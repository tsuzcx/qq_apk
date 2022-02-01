package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSUtils;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.AuthorData;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.ProteusRecommendItemData;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import org.json.JSONObject;

class WebProteusViewCreator$ProteusItemViewHolder$5
  implements WebProteusViewCreator.ProteusItemViewOnClickListener
{
  WebProteusViewCreator$ProteusItemViewHolder$5(WebProteusViewCreator.ProteusItemViewHolder paramProteusItemViewHolder) {}
  
  public void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    if ((paramProteusItemData instanceof AuthorData))
    {
      paramViewBase = (AuthorData)paramProteusItemData;
      if (TextUtils.isEmpty(paramViewBase.a)) {
        return;
      }
      if (paramViewBase.g != null)
      {
        paramContext = paramViewBase.g;
        com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.a = paramContext;
        paramProteusItemData = paramViewBase.c;
        FastWebPTSUtils.a(this.a.f.getContext(), paramContext, paramProteusItemData, paramViewBase.aR, 0);
      }
    }
    else if ((paramProteusItemData instanceof ProteusRecommendItemData))
    {
      paramViewBase = (AuthorData)paramProteusItemData.bb.opt("author_data");
      if (TextUtils.isEmpty(paramViewBase.a)) {
        return;
      }
      if (paramViewBase.g != null)
      {
        paramContext = paramViewBase.g;
        com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.a = paramContext;
        paramProteusItemData = paramViewBase.c;
        FastWebPTSUtils.a(this.a.f.getContext(), paramContext, paramProteusItemData, paramViewBase.aR, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebProteusViewCreator.ProteusItemViewHolder.5
 * JD-Core Version:    0.7.0.1
 */