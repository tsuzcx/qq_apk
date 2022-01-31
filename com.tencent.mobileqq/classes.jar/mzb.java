import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.OneVideoInfo;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.ShareGroupFakeItem;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.StoryVideoPublishStatusEvent;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.request.AddGroupVideoRequest;
import com.tencent.biz.qqstory.network.response.AddGroupVideoResponse;
import com.tencent.biz.qqstory.network.response.AddGroupVideoResponse.AddGroupFeed;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class mzb
  implements CmdTaskManger.CommandCallback
{
  public mzb(VideoListFeedItem paramVideoListFeedItem, List paramList, StoryManager paramStoryManager) {}
  
  public void a(@NonNull AddGroupVideoRequest paramAddGroupVideoRequest, @Nullable AddGroupVideoResponse paramAddGroupVideoResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    boolean bool = false;
    if ((paramAddGroupVideoResponse == null) || (paramErrorMessage.isFail())) {
      bool = true;
    }
    if ((!bool) && (paramAddGroupVideoResponse.a() != null) && (paramAddGroupVideoResponse.a().size() != 1)) {
      bool = true;
    }
    for (;;)
    {
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "add share group fail:%b", new Object[] { Boolean.valueOf(bool) });
      paramAddGroupVideoRequest = new StoryVideoUploadManager.StoryVideoPublishStatusEvent(false);
      paramAddGroupVideoRequest.b = false;
      paramAddGroupVideoRequest.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
      paramErrorMessage = new StoryVideoUploadManager.ShareGroupFakeItem();
      paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem;
      Object localObject;
      label176:
      StoryVideoItem localStoryVideoItem1;
      if (!bool)
      {
        localObject = (AddGroupVideoResponse.AddGroupFeed)paramAddGroupVideoResponse.a().get(0);
        if (((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem)) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId.equals(((AddGroupVideoResponse.AddGroupFeed)localObject).b))) {
          paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = ((ShareGroupFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label501;
        }
        localStoryVideoItem1 = (StoryVideoItem)((Iterator)localObject).next();
        if (!bool) {
          break label495;
        }
      }
      label495:
      for (int i = 6;; i = 5)
      {
        localStoryVideoItem1.mUploadStatus = i;
        StoryVideoUploadManager.OneVideoInfo localOneVideoInfo = new StoryVideoUploadManager.OneVideoInfo();
        localOneVideoInfo.a = this.jdField_a_of_type_ComTencentBizQqstoryModelStoryManager.a(localStoryVideoItem1);
        paramErrorMessage.jdField_a_of_type_JavaUtilArrayList.add(localOneVideoInfo);
        if (bool) {
          break label176;
        }
        StoryVideoItem localStoryVideoItem2 = new StoryVideoItem();
        localStoryVideoItem2.copy(localStoryVideoItem1);
        List localList = paramAddGroupVideoResponse.a();
        localStoryVideoItem2.mVid = ((String)((AddGroupVideoResponse.AddGroupFeed)localList.get(0)).a.get(localStoryVideoItem1.sourceVid));
        localStoryVideoItem2.mVideoIndex = 0L;
        if (TextUtils.isEmpty(localStoryVideoItem2.mVid))
        {
          SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "cannot find true vid for sourceVid=%s, %s", new Object[] { localStoryVideoItem1.sourceVid, localList });
          AssertUtils.a(localStoryVideoItem2.mVid);
          localStoryVideoItem2.mVid = StoryVideoItem.makeFakeVid();
        }
        localOneVideoInfo.b = this.jdField_a_of_type_ComTencentBizQqstoryModelStoryManager.a(localStoryVideoItem2);
        break label176;
        paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = new ShareGroupFeedItem();
        paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.copy(paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
        paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId = ((AddGroupVideoResponse.AddGroupFeed)localObject).b;
        if (paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.videoCount == 0) {
          paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.videoCount = 1;
        }
        AssertUtils.a(((AddGroupVideoResponse.AddGroupFeed)localObject).b);
        localObject = (FeedManager)SuperManager.a(11);
        paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = ((ShareGroupFeedItem)((FeedManager)localObject).a(paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem));
        ((FeedManager)localObject).a(paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.ownerId, paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.date, paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId);
        break;
      }
      label501:
      paramAddGroupVideoRequest.jdField_a_of_type_JavaUtilArrayList.add(paramErrorMessage);
      Dispatchers.get().dispatch(paramAddGroupVideoRequest);
      SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "add shareGroup video return: %s", new Object[] { paramAddGroupVideoRequest });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mzb
 * JD-Core Version:    0.7.0.1
 */