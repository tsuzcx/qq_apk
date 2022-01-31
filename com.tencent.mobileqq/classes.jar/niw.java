import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;

class niw
  implements bhuk
{
  niw(nin paramnin, bhuf parambhuf) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Nin.f) {
      return;
    }
    this.jdField_a_of_type_Nin.f = true;
    if (paramInt == 0) {
      this.jdField_a_of_type_Nin.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_Nin.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Nin.jdField_a_of_type_Amrw);
      this.jdField_a_of_type_Nin.jdField_a_of_type_Amrw = new amrw(new nix(this));
      this.jdField_a_of_type_Nin.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Nin.jdField_a_of_type_Amrw);
      amsb.a(this.jdField_a_of_type_Nin.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Nin.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_Nin.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_Nin.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bhuf.dismiss();
      return;
      if (paramInt == 1) {
        this.jdField_a_of_type_Nin.jdField_a_of_type_Int = 2;
      } else if (paramInt == 2) {
        this.jdField_a_of_type_Nin.jdField_a_of_type_Int = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     niw
 * JD-Core Version:    0.7.0.1
 */