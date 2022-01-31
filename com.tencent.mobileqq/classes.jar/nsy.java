import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import com.tencent.qphone.base.util.QLog;

public class nsy
  implements View.OnTouchListener
{
  private static int jdField_a_of_type_Int = 10;
  private float jdField_a_of_type_Float;
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int;
  
  public nsy(int paramInt, View paramView)
  {
    this.jdField_b_of_type_Int = paramInt;
    jdField_a_of_type_Int = actn.a(5.0F, paramView.getResources());
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_b_of_type_Int == 0) && (oot.b()) && (oot.a()))
    {
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
      switch (paramMotionEvent.getAction())
      {
      default: 
      case 0: 
      case 2: 
        do
        {
          do
          {
            return true;
            this.jdField_a_of_type_Float = paramMotionEvent.getX();
            this.jdField_b_of_type_Float = paramMotionEvent.getY();
            return true;
            f1 = paramMotionEvent.getX() - this.jdField_a_of_type_Float;
            f2 = paramMotionEvent.getY() - this.jdField_b_of_type_Float;
          } while ((Math.abs(f1) > jdField_a_of_type_Int) && (Math.abs(f1) >= Math.abs(f2)));
          if ((Math.abs(f1) < Math.abs(f2)) && (-f2 > jdField_a_of_type_Int))
          {
            osm.a().n();
            this.jdField_a_of_type_Boolean = false;
            return false;
          }
        } while ((Math.abs(f1) >= Math.abs(f2)) || (f2 <= jdField_a_of_type_Int));
        this.jdField_a_of_type_Boolean = false;
        return false;
      }
      float f1 = paramMotionEvent.getX();
      float f2 = this.jdField_a_of_type_Float;
      float f3 = paramMotionEvent.getY();
      float f4 = this.jdField_b_of_type_Float;
      if ((Math.abs(f1 - f2) < jdField_a_of_type_Int) && (Math.abs(f3 - f4) < jdField_a_of_type_Int)) {
        this.jdField_a_of_type_Boolean = false;
      }
      paramView.getParent().requestDisallowInterceptTouchEvent(false);
      QLog.d("IconTabController", 1, "event : " + paramMotionEvent.getAction() + "  returnByCancleUp:" + this.jdField_a_of_type_Boolean);
      return this.jdField_a_of_type_Boolean;
    }
    if (oot.a())
    {
      osm.a().n();
      paramView.getParent().requestDisallowInterceptTouchEvent(false);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsy
 * JD-Core Version:    0.7.0.1
 */