package dov.com.tencent.biz.qqstory.takevideo.doodle.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.NormalTextItem;

class EditTextDialog$2
  implements View.OnClickListener
{
  EditTextDialog$2(EditTextDialog paramEditTextDialog) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem != null)
    {
      EditTextDialog.a(this.a, false);
      this.a.a = this.a.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem;
      this.a.a.a(EditTextDialog.a(this.a), this.a.jdField_b_of_type_JavaLangString);
      this.a.a.c(this.a.i);
      if ((this.a.a instanceof NormalTextItem)) {
        ((NormalTextItem)this.a.a).a(this.a.h);
      }
      this.a.a(false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.2
 * JD-Core Version:    0.7.0.1
 */