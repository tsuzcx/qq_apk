import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.meta.ImageFileObject;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject;
import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject.UploadFinishListener;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoTaskInfo;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;

public class nbf
  implements UploadObject.UploadFinishListener
{
  public nbf(StoryVideoUploadTask paramStoryVideoUploadTask, StoryVideoTaskInfo paramStoryVideoTaskInfo) {}
  
  public void a(UploadObject paramUploadObject)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskStoryVideoTaskInfo.l = ((ImageFileObject)paramUploadObject).b;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskStoryVideoUploadTask.a(1, new ErrorMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nbf
 * JD-Core Version:    0.7.0.1
 */