package com.tencent.mobileqq.msf.service;

import android.content.Intent;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.RemoteException;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.ac;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.core.net.a.f;
import com.tencent.mobileqq.msf.core.push.g;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

public class v
  implements IBinder.DeathRecipient
{
  private static final int A = 2;
  private static final int B = 1;
  private static final int C = 0;
  private static int D = 0;
  private static int E = 3;
  public static final int a = 2;
  public static final int b = 1;
  public static final int c = 0;
  public static final int d = 3;
  public static final boolean e = true;
  private static final int h = 90000;
  private static final int i = 500;
  private static final String j = "GuardManager";
  private static final String k = "gm_history";
  private static final int l = 1;
  private static final int m = 2;
  private static final int n = 3;
  private static final int o = 4;
  private static final int p = 5;
  private static long q = 720000L;
  private static long s;
  private static long t;
  public boolean f = false;
  public volatile boolean g = false;
  private IBinder r;
  private int u = 1;
  private long v = 0L;
  private v.a w;
  private v.a x;
  private v.a y;
  private MsfCore z;
  
  public v(MsfCore paramMsfCore)
  {
    this.z = paramMsfCore;
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    int i1 = 1;
    paramInt1 = 1;
    if (paramInt3 != 0)
    {
      if (paramInt3 == 2) {
        paramInt1 = 2;
      }
      D = paramInt1;
    }
    else if (D == 0)
    {
      paramInt1 = i1;
      if (new Random().nextInt(2) == 0) {
        paramInt1 = 2;
      }
      D = paramInt1;
    }
    Object localObject = Calendar.getInstance(Locale.getDefault());
    ((Calendar)localObject).setTimeInMillis(paramLong - 15000L);
    paramInt1 = ((Calendar)localObject).get(7);
    paramLong = ((Calendar)localObject).get(11) * 60 * 60 * 1000 + paramLong % 3600000L;
    if (D == 2)
    {
      if (paramBoolean) {
        localObject = "11";
      } else {
        localObject = "10";
      }
    }
    else if (paramBoolean) {
      localObject = "01";
    } else {
      localObject = "00";
    }
    a("GM_StartTime", paramLong, (String)localObject);
    E = paramInt2;
    a(0L, paramLong, paramInt1);
  }
  
  private void a(long paramLong1, long paramLong2, int paramInt)
  {
    if (paramLong1 != 0L)
    {
      localObject = Calendar.getInstance(Locale.getDefault());
      ((Calendar)localObject).setTimeInMillis(paramLong1 - 15000L);
      paramInt = ((Calendar)localObject).get(7);
      paramLong2 = ((Calendar)localObject).get(11) * 60 * 60 * 1000 + paramLong1 % 3600000L;
    }
    if (this.y == null) {
      d();
    }
    Object localObject = this.y;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1;
    if (paramLong1 == 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((v.a)localObject).a(paramLong2, bool1);
    if ((paramInt != 1) && (paramInt != 7))
    {
      localObject = this.w;
      bool1 = bool2;
      if (paramLong1 == 0L) {
        bool1 = true;
      }
      ((v.a)localObject).a(paramLong2, bool1);
    }
    else
    {
      localObject = this.x;
      bool1 = bool3;
      if (paramLong1 == 0L) {
        bool1 = true;
      }
      ((v.a)localObject).a(paramLong2, bool1);
    }
    e();
  }
  
  private void a(String paramString1, long paramLong, String paramString2)
  {
    if (paramString2 != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("Tag", paramString2);
      paramString2 = localHashMap;
    }
    else
    {
      paramString2 = null;
    }
    if (this.z.getStatReporter() != null) {
      this.z.getStatReporter().a(paramString1, true, paramLong, 0L, paramString2, false, false);
    }
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 171	java/io/ObjectInputStream
    //   5: dup
    //   6: invokestatic 177	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9: ldc 33
    //   11: invokevirtual 181	com/tencent/qphone/base/util/BaseApplication:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   14: invokespecial 184	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore 7
    //   19: aload 7
    //   21: astore 6
    //   23: aload 7
    //   25: invokevirtual 188	java/io/ObjectInputStream:readByte	()B
    //   28: istore_2
    //   29: iload_2
    //   30: ifeq +87 -> 117
    //   33: bipush 24
    //   35: iload_2
    //   36: irem
    //   37: ifne +80 -> 117
    //   40: aload 7
    //   42: astore 6
    //   44: iload_2
    //   45: newarray long
    //   47: astore 8
    //   49: aload 7
    //   51: astore 6
    //   53: iload_2
    //   54: newarray long
    //   56: astore 9
    //   58: iconst_0
    //   59: istore_1
    //   60: iload_1
    //   61: iload_2
    //   62: if_icmpge +36 -> 98
    //   65: aload 7
    //   67: astore 6
    //   69: aload 9
    //   71: iload_1
    //   72: aload 7
    //   74: invokevirtual 191	java/io/ObjectInputStream:readLong	()J
    //   77: lastore
    //   78: aload 7
    //   80: astore 6
    //   82: aload 8
    //   84: iload_1
    //   85: aload 7
    //   87: invokevirtual 191	java/io/ObjectInputStream:readLong	()J
    //   90: lastore
    //   91: iload_1
    //   92: iconst_1
    //   93: iadd
    //   94: istore_1
    //   95: goto -35 -> 60
    //   98: aload 7
    //   100: astore 6
    //   102: aload_0
    //   103: new 132	com/tencent/mobileqq/msf/service/v$a
    //   106: dup
    //   107: aload 9
    //   109: aload 8
    //   111: invokespecial 194	com/tencent/mobileqq/msf/service/v$a:<init>	([J[J)V
    //   114: putfield 137	com/tencent/mobileqq/msf/service/v:w	Lcom/tencent/mobileqq/msf/service/v$a;
    //   117: aload 7
    //   119: astore 6
    //   121: aload 7
    //   123: invokevirtual 197	java/io/ObjectInputStream:readInt	()I
    //   126: putstatic 123	com/tencent/mobileqq/msf/service/v:E	I
    //   129: aload 7
    //   131: astore 6
    //   133: aload 7
    //   135: invokevirtual 197	java/io/ObjectInputStream:readInt	()I
    //   138: putstatic 78	com/tencent/mobileqq/msf/service/v:D	I
    //   141: aload 7
    //   143: astore 6
    //   145: aload 7
    //   147: invokevirtual 191	java/io/ObjectInputStream:readLong	()J
    //   150: lstore 4
    //   152: iload_2
    //   153: istore_1
    //   154: lload 4
    //   156: ldc2_w 198
    //   159: lcmp
    //   160: ifgt +7 -> 167
    //   163: lload 4
    //   165: l2i
    //   166: istore_1
    //   167: iconst_1
    //   168: istore_3
    //   169: iload_1
    //   170: ifeq +106 -> 276
    //   173: bipush 24
    //   175: iload_1
    //   176: irem
    //   177: ifne +99 -> 276
    //   180: aload 7
    //   182: astore 6
    //   184: iload_1
    //   185: newarray long
    //   187: astore 8
    //   189: aload 7
    //   191: astore 6
    //   193: iload_1
    //   194: newarray long
    //   196: astore 9
    //   198: aload 9
    //   200: iconst_0
    //   201: lload 4
    //   203: lastore
    //   204: aload 7
    //   206: astore 6
    //   208: aload 8
    //   210: iconst_0
    //   211: aload 7
    //   213: invokevirtual 191	java/io/ObjectInputStream:readLong	()J
    //   216: lastore
    //   217: iconst_1
    //   218: istore_2
    //   219: iload_2
    //   220: iload_1
    //   221: if_icmpge +36 -> 257
    //   224: aload 7
    //   226: astore 6
    //   228: aload 9
    //   230: iload_2
    //   231: aload 7
    //   233: invokevirtual 191	java/io/ObjectInputStream:readLong	()J
    //   236: lastore
    //   237: aload 7
    //   239: astore 6
    //   241: aload 8
    //   243: iload_2
    //   244: aload 7
    //   246: invokevirtual 191	java/io/ObjectInputStream:readLong	()J
    //   249: lastore
    //   250: iload_2
    //   251: iconst_1
    //   252: iadd
    //   253: istore_2
    //   254: goto -35 -> 219
    //   257: aload 7
    //   259: astore 6
    //   261: aload_0
    //   262: new 132	com/tencent/mobileqq/msf/service/v$a
    //   265: dup
    //   266: aload 9
    //   268: aload 8
    //   270: invokespecial 194	com/tencent/mobileqq/msf/service/v$a:<init>	([J[J)V
    //   273: putfield 139	com/tencent/mobileqq/msf/service/v:x	Lcom/tencent/mobileqq/msf/service/v$a;
    //   276: aload 7
    //   278: astore 6
    //   280: aload 7
    //   282: invokevirtual 197	java/io/ObjectInputStream:readInt	()I
    //   285: istore_2
    //   286: iload_2
    //   287: ifeq +106 -> 393
    //   290: bipush 24
    //   292: iload_2
    //   293: irem
    //   294: ifne +99 -> 393
    //   297: aload 7
    //   299: astore 6
    //   301: iload_2
    //   302: newarray long
    //   304: astore 8
    //   306: aload 7
    //   308: astore 6
    //   310: iload_2
    //   311: newarray long
    //   313: astore 9
    //   315: aload 9
    //   317: iconst_0
    //   318: lload 4
    //   320: lastore
    //   321: aload 7
    //   323: astore 6
    //   325: aload 8
    //   327: iconst_0
    //   328: aload 7
    //   330: invokevirtual 191	java/io/ObjectInputStream:readLong	()J
    //   333: lastore
    //   334: iload_3
    //   335: istore_1
    //   336: iload_1
    //   337: iload_2
    //   338: if_icmpge +36 -> 374
    //   341: aload 7
    //   343: astore 6
    //   345: aload 9
    //   347: iload_1
    //   348: aload 7
    //   350: invokevirtual 191	java/io/ObjectInputStream:readLong	()J
    //   353: lastore
    //   354: aload 7
    //   356: astore 6
    //   358: aload 8
    //   360: iload_1
    //   361: aload 7
    //   363: invokevirtual 191	java/io/ObjectInputStream:readLong	()J
    //   366: lastore
    //   367: iload_1
    //   368: iconst_1
    //   369: iadd
    //   370: istore_1
    //   371: goto -35 -> 336
    //   374: aload 7
    //   376: astore 6
    //   378: aload_0
    //   379: new 132	com/tencent/mobileqq/msf/service/v$a
    //   382: dup
    //   383: aload 9
    //   385: aload 8
    //   387: invokespecial 194	com/tencent/mobileqq/msf/service/v$a:<init>	([J[J)V
    //   390: putfield 128	com/tencent/mobileqq/msf/service/v:y	Lcom/tencent/mobileqq/msf/service/v$a;
    //   393: aload 7
    //   395: invokevirtual 202	java/io/ObjectInputStream:close	()V
    //   398: goto +90 -> 488
    //   401: astore 6
    //   403: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   406: ifeq +82 -> 488
    //   409: ldc 30
    //   411: iconst_2
    //   412: ldc 210
    //   414: aload 6
    //   416: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   419: goto +69 -> 488
    //   422: astore 8
    //   424: goto +16 -> 440
    //   427: astore 6
    //   429: aconst_null
    //   430: astore 7
    //   432: goto +171 -> 603
    //   435: astore 8
    //   437: aconst_null
    //   438: astore 7
    //   440: aload 7
    //   442: astore 6
    //   444: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   447: ifeq +17 -> 464
    //   450: aload 7
    //   452: astore 6
    //   454: ldc 30
    //   456: iconst_2
    //   457: ldc 215
    //   459: aload 8
    //   461: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   464: aload 7
    //   466: ifnull +22 -> 488
    //   469: aload 7
    //   471: invokevirtual 202	java/io/ObjectInputStream:close	()V
    //   474: goto +14 -> 488
    //   477: astore 6
    //   479: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   482: ifeq +6 -> 488
    //   485: goto -76 -> 409
    //   488: aload_0
    //   489: getfield 128	com/tencent/mobileqq/msf/service/v:y	Lcom/tencent/mobileqq/msf/service/v$a;
    //   492: ifnonnull +58 -> 550
    //   495: aload_0
    //   496: getfield 137	com/tencent/mobileqq/msf/service/v:w	Lcom/tencent/mobileqq/msf/service/v$a;
    //   499: ifnull +154 -> 653
    //   502: aload_0
    //   503: getfield 137	com/tencent/mobileqq/msf/service/v:w	Lcom/tencent/mobileqq/msf/service/v$a;
    //   506: getfield 218	com/tencent/mobileqq/msf/service/v$a:a	[J
    //   509: invokevirtual 223	[J:clone	()Ljava/lang/Object;
    //   512: checkcast 219	[J
    //   515: astore 6
    //   517: aload_0
    //   518: getfield 137	com/tencent/mobileqq/msf/service/v:w	Lcom/tencent/mobileqq/msf/service/v$a;
    //   521: getfield 225	com/tencent/mobileqq/msf/service/v$a:b	[J
    //   524: invokevirtual 223	[J:clone	()Ljava/lang/Object;
    //   527: checkcast 219	[J
    //   530: astore 7
    //   532: goto +3 -> 535
    //   535: aload_0
    //   536: new 132	com/tencent/mobileqq/msf/service/v$a
    //   539: dup
    //   540: aload 6
    //   542: aload 7
    //   544: invokespecial 194	com/tencent/mobileqq/msf/service/v$a:<init>	([J[J)V
    //   547: putfield 128	com/tencent/mobileqq/msf/service/v:y	Lcom/tencent/mobileqq/msf/service/v$a;
    //   550: aload_0
    //   551: getfield 137	com/tencent/mobileqq/msf/service/v:w	Lcom/tencent/mobileqq/msf/service/v$a;
    //   554: ifnonnull +16 -> 570
    //   557: aload_0
    //   558: new 132	com/tencent/mobileqq/msf/service/v$a
    //   561: dup
    //   562: aconst_null
    //   563: aconst_null
    //   564: invokespecial 194	com/tencent/mobileqq/msf/service/v$a:<init>	([J[J)V
    //   567: putfield 137	com/tencent/mobileqq/msf/service/v:w	Lcom/tencent/mobileqq/msf/service/v$a;
    //   570: aload_0
    //   571: getfield 139	com/tencent/mobileqq/msf/service/v:x	Lcom/tencent/mobileqq/msf/service/v$a;
    //   574: ifnonnull +16 -> 590
    //   577: aload_0
    //   578: new 132	com/tencent/mobileqq/msf/service/v$a
    //   581: dup
    //   582: aconst_null
    //   583: aconst_null
    //   584: invokespecial 194	com/tencent/mobileqq/msf/service/v$a:<init>	([J[J)V
    //   587: putfield 139	com/tencent/mobileqq/msf/service/v:x	Lcom/tencent/mobileqq/msf/service/v$a;
    //   590: aload_0
    //   591: monitorexit
    //   592: return
    //   593: astore 8
    //   595: aload 6
    //   597: astore 7
    //   599: aload 8
    //   601: astore 6
    //   603: aload 7
    //   605: ifnull +34 -> 639
    //   608: aload 7
    //   610: invokevirtual 202	java/io/ObjectInputStream:close	()V
    //   613: goto +26 -> 639
    //   616: astore 6
    //   618: goto +24 -> 642
    //   621: astore 7
    //   623: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   626: ifeq +13 -> 639
    //   629: ldc 30
    //   631: iconst_2
    //   632: ldc 210
    //   634: aload 7
    //   636: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   639: aload 6
    //   641: athrow
    //   642: aload_0
    //   643: monitorexit
    //   644: goto +6 -> 650
    //   647: aload 6
    //   649: athrow
    //   650: goto -3 -> 647
    //   653: aconst_null
    //   654: astore 6
    //   656: aload 6
    //   658: astore 7
    //   660: goto -125 -> 535
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	663	0	this	v
    //   59	312	1	i1	int
    //   28	311	2	i2	int
    //   168	167	3	i3	int
    //   150	169	4	l1	long
    //   21	356	6	localObject1	Object
    //   401	14	6	localIOException1	java.io.IOException
    //   427	1	6	localObject2	Object
    //   442	11	6	localObject3	Object
    //   477	1	6	localIOException2	java.io.IOException
    //   515	87	6	localObject4	Object
    //   616	32	6	localObject5	Object
    //   654	3	6	localObject6	Object
    //   17	592	7	localObject7	Object
    //   621	14	7	localIOException3	java.io.IOException
    //   658	1	7	localObject8	Object
    //   47	339	8	arrayOfLong1	long[]
    //   422	1	8	localThrowable1	java.lang.Throwable
    //   435	25	8	localThrowable2	java.lang.Throwable
    //   593	7	8	localObject9	Object
    //   56	328	9	arrayOfLong2	long[]
    // Exception table:
    //   from	to	target	type
    //   393	398	401	java/io/IOException
    //   23	29	422	java/lang/Throwable
    //   44	49	422	java/lang/Throwable
    //   53	58	422	java/lang/Throwable
    //   69	78	422	java/lang/Throwable
    //   82	91	422	java/lang/Throwable
    //   102	117	422	java/lang/Throwable
    //   121	129	422	java/lang/Throwable
    //   133	141	422	java/lang/Throwable
    //   145	152	422	java/lang/Throwable
    //   184	189	422	java/lang/Throwable
    //   193	198	422	java/lang/Throwable
    //   208	217	422	java/lang/Throwable
    //   228	237	422	java/lang/Throwable
    //   241	250	422	java/lang/Throwable
    //   261	276	422	java/lang/Throwable
    //   280	286	422	java/lang/Throwable
    //   301	306	422	java/lang/Throwable
    //   310	315	422	java/lang/Throwable
    //   325	334	422	java/lang/Throwable
    //   345	354	422	java/lang/Throwable
    //   358	367	422	java/lang/Throwable
    //   378	393	422	java/lang/Throwable
    //   2	19	427	finally
    //   2	19	435	java/lang/Throwable
    //   469	474	477	java/io/IOException
    //   23	29	593	finally
    //   44	49	593	finally
    //   53	58	593	finally
    //   69	78	593	finally
    //   82	91	593	finally
    //   102	117	593	finally
    //   121	129	593	finally
    //   133	141	593	finally
    //   145	152	593	finally
    //   184	189	593	finally
    //   193	198	593	finally
    //   208	217	593	finally
    //   228	237	593	finally
    //   241	250	593	finally
    //   261	276	593	finally
    //   280	286	593	finally
    //   301	306	593	finally
    //   310	315	593	finally
    //   325	334	593	finally
    //   345	354	593	finally
    //   358	367	593	finally
    //   378	393	593	finally
    //   444	450	593	finally
    //   454	464	593	finally
    //   393	398	616	finally
    //   403	409	616	finally
    //   409	419	616	finally
    //   469	474	616	finally
    //   479	485	616	finally
    //   488	532	616	finally
    //   535	550	616	finally
    //   550	570	616	finally
    //   570	590	616	finally
    //   608	613	616	finally
    //   623	639	616	finally
    //   639	642	616	finally
    //   608	613	621	java/io/IOException
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 227	java/io/ObjectOutputStream
    //   5: dup
    //   6: invokestatic 177	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9: ldc 33
    //   11: iconst_0
    //   12: invokevirtual 231	com/tencent/qphone/base/util/BaseApplication:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   15: invokespecial 234	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: getfield 137	com/tencent/mobileqq/msf/service/v:w	Lcom/tencent/mobileqq/msf/service/v$a;
    //   25: aload_2
    //   26: iconst_0
    //   27: invokevirtual 237	com/tencent/mobileqq/msf/service/v$a:a	(Ljava/io/ObjectOutputStream;Z)V
    //   30: aload_2
    //   31: astore_1
    //   32: aload_2
    //   33: getstatic 123	com/tencent/mobileqq/msf/service/v:E	I
    //   36: invokevirtual 241	java/io/ObjectOutputStream:writeInt	(I)V
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: getstatic 78	com/tencent/mobileqq/msf/service/v:D	I
    //   45: invokevirtual 241	java/io/ObjectOutputStream:writeInt	(I)V
    //   48: aload_2
    //   49: astore_1
    //   50: aload_0
    //   51: getfield 139	com/tencent/mobileqq/msf/service/v:x	Lcom/tencent/mobileqq/msf/service/v$a;
    //   54: aload_2
    //   55: iconst_1
    //   56: invokevirtual 237	com/tencent/mobileqq/msf/service/v$a:a	(Ljava/io/ObjectOutputStream;Z)V
    //   59: aload_2
    //   60: astore_1
    //   61: aload_0
    //   62: getfield 128	com/tencent/mobileqq/msf/service/v:y	Lcom/tencent/mobileqq/msf/service/v$a;
    //   65: aload_2
    //   66: iconst_0
    //   67: invokevirtual 237	com/tencent/mobileqq/msf/service/v$a:a	(Ljava/io/ObjectOutputStream;Z)V
    //   70: aload_2
    //   71: invokevirtual 242	java/io/ObjectOutputStream:close	()V
    //   74: goto +75 -> 149
    //   77: astore_1
    //   78: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +68 -> 149
    //   84: ldc 30
    //   86: iconst_2
    //   87: ldc 210
    //   89: aload_1
    //   90: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   93: goto +56 -> 149
    //   96: astore_3
    //   97: goto +12 -> 109
    //   100: astore_1
    //   101: aconst_null
    //   102: astore_2
    //   103: goto +54 -> 157
    //   106: astore_3
    //   107: aconst_null
    //   108: astore_2
    //   109: aload_2
    //   110: astore_1
    //   111: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq +14 -> 128
    //   117: aload_2
    //   118: astore_1
    //   119: ldc 30
    //   121: iconst_2
    //   122: ldc 210
    //   124: aload_3
    //   125: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload_2
    //   129: ifnull +20 -> 149
    //   132: aload_2
    //   133: invokevirtual 242	java/io/ObjectOutputStream:close	()V
    //   136: goto +13 -> 149
    //   139: astore_1
    //   140: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq +6 -> 149
    //   146: goto -62 -> 84
    //   149: aload_0
    //   150: monitorexit
    //   151: return
    //   152: astore_3
    //   153: aload_1
    //   154: astore_2
    //   155: aload_3
    //   156: astore_1
    //   157: aload_2
    //   158: ifnull +30 -> 188
    //   161: aload_2
    //   162: invokevirtual 242	java/io/ObjectOutputStream:close	()V
    //   165: goto +23 -> 188
    //   168: astore_1
    //   169: goto +21 -> 190
    //   172: astore_2
    //   173: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +12 -> 188
    //   179: ldc 30
    //   181: iconst_2
    //   182: ldc 210
    //   184: aload_2
    //   185: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   188: aload_1
    //   189: athrow
    //   190: aload_0
    //   191: monitorexit
    //   192: goto +5 -> 197
    //   195: aload_1
    //   196: athrow
    //   197: goto -2 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	v
    //   20	41	1	localObject1	Object
    //   77	13	1	localIOException1	java.io.IOException
    //   100	1	1	localObject2	Object
    //   110	9	1	localObject3	Object
    //   139	15	1	localIOException2	java.io.IOException
    //   156	1	1	localObject4	Object
    //   168	28	1	localObject5	Object
    //   18	144	2	localObject6	Object
    //   172	13	2	localIOException3	java.io.IOException
    //   96	1	3	localThrowable1	java.lang.Throwable
    //   106	19	3	localThrowable2	java.lang.Throwable
    //   152	4	3	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   70	74	77	java/io/IOException
    //   21	30	96	java/lang/Throwable
    //   32	39	96	java/lang/Throwable
    //   41	48	96	java/lang/Throwable
    //   50	59	96	java/lang/Throwable
    //   61	70	96	java/lang/Throwable
    //   2	19	100	finally
    //   2	19	106	java/lang/Throwable
    //   132	136	139	java/io/IOException
    //   21	30	152	finally
    //   32	39	152	finally
    //   41	48	152	finally
    //   50	59	152	finally
    //   61	70	152	finally
    //   111	117	152	finally
    //   119	128	152	finally
    //   70	74	168	finally
    //   78	84	168	finally
    //   84	93	168	finally
    //   132	136	168	finally
    //   140	146	168	finally
    //   161	165	168	finally
    //   173	188	168	finally
    //   188	190	168	finally
    //   161	165	172	java/io/IOException
  }
  
  private boolean f()
  {
    IBinder localIBinder = this.r;
    return (localIBinder != null) && (localIBinder.isBinderAlive());
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onEvent:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramLong2);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = true;
    QLog.d("GuardManager", 1, (String)localObject);
    long l1 = System.currentTimeMillis();
    this.v = l1;
    this.g = true;
    if (paramInt != 100)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 7: 
        a(l1, 0L, 0);
        if (!com.tencent.mobileqq.msf.core.a.a.aQ()) {
          break;
        }
        try
        {
          this.z.sender.I.c().b();
          return;
        }
        catch (Exception localException1)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        QLog.d("GuardManager", 2, "failed to call adaptorcontroller foreground ", localException1);
        return;
      case 6: 
        MsfService.getCore().pushManager.k();
        MsfService.getCore().pushManager.l();
        if (!com.tencent.mobileqq.msf.core.a.a.aQ()) {
          break;
        }
        try
        {
          this.z.sender.I.c().b();
          return;
        }
        catch (Exception localException2)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        QLog.d("GuardManager", 2, "failed to call adaptorcontroller foreground ", localException2);
        return;
      case 5: 
        paramInt = (int)(paramLong1 >> 8);
        int i1 = (int)(paramLong1 & 0xFF);
        if ((paramLong2 & 0xFF) != 1L) {
          bool = false;
        }
        a(l1, paramInt, i1, bool, (int)(paramLong2 >> 8));
        return;
      case 4: 
        this.u = 5;
        q = paramLong1;
        return;
      case 3: 
        this.u = 4;
        return;
      case 2: 
        this.u = 3;
        q = paramLong1;
        return;
      case 1: 
        this.u = 2;
        if (!com.tencent.mobileqq.msf.core.a.a.aQ()) {
          break;
        }
        try
        {
          this.z.sender.I.c().a();
          return;
        }
        catch (Exception localException3)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        QLog.d("GuardManager", 2, "failed to call adaptorcontroller background ", localException3);
        return;
      }
    }
    else
    {
      s = l1;
      t = 0L;
      this.u = 1;
      this.g = false;
      k.d();
    }
  }
  
  public void a(IInterface paramIInterface)
  {
    IBinder localIBinder;
    if (paramIInterface != null) {
      localIBinder = paramIInterface.asBinder();
    } else {
      localIBinder = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAppBind with ");
    localStringBuilder.append(paramIInterface);
    QLog.d("GuardManager", 1, localStringBuilder.toString());
    paramIInterface = this.r;
    if (paramIInterface != localIBinder)
    {
      long l1 = System.currentTimeMillis();
      if (paramIInterface != null)
      {
        paramIInterface.unlinkToDeath(this, 0);
        this.r = null;
        s = l1;
        this.v = l1;
      }
      if ((localIBinder != null) && (localIBinder.isBinderAlive())) {
        try
        {
          localIBinder.linkToDeath(this, 0);
          this.r = localIBinder;
          s = l1;
          return;
        }
        catch (RemoteException paramIInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.d("GuardManager", 2, "onAppBind ", paramIInterface);
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return (this.g) && (f());
  }
  
  public boolean a(int paramInt)
  {
    if (this.f) {
      return true;
    }
    this.f = true;
    long l1 = System.currentTimeMillis();
    long l2 = Math.abs(l1 - t);
    if (((paramInt == 3) && (l2 > 90000L)) || ((paramInt == 1) && (l2 > q)) || ((paramInt == 0) && (l2 > 500L)))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("prestart ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(s);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(q);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(f());
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(t);
      QLog.d("GuardManager", 1, ((StringBuilder)localObject).toString());
      localObject = new Intent("com.tencent.mobileqq.broadcast.qq");
      ((Intent)localObject).putExtra("k_start_mode", paramInt);
      ((Intent)localObject).setPackage(BaseApplication.getContext().getPackageName());
      BaseApplication.getContext().sendBroadcast((Intent)localObject);
      s = l1;
      t = l1;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramInt);
      a("GM_LiteStart", 0L, ((StringBuilder)localObject).toString());
    }
    return true;
  }
  
  public void binderDied()
  {
    QLog.d("GuardManager", 1, "binderDied");
    Object localObject = this.r;
    if (localObject != null)
    {
      ((IBinder)localObject).unlinkToDeath(this, 0);
      this.r = null;
      s = System.currentTimeMillis();
      t = 0L;
      this.g = false;
      long l1 = s - this.v;
      if ((l1 > 0L) && (l1 < 86400000L))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("GM_AliveTime");
        ((StringBuilder)localObject).append(this.u);
        a(((StringBuilder)localObject).toString(), l1, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.v
 * JD-Core Version:    0.7.0.1
 */