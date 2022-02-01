package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager;
import com.tencent.mobileqq.kandian.biz.share.ShareAction;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;

class VideoFeedsShareController$AddFavoriteAction
  extends ShareAction
{
  VideoFeedsShareController$AddFavoriteAction(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public int a()
  {
    return 4;
  }
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (!NetworkUtil.isNetworkAvailable(VideoFeedsShareController.f(this.a)))
    {
      QQToast.makeText(VideoFeedsShareController.f(this.a), 0, HardCodeUtil.a(2131913404), 0).show();
      return;
    }
    VideoFeedsHelper.a(VideoFeedsShareController.m(this.a), VideoFeedsShareController.f(this.a));
    paramVideoInfo.J = true;
    VideoFeedsShareController.b(this.a).b(VideoFeedsShareController.c(this.a));
    if ((VideoFeedsShareController.f(this.a) instanceof VideoFeedsPlayActivity)) {
      ((VideoFeedsPlayActivity)VideoFeedsShareController.f(this.a)).c(true);
    }
    paramString = paramVideoInfo.r;
    paramActionSheetItem = new Bundle();
    paramActionSheetItem.putInt("videoDuration", paramVideoInfo.e);
    long l;
    if (TextUtils.isEmpty(paramVideoInfo.q)) {
      l = 0L;
    } else {
      l = Long.valueOf(paramVideoInfo.q).longValue();
    }
    paramActionSheetItem.putLong("publishAccountUin", l);
    paramActionSheetItem.putString("publishAccountName", paramString);
    paramActionSheetItem.putLong("feedsId", paramVideoInfo.E);
    paramActionSheetItem.putInt("feedsType", paramVideoInfo.F);
    if (paramVideoInfo.a == 6) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    paramActionSheetItem.putInt("videoType", paramInt);
    if (paramVideoInfo.l == null) {
      paramString = "";
    } else {
      paramString = paramVideoInfo.l;
    }
    ReadInJoyAtlasManager localReadInJoyAtlasManager = ReadInJoyAtlasManager.getInstance();
    Activity localActivity = VideoFeedsShareController.f(this.a);
    String str1 = VideoFeedsShareController.m(this.a).getCurrentUin();
    String str2 = paramVideoInfo.g;
    String str3 = paramVideoInfo.h;
    String str4 = paramVideoInfo.f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramVideoInfo.k);
    localStringBuilder.append("&sourcefrom=6");
    localReadInJoyAtlasManager.doFavorite(localActivity, str1, 2, paramString, str2, str3, str4, localStringBuilder.toString(), paramActionSheetItem);
    paramVideoInfo.H = true;
  }
  
  public int b()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.AddFavoriteAction
 * JD-Core Version:    0.7.0.1
 */