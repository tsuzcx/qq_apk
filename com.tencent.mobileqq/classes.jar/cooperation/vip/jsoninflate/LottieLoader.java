package cooperation.vip.jsoninflate;

import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.utils.ApolloLottieAnim;

public class LottieLoader
  extends ApolloLottieAnim
{
  private Downloader a;
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Int = 1;
    paramString3 = new LottieLoader.1(this, paramString2, paramString3);
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(paramString1, paramString2, false, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.jsoninflate.LottieLoader
 * JD-Core Version:    0.7.0.1
 */