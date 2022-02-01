package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.LayerListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog;

class DoodleLayout$TextLayerListener
  implements TextLayer.LayerListener
{
  private DoodleLayout$TextLayerListener(DoodleLayout paramDoodleLayout) {}
  
  public void a(float paramFloat)
  {
    if (paramFloat >= 0.95F)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleLayout", 2, "onAnimate:" + paramFloat);
      }
      if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog != null) && (this.a.a() != null) && (this.a.a().a() != null)) {
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog.a(this.a.a().a(), this.a.a().a().b());
      }
    }
  }
  
  public void a(DynamicTextItem paramDynamicTextItem)
  {
    if (DoodleLayout.a(this.a)) {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleLayout", 2, "onClickInside mIsRecording");
      }
    }
    long l;
    do
    {
      return;
      l = SystemClock.uptimeMillis();
    } while (l - this.a.jdField_a_of_type_Long <= 500L);
    this.a.jdField_a_of_type_Long = l;
    this.a.a(paramDynamicTextItem, paramDynamicTextItem.b(), 1);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.a.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }
  
  public boolean a(TextLayer.TextItem paramTextItem)
  {
    if ((DoodleLayout.b(this.a)) && (!DoodleLayout.c(this.a))) {
      return false;
    }
    return this.a.a(paramTextItem, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.TextLayerListener
 * JD-Core Version:    0.7.0.1
 */