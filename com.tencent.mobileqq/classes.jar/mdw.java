import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

public class mdw
  implements Runnable
{
  public mdw(VideoPluginInstall paramVideoPluginInstall) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "start install video sdk in subThread");
    }
    try
    {
      if (VideoPluginInstall.a(this.a) != null) {
        TVK_SDKMgr.installPlugin(VideoPluginInstall.a(this.a), new mdy(VideoPluginInstall.a(this.a)));
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.readinjoy.video", 2, "TVK_SDKMgr.installPlugin ERROR e=" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mdw
 * JD-Core Version:    0.7.0.1
 */