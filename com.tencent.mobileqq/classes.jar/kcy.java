import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoControlUI;

public class kcy
  implements Runnable
{
  public kcy(VideoControlUI paramVideoControlUI) {}
  
  public void run()
  {
    this.a.a.a(new Object[] { Integer.valueOf(102) });
    if (!this.a.n) {
      return;
    }
    if (this.a.v > 5) {
      this.a.v = 5;
    }
    if (this.a.v < 0) {
      this.a.v = 0;
    }
    VideoControlUI localVideoControlUI;
    if (this.a.i) {
      localVideoControlUI = this.a;
    }
    for (localVideoControlUI.v += 1;; localVideoControlUI.v -= 1)
    {
      this.a.a.a().postDelayed(this, VideoControlUI.a(this.a));
      return;
      localVideoControlUI = this.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kcy
 * JD-Core Version:    0.7.0.1
 */