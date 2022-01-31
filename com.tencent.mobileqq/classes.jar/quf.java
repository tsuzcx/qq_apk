import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.PreDownloadNotAlreadyVideoTask;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;

public class quf
  implements TVK_ICacheMgr.IPreloadCallback
{
  public quf(VideoPreDownloadMgr paramVideoPreDownloadMgr) {}
  
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(VideoPreDownloadMgr.a(), 2, "预下载回调 vid:" + VideoPreDownloadMgr.a(this.a) + " ERROR code: " + paramInt);
    }
    ThreadManager.post(new VideoPreDownloadMgr.PreDownloadNotAlreadyVideoTask(this.a, false), 5, null, true);
  }
  
  public void onPreLoadSucess(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(VideoPreDownloadMgr.a(), 2, "预下载回调 vid:" + VideoPreDownloadMgr.a(this.a) + " SUCCESS");
    }
    ThreadManager.post(new VideoPreDownloadMgr.PreDownloadNotAlreadyVideoTask(this.a, true), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     quf
 * JD-Core Version:    0.7.0.1
 */