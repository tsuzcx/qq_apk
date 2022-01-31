import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.List;

final class tfc
  extends tez
{
  public void installSucceed(String paramString1, String paramString2)
  {
    super.installSucceed(paramString1, paramString2);
    if (!tfa.b()) {
      return;
    }
    tfa.a(paramString1, paramString2, true);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    tlo.c("WeishiDownloadUtil", "qzone onDownloadCancel info = " + paramDownloadInfo);
    if (tfa.a(paramDownloadInfo))
    {
      tfa.a();
      int i = tfa.b();
      WSPublicAccReport.getInstance().reportDownload(tfa.a(), i, 3, 2, 0);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    tlo.d("WeishiDownloadUtil", "qzone onDownloadError info = " + paramDownloadInfo);
    if (tfa.a(paramDownloadInfo))
    {
      tfa.a();
      paramInt2 = tfa.b();
      WSPublicAccReport.getInstance().reportDownload(tfa.a(), paramInt2, 3, 2, 0);
      tlo.d("WeishiDownloadUtil", "qzone  errorCode:" + paramInt1 + ", errorMsg: " + paramString);
      tfa.a(paramDownloadInfo, paramInt1);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    tfa.a();
    tlo.a("WeishiDownloadUtil", "qzone onDownloadFinish~~~");
    int i = tfa.a();
    int j = tfa.b();
    if (j != 3)
    {
      tlo.c("WeishiDownloadUtil", "onDownloadFinish return!qzone只有主动下载");
      return;
    }
    if (!tfa.b())
    {
      tlo.d("WeishiDownloadUtil", "这是Qzone的监听器，不响应qq onDownloadFinish eventId:" + i + ",eventType:" + j);
      return;
    }
    tfa.a(paramDownloadInfo, i, j, "Qzone");
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadPause(paramDownloadInfo);
    tlo.d("WeishiDownloadUtil", "qzone onDownloadPause info = " + paramDownloadInfo);
    if (tfa.a(paramDownloadInfo)) {
      tfa.a();
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    super.onDownloadUpdate(paramList);
    if (!tfa.b()) {}
    while ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadWait(paramDownloadInfo);
    tlo.d("WeishiDownloadUtil", "qzone onDownloadWait info = " + paramDownloadInfo);
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    super.packageReplaced(paramString1, paramString2);
    tlo.d("WeishiDownloadUtil", "qzone packageReplaced appid = " + paramString1 + ", packageName = " + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tfc
 * JD-Core Version:    0.7.0.1
 */