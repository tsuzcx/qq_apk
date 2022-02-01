package cooperation.vip.qqbanner.manager;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.qqbanner.info.VasADBannerConfigInfo;
import java.lang.ref.WeakReference;

class VasADBannerResDownloadManager$VasBannerDownloadListener
  implements Downloader.DownloadListener
{
  private VasADBannerConfigInfo b;
  private volatile int c;
  private volatile int d;
  private int e;
  private WeakReference<QQAppInterface> f;
  
  public VasADBannerResDownloadManager$VasBannerDownloadListener(VasADBannerResDownloadManager paramVasADBannerResDownloadManager, QQAppInterface paramQQAppInterface, VasADBannerConfigInfo paramVasADBannerConfigInfo, int paramInt)
  {
    this.f = new WeakReference(paramQQAppInterface);
    this.b = paramVasADBannerConfigInfo;
    this.e = paramInt;
    this.c = 0;
    this.d = 0;
  }
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel())
    {
      paramDownloadResult = new StringBuilder();
      paramDownloadResult.append("diy data download fail url = ");
      paramDownloadResult.append(paramString);
      QLog.i("VasADBannerResDownloadManager", 2, paramDownloadResult.toString());
    }
    this.d += 1;
    VasADBannerResDownloadManager.a(this.a, this.b, paramString, false);
    paramString = new StringBuilder();
    paramString.append("onDownloadFailed mLoadSuccessTimes = ");
    paramString.append(this.c);
    paramString.append(" mDownTotalSize = ");
    paramString.append(this.e);
    QLog.e("VasADBannerResDownloadManager", 1, paramString.toString());
    paramString = (QQAppInterface)this.f.get();
    if (this.d + this.c == this.e) {
      VasADBannerResDownloadManager.a(this.a, paramString);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel())
    {
      paramDownloadResult = new StringBuilder();
      paramDownloadResult.append("banner resources download success url = ");
      paramDownloadResult.append(paramString);
      QLog.i("VasADBannerResDownloadManager", 2, paramDownloadResult.toString());
    }
    this.c += 1;
    VasADBannerResDownloadManager.a(this.a, this.b, paramString, true);
    paramString = (QQAppInterface)this.f.get();
    paramDownloadResult = new StringBuilder();
    paramDownloadResult.append("onDownloadSucceed mLoadSuccessTimes = ");
    paramDownloadResult.append(this.c);
    paramDownloadResult.append(" mDownTotalSize = ");
    paramDownloadResult.append(this.e);
    QLog.e("VasADBannerResDownloadManager", 1, paramDownloadResult.toString());
    if ((this.c == this.e) && (!this.b.d())) {
      VasADBannerResDownloadManager.b(this.a, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.qqbanner.manager.VasADBannerResDownloadManager.VasBannerDownloadListener
 * JD-Core Version:    0.7.0.1
 */