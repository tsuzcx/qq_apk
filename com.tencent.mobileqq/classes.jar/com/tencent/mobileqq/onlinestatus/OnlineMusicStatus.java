package com.tencent.mobileqq.onlinestatus;

import android.support.annotation.NonNull;

public class OnlineMusicStatus
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  
  public OnlineMusicStatus()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MusicStatus[needConvert:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", , songId:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", songName:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", songType:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", singerName:");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(", remainTime:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", sourceType:");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", pauseFlag:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", duration:");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineMusicStatus
 * JD-Core Version:    0.7.0.1
 */