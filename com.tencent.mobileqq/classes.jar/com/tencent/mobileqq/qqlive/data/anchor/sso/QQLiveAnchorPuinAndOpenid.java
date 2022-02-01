package com.tencent.mobileqq.qqlive.data.anchor.sso;

public class QQLiveAnchorPuinAndOpenid
{
  public String pgcOpenid;
  public long pgcPuin;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQLiveAnchorPuinAndOpenid{pgcPuin=");
    localStringBuilder.append(this.pgcPuin);
    localStringBuilder.append(", pgcOpenid='");
    localStringBuilder.append(this.pgcOpenid);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorPuinAndOpenid
 * JD-Core Version:    0.7.0.1
 */