package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.IStrategy.URLCallback;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "vids", "", "", "kotlin.jvm.PlatformType", "urls", "videoUrlInfo", "Lcom/tencent/mobileqq/kandian/base/video/player/videourl/VideoUrlInfo;", "getUrl", "([Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/mobileqq/kandian/base/video/player/videourl/VideoUrlInfo;)V"}, k=3, mv={1, 1, 16})
final class VideoPlayController$selectUrlByVid$1
  implements IStrategy.URLCallback
{
  VideoPlayController$selectUrlByVid$1(VideoPlayController paramVideoPlayController) {}
  
  public final void a(String[] paramArrayOfString1, String[] paramArrayOfString2, VideoUrlInfo paramVideoUrlInfo)
  {
    if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0) && (paramArrayOfString1 != null) && (paramArrayOfString1.length > 0))
    {
      paramArrayOfString1 = paramArrayOfString2[0];
      Intrinsics.checkExpressionValueIsNotNull(paramArrayOfString1, "urls[0]");
      if ((paramVideoUrlInfo != null) && (paramVideoUrlInfo.c == 2))
      {
        VideoPlayController.a(this.a, 0, 202, 108);
        return;
      }
      if (TextUtils.isEmpty((CharSequence)paramArrayOfString1))
      {
        VideoPlayController.a(this.a, 0, 202, 107);
        return;
      }
      this.a.d(paramArrayOfString1);
      return;
    }
    QLog.d(this.a.a(), 2, "urls null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoPlayController.selectUrlByVid.1
 * JD-Core Version:    0.7.0.1
 */