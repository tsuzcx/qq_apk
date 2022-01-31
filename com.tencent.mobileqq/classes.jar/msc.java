import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public final class msc
  implements DialogInterface.OnClickListener
{
  public msc(int paramInt, QQAppInterface paramQQAppInterface, long paramLong, Handler paramHandler) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      afqa.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, true, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      l = NetConnInfoCenter.getServerTimeMillis();
      ((ajqw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(31)).a(String.valueOf(this.jdField_a_of_type_Long), true, l);
      return;
    }
    afqa.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, false, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    long l = NetConnInfoCenter.getServerTimeMillis();
    ((ajqw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(31)).a(String.valueOf(this.jdField_a_of_type_Long), false, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     msc
 * JD-Core Version:    0.7.0.1
 */