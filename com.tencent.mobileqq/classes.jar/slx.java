import UserGrowth.stNotificationRsp;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import mqq.util.WeakReference;

class slx
  implements slh
{
  slx(slw paramslw) {}
  
  public void a(sls paramsls)
  {
    snb.b("WSRecommendFragmentPresenter", "NotificationRequest-onTaskResponse-resultCode:" + paramsls.b + " | resultBean:" + paramsls.jdField_a_of_type_JavaLangObject + " | thread:" + Thread.currentThread().getName());
    if (slw.a(this.a) == null)
    {
      snb.d("WSRecommendFragmentPresenter", "getNotification onTaskResponse mFragmentReference: null");
      return;
    }
    WSRecommendFragment localWSRecommendFragment = (WSRecommendFragment)slw.a(this.a).get();
    if (localWSRecommendFragment == null)
    {
      snb.d("WSRecommendFragmentPresenter", "getNotification onTaskResponse wsRecommendFragment: null");
      return;
    }
    if (paramsls.a())
    {
      if ((paramsls.jdField_a_of_type_JavaLangObject instanceof stNotificationRsp))
      {
        stNotificationRsp localstNotificationRsp = (stNotificationRsp)paramsls.jdField_a_of_type_JavaLangObject;
        sli localsli = paramsls.jdField_a_of_type_Sli;
        if (localstNotificationRsp.type > 0)
        {
          localWSRecommendFragment.a(localstNotificationRsp, localsli);
          return;
        }
        localWSRecommendFragment.a(paramsls.b, paramsls.jdField_a_of_type_JavaLangString);
        return;
      }
      localWSRecommendFragment.a(paramsls.b, paramsls.jdField_a_of_type_JavaLangString);
      snb.d("WSRecommendFragmentPresenter", "NotificationRequest-onTaskResponse error:" + paramsls.b + " | " + paramsls.jdField_a_of_type_JavaLangString);
      return;
    }
    localWSRecommendFragment.a(paramsls.jdField_a_of_type_Int, paramsls.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     slx
 * JD-Core Version:    0.7.0.1
 */