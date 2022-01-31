import com.tencent.av.app.DeviceCapabilityExamination;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ley
  implements aysa
{
  public void onResp(aysx paramaysx)
  {
    boolean bool = false;
    String str1 = (String)paramaysx.jdField_a_of_type_Aysw.a();
    if (paramaysx.jdField_a_of_type_Int == 0) {
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
        QLog.w("DeviceCapabilityExamination", 1, "DownloadTestResource fail, md5[" + str1 + "], resp.mResult[" + paramaysx.jdField_a_of_type_Int + "]");
        return;
      }
    }
    finally {}
    try
    {
      String str2 = DeviceCapabilityExamination.b(str1);
      bbdj.a(paramaysx.jdField_a_of_type_Aysw.c, str2, false);
      bbdj.d(paramaysx.jdField_a_of_type_Aysw.c);
      paramaysx = new File(DeviceCapabilityExamination.a(str1));
      QLog.w("DeviceCapabilityExamination", 1, "DownloadTestResource, suc, md5[" + str1 + "], exists[" + paramaysx.exists() + "]");
      return;
    }
    catch (Exception paramaysx)
    {
      QLog.w("DeviceCapabilityExamination", 1, "DownloadTestResource Exception, md5[" + str1 + "]");
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ley
 * JD-Core Version:    0.7.0.1
 */