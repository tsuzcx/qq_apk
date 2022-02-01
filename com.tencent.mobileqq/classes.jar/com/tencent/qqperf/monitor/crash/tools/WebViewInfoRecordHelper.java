package com.tencent.qqperf.monitor.crash.tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class WebViewInfoRecordHelper
{
  private static LinkedList<WebViewInfoRecordHelper> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private static int b;
  public int a;
  public long a;
  public String a;
  private SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("MM.dd HH:mm:ss.SSS");
  public String b;
  
  public WebViewInfoRecordHelper(long paramLong, String paramString1, String paramString2)
  {
    int j = 0;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    int i;
    if (paramString1 == null) {
      i = 0;
    } else {
      i = paramString1.getBytes().length;
    }
    if (paramString2 != null) {
      j = paramString2.getBytes().length;
    }
    this.jdField_a_of_type_Int = (i + 19 + 1 + j + 1);
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(10);
    while (jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
      localStringBuilder.append(((WebViewInfoRecordHelper)jdField_a_of_type_JavaUtilLinkedList.removeLast()).toString());
    }
    return localStringBuilder.toString();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() != 0) && (paramString2 != null))
    {
      if (paramString2.length() == 0) {
        return;
      }
      paramString1 = new WebViewInfoRecordHelper(System.currentTimeMillis(), paramString1, paramString2);
      jdField_a_of_type_JavaUtilLinkedList.add(paramString1);
      for (jdField_b_of_type_Int += paramString1.jdField_a_of_type_Int; (jdField_b_of_type_Int > 15360L) && (jdField_a_of_type_JavaUtilLinkedList.size() > 1); jdField_b_of_type_Int -= paramString1.jdField_a_of_type_Int) {
        paramString1 = (WebViewInfoRecordHelper)jdField_a_of_type_JavaUtilLinkedList.removeLast();
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    Date localDate = new Date(this.jdField_a_of_type_Long);
    localStringBuilder.append(this.jdField_a_of_type_JavaTextSimpleDateFormat.format(localDate));
    localStringBuilder.append(" ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.tools.WebViewInfoRecordHelper
 * JD-Core Version:    0.7.0.1
 */