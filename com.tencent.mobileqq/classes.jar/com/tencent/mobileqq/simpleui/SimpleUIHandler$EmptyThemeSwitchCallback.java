package com.tencent.mobileqq.simpleui;

import com.tencent.mobileqq.vas.theme.ThemeSwitchCallback;
import com.tencent.qphone.base.util.QLog;

public class SimpleUIHandler$EmptyThemeSwitchCallback
  extends ThemeSwitchCallback
{
  private boolean mHandled = false;
  
  public SimpleUIHandler$EmptyThemeSwitchCallback(SimpleUIHandler paramSimpleUIHandler) {}
  
  public boolean postSwitch(int paramInt)
  {
    QLog.i("SimpleUILog.SimpleUIHandler", 1, String.format("emptyCallback postSwitch %d", new Object[] { Integer.valueOf(paramInt) }));
    if (this.mHandled) {
      return true;
    }
    this.mHandled = true;
    SimpleUIHandler localSimpleUIHandler = this.this$0;
    SimpleUIHandler.a(localSimpleUIHandler, SimpleUIHandler.a(localSimpleUIHandler), -2147483648, SimpleUIHandler.b(this.this$0), -2147483648, null, -2147483648);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.simpleui.SimpleUIHandler.EmptyThemeSwitchCallback
 * JD-Core Version:    0.7.0.1
 */