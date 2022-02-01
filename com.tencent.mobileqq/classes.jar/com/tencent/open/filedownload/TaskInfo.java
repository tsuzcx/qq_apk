package com.tencent.open.filedownload;

public class TaskInfo
{
  public int a;
  public long a;
  public String a;
  public int b;
  public String b;
  public String c = "0";
  public String d = "default_via";
  public String e;
  public String f;
  public String g;
  public String h;
  
  public TaskInfo()
  {
    this.jdField_a_of_type_JavaLangString = "6000";
    this.jdField_b_of_type_JavaLangString = "0";
    this.jdField_b_of_type_Int = 1;
  }
  
  public static TaskInfo a(TaskInfo paramTaskInfo)
  {
    TaskInfo localTaskInfo = new TaskInfo();
    if (paramTaskInfo == null) {
      return localTaskInfo;
    }
    localTaskInfo.e = paramTaskInfo.e;
    localTaskInfo.f = paramTaskInfo.f;
    localTaskInfo.g = paramTaskInfo.g;
    localTaskInfo.jdField_a_of_type_Long = paramTaskInfo.jdField_a_of_type_Long;
    localTaskInfo.h = paramTaskInfo.h;
    localTaskInfo.jdField_a_of_type_Int = paramTaskInfo.jdField_a_of_type_Int;
    localTaskInfo.jdField_b_of_type_Int = paramTaskInfo.jdField_b_of_type_Int;
    localTaskInfo.c = paramTaskInfo.c;
    localTaskInfo.jdField_b_of_type_JavaLangString = paramTaskInfo.jdField_b_of_type_JavaLangString;
    localTaskInfo.jdField_a_of_type_JavaLangString = paramTaskInfo.jdField_a_of_type_JavaLangString;
    localTaskInfo.d = paramTaskInfo.d;
    return localTaskInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pageId=" + this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\nmoduleId=" + this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\npositionId=" + this.c);
    localStringBuilder.append("\nvia=" + this.d);
    localStringBuilder.append("\nurl=" + this.e);
    localStringBuilder.append("\npackageName=" + this.f);
    localStringBuilder.append("\niconUrl=" + this.g);
    localStringBuilder.append("\nlength=" + this.jdField_a_of_type_Long);
    localStringBuilder.append("\nname=" + this.h);
    localStringBuilder.append("\nprogress=" + this.jdField_a_of_type_Int);
    localStringBuilder.append("\nstate=" + this.jdField_b_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.filedownload.TaskInfo
 * JD-Core Version:    0.7.0.1
 */