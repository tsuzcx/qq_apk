package com.tencent.open.business.viareport;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.MobileInfoUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;

public class ReportManager
{
  protected static ReportManager a;
  protected String a;
  protected ArrayList<BatchReportInfo> a;
  protected volatile boolean a;
  protected ArrayList<BatchReportInfo> b = new ArrayList();
  
  protected ReportManager()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static ReportManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenBusinessViareportReportManager == null) {
        jdField_a_of_type_ComTencentOpenBusinessViareportReportManager = new ReportManager();
      }
      ReportManager localReportManager = jdField_a_of_type_ComTencentOpenBusinessViareportReportManager;
      return localReportManager;
    }
    finally {}
  }
  
  /* Error */
  private void a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 53	com/tencent/open/business/viareport/ReportConfig:b	()I
    //   3: istore 9
    //   5: ldc 55
    //   7: new 57	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   14: ldc 60
    //   16: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: iload 9
    //   21: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 76	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: iconst_0
    //   31: istore 7
    //   33: iconst_0
    //   34: istore 6
    //   36: invokestatic 82	android/os/SystemClock:elapsedRealtime	()J
    //   39: lstore 16
    //   41: lconst_0
    //   42: lstore 12
    //   44: lconst_0
    //   45: lstore 18
    //   47: iconst_0
    //   48: istore 10
    //   50: iload 7
    //   52: iconst_1
    //   53: iadd
    //   54: istore 8
    //   56: lload 12
    //   58: lstore 20
    //   60: aload_1
    //   61: aload_2
    //   62: aload_3
    //   63: invokestatic 87	com/tencent/open/base/http/HttpBaseUtil:a	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Lcom/tencent/open/base/http/HttpBaseUtil$Statistic;
    //   66: astore 24
    //   68: lload 12
    //   70: lstore 20
    //   72: aload 24
    //   74: getfield 90	com/tencent/open/base/http/HttpBaseUtil$Statistic:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   77: invokestatic 93	com/tencent/open/base/http/HttpBaseUtil:a	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   80: astore 25
    //   82: lload 12
    //   84: lstore 20
    //   86: aload 25
    //   88: ldc 95
    //   90: invokevirtual 101	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   93: istore 7
    //   95: iload 7
    //   97: ifeq +22 -> 119
    //   100: lload 12
    //   102: lstore 20
    //   104: aload 24
    //   106: getfield 90	com/tencent/open/base/http/HttpBaseUtil$Statistic:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   109: invokestatic 107	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   112: istore 11
    //   114: iload 11
    //   116: ifne +933 -> 1049
    //   119: iconst_1
    //   120: istore 7
    //   122: iload 9
    //   124: istore 6
    //   126: lload 12
    //   128: lstore 20
    //   130: lload 12
    //   132: lstore 14
    //   134: aload 24
    //   136: getfield 110	com/tencent/open/base/http/HttpBaseUtil$Statistic:jdField_a_of_type_Long	J
    //   139: lstore 12
    //   141: lload 12
    //   143: lstore 20
    //   145: lload 12
    //   147: lstore 14
    //   149: aload 24
    //   151: getfield 112	com/tencent/open/base/http/HttpBaseUtil$Statistic:b	J
    //   154: lstore 22
    //   156: iload 10
    //   158: istore 8
    //   160: lload 22
    //   162: lstore 14
    //   164: iload 6
    //   166: iload 9
    //   168: if_icmplt +858 -> 1026
    //   171: ldc 55
    //   173: new 57	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   180: ldc 114
    //   182: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: lload 16
    //   187: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   190: ldc 119
    //   192: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: lload 12
    //   197: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   200: ldc 119
    //   202: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: lload 14
    //   207: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   210: ldc 119
    //   212: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: iload 8
    //   217: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   220: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 122	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload_0
    //   227: iload 8
    //   229: invokevirtual 125	com/tencent/open/business/viareport/ReportManager:a	(I)Z
    //   232: ifeq +30 -> 262
    //   235: invokestatic 130	com/tencent/open/business/cgireport/ReportManager:a	()Lcom/tencent/open/business/cgireport/ReportManager;
    //   238: ldc 132
    //   240: lload 16
    //   242: lload 12
    //   244: lload 14
    //   246: iload 8
    //   248: invokestatic 137	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   251: invokevirtual 139	com/tencent/open/adapter/CommonDataAdapter:a	()J
    //   254: ldc 141
    //   256: aconst_null
    //   257: iload 5
    //   259: invokevirtual 144	com/tencent/open/business/cgireport/ReportManager:a	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;Z)V
    //   262: iload 7
    //   264: iconst_1
    //   265: if_icmpne +695 -> 960
    //   268: ldc 146
    //   270: ldc 148
    //   272: invokestatic 76	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   275: iload 4
    //   277: ifeq +26 -> 303
    //   280: ldc 55
    //   282: ldc 150
    //   284: invokestatic 76	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: aload_0
    //   288: iconst_0
    //   289: putfield 21	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_Boolean	Z
    //   292: iload 7
    //   294: ifeq +9 -> 303
    //   297: aload_0
    //   298: iload 5
    //   300: invokespecial 153	com/tencent/open/business/viareport/ReportManager:a	(Z)V
    //   303: return
    //   304: astore 25
    //   306: bipush 252
    //   308: istore 7
    //   310: goto -215 -> 95
    //   313: astore 24
    //   315: iload 6
    //   317: istore 7
    //   319: iload 8
    //   321: istore 6
    //   323: invokestatic 82	android/os/SystemClock:elapsedRealtime	()J
    //   326: lstore 16
    //   328: lconst_0
    //   329: lstore 12
    //   331: lconst_0
    //   332: lstore 14
    //   334: bipush 249
    //   336: istore 8
    //   338: ldc 55
    //   340: new 57	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   347: ldc 155
    //   349: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload 24
    //   354: invokevirtual 156	org/apache/http/conn/ConnectTimeoutException:toString	()Ljava/lang/String;
    //   357: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 159	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: goto -202 -> 164
    //   369: astore 24
    //   371: iload 6
    //   373: istore 7
    //   375: iload 8
    //   377: istore 6
    //   379: invokestatic 82	android/os/SystemClock:elapsedRealtime	()J
    //   382: lstore 16
    //   384: lconst_0
    //   385: lstore 12
    //   387: lconst_0
    //   388: lstore 14
    //   390: bipush 248
    //   392: istore 8
    //   394: ldc 55
    //   396: new 57	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   403: ldc 155
    //   405: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload 24
    //   410: invokevirtual 160	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   413: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokestatic 159	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   422: goto -258 -> 164
    //   425: astore 24
    //   427: iload 6
    //   429: istore 7
    //   431: iload 8
    //   433: istore 6
    //   435: lconst_0
    //   436: lstore 12
    //   438: lconst_0
    //   439: lstore 14
    //   441: bipush 252
    //   443: istore 8
    //   445: ldc 55
    //   447: new 57	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   454: ldc 155
    //   456: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: aload 24
    //   461: invokevirtual 161	org/json/JSONException:toString	()Ljava/lang/String;
    //   464: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: invokestatic 159	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   473: goto -309 -> 164
    //   476: astore_1
    //   477: ldc 55
    //   479: new 57	java/lang/StringBuilder
    //   482: dup
    //   483: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   486: ldc 155
    //   488: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: aload_1
    //   492: invokevirtual 162	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException:toString	()Ljava/lang/String;
    //   495: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokestatic 159	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   504: aload_0
    //   505: iconst_0
    //   506: putfield 21	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_Boolean	Z
    //   509: return
    //   510: astore_1
    //   511: aload_1
    //   512: invokevirtual 165	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException:getMessage	()Ljava/lang/String;
    //   515: ldc 167
    //   517: ldc 17
    //   519: invokevirtual 173	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   522: invokestatic 178	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   525: istore 6
    //   527: aload_0
    //   528: iload 6
    //   530: invokevirtual 125	com/tencent/open/business/viareport/ReportManager:a	(I)Z
    //   533: ifeq +30 -> 563
    //   536: invokestatic 130	com/tencent/open/business/cgireport/ReportManager:a	()Lcom/tencent/open/business/cgireport/ReportManager;
    //   539: ldc 132
    //   541: lload 16
    //   543: lload 20
    //   545: lload 18
    //   547: iload 6
    //   549: invokestatic 137	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   552: invokevirtual 139	com/tencent/open/adapter/CommonDataAdapter:a	()J
    //   555: ldc 141
    //   557: aconst_null
    //   558: iload 5
    //   560: invokevirtual 144	com/tencent/open/business/cgireport/ReportManager:a	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;Z)V
    //   563: ldc 55
    //   565: new 57	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   572: ldc 155
    //   574: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: aload_1
    //   578: invokevirtual 179	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException:toString	()Ljava/lang/String;
    //   581: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   587: invokestatic 159	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   590: aload_0
    //   591: iconst_0
    //   592: putfield 21	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_Boolean	Z
    //   595: return
    //   596: astore_2
    //   597: ldc 55
    //   599: new 57	java/lang/StringBuilder
    //   602: dup
    //   603: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   606: ldc 155
    //   608: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: aload_1
    //   612: invokevirtual 179	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException:toString	()Ljava/lang/String;
    //   615: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: invokestatic 159	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   624: goto -61 -> 563
    //   627: astore 24
    //   629: iload 6
    //   631: istore 7
    //   633: iload 8
    //   635: istore 6
    //   637: lconst_0
    //   638: lstore 12
    //   640: lconst_0
    //   641: lstore 14
    //   643: aload 24
    //   645: invokestatic 184	com/tencent/open/base/http/HttpCgiAsyncTask:a	(Ljava/io/IOException;)I
    //   648: istore 8
    //   650: ldc 55
    //   652: new 57	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   659: ldc 155
    //   661: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: aload 24
    //   666: invokevirtual 185	java/io/IOException:toString	()Ljava/lang/String;
    //   669: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: invokestatic 159	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   678: goto -514 -> 164
    //   681: astore 24
    //   683: iload 6
    //   685: istore 7
    //   687: iload 8
    //   689: istore 6
    //   691: aload 24
    //   693: instanceof 42
    //   696: ifeq +37 -> 733
    //   699: ldc 55
    //   701: new 57	java/lang/StringBuilder
    //   704: dup
    //   705: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   708: ldc 155
    //   710: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: aload 24
    //   715: invokevirtual 186	java/lang/Exception:toString	()Ljava/lang/String;
    //   718: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   724: invokestatic 159	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   727: aload_0
    //   728: iconst_0
    //   729: putfield 21	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_Boolean	Z
    //   732: return
    //   733: aload 24
    //   735: instanceof 44
    //   738: ifeq +122 -> 860
    //   741: aload 24
    //   743: invokevirtual 187	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   746: ldc 167
    //   748: ldc 17
    //   750: invokevirtual 173	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   753: invokestatic 178	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   756: istore 6
    //   758: aload_0
    //   759: iload 6
    //   761: invokevirtual 125	com/tencent/open/business/viareport/ReportManager:a	(I)Z
    //   764: ifeq +30 -> 794
    //   767: invokestatic 130	com/tencent/open/business/cgireport/ReportManager:a	()Lcom/tencent/open/business/cgireport/ReportManager;
    //   770: ldc 132
    //   772: lload 16
    //   774: lload 12
    //   776: lload 18
    //   778: iload 6
    //   780: invokestatic 137	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   783: invokevirtual 139	com/tencent/open/adapter/CommonDataAdapter:a	()J
    //   786: ldc 141
    //   788: aconst_null
    //   789: iload 5
    //   791: invokevirtual 144	com/tencent/open/business/cgireport/ReportManager:a	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;Z)V
    //   794: ldc 55
    //   796: new 57	java/lang/StringBuilder
    //   799: dup
    //   800: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   803: ldc 155
    //   805: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: aload 24
    //   810: invokevirtual 186	java/lang/Exception:toString	()Ljava/lang/String;
    //   813: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   819: invokestatic 159	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   822: aload_0
    //   823: iconst_0
    //   824: putfield 21	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_Boolean	Z
    //   827: return
    //   828: astore_1
    //   829: ldc 55
    //   831: new 57	java/lang/StringBuilder
    //   834: dup
    //   835: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   838: ldc 155
    //   840: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: aload 24
    //   845: invokevirtual 186	java/lang/Exception:toString	()Ljava/lang/String;
    //   848: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   854: invokestatic 159	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   857: goto -63 -> 794
    //   860: aload 24
    //   862: instanceof 46
    //   865: ifeq +50 -> 915
    //   868: lconst_0
    //   869: lstore 12
    //   871: lconst_0
    //   872: lstore 14
    //   874: aload 24
    //   876: checkcast 46	java/io/IOException
    //   879: invokestatic 184	com/tencent/open/base/http/HttpCgiAsyncTask:a	(Ljava/io/IOException;)I
    //   882: istore 8
    //   884: ldc 55
    //   886: new 57	java/lang/StringBuilder
    //   889: dup
    //   890: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   893: ldc 155
    //   895: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: aload 24
    //   900: invokevirtual 186	java/lang/Exception:toString	()Ljava/lang/String;
    //   903: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   909: invokestatic 159	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   912: goto -748 -> 164
    //   915: lconst_0
    //   916: lstore 12
    //   918: lconst_0
    //   919: lstore 14
    //   921: bipush 250
    //   923: istore 8
    //   925: ldc 55
    //   927: new 57	java/lang/StringBuilder
    //   930: dup
    //   931: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   934: ldc 155
    //   936: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: aload 24
    //   941: invokevirtual 186	java/lang/Exception:toString	()Ljava/lang/String;
    //   944: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   950: invokestatic 159	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   953: iload 9
    //   955: istore 6
    //   957: goto -793 -> 164
    //   960: ldc 146
    //   962: ldc 189
    //   964: invokestatic 76	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   967: iload 4
    //   969: ifeq -694 -> 275
    //   972: invokestatic 194	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   975: aload_0
    //   976: getfield 28	com/tencent/open/business/viareport/ReportManager:b	Ljava/util/ArrayList;
    //   979: invokevirtual 197	com/tencent/open/business/viareport/ReportDbHelper:a	(Ljava/util/ArrayList;)I
    //   982: pop
    //   983: invokestatic 194	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   986: aload_0
    //   987: getfield 26	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   990: invokevirtual 197	com/tencent/open/business/viareport/ReportDbHelper:a	(Ljava/util/ArrayList;)I
    //   993: pop
    //   994: goto -719 -> 275
    //   997: astore 24
    //   999: lload 14
    //   1001: lstore 12
    //   1003: goto -312 -> 691
    //   1006: astore 24
    //   1008: goto -371 -> 637
    //   1011: astore 24
    //   1013: goto -578 -> 435
    //   1016: astore 24
    //   1018: goto -639 -> 379
    //   1021: astore 24
    //   1023: goto -700 -> 323
    //   1026: iload 6
    //   1028: istore 10
    //   1030: iload 7
    //   1032: istore 6
    //   1034: iload 10
    //   1036: istore 7
    //   1038: lload 14
    //   1040: lstore 18
    //   1042: iload 8
    //   1044: istore 10
    //   1046: goto -996 -> 50
    //   1049: iload 6
    //   1051: istore 7
    //   1053: iload 8
    //   1055: istore 6
    //   1057: goto -931 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1060	0	this	ReportManager
    //   0	1060	1	paramString1	String
    //   0	1060	2	paramString2	String
    //   0	1060	3	paramBundle	Bundle
    //   0	1060	4	paramBoolean1	boolean
    //   0	1060	5	paramBoolean2	boolean
    //   34	1022	6	i	int
    //   31	1021	7	j	int
    //   54	1000	8	k	int
    //   3	951	9	m	int
    //   48	997	10	n	int
    //   112	3	11	bool	boolean
    //   42	960	12	l1	long
    //   132	907	14	l2	long
    //   39	734	16	l3	long
    //   45	996	18	l4	long
    //   58	486	20	l5	long
    //   154	7	22	l6	long
    //   66	84	24	localStatistic	com.tencent.open.base.http.HttpBaseUtil.Statistic
    //   313	40	24	localConnectTimeoutException1	org.apache.http.conn.ConnectTimeoutException
    //   369	40	24	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   425	35	24	localJSONException1	org.json.JSONException
    //   627	38	24	localIOException1	java.io.IOException
    //   681	259	24	localException1	java.lang.Exception
    //   997	1	24	localException2	java.lang.Exception
    //   1006	1	24	localIOException2	java.io.IOException
    //   1011	1	24	localJSONException2	org.json.JSONException
    //   1016	1	24	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   1021	1	24	localConnectTimeoutException2	org.apache.http.conn.ConnectTimeoutException
    //   80	7	25	localJSONObject	org.json.JSONObject
    //   304	1	25	localJSONException3	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   86	95	304	org/json/JSONException
    //   60	68	313	org/apache/http/conn/ConnectTimeoutException
    //   72	82	313	org/apache/http/conn/ConnectTimeoutException
    //   86	95	313	org/apache/http/conn/ConnectTimeoutException
    //   104	114	313	org/apache/http/conn/ConnectTimeoutException
    //   60	68	369	java/net/SocketTimeoutException
    //   72	82	369	java/net/SocketTimeoutException
    //   86	95	369	java/net/SocketTimeoutException
    //   104	114	369	java/net/SocketTimeoutException
    //   60	68	425	org/json/JSONException
    //   72	82	425	org/json/JSONException
    //   104	114	425	org/json/JSONException
    //   60	68	476	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   72	82	476	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   86	95	476	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   104	114	476	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   134	141	476	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   149	156	476	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   60	68	510	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   72	82	510	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   86	95	510	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   104	114	510	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   134	141	510	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   149	156	510	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   511	563	596	java/lang/Exception
    //   60	68	627	java/io/IOException
    //   72	82	627	java/io/IOException
    //   86	95	627	java/io/IOException
    //   104	114	627	java/io/IOException
    //   60	68	681	java/lang/Exception
    //   72	82	681	java/lang/Exception
    //   86	95	681	java/lang/Exception
    //   104	114	681	java/lang/Exception
    //   741	794	828	java/lang/Exception
    //   134	141	997	java/lang/Exception
    //   149	156	997	java/lang/Exception
    //   134	141	1006	java/io/IOException
    //   149	156	1006	java/io/IOException
    //   134	141	1011	org/json/JSONException
    //   149	156	1011	org/json/JSONException
    //   134	141	1016	java/net/SocketTimeoutException
    //   149	156	1016	java/net/SocketTimeoutException
    //   134	141	1021	org/apache/http/conn/ConnectTimeoutException
    //   149	156	1021	org/apache/http/conn/ConnectTimeoutException
  }
  
  private void a(boolean paramBoolean)
  {
    String str = String.valueOf(CommonDataAdapter.a().a());
    if (a(str)) {
      ThreadManager.executeOnNetWorkThread(new ReportManager.2(this, str, paramBoolean));
    }
  }
  
  protected String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = "https://analy.qq.com/cgi-bin/mapp_apptrace";
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected String a(ArrayList<BatchReportInfo> paramArrayList1, ArrayList<BatchReportInfo> paramArrayList2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramArrayList1 != null)
    {
      paramArrayList1 = paramArrayList1.iterator();
      while (paramArrayList1.hasNext())
      {
        BatchReportInfo localBatchReportInfo = (BatchReportInfo)paramArrayList1.next();
        localStringBuilder.append(localBatchReportInfo.jdField_a_of_type_JavaLangString + "_" + localBatchReportInfo.b + "_" + localBatchReportInfo.c + "_" + localBatchReportInfo.a() + "_" + localBatchReportInfo.g);
        if (!TextUtils.isEmpty(localBatchReportInfo.h)) {
          localStringBuilder.append("_" + localBatchReportInfo.h);
        }
        if (!TextUtils.isEmpty(localBatchReportInfo.i)) {
          localStringBuilder.append("_" + localBatchReportInfo.i);
        }
        if (!TextUtils.isEmpty(localBatchReportInfo.j)) {
          localStringBuilder.append("_" + localBatchReportInfo.j);
        }
        if (!TextUtils.isEmpty(localBatchReportInfo.k)) {
          localStringBuilder.append("_" + localBatchReportInfo.k);
        }
        if (!TextUtils.isEmpty(localBatchReportInfo.l)) {
          localStringBuilder.append("_" + localBatchReportInfo.l);
        }
        localStringBuilder.append(",");
      }
    }
    if (paramArrayList2 != null)
    {
      paramArrayList1 = paramArrayList2.iterator();
      while (paramArrayList1.hasNext())
      {
        paramArrayList2 = (BatchReportInfo)paramArrayList1.next();
        localStringBuilder.append(paramArrayList2.jdField_a_of_type_JavaLangString + "_" + paramArrayList2.b + "_" + paramArrayList2.c + "_" + paramArrayList2.a() + "_" + paramArrayList2.g);
        if (!TextUtils.isEmpty(paramArrayList2.h)) {
          localStringBuilder.append("_" + paramArrayList2.h);
        }
        if (!TextUtils.isEmpty(paramArrayList2.i)) {
          localStringBuilder.append("_" + paramArrayList2.i);
        }
        if (!TextUtils.isEmpty(paramArrayList2.j)) {
          localStringBuilder.append("_" + paramArrayList2.j);
        }
        if (!TextUtils.isEmpty(paramArrayList2.k)) {
          localStringBuilder.append("_" + paramArrayList2.k);
        }
        if (!TextUtils.isEmpty(paramArrayList2.l)) {
          localStringBuilder.append("_" + paramArrayList2.l);
        }
        localStringBuilder.append(",");
      }
    }
    paramArrayList2 = localStringBuilder.toString();
    paramArrayList1 = paramArrayList2;
    if (paramArrayList2.endsWith(",")) {
      paramArrayList1 = paramArrayList2.substring(0, paramArrayList2.length() - 1);
    }
    return paramArrayList1;
  }
  
  protected void a(String paramString, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    Bundle localBundle = new Bundle();
    if (paramBoolean1)
    {
      if (!a(paramString, localBundle))
      {
        LogUtility.b("viareport", "database empty");
        return;
      }
      this.jdField_a_of_type_Boolean = true;
    }
    localBundle.putString("uin", paramString);
    localBundle.putString("platform", CommonDataAdapter.a().g());
    localBundle.putString("action", "100");
    if (paramBoolean2)
    {
      paramString = "";
      localBundle.putString("imei", paramString);
      localBundle.putString("resolution", MobileInfoUtil.e());
      localBundle.putString("network", APNUtil.a(CommonDataAdapter.a().a()));
      localBundle.putString("wifimac", MobileInfoUtil.a());
      localBundle.putString("mobile_pf", "1");
      localBundle.putString("os_ver", Build.VERSION.RELEASE);
      localBundle.putString("lang", MobileInfoUtil.b());
      localBundle.putString("device", Build.DEVICE);
      localBundle.putString("model_name", Build.MODEL);
      localBundle.putString("sdk_ver", "1.5");
      localBundle.putString("timezone", TimeZone.getDefault().getID());
      localBundle.putString("city", MobileInfoUtil.g());
      if (!paramBoolean2) {
        break label328;
      }
      paramString = "";
      label226:
      localBundle.putString("longitude", paramString);
      localBundle.putString("ret_code", "0");
      localBundle.putString("qua", CommonDataAdapter.a().f());
      localBundle.putString("qz_ver", CommonDataAdapter.a().c());
      localBundle.putString("ext", CommonDataAdapter.a().h());
      if (paramBundle != null) {
        localBundle.putAll(paramBundle);
      }
      if (!paramBoolean1) {
        break label335;
      }
    }
    label328:
    label335:
    for (paramString = "POST";; paramString = "GET")
    {
      a(a(), paramString, localBundle, paramBoolean1, paramBoolean2);
      return;
      paramString = MobileInfoUtil.c();
      break;
      paramString = MobileInfoUtil.f();
      break label226;
    }
  }
  
  public void a(String paramString, BatchReportInfo paramBatchReportInfo, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    ThreadManager.executeOnNetWorkThread(new ReportManager.1(this, paramBoolean1, paramBatchReportInfo, paramBundle, paramString, paramBoolean2));
  }
  
  /* Error */
  protected boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 402	com/tencent/open/business/viareport/ReportConfig:a	()J
    //   5: lstore_1
    //   6: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   9: lstore_3
    //   10: ldc 55
    //   12: new 57	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 409
    //   22: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: lload_1
    //   26: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   29: ldc_w 411
    //   32: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: lload_3
    //   36: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   39: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 76	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: invokestatic 413	com/tencent/open/business/viareport/ReportConfig:b	()J
    //   48: lstore 5
    //   50: ldc 55
    //   52: new 57	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   59: ldc_w 415
    //   62: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: lload 5
    //   67: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   70: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 76	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: lload_3
    //   77: lload_1
    //   78: lsub
    //   79: lload 5
    //   81: ldc2_w 416
    //   84: lmul
    //   85: lcmp
    //   86: ifge +19 -> 105
    //   89: ldc 146
    //   91: ldc_w 419
    //   94: invokestatic 76	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: iconst_0
    //   98: istore 7
    //   100: aload_0
    //   101: monitorexit
    //   102: iload 7
    //   104: ireturn
    //   105: lload_3
    //   106: invokestatic 422	com/tencent/open/business/viareport/ReportConfig:a	(J)V
    //   109: ldc 146
    //   111: ldc_w 424
    //   114: invokestatic 76	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: iconst_1
    //   118: istore 7
    //   120: goto -20 -> 100
    //   123: astore 8
    //   125: aload_0
    //   126: monitorexit
    //   127: aload 8
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	ReportManager
    //   5	73	1	l1	long
    //   9	97	3	l2	long
    //   48	32	5	l3	long
    //   98	21	7	bool	boolean
    //   123	5	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	76	123	finally
    //   89	97	123	finally
    //   105	117	123	finally
  }
  
  /* Error */
  protected boolean a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: invokestatic 427	com/tencent/open/business/viareport/ReportConfig:a	(I)I
    //   6: istore_1
    //   7: ldc 55
    //   9: new 57	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 429
    //   19: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_1
    //   23: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 76	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: new 431	java/util/Random
    //   35: dup
    //   36: invokespecial 432	java/util/Random:<init>	()V
    //   39: bipush 100
    //   41: invokevirtual 435	java/util/Random:nextInt	(I)I
    //   44: iload_1
    //   45: if_icmpge +18 -> 63
    //   48: ldc_w 437
    //   51: ldc_w 439
    //   54: invokestatic 76	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: iconst_1
    //   58: istore_2
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_2
    //   62: ireturn
    //   63: ldc_w 437
    //   66: ldc_w 441
    //   69: invokestatic 76	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: iconst_0
    //   73: istore_2
    //   74: goto -15 -> 59
    //   77: astore_3
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_3
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	ReportManager
    //   0	82	1	paramInt	int
    //   58	16	2	bool	boolean
    //   77	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	57	77	finally
    //   63	72	77	finally
  }
  
  /* Error */
  protected boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 443	com/tencent/open/business/viareport/ReportConfig:a	()I
    //   5: istore_2
    //   6: ldc 55
    //   8: new 57	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 445
    //   18: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: iload_2
    //   22: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 76	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: invokestatic 194	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   34: aload_1
    //   35: invokevirtual 447	com/tencent/open/business/viareport/ReportDbHelper:a	(Ljava/lang/String;)I
    //   38: iload_2
    //   39: if_icmplt +17 -> 56
    //   42: ldc 146
    //   44: ldc_w 449
    //   47: invokestatic 76	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: iconst_1
    //   51: istore_3
    //   52: aload_0
    //   53: monitorexit
    //   54: iload_3
    //   55: ireturn
    //   56: ldc 146
    //   58: ldc_w 451
    //   61: invokestatic 76	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: iconst_0
    //   65: istore_3
    //   66: goto -14 -> 52
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	ReportManager
    //   0	74	1	paramString	String
    //   5	35	2	i	int
    //   51	15	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	50	69	finally
    //   56	64	69	finally
  }
  
  /* Error */
  protected boolean a(String paramString, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokestatic 194	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   6: aload_1
    //   7: invokevirtual 454	com/tencent/open/business/viareport/ReportDbHelper:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   10: putfield 26	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   13: invokestatic 194	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   16: ldc_w 456
    //   19: aload_1
    //   20: invokevirtual 459	com/tencent/open/business/viareport/ReportDbHelper:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   23: pop
    //   24: aload_0
    //   25: invokestatic 194	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   28: aload_1
    //   29: invokevirtual 461	com/tencent/open/business/viareport/ReportDbHelper:b	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   32: putfield 28	com/tencent/open/business/viareport/ReportManager:b	Ljava/util/ArrayList;
    //   35: invokestatic 194	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   38: ldc_w 463
    //   41: aload_1
    //   42: invokevirtual 459	com/tencent/open/business/viareport/ReportDbHelper:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   45: pop
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 26	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   51: aload_0
    //   52: getfield 28	com/tencent/open/business/viareport/ReportManager:b	Ljava/util/ArrayList;
    //   55: invokevirtual 465	com/tencent/open/business/viareport/ReportManager:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;)Ljava/lang/String;
    //   58: astore_1
    //   59: ldc 55
    //   61: new 57	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 467
    //   71: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_1
    //   75: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 76	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload_2
    //   85: ldc_w 469
    //   88: aload_1
    //   89: invokevirtual 289	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_1
    //   93: invokestatic 107	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   96: istore_3
    //   97: iload_3
    //   98: ifeq +9 -> 107
    //   101: iconst_0
    //   102: istore_3
    //   103: aload_0
    //   104: monitorexit
    //   105: iload_3
    //   106: ireturn
    //   107: iconst_1
    //   108: istore_3
    //   109: goto -6 -> 103
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	ReportManager
    //   0	117	1	paramString	String
    //   0	117	2	paramBundle	Bundle
    //   96	13	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	97	112	finally
  }
  
  /* Error */
  protected boolean b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 470	com/tencent/open/business/viareport/ReportConfig:a	(Ljava/lang/String;)I
    //   6: istore_2
    //   7: ldc 55
    //   9: new 57	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 472
    //   19: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_2
    //   23: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 76	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: new 431	java/util/Random
    //   35: dup
    //   36: invokespecial 432	java/util/Random:<init>	()V
    //   39: bipush 100
    //   41: invokevirtual 435	java/util/Random:nextInt	(I)I
    //   44: iload_2
    //   45: if_icmpge +18 -> 63
    //   48: ldc_w 437
    //   51: ldc_w 474
    //   54: invokestatic 76	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: iconst_1
    //   58: istore_3
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_3
    //   62: ireturn
    //   63: ldc_w 437
    //   66: ldc_w 476
    //   69: invokestatic 76	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: iconst_0
    //   73: istore_3
    //   74: goto -15 -> 59
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	ReportManager
    //   0	82	1	paramString	String
    //   6	40	2	i	int
    //   58	16	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	57	77	finally
    //   63	72	77	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.business.viareport.ReportManager
 * JD-Core Version:    0.7.0.1
 */