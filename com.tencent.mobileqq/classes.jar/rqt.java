import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

public class rqt
  implements Runnable
{
  public rqt(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "hor anim onAnimationEnd() is called,time is:" + System.currentTimeMillis());
    }
    int i;
    if (this.a.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout != null)
    {
      i = 0;
      while (i < this.a.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout.length)
      {
        if (this.a.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout[i] != null) {
          this.a.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout[i].setVisibility(8);
        }
        i += 1;
      }
    }
    if (this.a.jdField_a_of_type_ArrayOfAndroidViewView != null)
    {
      i = 0;
      while (i < this.a.jdField_a_of_type_ArrayOfAndroidViewView.length)
      {
        if (this.a.jdField_a_of_type_ArrayOfAndroidViewView[i] != null) {
          this.a.jdField_a_of_type_ArrayOfAndroidViewView[i].setVisibility(0);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rqt
 * JD-Core Version:    0.7.0.1
 */