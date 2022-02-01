package com.tencent.mtt.hippy.uimanager;

import android.os.MessageQueue.IdleHandler;
import android.view.View;
import com.tencent.mtt.hippy.utils.LogUtils;

class HippyViewController$1
  implements MessageQueue.IdleHandler
{
  HippyViewController$1(HippyViewController paramHippyViewController, View paramView) {}
  
  public boolean queueIdle()
  {
    HippyViewController.access$002(this.b, true);
    if (!this.a.requestFocusFromTouch())
    {
      boolean bool = this.a.requestFocus();
      LogUtils.d("requestFocus", "requestFocus result:" + bool);
    }
    HippyViewController.access$002(this.b, false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.HippyViewController.1
 * JD-Core Version:    0.7.0.1
 */