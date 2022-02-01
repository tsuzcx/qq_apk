import android.annotation.SuppressLint;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class rkd
  implements rka
{
  private long jdField_a_of_type_Long;
  @SuppressLint({"HandlerLeak"})
  private beyf jdField_a_of_type_Beyf = new rke(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private rjz<String> jdField_a_of_type_Rjz;
  
  public rkd(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Beyf);
  }
  
  public void a()
  {
    QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "pause, path=" + this.jdField_a_of_type_JavaLangString + ",uniSeq=" + this.jdField_a_of_type_Long);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject != null)
    {
      localObject = (berp)((beyb)localObject).a("0", this.jdField_a_of_type_Long);
      if (localObject != null) {
        ((berp)localObject).c();
      }
    }
    b();
  }
  
  public void a(String paramString)
  {
    beyb localbeyb = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (this.jdField_a_of_type_Beyf.getFilter().size() == 0) {
      this.jdField_a_of_type_Beyf.addFilter(new Class[] { berh.class });
    }
    localbeyb.a(this.jdField_a_of_type_Beyf);
    beyg localbeyg = new beyg();
    localbeyg.jdField_a_of_type_Boolean = true;
    localbeyg.jdField_c_of_type_Int = 54;
    localbeyg.i = paramString;
    localbeyg.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localbeyg.jdField_c_of_type_JavaLangString = "0";
    localbeyg.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localbeyg.jdField_b_of_type_Int = 24;
    localbeyg.jdField_a_of_type_JavaLangString = "KandianUGCVideoUpload";
    localbeyb.a(localbeyg);
    this.jdField_a_of_type_Long = localbeyg.jdField_a_of_type_Long;
    this.jdField_a_of_type_JavaLangString = paramString;
    QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "upload, path=" + paramString + ",uniSeq=" + this.jdField_a_of_type_Long);
  }
  
  public void a(rjz<String> paramrjz)
  {
    this.jdField_a_of_type_Rjz = paramrjz;
  }
  
  public void b(String paramString)
  {
    QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "resume, uploadKey=" + paramString);
    if (this.jdField_a_of_type_Beyf.getFilter().isEmpty()) {
      this.jdField_a_of_type_Beyf.addFilter(new Class[] { berh.class });
    }
    beyb localbeyb = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localbeyb.a(this.jdField_a_of_type_Beyf);
    try
    {
      paramString = new JSONObject(paramString);
      if (this.jdField_a_of_type_Long == 0L)
      {
        this.jdField_a_of_type_Long = paramString.optInt("uniseq", 0);
        this.jdField_a_of_type_JavaLangString = paramString.optString("localPath", "");
        QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "resume from app reboot");
      }
      paramString = (berp)localbeyb.a("0", this.jdField_a_of_type_Long);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rkd
 * JD-Core Version:    0.7.0.1
 */