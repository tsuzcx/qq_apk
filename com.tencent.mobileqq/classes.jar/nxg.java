import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.StoryVideoTaskInfo;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoSpreadGroupList;
import com.tencent.biz.qqstory.network.request.GetStoryFeedIdListRequest;
import com.tencent.biz.qqstory.network.request.GetStoryFeedIdListRequest.GetStoryFeedIdListResponse;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.FeedIdListCache;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class nxg
  implements CmdTaskManger.CommandCallback
{
  nxg(nxf paramnxf, JobContext paramJobContext, AtomicBoolean paramAtomicBoolean, Integer paramInteger) {}
  
  private boolean a(FeedIdListSeqInfo paramFeedIdListSeqInfo, List paramList)
  {
    Object localObject2;
    do
    {
      paramList = paramList.iterator();
      Object localObject1;
      while (!((Iterator)localObject1).hasNext())
      {
        do
        {
          do
          {
            if (!paramList.hasNext()) {
              break;
            }
            localObject1 = (StoryVideoItem)paramList.next();
          } while (!paramFeedIdListSeqInfo.c.equals(((StoryVideoItem)localObject1).mPublishDate));
          if ((((StoryVideoItem)localObject1).isLocalAddShareGroupVideo()) && (paramFeedIdListSeqInfo.b.equals(((StoryVideoItem)localObject1).shareGroupId)))
          {
            SLog.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this share group feed has *add* fail video:%s", new Object[] { paramFeedIdListSeqInfo });
            return true;
          }
          localObject2 = StoryVideoTaskInfo.a(((StoryVideoItem)localObject1).mVid);
          if ((localObject2 != null) && (((PublishVideoEntry)localObject2).getBooleanExtra("ignorePersonalPublish", false))) {}
          for (int i = 1; (i == 0) && (paramFeedIdListSeqInfo.b.equals(((StoryVideoItem)localObject1).mOwnerUid)); i = 0)
          {
            SLog.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this personal feed  has fail video:%s", new Object[] { paramFeedIdListSeqInfo });
            return true;
          }
          localObject1 = ((StoryVideoItem)localObject1).mVideoSpreadGroupList;
        } while ((localObject1 == null) || (((VideoSpreadGroupList)localObject1).b == null));
        localObject1 = ((VideoSpreadGroupList)localObject1).b.iterator();
      }
      localObject2 = (String)((Iterator)localObject1).next();
    } while (!paramFeedIdListSeqInfo.b.equals(localObject2));
    SLog.d("Q.qqstory.home.data.HomeFeedListPageLoader", "this share group feed has fail video:%s", new Object[] { paramFeedIdListSeqInfo });
    return true;
    return false;
  }
  
  public void a(@NonNull GetStoryFeedIdListRequest paramGetStoryFeedIdListRequest, @Nullable GetStoryFeedIdListRequest.GetStoryFeedIdListResponse paramGetStoryFeedIdListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      SLog.d("Q.qqstory.home.data.HomeFeedListPageLoader", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramGetStoryFeedIdListResponse == null))
    {
      SLog.a("Q.qqstory.home.data.HomeFeedListPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      nxf.a(this.jdField_a_of_type_Nxf, paramErrorMessage);
      return;
    }
    nxf.a(this.jdField_a_of_type_Nxf);
    Object localObject2 = "";
    paramErrorMessage = null;
    List localList = ((StoryManager)SuperManager.a(5)).a(true);
    Iterator localIterator = paramGetStoryFeedIdListResponse.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject1;
    if (localIterator.hasNext())
    {
      FeedIdListSeqInfo localFeedIdListSeqInfo = (FeedIdListSeqInfo)localIterator.next();
      localObject1 = localObject2;
      if (!((String)localObject2).equals(localFeedIdListSeqInfo.c)) {
        localObject1 = localFeedIdListSeqInfo.c;
      }
      if (!a(localFeedIdListSeqInfo, localList)) {
        break label384;
      }
      localFeedIdListSeqInfo.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      paramErrorMessage = localFeedIdListSeqInfo;
    }
    label384:
    for (;;)
    {
      localObject2 = localObject1;
      break;
      nxf.a(this.jdField_a_of_type_Nxf).a(paramGetStoryFeedIdListResponse.jdField_a_of_type_JavaUtilList, paramGetStoryFeedIdListResponse.jdField_a_of_type_JavaLangString, paramGetStoryFeedIdListResponse.jdField_a_of_type_Boolean);
      ((FeedManager)SuperManager.a(11)).a(paramGetStoryFeedIdListResponse.jdField_a_of_type_JavaUtilList);
      if ((paramErrorMessage != null) && (((String)localObject2).equals(paramErrorMessage.c))) {}
      for (boolean bool = true;; bool = false)
      {
        SLog.d("Q.qqstory.home.data.HomeFeedListPageLoader", "today is end:%b, loop count:%d, last date has fail:%b", new Object[] { Boolean.valueOf(paramGetStoryFeedIdListResponse.b), Integer.valueOf(nxf.b(this.jdField_a_of_type_Nxf)), Boolean.valueOf(bool) });
        if ((paramGetStoryFeedIdListResponse.jdField_a_of_type_Boolean) || (nxf.b(this.jdField_a_of_type_Nxf) >= 10) || ((paramGetStoryFeedIdListResponse.b) && (!bool))) {
          break;
        }
        SLog.d("Q.qqstory.home.data.HomeFeedListPageLoader", "feedId list not end, pull more");
        paramGetStoryFeedIdListRequest.b = nxf.a(this.jdField_a_of_type_Nxf).a();
        CmdTaskManger.a().a(paramGetStoryFeedIdListRequest, this);
        return;
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false)) {
        nxf.a(this.jdField_a_of_type_Nxf).c();
      }
      paramGetStoryFeedIdListRequest = nxf.a(this.jdField_a_of_type_Nxf).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
      nxf.a(this.jdField_a_of_type_Nxf, paramGetStoryFeedIdListRequest);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nxg
 * JD-Core Version:    0.7.0.1
 */