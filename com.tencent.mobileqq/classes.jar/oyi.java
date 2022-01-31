import android.os.Handler;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class oyi
  implements View.OnAttachStateChangeListener
{
  oyi(oyh paramoyh, oys paramoys) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    if ((this.jdField_a_of_type_Oyh.a().a() != null) && (this.jdField_a_of_type_Oyh.a().a().a() != null)) {
      this.jdField_a_of_type_Oyh.a().a().a().b(this.jdField_a_of_type_Oys);
    }
    osm.a().a(this.jdField_a_of_type_Oys.a);
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if ((this.jdField_a_of_type_Oyh.a().a() != null) && (this.jdField_a_of_type_Oyh.a().a().a() != null)) {
      this.jdField_a_of_type_Oyh.a().a().a().c(this.jdField_a_of_type_Oys);
    }
    osm.a().b(this.jdField_a_of_type_Oys.a);
    if ((this.jdField_a_of_type_Oys instanceof oyo)) {
      ((oyo)this.jdField_a_of_type_Oys).a.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyi
 * JD-Core Version:    0.7.0.1
 */