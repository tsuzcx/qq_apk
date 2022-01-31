import android.view.View;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.msg.activities.DevicePttItemBuilder;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class qau
  implements ActionSheet.OnButtonClickListener
{
  public qau(DevicePttItemBuilder paramDevicePttItemBuilder, MessageForPtt paramMessageForPtt, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.uniseq);
    paramView = null;
    if (this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      paramView = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      ((MessageForPtt)paramView).fileSize = -3L;
      this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView, this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    if (paramView != null)
    {
      if (!"device_groupchat".equals(paramView.extStr)) {
        break label256;
      }
      if ((!NetworkUtil.d(BaseApplication.getContext())) && ((paramView instanceof MessageForDevPtt)))
      {
        paramView = (MessageForDevPtt)paramView;
        paramView.fileSize = -1L;
        paramView.extraflag = 32768;
        paramView.extStr = "device_groupchat";
        paramView.serial();
        this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView.frienduin, paramView.istroop, paramView.uniseq, paramView.msgData);
        this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder.b();
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
      }
      DeviceMsgChatPie.a(((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.url, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.voiceLength), paramView);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder.b();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      label256:
      ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(DeviceMsgHandle.f, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.url, Long.parseLong(this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), paramView.uniseq, paramView.istroop, (int)this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.msgRecTime / 1000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qau
 * JD-Core Version:    0.7.0.1
 */