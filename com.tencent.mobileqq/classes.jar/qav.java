import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import com.tencent.device.qfind.QFindBLEScanMgr;
import mqq.os.MqqHandler;

public class qav
  implements BluetoothAdapter.LeScanCallback
{
  public qav(QFindBLEScanMgr paramQFindBLEScanMgr) {}
  
  public void onLeScan(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    if (this.a.a != null) {
      this.a.a.post(new qaw(this, paramBluetoothDevice, paramArrayOfByte));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qav
 * JD-Core Version:    0.7.0.1
 */