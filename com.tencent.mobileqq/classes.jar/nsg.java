import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

class nsg
  implements View.OnClickListener
{
  nsg(nsf paramnsf) {}
  
  public void onClick(View paramView)
  {
    ((Activity)paramView.getContext()).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsg
 * JD-Core Version:    0.7.0.1
 */