package com.tencent.mobileqq.kandian.biz.video.click;

import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ClickHandler;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsViewHolder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class RIJVideoHandleClick$10
  implements ClickHandler
{
  RIJVideoHandleClick$10(RIJVideoHandleClick paramRIJVideoHandleClick) {}
  
  public void onClick(View paramView)
  {
    VideoFeedsViewHolder localVideoFeedsViewHolder = (VideoFeedsViewHolder)paramView.getTag();
    AbsBaseArticleInfo localAbsBaseArticleInfo = RIJVideoHandleClick.a(this.a).a(localVideoFeedsViewHolder.jdField_a_of_type_Int);
    if (localAbsBaseArticleInfo == null) {
      return;
    }
    RIJVideoHandleClick.a(this.a).a().a().a(localVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, localAbsBaseArticleInfo, true, true);
    ThreadManager.executeOnSubThread(new RIJVideoHandleClick.10.1(this, localAbsBaseArticleInfo));
    VideoHandler.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.click.RIJVideoHandleClick.10
 * JD-Core Version:    0.7.0.1
 */