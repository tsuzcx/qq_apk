import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;

final class tfb
  extends tez
{
  public void installSucceed(String paramString1, String paramString2)
  {
    super.installSucceed(paramString1, paramString2);
    if (tfa.b()) {
      return;
    }
    tfa.a(paramString1, paramString2, true);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    tlo.c("WeishiDownloadUtil", "qq onDownloadCancel info = " + paramDownloadInfo);
    if (tfa.a(paramDownloadInfo))
    {
      tfa.a();
      int i = tfa.b();
      WSPublicAccReport.getInstance().reportDownload(tfa.a(), i, 3, 2, 0);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    tlo.d("WeishiDownloadUtil", "qq onDownloadError info = " + paramDownloadInfo);
    if (tfa.a(paramDownloadInfo))
    {
      tfa.a();
      paramInt2 = tfa.b();
      WSPublicAccReport.getInstance().reportDownload(tfa.a(), paramInt2, 3, 2, 0);
      tlo.d("WeishiDownloadUtil", " errorCode:" + paramInt1 + ", errorMsg: " + paramString);
      tfa.a(paramDownloadInfo, paramInt1);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    tfa.a();
    int i = tfa.a();
    int j = tfa.b();
    if (tfa.b())
    {
      if (tfa.d()) {
        tlo.d("WeishiDownloadUtil", "这是预下载中点击操作，qq监听器响应");
      }
    }
    else
    {
      tfa.a(paramDownloadInfo, i, j, "QQ");
      return;
    }
    tlo.d("WeishiDownloadUtil", "这是qq的监听器，不响应qzone. onDownloadFinish eventId:" + i + ",eventType:" + j);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadPause(paramDownloadInfo);
    tlo.d("WeishiDownloadUtil", "qq onDownloadPause info = " + paramDownloadInfo);
    if (tfa.a(paramDownloadInfo)) {
      tfa.a();
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    super.onDownloadUpdate(paramList);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        tlo.c("WeishiDownloadUtil", "qq onDownloadUpdate progress = " + localDownloadInfo.f + ", url = " + localDownloadInfo.d);
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadWait(paramDownloadInfo);
    tlo.d("WeishiDownloadUtil", "qq onDownloadWait info = " + paramDownloadInfo);
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    super.packageReplaced(paramString1, paramString2);
    tlo.d("WeishiDownloadUtil", "qq packageReplaced appid = " + paramString1 + ", packageName = " + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tfb
 * JD-Core Version:    0.7.0.1
 */