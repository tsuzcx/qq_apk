package cooperation.comic;

import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

final class VipComicHelper$1
  implements Runnable
{
  VipComicHelper$1(WeakReference paramWeakReference, int paramInt) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return;
    }
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.comic_plugin_profile.name(), "");
    Integer[] arrayOfInteger = new Integer[7];
    int i;
    if (((IDPCApi)QRoute.api(IDPCApi.class)).parseComplexParamsByStringToIntParser(str, arrayOfInteger) >= arrayOfInteger.length) {
      if ((arrayOfInteger[4].intValue() & this.jdField_a_of_type_Int) != 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ComicHelper", 2, "Skip update offline pkg. entry = " + this.jdField_a_of_type_Int);
        return;
        i = 0;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ComicHelper", 2, "Do update offline pkg. entry = " + this.jdField_a_of_type_Int);
      }
      HtmlOffline.b("354", localQQAppInterface, true, new VipComicHelper.1.1(this));
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.VipComicHelper.1
 * JD-Core Version:    0.7.0.1
 */