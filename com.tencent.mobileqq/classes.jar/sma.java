import UserGrowth.stNotificationRsp;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import mqq.util.WeakReference;

class sma
  implements slk
{
  sma(slz paramslz) {}
  
  public void a(slv paramslv)
  {
    sne.b("WSRecommendFragmentPresenter", "NotificationRequest-onTaskResponse-resultCode:" + paramslv.b + " | resultBean:" + paramslv.jdField_a_of_type_JavaLangObject + " | thread:" + Thread.currentThread().getName());
    if (slz.a(this.a) == null)
    {
      sne.d("WSRecommendFragmentPresenter", "getNotification onTaskResponse mFragmentReference: null");
      return;
    }
    WSRecommendFragment localWSRecommendFragment = (WSRecommendFragment)slz.a(this.a).get();
    if (localWSRecommendFragment == null)
    {
      sne.d("WSRecommendFragmentPresenter", "getNotification onTaskResponse wsRecommendFragment: null");
      return;
    }
    if (paramslv.a())
    {
      if ((paramslv.jdField_a_of_type_JavaLangObject instanceof stNotificationRsp))
      {
        stNotificationRsp localstNotificationRsp = (stNotificationRsp)paramslv.jdField_a_of_type_JavaLangObject;
        sll localsll = paramslv.jdField_a_of_type_Sll;
        if (localstNotificationRsp.type > 0)
        {
          localWSRecommendFragment.a(localstNotificationRsp, localsll);
          return;
        }
        localWSRecommendFragment.a(paramslv.b, paramslv.jdField_a_of_type_JavaLangString);
        return;
      }
      localWSRecommendFragment.a(paramslv.b, paramslv.jdField_a_of_type_JavaLangString);
      sne.d("WSRecommendFragmentPresenter", "NotificationRequest-onTaskResponse error:" + paramslv.b + " | " + paramslv.jdField_a_of_type_JavaLangString);
      return;
    }
    localWSRecommendFragment.a(paramslv.jdField_a_of_type_Int, paramslv.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sma
 * JD-Core Version:    0.7.0.1
 */