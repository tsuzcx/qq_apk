package cooperation.vip.qqbanner.manager;

import cooperation.vip.qqbanner.info.VasADBannerConfigInfo;

class VasADCountDownInmersionBannerManager$1
  implements Runnable
{
  VasADCountDownInmersionBannerManager$1(VasADCountDownInmersionBannerManager paramVasADCountDownInmersionBannerManager, VasADBannerConfigInfo paramVasADBannerConfigInfo) {}
  
  public void run()
  {
    VasADBannerConfigInfo localVasADBannerConfigInfo = this.a;
    if (localVasADBannerConfigInfo == null) {
      return;
    }
    VasADCountDownInmersionBannerManager.a(this.this$0, localVasADBannerConfigInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.qqbanner.manager.VasADCountDownInmersionBannerManager.1
 * JD-Core Version:    0.7.0.1
 */