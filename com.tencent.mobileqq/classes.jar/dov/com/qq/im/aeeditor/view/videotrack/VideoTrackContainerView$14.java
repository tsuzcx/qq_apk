package dov.com.qq.im.aeeditor.view.videotrack;

import android.graphics.Bitmap;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbListener;

class VideoTrackContainerView$14
  implements VideoThumbListener
{
  VideoTrackContainerView$14(VideoTrackContainerView paramVideoTrackContainerView) {}
  
  public void onThumbGenerated(Object paramObject, CMTime paramCMTime, Bitmap paramBitmap)
  {
    if ((paramObject instanceof String)) {
      this.a.a((String)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView.14
 * JD-Core Version:    0.7.0.1
 */