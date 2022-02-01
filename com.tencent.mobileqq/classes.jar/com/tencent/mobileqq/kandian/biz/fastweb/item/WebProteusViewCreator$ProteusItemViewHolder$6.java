package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;

class WebProteusViewCreator$ProteusItemViewHolder$6
  implements WebProteusViewCreator.ProteusItemViewOnClickListener
{
  WebProteusViewCreator$ProteusItemViewHolder$6(WebProteusViewCreator.ProteusItemViewHolder paramProteusItemViewHolder) {}
  
  public void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    RIJUserLevelModule.getInstance().doActionsByUserLevel(paramContext, 3, new WebProteusViewCreator.ProteusItemViewHolder.6.1(this, paramViewBase, paramProteusItemData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebProteusViewCreator.ProteusItemViewHolder.6
 * JD-Core Version:    0.7.0.1
 */