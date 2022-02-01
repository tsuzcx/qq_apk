package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class VideoFeedsUGDownloadListener
  implements DownloadListener
{
  private HashMap<String, VideoFeedsUGDownloadListener.UGClickData> a = new HashMap();
  
  public void a(String paramString, VideoFeedsUGDownloadListener.UGClickData paramUGClickData)
  {
    this.a.remove(paramString);
    this.a.put(paramString, paramUGClickData);
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    ThreadManager.getUIHandler().postDelayed(new VideoFeedsUGDownloadListener.2(this, paramString2), 1000L);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2) {}
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getUIHandler().post(new VideoFeedsUGDownloadListener.1(this, paramDownloadInfo));
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadUpdate(List<DownloadInfo> paramList) {}
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo) {}
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsUGDownloadListener
 * JD-Core Version:    0.7.0.1
 */