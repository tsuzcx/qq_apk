package cooperation.vip.qqbanner.manager;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.qqbanner.info.VasADBannerConfigInfo.ResourceInfo;

class VasADCountDownInmersionBannerManager$2
  implements URLDrawable.URLDrawableListener
{
  VasADCountDownInmersionBannerManager$2(VasADCountDownInmersionBannerManager paramVasADCountDownInmersionBannerManager, VasADBannerConfigInfo.ResourceInfo paramResourceInfo) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("getLocalDrawable urlDrawable onLoadFialed , url = ");
    paramURLDrawable.append(this.a.a);
    QLog.i("QbossADCountDownInmersi", 1, paramURLDrawable.toString());
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("getLocalDrawable urlDrawable onLoadSuccessed , url = ");
    paramURLDrawable.append(this.a.a);
    QLog.i("QbossADCountDownInmersi", 1, paramURLDrawable.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.qqbanner.manager.VasADCountDownInmersionBannerManager.2
 * JD-Core Version:    0.7.0.1
 */