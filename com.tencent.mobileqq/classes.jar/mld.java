import com.tencent.av.gaudio.AVPhoneUserInfo;

public class mld
{
  public int a;
  public long a;
  public AVPhoneUserInfo a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  public boolean f;
  public boolean g;
  
  public mld()
  {
    this.jdField_b_of_type_Long = 4L;
    this.jdField_b_of_type_Int = 0;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Int == 2;
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public boolean d()
  {
    return (this.jdField_b_of_type_Boolean) && (!this.c);
  }
  
  public boolean e()
  {
    return this.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin:=").append(this.jdField_a_of_type_Long).append(',');
    localStringBuilder.append("videoSrc:=").append(this.jdField_b_of_type_Int).append(',');
    localStringBuilder.append("isVideoIn:=").append(this.e).append(',');
    localStringBuilder.append("isAttened:=").append(this.jdField_a_of_type_Boolean).append(',');
    localStringBuilder.append("isSpeaking:=").append(this.jdField_b_of_type_Boolean).append(',');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mld
 * JD-Core Version:    0.7.0.1
 */