import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

final class mrj
  implements bliz
{
  mrj(mvg parammvg, int[] paramArrayOfInt, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Mvg.dismiss();
    switch (this.jdField_a_of_type_ArrayOfInt[paramInt])
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt > 0) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800A518", "0X800A518", 0, paramInt, "", "", "", "");
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        mrh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true);
        paramInt = 3;
      }
      else
      {
        mrh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, this.jdField_a_of_type_Int, null);
        paramInt = 1;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
        {
          mrh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
          paramInt = 4;
        }
        else
        {
          mrh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, this.jdField_a_of_type_Int, null);
          paramInt = 2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mrj
 * JD-Core Version:    0.7.0.1
 */