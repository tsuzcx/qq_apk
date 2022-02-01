package com.tencent.timi.game.userinfo.impl.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TimiAvatarRoundImageViewImpl$4
  implements View.OnClickListener
{
  TimiAvatarRoundImageViewImpl$4(TimiAvatarRoundImageViewImpl paramTimiAvatarRoundImageViewImpl, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (TimiAvatarRoundImageViewImpl.a(this.b) != null) {
      TimiAvatarRoundImageViewImpl.a(this.b).a();
    }
    if (this.a) {
      TimiAvatarRoundImageViewImpl.b(this.b).onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.view.TimiAvatarRoundImageViewImpl.4
 * JD-Core Version:    0.7.0.1
 */