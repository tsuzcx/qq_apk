import android.view.View;
import android.view.View.OnClickListener;

class qfl
  implements View.OnClickListener
{
  qfl(qfk paramqfk) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if (qfk.a(this.a) != null) {
      qfk.a(this.a).a(paramView, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qfl
 * JD-Core Version:    0.7.0.1
 */