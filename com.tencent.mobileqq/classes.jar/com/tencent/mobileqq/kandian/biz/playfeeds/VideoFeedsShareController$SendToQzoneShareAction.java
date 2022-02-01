package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.share.ShareAction;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;

class VideoFeedsShareController$SendToQzoneShareAction
  extends ShareAction
{
  VideoFeedsShareController$SendToQzoneShareAction(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    VideoFeedsShareController.b(this.a).b(VideoFeedsShareController.c(this.a));
    paramActionSheetItem = new Bundle();
    paramActionSheetItem.putString("title", paramVideoInfo.g);
    paramActionSheetItem.putString("desc", paramVideoInfo.h);
    if ((paramVideoInfo.z != null) && (paramVideoInfo.z.contains("kandianshare.html5.qq.com")))
    {
      paramActionSheetItem.putString("detail_url", paramVideoInfo.z);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("&sourcefrom=1");
      paramActionSheetItem.putString("detail_url", localStringBuilder.toString());
    }
    paramString = new ArrayList(1);
    paramString.add(paramVideoInfo.f);
    paramActionSheetItem.putStringArrayList("image_url", paramString);
    paramActionSheetItem.putLong("req_share_id", 0L);
    QZoneShareManager.jumpToQzoneShare(VideoFeedsShareController.m(this.a), VideoFeedsShareController.f(this.a), paramActionSheetItem, null, 10001);
  }
  
  public int b()
  {
    return 1;
  }
  
  public int c()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.SendToQzoneShareAction
 * JD-Core Version:    0.7.0.1
 */