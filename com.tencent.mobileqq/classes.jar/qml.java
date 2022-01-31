import android.os.Handler;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class qml
  implements View.OnAttachStateChangeListener
{
  qml(qmj paramqmj, osm paramosm) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    osj.a().a(this.jdField_a_of_type_Osm);
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    osj.a().b(this.jdField_a_of_type_Osm);
    this.jdField_a_of_type_Qmj.a.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qml
 * JD-Core Version:    0.7.0.1
 */