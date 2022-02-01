package cooperation.vip.jsoninflate;

import com.tencent.TMG.utils.QLog;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;

class LottieLoader$1
  implements Downloader.DownloadListener
{
  LottieLoader$1(LottieLoader paramLottieLoader, String paramString1, String paramString2) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LottieLoader", 0, "diy data download fail url = " + paramString);
    }
    LottieLoader.a(this.jdField_a_of_type_CooperationVipJsoninflateLottieLoader, 2);
    LottieLoader.a(this.jdField_a_of_type_CooperationVipJsoninflateLottieLoader, false, paramString, this.jdField_a_of_type_JavaLangString, this.b);
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LottieLoader", 0, "diy data download success url = " + paramString);
    }
    LottieLoader.b(this.jdField_a_of_type_CooperationVipJsoninflateLottieLoader, true, paramString, this.jdField_a_of_type_JavaLangString, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.jsoninflate.LottieLoader.1
 * JD-Core Version:    0.7.0.1
 */