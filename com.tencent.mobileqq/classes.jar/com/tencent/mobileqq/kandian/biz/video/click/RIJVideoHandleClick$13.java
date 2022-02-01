package com.tencent.mobileqq.kandian.biz.video.click;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.framework.click.ClickHandler;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.share.VideoShareHelper;
import com.tencent.mobileqq.kandian.biz.video.RIJFullVideoPlayActivity;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsViewHolder;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJSocialBottomViewAladdinConfig;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;

class RIJVideoHandleClick$13
  implements ClickHandler
{
  RIJVideoHandleClick$13(RIJVideoHandleClick paramRIJVideoHandleClick) {}
  
  public void onClick(View paramView)
  {
    VideoFeedsViewHolder localVideoFeedsViewHolder = (VideoFeedsViewHolder)paramView.getTag();
    AbsBaseArticleInfo localAbsBaseArticleInfo = RIJVideoHandleClick.a(this.a).a(localVideoFeedsViewHolder.jdField_a_of_type_Int);
    if (localAbsBaseArticleInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJVideoHandleClick", 2, "articleInfo == null, ERROR");
      }
      return;
    }
    if ((RIJVideoHandleClick.a(this.a).a().a() != null) && (RIJVideoHandleClick.a(this.a).a().a().a()))
    {
      RIJVideoHandleClick.a(this.a).a().a().a();
      RIJVideoHandleClick.a(this.a).a().f(true);
    }
    boolean bool;
    if ((paramView.getId() != 2131368584) && (!RIJSocialBottomViewAladdinConfig.d())) {
      bool = false;
    } else {
      bool = true;
    }
    VideoShareHelper localVideoShareHelper = RIJVideoHandleClick.a(this.a).a().a();
    if (localVideoShareHelper == null)
    {
      QLog.e("RIJVideoHandleClick", 1, "handleVideoShareClick share failed for videoShareHelper is null.");
      return;
    }
    localVideoShareHelper.a(localVideoFeedsViewHolder.g, localVideoFeedsViewHolder.jdField_a_of_type_Int);
    localVideoShareHelper.a(RIJVideoHandleClick.a(this.a).a().a());
    localVideoShareHelper.a(localAbsBaseArticleInfo, RIJFullVideoPlayActivity.a(localVideoFeedsViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, localAbsBaseArticleInfo, RIJVideoHandleClick.a(this.a).a().a(), RIJVideoHandleClick.a(this.a)), RIJVideoHandleClick.a(this.a).a().a(), new RIJVideoHandleClick.13.1(this, localAbsBaseArticleInfo), RIJVideoHandleClick.a(this.a).a().b(), bool);
    VideoHandler.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.click.RIJVideoHandleClick.13
 * JD-Core Version:    0.7.0.1
 */