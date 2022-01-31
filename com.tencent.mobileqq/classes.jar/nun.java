import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.GetLikeListRequest;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.GetLikeListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;

class nun
  implements CmdTaskManger.CommandCallback
{
  nun(num paramnum, JobContext paramJobContext, String paramString) {}
  
  public void a(@NonNull DetailLikeListLoader.GetLikeListRequest paramGetLikeListRequest, @Nullable DetailLikeListLoader.GetLikeListResponse paramGetLikeListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      SLog.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "feed like info pull segment cancel on net respond");
      return;
    }
    if ((paramGetLikeListResponse == null) || (paramErrorMessage.isFail()))
    {
      SLog.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for like request");
      num.a(this.jdField_a_of_type_Num, paramErrorMessage);
      return;
    }
    if (this.jdField_a_of_type_Num.a == 0) {}
    for (boolean bool = false;; bool = true)
    {
      ((LikeManager)SuperManager.a(15)).a(paramGetLikeListResponse.a, this.jdField_a_of_type_JavaLangString, bool, true);
      paramGetLikeListRequest = new nug(bool, paramGetLikeListResponse.a, paramGetLikeListResponse.b, paramGetLikeListResponse.c);
      num.a(this.jdField_a_of_type_Num, paramGetLikeListRequest);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nun
 * JD-Core Version:    0.7.0.1
 */