package com.tencent.timi.game.team.impl.floating;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import trpc.yes.common.CommonOuterClass.QQUserId;

class FloatingTestFragment$1
  implements View.OnClickListener
{
  FloatingTestFragment$1(FloatingTestFragment paramFloatingTestFragment) {}
  
  public void onClick(View paramView)
  {
    CommonOuterClass.QQUserId localQQUserId = new CommonOuterClass.QQUserId();
    localQQUserId.uid.set(281321194L);
    localQQUserId.user_from.set(1);
    FloatingTestFragment.a(this.a).a(localQQUserId);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.floating.FloatingTestFragment.1
 * JD-Core Version:    0.7.0.1
 */