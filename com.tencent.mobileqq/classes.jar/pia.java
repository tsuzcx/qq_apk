import com.squareup.okhttp.Request.Builder;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.impl.ImageDownloaderInitializer;
import com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy;
import com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy.DownloadPool;
import com.tencent.component.network.downloader.strategy.KeepAliveStrategy;
import com.tencent.component.network.module.base.Config;
import org.apache.http.HttpRequest;

public final class pia
  implements DownloadPreprocessStrategy
{
  public pia(Downloader paramDownloader) {}
  
  public DownloadPreprocessStrategy.DownloadPool a(String paramString1, String paramString2)
  {
    if (Config.a(paramString2)) {
      return DownloadPreprocessStrategy.DownloadPool.HTTP2;
    }
    if (ImageDownloaderInitializer.a(paramString2)) {
      return DownloadPreprocessStrategy.DownloadPool.SPECIFIC1;
    }
    paramString1 = this.a.getKeepAliveStrategy();
    if ((paramString1 != null) && (paramString1.a(paramString2))) {
      return DownloadPreprocessStrategy.DownloadPool.SPECIFIC;
    }
    return DownloadPreprocessStrategy.DownloadPool.COMMON;
  }
  
  public String a(String paramString)
  {
    return paramString;
  }
  
  public void a(String paramString1, String paramString2, HttpRequest paramHttpRequest, Request.Builder paramBuilder, int paramInt)
  {
    if ((paramHttpRequest != null) && (paramString2 != null) && (ImageDownloaderInitializer.b(paramString2))) {
      paramHttpRequest.addHeader("Cookie", "uin=o" + Config.a() + ";");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pia
 * JD-Core Version:    0.7.0.1
 */