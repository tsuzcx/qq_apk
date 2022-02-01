package cooperation.weiyun;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.wifi.FreeWifiHelper.FreeWifiDialogListener;

final class WeiyunAIOUtils$1
  implements FreeWifiHelper.FreeWifiDialogListener
{
  WeiyunAIOUtils$1(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 2) {
      FileManagerUtil.a(this.a, this.b, BaseActivity.sTopActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.weiyun.WeiyunAIOUtils.1
 * JD-Core Version:    0.7.0.1
 */