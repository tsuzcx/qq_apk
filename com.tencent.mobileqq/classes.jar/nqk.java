import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class nqk
  implements Handler.Callback
{
  nqk(nqi paramnqi) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      if (System.currentTimeMillis() - nqi.a(this.a) > 1500L)
      {
        nqi.a(this.a, false);
        QLog.d("KandianAdPandent", 2, "time up do not update volume");
      }
      if (nqi.b(this.a))
      {
        nqi.a(this.a).sendEmptyMessageDelayed(1, 300L);
        this.a.d();
        return false;
      }
      nqi.a(this.a).removeMessages(1);
      return false;
    }
    nqi.a(this.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nqk
 * JD-Core Version:    0.7.0.1
 */