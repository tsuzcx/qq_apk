package com.tencent.mobileqq.kandian.biz.comment;

public class ReadInJoyCommentUtils$UserBiuInfo
{
  public String a;
  public CharSequence b;
  public CharSequence c;
  public long d;
  public int e;
  
  public ReadInJoyCommentUtils$UserBiuInfo(String paramString, long paramLong, CharSequence paramCharSequence)
  {
    this(paramString, paramLong, paramCharSequence, 0);
  }
  
  public ReadInJoyCommentUtils$UserBiuInfo(String paramString, long paramLong, CharSequence paramCharSequence, int paramInt)
  {
    this.a = paramString;
    this.d = paramLong;
    paramString = paramCharSequence;
    if (paramCharSequence == null) {
      paramString = "";
    }
    this.c = paramString;
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.UserBiuInfo
 * JD-Core Version:    0.7.0.1
 */