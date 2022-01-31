import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class raq
  extends Handler
{
  raq(rap paramrap, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
    }
    do
    {
      return;
      if (!this.a.g) {
        break;
      }
      if (this.a.f)
      {
        rap.a(this.a, this.a.a);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.w("ReadInJoyBaseAdapter", 2, "MSG_FOR_CHECK_PLAYAREA, 平移转场动画未做完，不触发自动播放");
    return;
    rap.a(this.a, this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     raq
 * JD-Core Version:    0.7.0.1
 */