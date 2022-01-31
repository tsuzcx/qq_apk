import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.CreateFakeVideoEvent;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.StoryVideoPublishStatusEvent;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoTaskInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class mzd
  implements Runnable
{
  public mzd(StoryVideoUploadManager paramStoryVideoUploadManager, StoryVideoTaskInfo paramStoryVideoTaskInfo, StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent) {}
  
  public void run()
  {
    SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "create story %s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskStoryVideoTaskInfo });
    Dispatchers.get().dispatch(this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadStoryVideoUploadManager$StoryVideoPublishStatusEvent);
    Dispatchers.get().dispatch(new StoryVideoUploadManager.CreateFakeVideoEvent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mzd
 * JD-Core Version:    0.7.0.1
 */