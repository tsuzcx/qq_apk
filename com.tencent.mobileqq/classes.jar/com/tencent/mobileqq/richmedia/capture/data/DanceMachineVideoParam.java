package com.tencent.mobileqq.richmedia.capture.data;

public class DanceMachineVideoParam
  extends VideoBusinessParam
{
  public int a;
  public String a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public DanceMachineVideoParam()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("danceScoreRate : ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\ndanceScore : ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\nptvCategory : ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\nptvId : ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" \nactivityType : ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\nactivityId : ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\noverPercent : ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\nuseSpecialShare : ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.DanceMachineVideoParam
 * JD-Core Version:    0.7.0.1
 */