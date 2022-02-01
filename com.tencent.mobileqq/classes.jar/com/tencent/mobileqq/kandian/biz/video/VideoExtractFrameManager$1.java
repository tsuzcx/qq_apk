package com.tencent.mobileqq.kandian.biz.video;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

final class VideoExtractFrameManager$1
  implements ThirdVideoManager.UUIDToUrlCallback
{
  VideoExtractFrameManager$1(VideoExtractFrameManager.VideoInfo paramVideoInfo, HashMap paramHashMap) {}
  
  public void a(VideoUrlInfo paramVideoUrlInfo)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("换链回包 mHasDestory = ");
      ((StringBuilder)localObject).append(VideoExtractFrameManager.c().get());
      ((StringBuilder)localObject).append(", vid = ");
      ((StringBuilder)localObject).append(paramVideoUrlInfo.b);
      QLog.d("VideoExtractFrame", 2, ((StringBuilder)localObject).toString());
    }
    if (!VideoExtractFrameManager.c().get())
    {
      if (!this.a.a.equals(paramVideoUrlInfo.b)) {
        return;
      }
      int j = 0;
      paramVideoUrlInfo = paramVideoUrlInfo.n.iterator();
      do
      {
        i = j;
        if (!paramVideoUrlInfo.hasNext()) {
          break;
        }
        localObject = (VideoUrlInfo)paramVideoUrlInfo.next();
      } while ((!((VideoUrlInfo)localObject).c) || (TextUtils.isEmpty(((VideoUrlInfo)localObject).e)) || (!((VideoUrlInfo)localObject).e.equals(String.valueOf(this.a.b))));
      this.a.g = ((VideoUrlInfo)localObject).i;
      this.a.h = ((VideoUrlInfo)localObject).j;
      VideoExtractFrameManager.a(this.a, ((VideoUrlInfo)localObject).a, this.b, this.a.c);
      int i = 1;
      if ((i == 0) && (QLog.isColorLevel()))
      {
        paramVideoUrlInfo = new StringBuilder();
        paramVideoUrlInfo.append("no found videoInfo.tag = ");
        paramVideoUrlInfo.append(this.a.f);
        QLog.d("VideoExtractFrame", 2, paramVideoUrlInfo.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoExtractFrameManager.1
 * JD-Core Version:    0.7.0.1
 */