package com.tencent.mobileqq.kandian.biz.fastweb.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil;

class WebFastProteusViewCreator$TextViewHolder$1$1
  implements ViewBase.OnClickListener
{
  WebFastProteusViewCreator$TextViewHolder$1$1(WebFastProteusViewCreator.TextViewHolder.1 param1) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    WebFastProteusViewCreator.a(true);
    ReportUtil.a(this.a.a.a, "0X800974B");
    ReadInJoyUtils.a(WebFastProteusViewCreator.TextViewHolder.a(this.a.a).getContext(), paramViewBase.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebFastProteusViewCreator.TextViewHolder.1.1
 * JD-Core Version:    0.7.0.1
 */