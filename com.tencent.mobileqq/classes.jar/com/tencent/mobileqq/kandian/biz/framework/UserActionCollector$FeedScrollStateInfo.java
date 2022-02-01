package com.tencent.mobileqq.kandian.biz.framework;

public class UserActionCollector$FeedScrollStateInfo
{
  public double a;
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public int c = -2019;
  public int d = -2019;
  public int e = -2019;
  
  public UserActionCollector$FeedScrollStateInfo(UserActionCollector paramUserActionCollector)
  {
    this.jdField_b_of_type_Int = -2019;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nFeedScrollStateInfo{feedID='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", viewHeight=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", starTopOffset=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", endTopOffset=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", startBottomOffset=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", endBottomOffset=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", enterAZSpeed=");
    localStringBuilder.append(this.jdField_a_of_type_Double);
    localStringBuilder.append(", enterAZTime=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", exitAZTime=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.UserActionCollector.FeedScrollStateInfo
 * JD-Core Version:    0.7.0.1
 */