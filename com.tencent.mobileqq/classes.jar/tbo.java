import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class tbo
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    ((ViewGroup)paramView.getParent()).performClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tbo
 * JD-Core Version:    0.7.0.1
 */