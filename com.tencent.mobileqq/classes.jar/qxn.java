public class qxn
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  private qxn(qxp paramqxp)
  {
    this.jdField_a_of_type_JavaLangString = qxp.a(paramqxp);
    this.jdField_b_of_type_JavaLangString = qxp.b(paramqxp);
    this.c = qxp.c(paramqxp);
    this.d = qxp.d(paramqxp);
    this.jdField_a_of_type_Long = qxp.a(paramqxp);
    this.e = qxp.e(paramqxp);
    this.jdField_b_of_type_Long = qxp.b(paramqxp);
  }
  
  public static qxp a()
  {
    return new qxp(null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qxn
 * JD-Core Version:    0.7.0.1
 */