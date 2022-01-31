import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;

class lnz
  extends ajuc
{
  String jdField_a_of_type_JavaLangString;
  
  private lnz(lnv paramlnv) {}
  
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
    this.jdField_a_of_type_Lnv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this);
    if (this == this.jdField_a_of_type_Lnv.jdField_a_of_type_Lnz) {
      this.jdField_a_of_type_Lnv.jdField_a_of_type_Lnz = null;
    }
    QLog.w("ShareChat", 1, "onGetSimpleTroopInfoResult, isSuc[" + paramBoolean + "]");
    this.jdField_a_of_type_Lnv.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lnz
 * JD-Core Version:    0.7.0.1
 */