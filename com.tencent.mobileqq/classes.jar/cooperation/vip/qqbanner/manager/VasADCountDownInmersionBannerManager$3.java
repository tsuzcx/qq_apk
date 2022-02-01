package cooperation.vip.qqbanner.manager;

import com.tencent.image.URLDrawable;

class VasADCountDownInmersionBannerManager$3
  implements Runnable
{
  VasADCountDownInmersionBannerManager$3(VasADCountDownInmersionBannerManager paramVasADCountDownInmersionBannerManager, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    URLDrawable localURLDrawable = this.a;
    if (localURLDrawable != null) {
      localURLDrawable.downloadImediatly(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.qqbanner.manager.VasADCountDownInmersionBannerManager.3
 * JD-Core Version:    0.7.0.1
 */