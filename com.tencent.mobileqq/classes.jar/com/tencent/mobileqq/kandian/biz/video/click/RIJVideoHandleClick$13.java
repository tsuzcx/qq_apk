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
    AbsBaseArticleInfo localAbsBaseArticleInfo = RIJVideoHandleClick.b(this.a).c(localVideoFeedsViewHolder.P);
    if (localAbsBaseArticleInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJVideoHandleClick", 2, "articleInfo == null, ERROR");
      }
      return;
    }
    if ((RIJVideoHandleClick.b(this.a).a().z() != null) && (RIJVideoHandleClick.b(this.a).a().z().g()))
    {
      RIJVideoHandleClick.b(this.a).a().z().c();
      RIJVideoHandleClick.b(this.a).a().f(true);
    }
    boolean bool;
    if ((paramView.getId() != 2131435496) && (!RIJSocialBottomViewAladdinConfig.d())) {
      bool = false;
    } else {
      bool = true;
    }
    VideoShareHelper localVideoShareHelper = RIJVideoHandleClick.b(this.a).a().d();
    if (localVideoShareHelper == null)
    {
      QLog.e("RIJVideoHandleClick", 1, "handleVideoShareClick share failed for videoShareHelper is null.");
      return;
    }
    localVideoShareHelper.a(localVideoFeedsViewHolder.Q, localVideoFeedsViewHolder.P);
    localVideoShareHelper.a(RIJVideoHandleClick.b(this.a).a().v());
    localVideoShareHelper.a(localAbsBaseArticleInfo, RIJFullVideoPlayActivity.a(localVideoFeedsViewHolder.t, localAbsBaseArticleInfo, RIJVideoHandleClick.b(this.a).a().z(), RIJVideoHandleClick.b(this.a)), RIJVideoHandleClick.b(this.a).a().z(), new RIJVideoHandleClick.13.1(this, localAbsBaseArticleInfo), RIJVideoHandleClick.b(this.a).a().B(), bool);
    VideoHandler.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.click.RIJVideoHandleClick.13
 * JD-Core Version:    0.7.0.1
 */