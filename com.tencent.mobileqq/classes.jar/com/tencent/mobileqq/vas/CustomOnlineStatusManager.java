package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.vas.config.business.qvip.CustomOnlineStatusConfig;
import com.tencent.pb.onlinestatus.CustomOnlineStatusPb.CustomOnlineStatusMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class CustomOnlineStatusManager
{
  HashMap<String, Long> a = new HashMap();
  private final ArrayList<WeakReference<Runnable>> b = new ArrayList();
  private String c = "";
  private int d = 0;
  private int e = 30000;
  private int f = -1;
  private long g = 0L;
  
  public static CustomOnlineStatusManager a()
  {
    return CustomOnlineStatusManager.SingletonInstance.a();
  }
  
  private final void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("CustomOnlineStatusManager", 4, "resetOnEnableToggle");
    }
    this.c = "";
    this.d = 0;
    this.g = 0L;
  }
  
  private CustomOnlineStatusConfig e()
  {
    return (CustomOnlineStatusConfig)QConfigManager.b().b(479);
  }
  
  private void f()
  {
    ThreadManager.getUIHandler().post(new CustomOnlineStatusManager.1(this));
  }
  
  public final void a(CustomOnlineStatusPb.CustomOnlineStatusMsg paramCustomOnlineStatusMsg)
  {
    this.d = CustomOnlineStatusManager.Utils.d(paramCustomOnlineStatusMsg);
    this.c = CustomOnlineStatusManager.Utils.a(paramCustomOnlineStatusMsg);
    this.e = CustomOnlineStatusManager.Utils.c(paramCustomOnlineStatusMsg);
    f();
  }
  
  public void a(Runnable paramRunnable)
  {
    this.b.add(new WeakReference(paramRunnable));
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      paramString = (Long)this.a.get(paramString);
      bool1 = bool2;
      if (paramString != null)
      {
        if (Math.abs(System.currentTimeMillis() - paramString.longValue()) > this.e) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public void b(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.a.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
  
  public final boolean b()
  {
    int j = this.f;
    Object localObject = e();
    boolean bool = false;
    int i;
    if ((localObject != null) && (!((CustomOnlineStatusConfig)localObject).a)) {
      i = 0;
    } else {
      i = 1;
    }
    this.f = i;
    if (j != this.f) {
      d();
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("featureEnable = ");
      ((StringBuilder)localObject).append(this.f);
      QLog.d("CustomOnlineStatusManager", 4, ((StringBuilder)localObject).toString());
    }
    if (this.f == 1) {
      bool = true;
    }
    return bool;
  }
  
  public final String c()
  {
    if (b())
    {
      long l = System.currentTimeMillis();
      if (Math.abs(this.g - l) > this.e)
      {
        this.g = l;
        if (QLog.isDevelopLevel()) {
          QLog.d("CustomOnlineStatusManager", 4, "sync owner status");
        }
        CustomOnlineStatusManager.Utils.a();
      }
      if (CustomOnlineStatusManager.Utils.a(this.d)) {
        return this.c;
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.CustomOnlineStatusManager
 * JD-Core Version:    0.7.0.1
 */