import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.item.FeedFeatureItem;
import com.tencent.biz.qqstory.network.request.GetFeedFeatureRequest;
import com.tencent.biz.qqstory.network.response.GetFeedFeatureResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;

class nup
  implements CmdTaskManger.CommandCallback
{
  nup(nuo paramnuo, JobContext paramJobContext, String paramString) {}
  
  public void a(@NonNull GetFeedFeatureRequest paramGetFeedFeatureRequest, @Nullable GetFeedFeatureResponse paramGetFeedFeatureResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      SLog.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "segment cancel on net respond");
      return;
    }
    if ((paramGetFeedFeatureResponse == null) || (paramErrorMessage.isFail()))
    {
      SLog.d("Q.qqstory.detail:DetailFeedAllInfoPullSegment", "request fail for feature request");
      nuo.a(this.jdField_a_of_type_Nuo, paramErrorMessage);
      return;
    }
    if (paramGetFeedFeatureResponse.a != null)
    {
      paramGetFeedFeatureRequest = paramGetFeedFeatureResponse.a.iterator();
      do
      {
        if (!paramGetFeedFeatureRequest.hasNext()) {
          break;
        }
        paramGetFeedFeatureResponse = (FeedFeatureItem)paramGetFeedFeatureRequest.next();
      } while (!paramGetFeedFeatureResponse.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString));
    }
    for (int i = paramGetFeedFeatureResponse.c;; i = 0)
    {
      nuo.a(this.jdField_a_of_type_Nuo, Integer.valueOf(i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nup
 * JD-Core Version:    0.7.0.1
 */