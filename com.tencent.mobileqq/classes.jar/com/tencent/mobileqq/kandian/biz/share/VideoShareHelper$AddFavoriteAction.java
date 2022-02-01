package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import java.net.URL;
import java.util.HashSet;

class VideoShareHelper$AddFavoriteAction
  extends ShareAction
{
  VideoShareHelper$AddFavoriteAction(VideoShareHelper paramVideoShareHelper) {}
  
  public int a()
  {
    return 4;
  }
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (!NetworkUtil.isNetworkAvailable(VideoShareHelper.g(this.a)))
    {
      QQToast.makeText(VideoShareHelper.g(this.a), 0, HardCodeUtil.a(2131913561), 0).show();
      return;
    }
    VideoFeedsHelper.a(VideoShareHelper.i(this.a), VideoShareHelper.f(this.a));
    paramActionSheetItem = new StringBuilder();
    paramActionSheetItem.append(paramString);
    paramActionSheetItem.append("&sourcefrom=6");
    String str1 = paramActionSheetItem.toString();
    paramString = VideoFeedsHelper.a(paramAbsBaseArticleInfo);
    paramActionSheetItem = VideoFeedsHelper.b(paramAbsBaseArticleInfo);
    Bundle localBundle = new Bundle();
    localBundle.putInt("videoDuration", paramAbsBaseArticleInfo.getVideoDuration());
    localBundle.putLong("publishAccountUin", paramActionSheetItem.longValue());
    localBundle.putString("publishAccountName", paramString);
    localBundle.putLong("feedsId", paramAbsBaseArticleInfo.mFeedId);
    localBundle.putInt("feedsType", paramAbsBaseArticleInfo.mFeedType);
    if (paramAbsBaseArticleInfo.busiType == 6) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    localBundle.putInt("videoType", paramInt);
    paramString = VideoShareHelper.i(this.a);
    if (paramString != null) {
      paramString = paramString.getCurrentUin();
    } else {
      paramString = "";
    }
    ReadInJoyAtlasManager localReadInJoyAtlasManager = ReadInJoyAtlasManager.getInstance();
    Activity localActivity = VideoShareHelper.f(this.a);
    String str2 = paramAbsBaseArticleInfo.getInnerUniqueID();
    String str3 = paramAbsBaseArticleInfo.mTitle;
    String str4 = paramAbsBaseArticleInfo.mSummary;
    if (paramAbsBaseArticleInfo.getVideoCoverURL() == null) {
      paramActionSheetItem = "";
    } else {
      paramActionSheetItem = paramAbsBaseArticleInfo.getVideoCoverURL().getPath();
    }
    localReadInJoyAtlasManager.doFavorite(localActivity, paramString, 2, str2, str3, str4, paramActionSheetItem, str1, localBundle);
    VideoShareHelper.e(this.a).add(paramAbsBaseArticleInfo.getInnerUniqueID());
  }
  
  public int b()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.VideoShareHelper.AddFavoriteAction
 * JD-Core Version:    0.7.0.1
 */