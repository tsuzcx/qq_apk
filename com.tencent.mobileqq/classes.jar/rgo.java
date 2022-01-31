import android.view.View;
import android.view.View.OnClickListener;

class rgo
  implements View.OnClickListener
{
  rgo(rgn paramrgn) {}
  
  public void onClick(View paramView)
  {
    rgn.a(true, -1, rgn.a(this.a));
    if (rgn.a(this.a) != null) {
      rgn.a(this.a).onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rgo
 * JD-Core Version:    0.7.0.1
 */