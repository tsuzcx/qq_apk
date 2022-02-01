package cooperation.vip.qqbanner.manager;

import com.tencent.image.URLDrawable;

class VasADBannerManager$2
  implements Runnable
{
  VasADBannerManager$2(VasADBannerManager paramVasADBannerManager, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    URLDrawable localURLDrawable = this.a;
    if (localURLDrawable != null) {
      localURLDrawable.downloadImediatly(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.qqbanner.manager.VasADBannerManager.2
 * JD-Core Version:    0.7.0.1
 */