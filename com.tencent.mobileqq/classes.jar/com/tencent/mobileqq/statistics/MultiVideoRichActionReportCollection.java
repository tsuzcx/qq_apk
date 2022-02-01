package com.tencent.mobileqq.statistics;

import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;

public class MultiVideoRichActionReportCollection
{
  static int jdField_a_of_type_Int = 0;
  private static long jdField_a_of_type_Long = 0L;
  static String jdField_a_of_type_JavaLangString = "";
  static boolean jdField_a_of_type_Boolean = false;
  public static int b = 1;
  private static long jdField_b_of_type_Long = 0L;
  private static String jdField_b_of_type_JavaLangString = "MultiVideoRichActionReportCollection";
  public static int c = 2;
  private static long jdField_c_of_type_Long = 0L;
  private static String jdField_c_of_type_JavaLangString = "";
  public static int d = 3;
  private static long jdField_d_of_type_Long = 0L;
  private static String jdField_d_of_type_JavaLangString = "";
  private static int jdField_e_of_type_Int = 0;
  private static String jdField_e_of_type_JavaLangString = "";
  private static String f = "";
  
  public static void a(int paramInt, String paramString)
  {
    AVLog.printDebugLog(jdField_b_of_type_JavaLangString, String.format("onConnected sessionType = %s, roomid = %s", new Object[] { Integer.valueOf(paramInt), paramString }));
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_JavaLangString = paramString;
    jdField_a_of_type_Int = paramInt;
    jdField_a_of_type_JavaLangString = paramString;
    paramInt = jdField_a_of_type_Int;
    if ((paramInt != 4) && (paramInt != 3))
    {
      if ((paramInt == 2) || (paramInt == 1)) {
        jdField_e_of_type_Int = jdField_c_of_type_Int;
      }
    }
    else {
      jdField_e_of_type_Int = jdField_d_of_type_Int;
    }
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface != null) {
      i = paramVideoAppInterface.b("BEAUTY_SKIN");
    } else {
      i = 0;
    }
    if (i > 0)
    {
      paramVideoAppInterface = new StringBuilder();
      paramVideoAppInterface.append(i);
      paramVideoAppInterface.append("");
      c(paramVideoAppInterface.toString());
    }
    int i = jdField_e_of_type_Int;
    if (i == jdField_c_of_type_Int)
    {
      if (jdField_a_of_type_Long == 0L) {
        a("0X8007F32");
      }
      if (jdField_b_of_type_Long == 0L) {
        a("0X8007F34");
      }
      if (jdField_c_of_type_Long == 0L) {
        a("0X8007F36");
      }
      if (jdField_d_of_type_Long == 0L) {
        a("0X8007E69");
      }
    }
    else if (i == jdField_d_of_type_Int)
    {
      if (jdField_a_of_type_Long == 0L) {
        a("0X8007F38");
      }
      if (jdField_b_of_type_Long == 0L) {
        a("0X8007F3A");
      }
      if (jdField_c_of_type_Long == 0L) {
        a("0X8007F3C");
      }
      if (jdField_d_of_type_Long == 0L) {
        a("0X8007E65");
      }
    }
  }
  
  public static void a(String paramString)
  {
    AVLog.printDebugLog(jdField_b_of_type_JavaLangString, String.format("reportClickEvent key = %s, type = %s, roomid = %s", new Object[] { paramString, "", jdField_a_of_type_JavaLangString }));
    ReportController.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", jdField_a_of_type_JavaLangString, "");
  }
  
  public static void a(String paramString1, String paramString2)
  {
    AVLog.printDebugLog(jdField_b_of_type_JavaLangString, String.format("reportClickEvent id = %s, type = %s, roomid = %s", new Object[] { paramString1, paramString2, jdField_a_of_type_JavaLangString }));
    ReportController.b(null, "dc00898", "", "", paramString1, paramString1, 0, 0, "", "", jdField_a_of_type_JavaLangString, paramString2);
  }
  
  public static void b(String paramString)
  {
    jdField_c_of_type_JavaLangString = paramString;
    jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public static void c(String paramString)
  {
    int i = jdField_e_of_type_Int;
    if (i == jdField_c_of_type_Int) {
      a("0X8007F35", paramString);
    } else if (i == jdField_d_of_type_Int) {
      a("0X8007F3B", paramString);
    }
    jdField_e_of_type_JavaLangString = paramString;
    jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  public static void d(String paramString)
  {
    int i = jdField_e_of_type_Int;
    if (i == jdField_c_of_type_Int) {
      a("0X8007E6A", paramString);
    } else if (i == jdField_d_of_type_Int) {
      a("0X8007E66", paramString);
    }
    f = paramString;
    jdField_d_of_type_Long = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.MultiVideoRichActionReportCollection
 * JD-Core Version:    0.7.0.1
 */