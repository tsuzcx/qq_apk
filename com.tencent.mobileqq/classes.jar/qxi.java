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
  private baua jdField_a_of_type_Baua = new qxj(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private qxe<String> jdField_a_of_type_Qxe;
  
  public qxi(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Baua);
  }
  
  public void a()
  {
    QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "pause, path=" + this.jdField_a_of_type_JavaLangString + ",uniSeq=" + this.jdField_a_of_type_Long);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject != null)
    {
      localObject = (bamw)((batw)localObject).a("0", this.jdField_a_of_type_Long);
      if (localObject != null) {
        ((bamw)localObject).c();
      }
    }
    b();
  }
  
  public void a(String paramString)
  {
    batw localbatw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (this.jdField_a_of_type_Baua.getFilter().size() == 0) {
      this.jdField_a_of_type_Baua.addFilter(new Class[] { bamp.class });
    }
    localbatw.a(this.jdField_a_of_type_Baua);
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_Boolean = true;
    localbaub.jdField_c_of_type_Int = 54;
    localbaub.i = paramString;
    localbaub.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localbaub.jdField_c_of_type_JavaLangString = "0";
    localbaub.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localbaub.jdField_b_of_type_Int = 24;
    localbaub.jdField_a_of_type_JavaLangString = "KandianUGCVideoUpload";
    localbatw.a(localbaub);
    this.jdField_a_of_type_Long = localbaub.jdField_a_of_type_Long;
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
    if (this.jdField_a_of_type_Baua.getFilter().isEmpty()) {
      this.jdField_a_of_type_Baua.addFilter(new Class[] { bamp.class });
    }
    batw localbatw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localbatw.a(this.jdField_a_of_type_Baua);
    try
    {
      paramString = new JSONObject(paramString);
      if (this.jdField_a_of_type_Long == 0L)
      {
        this.jdField_a_of_type_Long = paramString.optInt("uniseq", 0);
        this.jdField_a_of_type_JavaLangString = paramString.optString("localPath", "");
        QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "resume from app reboot");
      }
      paramString = (bamw)localbatw.a("0", this.jdField_a_of_type_Long);
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