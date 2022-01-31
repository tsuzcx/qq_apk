import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;

public class sxi
  implements swy
{
  public sxi(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(swx paramswx)
  {
    ((sxe)this.a.a).j = ((sws)paramswx).b;
    ved.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "make video thumbnail finish:%s", ((sxe)this.a.a).j);
    this.a.a(1, new ErrorMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sxi
 * JD-Core Version:    0.7.0.1
 */