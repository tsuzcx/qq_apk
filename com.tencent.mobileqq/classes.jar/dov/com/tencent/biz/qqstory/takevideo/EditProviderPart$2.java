package dov.com.tencent.biz.qqstory.takevideo;

import android.view.View;
import android.view.ViewTreeObserver;
import bjtx;
import bjtz;
import bjxn;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class EditProviderPart$2
  implements Runnable
{
  public EditProviderPart$2(bjtx parambjtx, List paramList) {}
  
  public void run()
  {
    if (bjtx.a(this.this$0) != 0) {
      if (QLog.isColorLevel()) {
        QLog.e("EditProviderPart", 2, "EditVideoState is not idle");
      }
    }
    do
    {
      return;
      if ((this.this$0.jdField_a_of_type_Bjyv != null) && (bjtx.a(this.this$0) != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EditProviderPart", 2, "initTransitionRecommendView postDelayed null");
    return;
    this.this$0.jdField_a_of_type_Bjxn.a(41);
    bjtx.a(this.this$0).setVisibility(0);
    bjtx.a(this.this$0).getViewTreeObserver().addOnGlobalLayoutListener(new bjtz(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditProviderPart.2
 * JD-Core Version:    0.7.0.1
 */