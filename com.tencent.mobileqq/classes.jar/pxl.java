import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DevLittleVideoOperator;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import mqq.app.MobileQQ;

public class pxl
  implements Runnable
{
  public pxl(DevLittleVideoOperator paramDevLittleVideoOperator, ShortVideoUploadInfo paramShortVideoUploadInfo) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = null;
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo.a instanceof MessageForDevLittleVideo)) {
      localMessageRecord = (MessageRecord)this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo.a;
    }
    if (localMessageRecord == null) {}
    Object localObject;
    label300:
    label322:
    label487:
    do
    {
      do
      {
        return;
      } while (!(localMessageRecord instanceof MessageForDevLittleVideo));
      boolean bool1 = NetworkUtil.g(this.jdField_a_of_type_ComTencentDeviceFileDevLittleVideoOperator.a.getApplication().getApplicationContext());
      localObject = (MessageForDevLittleVideo)localMessageRecord;
      int i;
      long l;
      if (bool1)
      {
        i = 1002;
        ((MessageForDevLittleVideo)localObject).videoFileStatus = i;
        ((MessageForDevLittleVideo)localObject).videoFileProgress = 0;
        ((MessageForDevLittleVideo)localObject).serial();
        this.jdField_a_of_type_ComTencentDeviceFileDevLittleVideoOperator.a.a().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq, localMessageRecord.msgData);
        if (!bool1) {
          break label487;
        }
        l = System.currentTimeMillis();
        if (!this.jdField_a_of_type_ComTencentDeviceFileDevLittleVideoOperator.a(localMessageRecord.frienduin)) {
          break label322;
        }
        i = ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentDeviceFileDevLittleVideoOperator.a.a(51)).a(Long.parseLong(((MessageForDevLittleVideo)localObject).frienduin), ((MessageForDevLittleVideo)localObject).videoFileName, ((MessageForDevLittleVideo)localObject).videoFileSize, ((MessageForDevLittleVideo)localObject).videoFileTime, ((MessageForDevLittleVideo)localObject).mThumbFilePath);
        if (i == 0) {
          break label300;
        }
        Logger.a(this.jdField_a_of_type_ComTencentDeviceFileDevLittleVideoOperator.g, this.jdField_a_of_type_ComTencentDeviceFileDevLittleVideoOperator.f, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
        DeviceMsgChatPie.a(i, (MessageRecord)localObject);
      }
      for (;;)
      {
        Logger.a(this.jdField_a_of_type_ComTencentDeviceFileDevLittleVideoOperator.g, this.jdField_a_of_type_ComTencentDeviceFileDevLittleVideoOperator.f, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
        return;
        i = 1005;
        break;
        Logger.a(this.jdField_a_of_type_ComTencentDeviceFileDevLittleVideoOperator.g, this.jdField_a_of_type_ComTencentDeviceFileDevLittleVideoOperator.f, "doSendShortVideo failed");
        continue;
        ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentDeviceFileDevLittleVideoOperator.a.a(49)).a().a(DeviceMsgHandle.e, ((MessageForDevLittleVideo)localObject).videoFileName, Long.parseLong(((MessageForDevLittleVideo)localObject).frienduin), localMessageRecord.uniseq, localMessageRecord.istroop, 0);
        bool1 = ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentDeviceFileDevLittleVideoOperator.a.a(51)).a(Long.parseLong(localMessageRecord.frienduin)).booleanValue();
        boolean bool2 = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentDeviceFileDevLittleVideoOperator.a.getApp(), localMessageRecord.frienduin, null, "devicemsg_showvideotips_first", true);
        if ((bool1) && (bool2))
        {
          ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentDeviceFileDevLittleVideoOperator.a.a(49)).a(localMessageRecord.frienduin, "当前仅支持视频消息发送给设备，其他群聊成员不可见", MessageCache.a(), true, false, true);
          SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentDeviceFileDevLittleVideoOperator.a.getApp(), localMessageRecord.frienduin, null, "devicemsg_showvideotips_first", false);
        }
      }
      localObject = ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentDeviceFileDevLittleVideoOperator.a.a(49)).a();
    } while (localObject == null);
    ((DeviceAVFileMsgObserver)localObject).a(localMessageRecord, Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     pxl
 * JD-Core Version:    0.7.0.1
 */