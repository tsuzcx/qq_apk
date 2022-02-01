package com.tencent.mobileqq.kandian.glue.report.task;

import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

public class Task
{
  public static int c = 0;
  public static int d = 1;
  public static int e = 2;
  public static int f = 3;
  public static int g = 4;
  public static int h = 5;
  public static int j = 0;
  public static int k = 1;
  public static int l = 2;
  public static int m = 3;
  public static int n = 4;
  public JSContext a;
  public String b;
  public int i = c;
  public JSONObject o;
  public ArrayList<Task.ConfigItem> p = new ArrayList();
  public ArrayList<Task.ConfigItem> q = new ArrayList();
  public ArrayList<Task.ConfigItem> r = new ArrayList();
  public ArrayList<Task.ConfigItem> s = new ArrayList();
  public ArrayList<Task.ConfigItem> t = new ArrayList();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Task{jsContext=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", id='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", config=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", filter=");
    localStringBuilder.append(Arrays.toString(this.p.toArray()));
    localStringBuilder.append(", extraction=");
    localStringBuilder.append(Arrays.toString(this.q.toArray()));
    localStringBuilder.append(", process=");
    localStringBuilder.append(Arrays.toString(this.r.toArray()));
    localStringBuilder.append(", distribution=");
    localStringBuilder.append(Arrays.toString(this.s.toArray()));
    localStringBuilder.append(", check=");
    localStringBuilder.append(Arrays.toString(this.t.toArray()));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.Task
 * JD-Core Version:    0.7.0.1
 */