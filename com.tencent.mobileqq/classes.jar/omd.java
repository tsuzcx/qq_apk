import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.GetTroopAssistantFeedIdListRequest;
import com.tencent.biz.qqstory.network.request.GetTroopAssistantFeedIdListRequest.GetTroopAssistantFeedIdListResponse;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.FeedIdListCache;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;

class omd
  implements CmdTaskManger.CommandCallback
{
  omd(omc paramomc, JobContext paramJobContext, Integer paramInteger) {}
  
  public void a(@NonNull GetTroopAssistantFeedIdListRequest paramGetTroopAssistantFeedIdListRequest, @Nullable GetTroopAssistantFeedIdListRequest.GetTroopAssistantFeedIdListResponse paramGetTroopAssistantFeedIdListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      SLog.d("Q.qqstory.home.data.FeedListPageLoaderBase", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramGetTroopAssistantFeedIdListResponse == null))
    {
      SLog.a("Q.qqstory.home.data.FeedListPageLoaderBase", "pull feedId list fail %s", paramErrorMessage.toString());
      omc.a(this.jdField_a_of_type_Omc, paramErrorMessage);
      return;
    }
    omc.a(this.jdField_a_of_type_Omc).a(paramGetTroopAssistantFeedIdListResponse.jdField_a_of_type_JavaUtilList, paramGetTroopAssistantFeedIdListResponse.jdField_a_of_type_JavaLangString, paramGetTroopAssistantFeedIdListResponse.jdField_a_of_type_Boolean);
    ((FeedManager)SuperManager.a(11)).a(paramGetTroopAssistantFeedIdListResponse.jdField_a_of_type_JavaUtilList);
    paramGetTroopAssistantFeedIdListRequest = omc.a(this.jdField_a_of_type_Omc).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    omc.a(this.jdField_a_of_type_Omc, paramGetTroopAssistantFeedIdListRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     omd
 * JD-Core Version:    0.7.0.1
 */