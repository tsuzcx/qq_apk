import android.content.Context;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.ugc.upload.RIJUgcImageUploader.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

public class qxg
  implements qxd
{
  public static String a;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private qxc jdField_a_of_type_Qxc;
  private qxs jdField_a_of_type_Qxs;
  private volatile boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = "RIJUGC.RIJUgcImageUploader";
  }
  
  public qxg(Context paramContext, QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a()
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "upload, path=" + this.jdField_b_of_type_JavaLangString);
    this.jdField_b_of_type_Boolean = true;
    ThreadManagerV2.getUIHandlerV2().post(new RIJUgcImageUploader.1(this));
  }
  
  public void a(qxc paramqxc)
  {
    this.jdField_a_of_type_Qxc = paramqxc;
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      QLog.i(jdField_a_of_type_JavaLangString, 1, "cancel, path=" + this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_Qxs != null)
      {
        this.jdField_a_of_type_Qxs.a();
        this.jdField_a_of_type_Qxs.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qxg
 * JD-Core Version:    0.7.0.1
 */