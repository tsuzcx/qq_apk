package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.keyboard;

import android.util.Log;
import com.tencent.mobileqq.litelivesdk.utils.ui.ViewUtils.OnInputMethodChangeListener;

class CustomKeyboardModule$6
  implements ViewUtils.OnInputMethodChangeListener
{
  CustomKeyboardModule$6(CustomKeyboardModule paramCustomKeyboardModule) {}
  
  public void a(boolean paramBoolean)
  {
    String str = CustomKeyboardModule.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInputMethodChange  isShow = ");
    localStringBuilder.append(paramBoolean);
    Log.d(str, localStringBuilder.toString());
    if (paramBoolean) {
      return;
    }
    CustomKeyboardModule.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.keyboard.CustomKeyboardModule.6
 * JD-Core Version:    0.7.0.1
 */