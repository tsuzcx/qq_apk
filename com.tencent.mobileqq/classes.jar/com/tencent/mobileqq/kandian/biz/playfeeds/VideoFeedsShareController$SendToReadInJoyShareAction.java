package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.mobileqq.kandian.biz.share.ShareAction;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;

class VideoFeedsShareController$SendToReadInJoyShareAction
  extends ShareAction
{
  VideoFeedsShareController$SendToReadInJoyShareAction(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  private void b(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramVideoInfo != null) {
      try
      {
        VideoFeedsShareController.b(this.a).b(VideoFeedsShareController.c(this.a));
        paramString = new Intent(VideoFeedsShareController.f(this.a), ReadInJoyDeliverBiuActivity.class);
        if ((VideoFeedsShareController.e(this.a).a == 6) && (paramVideoInfo.aB != null)) {
          paramString.putExtra("feedsType", VideoFeedsShareController.e(this.a).aB.mFeedType);
        }
        paramString.putExtra("ARG_VIDEO_ARTICLE_ID", VideoFeedsShareController.e(this.a).l);
        paramString.putExtra("biu_src", 2);
        paramString.putExtra("arg_from_type", 8);
        paramString.putExtra("arg_article_info", paramVideoInfo.aB);
        VideoFeedsShareController.f(this.a).startActivityForResult(paramString, 102);
        VideoFeedsShareController.f(this.a).overridePendingTransition(0, 0);
        return;
      }
      catch (Exception paramVideoInfo)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("innerOpenReadInJoyBiuActivity error exception = ");
          paramString.append(paramVideoInfo.getMessage());
          QLog.e("VideoFeedsShareController", 2, paramString.toString());
        }
        VideoFeedsShareController.b(this.a).b(false);
      }
    }
  }
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    RIJUserLevelModule.getInstance().doActionsByUserLevel(VideoFeedsShareController.f(this.a), 2, new VideoFeedsShareController.SendToReadInJoyShareAction.1(this, paramInt, paramVideoInfo, paramString, paramActionSheetItem));
  }
  
  public int c()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.SendToReadInJoyShareAction
 * JD-Core Version:    0.7.0.1
 */