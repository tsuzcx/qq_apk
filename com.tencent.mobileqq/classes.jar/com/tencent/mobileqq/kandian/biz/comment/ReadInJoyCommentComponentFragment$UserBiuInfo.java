package com.tencent.mobileqq.kandian.biz.comment;

import android.text.TextUtils;

public class ReadInJoyCommentComponentFragment$UserBiuInfo
{
  public String a;
  public CharSequence b;
  public CharSequence c;
  public long d;
  public int e;
  
  public ReadInJoyCommentComponentFragment$UserBiuInfo(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment, String paramString, long paramLong, CharSequence paramCharSequence)
  {
    this(paramReadInJoyCommentComponentFragment, paramString, paramLong, paramCharSequence, 0);
  }
  
  public ReadInJoyCommentComponentFragment$UserBiuInfo(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment, String paramString, long paramLong, CharSequence paramCharSequence, int paramInt)
  {
    this.a = paramString;
    this.d = paramLong;
    paramReadInJoyCommentComponentFragment = paramCharSequence;
    if (paramCharSequence == null) {
      paramReadInJoyCommentComponentFragment = "";
    }
    this.c = paramReadInJoyCommentComponentFragment;
    this.e = paramInt;
  }
  
  public String toString()
  {
    int i;
    if (!TextUtils.isEmpty(this.c)) {
      i = this.c.length();
    } else {
      i = 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UserBiuInfo {uin=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", nickName=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", comment=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", length=");
    localStringBuilder.append(i);
    localStringBuilder.append(", feedid=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentComponentFragment.UserBiuInfo
 * JD-Core Version:    0.7.0.1
 */