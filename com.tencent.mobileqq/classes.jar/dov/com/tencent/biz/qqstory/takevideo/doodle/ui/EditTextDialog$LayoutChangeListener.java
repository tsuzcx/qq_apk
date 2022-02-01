package dov.com.tencent.biz.qqstory.takevideo.doodle.ui;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import mqq.os.MqqHandler;

class EditTextDialog$LayoutChangeListener
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private EditTextDialog$LayoutChangeListener(EditTextDialog paramEditTextDialog) {}
  
  public void onGlobalLayout()
  {
    int i = this.a.jdField_a_of_type_AndroidViewView.getBottom();
    if (QLog.isColorLevel()) {
      QLog.i("EditTextDialog", 2, "onGlobalLayout third bottom:" + i + " last:" + this.a.b);
    }
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout != null)
    {
      int[] arrayOfInt = new int[2];
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.getLocationOnScreen(arrayOfInt);
      int j = arrayOfInt[1];
      int k = j - AIOUtils.a(62.0F, BaseApplicationImpl.getContext().getResources());
      if (k < EditTextDialog.b(this.a)) {
        EditTextDialog.b(this.a, k);
      }
      if (QLog.isColorLevel()) {
        QLog.d("EditTextDialog", 2, "max height" + k + "preViewTextMaxHeight" + EditTextDialog.b(this.a) + "y" + j);
      }
    }
    if (i - this.a.b > this.a.jdField_a_of_type_Int)
    {
      this.a.a(false);
      if (this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) {
        this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.d = false;
      }
      return;
    }
    this.a.jdField_a_of_type_MqqOsMqqHandler.post(new EditTextDialog.LayoutChangeListener.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.LayoutChangeListener
 * JD-Core Version:    0.7.0.1
 */