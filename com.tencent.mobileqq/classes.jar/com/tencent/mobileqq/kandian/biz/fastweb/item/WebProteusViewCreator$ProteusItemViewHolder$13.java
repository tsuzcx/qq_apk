package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import org.json.JSONObject;

class WebProteusViewCreator$ProteusItemViewHolder$13
  implements WebProteusViewCreator.ProteusItemViewOnClickListener
{
  WebProteusViewCreator$ProteusItemViewHolder$13(WebProteusViewCreator.ProteusItemViewHolder paramProteusItemViewHolder) {}
  
  public void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    JSONObject localJSONObject = paramProteusItemData.bb;
    if (WebProteusViewCreator.ProteusItemViewHolder.a(this.a, localJSONObject))
    {
      WebProteusViewCreator.ProteusItemViewHolder.a(this.a, paramViewBase, paramContext, paramProteusItemData);
      return;
    }
    WebProteusViewCreator.ProteusItemViewHolder.b(this.a, paramViewBase, paramContext, paramProteusItemData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebProteusViewCreator.ProteusItemViewHolder.13
 * JD-Core Version:    0.7.0.1
 */