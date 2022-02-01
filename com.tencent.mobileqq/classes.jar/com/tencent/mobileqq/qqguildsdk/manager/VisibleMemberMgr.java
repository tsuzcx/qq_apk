package com.tencent.mobileqq.qqguildsdk.manager;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.callback.IGetInvisibleMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetVisibleMemberCountCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetVisibleMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine;
import com.tencent.mobileqq.qqguildsdk.privatechannel.InvisibleMemberListCall;
import com.tencent.mobileqq.qqguildsdk.privatechannel.VisibleMemberListCall;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VisibleMemberMgr
{
  private final GPSManagerEngine a;
  private final Map<String, Integer> b = new HashMap();
  private final Map<String, VisibleMemberMgr.GetVisibleMemberCountCall> c = new HashMap();
  private VisibleMemberListCall d;
  private InvisibleMemberListCall e;
  
  public VisibleMemberMgr(GPSManagerEngine paramGPSManagerEngine)
  {
    this.a = paramGPSManagerEngine;
  }
  
  public static String a(@NonNull String paramString1, @NonNull String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(":");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  @MainThread
  public void a(@NonNull String paramString1, @NonNull String paramString2, int paramInt)
  {
    paramString1 = a(paramString1, paramString2);
    this.b.put(paramString1, Integer.valueOf(paramInt));
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    a(paramString1, paramString2, paramInt2);
    paramString1 = a(paramString1, paramString2);
    paramString1 = (VisibleMemberMgr.GetVisibleMemberCountCall)this.c.remove(paramString1);
    if (paramString1 != null) {
      paramString1.onGetVisibleMemberCount(paramInt1, paramString3, paramInt2);
    }
  }
  
  @MainThread
  public void a(@NonNull String paramString1, @NonNull String paramString2, int paramInt, boolean paramBoolean, @NonNull IGetInvisibleMemberListCallback paramIGetInvisibleMemberListCallback)
  {
    String str = a(paramString1, paramString2);
    Object localObject = this.e;
    if (localObject == null)
    {
      this.e = new InvisibleMemberListCall(this.a, paramString1, paramString2);
    }
    else
    {
      localObject = a(((InvisibleMemberListCall)localObject).a, this.e.b);
      if ((paramBoolean) || (!str.equals(localObject)))
      {
        this.e.a();
        this.e = new InvisibleMemberListCall(this.a, paramString1, paramString2);
      }
    }
    this.e.a(paramInt, paramIGetInvisibleMemberListCallback);
  }
  
  @MainThread
  public void a(@NonNull String paramString1, @NonNull String paramString2, int paramInt, boolean paramBoolean, @NonNull IGetVisibleMemberListCallback paramIGetVisibleMemberListCallback)
  {
    String str = a(paramString1, paramString2);
    Object localObject = this.d;
    if (localObject == null)
    {
      this.d = new VisibleMemberListCall(this, this.a, paramString1, paramString2);
    }
    else
    {
      localObject = a(((VisibleMemberListCall)localObject).a, this.d.b);
      if ((paramBoolean) || (!str.equals(localObject)))
      {
        this.d.a();
        this.d = new VisibleMemberListCall(this, this.a, paramString1, paramString2);
      }
    }
    this.d.a(paramInt, paramIGetVisibleMemberListCallback);
  }
  
  @MainThread
  public void a(@NonNull String paramString1, @NonNull String paramString2, @NonNull IGetVisibleMemberCountCallback paramIGetVisibleMemberCountCallback)
  {
    if (this.a.h(paramString2).getVisibleType() == 0)
    {
      paramIGetVisibleMemberCountCallback.onGetVisibleMemberCount(-90, "该子频道对全部成员可见", 0);
      return;
    }
    Object localObject = a(paramString1, paramString2);
    Integer localInteger = (Integer)this.b.get(localObject);
    if (localInteger != null)
    {
      paramIGetVisibleMemberCountCallback.onGetVisibleMemberCount(0, "from cache", localInteger.intValue());
      return;
    }
    localObject = (VisibleMemberMgr.GetVisibleMemberCountCall)this.c.get(localObject);
    if (localObject != null)
    {
      ((VisibleMemberMgr.GetVisibleMemberCountCall)localObject).a(paramIGetVisibleMemberCountCallback);
      return;
    }
    c(paramString1, paramString2).a(paramIGetVisibleMemberCountCallback);
    this.a.a(paramString1, paramString2, 0L, 0, new VisibleMemberMgr.1(this, paramString1, paramString2));
  }
  
  public void a(String paramString1, String paramString2, @NonNull List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onJoinChannel guildId=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" channelId=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" members.size=");
    localStringBuilder.append(paramList.size());
    GProLog.a("VisibleMemberMgr", false, "cache", localStringBuilder.toString());
    d(paramString1, paramString2);
  }
  
  @MainThread
  public int b(@NonNull String paramString1, @NonNull String paramString2)
  {
    paramString1 = a(paramString1, paramString2);
    paramString1 = (Integer)this.b.get(paramString1);
    if (paramString1 == null) {
      return 0;
    }
    return paramString1.intValue();
  }
  
  public void b(String paramString1, String paramString2, @NonNull List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLeaveChannel guildId=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" channelId=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" members.size=");
    localStringBuilder.append(paramList.size());
    GProLog.a("VisibleMemberMgr", false, "cache", localStringBuilder.toString());
    d(paramString1, paramString2);
  }
  
  public VisibleMemberMgr.GetVisibleMemberCountCall c(String paramString1, String paramString2)
  {
    String str = a(paramString1, paramString2);
    paramString2 = (VisibleMemberMgr.GetVisibleMemberCountCall)this.c.get(str);
    paramString1 = paramString2;
    if (paramString2 == null)
    {
      paramString1 = new VisibleMemberMgr.GetVisibleMemberCountCall();
      this.c.put(str, paramString1);
    }
    return paramString1;
  }
  
  @MainThread
  public void d(@NonNull String paramString1, @NonNull String paramString2)
  {
    paramString1 = a(paramString1, paramString2);
    this.b.remove(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.manager.VisibleMemberMgr
 * JD-Core Version:    0.7.0.1
 */