import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class obv
  implements Handler.Callback
{
  obv(obt paramobt) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      if (System.currentTimeMillis() - obt.a(this.a) > 1500L)
      {
        obt.a(this.a, false);
        QLog.d("KandianAdPandent", 2, "time up do not update volume");
      }
      if (obt.b(this.a))
      {
        obt.a(this.a).sendEmptyMessageDelayed(1, 300L);
        this.a.d();
        return false;
      }
      obt.a(this.a).removeMessages(1);
      return false;
    }
    obt.a(this.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obv
 * JD-Core Version:    0.7.0.1
 */