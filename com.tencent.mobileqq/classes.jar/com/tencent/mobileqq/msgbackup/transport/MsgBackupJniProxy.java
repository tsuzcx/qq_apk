package com.tencent.mobileqq.msgbackup.transport;

import android.content.Context;
import android.os.Build.VERSION;
import arpa;
import arrx;
import arsa;
import arsc;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArraySet;

public class MsgBackupJniProxy
{
  public MsgBackupJniProxy(Context paramContext)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 24) {
        a(paramContext, "c++_shared", "/lib/");
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 24) {
          a(paramContext, "xplatform", "/txlib/");
        }
        for (;;)
        {
          try
          {
            SoLoadUtilNew.loadSoByName(paramContext, "msgbackup");
            return;
          }
          catch (UnsatisfiedLinkError paramContext)
          {
            QLog.e("MsgBackup-Proxy", 1, paramContext, new Object[0]);
          }
          SoLoadUtil.a(paramContext, "c++_shared", 0, false);
          break;
          localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
          localUnsatisfiedLinkError1.printStackTrace();
          break;
          SoLoadUtil.a(paramContext, "xplatform", 0, false);
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
      {
        for (;;)
        {
          localUnsatisfiedLinkError2.printStackTrace();
        }
      }
    }
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +28 -> 34
    //   9: ldc 47
    //   11: iconst_2
    //   12: new 60	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   19: ldc 63
    //   21: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: invokestatic 81	android/os/SystemClock:uptimeMillis	()J
    //   37: lstore 4
    //   39: ldc 83
    //   41: astore 13
    //   43: new 60	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   50: ldc 85
    //   52: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 87
    //   61: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore 14
    //   69: iconst_0
    //   70: istore 10
    //   72: aload_0
    //   73: astore 12
    //   75: aload_0
    //   76: ifnonnull +8 -> 84
    //   79: invokestatic 93	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   82: astore 12
    //   84: new 60	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   91: aload 12
    //   93: invokevirtual 99	android/content/Context:getFilesDir	()Ljava/io/File;
    //   96: invokevirtual 104	java/io/File:getParent	()Ljava/lang/String;
    //   99: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_2
    //   103: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: astore 17
    //   111: ldc 47
    //   113: iconst_1
    //   114: ldc 106
    //   116: invokestatic 109	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: new 101	java/io/File
    //   122: dup
    //   123: new 60	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   130: aload 17
    //   132: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload 14
    //   137: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokespecial 112	java/io/File:<init>	(Ljava/lang/String;)V
    //   146: astore_2
    //   147: invokestatic 117	com/tencent/common/config/AppSetting:g	()Ljava/lang/String;
    //   150: astore_0
    //   151: new 60	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   158: ldc 119
    //   160: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_1
    //   164: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: astore 18
    //   172: new 60	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   179: ldc 121
    //   181: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_1
    //   185: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: astore 15
    //   193: aload 12
    //   195: ldc 123
    //   197: iconst_0
    //   198: invokevirtual 127	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   201: astore 16
    //   203: aload 16
    //   205: aload 18
    //   207: ldc 129
    //   209: invokeinterface 135 3 0
    //   214: astore 19
    //   216: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   219: ifeq +47 -> 266
    //   222: ldc 47
    //   224: iconst_2
    //   225: new 60	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   232: ldc 137
    //   234: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_1
    //   238: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: ldc 139
    //   243: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload 19
    //   248: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: ldc 141
    //   253: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_0
    //   257: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   266: aload_0
    //   267: aload 19
    //   269: invokestatic 147	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   272: ifne +46 -> 318
    //   275: aload_2
    //   276: invokevirtual 150	java/io/File:exists	()Z
    //   279: ifeq +8 -> 287
    //   282: aload_2
    //   283: invokevirtual 153	java/io/File:delete	()Z
    //   286: pop
    //   287: ldc 155
    //   289: aload_0
    //   290: invokevirtual 160	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   293: ifeq +225 -> 518
    //   296: aload 16
    //   298: invokeinterface 164 1 0
    //   303: aload 18
    //   305: ldc 129
    //   307: invokeinterface 170 3 0
    //   312: invokeinterface 173 1 0
    //   317: pop
    //   318: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   321: ifeq +11 -> 332
    //   324: ldc 47
    //   326: iconst_2
    //   327: ldc 175
    //   329: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: aload 13
    //   334: astore_0
    //   335: aload_2
    //   336: invokevirtual 150	java/io/File:exists	()Z
    //   339: ifne +77 -> 416
    //   342: aload 12
    //   344: aload 17
    //   346: ldc 177
    //   348: aload 14
    //   350: invokestatic 180	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   353: istore_3
    //   354: ldc 47
    //   356: iconst_1
    //   357: new 60	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   364: ldc 182
    //   366: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: iload_3
    //   370: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   373: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 109	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   379: iload_3
    //   380: ifeq +168 -> 548
    //   383: aload_2
    //   384: invokevirtual 153	java/io/File:delete	()Z
    //   387: pop
    //   388: new 60	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   395: ldc 83
    //   397: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: ldc 187
    //   402: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: astore_0
    //   409: ldc 47
    //   411: iconst_1
    //   412: aload_0
    //   413: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   416: ldc 47
    //   418: iconst_1
    //   419: ldc 191
    //   421: invokestatic 109	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   424: aload_2
    //   425: invokevirtual 150	java/io/File:exists	()Z
    //   428: istore 11
    //   430: iload 11
    //   432: ifeq +354 -> 786
    //   435: aload_2
    //   436: invokevirtual 194	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   439: invokestatic 199	java/lang/System:load	(Ljava/lang/String;)V
    //   442: iconst_1
    //   443: istore 10
    //   445: iload 10
    //   447: istore 11
    //   449: iload 10
    //   451: ifne +18 -> 469
    //   454: ldc 47
    //   456: iconst_1
    //   457: ldc 201
    //   459: invokestatic 109	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   462: aload_1
    //   463: invokestatic 204	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   466: iconst_1
    //   467: istore 11
    //   469: invokestatic 81	android/os/SystemClock:uptimeMillis	()J
    //   472: lstore 6
    //   474: ldc 47
    //   476: iconst_1
    //   477: new 60	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   484: ldc 206
    //   486: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload_1
    //   490: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: ldc 208
    //   495: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: lload 6
    //   500: lload 4
    //   502: lsub
    //   503: invokevirtual 211	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   506: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 109	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   512: ldc 2
    //   514: monitorexit
    //   515: iload 11
    //   517: ireturn
    //   518: aload 16
    //   520: invokeinterface 164 1 0
    //   525: aload 18
    //   527: aload_0
    //   528: invokeinterface 170 3 0
    //   533: invokeinterface 173 1 0
    //   538: pop
    //   539: goto -221 -> 318
    //   542: astore_0
    //   543: ldc 2
    //   545: monitorexit
    //   546: aload_0
    //   547: athrow
    //   548: aload_2
    //   549: invokestatic 217	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   552: lstore 6
    //   554: aload 16
    //   556: invokeinterface 164 1 0
    //   561: aload 15
    //   563: lload 6
    //   565: invokeinterface 221 4 0
    //   570: invokeinterface 173 1 0
    //   575: pop
    //   576: aload 13
    //   578: astore_0
    //   579: goto -163 -> 416
    //   582: astore 12
    //   584: aload_2
    //   585: invokestatic 217	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   588: lstore 6
    //   590: aload 16
    //   592: aload 15
    //   594: ldc2_w 222
    //   597: invokeinterface 227 4 0
    //   602: lstore 8
    //   604: lload 6
    //   606: ldc2_w 222
    //   609: lcmp
    //   610: ifeq +86 -> 696
    //   613: lload 6
    //   615: lload 8
    //   617: lcmp
    //   618: ifeq +78 -> 696
    //   621: aload_2
    //   622: invokevirtual 153	java/io/File:delete	()Z
    //   625: pop
    //   626: new 60	java/lang/StringBuilder
    //   629: dup
    //   630: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   633: aload_0
    //   634: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: ldc 229
    //   639: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: lload 6
    //   644: invokevirtual 211	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   647: ldc 231
    //   649: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: lload 8
    //   654: invokevirtual 211	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   657: ldc 233
    //   659: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: aload_2
    //   663: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   666: ldc 238
    //   668: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: aload 12
    //   673: invokestatic 242	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   676: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   682: astore_0
    //   683: ldc 47
    //   685: iconst_1
    //   686: aload_0
    //   687: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   690: iconst_0
    //   691: istore 10
    //   693: goto -248 -> 445
    //   696: new 60	java/lang/StringBuilder
    //   699: dup
    //   700: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   703: aload_0
    //   704: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: ldc 244
    //   709: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: aload_2
    //   713: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   716: ldc 238
    //   718: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: aload 12
    //   723: invokestatic 242	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   726: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   732: astore_0
    //   733: ldc 47
    //   735: iconst_1
    //   736: aload_0
    //   737: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   740: iconst_0
    //   741: istore 10
    //   743: goto -298 -> 445
    //   746: astore_2
    //   747: ldc 47
    //   749: iconst_1
    //   750: new 60	java/lang/StringBuilder
    //   753: dup
    //   754: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   757: aload_0
    //   758: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: ldc 246
    //   763: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: aload_2
    //   767: invokestatic 242	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   770: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   776: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   779: iload 10
    //   781: istore 11
    //   783: goto -314 -> 469
    //   786: goto -341 -> 445
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	789	0	paramContext	Context
    //   0	789	1	paramString1	String
    //   0	789	2	paramString2	String
    //   353	27	3	i	int
    //   37	464	4	l1	long
    //   472	171	6	l2	long
    //   602	51	8	l3	long
    //   70	710	10	bool1	boolean
    //   428	354	11	bool2	boolean
    //   73	270	12	localObject	Object
    //   582	140	12	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   41	536	13	str1	String
    //   67	282	14	str2	String
    //   191	402	15	str3	String
    //   201	390	16	localSharedPreferences	android.content.SharedPreferences
    //   109	236	17	str4	String
    //   170	356	18	str5	String
    //   214	54	19	str6	String
    // Exception table:
    //   from	to	target	type
    //   3	34	542	finally
    //   34	39	542	finally
    //   43	69	542	finally
    //   79	84	542	finally
    //   84	266	542	finally
    //   266	287	542	finally
    //   287	318	542	finally
    //   318	332	542	finally
    //   335	379	542	finally
    //   383	416	542	finally
    //   416	430	542	finally
    //   435	442	542	finally
    //   454	462	542	finally
    //   462	466	542	finally
    //   469	512	542	finally
    //   518	539	542	finally
    //   548	576	542	finally
    //   584	604	542	finally
    //   621	690	542	finally
    //   696	740	542	finally
    //   747	779	542	finally
    //   435	442	582	java/lang/UnsatisfiedLinkError
    //   462	466	746	java/lang/UnsatisfiedLinkError
  }
  
  public static native byte[] decryptFromByteArray(byte[] paramArrayOfByte, String paramString);
  
  public static native String decryptFromString(String paramString1, String paramString2);
  
  public static native byte[] encryptFromByteArray(byte[] paramArrayOfByte, String paramString);
  
  public static native String encryptFromString(String paramString1, String paramString2);
  
  public void a(long paramLong1, int paramInt, String paramString, long paramLong2)
  {
    sendMessage(paramLong1, paramInt, paramString, paramLong2, 0L);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup-Proxy", 2, "sendFile path = " + paramString + ", fid = " + paramLong3 + ", sessionId = " + paramLong2);
    }
    sendFile(paramLong1, paramLong2, paramLong3, paramString, 0L);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup-Proxy", 2, "received from Buffer url = " + paramString + ", fid = " + paramLong2);
    }
    recvToBuffer(paramLong1, paramLong2, paramString, 0L);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2, boolean paramBoolean1, long paramLong3, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup-Proxy", 2, "received File url = " + paramString1 + ", fid = " + paramLong2 + ", path = " + paramString2 + ", trivial = " + paramBoolean1 + ", isResTask = " + paramBoolean2);
    }
    if ((paramBoolean1) && (paramBoolean2))
    {
      arsa.a();
      arpa.a().a.add(Long.valueOf(paramLong2));
      arrx localarrx = arsa.a;
      localarrx.j += 1L;
    }
    recvFile(paramLong1, paramLong2, paramString1, paramString2, paramBoolean1, paramLong3, 0L);
  }
  
  public void a(long paramLong, String paramString)
  {
    setEncryptKey(paramLong, paramString, arsc.b);
  }
  
  public void b(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup-Proxy", 2, "sendBuffer buffer = " + paramString + ", fid = " + paramLong3 + ", sessionId = " + paramLong2);
    }
    sendBuffer(paramLong1, paramLong2, paramLong3, paramString, 0L);
  }
  
  public native void cancelAllRecvTasks(long paramLong);
  
  public native void cancelAllSendTasks(long paramLong);
  
  public native int cancelRecvFile(long paramLong1, long paramLong2);
  
  public native int cancelSendFile(long paramLong1, long paramLong2, long paramLong3);
  
  public native long createSession(int paramInt, long paramLong, MsgBackupNotifier paramMsgBackupNotifier);
  
  public native void destroySession(long paramLong);
  
  public native byte[] getRecvBuffer(long paramLong1, long paramLong2);
  
  public native int getVersoEndpoint(long paramLong, MsgBackupEndPoint paramMsgBackupEndPoint);
  
  public native int queryReachability(long paramLong, MsgBackupNetState paramMsgBackupNetState);
  
  public native void recvFile(long paramLong1, long paramLong2, String paramString1, String paramString2, boolean paramBoolean, long paramLong3, long paramLong4);
  
  public native void recvToBuffer(long paramLong1, long paramLong2, String paramString, long paramLong3);
  
  public native void refuseFileRequest(long paramLong1, long paramLong2, long paramLong3, String paramString);
  
  public native void sendBuffer(long paramLong1, long paramLong2, long paramLong3, String paramString, long paramLong4);
  
  public native void sendFile(long paramLong1, long paramLong2, long paramLong3, String paramString, long paramLong4);
  
  public native void sendMessage(long paramLong1, int paramInt, String paramString, long paramLong2, long paramLong3);
  
  public native void setEncryptKey(long paramLong, String paramString, boolean paramBoolean);
  
  public native void setPeerEndpoint(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public native int start(long paramLong, MsgBackupEndPoint paramMsgBackupEndPoint1, MsgBackupEndPoint paramMsgBackupEndPoint2);
  
  public native void stop(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.transport.MsgBackupJniProxy
 * JD-Core Version:    0.7.0.1
 */