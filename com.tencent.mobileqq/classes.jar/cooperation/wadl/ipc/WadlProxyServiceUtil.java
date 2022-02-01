package cooperation.wadl.ipc;

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
    if (jdField_a_of_type_CooperationWadlIpcWadlProxyServiceWrap == null) {}
    synchronized (jdField_a_of_type_JavaLangString)
    {
      if (jdField_a_of_type_CooperationWadlIpcWadlProxyServiceWrap == null) {
        jdField_a_of_type_CooperationWadlIpcWadlProxyServiceWrap = new WadlProxyServiceWrap();
      }
      return jdField_a_of_type_CooperationWadlIpcWadlProxyServiceWrap;
    }
  }
  
  public static void a()
  {
    if (jdField_a_of_type_CooperationWadlIpcWadlProxyServiceWrap != null)
    {
      jdField_a_of_type_CooperationWadlIpcWadlProxyServiceWrap.c();
      jdField_a_of_type_CooperationWadlIpcWadlProxyServiceWrap = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlProxyServiceUtil
 * JD-Core Version:    0.7.0.1
 */