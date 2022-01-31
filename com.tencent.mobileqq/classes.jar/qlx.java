import android.os.Handler;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class qlx
  implements View.OnAttachStateChangeListener
{
  qlx(qlv paramqlv, ohe paramohe) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    ohb.a().a(this.jdField_a_of_type_Ohe);
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    ohb.a().b(this.jdField_a_of_type_Ohe);
    this.jdField_a_of_type_Qlv.a.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qlx
 * JD-Core Version:    0.7.0.1
 */