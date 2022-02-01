package dov.com.tencent.biz.qqstory.takevideo.doodle.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.EditTextPreView;
import dov.com.qq.im.capture.text.NormalTextItem;

class EditTextDialog$6
  implements TextWatcher
{
  EditTextDialog$6(EditTextDialog paramEditTextDialog) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog$EditTextDialogEventListener == null) {}
    NormalTextItem localNormalTextItem;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramCharSequence == null);
        EditTextDialog.a(this.a, true);
        if (this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) {
          this.a.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setText(this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b(), paramCharSequence.toString());
        }
      } while (!(this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem instanceof NormalTextItem));
      localNormalTextItem = (NormalTextItem)this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
      if ((localNormalTextItem.a(paramCharSequence.toString())) && (paramInt3 != 0) && ((EditTextDialog.a(this.a) == null) || (!EditTextDialog.a(this.a).d())))
      {
        EditTextDialog.a(this.a, QQToast.a(this.a.getContext(), HardCodeUtil.a(2131703734), 0));
        EditTextDialog.a(this.a).a();
      }
    } while ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() == EditTextDialog.a(this.a)) || (localNormalTextItem.f() == EditTextDialog.b(this.a)));
    if ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() > EditTextDialog.b(this.a)) && (EditTextDialog.b(this.a) < localNormalTextItem.f()))
    {
      boolean bool = localNormalTextItem.a(EditTextDialog.a(this.a), paramCharSequence.toString(), EditTextDialog.b(this.a), EditTextDialog.c(this.a));
      EditTextDialog.a(this.a, localNormalTextItem.d());
      EditTextDialog.a(this.a);
      if ((bool) && ((EditTextDialog.a(this.a) == null) || (!EditTextDialog.a(this.a).d())))
      {
        EditTextDialog.a(this.a, QQToast.a(this.a.getContext(), HardCodeUtil.a(2131703733), 0));
        EditTextDialog.a(this.a).a();
      }
    }
    for (;;)
    {
      EditTextDialog.a(this.a, this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b());
      EditTextDialog.b(this.a, localNormalTextItem.f());
      return;
      if ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() < EditTextDialog.b(this.a)) && (EditTextDialog.c(this.a) < NormalTextItem.b) && (EditTextDialog.b(this.a) > localNormalTextItem.f()))
      {
        EditTextDialog.a(this.a, localNormalTextItem.a(EditTextDialog.a(this.a), paramCharSequence.toString(), EditTextDialog.b(this.a), EditTextDialog.c(this.a)));
        EditTextDialog.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.6
 * JD-Core Version:    0.7.0.1
 */