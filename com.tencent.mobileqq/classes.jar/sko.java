import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;

final class sko
  extends skm
{
  public void installSucceed(String paramString1, String paramString2)
  {
    super.installSucceed(paramString1, paramString2);
    if (skn.b()) {
      return;
    }
    skn.a(paramString1, paramString2, true);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    snb.c("WeishiDownloadUtil", "qq onDownloadCancel info = " + paramDownloadInfo);
    if (skn.a(paramDownloadInfo))
    {
      skn.a();
      int i = skn.b();
      WSPublicAccReport.getInstance().reportDownload(skn.a(), i, 3, 2, 0);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    snb.d("WeishiDownloadUtil", "qq onDownloadError info = " + paramDownloadInfo);
    if (skn.a(paramDownloadInfo))
    {
      skn.a();
      paramInt2 = skn.b();
      WSPublicAccReport.getInstance().reportDownload(skn.a(), paramInt2, 3, 2, 0);
      snb.d("WeishiDownloadUtil", " errorCode:" + paramInt1 + ", errorMsg: " + paramString);
      skn.a(paramDownloadInfo, paramInt1);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    skn.a();
    int i = skn.a();
    int j = skn.b();
    if (skn.b())
    {
      if (skn.d()) {
        snb.d("WeishiDownloadUtil", "这是预下载中点击操作，qq监听器响应");
      }
    }
    else
    {
      skn.a(paramDownloadInfo, i, j, "QQ");
      return;
    }
    snb.d("WeishiDownloadUtil", "这是qq的监听器，不响应qzone. onDownloadFinish eventId:" + i + ",eventType:" + j);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadPause(paramDownloadInfo);
    snb.d("WeishiDownloadUtil", "qq onDownloadPause info = " + paramDownloadInfo);
    if (skn.a(paramDownloadInfo)) {
      skn.a();
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
        snb.c("WeishiDownloadUtil", "qq onDownloadUpdate progress = " + localDownloadInfo.f + ", url = " + localDownloadInfo.d);
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadWait(paramDownloadInfo);
    snb.d("WeishiDownloadUtil", "qq onDownloadWait info = " + paramDownloadInfo);
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    super.packageReplaced(paramString1, paramString2);
    snb.d("WeishiDownloadUtil", "qq packageReplaced appid = " + paramString1 + ", packageName = " + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sko
 * JD-Core Version:    0.7.0.1
 */