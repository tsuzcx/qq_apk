import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;

class lym
  extends akil
{
  String jdField_a_of_type_JavaLangString;
  
  private lym(lyi paramlyi) {}
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w("ShareChat", 1, "onUpdateTroopList, isSuccess[" + paramBoolean + "]");
    }
  }
  
  protected void a(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
  {
    if (paramTroopInfo == null) {}
    do
    {
      return;
      paramTroopInfo = paramTroopInfo.troopuin;
    } while ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramTroopInfo)));
    this.jdField_a_of_type_Lyi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this);
    if (this == this.jdField_a_of_type_Lyi.jdField_a_of_type_Lym) {
      this.jdField_a_of_type_Lyi.jdField_a_of_type_Lym = null;
    }
    QLog.w("ShareChat", 1, "onGetSimpleTroopInfoResult, isSuc[" + paramBoolean + "]");
    this.jdField_a_of_type_Lyi.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lym
 * JD-Core Version:    0.7.0.1
 */