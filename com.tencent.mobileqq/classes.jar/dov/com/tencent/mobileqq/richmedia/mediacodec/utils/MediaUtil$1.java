package dov.com.tencent.mobileqq.richmedia.mediacodec.utils;

import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.localmedia.baoutils.common.Callbacks.Callback;
import dov.com.tencent.biz.qqstory.takevideo.localmedia.demos.MediaCodecThumbnailGenerator.ThumbnailResult;

final class MediaUtil$1
  implements Callbacks.Callback<Boolean, MediaCodecThumbnailGenerator.ThumbnailResult>
{
  MediaUtil$1(Object paramObject) {}
  
  public Void a(Boolean arg1, MediaCodecThumbnailGenerator.ThumbnailResult paramThumbnailResult)
  {
    QLog.e(MediaUtil.a(), 2, "MediaCodecThumbnailGenerator finished().");
    synchronized (this.a)
    {
      this.a.notifyAll();
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil.1
 * JD-Core Version:    0.7.0.1
 */