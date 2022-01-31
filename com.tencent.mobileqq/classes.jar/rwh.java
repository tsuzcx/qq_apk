import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.biz.pubaccount.util.monitor.FPSSuspendedBall;

public class rwh
  implements View.OnTouchListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  
  private rwh(FPSSuspendedBall paramFPSSuspendedBall) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      this.jdField_a_of_type_Int = FPSSuspendedBall.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorFPSSuspendedBall).x;
      this.jdField_b_of_type_Int = FPSSuspendedBall.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorFPSSuspendedBall).y;
      this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
      this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
      continue;
      FPSSuspendedBall.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorFPSSuspendedBall).x = (this.jdField_a_of_type_Int + (int)(this.jdField_a_of_type_Float - paramMotionEvent.getRawX()));
      FPSSuspendedBall.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorFPSSuspendedBall).y = (this.jdField_b_of_type_Int + (int)(paramMotionEvent.getRawY() - this.jdField_b_of_type_Float));
      FPSSuspendedBall.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorFPSSuspendedBall).updateViewLayout(paramView, FPSSuspendedBall.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilMonitorFPSSuspendedBall));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rwh
 * JD-Core Version:    0.7.0.1
 */