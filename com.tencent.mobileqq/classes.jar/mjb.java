import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;

public class mjb
  implements View.OnClickListener
{
  public mjb(VideoControlUI paramVideoControlUI) {}
  
  public void onClick(View paramView)
  {
    mqw.c(paramView.getId());
    AVActivity localAVActivity = this.a.a();
    if (localAVActivity != null) {
      localAVActivity.BtnOnClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mjb
 * JD-Core Version:    0.7.0.1
 */