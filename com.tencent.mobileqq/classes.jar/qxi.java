import android.annotation.SuppressLint;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class qxi
  implements qxf
{
  private long jdField_a_of_type_Long;
  @SuppressLint({"HandlerLeak"})
  private bayj jdField_a_of_type_Bayj = new qxj(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private qxe<String> jdField_a_of_type_Qxe;
  
  public qxi(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Bayj);
  }
  
  public void a()
  {
    QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "pause, path=" + this.jdField_a_of_type_JavaLangString + ",uniSeq=" + this.jdField_a_of_type_Long);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject != null)
    {
      localObject = (barf)((bayf)localObject).a("0", this.jdField_a_of_type_Long);
      if (localObject != null) {
        ((barf)localObject).c();
      }
    }
    b();
  }
  
  public void a(String paramString)
  {
    bayf localbayf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (this.jdField_a_of_type_Bayj.getFilter().size() == 0) {
      this.jdField_a_of_type_Bayj.addFilter(new Class[] { baqy.class });
    }
    localbayf.a(this.jdField_a_of_type_Bayj);
    bayk localbayk = new bayk();
    localbayk.jdField_a_of_type_Boolean = true;
    localbayk.jdField_c_of_type_Int = 54;
    localbayk.i = paramString;
    localbayk.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localbayk.jdField_c_of_type_JavaLangString = "0";
    localbayk.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localbayk.jdField_b_of_type_Int = 24;
    localbayk.jdField_a_of_type_JavaLangString = "KandianUGCVideoUpload";
    localbayf.a(localbayk);
    this.jdField_a_of_type_Long = localbayk.jdField_a_of_type_Long;
    this.jdField_a_of_type_JavaLangString = paramString;
    QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "upload, path=" + paramString + ",uniSeq=" + this.jdField_a_of_type_Long);
  }
  
  public void a(qxe<String> paramqxe)
  {
    this.jdField_a_of_type_Qxe = paramqxe;
  }
  
  public void b(String paramString)
  {
    QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "resume, uploadKey=" + paramString);
    if (this.jdField_a_of_type_Bayj.getFilter().isEmpty()) {
      this.jdField_a_of_type_Bayj.addFilter(new Class[] { baqy.class });
    }
    bayf localbayf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localbayf.a(this.jdField_a_of_type_Bayj);
    try
    {
      paramString = new JSONObject(paramString);
      if (this.jdField_a_of_type_Long == 0L)
      {
        this.jdField_a_of_type_Long = paramString.optInt("uniseq", 0);
        this.jdField_a_of_type_JavaLangString = paramString.optString("localPath", "");
        QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "resume from app reboot");
      }
      paramString = (barf)localbayf.a("0", this.jdField_a_of_type_Long);
      if (paramString != null)
      {
        paramString.b();
        return;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        QLog.e("RIJUGC.RIJUgcVideoUploader", 1, "resume, e=" + QLog.getStackTraceString(paramString));
      }
      a(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qxi
 * JD-Core Version:    0.7.0.1
 */