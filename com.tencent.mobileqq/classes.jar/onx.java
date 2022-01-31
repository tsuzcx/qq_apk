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

class onx
  implements CmdTaskManger.CommandCallback
{
  onx(onw paramonw, JobContext paramJobContext, Integer paramInteger) {}
  
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
      onw.a(this.jdField_a_of_type_Onw, paramErrorMessage);
      return;
    }
    onw.a(this.jdField_a_of_type_Onw).a(paramGetTroopAssistantFeedIdListResponse.jdField_a_of_type_JavaUtilList, paramGetTroopAssistantFeedIdListResponse.jdField_a_of_type_JavaLangString, paramGetTroopAssistantFeedIdListResponse.jdField_a_of_type_Boolean);
    ((FeedManager)SuperManager.a(11)).a(paramGetTroopAssistantFeedIdListResponse.jdField_a_of_type_JavaUtilList);
    paramGetTroopAssistantFeedIdListRequest = onw.a(this.jdField_a_of_type_Onw).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    onw.a(this.jdField_a_of_type_Onw, paramGetTroopAssistantFeedIdListRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     onx
 * JD-Core Version:    0.7.0.1
 */