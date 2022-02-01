package com.tencent.mobileqq.kandian.biz.pts.component;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoView;
import com.tencent.mobileqq.kandian.biz.gifvideo.media.MediaVideoView;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.IStrategy.URLCallback;
import com.tencent.mobileqq.kandian.repo.video.entity.PGCVideoInfo;
import com.tencent.qphone.base.util.QLog;

class ComponentPGCShortContentBig$1
  implements IStrategy.URLCallback
{
  ComponentPGCShortContentBig$1(ComponentPGCShortContentBig paramComponentPGCShortContentBig, PGCVideoInfo paramPGCVideoInfo) {}
  
  public void a(String[] paramArrayOfString1, String[] paramArrayOfString2, VideoUrlInfo paramVideoUrlInfo)
  {
    if ((ComponentPGCShortContentBig.a(this.b) != null) && ((ComponentPGCShortContentBig.a(this.b) instanceof VideoView)))
    {
      if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0))
      {
        paramArrayOfString2 = paramArrayOfString2[0];
        if ((!TextUtils.isEmpty(this.a.e)) && (this.a.e.equals(paramArrayOfString1[0])) && (this.a.e.equals(((MediaVideoView)ComponentPGCShortContentBig.a(this.b)).getVideoVid())))
        {
          ComponentPGCShortContentBig.a(this.b, paramArrayOfString2);
          return;
        }
        QLog.d("gifvideo.ComponentPGCShortContentBig", 2, "not current video");
        return;
      }
      QLog.d("gifvideo.ComponentPGCShortContentBig", 2, "urls null");
      return;
    }
    QLog.d("gifvideo.ComponentPGCShortContentBig", 2, "not vieoview");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentPGCShortContentBig.1
 * JD-Core Version:    0.7.0.1
 */