package com.tencent.open.business.cgireport;

import alnn;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.OpenConfig;
import java.util.ArrayList;
import java.util.Random;

public class ReportManager
{
  protected static ReportManager a;
  public static final String a;
  public int a;
  protected long a;
  public ReportDataModal a;
  public volatile ArrayList a;
  protected Random a;
  public boolean a;
  protected volatile ArrayList b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = ReportManager.class.getName();
  }
  
  public ReportManager()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal = new ReportDataModal();
    this.jdField_a_of_type_JavaUtilRandom = new Random();
  }
  
  public static ReportManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenBusinessCgireportReportManager == null) {
        jdField_a_of_type_ComTencentOpenBusinessCgireportReportManager = new ReportManager();
      }
      ReportManager localReportManager = jdField_a_of_type_ComTencentOpenBusinessCgireportReportManager;
      return localReportManager;
    }
    finally {}
  }
  
  protected int a(int paramInt)
  {
    if (paramInt == 0)
    {
      i = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_CGIReportFrequencySuccess");
      LogUtility.c("OpenConfig_agent", "config 4:Common_CGIReportFrequencySuccess     config_value:" + i);
      paramInt = i;
      if (i == 0) {
        paramInt = 10;
      }
      LogUtility.c("OpenConfig_agent", "config 4:Common_CGIReportFrequencySuccess     result_value:" + paramInt);
      return paramInt;
    }
    int i = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_CGIReportFrequencyFailed");
    LogUtility.c("OpenConfig_agent", "config 4:Common_CGIReportFrequencyFailed     config_value:" + i);
    paramInt = i;
    if (i == 0) {
      paramInt = 100;
    }
    LogUtility.c("OpenConfig_agent", "config 4:Common_CGIReportFrequencyFailed     result_value:" + paramInt);
    return paramInt;
  }
  
  /* Error */
  protected Bundle a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 110
    //   4: ldc 112
    //   6: invokestatic 114	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 46	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal	Lcom/tencent/open/business/cgireport/ReportDataModal;
    //   14: aload_1
    //   15: invokevirtual 117	com/tencent/open/business/cgireport/ReportDataModal:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   18: putfield 39	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   21: aload_0
    //   22: getfield 46	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal	Lcom/tencent/open/business/cgireport/ReportDataModal;
    //   25: aload_1
    //   26: invokevirtual 120	com/tencent/open/business/cgireport/ReportDataModal:b	(Ljava/lang/String;)Z
    //   29: pop
    //   30: aload_0
    //   31: getfield 39	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   34: invokevirtual 124	java/util/ArrayList:size	()I
    //   37: ifgt +16 -> 53
    //   40: ldc 110
    //   42: ldc 126
    //   44: invokestatic 114	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: areturn
    //   53: aload_0
    //   54: aload_0
    //   55: getfield 46	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal	Lcom/tencent/open/business/cgireport/ReportDataModal;
    //   58: aload_1
    //   59: invokevirtual 128	com/tencent/open/business/cgireport/ReportDataModal:b	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   62: putfield 41	com/tencent/open/business/cgireport/ReportManager:b	Ljava/util/ArrayList;
    //   65: aload_0
    //   66: getfield 46	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal	Lcom/tencent/open/business/cgireport/ReportDataModal;
    //   69: aload_1
    //   70: invokevirtual 130	com/tencent/open/business/cgireport/ReportDataModal:a	(Ljava/lang/String;)Z
    //   73: pop
    //   74: new 132	android/os/Bundle
    //   77: dup
    //   78: invokespecial 133	android/os/Bundle:<init>	()V
    //   81: astore 4
    //   83: aload 4
    //   85: ldc 135
    //   87: aload_1
    //   88: invokevirtual 138	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload 4
    //   93: ldc 140
    //   95: getstatic 143	com/tencent/open/business/cgireport/ReportComm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   98: invokevirtual 138	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload 4
    //   103: ldc 145
    //   105: getstatic 150	android/os/Build:DEVICE	Ljava/lang/String;
    //   108: invokevirtual 138	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload 4
    //   113: ldc 152
    //   115: getstatic 154	com/tencent/open/business/cgireport/ReportComm:b	Ljava/lang/String;
    //   118: invokevirtual 138	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: aload 4
    //   123: ldc 156
    //   125: ldc 158
    //   127: invokevirtual 138	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: iconst_0
    //   131: istore_2
    //   132: iload_2
    //   133: aload_0
    //   134: getfield 39	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   137: invokevirtual 124	java/util/ArrayList:size	()I
    //   140: if_icmpge +416 -> 556
    //   143: aload 4
    //   145: new 78	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   152: iload_2
    //   153: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: ldc 160
    //   158: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: aload_0
    //   165: getfield 39	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   168: iload_2
    //   169: invokevirtual 164	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   172: checkcast 166	com/tencent/open/business/cgireport/reportItem
    //   175: getfield 167	com/tencent/open/business/cgireport/reportItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   178: invokevirtual 138	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload 4
    //   183: new 78	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   190: iload_2
    //   191: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: ldc 169
    //   196: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: aload_0
    //   203: getfield 39	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   206: iload_2
    //   207: invokevirtual 164	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   210: checkcast 166	com/tencent/open/business/cgireport/reportItem
    //   213: getfield 170	com/tencent/open/business/cgireport/reportItem:b	Ljava/lang/String;
    //   216: invokevirtual 138	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload 4
    //   221: new 78	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   228: iload_2
    //   229: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   232: ldc 172
    //   234: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: aload_0
    //   241: getfield 39	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   244: iload_2
    //   245: invokevirtual 164	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   248: checkcast 166	com/tencent/open/business/cgireport/reportItem
    //   251: getfield 174	com/tencent/open/business/cgireport/reportItem:c	Ljava/lang/String;
    //   254: invokevirtual 138	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: aload 4
    //   259: new 78	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   266: iload_2
    //   267: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   270: ldc 176
    //   272: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: aload_0
    //   279: getfield 39	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   282: iload_2
    //   283: invokevirtual 164	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   286: checkcast 166	com/tencent/open/business/cgireport/reportItem
    //   289: getfield 179	com/tencent/open/business/cgireport/reportItem:d	Ljava/lang/String;
    //   292: invokevirtual 138	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: aload 4
    //   297: new 78	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   304: iload_2
    //   305: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   308: ldc 181
    //   310: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: aload_0
    //   317: getfield 39	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   320: iload_2
    //   321: invokevirtual 164	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   324: checkcast 166	com/tencent/open/business/cgireport/reportItem
    //   327: getfield 184	com/tencent/open/business/cgireport/reportItem:e	Ljava/lang/String;
    //   330: invokevirtual 138	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   333: aload 4
    //   335: new 78	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   342: iload_2
    //   343: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   346: ldc 186
    //   348: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: aload_0
    //   355: getfield 39	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   358: iload_2
    //   359: invokevirtual 164	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   362: checkcast 166	com/tencent/open/business/cgireport/reportItem
    //   365: getfield 189	com/tencent/open/business/cgireport/reportItem:f	Ljava/lang/String;
    //   368: invokevirtual 138	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: aload 4
    //   373: new 78	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   380: iload_2
    //   381: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   384: ldc 191
    //   386: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: aload_0
    //   393: getfield 39	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   396: iload_2
    //   397: invokevirtual 164	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   400: checkcast 166	com/tencent/open/business/cgireport/reportItem
    //   403: getfield 194	com/tencent/open/business/cgireport/reportItem:g	Ljava/lang/String;
    //   406: invokevirtual 138	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   409: aload 4
    //   411: new 78	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   418: iload_2
    //   419: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   422: ldc 196
    //   424: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: aload_0
    //   431: getfield 39	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   434: iload_2
    //   435: invokevirtual 164	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   438: checkcast 166	com/tencent/open/business/cgireport/reportItem
    //   441: getfield 199	com/tencent/open/business/cgireport/reportItem:j	Ljava/lang/String;
    //   444: invokevirtual 138	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: aload 4
    //   449: new 78	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   456: iload_2
    //   457: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   460: ldc 201
    //   462: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: aload_0
    //   469: getfield 39	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   472: iload_2
    //   473: invokevirtual 164	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   476: checkcast 166	com/tencent/open/business/cgireport/reportItem
    //   479: getfield 204	com/tencent/open/business/cgireport/reportItem:h	Ljava/lang/String;
    //   482: invokevirtual 138	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   485: new 78	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   492: invokestatic 208	com/tencent/open/business/base/MobileInfoUtil:h	()Ljava/lang/String;
    //   495: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: ldc 210
    //   500: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: aload_0
    //   504: getfield 39	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   507: iload_2
    //   508: invokevirtual 164	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   511: checkcast 166	com/tencent/open/business/cgireport/reportItem
    //   514: getfield 213	com/tencent/open/business/cgireport/reportItem:i	Ljava/lang/String;
    //   517: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: astore_1
    //   524: aload 4
    //   526: new 78	java/lang/StringBuilder
    //   529: dup
    //   530: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   533: iload_2
    //   534: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   537: ldc 215
    //   539: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   545: aload_1
    //   546: invokevirtual 138	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   549: iload_2
    //   550: iconst_1
    //   551: iadd
    //   552: istore_2
    //   553: goto -421 -> 132
    //   556: aload_0
    //   557: getfield 39	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   560: invokevirtual 124	java/util/ArrayList:size	()I
    //   563: istore_2
    //   564: iload_2
    //   565: aload_0
    //   566: getfield 41	com/tencent/open/business/cgireport/ReportManager:b	Ljava/util/ArrayList;
    //   569: invokevirtual 124	java/util/ArrayList:size	()I
    //   572: aload_0
    //   573: getfield 39	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   576: invokevirtual 124	java/util/ArrayList:size	()I
    //   579: iadd
    //   580: if_icmpge +441 -> 1021
    //   583: iload_2
    //   584: aload_0
    //   585: getfield 39	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   588: invokevirtual 124	java/util/ArrayList:size	()I
    //   591: isub
    //   592: istore_3
    //   593: aload 4
    //   595: new 78	java/lang/StringBuilder
    //   598: dup
    //   599: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   602: iload_2
    //   603: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   606: ldc 160
    //   608: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   614: aload_0
    //   615: getfield 41	com/tencent/open/business/cgireport/ReportManager:b	Ljava/util/ArrayList;
    //   618: iload_3
    //   619: invokevirtual 164	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   622: checkcast 166	com/tencent/open/business/cgireport/reportItem
    //   625: getfield 167	com/tencent/open/business/cgireport/reportItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   628: invokevirtual 138	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   631: aload 4
    //   633: new 78	java/lang/StringBuilder
    //   636: dup
    //   637: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   640: iload_2
    //   641: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   644: ldc 169
    //   646: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   652: aload_0
    //   653: getfield 41	com/tencent/open/business/cgireport/ReportManager:b	Ljava/util/ArrayList;
    //   656: iload_3
    //   657: invokevirtual 164	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   660: checkcast 166	com/tencent/open/business/cgireport/reportItem
    //   663: getfield 170	com/tencent/open/business/cgireport/reportItem:b	Ljava/lang/String;
    //   666: invokevirtual 138	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   669: aload 4
    //   671: new 78	java/lang/StringBuilder
    //   674: dup
    //   675: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   678: iload_2
    //   679: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   682: ldc 172
    //   684: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   690: aload_0
    //   691: getfield 41	com/tencent/open/business/cgireport/ReportManager:b	Ljava/util/ArrayList;
    //   694: iload_3
    //   695: invokevirtual 164	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   698: checkcast 166	com/tencent/open/business/cgireport/reportItem
    //   701: getfield 174	com/tencent/open/business/cgireport/reportItem:c	Ljava/lang/String;
    //   704: invokevirtual 138	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   707: aload 4
    //   709: new 78	java/lang/StringBuilder
    //   712: dup
    //   713: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   716: iload_2
    //   717: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   720: ldc 176
    //   722: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   728: aload_0
    //   729: getfield 41	com/tencent/open/business/cgireport/ReportManager:b	Ljava/util/ArrayList;
    //   732: iload_3
    //   733: invokevirtual 164	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   736: checkcast 166	com/tencent/open/business/cgireport/reportItem
    //   739: getfield 179	com/tencent/open/business/cgireport/reportItem:d	Ljava/lang/String;
    //   742: invokevirtual 138	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   745: aload 4
    //   747: new 78	java/lang/StringBuilder
    //   750: dup
    //   751: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   754: iload_2
    //   755: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   758: ldc 181
    //   760: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   766: aload_0
    //   767: getfield 41	com/tencent/open/business/cgireport/ReportManager:b	Ljava/util/ArrayList;
    //   770: iload_3
    //   771: invokevirtual 164	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   774: checkcast 166	com/tencent/open/business/cgireport/reportItem
    //   777: getfield 184	com/tencent/open/business/cgireport/reportItem:e	Ljava/lang/String;
    //   780: invokevirtual 138	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   783: aload 4
    //   785: new 78	java/lang/StringBuilder
    //   788: dup
    //   789: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   792: iload_2
    //   793: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   796: ldc 186
    //   798: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   804: aload_0
    //   805: getfield 41	com/tencent/open/business/cgireport/ReportManager:b	Ljava/util/ArrayList;
    //   808: iload_3
    //   809: invokevirtual 164	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   812: checkcast 166	com/tencent/open/business/cgireport/reportItem
    //   815: getfield 189	com/tencent/open/business/cgireport/reportItem:f	Ljava/lang/String;
    //   818: invokevirtual 138	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   821: aload 4
    //   823: new 78	java/lang/StringBuilder
    //   826: dup
    //   827: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   830: iload_2
    //   831: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   834: ldc 191
    //   836: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   842: aload_0
    //   843: getfield 41	com/tencent/open/business/cgireport/ReportManager:b	Ljava/util/ArrayList;
    //   846: iload_3
    //   847: invokevirtual 164	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   850: checkcast 166	com/tencent/open/business/cgireport/reportItem
    //   853: getfield 194	com/tencent/open/business/cgireport/reportItem:g	Ljava/lang/String;
    //   856: invokevirtual 138	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   859: aload 4
    //   861: new 78	java/lang/StringBuilder
    //   864: dup
    //   865: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   868: iload_2
    //   869: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   872: ldc 196
    //   874: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   880: aload_0
    //   881: getfield 41	com/tencent/open/business/cgireport/ReportManager:b	Ljava/util/ArrayList;
    //   884: iload_3
    //   885: invokevirtual 164	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   888: checkcast 166	com/tencent/open/business/cgireport/reportItem
    //   891: getfield 199	com/tencent/open/business/cgireport/reportItem:j	Ljava/lang/String;
    //   894: invokevirtual 138	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   897: aload 4
    //   899: new 78	java/lang/StringBuilder
    //   902: dup
    //   903: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   906: iload_2
    //   907: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   910: ldc 201
    //   912: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   918: aload_0
    //   919: getfield 41	com/tencent/open/business/cgireport/ReportManager:b	Ljava/util/ArrayList;
    //   922: iload_3
    //   923: invokevirtual 164	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   926: checkcast 166	com/tencent/open/business/cgireport/reportItem
    //   929: getfield 204	com/tencent/open/business/cgireport/reportItem:h	Ljava/lang/String;
    //   932: invokevirtual 138	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   935: new 78	java/lang/StringBuilder
    //   938: dup
    //   939: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   942: invokestatic 208	com/tencent/open/business/base/MobileInfoUtil:h	()Ljava/lang/String;
    //   945: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: ldc 210
    //   950: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: aload_0
    //   954: getfield 39	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   957: iload_3
    //   958: invokevirtual 164	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   961: checkcast 166	com/tencent/open/business/cgireport/reportItem
    //   964: getfield 213	com/tencent/open/business/cgireport/reportItem:i	Ljava/lang/String;
    //   967: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   973: astore_1
    //   974: aload 4
    //   976: new 78	java/lang/StringBuilder
    //   979: dup
    //   980: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   983: iload_2
    //   984: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   987: ldc 215
    //   989: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   995: aload_1
    //   996: invokevirtual 138	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   999: iload_2
    //   1000: iconst_1
    //   1001: iadd
    //   1002: istore_2
    //   1003: goto -439 -> 564
    //   1006: astore_1
    //   1007: getstatic 24	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1010: ldc 217
    //   1012: aload_1
    //   1013: invokestatic 220	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1016: aconst_null
    //   1017: astore_1
    //   1018: goto -969 -> 49
    //   1021: ldc 110
    //   1023: ldc 222
    //   1025: invokestatic 114	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1028: aload 4
    //   1030: astore_1
    //   1031: goto -982 -> 49
    //   1034: astore_1
    //   1035: aload_0
    //   1036: monitorexit
    //   1037: aload_1
    //   1038: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1039	0	this	ReportManager
    //   0	1039	1	paramString	String
    //   131	872	2	i	int
    //   592	366	3	j	int
    //   81	948	4	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   83	130	1006	java/lang/Exception
    //   132	549	1006	java/lang/Exception
    //   556	564	1006	java/lang/Exception
    //   564	999	1006	java/lang/Exception
    //   2	47	1034	finally
    //   53	83	1034	finally
    //   83	130	1034	finally
    //   132	549	1034	finally
    //   556	564	1034	finally
    //   564	999	1034	finally
    //   1007	1016	1034	finally
    //   1021	1028	1034	finally
  }
  
  protected String a()
  {
    return AppNetConnInfo.getCurrentAPN();
  }
  
  protected void a(String paramString)
  {
    LogUtility.b("cgi_report_debug", "ReportManager doUpload start");
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    a("http://wspeed.qq.com/w.cgi", "POST", paramString);
  }
  
  public void a(String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, String paramString2, String paramString3)
  {
    if (a(paramInt) == true)
    {
      b(paramString1, paramLong1, paramLong2, paramLong3, paramInt, paramLong4, paramString2, paramString3);
      if (this.jdField_a_of_type_Boolean != true) {
        break label37;
      }
    }
    label37:
    do
    {
      return;
      if (a() == true)
      {
        a(paramString2);
        return;
      }
    } while (a(paramString2) != true);
    a(paramString2);
  }
  
  protected void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    ThreadManager.executeOnNetWorkThread(new alnn(this, paramString1, paramBundle));
  }
  
  protected boolean a()
  {
    long l2 = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_CGIReportTimeinterval");
    LogUtility.c("OpenConfig_agent", "config 5:Common_CGIReportTimeinterval     config_value:" + l2);
    long l1 = l2;
    if (l2 == 0L) {
      l1 = 1200L;
    }
    LogUtility.c("OpenConfig_agent", "config 5:Common_CGIReportTimeinterval     result_value:" + l1);
    l2 = System.currentTimeMillis() / 1000L;
    if ((this.jdField_a_of_type_Long == 0L) || (l1 + this.jdField_a_of_type_Long <= l2))
    {
      this.jdField_a_of_type_Long = l2;
      LogUtility.b("cgi_report_debug", "ReportManager availableForTime = ture");
      return true;
    }
    LogUtility.b("cgi_report_debug", "ReportManager availableForTime = false");
    return false;
  }
  
  protected boolean a(int paramInt)
  {
    paramInt = a(paramInt);
    if (this.jdField_a_of_type_JavaUtilRandom.nextInt(100) < paramInt)
    {
      LogUtility.b("cgi_report_debug", "ReportManager availableForFrequency = ture");
      return true;
    }
    LogUtility.b("cgi_report_debug", "ReportManager availableForFrequency = false");
    return false;
  }
  
  protected boolean a(String paramString)
  {
    int j = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_CGIReportMaxcount");
    LogUtility.c("OpenConfig_agent", "config 6:Common_CGIReportMaxcount     config_value:" + j);
    int i = j;
    if (j == 0) {
      i = 20;
    }
    LogUtility.c("OpenConfig_agent", "config 6:Common_CGIReportMaxcount     result_value:" + i);
    if (this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal.a(paramString) >= i)
    {
      LogUtility.b("cgi_report_debug", "ReportManager availableForCount = ture");
      return true;
    }
    LogUtility.b("cgi_report_debug", "ReportManager availableForCount = false");
    return false;
  }
  
  protected void b(String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, String paramString2, String paramString3)
  {
    paramLong1 = SystemClock.elapsedRealtime() - paramLong1;
    LogUtility.b("cgi_report_debug", "ReportManager updateDB url=" + paramString1 + ",resultCode=" + paramInt + ",timeCost=" + paramLong1 + ",reqSize=" + paramLong2 + ",rspSize=" + paramLong3);
    int i = 100 / a(paramInt);
    if (i <= 0) {
      i = 1;
    }
    for (;;)
    {
      String str = a();
      this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal.a(str, i + "", paramString1, paramInt + "", paramLong1 + "", paramLong2 + "", paramLong3 + "", paramLong4 + "", paramString3, paramString2);
      return;
      if (i > 100) {
        i = 100;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.business.cgireport.ReportManager
 * JD-Core Version:    0.7.0.1
 */