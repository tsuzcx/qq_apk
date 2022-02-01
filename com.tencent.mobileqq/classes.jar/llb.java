import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class llb
{
  static String jdField_a_of_type_JavaLangString = "smartdevice::sharp";
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  lla jdField_a_of_type_Lla = null;
  llc jdField_a_of_type_Llc = null;
  
  public llb(lla paramlla, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_Lla = paramlla;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Llc = new llc(this);
    paramlla = new IntentFilter();
    paramlla.addAction("SmartDevice_ReceiveSharpMsg");
    paramlla.addAction("SmartDevice_ReceiveSharpAckMsg");
    paramlla.addAction("SmartDevice_DeviceUnBindRst");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().registerReceiver(this.jdField_a_of_type_Llc, paramlla, "com.tencent.smartdevice.permission.broadcast", null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     llb
 * JD-Core Version:    0.7.0.1
 */