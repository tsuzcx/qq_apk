import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;

public class mff
  implements TVK_ICacheMgr.IPreloadCallback
{
  public mff(VideoPreDownloadMgr paramVideoPreDownloadMgr) {}
  
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(VideoPreDownloadMgr.a(), 2, "预下载回调 vid:" + VideoPreDownloadMgr.a(this.a) + " ERROR code: " + paramInt);
    }
    ThreadManager.post(new mfi(this.a, false), 5, null, true);
  }
  
  public void onPreLoadSucess(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(VideoPreDownloadMgr.a(), 2, "预下载回调 vid:" + VideoPreDownloadMgr.a(this.a) + " SUCCESS");
    }
    ThreadManager.post(new mfi(this.a, true), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mff
 * JD-Core Version:    0.7.0.1
 */