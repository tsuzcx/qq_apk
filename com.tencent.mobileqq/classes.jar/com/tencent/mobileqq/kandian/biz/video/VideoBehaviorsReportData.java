package com.tencent.mobileqq.kandian.biz.video;

public class VideoBehaviorsReportData
{
  public int a;
  public int b;
  public int c;
  public long d;
  public boolean e;
  public boolean f;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("mSceneType: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mCurIndexDiff: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mPreIndexDiff: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mTimeInterval: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mIsPull: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mIsAutoPlay: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoBehaviorsReportData
 * JD-Core Version:    0.7.0.1
 */