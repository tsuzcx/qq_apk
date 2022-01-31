import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.qphone.base.util.QLog;

public class mre
  implements View.OnTouchListener
{
  public mre(GuideHelper paramGuideHelper, long paramLong) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    QLog.w("GuideHelper", 1, "onTouch to hide, seq[" + this.jdField_a_of_type_Long + "]");
    GuideHelper.a(this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper, this.jdField_a_of_type_Long);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mre
 * JD-Core Version:    0.7.0.1
 */