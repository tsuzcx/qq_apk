import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.GetProfileFeedIdListRequest;
import com.tencent.biz.qqstory.network.request.GetProfileFeedIdListRequest.GetProfileFeedIdListResponse;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.FeedIdListCache;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;

class nwt
  implements CmdTaskManger.CommandCallback
{
  nwt(nws paramnws, JobContext paramJobContext, Integer paramInteger) {}
  
  public void a(@NonNull GetProfileFeedIdListRequest paramGetProfileFeedIdListRequest, @Nullable GetProfileFeedIdListRequest.GetProfileFeedIdListResponse paramGetProfileFeedIdListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      SLog.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramGetProfileFeedIdListResponse == null))
    {
      SLog.a("Q.qqstory.home.data.FeedListPageLoaderBase", "pull feedId list fail %s", paramErrorMessage.toString());
      nws.a(this.jdField_a_of_type_Nws, paramErrorMessage);
      return;
    }
    nws.a(this.jdField_a_of_type_Nws).a(paramGetProfileFeedIdListResponse.jdField_a_of_type_JavaUtilList, paramGetProfileFeedIdListResponse.jdField_a_of_type_JavaLangString, paramGetProfileFeedIdListResponse.jdField_a_of_type_Boolean);
    ((FeedManager)SuperManager.a(11)).a(paramGetProfileFeedIdListResponse.jdField_a_of_type_JavaUtilList);
    paramGetProfileFeedIdListRequest = nws.a(this.jdField_a_of_type_Nws).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    nws.a(this.jdField_a_of_type_Nws, paramGetProfileFeedIdListRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nwt
 * JD-Core Version:    0.7.0.1
 */