import android.view.View;
import android.view.View.OnClickListener;

class qfi
  implements View.OnClickListener
{
  qfi(qfh paramqfh) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if (qfh.a(this.a) != null) {
      qfh.a(this.a).a(paramView, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qfi
 * JD-Core Version:    0.7.0.1
 */