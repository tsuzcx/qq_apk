package com.tencent.mobileqq.kandian.biz.feeds.controller;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.ProteusRecycleView.OnStateChangeListener;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;

class SubscribedListHeaderController$1$1
  implements ProteusRecycleView.OnStateChangeListener
{
  SubscribedListHeaderController$1$1(SubscribedListHeaderController.1 param1, ViewBase paramViewBase) {}
  
  public void a()
  {
    String str = this.a.getEventAttachedData();
    ReadInJoyUtils.a(SubscribedListHeaderController.a(this.b.b).getContext(), str);
    ProteusSupportUtil.a(this.b.a, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.SubscribedListHeaderController.1.1
 * JD-Core Version:    0.7.0.1
 */