package com.tencent.mobileqq.kandian.biz.fastweb.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebDislikeUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.RIJ3ClickUtils;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController;
import com.tencent.mobileqq.kandian.repo.account.IUserLevelCallBack;
import com.tencent.mobileqq.kandian.repo.account.UserLevelInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;

class WebProteusViewCreator$ProteusItemViewHolder$6$1
  implements IUserLevelCallBack
{
  WebProteusViewCreator$ProteusItemViewHolder$6$1(WebProteusViewCreator.ProteusItemViewHolder.6 param6, ViewBase paramViewBase, ProteusItemData paramProteusItemData) {}
  
  public void a(UserLevelInfo paramUserLevelInfo)
  {
    paramUserLevelInfo = this.a;
    if (paramUserLevelInfo != null) {
      paramUserLevelInfo = paramUserLevelInfo.getNativeView();
    } else {
      paramUserLevelInfo = null;
    }
    FastWebDislikeUtils.a(paramUserLevelInfo, this.b.aQ, this.b.aR);
    if ((this.b.aQ != null) && (this.b.aR != null) && (this.b.aR.h)) {
      RIJFeedsDynamicInsertController.INSTANCE.requestInsertArticlesAndRecordAction(this.b.aQ.innerUniqueID, new RIJFeedsInsertAction(ActionType.ACTION_LOVE, 0, 0, 0), 5);
    }
    RIJ3ClickUtils.a.a(this.a.getNativeView(), 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebProteusViewCreator.ProteusItemViewHolder.6.1
 * JD-Core Version:    0.7.0.1
 */