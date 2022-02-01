package com.tencent.mobileqq.msf.core;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.jce.wup.ObjectCreateException;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.core.a.a.a;
import com.tencent.mobileqq.msf.core.net.a.f;
import com.tencent.mobileqq.msf.core.net.j;
import com.tencent.mobileqq.msf.core.net.k.b;
import com.tencent.mobileqq.msf.core.net.m;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.core.push.g;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.msf.service.protocol.pb.SSOReserveField.ReserveFields;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class aj
{
  public static AtomicInteger A;
  public static ArrayList B;
  public static String E;
  public static String F;
  public static int G = 0;
  public static int H = 0;
  public static long J = 0L;
  public static int M = 0;
  public static byte[] N;
  public static int O = 0;
  public static volatile boolean P = false;
  public static long U = 0L;
  static int V = 0;
  static AtomicBoolean W;
  public static final String Y = "GrayUinPro.Check";
  public static final String Z = "res";
  public static final String a = "MSF.C.NetConnTag";
  private static int aB = 0;
  private static final String aF = "gray_uin_check_dir";
  private static final String aG = "gray_uin_check_file_num";
  private static final String aH = "gray_uin_check_file";
  private static final String aI;
  private static final String aJ;
  private static final String aK;
  private static AtomicBoolean aL = new AtomicBoolean();
  public static final int ac = -10008;
  public static final int ad = -302;
  public static final int ae = 302;
  static CopyOnWriteArraySet af;
  private static final int ai = 50;
  private static final AtomicInteger am;
  private static boolean ao = false;
  private static int ar = 0;
  private static String as;
  private static String[] at;
  public static final String c = "__extraTimeoutSeq";
  public static boolean s = false;
  public static ConcurrentHashMap t;
  public static ConcurrentHashMap u;
  public static long v;
  public static int w;
  public static int x;
  public static boolean y;
  public static long z;
  public aj.a C = new aj.a(this);
  MsfCore D;
  public f I = null;
  aj.c K = new aj.c(this);
  long L;
  AtomicBoolean Q = new AtomicBoolean();
  int R = 0;
  long S = 0L;
  long T = 0L;
  HashSet X = new HashSet();
  private long aA = 0L;
  private byte[] aC = null;
  private long aD = 0L;
  private Random aE = new Random(System.currentTimeMillis());
  public int aa = -1;
  public AtomicBoolean ab = new AtomicBoolean();
  ArrayList ag = new ArrayList();
  boolean ah = false;
  private HashSet aj = new HashSet();
  private ToServiceMsg ak;
  private Handler al;
  private SimpleDateFormat an = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
  private int ap = 0;
  private String aq = "0";
  private HashSet au = new HashSet();
  private volatile boolean av = false;
  private Object aw = new Object();
  private long ax = 0L;
  private long ay = 0L;
  private long az = SystemClock.uptimeMillis();
  public n b;
  public ConcurrentHashMap d = new ConcurrentHashMap();
  public ConcurrentHashMap e = new ConcurrentHashMap();
  public ConcurrentHashMap f = new ConcurrentHashMap();
  public LinkedBlockingDeque g = new LinkedBlockingDeque(1000);
  public LinkedBlockingDeque h = new LinkedBlockingDeque();
  aj.b i = new aj.b(this);
  public int j = 10;
  public int k = 3072;
  public int l = 0;
  public int m = 500;
  public int n = 0;
  public int o = 300;
  public long p = 0L;
  public boolean q = false;
  public volatile boolean r = false;
  
  static
  {
    am = new AtomicInteger();
    t = new ConcurrentHashMap();
    u = new ConcurrentHashMap();
    v = -1L;
    w = -1;
    x = 0;
    y = true;
    z = -1L;
    ao = false;
    A = new AtomicInteger(0);
    B = new ArrayList();
    E = ":";
    F = "0";
    G = 0;
    H = 0;
    ar = 0;
    as = "";
    at = new String[] { "StreamSvr.UploadStreamMsg" };
    J = -1L;
    M = 0;
    N = null;
    O = 0;
    P = false;
    aB = -1;
    U = 0L;
    V = -1;
    W = new AtomicBoolean();
    aI = "/storage/emulated/0/tencent" + File.separator + "MobileQQ" + File.separator + "gray_uin_check_dir";
    aJ = "/storage/emulated/0/tencent" + File.separator + "MobileQQ" + File.separator + "gray_uin_check_dir" + File.separator + "gray_uin_check_file_num";
    aK = "/storage/emulated/0/tencent" + File.separator + "MobileQQ" + File.separator + "gray_uin_check_dir" + File.separator + "gray_uin_check_file";
    af = new CopyOnWriteArraySet();
  }
  
  public aj(MsfCore paramMsfCore)
  {
    this.D = paramMsfCore;
    HandlerThread localHandlerThread = new HandlerThread("mergehandle", 5);
    localHandlerThread.start();
    this.al = new Handler(localHandlerThread.getLooper());
    this.ap = paramMsfCore.getMsfAppid();
    this.b = new n(paramMsfCore, this.al);
    this.K.setName("MsfCoreMsgSender");
    try
    {
      paramMsfCore = com.tencent.mobileqq.msf.core.a.a.c();
      if (paramMsfCore != null)
      {
        this.j = Integer.parseInt(paramMsfCore[0]);
        this.k = Integer.parseInt(paramMsfCore[1]);
        this.o = Integer.parseInt(paramMsfCore[2]);
        this.m = Integer.parseInt(paramMsfCore[3]);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "maxDelaySize: " + this.k + " noMergeSize: " + this.o + " globaldelayTime: " + this.m + " delayWaitSendCount: " + this.j);
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
            this.n = Integer.parseInt(com.tencent.mobileqq.msf.core.a.a.e());
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.NetConnTag", 2, "mergeDuration: " + this.n);
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
  
  private static boolean A()
  {
    if ((MsfCore.sCore == null) || (MsfCore.sCore.sender == null) || (MsfCore.sCore.sender.b == null)) {}
    while (MsfCore.sCore.sender.b.f() != 2) {
      return false;
    }
    return true;
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      af.add(paramString);
      QLog.d("MSF.C.NetConnTag", 1, "use simple head for uin:" + MsfSdkUtils.getShortUin(paramString));
    }
    for (;;)
    {
      CodecWarpper.nativeSetUseSimpleHead(paramString, paramBoolean);
      return;
      af.remove(paramString);
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
    //   0: new 225	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   7: invokestatic 538	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10: invokevirtual 542	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   13: invokevirtual 545	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   16: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc_w 547
    //   22: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore_1
    //   29: new 225	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   36: aload_1
    //   37: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 549
    //   43: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: astore_3
    //   50: new 234	java/io/File
    //   53: dup
    //   54: aload_3
    //   55: invokespecial 551	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore_2
    //   59: aload_2
    //   60: astore_1
    //   61: aload_2
    //   62: invokevirtual 554	java/io/File:canRead	()Z
    //   65: ifne +12 -> 77
    //   68: new 234	java/io/File
    //   71: dup
    //   72: aload_3
    //   73: invokespecial 551	java/io/File:<init>	(Ljava/lang/String;)V
    //   76: astore_1
    //   77: invokestatic 449	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +71 -> 151
    //   83: ldc 36
    //   85: iconst_2
    //   86: new 225	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   93: ldc_w 556
    //   96: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_1
    //   100: invokevirtual 545	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   103: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc_w 558
    //   109: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_1
    //   113: invokevirtual 561	java/io/File:isFile	()Z
    //   116: invokevirtual 564	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   119: ldc_w 566
    //   122: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_1
    //   126: invokevirtual 554	java/io/File:canRead	()Z
    //   129: invokevirtual 564	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   132: ldc_w 568
    //   135: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_1
    //   139: invokevirtual 571	java/io/File:length	()J
    //   142: invokevirtual 574	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   145: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 576	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: new 578	java/util/Properties
    //   154: dup
    //   155: invokespecial 579	java/util/Properties:<init>	()V
    //   158: astore 4
    //   160: aload_1
    //   161: invokevirtual 582	java/io/File:exists	()Z
    //   164: ifeq +228 -> 392
    //   167: new 584	java/io/FileInputStream
    //   170: dup
    //   171: aload_1
    //   172: invokespecial 587	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   175: astore_2
    //   176: aload_2
    //   177: astore_1
    //   178: aload 4
    //   180: aload_2
    //   181: invokevirtual 591	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   184: aload_2
    //   185: astore_1
    //   186: aload_2
    //   187: invokevirtual 594	java/io/FileInputStream:close	()V
    //   190: aload_2
    //   191: ifnull +7 -> 198
    //   194: aload_2
    //   195: invokevirtual 594	java/io/FileInputStream:close	()V
    //   198: aload 4
    //   200: ldc_w 596
    //   203: invokevirtual 599	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   206: astore_1
    //   207: aload_1
    //   208: ifnull +171 -> 379
    //   211: aload_1
    //   212: invokevirtual 602	java/lang/String:trim	()Ljava/lang/String;
    //   215: invokevirtual 604	java/lang/String:length	()I
    //   218: ifle +161 -> 379
    //   221: aload_1
    //   222: invokestatic 609	com/tencent/mobileqq/msf/core/d:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/msf/core/d;
    //   225: astore_2
    //   226: aload_2
    //   227: invokevirtual 611	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   230: ifnull +10 -> 240
    //   233: aload_2
    //   234: invokevirtual 612	com/tencent/mobileqq/msf/core/d:f	()I
    //   237: ifgt +61 -> 298
    //   240: return
    //   241: astore_1
    //   242: aload_1
    //   243: invokevirtual 615	java/io/IOException:printStackTrace	()V
    //   246: goto -48 -> 198
    //   249: astore_3
    //   250: aconst_null
    //   251: astore_2
    //   252: aload_2
    //   253: astore_1
    //   254: aload_3
    //   255: invokevirtual 616	java/lang/Exception:printStackTrace	()V
    //   258: aload_2
    //   259: ifnull -61 -> 198
    //   262: aload_2
    //   263: invokevirtual 594	java/io/FileInputStream:close	()V
    //   266: goto -68 -> 198
    //   269: astore_1
    //   270: aload_1
    //   271: invokevirtual 615	java/io/IOException:printStackTrace	()V
    //   274: goto -76 -> 198
    //   277: astore_2
    //   278: aconst_null
    //   279: astore_1
    //   280: aload_1
    //   281: ifnull +7 -> 288
    //   284: aload_1
    //   285: invokevirtual 594	java/io/FileInputStream:close	()V
    //   288: aload_2
    //   289: athrow
    //   290: astore_1
    //   291: aload_1
    //   292: invokevirtual 615	java/io/IOException:printStackTrace	()V
    //   295: goto -7 -> 288
    //   298: aload_1
    //   299: invokevirtual 602	java/lang/String:trim	()Ljava/lang/String;
    //   302: ldc_w 474
    //   305: ldc 194
    //   307: invokevirtual 620	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   310: astore_1
    //   311: aload_0
    //   312: getfield 426	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   315: aload_1
    //   316: invokevirtual 622	com/tencent/mobileqq/msf/core/net/n:a	(Ljava/lang/String;)V
    //   319: ldc 36
    //   321: iconst_1
    //   322: new 225	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   329: ldc_w 624
    //   332: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_1
    //   336: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 463	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: aload 4
    //   347: ldc_w 626
    //   350: invokevirtual 599	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   353: astore_1
    //   354: aload_1
    //   355: ifnull -115 -> 240
    //   358: aload_1
    //   359: invokevirtual 602	java/lang/String:trim	()Ljava/lang/String;
    //   362: invokevirtual 604	java/lang/String:length	()I
    //   365: ifle -125 -> 240
    //   368: aload_1
    //   369: invokestatic 630	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   372: invokevirtual 633	java/lang/Integer:intValue	()I
    //   375: putstatic 214	com/tencent/mobileqq/msf/core/aj:aB	I
    //   378: return
    //   379: aload_0
    //   380: invokespecial 635	com/tencent/mobileqq/msf/core/aj:v	()V
    //   383: return
    //   384: astore_2
    //   385: goto -105 -> 280
    //   388: astore_3
    //   389: goto -137 -> 252
    //   392: aconst_null
    //   393: astore_2
    //   394: goto -204 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	this	aj
    //   0	397	1	paramContext	Context
    //   58	205	2	localObject1	Object
    //   277	12	2	localObject2	Object
    //   384	1	2	localObject3	Object
    //   393	1	2	localObject4	Object
    //   49	24	3	str	String
    //   249	6	3	localException1	Exception
    //   388	1	3	localException2	Exception
    //   158	188	4	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   194	198	241	java/io/IOException
    //   160	176	249	java/lang/Exception
    //   262	266	269	java/io/IOException
    //   160	176	277	finally
    //   284	288	290	java/io/IOException
    //   178	184	384	finally
    //   186	190	384	finally
    //   254	258	384	finally
    //   178	184	388	java/lang/Exception
    //   186	190	388	java/lang/Exception
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.b.b())
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "Heartbeat.Alive");
      localToServiceMsg.setMsfCommand(MsfCommand._msf_HeartbeatAlive);
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.setAppId(this.D.getMsfAppid());
      localToServiceMsg.putWupBuffer(new byte[] { 0, 0, 0, 4 });
      if (paramBoolean) {
        localToServiceMsg.setTimeout(com.tencent.mobileqq.msf.core.a.a.C());
      }
      for (;;)
      {
        a(localToServiceMsg);
        this.R = com.tencent.mobileqq.msf.core.a.a.I();
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.NetConnTag", 4, "send fast net detect Heartbeat msg ok");
        }
        if ((!paramBoolean) || (com.tencent.mobileqq.msf.core.a.a.Q()))
        {
          this.S = System.currentTimeMillis();
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.NetConnTag", 1, "Update send heartbeat time: " + this.S);
          }
        }
        this.Q.set(true);
        return;
        localToServiceMsg.setTimeout(10000L);
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.NetConnTag", 4, "conn is also closed.not need send heartbeat msg");
    }
    x();
  }
  
  public static boolean b(String paramString)
  {
    return af.contains(paramString);
  }
  
  public static byte[] b(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    int i1;
    Object localObject;
    try
    {
      if (MsfCore.sCore != null)
      {
        i1 = MsfCore.sCore.mLocaleId;
        int i3 = com.tencent.mobileqq.msf.core.a.a.bf();
        int i2 = i3;
        if (i3 < 1) {
          i2 = 1;
        }
        i3 = (int)(Math.random() * 100.0D);
        if ((paramToServiceMsg.getServiceCmd().equals("MessageSvc.PbGetMsg")) && (i3 % i2 == i2 - 1))
        {
          localObject = new SSOReserveField.ReserveFields();
          paramToServiceMsg = (String)paramToServiceMsg.getAttribute("sso_push_timestamp");
          if (paramToServiceMsg != null)
          {
            String[] arrayOfString = paramToServiceMsg.split("\\|");
            String str1 = Build.MODEL.replace('\n', '-');
            i2 = Build.VERSION.SDK_INT;
            String str2 = Build.DISPLAY;
            String str3 = Build.MANUFACTURER;
            if (arrayOfString.length == 3)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("model:" + str1 + ";");
              localStringBuilder.append("os:" + i2 + ";");
              localStringBuilder.append("version:v2");
              if (com.tencent.mobileqq.msf.core.a.a.bl())
              {
                localStringBuilder.append("man:" + str3);
                localStringBuilder.append("sys:" + str2);
              }
              ((SSOReserveField.ReserveFields)localObject).sso_send.set(Long.parseLong(arrayOfString[0]));
              ((SSOReserveField.ReserveFields)localObject).sdk_recv.set(Long.parseLong(arrayOfString[1]));
              ((SSOReserveField.ReserveFields)localObject).app_recv.set(Long.parseLong(arrayOfString[2]));
              ((SSOReserveField.ReserveFields)localObject).sdk_send.set(System.currentTimeMillis());
              ((SSOReserveField.ReserveFields)localObject).type.set(w);
              ((SSOReserveField.ReserveFields)localObject).extra.set(localStringBuilder.toString());
              if (i1 > 0) {
                ((SSOReserveField.ReserveFields)localObject).locale_id.set(i1);
              }
              if ((2 <= paramInt) && (N != null))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("MSF.C.NetConnTag", 2, "MSF.C.CodecWarpper buildReserveFiled sGwV4Sec:" + N);
                }
                ((SSOReserveField.ReserveFields)localObject).client_ipcookie.set(ByteStringMicro.copyFrom(N));
              }
            }
            QLog.d("MSF.C.NetConnTag", 1, "msf get timestamp:" + paramToServiceMsg + ", length:" + arrayOfString.length + ", model:" + str1 + ", type:" + w);
          }
        }
        else if (i1 > 0)
        {
          paramToServiceMsg = new SSOReserveField.ReserveFields();
          paramToServiceMsg.locale_id.set(i1);
          label507:
          localObject = paramToServiceMsg;
          if (2 > paramInt) {
            break label622;
          }
          localObject = paramToServiceMsg;
          if (N == null) {
            break label622;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "MSF.C.CodecWarpper buildReserveFiled sGwV4Sec:" + N);
          }
          localObject = paramToServiceMsg;
          if (paramToServiceMsg == null) {
            localObject = new SSOReserveField.ReserveFields();
          }
          ((SSOReserveField.ReserveFields)localObject).client_ipcookie.set(ByteStringMicro.copyFrom(N));
        }
      }
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.d("MSF.C.NetConnTag", 1, "failed to construct reserve field", paramToServiceMsg);
      return null;
    }
    label622:
    do
    {
      paramToServiceMsg = ((SSOReserveField.ReserveFields)localObject).toByteArray();
      return paramToServiceMsg;
      paramToServiceMsg = null;
      break label507;
      i1 = 0;
      break;
    } while (localObject != null);
    return null;
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    int i1 = paramArrayOfByte.length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i1 + 4);
    localByteBuffer.putInt(i1 + 4).put(paramArrayOfByte).flip();
    return localByteBuffer.array();
  }
  
  public static void c(String paramString)
  {
    if (!A()) {
      as = paramString;
    }
  }
  
  public static void d(int paramInt)
  {
    ar = paramInt;
  }
  
  private String e(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i1 = 0;
    while (i1 < paramInt)
    {
      localStringBuffer.append((char)(int)(Math.random() * 9.0D + 48.0D));
      i1 += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static void e(String paramString)
  {
    if (A()) {
      as = paramString;
    }
  }
  
  /* Error */
  private String f(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: new 234	java/io/File
    //   9: dup
    //   10: getstatic 247	com/tencent/mobileqq/msf/core/aj:aJ	Ljava/lang/String;
    //   13: invokespecial 551	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore_3
    //   17: new 234	java/io/File
    //   20: dup
    //   21: getstatic 249	com/tencent/mobileqq/msf/core/aj:aK	Ljava/lang/String;
    //   24: invokespecial 551	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore 7
    //   29: ldc 194
    //   31: astore_2
    //   32: aload_2
    //   33: astore 4
    //   35: aload 7
    //   37: invokevirtual 582	java/io/File:exists	()Z
    //   40: ifeq +43 -> 83
    //   43: aload_2
    //   44: astore 4
    //   46: aload 7
    //   48: invokevirtual 898	java/io/File:delete	()Z
    //   51: pop
    //   52: aload_2
    //   53: astore 4
    //   55: ldc 36
    //   57: iconst_1
    //   58: new 225	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   65: ldc_w 900
    //   68: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: getstatic 249	com/tencent/mobileqq/msf/core/aj:aK	Ljava/lang/String;
    //   74: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 463	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: aload_2
    //   84: astore 4
    //   86: aload_3
    //   87: invokevirtual 582	java/io/File:exists	()Z
    //   90: ifne +74 -> 164
    //   93: aload_2
    //   94: astore 4
    //   96: aload_0
    //   97: invokespecial 902	com/tencent/mobileqq/msf/core/aj:z	()V
    //   100: aload_2
    //   101: astore 4
    //   103: aload_0
    //   104: iload_1
    //   105: invokespecial 904	com/tencent/mobileqq/msf/core/aj:e	(I)Ljava/lang/String;
    //   108: astore_2
    //   109: aload_2
    //   110: astore 4
    //   112: new 906	java/io/FileOutputStream
    //   115: dup
    //   116: aload_3
    //   117: invokespecial 907	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   120: astore_3
    //   121: aload_3
    //   122: ifnull +453 -> 575
    //   125: aload_3
    //   126: aload_2
    //   127: invokevirtual 910	java/lang/String:getBytes	()[B
    //   130: invokevirtual 913	java/io/FileOutputStream:write	([B)V
    //   133: aload 6
    //   135: astore 4
    //   137: aload 4
    //   139: ifnull +8 -> 147
    //   142: aload 4
    //   144: invokevirtual 594	java/io/FileInputStream:close	()V
    //   147: aload_2
    //   148: astore 4
    //   150: aload_3
    //   151: ifnull +10 -> 161
    //   154: aload_3
    //   155: invokevirtual 914	java/io/FileOutputStream:close	()V
    //   158: aload_2
    //   159: astore 4
    //   161: aload 4
    //   163: areturn
    //   164: aload_2
    //   165: astore 4
    //   167: new 584	java/io/FileInputStream
    //   170: dup
    //   171: aload_3
    //   172: invokespecial 587	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   175: astore_3
    //   176: iload_1
    //   177: newarray byte
    //   179: astore_2
    //   180: aload_3
    //   181: ifnull +379 -> 560
    //   184: aload_3
    //   185: aload_2
    //   186: invokevirtual 918	java/io/FileInputStream:read	([B)I
    //   189: pop
    //   190: new 198	java/lang/String
    //   193: dup
    //   194: aload_2
    //   195: invokespecial 920	java/lang/String:<init>	([B)V
    //   198: astore_2
    //   199: aload_3
    //   200: invokevirtual 594	java/io/FileInputStream:close	()V
    //   203: aconst_null
    //   204: astore 5
    //   206: aload_3
    //   207: astore 4
    //   209: aload 5
    //   211: astore_3
    //   212: goto -75 -> 137
    //   215: astore 4
    //   217: ldc 36
    //   219: iconst_1
    //   220: new 225	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   227: ldc_w 922
    //   230: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload 4
    //   235: invokevirtual 477	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 463	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: goto -97 -> 147
    //   247: astore_3
    //   248: ldc 36
    //   250: iconst_1
    //   251: new 225	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   258: ldc_w 924
    //   261: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload_3
    //   265: invokevirtual 477	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 463	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aload_2
    //   275: areturn
    //   276: astore_3
    //   277: aconst_null
    //   278: astore 5
    //   280: aload 4
    //   282: astore_2
    //   283: aconst_null
    //   284: astore 6
    //   286: aload_3
    //   287: astore 4
    //   289: aload 6
    //   291: astore_3
    //   292: ldc 36
    //   294: iconst_1
    //   295: new 225	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   302: ldc_w 926
    //   305: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload 4
    //   310: invokevirtual 477	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 463	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aload 5
    //   321: ifnull +8 -> 329
    //   324: aload 5
    //   326: invokevirtual 594	java/io/FileInputStream:close	()V
    //   329: aload_2
    //   330: astore 4
    //   332: aload_3
    //   333: ifnull -172 -> 161
    //   336: aload_3
    //   337: invokevirtual 914	java/io/FileOutputStream:close	()V
    //   340: aload_2
    //   341: areturn
    //   342: astore_3
    //   343: ldc 36
    //   345: iconst_1
    //   346: new 225	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   353: ldc_w 924
    //   356: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload_3
    //   360: invokevirtual 477	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   363: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokestatic 463	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   369: aload_2
    //   370: areturn
    //   371: astore 4
    //   373: ldc 36
    //   375: iconst_1
    //   376: new 225	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   383: ldc_w 922
    //   386: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload 4
    //   391: invokevirtual 477	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 463	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   400: goto -71 -> 329
    //   403: astore_2
    //   404: aconst_null
    //   405: astore_3
    //   406: aload 5
    //   408: astore 4
    //   410: aload 4
    //   412: ifnull +8 -> 420
    //   415: aload 4
    //   417: invokevirtual 594	java/io/FileInputStream:close	()V
    //   420: aload_3
    //   421: ifnull +7 -> 428
    //   424: aload_3
    //   425: invokevirtual 914	java/io/FileOutputStream:close	()V
    //   428: aload_2
    //   429: athrow
    //   430: astore 4
    //   432: ldc 36
    //   434: iconst_1
    //   435: new 225	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   442: ldc_w 922
    //   445: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload 4
    //   450: invokevirtual 477	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   453: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: invokestatic 463	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   459: goto -39 -> 420
    //   462: astore_3
    //   463: ldc 36
    //   465: iconst_1
    //   466: new 225	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   473: ldc_w 924
    //   476: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: aload_3
    //   480: invokevirtual 477	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   483: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokestatic 463	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   489: goto -61 -> 428
    //   492: astore_2
    //   493: aload 5
    //   495: astore 4
    //   497: goto -87 -> 410
    //   500: astore_2
    //   501: aconst_null
    //   502: astore 5
    //   504: aload_3
    //   505: astore 4
    //   507: aload 5
    //   509: astore_3
    //   510: goto -100 -> 410
    //   513: astore_2
    //   514: aload 5
    //   516: astore 4
    //   518: goto -108 -> 410
    //   521: astore 4
    //   523: aconst_null
    //   524: astore 5
    //   526: goto -234 -> 292
    //   529: astore 4
    //   531: ldc 194
    //   533: astore_2
    //   534: aconst_null
    //   535: astore 6
    //   537: aload_3
    //   538: astore 5
    //   540: aload 6
    //   542: astore_3
    //   543: goto -251 -> 292
    //   546: astore 4
    //   548: aconst_null
    //   549: astore 6
    //   551: aload_3
    //   552: astore 5
    //   554: aload 6
    //   556: astore_3
    //   557: goto -265 -> 292
    //   560: ldc 194
    //   562: astore_2
    //   563: aconst_null
    //   564: astore 5
    //   566: aload_3
    //   567: astore 4
    //   569: aload 5
    //   571: astore_3
    //   572: goto -435 -> 137
    //   575: aload 6
    //   577: astore 4
    //   579: goto -442 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	582	0	this	aj
    //   0	582	1	paramInt	int
    //   31	339	2	localObject1	Object
    //   403	26	2	localObject2	Object
    //   492	1	2	localObject3	Object
    //   500	1	2	localObject4	Object
    //   513	1	2	localObject5	Object
    //   533	30	2	str	String
    //   16	196	3	localObject6	Object
    //   247	18	3	localThrowable1	Throwable
    //   276	11	3	localThrowable2	Throwable
    //   291	46	3	localObject7	Object
    //   342	18	3	localThrowable3	Throwable
    //   405	20	3	localObject8	Object
    //   462	43	3	localThrowable4	Throwable
    //   509	63	3	localObject9	Object
    //   33	175	4	localObject10	Object
    //   215	66	4	localThrowable5	Throwable
    //   287	44	4	localObject11	Object
    //   371	19	4	localThrowable6	Throwable
    //   408	8	4	localObject12	Object
    //   430	19	4	localThrowable7	Throwable
    //   495	22	4	localObject13	Object
    //   521	1	4	localThrowable8	Throwable
    //   529	1	4	localThrowable9	Throwable
    //   546	1	4	localThrowable10	Throwable
    //   567	11	4	localObject14	Object
    //   1	569	5	localObject15	Object
    //   4	572	6	localObject16	Object
    //   27	20	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   142	147	215	java/lang/Throwable
    //   154	158	247	java/lang/Throwable
    //   35	43	276	java/lang/Throwable
    //   46	52	276	java/lang/Throwable
    //   55	83	276	java/lang/Throwable
    //   86	93	276	java/lang/Throwable
    //   96	100	276	java/lang/Throwable
    //   103	109	276	java/lang/Throwable
    //   112	121	276	java/lang/Throwable
    //   167	176	276	java/lang/Throwable
    //   336	340	342	java/lang/Throwable
    //   324	329	371	java/lang/Throwable
    //   35	43	403	finally
    //   46	52	403	finally
    //   55	83	403	finally
    //   86	93	403	finally
    //   96	100	403	finally
    //   103	109	403	finally
    //   112	121	403	finally
    //   167	176	403	finally
    //   415	420	430	java/lang/Throwable
    //   424	428	462	java/lang/Throwable
    //   125	133	492	finally
    //   176	180	500	finally
    //   184	199	500	finally
    //   199	203	500	finally
    //   292	319	513	finally
    //   125	133	521	java/lang/Throwable
    //   176	180	529	java/lang/Throwable
    //   184	199	529	java/lang/Throwable
    //   199	203	546	java/lang/Throwable
  }
  
  private int g(ToServiceMsg paramToServiceMsg)
  {
    Object localObject1;
    long l1;
    if (paramToServiceMsg.isNeedCallback())
    {
      this.d.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), paramToServiceMsg);
      paramToServiceMsg.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(am.incrementAndGet()));
      if (paramToServiceMsg.getTimeout() == -1L)
      {
        paramToServiceMsg.setTimeout(30000L);
        localObject1 = this.D.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
        if (("LongConn.OffPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd()))) {
          QLog.d("MSF.C.NetConnTag", 1, "Sender PicUpMsg timer start, appSeq: " + paramToServiceMsg.getAppSeq() + ", delayMillis: " + paramToServiceMsg.getTimeout());
        }
        paramToServiceMsg.addAttribute("to_timeoutCallbacker", localObject1);
        if (com.tencent.mobileqq.msf.core.a.a.x())
        {
          l1 = paramToServiceMsg.getTimeout() - com.tencent.mobileqq.msf.core.a.a.A();
          if (l1 > 0L) {
            paramToServiceMsg.addAttribute("to_predetect_timeoutCallbacker", this.D.msfAlarmer.b(paramToServiceMsg, l1));
          }
        }
        if ((com.tencent.mobileqq.msf.core.a.a.aa()) && (this.D.quicksender != null) && (this.D.quicksender.b(paramToServiceMsg)))
        {
          QLog.d("MSF.C.NetConnTag", 1, "add quick send timeout check " + paramToServiceMsg.getRequestSsoSeq());
          if ((this.b.b()) && (this.b.l() != null) && (this.b.l().b() != null)) {
            paramToServiceMsg.getAttributes().put("connIDC", this.b.l().b().i);
          }
          this.D.quicksender.c(paramToServiceMsg);
        }
      }
    }
    for (;;)
    {
      try
      {
        this.D.quicksender.f.a(paramToServiceMsg);
        if (this.g.offer(paramToServiceMsg)) {
          break label613;
        }
        QLog.d("MSF.C.NetConnTag", 1, "error, add " + paramToServiceMsg + " to send queue is full! size: " + this.g.size());
        if (paramToServiceMsg.getServiceCmd().equals("SSO.LoginMerge")) {
          break label528;
        }
        localObject1 = w.a(paramToServiceMsg);
        ((FromServiceMsg)localObject1).setBusinessFail(1008, "send queue is full!");
        this.D.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject1);
        if ((!W.get()) && (i.c))
        {
          W.set(true);
          V = paramToServiceMsg.getRequestSsoSeq();
        }
        return paramToServiceMsg.getRequestSsoSeq();
        localObject1 = this.D.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        continue;
      }
      if (paramToServiceMsg.getServiceCmd().equals("SSO.LoginMerge"))
      {
        this.D.msfAlarmer.a(paramToServiceMsg.getRequestSsoSeq(), 30000L);
        continue;
        label528:
        Object localObject2 = (ArrayList)this.f.remove(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
        if (localObject2 != null)
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            ToServiceMsg localToServiceMsg = (ToServiceMsg)((Iterator)localObject2).next();
            FromServiceMsg localFromServiceMsg = w.a(localToServiceMsg);
            localFromServiceMsg.setBusinessFail(1008, "send queue is full!");
            this.D.addRespToQuque(localToServiceMsg, localFromServiceMsg);
          }
          continue;
          label613:
          this.aA += 1L;
          this.f.remove(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.NetConnTag", 4, "add " + paramToServiceMsg + " to sendQueue(" + this.g.size() + ")");
          }
          l1 = SystemClock.elapsedRealtime();
          if (l1 - this.ax >= 300000L)
          {
            this.ax = l1;
            if (QLog.isColorLevel()) {
              y();
            }
          }
        }
      }
    }
  }
  
  public static void h()
  {
    Iterator localIterator = af.iterator();
    while (localIterator.hasNext()) {
      CodecWarpper.nativeSetUseSimpleHead((String)localIterator.next(), false);
    }
    af.clear();
  }
  
  private void h(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg.getUin().equals("0")) {}
    int i1;
    do
    {
      return;
      int i2 = 0;
      i1 = i2;
      if (!this.X.contains(paramToServiceMsg.getUin()))
      {
        this.aD += 1L;
        if (this.aD >= 2L)
        {
          i1 = i2;
          if (this.aE.nextInt(20) >= 2) {}
        }
        else
        {
          i1 = 1;
        }
      }
    } while (i1 == 0);
    a(paramToServiceMsg.getAppId(), paramToServiceMsg.getUin());
  }
  
  public static int n()
  {
    return ar;
  }
  
  public static String o()
  {
    return as;
  }
  
  private void u()
  {
    this.aj.add("StatSvc.register");
    this.aj.add("PushService.register");
    this.aj.add("RegPrxySvc.info");
    this.aj.add("RegPrxySvc.infoNew");
    this.aj.add("RegPrxySvc.infoAndroid");
    this.aj.add("RegPrxySvc.infoLogin");
    this.aj.add("RegPrxySvc.infoSync");
    this.aj.add("im_status.stat_reg");
    this.aj.add("SSO.LoginMerge");
  }
  
  private void v()
  {
    if (MsfSdkUtils.isBuildTestEnvValid())
    {
      d locald = d.a("socket://183.3.233.202:14000");
      if ((locald.c() == null) || (locald.f() <= 0)) {
        QLog.i("MSF.C.NetConnTag", 1, "testServerAddress ip or port error");
      }
    }
    else
    {
      return;
    }
    this.b.a("socket://183.3.233.202:14000");
    aB = 62;
    QLog.d("MSF.C.NetConnTag", 1, "set buildTestServer Address socket://183.3.233.202:14000");
  }
  
  private void w()
  {
    if (this.b.b())
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "Heartbeat.Alive");
      localToServiceMsg.setMsfCommand(MsfCommand._msf_HeartbeatAlive);
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.setAppId(this.D.getMsfAppid());
      localToServiceMsg.putWupBuffer(new byte[] { 0, 0, 0, 4 });
      localToServiceMsg.setTimeout(com.tencent.mobileqq.msf.core.a.a.A());
      a(localToServiceMsg);
      this.R += 1;
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.NetConnTag", 4, "send Heartbeat msg ok");
      }
      this.S = System.currentTimeMillis();
      this.Q.set(true);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.NetConnTag", 4, "conn is also closed.not need send heartbeat msg");
    }
    x();
  }
  
  private void x()
  {
    this.R = 0;
    this.Q.set(false);
  }
  
  private void y()
  {
    boolean bool2 = false;
    try
    {
      for (ThreadGroup localThreadGroup = Thread.currentThread().getThreadGroup(); localThreadGroup.getParent() != null; localThreadGroup = localThreadGroup.getParent()) {}
      Thread[] arrayOfThread = new Thread[localThreadGroup.activeCount()];
      localThreadGroup.enumerate(arrayOfThread);
      int i2 = this.g.size();
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
  
  private void z()
  {
    File localFile1 = new File(aI);
    File localFile2 = new File(aJ);
    try
    {
      if (!localFile1.exists()) {
        localFile1.mkdir();
      }
      if (!localFile2.exists()) {
        localFile2.createNewFile();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("MSF.C.NetConnTag", 1, "ensureFileExist " + localThrowable);
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
      this.d.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), paramToServiceMsg);
      paramToServiceMsg.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(am.incrementAndGet()));
      if (paramToServiceMsg.getTimeout() != -1L) {
        break label175;
      }
      paramToServiceMsg.setTimeout(30000L);
      localRunnable = this.D.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
    }
    for (;;)
    {
      paramToServiceMsg.addAttribute("to_timeoutCallbacker", localRunnable);
      try
      {
        this.g.addFirst(paramToServiceMsg);
        this.aA += 1L;
        return paramToServiceMsg.getRequestSsoSeq();
        label175:
        localRunnable = this.D.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
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
    return this.az;
  }
  
  public Runnable a(int paramInt)
  {
    long l1 = com.tencent.mobileqq.msf.core.a.a.B();
    if (l1 > 0L) {
      return this.D.msfAlarmer.b(paramInt, l1);
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
    ((com.tencent.msf.service.protocol.e.c)localObject).d = f(18);
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "getInfoMachine = " + ((com.tencent.msf.service.protocol.e.c)localObject).d + " file_path = " + aJ);
    }
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
    this.b.a(parama);
  }
  
  public void a(FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.getResultCode() == 1000) {
      this.X.add(paramFromServiceMsg.getUin());
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
          this.D.getSsoRespHandler();
          ak.a.put(paramFromServiceMsg.getUin(), localObject1);
          QLog.d("MSF.C.NetConnTag", 1, Thread.currentThread().getName() + " onRecvCheckRoleResp setAccountNoLogin uin=" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()));
          this.D.getAccountCenter().k(paramFromServiceMsg.getUin());
          return;
        }
        ak.a.remove(paramFromServiceMsg.getUin());
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
      if (!this.b.b())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "conn is also closed.");
        }
        x();
      }
      do
      {
        return;
        if (this.R < com.tencent.mobileqq.msf.core.a.a.I()) {
          break;
        }
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "Heartbeat continueTimeoutCount is " + this.R + ",closeConn closeByNetDetectFailed");
          }
          this.D.sender.b.a(com.tencent.qphone.base.a.p);
          x();
          return;
        }
        catch (Exception paramFromServiceMsg) {}
      } while (!QLog.isColorLevel());
      QLog.d("MSF.C.NetConnTag", 2, paramFromServiceMsg.toString(), paramFromServiceMsg);
      return;
      long l1 = System.currentTimeMillis();
      if (l1 - this.S > com.tencent.mobileqq.msf.core.a.a.I() * com.tencent.mobileqq.msf.core.a.a.A())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "timenow - firstSendHeartBeatTime is " + (l1 - this.S) + ",closeConn continueWaitRspTimeout");
        }
        this.D.sender.b.a(com.tencent.qphone.base.a.e);
        x();
        return;
      }
      w();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "recv heart resp.now conn is alive.");
    }
    x();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    paramToServiceMsg.getAttributes().put("_attr_regprxy_socket_hashcode", new Integer(paramInt));
    this.ak = paramToServiceMsg;
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      this.D.msfAlarmer.b(paramRunnable);
    }
  }
  
  public void a(String paramString)
  {
    CodecWarpper.nativeRemoveAccountKey(paramString);
  }
  
  public void a(HashMap paramHashMap)
  {
    this.ag.add(paramHashMap);
    this.ah = true;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "add waitReportData " + this.ag.size());
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.aC = paramArrayOfByte;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    if (!this.b.c(paramInt)) {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "onRecvSsoResp: dump, connId: " + paramInt);
      }
    }
    do
    {
      return;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 4) || (paramArrayOfByte.length > 50)) {
        break;
      }
    } while (this.C.onSSOPingResponse(paramArrayOfByte, paramInt) <= 0);
    this.C.nativeOnReceData(paramArrayOfByte, paramInt);
    return;
    this.C.nativeOnReceData(paramArrayOfByte, paramInt);
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
        if ((str != null) && (str.length() > 0)) {
          this.au.add(str);
        }
        i1 += 1;
      }
    }
    this.au.add("GrayUinPro.Check");
    this.au.add("StatSvc.register");
    this.au.add("StatSvc.get");
    this.au.add("RegPrxySvc.infoLogin");
    this.au.add("RegPrxySvc.infoSync");
    this.au.add("wtlogin.login");
    this.au.add("RegPrxySvc.getOffMsg");
    this.au.add("login.auth");
    this.au.add("wtlogin.exchange");
    this.au.add("wtlogin.trans_emp");
    this.au.add("MessageSvc.PbSendMsg");
    this.au.add("LongConn.OffPicUp");
    this.au.add("LongConn.OffPicDown");
    this.au.add("ImgStore.GroupPicUp");
    this.au.add("ImgStore.GroupPicDown");
    this.au.add("StreamSvr.UploadStreamMsg");
    this.au.add("StreamSvr.RespUploadStreamMsg");
    this.au.add("StreamSvr.PushStreamMsg");
    this.au.add("StreamSvr.RespPushStreamMsg");
    this.au.add("OidbSvc.0x787_1");
    this.au.add("OidbSvc.0x49d_107");
    this.au.add("MultiMsg.ApplyUp");
    this.au.add("MultiMsg.ApplyDown");
    this.au.add("PttCenterSvr.ShortVideoUpReq");
    this.au.add("PttCenterSvr.ShortVideoDownReq");
    this.au.add("ImgStore.GroupPicUp#pttGu");
    this.au.add("ImgStore.GroupPicDown#pttGd");
    this.au.add("PttStore.GroupPttUp");
    this.au.add("PttStore.GroupPttDown");
    this.au.add("Heartbeat.Alive");
    this.au.add("friendlist.getFriendGroupList");
    this.au.add("VideoSvc.Send");
    this.au.add("VideoSvc.Ack");
    this.au.add("SharpSvr.c2s");
    this.au.add("SharpSvr.c2sack");
    this.au.add("SharpSvr.s2c");
    this.au.add("SharpSvr.s2cack");
    this.au.add("MultiVideo.c2s");
    this.au.add("MultiVideo.c2sack");
    this.au.add("MultiVideo.s2c");
    this.au.add("MultiVideo.s2cack");
    this.au.add("MessageSvc.PbGetMsg");
    this.au.add("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200");
    this.au.add("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500");
    this.au.add("OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_APPLY_DOWNLOAD-1200");
    this.au.add("cmd_openConn");
    this.au.add("wtlogin.exchange_emp");
    this.au.add("wtlogin.name2uin");
    this.au.add("Client.CorrectTime");
    this.au.add("StatSvc.RspMSFForceOffline");
    this.au.add("LightAppSvc.mini_app_userapp.GetUserAppList");
    this.au.add("qzoneh5.video.vv");
    this.au.add("OidbSvc.0xb77_9");
    this.au.add("OidbSvc.0xdc2_9");
    this.au.add("OidbSvc.0xd55");
    this.au.add("QQConnectLogin.pre_auth");
    this.au.add("ConnAuthSvr.get_app_info");
    this.au.add("ConnAuthSvr.sdk_auth_api");
    this.au.add("ConnAuthSvr.get_auth_api_list");
    this.au.add("QQConnectLogin.pre_auth_emp");
    this.au.add("ConnAuthSvr.get_app_info_emp");
    this.au.add("ConnAuthSvr.sdk_auth_api_emp");
    this.au.add("ConnAuthSvr.get_auth_api_list_emp");
  }
  
  public boolean a(Context paramContext)
  {
    try
    {
      if (com.tencent.mobileqq.msf.core.a.a.aI())
      {
        this.I = new f(this.D, paramContext);
        s = true;
      }
    }
    catch (Throwable localException)
    {
      try
      {
        v();
        u();
      }
      catch (Exception localException)
      {
        try
        {
          do
          {
            for (;;)
            {
              this.C.init(paramContext, false);
              CodecWarpper.nativeSetKsid(this.D.getAccountCenter().f());
              this.K.start();
              i.a(paramContext, true);
              return true;
              localThrowable = localThrowable;
              QLog.d("MSF.C.NetConnTag", 1, "init socketAdaptorfactory failed", localThrowable);
            }
            localException = localException;
          } while (!QLog.isColorLevel());
          QLog.d("MSF.C.NetConnTag", 2, "setBuildTestServerIfNeed error " + localException);
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          for (;;)
          {
            com.tencent.mobileqq.msf.core.c.k.a("codecwrapperV2", CodecWarpper.isLoaded, CodecWarpper.soLoadResultCode, localUnsatisfiedLinkError.getMessage());
          }
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
      this.D.sender.b.l().h();
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, Thread.currentThread().getName() + " onFoundTimeoutMsg closeConn closeBySSOPingTimeout");
      }
      this.D.sender.b.a(com.tencent.qphone.base.a.B);
      return false;
    }
    if (paramToServiceMsg.getMsfCommand() == MsfCommand.msf_oshello)
    {
      QLog.d("MSF.C.NetConnTag", 1, "cannot get os hello response");
      return false;
    }
    long l1 = 0L;
    long l2 = 0L;
    int i1 = 0;
    int i2;
    boolean bool1;
    try
    {
      i2 = NetConnInfoCenter.getActiveNetworkType();
      l3 = this.b.l().e();
      boolean bool2 = this.b.b();
      if (paramToServiceMsg.getAttributes().containsKey("_attr_req_send_time")) {
        l1 = ((Long)paramToServiceMsg.getAttribute("_attr_req_send_time")).longValue();
      }
      if (paramToServiceMsg.getAttributes().containsKey("_attr_req_socket_conn_time")) {
        l2 = ((Long)paramToServiceMsg.getAttribute("_attr_req_socket_conn_time")).longValue();
      }
      if (paramToServiceMsg.getAttributes().containsKey("_attr_req_netstate")) {
        i1 = ((Integer)paramToServiceMsg.getAttribute("_attr_req_netstate")).intValue();
      }
      if (!paramToServiceMsg.getAttributes().containsKey("_attr_req_isconn")) {
        break label1853;
      }
      bool1 = ((Boolean)paramToServiceMsg.getAttribute("_attr_req_isconn")).booleanValue();
      if (this.D.statReporter != null)
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("_attr_req_send_time", "" + l1);
        ((HashMap)localObject).put("_attr_req_socket_conn_time", "" + l2);
        ((HashMap)localObject).put("_attr_req_netstate", "" + i1);
        ((HashMap)localObject).put("_attr_req_isconn", "" + bool1);
        ((HashMap)localObject).put("_attr_timeout_netstate", "" + i2);
        ((HashMap)localObject).put("_attr_timeout_isconn", "" + bool2);
        ((HashMap)localObject).put("_attr_timeout_socket_conn_time", "" + l3);
        this.D.statReporter.a("actReqTimeoutReport", false, 0L, 0L, (Map)localObject, false, false);
      }
    }
    catch (Exception localException3)
    {
      try
      {
        this.I.b().a(paramToServiceMsg.getRequestSsoSeq(), true);
        if (!paramToServiceMsg.getAttributes().containsKey("__timestamp_msf2net")) {
          break label1847;
        }
        l1 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
        l3 = System.currentTimeMillis();
        if (!paramToServiceMsg.getAttributes().containsKey("__timestamp_addSendQueue")) {
          break label1841;
        }
        l2 = ((Long)paramToServiceMsg.getAttribute("__timestamp_addSendQueue")).longValue();
      }
      catch (Exception localException3)
      {
        try
        {
          if ((!paramToServiceMsg.getServiceCmd().equals("MessageSvc.PbGetMsg")) || (this.D.statReporter == null)) {
            break label694;
          }
          this.D.statReporter.a("dim.Msf.PushSendFail", false, 0L, 0L, null, false, false);
        }
        catch (Exception localException3)
        {
          try
          {
            Object localObject;
            while (paramToServiceMsg.getServiceCmd() == com.tencent.mobileqq.msf.core.push.e.k)
            {
              l4 = ((Long)paramToServiceMsg.getAttribute("_attr_alarm_elapsed_time", Long.valueOf(0L))).longValue();
              if ((com.tencent.mobileqq.msf.core.a.a.v) && (l4 > com.tencent.mobileqq.msf.core.a.a.bn()) && (l2 >= this.b.l().e()))
              {
                localObject = paramToServiceMsg.getUin();
                if (localObject != null) {
                  if ((!com.tencent.mobileqq.msf.core.a.a.w) || (Long.parseLong((String)localObject) % 2L == 0L))
                  {
                    QLog.d("MSF.C.NetConnTag", 1, "try close conn by wakeup alarm exceeded and detect timeout:" + l4);
                    this.D.sender.b.a(com.tencent.qphone.base.a.E);
                    if (this.D.getStatReporter() != null) {
                      this.D.getStatReporter().a("3", (String)localObject, true, 0L);
                    }
                    return false;
                    localException1 = localException1;
                    QLog.e("MSF.C.NetConnTag", 1, "report 1002 failed", localException1);
                    continue;
                    localException2 = localException2;
                    QLog.d("MSF.C.NetConnTag", 1, "adaptor recv timeout failed", localException2);
                    continue;
                    localException3 = localException3;
                    QLog.d("MSF.C.NetConnTag", 1, "", localException3);
                  }
                  else
                  {
                    this.D.pushManager.E = SystemClock.elapsedRealtime();
                    QLog.d("MSF.C.NetConnTag", 1, "wakeup alarm exceeded and detect timeout, but not close conn");
                  }
                }
              }
            }
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              long l3;
              QLog.d("MSF.C.NetConnTag", 1, "SimpleGet timeout error!", localException4);
            }
          }
          if ((l2 == 0L) || (l3 - l2 <= paramToServiceMsg.getTimeout()) || (l3 - l2 <= this.D.pushManager.e()) || (paramToServiceMsg.getTimeout() >= this.D.pushManager.e())) {
            break label1094;
          }
          if (l2 < this.b.l().e()) {
            break label1092;
          }
          if (!QLog.isColorLevel()) {
            break label1054;
          }
          QLog.d("MSF.C.NetConnTag", 2, "xiaomi 2s: " + paramToServiceMsg.getRequestSsoSeq() + " msg timeout , addtoqueueTime is " + (l3 - l2) + ",try close conn");
          this.D.sender.b.a(com.tencent.qphone.base.a.q);
          x();
          return true;
          return true;
          if ((l1 != 0L) && (l1 <= this.b.l().e())) {
            break label1462;
          }
          if (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_HeartbeatAlive) {
            break label1164;
          }
          QLog.d("MSF.C.NetConnTag", 1, "found timeout heartalive msg " + paramToServiceMsg.getRequestSsoSeq());
          a(paramFromServiceMsg, paramToServiceMsg);
          return false;
          if (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_QuickHeartBeat) {
            break label1218;
          }
          QLog.d("MSF.C.NetConnTag", 1, "found timeout quickheartbeat msg " + paramToServiceMsg.getRequestSsoSeq());
          this.D.quicksender.a(paramToServiceMsg, paramFromServiceMsg, false);
          return false;
          try
          {
            if ((this.Q.get()) && (System.currentTimeMillis() - this.S < com.tencent.mobileqq.msf.core.a.a.O() + 120000)) {
              break label1418;
            }
            l1 = System.currentTimeMillis();
            if (l1 - this.S <= com.tencent.mobileqq.msf.core.a.a.O()) {
              break label1363;
            }
            if (paramToServiceMsg.getRequestSsoSeq() == V)
            {
              V = -1;
              QLog.d("MSF.C.NetConnTag", 1, "found first msg screen on timeout try close conn " + paramToServiceMsg);
              this.D.sender.b.a(com.tencent.qphone.base.a.t);
              x();
              return true;
            }
          }
          finally {}
          if (!com.tencent.mobileqq.msf.core.a.a.bo()) {
            break label1349;
          }
          w();
          for (;;)
          {
            if (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_HeartbeatAlive) {
              break label1497;
            }
            return false;
            QLog.d("MSF.C.NetConnTag", 1, "found timeout msg check time: timenow = " + l1 + " firstSendHeartBeatTime = " + this.S + " ConfigManager.getHeartBeatTimeInterval() = " + com.tencent.mobileqq.msf.core.a.a.O());
            break;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("MSF.C.NetConnTag", 2, "sendingHeartBeat: " + this.Q + "net detect has started, no need sendHeartbeat");
            break;
            QLog.d("MSF.C.NetConnTag", 1, "found timeout msg " + paramToServiceMsg + " before connSucc.");
          }
          if (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_QuickHeartBeat) {
            break label1522;
          }
          this.D.quicksender.a(paramToServiceMsg, paramFromServiceMsg, true);
          return false;
        }
      }
    }
    if ((paramToServiceMsg != null) && (paramToServiceMsg.isNeedRemindSlowNetwork())) {
      com.tencent.mobileqq.msf.core.net.k.a(k.b.a);
    }
    paramToServiceMsg.addAttribute("_tag_socket_connerror", n.p);
    paramFromServiceMsg.addAttribute("_tag_socket_connerror", n.p);
    if (paramToServiceMsg.getAttributes().containsKey("_tag_socket")) {
      paramFromServiceMsg.addAttribute("_tag_socket", paramToServiceMsg.getAttribute("_tag_socket"));
    }
    if ((s) && (f.a())) {}
    for (;;)
    {
      try
      {
        label694:
        long l4;
        label1054:
        label1092:
        label1094:
        label1363:
        label1497:
        label1522:
        if (!this.b.b()) {
          break label1859;
        }
        label1164:
        label1218:
        label1349:
        int i3 = 1;
        label1418:
        label1462:
        paramFromServiceMsg = at;
        int i4 = paramFromServiceMsg.length;
        i1 = 0;
        i2 = i3;
        if (i1 < i4)
        {
          CharSequence localCharSequence = paramFromServiceMsg[i1];
          if ((TextUtils.isEmpty(localCharSequence)) || (paramToServiceMsg == null) || (!localCharSequence.equals(paramToServiceMsg.getServiceCmd()))) {
            break label1861;
          }
          i2 = 0;
        }
        if (i2 == 0) {
          break label1859;
        }
        if (!B.contains(paramToServiceMsg.getServiceCmd())) {
          B.add(paramToServiceMsg.getServiceCmd());
        }
        if (A.incrementAndGet() < com.tencent.mobileqq.msf.core.a.a.J()) {
          break label1859;
        }
        if (B.size() > 2)
        {
          QLog.d("MSF.C.NetConnTag", 1, "Continue wait resp for bus packets ,try close conn");
          A.set(0);
          B.clear();
          this.D.sender.b.a(com.tencent.qphone.base.a.e);
          x();
        }
        else if (QLog.isColorLevel())
        {
          paramToServiceMsg = (String)B.get(0);
          QLog.d("MSF.C.NetConnTag", 1, "Continue wait resp timeout by single cmd:" + paramToServiceMsg);
          A.set(0);
          B.clear();
          paramToServiceMsg = new HashMap();
          paramToServiceMsg.put("event_cmd", B.get(0));
          if (this.D.getStatReporter() == null) {
            break label1859;
          }
          this.D.getStatReporter().a("dim.Msf.SingleCmdTimeout", false, 0L, 0L, paramToServiceMsg, false, false);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.d("MSF.C.NetConnTag", 1, " Continue wait resp for bus packets ,try close conn failed: " + paramToServiceMsg);
      }
      paramToServiceMsg = com.tencent.mobileqq.msf.core.b.c.a((String)B.get(0));
      continue;
      label1841:
      l2 = 0L;
      continue;
      label1847:
      l1 = 0L;
      continue;
      label1853:
      bool1 = false;
      break;
      label1859:
      return true;
      label1861:
      i1 += 1;
    }
  }
  
  public int b(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return -1;
    }
    if (this.D.isSuspended())
    {
      QLog.d("MSF.C.NetConnTag", 1, "handleSsoFailCode, msfcore suspent");
      ??? = w.a(paramToServiceMsg);
      ((FromServiceMsg)???).setBusinessFail(2009, "MSF is suspeded.");
      this.D.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
      return paramToServiceMsg.getRequestSsoSeq();
    }
    if ((paramToServiceMsg.getWupBuffer() != null) && (paramToServiceMsg.getWupBuffer().length > 103424))
    {
      ??? = w.a(paramToServiceMsg);
      ((FromServiceMsg)???).setBusinessFail(2019, "check the wupbuf size in range[0, 101kb]");
      this.D.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
      return paramToServiceMsg.getRequestSsoSeq();
    }
    Object localObject2;
    String str;
    int i1;
    if (this.D.configManager.K != null)
    {
      Iterator localIterator = this.D.configManager.K.iterator();
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
            this.D.configManager.K.remove(localObject2);
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
                break label1969;
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
          ((FromServiceMsg)localObject2).setAppId(this.D.getMsfAppid());
          ((FromServiceMsg)localObject2).setMsgSuccess();
          ((FromServiceMsg)localObject2).setRequestSsoSeq(MsfCore.getNextSeq());
          MsfSdkUtils.addFromMsgProcessName("*", (FromServiceMsg)localObject2);
          ((FromServiceMsg)localObject2).getAttributes().put("msg", new String(((a.a)???).b.d));
          this.D.addRespToQuque(null, (FromServiceMsg)localObject2);
          ((a.a)???).b.e = 0;
        }
        localObject2 = w.a(paramToServiceMsg);
        ((FromServiceMsg)localObject2).setBusinessFail(((a.a)???).b.c, new String(((a.a)???).b.d));
        this.D.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "OverloadPushNotify server overload block tomsg: " + paramToServiceMsg + " frommsg: " + localObject2);
        }
        return paramToServiceMsg.getRequestSsoSeq();
        ??? = localObject2;
        if (!((a.a)localObject2).c.equals(str)) {
          break;
        }
        if (!QLog.isColorLevel()) {
          break label1969;
        }
        QLog.d("MSF.C.NetConnTag", 2, "OverloadPushNotify item matched strServiceCmd = " + str + " sCmd:" + ((a.a)localObject2).c);
        i1 = 1;
        ??? = localObject2;
        continue;
      }
      if ((paramToServiceMsg.getAppId() <= 0) && (paramToServiceMsg.getMsfCommand() != MsfCommand.openConn) && ((TextUtils.isEmpty(paramToServiceMsg.getServiceCmd())) || (!paramToServiceMsg.getServiceCmd().startsWith("wtlogin."))))
      {
        ??? = w.a(paramToServiceMsg);
        ((FromServiceMsg)???).setBusinessFail(1007, "msg appid is " + paramToServiceMsg.getAppId());
        this.D.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
        return paramToServiceMsg.getRequestSsoSeq();
      }
      if (aL.get())
      {
        ??? = w.a(paramToServiceMsg);
        ((FromServiceMsg)???).setBusinessFail(2014, "error");
        this.D.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
        return paramToServiceMsg.getRequestSsoSeq();
      }
      localObject2 = (com.tencent.msf.service.protocol.e.d)ak.a.get(paramToServiceMsg.getUin());
      ??? = localObject2;
      if (localObject2 != null)
      {
        ??? = localObject2;
        if (paramToServiceMsg.getServiceCmd().equals("wtlogin.login"))
        {
          this.X.remove(paramToServiceMsg.getUin());
          ak.a.remove(paramToServiceMsg.getUin());
          ??? = null;
        }
      }
      if ((??? != null) && (!paramToServiceMsg.getServiceCmd().startsWith("login.")) && (!paramToServiceMsg.getServiceCmd().startsWith("wtlogin.login")) && (!paramToServiceMsg.getServiceCmd().equals("GrayUinPro.Check")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "error, " + paramToServiceMsg.getUin() + " not in gray list");
        }
        localObject2 = w.a(paramToServiceMsg);
        try
        {
          ((FromServiceMsg)localObject2).setBusinessFail(2008, new String(((com.tencent.msf.service.protocol.e.d)???).c, "UTF-8"));
          ((FromServiceMsg)localObject2).addAttribute(((FromServiceMsg)localObject2).getServiceCmd(), String.valueOf(((com.tencent.msf.service.protocol.e.d)???).b));
          this.D.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject2);
          if (this.D.getAccountCenter().g(((FromServiceMsg)localObject2).getUin()))
          {
            QLog.d("MSF.C.NetConnTag", 1, Thread.currentThread().getName() + " addSendQueue setAccountNoLogin uin=" + MsfSdkUtils.getShortUin(((FromServiceMsg)localObject2).getUin()));
            this.D.getAccountCenter().k(((FromServiceMsg)localObject2).getUin());
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
      if ((this.D.standbyModeManager != null) && (this.D.standbyModeManager.b()))
      {
        if (!this.D.standbyModeManager.a(paramToServiceMsg.getServiceCmd()))
        {
          QLog.d("MSF.C.NetConnTag", 1, "refuse to send request cmd: " + paramToServiceMsg.getServiceCmd() + " ssoseq: " + paramToServiceMsg.getRequestSsoSeq() + " by standbyMode");
          this.D.getStandyModeManager().a(paramToServiceMsg);
          ??? = w.a(paramToServiceMsg);
          ((FromServiceMsg)???).setBusinessFail(2018, "standby mode force stop request");
          this.D.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
          if (!this.b.b())
          {
            ??? = MsfMsgUtil.getConnOpenMsg("");
            MsfSdkUtils.addToMsgProcessName("", (ToServiceMsg)???);
            this.D.sendSsoMsg((ToServiceMsg)???);
          }
          return paramToServiceMsg.getRequestSsoSeq();
        }
        this.D.getStandyModeManager().b(paramToServiceMsg);
      }
      CodecWarpper.getFileStoreKey();
      ??? = this.D.getAccountCenter().i(paramToServiceMsg.getUin());
      if (??? != null) {
        paramToServiceMsg.setUin((String)???);
      }
      if ((!paramToServiceMsg.getUin().equals("0")) && (!this.aq.equals(paramToServiceMsg.getUin())))
      {
        this.aq = paramToServiceMsg.getUin();
        if (this.D.statReporter != null) {
          this.D.statReporter.a(this.aq);
        }
        if (this.ap != paramToServiceMsg.getAppId()) {
          this.ap = paramToServiceMsg.getAppId();
        }
        if (paramToServiceMsg.getRequestSsoSeq() == -1) {
          paramToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
        }
        if (!paramToServiceMsg.getAttributes().containsKey("__timestamp_app2msf")) {
          paramToServiceMsg.addAttribute("__timestamp_app2msf", Long.valueOf(System.currentTimeMillis()));
        }
        paramToServiceMsg.addAttribute("__timestamp_addSendQueue", Long.valueOf(System.currentTimeMillis()));
        if ((!this.q) && (this.r))
        {
          this.p = SystemClock.elapsedRealtime();
          this.q = true;
        }
        if (((paramToServiceMsg.getServiceCmd().equals("StatSvc.register")) || (paramToServiceMsg.getServiceCmd().equals("StatSvc.get"))) && (paramToServiceMsg.getMsfCommand().equals(MsfCommand._msf_RegPush)) && (this.r))
        {
          this.p = SystemClock.elapsedRealtime();
          this.q = true;
          ??? = com.tencent.mobileqq.msf.core.a.a.d();
          if ((??? == null) || (this.au.size() == ???.length)) {
            break label1687;
          }
          a((String[])???);
        }
      }
      for (;;)
      {
        if ((this.r) && (SystemClock.elapsedRealtime() - this.p < this.n))
        {
          if (this.au.size() == 0) {
            a(null);
          }
          if ((this.au.contains(paramToServiceMsg.getServiceCmd())) || ((!TextUtils.isEmpty(paramToServiceMsg.getServiceCmd())) && (paramToServiceMsg.getServiceCmd().startsWith("wtlogin."))) || (("ConfigurationService.ReqGetConfig".equals(paramToServiceMsg.getServiceCmd())) && (((Boolean)paramToServiceMsg.getAttribute("_attr_disable_merge", Boolean.valueOf(false))).booleanValue())))
          {
            return g(paramToServiceMsg);
            if ((!paramToServiceMsg.getUin().equals("0")) || (paramToServiceMsg.getAttributes().containsKey("__base_tag_isAppMsg")) || (paramToServiceMsg.getServiceCmd().equals("PhSigLcId.Check"))) {
              break;
            }
            paramToServiceMsg.setUin(j());
            break;
            label1687:
            if (??? != null) {
              continue;
            }
            a(null);
            continue;
          }
          this.L = SystemClock.elapsedRealtime();
          this.h.add(paramToServiceMsg);
          i1 = paramToServiceMsg.getWupBuffer().length;
          for (;;)
          {
            synchronized (this.aw)
            {
              this.l = (i1 + this.l);
              if (!this.av)
              {
                this.al.postDelayed(this.i, this.m);
                this.av = true;
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
      return g(paramToServiceMsg);
      i1 = 0;
      continue;
      label1969:
      i1 = 1;
      ??? = localObject2;
    }
  }
  
  public long b()
  {
    return this.aA;
  }
  
  public void b(int paramInt)
  {
    try
    {
      if ((this.b.b()) && (this.b.l() != null) && (this.b.l().i() == paramInt)) {
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
    if ((this.ak == null) || (!this.ak.getAttributes().containsKey("_attr_regprxy_socket_hashcode")) || (!this.ak.getAttributes().containsKey("_attr_regprxy_random_code")))
    {
      QLog.d("MSF.C.NetConnTag", 1, "not tag regprxysvc resp seq:" + paramFromServiceMsg.getRequestSsoSeq() + " by infoLogin error");
      return;
    }
    int i1 = this.b.l().i();
    if ((!this.b.b()) || (i1 == 0))
    {
      QLog.d("MSF.C.NetConnTag", 1, "not tag regprxysvc resp seq:" + paramFromServiceMsg.getRequestSsoSeq() + " by disconn, sockethashcode = " + i1);
      return;
    }
    if (i1 == ((Integer)this.ak.getAttributes().get("_attr_regprxy_socket_hashcode")).intValue())
    {
      paramFromServiceMsg.getAttributes().put("_attr_regprxy_random_code", this.ak.getAttributes().get("_attr_regprxy_random_code"));
      return;
    }
    QLog.d("MSF.C.NetConnTag", 1, "not tag regprxysvc resp seq:" + paramFromServiceMsg.getRequestSsoSeq() + " by socket changed");
  }
  
  public ToServiceMsg c(int paramInt)
  {
    ToServiceMsg localToServiceMsg = (ToServiceMsg)this.d.remove(Integer.valueOf(paramInt));
    if (localToServiceMsg != null)
    {
      Runnable localRunnable = (Runnable)localToServiceMsg.getAttributes().remove("to_timeoutCallbacker");
      this.D.msfAlarmer.b().removeCallbacks(localRunnable);
      if (com.tencent.mobileqq.msf.core.a.a.x())
      {
        localRunnable = (Runnable)localToServiceMsg.getAttributes().remove("to_predetect_timeoutCallbacker");
        if (localRunnable != null) {
          this.D.msfAlarmer.b().removeCallbacks(localRunnable);
        }
      }
      if ((this.D.getStatReporter() != null) && (localToServiceMsg.isSupportRetry())) {
        this.D.getStatReporter().e(true);
      }
    }
    return localToServiceMsg;
  }
  
  public void c()
  {
    this.aA = 0L;
  }
  
  public void c(ToServiceMsg paramToServiceMsg)
  {
    this.d.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), paramToServiceMsg);
    paramToServiceMsg.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(am.incrementAndGet()));
    if (paramToServiceMsg.getTimeout() == -1L) {
      paramToServiceMsg.setTimeout(30000L);
    }
    for (Runnable localRunnable = this.D.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());; localRunnable = this.D.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout()))
    {
      paramToServiceMsg.addAttribute("to_timeoutCallbacker", localRunnable);
      return;
    }
  }
  
  public void d(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      Runnable localRunnable = (Runnable)paramToServiceMsg.getAttributes().remove("to_timeoutCallbacker");
      if (localRunnable != null) {
        this.D.msfAlarmer.b().removeCallbacks(localRunnable);
      }
      if (com.tencent.mobileqq.msf.core.a.a.x())
      {
        paramToServiceMsg = (Runnable)paramToServiceMsg.getAttributes().remove("to_predetect_timeoutCallbacker");
        if (paramToServiceMsg != null) {
          this.D.msfAlarmer.b().removeCallbacks(paramToServiceMsg);
        }
      }
    }
  }
  
  public boolean d()
  {
    return this.d.isEmpty();
  }
  
  public byte[] e()
  {
    return this.aC;
  }
  
  public byte[] e(ToServiceMsg paramToServiceMsg)
  {
    Object localObject1 = null;
    if (paramToServiceMsg != null) {}
    for (;;)
    {
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
          byte b2 = j.b();
          i1 = (byte)NetConnInfoCenter.getActiveNetIpFamily(false);
          if (!P) {
            break label312;
          }
          b1 = (byte)(i1 | 0x4);
          if (this.b.l().b() == null) {
            break label322;
          }
          i1 = this.b.l().b().d();
          localObject2 = b(paramToServiceMsg, i1);
          h();
          byte[] arrayOfByte1 = e();
          byte[] arrayOfByte2 = paramToServiceMsg.getWupBuffer();
          if (591 == CodecWarpper.getSharedObjectVersion()) {
            return CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), w.d(), w.f(), w.g(), "", (String)localObject1, arrayOfByte1, paramToServiceMsg.getAppId(), this.D.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b2, arrayOfByte2, false);
          }
          if ((595 == CodecWarpper.getSharedObjectVersion()) || (600 == CodecWarpper.getSharedObjectVersion())) {
            return CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), w.d(), w.f(), w.g(), "", (String)localObject1, arrayOfByte1, paramToServiceMsg.getAppId(), this.D.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b2, (byte[])localObject2, arrayOfByte2, false);
          }
          return CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), w.d(), w.f(), w.g(), "", (String)localObject1, arrayOfByte1, paramToServiceMsg.getAppId(), this.D.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b2, b1, (byte[])localObject2, arrayOfByte2, false);
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
      label312:
      byte b1 = (byte)(i1 & 0xFFFFFFFB);
      continue;
      label322:
      int i1 = 1;
    }
  }
  
  public void f()
  {
    if (this.aq != "0") {
      this.D.getAccountCenter().a(false);
    }
  }
  
  public void f(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {}
    while ((paramToServiceMsg.getMsfCommand() == MsfCommand.msf_ssoping) || (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_HeartbeatAlive)) {
      return;
    }
    if (paramToServiceMsg.getAttributes().containsKey("__timestamp_msf2net")) {}
    for (long l1 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net")).longValue();; l1 = 0L)
    {
      if ((l1 != 0L) && (l1 <= this.b.l().e()))
      {
        QLog.d("MSF.C.NetConnTag", 1, "preDetectTimeoutMsg return before connSucc.");
        return;
      }
      for (;;)
      {
        synchronized (this.Q)
        {
          if ((!this.Q.get()) || (System.currentTimeMillis() - this.S >= com.tencent.mobileqq.msf.core.a.a.O() + 120000))
          {
            l1 = System.currentTimeMillis();
            if (!QLog.isColorLevel()) {
              break label287;
            }
            localObject = paramToServiceMsg.getServiceCmd();
            if (l1 - this.S <= com.tencent.mobileqq.msf.core.a.a.P()) {
              break label299;
            }
            w();
            QLog.d("MSF.C.NetConnTag", 1, "preDetectTimeoutMsg cmd:" + (String)localObject + ", ssoSeq:" + paramToServiceMsg.getRequestSsoSeq());
            if (this.D.statReporter != null)
            {
              localObject = new HashMap();
              ((HashMap)localObject).put("param_preDetectUin", paramToServiceMsg.getUin());
              ((HashMap)localObject).put("param_preDetectCmd", paramToServiceMsg.getServiceCmd());
              ((HashMap)localObject).put("param_preDetectSsoseq", String.valueOf(paramToServiceMsg.getRequestSsoSeq()));
              this.D.statReporter.a("dim.Msf.PreDetectTimeoutMsg", true, 0L, 0L, (Map)localObject, false, false);
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
  
  public void g()
  {
    b(false);
  }
  
  public void i()
  {
    this.C.nativeClearReceData();
  }
  
  public String j()
  {
    return this.aq;
  }
  
  public int k()
  {
    return this.ap;
  }
  
  public void l()
  {
    try
    {
      if (this.ah)
      {
        Iterator localIterator = this.ag.iterator();
        while (localIterator.hasNext())
        {
          HashMap localHashMap = (HashMap)localIterator.next();
          try
          {
            this.D.configManager.a(localHashMap, "");
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
      QLog.d("MSF.C.NetConnTag", 2, "report waitReportData succ " + this.ag.size());
    }
    this.ag.clear();
    this.ah = false;
  }
  
  public void m()
  {
    Iterator localIterator = this.d.entrySet().iterator();
    label271:
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
        if ((localObject1 == null) || (this.g.contains(localObject1))) {
          continue;
        }
        if (((ToServiceMsg)localObject1).isFastResendEnabled()) {
          i1 = 1;
        }
      }
      for (;;)
      {
        if (i1 == 0) {
          break label271;
        }
        Object localObject2 = MsfSdkUtils.constructResponse((ToServiceMsg)localObject1, 2901, "", null);
        ((FromServiceMsg)localObject2).setBusinessFail(2901);
        if ((localObject1 != null) && (this.D.quicksender != null) && (this.D.quicksender.b((ToServiceMsg)localObject1))) {
          this.D.quicksender.a((ToServiceMsg)localObject1, (FromServiceMsg)localObject2, -1);
        }
        this.D.addRespToQuque((ToServiceMsg)localObject1, (FromServiceMsg)localObject2);
        localIterator.remove();
        break;
        if (((ToServiceMsg)localObject1).isSupportRetry())
        {
          QLog.d("MSF.C.NetConnTag", 1, "send reteyMsg :" + ((ToServiceMsg)localObject1).getStringForLog());
          this.g.offer(localObject1);
          i1 = 0;
        }
        else
        {
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
  }
  
  public void p()
  {
    if ((this.b != null) && (this.b.l() != null)) {
      this.b.l().g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.aj
 * JD-Core Version:    0.7.0.1
 */