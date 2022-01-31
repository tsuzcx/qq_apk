import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.screenshare.floatingwindow.ScreenShareFloatingRelativeLayout;

public class lyl
  implements View.OnTouchListener
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int = 0;
  float jdField_b_of_type_Float = 0.0F;
  int jdField_b_of_type_Int = 0;
  
  public lyl(ScreenShareFloatingRelativeLayout paramScreenShareFloatingRelativeLayout) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int j = 0;
    paramView = ScreenShareFloatingRelativeLayout.a(this.jdField_a_of_type_ComTencentAvScreenshareFloatingwindowScreenShareFloatingRelativeLayout).a();
    switch (paramMotionEvent.getAction())
    {
    }
    int i;
    label255:
    do
    {
      return true;
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      this.jdField_a_of_type_Int = paramView.x;
      this.jdField_b_of_type_Int = paramView.y;
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      float f3 = paramView.x;
      paramView.x = ((int)((f1 - this.jdField_a_of_type_Float) / 3.0F + f3));
      paramView.y = ((int)(paramView.y + (f2 - this.jdField_b_of_type_Float) / 3.0F));
      int m = ScreenShareFloatingRelativeLayout.a(this.jdField_a_of_type_ComTencentAvScreenshareFloatingwindowScreenShareFloatingRelativeLayout) - this.jdField_a_of_type_ComTencentAvScreenshareFloatingwindowScreenShareFloatingRelativeLayout.getWidth();
      int k = ScreenShareFloatingRelativeLayout.b(this.jdField_a_of_type_ComTencentAvScreenshareFloatingwindowScreenShareFloatingRelativeLayout) - this.jdField_a_of_type_ComTencentAvScreenshareFloatingwindowScreenShareFloatingRelativeLayout.getHeight();
      if (paramView.x <= 0)
      {
        i = 0;
        paramView.x = i;
        if (paramView.y > 0) {
          break label255;
        }
        i = j;
      }
      for (;;)
      {
        paramView.y = i;
        ScreenShareFloatingRelativeLayout.a(this.jdField_a_of_type_ComTencentAvScreenshareFloatingwindowScreenShareFloatingRelativeLayout).a(this.jdField_a_of_type_ComTencentAvScreenshareFloatingwindowScreenShareFloatingRelativeLayout, paramView.x, paramView.y);
        return true;
        i = m;
        if (paramView.x > m) {
          break;
        }
        i = paramView.x;
        break;
        if (paramView.y > k) {
          i = k;
        } else {
          i = paramView.y;
        }
      }
      i = paramView.x;
      j = paramView.y;
    } while ((Math.abs(i - this.jdField_a_of_type_Int) > 20) || (Math.abs(j - this.jdField_b_of_type_Int) > 20));
    ScreenShareFloatingRelativeLayout.a(this.jdField_a_of_type_ComTencentAvScreenshareFloatingwindowScreenShareFloatingRelativeLayout).a(1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lyl
 * JD-Core Version:    0.7.0.1
 */