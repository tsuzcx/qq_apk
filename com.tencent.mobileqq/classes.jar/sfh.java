import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.PreDownloadNotAlreadyVideoTask;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class sfh
  implements siu
{
  public sfh(VideoPreDownloadMgr paramVideoPreDownloadMgr) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i(VideoPreDownloadMgr.a(), 2, "预下载回调 vid:" + VideoPreDownloadMgr.a(this.a) + " SUCCESS");
    }
    ThreadManager.post(new VideoPreDownloadMgr.PreDownloadNotAlreadyVideoTask(this.a, true), 5, null, true);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i(VideoPreDownloadMgr.a(), 2, "预下载回调 vid:" + VideoPreDownloadMgr.a(this.a));
    }
    ThreadManager.post(new VideoPreDownloadMgr.PreDownloadNotAlreadyVideoTask(this.a, false), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sfh
 * JD-Core Version:    0.7.0.1
 */