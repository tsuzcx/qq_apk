package com.tencent.mobileqq.qqexpand.match;

public class MatchNotifyInfo
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public int c;
  public String c;
  public int d;
  
  public MatchNotifyInfo()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = -1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{SenderUin: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("}");
    localStringBuilder.append("{SenderNickName: ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("}");
    localStringBuilder.append("{bEnter: ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("}");
    localStringBuilder.append("{leaveChatType: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("}");
    localStringBuilder.append("{leftChatTime: ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("}");
    localStringBuilder.append("{timeStamp: ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("}");
    localStringBuilder.append("{matchExpired: ");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append("}");
    localStringBuilder.append("{c2cExpiredTime: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("}");
    localStringBuilder.append("{tipsWording: ");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("}");
    localStringBuilder.append("{readyTs: ");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.match.MatchNotifyInfo
 * JD-Core Version:    0.7.0.1
 */