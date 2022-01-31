import UserGrowth.stSimpleGetFeedListRsp;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import java.util.ArrayList;

class tco
  implements tgt
{
  tco(tcn paramtcn, WSRedDotPushMsg paramWSRedDotPushMsg) {}
  
  public void a(the paramthe)
  {
    tcn.a(this.jdField_a_of_type_Tcn, false);
    if (paramthe == null) {
      tlo.d("WSRedDotPreloadManager", "WSRedDot preloadTask is null.");
    }
    do
    {
      return;
      tlo.b("WSRedDotPreloadManager", "onTaskResponse-resultCode:" + paramthe.b + " | resultBean:" + paramthe.jdField_a_of_type_JavaLangObject + " | thread:" + Thread.currentThread().getName());
      if (!paramthe.a())
      {
        tlo.d("WSRedDotPreloadManager", "WSRedDot preload request error. resultCode=" + paramthe.b);
        return;
      }
    } while (!(paramthe.jdField_a_of_type_Thb instanceof tkn));
    Object localObject = (tkn)paramthe.jdField_a_of_type_Thb;
    tlo.b("WSRedDotPreloadManager", "WSRedDot recommendRequest.mRequestId=" + ((tkn)localObject).b + ", mCurrentUniSeq=" + tcn.a(this.jdField_a_of_type_Tcn));
    if ((TextUtils.equals(((tkn)localObject).b, String.valueOf(tcn.a(this.jdField_a_of_type_Tcn)))) && ((paramthe.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedListRsp)) && (((stSimpleGetFeedListRsp)paramthe.jdField_a_of_type_JavaLangObject).feeds != null) && (((stSimpleGetFeedListRsp)paramthe.jdField_a_of_type_JavaLangObject).feeds.size() > 0))
    {
      localObject = (stSimpleGetFeedListRsp)paramthe.jdField_a_of_type_JavaLangObject;
      ArrayList localArrayList = ((stSimpleGetFeedListRsp)localObject).feeds;
      if (paramthe.jdField_a_of_type_Tgu != null) {
        tee.a().a(((stSimpleGetFeedListRsp)localObject).trace_id, paramthe.jdField_a_of_type_Tgu.a);
      }
      long l = tcn.a(this.jdField_a_of_type_Tcn, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg);
      tcq.a().a(localArrayList, l);
      tcn.b(this.jdField_a_of_type_Tcn, false);
      return;
    }
    tlo.d("WSRedDotPreloadManager", "WSRedDot preloadList is empty. task.mResultBean=" + paramthe.jdField_a_of_type_JavaLangObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tco
 * JD-Core Version:    0.7.0.1
 */