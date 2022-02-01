public class rtm
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  private rtm(rto paramrto)
  {
    this.jdField_a_of_type_JavaLangString = rto.a(paramrto);
    this.jdField_b_of_type_JavaLangString = rto.b(paramrto);
    this.c = rto.c(paramrto);
    this.d = rto.d(paramrto);
    this.jdField_a_of_type_Long = rto.a(paramrto);
    this.e = rto.e(paramrto);
    this.jdField_b_of_type_Long = rto.b(paramrto);
  }
  
  public static rto a()
  {
    return new rto(null);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rtm
 * JD-Core Version:    0.7.0.1
 */