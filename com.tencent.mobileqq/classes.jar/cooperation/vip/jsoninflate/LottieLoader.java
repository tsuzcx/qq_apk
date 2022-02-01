package cooperation.vip.jsoninflate;

import android.content.Context;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.apollo.view.ApolloLottieAnim;
import com.tencent.mobileqq.app.QQAppInterface;

public class LottieLoader
  extends ApolloLottieAnim
{
  private static final String TAG = "LottieLoader";
  private Downloader mDownloader;
  
  public LottieLoader(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
    this.mDownloader = DownloaderFactory.getInstance(paramContext).getCommonDownloader();
  }
  
  public void download(String paramString1, String paramString2, String paramString3)
  {
    this.mState = 1;
    paramString3 = new LottieLoader.1(this, paramString2, paramString3);
    this.mDownloader.download(paramString1, paramString2, false, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.jsoninflate.LottieLoader
 * JD-Core Version:    0.7.0.1
 */