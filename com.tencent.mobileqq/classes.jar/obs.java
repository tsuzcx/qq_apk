import android.view.View;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;

public class obs
  implements bkzq
{
  obs(obm paramobm, oji paramoji, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 1;
    if (this.jdField_a_of_type_Obm.f) {
      return;
    }
    this.jdField_a_of_type_Obm.f = true;
    if (paramInt + 1 == 1)
    {
      if (!AppConstants.KANDIAN_DAILY_UIN.equals(this.jdField_a_of_type_Obm.jdField_a_of_type_JavaLangString)) {
        break label209;
      }
      olh.a(null, "", "0X8009947", "0X8009947", 0, 0, "", "", "", "", false);
      i = 1;
    }
    label209:
    for (;;)
    {
      this.jdField_a_of_type_Obm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Obm.jdField_a_of_type_Apar);
      this.jdField_a_of_type_Obm.jdField_a_of_type_Apar = new apar(new obt(this, i));
      this.jdField_a_of_type_Obm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Obm.jdField_a_of_type_Apar);
      apaw.a(this.jdField_a_of_type_Obm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Obm.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_Obm.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, paramInt);
      this.jdField_a_of_type_Bkzi.dismiss();
      return;
      int j = 3;
      i = j;
      if (AppConstants.KANDIAN_DAILY_UIN.equals(this.jdField_a_of_type_Obm.jdField_a_of_type_JavaLangString))
      {
        olh.a(null, "", "0X8009943", "0X8009943", 0, 0, "", "", "", "", false);
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     obs
 * JD-Core Version:    0.7.0.1
 */