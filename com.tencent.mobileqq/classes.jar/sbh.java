import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

public class sbh
  extends AccountObserver
{
  public sbh(ChatHistoryForC2C paramChatHistoryForC2C, boolean paramBoolean) {}
  
  public void onRefreshDA2(boolean paramBoolean, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder().append("onRefrshDA2 result: ").append(paramBoolean).append(", da2 length: ");
      if (paramString2 != null) {
        break label93;
      }
    }
    label93:
    for (int i = 0;; i = paramString2.length())
    {
      QLog.d("ChatHistoryForC2C", 2, i);
      boolean bool1 = bool2;
      if (paramBoolean)
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString2)) {
          bool1 = true;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.runOnUiThread(new sbi(this, bool1));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sbh
 * JD-Core Version:    0.7.0.1
 */