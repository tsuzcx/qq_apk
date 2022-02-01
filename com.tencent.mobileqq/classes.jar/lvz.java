import java.util.HashMap;
import java.util.Map;

public class lvz
{
  private static volatile lvz jdField_a_of_type_Lvz;
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private lvz()
  {
    this.jdField_a_of_type_JavaUtilMap.put("request", new String("-1"));
    this.jdField_a_of_type_JavaUtilMap.put("update", new String("-1"));
    this.jdField_a_of_type_JavaUtilMap.put("load", new String("-1"));
  }
  
  public static lvz a()
  {
    if (jdField_a_of_type_Lvz == null) {}
    try
    {
      if (jdField_a_of_type_Lvz == null) {
        jdField_a_of_type_Lvz = new lvz();
      }
      return jdField_a_of_type_Lvz;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lvz
 * JD-Core Version:    0.7.0.1
 */