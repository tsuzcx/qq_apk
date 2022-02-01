package com.tencent.timi.game.liveroom.impl.test;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.ClipboardUtil;

class TgLiveRoomTestFragment$8
  implements View.OnClickListener
{
  TgLiveRoomTestFragment$8(TgLiveRoomTestFragment paramTgLiveRoomTestFragment) {}
  
  public void onClick(View paramView)
  {
    if (TgLiveRoomTestFragment.c(this.a).getText() != null)
    {
      String str = TgLiveRoomTestFragment.c(this.a).getText().toString();
      ClipboardUtil.a(Env.a(), str);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("已拷贝至剪贴板\n\n");
      localStringBuilder.append(str);
      CustomToastView.a(localStringBuilder.toString());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.test.TgLiveRoomTestFragment.8
 * JD-Core Version:    0.7.0.1
 */