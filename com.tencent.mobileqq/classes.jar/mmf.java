import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

class mmf
  implements View.OnClickListener
{
  mmf(mmb parammmb) {}
  
  public void onClick(View paramView)
  {
    if ((mmb.a(this.a) != null) && (mmb.a(this.a).isShown()))
    {
      this.a.e();
      return;
    }
    mmb.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mmf
 * JD-Core Version:    0.7.0.1
 */