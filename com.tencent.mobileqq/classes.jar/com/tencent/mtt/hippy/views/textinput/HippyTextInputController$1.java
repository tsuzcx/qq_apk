package com.tencent.mtt.hippy.views.textinput;

import android.os.MessageQueue.IdleHandler;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.utils.LogUtils;

class HippyTextInputController$1
  implements MessageQueue.IdleHandler
{
  HippyTextInputController$1(HippyTextInputController paramHippyTextInputController, HippyTextInput paramHippyTextInput, HippyArray paramHippyArray) {}
  
  public boolean queueIdle()
  {
    boolean bool = this.val$view.requestFocusFromTouch();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" requestFocusFromTouch result:");
    localStringBuilder.append(bool);
    LogUtils.d("InputText", localStringBuilder.toString());
    if (!bool)
    {
      bool = this.val$view.requestFocus();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestFocus result:");
      localStringBuilder.append(bool);
      LogUtils.d("InputText", localStringBuilder.toString());
    }
    if ((this.val$var.getObject(0) == null) || (this.val$var.getBoolean(0) == true)) {
      this.val$view.showInputMethodManager();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.textinput.HippyTextInputController.1
 * JD-Core Version:    0.7.0.1
 */