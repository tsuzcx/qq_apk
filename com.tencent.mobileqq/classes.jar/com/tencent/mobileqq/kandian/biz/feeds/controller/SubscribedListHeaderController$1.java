package com.tencent.mobileqq.kandian.biz.feeds.controller;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.RvPolymericContainer;

class SubscribedListHeaderController$1
  implements ViewFactory.FoundClickableViewListener
{
  SubscribedListHeaderController$1(SubscribedListHeaderController paramSubscribedListHeaderController, TemplateBean paramTemplateBean) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    if (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()) != 1128) {
      return;
    }
    if ((paramViewBase instanceof RvPolymericContainer)) {
      ((RvPolymericContainer)paramViewBase).a(new SubscribedListHeaderController.1.1(this, paramViewBase));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.SubscribedListHeaderController.1
 * JD-Core Version:    0.7.0.1
 */