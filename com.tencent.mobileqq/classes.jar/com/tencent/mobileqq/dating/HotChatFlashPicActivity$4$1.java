package com.tencent.mobileqq.dating;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class HotChatFlashPicActivity$4$1
  implements View.OnClickListener
{
  HotChatFlashPicActivity$4$1(HotChatFlashPicActivity.4 param4) {}
  
  public void onClick(View paramView)
  {
    if ((HotChatFlashPicActivity.a(this.a.a) != null) && (!this.a.a.isFinishing()))
    {
      HotChatFlashPicActivity.a(this.a.a).dismiss();
      HotChatFlashPicActivity.a(this.a.a, null);
      this.a.a.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.HotChatFlashPicActivity.4.1
 * JD-Core Version:    0.7.0.1
 */