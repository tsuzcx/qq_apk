package com.tencent.mobileqq.msf.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.a.c;
import com.tencent.mobileqq.msf.core.a.c.a;
import com.tencent.mobileqq.msf.core.net.b;
import com.tencent.mobileqq.msf.core.net.g;
import com.tencent.mobileqq.msf.core.quicksend.QuickSendStrategy;
import com.tencent.mobileqq.msf.sdk.y;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class h
{
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 3;
  public static final String i = "send_mode";
  public static final int j = 0;
  public static final int k = 1;
  public static final String l = "unknown";
  public static final String m = "pcactive";
  public static final String n = "quicksend";
  public static final int o = 0;
  public static final int p = -1;
  public static final int q = 1;
  public static final int r = 2;
  public static final int s = 3;
  public static final int t = 4;
  public static final int u = 5;
  public static final int v = 6;
  private static final String w = "LightTcpSender";
  private int A = 10000;
  private int B = 30000;
  private boolean C = false;
  private final h.a D = new h.a(this);
  b a;
  Network b = null;
  boolean c = true;
  boolean d = false;
  public final LinkedBlockingQueue e = new LinkedBlockingQueue(100);
  private Context x;
  private MsfCore y;
  private Handler z = null;
  
  public h(MsfCore paramMsfCore, Context paramContext)
  {
    this.x = paramContext;
    this.y = paramMsfCore;
    if ((new Random().nextInt(100) % 2 == 0) && (com.tencent.mobileqq.msf.core.a.a.bv()))
    {
      this.d = bool;
      if (this.d) {
        break label169;
      }
    }
    label169:
    for (this.a = new g();; this.a = new com.tencent.mobileqq.msf.core.net.f())
    {
      paramMsfCore = new HandlerThread("LightTcpSenderThread");
      paramMsfCore.start();
      this.z = new h.b(this, paramMsfCore.getLooper());
      com.tencent.mobileqq.msf.core.net.l.a(this.D);
      return;
      bool = false;
      break;
    }
  }
  
  private FromServiceMsg a(FromServiceMsg paramFromServiceMsg)
  {
    byte[] arrayOfByte1;
    int i1;
    if ((paramFromServiceMsg.getFlag() & 0x1) != 0)
    {
      arrayOfByte1 = paramFromServiceMsg.getWupBuffer();
      if (arrayOfByte1.length > 4) {
        i1 = (arrayOfByte1[0] & 0xFF) << 24 | 0x0 | (arrayOfByte1[1] & 0xFF) << 16 | (arrayOfByte1[2] & 0xFF) << 8 | arrayOfByte1[3] & 0xFF;
      }
    }
    else
    {
      try
      {
        byte[] arrayOfByte2 = new byte[i1];
        System.arraycopy(arrayOfByte1, 4, arrayOfByte2, 0, i1 - 4);
        arrayOfByte1 = com.tencent.qphone.base.util.l.b(arrayOfByte2);
        arrayOfByte2 = new byte[arrayOfByte1.length + 4];
        arrayOfByte2[0] = ((byte)(arrayOfByte1.length + 4 >> 24 & 0xFF));
        arrayOfByte2[1] = ((byte)(arrayOfByte1.length + 4 >> 16 & 0xFF));
        arrayOfByte2[2] = ((byte)(arrayOfByte1.length + 4 >> 8 & 0xFF));
        arrayOfByte2[3] = ((byte)(arrayOfByte1.length + 4 & 0xFF));
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 4, arrayOfByte1.length);
        paramFromServiceMsg.putWupBuffer(arrayOfByte2);
        return paramFromServiceMsg;
      }
      catch (Throwable paramFromServiceMsg)
      {
        QLog.d("LightTcpSender", 1, "LightSender uncompress data failed", paramFromServiceMsg);
        return null;
      }
    }
    return null;
  }
  
  private CopyOnWriteArrayList a(CopyOnWriteArrayList paramCopyOnWriteArrayList, String paramString)
  {
    if ((paramCopyOnWriteArrayList == null) || (paramCopyOnWriteArrayList.size() <= 0) || (TextUtils.isEmpty(paramString))) {
      return paramCopyOnWriteArrayList;
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
    while (paramCopyOnWriteArrayList.hasNext())
    {
      d locald = (d)paramCopyOnWriteArrayList.next();
      if ((locald != null) && (paramString.equals(locald.i))) {
        localCopyOnWriteArrayList.add(0, locald);
      } else {
        localCopyOnWriteArrayList.add(locald);
      }
    }
    return localCopyOnWriteArrayList;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt, String paramString, com.tencent.mobileqq.msf.core.quicksend.f paramf)
  {
    paramf.f = paramInt;
    if (paramFromServiceMsg == null)
    {
      FromServiceMsg localFromServiceMsg = w.a(paramToServiceMsg);
      if (localFromServiceMsg != null)
      {
        localFromServiceMsg.setBusinessFail(paramInt, paramString);
        this.y.getSsoRespHandler().a(paramToServiceMsg, localFromServiceMsg);
      }
    }
    for (;;)
    {
      com.tencent.mobileqq.a.a.a.a().a(paramToServiceMsg, paramFromServiceMsg, paramf);
      return;
      this.y.getSsoRespHandler().a(paramToServiceMsg, paramFromServiceMsg);
    }
  }
  
  /* Error */
  private boolean a(com.tencent.mobileqq.msf.core.quicksend.f paramf, ToServiceMsg paramToServiceMsg)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_2
    //   4: ifnull +4056 -> 4060
    //   7: aload_2
    //   8: invokevirtual 274	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   11: istore 4
    //   13: iload 5
    //   15: istore_3
    //   16: aload_2
    //   17: invokevirtual 278	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   20: ldc_w 280
    //   23: invokevirtual 285	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   26: ifeq +32 -> 58
    //   29: aload_2
    //   30: invokevirtual 278	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   33: ldc_w 280
    //   36: invokevirtual 289	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 291	java/lang/Integer
    //   42: astore 13
    //   44: iload 5
    //   46: istore_3
    //   47: aload 13
    //   49: ifnull +9 -> 58
    //   52: aload 13
    //   54: invokevirtual 294	java/lang/Integer:intValue	()I
    //   57: istore_3
    //   58: aload_2
    //   59: invokevirtual 278	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   62: ldc_w 296
    //   65: invokevirtual 285	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   68: ifeq +3968 -> 4036
    //   71: aload_2
    //   72: invokevirtual 278	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   75: ldc_w 296
    //   78: invokevirtual 289	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   81: checkcast 291	java/lang/Integer
    //   84: astore 13
    //   86: aload 13
    //   88: ifnull +3948 -> 4036
    //   91: aload 13
    //   93: invokevirtual 294	java/lang/Integer:intValue	()I
    //   96: istore 6
    //   98: iload 4
    //   100: istore 5
    //   102: iload_3
    //   103: istore 4
    //   105: iload 6
    //   107: istore_3
    //   108: aload_1
    //   109: iconst_0
    //   110: putfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   113: aload_1
    //   114: aload_0
    //   115: getfield 73	com/tencent/mobileqq/msf/core/h:c	Z
    //   118: putfield 300	com/tencent/mobileqq/msf/core/quicksend/f:l	Z
    //   121: aload_2
    //   122: invokevirtual 304	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   125: astore 13
    //   127: aload_0
    //   128: getfield 73	com/tencent/mobileqq/msf/core/h:c	Z
    //   131: ifeq +40 -> 171
    //   134: aload_2
    //   135: ldc_w 306
    //   138: iconst_0
    //   139: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   142: invokevirtual 314	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   145: checkcast 291	java/lang/Integer
    //   148: invokevirtual 294	java/lang/Integer:intValue	()I
    //   151: istore 6
    //   153: aload_2
    //   154: invokevirtual 278	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   157: ldc_w 306
    //   160: iload 6
    //   162: iconst_1
    //   163: iadd
    //   164: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   167: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   170: pop
    //   171: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +615 -> 789
    //   177: new 323	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   184: ldc_w 326
    //   187: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload 13
    //   192: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: ldc_w 332
    //   198: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_2
    //   202: invokevirtual 274	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   205: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: ldc_w 337
    //   211: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: iload 4
    //   216: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   219: ldc_w 339
    //   222: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: astore 13
    //   227: aload_0
    //   228: getfield 73	com/tencent/mobileqq/msf/core/h:c	Z
    //   231: ifeq +546 -> 777
    //   234: iconst_1
    //   235: istore 6
    //   237: aload 13
    //   239: iload 6
    //   241: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   244: ldc_w 341
    //   247: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: astore 13
    //   252: aload_0
    //   253: getfield 81	com/tencent/mobileqq/msf/core/h:d	Z
    //   256: ifeq +527 -> 783
    //   259: iconst_1
    //   260: istore 6
    //   262: ldc 42
    //   264: iconst_1
    //   265: aload 13
    //   267: iload 6
    //   269: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   272: ldc_w 343
    //   275: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokestatic 348	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetworkType	()I
    //   281: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   284: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 354	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: invokestatic 256	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   293: aload_2
    //   294: invokevirtual 357	com/tencent/mobileqq/a/a/a:c	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   297: aload_0
    //   298: aload_2
    //   299: invokespecial 360	com/tencent/mobileqq/msf/core/h:d	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)[B
    //   302: astore 13
    //   304: aload 13
    //   306: ifnonnull +614 -> 920
    //   309: aload_0
    //   310: aload_2
    //   311: aconst_null
    //   312: iconst_1
    //   313: new 323	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   320: ldc_w 362
    //   323: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: iload 5
    //   328: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   331: ldc_w 364
    //   334: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: aload_1
    //   341: invokespecial 366	com/tencent/mobileqq/msf/core/h:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;ILjava/lang/String;Lcom/tencent/mobileqq/msf/core/quicksend/f;)V
    //   344: iconst_0
    //   345: istore 9
    //   347: aload_1
    //   348: invokestatic 372	android/os/SystemClock:elapsedRealtime	()J
    //   351: aload_1
    //   352: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   355: lsub
    //   356: putfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   359: iload 9
    //   361: istore 8
    //   363: aload_0
    //   364: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   367: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   370: ifnull +404 -> 774
    //   373: iload 9
    //   375: istore 8
    //   377: aload_0
    //   378: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   381: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   384: ifnull +390 -> 774
    //   387: iload 9
    //   389: istore 8
    //   391: aload_2
    //   392: ifnull +382 -> 774
    //   395: iload 9
    //   397: istore 8
    //   399: aload_0
    //   400: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   403: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   406: aload_2
    //   407: invokevirtual 388	com/tencent/mobileqq/msf/core/quicksend/b:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   410: ifeq +364 -> 774
    //   413: new 282	java/util/HashMap
    //   416: dup
    //   417: invokespecial 389	java/util/HashMap:<init>	()V
    //   420: astore_2
    //   421: aload_2
    //   422: ldc_w 391
    //   425: aload_1
    //   426: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   429: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   432: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   435: pop
    //   436: aload_2
    //   437: ldc_w 398
    //   440: aload_1
    //   441: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   444: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   447: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   450: pop
    //   451: aload_2
    //   452: ldc_w 405
    //   455: aload_1
    //   456: getfield 407	com/tencent/mobileqq/msf/core/quicksend/f:c	Ljava/lang/String;
    //   459: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   462: pop
    //   463: aload_2
    //   464: ldc_w 409
    //   467: aload_1
    //   468: getfield 411	com/tencent/mobileqq/msf/core/quicksend/f:d	Ljava/lang/String;
    //   471: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   474: pop
    //   475: aload_2
    //   476: ldc_w 413
    //   479: ldc_w 415
    //   482: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   485: pop
    //   486: aload_2
    //   487: ldc_w 417
    //   490: aload_1
    //   491: getfield 419	com/tencent/mobileqq/msf/core/quicksend/f:e	I
    //   494: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   497: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   500: pop
    //   501: aload_2
    //   502: ldc_w 424
    //   505: aload_1
    //   506: getfield 231	com/tencent/mobileqq/msf/core/quicksend/f:f	I
    //   509: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   512: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   515: pop
    //   516: aload_2
    //   517: ldc_w 426
    //   520: aload_1
    //   521: getfield 428	com/tencent/mobileqq/msf/core/quicksend/f:g	J
    //   524: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   527: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   530: pop
    //   531: aload_2
    //   532: ldc_w 430
    //   535: aload_1
    //   536: getfield 432	com/tencent/mobileqq/msf/core/quicksend/f:i	Z
    //   539: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   542: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   545: pop
    //   546: aload_2
    //   547: ldc_w 434
    //   550: aload_1
    //   551: getfield 436	com/tencent/mobileqq/msf/core/quicksend/f:j	J
    //   554: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   557: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   560: pop
    //   561: aload_2
    //   562: ldc_w 438
    //   565: aload_1
    //   566: getfield 440	com/tencent/mobileqq/msf/core/quicksend/f:k	I
    //   569: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   572: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   575: pop
    //   576: aload_2
    //   577: ldc_w 442
    //   580: aload_1
    //   581: getfield 444	com/tencent/mobileqq/msf/core/quicksend/f:m	Ljava/lang/String;
    //   584: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   587: pop
    //   588: aload_2
    //   589: ldc_w 446
    //   592: aload_1
    //   593: getfield 448	com/tencent/mobileqq/msf/core/quicksend/f:h	Ljava/lang/String;
    //   596: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   599: pop
    //   600: aload_2
    //   601: ldc_w 450
    //   604: new 323	java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   611: ldc_w 452
    //   614: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: iload 4
    //   619: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   622: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   628: pop
    //   629: aload_2
    //   630: ldc_w 454
    //   633: new 323	java/lang/StringBuilder
    //   636: dup
    //   637: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   640: ldc_w 452
    //   643: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: iload_3
    //   647: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   650: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   653: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   656: pop
    //   657: aload_2
    //   658: ldc_w 456
    //   661: aload_0
    //   662: getfield 73	com/tencent/mobileqq/msf/core/h:c	Z
    //   665: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   668: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   671: pop
    //   672: aload_2
    //   673: ldc_w 460
    //   676: aload_0
    //   677: getfield 81	com/tencent/mobileqq/msf/core/h:d	Z
    //   680: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   683: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   686: pop
    //   687: iconst_0
    //   688: istore_3
    //   689: aload_1
    //   690: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   693: ifeq +12 -> 705
    //   696: aload_0
    //   697: getfield 73	com/tencent/mobileqq/msf/core/h:c	Z
    //   700: ifeq +3236 -> 3936
    //   703: iconst_4
    //   704: istore_3
    //   705: aload_2
    //   706: ldc_w 462
    //   709: iload_3
    //   710: invokestatic 464	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   713: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   716: pop
    //   717: aload_2
    //   718: getstatic 469	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   721: ldc_w 452
    //   724: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   727: pop
    //   728: aload_0
    //   729: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   732: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   735: astore 13
    //   737: aload_1
    //   738: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   741: istore 8
    //   743: aload_1
    //   744: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   747: lstore 11
    //   749: aload 13
    //   751: astore_1
    //   752: iconst_0
    //   753: istore 9
    //   755: aload_1
    //   756: ldc_w 471
    //   759: iload 8
    //   761: lload 11
    //   763: lconst_0
    //   764: aload_2
    //   765: iconst_0
    //   766: iconst_0
    //   767: invokevirtual 476	com/tencent/mobileqq/msf/core/c/k:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   770: iload 9
    //   772: istore 8
    //   774: iload 8
    //   776: ireturn
    //   777: iconst_0
    //   778: istore 6
    //   780: goto -543 -> 237
    //   783: iconst_0
    //   784: istore 6
    //   786: goto -524 -> 262
    //   789: new 323	java/lang/StringBuilder
    //   792: dup
    //   793: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   796: ldc_w 326
    //   799: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: aload 13
    //   804: invokestatic 481	com/tencent/mobileqq/msf/core/b/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   807: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: ldc_w 332
    //   813: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: aload_2
    //   817: invokevirtual 274	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   820: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   823: ldc_w 337
    //   826: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: iload 4
    //   831: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   834: ldc_w 339
    //   837: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: astore 13
    //   842: aload_0
    //   843: getfield 73	com/tencent/mobileqq/msf/core/h:c	Z
    //   846: ifeq +62 -> 908
    //   849: iconst_1
    //   850: istore 6
    //   852: aload 13
    //   854: iload 6
    //   856: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   859: ldc_w 341
    //   862: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   865: astore 13
    //   867: aload_0
    //   868: getfield 81	com/tencent/mobileqq/msf/core/h:d	Z
    //   871: ifeq +43 -> 914
    //   874: iconst_1
    //   875: istore 6
    //   877: ldc 42
    //   879: iconst_1
    //   880: aload 13
    //   882: iload 6
    //   884: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   887: ldc_w 343
    //   890: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   893: invokestatic 348	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetworkType	()I
    //   896: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   899: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   902: invokestatic 354	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   905: goto -615 -> 290
    //   908: iconst_0
    //   909: istore 6
    //   911: goto -59 -> 852
    //   914: iconst_0
    //   915: istore 6
    //   917: goto -40 -> 877
    //   920: aload_0
    //   921: aload_2
    //   922: invokespecial 184	com/tencent/mobileqq/msf/core/h:c	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Ljava/lang/String;
    //   925: astore 14
    //   927: aload_1
    //   928: aload_2
    //   929: invokevirtual 484	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   932: putfield 407	com/tencent/mobileqq/msf/core/quicksend/f:c	Ljava/lang/String;
    //   935: aload_1
    //   936: aload_2
    //   937: invokevirtual 304	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   940: putfield 411	com/tencent/mobileqq/msf/core/quicksend/f:d	Ljava/lang/String;
    //   943: aload_1
    //   944: aload 13
    //   946: arraylength
    //   947: putfield 419	com/tencent/mobileqq/msf/core/quicksend/f:e	I
    //   950: invokestatic 372	android/os/SystemClock:elapsedRealtime	()J
    //   953: lstore 11
    //   955: aload_0
    //   956: getfield 117	com/tencent/mobileqq/msf/core/h:a	Lcom/tencent/mobileqq/msf/core/net/b;
    //   959: aload_2
    //   960: aload 13
    //   962: aload 14
    //   964: aload_1
    //   965: invokeinterface 489 5 0
    //   970: astore 13
    //   972: aload 13
    //   974: ifnonnull +449 -> 1423
    //   977: aload_0
    //   978: aload_2
    //   979: aconst_null
    //   980: iconst_3
    //   981: new 323	java/lang/StringBuilder
    //   984: dup
    //   985: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   988: ldc_w 362
    //   991: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   994: iload 5
    //   996: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   999: ldc_w 491
    //   1002: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1008: aload_1
    //   1009: invokespecial 366	com/tencent/mobileqq/msf/core/h:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;ILjava/lang/String;Lcom/tencent/mobileqq/msf/core/quicksend/f;)V
    //   1012: iconst_0
    //   1013: istore 9
    //   1015: aload_1
    //   1016: invokestatic 372	android/os/SystemClock:elapsedRealtime	()J
    //   1019: aload_1
    //   1020: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   1023: lsub
    //   1024: putfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   1027: iload 9
    //   1029: istore 8
    //   1031: aload_0
    //   1032: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1035: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   1038: ifnull -264 -> 774
    //   1041: iload 9
    //   1043: istore 8
    //   1045: aload_0
    //   1046: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1049: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   1052: ifnull -278 -> 774
    //   1055: iload 9
    //   1057: istore 8
    //   1059: aload_2
    //   1060: ifnull -286 -> 774
    //   1063: iload 9
    //   1065: istore 8
    //   1067: aload_0
    //   1068: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1071: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   1074: aload_2
    //   1075: invokevirtual 388	com/tencent/mobileqq/msf/core/quicksend/b:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   1078: ifeq -304 -> 774
    //   1081: new 282	java/util/HashMap
    //   1084: dup
    //   1085: invokespecial 389	java/util/HashMap:<init>	()V
    //   1088: astore_2
    //   1089: aload_2
    //   1090: ldc_w 391
    //   1093: aload_1
    //   1094: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   1097: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   1100: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1103: pop
    //   1104: aload_2
    //   1105: ldc_w 398
    //   1108: aload_1
    //   1109: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   1112: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1115: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1118: pop
    //   1119: aload_2
    //   1120: ldc_w 405
    //   1123: aload_1
    //   1124: getfield 407	com/tencent/mobileqq/msf/core/quicksend/f:c	Ljava/lang/String;
    //   1127: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1130: pop
    //   1131: aload_2
    //   1132: ldc_w 409
    //   1135: aload_1
    //   1136: getfield 411	com/tencent/mobileqq/msf/core/quicksend/f:d	Ljava/lang/String;
    //   1139: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1142: pop
    //   1143: aload_2
    //   1144: ldc_w 413
    //   1147: ldc_w 415
    //   1150: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1153: pop
    //   1154: aload_2
    //   1155: ldc_w 417
    //   1158: aload_1
    //   1159: getfield 419	com/tencent/mobileqq/msf/core/quicksend/f:e	I
    //   1162: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1165: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1168: pop
    //   1169: aload_2
    //   1170: ldc_w 424
    //   1173: aload_1
    //   1174: getfield 231	com/tencent/mobileqq/msf/core/quicksend/f:f	I
    //   1177: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1180: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1183: pop
    //   1184: aload_2
    //   1185: ldc_w 426
    //   1188: aload_1
    //   1189: getfield 428	com/tencent/mobileqq/msf/core/quicksend/f:g	J
    //   1192: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1195: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1198: pop
    //   1199: aload_2
    //   1200: ldc_w 430
    //   1203: aload_1
    //   1204: getfield 432	com/tencent/mobileqq/msf/core/quicksend/f:i	Z
    //   1207: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   1210: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1213: pop
    //   1214: aload_2
    //   1215: ldc_w 434
    //   1218: aload_1
    //   1219: getfield 436	com/tencent/mobileqq/msf/core/quicksend/f:j	J
    //   1222: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1225: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1228: pop
    //   1229: aload_2
    //   1230: ldc_w 438
    //   1233: aload_1
    //   1234: getfield 440	com/tencent/mobileqq/msf/core/quicksend/f:k	I
    //   1237: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1240: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1243: pop
    //   1244: aload_2
    //   1245: ldc_w 442
    //   1248: aload_1
    //   1249: getfield 444	com/tencent/mobileqq/msf/core/quicksend/f:m	Ljava/lang/String;
    //   1252: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1255: pop
    //   1256: aload_2
    //   1257: ldc_w 446
    //   1260: aload_1
    //   1261: getfield 448	com/tencent/mobileqq/msf/core/quicksend/f:h	Ljava/lang/String;
    //   1264: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1267: pop
    //   1268: aload_2
    //   1269: ldc_w 450
    //   1272: new 323	java/lang/StringBuilder
    //   1275: dup
    //   1276: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   1279: ldc_w 452
    //   1282: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1285: iload 4
    //   1287: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1290: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1293: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1296: pop
    //   1297: aload_2
    //   1298: ldc_w 454
    //   1301: new 323	java/lang/StringBuilder
    //   1304: dup
    //   1305: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   1308: ldc_w 452
    //   1311: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1314: iload_3
    //   1315: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1318: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1321: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1324: pop
    //   1325: aload_2
    //   1326: ldc_w 456
    //   1329: aload_0
    //   1330: getfield 73	com/tencent/mobileqq/msf/core/h:c	Z
    //   1333: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1336: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1339: pop
    //   1340: aload_2
    //   1341: ldc_w 460
    //   1344: aload_0
    //   1345: getfield 81	com/tencent/mobileqq/msf/core/h:d	Z
    //   1348: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1351: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1354: pop
    //   1355: iconst_0
    //   1356: istore_3
    //   1357: aload_1
    //   1358: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   1361: ifeq +12 -> 1373
    //   1364: aload_0
    //   1365: getfield 73	com/tencent/mobileqq/msf/core/h:c	Z
    //   1368: ifeq +2586 -> 3954
    //   1371: iconst_4
    //   1372: istore_3
    //   1373: aload_2
    //   1374: ldc_w 462
    //   1377: iload_3
    //   1378: invokestatic 464	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1381: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1384: pop
    //   1385: aload_2
    //   1386: getstatic 469	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   1389: ldc_w 452
    //   1392: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1395: pop
    //   1396: aload_0
    //   1397: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1400: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   1403: astore 13
    //   1405: aload_1
    //   1406: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   1409: istore 8
    //   1411: aload_1
    //   1412: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   1415: lstore 11
    //   1417: aload 13
    //   1419: astore_1
    //   1420: goto -668 -> 752
    //   1423: aload_1
    //   1424: invokestatic 372	android/os/SystemClock:elapsedRealtime	()J
    //   1427: lload 11
    //   1429: lsub
    //   1430: putfield 428	com/tencent/mobileqq/msf/core/quicksend/f:g	J
    //   1433: aload_0
    //   1434: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1437: getfield 495	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   1440: getfield 500	com/tencent/mobileqq/msf/core/aj:C	Lcom/tencent/mobileqq/msf/core/aj$a;
    //   1443: aload 13
    //   1445: invokevirtual 506	com/tencent/mobileqq/msf/core/aj$a:nativeParseData	([B)Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   1448: astore 13
    //   1450: aload 13
    //   1452: ifnull +1062 -> 2514
    //   1455: aload_0
    //   1456: aload 13
    //   1458: invokespecial 508	com/tencent/mobileqq/msf/core/h:a	(Lcom/tencent/qphone/base/remote/FromServiceMsg;)Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   1461: astore 13
    //   1463: aload 13
    //   1465: ifnonnull +449 -> 1914
    //   1468: aload_0
    //   1469: aload_2
    //   1470: aconst_null
    //   1471: iconst_5
    //   1472: new 323	java/lang/StringBuilder
    //   1475: dup
    //   1476: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   1479: ldc_w 362
    //   1482: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1485: iload 5
    //   1487: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1490: ldc_w 491
    //   1493: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1496: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1499: aload_1
    //   1500: invokespecial 366	com/tencent/mobileqq/msf/core/h:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;ILjava/lang/String;Lcom/tencent/mobileqq/msf/core/quicksend/f;)V
    //   1503: iconst_0
    //   1504: istore 9
    //   1506: aload_1
    //   1507: invokestatic 372	android/os/SystemClock:elapsedRealtime	()J
    //   1510: aload_1
    //   1511: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   1514: lsub
    //   1515: putfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   1518: iload 9
    //   1520: istore 8
    //   1522: aload_0
    //   1523: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1526: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   1529: ifnull -755 -> 774
    //   1532: iload 9
    //   1534: istore 8
    //   1536: aload_0
    //   1537: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1540: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   1543: ifnull -769 -> 774
    //   1546: iload 9
    //   1548: istore 8
    //   1550: aload_2
    //   1551: ifnull -777 -> 774
    //   1554: iload 9
    //   1556: istore 8
    //   1558: aload_0
    //   1559: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1562: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   1565: aload_2
    //   1566: invokevirtual 388	com/tencent/mobileqq/msf/core/quicksend/b:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   1569: ifeq -795 -> 774
    //   1572: new 282	java/util/HashMap
    //   1575: dup
    //   1576: invokespecial 389	java/util/HashMap:<init>	()V
    //   1579: astore_2
    //   1580: aload_2
    //   1581: ldc_w 391
    //   1584: aload_1
    //   1585: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   1588: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   1591: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1594: pop
    //   1595: aload_2
    //   1596: ldc_w 398
    //   1599: aload_1
    //   1600: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   1603: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1606: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1609: pop
    //   1610: aload_2
    //   1611: ldc_w 405
    //   1614: aload_1
    //   1615: getfield 407	com/tencent/mobileqq/msf/core/quicksend/f:c	Ljava/lang/String;
    //   1618: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1621: pop
    //   1622: aload_2
    //   1623: ldc_w 409
    //   1626: aload_1
    //   1627: getfield 411	com/tencent/mobileqq/msf/core/quicksend/f:d	Ljava/lang/String;
    //   1630: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1633: pop
    //   1634: aload_2
    //   1635: ldc_w 413
    //   1638: ldc_w 415
    //   1641: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1644: pop
    //   1645: aload_2
    //   1646: ldc_w 417
    //   1649: aload_1
    //   1650: getfield 419	com/tencent/mobileqq/msf/core/quicksend/f:e	I
    //   1653: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1656: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1659: pop
    //   1660: aload_2
    //   1661: ldc_w 424
    //   1664: aload_1
    //   1665: getfield 231	com/tencent/mobileqq/msf/core/quicksend/f:f	I
    //   1668: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1671: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1674: pop
    //   1675: aload_2
    //   1676: ldc_w 426
    //   1679: aload_1
    //   1680: getfield 428	com/tencent/mobileqq/msf/core/quicksend/f:g	J
    //   1683: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1686: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1689: pop
    //   1690: aload_2
    //   1691: ldc_w 430
    //   1694: aload_1
    //   1695: getfield 432	com/tencent/mobileqq/msf/core/quicksend/f:i	Z
    //   1698: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   1701: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1704: pop
    //   1705: aload_2
    //   1706: ldc_w 434
    //   1709: aload_1
    //   1710: getfield 436	com/tencent/mobileqq/msf/core/quicksend/f:j	J
    //   1713: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1716: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1719: pop
    //   1720: aload_2
    //   1721: ldc_w 438
    //   1724: aload_1
    //   1725: getfield 440	com/tencent/mobileqq/msf/core/quicksend/f:k	I
    //   1728: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1731: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1734: pop
    //   1735: aload_2
    //   1736: ldc_w 442
    //   1739: aload_1
    //   1740: getfield 444	com/tencent/mobileqq/msf/core/quicksend/f:m	Ljava/lang/String;
    //   1743: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1746: pop
    //   1747: aload_2
    //   1748: ldc_w 446
    //   1751: aload_1
    //   1752: getfield 448	com/tencent/mobileqq/msf/core/quicksend/f:h	Ljava/lang/String;
    //   1755: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1758: pop
    //   1759: aload_2
    //   1760: ldc_w 450
    //   1763: new 323	java/lang/StringBuilder
    //   1766: dup
    //   1767: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   1770: ldc_w 452
    //   1773: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1776: iload 4
    //   1778: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1781: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1784: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1787: pop
    //   1788: aload_2
    //   1789: ldc_w 454
    //   1792: new 323	java/lang/StringBuilder
    //   1795: dup
    //   1796: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   1799: ldc_w 452
    //   1802: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1805: iload_3
    //   1806: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1809: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1812: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1815: pop
    //   1816: aload_2
    //   1817: ldc_w 456
    //   1820: aload_0
    //   1821: getfield 73	com/tencent/mobileqq/msf/core/h:c	Z
    //   1824: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1827: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1830: pop
    //   1831: aload_2
    //   1832: ldc_w 460
    //   1835: aload_0
    //   1836: getfield 81	com/tencent/mobileqq/msf/core/h:d	Z
    //   1839: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1842: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1845: pop
    //   1846: iconst_0
    //   1847: istore_3
    //   1848: aload_1
    //   1849: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   1852: ifeq +12 -> 1864
    //   1855: aload_0
    //   1856: getfield 73	com/tencent/mobileqq/msf/core/h:c	Z
    //   1859: ifeq +2113 -> 3972
    //   1862: iconst_4
    //   1863: istore_3
    //   1864: aload_2
    //   1865: ldc_w 462
    //   1868: iload_3
    //   1869: invokestatic 464	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1872: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1875: pop
    //   1876: aload_2
    //   1877: getstatic 469	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   1880: ldc_w 452
    //   1883: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1886: pop
    //   1887: aload_0
    //   1888: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1891: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   1894: astore 13
    //   1896: aload_1
    //   1897: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   1900: istore 8
    //   1902: aload_1
    //   1903: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   1906: lstore 11
    //   1908: aload 13
    //   1910: astore_1
    //   1911: goto -1159 -> 752
    //   1914: aload 13
    //   1916: aload 13
    //   1918: invokevirtual 511	com/tencent/qphone/base/remote/FromServiceMsg:getAppSeq	()I
    //   1921: invokevirtual 514	com/tencent/qphone/base/remote/FromServiceMsg:setRequestSsoSeq	(I)V
    //   1924: aload 13
    //   1926: invokevirtual 515	com/tencent/qphone/base/remote/FromServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   1929: ldc_w 517
    //   1932: aload_0
    //   1933: getfield 73	com/tencent/mobileqq/msf/core/h:c	Z
    //   1936: invokestatic 520	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1939: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1942: pop
    //   1943: aload_2
    //   1944: ifnull +57 -> 2001
    //   1947: aload 13
    //   1949: aload_2
    //   1950: invokevirtual 521	com/tencent/qphone/base/remote/ToServiceMsg:getAppSeq	()I
    //   1953: invokevirtual 524	com/tencent/qphone/base/remote/FromServiceMsg:setAppSeq	(I)V
    //   1956: aload 13
    //   1958: aload_2
    //   1959: invokevirtual 528	com/tencent/qphone/base/remote/ToServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1962: invokevirtual 532	com/tencent/qphone/base/remote/FromServiceMsg:setMsfCommand	(Lcom/tencent/mobileqq/msf/sdk/MsfCommand;)V
    //   1965: aload 13
    //   1967: aload_2
    //   1968: invokevirtual 535	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   1971: invokevirtual 538	com/tencent/qphone/base/remote/FromServiceMsg:setAppId	(I)V
    //   1974: aload 13
    //   1976: aload_2
    //   1977: invokevirtual 274	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   1980: invokevirtual 514	com/tencent/qphone/base/remote/FromServiceMsg:setRequestSsoSeq	(I)V
    //   1983: aload_2
    //   1984: invokevirtual 278	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   1987: ldc_w 517
    //   1990: aload_0
    //   1991: getfield 73	com/tencent/mobileqq/msf/core/h:c	Z
    //   1994: invokestatic 520	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1997: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2000: pop
    //   2001: aload_0
    //   2002: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2005: invokevirtual 246	com/tencent/mobileqq/msf/core/MsfCore:getSsoRespHandler	()Lcom/tencent/mobileqq/msf/core/al;
    //   2008: aload_2
    //   2009: aload 13
    //   2011: iload 4
    //   2013: invokevirtual 541	com/tencent/mobileqq/msf/core/al:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;I)Z
    //   2016: istore 9
    //   2018: iload 9
    //   2020: ifne +43 -> 2063
    //   2023: iload 9
    //   2025: istore 8
    //   2027: aload_0
    //   2028: aload_2
    //   2029: aconst_null
    //   2030: bipush 6
    //   2032: new 323	java/lang/StringBuilder
    //   2035: dup
    //   2036: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   2039: ldc_w 362
    //   2042: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2045: iload 5
    //   2047: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2050: ldc_w 543
    //   2053: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2056: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2059: aload_1
    //   2060: invokespecial 366	com/tencent/mobileqq/msf/core/h:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;ILjava/lang/String;Lcom/tencent/mobileqq/msf/core/quicksend/f;)V
    //   2063: iload 9
    //   2065: istore 8
    //   2067: aload_1
    //   2068: iconst_1
    //   2069: putfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   2072: iconst_1
    //   2073: istore 10
    //   2075: iconst_1
    //   2076: istore 8
    //   2078: aload_1
    //   2079: invokestatic 372	android/os/SystemClock:elapsedRealtime	()J
    //   2082: aload_1
    //   2083: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   2086: lsub
    //   2087: putfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   2090: aload_0
    //   2091: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2094: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   2097: ifnull +392 -> 2489
    //   2100: aload_0
    //   2101: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2104: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   2107: ifnull +382 -> 2489
    //   2110: aload_2
    //   2111: ifnull +378 -> 2489
    //   2114: aload_0
    //   2115: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2118: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   2121: aload_2
    //   2122: invokevirtual 388	com/tencent/mobileqq/msf/core/quicksend/b:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   2125: ifeq +364 -> 2489
    //   2128: new 282	java/util/HashMap
    //   2131: dup
    //   2132: invokespecial 389	java/util/HashMap:<init>	()V
    //   2135: astore 13
    //   2137: aload 13
    //   2139: ldc_w 391
    //   2142: aload_1
    //   2143: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   2146: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   2149: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2152: pop
    //   2153: aload 13
    //   2155: ldc_w 398
    //   2158: aload_1
    //   2159: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   2162: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2165: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2168: pop
    //   2169: aload 13
    //   2171: ldc_w 405
    //   2174: aload_1
    //   2175: getfield 407	com/tencent/mobileqq/msf/core/quicksend/f:c	Ljava/lang/String;
    //   2178: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2181: pop
    //   2182: aload 13
    //   2184: ldc_w 409
    //   2187: aload_1
    //   2188: getfield 411	com/tencent/mobileqq/msf/core/quicksend/f:d	Ljava/lang/String;
    //   2191: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2194: pop
    //   2195: aload 13
    //   2197: ldc_w 413
    //   2200: ldc_w 415
    //   2203: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2206: pop
    //   2207: aload 13
    //   2209: ldc_w 417
    //   2212: aload_1
    //   2213: getfield 419	com/tencent/mobileqq/msf/core/quicksend/f:e	I
    //   2216: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   2219: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2222: pop
    //   2223: aload 13
    //   2225: ldc_w 424
    //   2228: aload_1
    //   2229: getfield 231	com/tencent/mobileqq/msf/core/quicksend/f:f	I
    //   2232: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   2235: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2238: pop
    //   2239: aload 13
    //   2241: ldc_w 426
    //   2244: aload_1
    //   2245: getfield 428	com/tencent/mobileqq/msf/core/quicksend/f:g	J
    //   2248: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2251: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2254: pop
    //   2255: aload 13
    //   2257: ldc_w 430
    //   2260: aload_1
    //   2261: getfield 432	com/tencent/mobileqq/msf/core/quicksend/f:i	Z
    //   2264: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   2267: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2270: pop
    //   2271: aload 13
    //   2273: ldc_w 434
    //   2276: aload_1
    //   2277: getfield 436	com/tencent/mobileqq/msf/core/quicksend/f:j	J
    //   2280: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2283: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2286: pop
    //   2287: aload 13
    //   2289: ldc_w 438
    //   2292: aload_1
    //   2293: getfield 440	com/tencent/mobileqq/msf/core/quicksend/f:k	I
    //   2296: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   2299: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2302: pop
    //   2303: aload 13
    //   2305: ldc_w 442
    //   2308: aload_1
    //   2309: getfield 444	com/tencent/mobileqq/msf/core/quicksend/f:m	Ljava/lang/String;
    //   2312: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2315: pop
    //   2316: aload 13
    //   2318: ldc_w 446
    //   2321: aload_1
    //   2322: getfield 448	com/tencent/mobileqq/msf/core/quicksend/f:h	Ljava/lang/String;
    //   2325: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2328: pop
    //   2329: aload 13
    //   2331: ldc_w 450
    //   2334: new 323	java/lang/StringBuilder
    //   2337: dup
    //   2338: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   2341: ldc_w 452
    //   2344: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2347: iload 4
    //   2349: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2352: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2355: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2358: pop
    //   2359: aload 13
    //   2361: ldc_w 454
    //   2364: new 323	java/lang/StringBuilder
    //   2367: dup
    //   2368: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   2371: ldc_w 452
    //   2374: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2377: iload_3
    //   2378: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2381: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2384: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2387: pop
    //   2388: aload 13
    //   2390: ldc_w 456
    //   2393: aload_0
    //   2394: getfield 73	com/tencent/mobileqq/msf/core/h:c	Z
    //   2397: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   2400: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2403: pop
    //   2404: aload 13
    //   2406: ldc_w 460
    //   2409: aload_0
    //   2410: getfield 81	com/tencent/mobileqq/msf/core/h:d	Z
    //   2413: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   2416: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2419: pop
    //   2420: iconst_0
    //   2421: istore_3
    //   2422: aload_1
    //   2423: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   2426: ifeq +12 -> 2438
    //   2429: aload_0
    //   2430: getfield 73	com/tencent/mobileqq/msf/core/h:c	Z
    //   2433: ifeq +1557 -> 3990
    //   2436: iconst_4
    //   2437: istore_3
    //   2438: aload 13
    //   2440: ldc_w 462
    //   2443: iload_3
    //   2444: invokestatic 464	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2447: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2450: pop
    //   2451: aload 13
    //   2453: getstatic 469	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   2456: ldc_w 452
    //   2459: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2462: pop
    //   2463: aload_0
    //   2464: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2467: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   2470: ldc_w 471
    //   2473: aload_1
    //   2474: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   2477: aload_1
    //   2478: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   2481: lconst_0
    //   2482: aload 13
    //   2484: iconst_0
    //   2485: iconst_0
    //   2486: invokevirtual 476	com/tencent/mobileqq/msf/core/c/k:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   2489: iload 9
    //   2491: ifeq -1717 -> 774
    //   2494: invokestatic 256	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   2497: astore 13
    //   2499: iload 10
    //   2501: istore 8
    //   2503: aload 13
    //   2505: aload_2
    //   2506: aconst_null
    //   2507: aload_1
    //   2508: invokevirtual 259	com/tencent/mobileqq/a/a/a:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Lcom/tencent/mobileqq/msf/core/quicksend/f;)V
    //   2511: iload 8
    //   2513: ireturn
    //   2514: aload_0
    //   2515: aload_2
    //   2516: aconst_null
    //   2517: iconst_4
    //   2518: new 323	java/lang/StringBuilder
    //   2521: dup
    //   2522: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   2525: ldc_w 362
    //   2528: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2531: iload 5
    //   2533: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2536: ldc_w 545
    //   2539: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2542: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2545: aload_1
    //   2546: invokespecial 366	com/tencent/mobileqq/msf/core/h:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;ILjava/lang/String;Lcom/tencent/mobileqq/msf/core/quicksend/f;)V
    //   2549: aload_1
    //   2550: invokestatic 372	android/os/SystemClock:elapsedRealtime	()J
    //   2553: aload_1
    //   2554: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   2557: lsub
    //   2558: putfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   2561: aload_0
    //   2562: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2565: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   2568: ifnull +371 -> 2939
    //   2571: aload_0
    //   2572: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2575: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   2578: ifnull +361 -> 2939
    //   2581: aload_2
    //   2582: ifnull +357 -> 2939
    //   2585: aload_0
    //   2586: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2589: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   2592: aload_2
    //   2593: invokevirtual 388	com/tencent/mobileqq/msf/core/quicksend/b:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   2596: ifeq +343 -> 2939
    //   2599: new 282	java/util/HashMap
    //   2602: dup
    //   2603: invokespecial 389	java/util/HashMap:<init>	()V
    //   2606: astore_2
    //   2607: aload_2
    //   2608: ldc_w 391
    //   2611: aload_1
    //   2612: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   2615: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   2618: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2621: pop
    //   2622: aload_2
    //   2623: ldc_w 398
    //   2626: aload_1
    //   2627: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   2630: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2633: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2636: pop
    //   2637: aload_2
    //   2638: ldc_w 405
    //   2641: aload_1
    //   2642: getfield 407	com/tencent/mobileqq/msf/core/quicksend/f:c	Ljava/lang/String;
    //   2645: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2648: pop
    //   2649: aload_2
    //   2650: ldc_w 409
    //   2653: aload_1
    //   2654: getfield 411	com/tencent/mobileqq/msf/core/quicksend/f:d	Ljava/lang/String;
    //   2657: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2660: pop
    //   2661: aload_2
    //   2662: ldc_w 413
    //   2665: ldc_w 415
    //   2668: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2671: pop
    //   2672: aload_2
    //   2673: ldc_w 417
    //   2676: aload_1
    //   2677: getfield 419	com/tencent/mobileqq/msf/core/quicksend/f:e	I
    //   2680: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   2683: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2686: pop
    //   2687: aload_2
    //   2688: ldc_w 424
    //   2691: aload_1
    //   2692: getfield 231	com/tencent/mobileqq/msf/core/quicksend/f:f	I
    //   2695: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   2698: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2701: pop
    //   2702: aload_2
    //   2703: ldc_w 426
    //   2706: aload_1
    //   2707: getfield 428	com/tencent/mobileqq/msf/core/quicksend/f:g	J
    //   2710: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2713: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2716: pop
    //   2717: aload_2
    //   2718: ldc_w 430
    //   2721: aload_1
    //   2722: getfield 432	com/tencent/mobileqq/msf/core/quicksend/f:i	Z
    //   2725: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   2728: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2731: pop
    //   2732: aload_2
    //   2733: ldc_w 434
    //   2736: aload_1
    //   2737: getfield 436	com/tencent/mobileqq/msf/core/quicksend/f:j	J
    //   2740: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2743: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2746: pop
    //   2747: aload_2
    //   2748: ldc_w 438
    //   2751: aload_1
    //   2752: getfield 440	com/tencent/mobileqq/msf/core/quicksend/f:k	I
    //   2755: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   2758: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2761: pop
    //   2762: aload_2
    //   2763: ldc_w 442
    //   2766: aload_1
    //   2767: getfield 444	com/tencent/mobileqq/msf/core/quicksend/f:m	Ljava/lang/String;
    //   2770: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2773: pop
    //   2774: aload_2
    //   2775: ldc_w 446
    //   2778: aload_1
    //   2779: getfield 448	com/tencent/mobileqq/msf/core/quicksend/f:h	Ljava/lang/String;
    //   2782: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2785: pop
    //   2786: aload_2
    //   2787: ldc_w 450
    //   2790: new 323	java/lang/StringBuilder
    //   2793: dup
    //   2794: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   2797: ldc_w 452
    //   2800: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2803: iload 4
    //   2805: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2808: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2811: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2814: pop
    //   2815: aload_2
    //   2816: ldc_w 454
    //   2819: new 323	java/lang/StringBuilder
    //   2822: dup
    //   2823: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   2826: ldc_w 452
    //   2829: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2832: iload_3
    //   2833: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2836: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2839: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2842: pop
    //   2843: aload_2
    //   2844: ldc_w 456
    //   2847: aload_0
    //   2848: getfield 73	com/tencent/mobileqq/msf/core/h:c	Z
    //   2851: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   2854: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2857: pop
    //   2858: aload_2
    //   2859: ldc_w 460
    //   2862: aload_0
    //   2863: getfield 81	com/tencent/mobileqq/msf/core/h:d	Z
    //   2866: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   2869: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2872: pop
    //   2873: iconst_0
    //   2874: istore_3
    //   2875: aload_1
    //   2876: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   2879: ifeq +12 -> 2891
    //   2882: aload_0
    //   2883: getfield 73	com/tencent/mobileqq/msf/core/h:c	Z
    //   2886: ifeq +1122 -> 4008
    //   2889: iconst_4
    //   2890: istore_3
    //   2891: aload_2
    //   2892: ldc_w 462
    //   2895: iload_3
    //   2896: invokestatic 464	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2899: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2902: pop
    //   2903: aload_2
    //   2904: getstatic 469	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   2907: ldc_w 452
    //   2910: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2913: pop
    //   2914: aload_0
    //   2915: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2918: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   2921: ldc_w 471
    //   2924: aload_1
    //   2925: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   2928: aload_1
    //   2929: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   2932: lconst_0
    //   2933: aload_2
    //   2934: iconst_0
    //   2935: iconst_0
    //   2936: invokevirtual 476	com/tencent/mobileqq/msf/core/c/k:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   2939: iconst_0
    //   2940: ireturn
    //   2941: astore 13
    //   2943: iconst_0
    //   2944: istore 9
    //   2946: iload 9
    //   2948: istore 8
    //   2950: aload_0
    //   2951: aload_2
    //   2952: aconst_null
    //   2953: iconst_m1
    //   2954: new 323	java/lang/StringBuilder
    //   2957: dup
    //   2958: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   2961: ldc_w 362
    //   2964: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2967: iload 5
    //   2969: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2972: ldc_w 547
    //   2975: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2978: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2981: aload_1
    //   2982: invokespecial 366	com/tencent/mobileqq/msf/core/h:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;ILjava/lang/String;Lcom/tencent/mobileqq/msf/core/quicksend/f;)V
    //   2985: iload 9
    //   2987: istore 8
    //   2989: aload 13
    //   2991: invokevirtual 550	java/lang/Throwable:printStackTrace	()V
    //   2994: iload 9
    //   2996: istore 8
    //   2998: ldc 42
    //   3000: iconst_1
    //   3001: new 323	java/lang/StringBuilder
    //   3004: dup
    //   3005: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   3008: ldc_w 552
    //   3011: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3014: iload 5
    //   3016: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3019: ldc_w 554
    //   3022: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3025: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3028: aload 13
    //   3030: invokestatic 180	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3033: iconst_0
    //   3034: istore 10
    //   3036: iconst_0
    //   3037: istore 8
    //   3039: aload_1
    //   3040: invokestatic 372	android/os/SystemClock:elapsedRealtime	()J
    //   3043: aload_1
    //   3044: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   3047: lsub
    //   3048: putfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   3051: aload_0
    //   3052: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3055: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   3058: ifnull +392 -> 3450
    //   3061: aload_0
    //   3062: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3065: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   3068: ifnull +382 -> 3450
    //   3071: aload_2
    //   3072: ifnull +378 -> 3450
    //   3075: aload_0
    //   3076: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3079: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   3082: aload_2
    //   3083: invokevirtual 388	com/tencent/mobileqq/msf/core/quicksend/b:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   3086: ifeq +364 -> 3450
    //   3089: new 282	java/util/HashMap
    //   3092: dup
    //   3093: invokespecial 389	java/util/HashMap:<init>	()V
    //   3096: astore 13
    //   3098: aload 13
    //   3100: ldc_w 391
    //   3103: aload_1
    //   3104: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   3107: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   3110: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3113: pop
    //   3114: aload 13
    //   3116: ldc_w 398
    //   3119: aload_1
    //   3120: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   3123: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3126: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3129: pop
    //   3130: aload 13
    //   3132: ldc_w 405
    //   3135: aload_1
    //   3136: getfield 407	com/tencent/mobileqq/msf/core/quicksend/f:c	Ljava/lang/String;
    //   3139: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3142: pop
    //   3143: aload 13
    //   3145: ldc_w 409
    //   3148: aload_1
    //   3149: getfield 411	com/tencent/mobileqq/msf/core/quicksend/f:d	Ljava/lang/String;
    //   3152: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3155: pop
    //   3156: aload 13
    //   3158: ldc_w 413
    //   3161: ldc_w 415
    //   3164: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3167: pop
    //   3168: aload 13
    //   3170: ldc_w 417
    //   3173: aload_1
    //   3174: getfield 419	com/tencent/mobileqq/msf/core/quicksend/f:e	I
    //   3177: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3180: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3183: pop
    //   3184: aload 13
    //   3186: ldc_w 424
    //   3189: aload_1
    //   3190: getfield 231	com/tencent/mobileqq/msf/core/quicksend/f:f	I
    //   3193: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3196: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3199: pop
    //   3200: aload 13
    //   3202: ldc_w 426
    //   3205: aload_1
    //   3206: getfield 428	com/tencent/mobileqq/msf/core/quicksend/f:g	J
    //   3209: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3212: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3215: pop
    //   3216: aload 13
    //   3218: ldc_w 430
    //   3221: aload_1
    //   3222: getfield 432	com/tencent/mobileqq/msf/core/quicksend/f:i	Z
    //   3225: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   3228: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3231: pop
    //   3232: aload 13
    //   3234: ldc_w 434
    //   3237: aload_1
    //   3238: getfield 436	com/tencent/mobileqq/msf/core/quicksend/f:j	J
    //   3241: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3244: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3247: pop
    //   3248: aload 13
    //   3250: ldc_w 438
    //   3253: aload_1
    //   3254: getfield 440	com/tencent/mobileqq/msf/core/quicksend/f:k	I
    //   3257: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3260: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3263: pop
    //   3264: aload 13
    //   3266: ldc_w 442
    //   3269: aload_1
    //   3270: getfield 444	com/tencent/mobileqq/msf/core/quicksend/f:m	Ljava/lang/String;
    //   3273: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3276: pop
    //   3277: aload 13
    //   3279: ldc_w 446
    //   3282: aload_1
    //   3283: getfield 448	com/tencent/mobileqq/msf/core/quicksend/f:h	Ljava/lang/String;
    //   3286: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3289: pop
    //   3290: aload 13
    //   3292: ldc_w 450
    //   3295: new 323	java/lang/StringBuilder
    //   3298: dup
    //   3299: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   3302: ldc_w 452
    //   3305: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3308: iload 4
    //   3310: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3313: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3316: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3319: pop
    //   3320: aload 13
    //   3322: ldc_w 454
    //   3325: new 323	java/lang/StringBuilder
    //   3328: dup
    //   3329: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   3332: ldc_w 452
    //   3335: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3338: iload_3
    //   3339: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3342: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3345: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3348: pop
    //   3349: aload 13
    //   3351: ldc_w 456
    //   3354: aload_0
    //   3355: getfield 73	com/tencent/mobileqq/msf/core/h:c	Z
    //   3358: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   3361: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3364: pop
    //   3365: aload 13
    //   3367: ldc_w 460
    //   3370: aload_0
    //   3371: getfield 81	com/tencent/mobileqq/msf/core/h:d	Z
    //   3374: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   3377: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3380: pop
    //   3381: iconst_0
    //   3382: istore_3
    //   3383: aload_1
    //   3384: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   3387: ifeq +12 -> 3399
    //   3390: aload_0
    //   3391: getfield 73	com/tencent/mobileqq/msf/core/h:c	Z
    //   3394: ifeq +524 -> 3918
    //   3397: iconst_4
    //   3398: istore_3
    //   3399: aload 13
    //   3401: ldc_w 462
    //   3404: iload_3
    //   3405: invokestatic 464	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   3408: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3411: pop
    //   3412: aload 13
    //   3414: getstatic 469	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   3417: ldc_w 452
    //   3420: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3423: pop
    //   3424: aload_0
    //   3425: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3428: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   3431: ldc_w 471
    //   3434: aload_1
    //   3435: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   3438: aload_1
    //   3439: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   3442: lconst_0
    //   3443: aload 13
    //   3445: iconst_0
    //   3446: iconst_0
    //   3447: invokevirtual 476	com/tencent/mobileqq/msf/core/c/k:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   3450: iload 9
    //   3452: ifeq -2678 -> 774
    //   3455: invokestatic 256	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   3458: astore 13
    //   3460: iload 10
    //   3462: istore 8
    //   3464: goto -961 -> 2503
    //   3467: astore 13
    //   3469: iconst_0
    //   3470: istore 8
    //   3472: aload_1
    //   3473: invokestatic 372	android/os/SystemClock:elapsedRealtime	()J
    //   3476: aload_1
    //   3477: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   3480: lsub
    //   3481: putfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   3484: aload_0
    //   3485: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3488: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   3491: ifnull +392 -> 3883
    //   3494: aload_0
    //   3495: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3498: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   3501: ifnull +382 -> 3883
    //   3504: aload_2
    //   3505: ifnull +378 -> 3883
    //   3508: aload_0
    //   3509: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3512: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   3515: aload_2
    //   3516: invokevirtual 388	com/tencent/mobileqq/msf/core/quicksend/b:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   3519: ifeq +364 -> 3883
    //   3522: new 282	java/util/HashMap
    //   3525: dup
    //   3526: invokespecial 389	java/util/HashMap:<init>	()V
    //   3529: astore 14
    //   3531: aload 14
    //   3533: ldc_w 391
    //   3536: aload_1
    //   3537: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   3540: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   3543: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3546: pop
    //   3547: aload 14
    //   3549: ldc_w 398
    //   3552: aload_1
    //   3553: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   3556: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3559: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3562: pop
    //   3563: aload 14
    //   3565: ldc_w 405
    //   3568: aload_1
    //   3569: getfield 407	com/tencent/mobileqq/msf/core/quicksend/f:c	Ljava/lang/String;
    //   3572: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3575: pop
    //   3576: aload 14
    //   3578: ldc_w 409
    //   3581: aload_1
    //   3582: getfield 411	com/tencent/mobileqq/msf/core/quicksend/f:d	Ljava/lang/String;
    //   3585: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3588: pop
    //   3589: aload 14
    //   3591: ldc_w 413
    //   3594: ldc_w 415
    //   3597: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3600: pop
    //   3601: aload 14
    //   3603: ldc_w 417
    //   3606: aload_1
    //   3607: getfield 419	com/tencent/mobileqq/msf/core/quicksend/f:e	I
    //   3610: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3613: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3616: pop
    //   3617: aload 14
    //   3619: ldc_w 424
    //   3622: aload_1
    //   3623: getfield 231	com/tencent/mobileqq/msf/core/quicksend/f:f	I
    //   3626: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3629: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3632: pop
    //   3633: aload 14
    //   3635: ldc_w 426
    //   3638: aload_1
    //   3639: getfield 428	com/tencent/mobileqq/msf/core/quicksend/f:g	J
    //   3642: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3645: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3648: pop
    //   3649: aload 14
    //   3651: ldc_w 430
    //   3654: aload_1
    //   3655: getfield 432	com/tencent/mobileqq/msf/core/quicksend/f:i	Z
    //   3658: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   3661: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3664: pop
    //   3665: aload 14
    //   3667: ldc_w 434
    //   3670: aload_1
    //   3671: getfield 436	com/tencent/mobileqq/msf/core/quicksend/f:j	J
    //   3674: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3677: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3680: pop
    //   3681: aload 14
    //   3683: ldc_w 438
    //   3686: aload_1
    //   3687: getfield 440	com/tencent/mobileqq/msf/core/quicksend/f:k	I
    //   3690: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3693: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3696: pop
    //   3697: aload 14
    //   3699: ldc_w 442
    //   3702: aload_1
    //   3703: getfield 444	com/tencent/mobileqq/msf/core/quicksend/f:m	Ljava/lang/String;
    //   3706: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3709: pop
    //   3710: aload 14
    //   3712: ldc_w 446
    //   3715: aload_1
    //   3716: getfield 448	com/tencent/mobileqq/msf/core/quicksend/f:h	Ljava/lang/String;
    //   3719: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3722: pop
    //   3723: aload 14
    //   3725: ldc_w 450
    //   3728: new 323	java/lang/StringBuilder
    //   3731: dup
    //   3732: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   3735: ldc_w 452
    //   3738: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3741: iload 4
    //   3743: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3746: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3749: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3752: pop
    //   3753: aload 14
    //   3755: ldc_w 454
    //   3758: new 323	java/lang/StringBuilder
    //   3761: dup
    //   3762: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   3765: ldc_w 452
    //   3768: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3771: iload_3
    //   3772: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3775: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3778: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3781: pop
    //   3782: aload 14
    //   3784: ldc_w 456
    //   3787: aload_0
    //   3788: getfield 73	com/tencent/mobileqq/msf/core/h:c	Z
    //   3791: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   3794: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3797: pop
    //   3798: aload 14
    //   3800: ldc_w 460
    //   3803: aload_0
    //   3804: getfield 81	com/tencent/mobileqq/msf/core/h:d	Z
    //   3807: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   3810: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3813: pop
    //   3814: iconst_0
    //   3815: istore_3
    //   3816: aload_1
    //   3817: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   3820: ifeq +12 -> 3832
    //   3823: aload_0
    //   3824: getfield 73	com/tencent/mobileqq/msf/core/h:c	Z
    //   3827: ifeq +73 -> 3900
    //   3830: iconst_4
    //   3831: istore_3
    //   3832: aload 14
    //   3834: ldc_w 462
    //   3837: iload_3
    //   3838: invokestatic 464	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   3841: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3844: pop
    //   3845: aload 14
    //   3847: getstatic 469	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   3850: ldc_w 452
    //   3853: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3856: pop
    //   3857: aload_0
    //   3858: getfield 99	com/tencent/mobileqq/msf/core/h:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3861: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   3864: ldc_w 471
    //   3867: aload_1
    //   3868: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   3871: aload_1
    //   3872: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   3875: lconst_0
    //   3876: aload 14
    //   3878: iconst_0
    //   3879: iconst_0
    //   3880: invokevirtual 476	com/tencent/mobileqq/msf/core/c/k:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   3883: iload 8
    //   3885: ifeq +12 -> 3897
    //   3888: invokestatic 256	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   3891: aload_2
    //   3892: aconst_null
    //   3893: aload_1
    //   3894: invokevirtual 259	com/tencent/mobileqq/a/a/a:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Lcom/tencent/mobileqq/msf/core/quicksend/f;)V
    //   3897: aload 13
    //   3899: athrow
    //   3900: aload_0
    //   3901: getfield 81	com/tencent/mobileqq/msf/core/h:d	Z
    //   3904: ifeq +9 -> 3913
    //   3907: bipush 6
    //   3909: istore_3
    //   3910: goto -78 -> 3832
    //   3913: iconst_2
    //   3914: istore_3
    //   3915: goto -83 -> 3832
    //   3918: aload_0
    //   3919: getfield 81	com/tencent/mobileqq/msf/core/h:d	Z
    //   3922: ifeq +9 -> 3931
    //   3925: bipush 6
    //   3927: istore_3
    //   3928: goto -529 -> 3399
    //   3931: iconst_2
    //   3932: istore_3
    //   3933: goto -534 -> 3399
    //   3936: aload_0
    //   3937: getfield 81	com/tencent/mobileqq/msf/core/h:d	Z
    //   3940: ifeq +9 -> 3949
    //   3943: bipush 6
    //   3945: istore_3
    //   3946: goto -3241 -> 705
    //   3949: iconst_2
    //   3950: istore_3
    //   3951: goto -3246 -> 705
    //   3954: aload_0
    //   3955: getfield 81	com/tencent/mobileqq/msf/core/h:d	Z
    //   3958: ifeq +9 -> 3967
    //   3961: bipush 6
    //   3963: istore_3
    //   3964: goto -2591 -> 1373
    //   3967: iconst_2
    //   3968: istore_3
    //   3969: goto -2596 -> 1373
    //   3972: aload_0
    //   3973: getfield 81	com/tencent/mobileqq/msf/core/h:d	Z
    //   3976: ifeq +9 -> 3985
    //   3979: bipush 6
    //   3981: istore_3
    //   3982: goto -2118 -> 1864
    //   3985: iconst_2
    //   3986: istore_3
    //   3987: goto -2123 -> 1864
    //   3990: aload_0
    //   3991: getfield 81	com/tencent/mobileqq/msf/core/h:d	Z
    //   3994: ifeq +9 -> 4003
    //   3997: bipush 6
    //   3999: istore_3
    //   4000: goto -1562 -> 2438
    //   4003: iconst_2
    //   4004: istore_3
    //   4005: goto -1567 -> 2438
    //   4008: aload_0
    //   4009: getfield 81	com/tencent/mobileqq/msf/core/h:d	Z
    //   4012: ifeq +9 -> 4021
    //   4015: bipush 6
    //   4017: istore_3
    //   4018: goto -1127 -> 2891
    //   4021: iconst_2
    //   4022: istore_3
    //   4023: goto -1132 -> 2891
    //   4026: astore 13
    //   4028: goto -556 -> 3472
    //   4031: astore 13
    //   4033: goto -1087 -> 2946
    //   4036: iconst_m1
    //   4037: istore 7
    //   4039: iload_3
    //   4040: istore 5
    //   4042: iload 4
    //   4044: istore 6
    //   4046: iload 7
    //   4048: istore_3
    //   4049: iload 5
    //   4051: istore 4
    //   4053: iload 6
    //   4055: istore 5
    //   4057: goto -3949 -> 108
    //   4060: iconst_m1
    //   4061: istore_3
    //   4062: iconst_0
    //   4063: istore 4
    //   4065: iconst_0
    //   4066: istore 5
    //   4068: goto -3960 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4071	0	this	h
    //   0	4071	1	paramf	com.tencent.mobileqq.msf.core.quicksend.f
    //   0	4071	2	paramToServiceMsg	ToServiceMsg
    //   15	4047	3	i1	int
    //   11	4053	4	i2	int
    //   1	4066	5	i3	int
    //   96	3958	6	i4	int
    //   4037	10	7	i5	int
    //   361	3523	8	bool1	boolean
    //   345	3106	9	bool2	boolean
    //   2073	1388	10	bool3	boolean
    //   747	1160	11	l1	long
    //   42	2462	13	localObject1	Object
    //   2941	88	13	localThrowable1	Throwable
    //   3096	363	13	localObject2	Object
    //   3467	431	13	localObject3	Object
    //   4026	1	13	localObject4	Object
    //   4031	1	13	localThrowable2	Throwable
    //   925	2952	14	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   297	304	2941	java/lang/Throwable
    //   309	344	2941	java/lang/Throwable
    //   920	972	2941	java/lang/Throwable
    //   977	1012	2941	java/lang/Throwable
    //   1423	1450	2941	java/lang/Throwable
    //   1455	1463	2941	java/lang/Throwable
    //   1468	1503	2941	java/lang/Throwable
    //   1914	1943	2941	java/lang/Throwable
    //   1947	2001	2941	java/lang/Throwable
    //   2001	2018	2941	java/lang/Throwable
    //   2514	2549	2941	java/lang/Throwable
    //   297	304	3467	finally
    //   309	344	3467	finally
    //   920	972	3467	finally
    //   977	1012	3467	finally
    //   1423	1450	3467	finally
    //   1455	1463	3467	finally
    //   1468	1503	3467	finally
    //   1914	1943	3467	finally
    //   1947	2001	3467	finally
    //   2001	2018	3467	finally
    //   2514	2549	3467	finally
    //   2027	2063	4026	finally
    //   2067	2072	4026	finally
    //   2950	2985	4026	finally
    //   2989	2994	4026	finally
    //   2998	3033	4026	finally
    //   2027	2063	4031	java/lang/Throwable
    //   2067	2072	4031	java/lang/Throwable
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, com.tencent.mobileqq.msf.core.quicksend.f paramf, String paramString1, String paramString2)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        if (e()) {
          continue;
        }
        bool2 = b(paramToServiceMsg, paramf, paramString1, paramString2);
        if (bool2) {
          continue;
        }
      }
      catch (Throwable paramToServiceMsg)
      {
        boolean bool2;
        QLog.i("LightTcpSender", 1, paramToServiceMsg.getMessage(), paramToServiceMsg);
        continue;
      }
      finally {}
      return bool1;
      bool2 = e();
      if (bool2) {
        bool1 = true;
      }
    }
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, com.tencent.mobileqq.msf.core.quicksend.f paramf, String paramString1, String paramString2)
  {
    Object localObject1;
    Object localObject2;
    boolean bool;
    if (NetConnInfoCenter.isWifiConn()) {
      if (this.a.a())
      {
        localObject1 = this.y.getSsoListManager().a(c.a.a("Quic", "Wifi", "Ipv4"), true);
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(paramString2)) {
          localObject2 = a((CopyOnWriteArrayList)localObject1, paramString2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("LightTcpSender", 2, "selectAndConnect sortedList: " + localObject2);
        }
        if (localObject2 == null) {
          break label467;
        }
        paramString2 = ((CopyOnWriteArrayList)localObject2).iterator();
        bool = false;
      }
    }
    label536:
    for (;;)
    {
      if (paramString2.hasNext())
      {
        localObject1 = (d)paramString2.next();
        this.A = ((d)localObject1).g();
        this.a.a(this.A);
        this.a.a(this.b);
        long l1 = SystemClock.elapsedRealtime();
        bool = this.a.a(((d)localObject1).c(), ((d)localObject1).f(), paramString1, paramf);
        paramf.k += 1;
        paramf.j = (SystemClock.elapsedRealtime() - l1);
        paramf.i = bool;
        if (!bool)
        {
          if (!QLog.isColorLevel()) {
            break label536;
          }
          QLog.i("LightTcpSender", 2, "connect " + ((d)localObject1).toString() + " fail");
          continue;
          localObject2 = this.y.getSsoListManager().a(c.a.a("Http", "Wifi", "Ipv4"), true);
          CopyOnWriteArrayList localCopyOnWriteArrayList = this.y.getSsoListManager().a(c.a.a("Http", "Mobile", "Ipv4"), true);
          if ((this.c) && (localCopyOnWriteArrayList != null))
          {
            localObject1 = localCopyOnWriteArrayList;
            if (localCopyOnWriteArrayList.size() > 0) {
              break;
            }
          }
          localObject1 = localObject2;
          break;
          if (this.a.a())
          {
            localObject1 = this.y.getSsoListManager().a(c.a.a("Quic", "Mobile", "Ipv4"), true);
            break;
          }
          localObject1 = this.y.getSsoListManager().a(c.a.a("Http", "Mobile", "Ipv4"), true);
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("LightTcpSender", 2, "connect " + ((d)localObject1).toString() + " ok");
        }
        return true;
        label467:
        QLog.w("LightTcpSender", 1, "selectAndConnect ssolist is null");
        return false;
      }
      if (!bool)
      {
        paramf.g = (SystemClock.elapsedRealtime() - paramf.g);
        a(paramToServiceMsg, null, 2, "selectAndConnect ssoseq:" + paramToServiceMsg.getRequestSsoSeq() + ", connect all failed", paramf);
        return false;
      }
      return false;
    }
  }
  
  private String c(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg != null) && (paramToServiceMsg.getServiceCmd().equals("MessageSvc.QueryPullUp"))) {
      return "pcactive";
    }
    if ((paramToServiceMsg != null) && (paramToServiceMsg.isQuickSendEnable()) && (QuickSendStrategy.getStragegyArgs(paramToServiceMsg.getQuickSendStrategy()) != null)) {
      return "quicksend";
    }
    return "unknown";
  }
  
  private byte[] d(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return null;
    }
    String str;
    byte b1;
    byte b2;
    try
    {
      str = paramToServiceMsg.getServiceCmd();
      Object localObject = null;
      if (paramToServiceMsg.getWupBuffer() == null) {
        break label472;
      }
      b1 = f();
      b2 = (byte)NetConnInfoCenter.getActiveNetIpFamily(false);
      int i1 = 0;
      if (paramToServiceMsg.getAttributes().containsKey("send_mode")) {
        i1 = ((Integer)paramToServiceMsg.getAttributes().get("send_mode")).intValue();
      }
      try
      {
        byte[] arrayOfByte = aj.b(paramToServiceMsg, b2);
        localObject = arrayOfByte;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("LightTcpSender", 1, "", localException);
        }
      }
      if (i1 != 1) {
        break label305;
      }
      if (591 == CodecWarpper.getSharedObjectVersion()) {
        return CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), w.d(), w.f(), w.g(), "", str, null, paramToServiceMsg.getAppId(), this.y.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, paramToServiceMsg.getWupBuffer(), true);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.d("LightTcpSender", 1, "LightSender get packet fail ssoseq: " + paramToServiceMsg.getRequestSsoSeq(), localThrowable);
      return null;
    }
    if ((595 == CodecWarpper.getSharedObjectVersion()) || (600 == CodecWarpper.getSharedObjectVersion())) {
      return CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), w.d(), w.f(), w.g(), "", str, null, paramToServiceMsg.getAppId(), this.y.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, localThrowable, paramToServiceMsg.getWupBuffer(), true);
    }
    return CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), w.d(), w.f(), w.g(), "", str, null, paramToServiceMsg.getAppId(), this.y.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, b2, localThrowable, paramToServiceMsg.getWupBuffer(), true);
    label305:
    if (591 == CodecWarpper.getSharedObjectVersion()) {
      return CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), w.d(), w.f(), w.g(), "", str, null, paramToServiceMsg.getAppId(), this.y.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, paramToServiceMsg.getWupBuffer(), true);
    }
    if ((595 == CodecWarpper.getSharedObjectVersion()) || (600 == CodecWarpper.getSharedObjectVersion())) {
      return CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), w.d(), w.f(), w.g(), "", str, null, paramToServiceMsg.getAppId(), this.y.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, localThrowable, paramToServiceMsg.getWupBuffer(), true);
    }
    return CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), w.d(), w.f(), w.g(), "", str, null, paramToServiceMsg.getAppId(), this.y.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, b2, localThrowable, paramToServiceMsg.getWupBuffer(), true);
    label472:
    return new byte[0];
  }
  
  private boolean e()
  {
    return this.a.b();
  }
  
  private byte f()
  {
    byte b1 = 0;
    Object localObject = this.b;
    if (localObject != null)
    {
      try
      {
        if (com.tencent.mobileqq.msf.core.net.l.a(this.x, (Network)localObject, 0))
        {
          ConnectivityManager localConnectivityManager = (ConnectivityManager)this.x.getSystemService("connectivity");
          if (localConnectivityManager != null)
          {
            localObject = localConnectivityManager.getNetworkInfo((Network)localObject);
            if (localObject != null) {}
            for (int i1 = ((NetworkInfo)localObject).getSubtype();; i1 = ((TelephonyManager)BaseApplication.getContext().getSystemService("phone")).getNetworkType())
            {
              i2 = y.a(i1);
              i1 = i2;
              if (i2 != 20) {
                i1 = i2 + 100;
              }
              i2 = i1;
              if (i1 <= 254) {
                break label189;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("LightTcpSender", 2, "error,netWorkType is " + 254);
              break;
            }
          }
        }
        else
        {
          boolean bool = com.tencent.mobileqq.msf.core.net.l.a(this.x, (Network)localObject, 0);
          if (bool) {
            b1 = 1;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return 0;
      }
      return 0;
      int i2 = 254;
      label189:
      b1 = (byte)i2;
    }
    return b1;
  }
  
  public void a(int paramInt)
  {
    this.C = true;
    this.z.removeMessages(1);
    this.z.sendEmptyMessageDelayed(1, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("LightTcpSender", 2, "closeMobileNetwork");
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    this.e.remove(paramToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.i("LightTcpSender", 2, "removeMsg size=" + this.e.size());
    }
  }
  
  public boolean a()
  {
    return com.tencent.mobileqq.msf.core.net.l.a(this.x, this.b, 0);
  }
  
  public void b()
  {
    this.C = false;
    this.z.removeMessages(1);
    if (QLog.isColorLevel()) {
      QLog.i("LightTcpSender", 2, "cancelToCloseMobilework");
    }
  }
  
  public boolean b(ToServiceMsg paramToServiceMsg)
  {
    boolean bool = false;
    if (!this.e.contains(paramToServiceMsg))
    {
      if (!this.e.offer(paramToServiceMsg)) {
        break label88;
      }
      this.C = false;
      this.z.removeMessages(1);
      this.z.sendEmptyMessage(2);
      if (QLog.isColorLevel()) {
        QLog.i("LightTcpSender", 2, "sendMsg size=" + this.e.size());
      }
    }
    bool = true;
    label88:
    while (!QLog.isColorLevel()) {
      return bool;
    }
    QLog.i("LightTcpSender", 2, "sendMsg Queue Full size=" + this.e.size());
    return false;
  }
  
  public void c()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      if ("MessageSvc.QueryPullUp".equals(((ToServiceMsg)localIterator.next()).getServiceCmd())) {
        localIterator.remove();
      }
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      ToServiceMsg localToServiceMsg = (ToServiceMsg)localIterator.next();
      if ("MessageSvc.QueryPullUp".equals(localToServiceMsg.getServiceCmd())) {
        localToServiceMsg.getAttributes().put("RequestEcho", Boolean.valueOf(false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.h
 * JD-Core Version:    0.7.0.1
 */