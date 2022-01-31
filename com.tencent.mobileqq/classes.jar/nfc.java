import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.meta.ImageFileObject;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject.UploadFinishListener;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoTaskInfo;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;
import com.tencent.biz.qqstory.support.logging.SLog;

public class nfc
  implements UploadObject.UploadFinishListener
{
  public nfc(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(UploadObject paramUploadObject)
  {
    ((StoryVideoTaskInfo)this.a.a).j = ((ImageFileObject)paramUploadObject).b;
    SLog.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "make video thumbnail finish:%s", ((StoryVideoTaskInfo)this.a.a).j);
    this.a.a(1, new ErrorMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nfc
 * JD-Core Version:    0.7.0.1
 */