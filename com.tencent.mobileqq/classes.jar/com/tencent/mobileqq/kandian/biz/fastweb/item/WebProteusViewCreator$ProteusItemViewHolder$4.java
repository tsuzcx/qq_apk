package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.AuthorData;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;

class WebProteusViewCreator$ProteusItemViewHolder$4
  implements WebProteusViewCreator.ProteusItemViewOnClickListener
{
  WebProteusViewCreator$ProteusItemViewHolder$4(WebProteusViewCreator.ProteusItemViewHolder paramProteusItemViewHolder) {}
  
  public void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    if ((paramProteusItemData instanceof AuthorData))
    {
      paramViewBase = (AuthorData)paramProteusItemData;
      paramViewBase.b(false);
      if (WebProteusViewCreator.a(this.a.a) != null) {
        WebProteusViewCreator.a(this.a.a).notifyDataSetChanged();
      }
      if ((paramViewBase.a) && (paramProteusItemData.b != null)) {
        RIJFeedsDynamicInsertController.INSTANCE.requestInsertArticlesAndRecordAction(paramProteusItemData.b.innerUniqueID, new RIJFeedsInsertAction(ActionType.ACTION_FOLLOW, 0, 0, 0), 5);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebProteusViewCreator.ProteusItemViewHolder.4
 * JD-Core Version:    0.7.0.1
 */