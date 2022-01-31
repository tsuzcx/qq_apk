package com.tencent.mobileqq.openapi.sdk;

public class MessageItem
{
  public static final String[] a;
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "uin", "uin_type", "senderUin", "msg_type", "msgid", "msgTime", "is_send", "msgContent", "media_path", "mediaStatus" };
  }
  
  private MessageItem() {}
  
  public MessageItem(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, long paramLong, boolean paramBoolean, String paramString4, String paramString5, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.d = paramString4;
    this.e = paramString5;
    this.jdField_c_of_type_Int = paramInt3;
  }
  
  public Object[] a()
  {
    return new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_b_of_type_JavaLangString, Integer.valueOf(this.jdField_b_of_type_Int), this.jdField_c_of_type_JavaLangString, Long.valueOf(this.jdField_a_of_type_Long), Boolean.valueOf(this.jdField_a_of_type_Boolean), this.d, this.e, Integer.valueOf(this.jdField_c_of_type_Int) };
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString).append("; ");
    localStringBuilder.append(this.jdField_b_of_type_Int).append("; ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString).append("; ");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString).append("; ");
    localStringBuilder.append(this.jdField_a_of_type_Long).append(";");
    localStringBuilder.append(this.jdField_a_of_type_Boolean).append("; ");
    localStringBuilder.append(this.d).append("; ");
    localStringBuilder.append(this.e).append("; ");
    localStringBuilder.append(this.jdField_c_of_type_Int).append(". ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.openapi.sdk.MessageItem
 * JD-Core Version:    0.7.0.1
 */