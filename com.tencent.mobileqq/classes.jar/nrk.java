import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;

public class nrk
  implements bkhw
{
  nrk(nre paramnre, nyl paramnyl, bkho parambkho) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 1;
    if (this.jdField_a_of_type_Nre.f) {
      return;
    }
    this.jdField_a_of_type_Nre.f = true;
    if (paramInt + 1 == 1)
    {
      if (!anhk.aR.equals(this.jdField_a_of_type_Nre.jdField_a_of_type_JavaLangString)) {
        break label209;
      }
      oat.a(null, "", "0X8009947", "0X8009947", 0, 0, "", "", "", "", false);
      i = 1;
    }
    label209:
    for (;;)
    {
      this.jdField_a_of_type_Nre.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Nre.jdField_a_of_type_Aoqn);
      this.jdField_a_of_type_Nre.jdField_a_of_type_Aoqn = new aoqn(new nrl(this, i));
      this.jdField_a_of_type_Nre.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Nre.jdField_a_of_type_Aoqn);
      aoqs.a(this.jdField_a_of_type_Nre.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Nre.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_Nre.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, paramInt);
      this.jdField_a_of_type_Bkho.dismiss();
      return;
      int j = 3;
      i = j;
      if (anhk.aR.equals(this.jdField_a_of_type_Nre.jdField_a_of_type_JavaLangString))
      {
        oat.a(null, "", "0X8009943", "0X8009943", 0, 0, "", "", "", "", false);
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nrk
 * JD-Core Version:    0.7.0.1
 */