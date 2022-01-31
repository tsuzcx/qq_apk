import com.tencent.av.app.DeviceCapabilityExamination;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class lgw
  implements bapx
{
  public void onResp(baqw parambaqw)
  {
    boolean bool = false;
    String str1 = (String)parambaqw.jdField_a_of_type_Baqv.a();
    if (parambaqw.jdField_a_of_type_Int == 0) {
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
        QLog.w("DeviceCapabilityExamination", 1, "DownloadTestResource fail, md5[" + str1 + "], resp.mResult[" + parambaqw.jdField_a_of_type_Int + "]");
        return;
      }
    }
    finally {}
    try
    {
      String str2 = DeviceCapabilityExamination.b(str1);
      bdcs.a(parambaqw.jdField_a_of_type_Baqv.c, str2, false);
      bdcs.d(parambaqw.jdField_a_of_type_Baqv.c);
      parambaqw = new File(DeviceCapabilityExamination.a(str1));
      QLog.w("DeviceCapabilityExamination", 1, "DownloadTestResource, suc, md5[" + str1 + "], exists[" + parambaqw.exists() + "]");
      return;
    }
    catch (Exception parambaqw)
    {
      QLog.w("DeviceCapabilityExamination", 1, "DownloadTestResource Exception, md5[" + str1 + "]");
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lgw
 * JD-Core Version:    0.7.0.1
 */