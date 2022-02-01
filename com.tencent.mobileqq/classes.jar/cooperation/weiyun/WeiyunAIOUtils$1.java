package cooperation.weiyun;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.wifi.FreeWifiDialogListener;

final class WeiyunAIOUtils$1
  implements FreeWifiDialogListener
{
  WeiyunAIOUtils$1(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 2) {
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, BaseActivity.sTopActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.WeiyunAIOUtils.1
 * JD-Core Version:    0.7.0.1
 */