import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.device.ble.QFindGattManager;
import com.tencent.device.qfind.BluetoothLeService;
import com.tencent.device.qfind.BluetoothLeService.LocalBinder;
import com.tencent.device.qfind.PeerInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class pwj
  implements ServiceConnection
{
  public pwj(QFindGattManager paramQFindGattManager) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    QFindGattManager.a(this.a, ((BluetoothLeService.LocalBinder)paramIBinder).a());
    if ((!QFindGattManager.a(this.a).a()) && (QLog.isColorLevel())) {
      QLog.e("DeviceBLE2", 2, "Unable to initialize Bluetooth");
    }
    if (QLog.isColorLevel()) {
      QLog.i("DeviceBLE2", 2, "ServiceConnection onServiceConnected ");
    }
    if (!QFindGattManager.a(this.a).isEmpty())
    {
      this.a.a = ((PeerInfo)QFindGattManager.a(this.a).get(0));
      QFindGattManager.a(this.a).remove(0);
      QFindGattManager.a(this.a).a(this.a.a.a, this.a.a.b);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QFindGattManager.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     pwj
 * JD-Core Version:    0.7.0.1
 */