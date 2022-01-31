import android.os.Handler;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class oyf
  implements View.OnAttachStateChangeListener
{
  oyf(oye paramoye, oyp paramoyp) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    if ((this.jdField_a_of_type_Oye.a().a() != null) && (this.jdField_a_of_type_Oye.a().a().a() != null)) {
      this.jdField_a_of_type_Oye.a().a().a().b(this.jdField_a_of_type_Oyp);
    }
    osj.a().a(this.jdField_a_of_type_Oyp.a);
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if ((this.jdField_a_of_type_Oye.a().a() != null) && (this.jdField_a_of_type_Oye.a().a().a() != null)) {
      this.jdField_a_of_type_Oye.a().a().a().c(this.jdField_a_of_type_Oyp);
    }
    osj.a().b(this.jdField_a_of_type_Oyp.a);
    if ((this.jdField_a_of_type_Oyp instanceof oyl)) {
      ((oyl)this.jdField_a_of_type_Oyp).a.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyf
 * JD-Core Version:    0.7.0.1
 */