package com.tencent.mobileqq.forward;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class ForwardD55Manager
{
  private WeakReference<ForwardD55Manager.D55ResultListener> a;
  private Map<Long, AppInfo> b = new ConcurrentHashMap();
  private int c;
  private AppInfo d;
  
  public AppInfo a(long paramLong)
  {
    try
    {
      AppInfo localAppInfo = (AppInfo)this.b.get(Long.valueOf(paramLong));
      return localAppInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(long paramLong, AppInfo paramAppInfo)
  {
    try
    {
      QLog.d("ForwardD55Manager", 1, new Object[] { "--> onResult appId=", Long.valueOf(paramLong), ", appInfo=", paramAppInfo.toString() });
      this.b.put(Long.valueOf(paramLong), paramAppInfo);
      if (this.a != null)
      {
        QLog.d("ForwardD55Manager", 1, "--> onResult null != mListener");
        if (this.a.get() != null)
        {
          QLog.d("ForwardD55Manager", 1, "--> onResult null != mListener.get()");
          ((ForwardD55Manager.D55ResultListener)this.a.get()).a();
        }
        else
        {
          QLog.d("ForwardD55Manager", 1, "--> onResult null == mListener.get()");
        }
      }
      else
      {
        QLog.d("ForwardD55Manager", 1, "--> onResult null == mListener");
      }
      return;
    }
    finally {}
  }
  
  public void a(ForwardD55Manager.D55ResultListener paramD55ResultListener)
  {
    try
    {
      QLog.d("ForwardD55Manager", 1, new Object[] { "--> setD55Listener=", paramD55ResultListener });
      if (paramD55ResultListener == null) {
        paramD55ResultListener = null;
      } else {
        paramD55ResultListener = new WeakReference(paramD55ResultListener);
      }
      this.a = paramD55ResultListener;
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, long paramLong, String paramString2)
  {
    this.c = 0;
    this.d = null;
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    QLog.d("ForwardD55Manager", 1, new Object[] { "fetchAppInfoByD55 openId=", paramString1, ", appId=", Long.valueOf(paramLong), ", pkgName=", paramString2 });
    ForwardStatisticsReporter.a("KEY_STAGE_1_D55");
    localObject = ((QQAppInterface)localObject).getMsgHandler();
    if (paramString1 == null) {
      paramString1 = "";
    }
    ((MessageHandler)localObject).a(false, paramString1, false, 0L, paramLong, 1, 2, paramString2, true, ForwardShareByServerHelper.d(), new ForwardD55Manager.1(this, paramString2, paramLong));
  }
  
  public boolean a()
  {
    try
    {
      if (this.d != null)
      {
        int i = this.c;
        if (i == 0)
        {
          bool = true;
          break label25;
        }
      }
      boolean bool = false;
      label25:
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean b()
  {
    try
    {
      if (this.d != null)
      {
        int i = this.c;
        if (i > 0)
        {
          bool = true;
          break label25;
        }
      }
      boolean bool = false;
      label25:
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean c()
  {
    try
    {
      if (this.d != null)
      {
        int i = this.c;
        if (i <= -1)
        {
          bool = true;
          break label26;
        }
      }
      boolean bool = false;
      label26:
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String d()
  {
    try
    {
      String str;
      if (this.d != null) {
        str = this.d.h();
      } else {
        str = "";
      }
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public AppInfo e()
  {
    try
    {
      AppInfo localAppInfo = this.d;
      return localAppInfo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void f()
  {
    try
    {
      this.b.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardD55Manager
 * JD-Core Version:    0.7.0.1
 */