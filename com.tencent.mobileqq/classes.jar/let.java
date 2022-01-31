import com.tencent.av.app.DeviceCapabilityExamination;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class let
  implements aysc
{
  public void onResp(aysz paramaysz)
  {
    boolean bool = false;
    String str1 = (String)paramaysz.jdField_a_of_type_Aysy.a();
    if (paramaysz.jdField_a_of_type_Int == 0) {
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
        QLog.w("DeviceCapabilityExamination", 1, "DownloadTestResource fail, md5[" + str1 + "], resp.mResult[" + paramaysz.jdField_a_of_type_Int + "]");
        return;
      }
    }
    finally {}
    try
    {
      String str2 = DeviceCapabilityExamination.b(str1);
      bbdx.a(paramaysz.jdField_a_of_type_Aysy.c, str2, false);
      bbdx.d(paramaysz.jdField_a_of_type_Aysy.c);
      paramaysz = new File(DeviceCapabilityExamination.a(str1));
      QLog.w("DeviceCapabilityExamination", 1, "DownloadTestResource, suc, md5[" + str1 + "], exists[" + paramaysz.exists() + "]");
      return;
    }
    catch (Exception paramaysz)
    {
      QLog.w("DeviceCapabilityExamination", 1, "DownloadTestResource Exception, md5[" + str1 + "]");
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     let
 * JD-Core Version:    0.7.0.1
 */