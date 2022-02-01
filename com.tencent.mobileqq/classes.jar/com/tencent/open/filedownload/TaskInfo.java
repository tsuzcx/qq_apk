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
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("pageId=");
    localStringBuilder2.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("\nmoduleId=");
    localStringBuilder2.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("\npositionId=");
    localStringBuilder2.append(this.c);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("\nvia=");
    localStringBuilder2.append(this.d);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("\nurl=");
    localStringBuilder2.append(this.e);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("\npackageName=");
    localStringBuilder2.append(this.f);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("\niconUrl=");
    localStringBuilder2.append(this.g);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("\nlength=");
    localStringBuilder2.append(this.jdField_a_of_type_Long);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("\nname=");
    localStringBuilder2.append(this.h);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("\nprogress=");
    localStringBuilder2.append(this.jdField_a_of_type_Int);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("\nstate=");
    localStringBuilder2.append(this.jdField_b_of_type_Int);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.filedownload.TaskInfo
 * JD-Core Version:    0.7.0.1
 */