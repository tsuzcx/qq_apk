import android.annotation.SuppressLint;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class rth
  implements rte
{
  private long jdField_a_of_type_Long;
  @SuppressLint({"HandlerLeak"})
  private bdzm jdField_a_of_type_Bdzm = new rti(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private rtd<String> jdField_a_of_type_Rtd;
  
  public rth(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Bdzm);
  }
  
  public void a()
  {
    QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "pause, path=" + this.jdField_a_of_type_JavaLangString + ",uniSeq=" + this.jdField_a_of_type_Long);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject != null)
    {
      localObject = (bdsx)((bdzi)localObject).a("0", this.jdField_a_of_type_Long);
      if (localObject != null) {
        ((bdsx)localObject).c();
      }
    }
    b();
  }
  
  public void a(String paramString)
  {
    bdzi localbdzi = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (this.jdField_a_of_type_Bdzm.getFilter().size() == 0) {
      this.jdField_a_of_type_Bdzm.addFilter(new Class[] { bdsp.class });
    }
    localbdzi.a(this.jdField_a_of_type_Bdzm);
    bdzn localbdzn = new bdzn();
    localbdzn.jdField_a_of_type_Boolean = true;
    localbdzn.jdField_c_of_type_Int = 54;
    localbdzn.i = paramString;
    localbdzn.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localbdzn.jdField_c_of_type_JavaLangString = "0";
    localbdzn.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localbdzn.jdField_b_of_type_Int = 24;
    localbdzn.jdField_a_of_type_JavaLangString = "KandianUGCVideoUpload";
    localbdzi.a(localbdzn);
    this.jdField_a_of_type_Long = localbdzn.jdField_a_of_type_Long;
    this.jdField_a_of_type_JavaLangString = paramString;
    QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "upload, path=" + paramString + ",uniSeq=" + this.jdField_a_of_type_Long);
  }
  
  public void a(rtd<String> paramrtd)
  {
    this.jdField_a_of_type_Rtd = paramrtd;
  }
  
  public void b(String paramString)
  {
    QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "resume, uploadKey=" + paramString);
    if (this.jdField_a_of_type_Bdzm.getFilter().isEmpty()) {
      this.jdField_a_of_type_Bdzm.addFilter(new Class[] { bdsp.class });
    }
    bdzi localbdzi = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localbdzi.a(this.jdField_a_of_type_Bdzm);
    try
    {
      paramString = new JSONObject(paramString);
      if (this.jdField_a_of_type_Long == 0L)
      {
        this.jdField_a_of_type_Long = paramString.optInt("uniseq", 0);
        this.jdField_a_of_type_JavaLangString = paramString.optString("localPath", "");
        QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "resume from app reboot");
      }
      paramString = (bdsx)localbdzi.a("0", this.jdField_a_of_type_Long);
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
 * Qualified Name:     rth
 * JD-Core Version:    0.7.0.1
 */