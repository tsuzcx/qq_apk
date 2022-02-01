package com.tencent.mobileqq.kandian.biz.comment;

import android.text.TextUtils;

public class ReadInJoyCommentComponentFragment$UserBiuInfo
{
  public int a;
  public long a;
  public CharSequence a;
  public String a;
  public CharSequence b;
  
  public ReadInJoyCommentComponentFragment$UserBiuInfo(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment, String paramString, long paramLong, CharSequence paramCharSequence)
  {
    this(paramReadInJoyCommentComponentFragment, paramString, paramLong, paramCharSequence, 0);
  }
  
  public ReadInJoyCommentComponentFragment$UserBiuInfo(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment, String paramString, long paramLong, CharSequence paramCharSequence, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    paramReadInJoyCommentComponentFragment = paramCharSequence;
    if (paramCharSequence == null) {
      paramReadInJoyCommentComponentFragment = "";
    }
    this.b = paramReadInJoyCommentComponentFragment;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String toString()
  {
    int i;
    if (!TextUtils.isEmpty(this.b)) {
      i = this.b.length();
    } else {
      i = 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UserBiuInfo {uin=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", nickName=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangCharSequence);
    localStringBuilder.append(", comment=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", length=");
    localStringBuilder.append(i);
    localStringBuilder.append(", feedid=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentComponentFragment.UserBiuInfo
 * JD-Core Version:    0.7.0.1
 */