package com.tencent.mobileqq.simpleui;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.vas.theme.ThemeSwitchCallback;
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
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          break label64;
        }
        if (paramInt == 3) {}
      }
      else
      {
        paramInt = 3;
        break label71;
      }
      return true;
      label64:
      paramInt = 1;
    }
    else
    {
      paramInt = 0;
    }
    label71:
    boolean bool1;
    if (paramInt == 0)
    {
      if (!AppNetConnInfo.isNetSupport())
      {
        this.this$0.notifyUI(3, false, new Object[] { Boolean.valueOf(true), Boolean.valueOf(this.this$0.a), Integer.valueOf(6) });
        bool1 = this.this$0.a(false, "211", SimpleUIUtil.a(), true, SimpleUIUtil.a(SimpleUIUtil.f()));
        if (!bool1)
        {
          localSimpleUIHandler1 = this.this$0;
          SimpleUIHandler.a(localSimpleUIHandler1, SimpleUIHandler.a(localSimpleUIHandler1), -2147483648, SimpleUIHandler.b(this.this$0), -2147483648, null, -2147483648);
        }
        if (QLog.isColorLevel()) {
          QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("postSwitch net_err revert theme bStartSwtich=%b", new Object[] { Boolean.valueOf(bool1) }));
        }
        return true;
      }
      localSimpleUIHandler1 = (SimpleUIHandler)SimpleUIHandler.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER);
      SimpleUIHandler localSimpleUIHandler2 = this.this$0;
      if (SimpleUIHandler.a(localSimpleUIHandler2, SimpleUIHandler.a(localSimpleUIHandler2)) == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localSimpleUIHandler2 = this.this$0;
      paramInt = SimpleUIHandler.a(localSimpleUIHandler2, SimpleUIHandler.b(localSimpleUIHandler2));
      localSimpleUIHandler2 = this.this$0;
      if (SimpleUIHandler.a(localSimpleUIHandler2, SimpleUIHandler.c(localSimpleUIHandler2)) == 1) {
        bool2 = true;
      }
    }
    try
    {
      long l = localSimpleUIHandler1.a(bool1, paramInt, this.this$0.a, bool2);
      SimpleUIHandler.a(this.this$0).set(l);
      return true;
    }
    catch (Exception localException) {}
    SimpleUIHandler localSimpleUIHandler1 = this.this$0;
    SimpleUIHandler.a(localSimpleUIHandler1, SimpleUIHandler.a(localSimpleUIHandler1), -2147483648, SimpleUIHandler.b(this.this$0), -2147483648, SimpleUIHandler.c(this.this$0), -2147483648);
    this.this$0.notifyUI(3, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(this.this$0.a), Integer.valueOf(paramInt) });
    return true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.simpleui.SimpleUIHandler.SimpleUIThemeSwitchCallback
 * JD-Core Version:    0.7.0.1
 */