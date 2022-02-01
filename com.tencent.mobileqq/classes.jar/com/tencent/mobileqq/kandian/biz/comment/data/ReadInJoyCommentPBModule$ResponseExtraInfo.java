package com.tencent.mobileqq.kandian.biz.comment.data;

public class ReadInJoyCommentPBModule$ResponseExtraInfo
{
  public int a;
  public long a;
  public ReadInJoyCommentPBModule.Label a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public boolean b;
  
  public ReadInJoyCommentPBModule$ResponseExtraInfo()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ResponseExtraInfo{commentCnt=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", hideCommentCnt=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", showMaskPageNo=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", jumpSchema='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isPgcAuthor=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", label=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentDataReadInJoyCommentPBModule$Label.toString());
    localStringBuilder.append(", isShowLabel=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", defaultInput='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentPBModule.ResponseExtraInfo
 * JD-Core Version:    0.7.0.1
 */