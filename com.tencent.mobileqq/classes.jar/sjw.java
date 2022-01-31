import UserGrowth.stSimpleGetFeedListRsp;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import java.util.ArrayList;

class sjw
  implements slk
{
  sjw(sjv paramsjv, WSRedDotPushMsg paramWSRedDotPushMsg) {}
  
  public void a(slv paramslv)
  {
    sjv.a(this.jdField_a_of_type_Sjv, false);
    if (paramslv == null) {
      sne.d("WSRedDotPreloadManager", "WSRedDot preloadTask is null.");
    }
    do
    {
      return;
      sne.b("WSRedDotPreloadManager", "onTaskResponse-resultCode:" + paramslv.b + " | resultBean:" + paramslv.jdField_a_of_type_JavaLangObject + " | thread:" + Thread.currentThread().getName());
      if (!paramslv.a())
      {
        sne.d("WSRedDotPreloadManager", "WSRedDot preload request error. resultCode=" + paramslv.b);
        return;
      }
    } while (!(paramslv.jdField_a_of_type_Sls instanceof smy));
    smy localsmy = (smy)paramslv.jdField_a_of_type_Sls;
    sne.b("WSRedDotPreloadManager", "WSRedDot recommendRequest.mRequestId=" + localsmy.b + ", mCurrentUniSeq=" + sjv.a(this.jdField_a_of_type_Sjv));
    if ((TextUtils.equals(localsmy.b, String.valueOf(sjv.a(this.jdField_a_of_type_Sjv)))) && ((paramslv.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedListRsp)) && (((stSimpleGetFeedListRsp)paramslv.jdField_a_of_type_JavaLangObject).feeds != null) && (((stSimpleGetFeedListRsp)paramslv.jdField_a_of_type_JavaLangObject).feeds.size() > 0))
    {
      paramslv = ((stSimpleGetFeedListRsp)paramslv.jdField_a_of_type_JavaLangObject).feeds;
      long l = sjv.a(this.jdField_a_of_type_Sjv, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg);
      sjy.a().a(paramslv, l);
      sjv.b(this.jdField_a_of_type_Sjv, false);
      return;
    }
    sne.d("WSRedDotPreloadManager", "WSRedDot preloadList is empty. task.mResultBean=" + paramslv.jdField_a_of_type_JavaLangObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sjw
 * JD-Core Version:    0.7.0.1
 */