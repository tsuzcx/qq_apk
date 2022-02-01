import com.tencent.av.app.DeviceCapabilityExamination;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ldx
  implements beuq
{
  public void onResp(bevm parambevm)
  {
    boolean bool = false;
    String str1 = (String)parambevm.jdField_a_of_type_Bevl.a();
    if (parambevm.jdField_a_of_type_Int == 0) {
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
        QLog.w("DeviceCapabilityExamination", 1, "DownloadTestResource fail, md5[" + str1 + "], resp.mResult[" + parambevm.jdField_a_of_type_Int + "]");
        return;
      }
    }
    finally {}
    try
    {
      String str2 = DeviceCapabilityExamination.b(str1);
      bhmi.a(parambevm.jdField_a_of_type_Bevl.c, str2, false);
      bhmi.d(parambevm.jdField_a_of_type_Bevl.c);
      parambevm = new File(DeviceCapabilityExamination.a(str1));
      QLog.w("DeviceCapabilityExamination", 1, "DownloadTestResource, suc, md5[" + str1 + "], exists[" + parambevm.exists() + "]");
      return;
    }
    catch (Exception parambevm)
    {
      QLog.w("DeviceCapabilityExamination", 1, "DownloadTestResource Exception, md5[" + str1 + "]");
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ldx
 * JD-Core Version:    0.7.0.1
 */