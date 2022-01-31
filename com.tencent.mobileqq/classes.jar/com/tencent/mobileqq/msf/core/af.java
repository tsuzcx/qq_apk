package com.tencent.mobileqq.msf.core;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.jce.wup.ObjectCreateException;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.core.a.a.a;
import com.tencent.mobileqq.msf.core.net.a.e;
import com.tencent.mobileqq.msf.core.net.j.b;
import com.tencent.mobileqq.msf.core.net.l;
import com.tencent.mobileqq.msf.core.net.m;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.msf.service.protocol.pb.SSOLoginMerge.BusiBuffData;
import com.tencent.msf.service.protocol.pb.SSOLoginMerge.BusiBuffItem;
import com.tencent.msf.service.protocol.pb.SSOReserveField.ReserveFields;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class af
{
  public static boolean A = false;
  public static long B = 0L;
  public static AtomicInteger C;
  public static ArrayList D;
  public static String G;
  public static String H;
  public static int I = 0;
  public static long K = 0L;
  public static int N = 0;
  public static long S = 0L;
  static int T = 0;
  static AtomicBoolean U;
  public static final String W = "GrayUinPro.Check";
  public static final String X = "res";
  private static AtomicBoolean aA = new AtomicBoolean();
  public static final int aa = -10008;
  public static final int ab = -302;
  public static final int ac = 302;
  static CopyOnWriteArraySet ad;
  private static final AtomicInteger aj = new AtomicInteger();
  private static boolean ak = false;
  private static int an = 0;
  private static String ao;
  private static String[] ap;
  public static final String b = "__extraTimeoutSeq";
  public static final String r = "MSF.C.NetConnTag";
  public static boolean s;
  public static ConcurrentHashMap t = new ConcurrentHashMap();
  public static ConcurrentHashMap u = new ConcurrentHashMap();
  public static long v = -1L;
  public static int y = -1;
  public static int z;
  public a E = new a();
  MsfCore F;
  public com.tencent.mobileqq.msf.core.net.a.f J;
  c L = new c();
  long M;
  AtomicBoolean O = new AtomicBoolean();
  int P = 0;
  long Q = 0L;
  long R = 0L;
  HashSet V = new HashSet();
  public int Y = -1;
  public AtomicBoolean Z = new AtomicBoolean();
  public m a;
  ArrayList ae = new ArrayList();
  boolean af = false;
  private HashSet ag = new HashSet();
  private ToServiceMsg ah;
  private Handler ai;
  private int al;
  private String am = "0";
  private HashSet aq = new HashSet();
  private volatile boolean ar;
  private Object as = new Object();
  private long at;
  private long au;
  private long av = SystemClock.uptimeMillis();
  private long aw;
  private byte[] ax;
  private long ay;
  private Random az = new Random(System.currentTimeMillis());
  public ConcurrentHashMap c = new ConcurrentHashMap();
  public ConcurrentHashMap d = new ConcurrentHashMap();
  public ConcurrentHashMap e = new ConcurrentHashMap();
  public LinkedBlockingDeque f = new LinkedBlockingDeque(1000);
  public LinkedBlockingDeque g = new LinkedBlockingDeque();
  b h = new b();
  public int i = 10;
  public int j = 3072;
  public int k;
  public int l = 500;
  public int m;
  public int n = 300;
  public long o;
  public boolean p;
  public volatile boolean q;
  public final String w = Environment.getExternalStorageDirectory().getPath() + "/tencent/MobileQQ/data/wifi";
  public SimpleDateFormat x = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
  
  static
  {
    A = true;
    B = -1L;
    C = new AtomicInteger(0);
    D = new ArrayList();
    G = ":";
    H = "0";
    ao = "";
    ap = new String[] { "StreamSvr.UploadStreamMsg" };
    K = -1L;
    T = -1;
    U = new AtomicBoolean();
    ad = new CopyOnWriteArraySet();
  }
  
  public af(MsfCore paramMsfCore)
  {
    this.F = paramMsfCore;
    HandlerThread localHandlerThread = new HandlerThread("mergehandle", 5);
    localHandlerThread.start();
    this.ai = new Handler(localHandlerThread.getLooper());
    this.al = paramMsfCore.getMsfAppid();
    this.a = new m(paramMsfCore);
    this.L.setName("MsfCoreMsgSender");
    try
    {
      paramMsfCore = com.tencent.mobileqq.msf.core.a.a.c();
      if (paramMsfCore != null)
      {
        this.i = Integer.parseInt(paramMsfCore[0]);
        this.j = Integer.parseInt(paramMsfCore[1]);
        this.n = Integer.parseInt(paramMsfCore[2]);
        this.l = Integer.parseInt(paramMsfCore[3]);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "maxDelaySize: " + this.j + " noMergeSize: " + this.n + " globaldelayTime: " + this.l + " delayWaitSendCount: " + this.i);
        }
      }
      return;
    }
    catch (Exception paramMsfCore)
    {
      try
      {
        for (;;)
        {
          a(com.tencent.mobileqq.msf.core.a.a.d());
          try
          {
            this.m = Integer.parseInt(com.tencent.mobileqq.msf.core.a.a.e());
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.NetConnTag", 2, "mergeDuration: " + this.m);
            }
            return;
          }
          catch (Exception paramMsfCore)
          {
            QLog.d("MSF.C.NetConnTag", 1, " " + paramMsfCore, paramMsfCore);
          }
          paramMsfCore = paramMsfCore;
          QLog.d("MSF.C.NetConnTag", 1, " " + paramMsfCore, paramMsfCore);
        }
      }
      catch (Exception paramMsfCore)
      {
        for (;;)
        {
          QLog.d("MSF.C.NetConnTag", 1, " " + paramMsfCore, paramMsfCore);
        }
      }
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ad.add(paramString);
      QLog.d("MSF.C.NetConnTag", 1, "use simple head for uin:" + MsfSdkUtils.getShortUin(paramString));
    }
    for (;;)
    {
      CodecWarpper.nativeSetUseSimpleHead(paramString, paramBoolean);
      return;
      ad.remove(paramString);
      QLog.d("MSF.C.NetConnTag", 1, "use full head for uin:" + MsfSdkUtils.getShortUin(paramString));
      if (t.containsKey(paramString))
      {
        t.remove(paramString);
        QLog.d("MSF.C.NetConnTag", 1, "clear storeSendSsoSeq tag for uin:" + MsfSdkUtils.getShortUin(paramString));
      }
    }
  }
  
  /* Error */
  private void b(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 473	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   3: ifnull +58 -> 61
    //   6: getstatic 473	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   9: arraylength
    //   10: ifle +51 -> 61
    //   13: aload_0
    //   14: getfield 365	com/tencent/mobileqq/msf/core/af:a	Lcom/tencent/mobileqq/msf/core/net/m;
    //   17: getstatic 473	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   20: invokevirtual 474	com/tencent/mobileqq/msf/core/net/m:a	([Ljava/lang/String;)V
    //   23: invokestatic 388	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +34 -> 60
    //   29: ldc 69
    //   31: iconst_2
    //   32: new 239	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 476
    //   42: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: getstatic 473	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   48: invokestatic 481	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   51: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 402	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: return
    //   61: getstatic 484	com/tencent/qphone/base/BaseConstants:WiFiloginMergeTSAddress	[Ljava/lang/String;
    //   64: ifnull +58 -> 122
    //   67: getstatic 484	com/tencent/qphone/base/BaseConstants:WiFiloginMergeTSAddress	[Ljava/lang/String;
    //   70: arraylength
    //   71: ifle +51 -> 122
    //   74: aload_0
    //   75: getfield 365	com/tencent/mobileqq/msf/core/af:a	Lcom/tencent/mobileqq/msf/core/net/m;
    //   78: getstatic 484	com/tencent/qphone/base/BaseConstants:WiFiloginMergeTSAddress	[Ljava/lang/String;
    //   81: invokevirtual 486	com/tencent/mobileqq/msf/core/net/m:b	([Ljava/lang/String;)V
    //   84: invokestatic 388	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq -27 -> 60
    //   90: ldc 69
    //   92: iconst_2
    //   93: new 239	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   100: ldc_w 476
    //   103: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: getstatic 473	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   109: invokestatic 481	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   112: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 402	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: return
    //   122: aload_1
    //   123: invokevirtual 491	android/content/Context:getPackageName	()Ljava/lang/String;
    //   126: astore_1
    //   127: new 248	java/io/File
    //   130: dup
    //   131: new 239	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   138: invokestatic 246	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   141: invokevirtual 252	java/io/File:getPath	()Ljava/lang/String;
    //   144: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc_w 493
    //   150: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_1
    //   154: ldc_w 495
    //   157: ldc_w 497
    //   160: invokevirtual 501	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   163: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc_w 503
    //   169: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokespecial 505	java/io/File:<init>	(Ljava/lang/String;)V
    //   178: astore_1
    //   179: new 507	java/util/Properties
    //   182: dup
    //   183: invokespecial 508	java/util/Properties:<init>	()V
    //   186: astore_3
    //   187: new 510	java/io/FileInputStream
    //   190: dup
    //   191: aload_1
    //   192: invokespecial 513	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   195: astore_2
    //   196: aload_2
    //   197: astore_1
    //   198: aload_3
    //   199: aload_2
    //   200: invokevirtual 517	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   203: aload_2
    //   204: astore_1
    //   205: aload_3
    //   206: ldc_w 519
    //   209: invokevirtual 522	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   212: astore 4
    //   214: aload_2
    //   215: astore_1
    //   216: aload_3
    //   217: ldc_w 524
    //   220: invokevirtual 522	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   223: astore_3
    //   224: aload_2
    //   225: astore_1
    //   226: aload 4
    //   228: ldc_w 526
    //   231: invokevirtual 530	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   234: putstatic 473	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   237: aload_2
    //   238: astore_1
    //   239: aload_3
    //   240: ldc_w 526
    //   243: invokevirtual 530	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   246: putstatic 484	com/tencent/qphone/base/BaseConstants:WiFiloginMergeTSAddress	[Ljava/lang/String;
    //   249: aload_2
    //   250: astore_1
    //   251: aload_0
    //   252: getfield 365	com/tencent/mobileqq/msf/core/af:a	Lcom/tencent/mobileqq/msf/core/net/m;
    //   255: getstatic 473	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   258: invokevirtual 474	com/tencent/mobileqq/msf/core/net/m:a	([Ljava/lang/String;)V
    //   261: aload_2
    //   262: astore_1
    //   263: invokestatic 388	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   266: ifeq +36 -> 302
    //   269: aload_2
    //   270: astore_1
    //   271: ldc 69
    //   273: iconst_2
    //   274: new 239	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   281: ldc_w 532
    //   284: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: getstatic 473	com/tencent/qphone/base/BaseConstants:XGloginMergeTSAddress	[Ljava/lang/String;
    //   290: invokestatic 481	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   293: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 402	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: aload_2
    //   303: astore_1
    //   304: aload_0
    //   305: getfield 365	com/tencent/mobileqq/msf/core/af:a	Lcom/tencent/mobileqq/msf/core/net/m;
    //   308: getstatic 484	com/tencent/qphone/base/BaseConstants:WiFiloginMergeTSAddress	[Ljava/lang/String;
    //   311: invokevirtual 486	com/tencent/mobileqq/msf/core/net/m:b	([Ljava/lang/String;)V
    //   314: aload_2
    //   315: astore_1
    //   316: invokestatic 388	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq +36 -> 355
    //   322: aload_2
    //   323: astore_1
    //   324: ldc 69
    //   326: iconst_2
    //   327: new 239	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   334: ldc_w 532
    //   337: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: getstatic 484	com/tencent/qphone/base/BaseConstants:WiFiloginMergeTSAddress	[Ljava/lang/String;
    //   343: invokestatic 481	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   346: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 402	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: aload_2
    //   356: ifnull -296 -> 60
    //   359: aload_2
    //   360: invokevirtual 535	java/io/FileInputStream:close	()V
    //   363: return
    //   364: astore_1
    //   365: aload_1
    //   366: invokevirtual 538	java/lang/Exception:printStackTrace	()V
    //   369: return
    //   370: astore_3
    //   371: aconst_null
    //   372: astore_2
    //   373: aload_2
    //   374: astore_1
    //   375: aload_3
    //   376: invokevirtual 538	java/lang/Exception:printStackTrace	()V
    //   379: aload_2
    //   380: ifnull -320 -> 60
    //   383: aload_2
    //   384: invokevirtual 535	java/io/FileInputStream:close	()V
    //   387: return
    //   388: astore_1
    //   389: aload_1
    //   390: invokevirtual 538	java/lang/Exception:printStackTrace	()V
    //   393: return
    //   394: astore_2
    //   395: aconst_null
    //   396: astore_1
    //   397: aload_1
    //   398: ifnull +7 -> 405
    //   401: aload_1
    //   402: invokevirtual 535	java/io/FileInputStream:close	()V
    //   405: aload_2
    //   406: athrow
    //   407: astore_1
    //   408: aload_1
    //   409: invokevirtual 538	java/lang/Exception:printStackTrace	()V
    //   412: goto -7 -> 405
    //   415: astore_2
    //   416: goto -19 -> 397
    //   419: astore_3
    //   420: goto -47 -> 373
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	423	0	this	af
    //   0	423	1	paramContext	Context
    //   195	189	2	localFileInputStream	java.io.FileInputStream
    //   394	12	2	localObject1	Object
    //   415	1	2	localObject2	Object
    //   186	54	3	localObject3	Object
    //   370	6	3	localException1	Exception
    //   419	1	3	localException2	Exception
    //   212	15	4	str	String
    // Exception table:
    //   from	to	target	type
    //   359	363	364	java/lang/Exception
    //   187	196	370	java/lang/Exception
    //   383	387	388	java/lang/Exception
    //   187	196	394	finally
    //   401	405	407	java/lang/Exception
    //   198	203	415	finally
    //   205	214	415	finally
    //   216	224	415	finally
    //   226	237	415	finally
    //   239	249	415	finally
    //   251	261	415	finally
    //   263	269	415	finally
    //   271	302	415	finally
    //   304	314	415	finally
    //   316	322	415	finally
    //   324	355	415	finally
    //   375	379	415	finally
    //   198	203	419	java/lang/Exception
    //   205	214	419	java/lang/Exception
    //   216	224	419	java/lang/Exception
    //   226	237	419	java/lang/Exception
    //   239	249	419	java/lang/Exception
    //   251	261	419	java/lang/Exception
    //   263	269	419	java/lang/Exception
    //   271	302	419	java/lang/Exception
    //   304	314	419	java/lang/Exception
    //   316	322	419	java/lang/Exception
    //   324	355	419	java/lang/Exception
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.a.b())
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "Heartbeat.Alive");
      localToServiceMsg.setMsfCommand(MsfCommand._msf_HeartbeatAlive);
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.setAppId(this.F.getMsfAppid());
      localToServiceMsg.putWupBuffer(new byte[] { 0, 0, 0, 4 });
      if (paramBoolean) {
        localToServiceMsg.setTimeout(com.tencent.mobileqq.msf.core.a.a.B());
      }
      for (;;)
      {
        a(localToServiceMsg);
        this.P = com.tencent.mobileqq.msf.core.a.a.H();
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.NetConnTag", 4, "send fast net detect Heartbeat msg ok");
        }
        if ((!paramBoolean) || (com.tencent.mobileqq.msf.core.a.a.P()))
        {
          this.Q = System.currentTimeMillis();
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.NetConnTag", 1, "Update send heartbeat time: " + this.Q);
          }
        }
        this.O.set(true);
        return;
        localToServiceMsg.setTimeout(10000L);
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.NetConnTag", 4, "conn is also closed.not need send heartbeat msg");
    }
    v();
  }
  
  public static boolean b(String paramString)
  {
    return ad.contains(paramString);
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    int i1 = paramArrayOfByte.length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i1 + 4);
    localByteBuffer.putInt(i1 + 4).put(paramArrayOfByte).flip();
    return localByteBuffer.array();
  }
  
  /* Error */
  private void c(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 640	com/tencent/qphone/base/BaseConstants:testServerAddress	Ljava/lang/String;
    //   3: ifnull +90 -> 93
    //   6: getstatic 640	com/tencent/qphone/base/BaseConstants:testServerAddress	Ljava/lang/String;
    //   9: ldc 176
    //   11: invokevirtual 643	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifne +79 -> 93
    //   17: getstatic 640	com/tencent/qphone/base/BaseConstants:testServerAddress	Ljava/lang/String;
    //   20: invokestatic 648	com/tencent/mobileqq/msf/core/d:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/msf/core/d;
    //   23: astore_1
    //   24: aload_1
    //   25: invokevirtual 650	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   28: ifnull +10 -> 38
    //   31: aload_1
    //   32: invokevirtual 652	com/tencent/mobileqq/msf/core/d:d	()I
    //   35: ifgt +19 -> 54
    //   38: invokestatic 388	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   41: ifeq +12 -> 53
    //   44: ldc 69
    //   46: iconst_2
    //   47: ldc_w 654
    //   50: invokestatic 656	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: return
    //   54: aload_0
    //   55: getfield 365	com/tencent/mobileqq/msf/core/af:a	Lcom/tencent/mobileqq/msf/core/net/m;
    //   58: getstatic 640	com/tencent/qphone/base/BaseConstants:testServerAddress	Ljava/lang/String;
    //   61: invokevirtual 658	com/tencent/mobileqq/msf/core/net/m:a	(Ljava/lang/String;)V
    //   64: ldc 69
    //   66: iconst_1
    //   67: new 239	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   74: ldc_w 660
    //   77: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: getstatic 640	com/tencent/qphone/base/BaseConstants:testServerAddress	Ljava/lang/String;
    //   83: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 402	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: return
    //   93: aload_1
    //   94: invokevirtual 491	android/content/Context:getPackageName	()Ljava/lang/String;
    //   97: astore_3
    //   98: new 248	java/io/File
    //   101: dup
    //   102: new 239	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   109: invokestatic 246	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   112: invokevirtual 252	java/io/File:getPath	()Ljava/lang/String;
    //   115: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: ldc_w 662
    //   121: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_3
    //   125: ldc_w 495
    //   128: ldc_w 497
    //   131: invokevirtual 501	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   134: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc_w 664
    //   140: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokespecial 505	java/io/File:<init>	(Ljava/lang/String;)V
    //   149: astore_2
    //   150: aload_2
    //   151: astore_1
    //   152: aload_2
    //   153: invokevirtual 667	java/io/File:canRead	()Z
    //   156: ifne +55 -> 211
    //   159: new 248	java/io/File
    //   162: dup
    //   163: new 239	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   170: invokestatic 246	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   173: invokevirtual 252	java/io/File:getPath	()Ljava/lang/String;
    //   176: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: ldc_w 493
    //   182: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload_3
    //   186: ldc_w 495
    //   189: ldc_w 497
    //   192: invokevirtual 501	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   195: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc_w 664
    //   201: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokespecial 505	java/io/File:<init>	(Ljava/lang/String;)V
    //   210: astore_1
    //   211: invokestatic 388	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   214: ifeq +71 -> 285
    //   217: ldc 69
    //   219: iconst_2
    //   220: new 239	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   227: ldc_w 669
    //   230: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_1
    //   234: invokevirtual 672	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   237: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: ldc_w 674
    //   243: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_1
    //   247: invokevirtual 677	java/io/File:isFile	()Z
    //   250: invokevirtual 680	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   253: ldc_w 682
    //   256: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload_1
    //   260: invokevirtual 667	java/io/File:canRead	()Z
    //   263: invokevirtual 680	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   266: ldc_w 684
    //   269: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload_1
    //   273: invokevirtual 687	java/io/File:length	()J
    //   276: invokevirtual 600	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   279: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 656	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: new 507	java/util/Properties
    //   288: dup
    //   289: invokespecial 508	java/util/Properties:<init>	()V
    //   292: astore 4
    //   294: aload_1
    //   295: invokevirtual 690	java/io/File:exists	()Z
    //   298: ifeq +262 -> 560
    //   301: new 510	java/io/FileInputStream
    //   304: dup
    //   305: aload_1
    //   306: invokespecial 513	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   309: astore_2
    //   310: aload_2
    //   311: astore_1
    //   312: aload 4
    //   314: aload_2
    //   315: invokevirtual 517	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   318: aload_2
    //   319: astore_1
    //   320: aload_2
    //   321: invokevirtual 535	java/io/FileInputStream:close	()V
    //   324: aload_2
    //   325: ifnull +7 -> 332
    //   328: aload_2
    //   329: invokevirtual 535	java/io/FileInputStream:close	()V
    //   332: iconst_0
    //   333: ifeq +11 -> 344
    //   336: new 692	java/lang/NullPointerException
    //   339: dup
    //   340: invokespecial 693	java/lang/NullPointerException:<init>	()V
    //   343: athrow
    //   344: aload 4
    //   346: ldc_w 695
    //   349: invokevirtual 522	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   352: astore_2
    //   353: aload_2
    //   354: ifnull +182 -> 536
    //   357: aload_2
    //   358: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   361: invokevirtual 700	java/lang/String:length	()I
    //   364: ifle +172 -> 536
    //   367: aload_2
    //   368: invokestatic 648	com/tencent/mobileqq/msf/core/d:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/msf/core/d;
    //   371: astore_1
    //   372: aload_1
    //   373: invokevirtual 650	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   376: ifnull -323 -> 53
    //   379: aload_1
    //   380: invokevirtual 652	com/tencent/mobileqq/msf/core/d:d	()I
    //   383: ifle -330 -> 53
    //   386: aload_2
    //   387: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   390: ldc_w 415
    //   393: ldc 176
    //   395: invokevirtual 501	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   398: astore_1
    //   399: aload_0
    //   400: getfield 365	com/tencent/mobileqq/msf/core/af:a	Lcom/tencent/mobileqq/msf/core/net/m;
    //   403: aload_1
    //   404: invokevirtual 658	com/tencent/mobileqq/msf/core/net/m:a	(Ljava/lang/String;)V
    //   407: ldc 69
    //   409: iconst_1
    //   410: new 239	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   417: ldc_w 702
    //   420: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: aload_1
    //   424: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 261	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 402	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: return
    //   434: astore_1
    //   435: aload_1
    //   436: invokevirtual 703	java/io/IOException:printStackTrace	()V
    //   439: goto -107 -> 332
    //   442: astore_1
    //   443: aload_1
    //   444: invokevirtual 703	java/io/IOException:printStackTrace	()V
    //   447: goto -103 -> 344
    //   450: astore_3
    //   451: aconst_null
    //   452: astore_2
    //   453: aload_2
    //   454: astore_1
    //   455: aload_3
    //   456: invokevirtual 538	java/lang/Exception:printStackTrace	()V
    //   459: aload_2
    //   460: ifnull +7 -> 467
    //   463: aload_2
    //   464: invokevirtual 535	java/io/FileInputStream:close	()V
    //   467: iconst_0
    //   468: ifeq -124 -> 344
    //   471: new 692	java/lang/NullPointerException
    //   474: dup
    //   475: invokespecial 693	java/lang/NullPointerException:<init>	()V
    //   478: athrow
    //   479: astore_1
    //   480: aload_1
    //   481: invokevirtual 703	java/io/IOException:printStackTrace	()V
    //   484: goto -140 -> 344
    //   487: astore_1
    //   488: aload_1
    //   489: invokevirtual 703	java/io/IOException:printStackTrace	()V
    //   492: goto -25 -> 467
    //   495: astore_2
    //   496: aconst_null
    //   497: astore_1
    //   498: aload_1
    //   499: ifnull +7 -> 506
    //   502: aload_1
    //   503: invokevirtual 535	java/io/FileInputStream:close	()V
    //   506: iconst_0
    //   507: ifeq +11 -> 518
    //   510: new 692	java/lang/NullPointerException
    //   513: dup
    //   514: invokespecial 693	java/lang/NullPointerException:<init>	()V
    //   517: athrow
    //   518: aload_2
    //   519: athrow
    //   520: astore_1
    //   521: aload_1
    //   522: invokevirtual 703	java/io/IOException:printStackTrace	()V
    //   525: goto -19 -> 506
    //   528: astore_1
    //   529: aload_1
    //   530: invokevirtual 703	java/io/IOException:printStackTrace	()V
    //   533: goto -15 -> 518
    //   536: invokestatic 388	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   539: ifeq -486 -> 53
    //   542: ldc 69
    //   544: iconst_1
    //   545: ldc_w 705
    //   548: invokestatic 402	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   551: return
    //   552: astore_2
    //   553: goto -55 -> 498
    //   556: astore_3
    //   557: goto -104 -> 453
    //   560: aconst_null
    //   561: astore_2
    //   562: goto -238 -> 324
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	565	0	this	af
    //   0	565	1	paramContext	Context
    //   149	315	2	localObject1	Object
    //   495	24	2	localObject2	Object
    //   552	1	2	localObject3	Object
    //   561	1	2	localObject4	Object
    //   97	89	3	str	String
    //   450	6	3	localException1	Exception
    //   556	1	3	localException2	Exception
    //   292	53	4	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   328	332	434	java/io/IOException
    //   336	344	442	java/io/IOException
    //   294	310	450	java/lang/Exception
    //   471	479	479	java/io/IOException
    //   463	467	487	java/io/IOException
    //   294	310	495	finally
    //   502	506	520	java/io/IOException
    //   510	518	528	java/io/IOException
    //   312	318	552	finally
    //   320	324	552	finally
    //   455	459	552	finally
    //   312	318	556	java/lang/Exception
    //   320	324	556	java/lang/Exception
  }
  
  public static void c(String paramString)
  {
    ao = paramString;
  }
  
  public static void d(int paramInt)
  {
    an = paramInt;
  }
  
  public static byte[] f(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      int i2 = com.tencent.mobileqq.msf.core.a.a.be();
      int i1 = i2;
      if (i2 < 1) {
        i1 = 1;
      }
      i2 = (int)(Math.random() * 100.0D);
      if ((paramToServiceMsg.getServiceCmd().equals("MessageSvc.PbGetMsg")) && (i2 % i1 == i1 - 1))
      {
        SSOReserveField.ReserveFields localReserveFields = new SSOReserveField.ReserveFields();
        paramToServiceMsg = (String)paramToServiceMsg.getAttribute("sso_push_timestamp");
        if (paramToServiceMsg != null)
        {
          String[] arrayOfString = paramToServiceMsg.split("\\|");
          String str1 = Build.MODEL.replace('\n', '-');
          i1 = Build.VERSION.SDK_INT;
          String str2 = Build.DISPLAY;
          String str3 = Build.MANUFACTURER;
          if (arrayOfString.length == 3)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("model:" + str1 + ";");
            localStringBuilder.append("os:" + i1 + ";");
            localStringBuilder.append("version:v2");
            if (com.tencent.mobileqq.msf.core.a.a.bk())
            {
              localStringBuilder.append("man:" + str3);
              localStringBuilder.append("sys:" + str2);
            }
            localReserveFields.sso_send.set(Long.parseLong(arrayOfString[0]));
            localReserveFields.sdk_recv.set(Long.parseLong(arrayOfString[1]));
            localReserveFields.app_recv.set(Long.parseLong(arrayOfString[2]));
            localReserveFields.sdk_send.set(System.currentTimeMillis());
            localReserveFields.type.set(y);
            localReserveFields.extra.set(localStringBuilder.toString());
          }
          QLog.d("MSF.C.NetConnTag", 1, "msf get timestamp:" + paramToServiceMsg + ", length:" + arrayOfString.length + ", model:" + str1 + ", type:" + y);
          paramToServiceMsg = localReserveFields.toByteArray();
          return paramToServiceMsg;
        }
      }
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.d("MSF.C.NetConnTag", 1, "failed to construct reserve field", paramToServiceMsg);
    }
    return null;
  }
  
  public static void g()
  {
    Iterator localIterator = ad.iterator();
    while (localIterator.hasNext()) {
      CodecWarpper.nativeSetUseSimpleHead((String)localIterator.next(), false);
    }
    ad.clear();
  }
  
  private int h(ToServiceMsg paramToServiceMsg)
  {
    Object localObject1;
    long l1;
    if (paramToServiceMsg.isNeedCallback())
    {
      this.c.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), paramToServiceMsg);
      paramToServiceMsg.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(aj.incrementAndGet()));
      if (paramToServiceMsg.getTimeout() == -1L)
      {
        paramToServiceMsg.setTimeout(30000L);
        localObject1 = this.F.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
        if (("LongConn.OffPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd()))) {
          QLog.d("MSF.C.NetConnTag", 1, "Sender PicUpMsg timer start, appSeq: " + paramToServiceMsg.getAppSeq() + ", delayMillis: " + paramToServiceMsg.getTimeout());
        }
        paramToServiceMsg.addAttribute("to_timeoutCallbacker", localObject1);
        if (com.tencent.mobileqq.msf.core.a.a.x())
        {
          l1 = paramToServiceMsg.getTimeout() - com.tencent.mobileqq.msf.core.a.a.z();
          if (l1 > 0L) {
            paramToServiceMsg.addAttribute("to_predetect_timeoutCallbacker", this.F.msfAlarmer.b(paramToServiceMsg, l1));
          }
        }
        if ((com.tencent.mobileqq.msf.core.a.a.Z()) && (this.F.quicksender != null) && (this.F.quicksender.b(paramToServiceMsg)))
        {
          QLog.d("MSF.C.NetConnTag", 1, "add quick send timeout check " + paramToServiceMsg.getRequestSsoSeq());
          if ((this.a.b()) && (this.a.o() != null) && (this.a.o().B != null)) {
            paramToServiceMsg.getAttributes().put("connIDC", this.a.o().B.k);
          }
          this.F.quicksender.c(paramToServiceMsg);
        }
      }
    }
    for (;;)
    {
      try
      {
        this.F.quicksender.f.a(paramToServiceMsg);
        if (this.f.offer(paramToServiceMsg)) {
          break label613;
        }
        QLog.d("MSF.C.NetConnTag", 1, "error, add " + paramToServiceMsg + " to send queue is full! size: " + this.f.size());
        if (paramToServiceMsg.getServiceCmd().equals("SSO.LoginMerge")) {
          break label528;
        }
        localObject1 = t.a(paramToServiceMsg);
        ((FromServiceMsg)localObject1).setBusinessFail(1008, "send queue is full!");
        this.F.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject1);
        if ((!U.get()) && (h.b))
        {
          U.set(true);
          T = paramToServiceMsg.getRequestSsoSeq();
        }
        return paramToServiceMsg.getRequestSsoSeq();
        localObject1 = this.F.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        continue;
      }
      if (paramToServiceMsg.getServiceCmd().equals("SSO.LoginMerge"))
      {
        this.F.msfAlarmer.a(paramToServiceMsg.getRequestSsoSeq(), 30000L);
        continue;
        label528:
        Object localObject2 = (ArrayList)this.e.remove(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
        if (localObject2 != null)
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            ToServiceMsg localToServiceMsg = (ToServiceMsg)((Iterator)localObject2).next();
            FromServiceMsg localFromServiceMsg = t.a(localToServiceMsg);
            localFromServiceMsg.setBusinessFail(1008, "send queue is full!");
            this.F.addRespToQuque(localToServiceMsg, localFromServiceMsg);
          }
          continue;
          label613:
          this.aw += 1L;
          this.e.remove(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.NetConnTag", 4, "add " + paramToServiceMsg + " to sendQueue(" + this.f.size() + ")");
          }
          l1 = SystemClock.elapsedRealtime();
          if (l1 - this.at >= 300000L)
          {
            this.at = l1;
            if (QLog.isColorLevel()) {
              w();
            }
          }
        }
      }
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg.getUin().equals("0")) {}
    int i1;
    do
    {
      return;
      int i2 = 0;
      i1 = i2;
      if (!this.V.contains(paramToServiceMsg.getUin()))
      {
        this.ay += 1L;
        if (this.ay >= 2L)
        {
          i1 = i2;
          if (this.az.nextInt(20) >= 2) {}
        }
        else
        {
          i1 = 1;
        }
      }
    } while (i1 == 0);
    a(paramToServiceMsg.getAppId(), paramToServiceMsg.getUin());
  }
  
  public static int m()
  {
    return an;
  }
  
  public static String n()
  {
    return ao;
  }
  
  private void t()
  {
    this.ag.add("StatSvc.register");
    this.ag.add("PushService.register");
    this.ag.add("RegPrxySvc.info");
    this.ag.add("RegPrxySvc.infoNew");
    this.ag.add("RegPrxySvc.infoAndroid");
    this.ag.add("RegPrxySvc.infoLogin");
    this.ag.add("RegPrxySvc.infoSync");
    this.ag.add("im_status.stat_reg");
    this.ag.add("SSO.LoginMerge");
  }
  
  private void u()
  {
    if (this.a.b())
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "Heartbeat.Alive");
      localToServiceMsg.setMsfCommand(MsfCommand._msf_HeartbeatAlive);
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.setAppId(this.F.getMsfAppid());
      localToServiceMsg.putWupBuffer(new byte[] { 0, 0, 0, 4 });
      localToServiceMsg.setTimeout(com.tencent.mobileqq.msf.core.a.a.z());
      a(localToServiceMsg);
      this.P += 1;
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.NetConnTag", 4, "send Heartbeat msg ok");
      }
      this.Q = System.currentTimeMillis();
      this.O.set(true);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.NetConnTag", 4, "conn is also closed.not need send heartbeat msg");
    }
    v();
  }
  
  private void v()
  {
    this.P = 0;
    this.O.set(false);
  }
  
  private void w()
  {
    boolean bool2 = false;
    try
    {
      for (ThreadGroup localThreadGroup = Thread.currentThread().getThreadGroup(); localThreadGroup.getParent() != null; localThreadGroup = localThreadGroup.getParent()) {}
      Thread[] arrayOfThread = new Thread[localThreadGroup.activeCount()];
      localThreadGroup.enumerate(arrayOfThread);
      int i2 = this.f.size();
      int i3 = arrayOfThread.length;
      int i1 = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i1 < i3)
        {
          localThreadGroup = arrayOfThread[i1];
          if ((localThreadGroup != null) && ("MsfCoreMsgSender".equals(localThreadGroup.getName()))) {
            bool1 = true;
          }
        }
        else
        {
          QLog.d("MSF.C.NetConnTag", 1, "sender alive:" + bool1 + " size: " + i2);
          return;
        }
        i1 += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.NetConnTag", 1, "printCurrentThreads error", localException);
    }
  }
  
  public int a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg.getRequestSsoSeq() == -1) {
      paramToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
    }
    paramToServiceMsg.addAttribute("__timestamp_addSendQueue", Long.valueOf(System.currentTimeMillis()));
    Runnable localRunnable;
    if (paramToServiceMsg.isNeedCallback())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "add " + paramToServiceMsg + " to send");
      }
      this.c.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), paramToServiceMsg);
      paramToServiceMsg.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(aj.incrementAndGet()));
      if (paramToServiceMsg.getTimeout() != -1L) {
        break label175;
      }
      paramToServiceMsg.setTimeout(30000L);
      localRunnable = this.F.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
    }
    for (;;)
    {
      paramToServiceMsg.addAttribute("to_timeoutCallbacker", localRunnable);
      try
      {
        this.f.addFirst(paramToServiceMsg);
        this.aw += 1L;
        return paramToServiceMsg.getRequestSsoSeq();
        label175:
        localRunnable = this.F.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("MSF.C.NetConnTag", 1, "inset heartbeatMsg error. " + localException, localException);
        }
      }
    }
  }
  
  public long a()
  {
    return this.av;
  }
  
  public Runnable a(int paramInt)
  {
    long l1 = com.tencent.mobileqq.msf.core.a.a.A();
    if (l1 > 0L) {
      return this.F.msfAlarmer.b(paramInt, l1);
    }
    b(paramInt);
    return null;
  }
  
  public void a(int paramInt, String paramString)
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setRequestId(MsfCore.getNextSeq());
    localUniPacket.setServantName("KQQ.ConfigService.ConfigServantObj");
    localUniPacket.setFuncName("ClientReq");
    Object localObject = new com.tencent.msf.service.protocol.e.c();
    ((com.tencent.msf.service.protocol.e.c)localObject).a = paramInt;
    ((com.tencent.msf.service.protocol.e.c)localObject).b = paramString;
    localUniPacket.put("req", localObject);
    localObject = new ToServiceMsg("", paramString, "GrayUinPro.Check");
    ((ToServiceMsg)localObject).setAppId(paramInt);
    ((ToServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
    ((ToServiceMsg)localObject).putWupBuffer(localUniPacket.encode());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).setMsfCommand(MsfCommand.checkRole);
    b((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "role send gray check for " + paramString + " use " + paramInt + " to:" + localObject);
    }
  }
  
  public void a(com.tencent.qphone.base.a parama)
  {
    this.a.a(parama);
  }
  
  public void a(FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.getResultCode() == 1000) {
      this.V.add(paramFromServiceMsg.getUin());
    }
    label372:
    for (;;)
    {
      try
      {
        Object localObject1 = paramFromServiceMsg.getWupBuffer();
        if ((localObject1.length <= 4) || (localObject1[0] != 0) || (localObject1[1] != 0) || (localObject1[2] != 0) || (localObject1[3] != 4)) {
          break label372;
        }
        Object localObject2 = new byte[localObject1.length - 4];
        System.arraycopy(localObject1, 4, localObject2, 0, localObject2.length);
        localObject1 = localObject2;
        QLog.d("MSF.C.NetConnTag", 1, "recv buf:" + HexUtil.bytes2HexStr((byte[])localObject1));
        localObject2 = new UniPacket();
        ((UniPacket)localObject2).decode((byte[])localObject1);
        localObject1 = (com.tencent.msf.service.protocol.e.d)((UniPacket)localObject2).getByClass("res", new com.tencent.msf.service.protocol.e.d());
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.NetConnTag", 4, "role received gray resp uin:" + paramFromServiceMsg.getUin() + " appid:" + paramFromServiceMsg.getAppId() + " status:" + ((com.tencent.msf.service.protocol.e.d)localObject1).a + " yyb:" + ((com.tencent.msf.service.protocol.e.d)localObject1).b + " msg:" + HexUtil.bytes2HexStr(((com.tencent.msf.service.protocol.e.d)localObject1).c));
        }
        if (((com.tencent.msf.service.protocol.e.d)localObject1).a == 1)
        {
          this.F.getSsoRespHandler();
          ag.a.put(paramFromServiceMsg.getUin(), localObject1);
          QLog.d("MSF.C.NetConnTag", 1, Thread.currentThread().getName() + " onRecvCheckRoleResp setAccountNoLogin uin=" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()));
          this.F.getAccountCenter().k(paramFromServiceMsg.getUin());
          return;
        }
        ag.a.remove(paramFromServiceMsg.getUin());
        return;
      }
      catch (ObjectCreateException paramFromServiceMsg)
      {
        if (!QLog.isDevelopLevel()) {
          break;
        }
      }
      QLog.d("MSF.C.NetConnTag", 4, "role gray check error", paramFromServiceMsg);
      return;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("MSF.C.NetConnTag", 4, "role gray check fail " + paramFromServiceMsg);
      return;
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    if (paramFromServiceMsg.getBusinessFailCode() == 1002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "handleHeartbeat wait " + paramToServiceMsg + " timeout.");
      }
      if (!this.a.b())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "conn is also closed.");
        }
        v();
      }
      do
      {
        return;
        if (this.P < com.tencent.mobileqq.msf.core.a.a.H()) {
          break;
        }
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "Heartbeat continueTimeoutCount is " + this.P + ",closeConn closeByNetDetectFailed");
          }
          this.F.sender.a.a(com.tencent.qphone.base.a.p);
          v();
          return;
        }
        catch (Exception paramFromServiceMsg) {}
      } while (!QLog.isColorLevel());
      QLog.d("MSF.C.NetConnTag", 2, paramFromServiceMsg.toString(), paramFromServiceMsg);
      return;
      long l1 = System.currentTimeMillis();
      if (l1 - this.Q > com.tencent.mobileqq.msf.core.a.a.H() * com.tencent.mobileqq.msf.core.a.a.z())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "timenow - firstSendHeartBeatTime is " + (l1 - this.Q) + ",closeConn continueWaitRspTimeout");
        }
        this.F.sender.a.a(com.tencent.qphone.base.a.e);
        v();
        return;
      }
      u();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "recv heart resp.now conn is alive.");
    }
    v();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    paramToServiceMsg.getAttributes().put("_attr_regprxy_socket_hashcode", new Integer(paramInt));
    this.ah = paramToServiceMsg;
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      this.F.msfAlarmer.b(paramRunnable);
    }
  }
  
  public void a(String paramString)
  {
    CodecWarpper.nativeRemoveAccountKey(paramString);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (-1L == v) {
      v = System.currentTimeMillis();
    }
    String str2 = com.tencent.mobileqq.msf.core.a.d.c();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "unknown";
    }
    int i1;
    if (u.containsKey(str1))
    {
      i1 = ((Integer)u.get(str1)).intValue();
      if (i1 < com.tencent.mobileqq.msf.core.a.a.aY())
      {
        u.remove(str1);
        u.put(str1, Integer.valueOf(i1 + 1));
        i1 = 1;
      }
    }
    for (;;)
    {
      if (i1 != 0) {
        new d(paramString, str1, paramLong).run();
      }
      return;
      QLog.d("MSF.C.NetConnTag", 1, "single ssid " + str1 + " record times limited in " + i1);
      i1 = 0;
      continue;
      u.put(str1, Integer.valueOf(1));
      i1 = 1;
    }
  }
  
  public void a(HashMap paramHashMap)
  {
    this.ae.add(paramHashMap);
    this.af = true;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "add waitReportData " + this.ae.size());
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.ax = paramArrayOfByte;
  }
  
  public void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      int i2 = paramArrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = paramArrayOfString[i1];
        this.aq.add(str);
        i1 += 1;
      }
    }
    this.aq.add("GrayUinPro.Check");
    this.aq.add("StatSvc.register");
    this.aq.add("StatSvc.get");
    this.aq.add("RegPrxySvc.infoLogin");
    this.aq.add("RegPrxySvc.infoSync");
    this.aq.add("wtlogin.login");
    this.aq.add("RegPrxySvc.getOffMsg");
    this.aq.add("login.auth");
    this.aq.add("wtlogin.exchange");
    this.aq.add("wtlogin.trans_emp");
    this.aq.add("MessageSvc.PbSendMsg");
    this.aq.add("LongConn.OffPicUp");
    this.aq.add("LongConn.OffPicDown");
    this.aq.add("ImgStore.GroupPicUp");
    this.aq.add("ImgStore.GroupPicDown");
    this.aq.add("StreamSvr.UploadStreamMsg");
    this.aq.add("StreamSvr.RespUploadStreamMsg");
    this.aq.add("StreamSvr.PushStreamMsg");
    this.aq.add("StreamSvr.RespPushStreamMsg");
    this.aq.add("OidbSvc.0x787_1");
    this.aq.add("OidbSvc.0x49d_107");
    this.aq.add("MultiMsg.ApplyUp");
    this.aq.add("MultiMsg.ApplyDown");
    this.aq.add("PttCenterSvr.ShortVideoUpReq");
    this.aq.add("PttCenterSvr.ShortVideoDownReq");
    this.aq.add("ImgStore.GroupPicUp#pttGu");
    this.aq.add("ImgStore.GroupPicDown#pttGd");
    this.aq.add("PttStore.GroupPttUp");
    this.aq.add("PttStore.GroupPttDown");
    this.aq.add("Heartbeat.Alive");
    this.aq.add("friendlist.getFriendGroupList");
    this.aq.add("VideoSvc.Send");
    this.aq.add("VideoSvc.Ack");
    this.aq.add("SharpSvr.c2s");
    this.aq.add("SharpSvr.c2sack");
    this.aq.add("SharpSvr.s2c");
    this.aq.add("SharpSvr.s2cack");
    this.aq.add("MultiVideo.c2s");
    this.aq.add("MultiVideo.c2sack");
    this.aq.add("MultiVideo.s2c");
    this.aq.add("MultiVideo.s2cack");
    this.aq.add("MessageSvc.PbGetMsg");
    this.aq.add("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200");
    this.aq.add("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500");
    this.aq.add("OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_APPLY_DOWNLOAD-1200");
    this.aq.add("cmd_openConn");
    this.aq.add("wtlogin.exchange_emp");
    this.aq.add("wtlogin.name2uin");
    this.aq.add("Client.CorrectTime");
    this.aq.add("StatSvc.RspMSFForceOffline");
  }
  
  public boolean a(Context paramContext)
  {
    try
    {
      if (com.tencent.mobileqq.msf.core.a.a.aH())
      {
        this.J = new com.tencent.mobileqq.msf.core.net.a.f(this.F, paramContext);
        s = true;
      }
      QLog.d("MSF.C.NetConnTag", 1, "noTry loadTestServerConfig by release");
      t();
    }
    catch (Throwable localThrowable)
    {
      try
      {
        this.E.init(paramContext, false);
        CodecWarpper.nativeSetKsid(this.F.getAccountCenter().f());
        this.L.start();
        h.a(paramContext, true);
        return true;
        localThrowable = localThrowable;
        QLog.d("MSF.C.NetConnTag", 1, "init socketAdaptorfactory failed", localThrowable);
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        for (;;)
        {
          com.tencent.mobileqq.msf.core.c.j.a("codecwrapperV2", CodecWarpper.isLoaded, CodecWarpper.soLoadResultCode, localUnsatisfiedLinkError.getMessage());
        }
      }
    }
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return false;
    }
    if (paramToServiceMsg.getMsfCommand() == MsfCommand.msf_ssoping)
    {
      this.F.sender.a.o().g();
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, Thread.currentThread().getName() + " onFoundTimeoutMsg closeConn closeBySSOPingTimeout");
      }
      this.F.sender.a.a(com.tencent.qphone.base.a.B);
      return false;
    }
    if (paramToServiceMsg.getMsfCommand() == MsfCommand.msf_oshello)
    {
      QLog.d("MSF.C.NetConnTag", 1, "cannot get os hello response");
      return false;
    }
    if ((paramToServiceMsg != null) && (paramToServiceMsg.isNeedRemindSlowNetwork())) {
      com.tencent.mobileqq.msf.core.net.j.a(j.b.a);
    }
    paramToServiceMsg.addAttribute("_tag_socket_connerror", m.H);
    paramFromServiceMsg.addAttribute("_tag_socket_connerror", m.H);
    if (paramToServiceMsg.getAttributes().containsKey("_tag_socket")) {
      paramFromServiceMsg.addAttribute("_tag_socket", paramToServiceMsg.getAttribute("_tag_socket"));
    }
    if ((s) && (com.tencent.mobileqq.msf.core.net.a.f.a())) {}
    long l1;
    long l2;
    try
    {
      this.J.b().a(paramToServiceMsg.getRequestSsoSeq(), true);
      if (paramToServiceMsg.getAttributes().containsKey("__timestamp_msf2net"))
      {
        l1 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
        l3 = System.currentTimeMillis();
        if (paramToServiceMsg.getAttributes().containsKey("__timestamp_addSendQueue")) {
          l2 = ((Long)paramToServiceMsg.getAttribute("__timestamp_addSendQueue")).longValue();
        }
      }
    }
    catch (Exception localException2)
    {
      try
      {
        label266:
        if ((paramToServiceMsg.getServiceCmd().equals("MessageSvc.PbGetMsg")) && (this.F.statReporter != null)) {
          this.F.statReporter.a("dim.Msf.PushSendFail", false, 0L, 0L, null, false, false);
        }
      }
      catch (Exception localException2)
      {
        try
        {
          while (paramToServiceMsg.getServiceCmd() == com.tencent.mobileqq.msf.core.push.d.k)
          {
            long l4 = ((Long)paramToServiceMsg.getAttribute("_attr_alarm_elapsed_time", Long.valueOf(0L))).longValue();
            if ((com.tencent.mobileqq.msf.core.a.a.u) && (l4 > com.tencent.mobileqq.msf.core.a.a.bm()) && (l2 >= this.a.o().d()))
            {
              String str = paramToServiceMsg.getUin();
              if (str != null) {
                if ((!com.tencent.mobileqq.msf.core.a.a.v) || (Long.parseLong(str) % 2L == 0L))
                {
                  QLog.d("MSF.C.NetConnTag", 1, "try close conn by wakeup alarm exceeded and detect timeout:" + l4);
                  this.F.sender.a.a(com.tencent.qphone.base.a.E);
                  if (this.F.getStatReporter() != null) {
                    this.F.getStatReporter().a("3", str, true, 0L);
                  }
                  return false;
                  localException1 = localException1;
                  QLog.d("MSF.C.NetConnTag", 1, "adaptor recv timeout failed", localException1);
                  continue;
                  localException2 = localException2;
                  QLog.d("MSF.C.NetConnTag", 1, "", localException2);
                }
                else
                {
                  this.F.pushManager.D = SystemClock.elapsedRealtime();
                  QLog.d("MSF.C.NetConnTag", 1, "wakeup alarm exceeded and detect timeout, but not close conn");
                }
              }
            }
          }
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            long l3;
            QLog.d("MSF.C.NetConnTag", 1, "SimpleGet timeout error!", localException3);
          }
        }
        if ((l2 != 0L) && (l3 - l2 > paramToServiceMsg.getTimeout()) && (l3 - l2 > this.F.pushManager.e()) && (paramToServiceMsg.getTimeout() < this.F.pushManager.e()))
        {
          if (l2 >= this.a.o().d())
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.NetConnTag", 2, "xiaomi 2s: " + paramToServiceMsg.getRequestSsoSeq() + " msg timeout , addtoqueueTime is " + (l3 - l2) + ",try close conn");
            }
            this.F.sender.a.a(com.tencent.qphone.base.a.q);
            v();
            return true;
          }
          return true;
        }
        if ((l1 == 0L) || (l1 > this.a.o().d()))
        {
          if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_HeartbeatAlive)
          {
            QLog.d("MSF.C.NetConnTag", 1, "found timeout heartalive msg " + paramToServiceMsg.getRequestSsoSeq());
            a(paramFromServiceMsg, paramToServiceMsg);
            return false;
          }
          if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_QuickHeartBeat)
          {
            QLog.d("MSF.C.NetConnTag", 1, "found timeout quickheartbeat msg " + paramToServiceMsg.getRequestSsoSeq());
            this.F.quicksender.a(paramToServiceMsg, paramFromServiceMsg, false);
            return false;
          }
          try
          {
            if ((this.O.get()) && (System.currentTimeMillis() - this.Q < com.tencent.mobileqq.msf.core.a.a.N() + 120000)) {
              break label1016;
            }
            l1 = System.currentTimeMillis();
            if (l1 - this.Q <= com.tencent.mobileqq.msf.core.a.a.N()) {
              break label961;
            }
            if (paramToServiceMsg.getRequestSsoSeq() == T)
            {
              T = -1;
              QLog.d("MSF.C.NetConnTag", 1, "found first msg screen on timeout try close conn " + paramToServiceMsg);
              this.F.sender.a.a(com.tencent.qphone.base.a.t);
              v();
              return true;
            }
          }
          finally {}
          if (com.tencent.mobileqq.msf.core.a.a.bn()) {
            u();
          }
        }
        for (;;)
        {
          if (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_HeartbeatAlive) {
            break label1095;
          }
          return false;
          label961:
          QLog.d("MSF.C.NetConnTag", 1, "found timeout msg check time: timenow = " + l1 + " firstSendHeartBeatTime = " + this.Q + " ConfigManager.getHeartBeatTimeInterval() = " + com.tencent.mobileqq.msf.core.a.a.N());
          break;
          label1016:
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MSF.C.NetConnTag", 2, "sendingHeartBeat: " + this.O + "net detect has started, no need sendHeartbeat");
          break;
          QLog.d("MSF.C.NetConnTag", 1, "found timeout msg " + paramToServiceMsg + " before connSucc.");
        }
        label1095:
        if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_QuickHeartBeat)
        {
          this.F.quicksender.a(paramToServiceMsg, paramFromServiceMsg, true);
          return false;
        }
      }
    }
    for (;;)
    {
      int i1;
      try
      {
        if (!this.a.b()) {
          break label1451;
        }
        int i3 = 1;
        paramFromServiceMsg = ap;
        int i4 = paramFromServiceMsg.length;
        i1 = 0;
        int i2 = i3;
        if (i1 < i4)
        {
          CharSequence localCharSequence = paramFromServiceMsg[i1];
          if ((TextUtils.isEmpty(localCharSequence)) || (paramToServiceMsg == null) || (!localCharSequence.equals(paramToServiceMsg.getServiceCmd()))) {
            break label1453;
          }
          i2 = 0;
        }
        if (i2 == 0) {
          break label1451;
        }
        if (!D.contains(paramToServiceMsg.getServiceCmd())) {
          D.add(paramToServiceMsg.getServiceCmd());
        }
        if (C.incrementAndGet() < com.tencent.mobileqq.msf.core.a.a.I()) {
          break label1451;
        }
        if (D.size() > 2)
        {
          QLog.d("MSF.C.NetConnTag", 1, "Continue wait resp for bus packets ,try close conn");
          C.set(0);
          D.clear();
          this.F.sender.a.a(com.tencent.qphone.base.a.e);
          v();
        }
        else if (QLog.isColorLevel())
        {
          paramToServiceMsg = (String)D.get(0);
          QLog.d("MSF.C.NetConnTag", 1, "Continue wait resp timeout by single cmd:" + paramToServiceMsg);
          C.set(0);
          D.clear();
          paramToServiceMsg = new HashMap();
          paramToServiceMsg.put("event_cmd", D.get(0));
          if (this.F.getStatReporter() == null) {
            break label1451;
          }
          this.F.getStatReporter().a("dim.Msf.SingleCmdTimeout", false, 0L, 0L, paramToServiceMsg, false, false);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.d("MSF.C.NetConnTag", 1, " Continue wait resp for bus packets ,try close conn failed: " + paramToServiceMsg);
      }
      paramToServiceMsg = com.tencent.mobileqq.msf.core.b.c.a((String)D.get(0));
      continue;
      l2 = 0L;
      break label266;
      l1 = 0L;
      break;
      label1451:
      return true;
      label1453:
      i1 += 1;
    }
  }
  
  public int b(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return -1;
    }
    if (this.F.isSuspended())
    {
      QLog.d("MSF.C.NetConnTag", 1, "handleSsoFailCode, msfcore suspent");
      ??? = t.a(paramToServiceMsg);
      ((FromServiceMsg)???).setBusinessFail(2009, "MSF is suspeded.");
      this.F.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
      return paramToServiceMsg.getRequestSsoSeq();
    }
    if ((paramToServiceMsg.getWupBuffer() != null) && (paramToServiceMsg.getWupBuffer().length > 103424))
    {
      ??? = t.a(paramToServiceMsg);
      ((FromServiceMsg)???).setBusinessFail(2019, "check the wupbuf size in range[0, 101kb]");
      this.F.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
      return paramToServiceMsg.getRequestSsoSeq();
    }
    Object localObject2;
    String str;
    int i1;
    if (this.F.configManager.L != null)
    {
      Iterator localIterator = this.F.configManager.L.iterator();
      ??? = null;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject2 = (a.a)localIterator.next();
          if (((a.a)localObject2).a + ((a.a)localObject2).b.b < System.currentTimeMillis() / 1000L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.NetConnTag", 2, "OverloadPushNotify item expired sCmd = " + ((a.a)localObject2).c);
            }
            this.F.configManager.L.remove(localObject2);
            ??? = localObject2;
          }
          else
          {
            str = paramToServiceMsg.getServiceCmd();
            if (((a.a)localObject2).c.charAt(((a.a)localObject2).c.length() - 1) == '*')
            {
              ??? = localObject2;
              if (!str.startsWith(((a.a)localObject2).c.substring(0, ((a.a)localObject2).c.length() - 1))) {
                continue;
              }
              if (!QLog.isColorLevel()) {
                break label1936;
              }
              QLog.d("MSF.C.NetConnTag", 2, "OverloadPushNotify item matched strServiceCmd = " + str + " sCmd:" + ((a.a)localObject2).c);
              i1 = 1;
              ??? = localObject2;
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((i1 != 0) && (??? != null))
      {
        if (((a.a)???).b.e == 1)
        {
          localObject2 = new FromServiceMsg();
          ((FromServiceMsg)localObject2).setUin("0");
          ((FromServiceMsg)localObject2).setServiceCmd("OverLoadPush.notify");
          ((FromServiceMsg)localObject2).setMsfCommand(MsfCommand.onOverloadPushNotify);
          ((FromServiceMsg)localObject2).setAppId(this.F.getMsfAppid());
          ((FromServiceMsg)localObject2).setMsgSuccess();
          ((FromServiceMsg)localObject2).setRequestSsoSeq(MsfCore.getNextSeq());
          MsfSdkUtils.addFromMsgProcessName("*", (FromServiceMsg)localObject2);
          ((FromServiceMsg)localObject2).getAttributes().put("msg", new String(((a.a)???).b.d));
          this.F.addRespToQuque(null, (FromServiceMsg)localObject2);
          ((a.a)???).b.e = 0;
        }
        localObject2 = t.a(paramToServiceMsg);
        ((FromServiceMsg)localObject2).setBusinessFail(((a.a)???).b.c, new String(((a.a)???).b.d));
        this.F.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "OverloadPushNotify server overload block tomsg: " + paramToServiceMsg + " frommsg: " + localObject2);
        }
        return paramToServiceMsg.getRequestSsoSeq();
        ??? = localObject2;
        if (!((a.a)localObject2).c.equals(str)) {
          break;
        }
        if (!QLog.isColorLevel()) {
          break label1936;
        }
        QLog.d("MSF.C.NetConnTag", 2, "OverloadPushNotify item matched strServiceCmd = " + str + " sCmd:" + ((a.a)localObject2).c);
        i1 = 1;
        ??? = localObject2;
        continue;
      }
      if ((paramToServiceMsg.getAppId() <= 0) && (paramToServiceMsg.getMsfCommand() != MsfCommand.openConn) && ((TextUtils.isEmpty(paramToServiceMsg.getServiceCmd())) || (!paramToServiceMsg.getServiceCmd().startsWith("wtlogin."))))
      {
        ??? = t.a(paramToServiceMsg);
        ((FromServiceMsg)???).setBusinessFail(1007, "msg appid is " + paramToServiceMsg.getAppId());
        this.F.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
        return paramToServiceMsg.getRequestSsoSeq();
      }
      if (aA.get())
      {
        ??? = t.a(paramToServiceMsg);
        ((FromServiceMsg)???).setBusinessFail(2014, "error");
        this.F.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
        return paramToServiceMsg.getRequestSsoSeq();
      }
      localObject2 = (com.tencent.msf.service.protocol.e.d)ag.a.get(paramToServiceMsg.getUin());
      ??? = localObject2;
      if (localObject2 != null)
      {
        ??? = localObject2;
        if (paramToServiceMsg.getServiceCmd().equals("wtlogin.login"))
        {
          this.V.remove(paramToServiceMsg.getUin());
          ag.a.remove(paramToServiceMsg.getUin());
          ??? = null;
        }
      }
      if ((??? != null) && (!paramToServiceMsg.getServiceCmd().startsWith("login.")) && (!paramToServiceMsg.getServiceCmd().startsWith("wtlogin.login")) && (!paramToServiceMsg.getServiceCmd().equals("GrayUinPro.Check")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "error, " + paramToServiceMsg.getUin() + " not in gray list");
        }
        localObject2 = t.a(paramToServiceMsg);
        try
        {
          ((FromServiceMsg)localObject2).setBusinessFail(2008, new String(((com.tencent.msf.service.protocol.e.d)???).c, "UTF-8"));
          ((FromServiceMsg)localObject2).addAttribute(((FromServiceMsg)localObject2).getServiceCmd(), String.valueOf(((com.tencent.msf.service.protocol.e.d)???).b));
          this.F.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject2);
          if (this.F.getAccountCenter().g(((FromServiceMsg)localObject2).getUin()))
          {
            QLog.d("MSF.C.NetConnTag", 1, Thread.currentThread().getName() + " addSendQueue setAccountNoLogin uin=" + MsfSdkUtils.getShortUin(((FromServiceMsg)localObject2).getUin()));
            this.F.getAccountCenter().k(((FromServiceMsg)localObject2).getUin());
          }
          return paramToServiceMsg.getRequestSsoSeq();
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ((FromServiceMsg)localObject2).setBusinessFail(2008, paramToServiceMsg.getUin() + " not in gray list");
          }
        }
      }
      if ((this.F.standbyModeManager != null) && (this.F.standbyModeManager.b()))
      {
        if (!this.F.standbyModeManager.a(paramToServiceMsg.getServiceCmd()))
        {
          QLog.d("MSF.C.NetConnTag", 1, "refuse to send request cmd: " + paramToServiceMsg.getServiceCmd() + " ssoseq: " + paramToServiceMsg.getRequestSsoSeq() + " by standbyMode");
          this.F.getStandyModeManager().a(paramToServiceMsg);
          ??? = t.a(paramToServiceMsg);
          ((FromServiceMsg)???).setBusinessFail(2018, "standby mode force stop request");
          this.F.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
          if (!this.a.b())
          {
            ??? = MsfMsgUtil.getConnOpenMsg("");
            MsfSdkUtils.addToMsgProcessName("", (ToServiceMsg)???);
            this.F.sendSsoMsg((ToServiceMsg)???);
          }
          return paramToServiceMsg.getRequestSsoSeq();
        }
        this.F.getStandyModeManager().b(paramToServiceMsg);
      }
      CodecWarpper.getFileStoreKey();
      ??? = this.F.getAccountCenter().i(paramToServiceMsg.getUin());
      if (??? != null) {
        paramToServiceMsg.setUin((String)???);
      }
      if ((!paramToServiceMsg.getUin().equals("0")) && (!this.am.equals(paramToServiceMsg.getUin())))
      {
        this.am = paramToServiceMsg.getUin();
        if (this.F.statReporter != null) {
          this.F.statReporter.a(this.am);
        }
        if (this.al != paramToServiceMsg.getAppId()) {
          this.al = paramToServiceMsg.getAppId();
        }
        if (paramToServiceMsg.getRequestSsoSeq() == -1) {
          paramToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
        }
        if (!paramToServiceMsg.getAttributes().containsKey("__timestamp_app2msf")) {
          paramToServiceMsg.addAttribute("__timestamp_app2msf", Long.valueOf(System.currentTimeMillis()));
        }
        paramToServiceMsg.addAttribute("__timestamp_addSendQueue", Long.valueOf(System.currentTimeMillis()));
        if ((!this.p) && (this.q))
        {
          this.o = SystemClock.elapsedRealtime();
          this.p = true;
        }
        if (((paramToServiceMsg.getServiceCmd().equals("StatSvc.register")) || (paramToServiceMsg.getServiceCmd().equals("StatSvc.get"))) && (paramToServiceMsg.getMsfCommand().equals(MsfCommand._msf_RegPush)) && (this.q))
        {
          this.o = SystemClock.elapsedRealtime();
          this.p = true;
          ??? = com.tencent.mobileqq.msf.core.a.a.d();
          if ((??? == null) || (this.aq.size() == ???.length)) {
            break label1654;
          }
          a((String[])???);
        }
      }
      for (;;)
      {
        if ((this.q) && (SystemClock.elapsedRealtime() - this.o < this.m))
        {
          if (this.aq.size() == 0) {
            a(null);
          }
          if ((this.aq.contains(paramToServiceMsg.getServiceCmd())) || ((!TextUtils.isEmpty(paramToServiceMsg.getServiceCmd())) && (paramToServiceMsg.getServiceCmd().startsWith("wtlogin."))))
          {
            return h(paramToServiceMsg);
            if ((!paramToServiceMsg.getUin().equals("0")) || (paramToServiceMsg.getAttributes().containsKey("__base_tag_isAppMsg")) || (paramToServiceMsg.getServiceCmd().equals("PhSigLcId.Check"))) {
              break;
            }
            paramToServiceMsg.setUin(i());
            break;
            label1654:
            if (??? != null) {
              continue;
            }
            a(null);
            continue;
          }
          this.M = SystemClock.elapsedRealtime();
          this.g.add(paramToServiceMsg);
          i1 = paramToServiceMsg.getWupBuffer().length;
          for (;;)
          {
            synchronized (this.as)
            {
              this.k = (i1 + this.k);
              if (!this.ar)
              {
                this.ai.postDelayed(this.h, this.l);
                this.ar = true;
              }
              ??? = paramToServiceMsg.getServiceCmd();
              if (QLog.isColorLevel())
              {
                QLog.d("MSF.C.NetConnTag", 2, "add " + paramToServiceMsg.getRequestSsoSeq() + " cmd: " + (String)??? + " uin: " + paramToServiceMsg.getUin() + " len: " + paramToServiceMsg.getWupBuffer().length + " msg to SSO.LoginMerge delayWaitSendList");
                return paramToServiceMsg.getRequestSsoSeq();
              }
            }
            QLog.d("MSF.C.NetConnTag", 1, "add " + paramToServiceMsg.getRequestSsoSeq() + " cmd:" + com.tencent.mobileqq.msf.core.b.c.a((String)???) + " uin: " + MsfSdkUtils.getShortUin(paramToServiceMsg.getUin()) + " len: " + paramToServiceMsg.getWupBuffer().length + " msg to " + com.tencent.mobileqq.msf.core.b.c.a("SSO.LoginMerge") + " delayWaitSendList");
          }
        }
      }
      return h(paramToServiceMsg);
      i1 = 0;
      continue;
      label1936:
      i1 = 1;
      ??? = localObject2;
    }
  }
  
  public long b()
  {
    return this.aw;
  }
  
  public void b(int paramInt)
  {
    try
    {
      if ((this.a.b()) && (this.a.o() != null) && (this.a.o().g != null) && (this.a.o().g.hashCode() == paramInt)) {
        b(true);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(FromServiceMsg paramFromServiceMsg)
  {
    if ((this.ah == null) || (!this.ah.getAttributes().containsKey("_attr_regprxy_socket_hashcode")) || (!this.ah.getAttributes().containsKey("_attr_regprxy_random_code")))
    {
      QLog.d("MSF.C.NetConnTag", 1, "not tag regprxysvc resp seq:" + paramFromServiceMsg.getRequestSsoSeq() + " by infoLogin error");
      return;
    }
    if ((!this.a.b()) || (this.a.o().g == null))
    {
      QLog.d("MSF.C.NetConnTag", 1, "not tag regprxysvc resp seq:" + paramFromServiceMsg.getRequestSsoSeq() + " by disconn");
      return;
    }
    if (this.a.o().g.hashCode() == ((Integer)this.ah.getAttributes().get("_attr_regprxy_socket_hashcode")).intValue())
    {
      paramFromServiceMsg.getAttributes().put("_attr_regprxy_random_code", this.ah.getAttributes().get("_attr_regprxy_random_code"));
      return;
    }
    QLog.d("MSF.C.NetConnTag", 1, "not tag regprxysvc resp seq:" + paramFromServiceMsg.getRequestSsoSeq() + " by socket changed");
  }
  
  public ToServiceMsg c(int paramInt)
  {
    ToServiceMsg localToServiceMsg = (ToServiceMsg)this.c.remove(Integer.valueOf(paramInt));
    if (localToServiceMsg != null)
    {
      Runnable localRunnable = (Runnable)localToServiceMsg.getAttributes().remove("to_timeoutCallbacker");
      this.F.msfAlarmer.b().removeCallbacks(localRunnable);
      if (com.tencent.mobileqq.msf.core.a.a.x())
      {
        localRunnable = (Runnable)localToServiceMsg.getAttributes().remove("to_predetect_timeoutCallbacker");
        if (localRunnable != null) {
          this.F.msfAlarmer.b().removeCallbacks(localRunnable);
        }
      }
    }
    return localToServiceMsg;
  }
  
  public void c()
  {
    this.aw = 0L;
  }
  
  public void c(ToServiceMsg paramToServiceMsg)
  {
    this.c.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), paramToServiceMsg);
    paramToServiceMsg.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(aj.incrementAndGet()));
    if (paramToServiceMsg.getTimeout() == -1L) {
      paramToServiceMsg.setTimeout(30000L);
    }
    for (Runnable localRunnable = this.F.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());; localRunnable = this.F.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout()))
    {
      paramToServiceMsg.addAttribute("to_timeoutCallbacker", localRunnable);
      return;
    }
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    this.E.nativeOnReceData(paramArrayOfByte);
  }
  
  public void d(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      Runnable localRunnable = (Runnable)paramToServiceMsg.getAttributes().remove("to_timeoutCallbacker");
      if (localRunnable != null) {
        this.F.msfAlarmer.b().removeCallbacks(localRunnable);
      }
      if (com.tencent.mobileqq.msf.core.a.a.x())
      {
        paramToServiceMsg = (Runnable)paramToServiceMsg.getAttributes().remove("to_predetect_timeoutCallbacker");
        if (paramToServiceMsg != null) {
          this.F.msfAlarmer.b().removeCallbacks(paramToServiceMsg);
        }
      }
    }
  }
  
  public boolean d()
  {
    return this.c.isEmpty();
  }
  
  public byte[] e()
  {
    return this.ax;
  }
  
  public byte[] e(ToServiceMsg paramToServiceMsg)
  {
    Object localObject1 = null;
    if (paramToServiceMsg != null) {}
    for (;;)
    {
      int i1;
      try
      {
        Object localObject2 = paramToServiceMsg.getServiceCmd();
        i1 = ((String)localObject2).indexOf("#");
        localObject1 = localObject2;
        if (i1 != -1) {
          localObject1 = ((String)localObject2).substring(0, i1);
        }
        if (paramToServiceMsg.getWupBuffer() != null)
        {
          b1 = 0;
          byte[] arrayOfByte1;
          byte[] arrayOfByte2;
          if (NetConnInfoCenter.isWifiConn())
          {
            b1 = 1;
            localObject2 = f(paramToServiceMsg);
            g();
            arrayOfByte1 = e();
            arrayOfByte2 = paramToServiceMsg.getWupBuffer();
            if (591 == CodecWarpper.getSharedObjectVersion()) {
              return CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), t.d(), t.f(), t.g(), "", (String)localObject1, arrayOfByte1, paramToServiceMsg.getAppId(), this.F.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, arrayOfByte2, false);
            }
          }
          else
          {
            if (!NetConnInfoCenter.isMobileConn()) {
              continue;
            }
            int i2 = NetConnInfoCenter.getMobileNetworkType() + 100;
            i1 = i2;
            if (i2 <= 254) {
              break label275;
            }
            i2 = 254;
            i1 = i2;
            if (!QLog.isColorLevel()) {
              break label275;
            }
            QLog.d("MSF.C.NetConnTag", 2, "error,netWorkType is " + 254);
            i1 = i2;
            break label275;
          }
          return CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), t.d(), t.f(), t.g(), "", (String)localObject1, arrayOfByte1, paramToServiceMsg.getAppId(), this.F.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, (byte[])localObject2, arrayOfByte2, false);
        }
        return new byte[0];
      }
      catch (Throwable paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        QLog.d("MSF.C.NetConnTag", 1, "encode packet failed", paramToServiceMsg);
        localObject1 = new byte[0];
      }
      return localObject1;
      label275:
      byte b1 = (byte)i1;
    }
  }
  
  public void f()
  {
    if (this.am != "0") {
      this.F.getAccountCenter().a(false);
    }
  }
  
  public void g(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {}
    while ((paramToServiceMsg.getMsfCommand() == MsfCommand.msf_ssoping) || (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_HeartbeatAlive)) {
      return;
    }
    if (paramToServiceMsg.getAttributes().containsKey("__timestamp_msf2net")) {}
    for (long l1 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net")).longValue();; l1 = 0L)
    {
      if ((l1 != 0L) && (l1 <= this.a.o().d()))
      {
        QLog.d("MSF.C.NetConnTag", 1, "preDetectTimeoutMsg return before connSucc.");
        return;
      }
      for (;;)
      {
        synchronized (this.O)
        {
          if ((!this.O.get()) || (System.currentTimeMillis() - this.Q >= com.tencent.mobileqq.msf.core.a.a.N() + 120000))
          {
            l1 = System.currentTimeMillis();
            if (!QLog.isColorLevel()) {
              break label287;
            }
            localObject = paramToServiceMsg.getServiceCmd();
            if (l1 - this.Q <= com.tencent.mobileqq.msf.core.a.a.O()) {
              break label299;
            }
            u();
            QLog.d("MSF.C.NetConnTag", 1, "preDetectTimeoutMsg cmd:" + (String)localObject + ", ssoSeq:" + paramToServiceMsg.getRequestSsoSeq());
            if (this.F.statReporter != null)
            {
              localObject = new HashMap();
              ((HashMap)localObject).put("param_preDetectUin", paramToServiceMsg.getUin());
              ((HashMap)localObject).put("param_preDetectCmd", paramToServiceMsg.getServiceCmd());
              ((HashMap)localObject).put("param_preDetectSsoseq", String.valueOf(paramToServiceMsg.getRequestSsoSeq()));
              this.F.statReporter.a("dim.Msf.PreDetectTimeoutMsg", true, 0L, 0L, (Map)localObject, false, false);
            }
          }
          return;
        }
        label287:
        Object localObject = com.tencent.mobileqq.msf.core.b.c.a(paramToServiceMsg.getServiceCmd());
        continue;
        label299:
        QLog.d("MSF.C.NetConnTag", 1, "notry preDetectTimeoutMsg cmd:" + (String)localObject + ", ssoSeq:" + paramToServiceMsg.getRequestSsoSeq());
      }
    }
  }
  
  public void h()
  {
    this.E.nativeClearReceData();
  }
  
  public String i()
  {
    return this.am;
  }
  
  public int j()
  {
    return this.al;
  }
  
  public void k()
  {
    try
    {
      if (this.af)
      {
        Iterator localIterator = this.ae.iterator();
        while (localIterator.hasNext())
        {
          HashMap localHashMap = (HashMap)localIterator.next();
          try
          {
            this.F.configManager.a(localHashMap, "");
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
      }
      return;
    }
    catch (Exception localException1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "report waitReportData error " + localException1);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "report waitReportData succ " + this.ae.size());
    }
    this.ae.clear();
    this.af = false;
  }
  
  public void l()
  {
    Iterator localIterator = this.c.entrySet().iterator();
    label218:
    for (;;)
    {
      Object localObject1;
      int i1;
      if (localIterator.hasNext())
      {
        localObject1 = (Map.Entry)localIterator.next();
        if (localObject1 == null) {
          continue;
        }
        localObject1 = (ToServiceMsg)((Map.Entry)localObject1).getValue();
        if ((localObject1 == null) || (this.f.contains(localObject1))) {
          continue;
        }
        if (((ToServiceMsg)localObject1).isFastResendEnabled()) {
          i1 = 1;
        }
      }
      for (;;)
      {
        if (i1 == 0) {
          break label218;
        }
        Object localObject2 = MsfSdkUtils.constructResponse((ToServiceMsg)localObject1, 2901, "", null);
        ((FromServiceMsg)localObject2).setBusinessFail(2901);
        if ((localObject1 != null) && (this.F.quicksender != null) && (this.F.quicksender.b((ToServiceMsg)localObject1))) {
          this.F.quicksender.a((ToServiceMsg)localObject1, (FromServiceMsg)localObject2, -1);
        }
        this.F.addRespToQuque((ToServiceMsg)localObject1, (FromServiceMsg)localObject2);
        localIterator.remove();
        break;
        localObject2 = BaseConstants.CMD_NeedResendCmds;
        int i2 = localObject2.length;
        i1 = 0;
        for (;;)
        {
          if (i1 < i2)
          {
            Object localObject3 = localObject2[i1];
            if (((ToServiceMsg)localObject1).getServiceCmd().equals(localObject3))
            {
              i1 = 1;
              break;
            }
            i1 += 1;
            continue;
            return;
          }
        }
        i1 = 0;
      }
    }
  }
  
  public void o()
  {
    if ((this.a != null) && (this.a.o() != null)) {
      this.a.o().e();
    }
  }
  
  public void p()
  {
    if (-1L == v) {}
    long l1;
    do
    {
      return;
      l1 = System.currentTimeMillis();
    } while (l1 - v <= com.tencent.mobileqq.msf.core.a.a.aZ());
    try
    {
      new e().run();
      v = l1;
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.NetConnTag", 1, "failed to report connect wifi info " + localException.toString());
    }
  }
  
  class a
    extends CodecWarpper
  {
    a() {}
    
    private com.tencent.qphone.base.a a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return com.tencent.qphone.base.a.u;
      case -2: 
        return com.tencent.qphone.base.a.v;
      case -3: 
        return com.tencent.qphone.base.a.w;
      case -4: 
        return com.tencent.qphone.base.a.x;
      case -5: 
        return com.tencent.qphone.base.a.j;
      case -6: 
        return com.tencent.qphone.base.a.r;
      case -7: 
        return com.tencent.qphone.base.a.s;
      }
      return com.tencent.qphone.base.a.y;
    }
    
    private void a(FromServiceMsg paramFromServiceMsg, int paramInt)
    {
      paramFromServiceMsg.addAttribute("__timestamp_net2msf", Long.valueOf(System.currentTimeMillis()));
      paramFromServiceMsg.addAttribute("__timestamp_net2msf_boot", Long.valueOf(SystemClock.elapsedRealtime()));
      Object localObject = paramFromServiceMsg.getMsgCookie();
      if ((localObject != null) && (localObject.length > 0)) {
        af.this.F.sender.a((byte[])localObject);
      }
      paramFromServiceMsg.setRequestSsoSeq(paramFromServiceMsg.getAppSeq());
      if ((!paramFromServiceMsg.isSuccess()) && (paramFromServiceMsg.getBusinessFailCode() == -10008)) {
        af.a(paramFromServiceMsg.getUin(), false);
      }
      ToServiceMsg localToServiceMsg;
      for (;;)
      {
        if (NetConnInfoCenter.isNeedWifiAuth()) {
          NetConnInfoCenter.setNeedWifiAuth(false);
        }
        localToServiceMsg = af.this.F.sender.c(paramFromServiceMsg.getRequestSsoSeq());
        label132:
        long l2;
        long l1;
        StringBuilder localStringBuilder;
        String str2;
        int i;
        label281:
        String str1;
        if (localToServiceMsg != null)
        {
          localObject = localToServiceMsg.getServiceCmd();
          l2 = 0L;
          l1 = l2;
          if (localToServiceMsg != null)
          {
            l1 = l2;
            if (localToServiceMsg.getAttribute("__timestamp_msf2net") != null)
            {
              l1 = l2;
              if (paramFromServiceMsg != null)
              {
                l1 = l2;
                if (paramFromServiceMsg.getAttribute("__timestamp_net2msf") != null)
                {
                  l2 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - ((Long)localToServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
                  l1 = l2;
                  if (l2 < 0L) {
                    l1 = 0L;
                  }
                  l2 = l1;
                  if (l1 > 2147483647L) {
                    l2 = 0L;
                  }
                  paramFromServiceMsg.addAttribute("__timestamp_msf2net", localToServiceMsg.getAttribute("__timestamp_msf2net"));
                  l1 = l2;
                }
              }
            }
          }
          localStringBuilder = new StringBuilder();
          str2 = paramFromServiceMsg.getServiceCmd();
          if (!com.tencent.mobileqq.a.a.a.b) {
            break label1027;
          }
          i = 1;
          if (!QLog.isDevelopLevel()) {
            break label1134;
          }
          if (l1 != 0L) {
            break label1032;
          }
          str1 = String.valueOf(l1);
          label301:
          if (paramFromServiceMsg.getResultCode() == 1000) {
            break label1058;
          }
          QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + paramFromServiceMsg.getUin() + " cmd:" + str2 + " len:" + paramInt + " costTime:" + str1 + " code:" + paramFromServiceMsg.getResultCode() + " failMsg:" + paramFromServiceMsg.getBusinessFailMsg() + " cross:" + i);
          label408:
          paramFromServiceMsg.addAttribute("_tag_LOGSTR", af.G + "|" + paramFromServiceMsg.getRequestSsoSeq() + "|" + paramFromServiceMsg.getServiceCmd() + "|");
          paramFromServiceMsg.addAttribute("_tag_socket", af.G);
          paramFromServiceMsg.addAttribute("_tag_localsocket", af.H);
          paramFromServiceMsg.addAttribute("_tag_socket_nettype", Integer.valueOf(l.A));
          if (localToServiceMsg == null) {}
        }
        try
        {
          af.this.a.a(paramFromServiceMsg, localToServiceMsg);
          i = paramFromServiceMsg.getRequestSsoSeq();
          l2 = paramInt;
          if (localToServiceMsg == null)
          {
            bool = true;
            com.tencent.mobileqq.a.a.f.a((String)localObject, i, l2, l1, bool);
            com.tencent.mobileqq.a.a.a.a().a(localToServiceMsg, paramFromServiceMsg);
            if ((af.this.F.isReconnectSso.get()) && (af.this.F.sender.d()))
            {
              af.this.a.o().a(com.tencent.qphone.base.a.h);
              af.this.F.isReconnectSso.set(false);
            }
            if (localToServiceMsg == null) {
              break label1521;
            }
            paramFromServiceMsg.setAppSeq(localToServiceMsg.getAppSeq());
            paramFromServiceMsg.setMsfCommand(localToServiceMsg.getMsfCommand());
            paramFromServiceMsg.setAppId(localToServiceMsg.getAppId());
            if (paramFromServiceMsg.isSuccess()) {
              break label1521;
            }
            i = paramFromServiceMsg.getBusinessFailCode();
            paramInt = i;
            if (i == 302)
            {
              paramFromServiceMsg.setBusinessFail(-302);
              paramInt = -302;
            }
            if (paramInt != -302) {
              break label1412;
            }
            af.this.a.o().a(com.tencent.qphone.base.a.i);
            af.this.F.reSendMsg(localToServiceMsg);
            return;
            if ((paramFromServiceMsg.getUin() == null) || (paramFromServiceMsg.getUin().length() <= 4) || (af.ad.contains(paramFromServiceMsg.getUin())) || (!paramFromServiceMsg.isSuccess()) || (paramFromServiceMsg.getServiceCmd().startsWith("login.")) || (paramFromServiceMsg.getServiceCmd().startsWith("wtlogin.")) || (paramFromServiceMsg.getServiceCmd().equals("ConfigService.ClientReq")) || (paramFromServiceMsg.getServiceCmd().equals("GrayUinPro.Check")) || (paramFromServiceMsg.getServiceCmd().equals("account.RequestReBindMblWTLogin_emp")) || (paramFromServiceMsg.getServiceCmd().equals("account.RequestVerifyWTLogin_emp")) || (paramFromServiceMsg.getServiceCmd().equals("ConnAuthSvr.get_app_info_emp")) || (paramFromServiceMsg.getServiceCmd().equals("ConnAuthSvr.sdk_auth_api_emp")) || (paramFromServiceMsg.getServiceCmd().equals("ConnAuthSvr.get_auth_api_list_emp"))) {
              continue;
            }
            localObject = (ConcurrentLinkedQueue)af.t.get(paramFromServiceMsg.getUin());
            if ((localObject != null) && (((ConcurrentLinkedQueue)localObject).contains(Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()))))
            {
              af.t.remove(paramFromServiceMsg.getUin());
              af.a(paramFromServiceMsg.getUin(), true);
              QLog.d(tag, 1, "recv Packet removeItem setV9, ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + ", uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()));
              continue;
            }
            QLog.d(tag, 1, "recv Packet ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + ", uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()));
            continue;
            localObject = paramFromServiceMsg.getServiceCmd();
            break label132;
            label1027:
            i = 0;
            break label281;
            label1032:
            str1 = l1 + NetConnInfoCenter.getSignalStrengthsLog();
            break label301;
            label1058:
            QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + paramFromServiceMsg.getUin() + " cmd:" + str2 + " len:" + paramInt + " costTime:" + str1 + " cross:" + i);
            break label408;
            label1134:
            if (paramFromServiceMsg.getResultCode() != 1000)
            {
              QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()) + " cmd:" + com.tencent.mobileqq.msf.core.b.c.a(str2) + new StringBuilder().append(" ").append(paramFromServiceMsg.getRequestSsoSeq() + paramInt).toString() + " code:" + paramFromServiceMsg.getResultCode() + " failMsg:" + paramFromServiceMsg.getBusinessFailMsg() + " cross:" + i);
              break label408;
            }
            QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()) + " cmd:" + com.tencent.mobileqq.msf.core.b.c.a(str2) + new StringBuilder().append(" ").append(paramFromServiceMsg.getRequestSsoSeq() + paramInt).toString() + " cross:" + i);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            af.this.a.d();
            af.this.a.q = 0L;
            QLog.d(tag, 1, "call firstResponseGetted error " + localException, localException);
            continue;
            boolean bool = false;
          }
          label1412:
          if (paramInt == -10008)
          {
            if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getRequestSsoSeq() == 0)) {
              MsfCore.sCore.getStatReporter().a(false, localToServiceMsg, paramFromServiceMsg);
            }
            if (!MsfMsgUtil.hasResendBy10008(localToServiceMsg))
            {
              localToServiceMsg.getAttributes().put("_attr_msg_has_resend_by_10008", Boolean.valueOf(true));
              QLog.d(tag, 1, "Resend 10008 " + localToServiceMsg.getShortStringForLog());
              af.this.F.reSendMsg(localToServiceMsg);
              return;
            }
            QLog.d(tag, 1, "This msg has already resend by -10008, won't resend again!");
          }
        }
      }
      label1521:
      if (af.s().get()) {
        QLog.e(tag, 1, "invalidSign, " + paramFromServiceMsg + " is droped.");
      }
      for (;;)
      {
        af.this.F.getAccountCenter().g.a();
        v.a().z();
        af.this.k();
        af.this.p();
        return;
        if (paramFromServiceMsg.getMsfCommand() == MsfCommand._msf_HeartbeatAlive)
        {
          af.this.a(paramFromServiceMsg, localToServiceMsg);
        }
        else if (paramFromServiceMsg.getMsfCommand() == MsfCommand._msf_QuickHeartBeat)
        {
          af.this.F.quicksender.a(localToServiceMsg, paramFromServiceMsg, false);
        }
        else
        {
          af.C.set(0);
          af.D.clear();
          af.this.F.getSsoRespHandler().b(localToServiceMsg, paramFromServiceMsg);
        }
      }
    }
    
    public void a(int paramInt1, int paramInt2, int paramInt3)
    {
      QLog.d(tag, 1, "MSF.C.CodecWarpper loginMerge onInvalidData " + paramInt1 + " size is " + paramInt2 + ", try to closeConn");
      af.this.a.o().a(a(paramInt1));
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(af.d(af.this)).append("|").append(MsfCore.mobileQQAppid).append("|").append(paramInt3).append("|").append(paramInt1).append("|").append(af.this.a.o().l + ":" + af.this.a.o().m);
      if (QLog.isDevelopLevel()) {
        QLog.d(tag, 4, "CodecStatHelper Report loginMerge_error " + localStringBuffer.toString());
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("loginMerge_failDetail", localStringBuffer.toString());
      if (MsfService.getCore().getStatReporter() != null) {
        MsfService.getCore().getStatReporter().a("loginMerge_error", true, 0L, 0L, localHashMap, false, false);
      }
    }
    
    public void onInvalidData(int paramInt1, int paramInt2)
    {
      QLog.d(tag, 1, "MSF.C.CodecWarpper onInvalidData " + paramInt1 + " size is " + paramInt2 + ", try to closeConn");
      af.this.a.o().a(a(paramInt1));
      try
      {
        af.this.a.f();
        return;
      }
      catch (Exception localException)
      {
        QLog.d(tag, 1, "call findResponseDataError error " + localException);
      }
    }
    
    public void onInvalidSign()
    {
      QLog.d(tag, 1, "MSF.C.CodecWarpper onInvalidSign");
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(af.this.F.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_InvalidSign");
      localFromServiceMsg.setBusinessFail(2014, "onInvalidSign");
      localFromServiceMsg.setMsfCommand(MsfCommand.onInvalidSign);
      MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
      af.this.F.addRespToQuque(null, localFromServiceMsg);
      af.s().set(true);
    }
    
    public void onResponse(int paramInt1, Object paramObject, int paramInt2)
    {
      Object localObject1 = null;
      if (paramObject != null) {}
      try
      {
        if (af.T != -1) {
          af.T = -1;
        }
        af.this.R = System.currentTimeMillis();
        af.S = af.this.R;
        localObject2 = (FromServiceMsg)paramObject;
        try
        {
          paramInt1 = ((FromServiceMsg)localObject2).getWupBuffer().length;
          if (!((FromServiceMsg)localObject2).getServiceCmd().equals("SSO.LoginMerge")) {
            break label417;
          }
          ((FromServiceMsg)localObject2).setRequestSsoSeq(((FromServiceMsg)localObject2).getAppSeq());
          if (((FromServiceMsg)localObject2).isSuccess()) {
            break label417;
          }
          if (!QLog.isColorLevel()) {
            break label404;
          }
          localObject1 = ((FromServiceMsg)localObject2).getServiceCmd();
          QLog.d("MSF.C.NetConnTag", 1, "failed merge netRecv ssoSeq:" + ((FromServiceMsg)localObject2).getRequestSsoSeq() + " cmd: " + (String)localObject1 + " len: " + ((FromServiceMsg)localObject2).getWupBuffer().length);
          localObject1 = (ArrayList)af.this.d.remove(Integer.valueOf(((FromServiceMsg)localObject2).getRequestSsoSeq()));
          if (((FromServiceMsg)localObject2).getBusinessFailCode() == -10107)
          {
            if (af.this.q) {
              af.this.q = false;
            }
            QLog.d("MSF.C.NetConnTag", 1, "merge not support, " + Arrays.toString(((ArrayList)localObject1).toArray()) + "resend, close merge.");
          }
          if (localObject1 == null) {
            break label417;
          }
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            paramInt1 = ((Integer)((Iterator)localObject1).next()).intValue();
            ToServiceMsg localToServiceMsg = af.this.F.sender.c(paramInt1);
            if (localToServiceMsg != null) {
              af.a(af.this, localToServiceMsg);
            }
          }
          if (!((Throwable)localObject2).toString().contains("InvalidProtocol")) {
            break label354;
          }
        }
        catch (Throwable localThrowable2)
        {
          localObject1 = localObject2;
          localObject2 = localThrowable2;
        }
      }
      catch (Throwable localThrowable1)
      {
        Object localObject2;
        label323:
        label354:
        break label323;
      }
      if (localObject1 != null) {
        a(-8, paramInt2, ((FromServiceMsg)localObject1).getRequestSsoSeq());
      }
      if (QLog.isColorLevel()) {
        QLog.d(tag, 2, "handleSsoResp " + paramObject + " error " + ((Throwable)localObject2).toString(), (Throwable)localObject2);
      }
      for (;;)
      {
        return;
        label404:
        localObject1 = com.tencent.mobileqq.msf.core.b.c.a(((FromServiceMsg)localObject2).getServiceCmd());
        break;
        label417:
        int i;
        if ((((FromServiceMsg)localObject2).getFlag() & 0x1) != 0)
        {
          localObject1 = ((FromServiceMsg)localObject2).getWupBuffer();
          i = localObject1.length;
          if (i > 4) {
            i = (localObject1[0] & 0xFF) << 24 | 0x0 | (localObject1[1] & 0xFF) << 16 | (localObject1[2] & 0xFF) << 8 | localObject1[3] & 0xFF;
          }
        }
        else
        {
          try
          {
            Object localObject3 = new byte[i];
            System.arraycopy(localObject1, 4, localObject3, 0, i - 4);
            localObject3 = com.tencent.qphone.base.util.j.b((byte[])localObject3);
            Object localObject4 = new byte[localObject3.length + 4];
            localObject4[0] = ((byte)(localObject3.length + 4 >> 24 & 0xFF));
            localObject4[1] = ((byte)(localObject3.length + 4 >> 16 & 0xFF));
            localObject4[2] = ((byte)(localObject3.length + 4 >> 8 & 0xFF));
            localObject4[3] = ((byte)(localObject3.length + 4 & 0xFF));
            System.arraycopy(localObject3, 0, localObject4, 4, localObject3.length);
            ((FromServiceMsg)localObject2).putWupBuffer((byte[])localObject4);
            if ((!((FromServiceMsg)localObject2).isSuccess()) || (!((FromServiceMsg)localObject2).getServiceCmd().equals("SSO.LoginMerge"))) {
              break label1002;
            }
            QLog.d("MSF.C.NetConnTag", 1, "netRecv Delay FromServiceMsg ssoSeq:" + ((FromServiceMsg)localObject2).getRequestSsoSeq() + " scmd: " + ((FromServiceMsg)localObject2).getServiceCmd() + " len: " + paramInt1 + " uncompressed len: " + ((FromServiceMsg)localObject2).getWupBuffer().length);
            localObject1 = new SSOLoginMerge.BusiBuffData();
            localObject3 = new byte[((FromServiceMsg)localObject2).getWupBuffer().length - 4];
            System.arraycopy(((FromServiceMsg)localObject2).getWupBuffer(), 4, localObject3, 0, localObject3.length);
            localObject1 = ((SSOLoginMerge.BusiBuffData)((SSOLoginMerge.BusiBuffData)localObject1).mergeFrom((byte[])localObject3)).BusiBuffVec.get().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (SSOLoginMerge.BusiBuffItem)((Iterator)localObject1).next();
              localObject4 = new FromServiceMsg();
              ((FromServiceMsg)localObject4).setServiceCmd(((SSOLoginMerge.BusiBuffItem)localObject3).ServiceCmd.get());
              ((FromServiceMsg)localObject4).setRequestSsoSeq(((SSOLoginMerge.BusiBuffItem)localObject3).SeqNo.get());
              ((FromServiceMsg)localObject4).putWupBuffer(((SSOLoginMerge.BusiBuffItem)localObject3).BusiBuff.get().toByteArray());
              ((FromServiceMsg)localObject4).setAppSeq(((FromServiceMsg)localObject4).getRequestSsoSeq());
              ((FromServiceMsg)localObject4).setMsgSuccess();
              ((FromServiceMsg)localObject4).setUin(((FromServiceMsg)localObject2).getUin());
              ((FromServiceMsg)localObject4).putWupBuffer(af.b(((FromServiceMsg)localObject4).getWupBuffer()));
              a((FromServiceMsg)localObject4, ((FromServiceMsg)localObject4).getWupBuffer().length);
            }
            if (((FromServiceMsg)localObject2).getServiceCmd().equals("SSO.LoginMerge")) {
              break label987;
            }
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.d(tag, 2, "uncompress data failed " + localException);
            }
            if (!((FromServiceMsg)localObject2).getServiceCmd().equals("SSO.LoginMerge"))
            {
              onInvalidData(-7, localObject1.length);
              return;
            }
            a(-7, localObject1.length, ((FromServiceMsg)localObject2).getRequestSsoSeq());
            return;
          }
        }
      }
      onInvalidData(-6, localObject1.length);
      return;
      label987:
      a(-6, localObject1.length, ((FromServiceMsg)localObject2).getRequestSsoSeq());
      return;
      label1002:
      a((FromServiceMsg)localObject2, paramInt2);
    }
    
    /* Error */
    public void onResponse(int paramInt1, Object paramObject, int paramInt2, byte[] paramArrayOfByte)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 10
      //   3: aload_2
      //   4: ifnull +395 -> 399
      //   7: getstatic 617	com/tencent/mobileqq/msf/core/af:T	I
      //   10: iconst_m1
      //   11: if_icmpeq +7 -> 18
      //   14: iconst_m1
      //   15: putstatic 617	com/tencent/mobileqq/msf/core/af:T	I
      //   18: aload_0
      //   19: getfield 12	com/tencent/mobileqq/msf/core/af$a:a	Lcom/tencent/mobileqq/msf/core/af;
      //   22: invokestatic 55	java/lang/System:currentTimeMillis	()J
      //   25: putfield 620	com/tencent/mobileqq/msf/core/af:R	J
      //   28: aload_0
      //   29: getfield 12	com/tencent/mobileqq/msf/core/af$a:a	Lcom/tencent/mobileqq/msf/core/af;
      //   32: getfield 620	com/tencent/mobileqq/msf/core/af:R	J
      //   35: putstatic 623	com/tencent/mobileqq/msf/core/af:S	J
      //   38: aload_2
      //   39: checkcast 63	com/tencent/qphone/base/remote/FromServiceMsg
      //   42: astore 9
      //   44: aload 9
      //   46: invokevirtual 626	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
      //   49: arraylength
      //   50: istore_1
      //   51: aload 9
      //   53: invokevirtual 149	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   56: ldc_w 628
      //   59: invokevirtual 328	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   62: ifeq +351 -> 413
      //   65: aload 9
      //   67: aload 9
      //   69: invokevirtual 94	com/tencent/qphone/base/remote/FromServiceMsg:getAppSeq	()I
      //   72: invokevirtual 98	com/tencent/qphone/base/remote/FromServiceMsg:setRequestSsoSeq	(I)V
      //   75: aload 9
      //   77: invokevirtual 102	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
      //   80: ifne +333 -> 413
      //   83: invokestatic 631	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   86: ifeq +314 -> 400
      //   89: aload 9
      //   91: invokevirtual 149	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   94: astore 8
      //   96: ldc 170
      //   98: iconst_1
      //   99: new 147	java/lang/StringBuilder
      //   102: dup
      //   103: invokespecial 148	java/lang/StringBuilder:<init>	()V
      //   106: ldc_w 633
      //   109: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   112: aload 9
      //   114: invokevirtual 124	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
      //   117: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   120: ldc_w 635
      //   123: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   126: aload 8
      //   128: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   131: ldc_w 637
      //   134: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   137: aload 9
      //   139: invokevirtual 626	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
      //   142: arraylength
      //   143: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   146: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   149: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   152: aload_0
      //   153: getfield 12	com/tencent/mobileqq/msf/core/af$a:a	Lcom/tencent/mobileqq/msf/core/af;
      //   156: getfield 639	com/tencent/mobileqq/msf/core/af:d	Ljava/util/concurrent/ConcurrentHashMap;
      //   159: aload 9
      //   161: invokevirtual 124	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
      //   164: invokestatic 231	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   167: invokevirtual 355	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   170: checkcast 510	java/util/ArrayList
      //   173: astore 8
      //   175: aload 9
      //   177: invokevirtual 105	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailCode	()I
      //   180: sipush -10107
      //   183: if_icmpne +60 -> 243
      //   186: aload_0
      //   187: getfield 12	com/tencent/mobileqq/msf/core/af$a:a	Lcom/tencent/mobileqq/msf/core/af;
      //   190: getfield 641	com/tencent/mobileqq/msf/core/af:q	Z
      //   193: ifeq +11 -> 204
      //   196: aload_0
      //   197: getfield 12	com/tencent/mobileqq/msf/core/af$a:a	Lcom/tencent/mobileqq/msf/core/af;
      //   200: iconst_0
      //   201: putfield 641	com/tencent/mobileqq/msf/core/af:q	Z
      //   204: ldc 170
      //   206: iconst_1
      //   207: new 147	java/lang/StringBuilder
      //   210: dup
      //   211: invokespecial 148	java/lang/StringBuilder:<init>	()V
      //   214: ldc_w 643
      //   217: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   220: aload 8
      //   222: invokevirtual 647	java/util/ArrayList:toArray	()[Ljava/lang/Object;
      //   225: invokestatic 652	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
      //   228: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   231: ldc_w 654
      //   234: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   237: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   240: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   243: aload 8
      //   245: ifnull +168 -> 413
      //   248: aload 8
      //   250: invokevirtual 658	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   253: astore 4
      //   255: aload 4
      //   257: invokeinterface 663 1 0
      //   262: ifeq +137 -> 399
      //   265: aload 4
      //   267: invokeinterface 667 1 0
      //   272: checkcast 228	java/lang/Integer
      //   275: invokevirtual 670	java/lang/Integer:intValue	()I
      //   278: istore_1
      //   279: aload_0
      //   280: getfield 12	com/tencent/mobileqq/msf/core/af$a:a	Lcom/tencent/mobileqq/msf/core/af;
      //   283: getfield 82	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   286: getfield 87	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
      //   289: iload_1
      //   290: invokevirtual 128	com/tencent/mobileqq/msf/core/af:c	(I)Lcom/tencent/qphone/base/remote/ToServiceMsg;
      //   293: astore 8
      //   295: aload 8
      //   297: ifnull -42 -> 255
      //   300: aload_0
      //   301: getfield 12	com/tencent/mobileqq/msf/core/af$a:a	Lcom/tencent/mobileqq/msf/core/af;
      //   304: aload 8
      //   306: invokestatic 673	com/tencent/mobileqq/msf/core/af:a	(Lcom/tencent/mobileqq/msf/core/af;Lcom/tencent/qphone/base/remote/ToServiceMsg;)I
      //   309: pop
      //   310: goto -55 -> 255
      //   313: astore 8
      //   315: aload 9
      //   317: astore 4
      //   319: aload 8
      //   321: invokevirtual 674	java/lang/Throwable:toString	()Ljava/lang/String;
      //   324: ldc_w 676
      //   327: invokevirtual 679	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   330: ifeq +20 -> 350
      //   333: aload 4
      //   335: ifnull +15 -> 350
      //   338: aload_0
      //   339: bipush 248
      //   341: iload_3
      //   342: aload 4
      //   344: invokevirtual 124	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
      //   347: invokevirtual 681	com/tencent/mobileqq/msf/core/af$a:a	(III)V
      //   350: invokestatic 631	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   353: ifeq +46 -> 399
      //   356: getstatic 358	com/tencent/mobileqq/msf/core/af$a:tag	Ljava/lang/String;
      //   359: iconst_2
      //   360: new 147	java/lang/StringBuilder
      //   363: dup
      //   364: invokespecial 148	java/lang/StringBuilder:<init>	()V
      //   367: ldc_w 683
      //   370: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   373: aload_2
      //   374: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   377: ldc_w 685
      //   380: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   383: aload 8
      //   385: invokevirtual 674	java/lang/Throwable:toString	()Ljava/lang/String;
      //   388: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   391: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   394: aload 8
      //   396: invokestatic 396	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   399: return
      //   400: aload 9
      //   402: invokevirtual 149	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   405: invokestatic 380	com/tencent/mobileqq/msf/core/b/c:a	(Ljava/lang/String;)Ljava/lang/String;
      //   408: astore 8
      //   410: goto -314 -> 96
      //   413: aload 9
      //   415: invokevirtual 688	com/tencent/qphone/base/remote/FromServiceMsg:getFlag	()I
      //   418: iconst_1
      //   419: iand
      //   420: ifeq +188 -> 608
      //   423: aload 9
      //   425: invokevirtual 626	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
      //   428: astore 8
      //   430: aload 8
      //   432: arraylength
      //   433: istore 5
      //   435: iload 5
      //   437: iconst_4
      //   438: if_icmple +691 -> 1129
      //   441: iconst_0
      //   442: aload 8
      //   444: iconst_0
      //   445: baload
      //   446: sipush 255
      //   449: iand
      //   450: bipush 24
      //   452: ishl
      //   453: ior
      //   454: aload 8
      //   456: iconst_1
      //   457: baload
      //   458: sipush 255
      //   461: iand
      //   462: bipush 16
      //   464: ishl
      //   465: ior
      //   466: aload 8
      //   468: iconst_2
      //   469: baload
      //   470: sipush 255
      //   473: iand
      //   474: bipush 8
      //   476: ishl
      //   477: ior
      //   478: aload 8
      //   480: iconst_3
      //   481: baload
      //   482: sipush 255
      //   485: iand
      //   486: ior
      //   487: istore 5
      //   489: iload 5
      //   491: newarray byte
      //   493: astore 10
      //   495: aload 8
      //   497: iconst_4
      //   498: aload 10
      //   500: iconst_0
      //   501: iload 5
      //   503: iconst_4
      //   504: isub
      //   505: invokestatic 692	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   508: aload 10
      //   510: invokestatic 697	com/tencent/qphone/base/util/j:b	([B)[B
      //   513: astore 10
      //   515: aload 10
      //   517: arraylength
      //   518: iconst_4
      //   519: iadd
      //   520: newarray byte
      //   522: astore 11
      //   524: aload 11
      //   526: iconst_0
      //   527: aload 10
      //   529: arraylength
      //   530: iconst_4
      //   531: iadd
      //   532: bipush 24
      //   534: ishr
      //   535: sipush 255
      //   538: iand
      //   539: i2b
      //   540: bastore
      //   541: aload 11
      //   543: iconst_1
      //   544: aload 10
      //   546: arraylength
      //   547: iconst_4
      //   548: iadd
      //   549: bipush 16
      //   551: ishr
      //   552: sipush 255
      //   555: iand
      //   556: i2b
      //   557: bastore
      //   558: aload 11
      //   560: iconst_2
      //   561: aload 10
      //   563: arraylength
      //   564: iconst_4
      //   565: iadd
      //   566: bipush 8
      //   568: ishr
      //   569: sipush 255
      //   572: iand
      //   573: i2b
      //   574: bastore
      //   575: aload 11
      //   577: iconst_3
      //   578: aload 10
      //   580: arraylength
      //   581: iconst_4
      //   582: iadd
      //   583: sipush 255
      //   586: iand
      //   587: i2b
      //   588: bastore
      //   589: aload 10
      //   591: iconst_0
      //   592: aload 11
      //   594: iconst_4
      //   595: aload 10
      //   597: arraylength
      //   598: invokestatic 692	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   601: aload 9
      //   603: aload 11
      //   605: invokevirtual 700	com/tencent/qphone/base/remote/FromServiceMsg:putWupBuffer	([B)V
      //   608: aload 4
      //   610: ifnull +168 -> 778
      //   613: aload 9
      //   615: invokevirtual 149	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   618: ldc_w 778
      //   621: invokevirtual 328	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   624: ifeq +154 -> 778
      //   627: invokestatic 74	android/os/SystemClock:elapsedRealtime	()J
      //   630: lstore 6
      //   632: iconst_0
      //   633: lload 6
      //   635: ldc2_w 779
      //   638: lsub
      //   639: lload 6
      //   641: invokestatic 783	com/tencent/mobileqq/msf/core/c/j:a	(ZJJ)B
      //   644: putstatic 785	com/tencent/mobileqq/msf/core/af:y	I
      //   647: new 787	com/tencent/msf/service/protocol/pb/SSOReserveField$ReserveFields
      //   650: dup
      //   651: invokespecial 788	com/tencent/msf/service/protocol/pb/SSOReserveField$ReserveFields:<init>	()V
      //   654: astore 8
      //   656: aload 8
      //   658: aload 4
      //   660: invokevirtual 789	com/tencent/msf/service/protocol/pb/SSOReserveField$ReserveFields:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
      //   663: pop
      //   664: new 147	java/lang/StringBuilder
      //   667: dup
      //   668: invokespecial 148	java/lang/StringBuilder:<init>	()V
      //   671: astore 4
      //   673: aload 4
      //   675: aload 8
      //   677: getfield 793	com/tencent/msf/service/protocol/pb/SSOReserveField$ReserveFields:sso_send	Lcom/tencent/mobileqq/pb/PBUInt64Field;
      //   680: invokevirtual 797	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
      //   683: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   686: ldc 211
      //   688: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   691: invokestatic 55	java/lang/System:currentTimeMillis	()J
      //   694: invokevirtual 373	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   697: pop
      //   698: aload 9
      //   700: ldc_w 799
      //   703: aload 4
      //   705: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   708: invokevirtual 67	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   711: pop
      //   712: getstatic 358	com/tencent/mobileqq/msf/core/af$a:tag	Ljava/lang/String;
      //   715: iconst_1
      //   716: new 147	java/lang/StringBuilder
      //   719: dup
      //   720: invokespecial 148	java/lang/StringBuilder:<init>	()V
      //   723: ldc_w 801
      //   726: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   729: aload 4
      //   731: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   734: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   737: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   740: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   743: aload_0
      //   744: getfield 12	com/tencent/mobileqq/msf/core/af$a:a	Lcom/tencent/mobileqq/msf/core/af;
      //   747: getfield 82	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   750: getfield 805	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
      //   753: ifnull +25 -> 778
      //   756: aload_0
      //   757: getfield 12	com/tencent/mobileqq/msf/core/af$a:a	Lcom/tencent/mobileqq/msf/core/af;
      //   760: getfield 82	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   763: getfield 805	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
      //   766: ldc_w 807
      //   769: iconst_1
      //   770: lconst_0
      //   771: lconst_0
      //   772: aconst_null
      //   773: iconst_0
      //   774: iconst_0
      //   775: invokevirtual 570	com/tencent/mobileqq/msf/core/c/j:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
      //   778: aload 9
      //   780: invokevirtual 102	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
      //   783: ifeq +402 -> 1185
      //   786: aload 9
      //   788: invokevirtual 149	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   791: ldc_w 628
      //   794: invokevirtual 328	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   797: ifeq +388 -> 1185
      //   800: ldc 170
      //   802: iconst_1
      //   803: new 147	java/lang/StringBuilder
      //   806: dup
      //   807: invokespecial 148	java/lang/StringBuilder:<init>	()V
      //   810: ldc_w 702
      //   813: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   816: aload 9
      //   818: invokevirtual 124	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
      //   821: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   824: ldc_w 704
      //   827: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   830: aload 9
      //   832: invokevirtual 149	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   835: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   838: ldc_w 637
      //   841: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   844: iload_1
      //   845: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   848: ldc_w 706
      //   851: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   854: aload 9
      //   856: invokevirtual 626	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
      //   859: arraylength
      //   860: invokevirtual 179	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   863: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   866: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   869: new 708	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffData
      //   872: dup
      //   873: invokespecial 709	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffData:<init>	()V
      //   876: astore 4
      //   878: aload 9
      //   880: invokevirtual 626	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
      //   883: arraylength
      //   884: iconst_4
      //   885: isub
      //   886: newarray byte
      //   888: astore 8
      //   890: aload 9
      //   892: invokevirtual 626	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
      //   895: iconst_4
      //   896: aload 8
      //   898: iconst_0
      //   899: aload 8
      //   901: arraylength
      //   902: invokestatic 692	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   905: aload 4
      //   907: aload 8
      //   909: invokevirtual 713	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
      //   912: checkcast 708	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffData
      //   915: getfield 717	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffData:BusiBuffVec	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
      //   918: invokevirtual 722	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
      //   921: invokeinterface 725 1 0
      //   926: astore 4
      //   928: aload 4
      //   930: invokeinterface 663 1 0
      //   935: ifeq -536 -> 399
      //   938: aload 4
      //   940: invokeinterface 667 1 0
      //   945: checkcast 727	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffItem
      //   948: astore 8
      //   950: new 63	com/tencent/qphone/base/remote/FromServiceMsg
      //   953: dup
      //   954: invokespecial 728	com/tencent/qphone/base/remote/FromServiceMsg:<init>	()V
      //   957: astore 10
      //   959: aload 10
      //   961: aload 8
      //   963: getfield 732	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffItem:ServiceCmd	Lcom/tencent/mobileqq/pb/PBStringField;
      //   966: invokevirtual 736	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
      //   969: invokevirtual 740	com/tencent/qphone/base/remote/FromServiceMsg:setServiceCmd	(Ljava/lang/String;)V
      //   972: aload 10
      //   974: aload 8
      //   976: getfield 744	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffItem:SeqNo	Lcom/tencent/mobileqq/pb/PBUInt32Field;
      //   979: invokevirtual 748	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
      //   982: invokevirtual 98	com/tencent/qphone/base/remote/FromServiceMsg:setRequestSsoSeq	(I)V
      //   985: aload 10
      //   987: aload 8
      //   989: getfield 752	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffItem:BusiBuff	Lcom/tencent/mobileqq/pb/PBBytesField;
      //   992: invokevirtual 757	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
      //   995: invokevirtual 762	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
      //   998: invokevirtual 700	com/tencent/qphone/base/remote/FromServiceMsg:putWupBuffer	([B)V
      //   1001: aload 10
      //   1003: aload 10
      //   1005: invokevirtual 124	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
      //   1008: invokevirtual 278	com/tencent/qphone/base/remote/FromServiceMsg:setAppSeq	(I)V
      //   1011: aload 10
      //   1013: invokevirtual 765	com/tencent/qphone/base/remote/FromServiceMsg:setMsgSuccess	()V
      //   1016: aload 10
      //   1018: aload 9
      //   1020: invokevirtual 109	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
      //   1023: invokevirtual 768	com/tencent/qphone/base/remote/FromServiceMsg:setUin	(Ljava/lang/String;)V
      //   1026: aload 10
      //   1028: aload 10
      //   1030: invokevirtual 626	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
      //   1033: invokestatic 769	com/tencent/mobileqq/msf/core/af:b	([B)[B
      //   1036: invokevirtual 700	com/tencent/qphone/base/remote/FromServiceMsg:putWupBuffer	([B)V
      //   1039: aload_0
      //   1040: aload 10
      //   1042: aload 10
      //   1044: invokevirtual 626	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
      //   1047: arraylength
      //   1048: invokespecial 771	com/tencent/mobileqq/msf/core/af$a:a	(Lcom/tencent/qphone/base/remote/FromServiceMsg;I)V
      //   1051: goto -123 -> 928
      //   1054: astore 4
      //   1056: invokestatic 631	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1059: ifeq +31 -> 1090
      //   1062: getstatic 358	com/tencent/mobileqq/msf/core/af$a:tag	Ljava/lang/String;
      //   1065: iconst_2
      //   1066: new 147	java/lang/StringBuilder
      //   1069: dup
      //   1070: invokespecial 148	java/lang/StringBuilder:<init>	()V
      //   1073: ldc_w 773
      //   1076: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1079: aload 4
      //   1081: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   1084: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1087: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1090: aload 9
      //   1092: invokevirtual 149	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   1095: ldc_w 628
      //   1098: invokevirtual 328	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1101: ifne +13 -> 1114
      //   1104: aload_0
      //   1105: bipush 249
      //   1107: aload 8
      //   1109: arraylength
      //   1110: invokevirtual 775	com/tencent/mobileqq/msf/core/af$a:onInvalidData	(II)V
      //   1113: return
      //   1114: aload_0
      //   1115: bipush 249
      //   1117: aload 8
      //   1119: arraylength
      //   1120: aload 9
      //   1122: invokevirtual 124	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
      //   1125: invokevirtual 681	com/tencent/mobileqq/msf/core/af$a:a	(III)V
      //   1128: return
      //   1129: aload 9
      //   1131: invokevirtual 149	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   1134: ldc_w 628
      //   1137: invokevirtual 328	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1140: ifne +13 -> 1153
      //   1143: aload_0
      //   1144: bipush 250
      //   1146: aload 8
      //   1148: arraylength
      //   1149: invokevirtual 775	com/tencent/mobileqq/msf/core/af$a:onInvalidData	(II)V
      //   1152: return
      //   1153: aload_0
      //   1154: bipush 250
      //   1156: aload 8
      //   1158: arraylength
      //   1159: aload 9
      //   1161: invokevirtual 124	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
      //   1164: invokevirtual 681	com/tencent/mobileqq/msf/core/af$a:a	(III)V
      //   1167: return
      //   1168: astore 4
      //   1170: getstatic 358	com/tencent/mobileqq/msf/core/af$a:tag	Ljava/lang/String;
      //   1173: iconst_1
      //   1174: ldc_w 809
      //   1177: aload 4
      //   1179: invokestatic 396	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   1182: goto -404 -> 778
      //   1185: aload_0
      //   1186: aload 9
      //   1188: iload_3
      //   1189: invokespecial 771	com/tencent/mobileqq/msf/core/af$a:a	(Lcom/tencent/qphone/base/remote/FromServiceMsg;I)V
      //   1192: return
      //   1193: astore 8
      //   1195: aload 10
      //   1197: astore 4
      //   1199: goto -880 -> 319
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1202	0	this	a
      //   0	1202	1	paramInt1	int
      //   0	1202	2	paramObject	Object
      //   0	1202	3	paramInt2	int
      //   0	1202	4	paramArrayOfByte	byte[]
      //   433	72	5	i	int
      //   630	10	6	l	long
      //   94	211	8	localObject1	Object
      //   313	82	8	localThrowable1	Throwable
      //   408	749	8	localObject2	Object
      //   1193	1	8	localThrowable2	Throwable
      //   42	1145	9	localFromServiceMsg	FromServiceMsg
      //   1	1195	10	localObject3	Object
      //   522	82	11	arrayOfByte	byte[]
      // Exception table:
      //   from	to	target	type
      //   44	96	313	java/lang/Throwable
      //   96	204	313	java/lang/Throwable
      //   204	243	313	java/lang/Throwable
      //   248	255	313	java/lang/Throwable
      //   255	295	313	java/lang/Throwable
      //   300	310	313	java/lang/Throwable
      //   400	410	313	java/lang/Throwable
      //   413	435	313	java/lang/Throwable
      //   489	608	313	java/lang/Throwable
      //   613	778	313	java/lang/Throwable
      //   778	928	313	java/lang/Throwable
      //   928	1051	313	java/lang/Throwable
      //   1056	1090	313	java/lang/Throwable
      //   1090	1113	313	java/lang/Throwable
      //   1114	1128	313	java/lang/Throwable
      //   1129	1152	313	java/lang/Throwable
      //   1153	1167	313	java/lang/Throwable
      //   1170	1182	313	java/lang/Throwable
      //   1185	1192	313	java/lang/Throwable
      //   489	608	1054	java/lang/Exception
      //   613	778	1168	java/lang/Exception
      //   7	18	1193	java/lang/Throwable
      //   18	44	1193	java/lang/Throwable
    }
    
    public void onSSOPingResponse(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte == null)
      {
        QLog.d(tag, 1, "MSF.C.CodecWarpper onSSOPingResponse error, data null");
        return;
      }
      if (paramArrayOfByte.length <= 4)
      {
        QLog.d(tag, 1, "MSF.C.CodecWarpper onSSOPingResponse error, length: " + paramArrayOfByte.length);
        return;
      }
      int i = paramArrayOfByte.length;
      Object localObject2;
      try
      {
        localObject1 = ByteBuffer.wrap(paramArrayOfByte);
        ((ByteBuffer)localObject1).getInt();
        ((ByteBuffer)localObject1).getInt();
        ((ByteBuffer)localObject1).getInt();
        j = ((ByteBuffer)localObject1).get();
        localObject2 = new byte[j];
        ((ByteBuffer)localObject1).get((byte[])localObject2, 0, j);
        if ((!new String((byte[])localObject2).equals("MSF")) && (com.tencent.mobileqq.msf.core.a.a.aP()))
        {
          boolean bool = com.tencent.mobileqq.msf.core.net.a.b.b();
          if (bool) {
            try
            {
              com.tencent.mobileqq.msf.core.net.a.b.b(paramArrayOfByte);
              return;
            }
            catch (Exception paramArrayOfByte)
            {
              QLog.d(tag, 1, "heartbeatproxy failed to process back msg ", paramArrayOfByte);
              return;
            }
          }
        }
        ((ByteBuffer)localObject1).position(((ByteBuffer)localObject1).get() + ((ByteBuffer)localObject1).position());
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        QLog.d(tag, 1, "MSF.C.CodecWarpper onSSOPingResponse error, exception : ", paramArrayOfByte);
        return;
      }
      int j = ((ByteBuffer)localObject1).getInt();
      new StringBuilder().append(j >> 24 & 0xFF).append('.').append(j >> 16 & 0xFF).append('.').append(j >> 8 & 0xFF).append('.').append(j & 0xFF).toString();
      Object localObject1 = af.this.a.o().g();
      af.this.a.a(true);
      long l1;
      if ((localObject1 != null) && (((ToServiceMsg)localObject1).getAttribute("__timestamp_msf2net") != null))
      {
        long l2 = SystemClock.elapsedRealtime() - ((Long)((ToServiceMsg)localObject1).getAttribute("__timestamp_msf2net")).longValue();
        l1 = l2;
        if (l2 >= 0L) {
          break label643;
        }
        l1 = 0L;
      }
      for (;;)
      {
        com.tencent.mobileqq.a.a.a.a().a(((ToServiceMsg)localObject1).getRequestSsoSeq(), l1);
        localObject2 = new StringBuilder();
        paramArrayOfByte = ((ToServiceMsg)localObject1).getServiceCmd();
        if (QLog.isDevelopLevel()) {
          if (l1 == 0L)
          {
            paramArrayOfByte = String.valueOf(l1);
            label386:
            QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + ((ToServiceMsg)localObject1).getRequestSsoSeq() + " uin:" + ((ToServiceMsg)localObject1).getUin() + " cmd:" + ((ToServiceMsg)localObject1).getServiceCmd() + " len:" + i + " costTime:" + paramArrayOfByte);
          }
        }
        for (;;)
        {
          for (;;)
          {
            if (0L == l1) {
              break label632;
            }
            try
            {
              if (!NetConnInfoCenter.isWifiConn()) {
                break;
              }
              af.this.a(af.this.x.format(Long.valueOf(System.currentTimeMillis())), l1);
              return;
            }
            catch (Exception paramArrayOfByte)
            {
              QLog.d(tag, 1, "failed to store connect wifi info " + paramArrayOfByte.toString());
              return;
            }
          }
          paramArrayOfByte = l1 + NetConnInfoCenter.getSignalStrengthsLog();
          break label386;
          QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + ((ToServiceMsg)localObject1).getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(((ToServiceMsg)localObject1).getUin()) + " cmd:" + com.tencent.mobileqq.msf.core.b.c.a(paramArrayOfByte) + new StringBuilder().append(" ").append(i + ((ToServiceMsg)localObject1).getRequestSsoSeq()).toString());
        }
        label632:
        break;
        label643:
        do
        {
          break;
          l1 = 0L;
          break;
        } while (l1 <= 2147483647L);
        l1 = 0L;
      }
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      int j;
      long l;
      synchronized (af.a(af.this))
      {
        j = af.this.g.size();
        i = j;
        if (j > af.this.i) {
          i = af.this.i;
        }
        l = SystemClock.elapsedRealtime();
        if (af.this.M >= l)
        {
          af.b(af.this).postDelayed(af.this.h, af.this.l);
          if ((!af.c(af.this)) && (af.this.g.size() - af.this.j > 0))
          {
            af.b(af.this).postDelayed(af.this.h, af.this.l);
            af.a(af.this, true);
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.NetConnTag", 4, "delayWaitSendList size is " + af.this.g.size() + ", " + i + " sso package should be merged.");
          }
          if (i <= 0) {
            break label1621;
          }
          j = i;
        }
        try
        {
          if (i > af.this.g.size()) {
            j = af.this.g.size();
          }
          if (j != 1) {
            break label348;
          }
          ??? = (ToServiceMsg)af.this.g.peek();
          if ((??? == null) || (((ToServiceMsg)???).getWupBuffer().length >= af.this.n)) {
            break label348;
          }
          af localaf = af.this;
          localaf.k -= ((ToServiceMsg)???).getWupBuffer().length;
          af.a(af.this, (ToServiceMsg)af.this.g.poll());
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            synchronized (af.a(af.this))
            {
              if ((af.this.k >= af.this.j) && (!af.c(af.this)))
              {
                af.a(af.this, true);
                af.b(af.this).post(af.this.h);
                if (i1 > 0)
                {
                  af.this.d.put(Integer.valueOf(((ToServiceMsg)???).getRequestSsoSeq()), localArrayList);
                  af.this.e.put(Integer.valueOf(((ToServiceMsg)???).getRequestSsoSeq()), localObject6);
                  localObject5 = ((SSOLoginMerge.BusiBuffData)localObject5).toByteArray();
                  localObject6 = new ByteArrayOutputStream();
                  com.tencent.qphone.base.util.j.a((byte[])localObject5, (OutputStream)localObject6);
                  localObject6 = af.b(((ByteArrayOutputStream)localObject6).toByteArray());
                  ((ToServiceMsg)???).putWupBuffer((byte[])localObject6);
                  ((ToServiceMsg)???).getAttributes().put("mergeCount", Integer.valueOf(i1));
                  ((ToServiceMsg)???).getAttributes().put("noRespCount", Integer.valueOf(j));
                  if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.NetConnTag", 4, "Delay ToServiceMsg ssoseq: " + ((ToServiceMsg)???).getRequestSsoSeq() + " delayWaitSendList buffer size is " + localObject5.length + ", zip size is " + localObject6.length);
                  }
                }
                if (??? == null) {
                  continue;
                }
                ((ToServiceMsg)???).addAttribute("__timestamp_addSendQueue", Long.valueOf(System.currentTimeMillis()));
                af.a(af.this, (ToServiceMsg)???);
                return;
                localException = localException;
                QLog.d("MSF.C.NetConnTag", 1, "add delayMsg to send error, close LoginMerge. " + localException, localException);
                af.this.q = false;
                if (af.this.g.size() <= 0) {
                  continue;
                }
                localToServiceMsg1 = (ToServiceMsg)af.this.g.poll();
                if (localToServiceMsg1 == null) {
                  continue;
                }
                af.a(af.this, localToServiceMsg1);
                continue;
                if ("RegPrxySvc.getOffMsg".equals(localToServiceMsg2.getServiceCmd()))
                {
                  localToServiceMsg1.getAttributes().put("infoLoginMsg", localToServiceMsg2);
                  continue;
                }
                if (!"RegPrxySvc.infoSync".equals(localToServiceMsg2.getServiceCmd())) {
                  continue;
                }
                localToServiceMsg1.getAttributes().put("infoLoginMsg", localToServiceMsg2);
                continue;
                ??? = af.this;
                ((af)???).k -= localToServiceMsg2.getWupBuffer().length;
                if (n == 0)
                {
                  localToServiceMsg1.setUin(localToServiceMsg2.getUin());
                  localBusiBuffItem = new SSOLoginMerge.BusiBuffItem();
                  localBusiBuffItem.SeqNo.set(localToServiceMsg2.getRequestSsoSeq());
                  localBusiBuffItem.ServiceCmd.set(localToServiceMsg2.getServiceCmd());
                  if (localToServiceMsg2.getWupBuffer().length < 4)
                  {
                    localBusiBuffItem.BusiBuffLen.set(af.b(localToServiceMsg2.getWupBuffer()).length);
                    if (localToServiceMsg2.getWupBuffer().length < 4) {
                      continue;
                    }
                    ??? = new byte[localToServiceMsg2.getWupBuffer().length - 4];
                    System.arraycopy(localToServiceMsg2.getWupBuffer(), 4, ???, 0, ???.length);
                    localBusiBuffItem.BusiBuff.set(ByteStringMicro.copyFrom((byte[])???));
                    localBusiBuffItem.NeedResp.set(localToServiceMsg2.isNeedCallback());
                    ((SSOLoginMerge.BusiBuffData)localObject5).BusiBuffVec.add(localBusiBuffItem);
                    localArrayList.add(Integer.valueOf(localToServiceMsg2.getRequestSsoSeq()));
                    ((ArrayList)localObject6).add(localToServiceMsg2);
                    af.this.c.put(Integer.valueOf(localToServiceMsg2.getRequestSsoSeq()), localToServiceMsg2);
                    localToServiceMsg2.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(af.q().incrementAndGet()));
                    if (localToServiceMsg2.getTimeout() != -1L) {
                      continue;
                    }
                    localToServiceMsg2.setTimeout(30000L);
                    ??? = af.this.F.msfAlarmer.a(localToServiceMsg2, localToServiceMsg2.getTimeout());
                    localToServiceMsg2.addAttribute("to_timeoutCallbacker", ???);
                    i1 = j;
                    i2 = i;
                    if (!com.tencent.mobileqq.msf.core.a.a.x()) {
                      break;
                    }
                    l = localToServiceMsg2.getTimeout() - com.tencent.mobileqq.msf.core.a.a.z();
                    i1 = j;
                    i2 = i;
                    if (l <= 0L) {
                      break;
                    }
                    localToServiceMsg2.addAttribute("to_predetect_timeoutCallbacker", af.this.F.msfAlarmer.b(localToServiceMsg2, l));
                    i1 = j;
                    i2 = i;
                    break;
                  }
                }
                else
                {
                  if (localToServiceMsg1.getUin().equals(localToServiceMsg2.getUin())) {
                    continue;
                  }
                  af.this.g.addFirst(localToServiceMsg2);
                  ??? = af.this;
                  i = ((af)???).k;
                  ((af)???).k = (localToServiceMsg2.getWupBuffer().length + i);
                  i1 = k;
                  continue;
                }
                localBusiBuffItem.BusiBuffLen.set(localToServiceMsg2.getWupBuffer().length);
                continue;
                ??? = localToServiceMsg2.getWupBuffer();
                continue;
                ??? = af.this.F.msfAlarmer.a(localToServiceMsg2, localToServiceMsg2.getTimeout());
                continue;
              }
              if ((!af.c(af.this)) && (af.this.g.size() >= af.this.i))
              {
                af.a(af.this, true);
                af.b(af.this).post(af.this.h);
              }
            }
            if ((!af.c(af.this)) && (!af.this.g.isEmpty()))
            {
              af.b(af.this).postDelayed(af.this.h, af.this.l);
              af.a(af.this, true);
            }
          }
          int k = i;
        }
        af.a(af.this, false);
      }
      label348:
      ??? = new ToServiceMsg("MSF SSOPackageMerge", af.d(af.this), "SSO.LoginMerge");
      ((ToServiceMsg)???).setAppId(MsfCore.mobileQQAppid);
      ((ToServiceMsg)???).setMsfCommand(MsfCommand.unknown);
      if (((ToServiceMsg)???).getRequestSsoSeq() == -1) {
        ((ToServiceMsg)???).setRequestSsoSeq(MsfCore.getNextSeq());
      }
      ((ToServiceMsg)???).setTimeout(30000L);
      ((ToServiceMsg)???).setNeedCallback(false);
      ArrayList localArrayList = new ArrayList();
      Object localObject6 = new ArrayList();
      Object localObject5 = new SSOLoginMerge.BusiBuffData();
      int i = j;
      if (i > af.this.g.size()) {
        k = af.this.g.size();
      }
      for (;;)
      {
        int i1 = k;
        j = i;
        ToServiceMsg localToServiceMsg2;
        int i2;
        if (n < k)
        {
          localToServiceMsg2 = (ToServiceMsg)af.this.g.poll();
          i1 = i;
          i2 = m;
          if (localToServiceMsg2 == null) {
            break label1647;
          }
          if (!"RegPrxySvc.infoLogin".equals(localToServiceMsg2.getServiceCmd())) {
            break label955;
          }
          ((ToServiceMsg)???).getAttributes().put("infoLoginMsg", localToServiceMsg2);
          j = i;
          if (!localToServiceMsg2.isNeedCallback()) {
            j = i + 1;
          }
          i = m + localToServiceMsg2.getWupBuffer().length;
          if ((i < af.this.j) || (n == 0)) {
            break label1015;
          }
          af.this.g.addFirst(localToServiceMsg2);
          i1 = n;
        }
        ToServiceMsg localToServiceMsg1;
        label955:
        label1015:
        SSOLoginMerge.BusiBuffItem localBusiBuffItem;
        label1621:
        localObject5 = null;
        localObject6 = null;
        localArrayList = null;
        Object localObject3 = null;
        break;
        int m = 0;
        i = 0;
        int n = 0;
        continue;
        label1647:
        n += 1;
        m = i2;
        i = i1;
      }
    }
  }
  
  class c
    extends Thread
  {
    long a = 0L;
    
    c() {}
    
    private void a(ToServiceMsg paramToServiceMsg, String paramString1, String paramString2)
    {
      af.this.c(paramToServiceMsg.getRequestSsoSeq());
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   4: getfield 40	com/tencent/mobileqq/msf/core/af:f	Ljava/util/concurrent/LinkedBlockingDeque;
      //   7: invokevirtual 46	java/util/concurrent/LinkedBlockingDeque:take	()Ljava/lang/Object;
      //   10: checkcast 24	com/tencent/qphone/base/remote/ToServiceMsg
      //   13: astore 17
      //   15: aload_0
      //   16: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   19: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   22: ifnull +33 -> 55
      //   25: aload_0
      //   26: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   29: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   32: getfield 56	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   35: ifnull +20 -> 55
      //   38: aload_0
      //   39: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   42: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   45: getfield 56	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   48: iconst_1
      //   49: invokeinterface 62 2 0
      //   54: pop
      //   55: aload 17
      //   57: ifnull +1050 -> 1107
      //   60: aload 17
      //   62: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   65: astore 15
      //   67: aload 15
      //   69: ldc 68
      //   71: invokevirtual 74	java/lang/String:indexOf	(Ljava/lang/String;)I
      //   74: istore_3
      //   75: iload_3
      //   76: iconst_m1
      //   77: if_icmpeq +2501 -> 2578
      //   80: new 76	java/lang/StringBuilder
      //   83: dup
      //   84: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   87: aload 15
      //   89: iload_3
      //   90: iconst_1
      //   91: iadd
      //   92: aload 15
      //   94: invokevirtual 80	java/lang/String:length	()I
      //   97: invokevirtual 84	java/lang/String:substring	(II)Ljava/lang/String;
      //   100: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   103: ldc 90
      //   105: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   108: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   111: astore 14
      //   113: aload 15
      //   115: iconst_0
      //   116: iload_3
      //   117: invokevirtual 84	java/lang/String:substring	(II)Ljava/lang/String;
      //   120: astore 15
      //   122: aload 17
      //   124: ldc 95
      //   126: lconst_0
      //   127: invokestatic 101	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   130: invokevirtual 105	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   133: checkcast 97	java/lang/Long
      //   136: invokevirtual 109	java/lang/Long:longValue	()J
      //   139: lstore 7
      //   141: invokestatic 114	java/lang/System:currentTimeMillis	()J
      //   144: lstore 9
      //   146: aload_0
      //   147: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   150: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   153: getfield 118	com/tencent/mobileqq/msf/core/MsfCore:configManager	Lcom/tencent/mobileqq/msf/core/a/a;
      //   156: aload 17
      //   158: lload 9
      //   160: invokevirtual 123	com/tencent/mobileqq/msf/core/a/a:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;J)V
      //   163: aload 17
      //   165: invokevirtual 127	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
      //   168: ifnull +1153 -> 1321
      //   171: iconst_0
      //   172: istore_2
      //   173: invokestatic 133	com/tencent/mobileqq/msf/core/NetConnInfoCenter:isWifiConn	()Z
      //   176: ifeq +543 -> 719
      //   179: iconst_1
      //   180: istore_1
      //   181: iload_1
      //   182: getstatic 137	com/tencent/mobileqq/msf/core/af:N	I
      //   185: if_icmpeq +18 -> 203
      //   188: iload_1
      //   189: putstatic 137	com/tencent/mobileqq/msf/core/af:N	I
      //   192: invokestatic 140	com/tencent/mobileqq/msf/core/af:g	()V
      //   195: ldc 142
      //   197: iconst_1
      //   198: ldc 144
      //   200: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   203: getstatic 155	com/tencent/mobileqq/msf/core/auth/d:f	Ljava/util/concurrent/ConcurrentHashMap;
      //   206: aload 17
      //   208: invokevirtual 158	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   211: invokevirtual 164	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
      //   214: ifeq +78 -> 292
      //   217: aload_0
      //   218: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   221: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   224: invokevirtual 168	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
      //   227: aload 17
      //   229: invokevirtual 158	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   232: invokevirtual 174	com/tencent/mobileqq/msf/core/auth/b:o	(Ljava/lang/String;)V
      //   235: getstatic 155	com/tencent/mobileqq/msf/core/auth/d:f	Ljava/util/concurrent/ConcurrentHashMap;
      //   238: aload 17
      //   240: invokevirtual 158	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   243: invokevirtual 178	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   246: pop
      //   247: ldc 142
      //   249: iconst_1
      //   250: new 76	java/lang/StringBuilder
      //   253: dup
      //   254: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   257: ldc 180
      //   259: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   262: aload 17
      //   264: invokevirtual 158	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   267: invokestatic 186	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
      //   270: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   273: ldc 188
      //   275: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   278: aload 17
      //   280: invokevirtual 28	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
      //   283: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   286: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   289: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   292: aload_0
      //   293: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   296: getfield 194	com/tencent/mobileqq/msf/core/af:a	Lcom/tencent/mobileqq/msf/core/net/m;
      //   299: invokevirtual 198	com/tencent/mobileqq/msf/core/net/m:b	()Z
      //   302: ifne +14 -> 316
      //   305: invokestatic 140	com/tencent/mobileqq/msf/core/af:g	()V
      //   308: ldc 142
      //   310: iconst_1
      //   311: ldc 200
      //   313: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   316: aload_0
      //   317: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   320: invokestatic 204	com/tencent/mobileqq/msf/core/af:e	(Lcom/tencent/mobileqq/msf/core/af;)Ljava/util/HashSet;
      //   323: aload 17
      //   325: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   328: invokevirtual 209	java/util/HashSet:contains	(Ljava/lang/Object;)Z
      //   331: ifeq +12 -> 343
      //   334: aload 17
      //   336: invokevirtual 158	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   339: iconst_0
      //   340: invokestatic 212	com/tencent/mobileqq/msf/core/af:a	(Ljava/lang/String;Z)V
      //   343: aload 17
      //   345: invokestatic 215	com/tencent/mobileqq/msf/core/af:f	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)[B
      //   348: astore 13
      //   350: aload 17
      //   352: invokevirtual 127	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
      //   355: ifnonnull +60 -> 415
      //   358: new 217	java/util/HashMap
      //   361: dup
      //   362: invokespecial 218	java/util/HashMap:<init>	()V
      //   365: astore 16
      //   367: aload 16
      //   369: ldc 220
      //   371: aload 17
      //   373: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   376: invokevirtual 224	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   379: pop
      //   380: aload_0
      //   381: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   384: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   387: invokevirtual 228	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/j;
      //   390: ifnull +25 -> 415
      //   393: aload_0
      //   394: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   397: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   400: invokevirtual 228	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/j;
      //   403: ldc 230
      //   405: iconst_0
      //   406: lconst_0
      //   407: lconst_0
      //   408: aload 16
      //   410: iconst_0
      //   411: iconst_0
      //   412: invokevirtual 235	com/tencent/mobileqq/msf/core/c/j:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
      //   415: invokestatic 238	com/tencent/mobileqq/msf/core/af:r	()Z
      //   418: ifne +51 -> 469
      //   421: invokestatic 243	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
      //   424: sipush 600
      //   427: if_icmpeq +37 -> 464
      //   430: aload_0
      //   431: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   434: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   437: invokevirtual 228	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/j;
      //   440: ifnull +24 -> 464
      //   443: aload_0
      //   444: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   447: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   450: invokevirtual 228	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/j;
      //   453: ldc 245
      //   455: iconst_0
      //   456: lconst_0
      //   457: lconst_0
      //   458: aconst_null
      //   459: iconst_0
      //   460: iconst_0
      //   461: invokevirtual 235	com/tencent/mobileqq/msf/core/c/j:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
      //   464: iconst_1
      //   465: invokestatic 248	com/tencent/mobileqq/msf/core/af:a	(Z)Z
      //   468: pop
      //   469: sipush 591
      //   472: invokestatic 243	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
      //   475: if_icmpne +782 -> 1257
      //   478: aload 17
      //   480: invokevirtual 28	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
      //   483: invokestatic 252	com/tencent/mobileqq/msf/core/t:d	()Ljava/lang/String;
      //   486: invokestatic 254	com/tencent/mobileqq/msf/core/t:f	()Ljava/lang/String;
      //   489: invokestatic 256	com/tencent/mobileqq/msf/core/t:g	()Ljava/lang/String;
      //   492: ldc_w 258
      //   495: aload 15
      //   497: aload_0
      //   498: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   501: invokevirtual 260	com/tencent/mobileqq/msf/core/af:e	()[B
      //   504: aload 17
      //   506: invokevirtual 263	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
      //   509: aload_0
      //   510: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   513: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   516: invokevirtual 266	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
      //   519: aload 17
      //   521: invokevirtual 158	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   524: iconst_0
      //   525: iload_1
      //   526: aload 17
      //   528: invokevirtual 127	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
      //   531: iconst_0
      //   532: invokestatic 270	com/tencent/qphone/base/util/CodecWarpper:nativeEncodeRequest	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BIILjava/lang/String;BB[BZ)[B
      //   535: astore 13
      //   537: aload 13
      //   539: ifnull +21 -> 560
      //   542: aload 17
      //   544: invokevirtual 274	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
      //   547: ldc_w 276
      //   550: aload 13
      //   552: arraylength
      //   553: invokestatic 281	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   556: invokevirtual 224	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   559: pop
      //   560: ldc 142
      //   562: iconst_1
      //   563: new 76	java/lang/StringBuilder
      //   566: dup
      //   567: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   570: ldc_w 283
      //   573: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   576: aload 17
      //   578: invokevirtual 28	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
      //   581: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   584: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   587: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   590: aload 13
      //   592: astore 16
      //   594: aload 17
      //   596: ifnull +32 -> 628
      //   599: aload 13
      //   601: astore 16
      //   603: aload 17
      //   605: invokevirtual 28	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
      //   608: ifne +20 -> 628
      //   611: getstatic 286	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   614: invokevirtual 228	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/j;
      //   617: iconst_1
      //   618: aload 17
      //   620: aconst_null
      //   621: invokevirtual 289	com/tencent/mobileqq/msf/core/c/j:a	(ZLcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
      //   624: aload 13
      //   626: astore 16
      //   628: aload 16
      //   630: ifnonnull +699 -> 1329
      //   633: ldc 142
      //   635: iconst_1
      //   636: new 76	java/lang/StringBuilder
      //   639: dup
      //   640: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   643: ldc_w 291
      //   646: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   649: aload 17
      //   651: invokevirtual 294	com/tencent/qphone/base/remote/ToServiceMsg:getStringForLog	()Ljava/lang/String;
      //   654: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   657: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   660: invokestatic 297	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
      //   663: aload_0
      //   664: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   667: aload 17
      //   669: invokevirtual 28	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
      //   672: invokevirtual 31	com/tencent/mobileqq/msf/core/af:c	(I)Lcom/tencent/qphone/base/remote/ToServiceMsg;
      //   675: pop
      //   676: aload_0
      //   677: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   680: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   683: ifnull -683 -> 0
      //   686: aload_0
      //   687: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   690: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   693: getfield 56	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   696: ifnull -696 -> 0
      //   699: aload_0
      //   700: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   703: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   706: getfield 56	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   709: iconst_1
      //   710: invokeinterface 300 2 0
      //   715: pop
      //   716: goto -716 -> 0
      //   719: invokestatic 303	com/tencent/mobileqq/msf/core/NetConnInfoCenter:isMobileConn	()Z
      //   722: ifeq +70 -> 792
      //   725: invokestatic 306	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getMobileNetworkType	()I
      //   728: bipush 100
      //   730: iadd
      //   731: istore 4
      //   733: iload 4
      //   735: istore_3
      //   736: iload 4
      //   738: sipush 254
      //   741: if_icmple +1843 -> 2584
      //   744: sipush 254
      //   747: istore 4
      //   749: iload 4
      //   751: istore_3
      //   752: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   755: ifeq +1829 -> 2584
      //   758: ldc 142
      //   760: iconst_2
      //   761: new 76	java/lang/StringBuilder
      //   764: dup
      //   765: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   768: ldc_w 311
      //   771: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   774: sipush 254
      //   777: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   780: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   783: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   786: iload 4
      //   788: istore_3
      //   789: goto +1795 -> 2584
      //   792: aload_0
      //   793: getfield 20	com/tencent/mobileqq/msf/core/af$c:a	J
      //   796: lconst_0
      //   797: lcmp
      //   798: ifeq +19 -> 817
      //   801: iload_2
      //   802: istore_1
      //   803: lload 9
      //   805: aload_0
      //   806: getfield 20	com/tencent/mobileqq/msf/core/af$c:a	J
      //   809: lsub
      //   810: ldc2_w 312
      //   813: lcmp
      //   814: ifle -633 -> 181
      //   817: aload_0
      //   818: lload 9
      //   820: putfield 20	com/tencent/mobileqq/msf/core/af$c:a	J
      //   823: invokestatic 319	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
      //   826: iconst_1
      //   827: invokestatic 323	com/tencent/mobileqq/msf/core/NetConnInfoCenter:checkConnInfo	(Landroid/content/Context;Z)V
      //   830: iload_2
      //   831: istore_1
      //   832: goto -651 -> 181
      //   835: astore 13
      //   837: ldc 142
      //   839: iconst_1
      //   840: new 76	java/lang/StringBuilder
      //   843: dup
      //   844: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   847: ldc_w 325
      //   850: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   853: aload 13
      //   855: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   858: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   861: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   864: iload_2
      //   865: istore_1
      //   866: goto -685 -> 181
      //   869: astore 13
      //   871: ldc 142
      //   873: iconst_1
      //   874: aload 13
      //   876: invokevirtual 329	java/lang/Throwable:toString	()Ljava/lang/String;
      //   879: aload 13
      //   881: invokestatic 332	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   884: aload_0
      //   885: aload 17
      //   887: ldc_w 334
      //   890: aload 13
      //   892: invokevirtual 329	java/lang/Throwable:toString	()Ljava/lang/String;
      //   895: invokespecial 336	com/tencent/mobileqq/msf/core/af$c:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Ljava/lang/String;Ljava/lang/String;)V
      //   898: aload_0
      //   899: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   902: getfield 40	com/tencent/mobileqq/msf/core/af:f	Ljava/util/concurrent/LinkedBlockingDeque;
      //   905: aload 17
      //   907: invokevirtual 338	java/util/concurrent/LinkedBlockingDeque:remove	(Ljava/lang/Object;)Z
      //   910: pop
      //   911: aload_0
      //   912: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   915: invokestatic 341	com/tencent/mobileqq/msf/core/af:f	(Lcom/tencent/mobileqq/msf/core/af;)J
      //   918: pop2
      //   919: aload 17
      //   921: invokevirtual 345	com/tencent/qphone/base/remote/ToServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
      //   924: astore 13
      //   926: getstatic 351	com/tencent/mobileqq/msf/sdk/MsfCommand:_msf_kickedAndCleanTokenResp	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
      //   929: astore 14
      //   931: aload 13
      //   933: aload 14
      //   935: if_acmpne +172 -> 1107
      //   938: aload 17
      //   940: aload 17
      //   942: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   945: invokevirtual 354	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
      //   948: checkcast 356	com/tencent/qphone/base/remote/FromServiceMsg
      //   951: astore 13
      //   953: ldc 142
      //   955: iconst_1
      //   956: new 76	java/lang/StringBuilder
      //   959: dup
      //   960: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   963: invokestatic 360	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   966: invokevirtual 363	java/lang/Thread:getName	()Ljava/lang/String;
      //   969: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   972: ldc_w 365
      //   975: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   978: aload 13
      //   980: invokevirtual 366	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
      //   983: invokestatic 186	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
      //   986: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   989: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   992: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   995: aload_0
      //   996: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   999: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1002: invokevirtual 168	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
      //   1005: aload 13
      //   1007: invokevirtual 366	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
      //   1010: invokevirtual 369	com/tencent/mobileqq/msf/core/auth/b:k	(Ljava/lang/String;)V
      //   1013: aload 13
      //   1015: sipush 2012
      //   1018: aload 13
      //   1020: invokevirtual 372	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
      //   1023: invokevirtual 376	com/tencent/qphone/base/remote/FromServiceMsg:setBusinessFail	(ILjava/lang/String;)V
      //   1026: iconst_0
      //   1027: istore 11
      //   1029: aload 17
      //   1031: invokevirtual 274	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
      //   1034: ldc_w 378
      //   1037: invokevirtual 379	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
      //   1040: ifeq +19 -> 1059
      //   1043: aload 17
      //   1045: ldc_w 378
      //   1048: invokevirtual 354	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
      //   1051: checkcast 381	java/lang/Boolean
      //   1054: invokevirtual 384	java/lang/Boolean:booleanValue	()Z
      //   1057: istore 11
      //   1059: aload 13
      //   1061: ldc_w 378
      //   1064: iload 11
      //   1066: invokestatic 387	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   1069: invokevirtual 390	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   1072: pop
      //   1073: ldc_w 392
      //   1076: aload 13
      //   1078: invokestatic 396	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:addFromMsgProcessName	(Ljava/lang/String;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
      //   1081: aload_0
      //   1082: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   1085: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1088: aconst_null
      //   1089: aload 13
      //   1091: invokevirtual 400	com/tencent/mobileqq/msf/core/MsfCore:addRespToQuque	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
      //   1094: aload_0
      //   1095: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   1098: getfield 194	com/tencent/mobileqq/msf/core/af:a	Lcom/tencent/mobileqq/msf/core/net/m;
      //   1101: getstatic 405	com/tencent/qphone/base/a:a	Lcom/tencent/qphone/base/a;
      //   1104: invokevirtual 408	com/tencent/mobileqq/msf/core/net/m:a	(Lcom/tencent/qphone/base/a;)V
      //   1107: aload_0
      //   1108: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   1111: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1114: ifnull +33 -> 1147
      //   1117: aload_0
      //   1118: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   1121: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1124: getfield 56	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   1127: ifnull +20 -> 1147
      //   1130: aload_0
      //   1131: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   1134: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1137: getfield 56	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   1140: iconst_1
      //   1141: invokeinterface 300 2 0
      //   1146: pop
      //   1147: ldc2_w 409
      //   1150: invokestatic 414	java/lang/Thread:sleep	(J)V
      //   1153: aload_0
      //   1154: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   1157: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1160: ifnull -1160 -> 0
      //   1163: aload_0
      //   1164: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   1167: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1170: getfield 56	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   1173: ifnull -1173 -> 0
      //   1176: aload_0
      //   1177: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   1180: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1183: getfield 56	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   1186: iconst_1
      //   1187: invokeinterface 300 2 0
      //   1192: pop
      //   1193: goto -1193 -> 0
      //   1196: astore 16
      //   1198: ldc 142
      //   1200: iconst_1
      //   1201: ldc_w 416
      //   1204: aload 16
      //   1206: invokestatic 332	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   1209: goto -740 -> 469
      //   1212: astore 13
      //   1214: aload_0
      //   1215: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   1218: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1221: ifnull +33 -> 1254
      //   1224: aload_0
      //   1225: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   1228: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1231: getfield 56	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   1234: ifnull +20 -> 1254
      //   1237: aload_0
      //   1238: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   1241: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1244: getfield 56	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   1247: iconst_1
      //   1248: invokeinterface 300 2 0
      //   1253: pop
      //   1254: aload 13
      //   1256: athrow
      //   1257: aload 17
      //   1259: invokevirtual 28	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
      //   1262: invokestatic 252	com/tencent/mobileqq/msf/core/t:d	()Ljava/lang/String;
      //   1265: invokestatic 254	com/tencent/mobileqq/msf/core/t:f	()Ljava/lang/String;
      //   1268: invokestatic 256	com/tencent/mobileqq/msf/core/t:g	()Ljava/lang/String;
      //   1271: ldc_w 258
      //   1274: aload 15
      //   1276: aload_0
      //   1277: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   1280: invokevirtual 260	com/tencent/mobileqq/msf/core/af:e	()[B
      //   1283: aload 17
      //   1285: invokevirtual 263	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
      //   1288: aload_0
      //   1289: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   1292: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1295: invokevirtual 266	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
      //   1298: aload 17
      //   1300: invokevirtual 158	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   1303: iconst_0
      //   1304: iload_1
      //   1305: aload 13
      //   1307: aload 17
      //   1309: invokevirtual 127	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
      //   1312: iconst_0
      //   1313: invokestatic 419	com/tencent/qphone/base/util/CodecWarpper:nativeEncodeRequest	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BIILjava/lang/String;BB[B[BZ)[B
      //   1316: astore 13
      //   1318: goto -781 -> 537
      //   1321: iconst_0
      //   1322: newarray byte
      //   1324: astore 16
      //   1326: goto -698 -> 628
      //   1329: aload 17
      //   1331: invokevirtual 158	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   1334: ldc_w 421
      //   1337: invokevirtual 424	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1340: ifne +1250 -> 2590
      //   1343: aload 17
      //   1345: ldc_w 426
      //   1348: iconst_0
      //   1349: invokestatic 387	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   1352: invokevirtual 105	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   1355: checkcast 381	java/lang/Boolean
      //   1358: invokevirtual 384	java/lang/Boolean:booleanValue	()Z
      //   1361: ifne +1229 -> 2590
      //   1364: aload 17
      //   1366: invokevirtual 263	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
      //   1369: iconst_m1
      //   1370: if_icmpeq +1220 -> 2590
      //   1373: aload 17
      //   1375: invokevirtual 263	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
      //   1378: bipush 100
      //   1380: if_icmpeq +1210 -> 2590
      //   1383: aload_0
      //   1384: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   1387: aload 17
      //   1389: invokestatic 429	com/tencent/mobileqq/msf/core/af:b	(Lcom/tencent/mobileqq/msf/core/af;Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
      //   1392: goto +1198 -> 2590
      //   1395: iload 11
      //   1397: ifne -478 -> 919
      //   1400: invokestatic 114	java/lang/System:currentTimeMillis	()J
      //   1403: lstore 9
      //   1405: lload 9
      //   1407: lload 7
      //   1409: lsub
      //   1410: aload 17
      //   1412: invokevirtual 432	com/tencent/qphone/base/remote/ToServiceMsg:getTimeout	()J
      //   1415: lcmp
      //   1416: ifle +39 -> 1455
      //   1419: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1422: ifeq -503 -> 919
      //   1425: ldc 142
      //   1427: iconst_2
      //   1428: new 76	java/lang/StringBuilder
      //   1431: dup
      //   1432: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   1435: aload 17
      //   1437: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   1440: ldc_w 434
      //   1443: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1446: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1449: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1452: goto -533 -> 919
      //   1455: getstatic 437	com/tencent/mobileqq/msf/core/af:S	J
      //   1458: lconst_0
      //   1459: lcmp
      //   1460: ifeq +114 -> 1574
      //   1463: lload 9
      //   1465: getstatic 437	com/tencent/mobileqq/msf/core/af:S	J
      //   1468: lsub
      //   1469: invokestatic 440	com/tencent/mobileqq/msf/core/a/a:Q	()I
      //   1472: i2l
      //   1473: lcmp
      //   1474: ifle +100 -> 1574
      //   1477: aload_0
      //   1478: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   1481: getfield 194	com/tencent/mobileqq/msf/core/af:a	Lcom/tencent/mobileqq/msf/core/net/m;
      //   1484: invokevirtual 198	com/tencent/mobileqq/msf/core/net/m:b	()Z
      //   1487: ifeq +87 -> 1574
      //   1490: getstatic 437	com/tencent/mobileqq/msf/core/af:S	J
      //   1493: aload_0
      //   1494: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   1497: getfield 194	com/tencent/mobileqq/msf/core/af:a	Lcom/tencent/mobileqq/msf/core/net/m;
      //   1500: invokevirtual 443	com/tencent/mobileqq/msf/core/net/m:o	()Lcom/tencent/mobileqq/msf/core/net/l;
      //   1503: invokevirtual 447	com/tencent/mobileqq/msf/core/net/l:d	()J
      //   1506: lcmp
      //   1507: iflt +408 -> 1915
      //   1510: lconst_0
      //   1511: putstatic 437	com/tencent/mobileqq/msf/core/af:S	J
      //   1514: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1517: ifeq +47 -> 1564
      //   1520: ldc 142
      //   1522: iconst_2
      //   1523: new 76	java/lang/StringBuilder
      //   1526: dup
      //   1527: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   1530: ldc_w 449
      //   1533: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1536: invokestatic 114	java/lang/System:currentTimeMillis	()J
      //   1539: getstatic 437	com/tencent/mobileqq/msf/core/af:S	J
      //   1542: lsub
      //   1543: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1546: ldc_w 454
      //   1549: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1552: invokestatic 440	com/tencent/mobileqq/msf/core/a/a:Q	()I
      //   1555: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1558: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1561: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1564: aload_0
      //   1565: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   1568: getstatic 456	com/tencent/qphone/base/a:o	Lcom/tencent/qphone/base/a;
      //   1571: invokevirtual 457	com/tencent/mobileqq/msf/core/af:a	(Lcom/tencent/qphone/base/a;)V
      //   1574: getstatic 437	com/tencent/mobileqq/msf/core/af:S	J
      //   1577: lconst_0
      //   1578: lcmp
      //   1579: ifeq +85 -> 1664
      //   1582: lload 9
      //   1584: getstatic 437	com/tencent/mobileqq/msf/core/af:S	J
      //   1587: lsub
      //   1588: ldc2_w 458
      //   1591: lcmp
      //   1592: ifle +72 -> 1664
      //   1595: aload_0
      //   1596: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   1599: getfield 194	com/tencent/mobileqq/msf/core/af:a	Lcom/tencent/mobileqq/msf/core/net/m;
      //   1602: invokevirtual 198	com/tencent/mobileqq/msf/core/net/m:b	()Z
      //   1605: ifeq +59 -> 1664
      //   1608: getstatic 437	com/tencent/mobileqq/msf/core/af:S	J
      //   1611: aload_0
      //   1612: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   1615: getfield 194	com/tencent/mobileqq/msf/core/af:a	Lcom/tencent/mobileqq/msf/core/net/m;
      //   1618: invokevirtual 443	com/tencent/mobileqq/msf/core/net/m:o	()Lcom/tencent/mobileqq/msf/core/net/l;
      //   1621: invokevirtual 447	com/tencent/mobileqq/msf/core/net/l:d	()J
      //   1624: lcmp
      //   1625: iflt +39 -> 1664
      //   1628: aload_0
      //   1629: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   1632: getfield 463	com/tencent/mobileqq/msf/core/af:O	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   1635: invokevirtual 468	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   1638: ifne +26 -> 1664
      //   1641: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1644: ifeq +12 -> 1656
      //   1647: ldc 142
      //   1649: iconst_2
      //   1650: ldc_w 470
      //   1653: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1656: aload_0
      //   1657: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   1660: iconst_0
      //   1661: invokestatic 473	com/tencent/mobileqq/msf/core/af:b	(Lcom/tencent/mobileqq/msf/core/af;Z)V
      //   1664: aload 17
      //   1666: ldc_w 475
      //   1669: invokestatic 480	android/os/SystemClock:elapsedRealtime	()J
      //   1672: invokestatic 101	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   1675: invokevirtual 481	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   1678: pop
      //   1679: aload 17
      //   1681: ldc_w 483
      //   1684: lconst_0
      //   1685: invokestatic 101	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   1688: invokevirtual 481	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   1691: pop
      //   1692: aload 17
      //   1694: ldc_w 485
      //   1697: getstatic 489	com/tencent/mobileqq/msf/core/af:G	Ljava/lang/String;
      //   1700: invokevirtual 481	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   1703: pop
      //   1704: aload 17
      //   1706: ldc_w 491
      //   1709: getstatic 494	com/tencent/mobileqq/msf/core/af:H	Ljava/lang/String;
      //   1712: invokevirtual 481	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   1715: pop
      //   1716: aload_0
      //   1717: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   1720: invokestatic 114	java/lang/System:currentTimeMillis	()J
      //   1723: invokestatic 497	com/tencent/mobileqq/msf/core/af:a	(Lcom/tencent/mobileqq/msf/core/af;J)J
      //   1726: pop2
      //   1727: aload_0
      //   1728: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   1731: getfield 194	com/tencent/mobileqq/msf/core/af:a	Lcom/tencent/mobileqq/msf/core/net/m;
      //   1734: aload 17
      //   1736: invokevirtual 263	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
      //   1739: aload 17
      //   1741: invokevirtual 500	com/tencent/qphone/base/remote/ToServiceMsg:getAppSeq	()I
      //   1744: aload 15
      //   1746: aload 14
      //   1748: aload 17
      //   1750: invokevirtual 345	com/tencent/qphone/base/remote/ToServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
      //   1753: aload 17
      //   1755: invokevirtual 158	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   1758: aload 17
      //   1760: invokevirtual 28	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
      //   1763: aload 16
      //   1765: aload 17
      //   1767: invokevirtual 503	com/tencent/mobileqq/msf/core/net/m:a	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/msf/sdk/MsfCommand;Ljava/lang/String;I[BLcom/tencent/qphone/base/remote/ToServiceMsg;)Z
      //   1770: istore 12
      //   1772: iload 12
      //   1774: istore 11
      //   1776: aload_0
      //   1777: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   1780: invokestatic 506	android/os/SystemClock:uptimeMillis	()J
      //   1783: invokestatic 508	com/tencent/mobileqq/msf/core/af:b	(Lcom/tencent/mobileqq/msf/core/af;J)J
      //   1786: pop2
      //   1787: iload 11
      //   1789: ifne +183 -> 1972
      //   1792: aload 17
      //   1794: invokevirtual 274	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
      //   1797: ldc_w 475
      //   1800: invokevirtual 509	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1803: pop
      //   1804: aload 17
      //   1806: invokevirtual 274	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
      //   1809: ldc_w 483
      //   1812: invokevirtual 509	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1815: pop
      //   1816: aload 17
      //   1818: invokevirtual 274	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
      //   1821: ldc_w 485
      //   1824: invokevirtual 509	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1827: pop
      //   1828: aload 17
      //   1830: invokevirtual 274	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
      //   1833: ldc_w 491
      //   1836: invokevirtual 509	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1839: pop
      //   1840: aload 17
      //   1842: invokevirtual 274	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
      //   1845: ldc_w 511
      //   1848: iconst_1
      //   1849: invokestatic 387	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   1852: invokevirtual 224	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1855: pop
      //   1856: invokestatic 309	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1859: ifeq +34 -> 1893
      //   1862: ldc 142
      //   1864: iconst_2
      //   1865: new 76	java/lang/StringBuilder
      //   1868: dup
      //   1869: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   1872: invokestatic 360	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   1875: invokevirtual 363	java/lang/Thread:getName	()Ljava/lang/String;
      //   1878: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1881: ldc_w 513
      //   1884: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1887: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1890: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1893: aload_0
      //   1894: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   1897: getfield 194	com/tencent/mobileqq/msf/core/af:a	Lcom/tencent/mobileqq/msf/core/net/m;
      //   1900: getstatic 515	com/tencent/qphone/base/a:d	Lcom/tencent/qphone/base/a;
      //   1903: invokevirtual 408	com/tencent/mobileqq/msf/core/net/m:a	(Lcom/tencent/qphone/base/a;)V
      //   1906: getstatic 520	com/tencent/qphone/base/BaseConstants:reSendIntrevTime	J
      //   1909: invokestatic 414	java/lang/Thread:sleep	(J)V
      //   1912: goto -517 -> 1395
      //   1915: lconst_0
      //   1916: putstatic 437	com/tencent/mobileqq/msf/core/af:S	J
      //   1919: goto -345 -> 1574
      //   1922: ldc 142
      //   1924: iconst_1
      //   1925: new 76	java/lang/StringBuilder
      //   1928: dup
      //   1929: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   1932: ldc_w 522
      //   1935: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1938: aload 13
      //   1940: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   1943: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1946: aload 13
      //   1948: invokestatic 332	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   1951: goto -164 -> 1787
      //   1954: astore 13
      //   1956: ldc 142
      //   1958: iconst_1
      //   1959: aload 13
      //   1961: invokevirtual 523	java/lang/Exception:toString	()Ljava/lang/String;
      //   1964: aload 13
      //   1966: invokestatic 332	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   1969: goto -574 -> 1395
      //   1972: aload 17
      //   1974: ldc_w 483
      //   1977: invokestatic 114	java/lang/System:currentTimeMillis	()J
      //   1980: invokestatic 101	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   1983: invokevirtual 481	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   1986: pop
      //   1987: iconst_0
      //   1988: istore_3
      //   1989: iconst_0
      //   1990: istore 4
      //   1992: iconst_0
      //   1993: istore 5
      //   1995: ldc_w 525
      //   1998: aload 15
      //   2000: invokevirtual 424	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2003: istore 12
      //   2005: iload 12
      //   2007: ifeq +464 -> 2471
      //   2010: iload 4
      //   2012: istore_3
      //   2013: aload 17
      //   2015: invokevirtual 274	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
      //   2018: ldc_w 527
      //   2021: invokevirtual 529	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   2024: checkcast 278	java/lang/Integer
      //   2027: invokevirtual 532	java/lang/Integer:intValue	()I
      //   2030: istore 4
      //   2032: iload 4
      //   2034: istore_3
      //   2035: aload 17
      //   2037: invokevirtual 274	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
      //   2040: ldc_w 534
      //   2043: invokevirtual 529	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   2046: checkcast 278	java/lang/Integer
      //   2049: invokevirtual 532	java/lang/Integer:intValue	()I
      //   2052: istore 6
      //   2054: iload 6
      //   2056: istore_3
      //   2057: iload_3
      //   2058: istore 5
      //   2060: ldc_w 525
      //   2063: aload 15
      //   2065: invokevirtual 424	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2068: ifne +17 -> 2085
      //   2071: iload_3
      //   2072: istore 5
      //   2074: aload 17
      //   2076: invokevirtual 537	com/tencent/qphone/base/remote/ToServiceMsg:isNeedCallback	()Z
      //   2079: ifne +6 -> 2085
      //   2082: iconst_1
      //   2083: istore 5
      //   2085: aload 15
      //   2087: aload 17
      //   2089: invokevirtual 28	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
      //   2092: aload 16
      //   2094: arraylength
      //   2095: i2l
      //   2096: iload 4
      //   2098: iload 5
      //   2100: invokestatic 542	com/tencent/mobileqq/a/a/f:a	(Ljava/lang/String;IJII)V
      //   2103: aload 17
      //   2105: invokevirtual 158	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   2108: ifnull +265 -> 2373
      //   2111: aload 17
      //   2113: invokevirtual 158	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   2116: invokevirtual 80	java/lang/String:length	()I
      //   2119: iconst_4
      //   2120: if_icmple +253 -> 2373
      //   2123: aload 17
      //   2125: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   2128: ldc_w 544
      //   2131: invokevirtual 548	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   2134: ifne +239 -> 2373
      //   2137: aload 17
      //   2139: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   2142: ldc_w 550
      //   2145: invokevirtual 548	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   2148: ifne +225 -> 2373
      //   2151: aload 17
      //   2153: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   2156: ldc_w 552
      //   2159: invokevirtual 424	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2162: ifne +211 -> 2373
      //   2165: aload 17
      //   2167: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   2170: ldc_w 554
      //   2173: invokevirtual 424	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2176: ifne +197 -> 2373
      //   2179: aload 17
      //   2181: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   2184: ldc_w 556
      //   2187: invokevirtual 424	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2190: ifne +183 -> 2373
      //   2193: aload 17
      //   2195: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   2198: ldc_w 558
      //   2201: invokevirtual 424	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2204: ifne +169 -> 2373
      //   2207: aload 17
      //   2209: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   2212: ldc_w 560
      //   2215: invokevirtual 424	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2218: ifne +155 -> 2373
      //   2221: aload 17
      //   2223: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   2226: ldc_w 562
      //   2229: invokevirtual 424	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2232: ifne +141 -> 2373
      //   2235: aload 17
      //   2237: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   2240: ldc_w 564
      //   2243: invokevirtual 424	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2246: ifne +127 -> 2373
      //   2249: getstatic 568	com/tencent/mobileqq/msf/core/af:ad	Ljava/util/concurrent/CopyOnWriteArraySet;
      //   2252: aload 17
      //   2254: invokevirtual 158	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   2257: invokevirtual 571	java/util/concurrent/CopyOnWriteArraySet:contains	(Ljava/lang/Object;)Z
      //   2260: ifne +113 -> 2373
      //   2263: getstatic 574	com/tencent/mobileqq/msf/core/af:t	Ljava/util/concurrent/ConcurrentHashMap;
      //   2266: aload 17
      //   2268: invokevirtual 158	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   2271: invokevirtual 575	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   2274: ifnonnull +26 -> 2300
      //   2277: new 577	java/util/concurrent/ConcurrentLinkedQueue
      //   2280: dup
      //   2281: invokespecial 578	java/util/concurrent/ConcurrentLinkedQueue:<init>	()V
      //   2284: astore 13
      //   2286: getstatic 574	com/tencent/mobileqq/msf/core/af:t	Ljava/util/concurrent/ConcurrentHashMap;
      //   2289: aload 17
      //   2291: invokevirtual 158	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   2294: aload 13
      //   2296: invokevirtual 579	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2299: pop
      //   2300: getstatic 574	com/tencent/mobileqq/msf/core/af:t	Ljava/util/concurrent/ConcurrentHashMap;
      //   2303: aload 17
      //   2305: invokevirtual 158	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   2308: invokevirtual 575	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   2311: checkcast 577	java/util/concurrent/ConcurrentLinkedQueue
      //   2314: aload 17
      //   2316: invokevirtual 28	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
      //   2319: invokestatic 281	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2322: invokevirtual 582	java/util/concurrent/ConcurrentLinkedQueue:offer	(Ljava/lang/Object;)Z
      //   2325: pop
      //   2326: ldc 142
      //   2328: iconst_1
      //   2329: new 76	java/lang/StringBuilder
      //   2332: dup
      //   2333: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   2336: ldc_w 584
      //   2339: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2342: aload 17
      //   2344: invokevirtual 28	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
      //   2347: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2350: ldc_w 586
      //   2353: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2356: aload 17
      //   2358: invokevirtual 158	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   2361: invokestatic 186	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
      //   2364: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2367: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2370: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   2373: aload 17
      //   2375: invokevirtual 66	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   2378: ldc_w 588
      //   2381: invokevirtual 548	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   2384: ifeq +9 -> 2393
      //   2387: invokestatic 480	android/os/SystemClock:elapsedRealtime	()J
      //   2390: putstatic 591	com/tencent/mobileqq/msf/core/af:K	J
      //   2393: aload_0
      //   2394: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   2397: getfield 594	com/tencent/mobileqq/msf/core/af:Z	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   2400: invokevirtual 468	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   2403: ifeq +198 -> 2601
      //   2406: aload_0
      //   2407: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   2410: getfield 597	com/tencent/mobileqq/msf/core/af:Y	I
      //   2413: iconst_m1
      //   2414: if_icmpne +187 -> 2601
      //   2417: aload_0
      //   2418: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   2421: aload 17
      //   2423: invokevirtual 28	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
      //   2426: putfield 597	com/tencent/mobileqq/msf/core/af:Y	I
      //   2429: ldc 142
      //   2431: iconst_1
      //   2432: new 76	java/lang/StringBuilder
      //   2435: dup
      //   2436: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   2439: ldc_w 599
      //   2442: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2445: aload_0
      //   2446: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   2449: getfield 597	com/tencent/mobileqq/msf/core/af:Y	I
      //   2452: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2455: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2458: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   2461: goto +140 -> 2601
      //   2464: astore 13
      //   2466: aload 13
      //   2468: invokevirtual 602	java/lang/Exception:printStackTrace	()V
      //   2471: iload_3
      //   2472: istore 4
      //   2474: iload 5
      //   2476: istore_3
      //   2477: goto -420 -> 2057
      //   2480: astore 13
      //   2482: ldc 142
      //   2484: iconst_1
      //   2485: new 76	java/lang/StringBuilder
      //   2488: dup
      //   2489: invokespecial 77	java/lang/StringBuilder:<init>	()V
      //   2492: ldc_w 604
      //   2495: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2498: aload 13
      //   2500: invokevirtual 523	java/lang/Exception:toString	()Ljava/lang/String;
      //   2503: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2506: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2509: invokestatic 606	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   2512: goto -1405 -> 1107
      //   2515: astore 13
      //   2517: ldc 142
      //   2519: iconst_1
      //   2520: aload 13
      //   2522: invokevirtual 329	java/lang/Throwable:toString	()Ljava/lang/String;
      //   2525: aload 13
      //   2527: invokestatic 332	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   2530: aload_0
      //   2531: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   2534: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   2537: ifnull -2537 -> 0
      //   2540: aload_0
      //   2541: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   2544: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   2547: getfield 56	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   2550: ifnull -2550 -> 0
      //   2553: aload_0
      //   2554: getfield 15	com/tencent/mobileqq/msf/core/af$c:b	Lcom/tencent/mobileqq/msf/core/af;
      //   2557: getfield 50	com/tencent/mobileqq/msf/core/af:F	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   2560: getfield 56	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   2563: iconst_1
      //   2564: invokeinterface 300 2 0
      //   2569: pop
      //   2570: goto -2570 -> 0
      //   2573: astore 13
      //   2575: goto -653 -> 1922
      //   2578: aconst_null
      //   2579: astore 14
      //   2581: goto -2459 -> 122
      //   2584: iload_3
      //   2585: i2b
      //   2586: istore_1
      //   2587: goto -2406 -> 181
      //   2590: iconst_0
      //   2591: istore 11
      //   2593: goto -1198 -> 1395
      //   2596: astore 13
      //   2598: goto -676 -> 1922
      //   2601: goto -1206 -> 1395
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	2604	0	this	c
      //   180	1125	1	i	int
      //   2586	1	1	j	int
      //   172	693	2	k	int
      //   74	2511	3	m	int
      //   731	1742	4	n	int
      //   1993	482	5	i1	int
      //   2052	3	6	i2	int
      //   139	1269	7	l1	long
      //   144	1439	9	l2	long
      //   1027	1565	11	bool1	boolean
      //   1770	236	12	bool2	boolean
      //   348	277	13	arrayOfByte1	byte[]
      //   835	19	13	localException1	Exception
      //   869	22	13	localThrowable1	Throwable
      //   924	166	13	localObject1	Object
      //   1212	94	13	arrayOfByte2	byte[]
      //   1316	631	13	arrayOfByte3	byte[]
      //   1954	11	13	localException2	Exception
      //   2284	11	13	localConcurrentLinkedQueue	ConcurrentLinkedQueue
      //   2464	3	13	localException3	Exception
      //   2480	19	13	localException4	Exception
      //   2515	11	13	localThrowable2	Throwable
      //   2573	1	13	localThrowable3	Throwable
      //   2596	1	13	localThrowable4	Throwable
      //   111	2469	14	localObject2	Object
      //   65	2021	15	str	String
      //   365	264	16	localObject3	Object
      //   1196	9	16	localException5	Exception
      //   1324	769	16	arrayOfByte4	byte[]
      //   13	2409	17	localToServiceMsg	ToServiceMsg
      // Exception table:
      //   from	to	target	type
      //   823	830	835	java/lang/Exception
      //   60	75	869	java/lang/Throwable
      //   80	122	869	java/lang/Throwable
      //   122	171	869	java/lang/Throwable
      //   173	179	869	java/lang/Throwable
      //   181	203	869	java/lang/Throwable
      //   203	292	869	java/lang/Throwable
      //   292	316	869	java/lang/Throwable
      //   316	343	869	java/lang/Throwable
      //   343	350	869	java/lang/Throwable
      //   350	415	869	java/lang/Throwable
      //   415	464	869	java/lang/Throwable
      //   464	469	869	java/lang/Throwable
      //   469	537	869	java/lang/Throwable
      //   542	560	869	java/lang/Throwable
      //   560	590	869	java/lang/Throwable
      //   603	624	869	java/lang/Throwable
      //   633	676	869	java/lang/Throwable
      //   719	733	869	java/lang/Throwable
      //   752	786	869	java/lang/Throwable
      //   792	801	869	java/lang/Throwable
      //   803	817	869	java/lang/Throwable
      //   817	823	869	java/lang/Throwable
      //   823	830	869	java/lang/Throwable
      //   837	864	869	java/lang/Throwable
      //   1198	1209	869	java/lang/Throwable
      //   1257	1318	869	java/lang/Throwable
      //   1321	1326	869	java/lang/Throwable
      //   1329	1392	869	java/lang/Throwable
      //   1400	1452	869	java/lang/Throwable
      //   1455	1564	869	java/lang/Throwable
      //   1564	1574	869	java/lang/Throwable
      //   1574	1656	869	java/lang/Throwable
      //   1656	1664	869	java/lang/Throwable
      //   1792	1893	869	java/lang/Throwable
      //   1893	1906	869	java/lang/Throwable
      //   1906	1912	869	java/lang/Throwable
      //   1915	1919	869	java/lang/Throwable
      //   1922	1951	869	java/lang/Throwable
      //   1956	1969	869	java/lang/Throwable
      //   1972	1987	869	java/lang/Throwable
      //   1995	2005	869	java/lang/Throwable
      //   2013	2032	869	java/lang/Throwable
      //   2035	2054	869	java/lang/Throwable
      //   2060	2071	869	java/lang/Throwable
      //   2074	2082	869	java/lang/Throwable
      //   2085	2300	869	java/lang/Throwable
      //   2300	2373	869	java/lang/Throwable
      //   2373	2393	869	java/lang/Throwable
      //   2393	2461	869	java/lang/Throwable
      //   2466	2471	869	java/lang/Throwable
      //   350	415	1196	java/lang/Exception
      //   415	464	1196	java/lang/Exception
      //   464	469	1196	java/lang/Exception
      //   0	55	1212	finally
      //   60	75	1212	finally
      //   80	122	1212	finally
      //   122	171	1212	finally
      //   173	179	1212	finally
      //   181	203	1212	finally
      //   203	292	1212	finally
      //   292	316	1212	finally
      //   316	343	1212	finally
      //   343	350	1212	finally
      //   350	415	1212	finally
      //   415	464	1212	finally
      //   464	469	1212	finally
      //   469	537	1212	finally
      //   542	560	1212	finally
      //   560	590	1212	finally
      //   603	624	1212	finally
      //   633	676	1212	finally
      //   719	733	1212	finally
      //   752	786	1212	finally
      //   792	801	1212	finally
      //   803	817	1212	finally
      //   817	823	1212	finally
      //   823	830	1212	finally
      //   837	864	1212	finally
      //   871	919	1212	finally
      //   919	931	1212	finally
      //   938	1026	1212	finally
      //   1029	1059	1212	finally
      //   1059	1107	1212	finally
      //   1107	1147	1212	finally
      //   1147	1153	1212	finally
      //   1198	1209	1212	finally
      //   1257	1318	1212	finally
      //   1321	1326	1212	finally
      //   1329	1392	1212	finally
      //   1400	1452	1212	finally
      //   1455	1564	1212	finally
      //   1564	1574	1212	finally
      //   1574	1656	1212	finally
      //   1656	1664	1212	finally
      //   1664	1772	1212	finally
      //   1776	1787	1212	finally
      //   1792	1893	1212	finally
      //   1893	1906	1212	finally
      //   1906	1912	1212	finally
      //   1915	1919	1212	finally
      //   1922	1951	1212	finally
      //   1956	1969	1212	finally
      //   1972	1987	1212	finally
      //   1995	2005	1212	finally
      //   2013	2032	1212	finally
      //   2035	2054	1212	finally
      //   2060	2071	1212	finally
      //   2074	2082	1212	finally
      //   2085	2300	1212	finally
      //   2300	2373	1212	finally
      //   2373	2393	1212	finally
      //   2393	2461	1212	finally
      //   2466	2471	1212	finally
      //   2482	2512	1212	finally
      //   2517	2530	1212	finally
      //   1906	1912	1954	java/lang/Exception
      //   2013	2032	2464	java/lang/Exception
      //   2035	2054	2464	java/lang/Exception
      //   938	1026	2480	java/lang/Exception
      //   1029	1059	2480	java/lang/Exception
      //   1059	1107	2480	java/lang/Exception
      //   0	55	2515	java/lang/Throwable
      //   871	919	2515	java/lang/Throwable
      //   919	931	2515	java/lang/Throwable
      //   938	1026	2515	java/lang/Throwable
      //   1029	1059	2515	java/lang/Throwable
      //   1059	1107	2515	java/lang/Throwable
      //   1107	1147	2515	java/lang/Throwable
      //   1147	1153	2515	java/lang/Throwable
      //   2482	2512	2515	java/lang/Throwable
      //   1776	1787	2573	java/lang/Throwable
      //   1664	1772	2596	java/lang/Throwable
    }
  }
  
  public class d
    implements Runnable
  {
    String a;
    long b;
    String c;
    
    public d(String paramString1, String paramString2, long paramLong)
    {
      this.a = paramString1;
      this.c = paramString2;
      this.b = paramLong;
    }
    
    public void run()
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.a).append("+").append(this.b).append("+").append(this.c).append("\n");
        FileOutputStream localFileOutputStream = new FileOutputStream(new File(af.this.w), true);
        localFileOutputStream.write(localStringBuilder.toString().getBytes());
        localFileOutputStream.close();
        return;
      }
      catch (Exception localException)
      {
        QLog.d("MSF.C.NetConnTag", 1, "connect ssid file write failed");
      }
    }
  }
  
  class e
    implements Runnable
  {
    e() {}
    
    public void run()
    {
      boolean bool = false;
      try
      {
        HashMap localHashMap = new HashMap();
        File localFile = new File(af.this.w);
        if (localFile.isFile())
        {
          FileReader localFileReader = new FileReader(localFile);
          BufferedReader localBufferedReader = new BufferedReader(localFileReader);
          int i = 1;
          for (;;)
          {
            String str = localBufferedReader.readLine();
            if (str == null) {
              break;
            }
            localHashMap.put("SSID" + String.valueOf(i), str);
            i += 1;
          }
          localFileReader.close();
          if (localFile.delete())
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.NetConnTag", 2, "reportConnectWiFiThread succ to delete file");
            }
            af.u.clear();
            bool = true;
          }
          if (MsfService.core.getStatReporter() != null) {
            MsfService.core.getStatReporter().a("dim.Msf.ConnectWiFiSSID", bool, 0L, 0L, localHashMap, false, false);
          }
        }
        else
        {
          QLog.d("MSF.C.NetConnTag", 1, "reportConnectWiFiThread not a file");
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.d("MSF.C.NetConnTag", 1, "failed to report connect wifi info " + localException.toString());
      }
    }
  }
  
  class f
    implements Runnable
  {
    int a = 0;
    
    public f(int paramInt)
    {
      this.a = paramInt;
    }
    
    public void run()
    {
      try
      {
        long l = System.currentTimeMillis();
        Object localObject = Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/com/tencent/mobileqq/com.tencent.mobileqq_logcat_" + this.a + "_" + QLog.getLogFileFormatter().format(Long.valueOf(l)) + ".log";
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "start to store logcat " + (String)localObject);
        }
        localObject = "logcat -b main -b system -b radio -b events -v time -f " + (String)localObject;
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "start to execute command " + (String)localObject);
        }
        localObject = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec((String)localObject).getErrorStream()));
        for (;;)
        {
          String str = ((BufferedReader)localObject).readLine();
          if (str == null) {
            break;
          }
          QLog.d("MSF.C.NetConnTag", 1, "logcat storage error:" + str);
        }
        localException.close();
      }
      catch (Exception localException)
      {
        QLog.d("MSF.C.NetConnTag", 1, "failed to store logcat ", localException);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.af
 * JD-Core Version:    0.7.0.1
 */