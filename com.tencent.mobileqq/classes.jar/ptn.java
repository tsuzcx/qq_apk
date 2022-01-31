import android.view.View;
import android.view.View.OnClickListener;

class ptn
  implements View.OnClickListener
{
  ptn(ptm paramptm) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if (ptm.a(this.a) != null) {
      ptm.a(this.a).a(paramView, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ptn
 * JD-Core Version:    0.7.0.1
 */