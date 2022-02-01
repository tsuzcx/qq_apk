package dov.com.qq.im;

import android.widget.Button;
import blhu;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;

public class QIMCameraCaptureUnit$12
  implements Runnable
{
  public QIMCameraCaptureUnit$12(blhu paramblhu, boolean paramBoolean) {}
  
  public void run()
  {
    if (!this.this$0.e)
    {
      if (!this.a) {
        break label80;
      }
      if (!blhu.a(this.this$0))
      {
        if (blhu.b(this.this$0)) {
          this.this$0.c.setVisibility(0);
        }
        this.this$0.c.setSelected(true);
        this.this$0.a.a(true);
        blhu.b(this.this$0, false);
      }
    }
    return;
    label80:
    this.this$0.c.setVisibility(8);
    this.this$0.c.setSelected(false);
    this.this$0.a.a(false);
    blhu.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.12
 * JD-Core Version:    0.7.0.1
 */