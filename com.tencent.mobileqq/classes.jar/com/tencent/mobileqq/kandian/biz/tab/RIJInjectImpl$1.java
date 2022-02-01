package com.tencent.mobileqq.kandian.biz.tab;

import android.view.View;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameFragment.DragViewPunctureClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IRIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngineFactory;
import com.tencent.mobileqq.qroute.QRoute;

final class RIJInjectImpl$1
  extends FrameFragment.DragViewPunctureClickListener
{
  RIJInjectImpl$1(FrameFragment paramFrameFragment) {}
  
  public void onClick(View paramView)
  {
    Frame localFrame = this.a.a();
    ((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).onTabClickSelf(localFrame);
    ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().l();
    RIJInjectImpl.a((QQAppInterface)this.a.jdField_a_of_type_MqqAppAppRuntime, this.a.jdField_a_of_type_JavaUtilHashMap);
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.RIJInjectImpl.1
 * JD-Core Version:    0.7.0.1
 */