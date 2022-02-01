package dov.com.tencent.mobileqq.richmedia.mediacodec.utils;

import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.localmedia.baoutils.common.Callbacks.Callback;
import dov.com.tencent.biz.qqstory.takevideo.localmedia.demos.MediaCodecThumbnailGenerator.ThumbnailProgress;

final class MediaUtil$2
  implements Callbacks.Callback<Boolean, MediaCodecThumbnailGenerator.ThumbnailProgress>
{
  MediaUtil$2(MediaUtil.FrameWithoutBlackResult paramFrameWithoutBlackResult) {}
  
  public Void a(Boolean paramBoolean, MediaCodecThumbnailGenerator.ThumbnailProgress paramThumbnailProgress)
  {
    if (paramThumbnailProgress.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.a.jdField_a_of_type_AndroidGraphicsBitmap = paramThumbnailProgress.jdField_a_of_type_AndroidGraphicsBitmap;
      this.a.jdField_a_of_type_Long = paramThumbnailProgress.jdField_a_of_type_Long;
      QLog.e(MediaUtil.a(), 2, "MediaCodecThumbnailGenerator progress " + paramThumbnailProgress.jdField_a_of_type_Long);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil.2
 * JD-Core Version:    0.7.0.1
 */