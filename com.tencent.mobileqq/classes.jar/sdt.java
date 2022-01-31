import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.troop.utils.TroopBindPubAccountProtocol.RequestPublicAccountObserver;

public class sdt
  extends TroopBindPubAccountProtocol.RequestPublicAccountObserver
{
  public sdt(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void a(boolean paramBoolean, long paramLong, AccountDetail paramAccountDetail)
  {
    if (paramBoolean)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 17;
      Bundle localBundle = new Bundle();
      localBundle.putString("uinname", paramAccountDetail.name);
      localBundle.putString("extra_type", paramAccountDetail.summary);
      localBundle.putLong("uin", paramLong);
      localMessage.setData(localBundle);
      this.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sdt
 * JD-Core Version:    0.7.0.1
 */