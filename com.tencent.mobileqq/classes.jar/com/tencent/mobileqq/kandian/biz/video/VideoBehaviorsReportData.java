package com.tencent.mobileqq.kandian.biz.video;

public class VideoBehaviorsReportData
{
  public int a;
  public long a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("mSceneType: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mCurIndexDiff: ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", mPreIndexDiff: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mTimeInterval: ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", mIsPull: ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", mIsAutoPlay: ");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoBehaviorsReportData
 * JD-Core Version:    0.7.0.1
 */