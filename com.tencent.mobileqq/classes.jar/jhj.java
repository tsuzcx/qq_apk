import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.AbstractNetChannel;
import com.tencent.av.core.DeviceSharpController;
import com.tencent.qphone.base.util.QLog;

public class jhj
  extends BroadcastReceiver
{
  public jhj(DeviceSharpController paramDeviceSharpController) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_ReceiveSharpMsg"))
    {
      if (QLog.isColorLevel()) {
        QLog.d(DeviceSharpController.jdField_a_of_type_JavaLangString, 2, "recv broadcast : smartdevice receive sharp msg");
      }
      paramContext = paramIntent.getBundleExtra("msgData");
      if (paramContext != null)
      {
        paramContext = paramContext.getByteArray("value");
        if (paramContext != null) {
          this.a.jdField_a_of_type_ComTencentAvCoreAbstractNetChannel.a(0L, paramContext, null);
        }
      }
    }
    label154:
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (!paramIntent.getAction().equalsIgnoreCase("SmartDevice_ReceiveSharpAckMsg")) {
                  break label154;
                }
                if (QLog.isColorLevel()) {
                  QLog.d(DeviceSharpController.jdField_a_of_type_JavaLangString, 2, "recv broadcast : smartdevice receive sharp ack msg");
                }
                if (!paramIntent.getBooleanExtra("timeout", false)) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d(DeviceSharpController.jdField_a_of_type_JavaLangString, 2, "recv broadcast : smartdevice receive sharp timeout msg");
              return;
              paramContext = paramIntent.getBundleExtra("msgData");
            } while (paramContext == null);
            paramContext = paramContext.getByteArray("value");
          } while (paramContext == null);
          this.a.jdField_a_of_type_ComTencentAvCoreAbstractNetChannel.b(0L, paramContext, null);
          return;
        } while (!paramIntent.getAction().equals("SmartDevice_DeviceUnBindRst"));
        paramContext = paramIntent.getExtras();
      } while (paramContext == null);
      i = paramContext.getInt("deviceoprstcode");
      paramContext = Long.valueOf(paramContext.getLong("deviceopdin", 0L));
    } while ((i != 0) || (paramContext.longValue() == 0L) || (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() == null) || (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a() == null) || (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().c == null) || (!this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().c.equals(String.valueOf(paramContext))));
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jhj
 * JD-Core Version:    0.7.0.1
 */