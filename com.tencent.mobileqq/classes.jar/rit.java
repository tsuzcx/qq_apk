import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGDownloadListener.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGDownloadListener.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class rit
  implements bfoj
{
  private HashMap<String, riu> a = new HashMap();
  
  public void a(String paramString, riu paramriu)
  {
    if (this.a.containsKey(paramString)) {
      this.a.remove(paramString);
    }
    this.a.put(paramString, paramriu);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rit
 * JD-Core Version:    0.7.0.1
 */