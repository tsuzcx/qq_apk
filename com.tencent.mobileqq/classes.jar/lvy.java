import java.util.HashMap;
import java.util.Map;

public class lvy
{
  private static volatile lvy jdField_a_of_type_Lvy;
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private lvy()
  {
    this.jdField_a_of_type_JavaUtilMap.put("request", new String("-1"));
    this.jdField_a_of_type_JavaUtilMap.put("update", new String("-1"));
    this.jdField_a_of_type_JavaUtilMap.put("load", new String("-1"));
  }
  
  public static lvy a()
  {
    if (jdField_a_of_type_Lvy == null) {}
    try
    {
      if (jdField_a_of_type_Lvy == null) {
        jdField_a_of_type_Lvy = new lvy();
      }
      return jdField_a_of_type_Lvy;
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
 * Qualified Name:     lvy
 * JD-Core Version:    0.7.0.1
 */