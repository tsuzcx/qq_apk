import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.ui.VideoLayerUI;
import java.util.List;

public class kei
  implements Runnable
{
  private kei(VideoLayerUI paramVideoLayerUI) {}
  
  public void run()
  {
    if (this.a.a == null) {
      return;
    }
    if (VideoLayerUI.a(this.a).size() > 0)
    {
      this.a.a.a().removeCallbacks(VideoLayerUI.a(this.a));
      this.a.a.a().removeCallbacks(VideoLayerUI.b(this.a));
      RecvMsg localRecvMsg = (RecvMsg)VideoLayerUI.a(this.a).remove(0);
      VideoLayerUI.a(this.a, localRecvMsg);
      this.a.a.a().postDelayed(VideoLayerUI.a(this.a), 3000L);
      this.a.a.a().postDelayed(VideoLayerUI.b(this.a), 3000L);
      return;
    }
    this.a.a.a().removeCallbacks(VideoLayerUI.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kei
 * JD-Core Version:    0.7.0.1
 */