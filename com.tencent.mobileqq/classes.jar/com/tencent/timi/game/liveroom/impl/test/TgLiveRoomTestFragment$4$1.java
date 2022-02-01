package com.tencent.timi.game.liveroom.impl.test;

import android.view.View;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataBase;
import com.tencent.timi.game.component.qqlive.api.SimpleTgLiveAnchorStartListener;
import com.tencent.timi.game.liveroom.api.IAnchorRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.CustomToastView;

class TgLiveRoomTestFragment$4$1
  extends SimpleTgLiveAnchorStartListener
{
  TgLiveRoomTestFragment$4$1(TgLiveRoomTestFragment.4 param4) {}
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    CustomToastView.a(paramString);
  }
  
  public void a(boolean paramBoolean, QQLiveAnchorDataBase paramQQLiveAnchorDataBase, View paramView)
  {
    if (paramBoolean) {
      ((IAnchorRoomService)ServiceCenter.a(IAnchorRoomService.class)).a(this.a.a.getActivity(), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.test.TgLiveRoomTestFragment.4.1
 * JD-Core Version:    0.7.0.1
 */