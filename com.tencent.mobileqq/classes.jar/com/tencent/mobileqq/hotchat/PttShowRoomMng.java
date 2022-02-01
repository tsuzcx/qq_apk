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
  final LruCache<String, PttShowRoomMng.Guest> jdField_a_of_type_AndroidSupportV4UtilLruCache;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  final List<PttShowRoomMng.PendingCmd> jdField_a_of_type_JavaUtilList;
  final ConcurrentHashMap<String, PttShowRoomMng.CancelSeat[]> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public PttShowRoomMng(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(3);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new PttShowRoomMng.1(this, 20);
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
  
  private PttShowRoomMng.Guest a(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidSupportV4UtilLruCache != null)
      {
        paramString = (PttShowRoomMng.Guest)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void a(String paramString, PttShowRoomMng.Guest paramGuest)
  {
    try
    {
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, paramGuest);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
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
        if (this.jdField_a_of_type_AndroidSupportV4UtilLruCache == null) {
          return null;
        }
        localObject1 = a(paramString);
        int i;
        if (localObject1 == null)
        {
          if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
          {
            paramString = (String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "self_nick", "");
            i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramString, i, NetConnInfoCenter.getServerTime());
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
          i = ((PttShowRoomMng.Guest)localObject1).jdField_a_of_type_Int;
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
        if (this.jdField_a_of_type_AndroidSupportV4UtilLruCache == null) {
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
      localObject1 = a(paramMessageRecord.senderuin);
      if ((localObject1 == null) || (((PttShowRoomMng.Guest)localObject1).jdField_a_of_type_Long < paramMessageRecord.time))
      {
        try
        {
          str1 = paramMessageRecord.getExtInfoFromExtStr("hotchat_nick");
          i = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("hotchat_gender"));
          l = paramMessageRecord.time;
          if (!paramMessageRecord.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
            break label261;
          }
          str2 = (String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "self_nick", "");
          j = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      PttShowRoomMng.Guest localGuest = a(paramString1);
      if ((localGuest != null) && (localGuest.jdField_a_of_type_Long <= paramLong))
      {
        localGuest.jdField_a_of_type_Int = paramInt;
        if ((paramString2 != null) && (paramString2.length() > 0)) {
          localGuest.b = paramString2;
        }
        localGuest.jdField_a_of_type_Long = paramLong;
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("PttShow", "cacheGender_update", new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        }
      }
      else if (localGuest == null)
      {
        localGuest = new PttShowRoomMng.Guest();
        localGuest.jdField_a_of_type_JavaLangString = paramString1;
        localGuest.jdField_a_of_type_Int = paramInt;
        if ((paramString2 != null) && (paramString2.length() > 0)) {
          localGuest.b = paramString2;
        }
        localGuest.jdField_a_of_type_Long = paramLong;
        a(paramString1, localGuest);
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("PttShow", "cacheGender_add", new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.PttShowRoomMng
 * JD-Core Version:    0.7.0.1
 */