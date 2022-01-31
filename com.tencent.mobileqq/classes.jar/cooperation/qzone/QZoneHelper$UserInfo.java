package cooperation.qzone;

import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class QZoneHelper$UserInfo
{
  private static UserInfo a;
  public String a;
  public String b;
  
  public static UserInfo a()
  {
    if (jdField_a_of_type_CooperationQzoneQZoneHelper$UserInfo == null) {
      jdField_a_of_type_CooperationQzoneQZoneHelper$UserInfo = new UserInfo();
    }
    jdField_a_of_type_CooperationQzoneQZoneHelper$UserInfo.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    jdField_a_of_type_CooperationQzoneQZoneHelper$UserInfo.b = null;
    return jdField_a_of_type_CooperationQzoneQZoneHelper$UserInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.UserInfo
 * JD-Core Version:    0.7.0.1
 */