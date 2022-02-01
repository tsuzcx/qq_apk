import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;

class lyv
  extends aojs
{
  String jdField_a_of_type_JavaLangString;
  
  private lyv(lyr paramlyr) {}
  
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
    this.jdField_a_of_type_Lyr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this);
    if (this == this.jdField_a_of_type_Lyr.jdField_a_of_type_Lyv) {
      this.jdField_a_of_type_Lyr.jdField_a_of_type_Lyv = null;
    }
    QLog.w("ShareChat", 1, "onGetSimpleTroopInfoResult, isSuc[" + paramBoolean + "]");
    this.jdField_a_of_type_Lyr.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lyv
 * JD-Core Version:    0.7.0.1
 */