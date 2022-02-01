package com.tencent.mobileqq.webview.swift;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper.IdleTask;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

class WebViewKernel$3
  extends SwiftBrowserIdleTaskHelper.IdleTask
{
  WebViewKernel$3(WebViewKernel paramWebViewKernel, int paramInt)
  {
    super(paramInt);
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("WebViewKernel", 2, "TASK_ID_BROWSER_ACTIVITY_RUN_ONCE.");
    }
    long l;
    if (Build.VERSION.SDK_INT < 19) {
      l = System.currentTimeMillis();
    }
    for (;;)
    {
      boolean bool;
      try
      {
        Object localObject1 = Class.forName("android.webkit.WebViewCore");
        Object localObject2 = ((Class)localObject1).getDeclaredField("sWebCoreHandler");
        ((Field)localObject2).setAccessible(true);
        localObject1 = (Handler)((Field)localObject2).get(localObject1);
        if (localObject1 != null)
        {
          localObject1 = ((Handler)localObject1).getLooper();
          if (localObject1 != null)
          {
            localObject1 = ((Looper)localObject1).getThread().getState();
            localObject2 = Thread.State.WAITING;
            if (localObject1 == localObject2)
            {
              bool = true;
              continue;
            }
          }
        }
        bool = false;
        if (!bool) {
          break label278;
        }
        i = 0;
        try
        {
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "webcore_wait", 0, 1, i, "", "", "", "");
        }
        catch (ClassCastException localClassCastException1) {}catch (IllegalAccessException localIllegalAccessException1) {}catch (NoSuchFieldException localNoSuchFieldException1) {}catch (ClassNotFoundException localClassNotFoundException1) {}
        localClassNotFoundException2.printStackTrace();
      }
      catch (ClassCastException localClassCastException2)
      {
        bool = false;
        localClassCastException2.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException2)
      {
        bool = false;
        localIllegalAccessException2.printStackTrace();
      }
      catch (NoSuchFieldException localNoSuchFieldException2)
      {
        bool = false;
        localNoSuchFieldException2.printStackTrace();
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        bool = false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("check if WebViewCordThread is waiting: ");
        localStringBuilder.append(bool);
        localStringBuilder.append(", cost: ");
        localStringBuilder.append(System.currentTimeMillis() - l);
        QLog.d("WebViewKernel", 2, localStringBuilder.toString());
      }
      return 1;
      label278:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewKernel.3
 * JD-Core Version:    0.7.0.1
 */