package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import java.util.List;
import org.json.JSONObject;

class DoubleShortVideoProteusItem$1
  implements ViewBase.OnClickListener
{
  DoubleShortVideoProteusItem$1(DoubleShortVideoProteusItem paramDoubleShortVideoProteusItem, IReadInJoyModel paramIReadInJoyModel, int paramInt, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.a.k();
    if (localAbsBaseArticleInfo == null) {
      return;
    }
    JSONObject localJSONObject = localAbsBaseArticleInfo.getProteusItemData();
    if (localJSONObject == null) {
      return;
    }
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = (ReadInJoyBaseAdapter)this.a.u();
    boolean bool;
    if (this.b == 1131) {
      bool = true;
    } else {
      bool = false;
    }
    paramViewBase = localAbsBaseArticleInfo;
    if (!bool)
    {
      paramViewBase = localAbsBaseArticleInfo;
      if (localAbsBaseArticleInfo.mSubArticleList != null)
      {
        paramViewBase = localAbsBaseArticleInfo;
        if (localAbsBaseArticleInfo.mSubArticleList.size() > 0)
        {
          paramViewBase = localAbsBaseArticleInfo;
          if (localAbsBaseArticleInfo.mSubArticleList.get(0) != null) {
            paramViewBase = (AbsBaseArticleInfo)localAbsBaseArticleInfo.mSubArticleList.get(0);
          }
        }
      }
    }
    if (!VideoFeedsHelper.a(paramViewBase, this.c.getContext())) {
      DoubleShortVideoProteusItem.a(this.d, this.c.getContext(), paramViewBase, localReadInJoyBaseAdapter);
    }
    ReadInJoyLogicEngine.a().a(paramViewBase.mArticleID, System.currentTimeMillis());
    DoubleShortVideoProteusItem.a(this.d, paramViewBase, bool, localJSONObject);
    localReadInJoyBaseAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.DoubleShortVideoProteusItem.1
 * JD-Core Version:    0.7.0.1
 */