public class qij
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  private qij(qil paramqil)
  {
    this.jdField_a_of_type_JavaLangString = qil.a(paramqil);
    this.jdField_b_of_type_JavaLangString = qil.b(paramqil);
    this.c = qil.c(paramqil);
    this.d = qil.d(paramqil);
    this.jdField_a_of_type_Long = qil.a(paramqil);
    this.e = qil.e(paramqil);
    this.jdField_b_of_type_Long = qil.b(paramqil);
  }
  
  public static qil a()
  {
    return new qil(null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qij
 * JD-Core Version:    0.7.0.1
 */