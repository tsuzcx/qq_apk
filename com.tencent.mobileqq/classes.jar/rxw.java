import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.List;

final class rxw
  extends rxt
{
  public void installSucceed(String paramString1, String paramString2)
  {
    super.installSucceed(paramString1, paramString2);
    if (!rxu.b()) {
      return;
    }
    rxu.a(paramString1, paramString2, true);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    sai.c("WeishiDownloadUtil", "qzone onDownloadCancel info = " + paramDownloadInfo);
    if (rxu.a(paramDownloadInfo))
    {
      rxu.a();
      int i = rxu.b();
      WSPublicAccReport.getInstance().reportDownload(rxu.a(), i, 3, 2, 0);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    sai.d("WeishiDownloadUtil", "qzone onDownloadError info = " + paramDownloadInfo);
    if (rxu.a(paramDownloadInfo))
    {
      rxu.a();
      paramInt2 = rxu.b();
      WSPublicAccReport.getInstance().reportDownload(rxu.a(), paramInt2, 3, 2, 0);
      sai.d("WeishiDownloadUtil", "qzone  errorCode:" + paramInt1 + ", errorMsg: " + paramString);
      rxu.a(paramDownloadInfo, paramInt1);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    rxu.a();
    sai.a("WeishiDownloadUtil", "qzone onDownloadFinish~~~");
    int i = rxu.a();
    int j = rxu.b();
    if (j != 3)
    {
      sai.c("WeishiDownloadUtil", "onDownloadFinish return!qzone只有主动下载");
      return;
    }
    if (!rxu.b())
    {
      sai.d("WeishiDownloadUtil", "这是Qzone的监听器，不响应qq onDownloadFinish eventId:" + i + ",eventType:" + j);
      return;
    }
    rxu.a(paramDownloadInfo, i, j, "Qzone");
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadPause(paramDownloadInfo);
    sai.d("WeishiDownloadUtil", "qzone onDownloadPause info = " + paramDownloadInfo);
    if (rxu.a(paramDownloadInfo)) {
      rxu.a();
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    super.onDownloadUpdate(paramList);
    if (!rxu.b()) {}
    while ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadWait(paramDownloadInfo);
    sai.d("WeishiDownloadUtil", "qzone onDownloadWait info = " + paramDownloadInfo);
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    super.packageReplaced(paramString1, paramString2);
    sai.d("WeishiDownloadUtil", "qzone packageReplaced appid = " + paramString1 + ", packageName = " + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rxw
 * JD-Core Version:    0.7.0.1
 */