import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall.OnVideoPluginInstallListener;

public class mip
  implements Handler.Callback
{
  public mip(VideoPluginInstall paramVideoPluginInstall) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        do
        {
          return true;
          VideoPluginInstall.a(this.a, false);
          VideoPluginInstall.a(this.a).removeMessages(0);
        } while (VideoPluginInstall.a(this.a) == null);
        VideoPluginInstall.a(this.a).c(true);
        return true;
        VideoPluginInstall.a(this.a, false);
        VideoPluginInstall.a(this.a).removeMessages(1);
      } while (VideoPluginInstall.a(this.a) == null);
      VideoPluginInstall.a(this.a).c(false);
      return true;
    }
    VideoPluginInstall.a(this.a, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mip
 * JD-Core Version:    0.7.0.1
 */