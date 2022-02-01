package com.tencent.mobileqq.kandian.biz.comment.guide;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;

class GuidePopuppWindow$2
  implements ViewFactory.FoundClickableViewListener
{
  GuidePopuppWindow$2(GuidePopuppWindow paramGuidePopuppWindow) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    if (paramViewBase.getNativeView() != null)
    {
      if (paramViewBase.getClickEvnet() == null) {
        return;
      }
      paramViewBase.setOnClickListener(new GuidePopuppWindow.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.guide.GuidePopuppWindow.2
 * JD-Core Version:    0.7.0.1
 */