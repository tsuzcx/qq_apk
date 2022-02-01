package com.tencent.mobileqq.mini.appbrand;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

public class AppBrandRuntime$KeyboardObserver
  implements Observer
{
  public AppBrandRuntime$KeyboardObserver(AppBrandRuntime paramAppBrandRuntime) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    try
    {
      if ((paramObject instanceof String))
      {
        if ("hideKeyboard".equals((String)paramObject)) {
          QLog.d("AppBrandRuntime", 2, "KeyboardObserver hideKeyboard");
        }
        for (;;)
        {
          if (AppBrandRuntime.access$500(this.this$0)) {
            ThreadManager.getUIHandler().postDelayed(new AppBrandRuntime.KeyboardObserver.1(this), 50L);
          }
          AppBrandRuntime.access$502(this.this$0, false);
          return;
          if ("hideInput".equals((String)paramObject)) {
            QLog.d("AppBrandRuntime", 2, "KeyboardObserver hideInput");
          }
        }
      }
      if (!(paramObject instanceof Integer)) {
        return;
      }
    }
    catch (Exception paramObservable)
    {
      QLog.e("AppBrandRuntime", 2, "KeyboardObserver error, ", paramObservable);
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new AppBrandRuntime.KeyboardObserver.2(this, paramObject), 50L);
    AppBrandRuntime.access$502(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.KeyboardObserver
 * JD-Core Version:    0.7.0.1
 */