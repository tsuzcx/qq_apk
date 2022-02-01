package com.tencent.mobileqq.msgbackup.data;

public class MsgBackupSessionTask
{
  public int a;
  public long a;
  public String a;
  public short a;
  public boolean a;
  public long b;
  public String b;
  public boolean b;
  public String c;
  
  public MsgBackupSessionTask()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MsgBackupSessionTask[msg = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", cmd = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", isFileTask = ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", sessionId = ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", path = ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", url = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", retryTimes = ");
    localStringBuilder.append(this.jdField_a_of_type_Short);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupSessionTask
 * JD-Core Version:    0.7.0.1
 */