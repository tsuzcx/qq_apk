package dov.com.qq.im;

import alud;
import bkoa;
import dov.com.qq.im.capture.view.StoryImageToastView;
import dov.com.qq.im.capture.view.StoryTextToastView;
import java.util.List;

public class QIMStoryEffectCameraCaptureUnit$2
  implements Runnable
{
  public QIMStoryEffectCameraCaptureUnit$2(bkoa parambkoa, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if ((this.a) && (!this.b)) {
      bkoa.a(this.this$0).b(String.format("%02d", new Object[] { Integer.valueOf(this.this$0.jdField_a_of_type_JavaUtilList.size() + 1) })).a(alud.a(2131710236)).a();
    }
    this.this$0.jdField_a_of_type_DovComQqImCaptureViewStoryImageToastView.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.QIMStoryEffectCameraCaptureUnit.2
 * JD-Core Version:    0.7.0.1
 */