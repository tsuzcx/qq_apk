package com.tencent.timi.game.userinfo.impl.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.utils.NoDoubleClickUtils;

class TimiAvatarRoundImageViewImpl$1
  implements View.OnClickListener
{
  TimiAvatarRoundImageViewImpl$1(TimiAvatarRoundImageViewImpl paramTimiAvatarRoundImageViewImpl) {}
  
  public void onClick(View paramView)
  {
    if ((!NoDoubleClickUtils.a("jumpPersonalPage")) && (this.a.b != null)) {
      this.a.b.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.view.TimiAvatarRoundImageViewImpl.1
 * JD-Core Version:    0.7.0.1
 */