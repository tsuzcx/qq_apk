import android.os.Looper;
import android.os.Message;
import com.tencent.device.ble.QFindGattManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class pwi
  extends MqqHandler
{
  public pwi(QFindGattManager paramQFindGattManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DeviceBLE2", 2, "QFindGattManager write data timeout bleSN " + (String)paramMessage.obj);
      }
      QFindGattManager.a(this.a, paramMessage.arg1);
      this.a.a((String)paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     pwi
 * JD-Core Version:    0.7.0.1
 */