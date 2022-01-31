import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;

public class qga
  implements Runnable
{
  public qga(DeviceMsgHandle paramDeviceMsgHandle, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceMsgHandle.b.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
    this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceMsgHandle.b.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qga
 * JD-Core Version:    0.7.0.1
 */