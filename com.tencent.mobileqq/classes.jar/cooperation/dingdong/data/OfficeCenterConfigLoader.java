package cooperation.dingdong.data;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.qphone.base.util.QLog;

public class OfficeCenterConfigLoader
{
  private static volatile OfficeCenterConfigLoader jdField_a_of_type_CooperationDingdongDataOfficeCenterConfigLoader;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private String b = "";
  
  public static OfficeCenterConfigLoader a()
  {
    if (jdField_a_of_type_CooperationDingdongDataOfficeCenterConfigLoader == null) {}
    try
    {
      if (jdField_a_of_type_CooperationDingdongDataOfficeCenterConfigLoader == null) {
        jdField_a_of_type_CooperationDingdongDataOfficeCenterConfigLoader = new OfficeCenterConfigLoader();
      }
      return jdField_a_of_type_CooperationDingdongDataOfficeCenterConfigLoader;
    }
    finally {}
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    QLog.d("OfficeCenterConfigLoader", 1, "begin to get config, mbConfigGetting = " + this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.d("OfficeCenterConfigLoader", 4, "officecenter: get config is doing.");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    ConfigServlet.c(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.dingdong.data.OfficeCenterConfigLoader
 * JD-Core Version:    0.7.0.1
 */