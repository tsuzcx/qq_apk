import UserGrowth.stSimpleGetFeedListRsp;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import java.util.ArrayList;

class rxa
  implements ryo
{
  rxa(rwz paramrwz, WSRedDotPushMsg paramWSRedDotPushMsg) {}
  
  public void a(ryz paramryz)
  {
    rwz.a(this.jdField_a_of_type_Rwz, false);
    if (paramryz == null) {
      sai.d("WSRedDotPreloadManager", "WSRedDot preloadTask is null.");
    }
    do
    {
      return;
      sai.b("WSRedDotPreloadManager", "onTaskResponse-resultCode:" + paramryz.b + " | resultBean:" + paramryz.jdField_a_of_type_JavaLangObject + " | thread:" + Thread.currentThread().getName());
      if (!paramryz.a())
      {
        sai.d("WSRedDotPreloadManager", "WSRedDot preload request error. resultCode=" + paramryz.b);
        return;
      }
    } while (!(paramryz.jdField_a_of_type_Ryw instanceof sac));
    sac localsac = (sac)paramryz.jdField_a_of_type_Ryw;
    sai.b("WSRedDotPreloadManager", "WSRedDot recommendRequest.mRequestId=" + localsac.b + ", mCurrentUniSeq=" + rwz.a(this.jdField_a_of_type_Rwz));
    if ((TextUtils.equals(localsac.b, String.valueOf(rwz.a(this.jdField_a_of_type_Rwz)))) && ((paramryz.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedListRsp)) && (((stSimpleGetFeedListRsp)paramryz.jdField_a_of_type_JavaLangObject).feeds != null) && (((stSimpleGetFeedListRsp)paramryz.jdField_a_of_type_JavaLangObject).feeds.size() > 0))
    {
      paramryz = ((stSimpleGetFeedListRsp)paramryz.jdField_a_of_type_JavaLangObject).feeds;
      long l = rwz.a(this.jdField_a_of_type_Rwz, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg);
      rxc.a().a(paramryz, l);
      rwz.b(this.jdField_a_of_type_Rwz, false);
      return;
    }
    sai.d("WSRedDotPreloadManager", "WSRedDot preloadList is empty. task.mResultBean=" + paramryz.jdField_a_of_type_JavaLangObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rxa
 * JD-Core Version:    0.7.0.1
 */