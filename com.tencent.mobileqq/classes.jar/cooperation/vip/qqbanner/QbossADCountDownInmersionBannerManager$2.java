package cooperation.vip.qqbanner;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.recent.QbossADBannerConfigInfo.ResourceInfo;
import com.tencent.qphone.base.util.QLog;

class QbossADCountDownInmersionBannerManager$2
  implements URLDrawable.URLDrawableListener
{
  QbossADCountDownInmersionBannerManager$2(QbossADCountDownInmersionBannerManager paramQbossADCountDownInmersionBannerManager, QbossADBannerConfigInfo.ResourceInfo paramResourceInfo) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.i("QbossADCountDownInmersi", 1, "getLocalDrawable urlDrawable onLoadFialed , url = " + this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerConfigInfo$ResourceInfo.a);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QLog.i("QbossADCountDownInmersi", 1, "getLocalDrawable urlDrawable onLoadSuccessed , url = " + this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerConfigInfo$ResourceInfo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADCountDownInmersionBannerManager.2
 * JD-Core Version:    0.7.0.1
 */