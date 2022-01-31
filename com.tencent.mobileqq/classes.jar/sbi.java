import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class sbi
  extends BizTroopObserver
{
  public sbi(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if ((paramInt2 != 0) && (TextUtils.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramString1)))
    {
      if ((!this.a.isFinishing()) && (this.a.isResume()))
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = this.a.getResources().getString(2131435563);
        }
        QQToast.a(this.a, 1, paramString1, 0).b(this.a.getTitleBarHeight());
      }
      ChatSettingForTroop.h(this.a);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = true;
    super.a(paramBoolean, paramString1, paramString2, paramString3);
    if (TextUtils.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramString1))
    {
      this.a.s();
      if (!paramBoolean) {
        break label158;
      }
      this.a.a(paramString2);
      if ((this.a.isResume()) && (this.a.e))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop = false;
        TroopUtils.a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, this.a, new sbj(this));
        this.a.e = false;
      }
      paramString1 = this.a;
      if ((this.a.d) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop)) {
        break label153;
      }
      paramBoolean = bool;
      ChatSettingForTroop.a(paramString1, paramBoolean);
    }
    label153:
    label158:
    do
    {
      return;
      paramBoolean = false;
      break;
      QQToast.a(this.a, 1, "修改失败，请稍后再试", 0).b(this.a.getTitleBarHeight());
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName();
        this.a.b(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.chatopttroop", 2, paramString3);
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof TroopNotificationCache))
    {
      paramObject = (TroopNotificationCache)paramObject;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(paramObject.title))) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopMemo = paramObject.title;
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sbi
 * JD-Core Version:    0.7.0.1
 */