import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.biz.troop.TroopMemberApiPlugin;
import com.tencent.qphone.base.util.QLog;

public class ovw
  implements TroopMemberApiClient.Callback
{
  public ovw(TroopMemberApiPlugin paramTroopMemberApiPlugin, String paramString) {}
  
  public void a(Bundle paramBundle)
  {
    boolean bool = paramBundle.getBoolean("isSuccess", false);
    if (bool)
    {
      paramBundle = paramBundle.getString("data");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle });
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin.TAG, 2, "getTroopBarPublishInfo() in callback isSuccess=" + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovw
 * JD-Core Version:    0.7.0.1
 */