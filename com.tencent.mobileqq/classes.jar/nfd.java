import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoTaskInfo;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.handler.DeleteStoryVideoHandler;
import com.tencent.biz.qqstory.network.request.PublishStoryVideoRequest;
import com.tencent.biz.qqstory.network.response.AddGroupVideoResponse.AddGroupFeed;
import com.tencent.biz.qqstory.network.response.PublishStoryVideoRespond;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class nfd
  implements CmdTaskManger.CommandCallback
{
  public nfd(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  public void a(@NonNull PublishStoryVideoRequest paramPublishStoryVideoRequest, @Nullable PublishStoryVideoRespond paramPublishStoryVideoRespond, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramErrorMessage.isFail()) || (paramPublishStoryVideoRespond == null))
    {
      this.a.a(6, paramErrorMessage);
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post fail:%s task:%s", new Object[] { paramErrorMessage, this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo });
      return;
    }
    ((StoryVideoTaskInfo)this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).d = (paramPublishStoryVideoRespond.jdField_a_of_type_Long * 1000L);
    paramPublishStoryVideoRequest = ((StoryVideoTaskInfo)this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a();
    SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "local feedId %s, remote id: %s", new Object[] { paramPublishStoryVideoRequest.feedId, paramPublishStoryVideoRespond.jdField_a_of_type_JavaLangString });
    SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "local date %s, date id: %s", new Object[] { paramPublishStoryVideoRequest.date, paramPublishStoryVideoRespond.c });
    if (paramPublishStoryVideoRequest.isFakeFeedItem())
    {
      ((StoryVideoTaskInfo)this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).a(paramPublishStoryVideoRespond.jdField_a_of_type_JavaLangString);
      paramPublishStoryVideoRequest.setDate(paramPublishStoryVideoRespond.c);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramPublishStoryVideoRespond.d))
      {
        ((StoryVideoTaskInfo)this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).g = paramPublishStoryVideoRespond.d;
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish success and storyId:%s", new Object[] { paramPublishStoryVideoRespond.d });
      }
      if (!TextUtils.isEmpty(paramPublishStoryVideoRespond.e))
      {
        ((StoryVideoTaskInfo)this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).g = paramPublishStoryVideoRespond.e;
        SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish success and vid:%s", new Object[] { paramPublishStoryVideoRespond.e });
      }
      ((StoryVideoTaskInfo)this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).b = paramPublishStoryVideoRespond.jdField_a_of_type_JavaUtilList;
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "add to shareGroup rsp:" + ((StoryVideoTaskInfo)this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).b);
      ((StoryVideoTaskInfo)this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).e = paramPublishStoryVideoRespond.b;
      if (!this.a.a()) {
        break label535;
      }
      this.a.a(this.a.jdField_a_of_type_Int, new ErrorMessage());
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post success after stop:%s", new Object[] { this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo });
      if (this.a.jdField_a_of_type_Int != 7) {
        break;
      }
      new DeleteStoryVideoHandler().a(((StoryVideoTaskInfo)this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo).g);
      if (paramPublishStoryVideoRespond.jdField_a_of_type_JavaUtilList == null) {
        break;
      }
      paramPublishStoryVideoRequest = paramPublishStoryVideoRespond.jdField_a_of_type_JavaUtilList.iterator();
      while (paramPublishStoryVideoRequest.hasNext())
      {
        paramPublishStoryVideoRespond = ((AddGroupVideoResponse.AddGroupFeed)paramPublishStoryVideoRequest.next()).a.values().iterator();
        while (paramPublishStoryVideoRespond.hasNext())
        {
          paramErrorMessage = (String)paramPublishStoryVideoRespond.next();
          new DeleteStoryVideoHandler().a(paramErrorMessage);
        }
      }
      if (!paramPublishStoryVideoRequest.feedId.equals(paramPublishStoryVideoRespond.jdField_a_of_type_JavaLangString)) {
        SLog.e("Q.qqstory.publish.upload:StoryVideoUploadTask", "local feedId %s, remote id: %s", new Object[] { paramPublishStoryVideoRequest.feedId, paramPublishStoryVideoRespond.jdField_a_of_type_JavaLangString });
      }
    }
    label535:
    this.a.a(5, new ErrorMessage());
    SLog.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "publish post success:%s", new Object[] { this.a.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadTaskBaseTaskInfo });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nfd
 * JD-Core Version:    0.7.0.1
 */