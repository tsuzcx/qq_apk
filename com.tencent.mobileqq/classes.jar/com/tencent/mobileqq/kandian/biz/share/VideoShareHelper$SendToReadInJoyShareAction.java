package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class VideoShareHelper$SendToReadInJoyShareAction
  extends ShareAction
{
  VideoShareHelper$SendToReadInJoyShareAction(VideoShareHelper paramVideoShareHelper) {}
  
  private void b(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    paramString = new Intent(VideoShareHelper.g(this.a), ReadInJoyDeliverBiuActivity.class);
    if (paramAbsBaseArticleInfo.busiType == 6) {
      paramString.putExtra("feedsType", VideoShareHelper.h(this.a).mFeedType);
    }
    paramString.putExtra("ARG_VIDEO_ARTICLE_ID", VideoShareHelper.h(this.a).mArticleID);
    paramString.putExtra("biu_src", 2);
    paramString.putExtra("arg_from_type", 8);
    paramString.putExtra("arg_article_info", paramAbsBaseArticleInfo);
    VideoShareHelper.f(this.a).startActivityForResult(paramString, 102);
    VideoShareHelper.f(this.a).overridePendingTransition(0, 0);
  }
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    RIJUserLevelModule.getInstance().doActionsByUserLevel(VideoShareHelper.f(this.a), 2, new VideoShareHelper.SendToReadInJoyShareAction.1(this, paramInt, paramAbsBaseArticleInfo, paramString, paramActionSheetItem));
  }
  
  public int c()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.VideoShareHelper.SendToReadInJoyShareAction
 * JD-Core Version:    0.7.0.1
 */