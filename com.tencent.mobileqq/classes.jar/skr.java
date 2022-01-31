import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;

final class skr
  extends skp
{
  public void installSucceed(String paramString1, String paramString2)
  {
    super.installSucceed(paramString1, paramString2);
    if (skq.b()) {
      return;
    }
    skq.a(paramString1, paramString2, true);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    sne.c("WeishiDownloadUtil", "qq onDownloadCancel info = " + paramDownloadInfo);
    if (skq.a(paramDownloadInfo))
    {
      skq.a();
      int i = skq.b();
      WSPublicAccReport.getInstance().reportDownload(skq.a(), i, 3, 2, 0);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    sne.d("WeishiDownloadUtil", "qq onDownloadError info = " + paramDownloadInfo);
    if (skq.a(paramDownloadInfo))
    {
      skq.a();
      paramInt2 = skq.b();
      WSPublicAccReport.getInstance().reportDownload(skq.a(), paramInt2, 3, 2, 0);
      sne.d("WeishiDownloadUtil", " errorCode:" + paramInt1 + ", errorMsg: " + paramString);
      skq.a(paramDownloadInfo, paramInt1);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    skq.a();
    int i = skq.a();
    int j = skq.b();
    if (skq.b())
    {
      if (skq.d()) {
        sne.d("WeishiDownloadUtil", "这是预下载中点击操作，qq监听器响应");
      }
    }
    else
    {
      skq.a(paramDownloadInfo, i, j, "QQ");
      return;
    }
    sne.d("WeishiDownloadUtil", "这是qq的监听器，不响应qzone. onDownloadFinish eventId:" + i + ",eventType:" + j);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadPause(paramDownloadInfo);
    sne.d("WeishiDownloadUtil", "qq onDownloadPause info = " + paramDownloadInfo);
    if (skq.a(paramDownloadInfo)) {
      skq.a();
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
        sne.c("WeishiDownloadUtil", "qq onDownloadUpdate progress = " + localDownloadInfo.f + ", url = " + localDownloadInfo.d);
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadWait(paramDownloadInfo);
    sne.d("WeishiDownloadUtil", "qq onDownloadWait info = " + paramDownloadInfo);
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    super.packageReplaced(paramString1, paramString2);
    sne.d("WeishiDownloadUtil", "qq packageReplaced appid = " + paramString1 + ", packageName = " + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     skr
 * JD-Core Version:    0.7.0.1
 */