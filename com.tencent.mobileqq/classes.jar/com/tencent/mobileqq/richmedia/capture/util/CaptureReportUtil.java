package com.tencent.mobileqq.richmedia.capture.util;

import ahpi;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleDataManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategory;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.data.TemplateGroupItem;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport;
import com.tencent.mobileqq.statistics.CaptureReportController;
import com.tencent.mobileqq.statistics.reportitem.CaptureMsgReportItem;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CaptureReportUtil
{
  public static int a;
  public static long a;
  public static final SparseIntArray a;
  public static String a;
  public static boolean a;
  public static String b;
  public static boolean b;
  public static String c;
  public static boolean c;
  public static String d;
  public static boolean d;
  public static String e;
  public static boolean e;
  
  static
  {
    jdField_a_of_type_Int = -1;
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "";
    jdField_c_of_type_JavaLangString = "";
    jdField_d_of_type_JavaLangString = "";
    jdField_e_of_type_JavaLangString = "";
    jdField_a_of_type_Long = -1L;
    jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10000, 1);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10004, 2);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10001, 3);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10002, 4);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10007, 5);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10003, 6);
  }
  
  public static CaptureMsgReportItem a()
  {
    CaptureMsgReportItem localCaptureMsgReportItem = new CaptureMsgReportItem();
    localCaptureMsgReportItem.jdField_a_of_type_JavaLangString = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    localCaptureMsgReportItem.jdField_b_of_type_JavaLangString = "";
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "";
    localCaptureMsgReportItem.jdField_a_of_type_Int = jdField_a_of_type_AndroidUtilSparseIntArray.get(jdField_a_of_type_Int, -1);
    localCaptureMsgReportItem.jdField_e_of_type_JavaLangString = "${count_unknown}";
    localCaptureMsgReportItem.f = "";
    localCaptureMsgReportItem.g = "";
    localCaptureMsgReportItem.h = "";
    localCaptureMsgReportItem.i = "";
    localCaptureMsgReportItem.j = "";
    localCaptureMsgReportItem.k = "";
    localCaptureMsgReportItem.l = "";
    localCaptureMsgReportItem.m = "";
    localCaptureMsgReportItem.n = "";
    localCaptureMsgReportItem.o = "";
    localCaptureMsgReportItem.p = "";
    localCaptureMsgReportItem.q = "";
    localCaptureMsgReportItem.r = "";
    localCaptureMsgReportItem.s = "";
    localCaptureMsgReportItem.t = "";
    localCaptureMsgReportItem.u = "";
    return localCaptureMsgReportItem;
  }
  
  public static void a()
  {
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X8008423";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X8008423";
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  public static void a(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X8008754";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X8008754";
    localCaptureMsgReportItem.n = String.valueOf(paramInt);
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X8008430";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X8008430";
    localCaptureMsgReportItem.jdField_b_of_type_JavaLangString = paramString;
    if (localCaptureMsgReportItem.jdField_a_of_type_Int == 5) {
      localCaptureMsgReportItem.g = jdField_a_of_type_JavaLangString;
    }
    localCaptureMsgReportItem.h = jdField_b_of_type_JavaLangString;
    localCaptureMsgReportItem.i = jdField_c_of_type_JavaLangString;
    localCaptureMsgReportItem.j = jdField_d_of_type_JavaLangString;
    localCaptureMsgReportItem.k = jdField_e_of_type_JavaLangString;
    localCaptureMsgReportItem.l = (paramInt + "");
    localCaptureMsgReportItem.n = "";
    paramString = new StringBuilder();
    if (jdField_d_of_type_Boolean) {}
    for (int i = 2;; i = 1)
    {
      localCaptureMsgReportItem.m = (i + "");
      CaptureReportController.a(null, localCaptureMsgReportItem);
      if (jdField_a_of_type_Boolean)
      {
        localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X80083B2";
        localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X80083B2";
        CaptureReportController.a(null, localCaptureMsgReportItem);
      }
      QmcfManager.a().a(paramInt, jdField_a_of_type_Int, jdField_e_of_type_JavaLangString);
      return;
    }
  }
  
  public static void a(long paramLong, int paramInt)
  {
    if (jdField_b_of_type_Boolean)
    {
      CaptureMsgReportItem localCaptureMsgReportItem = a();
      localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X800893A";
      localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X800893A";
      localCaptureMsgReportItem.h = jdField_b_of_type_JavaLangString;
      localCaptureMsgReportItem.i = jdField_c_of_type_JavaLangString;
      localCaptureMsgReportItem.f = (paramInt + "");
      if (localCaptureMsgReportItem.jdField_a_of_type_Int == 5) {
        localCaptureMsgReportItem.g = jdField_a_of_type_JavaLangString;
      }
      localCaptureMsgReportItem.o = ((float)paramLong / 1000.0F + "");
      CaptureReportController.a(null, localCaptureMsgReportItem);
    }
  }
  
  public static void a(BoyDataReport paramBoyDataReport)
  {
    if (paramBoyDataReport != null) {
      ThreadManager.post(new ahpi(paramBoyDataReport), 5, null, false);
    }
  }
  
  public static void a(String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X8008425";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X8008425";
    localCaptureMsgReportItem.h = paramString;
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  public static void a(String paramString, long paramLong)
  {
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X8008939";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X8008939";
    localCaptureMsgReportItem.h = jdField_b_of_type_JavaLangString;
    localCaptureMsgReportItem.i = jdField_c_of_type_JavaLangString;
    if (localCaptureMsgReportItem.jdField_a_of_type_Int == 5) {
      localCaptureMsgReportItem.g = jdField_a_of_type_JavaLangString;
    }
    localCaptureMsgReportItem.j = paramString;
    localCaptureMsgReportItem.o = ((float)paramLong / 1000.0F + "");
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  private static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown";
    case 0: 
      return "miss";
    case 1: 
      return "good";
    case 2: 
      return "great";
    }
    return "perfect";
  }
  
  public static void b()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X8008424";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X8008424";
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  public static void b(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X8008429";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X8008429";
    localCaptureMsgReportItem.f = (paramInt + "");
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  public static void b(int paramInt, String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X8008433";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X8008433";
    localCaptureMsgReportItem.jdField_b_of_type_JavaLangString = paramString;
    localCaptureMsgReportItem.h = jdField_b_of_type_JavaLangString;
    localCaptureMsgReportItem.i = jdField_c_of_type_JavaLangString;
    localCaptureMsgReportItem.j = jdField_d_of_type_JavaLangString;
    localCaptureMsgReportItem.k = jdField_e_of_type_JavaLangString;
    if (localCaptureMsgReportItem.jdField_a_of_type_Int == 5) {
      localCaptureMsgReportItem.g = jdField_a_of_type_JavaLangString;
    }
    localCaptureMsgReportItem.l = (paramInt + "");
    paramString = new StringBuilder();
    if (jdField_c_of_type_Boolean) {}
    for (int i = 2;; i = 1)
    {
      localCaptureMsgReportItem.m = (i + "");
      localCaptureMsgReportItem.n = String.valueOf(SubtitleDataManager.a().c);
      localCaptureMsgReportItem.o = (jdField_a_of_type_Long + "");
      CaptureReportController.a(null, localCaptureMsgReportItem);
      if (jdField_a_of_type_Boolean)
      {
        localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X80083B1";
        localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X80083B1";
        CaptureReportController.a(null, localCaptureMsgReportItem);
      }
      QmcfManager.a().a(paramInt, jdField_a_of_type_Int, jdField_e_of_type_JavaLangString);
      return;
    }
  }
  
  private static void b(long paramLong1, long paramLong2)
  {
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X8008937";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X8008937";
    localCaptureMsgReportItem.h = jdField_b_of_type_JavaLangString;
    localCaptureMsgReportItem.i = jdField_c_of_type_JavaLangString;
    localCaptureMsgReportItem.j = ("" + paramLong1);
    if (localCaptureMsgReportItem.jdField_a_of_type_Int == 5) {
      localCaptureMsgReportItem.g = jdField_a_of_type_JavaLangString;
    }
    localCaptureMsgReportItem.o = (paramLong2 / 1000L + "");
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  public static void b(String paramString)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X8008427";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X8008427";
    localCaptureMsgReportItem.j = paramString;
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  private static void b(String paramString1, String paramString2, String paramString3)
  {
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X8008936";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X8008936";
    localCaptureMsgReportItem.h = jdField_b_of_type_JavaLangString;
    localCaptureMsgReportItem.i = jdField_c_of_type_JavaLangString;
    localCaptureMsgReportItem.j = paramString2;
    localCaptureMsgReportItem.k = paramString1;
    if (localCaptureMsgReportItem.jdField_a_of_type_Int == 5) {
      localCaptureMsgReportItem.g = jdField_a_of_type_JavaLangString;
    }
    localCaptureMsgReportItem.l = paramString3;
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  public static void c()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X8008753";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X8008753";
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  public static void c(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.f = (paramInt + "");
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X800842B";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X800842B";
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  public static void c(String paramString)
  {
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X8008938";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X8008938";
    localCaptureMsgReportItem.h = jdField_b_of_type_JavaLangString;
    localCaptureMsgReportItem.i = jdField_c_of_type_JavaLangString;
    if (localCaptureMsgReportItem.jdField_a_of_type_Int == 5) {
      localCaptureMsgReportItem.g = jdField_a_of_type_JavaLangString;
    }
    localCaptureMsgReportItem.j = paramString;
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  public static void d()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X8008426";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X8008426";
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  public static void d(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.f = (paramInt + "");
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X800842C";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X800842C";
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  public static void e()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X8008428";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X8008428";
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  public static void e(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    CaptureMsgReportItem localCaptureMsgReportItem;
    do
    {
      return;
      localCaptureMsgReportItem = a();
      localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X800842D";
      localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X800842D";
      if (localCaptureMsgReportItem.jdField_a_of_type_Int == 5) {
        localCaptureMsgReportItem.g = jdField_a_of_type_JavaLangString;
      }
      localCaptureMsgReportItem.h = jdField_b_of_type_JavaLangString;
      localCaptureMsgReportItem.i = jdField_c_of_type_JavaLangString;
      localCaptureMsgReportItem.j = jdField_d_of_type_JavaLangString;
      localCaptureMsgReportItem.k = jdField_e_of_type_JavaLangString;
      localCaptureMsgReportItem.g = jdField_a_of_type_JavaLangString;
      localCaptureMsgReportItem.l = (paramInt + "");
      CaptureReportController.a(null, localCaptureMsgReportItem);
    } while (!jdField_a_of_type_Boolean);
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X80083AE";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X80083AE";
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  public static void f()
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X800842A";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X800842A";
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  public static void f(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    CaptureMsgReportItem localCaptureMsgReportItem;
    do
    {
      return;
      localCaptureMsgReportItem = a();
      localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X800842D";
      localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X800842D";
      if (localCaptureMsgReportItem.jdField_a_of_type_Int == 5) {
        localCaptureMsgReportItem.g = jdField_a_of_type_JavaLangString;
      }
      localCaptureMsgReportItem.h = jdField_b_of_type_JavaLangString;
      localCaptureMsgReportItem.i = jdField_c_of_type_JavaLangString;
      localCaptureMsgReportItem.j = jdField_d_of_type_JavaLangString;
      localCaptureMsgReportItem.k = jdField_e_of_type_JavaLangString;
      localCaptureMsgReportItem.l = (paramInt + "");
      CaptureReportController.a(null, localCaptureMsgReportItem);
    } while (!jdField_a_of_type_Boolean);
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X80083AE";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X80083AE";
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  public static void g()
  {
    if (jdField_a_of_type_Int == 10002) {
      StoryReportor.a("video_edit", "camera_clkdouble", 0, 0, new String[0]);
    }
  }
  
  public static void g(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    CaptureMsgReportItem localCaptureMsgReportItem;
    do
    {
      return;
      localCaptureMsgReportItem = a();
      localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X800842E";
      localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X800842E";
      if (localCaptureMsgReportItem.jdField_a_of_type_Int == 5) {
        localCaptureMsgReportItem.g = jdField_a_of_type_JavaLangString;
      }
      localCaptureMsgReportItem.h = jdField_b_of_type_JavaLangString;
      localCaptureMsgReportItem.i = jdField_c_of_type_JavaLangString;
      localCaptureMsgReportItem.j = jdField_d_of_type_JavaLangString;
      localCaptureMsgReportItem.k = jdField_e_of_type_JavaLangString;
      localCaptureMsgReportItem.l = (paramInt + "");
      CaptureReportController.a(null, localCaptureMsgReportItem);
    } while (!jdField_a_of_type_Boolean);
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X80083B0";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X80083B0";
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  public static void h()
  {
    Object localObject;
    int i;
    if ((TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(jdField_c_of_type_JavaLangString)))
    {
      localObject = CapturePtvTemplateManager.a();
      i = ((CapturePtvTemplateManager)localObject).a();
      if (i == -1) {
        break label137;
      }
      localObject = ((CapturePtvTemplateManager)localObject).a(i);
    }
    for (;;)
    {
      if (localObject == null)
      {
        jdField_b_of_type_JavaLangString = "";
        jdField_c_of_type_JavaLangString = "";
        if (QLog.isColorLevel()) {
          QLog.d("CaptureReportUtil", 2, "error templateGroup is null");
        }
        label68:
        if ((TextUtils.isEmpty(jdField_d_of_type_JavaLangString)) || (TextUtils.isEmpty(jdField_e_of_type_JavaLangString)))
        {
          localObject = CaptureVideoFilterManager.a();
          i = ((CaptureVideoFilterManager)localObject).a();
          if (i == -1) {
            break label195;
          }
          localObject = ((CaptureVideoFilterManager)localObject).a(i);
        }
      }
      for (;;)
      {
        if (localObject == null)
        {
          jdField_d_of_type_JavaLangString = "";
          jdField_e_of_type_JavaLangString = "";
          if (QLog.isColorLevel()) {
            QLog.d("CaptureReportUtil", 2, "error templateGroup is null");
          }
          return;
          label137:
          localObject = ((CapturePtvTemplateManager)localObject).a();
          if (((ArrayList)localObject).size() <= 0) {
            break label273;
          }
          localObject = (TemplateGroupItem)((ArrayList)localObject).get(0);
          break;
          jdField_b_of_type_JavaLangString = ((TemplateGroupItem)localObject).jdField_a_of_type_Int + "";
          jdField_c_of_type_JavaLangString = "0";
          break label68;
          label195:
          localObject = ((CaptureVideoFilterManager)localObject).a();
          if (((List)localObject).size() <= 0) {
            break label268;
          }
          localObject = (FilterCategory)((List)localObject).get(0);
          continue;
        }
        jdField_d_of_type_JavaLangString = ((FilterCategory)localObject).jdField_a_of_type_Int + "";
        jdField_e_of_type_JavaLangString = ((FilterCategoryItem)((FilterCategory)localObject).jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString;
        return;
        label268:
        localObject = null;
      }
      label273:
      localObject = null;
    }
  }
  
  public static void h(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X800842F";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X800842F";
    if (localCaptureMsgReportItem.jdField_a_of_type_Int == 5) {
      localCaptureMsgReportItem.g = jdField_a_of_type_JavaLangString;
    }
    localCaptureMsgReportItem.h = jdField_b_of_type_JavaLangString;
    localCaptureMsgReportItem.i = jdField_c_of_type_JavaLangString;
    localCaptureMsgReportItem.j = jdField_d_of_type_JavaLangString;
    localCaptureMsgReportItem.k = jdField_e_of_type_JavaLangString;
    localCaptureMsgReportItem.l = (paramInt + "");
    StringBuilder localStringBuilder = new StringBuilder();
    if (jdField_d_of_type_Boolean) {}
    for (paramInt = 2;; paramInt = 1)
    {
      localCaptureMsgReportItem.m = (paramInt + "");
      CaptureReportController.a(null, localCaptureMsgReportItem);
      return;
    }
  }
  
  public static void i()
  {
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X8008F10";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X8008F10";
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  public static void i(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {}
    CaptureMsgReportItem localCaptureMsgReportItem;
    do
    {
      return;
      localCaptureMsgReportItem = a();
      localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X8008431";
      localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X8008431";
      if (localCaptureMsgReportItem.jdField_a_of_type_Int == 5) {
        localCaptureMsgReportItem.g = jdField_a_of_type_JavaLangString;
      }
      localCaptureMsgReportItem.h = jdField_b_of_type_JavaLangString;
      localCaptureMsgReportItem.i = jdField_c_of_type_JavaLangString;
      localCaptureMsgReportItem.j = jdField_d_of_type_JavaLangString;
      localCaptureMsgReportItem.k = jdField_e_of_type_JavaLangString;
      localCaptureMsgReportItem.l = (paramInt + "");
      localCaptureMsgReportItem.n = String.valueOf(SubtitleDataManager.a().c);
      localCaptureMsgReportItem.o = (jdField_a_of_type_Long + "");
      CaptureReportController.a(null, localCaptureMsgReportItem);
    } while (!jdField_a_of_type_Boolean);
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X80083AF";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X80083AF";
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  public static void j()
  {
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X8008F11";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X8008F11";
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  public static void j(int paramInt)
  {
    if (!jdField_e_of_type_Boolean) {
      return;
    }
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X8008432";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X8008432";
    localCaptureMsgReportItem.h = jdField_b_of_type_JavaLangString;
    localCaptureMsgReportItem.i = jdField_c_of_type_JavaLangString;
    localCaptureMsgReportItem.j = jdField_d_of_type_JavaLangString;
    localCaptureMsgReportItem.k = jdField_e_of_type_JavaLangString;
    if (localCaptureMsgReportItem.jdField_a_of_type_Int == 5) {
      localCaptureMsgReportItem.g = jdField_a_of_type_JavaLangString;
    }
    localCaptureMsgReportItem.l = (paramInt + "");
    StringBuilder localStringBuilder = new StringBuilder();
    if (jdField_c_of_type_Boolean) {}
    for (paramInt = 2;; paramInt = 1)
    {
      localCaptureMsgReportItem.m = (paramInt + "");
      localCaptureMsgReportItem.n = String.valueOf(SubtitleDataManager.a().c);
      localCaptureMsgReportItem.o = (jdField_a_of_type_Long + "");
      CaptureReportController.a(null, localCaptureMsgReportItem);
      return;
    }
  }
  
  public static void k()
  {
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X8008F12";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X8008F12";
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  public static void l()
  {
    CaptureMsgReportItem localCaptureMsgReportItem = a();
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X800901B";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X800901B";
    localCaptureMsgReportItem.h = jdField_b_of_type_JavaLangString;
    localCaptureMsgReportItem.i = jdField_c_of_type_JavaLangString;
    localCaptureMsgReportItem.j = jdField_d_of_type_JavaLangString;
    localCaptureMsgReportItem.k = jdField_e_of_type_JavaLangString;
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  public static void m()
  {
    jdField_a_of_type_Int = -1;
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "";
    jdField_c_of_type_JavaLangString = "";
    jdField_d_of_type_JavaLangString = "";
    jdField_e_of_type_JavaLangString = "";
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_Long = -1L;
    jdField_d_of_type_Boolean = false;
    jdField_c_of_type_Boolean = false;
    jdField_e_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil
 * JD-Core Version:    0.7.0.1
 */