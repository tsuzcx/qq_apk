package com.tencent.mobileqq.simpleui;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.theme.ThemeSwitchCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;

public class SimpleUIHandler$SimpleUIThemeSwitchCallback
  extends ThemeSwitchCallback
{
  private boolean mHandled = false;
  
  public SimpleUIHandler$SimpleUIThemeSwitchCallback(SimpleUIHandler paramSimpleUIHandler) {}
  
  public boolean postSwitch(int paramInt)
  {
    boolean bool2 = false;
    QLog.i("SimpleUILog.SimpleUIHandler", 1, String.format("postSwitch %d", new Object[] { Integer.valueOf(paramInt) }));
    if (this.mHandled) {
      return true;
    }
    this.mHandled = true;
    switch (paramInt)
    {
    case 3: 
    default: 
      paramInt = 3;
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        if (!AppNetConnInfo.isNetSupport())
        {
          this.this$0.notifyUI(3, false, new Object[] { Boolean.valueOf(true), Boolean.valueOf(this.this$0.a), Integer.valueOf(6) });
          bool1 = this.this$0.a(false, "211", SimpleUIUtil.a(), true, SimpleUIUtil.a(SimpleUIUtil.f()));
          if (!bool1) {
            SimpleUIHandler.a(this.this$0, SimpleUIHandler.a(this.this$0), -2147483648, SimpleUIHandler.b(this.this$0), -2147483648, null, -2147483648);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("postSwitch net_err revert theme bStartSwtich=%b", new Object[] { Boolean.valueOf(bool1) }));
          return true;
          paramInt = 0;
          continue;
          paramInt = 3;
          continue;
          paramInt = 1;
          continue;
        }
        SimpleUIHandler localSimpleUIHandler = (SimpleUIHandler)SimpleUIHandler.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER);
        if (SimpleUIHandler.a(this.this$0, SimpleUIHandler.a(this.this$0)) == 1) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          paramInt = SimpleUIHandler.a(this.this$0, SimpleUIHandler.b(this.this$0));
          if (SimpleUIHandler.a(this.this$0, SimpleUIHandler.c(this.this$0)) == 1) {
            bool2 = true;
          }
          try
          {
            long l = localSimpleUIHandler.a(bool1, paramInt, this.this$0.a, bool2);
            SimpleUIHandler.a(this.this$0).set(l);
            return true;
          }
          catch (Exception localException)
          {
            return true;
          }
        }
      }
    }
    SimpleUIHandler.a(this.this$0, SimpleUIHandler.a(this.this$0), -2147483648, SimpleUIHandler.b(this.this$0), -2147483648, SimpleUIHandler.c(this.this$0), -2147483648);
    this.this$0.notifyUI(3, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(this.this$0.a), Integer.valueOf(paramInt) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.simpleui.SimpleUIHandler.SimpleUIThemeSwitchCallback
 * JD-Core Version:    0.7.0.1
 */