import UserGrowth.stNotificationRsp;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import mqq.util.WeakReference;

class rze
  implements ryo
{
  rze(rzd paramrzd) {}
  
  public void a(ryz paramryz)
  {
    sai.b("WSRecommendFragmentPresenter", "NotificationRequest-onTaskResponse-resultCode:" + paramryz.b + " | resultBean:" + paramryz.jdField_a_of_type_JavaLangObject + " | thread:" + Thread.currentThread().getName());
    if (rzd.a(this.a) == null)
    {
      sai.d("WSRecommendFragmentPresenter", "getNotification onTaskResponse mFragmentReference: null");
      return;
    }
    WSRecommendFragment localWSRecommendFragment = (WSRecommendFragment)rzd.a(this.a).get();
    if (localWSRecommendFragment == null)
    {
      sai.d("WSRecommendFragmentPresenter", "getNotification onTaskResponse wsRecommendFragment: null");
      return;
    }
    if (paramryz.a())
    {
      if ((paramryz.jdField_a_of_type_JavaLangObject instanceof stNotificationRsp))
      {
        stNotificationRsp localstNotificationRsp = (stNotificationRsp)paramryz.jdField_a_of_type_JavaLangObject;
        ryp localryp = paramryz.jdField_a_of_type_Ryp;
        if (localstNotificationRsp.type > 0)
        {
          localWSRecommendFragment.a(localstNotificationRsp, localryp);
          return;
        }
        localWSRecommendFragment.a(paramryz.b, paramryz.jdField_a_of_type_JavaLangString);
        return;
      }
      localWSRecommendFragment.a(paramryz.b, paramryz.jdField_a_of_type_JavaLangString);
      sai.d("WSRecommendFragmentPresenter", "NotificationRequest-onTaskResponse error:" + paramryz.b + " | " + paramryz.jdField_a_of_type_JavaLangString);
      return;
    }
    localWSRecommendFragment.a(paramryz.jdField_a_of_type_Int, paramryz.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rze
 * JD-Core Version:    0.7.0.1
 */