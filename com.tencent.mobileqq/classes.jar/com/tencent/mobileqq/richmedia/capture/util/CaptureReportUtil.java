package com.tencent.mobileqq.richmedia.capture.util;

import android.util.SparseIntArray;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.statistics.CaptureReportController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.reportitem.CaptureMsgReportItem;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelItemInfo;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_Long = -1L;
    jdField_c_of_type_Boolean = false;
    jdField_d_of_type_Boolean = false;
    jdField_e_of_type_Boolean = false;
    jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10000, 1);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10004, 2);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10001, 3);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10002, 4);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10007, 5);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10003, 6);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10012, 7);
    jdField_a_of_type_AndroidUtilSparseIntArray.put(10013, 8);
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
    localCaptureMsgReportItem.f = (paramInt + "");
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X800842B";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X800842B";
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
      QmcfManager.getInstance().reportQmcfFrameConsume(paramInt, jdField_a_of_type_Int, jdField_e_of_type_JavaLangString);
      return;
    }
  }
  
  public static void a(EditVideoPartManager paramEditVideoPartManager)
  {
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.a != null) && (paramEditVideoPartManager.a.jdField_a_of_type_Int == 14)) {
      if (paramEditVideoPartManager.a()) {
        break label57;
      }
    }
    label57:
    for (int i = 1;; i = 2)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A55F", "0X800A55F", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(EditVideoPartManager paramEditVideoPartManager, SendPanelItemInfo paramSendPanelItemInfo)
  {
    if (paramSendPanelItemInfo == null) {}
    while ((paramEditVideoPartManager == null) || (paramEditVideoPartManager.a == null) || (paramEditVideoPartManager.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (paramSendPanelItemInfo.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A55C", "0X800A55C", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(SendPanelItemInfo paramSendPanelItemInfo)
  {
    c(null, paramSendPanelItemInfo);
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
  
  public static void b()
  {
    if (jdField_a_of_type_Int == 10002) {
      StoryReportor.a("video_edit", "camera_clkdouble", 0, 0, new String[0]);
    }
  }
  
  public static void b(int paramInt)
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
      localCaptureMsgReportItem.o = (jdField_a_of_type_Long + "");
      CaptureReportController.a(null, localCaptureMsgReportItem);
      if (jdField_a_of_type_Boolean)
      {
        localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X80083B1";
        localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X80083B1";
        CaptureReportController.a(null, localCaptureMsgReportItem);
      }
      QmcfManager.getInstance().reportQmcfFrameConsume(paramInt, jdField_a_of_type_Int, jdField_e_of_type_JavaLangString);
      return;
    }
  }
  
  public static void b(EditVideoPartManager paramEditVideoPartManager)
  {
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.a != null) && (paramEditVideoPartManager.a.jdField_a_of_type_Int == 14)) {
      if (paramEditVideoPartManager.a()) {
        break label57;
      }
    }
    label57:
    for (int i = 1;; i = 2)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A55E", "0X800A55E", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void b(EditVideoPartManager paramEditVideoPartManager, SendPanelItemInfo paramSendPanelItemInfo)
  {
    if (paramSendPanelItemInfo == null) {}
    while ((paramEditVideoPartManager == null) || (paramEditVideoPartManager.a == null) || (paramEditVideoPartManager.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (paramSendPanelItemInfo.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A55B", "0X800A55B", i, 0, "", "", "", "");
      return;
    }
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
  
  public static void c()
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
  
  public static void c(int paramInt)
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
  
  public static void c(EditVideoPartManager paramEditVideoPartManager)
  {
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.a != null) && (paramEditVideoPartManager.a.jdField_a_of_type_Int == 14)) {
      ReportController.b(null, "dc00898", "", "", "0X800A55D", "0X800A55D", 0, 0, "", "", "", "");
    }
  }
  
  public static void c(EditVideoPartManager paramEditVideoPartManager, SendPanelItemInfo paramSendPanelItemInfo)
  {
    int i = 1;
    if (paramSendPanelItemInfo == null) {}
    while ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.a != null) && (paramEditVideoPartManager.a.jdField_a_of_type_Int != 14)) {
      return;
    }
    if (paramSendPanelItemInfo.jdField_a_of_type_Int == 1)
    {
      paramEditVideoPartManager = "2";
      if (!paramSendPanelItemInfo.jdField_a_of_type_Boolean) {
        break label91;
      }
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A55A", "0X800A55A", i, 0, paramEditVideoPartManager, "", "", "");
      return;
      if (paramSendPanelItemInfo.jdField_a_of_type_Int == 0)
      {
        paramEditVideoPartManager = "1";
        break;
      }
      paramEditVideoPartManager = "3";
      break;
      label91:
      i = 2;
    }
  }
  
  public static void d(int paramInt)
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
  
  public static void d(EditVideoPartManager paramEditVideoPartManager)
  {
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.a != null) && (paramEditVideoPartManager.a.jdField_a_of_type_Int == 14)) {
      if (paramEditVideoPartManager.a()) {
        break label57;
      }
    }
    label57:
    for (int i = 1;; i = 2)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A559", "0X800A559", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void e(int paramInt)
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
  
  public static void e(EditVideoPartManager paramEditVideoPartManager)
  {
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.a != null) && (paramEditVideoPartManager.a.jdField_a_of_type_Int == 14)) {
      ReportController.b(null, "dc00898", "", "", "0X800A558", "0X800A558", 0, 0, "", "", "", "");
    }
  }
  
  public static void f(int paramInt)
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
      localCaptureMsgReportItem.o = (jdField_a_of_type_Long + "");
      CaptureReportController.a(null, localCaptureMsgReportItem);
    } while (!jdField_a_of_type_Boolean);
    localCaptureMsgReportItem.jdField_c_of_type_JavaLangString = "0X80083AF";
    localCaptureMsgReportItem.jdField_d_of_type_JavaLangString = "0X80083AF";
    CaptureReportController.a(null, localCaptureMsgReportItem);
  }
  
  public static void f(EditVideoPartManager paramEditVideoPartManager)
  {
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.a != null) && (paramEditVideoPartManager.a.jdField_a_of_type_Int == 14)) {
      ReportController.b(null, "dc00898", "", "", "0X800A557", "0X800A557", 0, 0, "", "", "", "");
    }
  }
  
  public static void g(int paramInt)
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
      localCaptureMsgReportItem.o = (jdField_a_of_type_Long + "");
      CaptureReportController.a(null, localCaptureMsgReportItem);
      return;
    }
  }
  
  public static void g(EditVideoPartManager paramEditVideoPartManager)
  {
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.a != null) && (paramEditVideoPartManager.a.jdField_a_of_type_Int == 14)) {
      ReportController.b(null, "dc00898", "", "", "0X800A556", "0X800A556", 0, 0, "", "", "", "");
    }
  }
  
  public static void h(EditVideoPartManager paramEditVideoPartManager)
  {
    if ((paramEditVideoPartManager != null) && (paramEditVideoPartManager.a != null) && (paramEditVideoPartManager.a.jdField_a_of_type_Int == 14)) {
      ReportController.b(null, "dc00898", "", "", "0X800A555", "0X800A555", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil
 * JD-Core Version:    0.7.0.1
 */