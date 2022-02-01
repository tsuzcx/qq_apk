import android.content.Context;
import com.tencent.biz.pubaccount.PublicAccountUnfollowTask.1;
import com.tencent.biz.pubaccount.PublicAccountUnfollowTask.2;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class oco
  implements pre
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private ocp jdField_a_of_type_Ocp;
  
  public oco(QQAppInterface paramQQAppInterface, String paramString, Context paramContext)
  {
    this(paramQQAppInterface, paramString, paramContext, null);
  }
  
  public oco(QQAppInterface paramQQAppInterface, String paramString, Context paramContext, ocp paramocp)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Ocp = paramocp;
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Int >= 3) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.d("PublicAccountUnfollowTask", 2, "retry count reach max value or app = null ! retryCount : " + this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(new PublicAccountUnfollowTask.1(this));
  }
  
  public void a(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    if (i < 3)
    {
      QLog.d("PublicAccountUnfollowTask", 2, "unfollow account fail ! uin : " + this.jdField_a_of_type_JavaLangString + " , errCode : " + paramInt + ", retry : " + this.jdField_a_of_type_Int);
      this.jdField_a_of_type_MqqOsMqqHandler.post(new PublicAccountUnfollowTask.2(this));
    }
    while (this.jdField_a_of_type_Ocp == null) {
      return;
    }
    this.jdField_a_of_type_Ocp.a(false, this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      QLog.d("PublicAccountUnfollowTask", 2, "unfollow account success ! uin : " + paramString + ",retry : " + this.jdField_a_of_type_Int);
      paramInt = tzq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      alpb.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_JavaLangString, 1008);
      ((pfg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(163)).a().e();
      if (this.jdField_a_of_type_Ocp != null) {
        this.jdField_a_of_type_Ocp.a(true, paramString);
      }
      return;
    }
    a(-1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oco
 * JD-Core Version:    0.7.0.1
 */