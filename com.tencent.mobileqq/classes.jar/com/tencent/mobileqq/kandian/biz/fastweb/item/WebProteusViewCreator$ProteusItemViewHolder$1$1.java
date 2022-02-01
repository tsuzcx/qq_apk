package com.tencent.mobileqq.kandian.biz.fastweb.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class WebProteusViewCreator$ProteusItemViewHolder$1$1
  implements ViewBase.OnClickListener
{
  WebProteusViewCreator$ProteusItemViewHolder$1$1(WebProteusViewCreator.ProteusItemViewHolder.1 param1) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    int i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
    WebProteusViewCreator.ProteusItemViewHolder.a(this.a.c, i).a(paramViewBase, this.a.a, this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebProteusViewCreator.ProteusItemViewHolder.1.1
 * JD-Core Version:    0.7.0.1
 */