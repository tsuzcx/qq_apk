package dov.com.tencent.biz.qqstory.takevideo.doodle.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class EditTextDialog$InitialLayoutListener
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private EditTextDialog$InitialLayoutListener(EditTextDialog paramEditTextDialog) {}
  
  public void onGlobalLayout()
  {
    int i = this.a.jdField_a_of_type_AndroidViewView.getBottom();
    if (this.a.b < 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EditTextDialog", 2, "onGlobalLayout first bottom:" + i);
      }
      this.a.b = i;
      this.a.jdField_a_of_type_MqqOsMqqHandler.post(new EditTextDialog.InitialLayoutListener.1(this));
    }
    while (this.a.b - i <= this.a.jdField_a_of_type_Int) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("EditTextDialog", 2, "onGlobalLayout second bottom:" + i);
    }
    this.a.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.a.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(this.a.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    this.a.b = i;
    this.a.jdField_a_of_type_AndroidViewViewGroup.requestLayout();
    this.a.jdField_a_of_type_MqqOsMqqHandler.post(new EditTextDialog.InitialLayoutListener.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.InitialLayoutListener
 * JD-Core Version:    0.7.0.1
 */