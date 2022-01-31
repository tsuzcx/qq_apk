import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.av.ui.VideoInviteFull;
import com.tencent.mobileqq.utils.NetworkUtil;

public class kce
  implements Runnable
{
  public kce(VideoInviteFull paramVideoInviteFull) {}
  
  public void run()
  {
    if (this.a.a == null) {}
    do
    {
      do
      {
        return;
        this.a.a.setVisibility(8);
        this.a.c.setVisibility(8);
        if ((NetworkUtil.h(VideoInviteFull.a(this.a))) || (NetworkUtil.f(VideoInviteFull.b(this.a)))) {
          break;
        }
        if (NetworkUtil.b(VideoInviteFull.c(this.a)))
        {
          this.a.c.setVisibility(0);
          this.a.c.setText(2131429061);
        }
      } while (!NetworkUtil.c(VideoInviteFull.d(this.a)));
      this.a.c.setVisibility(0);
      this.a.c.setText(2131429060);
      return;
    } while (!this.a.b);
    this.a.c.setVisibility(0);
    this.a.c.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kce
 * JD-Core Version:    0.7.0.1
 */