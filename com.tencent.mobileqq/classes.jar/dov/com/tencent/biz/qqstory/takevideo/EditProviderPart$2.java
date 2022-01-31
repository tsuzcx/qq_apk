package dov.com.tencent.biz.qqstory.takevideo;

import android.view.View;
import android.view.ViewTreeObserver;
import bicj;
import bicl;
import bigb;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class EditProviderPart$2
  implements Runnable
{
  public EditProviderPart$2(bicj parambicj, List paramList) {}
  
  public void run()
  {
    if (bicj.a(this.this$0) != 0) {
      if (QLog.isColorLevel()) {
        QLog.e("EditProviderPart", 2, "EditVideoState is not idle");
      }
    }
    do
    {
      return;
      if ((this.this$0.jdField_a_of_type_Bihj != null) && (bicj.a(this.this$0) != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EditProviderPart", 2, "initTransitionRecommendView postDelayed null");
    return;
    this.this$0.jdField_a_of_type_Bigb.a(41);
    bicj.a(this.this$0).setVisibility(0);
    bicj.a(this.this$0).getViewTreeObserver().addOnGlobalLayoutListener(new bicl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditProviderPart.2
 * JD-Core Version:    0.7.0.1
 */