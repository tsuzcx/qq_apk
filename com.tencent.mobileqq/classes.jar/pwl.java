public class pwl
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  private pwl(pwn parampwn)
  {
    this.jdField_a_of_type_JavaLangString = pwn.a(parampwn);
    this.jdField_b_of_type_JavaLangString = pwn.b(parampwn);
    this.c = pwn.c(parampwn);
    this.d = pwn.d(parampwn);
    this.jdField_a_of_type_Long = pwn.a(parampwn);
    this.e = pwn.e(parampwn);
    this.jdField_b_of_type_Long = pwn.b(parampwn);
  }
  
  public static pwn a()
  {
    return new pwn(null);
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
 * Qualified Name:     pwl
 * JD-Core Version:    0.7.0.1
 */