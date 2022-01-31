import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tencent.im.troop.activity.troopactivity.ActSSORsp;
import tencent.im.troop.activity.troopactivity.GroupInfoCardResp;

public class sen
  implements BusinessObserver
{
  public sen(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a.f)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.chatopttroop", 2, "mGetTroopActivityObserver->onReceive, isDestroyed, return");
      }
      return;
    }
    if ((!paramBoolean) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.chatopttroop", 2, "mGetTroopActivityObserver: !isSuccess || mTroopInfoData == null");
      }
      ReportController.b(this.a.app, "P_CliOper", "BizTechReport", "", "troopInfoCard", "getTroopActivity", 0, -1, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, Boolean.toString(paramBoolean), "", "");
      return;
    }
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.chatopttroop", 2, "mGetTroopActivityObserver: data == null");
        }
        ReportController.b(this.a.app, "P_CliOper", "BizTechReport", "", "troopInfoCard", "getTroopActivity", 0, -2, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.chatopttroop", 2, "mGetTroopActivityObserver: InvalidProtocolBufferMicroException:" + paramBundle.getMessage());
      }
      ReportController.b(this.a.app, "P_CliOper", "BizTechReport", "", "troopInfoCard", "getTroopActivity", 0, -5, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      return;
    }
    Object localObject = new troopactivity.ActSSORsp();
    ((troopactivity.ActSSORsp)localObject).mergeFrom(paramBundle);
    if (((troopactivity.ActSSORsp)localObject).err_code.get() != 10000)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.chatopttroop", 2, "mGetTroopActivityObserver: errorcode:" + ((troopactivity.ActSSORsp)localObject).err_code.get() + ", msg:" + ((troopactivity.ActSSORsp)localObject).err_msg.get());
      }
      ReportController.b(this.a.app, "P_CliOper", "BizTechReport", "", "troopInfoCard", "getTroopActivity", 0, -3, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "" + ((troopactivity.ActSSORsp)localObject).err_code.get(), "", "");
      return;
    }
    localObject = ((troopactivity.ActSSORsp)localObject).body.get().toByteArray();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.chatopttroop", 2, "mGetTroopActivityObserver: respdata == null");
      }
      ReportController.b(this.a.app, "P_CliOper", "BizTechReport", "", "troopInfoCard", "getTroopActivity", 0, -4, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      return;
    }
    paramBundle = new troopactivity.GroupInfoCardResp();
    paramBundle.mergeFrom((byte[])localObject);
    localObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    ((Message)localObject).what = 15;
    ((Message)localObject).obj = paramBundle;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sen
 * JD-Core Version:    0.7.0.1
 */