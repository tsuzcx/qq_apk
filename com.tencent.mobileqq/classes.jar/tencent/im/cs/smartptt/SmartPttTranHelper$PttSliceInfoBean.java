package tencent.im.cs.smartptt;

public class SmartPttTranHelper$PttSliceInfoBean
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public int d;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PttSliceInfoBean{encodeType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", isfirst=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", isLast=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", voiceId='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", offset=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", vegPos='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", md5='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", chatType='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.smartptt.SmartPttTranHelper.PttSliceInfoBean
 * JD-Core Version:    0.7.0.1
 */