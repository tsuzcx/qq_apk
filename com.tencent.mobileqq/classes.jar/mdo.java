import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.qphone.base.util.QLog;

public class mdo
  implements View.OnTouchListener
{
  public mdo(GuideHelper paramGuideHelper, long paramLong) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    QLog.w("GuideHelper", 1, "onTouch to hide, seq[" + this.jdField_a_of_type_Long + "]");
    GuideHelper.a(this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper, this.jdField_a_of_type_Long);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mdo
 * JD-Core Version:    0.7.0.1
 */