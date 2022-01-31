import com.tencent.device.file.DevShortVideoOperator;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;

public class qce
  implements Runnable
{
  public qce(DevShortVideoOperator paramDevShortVideoOperator, ShortVideoUploadInfo paramShortVideoUploadInfo) {}
  
  public void run()
  {
    ShortVideoUploadInfo localShortVideoUploadInfo = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo;
    Object localObject = null;
    int i;
    if (localShortVideoUploadInfo.g == 0)
    {
      localObject = this.jdField_a_of_type_ComTencentDeviceFileDevShortVideoOperator.a(localShortVideoUploadInfo);
      i = 1;
    }
    for (;;)
    {
      if (localObject == null)
      {
        return;
        if (localShortVideoUploadInfo.g == 1)
        {
          localObject = (MessageForShortVideo)localShortVideoUploadInfo.a;
          i = 0;
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentDeviceFileDevShortVideoOperator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        if ((localObject instanceof MessageForDevShortVideo)) {
          ((MessageForDevShortVideo)localObject).videoFileStatus = 1002;
        }
        long l = System.currentTimeMillis();
        if (i != 0) {
          this.jdField_a_of_type_ComTencentDeviceFileDevShortVideoOperator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject, this.jdField_a_of_type_ComTencentDeviceFileDevShortVideoOperator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentDeviceFileDevShortVideoOperator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(DeviceMsgHandle.e, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo.h, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo.c), ((MessageRecord)localObject).uniseq, ((MessageRecord)localObject).istroop, 0);
        Logger.a(this.jdField_a_of_type_ComTencentDeviceFileDevShortVideoOperator.g, this.jdField_a_of_type_ComTencentDeviceFileDevShortVideoOperator.f, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
        return;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qce
 * JD-Core Version:    0.7.0.1
 */