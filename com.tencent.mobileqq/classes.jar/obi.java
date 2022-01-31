import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoPlayer;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoPlayer.PlayerContext;
import com.tencent.biz.qqstory.takevideo.localmedia.baoutils.common.Callbacks.Callback;
import com.tencent.biz.qqstory.takevideo.localmedia.demos.MediaCodecThumbnailGenerator.ThumbnailProgress;

public class obi
  implements Callbacks.Callback
{
  public obi(EditLocalVideoPlayer paramEditLocalVideoPlayer, long paramLong, int paramInt) {}
  
  public Void a(Boolean paramBoolean, MediaCodecThumbnailGenerator.ThumbnailProgress paramThumbnailProgress)
  {
    if ((!paramBoolean.booleanValue()) || (paramThumbnailProgress == null) || (paramThumbnailProgress.jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      SLog.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail error! thumbnail = (null)");
      return null;
    }
    SLog.b("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d", Integer.valueOf(paramThumbnailProgress.jdField_a_of_type_Int));
    if (paramThumbnailProgress.jdField_a_of_type_Int >= this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditLocalVideoPlayer.a.length)
    {
      SLog.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d OutOfArrayBounds", new Object[] { Integer.valueOf(paramThumbnailProgress.jdField_a_of_type_Int) });
      return null;
    }
    SLog.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "thumbnailProgress index: %d thumbnail done!", Integer.valueOf(paramThumbnailProgress.jdField_a_of_type_Int));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditLocalVideoPlayer.a[paramThumbnailProgress.jdField_a_of_type_Int] = EditLocalVideoPlayer.PlayerContext.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditLocalVideoPlayer.a[paramThumbnailProgress.jdField_a_of_type_Int], paramThumbnailProgress.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditLocalVideoPlayer.a[paramThumbnailProgress.jdField_a_of_type_Int].jdField_a_of_type_JavaLangString = paramThumbnailProgress.jdField_a_of_type_JavaLangString;
    if (paramThumbnailProgress.jdField_a_of_type_Long > 0L)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditLocalVideoPlayer.a[paramThumbnailProgress.jdField_a_of_type_Int].jdField_a_of_type_Int = ((int)paramThumbnailProgress.jdField_a_of_type_Long / 1000);
      SLog.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "fix start time : %d ", Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditLocalVideoPlayer.a[paramThumbnailProgress.jdField_a_of_type_Int].jdField_a_of_type_Int));
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditLocalVideoPlayer.a[paramThumbnailProgress.jdField_a_of_type_Int].b <= 0) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditLocalVideoPlayer.a.length == 1))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditLocalVideoPlayer.a[paramThumbnailProgress.jdField_a_of_type_Int].b = ((int)this.jdField_a_of_type_Long);
        SLog.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "fix end time : %d ", Integer.valueOf(this.jdField_a_of_type_Int));
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditLocalVideoPlayer.h();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obi
 * JD-Core Version:    0.7.0.1
 */