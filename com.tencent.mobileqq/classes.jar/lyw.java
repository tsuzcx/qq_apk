import android.text.TextUtils;
import com.tencent.av.share.ShareChat;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;

public class lyw
  extends aofu
{
  public String a;
  
  private lyw(ShareChat paramShareChat) {}
  
  protected void onGetSimpleTroopInfoResult(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
  {
    if (paramTroopInfo == null) {}
    do
    {
      return;
      paramTroopInfo = paramTroopInfo.troopuin;
    } while ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramTroopInfo)));
    this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this);
    if (this == this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_Lyw) {
      this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_Lyw = null;
    }
    QLog.w("ShareChat", 1, "onGetSimpleTroopInfoResult, isSuc[" + paramBoolean + "]");
    this.jdField_a_of_type_ComTencentAvShareShareChat.a();
  }
  
  protected void onUpdateTroopList(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w("ShareChat", 1, "onUpdateTroopList, isSuccess[" + paramBoolean + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lyw
 * JD-Core Version:    0.7.0.1
 */