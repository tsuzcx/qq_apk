import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public final class nfw
  implements DialogInterface.OnClickListener
{
  public nfw(int paramInt, QQAppInterface paramQQAppInterface, long paramLong, Handler paramHandler) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      aieq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, true, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      l = NetConnInfoCenter.getServerTimeMillis();
      ((ambk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(31)).a(String.valueOf(this.jdField_a_of_type_Long), true, l);
      return;
    }
    aieq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, false, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    long l = NetConnInfoCenter.getServerTimeMillis();
    ((ambk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(31)).a(String.valueOf(this.jdField_a_of_type_Long), false, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nfw
 * JD-Core Version:    0.7.0.1
 */