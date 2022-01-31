import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class ofk
  implements Handler.Callback
{
  ofk(ofi paramofi) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      if (System.currentTimeMillis() - ofi.a(this.a) > 1500L)
      {
        ofi.a(this.a, false);
        QLog.d("KandianAdPandent", 2, "time up do not update volume");
      }
      if (ofi.b(this.a))
      {
        ofi.a(this.a).sendEmptyMessageDelayed(1, 300L);
        this.a.d();
        return false;
      }
      ofi.a(this.a).removeMessages(1);
      return false;
    }
    ofi.a(this.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ofk
 * JD-Core Version:    0.7.0.1
 */