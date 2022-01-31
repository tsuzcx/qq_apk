import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;

public class mlv
  implements View.OnClickListener
{
  public mlv(VideoControlUI paramVideoControlUI) {}
  
  public void onClick(View paramView)
  {
    mtq.c(paramView.getId());
    AVActivity localAVActivity = this.a.a();
    if (localAVActivity != null) {
      localAVActivity.BtnOnClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mlv
 * JD-Core Version:    0.7.0.1
 */