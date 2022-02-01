package dov.com.tencent.biz.qqstory.takevideo;

import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.tencent.biz.qqstory.takevideo.localmedia.baoutils.common.Callbacks.Callback;
import dov.com.tencent.biz.qqstory.takevideo.localmedia.demos.MediaCodecThumbnailGenerator.ThumbnailProgress;

class EditLocalVideoPlayer$2
  implements Callbacks.Callback<Boolean, MediaCodecThumbnailGenerator.ThumbnailProgress>
{
  EditLocalVideoPlayer$2(EditLocalVideoPlayer paramEditLocalVideoPlayer) {}
  
  public Void a(Boolean paramBoolean, MediaCodecThumbnailGenerator.ThumbnailProgress paramThumbnailProgress)
  {
    if ((!paramBoolean.booleanValue()) || (paramThumbnailProgress == null) || (paramThumbnailProgress.jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      SLog.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail error! thumbnail = (null)");
      return null;
    }
    SLog.b("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d", Integer.valueOf(paramThumbnailProgress.jdField_a_of_type_Int));
    if (paramThumbnailProgress.jdField_a_of_type_Int >= this.a.a.length)
    {
      SLog.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d OutOfArrayBounds", new Object[] { Integer.valueOf(paramThumbnailProgress.jdField_a_of_type_Int) });
      return null;
    }
    SLog.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "thumbnailProgress index: %d thumbnail done!", Integer.valueOf(paramThumbnailProgress.jdField_a_of_type_Int));
    this.a.a[paramThumbnailProgress.jdField_a_of_type_Int] = EditLocalVideoPlayer.PlayerContext.a(this.a.a[paramThumbnailProgress.jdField_a_of_type_Int], paramThumbnailProgress.jdField_a_of_type_AndroidGraphicsBitmap);
    this.a.a[paramThumbnailProgress.jdField_a_of_type_Int].jdField_a_of_type_JavaLangString = paramThumbnailProgress.jdField_a_of_type_JavaLangString;
    this.a.k();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoPlayer.2
 * JD-Core Version:    0.7.0.1
 */