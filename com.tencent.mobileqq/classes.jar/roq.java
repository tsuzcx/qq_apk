import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class roq
  implements Runnable
{
  public roq(BaseChatPie paramBaseChatPie, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aI();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.i(0);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.U();
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131433770, 1).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     roq
 * JD-Core Version:    0.7.0.1
 */