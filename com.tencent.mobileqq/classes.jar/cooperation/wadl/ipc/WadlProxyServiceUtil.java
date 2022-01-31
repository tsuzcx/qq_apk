package cooperation.wadl.ipc;

import com.tencent.common.app.BaseApplicationImpl;
import java.util.List;
import mqq.app.AppRuntime;

public class WadlProxyServiceUtil
{
  private static WadlProxyServiceWrap a;
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "WadlProxyServiceUtil";
  }
  
  public static WadlProxyServiceWrap a()
  {
    if (jdField_a_of_type_CooperationWadlIpcWadlProxyServiceWrap == null) {
      a(BaseApplicationImpl.getApplication().getRuntime());
    }
    return jdField_a_of_type_CooperationWadlIpcWadlProxyServiceWrap;
  }
  
  public static List a()
  {
    return jdField_a_of_type_CooperationWadlIpcWadlProxyServiceWrap.a();
  }
  
  public static void a(WadlProxyServiceCallBackInterface paramWadlProxyServiceCallBackInterface)
  {
    jdField_a_of_type_CooperationWadlIpcWadlProxyServiceWrap.a(paramWadlProxyServiceCallBackInterface);
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    synchronized (jdField_a_of_type_JavaLangString)
    {
      if (jdField_a_of_type_CooperationWadlIpcWadlProxyServiceWrap == null) {
        jdField_a_of_type_CooperationWadlIpcWadlProxyServiceWrap = new WadlProxyServiceWrap(paramAppRuntime);
      }
      jdField_a_of_type_CooperationWadlIpcWadlProxyServiceWrap.a();
      return;
    }
  }
  
  public static void b(WadlProxyServiceCallBackInterface paramWadlProxyServiceCallBackInterface)
  {
    jdField_a_of_type_CooperationWadlIpcWadlProxyServiceWrap.b(paramWadlProxyServiceCallBackInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlProxyServiceUtil
 * JD-Core Version:    0.7.0.1
 */