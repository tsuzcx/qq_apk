import java.util.HashMap;
import java.util.Map;

public class lvh
{
  private static volatile lvh jdField_a_of_type_Lvh;
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private lvh()
  {
    this.jdField_a_of_type_JavaUtilMap.put("request", new String("-1"));
    this.jdField_a_of_type_JavaUtilMap.put("update", new String("-1"));
    this.jdField_a_of_type_JavaUtilMap.put("load", new String("-1"));
  }
  
  public static lvh a()
  {
    if (jdField_a_of_type_Lvh == null) {}
    try
    {
      if (jdField_a_of_type_Lvh == null) {
        jdField_a_of_type_Lvh = new lvh();
      }
      return jdField_a_of_type_Lvh;
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
 * Qualified Name:     lvh
 * JD-Core Version:    0.7.0.1
 */