package cooperation.weiyun.sdk.download.processor;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import anic;
import cooperation.weiyun.sdk.download.DownloadFile;
import cooperation.weiyun.sdk.download.DownloadJobContext;
import cooperation.weiyun.sdk.download.WyDownloader.IFetchListener;

public class UrlFetcher
  implements Handler.Callback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private WyDownloader.IFetchListener jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader$IFetchListener;
  private final UrlFetcher.UrlFetcherCallback jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorUrlFetcher$UrlFetcherCallback;
  
  public UrlFetcher(UrlFetcher.UrlFetcherCallback paramUrlFetcherCallback, WyDownloader.IFetchListener paramIFetchListener)
  {
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadProcessorUrlFetcher$UrlFetcherCallback = paramUrlFetcherCallback;
    paramUrlFetcherCallback = new HandlerThread("download-url-fetcher");
    paramUrlFetcherCallback.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramUrlFetcherCallback.getLooper(), this);
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader$IFetchListener = paramIFetchListener;
  }
  
  private void b(DownloadJobContext paramDownloadJobContext, int paramInt)
  {
    if (paramDownloadJobContext == null) {}
    long l;
    String str;
    do
    {
      return;
      l = paramDownloadJobContext.a();
      str = paramDownloadJobContext.a().a;
    } while (paramDownloadJobContext.d());
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader$IFetchListener.a(paramDownloadJobContext.a().a(), cooperation.weiyun.sdk.download.DownloadType.values()[paramInt], new anic(this, str, l, paramDownloadJobContext, paramInt));
  }
  
  public void a(DownloadJobContext paramDownloadJobContext, int paramInt)
  {
    if (paramDownloadJobContext == null) {
      return;
    }
    Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, paramInt, 0, paramDownloadJobContext).sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      b((DownloadJobContext)paramMessage.obj, paramMessage.arg1);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.weiyun.sdk.download.processor.UrlFetcher
 * JD-Core Version:    0.7.0.1
 */