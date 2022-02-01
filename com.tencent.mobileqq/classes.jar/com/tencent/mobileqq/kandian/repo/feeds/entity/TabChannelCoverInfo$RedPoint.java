package com.tencent.mobileqq.kandian.repo.feeds.entity;

public class TabChannelCoverInfo$RedPoint
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public int c;
  public long c;
  
  public TabChannelCoverInfo$RedPoint()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RedPoint{isShow=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", startTimestamp=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", animationTimestamp=");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append(", endTimestamp=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", titleText=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", titleColor=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", titleBgColor=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo.RedPoint
 * JD-Core Version:    0.7.0.1
 */