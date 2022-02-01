package com.tencent.mobileqq.litelivesdk.framework.businessmgr;

import android.text.TextUtils;
import com.tencent.ilive.EnterRoomConfig;
import com.tencent.ilive.audiencepages.room.pagelogic.AudienceMultiRoomActivityLogic;
import com.tencent.mobileqq.litelivesdk.api.IBusinessExpireObserver;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class BusinessManager
{
  public static BusinessManager a = new BusinessManager();
  private BusinessConfig b;
  private EnterRoomConfig c;
  private boolean d;
  private Map<String, IBusinessExpireObserver> e = new HashMap();
  private String f = "0";
  private long g = 0L;
  private boolean h = true;
  private boolean i;
  
  public void a(long paramLong)
  {
    if (paramLong <= 0L)
    {
      this.g = System.currentTimeMillis();
      return;
    }
    this.g = paramLong;
  }
  
  public void a(EnterRoomConfig paramEnterRoomConfig)
  {
    this.c = paramEnterRoomConfig;
    this.i = this.h;
    this.h = false;
  }
  
  public void a(BusinessConfig paramBusinessConfig)
  {
    if (paramBusinessConfig != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateActivieBizInfo appid ");
      localStringBuilder.append(paramBusinessConfig.a);
      QLog.e("LiveBusinessManager", 1, localStringBuilder.toString());
    }
    this.b = paramBusinessConfig;
  }
  
  public void a(String paramString)
  {
    if (this.b != null)
    {
      if (StringUtil.isEmpty(paramString)) {
        return;
      }
      this.b.i = paramString;
    }
  }
  
  public void a(String paramString, IBusinessExpireObserver paramIBusinessExpireObserver)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("registerBusinessExpireObserver appid = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" observer == null : ");
    boolean bool;
    if (paramIBusinessExpireObserver == null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append(" isContainKey = ");
    localStringBuilder.append(this.e.containsKey(paramString));
    QLog.e("LiveBusinessManager", 1, localStringBuilder.toString());
    if (this.e.containsKey(paramString)) {
      this.e.remove(paramString);
    }
    this.e.put(paramString, paramIBusinessExpireObserver);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public BusinessConfig b()
  {
    if (this.b != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getActiveBizConfig appid ");
      localStringBuilder.append(this.b.a);
      QLog.e("LiveBusinessManager", 1, localStringBuilder.toString());
    }
    return this.b;
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.f = paramString;
  }
  
  public EnterRoomConfig c()
  {
    return this.c;
  }
  
  public IBusinessExpireObserver c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getBusinessExpireObserver appid = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" isContainKey = ");
    localStringBuilder.append(this.e.containsKey(paramString));
    QLog.e("LiveBusinessManager", 1, localStringBuilder.toString());
    return (IBusinessExpireObserver)this.e.get(paramString);
  }
  
  public boolean d()
  {
    BusinessConfig localBusinessConfig = this.b;
    return (localBusinessConfig != null) && ("1014".equals(localBusinessConfig.a));
  }
  
  public boolean e()
  {
    BusinessConfig localBusinessConfig = this.b;
    return (localBusinessConfig != null) && ("1037".equals(localBusinessConfig.a));
  }
  
  public String f()
  {
    BusinessConfig localBusinessConfig = this.b;
    if ((localBusinessConfig != null) && (!StringUtil.isEmpty(localBusinessConfig.j))) {
      return this.b.j;
    }
    return "";
  }
  
  public String g()
  {
    BusinessConfig localBusinessConfig = this.b;
    if ((localBusinessConfig != null) && (!StringUtil.isEmpty(localBusinessConfig.i))) {
      return this.b.i;
    }
    return "";
  }
  
  public String h()
  {
    return this.f;
  }
  
  public long i()
  {
    long l2 = this.g;
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = System.currentTimeMillis();
    }
    return l1;
  }
  
  public boolean j()
  {
    return this.i;
  }
  
  public void k()
  {
    AudienceMultiRoomActivityLogic.a().e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager
 * JD-Core Version:    0.7.0.1
 */