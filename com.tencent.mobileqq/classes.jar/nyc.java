import java.util.HashMap;

class nyc
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public long c;
  public String c;
  public long d = -1L;
  
  private nyc()
  {
    this.jdField_a_of_type_JavaLangString = "IMAX_Ad_StartCost";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("adid", this.jdField_b_of_type_JavaLangString);
    localHashMap.put("vid", this.jdField_c_of_type_JavaLangString);
    localHashMap.put("webPreloaded", "" + this.jdField_a_of_type_Int);
    localHashMap.put("videoPreloaded", "" + this.jdField_b_of_type_Int);
    localHashMap.put("webProStartCost", "" + this.jdField_b_of_type_Long);
    localHashMap.put("webActStartCost", "" + this.jdField_a_of_type_Long);
    localHashMap.put("actDisplayCost", "" + this.jdField_c_of_type_Long);
    localHashMap.put("videoDisplayCost", "" + this.d);
    localHashMap.put("isFirst", "" + this.jdField_a_of_type_Boolean);
    return localHashMap;
  }
  
  public void a()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_c_of_type_Long = -1L;
    this.d = -1L;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[name:" + this.jdField_a_of_type_JavaLangString).append(" adid:" + this.jdField_b_of_type_JavaLangString).append(" vid:" + this.jdField_c_of_type_JavaLangString).append(" webPreloaded:" + this.jdField_a_of_type_Int).append(" videoPreloaded:" + this.jdField_b_of_type_Int).append(" webProStartCost:" + this.jdField_b_of_type_Long).append(" webActStartCost:" + this.jdField_a_of_type_Long).append(" actDisplayCost:" + this.jdField_c_of_type_Long).append(" videoDisplayCost:" + this.d).append(" isFirst:" + this.jdField_a_of_type_Boolean + "]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nyc
 * JD-Core Version:    0.7.0.1
 */