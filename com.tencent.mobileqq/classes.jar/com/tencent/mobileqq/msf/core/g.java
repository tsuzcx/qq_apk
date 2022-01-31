package com.tencent.mobileqq.msf.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.net.b;
import com.tencent.mobileqq.msf.core.net.k;
import com.tencent.mobileqq.msf.core.net.k.a;
import com.tencent.mobileqq.msf.core.quicksend.QuickSendStrategy;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class g
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
  private boolean C;
  private final a D = new a();
  b a;
  Network b = null;
  boolean c = true;
  boolean d = false;
  public final LinkedBlockingQueue e = new LinkedBlockingQueue(100);
  private Context x;
  private MsfCore y;
  private Handler z;
  
  public g(MsfCore paramMsfCore, Context paramContext)
  {
    this.x = paramContext;
    this.y = paramMsfCore;
    if ((new Random().nextInt(100) % 2 == 0) && (com.tencent.mobileqq.msf.core.a.a.bu()))
    {
      this.d = bool;
      if (this.d) {
        break label159;
      }
    }
    label159:
    for (this.a = new com.tencent.mobileqq.msf.core.net.g();; this.a = new com.tencent.mobileqq.msf.core.net.f())
    {
      paramMsfCore = new HandlerThread("LightTcpSenderThread");
      paramMsfCore.start();
      this.z = new b(paramMsfCore.getLooper());
      k.a(this.D);
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
        arrayOfByte1 = j.b(arrayOfByte2);
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
      if ((locald != null) && (paramString.equals(locald.k))) {
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
      FromServiceMsg localFromServiceMsg = t.a(paramToServiceMsg);
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
    //   0: aload_2
    //   1: ifnull +4037 -> 4038
    //   4: aload_2
    //   5: invokevirtual 274	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   8: istore 4
    //   10: aload_2
    //   11: invokevirtual 278	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   14: ldc_w 280
    //   17: invokevirtual 285	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   20: ifeq +4013 -> 4033
    //   23: aload_2
    //   24: invokevirtual 278	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   27: ldc_w 280
    //   30: invokevirtual 289	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 291	java/lang/Integer
    //   36: invokevirtual 294	java/lang/Integer:intValue	()I
    //   39: istore_3
    //   40: aload_2
    //   41: invokevirtual 278	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   44: ldc_w 296
    //   47: invokevirtual 285	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   50: ifeq +3959 -> 4009
    //   53: aload_2
    //   54: invokevirtual 278	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   57: ldc_w 296
    //   60: invokevirtual 289	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 291	java/lang/Integer
    //   66: invokevirtual 294	java/lang/Integer:intValue	()I
    //   69: istore 6
    //   71: iload 4
    //   73: istore 5
    //   75: iload_3
    //   76: istore 4
    //   78: iload 6
    //   80: istore_3
    //   81: aload_1
    //   82: iconst_0
    //   83: putfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   86: aload_1
    //   87: aload_0
    //   88: getfield 75	com/tencent/mobileqq/msf/core/g:c	Z
    //   91: putfield 300	com/tencent/mobileqq/msf/core/quicksend/f:l	Z
    //   94: aload_2
    //   95: invokevirtual 304	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   98: astore 13
    //   100: aload_0
    //   101: getfield 75	com/tencent/mobileqq/msf/core/g:c	Z
    //   104: ifeq +40 -> 144
    //   107: aload_2
    //   108: ldc_w 306
    //   111: iconst_0
    //   112: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   115: invokevirtual 314	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   118: checkcast 291	java/lang/Integer
    //   121: invokevirtual 294	java/lang/Integer:intValue	()I
    //   124: istore 6
    //   126: aload_2
    //   127: invokevirtual 278	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   130: ldc_w 306
    //   133: iload 6
    //   135: iconst_1
    //   136: iadd
    //   137: invokestatic 310	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   140: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   143: pop
    //   144: invokestatic 321	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +615 -> 762
    //   150: new 323	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   157: ldc_w 326
    //   160: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload 13
    //   165: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc_w 332
    //   171: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_2
    //   175: invokevirtual 274	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   178: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   181: ldc_w 337
    //   184: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: iload 4
    //   189: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   192: ldc_w 339
    //   195: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: astore 13
    //   200: aload_0
    //   201: getfield 75	com/tencent/mobileqq/msf/core/g:c	Z
    //   204: ifeq +546 -> 750
    //   207: iconst_1
    //   208: istore 6
    //   210: aload 13
    //   212: iload 6
    //   214: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   217: ldc_w 341
    //   220: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: astore 13
    //   225: aload_0
    //   226: getfield 81	com/tencent/mobileqq/msf/core/g:d	Z
    //   229: ifeq +527 -> 756
    //   232: iconst_1
    //   233: istore 6
    //   235: ldc 48
    //   237: iconst_1
    //   238: aload 13
    //   240: iload 6
    //   242: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   245: ldc_w 343
    //   248: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokestatic 348	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetworkType	()I
    //   254: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   257: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 354	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: invokestatic 254	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   266: aload_2
    //   267: invokevirtual 357	com/tencent/mobileqq/a/a/a:c	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   270: aload_0
    //   271: aload_2
    //   272: invokespecial 360	com/tencent/mobileqq/msf/core/g:d	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)[B
    //   275: astore 13
    //   277: aload 13
    //   279: ifnonnull +614 -> 893
    //   282: aload_0
    //   283: aload_2
    //   284: aconst_null
    //   285: iconst_1
    //   286: new 323	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   293: ldc_w 362
    //   296: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: iload 5
    //   301: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   304: ldc_w 364
    //   307: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: aload_1
    //   314: invokespecial 366	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;ILjava/lang/String;Lcom/tencent/mobileqq/msf/core/quicksend/f;)V
    //   317: iconst_0
    //   318: istore 9
    //   320: aload_1
    //   321: invokestatic 372	android/os/SystemClock:elapsedRealtime	()J
    //   324: aload_1
    //   325: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   328: lsub
    //   329: putfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   332: iload 9
    //   334: istore 8
    //   336: aload_0
    //   337: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   340: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
    //   343: ifnull +404 -> 747
    //   346: iload 9
    //   348: istore 8
    //   350: aload_0
    //   351: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   354: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   357: ifnull +390 -> 747
    //   360: iload 9
    //   362: istore 8
    //   364: aload_2
    //   365: ifnull +382 -> 747
    //   368: iload 9
    //   370: istore 8
    //   372: aload_0
    //   373: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   376: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   379: aload_2
    //   380: invokevirtual 388	com/tencent/mobileqq/msf/core/quicksend/b:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   383: ifeq +364 -> 747
    //   386: new 282	java/util/HashMap
    //   389: dup
    //   390: invokespecial 389	java/util/HashMap:<init>	()V
    //   393: astore_2
    //   394: aload_2
    //   395: ldc_w 391
    //   398: aload_1
    //   399: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   402: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   405: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   408: pop
    //   409: aload_2
    //   410: ldc_w 398
    //   413: aload_1
    //   414: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   417: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   420: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   423: pop
    //   424: aload_2
    //   425: ldc_w 405
    //   428: aload_1
    //   429: getfield 407	com/tencent/mobileqq/msf/core/quicksend/f:c	Ljava/lang/String;
    //   432: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   435: pop
    //   436: aload_2
    //   437: ldc_w 409
    //   440: aload_1
    //   441: getfield 411	com/tencent/mobileqq/msf/core/quicksend/f:d	Ljava/lang/String;
    //   444: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   447: pop
    //   448: aload_2
    //   449: ldc_w 413
    //   452: ldc_w 415
    //   455: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   458: pop
    //   459: aload_2
    //   460: ldc_w 417
    //   463: aload_1
    //   464: getfield 419	com/tencent/mobileqq/msf/core/quicksend/f:e	I
    //   467: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   470: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   473: pop
    //   474: aload_2
    //   475: ldc_w 424
    //   478: aload_1
    //   479: getfield 229	com/tencent/mobileqq/msf/core/quicksend/f:f	I
    //   482: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   485: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   488: pop
    //   489: aload_2
    //   490: ldc_w 426
    //   493: aload_1
    //   494: getfield 428	com/tencent/mobileqq/msf/core/quicksend/f:g	J
    //   497: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   500: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   503: pop
    //   504: aload_2
    //   505: ldc_w 430
    //   508: aload_1
    //   509: getfield 432	com/tencent/mobileqq/msf/core/quicksend/f:i	Z
    //   512: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   515: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   518: pop
    //   519: aload_2
    //   520: ldc_w 434
    //   523: aload_1
    //   524: getfield 436	com/tencent/mobileqq/msf/core/quicksend/f:j	J
    //   527: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   530: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   533: pop
    //   534: aload_2
    //   535: ldc_w 438
    //   538: aload_1
    //   539: getfield 440	com/tencent/mobileqq/msf/core/quicksend/f:k	I
    //   542: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   545: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   548: pop
    //   549: aload_2
    //   550: ldc_w 442
    //   553: aload_1
    //   554: getfield 444	com/tencent/mobileqq/msf/core/quicksend/f:m	Ljava/lang/String;
    //   557: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   560: pop
    //   561: aload_2
    //   562: ldc_w 446
    //   565: aload_1
    //   566: getfield 448	com/tencent/mobileqq/msf/core/quicksend/f:h	Ljava/lang/String;
    //   569: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   572: pop
    //   573: aload_2
    //   574: ldc_w 450
    //   577: new 323	java/lang/StringBuilder
    //   580: dup
    //   581: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   584: ldc_w 452
    //   587: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: iload 4
    //   592: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   595: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   601: pop
    //   602: aload_2
    //   603: ldc_w 454
    //   606: new 323	java/lang/StringBuilder
    //   609: dup
    //   610: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   613: ldc_w 452
    //   616: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: iload_3
    //   620: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   623: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   626: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   629: pop
    //   630: aload_2
    //   631: ldc_w 456
    //   634: aload_0
    //   635: getfield 75	com/tencent/mobileqq/msf/core/g:c	Z
    //   638: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   641: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   644: pop
    //   645: aload_2
    //   646: ldc_w 460
    //   649: aload_0
    //   650: getfield 81	com/tencent/mobileqq/msf/core/g:d	Z
    //   653: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   656: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   659: pop
    //   660: iconst_0
    //   661: istore_3
    //   662: aload_1
    //   663: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   666: ifeq +12 -> 678
    //   669: aload_0
    //   670: getfield 75	com/tencent/mobileqq/msf/core/g:c	Z
    //   673: ifeq +3236 -> 3909
    //   676: iconst_4
    //   677: istore_3
    //   678: aload_2
    //   679: ldc_w 462
    //   682: iload_3
    //   683: invokestatic 464	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   686: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   689: pop
    //   690: aload_2
    //   691: getstatic 469	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   694: ldc_w 452
    //   697: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   700: pop
    //   701: aload_0
    //   702: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   705: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
    //   708: astore 13
    //   710: aload_1
    //   711: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   714: istore 8
    //   716: aload_1
    //   717: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   720: lstore 11
    //   722: aload 13
    //   724: astore_1
    //   725: iconst_0
    //   726: istore 9
    //   728: aload_1
    //   729: ldc_w 471
    //   732: iload 8
    //   734: lload 11
    //   736: lconst_0
    //   737: aload_2
    //   738: iconst_0
    //   739: iconst_0
    //   740: invokevirtual 476	com/tencent/mobileqq/msf/core/c/j:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   743: iload 9
    //   745: istore 8
    //   747: iload 8
    //   749: ireturn
    //   750: iconst_0
    //   751: istore 6
    //   753: goto -543 -> 210
    //   756: iconst_0
    //   757: istore 6
    //   759: goto -524 -> 235
    //   762: new 323	java/lang/StringBuilder
    //   765: dup
    //   766: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   769: ldc_w 326
    //   772: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: aload 13
    //   777: invokestatic 481	com/tencent/mobileqq/msf/core/b/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   780: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: ldc_w 332
    //   786: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: aload_2
    //   790: invokevirtual 274	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   793: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   796: ldc_w 337
    //   799: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: iload 4
    //   804: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   807: ldc_w 339
    //   810: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: astore 13
    //   815: aload_0
    //   816: getfield 75	com/tencent/mobileqq/msf/core/g:c	Z
    //   819: ifeq +62 -> 881
    //   822: iconst_1
    //   823: istore 6
    //   825: aload 13
    //   827: iload 6
    //   829: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   832: ldc_w 341
    //   835: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: astore 13
    //   840: aload_0
    //   841: getfield 81	com/tencent/mobileqq/msf/core/g:d	Z
    //   844: ifeq +43 -> 887
    //   847: iconst_1
    //   848: istore 6
    //   850: ldc 48
    //   852: iconst_1
    //   853: aload 13
    //   855: iload 6
    //   857: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   860: ldc_w 343
    //   863: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: invokestatic 348	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetworkType	()I
    //   869: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   872: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   875: invokestatic 354	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   878: goto -615 -> 263
    //   881: iconst_0
    //   882: istore 6
    //   884: goto -59 -> 825
    //   887: iconst_0
    //   888: istore 6
    //   890: goto -40 -> 850
    //   893: aload_0
    //   894: aload_2
    //   895: invokespecial 182	com/tencent/mobileqq/msf/core/g:c	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Ljava/lang/String;
    //   898: astore 14
    //   900: aload_1
    //   901: aload_2
    //   902: invokevirtual 484	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   905: putfield 407	com/tencent/mobileqq/msf/core/quicksend/f:c	Ljava/lang/String;
    //   908: aload_1
    //   909: aload_2
    //   910: invokevirtual 304	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   913: putfield 411	com/tencent/mobileqq/msf/core/quicksend/f:d	Ljava/lang/String;
    //   916: aload_1
    //   917: aload 13
    //   919: arraylength
    //   920: putfield 419	com/tencent/mobileqq/msf/core/quicksend/f:e	I
    //   923: invokestatic 372	android/os/SystemClock:elapsedRealtime	()J
    //   926: lstore 11
    //   928: aload_0
    //   929: getfield 115	com/tencent/mobileqq/msf/core/g:a	Lcom/tencent/mobileqq/msf/core/net/b;
    //   932: aload_2
    //   933: aload 13
    //   935: aload 14
    //   937: aload_1
    //   938: invokeinterface 489 5 0
    //   943: astore 13
    //   945: aload 13
    //   947: ifnonnull +449 -> 1396
    //   950: aload_0
    //   951: aload_2
    //   952: aconst_null
    //   953: iconst_3
    //   954: new 323	java/lang/StringBuilder
    //   957: dup
    //   958: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   961: ldc_w 362
    //   964: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: iload 5
    //   969: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   972: ldc_w 491
    //   975: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   981: aload_1
    //   982: invokespecial 366	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;ILjava/lang/String;Lcom/tencent/mobileqq/msf/core/quicksend/f;)V
    //   985: iconst_0
    //   986: istore 9
    //   988: aload_1
    //   989: invokestatic 372	android/os/SystemClock:elapsedRealtime	()J
    //   992: aload_1
    //   993: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   996: lsub
    //   997: putfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   1000: iload 9
    //   1002: istore 8
    //   1004: aload_0
    //   1005: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1008: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
    //   1011: ifnull -264 -> 747
    //   1014: iload 9
    //   1016: istore 8
    //   1018: aload_0
    //   1019: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1022: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   1025: ifnull -278 -> 747
    //   1028: iload 9
    //   1030: istore 8
    //   1032: aload_2
    //   1033: ifnull -286 -> 747
    //   1036: iload 9
    //   1038: istore 8
    //   1040: aload_0
    //   1041: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1044: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   1047: aload_2
    //   1048: invokevirtual 388	com/tencent/mobileqq/msf/core/quicksend/b:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   1051: ifeq -304 -> 747
    //   1054: new 282	java/util/HashMap
    //   1057: dup
    //   1058: invokespecial 389	java/util/HashMap:<init>	()V
    //   1061: astore_2
    //   1062: aload_2
    //   1063: ldc_w 391
    //   1066: aload_1
    //   1067: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   1070: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   1073: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1076: pop
    //   1077: aload_2
    //   1078: ldc_w 398
    //   1081: aload_1
    //   1082: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   1085: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1088: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1091: pop
    //   1092: aload_2
    //   1093: ldc_w 405
    //   1096: aload_1
    //   1097: getfield 407	com/tencent/mobileqq/msf/core/quicksend/f:c	Ljava/lang/String;
    //   1100: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1103: pop
    //   1104: aload_2
    //   1105: ldc_w 409
    //   1108: aload_1
    //   1109: getfield 411	com/tencent/mobileqq/msf/core/quicksend/f:d	Ljava/lang/String;
    //   1112: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1115: pop
    //   1116: aload_2
    //   1117: ldc_w 413
    //   1120: ldc_w 415
    //   1123: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1126: pop
    //   1127: aload_2
    //   1128: ldc_w 417
    //   1131: aload_1
    //   1132: getfield 419	com/tencent/mobileqq/msf/core/quicksend/f:e	I
    //   1135: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1138: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1141: pop
    //   1142: aload_2
    //   1143: ldc_w 424
    //   1146: aload_1
    //   1147: getfield 229	com/tencent/mobileqq/msf/core/quicksend/f:f	I
    //   1150: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1153: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1156: pop
    //   1157: aload_2
    //   1158: ldc_w 426
    //   1161: aload_1
    //   1162: getfield 428	com/tencent/mobileqq/msf/core/quicksend/f:g	J
    //   1165: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1168: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1171: pop
    //   1172: aload_2
    //   1173: ldc_w 430
    //   1176: aload_1
    //   1177: getfield 432	com/tencent/mobileqq/msf/core/quicksend/f:i	Z
    //   1180: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   1183: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1186: pop
    //   1187: aload_2
    //   1188: ldc_w 434
    //   1191: aload_1
    //   1192: getfield 436	com/tencent/mobileqq/msf/core/quicksend/f:j	J
    //   1195: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1198: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1201: pop
    //   1202: aload_2
    //   1203: ldc_w 438
    //   1206: aload_1
    //   1207: getfield 440	com/tencent/mobileqq/msf/core/quicksend/f:k	I
    //   1210: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1213: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1216: pop
    //   1217: aload_2
    //   1218: ldc_w 442
    //   1221: aload_1
    //   1222: getfield 444	com/tencent/mobileqq/msf/core/quicksend/f:m	Ljava/lang/String;
    //   1225: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1228: pop
    //   1229: aload_2
    //   1230: ldc_w 446
    //   1233: aload_1
    //   1234: getfield 448	com/tencent/mobileqq/msf/core/quicksend/f:h	Ljava/lang/String;
    //   1237: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1240: pop
    //   1241: aload_2
    //   1242: ldc_w 450
    //   1245: new 323	java/lang/StringBuilder
    //   1248: dup
    //   1249: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   1252: ldc_w 452
    //   1255: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1258: iload 4
    //   1260: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1263: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1266: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1269: pop
    //   1270: aload_2
    //   1271: ldc_w 454
    //   1274: new 323	java/lang/StringBuilder
    //   1277: dup
    //   1278: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   1281: ldc_w 452
    //   1284: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1287: iload_3
    //   1288: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1291: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1294: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1297: pop
    //   1298: aload_2
    //   1299: ldc_w 456
    //   1302: aload_0
    //   1303: getfield 75	com/tencent/mobileqq/msf/core/g:c	Z
    //   1306: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1309: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1312: pop
    //   1313: aload_2
    //   1314: ldc_w 460
    //   1317: aload_0
    //   1318: getfield 81	com/tencent/mobileqq/msf/core/g:d	Z
    //   1321: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1324: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1327: pop
    //   1328: iconst_0
    //   1329: istore_3
    //   1330: aload_1
    //   1331: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   1334: ifeq +12 -> 1346
    //   1337: aload_0
    //   1338: getfield 75	com/tencent/mobileqq/msf/core/g:c	Z
    //   1341: ifeq +2586 -> 3927
    //   1344: iconst_4
    //   1345: istore_3
    //   1346: aload_2
    //   1347: ldc_w 462
    //   1350: iload_3
    //   1351: invokestatic 464	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1354: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1357: pop
    //   1358: aload_2
    //   1359: getstatic 469	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   1362: ldc_w 452
    //   1365: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1368: pop
    //   1369: aload_0
    //   1370: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1373: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
    //   1376: astore 13
    //   1378: aload_1
    //   1379: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   1382: istore 8
    //   1384: aload_1
    //   1385: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   1388: lstore 11
    //   1390: aload 13
    //   1392: astore_1
    //   1393: goto -668 -> 725
    //   1396: aload_1
    //   1397: invokestatic 372	android/os/SystemClock:elapsedRealtime	()J
    //   1400: lload 11
    //   1402: lsub
    //   1403: putfield 428	com/tencent/mobileqq/msf/core/quicksend/f:g	J
    //   1406: aload_0
    //   1407: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1410: getfield 495	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
    //   1413: getfield 501	com/tencent/mobileqq/msf/core/af:E	Lcom/tencent/mobileqq/msf/core/af$a;
    //   1416: aload 13
    //   1418: invokevirtual 507	com/tencent/mobileqq/msf/core/af$a:nativeParseData	([B)Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   1421: astore 13
    //   1423: aload 13
    //   1425: ifnull +1062 -> 2487
    //   1428: aload_0
    //   1429: aload 13
    //   1431: invokespecial 509	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/qphone/base/remote/FromServiceMsg;)Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   1434: astore 13
    //   1436: aload 13
    //   1438: ifnonnull +449 -> 1887
    //   1441: aload_0
    //   1442: aload_2
    //   1443: aconst_null
    //   1444: iconst_5
    //   1445: new 323	java/lang/StringBuilder
    //   1448: dup
    //   1449: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   1452: ldc_w 362
    //   1455: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1458: iload 5
    //   1460: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1463: ldc_w 491
    //   1466: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1469: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1472: aload_1
    //   1473: invokespecial 366	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;ILjava/lang/String;Lcom/tencent/mobileqq/msf/core/quicksend/f;)V
    //   1476: iconst_0
    //   1477: istore 9
    //   1479: aload_1
    //   1480: invokestatic 372	android/os/SystemClock:elapsedRealtime	()J
    //   1483: aload_1
    //   1484: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   1487: lsub
    //   1488: putfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   1491: iload 9
    //   1493: istore 8
    //   1495: aload_0
    //   1496: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1499: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
    //   1502: ifnull -755 -> 747
    //   1505: iload 9
    //   1507: istore 8
    //   1509: aload_0
    //   1510: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1513: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   1516: ifnull -769 -> 747
    //   1519: iload 9
    //   1521: istore 8
    //   1523: aload_2
    //   1524: ifnull -777 -> 747
    //   1527: iload 9
    //   1529: istore 8
    //   1531: aload_0
    //   1532: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1535: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   1538: aload_2
    //   1539: invokevirtual 388	com/tencent/mobileqq/msf/core/quicksend/b:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   1542: ifeq -795 -> 747
    //   1545: new 282	java/util/HashMap
    //   1548: dup
    //   1549: invokespecial 389	java/util/HashMap:<init>	()V
    //   1552: astore_2
    //   1553: aload_2
    //   1554: ldc_w 391
    //   1557: aload_1
    //   1558: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   1561: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   1564: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1567: pop
    //   1568: aload_2
    //   1569: ldc_w 398
    //   1572: aload_1
    //   1573: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   1576: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1579: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1582: pop
    //   1583: aload_2
    //   1584: ldc_w 405
    //   1587: aload_1
    //   1588: getfield 407	com/tencent/mobileqq/msf/core/quicksend/f:c	Ljava/lang/String;
    //   1591: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1594: pop
    //   1595: aload_2
    //   1596: ldc_w 409
    //   1599: aload_1
    //   1600: getfield 411	com/tencent/mobileqq/msf/core/quicksend/f:d	Ljava/lang/String;
    //   1603: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1606: pop
    //   1607: aload_2
    //   1608: ldc_w 413
    //   1611: ldc_w 415
    //   1614: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1617: pop
    //   1618: aload_2
    //   1619: ldc_w 417
    //   1622: aload_1
    //   1623: getfield 419	com/tencent/mobileqq/msf/core/quicksend/f:e	I
    //   1626: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1629: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1632: pop
    //   1633: aload_2
    //   1634: ldc_w 424
    //   1637: aload_1
    //   1638: getfield 229	com/tencent/mobileqq/msf/core/quicksend/f:f	I
    //   1641: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1644: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1647: pop
    //   1648: aload_2
    //   1649: ldc_w 426
    //   1652: aload_1
    //   1653: getfield 428	com/tencent/mobileqq/msf/core/quicksend/f:g	J
    //   1656: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1659: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1662: pop
    //   1663: aload_2
    //   1664: ldc_w 430
    //   1667: aload_1
    //   1668: getfield 432	com/tencent/mobileqq/msf/core/quicksend/f:i	Z
    //   1671: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   1674: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1677: pop
    //   1678: aload_2
    //   1679: ldc_w 434
    //   1682: aload_1
    //   1683: getfield 436	com/tencent/mobileqq/msf/core/quicksend/f:j	J
    //   1686: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1689: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1692: pop
    //   1693: aload_2
    //   1694: ldc_w 438
    //   1697: aload_1
    //   1698: getfield 440	com/tencent/mobileqq/msf/core/quicksend/f:k	I
    //   1701: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1704: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1707: pop
    //   1708: aload_2
    //   1709: ldc_w 442
    //   1712: aload_1
    //   1713: getfield 444	com/tencent/mobileqq/msf/core/quicksend/f:m	Ljava/lang/String;
    //   1716: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1719: pop
    //   1720: aload_2
    //   1721: ldc_w 446
    //   1724: aload_1
    //   1725: getfield 448	com/tencent/mobileqq/msf/core/quicksend/f:h	Ljava/lang/String;
    //   1728: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1731: pop
    //   1732: aload_2
    //   1733: ldc_w 450
    //   1736: new 323	java/lang/StringBuilder
    //   1739: dup
    //   1740: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   1743: ldc_w 452
    //   1746: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1749: iload 4
    //   1751: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1754: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1757: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1760: pop
    //   1761: aload_2
    //   1762: ldc_w 454
    //   1765: new 323	java/lang/StringBuilder
    //   1768: dup
    //   1769: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   1772: ldc_w 452
    //   1775: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1778: iload_3
    //   1779: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1782: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1785: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1788: pop
    //   1789: aload_2
    //   1790: ldc_w 456
    //   1793: aload_0
    //   1794: getfield 75	com/tencent/mobileqq/msf/core/g:c	Z
    //   1797: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1800: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1803: pop
    //   1804: aload_2
    //   1805: ldc_w 460
    //   1808: aload_0
    //   1809: getfield 81	com/tencent/mobileqq/msf/core/g:d	Z
    //   1812: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1815: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1818: pop
    //   1819: iconst_0
    //   1820: istore_3
    //   1821: aload_1
    //   1822: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   1825: ifeq +12 -> 1837
    //   1828: aload_0
    //   1829: getfield 75	com/tencent/mobileqq/msf/core/g:c	Z
    //   1832: ifeq +2113 -> 3945
    //   1835: iconst_4
    //   1836: istore_3
    //   1837: aload_2
    //   1838: ldc_w 462
    //   1841: iload_3
    //   1842: invokestatic 464	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1845: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1848: pop
    //   1849: aload_2
    //   1850: getstatic 469	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   1853: ldc_w 452
    //   1856: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1859: pop
    //   1860: aload_0
    //   1861: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1864: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
    //   1867: astore 13
    //   1869: aload_1
    //   1870: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   1873: istore 8
    //   1875: aload_1
    //   1876: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   1879: lstore 11
    //   1881: aload 13
    //   1883: astore_1
    //   1884: goto -1159 -> 725
    //   1887: aload 13
    //   1889: aload 13
    //   1891: invokevirtual 512	com/tencent/qphone/base/remote/FromServiceMsg:getAppSeq	()I
    //   1894: invokevirtual 515	com/tencent/qphone/base/remote/FromServiceMsg:setRequestSsoSeq	(I)V
    //   1897: aload 13
    //   1899: invokevirtual 516	com/tencent/qphone/base/remote/FromServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   1902: ldc_w 518
    //   1905: aload_0
    //   1906: getfield 75	com/tencent/mobileqq/msf/core/g:c	Z
    //   1909: invokestatic 521	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1912: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1915: pop
    //   1916: aload_2
    //   1917: ifnull +57 -> 1974
    //   1920: aload 13
    //   1922: aload_2
    //   1923: invokevirtual 522	com/tencent/qphone/base/remote/ToServiceMsg:getAppSeq	()I
    //   1926: invokevirtual 525	com/tencent/qphone/base/remote/FromServiceMsg:setAppSeq	(I)V
    //   1929: aload 13
    //   1931: aload_2
    //   1932: invokevirtual 529	com/tencent/qphone/base/remote/ToServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   1935: invokevirtual 533	com/tencent/qphone/base/remote/FromServiceMsg:setMsfCommand	(Lcom/tencent/mobileqq/msf/sdk/MsfCommand;)V
    //   1938: aload 13
    //   1940: aload_2
    //   1941: invokevirtual 536	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
    //   1944: invokevirtual 539	com/tencent/qphone/base/remote/FromServiceMsg:setAppId	(I)V
    //   1947: aload 13
    //   1949: aload_2
    //   1950: invokevirtual 274	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   1953: invokevirtual 515	com/tencent/qphone/base/remote/FromServiceMsg:setRequestSsoSeq	(I)V
    //   1956: aload_2
    //   1957: invokevirtual 278	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   1960: ldc_w 518
    //   1963: aload_0
    //   1964: getfield 75	com/tencent/mobileqq/msf/core/g:c	Z
    //   1967: invokestatic 521	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1970: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1973: pop
    //   1974: aload_0
    //   1975: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1978: invokevirtual 244	com/tencent/mobileqq/msf/core/MsfCore:getSsoRespHandler	()Lcom/tencent/mobileqq/msf/core/ag;
    //   1981: aload_2
    //   1982: aload 13
    //   1984: iload 4
    //   1986: invokevirtual 542	com/tencent/mobileqq/msf/core/ag:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;I)Z
    //   1989: istore 9
    //   1991: iload 9
    //   1993: ifne +43 -> 2036
    //   1996: iload 9
    //   1998: istore 8
    //   2000: aload_0
    //   2001: aload_2
    //   2002: aconst_null
    //   2003: bipush 6
    //   2005: new 323	java/lang/StringBuilder
    //   2008: dup
    //   2009: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   2012: ldc_w 362
    //   2015: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2018: iload 5
    //   2020: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2023: ldc_w 544
    //   2026: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2029: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2032: aload_1
    //   2033: invokespecial 366	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;ILjava/lang/String;Lcom/tencent/mobileqq/msf/core/quicksend/f;)V
    //   2036: iload 9
    //   2038: istore 8
    //   2040: aload_1
    //   2041: iconst_1
    //   2042: putfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   2045: iconst_1
    //   2046: istore 10
    //   2048: iconst_1
    //   2049: istore 8
    //   2051: aload_1
    //   2052: invokestatic 372	android/os/SystemClock:elapsedRealtime	()J
    //   2055: aload_1
    //   2056: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   2059: lsub
    //   2060: putfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   2063: aload_0
    //   2064: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2067: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
    //   2070: ifnull +392 -> 2462
    //   2073: aload_0
    //   2074: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2077: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   2080: ifnull +382 -> 2462
    //   2083: aload_2
    //   2084: ifnull +378 -> 2462
    //   2087: aload_0
    //   2088: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2091: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   2094: aload_2
    //   2095: invokevirtual 388	com/tencent/mobileqq/msf/core/quicksend/b:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   2098: ifeq +364 -> 2462
    //   2101: new 282	java/util/HashMap
    //   2104: dup
    //   2105: invokespecial 389	java/util/HashMap:<init>	()V
    //   2108: astore 13
    //   2110: aload 13
    //   2112: ldc_w 391
    //   2115: aload_1
    //   2116: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   2119: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   2122: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2125: pop
    //   2126: aload 13
    //   2128: ldc_w 398
    //   2131: aload_1
    //   2132: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   2135: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2138: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2141: pop
    //   2142: aload 13
    //   2144: ldc_w 405
    //   2147: aload_1
    //   2148: getfield 407	com/tencent/mobileqq/msf/core/quicksend/f:c	Ljava/lang/String;
    //   2151: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2154: pop
    //   2155: aload 13
    //   2157: ldc_w 409
    //   2160: aload_1
    //   2161: getfield 411	com/tencent/mobileqq/msf/core/quicksend/f:d	Ljava/lang/String;
    //   2164: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2167: pop
    //   2168: aload 13
    //   2170: ldc_w 413
    //   2173: ldc_w 415
    //   2176: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2179: pop
    //   2180: aload 13
    //   2182: ldc_w 417
    //   2185: aload_1
    //   2186: getfield 419	com/tencent/mobileqq/msf/core/quicksend/f:e	I
    //   2189: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   2192: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2195: pop
    //   2196: aload 13
    //   2198: ldc_w 424
    //   2201: aload_1
    //   2202: getfield 229	com/tencent/mobileqq/msf/core/quicksend/f:f	I
    //   2205: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   2208: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2211: pop
    //   2212: aload 13
    //   2214: ldc_w 426
    //   2217: aload_1
    //   2218: getfield 428	com/tencent/mobileqq/msf/core/quicksend/f:g	J
    //   2221: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2224: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2227: pop
    //   2228: aload 13
    //   2230: ldc_w 430
    //   2233: aload_1
    //   2234: getfield 432	com/tencent/mobileqq/msf/core/quicksend/f:i	Z
    //   2237: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   2240: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2243: pop
    //   2244: aload 13
    //   2246: ldc_w 434
    //   2249: aload_1
    //   2250: getfield 436	com/tencent/mobileqq/msf/core/quicksend/f:j	J
    //   2253: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2256: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2259: pop
    //   2260: aload 13
    //   2262: ldc_w 438
    //   2265: aload_1
    //   2266: getfield 440	com/tencent/mobileqq/msf/core/quicksend/f:k	I
    //   2269: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   2272: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2275: pop
    //   2276: aload 13
    //   2278: ldc_w 442
    //   2281: aload_1
    //   2282: getfield 444	com/tencent/mobileqq/msf/core/quicksend/f:m	Ljava/lang/String;
    //   2285: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2288: pop
    //   2289: aload 13
    //   2291: ldc_w 446
    //   2294: aload_1
    //   2295: getfield 448	com/tencent/mobileqq/msf/core/quicksend/f:h	Ljava/lang/String;
    //   2298: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2301: pop
    //   2302: aload 13
    //   2304: ldc_w 450
    //   2307: new 323	java/lang/StringBuilder
    //   2310: dup
    //   2311: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   2314: ldc_w 452
    //   2317: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2320: iload 4
    //   2322: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2325: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2328: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2331: pop
    //   2332: aload 13
    //   2334: ldc_w 454
    //   2337: new 323	java/lang/StringBuilder
    //   2340: dup
    //   2341: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   2344: ldc_w 452
    //   2347: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2350: iload_3
    //   2351: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2354: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2357: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2360: pop
    //   2361: aload 13
    //   2363: ldc_w 456
    //   2366: aload_0
    //   2367: getfield 75	com/tencent/mobileqq/msf/core/g:c	Z
    //   2370: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   2373: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2376: pop
    //   2377: aload 13
    //   2379: ldc_w 460
    //   2382: aload_0
    //   2383: getfield 81	com/tencent/mobileqq/msf/core/g:d	Z
    //   2386: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   2389: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2392: pop
    //   2393: iconst_0
    //   2394: istore_3
    //   2395: aload_1
    //   2396: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   2399: ifeq +12 -> 2411
    //   2402: aload_0
    //   2403: getfield 75	com/tencent/mobileqq/msf/core/g:c	Z
    //   2406: ifeq +1557 -> 3963
    //   2409: iconst_4
    //   2410: istore_3
    //   2411: aload 13
    //   2413: ldc_w 462
    //   2416: iload_3
    //   2417: invokestatic 464	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2420: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2423: pop
    //   2424: aload 13
    //   2426: getstatic 469	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   2429: ldc_w 452
    //   2432: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2435: pop
    //   2436: aload_0
    //   2437: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2440: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
    //   2443: ldc_w 471
    //   2446: aload_1
    //   2447: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   2450: aload_1
    //   2451: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   2454: lconst_0
    //   2455: aload 13
    //   2457: iconst_0
    //   2458: iconst_0
    //   2459: invokevirtual 476	com/tencent/mobileqq/msf/core/c/j:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   2462: iload 9
    //   2464: ifeq -1717 -> 747
    //   2467: invokestatic 254	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   2470: astore 13
    //   2472: iload 10
    //   2474: istore 8
    //   2476: aload 13
    //   2478: aload_2
    //   2479: aconst_null
    //   2480: aload_1
    //   2481: invokevirtual 257	com/tencent/mobileqq/a/a/a:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Lcom/tencent/mobileqq/msf/core/quicksend/f;)V
    //   2484: iload 8
    //   2486: ireturn
    //   2487: aload_0
    //   2488: aload_2
    //   2489: aconst_null
    //   2490: iconst_4
    //   2491: new 323	java/lang/StringBuilder
    //   2494: dup
    //   2495: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   2498: ldc_w 362
    //   2501: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2504: iload 5
    //   2506: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2509: ldc_w 546
    //   2512: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2515: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2518: aload_1
    //   2519: invokespecial 366	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;ILjava/lang/String;Lcom/tencent/mobileqq/msf/core/quicksend/f;)V
    //   2522: aload_1
    //   2523: invokestatic 372	android/os/SystemClock:elapsedRealtime	()J
    //   2526: aload_1
    //   2527: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   2530: lsub
    //   2531: putfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   2534: aload_0
    //   2535: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2538: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
    //   2541: ifnull +371 -> 2912
    //   2544: aload_0
    //   2545: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2548: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   2551: ifnull +361 -> 2912
    //   2554: aload_2
    //   2555: ifnull +357 -> 2912
    //   2558: aload_0
    //   2559: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2562: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   2565: aload_2
    //   2566: invokevirtual 388	com/tencent/mobileqq/msf/core/quicksend/b:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   2569: ifeq +343 -> 2912
    //   2572: new 282	java/util/HashMap
    //   2575: dup
    //   2576: invokespecial 389	java/util/HashMap:<init>	()V
    //   2579: astore_2
    //   2580: aload_2
    //   2581: ldc_w 391
    //   2584: aload_1
    //   2585: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   2588: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   2591: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2594: pop
    //   2595: aload_2
    //   2596: ldc_w 398
    //   2599: aload_1
    //   2600: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   2603: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2606: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2609: pop
    //   2610: aload_2
    //   2611: ldc_w 405
    //   2614: aload_1
    //   2615: getfield 407	com/tencent/mobileqq/msf/core/quicksend/f:c	Ljava/lang/String;
    //   2618: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2621: pop
    //   2622: aload_2
    //   2623: ldc_w 409
    //   2626: aload_1
    //   2627: getfield 411	com/tencent/mobileqq/msf/core/quicksend/f:d	Ljava/lang/String;
    //   2630: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2633: pop
    //   2634: aload_2
    //   2635: ldc_w 413
    //   2638: ldc_w 415
    //   2641: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2644: pop
    //   2645: aload_2
    //   2646: ldc_w 417
    //   2649: aload_1
    //   2650: getfield 419	com/tencent/mobileqq/msf/core/quicksend/f:e	I
    //   2653: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   2656: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2659: pop
    //   2660: aload_2
    //   2661: ldc_w 424
    //   2664: aload_1
    //   2665: getfield 229	com/tencent/mobileqq/msf/core/quicksend/f:f	I
    //   2668: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   2671: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2674: pop
    //   2675: aload_2
    //   2676: ldc_w 426
    //   2679: aload_1
    //   2680: getfield 428	com/tencent/mobileqq/msf/core/quicksend/f:g	J
    //   2683: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2686: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2689: pop
    //   2690: aload_2
    //   2691: ldc_w 430
    //   2694: aload_1
    //   2695: getfield 432	com/tencent/mobileqq/msf/core/quicksend/f:i	Z
    //   2698: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   2701: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2704: pop
    //   2705: aload_2
    //   2706: ldc_w 434
    //   2709: aload_1
    //   2710: getfield 436	com/tencent/mobileqq/msf/core/quicksend/f:j	J
    //   2713: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2716: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2719: pop
    //   2720: aload_2
    //   2721: ldc_w 438
    //   2724: aload_1
    //   2725: getfield 440	com/tencent/mobileqq/msf/core/quicksend/f:k	I
    //   2728: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   2731: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2734: pop
    //   2735: aload_2
    //   2736: ldc_w 442
    //   2739: aload_1
    //   2740: getfield 444	com/tencent/mobileqq/msf/core/quicksend/f:m	Ljava/lang/String;
    //   2743: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2746: pop
    //   2747: aload_2
    //   2748: ldc_w 446
    //   2751: aload_1
    //   2752: getfield 448	com/tencent/mobileqq/msf/core/quicksend/f:h	Ljava/lang/String;
    //   2755: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2758: pop
    //   2759: aload_2
    //   2760: ldc_w 450
    //   2763: new 323	java/lang/StringBuilder
    //   2766: dup
    //   2767: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   2770: ldc_w 452
    //   2773: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2776: iload 4
    //   2778: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2781: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2784: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2787: pop
    //   2788: aload_2
    //   2789: ldc_w 454
    //   2792: new 323	java/lang/StringBuilder
    //   2795: dup
    //   2796: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   2799: ldc_w 452
    //   2802: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2805: iload_3
    //   2806: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2809: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2812: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2815: pop
    //   2816: aload_2
    //   2817: ldc_w 456
    //   2820: aload_0
    //   2821: getfield 75	com/tencent/mobileqq/msf/core/g:c	Z
    //   2824: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   2827: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2830: pop
    //   2831: aload_2
    //   2832: ldc_w 460
    //   2835: aload_0
    //   2836: getfield 81	com/tencent/mobileqq/msf/core/g:d	Z
    //   2839: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   2842: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2845: pop
    //   2846: iconst_0
    //   2847: istore_3
    //   2848: aload_1
    //   2849: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   2852: ifeq +12 -> 2864
    //   2855: aload_0
    //   2856: getfield 75	com/tencent/mobileqq/msf/core/g:c	Z
    //   2859: ifeq +1122 -> 3981
    //   2862: iconst_4
    //   2863: istore_3
    //   2864: aload_2
    //   2865: ldc_w 462
    //   2868: iload_3
    //   2869: invokestatic 464	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2872: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2875: pop
    //   2876: aload_2
    //   2877: getstatic 469	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   2880: ldc_w 452
    //   2883: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2886: pop
    //   2887: aload_0
    //   2888: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2891: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
    //   2894: ldc_w 471
    //   2897: aload_1
    //   2898: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   2901: aload_1
    //   2902: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   2905: lconst_0
    //   2906: aload_2
    //   2907: iconst_0
    //   2908: iconst_0
    //   2909: invokevirtual 476	com/tencent/mobileqq/msf/core/c/j:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   2912: iconst_0
    //   2913: ireturn
    //   2914: astore 13
    //   2916: iconst_0
    //   2917: istore 9
    //   2919: iload 9
    //   2921: istore 8
    //   2923: aload_0
    //   2924: aload_2
    //   2925: aconst_null
    //   2926: iconst_m1
    //   2927: new 323	java/lang/StringBuilder
    //   2930: dup
    //   2931: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   2934: ldc_w 362
    //   2937: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2940: iload 5
    //   2942: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2945: ldc_w 548
    //   2948: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2951: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2954: aload_1
    //   2955: invokespecial 366	com/tencent/mobileqq/msf/core/g:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;ILjava/lang/String;Lcom/tencent/mobileqq/msf/core/quicksend/f;)V
    //   2958: iload 9
    //   2960: istore 8
    //   2962: aload 13
    //   2964: invokevirtual 551	java/lang/Throwable:printStackTrace	()V
    //   2967: iload 9
    //   2969: istore 8
    //   2971: ldc 48
    //   2973: iconst_1
    //   2974: new 323	java/lang/StringBuilder
    //   2977: dup
    //   2978: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   2981: ldc_w 553
    //   2984: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2987: iload 5
    //   2989: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2992: ldc_w 555
    //   2995: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2998: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3001: aload 13
    //   3003: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3006: iconst_0
    //   3007: istore 10
    //   3009: iconst_0
    //   3010: istore 8
    //   3012: aload_1
    //   3013: invokestatic 372	android/os/SystemClock:elapsedRealtime	()J
    //   3016: aload_1
    //   3017: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   3020: lsub
    //   3021: putfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   3024: aload_0
    //   3025: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3028: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
    //   3031: ifnull +392 -> 3423
    //   3034: aload_0
    //   3035: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3038: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   3041: ifnull +382 -> 3423
    //   3044: aload_2
    //   3045: ifnull +378 -> 3423
    //   3048: aload_0
    //   3049: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3052: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   3055: aload_2
    //   3056: invokevirtual 388	com/tencent/mobileqq/msf/core/quicksend/b:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   3059: ifeq +364 -> 3423
    //   3062: new 282	java/util/HashMap
    //   3065: dup
    //   3066: invokespecial 389	java/util/HashMap:<init>	()V
    //   3069: astore 13
    //   3071: aload 13
    //   3073: ldc_w 391
    //   3076: aload_1
    //   3077: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   3080: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   3083: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3086: pop
    //   3087: aload 13
    //   3089: ldc_w 398
    //   3092: aload_1
    //   3093: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   3096: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3099: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3102: pop
    //   3103: aload 13
    //   3105: ldc_w 405
    //   3108: aload_1
    //   3109: getfield 407	com/tencent/mobileqq/msf/core/quicksend/f:c	Ljava/lang/String;
    //   3112: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3115: pop
    //   3116: aload 13
    //   3118: ldc_w 409
    //   3121: aload_1
    //   3122: getfield 411	com/tencent/mobileqq/msf/core/quicksend/f:d	Ljava/lang/String;
    //   3125: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3128: pop
    //   3129: aload 13
    //   3131: ldc_w 413
    //   3134: ldc_w 415
    //   3137: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3140: pop
    //   3141: aload 13
    //   3143: ldc_w 417
    //   3146: aload_1
    //   3147: getfield 419	com/tencent/mobileqq/msf/core/quicksend/f:e	I
    //   3150: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3153: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3156: pop
    //   3157: aload 13
    //   3159: ldc_w 424
    //   3162: aload_1
    //   3163: getfield 229	com/tencent/mobileqq/msf/core/quicksend/f:f	I
    //   3166: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3169: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3172: pop
    //   3173: aload 13
    //   3175: ldc_w 426
    //   3178: aload_1
    //   3179: getfield 428	com/tencent/mobileqq/msf/core/quicksend/f:g	J
    //   3182: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3185: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3188: pop
    //   3189: aload 13
    //   3191: ldc_w 430
    //   3194: aload_1
    //   3195: getfield 432	com/tencent/mobileqq/msf/core/quicksend/f:i	Z
    //   3198: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   3201: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3204: pop
    //   3205: aload 13
    //   3207: ldc_w 434
    //   3210: aload_1
    //   3211: getfield 436	com/tencent/mobileqq/msf/core/quicksend/f:j	J
    //   3214: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3217: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3220: pop
    //   3221: aload 13
    //   3223: ldc_w 438
    //   3226: aload_1
    //   3227: getfield 440	com/tencent/mobileqq/msf/core/quicksend/f:k	I
    //   3230: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3233: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3236: pop
    //   3237: aload 13
    //   3239: ldc_w 442
    //   3242: aload_1
    //   3243: getfield 444	com/tencent/mobileqq/msf/core/quicksend/f:m	Ljava/lang/String;
    //   3246: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3249: pop
    //   3250: aload 13
    //   3252: ldc_w 446
    //   3255: aload_1
    //   3256: getfield 448	com/tencent/mobileqq/msf/core/quicksend/f:h	Ljava/lang/String;
    //   3259: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3262: pop
    //   3263: aload 13
    //   3265: ldc_w 450
    //   3268: new 323	java/lang/StringBuilder
    //   3271: dup
    //   3272: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   3275: ldc_w 452
    //   3278: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3281: iload 4
    //   3283: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3286: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3289: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3292: pop
    //   3293: aload 13
    //   3295: ldc_w 454
    //   3298: new 323	java/lang/StringBuilder
    //   3301: dup
    //   3302: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   3305: ldc_w 452
    //   3308: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3311: iload_3
    //   3312: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3315: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3318: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3321: pop
    //   3322: aload 13
    //   3324: ldc_w 456
    //   3327: aload_0
    //   3328: getfield 75	com/tencent/mobileqq/msf/core/g:c	Z
    //   3331: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   3334: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3337: pop
    //   3338: aload 13
    //   3340: ldc_w 460
    //   3343: aload_0
    //   3344: getfield 81	com/tencent/mobileqq/msf/core/g:d	Z
    //   3347: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   3350: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3353: pop
    //   3354: iconst_0
    //   3355: istore_3
    //   3356: aload_1
    //   3357: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   3360: ifeq +12 -> 3372
    //   3363: aload_0
    //   3364: getfield 75	com/tencent/mobileqq/msf/core/g:c	Z
    //   3367: ifeq +524 -> 3891
    //   3370: iconst_4
    //   3371: istore_3
    //   3372: aload 13
    //   3374: ldc_w 462
    //   3377: iload_3
    //   3378: invokestatic 464	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   3381: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3384: pop
    //   3385: aload 13
    //   3387: getstatic 469	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   3390: ldc_w 452
    //   3393: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3396: pop
    //   3397: aload_0
    //   3398: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3401: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
    //   3404: ldc_w 471
    //   3407: aload_1
    //   3408: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   3411: aload_1
    //   3412: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   3415: lconst_0
    //   3416: aload 13
    //   3418: iconst_0
    //   3419: iconst_0
    //   3420: invokevirtual 476	com/tencent/mobileqq/msf/core/c/j:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   3423: iload 9
    //   3425: ifeq -2678 -> 747
    //   3428: invokestatic 254	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   3431: astore 13
    //   3433: iload 10
    //   3435: istore 8
    //   3437: goto -961 -> 2476
    //   3440: astore 13
    //   3442: iconst_0
    //   3443: istore 8
    //   3445: aload_1
    //   3446: invokestatic 372	android/os/SystemClock:elapsedRealtime	()J
    //   3449: aload_1
    //   3450: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   3453: lsub
    //   3454: putfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   3457: aload_0
    //   3458: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3461: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
    //   3464: ifnull +392 -> 3856
    //   3467: aload_0
    //   3468: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3471: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   3474: ifnull +382 -> 3856
    //   3477: aload_2
    //   3478: ifnull +378 -> 3856
    //   3481: aload_0
    //   3482: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3485: getfield 383	com/tencent/mobileqq/msf/core/MsfCore:quicksender	Lcom/tencent/mobileqq/msf/core/quicksend/b;
    //   3488: aload_2
    //   3489: invokevirtual 388	com/tencent/mobileqq/msf/core/quicksend/b:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Z
    //   3492: ifeq +364 -> 3856
    //   3495: new 282	java/util/HashMap
    //   3498: dup
    //   3499: invokespecial 389	java/util/HashMap:<init>	()V
    //   3502: astore 14
    //   3504: aload 14
    //   3506: ldc_w 391
    //   3509: aload_1
    //   3510: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   3513: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   3516: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3519: pop
    //   3520: aload 14
    //   3522: ldc_w 398
    //   3525: aload_1
    //   3526: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   3529: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3532: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3535: pop
    //   3536: aload 14
    //   3538: ldc_w 405
    //   3541: aload_1
    //   3542: getfield 407	com/tencent/mobileqq/msf/core/quicksend/f:c	Ljava/lang/String;
    //   3545: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3548: pop
    //   3549: aload 14
    //   3551: ldc_w 409
    //   3554: aload_1
    //   3555: getfield 411	com/tencent/mobileqq/msf/core/quicksend/f:d	Ljava/lang/String;
    //   3558: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3561: pop
    //   3562: aload 14
    //   3564: ldc_w 413
    //   3567: ldc_w 415
    //   3570: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3573: pop
    //   3574: aload 14
    //   3576: ldc_w 417
    //   3579: aload_1
    //   3580: getfield 419	com/tencent/mobileqq/msf/core/quicksend/f:e	I
    //   3583: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3586: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3589: pop
    //   3590: aload 14
    //   3592: ldc_w 424
    //   3595: aload_1
    //   3596: getfield 229	com/tencent/mobileqq/msf/core/quicksend/f:f	I
    //   3599: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3602: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3605: pop
    //   3606: aload 14
    //   3608: ldc_w 426
    //   3611: aload_1
    //   3612: getfield 428	com/tencent/mobileqq/msf/core/quicksend/f:g	J
    //   3615: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3618: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3621: pop
    //   3622: aload 14
    //   3624: ldc_w 430
    //   3627: aload_1
    //   3628: getfield 432	com/tencent/mobileqq/msf/core/quicksend/f:i	Z
    //   3631: invokestatic 396	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   3634: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3637: pop
    //   3638: aload 14
    //   3640: ldc_w 434
    //   3643: aload_1
    //   3644: getfield 436	com/tencent/mobileqq/msf/core/quicksend/f:j	J
    //   3647: invokestatic 403	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3650: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3653: pop
    //   3654: aload 14
    //   3656: ldc_w 438
    //   3659: aload_1
    //   3660: getfield 440	com/tencent/mobileqq/msf/core/quicksend/f:k	I
    //   3663: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3666: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3669: pop
    //   3670: aload 14
    //   3672: ldc_w 442
    //   3675: aload_1
    //   3676: getfield 444	com/tencent/mobileqq/msf/core/quicksend/f:m	Ljava/lang/String;
    //   3679: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3682: pop
    //   3683: aload 14
    //   3685: ldc_w 446
    //   3688: aload_1
    //   3689: getfield 448	com/tencent/mobileqq/msf/core/quicksend/f:h	Ljava/lang/String;
    //   3692: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3695: pop
    //   3696: aload 14
    //   3698: ldc_w 450
    //   3701: new 323	java/lang/StringBuilder
    //   3704: dup
    //   3705: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   3708: ldc_w 452
    //   3711: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3714: iload 4
    //   3716: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3719: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3722: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3725: pop
    //   3726: aload 14
    //   3728: ldc_w 454
    //   3731: new 323	java/lang/StringBuilder
    //   3734: dup
    //   3735: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   3738: ldc_w 452
    //   3741: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3744: iload_3
    //   3745: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3748: invokevirtual 351	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3751: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3754: pop
    //   3755: aload 14
    //   3757: ldc_w 456
    //   3760: aload_0
    //   3761: getfield 75	com/tencent/mobileqq/msf/core/g:c	Z
    //   3764: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   3767: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3770: pop
    //   3771: aload 14
    //   3773: ldc_w 460
    //   3776: aload_0
    //   3777: getfield 81	com/tencent/mobileqq/msf/core/g:d	Z
    //   3780: invokestatic 458	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   3783: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3786: pop
    //   3787: iconst_0
    //   3788: istore_3
    //   3789: aload_1
    //   3790: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   3793: ifeq +12 -> 3805
    //   3796: aload_0
    //   3797: getfield 75	com/tencent/mobileqq/msf/core/g:c	Z
    //   3800: ifeq +73 -> 3873
    //   3803: iconst_4
    //   3804: istore_3
    //   3805: aload 14
    //   3807: ldc_w 462
    //   3810: iload_3
    //   3811: invokestatic 464	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   3814: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3817: pop
    //   3818: aload 14
    //   3820: getstatic 469	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   3823: ldc_w 452
    //   3826: invokevirtual 318	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3829: pop
    //   3830: aload_0
    //   3831: getfield 97	com/tencent/mobileqq/msf/core/g:y	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3834: getfield 379	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
    //   3837: ldc_w 471
    //   3840: aload_1
    //   3841: getfield 298	com/tencent/mobileqq/msf/core/quicksend/f:a	Z
    //   3844: aload_1
    //   3845: getfield 375	com/tencent/mobileqq/msf/core/quicksend/f:b	J
    //   3848: lconst_0
    //   3849: aload 14
    //   3851: iconst_0
    //   3852: iconst_0
    //   3853: invokevirtual 476	com/tencent/mobileqq/msf/core/c/j:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   3856: iload 8
    //   3858: ifeq +12 -> 3870
    //   3861: invokestatic 254	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   3864: aload_2
    //   3865: aconst_null
    //   3866: aload_1
    //   3867: invokevirtual 257	com/tencent/mobileqq/a/a/a:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Lcom/tencent/mobileqq/msf/core/quicksend/f;)V
    //   3870: aload 13
    //   3872: athrow
    //   3873: aload_0
    //   3874: getfield 81	com/tencent/mobileqq/msf/core/g:d	Z
    //   3877: ifeq +9 -> 3886
    //   3880: bipush 6
    //   3882: istore_3
    //   3883: goto -78 -> 3805
    //   3886: iconst_2
    //   3887: istore_3
    //   3888: goto -83 -> 3805
    //   3891: aload_0
    //   3892: getfield 81	com/tencent/mobileqq/msf/core/g:d	Z
    //   3895: ifeq +9 -> 3904
    //   3898: bipush 6
    //   3900: istore_3
    //   3901: goto -529 -> 3372
    //   3904: iconst_2
    //   3905: istore_3
    //   3906: goto -534 -> 3372
    //   3909: aload_0
    //   3910: getfield 81	com/tencent/mobileqq/msf/core/g:d	Z
    //   3913: ifeq +9 -> 3922
    //   3916: bipush 6
    //   3918: istore_3
    //   3919: goto -3241 -> 678
    //   3922: iconst_2
    //   3923: istore_3
    //   3924: goto -3246 -> 678
    //   3927: aload_0
    //   3928: getfield 81	com/tencent/mobileqq/msf/core/g:d	Z
    //   3931: ifeq +9 -> 3940
    //   3934: bipush 6
    //   3936: istore_3
    //   3937: goto -2591 -> 1346
    //   3940: iconst_2
    //   3941: istore_3
    //   3942: goto -2596 -> 1346
    //   3945: aload_0
    //   3946: getfield 81	com/tencent/mobileqq/msf/core/g:d	Z
    //   3949: ifeq +9 -> 3958
    //   3952: bipush 6
    //   3954: istore_3
    //   3955: goto -2118 -> 1837
    //   3958: iconst_2
    //   3959: istore_3
    //   3960: goto -2123 -> 1837
    //   3963: aload_0
    //   3964: getfield 81	com/tencent/mobileqq/msf/core/g:d	Z
    //   3967: ifeq +9 -> 3976
    //   3970: bipush 6
    //   3972: istore_3
    //   3973: goto -1562 -> 2411
    //   3976: iconst_2
    //   3977: istore_3
    //   3978: goto -1567 -> 2411
    //   3981: aload_0
    //   3982: getfield 81	com/tencent/mobileqq/msf/core/g:d	Z
    //   3985: ifeq +9 -> 3994
    //   3988: bipush 6
    //   3990: istore_3
    //   3991: goto -1127 -> 2864
    //   3994: iconst_2
    //   3995: istore_3
    //   3996: goto -1132 -> 2864
    //   3999: astore 13
    //   4001: goto -556 -> 3445
    //   4004: astore 13
    //   4006: goto -1087 -> 2919
    //   4009: iconst_m1
    //   4010: istore 7
    //   4012: iload_3
    //   4013: istore 5
    //   4015: iload 4
    //   4017: istore 6
    //   4019: iload 7
    //   4021: istore_3
    //   4022: iload 5
    //   4024: istore 4
    //   4026: iload 6
    //   4028: istore 5
    //   4030: goto -3949 -> 81
    //   4033: iconst_0
    //   4034: istore_3
    //   4035: goto -3995 -> 40
    //   4038: iconst_m1
    //   4039: istore_3
    //   4040: iconst_0
    //   4041: istore 4
    //   4043: iconst_0
    //   4044: istore 5
    //   4046: goto -3965 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4049	0	this	g
    //   0	4049	1	paramf	com.tencent.mobileqq.msf.core.quicksend.f
    //   0	4049	2	paramToServiceMsg	ToServiceMsg
    //   39	4001	3	i1	int
    //   8	4034	4	i2	int
    //   73	3972	5	i3	int
    //   69	3958	6	i4	int
    //   4010	10	7	i5	int
    //   334	3523	8	bool1	boolean
    //   318	3106	9	bool2	boolean
    //   2046	1388	10	bool3	boolean
    //   720	1160	11	l1	long
    //   98	2379	13	localObject1	Object
    //   2914	88	13	localThrowable1	Throwable
    //   3069	363	13	localObject2	Object
    //   3440	431	13	localObject3	Object
    //   3999	1	13	localObject4	Object
    //   4004	1	13	localThrowable2	Throwable
    //   898	2952	14	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   270	277	2914	java/lang/Throwable
    //   282	317	2914	java/lang/Throwable
    //   893	945	2914	java/lang/Throwable
    //   950	985	2914	java/lang/Throwable
    //   1396	1423	2914	java/lang/Throwable
    //   1428	1436	2914	java/lang/Throwable
    //   1441	1476	2914	java/lang/Throwable
    //   1887	1916	2914	java/lang/Throwable
    //   1920	1974	2914	java/lang/Throwable
    //   1974	1991	2914	java/lang/Throwable
    //   2487	2522	2914	java/lang/Throwable
    //   270	277	3440	finally
    //   282	317	3440	finally
    //   893	945	3440	finally
    //   950	985	3440	finally
    //   1396	1423	3440	finally
    //   1428	1436	3440	finally
    //   1441	1476	3440	finally
    //   1887	1916	3440	finally
    //   1920	1974	3440	finally
    //   1974	1991	3440	finally
    //   2487	2522	3440	finally
    //   2000	2036	3999	finally
    //   2040	2045	3999	finally
    //   2923	2958	3999	finally
    //   2962	2967	3999	finally
    //   2971	3006	3999	finally
    //   2000	2036	4004	java/lang/Throwable
    //   2040	2045	4004	java/lang/Throwable
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
        localObject1 = this.y.getSsoListManager().l();
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(paramString2)) {
          localObject2 = a((CopyOnWriteArrayList)localObject1, paramString2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("LightTcpSender", 2, "selectAndConnect sortedList: " + localObject2);
        }
        if (localObject2 == null) {
          break label422;
        }
        paramString2 = ((CopyOnWriteArrayList)localObject2).iterator();
        bool = false;
      }
    }
    label422:
    label491:
    for (;;)
    {
      if (paramString2.hasNext())
      {
        localObject1 = (d)paramString2.next();
        this.A = ((d)localObject1).e();
        this.a.a(this.A);
        this.a.a(this.b);
        long l1 = SystemClock.elapsedRealtime();
        bool = this.a.a(((d)localObject1).c(), ((d)localObject1).d(), paramString1, paramf);
        paramf.k += 1;
        paramf.j = (SystemClock.elapsedRealtime() - l1);
        paramf.i = bool;
        if (!bool)
        {
          if (!QLog.isColorLevel()) {
            break label491;
          }
          QLog.i("LightTcpSender", 2, "connect " + ((d)localObject1).toString() + " fail");
          continue;
          localObject2 = this.y.getSsoListManager().j();
          localObject1 = localObject2;
          if (!this.c) {
            break;
          }
          localObject1 = localObject2;
          if (this.y.getSsoListManager().k() == null) {
            break;
          }
          localObject1 = localObject2;
          if (this.y.getSsoListManager().k().size() <= 0) {
            break;
          }
          localObject1 = this.y.getSsoListManager().k();
          break;
          if (this.a.a())
          {
            localObject1 = this.y.getSsoListManager().l();
            break;
          }
          localObject1 = this.y.getSsoListManager().k();
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("LightTcpSender", 2, "connect " + ((d)localObject1).toString() + " ok");
        }
        return true;
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
    try
    {
      str = paramToServiceMsg.getServiceCmd();
      Object localObject = null;
      if (paramToServiceMsg.getWupBuffer() == null) {
        break label330;
      }
      b1 = f();
      int i1 = 0;
      if (paramToServiceMsg.getAttributes().containsKey("send_mode")) {
        i1 = ((Integer)paramToServiceMsg.getAttributes().get("send_mode")).intValue();
      }
      try
      {
        byte[] arrayOfByte = af.f(paramToServiceMsg);
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
        break label229;
      }
      if (591 == CodecWarpper.getSharedObjectVersion()) {
        return CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), t.d(), t.f(), t.g(), "", str, null, paramToServiceMsg.getAppId(), this.y.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, paramToServiceMsg.getWupBuffer(), true);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.d("LightTcpSender", 1, "LightSender get packet fail ssoseq: " + paramToServiceMsg.getRequestSsoSeq(), localThrowable);
      return null;
    }
    return CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), t.d(), t.f(), t.g(), "", str, null, paramToServiceMsg.getAppId(), this.y.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, localThrowable, paramToServiceMsg.getWupBuffer(), true);
    label229:
    if (591 == CodecWarpper.getSharedObjectVersion()) {
      return CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), t.d(), t.f(), t.g(), "", str, null, paramToServiceMsg.getAppId(), this.y.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, paramToServiceMsg.getWupBuffer(), true);
    }
    return CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), t.d(), t.f(), t.g(), "", str, null, paramToServiceMsg.getAppId(), this.y.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, localThrowable, paramToServiceMsg.getWupBuffer(), true);
    label330:
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
        if (k.a(this.x, (Network)localObject, 0))
        {
          ConnectivityManager localConnectivityManager = (ConnectivityManager)this.x.getSystemService("connectivity");
          if (localConnectivityManager != null)
          {
            localObject = localConnectivityManager.getNetworkInfo((Network)localObject);
            if (localObject != null)
            {
              int i2 = ((NetworkInfo)localObject).getSubtype() + 100;
              i1 = i2;
              if (i2 <= 254) {
                break label178;
              }
              if (!QLog.isColorLevel()) {
                break label174;
              }
              QLog.d("LightTcpSender", 2, "error,netWorkType is " + 254);
              i1 = 254;
              break label178;
            }
            i1 = ((TelephonyManager)BaseApplication.getContext().getSystemService("phone")).getNetworkType();
            break label178;
          }
        }
        else
        {
          boolean bool = k.a(this.x, (Network)localObject, 0);
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
      label174:
      int i1 = 254;
      label178:
      b1 = (byte)i1;
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
    return k.a(this.x, this.b, 0);
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
  
  class a
    extends k.a
  {
    a() {}
    
    public void a(int paramInt) {}
    
    public void b(int paramInt)
    {
      g.this.b = null;
    }
    
    public void onAvailable(Network paramNetwork)
    {
      g.a(g.this, false);
      g.this.b = paramNetwork;
      g.d(g.this).removeMessages(1);
      paramNetwork = g.d(g.this).obtainMessage(2);
      g.d(g.this).sendMessageAtFrontOfQueue(paramNetwork);
    }
    
    public void onCapabilitiesChanged(Network paramNetwork, NetworkCapabilities paramNetworkCapabilities) {}
    
    public void onLinkPropertiesChanged(Network paramNetwork, LinkProperties paramLinkProperties) {}
    
    public void onLosing(Network paramNetwork, int paramInt) {}
    
    public void onLost(Network paramNetwork) {}
  }
  
  class b
    extends Handler
  {
    public b(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
      case 2: 
        do
        {
          do
          {
            return;
            if (!g.a(g.this)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("LightTcpSender", 2, "Network is exit " + g.this.b);
          return;
          if (g.this.a()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("LightTcpSender", 2, "Network is closed " + g.this.b);
        return;
        while ((!g.a(g.this)) && (g.this.e.size() > 0))
        {
          ToServiceMsg localToServiceMsg = (ToServiceMsg)g.this.e.poll();
          if (localToServiceMsg != null)
          {
            com.tencent.mobileqq.msf.core.quicksend.f localf = new com.tencent.mobileqq.msf.core.quicksend.f();
            localf.b = SystemClock.elapsedRealtime();
            localf.j = localf.b;
            localf.g = localf.b;
            String str2 = g.a(g.this, localToServiceMsg);
            String str1 = "";
            paramMessage = str1;
            if (localToServiceMsg.getAttributes().containsKey("connIDC"))
            {
              paramMessage = str1;
              if (localToServiceMsg.getAttributes().get("connIDC") != null)
              {
                str1 = (String)localToServiceMsg.getAttributes().get("connIDC");
                paramMessage = str1;
                if (QLog.isColorLevel())
                {
                  QLog.d("LightTcpSender", 2, "sleectConnect ssoSeq:" + localToServiceMsg.getRequestSsoSeq() + " connIDC: " + str1);
                  paramMessage = str1;
                }
              }
            }
            if ((g.b(g.this)) || (g.a(g.this, localToServiceMsg, localf, str2, paramMessage)))
            {
              g.a(g.this, localf, localToServiceMsg);
              if (!g.b(g.this)) {
                g.this.a.c();
              }
            }
          }
        }
      }
      try
      {
        g.this.e.clear();
        g.this.a.c();
        g.this.a.d();
        paramMessage = g.c(g.this);
      }
      catch (Exception paramMessage)
      {
        for (;;)
        {
          QLog.i("LightTcpSender", 1, paramMessage.getMessage(), paramMessage);
          paramMessage.printStackTrace();
          paramMessage = g.c(g.this);
        }
      }
      finally
      {
        k.c(g.c(g.this));
      }
      k.c(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.g
 * JD-Core Version:    0.7.0.1
 */