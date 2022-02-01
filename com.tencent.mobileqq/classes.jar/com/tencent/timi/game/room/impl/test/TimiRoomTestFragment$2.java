package com.tencent.timi.game.room.impl.test;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.CustomToastView;

class TimiRoomTestFragment$2
  implements View.OnClickListener
{
  TimiRoomTestFragment$2(TimiRoomTestFragment paramTimiRoomTestFragment, EditText paramEditText) {}
  
  public void onClick(View paramView)
  {
    String str = this.a.getText().toString();
    long l;
    if (TextUtils.isEmpty(str)) {
      l = -1L;
    } else {
      l = Long.parseLong(str);
    }
    if (l <= 0L) {
      CustomToastView.a("roomId无效，请重新输入！");
    } else {
      ((IRoomService)ServiceCenter.a(IRoomService.class)).a(true, this.b.getActivity(), l, 1, 1, 1, 0, 0, null, ((IRoomService)ServiceCenter.a(IRoomService.class)).b(1), null, 0L, new TimiRoomTestFragment.2.1(this));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.test.TimiRoomTestFragment.2
 * JD-Core Version:    0.7.0.1
 */