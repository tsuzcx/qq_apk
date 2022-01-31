import android.bluetooth.BluetoothAdapter;
import com.tencent.device.qfind.QFindBLEScanMgr;
import com.tencent.qphone.base.util.QLog;

public class qhg
  implements Runnable
{
  public qhg(QFindBLEScanMgr paramQFindBLEScanMgr) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_Boolean) {
      this.a.jdField_a_of_type_Boolean = false;
    }
    try
    {
      if (this.a.jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QFindBLE", 2, "call native mBluetoothAdapter.stopLeScan with cb=" + this.a.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback + ", mScanning=" + this.a.jdField_a_of_type_Boolean);
        }
        this.a.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.stopLeScan(this.a.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qhg
 * JD-Core Version:    0.7.0.1
 */