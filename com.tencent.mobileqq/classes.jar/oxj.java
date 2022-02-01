import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.database.PublishVideoEntry;

public class oxj
{
  private VideoCompositeHelper jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper = new VideoCompositeHelper();
  private oxl jdField_a_of_type_Oxl;
  
  private void a(PublishVideoEntry paramPublishVideoEntry, int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Oxl != null) {
      this.jdField_a_of_type_Oxl.a(paramPublishVideoEntry, paramInt, paramString);
    }
  }
  
  private void a(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    if (this.jdField_a_of_type_Oxl != null) {
      this.jdField_a_of_type_Oxl.a(paramPublishVideoEntry, paramString);
    }
  }
  
  public void a(String paramString)
  {
    VideoCompositeHelper.deleteVideoCache(VideoCompositeHelper.getPublishVideoEntry(paramString));
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = VideoCompositeHelper.getPublishVideoEntry(paramString1);
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper.composite(paramString1, paramString2 + ".tmp.mp4", false, true, new oxk(this, l, paramString1));
  }
  
  public void a(oxl paramoxl)
  {
    this.jdField_a_of_type_Oxl = paramoxl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oxj
 * JD-Core Version:    0.7.0.1
 */