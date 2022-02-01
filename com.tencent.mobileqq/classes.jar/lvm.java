import java.util.HashMap;
import java.util.Map;

public class lvm
{
  private static volatile lvm jdField_a_of_type_Lvm;
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private lvm()
  {
    this.jdField_a_of_type_JavaUtilMap.put("request", new String("-1"));
    this.jdField_a_of_type_JavaUtilMap.put("update", new String("-1"));
    this.jdField_a_of_type_JavaUtilMap.put("load", new String("-1"));
  }
  
  public static lvm a()
  {
    if (jdField_a_of_type_Lvm == null) {}
    try
    {
      if (jdField_a_of_type_Lvm == null) {
        jdField_a_of_type_Lvm = new lvm();
      }
      return jdField_a_of_type_Lvm;
    }
    finally {}
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, String.valueOf(paramInt));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lvm
 * JD-Core Version:    0.7.0.1
 */