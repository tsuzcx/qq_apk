import java.util.HashMap;
import java.util.Map;

public class lyf
{
  private static volatile lyf jdField_a_of_type_Lyf;
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private lyf()
  {
    this.jdField_a_of_type_JavaUtilMap.put("request", new String("-1"));
    this.jdField_a_of_type_JavaUtilMap.put("update", new String("-1"));
    this.jdField_a_of_type_JavaUtilMap.put("load", new String("-1"));
  }
  
  public static lyf a()
  {
    if (jdField_a_of_type_Lyf == null) {}
    try
    {
      if (jdField_a_of_type_Lyf == null) {
        jdField_a_of_type_Lyf = new lyf();
      }
      return jdField_a_of_type_Lyf;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lyf
 * JD-Core Version:    0.7.0.1
 */