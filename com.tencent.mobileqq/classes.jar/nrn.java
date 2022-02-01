import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;

class nrn
  implements bkhw
{
  nrn(nre paramnre, bkho parambkho) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Nre.f) {
      return;
    }
    this.jdField_a_of_type_Nre.f = true;
    if (paramInt == 0) {
      this.jdField_a_of_type_Nre.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_Nre.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Nre.jdField_a_of_type_Aoqn);
      this.jdField_a_of_type_Nre.jdField_a_of_type_Aoqn = new aoqn(new nro(this));
      this.jdField_a_of_type_Nre.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Nre.jdField_a_of_type_Aoqn);
      aoqs.a(this.jdField_a_of_type_Nre.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Nre.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_Nre.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_Nre.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bkho.dismiss();
      return;
      if (paramInt == 1) {
        this.jdField_a_of_type_Nre.jdField_a_of_type_Int = 2;
      } else if (paramInt == 2) {
        this.jdField_a_of_type_Nre.jdField_a_of_type_Int = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nrn
 * JD-Core Version:    0.7.0.1
 */