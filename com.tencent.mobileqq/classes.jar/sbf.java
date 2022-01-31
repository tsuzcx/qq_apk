import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class sbf
  extends WtloginObserver
{
  public sbf(ChatHistoryForC2C paramChatHistoryForC2C, long paramLong, boolean paramBoolean) {}
  
  public void OnCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    long l;
    if (QLog.isColorLevel())
    {
      l = System.currentTimeMillis();
      paramWUserSigInfo = new StringBuilder().append("CheckDevLockStatus ret: ").append(paramInt).append(", has devinfo: ");
      if (paramDevlockInfo != null) {
        break label93;
      }
    }
    label93:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ChatHistoryForC2C", 2, bool + ", cost: " + (l - this.jdField_a_of_type_Long) + "ms");
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.runOnUiThread(new sbg(this, paramInt, paramDevlockInfo));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sbf
 * JD-Core Version:    0.7.0.1
 */