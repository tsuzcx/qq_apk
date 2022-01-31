import android.os.Handler;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class qmo
  implements View.OnAttachStateChangeListener
{
  qmo(qmm paramqmm, osp paramosp) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    osm.a().a(this.jdField_a_of_type_Osp);
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    osm.a().b(this.jdField_a_of_type_Osp);
    this.jdField_a_of_type_Qmm.a.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qmo
 * JD-Core Version:    0.7.0.1
 */