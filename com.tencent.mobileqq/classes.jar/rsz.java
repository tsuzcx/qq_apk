import android.content.Context;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class rsz
  implements Runnable
{
  rsz(rsy paramrsy, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int > 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 1, new Object[] { "ForwardWXforTroop failed! result: ", Integer.valueOf(this.jdField_a_of_type_Int), ", type: ", Integer.valueOf(this.jdField_a_of_type_Rsy.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) });
      }
      QQToast.a(this.jdField_a_of_type_Rsy.a.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Rsy.a.jdField_a_of_type_AndroidContentContext.getString(2131438946), 0).b(this.jdField_a_of_type_Rsy.a.a());
    }
    if ((this.jdField_a_of_type_Int == 0) && (BaseChatItemLayout.a)) {
      this.jdField_a_of_type_Rsy.a.a(false, null, false);
    }
    if (this.jdField_a_of_type_Rsy.a.c != null) {
      this.jdField_a_of_type_Rsy.a.c.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rsz
 * JD-Core Version:    0.7.0.1
 */