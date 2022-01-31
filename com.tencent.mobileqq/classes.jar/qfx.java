import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import java.util.concurrent.ConcurrentHashMap;

public class qfx
  implements Runnable
{
  public qfx(DeviceComnFileMsgProcessor paramDeviceComnFileMsgProcessor, MessageForDeviceFile paramMessageForDeviceFile) {}
  
  public void run()
  {
    if (DeviceComnFileMsgProcessor.a(this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor).containsKey(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile.uSessionID)))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile.nFileStatus = 23;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile.serial();
      DeviceComnFileMsgProcessor.a(this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor).a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile.frienduin, 9501, this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile.msgData);
      DeviceComnFileMsgProcessor.a(this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor, this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile);
      DeviceComnFileMsgProcessor.a(this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor).remove(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile.uSessionID));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qfx
 * JD-Core Version:    0.7.0.1
 */