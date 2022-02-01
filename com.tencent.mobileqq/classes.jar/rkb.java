import android.content.Context;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.ugc.upload.RIJUgcImageUploader.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

public class rkb
  implements rjy
{
  public static String a;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private rjx jdField_a_of_type_Rjx;
  private rkn jdField_a_of_type_Rkn;
  private volatile boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = "RIJUGC.RIJUgcImageUploader";
  }
  
  public rkb(Context paramContext, QQAppInterface paramQQAppInterface, String paramString)
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
  
  public void a(rjx paramrjx)
  {
    this.jdField_a_of_type_Rjx = paramrjx;
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      QLog.i(jdField_a_of_type_JavaLangString, 1, "cancel, path=" + this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_Rkn != null)
      {
        this.jdField_a_of_type_Rkn.a();
        this.jdField_a_of_type_Rkn.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rkb
 * JD-Core Version:    0.7.0.1
 */