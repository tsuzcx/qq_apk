import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class obs
  implements Handler.Callback
{
  obs(obq paramobq) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      if (System.currentTimeMillis() - obq.a(this.a) > 1500L)
      {
        obq.a(this.a, false);
        QLog.d("KandianAdPandent", 2, "time up do not update volume");
      }
      if (obq.b(this.a))
      {
        obq.a(this.a).sendEmptyMessageDelayed(1, 300L);
        this.a.d();
        return false;
      }
      obq.a(this.a).removeMessages(1);
      return false;
    }
    obq.a(this.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obs
 * JD-Core Version:    0.7.0.1
 */