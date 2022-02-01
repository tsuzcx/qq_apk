package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.common.RIJMiniProgramUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.data.MiniAppData;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebProteusReportUtils;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;

class WebProteusViewCreator$ProteusItemViewHolder$11
  implements WebProteusViewCreator.ProteusItemViewOnClickListener
{
  WebProteusViewCreator$ProteusItemViewHolder$11(WebProteusViewCreator.ProteusItemViewHolder paramProteusItemViewHolder) {}
  
  public void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramProteusItemData.aQ;
    String str = paramViewBase.getEventAttachedData();
    FastWebProteusReportUtils.b(paramProteusItemData.bd, paramViewBase);
    FastWebProteusReportUtils.a(paramProteusItemData.bd, paramViewBase);
    if (!TextUtils.isEmpty(str))
    {
      if (((paramProteusItemData instanceof MiniAppData)) && (localAbsBaseArticleInfo != null))
      {
        paramViewBase = (MiniAppData)paramProteusItemData;
        localAbsBaseArticleInfo.miniProgramName = paramViewBase.a;
        localAbsBaseArticleInfo.miniAppMovieName = paramViewBase.b;
        localAbsBaseArticleInfo.miniRowKey = paramViewBase.c;
        RIJMiniProgramUtils.a.a(localAbsBaseArticleInfo, 2, str);
        return;
      }
      RIJJumpUtils.c(paramContext, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebProteusViewCreator.ProteusItemViewHolder.11
 * JD-Core Version:    0.7.0.1
 */