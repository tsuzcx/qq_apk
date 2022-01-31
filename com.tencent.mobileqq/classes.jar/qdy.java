import java.util.HashMap;

public class qdy
{
  public long a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public boolean b;
  
  public HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_vid", this.jdField_a_of_type_JavaLangString);
    localHashMap.put("param_success", String.valueOf(this.jdField_a_of_type_Boolean).toLowerCase());
    localHashMap.put("param_costTime", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("param_ret_code", String.valueOf(this.jdField_b_of_type_Long));
    localHashMap.put("param_err_info", this.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_retry", String.valueOf(this.jdField_b_of_type_Boolean));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qdy
 * JD-Core Version:    0.7.0.1
 */