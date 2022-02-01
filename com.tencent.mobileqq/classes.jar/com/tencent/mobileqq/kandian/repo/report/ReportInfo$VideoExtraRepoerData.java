package com.tencent.mobileqq.kandian.repo.report;

public class ReportInfo$VideoExtraRepoerData
  implements Cloneable
{
  public int a;
  public boolean a;
  public int b;
  public boolean b;
  public int c = -1;
  public int d = -1;
  public int e = -1;
  public int f = -1;
  
  public ReportInfo$VideoExtraRepoerData()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoExtraRepoerData{JumpWayWhich=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", InOneThreeSource=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", videoTimePosition=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", videoDuration=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", needWhetherClickIn=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", whetherClickIn=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", InVideoChannelSource=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", videoFromType=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.report.ReportInfo.VideoExtraRepoerData
 * JD-Core Version:    0.7.0.1
 */