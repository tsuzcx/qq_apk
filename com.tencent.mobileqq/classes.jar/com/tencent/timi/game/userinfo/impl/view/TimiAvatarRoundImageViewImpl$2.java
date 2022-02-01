package com.tencent.timi.game.userinfo.impl.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TimiAvatarRoundImageViewImpl$2
  implements View.OnClickListener
{
  TimiAvatarRoundImageViewImpl$2(TimiAvatarRoundImageViewImpl paramTimiAvatarRoundImageViewImpl) {}
  
  public void onClick(View paramView)
  {
    if (TimiAvatarRoundImageViewImpl.a(this.a) != null) {
      TimiAvatarRoundImageViewImpl.a(this.a).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.view.TimiAvatarRoundImageViewImpl.2
 * JD-Core Version:    0.7.0.1
 */