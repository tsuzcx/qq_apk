import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.VideoCompositeCallBack;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;

public class mzi
  implements Runnable
{
  public mzi(VideoCompositeHelper paramVideoCompositeHelper, PublishVideoEntry paramPublishVideoEntry, String paramString, boolean paramBoolean, VideoCompositeHelper.VideoCompositeCallBack paramVideoCompositeCallBack) {}
  
  public void run()
  {
    try
    {
      try
      {
        this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper$VideoCompositeCallBack);
        return;
      }
      finally {}
      return;
    }
    catch (Exception localException)
    {
      SLog.c(VideoCompositeHelper.jdField_a_of_type_JavaLangString, "do composite exception", localException);
      this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper$VideoCompositeCallBack.a(942012, localException.getMessage(), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mzi
 * JD-Core Version:    0.7.0.1
 */