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
    if (!NetworkUtil.isNetworkAvailable(VideoFeedsShareController.a(this.a)))
    {
      QQToast.a(VideoFeedsShareController.a(this.a), 0, HardCodeUtil.a(2131715949), 0).a();
      return;
    }
    VideoFeedsHelper.a(VideoFeedsShareController.a(this.a), VideoFeedsShareController.a(this.a));
    paramVideoInfo.jdField_d_of_type_Boolean = true;
    VideoFeedsShareController.a(this.a).b(VideoFeedsShareController.b(this.a));
    if ((VideoFeedsShareController.a(this.a) instanceof VideoFeedsPlayActivity)) {
      ((VideoFeedsPlayActivity)VideoFeedsShareController.a(this.a)).c(true);
    }
    paramString = paramVideoInfo.k;
    paramActionSheetItem = new Bundle();
    paramActionSheetItem.putInt("videoDuration", paramVideoInfo.jdField_d_of_type_Int);
    long l;
    if (TextUtils.isEmpty(paramVideoInfo.j)) {
      l = 0L;
    } else {
      l = Long.valueOf(paramVideoInfo.j).longValue();
    }
    paramActionSheetItem.putLong("publishAccountUin", l);
    paramActionSheetItem.putString("publishAccountName", paramString);
    paramActionSheetItem.putLong("feedsId", paramVideoInfo.jdField_d_of_type_Long);
    paramActionSheetItem.putInt("feedsType", paramVideoInfo.h);
    if (paramVideoInfo.a == 6) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    paramActionSheetItem.putInt("videoType", paramInt);
    if (paramVideoInfo.g == null) {
      paramString = "";
    } else {
      paramString = paramVideoInfo.g;
    }
    ReadInJoyAtlasManager localReadInJoyAtlasManager = ReadInJoyAtlasManager.getInstance();
    Activity localActivity = VideoFeedsShareController.a(this.a);
    String str1 = VideoFeedsShareController.a(this.a).getCurrentUin();
    String str2 = paramVideoInfo.jdField_c_of_type_JavaLangString;
    String str3 = paramVideoInfo.jdField_d_of_type_JavaLangString;
    String str4 = paramVideoInfo.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramVideoInfo.f);
    localStringBuilder.append("&sourcefrom=6");
    localReadInJoyAtlasManager.doFavorite(localActivity, str1, 2, paramString, str2, str3, str4, localStringBuilder.toString(), paramActionSheetItem);
    paramVideoInfo.jdField_c_of_type_Boolean = true;
  }
  
  public int b()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.AddFavoriteAction
 * JD-Core Version:    0.7.0.1
 */