package com.tencent.open.filedownload;

public class TaskInfo
{
  public String a = "6000";
  public String b = "0";
  public String c = "0";
  public String d = "default_via";
  public String e;
  public String f;
  public String g;
  public long h;
  public String i;
  public int j;
  public int k = 1;
  
  public static TaskInfo a(TaskInfo paramTaskInfo)
  {
    TaskInfo localTaskInfo = new TaskInfo();
    if (paramTaskInfo == null) {
      return localTaskInfo;
    }
    localTaskInfo.e = paramTaskInfo.e;
    localTaskInfo.f = paramTaskInfo.f;
    localTaskInfo.g = paramTaskInfo.g;
    localTaskInfo.h = paramTaskInfo.h;
    localTaskInfo.i = paramTaskInfo.i;
    localTaskInfo.j = paramTaskInfo.j;
    localTaskInfo.k = paramTaskInfo.k;
    localTaskInfo.c = paramTaskInfo.c;
    localTaskInfo.b = paramTaskInfo.b;
    localTaskInfo.a = paramTaskInfo.a;
    localTaskInfo.d = paramTaskInfo.d;
    return localTaskInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("pageId=");
    localStringBuilder2.append(this.a);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("\nmoduleId=");
    localStringBuilder2.append(this.b);
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
    localStringBuilder2.append(this.h);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("\nname=");
    localStringBuilder2.append(this.i);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("\nprogress=");
    localStringBuilder2.append(this.j);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("\nstate=");
    localStringBuilder2.append(this.k);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.filedownload.TaskInfo
 * JD-Core Version:    0.7.0.1
 */