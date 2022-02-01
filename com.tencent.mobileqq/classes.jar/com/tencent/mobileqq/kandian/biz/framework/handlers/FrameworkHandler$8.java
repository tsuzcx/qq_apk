package com.tencent.mobileqq.kandian.biz.framework.handlers;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class FrameworkHandler$8
  implements View.OnKeyListener
{
  FrameworkHandler$8(FrameworkHandler paramFrameworkHandler) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && ((paramInt == 25) || (paramInt == 24)))
    {
      paramView = new Intent();
      paramView.setAction("com.tencent.mobileqq.kandian.biz.gifvideo.VideoMaskController.ACTION_DOWN_AUDIO_BUTTON");
      if (this.a.i() != null) {
        this.a.i().sendBroadcast(paramView);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.FrameworkHandler.8
 * JD-Core Version:    0.7.0.1
 */