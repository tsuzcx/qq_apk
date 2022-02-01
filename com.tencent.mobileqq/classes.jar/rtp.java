import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class rtp
{
  Context jdField_a_of_type_AndroidContentContext;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  rtq jdField_a_of_type_Rtq;
  
  public rtp(Context paramContext, QQAppInterface paramQQAppInterface, rtq paramrtq)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Rtq = paramrtq;
  }
  
  public void a() {}
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rtp
 * JD-Core Version:    0.7.0.1
 */