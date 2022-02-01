package com.tencent.mobileqq.hotchat;

import android.support.v4.util.LruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class PttShowRoomMng
{
  QQAppInterface a;
  final LruCache<String, PttShowRoomMng.Guest> b;
  final ConcurrentHashMap<String, PttShowRoomMng.CancelSeat[]> c;
  final List<PttShowRoomMng.PendingCmd> d;
  
  public PttShowRoomMng(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.c = new ConcurrentHashMap(3);
    this.d = new ArrayList();
    this.b = new PttShowRoomMng.1(this, 20);
  }
  
  public static final int a(QQAppInterface paramQQAppInterface)
  {
    int i = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(paramQQAppInterface.getAccount(), "self_gender", Integer.valueOf(0))).intValue();
    if (i == 2) {
      return 1;
    }
    if (i == 1) {
      return 0;
    }
    return 2;
  }
  
  private void a(String paramString, PttShowRoomMng.Guest paramGuest)
  {
    try
    {
      this.b.put(paramString, paramGuest);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private PttShowRoomMng.Guest b(String paramString)
  {
    try
    {
      if (this.b != null)
      {
        paramString = (PttShowRoomMng.Guest)this.b.get(paramString);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public Object a(String paramString, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (paramString.length() != 0)
      {
        if (this.b == null) {
          return null;
        }
        localObject1 = b(paramString);
        int i;
        if (localObject1 == null)
        {
          if (paramString.equals(this.a.getCurrentAccountUin()))
          {
            paramString = (String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.a.getAccount(), "self_nick", "");
            i = a(this.a);
            a(this.a.getAccount(), paramString, i, NetConnInfoCenter.getServerTime());
          }
          else
          {
            if (QLog.isDevelopLevel()) {
              NearbyUtils.a("PttShow", "getGender no cache", new Object[] { paramString });
            }
            paramString = null;
            i = 2;
          }
        }
        else
        {
          i = ((PttShowRoomMng.Guest)localObject1).c;
          paramString = ((PttShowRoomMng.Guest)localObject1).b;
        }
        if (paramInt != 1)
        {
          if (paramInt != 2) {
            return null;
          }
          return paramString;
        }
        localObject1 = Integer.valueOf(i);
      }
    }
    return localObject1;
  }
  
  public String a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (paramString.length() != 0)
      {
        if (this.b == null) {
          return null;
        }
        paramString = a(paramString, 2);
        localObject1 = localObject2;
        if ((paramString instanceof String)) {
          localObject1 = (String)paramString;
        }
      }
    }
    return localObject1;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    Object localObject1;
    String str1;
    int i;
    int j;
    if ((paramMessageRecord != null) && ((paramMessageRecord.extLong & 0x1) != 0))
    {
      if (paramMessageRecord.senderuin == null) {
        return;
      }
      localObject1 = b(paramMessageRecord.senderuin);
      if ((localObject1 == null) || (((PttShowRoomMng.Guest)localObject1).d < paramMessageRecord.time))
      {
        try
        {
          str1 = paramMessageRecord.getExtInfoFromExtStr("hotchat_nick");
          i = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("hotchat_gender"));
          l = paramMessageRecord.time;
          if (!paramMessageRecord.senderuin.equals(this.a.getCurrentAccountUin())) {
            break label261;
          }
          str2 = (String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.a.getAccount(), "self_nick", "");
          j = a(this.a);
          localObject1 = str1;
          if (str2 == null) {
            break label248;
          }
          localObject1 = str1;
          if (str2.length() <= 0) {
            break label248;
          }
          localObject1 = str2;
        }
        catch (Exception localException)
        {
          long l;
          String str2;
          localException.printStackTrace();
        }
        l = NetConnInfoCenter.getServerTime();
        if (!QLog.isDevelopLevel()) {
          break label258;
        }
        NearbyUtils.a("PttShow", "cacheSelfGender", new Object[] { str2, Integer.valueOf(j), Long.valueOf(l) });
        break label258;
      }
    }
    for (;;)
    {
      a(paramMessageRecord.senderuin, (String)localObject1, i, l);
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("PttShow", "cacheGender", new Object[] { paramMessageRecord.extStr });
      }
      return;
      label248:
      if (j == 2) {
        break;
      }
      i = j;
      break;
      label258:
      continue;
      label261:
      Object localObject2 = str1;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    if (paramString1 != null)
    {
      if (paramString1.length() == 0) {
        return;
      }
      PttShowRoomMng.Guest localGuest = b(paramString1);
      if ((localGuest != null) && (localGuest.d <= paramLong))
      {
        localGuest.c = paramInt;
        if ((paramString2 != null) && (paramString2.length() > 0)) {
          localGuest.b = paramString2;
        }
        localGuest.d = paramLong;
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("PttShow", "cacheGender_update", new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        }
      }
      else if (localGuest == null)
      {
        localGuest = new PttShowRoomMng.Guest();
        localGuest.a = paramString1;
        localGuest.c = paramInt;
        if ((paramString2 != null) && (paramString2.length() > 0)) {
          localGuest.b = paramString2;
        }
        localGuest.d = paramLong;
        a(paramString1, localGuest);
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("PttShow", "cacheGender_add", new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.PttShowRoomMng
 * JD-Core Version:    0.7.0.1
 */