import android.os.Handler;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class qxz
  implements View.OnAttachStateChangeListener
{
  qxz(qxx paramqxx, osm paramosm) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    osj.a().a(this.jdField_a_of_type_Osm);
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    osj.a().b(this.jdField_a_of_type_Osm);
    this.jdField_a_of_type_Qxx.a.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qxz
 * JD-Core Version:    0.7.0.1
 */