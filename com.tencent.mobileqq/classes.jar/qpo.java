import android.view.View;
import android.view.View.OnClickListener;

class qpo
  implements View.OnClickListener
{
  qpo(qpn paramqpn) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if (qpn.a(this.a) != null) {
      qpn.a(this.a).a(paramView, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qpo
 * JD-Core Version:    0.7.0.1
 */