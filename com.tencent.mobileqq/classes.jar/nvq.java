import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

class nvq
  implements View.OnClickListener
{
  nvq(nvp paramnvp) {}
  
  public void onClick(View paramView)
  {
    ((Activity)paramView.getContext()).onBackPressed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nvq
 * JD-Core Version:    0.7.0.1
 */