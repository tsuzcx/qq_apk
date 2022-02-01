import android.view.View;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;

public class nus
  implements bjoe
{
  nus(num paramnum, obr paramobr, bjnw parambjnw) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 1;
    if (this.jdField_a_of_type_Num.f) {
      return;
    }
    this.jdField_a_of_type_Num.f = true;
    if (paramInt + 1 == 1)
    {
      if (!AppConstants.KANDIAN_DAILY_UIN.equals(this.jdField_a_of_type_Num.jdField_a_of_type_JavaLangString)) {
        break label209;
      }
      odq.a(null, "", "0X8009947", "0X8009947", 0, 0, "", "", "", "", false);
      i = 1;
    }
    label209:
    for (;;)
    {
      this.jdField_a_of_type_Num.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Num.jdField_a_of_type_Anxp);
      this.jdField_a_of_type_Num.jdField_a_of_type_Anxp = new anxp(new nut(this, i));
      this.jdField_a_of_type_Num.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Num.jdField_a_of_type_Anxp);
      anxu.a(this.jdField_a_of_type_Num.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Num.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_Num.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, paramInt);
      this.jdField_a_of_type_Bjnw.dismiss();
      return;
      int j = 3;
      i = j;
      if (AppConstants.KANDIAN_DAILY_UIN.equals(this.jdField_a_of_type_Num.jdField_a_of_type_JavaLangString))
      {
        odq.a(null, "", "0X8009943", "0X8009943", 0, 0, "", "", "", "", false);
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nus
 * JD-Core Version:    0.7.0.1
 */