import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

@SuppressLint({"HandlerLeak"})
class rcw
  extends Handler
{
  private rcw(rcp paramrcp) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatWindowManager", 2, "floating window msg time out: " + paramMessage.what);
      }
      return;
      rcp.b(this.a);
      continue;
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rcw
 * JD-Core Version:    0.7.0.1
 */