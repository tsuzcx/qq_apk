package dov.com.tencent.biz.qqstory.takevideo;

import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class EditProviderPart$2
  implements Runnable
{
  EditProviderPart$2(EditProviderPart paramEditProviderPart, List paramList) {}
  
  public void run()
  {
    if (EditProviderPart.a(this.this$0) != 0) {
      if (QLog.isColorLevel()) {
        QLog.e("EditProviderPart", 2, "EditVideoState is not idle");
      }
    }
    do
    {
      return;
      if ((this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi != null) && (EditProviderPart.a(this.this$0) != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EditProviderPart", 2, "initTransitionRecommendView postDelayed null");
    return;
    this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(18);
    EditProviderPart.a(this.this$0).setVisibility(0);
    EditProviderPart.a(this.this$0).getViewTreeObserver().addOnGlobalLayoutListener(new EditProviderPart.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditProviderPart.2
 * JD-Core Version:    0.7.0.1
 */