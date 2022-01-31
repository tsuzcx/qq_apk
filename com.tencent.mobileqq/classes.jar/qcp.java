import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import com.tencent.device.qfind.QFindBLEScanMgr;
import mqq.os.MqqHandler;

public class qcp
  implements BluetoothAdapter.LeScanCallback
{
  public qcp(QFindBLEScanMgr paramQFindBLEScanMgr) {}
  
  public void onLeScan(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    if (this.a.a != null) {
      this.a.a.post(new qcq(this, paramBluetoothDevice, paramArrayOfByte));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qcp
 * JD-Core Version:    0.7.0.1
 */