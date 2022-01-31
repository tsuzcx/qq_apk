public class qaz
{
  private Integer jdField_a_of_type_JavaLangInteger;
  private Long jdField_a_of_type_JavaLangLong;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public qaz(Long paramLong, Integer paramInteger, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangLong = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_JavaLangInteger = paramInteger;
  }
  
  public Long a()
  {
    return this.jdField_a_of_type_JavaLangLong;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String toString()
  {
    return "FollowingMember{uin='" + this.jdField_a_of_type_JavaLangLong + '\'' + ", nickname='" + this.jdField_a_of_type_JavaLangString + '\'' + ", headUrl='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qaz
 * JD-Core Version:    0.7.0.1
 */