package com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl;

import android.text.TextUtils;

class QQPublishCommentBridgeImpl$BiuCommentHelper$UserBiuInfo
{
  public int a;
  public long a;
  public CharSequence a;
  public String a;
  public CharSequence b;
  
  public QQPublishCommentBridgeImpl$BiuCommentHelper$UserBiuInfo(QQPublishCommentBridgeImpl.BiuCommentHelper paramBiuCommentHelper, String paramString, long paramLong, CharSequence paramCharSequence)
  {
    this(paramBiuCommentHelper, paramString, paramLong, paramCharSequence, 0);
  }
  
  public QQPublishCommentBridgeImpl$BiuCommentHelper$UserBiuInfo(QQPublishCommentBridgeImpl.BiuCommentHelper paramBiuCommentHelper, String paramString, long paramLong, CharSequence paramCharSequence, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    paramBiuCommentHelper = paramCharSequence;
    if (paramCharSequence == null) {
      paramBiuCommentHelper = "";
    }
    this.b = paramBiuCommentHelper;
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
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo
 * JD-Core Version:    0.7.0.1
 */