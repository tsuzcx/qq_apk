package com.tencent.mobileqq.emosm.favroaming;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EmoAddedAuthCallback$2
  implements View.OnClickListener
{
  EmoAddedAuthCallback$2(EmoAddedAuthCallback paramEmoAddedAuthCallback, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    if ((!((Activity)this.b.b).isFinishing()) && (this.a.isShowing())) {
      this.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback.2
 * JD-Core Version:    0.7.0.1
 */