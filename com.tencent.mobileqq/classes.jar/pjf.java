import android.text.TextUtils;
import com.squareup.okhttp.Response;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.handler.ContentHandler;
import com.tencent.component.network.utils.StringUtil;
import org.apache.http.HttpResponse;

public class pjf
  implements ContentHandler
{
  public pjf(DownloaderFactory paramDownloaderFactory) {}
  
  public boolean a(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse, Response paramResponse)
  {
    paramDownloadResult = paramDownloadResult.getContent().type;
    if (TextUtils.isEmpty(paramDownloadResult)) {}
    while (!StringUtil.a(paramDownloadResult, "image")) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pjf
 * JD-Core Version:    0.7.0.1
 */