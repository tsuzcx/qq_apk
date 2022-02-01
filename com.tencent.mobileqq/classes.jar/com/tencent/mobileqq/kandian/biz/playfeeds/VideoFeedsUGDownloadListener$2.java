package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Intent;
import android.content.pm.PackageManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.KandianUGStatisticUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

class VideoFeedsUGDownloadListener$2
  implements Runnable
{
  VideoFeedsUGDownloadListener$2(VideoFeedsUGDownloadListener paramVideoFeedsUGDownloadListener, String paramString) {}
  
  public void run()
  {
    VideoFeedsUGDownloadListener.UGClickData localUGClickData = (VideoFeedsUGDownloadListener.UGClickData)VideoFeedsUGDownloadListener.a(this.this$0).get(this.a);
    if (localUGClickData != null)
    {
      KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(localUGClickData.a, "19", localUGClickData.b));
      Intent localIntent = BaseApplicationImpl.getContext().getPackageManager().getLaunchIntentForPackage(this.a);
      if (localIntent != null)
      {
        localIntent.setFlags(268435456);
        localIntent.putExtra("big_brother_source_key", "biz_src_kandian_videos");
        BaseApplicationImpl.getContext().startActivity(localIntent);
        KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(localUGClickData.a, "106", localUGClickData.b));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsUGDownloadListener.2
 * JD-Core Version:    0.7.0.1
 */