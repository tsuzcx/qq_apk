package dov.com.qq.im;

import android.widget.Button;
import bkil;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;

public class QIMCameraCaptureUnit$11
  implements Runnable
{
  public QIMCameraCaptureUnit$11(bkil parambkil, boolean paramBoolean) {}
  
  public void run()
  {
    if (!this.this$0.f)
    {
      if (!this.a) {
        break label80;
      }
      if (!bkil.a(this.this$0))
      {
        if (bkil.b(this.this$0)) {
          this.this$0.c.setVisibility(0);
        }
        this.this$0.c.setSelected(true);
        this.this$0.a.c(true);
        bkil.b(this.this$0, false);
      }
    }
    return;
    label80:
    this.this$0.c.setVisibility(8);
    this.this$0.c.setSelected(false);
    this.this$0.a.c(false);
    bkil.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.11
 * JD-Core Version:    0.7.0.1
 */