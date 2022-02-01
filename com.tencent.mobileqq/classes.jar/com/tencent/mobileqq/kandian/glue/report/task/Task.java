package com.tencent.mobileqq.kandian.glue.report.task;

import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

public class Task
{
  public static int a = 0;
  public static int b = 1;
  public static int c = 2;
  public static int d = 3;
  public static int e = 4;
  public static int f = 5;
  public static int h = 0;
  public static int i = 1;
  public static int j = 2;
  public static int k = 3;
  public static int l = 4;
  public JSContext a;
  public String a;
  public ArrayList<Task.ConfigItem> a;
  public JSONObject a;
  public ArrayList<Task.ConfigItem> b = new ArrayList();
  public ArrayList<Task.ConfigItem> c = new ArrayList();
  public ArrayList<Task.ConfigItem> d = new ArrayList();
  public ArrayList<Task.ConfigItem> e = new ArrayList();
  public int g = jdField_a_of_type_Int;
  
  public Task()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Task{jsContext=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianGlueReportTaskJSContext);
    localStringBuilder.append(", id='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", config=");
    localStringBuilder.append(this.jdField_a_of_type_OrgJsonJSONObject);
    localStringBuilder.append(", filter=");
    localStringBuilder.append(Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray()));
    localStringBuilder.append(", extraction=");
    localStringBuilder.append(Arrays.toString(this.b.toArray()));
    localStringBuilder.append(", process=");
    localStringBuilder.append(Arrays.toString(this.c.toArray()));
    localStringBuilder.append(", distribution=");
    localStringBuilder.append(Arrays.toString(this.d.toArray()));
    localStringBuilder.append(", check=");
    localStringBuilder.append(Arrays.toString(this.e.toArray()));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.Task
 * JD-Core Version:    0.7.0.1
 */