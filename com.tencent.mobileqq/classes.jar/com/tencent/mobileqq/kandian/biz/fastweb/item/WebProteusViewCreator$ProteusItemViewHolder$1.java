package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;

class WebProteusViewCreator$ProteusItemViewHolder$1
  implements ViewFactory.FoundClickableViewListener
{
  WebProteusViewCreator$ProteusItemViewHolder$1(WebProteusViewCreator.ProteusItemViewHolder paramProteusItemViewHolder, Context paramContext, ProteusItemData paramProteusItemData) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    paramViewBase.setOnClickListener(new WebProteusViewCreator.ProteusItemViewHolder.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebProteusViewCreator.ProteusItemViewHolder.1
 * JD-Core Version:    0.7.0.1
 */