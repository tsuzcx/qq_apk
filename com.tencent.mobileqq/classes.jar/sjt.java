import UserGrowth.stSimpleGetFeedListRsp;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import java.util.ArrayList;

class sjt
  implements slh
{
  sjt(sjs paramsjs, WSRedDotPushMsg paramWSRedDotPushMsg) {}
  
  public void a(sls paramsls)
  {
    sjs.a(this.jdField_a_of_type_Sjs, false);
    if (paramsls == null) {
      snb.d("WSRedDotPreloadManager", "WSRedDot preloadTask is null.");
    }
    do
    {
      return;
      snb.b("WSRedDotPreloadManager", "onTaskResponse-resultCode:" + paramsls.b + " | resultBean:" + paramsls.jdField_a_of_type_JavaLangObject + " | thread:" + Thread.currentThread().getName());
      if (!paramsls.a())
      {
        snb.d("WSRedDotPreloadManager", "WSRedDot preload request error. resultCode=" + paramsls.b);
        return;
      }
    } while (!(paramsls.jdField_a_of_type_Slp instanceof smv));
    smv localsmv = (smv)paramsls.jdField_a_of_type_Slp;
    snb.b("WSRedDotPreloadManager", "WSRedDot recommendRequest.mRequestId=" + localsmv.b + ", mCurrentUniSeq=" + sjs.a(this.jdField_a_of_type_Sjs));
    if ((TextUtils.equals(localsmv.b, String.valueOf(sjs.a(this.jdField_a_of_type_Sjs)))) && ((paramsls.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedListRsp)) && (((stSimpleGetFeedListRsp)paramsls.jdField_a_of_type_JavaLangObject).feeds != null) && (((stSimpleGetFeedListRsp)paramsls.jdField_a_of_type_JavaLangObject).feeds.size() > 0))
    {
      paramsls = ((stSimpleGetFeedListRsp)paramsls.jdField_a_of_type_JavaLangObject).feeds;
      long l = sjs.a(this.jdField_a_of_type_Sjs, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg);
      sjv.a().a(paramsls, l);
      sjs.b(this.jdField_a_of_type_Sjs, false);
      return;
    }
    snb.d("WSRedDotPreloadManager", "WSRedDot preloadList is empty. task.mResultBean=" + paramsls.jdField_a_of_type_JavaLangObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sjt
 * JD-Core Version:    0.7.0.1
 */