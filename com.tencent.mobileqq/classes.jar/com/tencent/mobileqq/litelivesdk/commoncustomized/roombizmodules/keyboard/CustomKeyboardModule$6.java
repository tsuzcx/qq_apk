package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.keyboard;

import android.util.Log;
import com.tencent.mobileqq.litelivesdk.utils.ui.ViewUtils.OnInputMethodChangeListener;

class CustomKeyboardModule$6
  implements ViewUtils.OnInputMethodChangeListener
{
  CustomKeyboardModule$6(CustomKeyboardModule paramCustomKeyboardModule) {}
  
  public void a(boolean paramBoolean)
  {
    Log.d(CustomKeyboardModule.a(), "onInputMethodChange  isShow = " + paramBoolean);
    if (paramBoolean) {
      return;
    }
    CustomKeyboardModule.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.keyboard.CustomKeyboardModule.6
 * JD-Core Version:    0.7.0.1
 */