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

class ntb
  implements CmdTaskManger.CommandCallback
{
  ntb(nta paramnta, JobContext paramJobContext, String paramString) {}
  
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
      nta.a(this.jdField_a_of_type_Nta, paramErrorMessage);
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
      nta.a(this.jdField_a_of_type_Nta, Integer.valueOf(i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ntb
 * JD-Core Version:    0.7.0.1
 */