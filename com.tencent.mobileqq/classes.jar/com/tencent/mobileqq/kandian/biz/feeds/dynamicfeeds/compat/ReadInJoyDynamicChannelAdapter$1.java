package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.compat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;

class ReadInJoyDynamicChannelAdapter$1
  implements View.OnClickListener
{
  ReadInJoyDynamicChannelAdapter$1(ReadInJoyDynamicChannelAdapter paramReadInJoyDynamicChannelAdapter) {}
  
  public void onClick(View paramView)
  {
    int i = ((ReadInJoyDynamicChannelAdapter.CustomViewHolder)paramView.getTag()).getAdapterPosition() - ReadInJoyDynamicChannelAdapter.a(this.a).getHeaderViewsCount();
    int j = this.a.getItemViewType(i);
    AbsBaseArticleInfo localAbsBaseArticleInfo = ReadInJoyDynamicChannelAdapter.a(this.a, i);
    if (localAbsBaseArticleInfo == null)
    {
      QLog.d("ReadInJoyDynamicChannelAdapter", 1, "onItemClick onClick articleInfo is null.");
      return;
    }
    QLog.d("ReadInJoyDynamicChannelAdapter", 2, new Object[] { "onItemClick, position = ", Integer.valueOf(i), ", itemViewType = ", Integer.valueOf(j) });
    this.a.a(i, paramView);
    localAbsBaseArticleInfo.invalidateProteusTemplateBean();
    com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.a = localAbsBaseArticleInfo;
    ReadInJoyLogicEngine.a().a(localAbsBaseArticleInfo.mArticleID, System.currentTimeMillis());
    this.a.notifyItemChanged(i);
    RIJFrameworkReportManager.a(ReadInJoyDynamicChannelAdapter.b(this.a), localAbsBaseArticleInfo, (int)localAbsBaseArticleInfo.mChannelID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.compat.ReadInJoyDynamicChannelAdapter.1
 * JD-Core Version:    0.7.0.1
 */