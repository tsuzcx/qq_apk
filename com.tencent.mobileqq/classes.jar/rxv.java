import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;

final class rxv
  extends rxt
{
  public void installSucceed(String paramString1, String paramString2)
  {
    super.installSucceed(paramString1, paramString2);
    if (rxu.b()) {
      return;
    }
    rxu.a(paramString1, paramString2, true);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    sai.c("WeishiDownloadUtil", "qq onDownloadCancel info = " + paramDownloadInfo);
    if (rxu.a(paramDownloadInfo))
    {
      rxu.a();
      int i = rxu.b();
      WSPublicAccReport.getInstance().reportDownload(rxu.a(), i, 3, 2, 0);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    sai.d("WeishiDownloadUtil", "qq onDownloadError info = " + paramDownloadInfo);
    if (rxu.a(paramDownloadInfo))
    {
      rxu.a();
      paramInt2 = rxu.b();
      WSPublicAccReport.getInstance().reportDownload(rxu.a(), paramInt2, 3, 2, 0);
      sai.d("WeishiDownloadUtil", " errorCode:" + paramInt1 + ", errorMsg: " + paramString);
      rxu.a(paramDownloadInfo, paramInt1);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    rxu.a();
    int i = rxu.a();
    int j = rxu.b();
    if (rxu.b())
    {
      if (rxu.d()) {
        sai.d("WeishiDownloadUtil", "这是预下载中点击操作，qq监听器响应");
      }
    }
    else
    {
      rxu.a(paramDownloadInfo, i, j, "QQ");
      return;
    }
    sai.d("WeishiDownloadUtil", "这是qq的监听器，不响应qzone. onDownloadFinish eventId:" + i + ",eventType:" + j);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadPause(paramDownloadInfo);
    sai.d("WeishiDownloadUtil", "qq onDownloadPause info = " + paramDownloadInfo);
    if (rxu.a(paramDownloadInfo)) {
      rxu.a();
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
        sai.c("WeishiDownloadUtil", "qq onDownloadUpdate progress = " + localDownloadInfo.f + ", url = " + localDownloadInfo.d);
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    super.onDownloadWait(paramDownloadInfo);
    sai.d("WeishiDownloadUtil", "qq onDownloadWait info = " + paramDownloadInfo);
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    super.packageReplaced(paramString1, paramString2);
    sai.d("WeishiDownloadUtil", "qq packageReplaced appid = " + paramString1 + ", packageName = " + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rxv
 * JD-Core Version:    0.7.0.1
 */