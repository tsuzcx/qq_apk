import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.av.ui.VideoInviteLock;
import com.tencent.mobileqq.utils.NetworkUtil;

public class kci
  implements Runnable
{
  public kci(VideoInviteLock paramVideoInviteLock) {}
  
  public void run()
  {
    if ((this.a.a == null) || (this.a.c == null)) {}
    do
    {
      do
      {
        return;
        this.a.a.setVisibility(8);
        this.a.c.setVisibility(8);
        if ((NetworkUtil.h(VideoInviteLock.a(this.a))) || (NetworkUtil.f(VideoInviteLock.b(this.a)))) {
          break;
        }
        if (NetworkUtil.b(VideoInviteLock.c(this.a)))
        {
          this.a.c.setVisibility(0);
          this.a.c.setText(2131429061);
        }
      } while (!NetworkUtil.c(VideoInviteLock.d(this.a)));
      this.a.c.setVisibility(0);
      this.a.c.setText(2131429060);
      return;
    } while (!this.a.b);
    this.a.c.setVisibility(0);
    this.a.c.setText(2131428690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kci
 * JD-Core Version:    0.7.0.1
 */