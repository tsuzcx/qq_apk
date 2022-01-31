import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class lbc
{
  static String jdField_a_of_type_JavaLangString = "smartdevice::sharp";
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  lbb jdField_a_of_type_Lbb = null;
  lbd jdField_a_of_type_Lbd = null;
  
  public lbc(lbb paramlbb, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_Lbb = paramlbb;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Lbd = new lbd(this);
    paramlbb = new IntentFilter();
    paramlbb.addAction("SmartDevice_ReceiveSharpMsg");
    paramlbb.addAction("SmartDevice_ReceiveSharpAckMsg");
    paramlbb.addAction("SmartDevice_DeviceUnBindRst");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().registerReceiver(this.jdField_a_of_type_Lbd, paramlbb, "com.tencent.smartdevice.permission.broadcast", null);
  }
  
  void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "send broadcast : smartdevice send sharp msg");
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("size", paramArrayOfByte.length);
    localBundle.putLong("uin", paramLong);
    localBundle.putByteArray("value", paramArrayOfByte);
    paramArrayOfByte = new Intent();
    paramArrayOfByte.putExtra("msgData", localBundle);
    paramArrayOfByte.setAction("SmartDevice_SendSharpMsg");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramArrayOfByte, "com.tencent.smartdevice.permission.broadcast");
  }
  
  public void b(byte[] paramArrayOfByte, long paramLong)
  {
    a(paramArrayOfByte, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lbc
 * JD-Core Version:    0.7.0.1
 */