import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class qim
{
  Context jdField_a_of_type_AndroidContentContext;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  qin jdField_a_of_type_Qin;
  
  public qim(Context paramContext, QQAppInterface paramQQAppInterface, qin paramqin)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Qin = paramqin;
  }
  
  public abstract void a();
  
  public abstract void a(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qim
 * JD-Core Version:    0.7.0.1
 */