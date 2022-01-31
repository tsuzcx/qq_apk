import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;

public class sxl
  implements sxb
{
  public sxl(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(sxa paramsxa)
  {
    ((sxh)this.a.a).j = ((swv)paramsxa).b;
    veg.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "make video thumbnail finish:%s", ((sxh)this.a.a).j);
    this.a.a(1, new ErrorMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sxl
 * JD-Core Version:    0.7.0.1
 */