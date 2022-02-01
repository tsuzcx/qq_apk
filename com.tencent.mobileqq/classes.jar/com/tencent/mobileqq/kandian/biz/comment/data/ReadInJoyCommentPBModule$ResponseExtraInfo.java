package com.tencent.mobileqq.kandian.biz.comment.data;

public class ReadInJoyCommentPBModule$ResponseExtraInfo
{
  public long a;
  public long b;
  public int c = -1;
  public String d;
  public boolean e;
  public ReadInJoyCommentPBModule.Label f;
  public boolean g;
  public String h;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ResponseExtraInfo{commentCnt=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", hideCommentCnt=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", showMaskPageNo=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", jumpSchema='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isPgcAuthor=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", label=");
    localStringBuilder.append(this.f.toString());
    localStringBuilder.append(", isShowLabel=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", defaultInput='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentPBModule.ResponseExtraInfo
 * JD-Core Version:    0.7.0.1
 */