import java.util.HashMap;
import java.util.Map;

public class lll
{
  private static volatile lll jdField_a_of_type_Lll;
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private lll()
  {
    this.jdField_a_of_type_JavaUtilMap.put("request", new String("-1"));
    this.jdField_a_of_type_JavaUtilMap.put("update", new String("-1"));
    this.jdField_a_of_type_JavaUtilMap.put("load", new String("-1"));
  }
  
  public static lll a()
  {
    if (jdField_a_of_type_Lll == null) {}
    try
    {
      if (jdField_a_of_type_Lll == null) {
        jdField_a_of_type_Lll = new lll();
      }
      return jdField_a_of_type_Lll;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lll
 * JD-Core Version:    0.7.0.1
 */