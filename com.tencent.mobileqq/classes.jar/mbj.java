import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

class mbj
  implements View.OnClickListener
{
  mbj(mbf parammbf) {}
  
  public void onClick(View paramView)
  {
    if ((mbf.a(this.a) != null) && (mbf.a(this.a).isShown()))
    {
      this.a.e();
      return;
    }
    mbf.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mbj
 * JD-Core Version:    0.7.0.1
 */