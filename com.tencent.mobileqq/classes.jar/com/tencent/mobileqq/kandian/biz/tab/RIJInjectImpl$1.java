package com.tencent.mobileqq.kandian.biz.tab;

import android.view.View;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameFragment.DragViewPunctureClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.xtab.api.impl.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.xtab.msgboard.RIJXTabMessageBoardRedUtil;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;

final class RIJInjectImpl$1
  extends FrameFragment.DragViewPunctureClickListener
{
  RIJInjectImpl$1(FrameFragment paramFrameFragment) {}
  
  public void onClick(View paramView)
  {
    Frame localFrame = this.a.v();
    RIJXTabFrameUtils.INSTANCE.onTabClickSelf(localFrame);
    ReadInJoyLogicEngine.a().I();
    RIJXTabMessageBoardRedUtil.a.c();
    RIJInjectImpl.a((QQAppInterface)this.a.A, this.a.G);
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.RIJInjectImpl.1
 * JD-Core Version:    0.7.0.1
 */