package dov.com.tencent.biz.qqstory.takevideo.doodle.ui;

import android.support.annotation.NonNull;
import dov.com.qq.im.capture.text.EditTextPreView;
import dov.com.qq.im.capture.text.NormalTextItem;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout.OnStrokeSelectedListener;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.HorizontalStroke;

class EditTextDialog$8
  implements HorizontalSelectColorLayout.OnStrokeSelectedListener
{
  EditTextDialog$8(EditTextDialog paramEditTextDialog) {}
  
  public void a(@NonNull HorizontalStroke paramHorizontalStroke)
  {
    switch (paramHorizontalStroke.a)
    {
    }
    int i;
    do
    {
      return;
      i = paramHorizontalStroke.b;
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.a = i;
      this.a.c = i;
    } while (!(this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem instanceof NormalTextItem));
    ((NormalTextItem)this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem).a(i);
    this.a.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.8
 * JD-Core Version:    0.7.0.1
 */