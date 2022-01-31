import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.AuthDevEnableCompleteActivity;

public class rnu
  implements View.OnClickListener
{
  public rnu(AuthDevEnableCompleteActivity paramAuthDevEnableCompleteActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (ImageView)paramView.findViewById(2131362767);
    if (paramView != null)
    {
      int i = 0;
      if (paramView.getVisibility() == 0) {
        i = 4;
      }
      paramView.setVisibility(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rnu
 * JD-Core Version:    0.7.0.1
 */