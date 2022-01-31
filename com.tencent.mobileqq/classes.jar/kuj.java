import com.tencent.av.app.DeviceCapabilityExamination;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class kuj
  implements axrt
{
  public void onResp(axsq paramaxsq)
  {
    boolean bool = false;
    String str1 = (String)paramaxsq.jdField_a_of_type_Axsp.a();
    if (paramaxsq.jdField_a_of_type_Int == 0) {
      bool = true;
    }
    try
    {
      if (DeviceCapabilityExamination.a != null)
      {
        DeviceCapabilityExamination.a.a(str1, bool);
        if (DeviceCapabilityExamination.a.a()) {
          DeviceCapabilityExamination.a = null;
        }
      }
      if (!bool)
      {
        QLog.w("DeviceCapabilityExamination", 1, "DownloadTestResource fail, md5[" + str1 + "], resp.mResult[" + paramaxsq.jdField_a_of_type_Int + "]");
        return;
      }
    }
    finally {}
    try
    {
      String str2 = DeviceCapabilityExamination.b(str1);
      bace.a(paramaxsq.jdField_a_of_type_Axsp.c, str2, false);
      bace.d(paramaxsq.jdField_a_of_type_Axsp.c);
      paramaxsq = new File(DeviceCapabilityExamination.a(str1));
      QLog.w("DeviceCapabilityExamination", 1, "DownloadTestResource, suc, md5[" + str1 + "], exists[" + paramaxsq.exists() + "]");
      return;
    }
    catch (Exception paramaxsq)
    {
      QLog.w("DeviceCapabilityExamination", 1, "DownloadTestResource Exception, md5[" + str1 + "]");
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kuj
 * JD-Core Version:    0.7.0.1
 */