import android.os.Handler;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class omt
  implements View.OnAttachStateChangeListener
{
  omt(oms paramoms, ond paramond) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    if ((this.jdField_a_of_type_Oms.a().a() != null) && (this.jdField_a_of_type_Oms.a().a().a() != null)) {
      this.jdField_a_of_type_Oms.a().a().a().b(this.jdField_a_of_type_Ond);
    }
    ohb.a().a(this.jdField_a_of_type_Ond.a);
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if ((this.jdField_a_of_type_Oms.a().a() != null) && (this.jdField_a_of_type_Oms.a().a().a() != null)) {
      this.jdField_a_of_type_Oms.a().a().a().c(this.jdField_a_of_type_Ond);
    }
    ohb.a().b(this.jdField_a_of_type_Ond.a);
    if ((this.jdField_a_of_type_Ond instanceof omz)) {
      ((omz)this.jdField_a_of_type_Ond).a.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     omt
 * JD-Core Version:    0.7.0.1
 */