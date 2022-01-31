import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.List;

final class skp
  extends skm
{
  public void installSucceed(String paramString1, String paramString2)
  {
    super.installSucceed(paramString1, paramString2);
    if (!skn.b()) {
      return;
    }
    skn.a(paramString1, paramString2, true);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    snb.c("WeishiDownloadUtil", "qzone onDownloadCancel info = " + paramDownloadInfo);
    if (skn.a(paramDownloadInfo))
    {
      skn.a();
      int i = skn.b();
      WSPublicAccReport.getInstance().reportDownload(skn.a(), i, 3, 2, 0);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    snb.d("WeishiDownloadUtil", "qzone onDownloadError info = " + paramDownloadInfo);
    if (skn.a(paramDownloadInfo))
    {
      skn.a();
      paramInt2 = skn.b();
      WSPublicAccReport.getInstance().reportDownload(skn.a(), paramInt2, 3, 2, 0);
      snb.d("WeishiDownloadUtil", "qzone  errorCode:" + paramInt1 + ", errorMsg: " + paramString);
      skn.a(paramDownloadInfo, paramInt1);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    skn.a();
    snb.a("WeishiDownloadUtil", "qzone onDownloadFinish~~~");
    int i = skn.a();
    int j = skn.b();
    if (j != 3)
    {
      snb.c("WeishiDownloadUtil", "onDownloadFinish return!qzone只有主动下载");
      return;
    }
    if (!skn.b())
    {
      snb.d("WeishiDownloadUtil", "这是Qzone的监听器，不响应qq onDownloadFinish eventId:" + i + ",eventType:" + j);
      return;
    }
    skn.a(paramDownloadInfo, i, j, "Qzone");
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadPause(paramDownloadInfo);
    snb.d("WeishiDownloadUtil", "qzone onDownloadPause info = " + paramDownloadInfo);
    if (skn.a(paramDownloadInfo)) {
      skn.a();
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    super.onDownloadUpdate(paramList);
    if (!skn.b()) {}
    while ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadWait(paramDownloadInfo);
    snb.d("WeishiDownloadUtil", "qzone onDownloadWait info = " + paramDownloadInfo);
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    super.packageReplaced(paramString1, paramString2);
    snb.d("WeishiDownloadUtil", "qzone packageReplaced appid = " + paramString1 + ", packageName = " + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     skp
 * JD-Core Version:    0.7.0.1
 */