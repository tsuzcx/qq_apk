package dov.com.tencent.mobileqq.shortvideo.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import brkp;
import brkq;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class ShortVideoTrimmer
{
  public static int a;
  static final Object jdField_a_of_type_JavaLangObject = new Object();
  static Process jdField_a_of_type_JavaLangProcess;
  public static AtomicBoolean a;
  private static boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  }
  
  public static int a()
  {
    if (jdField_a_of_type_Int == 0) {}
    try
    {
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new brkp());
      if (arrayOfFile == null) {
        return 1;
      }
      jdField_a_of_type_Int = arrayOfFile.length;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        jdField_a_of_type_Int = 1;
      }
    }
    return jdField_a_of_type_Int;
  }
  
  /* Error */
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 55	java/lang/System:currentTimeMillis	()J
    //   3: lstore 5
    //   5: aload_1
    //   6: invokestatic 58	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)Lbrkq;
    //   9: astore 9
    //   11: aload 9
    //   13: getfield 62	brkq:jdField_a_of_type_Boolean	Z
    //   16: ifne +10 -> 26
    //   19: ldc 64
    //   21: invokestatic 66	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   24: iconst_m1
    //   25: ireturn
    //   26: aload_1
    //   27: aload_2
    //   28: aload 9
    //   30: invokestatic 69	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;Ljava/lang/String;Lbrkq;)[Ljava/lang/String;
    //   33: astore_1
    //   34: aload_1
    //   35: ifnonnull +11 -> 46
    //   38: ldc 71
    //   40: invokestatic 66	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   43: bipush 254
    //   45: ireturn
    //   46: aload_0
    //   47: invokestatic 77	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoPath	(Landroid/content/Context;)Ljava/lang/String;
    //   50: astore 13
    //   52: invokestatic 82	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()Ljava/lang/String;
    //   55: astore 11
    //   57: getstatic 83	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_Boolean	Z
    //   60: ifne +39 -> 99
    //   63: new 32	java/io/File
    //   66: dup
    //   67: new 85	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   74: aload 13
    //   76: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 11
    //   81: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   90: invokevirtual 97	java/io/File:exists	()Z
    //   93: ifne +6 -> 99
    //   96: bipush 253
    //   98: ireturn
    //   99: aconst_null
    //   100: astore 9
    //   102: aconst_null
    //   103: astore 10
    //   105: new 99	java/lang/ProcessBuilder
    //   108: dup
    //   109: iconst_0
    //   110: anewarray 101	java/lang/String
    //   113: invokespecial 104	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   116: astore_0
    //   117: aload_0
    //   118: iconst_1
    //   119: invokevirtual 108	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   122: pop
    //   123: new 110	java/util/ArrayList
    //   126: dup
    //   127: invokespecial 111	java/util/ArrayList:<init>	()V
    //   130: astore 12
    //   132: aload 12
    //   134: new 85	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   141: aload 13
    //   143: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc 113
    //   148: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokeinterface 119 2 0
    //   159: pop
    //   160: new 85	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   167: ldc 121
    //   169: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload 12
    //   174: iconst_0
    //   175: invokeinterface 125 2 0
    //   180: checkcast 101	java/lang/String
    //   183: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 66	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   192: aload_1
    //   193: arraylength
    //   194: istore 4
    //   196: iconst_0
    //   197: istore_3
    //   198: iload_3
    //   199: iload 4
    //   201: if_icmpge +21 -> 222
    //   204: aload 12
    //   206: aload_1
    //   207: iload_3
    //   208: aaload
    //   209: invokeinterface 119 2 0
    //   214: pop
    //   215: iload_3
    //   216: iconst_1
    //   217: iadd
    //   218: istore_3
    //   219: goto -21 -> 198
    //   222: aload 12
    //   224: new 85	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   231: aload 13
    //   233: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload 11
    //   238: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokeinterface 119 2 0
    //   249: pop
    //   250: aload_0
    //   251: aload 12
    //   253: invokevirtual 129	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   256: pop
    //   257: new 85	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   264: ldc 131
    //   266: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload 12
    //   271: aload 12
    //   273: invokeinterface 134 1 0
    //   278: iconst_1
    //   279: isub
    //   280: invokeinterface 125 2 0
    //   285: checkcast 101	java/lang/String
    //   288: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 66	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   297: aload_0
    //   298: invokevirtual 138	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   301: astore 13
    //   303: getstatic 17	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   306: astore_0
    //   307: aload_0
    //   308: monitorenter
    //   309: aload 13
    //   311: putstatic 140	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   314: aload_0
    //   315: monitorexit
    //   316: getstatic 24	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   319: invokevirtual 142	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   322: ifne +256 -> 578
    //   325: aconst_null
    //   326: putstatic 140	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   329: aload 13
    //   331: invokevirtual 147	java/lang/Process:destroy	()V
    //   334: getstatic 24	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   337: iconst_1
    //   338: invokevirtual 150	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   341: iconst_0
    //   342: ifeq +11 -> 353
    //   345: new 152	java/lang/NullPointerException
    //   348: dup
    //   349: invokespecial 153	java/lang/NullPointerException:<init>	()V
    //   352: athrow
    //   353: iconst_0
    //   354: ifeq +11 -> 365
    //   357: new 152	java/lang/NullPointerException
    //   360: dup
    //   361: invokespecial 153	java/lang/NullPointerException:<init>	()V
    //   364: athrow
    //   365: iconst_0
    //   366: ifeq -342 -> 24
    //   369: new 152	java/lang/NullPointerException
    //   372: dup
    //   373: invokespecial 153	java/lang/NullPointerException:<init>	()V
    //   376: athrow
    //   377: astore_0
    //   378: iconst_m1
    //   379: ireturn
    //   380: astore_1
    //   381: aload_0
    //   382: monitorexit
    //   383: aload_1
    //   384: athrow
    //   385: astore 13
    //   387: aconst_null
    //   388: astore_0
    //   389: aconst_null
    //   390: astore_1
    //   391: aconst_null
    //   392: astore 12
    //   394: sipush -1001
    //   397: istore 4
    //   399: aload 12
    //   401: astore 11
    //   403: aload_1
    //   404: astore 10
    //   406: aload_0
    //   407: astore 9
    //   409: aload 13
    //   411: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   414: aload 12
    //   416: astore 11
    //   418: aload_1
    //   419: astore 10
    //   421: aload_0
    //   422: astore 9
    //   424: new 85	java/lang/StringBuilder
    //   427: dup
    //   428: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   431: ldc 158
    //   433: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: aload 13
    //   438: invokevirtual 159	java/io/IOException:toString	()Ljava/lang/String;
    //   441: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 66	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   450: aload_0
    //   451: ifnull +7 -> 458
    //   454: aload_0
    //   455: invokevirtual 164	java/io/InputStream:close	()V
    //   458: aload_1
    //   459: ifnull +7 -> 466
    //   462: aload_1
    //   463: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   466: iload 4
    //   468: istore_3
    //   469: aload 12
    //   471: ifnull +11 -> 482
    //   474: aload 12
    //   476: invokevirtual 170	java/io/BufferedReader:close	()V
    //   479: iload 4
    //   481: istore_3
    //   482: invokestatic 55	java/lang/System:currentTimeMillis	()J
    //   485: lstore 7
    //   487: new 85	java/lang/StringBuilder
    //   490: dup
    //   491: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   494: ldc 172
    //   496: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: lload 7
    //   501: lload 5
    //   503: lsub
    //   504: invokevirtual 175	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   507: ldc 177
    //   509: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: iload_3
    //   513: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   516: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: invokestatic 66	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   522: iload_3
    //   523: ifeq +46 -> 569
    //   526: new 32	java/io/File
    //   529: dup
    //   530: aload_2
    //   531: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   534: astore_0
    //   535: aload_0
    //   536: invokevirtual 97	java/io/File:exists	()Z
    //   539: ifeq +30 -> 569
    //   542: aload_0
    //   543: invokevirtual 183	java/io/File:delete	()Z
    //   546: pop
    //   547: new 85	java/lang/StringBuilder
    //   550: dup
    //   551: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   554: ldc 185
    //   556: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: iload_3
    //   560: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   563: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: invokestatic 66	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   569: getstatic 24	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   572: iconst_1
    //   573: invokevirtual 150	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   576: iload_3
    //   577: ireturn
    //   578: aload 13
    //   580: invokevirtual 189	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   583: astore_0
    //   584: new 166	java/io/InputStreamReader
    //   587: dup
    //   588: aload_0
    //   589: invokespecial 192	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   592: astore_1
    //   593: new 169	java/io/BufferedReader
    //   596: dup
    //   597: aload_1
    //   598: invokespecial 195	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   601: astore 12
    //   603: aload 12
    //   605: astore 11
    //   607: aload_1
    //   608: astore 10
    //   610: aload_0
    //   611: astore 9
    //   613: aload 13
    //   615: invokevirtual 198	java/lang/Process:waitFor	()I
    //   618: pop
    //   619: aload 12
    //   621: astore 11
    //   623: aload_1
    //   624: astore 10
    //   626: aload_0
    //   627: astore 9
    //   629: aload 13
    //   631: invokevirtual 201	java/lang/Process:exitValue	()I
    //   634: istore 4
    //   636: aload 12
    //   638: astore 11
    //   640: aload_1
    //   641: astore 10
    //   643: aload_0
    //   644: astore 9
    //   646: new 85	java/lang/StringBuilder
    //   649: dup
    //   650: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   653: ldc 203
    //   655: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: iload 4
    //   660: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   663: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   666: invokestatic 66	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   669: aload 12
    //   671: astore 11
    //   673: aload_1
    //   674: astore 10
    //   676: aload_0
    //   677: astore 9
    //   679: aload 12
    //   681: invokevirtual 206	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   684: astore 14
    //   686: aload 14
    //   688: ifnull +39 -> 727
    //   691: aload 12
    //   693: astore 11
    //   695: aload_1
    //   696: astore 10
    //   698: aload_0
    //   699: astore 9
    //   701: new 85	java/lang/StringBuilder
    //   704: dup
    //   705: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   708: ldc 208
    //   710: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: aload 14
    //   715: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   721: invokestatic 66	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   724: goto -55 -> 669
    //   727: aload 12
    //   729: astore 11
    //   731: aload_1
    //   732: astore 10
    //   734: aload_0
    //   735: astore 9
    //   737: aload 13
    //   739: invokevirtual 147	java/lang/Process:destroy	()V
    //   742: aload 12
    //   744: astore 11
    //   746: aload_1
    //   747: astore 10
    //   749: aload_0
    //   750: astore 9
    //   752: getstatic 17	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   755: astore 13
    //   757: aload 12
    //   759: astore 11
    //   761: aload_1
    //   762: astore 10
    //   764: aload_0
    //   765: astore 9
    //   767: aload 13
    //   769: monitorenter
    //   770: aconst_null
    //   771: putstatic 140	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_JavaLangProcess	Ljava/lang/Process;
    //   774: aload 13
    //   776: monitorexit
    //   777: aload 12
    //   779: astore 11
    //   781: aload_1
    //   782: astore 10
    //   784: aload_0
    //   785: astore 9
    //   787: ldc 210
    //   789: invokestatic 66	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   792: aload_0
    //   793: ifnull +7 -> 800
    //   796: aload_0
    //   797: invokevirtual 164	java/io/InputStream:close	()V
    //   800: aload_1
    //   801: ifnull +7 -> 808
    //   804: aload_1
    //   805: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   808: iload 4
    //   810: istore_3
    //   811: aload 12
    //   813: ifnull -331 -> 482
    //   816: aload 12
    //   818: invokevirtual 170	java/io/BufferedReader:close	()V
    //   821: iload 4
    //   823: istore_3
    //   824: goto -342 -> 482
    //   827: astore_0
    //   828: iload 4
    //   830: istore_3
    //   831: goto -349 -> 482
    //   834: astore 14
    //   836: aload 13
    //   838: monitorexit
    //   839: aload 12
    //   841: astore 11
    //   843: aload_1
    //   844: astore 10
    //   846: aload_0
    //   847: astore 9
    //   849: aload 14
    //   851: athrow
    //   852: astore 13
    //   854: sipush -1002
    //   857: istore 4
    //   859: aload 12
    //   861: astore 11
    //   863: aload_1
    //   864: astore 10
    //   866: aload_0
    //   867: astore 9
    //   869: aload 13
    //   871: invokevirtual 211	java/lang/InterruptedException:printStackTrace	()V
    //   874: aload 12
    //   876: astore 11
    //   878: aload_1
    //   879: astore 10
    //   881: aload_0
    //   882: astore 9
    //   884: new 85	java/lang/StringBuilder
    //   887: dup
    //   888: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   891: ldc 213
    //   893: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: aload 13
    //   898: invokevirtual 214	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   901: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   907: invokestatic 66	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   910: aload_0
    //   911: ifnull +7 -> 918
    //   914: aload_0
    //   915: invokevirtual 164	java/io/InputStream:close	()V
    //   918: aload_1
    //   919: ifnull +7 -> 926
    //   922: aload_1
    //   923: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   926: iload 4
    //   928: istore_3
    //   929: aload 12
    //   931: ifnull -449 -> 482
    //   934: aload 12
    //   936: invokevirtual 170	java/io/BufferedReader:close	()V
    //   939: iload 4
    //   941: istore_3
    //   942: goto -460 -> 482
    //   945: astore_0
    //   946: iload 4
    //   948: istore_3
    //   949: goto -467 -> 482
    //   952: astore 13
    //   954: aconst_null
    //   955: astore_0
    //   956: aconst_null
    //   957: astore_1
    //   958: aconst_null
    //   959: astore 12
    //   961: sipush -1003
    //   964: istore 4
    //   966: aload 12
    //   968: astore 11
    //   970: aload_1
    //   971: astore 10
    //   973: aload_0
    //   974: astore 9
    //   976: aload 13
    //   978: invokevirtual 215	java/lang/Exception:printStackTrace	()V
    //   981: aload 12
    //   983: astore 11
    //   985: aload_1
    //   986: astore 10
    //   988: aload_0
    //   989: astore 9
    //   991: new 85	java/lang/StringBuilder
    //   994: dup
    //   995: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   998: ldc 217
    //   1000: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1003: aload 13
    //   1005: invokevirtual 218	java/lang/Exception:toString	()Ljava/lang/String;
    //   1008: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1011: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1014: invokestatic 66	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   1017: aload_0
    //   1018: ifnull +7 -> 1025
    //   1021: aload_0
    //   1022: invokevirtual 164	java/io/InputStream:close	()V
    //   1025: aload_1
    //   1026: ifnull +7 -> 1033
    //   1029: aload_1
    //   1030: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   1033: iload 4
    //   1035: istore_3
    //   1036: aload 12
    //   1038: ifnull -556 -> 482
    //   1041: aload 12
    //   1043: invokevirtual 170	java/io/BufferedReader:close	()V
    //   1046: iload 4
    //   1048: istore_3
    //   1049: goto -567 -> 482
    //   1052: astore_0
    //   1053: iload 4
    //   1055: istore_3
    //   1056: goto -574 -> 482
    //   1059: astore_1
    //   1060: aconst_null
    //   1061: astore_0
    //   1062: aload 9
    //   1064: astore_2
    //   1065: aload_0
    //   1066: ifnull +7 -> 1073
    //   1069: aload_0
    //   1070: invokevirtual 164	java/io/InputStream:close	()V
    //   1073: aload_2
    //   1074: ifnull +7 -> 1081
    //   1077: aload_2
    //   1078: invokevirtual 167	java/io/InputStreamReader:close	()V
    //   1081: aload 10
    //   1083: ifnull +8 -> 1091
    //   1086: aload 10
    //   1088: invokevirtual 170	java/io/BufferedReader:close	()V
    //   1091: aload_1
    //   1092: athrow
    //   1093: astore_0
    //   1094: goto -525 -> 569
    //   1097: astore_0
    //   1098: goto -7 -> 1091
    //   1101: astore_1
    //   1102: aload 9
    //   1104: astore_2
    //   1105: goto -40 -> 1065
    //   1108: astore 9
    //   1110: aload_1
    //   1111: astore_2
    //   1112: aload 9
    //   1114: astore_1
    //   1115: goto -50 -> 1065
    //   1118: astore_1
    //   1119: aload 10
    //   1121: astore_2
    //   1122: aload 11
    //   1124: astore 10
    //   1126: aload 9
    //   1128: astore_0
    //   1129: goto -64 -> 1065
    //   1132: astore 13
    //   1134: aconst_null
    //   1135: astore_1
    //   1136: aconst_null
    //   1137: astore 12
    //   1139: goto -178 -> 961
    //   1142: astore 13
    //   1144: aconst_null
    //   1145: astore 12
    //   1147: goto -186 -> 961
    //   1150: astore 13
    //   1152: goto -191 -> 961
    //   1155: astore 13
    //   1157: aconst_null
    //   1158: astore_0
    //   1159: aconst_null
    //   1160: astore_1
    //   1161: aconst_null
    //   1162: astore 12
    //   1164: goto -310 -> 854
    //   1167: astore 13
    //   1169: aconst_null
    //   1170: astore_1
    //   1171: aconst_null
    //   1172: astore 12
    //   1174: goto -320 -> 854
    //   1177: astore 13
    //   1179: aconst_null
    //   1180: astore 12
    //   1182: goto -328 -> 854
    //   1185: astore_0
    //   1186: iload 4
    //   1188: istore_3
    //   1189: goto -707 -> 482
    //   1192: astore 13
    //   1194: aconst_null
    //   1195: astore_1
    //   1196: aconst_null
    //   1197: astore 12
    //   1199: goto -805 -> 394
    //   1202: astore 13
    //   1204: aconst_null
    //   1205: astore 12
    //   1207: goto -813 -> 394
    //   1210: astore 13
    //   1212: goto -818 -> 394
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1215	0	paramContext	Context
    //   0	1215	1	paramString1	String
    //   0	1215	2	paramString2	String
    //   197	992	3	i	int
    //   194	993	4	j	int
    //   3	499	5	l1	long
    //   485	15	7	l2	long
    //   9	1094	9	localObject1	Object
    //   1108	19	9	localObject2	Object
    //   103	1022	10	localObject3	Object
    //   55	1068	11	localObject4	Object
    //   130	1076	12	localObject5	Object
    //   50	280	13	localObject6	Object
    //   385	353	13	localIOException1	java.io.IOException
    //   755	82	13	localObject7	Object
    //   852	45	13	localInterruptedException1	java.lang.InterruptedException
    //   952	52	13	localException1	Exception
    //   1132	1	13	localException2	Exception
    //   1142	1	13	localException3	Exception
    //   1150	1	13	localException4	Exception
    //   1155	1	13	localInterruptedException2	java.lang.InterruptedException
    //   1167	1	13	localInterruptedException3	java.lang.InterruptedException
    //   1177	1	13	localInterruptedException4	java.lang.InterruptedException
    //   1192	1	13	localIOException2	java.io.IOException
    //   1202	1	13	localIOException3	java.io.IOException
    //   1210	1	13	localIOException4	java.io.IOException
    //   684	30	14	str	String
    //   834	16	14	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   345	353	377	java/io/IOException
    //   357	365	377	java/io/IOException
    //   369	377	377	java/io/IOException
    //   309	316	380	finally
    //   381	383	380	finally
    //   105	196	385	java/io/IOException
    //   204	215	385	java/io/IOException
    //   222	309	385	java/io/IOException
    //   316	341	385	java/io/IOException
    //   383	385	385	java/io/IOException
    //   578	584	385	java/io/IOException
    //   796	800	827	java/io/IOException
    //   804	808	827	java/io/IOException
    //   816	821	827	java/io/IOException
    //   770	777	834	finally
    //   836	839	834	finally
    //   613	619	852	java/lang/InterruptedException
    //   629	636	852	java/lang/InterruptedException
    //   646	669	852	java/lang/InterruptedException
    //   679	686	852	java/lang/InterruptedException
    //   701	724	852	java/lang/InterruptedException
    //   737	742	852	java/lang/InterruptedException
    //   752	757	852	java/lang/InterruptedException
    //   767	770	852	java/lang/InterruptedException
    //   787	792	852	java/lang/InterruptedException
    //   849	852	852	java/lang/InterruptedException
    //   914	918	945	java/io/IOException
    //   922	926	945	java/io/IOException
    //   934	939	945	java/io/IOException
    //   105	196	952	java/lang/Exception
    //   204	215	952	java/lang/Exception
    //   222	309	952	java/lang/Exception
    //   316	341	952	java/lang/Exception
    //   383	385	952	java/lang/Exception
    //   578	584	952	java/lang/Exception
    //   1021	1025	1052	java/io/IOException
    //   1029	1033	1052	java/io/IOException
    //   1041	1046	1052	java/io/IOException
    //   105	196	1059	finally
    //   204	215	1059	finally
    //   222	309	1059	finally
    //   316	341	1059	finally
    //   383	385	1059	finally
    //   578	584	1059	finally
    //   526	569	1093	java/lang/Exception
    //   1069	1073	1097	java/io/IOException
    //   1077	1081	1097	java/io/IOException
    //   1086	1091	1097	java/io/IOException
    //   584	593	1101	finally
    //   593	603	1108	finally
    //   409	414	1118	finally
    //   424	450	1118	finally
    //   613	619	1118	finally
    //   629	636	1118	finally
    //   646	669	1118	finally
    //   679	686	1118	finally
    //   701	724	1118	finally
    //   737	742	1118	finally
    //   752	757	1118	finally
    //   767	770	1118	finally
    //   787	792	1118	finally
    //   849	852	1118	finally
    //   869	874	1118	finally
    //   884	910	1118	finally
    //   976	981	1118	finally
    //   991	1017	1118	finally
    //   584	593	1132	java/lang/Exception
    //   593	603	1142	java/lang/Exception
    //   613	619	1150	java/lang/Exception
    //   629	636	1150	java/lang/Exception
    //   646	669	1150	java/lang/Exception
    //   679	686	1150	java/lang/Exception
    //   701	724	1150	java/lang/Exception
    //   737	742	1150	java/lang/Exception
    //   752	757	1150	java/lang/Exception
    //   767	770	1150	java/lang/Exception
    //   787	792	1150	java/lang/Exception
    //   849	852	1150	java/lang/Exception
    //   105	196	1155	java/lang/InterruptedException
    //   204	215	1155	java/lang/InterruptedException
    //   222	309	1155	java/lang/InterruptedException
    //   316	341	1155	java/lang/InterruptedException
    //   383	385	1155	java/lang/InterruptedException
    //   578	584	1155	java/lang/InterruptedException
    //   584	593	1167	java/lang/InterruptedException
    //   593	603	1177	java/lang/InterruptedException
    //   454	458	1185	java/io/IOException
    //   462	466	1185	java/io/IOException
    //   474	479	1185	java/io/IOException
    //   584	593	1192	java/io/IOException
    //   593	603	1202	java/io/IOException
    //   613	619	1210	java/io/IOException
    //   629	636	1210	java/io/IOException
    //   646	669	1210	java/io/IOException
    //   679	686	1210	java/io/IOException
    //   701	724	1210	java/io/IOException
    //   737	742	1210	java/io/IOException
    //   752	757	1210	java/io/IOException
    //   767	770	1210	java/io/IOException
    //   787	792	1210	java/io/IOException
    //   849	852	1210	java/io/IOException
  }
  
  public static brkq a(String paramString)
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.lvcc.name(), "640|640|384|768|30");
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject == null) || (localObject.length <= 1)) {}
    }
    int j;
    File localFile;
    for (;;)
    {
      try
      {
        i = Integer.valueOf(localObject[1]).intValue();
        j = i;
        if (i <= 0) {
          j = 640;
        }
        localObject = new brkq();
        localFile = new File(paramString);
        if (!localFile.exists())
        {
          ((brkq)localObject).jdField_a_of_type_Boolean = false;
          a("[@] getCompressConfig : [!file.exists]");
        }
        paramString = a(paramString);
        if ((paramString != null) && (paramString.length == 5) && (paramString[0] == 0)) {
          break;
        }
        ((brkq)localObject).jdField_a_of_type_Boolean = false;
        a("[@] getCompressConfig : values=" + paramString);
        if (paramString != null) {
          a("[@] getCompressConfig : values.length=" + paramString.length + " err=" + paramString[0]);
        }
        return localObject;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoTrimmer", 2, "getCompressConfig -> get DpcConfig Erro", localNumberFormatException);
        }
      }
      i = 0;
    }
    localNumberFormatException.jdField_a_of_type_JavaLangString = a(paramString[3]);
    localNumberFormatException.jdField_a_of_type_Int = paramString[1];
    localNumberFormatException.jdField_b_of_type_Int = paramString[2];
    int i = (int)(paramString[4] / 1000.0D + 0.5D);
    if (i == 0)
    {
      localNumberFormatException.jdField_a_of_type_Boolean = false;
      a("[@] getCompressConfig : [sec == 0 OR video duration < 0.5 sec]");
      return localNumberFormatException;
    }
    localNumberFormatException.jdField_b_of_type_Long = (localFile.length() / (i * 128));
    i = Math.max(paramString[1], paramString[2]);
    if (i <= j + 60)
    {
      if (localNumberFormatException.jdField_b_of_type_Long > 1688L)
      {
        localNumberFormatException.jdField_a_of_type_Boolean = true;
        localNumberFormatException.e = 25;
        localNumberFormatException.c = paramString[1];
        localNumberFormatException.d = paramString[2];
        return localNumberFormatException;
      }
      localNumberFormatException.jdField_a_of_type_Boolean = false;
      a("[@] getCompressConfig : [kbps > CODE_RATE] judge Failure...");
      return localNumberFormatException;
    }
    localNumberFormatException.jdField_a_of_type_Boolean = true;
    float f = j / i;
    localNumberFormatException.c = ((int)(paramString[1] * f));
    localNumberFormatException.d = ((int)(f * paramString[2]));
    localNumberFormatException.e = 25;
    return localNumberFormatException;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "0";
    case 0: 
      return "0";
    case 1: 
      return "90";
    case 2: 
      return "180";
    }
    return "270";
  }
  
  private static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoTrimmer", 2, paramString);
    }
    if (jdField_a_of_type_Boolean) {
      Log.d("ShortVideoTrimmer", paramString);
    }
  }
  
  public static boolean a(Context paramContext, int paramInt1, int paramInt2)
  {
    boolean bool2 = b(paramContext, paramInt1, paramInt2);
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (VideoEnvironment.a("AVCodec", paramContext) != 0) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  /* Error */
  private static boolean a(java.io.InputStream paramInputStream, byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: new 351	java/io/FileOutputStream
    //   6: dup
    //   7: aload_2
    //   8: invokespecial 352	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   11: astore 7
    //   13: iconst_0
    //   14: istore_3
    //   15: aload 7
    //   17: astore_2
    //   18: aload_0
    //   19: aload_1
    //   20: iload_3
    //   21: aload_1
    //   22: arraylength
    //   23: iload_3
    //   24: isub
    //   25: invokevirtual 356	java/io/InputStream:read	([BII)I
    //   28: istore 4
    //   30: iload 4
    //   32: iconst_m1
    //   33: if_icmpeq +39 -> 72
    //   36: iload_3
    //   37: iload 4
    //   39: iadd
    //   40: istore 4
    //   42: iload 4
    //   44: istore_3
    //   45: aload 7
    //   47: astore_2
    //   48: iload 4
    //   50: aload_1
    //   51: arraylength
    //   52: if_icmpne -37 -> 15
    //   55: aload 7
    //   57: astore_2
    //   58: aload 7
    //   60: aload_1
    //   61: iconst_0
    //   62: iload 4
    //   64: invokevirtual 360	java/io/FileOutputStream:write	([BII)V
    //   67: iconst_0
    //   68: istore_3
    //   69: goto -54 -> 15
    //   72: iload_3
    //   73: ifeq +14 -> 87
    //   76: aload 7
    //   78: astore_2
    //   79: aload 7
    //   81: aload_1
    //   82: iconst_0
    //   83: iload_3
    //   84: invokevirtual 360	java/io/FileOutputStream:write	([BII)V
    //   87: iconst_1
    //   88: istore 6
    //   90: iload 6
    //   92: istore 5
    //   94: aload 7
    //   96: ifnull +12 -> 108
    //   99: aload 7
    //   101: invokevirtual 361	java/io/FileOutputStream:close	()V
    //   104: iload 6
    //   106: istore 5
    //   108: iload 5
    //   110: ireturn
    //   111: astore_1
    //   112: aconst_null
    //   113: astore_0
    //   114: aload_0
    //   115: astore_2
    //   116: aload_1
    //   117: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   120: aload_0
    //   121: ifnull -13 -> 108
    //   124: aload_0
    //   125: invokevirtual 361	java/io/FileOutputStream:close	()V
    //   128: iconst_0
    //   129: ireturn
    //   130: astore_0
    //   131: iconst_0
    //   132: ireturn
    //   133: astore_0
    //   134: aconst_null
    //   135: astore_2
    //   136: aload_2
    //   137: ifnull +7 -> 144
    //   140: aload_2
    //   141: invokevirtual 361	java/io/FileOutputStream:close	()V
    //   144: aload_0
    //   145: athrow
    //   146: astore_0
    //   147: iconst_1
    //   148: ireturn
    //   149: astore_1
    //   150: goto -6 -> 144
    //   153: astore_0
    //   154: goto -18 -> 136
    //   157: astore_1
    //   158: aload 7
    //   160: astore_0
    //   161: goto -47 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramInputStream	java.io.InputStream
    //   0	164	1	paramArrayOfByte	byte[]
    //   0	164	2	paramString	String
    //   14	70	3	i	int
    //   28	35	4	j	int
    //   1	108	5	bool1	boolean
    //   88	17	6	bool2	boolean
    //   11	148	7	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   3	13	111	java/io/IOException
    //   124	128	130	java/io/IOException
    //   3	13	133	finally
    //   99	104	146	java/io/IOException
    //   140	144	149	java/io/IOException
    //   18	30	153	finally
    //   48	55	153	finally
    //   58	67	153	finally
    //   79	87	153	finally
    //   116	120	153	finally
    //   18	30	157	java/io/IOException
    //   48	55	157	java/io/IOException
    //   58	67	157	java/io/IOException
    //   79	87	157	java/io/IOException
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    if (!new File(paramString1).exists()) {}
    do
    {
      return true;
      paramString1 = MD5.getFileMd5(paramString1);
      paramString2 = MD5.getFileMd5(paramString2);
      paramString1 = HexUtil.bytes2HexStr(paramString1);
      paramString2 = HexUtil.bytes2HexStr(paramString2);
      a("[@] trimBinMd5Judge : pieMd5=" + paramString1 + "  outMd5=" + paramString2);
    } while ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString1.equals(paramString2)));
    return false;
  }
  
  /* Error */
  @android.annotation.TargetApi(17)
  public static int[] a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: getstatic 397	android/os/Build$VERSION:SDK_INT	I
    //   5: bipush 17
    //   7: if_icmplt +131 -> 138
    //   10: new 399	android/media/MediaMetadataRetriever
    //   13: dup
    //   14: invokespecial 400	android/media/MediaMetadataRetriever:<init>	()V
    //   17: astore_3
    //   18: aload_3
    //   19: aload_0
    //   20: invokevirtual 403	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   23: aload_3
    //   24: bipush 18
    //   26: invokevirtual 406	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   29: astore_2
    //   30: aload_3
    //   31: bipush 19
    //   33: invokevirtual 406	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   36: astore 4
    //   38: aload_3
    //   39: bipush 24
    //   41: invokevirtual 406	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   44: astore 5
    //   46: aload_3
    //   47: bipush 9
    //   49: invokevirtual 406	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   52: astore 6
    //   54: iconst_5
    //   55: newarray int
    //   57: astore_0
    //   58: aload_0
    //   59: iconst_0
    //   60: iconst_0
    //   61: iastore
    //   62: aload_0
    //   63: iconst_1
    //   64: aload_2
    //   65: invokestatic 254	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   68: invokevirtual 257	java/lang/Integer:intValue	()I
    //   71: iastore
    //   72: aload_0
    //   73: iconst_2
    //   74: aload 4
    //   76: invokestatic 254	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   79: invokevirtual 257	java/lang/Integer:intValue	()I
    //   82: iastore
    //   83: aload_0
    //   84: iconst_3
    //   85: aload 5
    //   87: invokestatic 254	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   90: invokevirtual 257	java/lang/Integer:intValue	()I
    //   93: iastore
    //   94: aload_0
    //   95: iconst_4
    //   96: aload 6
    //   98: invokestatic 254	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   101: invokevirtual 257	java/lang/Integer:intValue	()I
    //   104: iastore
    //   105: aload_3
    //   106: invokevirtual 409	android/media/MediaMetadataRetriever:release	()V
    //   109: aload_0
    //   110: areturn
    //   111: astore_2
    //   112: aconst_null
    //   113: astore_0
    //   114: ldc_w 279
    //   117: iconst_1
    //   118: ldc_w 411
    //   121: aload_2
    //   122: invokestatic 285	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   125: aload_3
    //   126: invokevirtual 409	android/media/MediaMetadataRetriever:release	()V
    //   129: aload_0
    //   130: areturn
    //   131: astore_0
    //   132: aload_3
    //   133: invokevirtual 409	android/media/MediaMetadataRetriever:release	()V
    //   136: aload_0
    //   137: athrow
    //   138: aload_0
    //   139: invokestatic 415	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:getRealProperties	(Ljava/lang/String;)Ljava/lang/String;
    //   142: astore_0
    //   143: aload_0
    //   144: ifnull +79 -> 223
    //   147: aload_0
    //   148: ldc_w 417
    //   151: invokevirtual 248	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   154: astore_3
    //   155: aload_3
    //   156: ifnull +67 -> 223
    //   159: aload_3
    //   160: arraylength
    //   161: ifle +62 -> 223
    //   164: aload_3
    //   165: arraylength
    //   166: newarray int
    //   168: astore_2
    //   169: aload_2
    //   170: astore_0
    //   171: iload_1
    //   172: aload_3
    //   173: arraylength
    //   174: if_icmpge -65 -> 109
    //   177: aload_2
    //   178: iload_1
    //   179: aload_3
    //   180: iload_1
    //   181: aaload
    //   182: invokestatic 254	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   185: invokevirtual 257	java/lang/Integer:intValue	()I
    //   188: iastore
    //   189: iload_1
    //   190: iconst_1
    //   191: iadd
    //   192: istore_1
    //   193: goto -24 -> 169
    //   196: astore_0
    //   197: aload_0
    //   198: invokevirtual 418	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   201: ldc_w 420
    //   204: invokestatic 66	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   207: aconst_null
    //   208: astore_0
    //   209: goto -66 -> 143
    //   212: astore_0
    //   213: aload_0
    //   214: invokevirtual 215	java/lang/Exception:printStackTrace	()V
    //   217: ldc_w 422
    //   220: invokestatic 66	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   223: aconst_null
    //   224: areturn
    //   225: astore_2
    //   226: goto -112 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	paramString	String
    //   1	192	1	i	int
    //   29	36	2	str1	String
    //   111	11	2	localException1	Exception
    //   168	10	2	arrayOfInt	int[]
    //   225	1	2	localException2	Exception
    //   17	163	3	localObject	Object
    //   36	39	4	str2	String
    //   44	42	5	str3	String
    //   52	45	6	str4	String
    // Exception table:
    //   from	to	target	type
    //   18	58	111	java/lang/Exception
    //   18	58	131	finally
    //   62	105	131	finally
    //   114	125	131	finally
    //   138	143	196	java/lang/UnsatisfiedLinkError
    //   171	189	212	java/lang/Exception
    //   62	105	225	java/lang/Exception
  }
  
  private static String[] a(String paramString1, String paramString2, brkq parambrkq)
  {
    String str1 = "1";
    if (a() >= 2) {
      str1 = "2";
    }
    String str2 = parambrkq.c + "x" + String.valueOf(parambrkq.d);
    a("[@] generateCommand threads=" + str1 + "  resolution=" + str2);
    return new String[] { "-d", "-y", "-threads", str1, "-copyts", "-copytb", "0", "-i", paramString1, "-metadata:s", "rotate=" + parambrkq.jdField_a_of_type_JavaLangString, "-acodec", "aac", "-vcodec", "libx264", "-preset", "ultrafast", "-tune", "fastdecode", "-profile:v", "High", "-level", "1.3", "-minrate", "300k", "-maxrate", "600k", "-bufsize", "800k", "-qmin", "1", "-qmax", String.valueOf(parambrkq.e), "-qdiff", "3", "-bf", "3", "-coder", "1", "-refs", "1", "-s", str2, "-movflags", "faststart", paramString2 };
  }
  
  /* Error */
  @android.annotation.TargetApi(9)
  private static boolean b(Context paramContext, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 5
    //   9: aload_0
    //   10: invokestatic 77	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoPath	(Landroid/content/Context;)Ljava/lang/String;
    //   13: astore 10
    //   15: new 32	java/io/File
    //   18: dup
    //   19: aload 10
    //   21: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 9
    //   26: aload 9
    //   28: invokevirtual 97	java/io/File:exists	()Z
    //   31: ifne +9 -> 40
    //   34: aload 9
    //   36: invokevirtual 514	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: iload_1
    //   41: ifeq +7 -> 48
    //   44: iload_2
    //   45: ifne +127 -> 172
    //   48: iconst_0
    //   49: putstatic 83	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_Boolean	Z
    //   52: getstatic 397	android/os/Build$VERSION:SDK_INT	I
    //   55: bipush 16
    //   57: if_icmplt +87 -> 144
    //   60: new 85	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   67: aload 10
    //   69: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc_w 516
    //   75: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore 9
    //   83: iconst_0
    //   84: istore_3
    //   85: new 85	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   92: aload 10
    //   94: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc 113
    //   99: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: astore 10
    //   107: new 32	java/io/File
    //   110: dup
    //   111: aload 10
    //   113: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   116: invokevirtual 97	java/io/File:exists	()Z
    //   119: ifeq +81 -> 200
    //   122: getstatic 83	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_Boolean	Z
    //   125: ifne +75 -> 200
    //   128: aload 9
    //   130: aload 10
    //   132: invokestatic 518	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   135: ifeq +65 -> 200
    //   138: iconst_1
    //   139: istore 4
    //   141: iload 4
    //   143: ireturn
    //   144: new 85	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   151: aload 10
    //   153: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc_w 520
    //   159: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: astore 9
    //   167: iconst_0
    //   168: istore_3
    //   169: goto -84 -> 85
    //   172: iconst_1
    //   173: putstatic 83	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:jdField_a_of_type_Boolean	Z
    //   176: getstatic 397	android/os/Build$VERSION:SDK_INT	I
    //   179: bipush 16
    //   181: if_icmplt +11 -> 192
    //   184: iload_1
    //   185: istore_3
    //   186: aconst_null
    //   187: astore 9
    //   189: goto -104 -> 85
    //   192: iload_2
    //   193: istore_3
    //   194: aconst_null
    //   195: astore 9
    //   197: goto -112 -> 85
    //   200: iload_1
    //   201: ifeq +7 -> 208
    //   204: iload_2
    //   205: ifne +140 -> 345
    //   208: new 522	java/io/FileInputStream
    //   211: dup
    //   212: aload 9
    //   214: invokespecial 523	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   217: astore_0
    //   218: ldc_w 525
    //   221: invokestatic 66	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   224: aload_0
    //   225: astore 8
    //   227: aload_0
    //   228: astore 7
    //   230: aload_0
    //   231: sipush 8192
    //   234: newarray byte
    //   236: aload 10
    //   238: invokestatic 527	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/io/InputStream;[BLjava/lang/String;)Z
    //   241: istore 6
    //   243: aload_0
    //   244: astore 8
    //   246: aload_0
    //   247: astore 7
    //   249: new 85	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   256: ldc_w 529
    //   259: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: iload 6
    //   264: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   267: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 66	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   273: iload 6
    //   275: istore 4
    //   277: iload 6
    //   279: ifeq +55 -> 334
    //   282: aload_0
    //   283: astore 8
    //   285: aload_0
    //   286: astore 7
    //   288: new 32	java/io/File
    //   291: dup
    //   292: aload 10
    //   294: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   297: iconst_1
    //   298: iconst_1
    //   299: invokevirtual 536	java/io/File:setExecutable	(ZZ)Z
    //   302: istore 4
    //   304: aload_0
    //   305: astore 8
    //   307: aload_0
    //   308: astore 7
    //   310: new 85	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   317: ldc_w 538
    //   320: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: iload 4
    //   325: invokevirtual 532	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   328: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokestatic 66	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   334: aload_0
    //   335: ifnull +7 -> 342
    //   338: aload_0
    //   339: invokevirtual 164	java/io/InputStream:close	()V
    //   342: iload 4
    //   344: ireturn
    //   345: aload_0
    //   346: invokevirtual 544	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   349: iload_3
    //   350: invokevirtual 550	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   353: astore_0
    //   354: aload_0
    //   355: astore 8
    //   357: aload_0
    //   358: astore 7
    //   360: ldc_w 552
    //   363: invokestatic 66	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   366: goto -142 -> 224
    //   369: astore_0
    //   370: aload 8
    //   372: astore 7
    //   374: aload_0
    //   375: invokevirtual 215	java/lang/Exception:printStackTrace	()V
    //   378: aload 8
    //   380: astore 7
    //   382: new 85	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   389: ldc_w 554
    //   392: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: aload_0
    //   396: invokevirtual 218	java/lang/Exception:toString	()Ljava/lang/String;
    //   399: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 66	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)V
    //   408: iload 5
    //   410: istore 4
    //   412: aload 8
    //   414: ifnull -273 -> 141
    //   417: aload 8
    //   419: invokevirtual 164	java/io/InputStream:close	()V
    //   422: iconst_0
    //   423: ireturn
    //   424: astore_0
    //   425: aload_0
    //   426: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   429: iconst_0
    //   430: ireturn
    //   431: astore_0
    //   432: aload_0
    //   433: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   436: goto -94 -> 342
    //   439: astore_0
    //   440: aload 7
    //   442: ifnull +8 -> 450
    //   445: aload 7
    //   447: invokevirtual 164	java/io/InputStream:close	()V
    //   450: aload_0
    //   451: athrow
    //   452: astore 7
    //   454: aload 7
    //   456: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   459: goto -9 -> 450
    //   462: astore 8
    //   464: aload_0
    //   465: astore 7
    //   467: aload 8
    //   469: astore_0
    //   470: goto -30 -> 440
    //   473: astore 7
    //   475: aload_0
    //   476: astore 8
    //   478: aload 7
    //   480: astore_0
    //   481: goto -111 -> 370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	484	0	paramContext	Context
    //   0	484	1	paramInt1	int
    //   0	484	2	paramInt2	int
    //   84	266	3	i	int
    //   139	272	4	bool1	boolean
    //   7	402	5	bool2	boolean
    //   241	37	6	bool3	boolean
    //   1	445	7	localObject1	Object
    //   452	3	7	localIOException	java.io.IOException
    //   465	1	7	localContext1	Context
    //   473	6	7	localException	Exception
    //   4	414	8	localContext2	Context
    //   462	6	8	localObject2	Object
    //   476	1	8	localContext3	Context
    //   24	189	9	localObject3	Object
    //   13	280	10	str	String
    // Exception table:
    //   from	to	target	type
    //   208	218	369	java/lang/Exception
    //   230	243	369	java/lang/Exception
    //   249	273	369	java/lang/Exception
    //   288	304	369	java/lang/Exception
    //   310	334	369	java/lang/Exception
    //   345	354	369	java/lang/Exception
    //   360	366	369	java/lang/Exception
    //   417	422	424	java/io/IOException
    //   338	342	431	java/io/IOException
    //   208	218	439	finally
    //   230	243	439	finally
    //   249	273	439	finally
    //   288	304	439	finally
    //   310	334	439	finally
    //   345	354	439	finally
    //   360	366	439	finally
    //   374	378	439	finally
    //   382	408	439	finally
    //   445	450	452	java/io/IOException
    //   218	224	462	finally
    //   218	224	473	java/lang/Exception
  }
  
  public static native String getRealProperties(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer
 * JD-Core Version:    0.7.0.1
 */