import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoLayerUI;

public class kee
  implements Runnable
{
  private kee(VideoLayerUI paramVideoLayerUI) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.a().removeCallbacks(VideoLayerUI.b(this.a));
    }
    VideoLayerUI.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kee
 * JD-Core Version:    0.7.0.1
 */