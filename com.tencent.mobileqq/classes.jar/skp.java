import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;

public class skp
  implements skf
{
  public skp(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(ske paramske)
  {
    ((skl)this.a.a).j = ((sjz)paramske).b;
    urk.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "make video thumbnail finish:%s", ((skl)this.a.a).j);
    this.a.a(1, new ErrorMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     skp
 * JD-Core Version:    0.7.0.1
 */