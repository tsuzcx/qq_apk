package dov.com.qq.im.capture.data;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class CaptureComboManager$1
  implements Handler.Callback
{
  CaptureComboManager$1(CaptureComboManager paramCaptureComboManager) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return false;
        this.a.a.removeMessages(1);
        if (this.a.a()) {
          this.a.a.sendEmptyMessageDelayed(1, 50L);
        }
      } while (paramMessage.arg2 != 7);
      int i = paramMessage.arg1;
      paramMessage = (CaptureSet)paramMessage.obj;
      Message.obtain(this.a.c, 7, i, 0, paramMessage).sendToTarget();
      return false;
      this.a.a.removeMessages(3);
    } while (!this.a.b());
    this.a.a.sendEmptyMessageDelayed(3, 50L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.data.CaptureComboManager.1
 * JD-Core Version:    0.7.0.1
 */