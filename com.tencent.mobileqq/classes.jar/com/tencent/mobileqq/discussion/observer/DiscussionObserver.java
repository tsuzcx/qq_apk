package com.tencent.mobileqq.discussion.observer;

import QQService.RespAddDiscussMember;
import QQService.RespGetDiscussInfo;
import android.util.Pair;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.discussion.IDiscussionObserver;
import com.tencent.protofile.discuss.FlyTicket.DiscussGetUrlResponse;
import com.tencent.protofile.discuss.FlyTicket.DiscussSigDecodeResponse;
import com.tencent.protofile.discuss.FlyTicket.RetInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DiscussionObserver
  implements IDiscussionObserver
{
  private void a(boolean paramBoolean, FlyTicket.DiscussSigDecodeResponse paramDiscussSigDecodeResponse)
  {
    if ((paramDiscussSigDecodeResponse != null) && (((FlyTicket.RetInfo)paramDiscussSigDecodeResponse.ret_info.get()).ret_code.get() == 0))
    {
      c(paramBoolean, paramDiscussSigDecodeResponse.sig.get());
      return;
    }
    c(false, null);
  }
  
  private void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    int i = Integer.parseInt((String)paramArrayOfObject[0]);
    FlyTicket.DiscussGetUrlResponse localDiscussGetUrlResponse = (FlyTicket.DiscussGetUrlResponse)paramArrayOfObject[1];
    long l = ((Long)paramArrayOfObject[2]).longValue();
    if ((localDiscussGetUrlResponse != null) && (i == 0))
    {
      String str = localDiscussGetUrlResponse.url.get();
      paramArrayOfObject = str;
      if (!localDiscussGetUrlResponse.url.get().endsWith("#flyticket"))
      {
        paramArrayOfObject = str;
        if (!str.endsWith(localDiscussGetUrlResponse.sig.get()))
        {
          paramArrayOfObject = new StringBuilder();
          paramArrayOfObject.append(str);
          paramArrayOfObject.append(localDiscussGetUrlResponse.sig.get());
          paramArrayOfObject = paramArrayOfObject.toString();
        }
      }
      if (localDiscussGetUrlResponse.short_url.get() != null) {
        str = localDiscussGetUrlResponse.short_url.get();
      } else {
        str = "";
      }
      a(paramBoolean, i, localDiscussGetUrlResponse.v_time.get(), paramArrayOfObject, str, l);
      return;
    }
    a(false, i, 0L, null, "", l);
  }
  
  private void b(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      String str = (String)paramObject[0];
      boolean bool2 = ((Boolean)paramObject[1]).booleanValue();
      int i = ((Integer)paramObject[2]).intValue();
      int j = ((Integer)paramObject[3]).intValue();
      boolean bool1;
      if (paramObject.length >= 5) {
        bool1 = ((Boolean)paramObject[4]).booleanValue();
      } else {
        bool1 = false;
      }
      a(paramBoolean, str, bool2, i, j, bool1);
    }
  }
  
  private void b(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 3))
    {
      int i = ((Integer)paramArrayOfObject[2]).intValue();
      long l;
      if (paramArrayOfObject[0] == null) {
        l = 0L;
      } else {
        l = ((Long)paramArrayOfObject[0]).longValue();
      }
      a(paramBoolean, i, l, (String)paramArrayOfObject[1]);
    }
  }
  
  private void c(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (!(paramArrayOfObject[1] instanceof Integer)) {
      return;
    }
    int i = ((Integer)paramArrayOfObject[1]).intValue();
    if (paramBoolean)
    {
      paramArrayOfObject = (RespAddDiscussMember)paramArrayOfObject[2];
      Map localMap = paramArrayOfObject.AddResult;
      Object localObject = localMap.keySet();
      ArrayList localArrayList = new ArrayList();
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject).next();
        if (((Integer)localMap.get(localLong)).intValue() == 0) {
          localArrayList.add(String.valueOf(localLong));
        }
      }
      a(true, i, paramArrayOfObject.DiscussUin, localArrayList);
      return;
    }
    a(false, i, Long.valueOf((String)paramArrayOfObject[0]).longValue(), null);
  }
  
  protected void a() {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong1, String paramString1, String paramString2, long paramLong2) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList) {}
  
  protected void a(boolean paramBoolean, int paramInt, RespGetDiscussInfo paramRespGetDiscussInfo) {}
  
  protected void a(boolean paramBoolean, long paramLong) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt) {}
  
  protected void a(boolean paramBoolean, Long paramLong) {}
  
  protected void a(boolean paramBoolean, Long paramLong1, Long paramLong2) {}
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString) {}
  
  protected void a(Object[] paramArrayOfObject) {}
  
  protected void b() {}
  
  protected void b(boolean paramBoolean, Long paramLong) {}
  
  protected void b(boolean paramBoolean, String paramString) {}
  
  protected void c(boolean paramBoolean, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Discussion DiscussObserver onUpdate type");
      localStringBuilder.append(paramInt);
      QLog.d("Discussion", 2, localStringBuilder.toString());
    }
    if (paramInt != 2000)
    {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          return;
        case 1018: 
          b(paramBoolean, paramObject);
          return;
        case 1017: 
          b(paramBoolean, (Long)paramObject);
          return;
        case 1016: 
          a(paramBoolean, (Long)paramObject);
          return;
        case 1015: 
          paramObject = (long[])paramObject;
          a(paramBoolean, Long.valueOf(paramObject[0]), Long.valueOf(paramObject[1]));
          return;
        case 1014: 
          paramObject = (Long[])paramObject;
          a(paramBoolean, paramObject[1].longValue(), paramObject[0].intValue());
          return;
        case 1013: 
          paramObject = (Object[])paramObject;
          a(paramBoolean, Integer.parseInt((String)paramObject[0]), (RespGetDiscussInfo)paramObject[1]);
          return;
        case 1012: 
          a(paramBoolean, (FlyTicket.DiscussSigDecodeResponse)paramObject);
          return;
        case 1011: 
          a(paramBoolean, (Object[])paramObject);
          return;
        case 1010: 
          a(paramBoolean, ((Long)paramObject).longValue());
          return;
        case 1009: 
          b();
          return;
        case 1008: 
          a();
          return;
        }
        paramObject = (Pair)paramObject;
        a(paramBoolean, ((Boolean)paramObject.first).booleanValue(), (String)paramObject.second);
        return;
      case 1005: 
        a(paramBoolean, (String)paramObject);
        return;
      case 1004: 
        ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).smallScreenUtils_getTrace("deleteDiscuss_onQuitDiscussion");
        b(paramBoolean, (String)paramObject);
        return;
      case 1003: 
        c(paramBoolean, (Object[])paramObject);
        return;
      case 1002: 
        b(paramBoolean, (Object[])paramObject);
        return;
      case 1001: 
        a(paramBoolean, paramObject);
        return;
      }
      a(paramBoolean);
      return;
    }
    a((Object[])paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.discussion.observer.DiscussionObserver
 * JD-Core Version:    0.7.0.1
 */