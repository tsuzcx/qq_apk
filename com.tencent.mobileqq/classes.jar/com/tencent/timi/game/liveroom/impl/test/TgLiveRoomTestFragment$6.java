package com.tencent.timi.game.liveroom.impl.test;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.api.IAnchorRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.CustomToastView;

class TgLiveRoomTestFragment$6
  implements View.OnClickListener
{
  TgLiveRoomTestFragment$6(TgLiveRoomTestFragment paramTgLiveRoomTestFragment) {}
  
  public void onClick(View paramView)
  {
    String str = TgLiveRoomTestFragment.a(this.a).getText().toString();
    long l;
    if (TextUtils.isEmpty(str)) {
      l = -1L;
    } else {
      l = Long.parseLong(str);
    }
    if (l <= 0L) {
      CustomToastView.a("roomId无效，请重新输入!");
    } else {
      ((IAnchorRoomService)ServiceCenter.a(IAnchorRoomService.class)).a(this.a.getContext(), l);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.test.TgLiveRoomTestFragment.6
 * JD-Core Version:    0.7.0.1
 */