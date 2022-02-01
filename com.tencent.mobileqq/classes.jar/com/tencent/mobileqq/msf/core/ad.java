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
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.msf.core.a.a.a;
import com.tencent.mobileqq.msf.core.net.a.f;
import com.tencent.mobileqq.msf.core.net.k;
import com.tencent.mobileqq.msf.core.net.k.b;
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
import com.tencent.msf.service.protocol.e.c;
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

public class ad
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
  public static int V = 0;
  public static AtomicBoolean W;
  public static final String Y = "GrayUinPro.Check";
  public static final String Z = "res";
  public static final String a = "MSF.C.NetConnTag";
  private static String aB;
  private static int aC = 0;
  private static String aD;
  private static final String aH = "gray_uin_check_dir";
  private static final String aI = "gray_uin_check_file_num";
  private static final String aJ = "gray_uin_check_file";
  private static final String aK;
  private static final String aL;
  private static final String aM;
  private static AtomicBoolean aQ = new AtomicBoolean();
  public static final int ac = -10008;
  public static final int ad = -302;
  public static final int ae = 302;
  static CopyOnWriteArraySet af;
  private static final int ai = 50;
  private static final AtomicInteger am = new AtomicInteger();
  private static boolean ao = false;
  private static int ar = 0;
  private static String as;
  private static String[] at;
  public static final String c = "__extraTimeoutSeq";
  public static boolean s = false;
  public static ConcurrentHashMap t = new ConcurrentHashMap();
  public static ConcurrentHashMap u = new ConcurrentHashMap();
  public static long v = -1L;
  public static int w = -1;
  public static int x = 0;
  public static boolean y = true;
  public static long z = -1L;
  public ad.a C = new ad.a(this);
  MsfCore D;
  public f I = null;
  ad.c K = new ad.c(this);
  long L;
  AtomicBoolean Q = new AtomicBoolean();
  int R = 0;
  long S = 0L;
  long T = 0L;
  HashSet X = new HashSet();
  private long aA = 0L;
  private byte[] aE = null;
  private long aF = 0L;
  private Random aG = new Random(System.currentTimeMillis());
  private long aN = 0L;
  private boolean aO = false;
  private AtomicBoolean aP = new AtomicBoolean(true);
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
  ad.b i = new ad.b(this);
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
    aC = -1;
    aD = "";
    U = 0L;
    V = -1;
    W = new AtomicBoolean();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/storage/emulated/0/tencent");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("MobileQQ");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("gray_uin_check_dir");
    aK = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("/storage/emulated/0/tencent");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("MobileQQ");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("gray_uin_check_dir");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("gray_uin_check_file_num");
    aL = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("/storage/emulated/0/tencent");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("MobileQQ");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("gray_uin_check_dir");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("gray_uin_check_file");
    aM = localStringBuilder.toString();
    af = new CopyOnWriteArraySet();
  }
  
  public ad(MsfCore paramMsfCore)
  {
    this.D = paramMsfCore;
    Object localObject = new HandlerThread("mergehandle", 5);
    ((HandlerThread)localObject).start();
    this.al = new Handler(((HandlerThread)localObject).getLooper());
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
        if (QLog.isColorLevel())
        {
          paramMsfCore = new StringBuilder();
          paramMsfCore.append("maxDelaySize: ");
          paramMsfCore.append(this.k);
          paramMsfCore.append(" noMergeSize: ");
          paramMsfCore.append(this.o);
          paramMsfCore.append(" globaldelayTime: ");
          paramMsfCore.append(this.m);
          paramMsfCore.append(" delayWaitSendCount: ");
          paramMsfCore.append(this.j);
          QLog.d("MSF.C.NetConnTag", 2, paramMsfCore.toString());
        }
      }
    }
    catch (Exception paramMsfCore)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramMsfCore);
      QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject).toString(), paramMsfCore);
    }
    try
    {
      a(com.tencent.mobileqq.msf.core.a.a.d());
    }
    catch (Exception paramMsfCore)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramMsfCore);
      QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject).toString(), paramMsfCore);
    }
    try
    {
      this.n = Integer.parseInt(com.tencent.mobileqq.msf.core.a.a.e());
      if (QLog.isColorLevel())
      {
        paramMsfCore = new StringBuilder();
        paramMsfCore.append("mergeDuration: ");
        paramMsfCore.append(this.n);
        QLog.d("MSF.C.NetConnTag", 2, paramMsfCore.toString());
      }
    }
    catch (Exception paramMsfCore)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramMsfCore);
      QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject).toString(), paramMsfCore);
    }
    x();
  }
  
  private void A()
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
    B();
  }
  
  private void B()
  {
    this.R = 0;
    this.Q.set(false);
  }
  
  private void C()
  {
    for (;;)
    {
      int i1;
      try
      {
        Object localObject = Thread.currentThread().getThreadGroup();
        if (((ThreadGroup)localObject).getParent() != null)
        {
          localObject = ((ThreadGroup)localObject).getParent();
          continue;
        }
        Thread[] arrayOfThread = new Thread[((ThreadGroup)localObject).activeCount()];
        ((ThreadGroup)localObject).enumerate(arrayOfThread);
        int i2 = this.g.size();
        int i3 = arrayOfThread.length;
        boolean bool2 = false;
        i1 = 0;
        boolean bool1 = bool2;
        if (i1 < i3)
        {
          localObject = arrayOfThread[i1];
          if ((localObject == null) || (!"MsfCoreMsgSender".equals(((Thread)localObject).getName()))) {
            break label169;
          }
          bool1 = true;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sender alive:");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append(" size: ");
        ((StringBuilder)localObject).append(i2);
        QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject).toString());
        return;
      }
      catch (Exception localException)
      {
        QLog.d("MSF.C.NetConnTag", 1, "printCurrentThreads error", localException);
        return;
      }
      label169:
      i1 += 1;
    }
  }
  
  private void D()
  {
    File localFile = new File(aK);
    Object localObject = new File(aL);
    try
    {
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      if (!((File)localObject).exists())
      {
        ((File)localObject).createNewFile();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ensureFileExist ");
      ((StringBuilder)localObject).append(localThrowable);
      QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private static boolean E()
  {
    MsfCore localMsfCore = MsfCore.sCore;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localMsfCore != null)
    {
      bool1 = bool2;
      if (MsfCore.sCore.sender != null)
      {
        if (MsfCore.sCore.sender.b == null) {
          return false;
        }
        bool1 = bool2;
        if (MsfCore.sCore.sender.b.f() == 2) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void F() {}
  
  public static void a(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      af.add(paramString);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("use simple head for uin:");
      localStringBuilder.append(MsfSdkUtils.getShortUin(paramString));
      QLog.d("MSF.C.NetConnTag", 1, localStringBuilder.toString());
    }
    else
    {
      af.remove(paramString);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("use full head for uin:");
      localStringBuilder.append(MsfSdkUtils.getShortUin(paramString));
      QLog.d("MSF.C.NetConnTag", 1, localStringBuilder.toString());
      if (t.containsKey(paramString))
      {
        t.remove(paramString);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("clear storeSendSsoSeq tag for uin:");
        localStringBuilder.append(MsfSdkUtils.getShortUin(paramString));
        QLog.d("MSF.C.NetConnTag", 1, localStringBuilder.toString());
      }
    }
    CodecWarpper.nativeSetUseSimpleHead(paramString, paramBoolean);
  }
  
  /* Error */
  private void b(Context paramContext)
  {
    // Byte code:
    //   0: new 230	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: invokestatic 661	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   12: invokevirtual 665	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   15: invokevirtual 668	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   18: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_1
    //   23: ldc_w 670
    //   26: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_1
    //   31: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: astore_1
    //   35: new 230	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   42: astore_2
    //   43: aload_2
    //   44: aload_1
    //   45: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_2
    //   50: ldc_w 672
    //   53: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_2
    //   58: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore_3
    //   62: new 239	java/io/File
    //   65: dup
    //   66: aload_3
    //   67: invokespecial 594	java/io/File:<init>	(Ljava/lang/String;)V
    //   70: astore_1
    //   71: aload_1
    //   72: astore_2
    //   73: aload_1
    //   74: invokevirtual 675	java/io/File:canRead	()Z
    //   77: ifne +12 -> 89
    //   80: new 239	java/io/File
    //   83: dup
    //   84: aload_3
    //   85: invokespecial 594	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: astore_2
    //   89: invokestatic 463	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq +89 -> 181
    //   95: new 230	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   102: astore_1
    //   103: aload_1
    //   104: ldc_w 677
    //   107: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_1
    //   112: aload_2
    //   113: invokevirtual 668	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   116: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload_1
    //   121: ldc_w 679
    //   124: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload_1
    //   129: aload_2
    //   130: invokevirtual 682	java/io/File:isFile	()Z
    //   133: invokevirtual 586	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload_1
    //   138: ldc_w 684
    //   141: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload_1
    //   146: aload_2
    //   147: invokevirtual 675	java/io/File:canRead	()Z
    //   150: invokevirtual 586	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload_1
    //   155: ldc_w 686
    //   158: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload_1
    //   163: aload_2
    //   164: invokevirtual 689	java/io/File:length	()J
    //   167: invokevirtual 692	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: ldc 36
    //   173: iconst_2
    //   174: aload_1
    //   175: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 694	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: new 696	java/util/Properties
    //   184: dup
    //   185: invokespecial 697	java/util/Properties:<init>	()V
    //   188: astore 6
    //   190: aconst_null
    //   191: astore 5
    //   193: aconst_null
    //   194: astore 4
    //   196: aconst_null
    //   197: astore_3
    //   198: aload 5
    //   200: astore_1
    //   201: aload_2
    //   202: invokevirtual 597	java/io/File:exists	()Z
    //   205: ifeq +42 -> 247
    //   208: aload 5
    //   210: astore_1
    //   211: new 699	java/io/FileInputStream
    //   214: dup
    //   215: aload_2
    //   216: invokespecial 702	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   219: astore_2
    //   220: aload 6
    //   222: aload_2
    //   223: invokevirtual 706	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   226: aload_2
    //   227: invokevirtual 709	java/io/FileInputStream:close	()V
    //   230: aload_2
    //   231: astore_3
    //   232: goto +15 -> 247
    //   235: astore_3
    //   236: aload_2
    //   237: astore_1
    //   238: aload_3
    //   239: astore_2
    //   240: goto +177 -> 417
    //   243: astore_3
    //   244: goto +30 -> 274
    //   247: aload_3
    //   248: ifnull +40 -> 288
    //   251: aload_3
    //   252: invokevirtual 709	java/io/FileInputStream:close	()V
    //   255: goto +33 -> 288
    //   258: astore_1
    //   259: aload_1
    //   260: invokevirtual 712	java/io/IOException:printStackTrace	()V
    //   263: goto +25 -> 288
    //   266: astore_2
    //   267: goto +150 -> 417
    //   270: astore_3
    //   271: aload 4
    //   273: astore_2
    //   274: aload_2
    //   275: astore_1
    //   276: aload_3
    //   277: invokevirtual 713	java/lang/Exception:printStackTrace	()V
    //   280: aload_2
    //   281: ifnull +7 -> 288
    //   284: aload_2
    //   285: invokevirtual 709	java/io/FileInputStream:close	()V
    //   288: aload 6
    //   290: ldc_w 715
    //   293: invokevirtual 718	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   296: astore_1
    //   297: aload_1
    //   298: ifnull +114 -> 412
    //   301: aload_1
    //   302: invokevirtual 721	java/lang/String:trim	()Ljava/lang/String;
    //   305: invokevirtual 723	java/lang/String:length	()I
    //   308: ifle +104 -> 412
    //   311: aload_1
    //   312: invokestatic 728	com/tencent/mobileqq/msf/core/d:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/msf/core/d;
    //   315: astore_2
    //   316: aload_2
    //   317: invokevirtual 730	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   320: ifnull +91 -> 411
    //   323: aload_2
    //   324: invokevirtual 731	com/tencent/mobileqq/msf/core/d:f	()I
    //   327: ifgt +4 -> 331
    //   330: return
    //   331: aload_1
    //   332: invokevirtual 721	java/lang/String:trim	()Ljava/lang/String;
    //   335: ldc_w 479
    //   338: ldc 197
    //   340: invokevirtual 735	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   343: astore_1
    //   344: aload_0
    //   345: getfield 440	com/tencent/mobileqq/msf/core/ad:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   348: aload_1
    //   349: invokevirtual 737	com/tencent/mobileqq/msf/core/net/n:a	(Ljava/lang/String;)V
    //   352: new 230	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   359: astore_2
    //   360: aload_2
    //   361: ldc_w 739
    //   364: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload_2
    //   369: aload_1
    //   370: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: ldc 36
    //   376: iconst_1
    //   377: aload_2
    //   378: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokestatic 477	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   384: aload 6
    //   386: ldc_w 741
    //   389: invokevirtual 718	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   392: astore_1
    //   393: aload_1
    //   394: ifnull +17 -> 411
    //   397: aload_1
    //   398: invokevirtual 721	java/lang/String:trim	()Ljava/lang/String;
    //   401: invokevirtual 723	java/lang/String:length	()I
    //   404: ifle +7 -> 411
    //   407: aload_1
    //   408: putstatic 219	com/tencent/mobileqq/msf/core/ad:aD	Ljava/lang/String;
    //   411: return
    //   412: aload_0
    //   413: invokespecial 743	com/tencent/mobileqq/msf/core/ad:z	()V
    //   416: return
    //   417: aload_1
    //   418: ifnull +15 -> 433
    //   421: aload_1
    //   422: invokevirtual 709	java/io/FileInputStream:close	()V
    //   425: goto +8 -> 433
    //   428: astore_1
    //   429: aload_1
    //   430: invokevirtual 712	java/io/IOException:printStackTrace	()V
    //   433: aload_2
    //   434: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	435	0	this	ad
    //   0	435	1	paramContext	Context
    //   42	198	2	localObject1	Object
    //   266	1	2	localObject2	Object
    //   273	161	2	localObject3	Object
    //   61	171	3	localObject4	Object
    //   235	4	3	localObject5	Object
    //   243	9	3	localException1	Exception
    //   270	7	3	localException2	Exception
    //   194	78	4	localObject6	Object
    //   191	18	5	localObject7	Object
    //   188	197	6	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   220	230	235	finally
    //   220	230	243	java/lang/Exception
    //   251	255	258	java/io/IOException
    //   284	288	258	java/io/IOException
    //   201	208	266	finally
    //   211	220	266	finally
    //   276	280	266	finally
    //   201	208	270	java/lang/Exception
    //   211	220	270	java/lang/Exception
    //   421	425	428	java/io/IOException
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.b.b())
    {
      Object localObject = new ToServiceMsg("", "0", "Heartbeat.Alive");
      ((ToServiceMsg)localObject).setMsfCommand(MsfCommand._msf_HeartbeatAlive);
      ((ToServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
      ((ToServiceMsg)localObject).setAppId(this.D.getMsfAppid());
      ((ToServiceMsg)localObject).putWupBuffer(new byte[] { 0, 0, 0, 4 });
      if (paramBoolean) {
        ((ToServiceMsg)localObject).setTimeout(com.tencent.mobileqq.msf.core.a.a.C());
      } else {
        ((ToServiceMsg)localObject).setTimeout(10000L);
      }
      a((ToServiceMsg)localObject);
      this.R = com.tencent.mobileqq.msf.core.a.a.I();
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.NetConnTag", 4, "send fast net detect Heartbeat msg ok");
      }
      if ((!paramBoolean) || (com.tencent.mobileqq.msf.core.a.a.Q()))
      {
        this.S = System.currentTimeMillis();
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Update send heartbeat time: ");
          ((StringBuilder)localObject).append(this.S);
          QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject).toString());
        }
      }
      this.Q.set(true);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.NetConnTag", 4, "conn is also closed.not need send heartbeat msg");
    }
    B();
  }
  
  public static boolean b(String paramString)
  {
    return af.contains(paramString);
  }
  
  public static byte[] b(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    paramToServiceMsg = d(paramToServiceMsg, paramInt);
    if (paramToServiceMsg == null) {
      return null;
    }
    return paramToServiceMsg.toByteArray();
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    int i1 = paramArrayOfByte.length + 4;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i1);
    localByteBuffer.putInt(i1).put(paramArrayOfByte).flip();
    return localByteBuffer.array();
  }
  
  public static void c(String paramString)
  {
    if (!E()) {
      as = paramString;
    }
  }
  
  public static byte[] c(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    if (TextUtils.isEmpty(aB))
    {
      QLog.d("MSF.C.NetConnTag", 1, "[buildReserveFiledWithQimei] qimei is null.");
      return null;
    }
    SSOReserveField.ReserveFields localReserveFields = d(paramToServiceMsg, paramInt);
    paramToServiceMsg = localReserveFields;
    if (localReserveFields == null) {
      paramToServiceMsg = new SSOReserveField.ReserveFields();
    }
    paramToServiceMsg.qimei.set(ByteStringMicro.copyFrom(aB.getBytes()));
    return paramToServiceMsg.toByteArray();
  }
  
  private static SSOReserveField.ReserveFields d(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    for (;;)
    {
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
          boolean bool = paramToServiceMsg.getServiceCmd().equals("MessageSvc.PbGetMsg");
          Object localObject1;
          if ((bool) && (i3 % i2 == i2 - 1))
          {
            SSOReserveField.ReserveFields localReserveFields = new SSOReserveField.ReserveFields();
            paramToServiceMsg = (String)paramToServiceMsg.getAttribute("sso_push_timestamp");
            localObject1 = localReserveFields;
            if (paramToServiceMsg != null)
            {
              localObject1 = paramToServiceMsg.split("\\|");
              String str = Build.MODEL.replace('\n', '-');
              i2 = Build.VERSION.SDK_INT;
              Object localObject2 = Build.DISPLAY;
              Object localObject3 = Build.MANUFACTURER;
              if (localObject1.length == 3)
              {
                StringBuilder localStringBuilder1 = new StringBuilder();
                StringBuilder localStringBuilder2 = new StringBuilder();
                localStringBuilder2.append("model:");
                localStringBuilder2.append(str);
                localStringBuilder2.append(";");
                localStringBuilder1.append(localStringBuilder2.toString());
                localStringBuilder2 = new StringBuilder();
                localStringBuilder2.append("os:");
                localStringBuilder2.append(i2);
                localStringBuilder2.append(";");
                localStringBuilder1.append(localStringBuilder2.toString());
                localStringBuilder1.append("version:v2");
                if (com.tencent.mobileqq.msf.core.a.a.bl())
                {
                  localStringBuilder2 = new StringBuilder();
                  localStringBuilder2.append("man:");
                  localStringBuilder2.append((String)localObject3);
                  localStringBuilder1.append(localStringBuilder2.toString());
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("sys:");
                  ((StringBuilder)localObject3).append((String)localObject2);
                  localStringBuilder1.append(((StringBuilder)localObject3).toString());
                }
                localReserveFields.sso_send.set(Long.parseLong(localObject1[0]));
                localReserveFields.sdk_recv.set(Long.parseLong(localObject1[1]));
                localReserveFields.app_recv.set(Long.parseLong(localObject1[2]));
                localReserveFields.sdk_send.set(System.currentTimeMillis());
                localReserveFields.type.set(w);
                localReserveFields.extra.set(localStringBuilder1.toString());
                if (i1 > 0) {
                  localReserveFields.locale_id.set(i1);
                }
                if ((2 <= paramInt) && (N != null))
                {
                  if (QLog.isColorLevel())
                  {
                    localObject2 = new StringBuilder();
                    ((StringBuilder)localObject2).append("MSF.C.CodecWarpper buildReserveFiled sGwV4Sec:");
                    ((StringBuilder)localObject2).append(N);
                    QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)localObject2).toString());
                  }
                  localReserveFields.client_ipcookie.set(ByteStringMicro.copyFrom(N));
                }
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("msf get timestamp:");
              ((StringBuilder)localObject2).append(paramToServiceMsg);
              ((StringBuilder)localObject2).append(", length:");
              ((StringBuilder)localObject2).append(localObject1.length);
              ((StringBuilder)localObject2).append(", model:");
              ((StringBuilder)localObject2).append(str);
              ((StringBuilder)localObject2).append(", type:");
              ((StringBuilder)localObject2).append(w);
              QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject2).toString());
              return localReserveFields;
            }
          }
          else
          {
            if (i1 <= 0) {
              break label717;
            }
            paramToServiceMsg = new SSOReserveField.ReserveFields();
            paramToServiceMsg.locale_id.set(i1);
            localObject1 = paramToServiceMsg;
            if (2 <= paramInt)
            {
              localObject1 = paramToServiceMsg;
              if (N != null)
              {
                if (QLog.isColorLevel())
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("MSF.C.CodecWarpper buildReserveFiled sGwV4Sec:");
                  ((StringBuilder)localObject1).append(N);
                  QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)localObject1).toString());
                }
                localObject1 = paramToServiceMsg;
                if (paramToServiceMsg == null) {
                  localObject1 = new SSOReserveField.ReserveFields();
                }
                ((SSOReserveField.ReserveFields)localObject1).client_ipcookie.set(ByteStringMicro.copyFrom(N));
              }
            }
          }
          return localObject1;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.d("MSF.C.NetConnTag", 1, "failed to construct reserve field", paramToServiceMsg);
        return null;
      }
      int i1 = 0;
      continue;
      label717:
      paramToServiceMsg = null;
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
  
  /* Error */
  private String f(int paramInt)
  {
    // Byte code:
    //   0: new 239	java/io/File
    //   3: dup
    //   4: getstatic 252	com/tencent/mobileqq/msf/core/ad:aL	Ljava/lang/String;
    //   7: invokespecial 594	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: new 239	java/io/File
    //   14: dup
    //   15: getstatic 254	com/tencent/mobileqq/msf/core/ad:aM	Ljava/lang/String;
    //   18: invokespecial 594	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore 7
    //   23: ldc 197
    //   25: astore 4
    //   27: aconst_null
    //   28: astore 5
    //   30: aconst_null
    //   31: astore 6
    //   33: aload 4
    //   35: astore_3
    //   36: aload 7
    //   38: invokevirtual 597	java/io/File:exists	()Z
    //   41: ifeq +62 -> 103
    //   44: aload 4
    //   46: astore_3
    //   47: aload 7
    //   49: invokevirtual 970	java/io/File:delete	()Z
    //   52: pop
    //   53: aload 4
    //   55: astore_3
    //   56: new 230	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   63: astore 7
    //   65: aload 4
    //   67: astore_3
    //   68: aload 7
    //   70: ldc_w 972
    //   73: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 4
    //   79: astore_3
    //   80: aload 7
    //   82: getstatic 254	com/tencent/mobileqq/msf/core/ad:aM	Ljava/lang/String;
    //   85: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 4
    //   91: astore_3
    //   92: ldc 36
    //   94: iconst_1
    //   95: aload 7
    //   97: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 477	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: aload 4
    //   105: astore_3
    //   106: aload_2
    //   107: invokevirtual 597	java/io/File:exists	()Z
    //   110: ifne +73 -> 183
    //   113: aload 4
    //   115: astore_3
    //   116: aload_0
    //   117: invokespecial 974	com/tencent/mobileqq/msf/core/ad:D	()V
    //   120: aload 4
    //   122: astore_3
    //   123: aload_0
    //   124: iload_1
    //   125: invokespecial 976	com/tencent/mobileqq/msf/core/ad:e	(I)Ljava/lang/String;
    //   128: astore 4
    //   130: aload 4
    //   132: astore_3
    //   133: new 978	java/io/FileOutputStream
    //   136: dup
    //   137: aload_2
    //   138: invokespecial 979	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   141: astore_2
    //   142: aload_2
    //   143: aload 4
    //   145: invokevirtual 818	java/lang/String:getBytes	()[B
    //   148: invokevirtual 982	java/io/FileOutputStream:write	([B)V
    //   151: aload 4
    //   153: astore_3
    //   154: aconst_null
    //   155: astore 5
    //   157: aload_2
    //   158: astore 4
    //   160: goto +64 -> 224
    //   163: astore_3
    //   164: aload 5
    //   166: astore 4
    //   168: goto +354 -> 522
    //   171: astore 5
    //   173: aload 4
    //   175: astore_3
    //   176: aload 6
    //   178: astore 4
    //   180: goto +200 -> 380
    //   183: aload 4
    //   185: astore_3
    //   186: new 699	java/io/FileInputStream
    //   189: dup
    //   190: aload_2
    //   191: invokespecial 702	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   194: astore_2
    //   195: iload_1
    //   196: newarray byte
    //   198: astore_3
    //   199: aload_2
    //   200: aload_3
    //   201: invokevirtual 986	java/io/FileInputStream:read	([B)I
    //   204: pop
    //   205: new 201	java/lang/String
    //   208: dup
    //   209: aload_3
    //   210: invokespecial 988	java/lang/String:<init>	([B)V
    //   213: astore_3
    //   214: aload_2
    //   215: invokevirtual 709	java/io/FileInputStream:close	()V
    //   218: aconst_null
    //   219: astore 4
    //   221: aload_2
    //   222: astore 5
    //   224: aload 5
    //   226: ifnull +48 -> 274
    //   229: aload 5
    //   231: invokevirtual 709	java/io/FileInputStream:close	()V
    //   234: goto +40 -> 274
    //   237: astore_2
    //   238: new 230	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   245: astore 5
    //   247: aload 5
    //   249: ldc_w 990
    //   252: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload 5
    //   258: aload_2
    //   259: invokevirtual 482	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: ldc 36
    //   265: iconst_1
    //   266: aload 5
    //   268: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 477	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aload_3
    //   275: astore_2
    //   276: aload 4
    //   278: ifnull +241 -> 519
    //   281: aload 4
    //   283: invokevirtual 991	java/io/FileOutputStream:close	()V
    //   286: aload_3
    //   287: areturn
    //   288: astore_2
    //   289: new 230	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   296: astore 4
    //   298: aload 4
    //   300: ldc_w 993
    //   303: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 4
    //   309: aload_2
    //   310: invokevirtual 482	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: ldc 36
    //   316: iconst_1
    //   317: aload 4
    //   319: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 477	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   325: aload_3
    //   326: areturn
    //   327: astore 5
    //   329: goto +21 -> 350
    //   332: astore_3
    //   333: aconst_null
    //   334: astore 5
    //   336: aload_2
    //   337: astore 4
    //   339: aload 5
    //   341: astore_2
    //   342: goto +180 -> 522
    //   345: astore 5
    //   347: aload 4
    //   349: astore_3
    //   350: aconst_null
    //   351: astore 6
    //   353: aload_2
    //   354: astore 4
    //   356: aload 6
    //   358: astore_2
    //   359: goto +21 -> 380
    //   362: astore_3
    //   363: aconst_null
    //   364: astore_2
    //   365: aload 5
    //   367: astore 4
    //   369: goto +153 -> 522
    //   372: astore 5
    //   374: aconst_null
    //   375: astore_2
    //   376: aload 6
    //   378: astore 4
    //   380: new 230	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   387: astore 6
    //   389: aload 6
    //   391: ldc_w 995
    //   394: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload 6
    //   400: aload 5
    //   402: invokevirtual 482	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: ldc 36
    //   408: iconst_1
    //   409: aload 6
    //   411: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 477	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: aload 4
    //   419: ifnull +50 -> 469
    //   422: aload 4
    //   424: invokevirtual 709	java/io/FileInputStream:close	()V
    //   427: goto +42 -> 469
    //   430: astore 4
    //   432: new 230	java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   439: astore 5
    //   441: aload 5
    //   443: ldc_w 990
    //   446: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload 5
    //   452: aload 4
    //   454: invokevirtual 482	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: ldc 36
    //   460: iconst_1
    //   461: aload 5
    //   463: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 477	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   469: aload_2
    //   470: ifnull +47 -> 517
    //   473: aload_2
    //   474: invokevirtual 991	java/io/FileOutputStream:close	()V
    //   477: goto +40 -> 517
    //   480: astore_2
    //   481: new 230	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   488: astore 4
    //   490: aload 4
    //   492: ldc_w 993
    //   495: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: pop
    //   499: aload 4
    //   501: aload_2
    //   502: invokevirtual 482	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: ldc 36
    //   508: iconst_1
    //   509: aload 4
    //   511: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: invokestatic 477	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   517: aload_3
    //   518: astore_2
    //   519: aload_2
    //   520: areturn
    //   521: astore_3
    //   522: aload 4
    //   524: ifnull +50 -> 574
    //   527: aload 4
    //   529: invokevirtual 709	java/io/FileInputStream:close	()V
    //   532: goto +42 -> 574
    //   535: astore 4
    //   537: new 230	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   544: astore 5
    //   546: aload 5
    //   548: ldc_w 990
    //   551: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: aload 5
    //   557: aload 4
    //   559: invokevirtual 482	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   562: pop
    //   563: ldc 36
    //   565: iconst_1
    //   566: aload 5
    //   568: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: invokestatic 477	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   574: aload_2
    //   575: ifnull +47 -> 622
    //   578: aload_2
    //   579: invokevirtual 991	java/io/FileOutputStream:close	()V
    //   582: goto +40 -> 622
    //   585: astore_2
    //   586: new 230	java/lang/StringBuilder
    //   589: dup
    //   590: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   593: astore 4
    //   595: aload 4
    //   597: ldc_w 993
    //   600: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: pop
    //   604: aload 4
    //   606: aload_2
    //   607: invokevirtual 482	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: ldc 36
    //   613: iconst_1
    //   614: aload 4
    //   616: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   619: invokestatic 477	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   622: aload_3
    //   623: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	624	0	this	ad
    //   0	624	1	paramInt	int
    //   10	212	2	localObject1	Object
    //   237	22	2	localThrowable1	Throwable
    //   275	1	2	localObject2	Object
    //   288	49	2	localThrowable2	Throwable
    //   341	133	2	localObject3	Object
    //   480	22	2	localThrowable3	Throwable
    //   518	61	2	localObject4	Object
    //   585	22	2	localThrowable4	Throwable
    //   35	119	3	localObject5	Object
    //   163	1	3	localObject6	Object
    //   175	151	3	localObject7	Object
    //   332	1	3	localObject8	Object
    //   349	1	3	localObject9	Object
    //   362	156	3	localObject10	Object
    //   521	102	3	localObject11	Object
    //   25	398	4	localObject12	Object
    //   430	23	4	localThrowable5	Throwable
    //   488	40	4	localStringBuilder1	StringBuilder
    //   535	23	4	localThrowable6	Throwable
    //   593	22	4	localStringBuilder2	StringBuilder
    //   28	137	5	localObject13	Object
    //   171	1	5	localThrowable7	Throwable
    //   222	45	5	localObject14	Object
    //   327	1	5	localThrowable8	Throwable
    //   334	6	5	localObject15	Object
    //   345	21	5	localThrowable9	Throwable
    //   372	29	5	localThrowable10	Throwable
    //   439	128	5	localStringBuilder3	StringBuilder
    //   31	379	6	localStringBuilder4	StringBuilder
    //   21	75	7	localObject16	Object
    // Exception table:
    //   from	to	target	type
    //   142	151	163	finally
    //   142	151	171	java/lang/Throwable
    //   229	234	237	java/lang/Throwable
    //   281	286	288	java/lang/Throwable
    //   214	218	327	java/lang/Throwable
    //   195	214	332	finally
    //   214	218	332	finally
    //   195	214	345	java/lang/Throwable
    //   36	44	362	finally
    //   47	53	362	finally
    //   56	65	362	finally
    //   68	77	362	finally
    //   80	89	362	finally
    //   92	103	362	finally
    //   106	113	362	finally
    //   116	120	362	finally
    //   123	130	362	finally
    //   133	142	362	finally
    //   186	195	362	finally
    //   36	44	372	java/lang/Throwable
    //   47	53	372	java/lang/Throwable
    //   56	65	372	java/lang/Throwable
    //   68	77	372	java/lang/Throwable
    //   80	89	372	java/lang/Throwable
    //   92	103	372	java/lang/Throwable
    //   106	113	372	java/lang/Throwable
    //   116	120	372	java/lang/Throwable
    //   123	130	372	java/lang/Throwable
    //   133	142	372	java/lang/Throwable
    //   186	195	372	java/lang/Throwable
    //   422	427	430	java/lang/Throwable
    //   473	477	480	java/lang/Throwable
    //   380	417	521	finally
    //   527	532	535	java/lang/Throwable
    //   578	582	585	java/lang/Throwable
  }
  
  private static void f(String paramString)
  {
    if (E()) {
      as = paramString;
    }
  }
  
  private int g(ToServiceMsg paramToServiceMsg)
  {
    Object localObject3;
    long l1;
    if (paramToServiceMsg.isNeedCallback())
    {
      this.d.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), paramToServiceMsg);
      paramToServiceMsg.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(am.incrementAndGet()));
      Object localObject1;
      if (paramToServiceMsg.getTimeout() == -1L)
      {
        paramToServiceMsg.setTimeout(30000L);
        localObject1 = this.D.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
      }
      else
      {
        localObject1 = this.D.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
      }
      if (("LongConn.OffPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Sender PicUpMsg timer start, appSeq: ");
        ((StringBuilder)localObject3).append(paramToServiceMsg.getAppSeq());
        ((StringBuilder)localObject3).append(", delayMillis: ");
        ((StringBuilder)localObject3).append(paramToServiceMsg.getTimeout());
        QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject3).toString());
      }
      paramToServiceMsg.addAttribute("to_timeoutCallbacker", localObject1);
      if (com.tencent.mobileqq.msf.core.a.a.x())
      {
        l1 = paramToServiceMsg.getTimeout() - com.tencent.mobileqq.msf.core.a.a.A();
        if (l1 > 0L) {
          paramToServiceMsg.addAttribute("to_predetect_timeoutCallbacker", this.D.msfAlarmer.b(paramToServiceMsg, l1));
        }
      }
      if ((com.tencent.mobileqq.msf.core.a.a.aa()) && (this.D.quicksender != null) && (this.D.quicksender.d(paramToServiceMsg)))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("add quick send timeout check ");
        ((StringBuilder)localObject1).append(paramToServiceMsg.getRequestSsoSeq());
        QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject1).toString());
        if ((this.b.b()) && (this.b.l() != null) && (this.b.l().b() != null)) {
          paramToServiceMsg.getAttributes().put("connIDC", this.b.l().b().i);
        }
        this.D.quicksender.e(paramToServiceMsg);
        try
        {
          this.D.quicksender.f.a(paramToServiceMsg);
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
    }
    else if (paramToServiceMsg.getServiceCmd().equals("SSO.LoginMerge"))
    {
      this.D.msfAlarmer.a(paramToServiceMsg.getRequestSsoSeq(), 30000L);
    }
    Object localObject2;
    if (!this.g.offer(paramToServiceMsg))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("error, add ");
      ((StringBuilder)localObject2).append(paramToServiceMsg);
      ((StringBuilder)localObject2).append(" to send queue is full! size: ");
      ((StringBuilder)localObject2).append(this.g.size());
      QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject2).toString());
      if (!paramToServiceMsg.getServiceCmd().equals("SSO.LoginMerge"))
      {
        localObject2 = o.a(paramToServiceMsg);
        ((FromServiceMsg)localObject2).setBusinessFail(1008, "send queue is full!");
        this.D.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject2);
      }
      else
      {
        localObject2 = (ArrayList)this.f.remove(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
        if (localObject2 != null)
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (ToServiceMsg)((Iterator)localObject2).next();
            FromServiceMsg localFromServiceMsg = o.a((ToServiceMsg)localObject3);
            localFromServiceMsg.setBusinessFail(1008, "send queue is full!");
            this.D.addRespToQuque((ToServiceMsg)localObject3, localFromServiceMsg);
          }
        }
      }
    }
    else
    {
      this.aA += 1L;
      this.f.remove(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("add ");
        ((StringBuilder)localObject2).append(paramToServiceMsg);
        ((StringBuilder)localObject2).append(" to sendQueue(");
        ((StringBuilder)localObject2).append(this.g.size());
        ((StringBuilder)localObject2).append(")");
        QLog.d("MSF.C.NetConnTag", 4, ((StringBuilder)localObject2).toString());
      }
      l1 = SystemClock.elapsedRealtime();
      if (l1 - this.ax >= 300000L)
      {
        this.ax = l1;
        if (QLog.isColorLevel()) {
          C();
        }
      }
    }
    if ((!W.get()) && (com.tencent.qphone.base.util.log.a.b.g))
    {
      W.set(true);
      V = paramToServiceMsg.getRequestSsoSeq();
    }
    return paramToServiceMsg.getRequestSsoSeq();
  }
  
  private void h(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg.getUin().equals("0")) {
      return;
    }
    int i2 = 0;
    int i1 = i2;
    if (!this.X.contains(paramToServiceMsg.getUin()))
    {
      this.aF += 1L;
      if (this.aF >= 2L)
      {
        i1 = i2;
        if (this.aG.nextInt(20) >= 2) {}
      }
      else
      {
        i1 = 1;
      }
    }
    if (i1 != 0) {
      a(paramToServiceMsg.getAppId(), paramToServiceMsg.getUin());
    }
  }
  
  public static void j()
  {
    Iterator localIterator = af.iterator();
    while (localIterator.hasNext()) {
      CodecWarpper.nativeSetUseSimpleHead((String)localIterator.next(), false);
    }
    af.clear();
  }
  
  public static int p()
  {
    return ar;
  }
  
  public static String q()
  {
    return as;
  }
  
  private void x()
  {
    QLog.d("libboot_MSF.C.NetConnTag", 1, "[initQimei] obtain qimei.");
    UserAction.getQimei(new ae(this));
  }
  
  private void y()
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
  
  private void z()
  {
    if (MsfSdkUtils.isBuildTestEnvValid())
    {
      d locald = d.a("socket://183.3.233.202:14000");
      if ((locald.c() != null) && (locald.f() > 0))
      {
        this.b.a("socket://183.3.233.202:14000");
        aC = 62;
        QLog.d("MSF.C.NetConnTag", 1, "set buildTestServer Address socket://183.3.233.202:14000");
        return;
      }
      QLog.i("MSF.C.NetConnTag", 1, "testServerAddress ip or port error");
    }
  }
  
  public int a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg.getRequestSsoSeq() == -1) {
      paramToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
    }
    paramToServiceMsg.addAttribute("__timestamp_addSendQueue", Long.valueOf(System.currentTimeMillis()));
    if (paramToServiceMsg.isNeedCallback())
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("add ");
        ((StringBuilder)localObject).append(paramToServiceMsg);
        ((StringBuilder)localObject).append(" to send");
        QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)localObject).toString());
      }
      this.d.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), paramToServiceMsg);
      paramToServiceMsg.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(am.incrementAndGet()));
      if (paramToServiceMsg.getTimeout() == -1L)
      {
        paramToServiceMsg.setTimeout(30000L);
        localObject = this.D.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
      }
      else
      {
        localObject = this.D.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
      }
      paramToServiceMsg.addAttribute("to_timeoutCallbacker", localObject);
    }
    try
    {
      this.g.addFirst(paramToServiceMsg);
      this.aA += 1L;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("inset heartbeatMsg error. ");
      localStringBuilder.append(localException);
      QLog.d("MSF.C.NetConnTag", 1, localStringBuilder.toString(), localException);
    }
    return paramToServiceMsg.getRequestSsoSeq();
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
    Object localObject1 = new UniPacket(true);
    ((UniPacket)localObject1).setRequestId(MsfCore.getNextSeq());
    ((UniPacket)localObject1).setServantName("KQQ.ConfigService.ConfigServantObj");
    ((UniPacket)localObject1).setFuncName("ClientReq");
    Object localObject2 = new c();
    ((c)localObject2).a = paramInt;
    ((c)localObject2).b = paramString;
    ((c)localObject2).d = f(18);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getInfoMachine = ");
      localStringBuilder.append(((c)localObject2).d);
      localStringBuilder.append(" file_path = ");
      localStringBuilder.append(aL);
      QLog.d("MSF.C.NetConnTag", 2, localStringBuilder.toString());
    }
    ((UniPacket)localObject1).put("req", localObject2);
    localObject2 = new ToServiceMsg("", paramString, "GrayUinPro.Check");
    ((ToServiceMsg)localObject2).setAppId(paramInt);
    ((ToServiceMsg)localObject2).setRequestSsoSeq(MsfCore.getNextSeq());
    ((ToServiceMsg)localObject2).putWupBuffer(((UniPacket)localObject1).encode());
    ((ToServiceMsg)localObject2).setTimeout(30000L);
    ((ToServiceMsg)localObject2).setMsfCommand(MsfCommand.checkRole);
    b((ToServiceMsg)localObject2);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("role send gray check for ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" use ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" to:");
      ((StringBuilder)localObject1).append(localObject2);
      QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(com.tencent.qphone.base.a parama)
  {
    this.b.a(parama);
  }
  
  public void a(FromServiceMsg paramFromServiceMsg)
  {
    Object localObject1;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      this.X.add(paramFromServiceMsg.getUin());
      try
      {
        Object localObject2 = paramFromServiceMsg.getWupBuffer();
        localObject1 = localObject2;
        if (localObject2.length > 4)
        {
          localObject1 = localObject2;
          if (localObject2[0] == 0)
          {
            localObject1 = localObject2;
            if (localObject2[1] == 0)
            {
              localObject1 = localObject2;
              if (localObject2[2] == 0)
              {
                localObject1 = localObject2;
                if (localObject2[3] == 4)
                {
                  localObject1 = new byte[localObject2.length - 4];
                  System.arraycopy(localObject2, 4, localObject1, 0, localObject1.length);
                }
              }
            }
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("recv buf:");
        ((StringBuilder)localObject2).append(HexUtil.bytes2HexStr((byte[])localObject1));
        QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject2).toString());
        localObject2 = new UniPacket();
        ((UniPacket)localObject2).decode((byte[])localObject1);
        localObject1 = (com.tencent.msf.service.protocol.e.d)((UniPacket)localObject2).getByClass("res", new com.tencent.msf.service.protocol.e.d());
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("role received gray resp uin:");
          ((StringBuilder)localObject2).append(paramFromServiceMsg.getUin());
          ((StringBuilder)localObject2).append(" appid:");
          ((StringBuilder)localObject2).append(paramFromServiceMsg.getAppId());
          ((StringBuilder)localObject2).append(" status:");
          ((StringBuilder)localObject2).append(((com.tencent.msf.service.protocol.e.d)localObject1).a);
          ((StringBuilder)localObject2).append(" yyb:");
          ((StringBuilder)localObject2).append(((com.tencent.msf.service.protocol.e.d)localObject1).b);
          ((StringBuilder)localObject2).append(" msg:");
          ((StringBuilder)localObject2).append(HexUtil.bytes2HexStr(((com.tencent.msf.service.protocol.e.d)localObject1).c));
          QLog.d("MSF.C.NetConnTag", 4, ((StringBuilder)localObject2).toString());
        }
        if (((com.tencent.msf.service.protocol.e.d)localObject1).a == 1)
        {
          this.D.getSsoRespHandler();
          ag.a.put(paramFromServiceMsg.getUin(), localObject1);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(Thread.currentThread().getName());
          ((StringBuilder)localObject1).append(" onRecvCheckRoleResp setAccountNoLogin uin=");
          ((StringBuilder)localObject1).append(MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()));
          QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject1).toString());
          this.D.getAccountCenter().k(paramFromServiceMsg.getUin());
          return;
        }
        ag.a.remove(paramFromServiceMsg.getUin());
        return;
      }
      catch (ObjectCreateException paramFromServiceMsg)
      {
        if (!QLog.isDevelopLevel()) {
          return;
        }
      }
      QLog.d("MSF.C.NetConnTag", 4, "role gray check error", paramFromServiceMsg);
    }
    else if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("role gray check fail ");
      ((StringBuilder)localObject1).append(paramFromServiceMsg);
      QLog.d("MSF.C.NetConnTag", 4, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    if (paramFromServiceMsg.getBusinessFailCode() == 1002)
    {
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleHeartbeat wait ");
        paramFromServiceMsg.append(paramToServiceMsg);
        paramFromServiceMsg.append(" timeout.");
        QLog.d("MSF.C.NetConnTag", 2, paramFromServiceMsg.toString());
      }
      if (!this.b.b())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "conn is also closed.");
        }
        B();
        return;
      }
      if (this.R >= com.tencent.mobileqq.msf.core.a.a.I())
      {
        try
        {
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("Heartbeat continueTimeoutCount is ");
            paramFromServiceMsg.append(this.R);
            paramFromServiceMsg.append(",closeConn closeByNetDetectFailed");
            QLog.d("MSF.C.NetConnTag", 2, paramFromServiceMsg.toString());
          }
          this.D.sender.b.a(com.tencent.qphone.base.a.p);
          B();
          return;
        }
        catch (Exception paramFromServiceMsg)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
        QLog.d("MSF.C.NetConnTag", 2, paramFromServiceMsg.toString(), paramFromServiceMsg);
      }
      else
      {
        long l1 = System.currentTimeMillis();
        if (l1 - this.S > com.tencent.mobileqq.msf.core.a.a.I() * com.tencent.mobileqq.msf.core.a.a.A())
        {
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("timenow - firstSendHeartBeatTime is ");
            paramFromServiceMsg.append(l1 - this.S);
            paramFromServiceMsg.append(",closeConn continueWaitRspTimeout");
            QLog.d("MSF.C.NetConnTag", 2, paramFromServiceMsg.toString());
          }
          this.D.sender.b.a(com.tencent.qphone.base.a.e);
          B();
          return;
        }
        A();
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "recv heart resp.now conn is alive.");
      }
      B();
    }
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
    if (QLog.isColorLevel())
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("add waitReportData ");
      paramHashMap.append(this.ag.size());
      QLog.d("MSF.C.NetConnTag", 2, paramHashMap.toString());
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.aE = paramArrayOfByte;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    if (!this.b.c(paramInt))
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("onRecvSsoResp: dump, connId: ");
        paramArrayOfByte.append(paramInt);
        QLog.d("MSF.C.NetConnTag", 2, paramArrayOfByte.toString());
      }
      return;
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 4) && (paramArrayOfByte.length <= 50))
    {
      if (this.C.onSSOPingResponse(paramArrayOfByte, paramInt) > 0) {
        this.C.nativeOnReceData(paramArrayOfByte, paramInt);
      }
    }
    else {
      this.C.nativeOnReceData(paramArrayOfByte, paramInt);
    }
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
    catch (Throwable localThrowable)
    {
      QLog.d("MSF.C.NetConnTag", 1, "init socketAdaptorfactory failed", localThrowable);
    }
    QLog.d("MSF.C.NetConnTag", 1, new Object[] { "isReleaseSupportSwitchToTestEnv = ", Boolean.valueOf(false), ", isPublicVersion = ", Boolean.valueOf(true) });
    try
    {
      z();
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setBuildTestServerIfNeed error ");
        localStringBuilder.append(localException);
        QLog.d("MSF.C.NetConnTag", 2, localStringBuilder.toString());
      }
    }
    y();
    try
    {
      this.C.init(paramContext, false);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      com.tencent.mobileqq.msf.core.d.j.a("codecwrapperV2", CodecWarpper.isLoaded, CodecWarpper.soLoadResultCode, localUnsatisfiedLinkError.getMessage());
    }
    CodecWarpper.nativeSetKsid(this.D.getAccountCenter().f());
    this.K.start();
    com.tencent.qphone.base.util.log.a.b.a(paramContext, true);
    return true;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return false;
    }
    if (paramToServiceMsg.getMsfCommand() == MsfCommand.msf_ssoping)
    {
      this.D.sender.b.l().h();
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append(Thread.currentThread().getName());
        paramToServiceMsg.append(" onFoundTimeoutMsg closeConn closeBySSOPingTimeout");
        QLog.d("MSF.C.NetConnTag", 2, paramToServiceMsg.toString());
      }
      this.D.sender.b.a(com.tencent.qphone.base.a.B);
      return false;
    }
    if (paramToServiceMsg.getMsfCommand() == MsfCommand.msf_oshello)
    {
      QLog.d("MSF.C.NetConnTag", 1, "cannot get os hello response");
      return false;
    }
    int i2;
    long l1;
    long l2;
    label203:
    int i1;
    label233:
    boolean bool1;
    label264:
    StringBuilder localStringBuilder2;
    try
    {
      i2 = NetConnInfoCenter.getActiveNetworkType();
      l3 = this.b.l().e();
      boolean bool2 = this.b.b();
      if (!paramToServiceMsg.getAttributes().containsKey("_attr_req_send_time")) {
        break label2046;
      }
      l1 = ((Long)paramToServiceMsg.getAttribute("_attr_req_send_time")).longValue();
      if (!paramToServiceMsg.getAttributes().containsKey("_attr_req_socket_conn_time")) {
        break label2052;
      }
      l2 = ((Long)paramToServiceMsg.getAttribute("_attr_req_socket_conn_time")).longValue();
      if (!paramToServiceMsg.getAttributes().containsKey("_attr_req_netstate")) {
        break label2058;
      }
      i1 = ((Integer)paramToServiceMsg.getAttribute("_attr_req_netstate")).intValue();
      if (!paramToServiceMsg.getAttributes().containsKey("_attr_req_isconn")) {
        break label2063;
      }
      bool1 = ((Boolean)paramToServiceMsg.getAttribute("_attr_req_isconn")).booleanValue();
      if (this.D.statReporter != null)
      {
        HashMap localHashMap = new HashMap();
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("");
        localStringBuilder2.append(l1);
        localHashMap.put("_attr_req_send_time", localStringBuilder2.toString());
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("");
        localStringBuilder2.append(l2);
        localHashMap.put("_attr_req_socket_conn_time", localStringBuilder2.toString());
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("");
        localStringBuilder2.append(i1);
        localHashMap.put("_attr_req_netstate", localStringBuilder2.toString());
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("");
        localStringBuilder2.append(bool1);
        localHashMap.put("_attr_req_isconn", localStringBuilder2.toString());
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("");
        localStringBuilder2.append(i2);
        localHashMap.put("_attr_timeout_netstate", localStringBuilder2.toString());
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("");
        localStringBuilder2.append(bool2);
        localHashMap.put("_attr_timeout_isconn", localStringBuilder2.toString());
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("");
        localStringBuilder2.append(l3);
        localHashMap.put("_attr_timeout_socket_conn_time", localStringBuilder2.toString());
        this.D.statReporter.a("actReqTimeoutReport", false, 0L, 0L, localHashMap, false, false);
      }
    }
    catch (Exception localException1)
    {
      QLog.e("MSF.C.NetConnTag", 1, "report 1002 failed", localException1);
    }
    if ((paramToServiceMsg != null) && (paramToServiceMsg.isNeedRemindSlowNetwork())) {
      k.a(k.b.a);
    }
    paramToServiceMsg.addAttribute("_tag_socket_connerror", n.p);
    paramFromServiceMsg.addAttribute("_tag_socket_connerror", n.p);
    if (paramToServiceMsg.getAttributes().containsKey("_tag_socket")) {
      paramFromServiceMsg.addAttribute("_tag_socket", paramToServiceMsg.getAttribute("_tag_socket"));
    }
    if ((s) && (f.a())) {
      try
      {
        this.I.b().a(paramToServiceMsg.getRequestSsoSeq(), true);
      }
      catch (Exception localException2)
      {
        QLog.d("MSF.C.NetConnTag", 1, "adaptor recv timeout failed", localException2);
      }
    }
    if (paramToServiceMsg.getAttributes().containsKey("__timestamp_msf2net")) {
      l1 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
    } else {
      l1 = 0L;
    }
    long l3 = System.currentTimeMillis();
    if (paramToServiceMsg.getAttributes().containsKey("__timestamp_addSendQueue")) {
      l2 = ((Long)paramToServiceMsg.getAttribute("__timestamp_addSendQueue")).longValue();
    } else {
      l2 = 0L;
    }
    try
    {
      if ((paramToServiceMsg.getServiceCmd().equals("MessageSvc.PbGetMsg")) && (this.D.statReporter != null)) {
        this.D.statReporter.a("dim_Msf_PushSendFail", false, 0L, 0L, null, false, false);
      }
    }
    catch (Exception localException3)
    {
      QLog.d("MSF.C.NetConnTag", 1, "", localException3);
    }
    StringBuilder localStringBuilder1;
    try
    {
      if (paramToServiceMsg.getServiceCmd() == com.tencent.mobileqq.msf.core.push.e.k)
      {
        long l4 = ((Long)paramToServiceMsg.getAttribute("_attr_alarm_elapsed_time", Long.valueOf(0L))).longValue();
        if ((com.tencent.mobileqq.msf.core.a.a.v) && (l4 > com.tencent.mobileqq.msf.core.a.a.bn()) && (l2 >= this.b.l().e()))
        {
          String str = paramToServiceMsg.getUin();
          if (str != null) {
            if ((com.tencent.mobileqq.msf.core.a.a.w) && (Long.parseLong(str) % 2L != 0L))
            {
              this.D.pushManager.F = SystemClock.elapsedRealtime();
              QLog.d("MSF.C.NetConnTag", 1, "wakeup alarm exceeded and detect timeout, but not close conn");
            }
            else
            {
              localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("try close conn by wakeup alarm exceeded and detect timeout:");
              localStringBuilder2.append(l4);
              QLog.d("MSF.C.NetConnTag", 1, localStringBuilder2.toString());
              this.D.sender.b.a(com.tencent.qphone.base.a.E);
              if (this.D.getStatReporter() != null) {
                this.D.getStatReporter().a("3", str, true, 0L);
              }
              return false;
            }
          }
        }
      }
    }
    catch (Exception localException4)
    {
      QLog.d("MSF.C.NetConnTag", 1, "SimpleGet timeout error!", localException4);
      if (l2 != 0L)
      {
        l3 -= l2;
        if ((l3 > paramToServiceMsg.getTimeout()) && (l3 > this.D.pushManager.e()) && (paramToServiceMsg.getTimeout() < this.D.pushManager.e()))
        {
          if (l2 >= this.b.l().e())
          {
            if (QLog.isColorLevel())
            {
              paramFromServiceMsg = new StringBuilder();
              paramFromServiceMsg.append("xiaomi 2s: ");
              paramFromServiceMsg.append(paramToServiceMsg.getRequestSsoSeq());
              paramFromServiceMsg.append(" msg timeout , addtoqueueTime is ");
              paramFromServiceMsg.append(l3);
              paramFromServiceMsg.append(",try close conn");
              QLog.d("MSF.C.NetConnTag", 2, paramFromServiceMsg.toString());
            }
            this.D.sender.b.a(com.tencent.qphone.base.a.q);
            B();
            return true;
          }
          return true;
        }
      }
      if ((l1 != 0L) && (l1 <= this.b.l().e()))
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("found timeout msg ");
        localStringBuilder1.append(paramToServiceMsg);
        localStringBuilder1.append(" before connSucc.");
        QLog.d("MSF.C.NetConnTag", 1, localStringBuilder1.toString());
      }
      else
      {
        if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_HeartbeatAlive)
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("found timeout heartalive msg ");
          localStringBuilder1.append(paramToServiceMsg.getRequestSsoSeq());
          QLog.d("MSF.C.NetConnTag", 1, localStringBuilder1.toString());
          a(paramFromServiceMsg, paramToServiceMsg);
          return false;
        }
        if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_QuickHeartBeat)
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("found timeout quickheartbeat msg ");
          localStringBuilder1.append(paramToServiceMsg.getRequestSsoSeq());
          QLog.d("MSF.C.NetConnTag", 1, localStringBuilder1.toString());
          this.D.quicksender.a(paramToServiceMsg, paramFromServiceMsg, false);
          return false;
        }
      }
    }
    for (;;)
    {
      try
      {
        if ((this.Q.get()) && (System.currentTimeMillis() - this.S < com.tencent.mobileqq.msf.core.a.a.O() + 120000))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("sendingHeartBeat: ");
            localStringBuilder1.append(this.Q);
            localStringBuilder1.append("net detect has started, no need sendHeartbeat");
            QLog.d("MSF.C.NetConnTag", 2, localStringBuilder1.toString());
          }
        }
        else
        {
          l1 = System.currentTimeMillis();
          if (l1 - this.S > com.tencent.mobileqq.msf.core.a.a.O())
          {
            if (paramToServiceMsg.getRequestSsoSeq() == V)
            {
              V = -1;
              paramFromServiceMsg = new StringBuilder();
              paramFromServiceMsg.append("found first msg screen on timeout try close conn ");
              paramFromServiceMsg.append(paramToServiceMsg);
              QLog.d("MSF.C.NetConnTag", 1, paramFromServiceMsg.toString());
              this.D.sender.b.a(com.tencent.qphone.base.a.t);
              B();
              return true;
            }
            if (com.tencent.mobileqq.msf.core.a.a.bo()) {
              A();
            }
          }
          else
          {
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("found timeout msg check time: timenow = ");
            localStringBuilder1.append(l1);
            localStringBuilder1.append(" firstSendHeartBeatTime = ");
            localStringBuilder1.append(this.S);
            localStringBuilder1.append(" ConfigManager.getHeartBeatTimeInterval() = ");
            localStringBuilder1.append(com.tencent.mobileqq.msf.core.a.a.O());
            QLog.d("MSF.C.NetConnTag", 1, localStringBuilder1.toString());
          }
        }
        if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_HeartbeatAlive) {
          return false;
        }
        if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_QuickHeartBeat)
        {
          this.D.quicksender.a(paramToServiceMsg, paramFromServiceMsg, true);
          return false;
        }
        try
        {
          if (this.b.b())
          {
            paramFromServiceMsg = at;
            i2 = paramFromServiceMsg.length;
            i1 = 0;
            if (i1 >= i2) {
              break label2076;
            }
            localStringBuilder1 = paramFromServiceMsg[i1];
            if ((TextUtils.isEmpty(localStringBuilder1)) || (paramToServiceMsg == null) || (!localStringBuilder1.equals(paramToServiceMsg.getServiceCmd()))) {
              break label2069;
            }
            i1 = 0;
            if (i1 != 0)
            {
              if (!B.contains(paramToServiceMsg.getServiceCmd())) {
                B.add(paramToServiceMsg.getServiceCmd());
              }
              if (A.incrementAndGet() >= com.tencent.mobileqq.msf.core.a.a.J()) {
                if (B.size() > 2)
                {
                  QLog.d("MSF.C.NetConnTag", 1, "Continue wait resp for bus packets ,try close conn");
                  A.set(0);
                  B.clear();
                  this.D.sender.b.a(com.tencent.qphone.base.a.e);
                  B();
                }
                else
                {
                  if (QLog.isColorLevel()) {
                    paramToServiceMsg = (String)B.get(0);
                  } else {
                    paramToServiceMsg = com.tencent.mobileqq.msf.core.b.a.a((String)B.get(0));
                  }
                  paramFromServiceMsg = new StringBuilder();
                  paramFromServiceMsg.append("Continue wait resp timeout by single cmd:");
                  paramFromServiceMsg.append(paramToServiceMsg);
                  QLog.d("MSF.C.NetConnTag", 1, paramFromServiceMsg.toString());
                  A.set(0);
                  B.clear();
                  paramToServiceMsg = new HashMap();
                  paramToServiceMsg.put("event_cmd", B.get(0));
                  if (this.D.getStatReporter() != null) {
                    this.D.getStatReporter().a("dim.Msf.SingleCmdTimeout", false, 0L, 0L, paramToServiceMsg, false, false);
                  }
                }
              }
            }
          }
          return true;
        }
        catch (Exception paramToServiceMsg)
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append(" Continue wait resp for bus packets ,try close conn failed: ");
          paramFromServiceMsg.append(paramToServiceMsg);
          QLog.d("MSF.C.NetConnTag", 1, paramFromServiceMsg.toString());
          return true;
        }
        throw paramToServiceMsg;
      }
      finally {}
      for (;;) {}
      label2046:
      l1 = 0L;
      break;
      label2052:
      l2 = 0L;
      break label203;
      label2058:
      i1 = 0;
      break label233;
      label2063:
      bool1 = false;
      break label264;
      label2069:
      i1 += 1;
      continue;
      label2076:
      i1 = 1;
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
      ??? = o.a(paramToServiceMsg);
      ((FromServiceMsg)???).setBusinessFail(2009, "MSF is suspeded.");
      this.D.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
      return paramToServiceMsg.getRequestSsoSeq();
    }
    if ((paramToServiceMsg.getWupBuffer() != null) && (paramToServiceMsg.getWupBuffer().length > 103424))
    {
      ??? = o.a(paramToServiceMsg);
      ((FromServiceMsg)???).setBusinessFail(2019, "check the wupbuf size in range[0, 101kb]");
      this.D.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
      return paramToServiceMsg.getRequestSsoSeq();
    }
    int i1;
    if (this.D.configManager.K != null)
    {
      localObject3 = this.D.configManager.K.iterator();
      ??? = null;
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (a.a)((Iterator)localObject3).next();
        if (((a.a)localObject2).a + ((a.a)localObject2).b.b < System.currentTimeMillis() / 1000L)
        {
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("OverloadPushNotify item expired sCmd = ");
            ((StringBuilder)???).append(((a.a)localObject2).c);
            QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)???).toString());
          }
          this.D.configManager.K.remove(localObject2);
          ??? = localObject2;
        }
        else
        {
          String str = paramToServiceMsg.getServiceCmd();
          if (((a.a)localObject2).c.charAt(((a.a)localObject2).c.length() - 1) == '*')
          {
            ??? = localObject2;
            if (!str.startsWith(((a.a)localObject2).c.substring(0, ((a.a)localObject2).c.length() - 1))) {
              continue;
            }
            if (QLog.isColorLevel())
            {
              ??? = new StringBuilder();
              ((StringBuilder)???).append("OverloadPushNotify item matched strServiceCmd = ");
              ((StringBuilder)???).append(str);
              ((StringBuilder)???).append(" sCmd:");
              ((StringBuilder)???).append(((a.a)localObject2).c);
              QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)???).toString());
            }
          }
          else
          {
            ??? = localObject2;
            if (!((a.a)localObject2).c.equals(str)) {
              continue;
            }
            if (QLog.isColorLevel())
            {
              ??? = new StringBuilder();
              ((StringBuilder)???).append("OverloadPushNotify item matched strServiceCmd = ");
              ((StringBuilder)???).append(str);
              ((StringBuilder)???).append(" sCmd:");
              ((StringBuilder)???).append(((a.a)localObject2).c);
              QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)???).toString());
            }
          }
          i1 = 1;
          ??? = localObject2;
          break label445;
        }
      }
      i1 = 0;
      label445:
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
        localObject2 = o.a(paramToServiceMsg);
        ((FromServiceMsg)localObject2).setBusinessFail(((a.a)???).b.c, new String(((a.a)???).b.d));
        this.D.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject2);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("OverloadPushNotify server overload block tomsg: ");
          ((StringBuilder)???).append(paramToServiceMsg);
          ((StringBuilder)???).append(" frommsg: ");
          ((StringBuilder)???).append(localObject2);
          QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)???).toString());
        }
        return paramToServiceMsg.getRequestSsoSeq();
      }
    }
    if ((paramToServiceMsg.getAppId() <= 0) && (paramToServiceMsg.getMsfCommand() != MsfCommand.openConn) && ((TextUtils.isEmpty(paramToServiceMsg.getServiceCmd())) || (!paramToServiceMsg.getServiceCmd().startsWith("wtlogin."))))
    {
      ??? = o.a(paramToServiceMsg);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("msg appid is ");
      ((StringBuilder)localObject2).append(paramToServiceMsg.getAppId());
      ((FromServiceMsg)???).setBusinessFail(1007, ((StringBuilder)localObject2).toString());
      this.D.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
      return paramToServiceMsg.getRequestSsoSeq();
    }
    if (aQ.get())
    {
      ??? = o.a(paramToServiceMsg);
      ((FromServiceMsg)???).setBusinessFail(2014, "error");
      this.D.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
      return paramToServiceMsg.getRequestSsoSeq();
    }
    Object localObject2 = (com.tencent.msf.service.protocol.e.d)ag.a.get(paramToServiceMsg.getUin());
    ??? = localObject2;
    if (localObject2 != null)
    {
      ??? = localObject2;
      if (paramToServiceMsg.getServiceCmd().equals("wtlogin.login"))
      {
        this.X.remove(paramToServiceMsg.getUin());
        ag.a.remove(paramToServiceMsg.getUin());
        ??? = null;
      }
    }
    if ((??? != null) && (!paramToServiceMsg.getServiceCmd().startsWith("login.")) && (!paramToServiceMsg.getServiceCmd().startsWith("wtlogin.login")) && (!paramToServiceMsg.getServiceCmd().equals("GrayUinPro.Check")))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("error, ");
        ((StringBuilder)localObject2).append(paramToServiceMsg.getUin());
        ((StringBuilder)localObject2).append(" not in gray list");
        QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = o.a(paramToServiceMsg);
    }
    try
    {
      ((FromServiceMsg)localObject2).setBusinessFail(2008, new String(((com.tencent.msf.service.protocol.e.d)???).c, "UTF-8"));
    }
    catch (Exception localException)
    {
      label1001:
      break label1001;
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramToServiceMsg.getUin());
    ((StringBuilder)localObject3).append(" not in gray list");
    ((FromServiceMsg)localObject2).setBusinessFail(2008, ((StringBuilder)localObject3).toString());
    ((FromServiceMsg)localObject2).addAttribute(((FromServiceMsg)localObject2).getServiceCmd(), String.valueOf(((com.tencent.msf.service.protocol.e.d)???).b));
    this.D.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject2);
    if (this.D.getAccountCenter().g(((FromServiceMsg)localObject2).getUin()))
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append(Thread.currentThread().getName());
      ((StringBuilder)???).append(" addSendQueue setAccountNoLogin uin=");
      ((StringBuilder)???).append(MsfSdkUtils.getShortUin(((FromServiceMsg)localObject2).getUin()));
      QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)???).toString());
      this.D.getAccountCenter().k(((FromServiceMsg)localObject2).getUin());
    }
    return paramToServiceMsg.getRequestSsoSeq();
    if ((this.D.standbyModeManager != null) && (this.D.standbyModeManager.b()))
    {
      if (!this.D.standbyModeManager.a(paramToServiceMsg.getServiceCmd()))
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("refuse to send request cmd: ");
        ((StringBuilder)???).append(paramToServiceMsg.getServiceCmd());
        ((StringBuilder)???).append(" ssoseq: ");
        ((StringBuilder)???).append(paramToServiceMsg.getRequestSsoSeq());
        ((StringBuilder)???).append(" by standbyMode");
        QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)???).toString());
        this.D.getStandyModeManager().a(paramToServiceMsg);
        ??? = o.a(paramToServiceMsg);
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
    }
    else if ((paramToServiceMsg.getUin().equals("0")) && (!paramToServiceMsg.getAttributes().containsKey("__base_tag_isAppMsg")) && (!paramToServiceMsg.getServiceCmd().equals("PhSigLcId.Check")))
    {
      paramToServiceMsg.setUin(l());
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
      if ((??? != null) && (this.au.size() != ???.length)) {
        a((String[])???);
      } else if (??? == null) {
        a(null);
      }
    }
    if ((this.r) && (SystemClock.elapsedRealtime() - this.p < this.n))
    {
      if (this.au.size() == 0) {
        a(null);
      }
      if ((!this.au.contains(paramToServiceMsg.getServiceCmd())) && ((TextUtils.isEmpty(paramToServiceMsg.getServiceCmd())) || (!paramToServiceMsg.getServiceCmd().startsWith("wtlogin."))) && ((!"ConfigurationService.ReqGetConfig".equals(paramToServiceMsg.getServiceCmd())) || (!((Boolean)paramToServiceMsg.getAttribute("_attr_disable_merge", Boolean.valueOf(false))).booleanValue())))
      {
        this.L = SystemClock.elapsedRealtime();
        this.h.add(paramToServiceMsg);
        i1 = paramToServiceMsg.getWupBuffer().length;
        synchronized (this.aw)
        {
          this.l += i1;
          if (!this.av)
          {
            this.al.postDelayed(this.i, this.m);
            this.av = true;
          }
          ??? = paramToServiceMsg.getServiceCmd();
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("add ");
            ((StringBuilder)localObject2).append(paramToServiceMsg.getRequestSsoSeq());
            ((StringBuilder)localObject2).append(" cmd: ");
            ((StringBuilder)localObject2).append((String)???);
            ((StringBuilder)localObject2).append(" uin: ");
            ((StringBuilder)localObject2).append(paramToServiceMsg.getUin());
            ((StringBuilder)localObject2).append(" len: ");
            ((StringBuilder)localObject2).append(paramToServiceMsg.getWupBuffer().length);
            ((StringBuilder)localObject2).append(" msg to SSO.LoginMerge delayWaitSendList");
            QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)localObject2).toString());
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("add ");
            ((StringBuilder)localObject2).append(paramToServiceMsg.getRequestSsoSeq());
            ((StringBuilder)localObject2).append(" cmd:");
            ((StringBuilder)localObject2).append(com.tencent.mobileqq.msf.core.b.a.a((String)???));
            ((StringBuilder)localObject2).append(" uin: ");
            ((StringBuilder)localObject2).append(MsfSdkUtils.getShortUin(paramToServiceMsg.getUin()));
            ((StringBuilder)localObject2).append(" len: ");
            ((StringBuilder)localObject2).append(paramToServiceMsg.getWupBuffer().length);
            ((StringBuilder)localObject2).append(" msg to ");
            ((StringBuilder)localObject2).append(com.tencent.mobileqq.msf.core.b.a.a("SSO.LoginMerge"));
            ((StringBuilder)localObject2).append(" delayWaitSendList");
            QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject2).toString());
          }
          return paramToServiceMsg.getRequestSsoSeq();
        }
      }
      return g(paramToServiceMsg);
    }
    return g(paramToServiceMsg);
  }
  
  public long b()
  {
    return this.aA;
  }
  
  public void b(int paramInt)
  {
    try
    {
      if ((this.b.b()) && (this.b.l() != null) && (this.b.l().i() == paramInt))
      {
        b(true);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = this.ak;
    if ((localObject != null) && (((ToServiceMsg)localObject).getAttributes().containsKey("_attr_regprxy_socket_hashcode")) && (this.ak.getAttributes().containsKey("_attr_regprxy_random_code")))
    {
      int i1 = this.b.l().i();
      if ((this.b.b()) && (i1 != 0))
      {
        if (i1 == ((Integer)this.ak.getAttributes().get("_attr_regprxy_socket_hashcode")).intValue())
        {
          paramFromServiceMsg.getAttributes().put("_attr_regprxy_random_code", this.ak.getAttributes().get("_attr_regprxy_random_code"));
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("not tag regprxysvc resp seq:");
        ((StringBuilder)localObject).append(paramFromServiceMsg.getRequestSsoSeq());
        ((StringBuilder)localObject).append(" by socket changed");
        QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject).toString());
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("not tag regprxysvc resp seq:");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getRequestSsoSeq());
      ((StringBuilder)localObject).append(" by disconn, sockethashcode = ");
      ((StringBuilder)localObject).append(i1);
      QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject).toString());
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("not tag regprxysvc resp seq:");
    ((StringBuilder)localObject).append(paramFromServiceMsg.getRequestSsoSeq());
    ((StringBuilder)localObject).append(" by infoLogin error");
    QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject).toString());
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
    Runnable localRunnable;
    if (paramToServiceMsg.getTimeout() == -1L)
    {
      paramToServiceMsg.setTimeout(30000L);
      localRunnable = this.D.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
    }
    else
    {
      localRunnable = this.D.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
    }
    paramToServiceMsg.addAttribute("to_timeoutCallbacker", localRunnable);
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
    return this.aE;
  }
  
  public byte[] e(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null) {}
    for (;;)
    {
      byte b2;
      try
      {
        Object localObject2 = paramToServiceMsg.getServiceCmd();
        i1 = ((String)localObject2).indexOf("#");
        Object localObject1 = localObject2;
        if (i1 != -1) {
          localObject1 = ((String)localObject2).substring(0, i1);
        }
        if (paramToServiceMsg.getWupBuffer() != null)
        {
          byte b1 = com.tencent.mobileqq.msf.core.net.j.b();
          i1 = (byte)NetConnInfoCenter.getActiveNetIpFamily(false);
          if (!P) {
            break label335;
          }
          i1 |= 0x4;
          break label328;
          if (this.b.l().b() == null) {
            break label345;
          }
          i1 = this.b.l().b().d();
          localObject2 = b(paramToServiceMsg, i1);
          byte[] arrayOfByte1 = c(paramToServiceMsg, i1);
          j();
          byte[] arrayOfByte2 = e();
          byte[] arrayOfByte3 = paramToServiceMsg.getWupBuffer();
          if (591 == CodecWarpper.getSharedObjectVersion()) {
            return CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), o.d(), o.f(), o.g(), "", (String)localObject1, arrayOfByte2, paramToServiceMsg.getAppId(), this.D.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, arrayOfByte3, false);
          }
          if ((595 != CodecWarpper.getSharedObjectVersion()) && (600 != CodecWarpper.getSharedObjectVersion())) {
            return CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), o.d(), o.f(), o.g(), "", (String)localObject1, arrayOfByte2, paramToServiceMsg.getAppId(), this.D.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, b2, (byte[])localObject2, arrayOfByte1, arrayOfByte3, false);
          }
          return CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), o.d(), o.f(), o.g(), "", (String)localObject1, arrayOfByte2, paramToServiceMsg.getAppId(), this.D.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, (byte[])localObject2, arrayOfByte1, arrayOfByte3, false);
        }
        return new byte[0];
      }
      catch (Throwable paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        QLog.d("MSF.C.NetConnTag", 1, "encode packet failed", paramToServiceMsg);
        return new byte[0];
      }
      return null;
      for (;;)
      {
        label328:
        b2 = (byte)i1;
        break;
        label335:
        i1 &= 0xFFFFFFFB;
      }
      label345:
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
    if (paramToServiceMsg == null) {
      return;
    }
    if (paramToServiceMsg.getMsfCommand() != MsfCommand.msf_ssoping)
    {
      if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_HeartbeatAlive) {
        return;
      }
      long l1;
      if (paramToServiceMsg.getAttributes().containsKey("__timestamp_msf2net")) {
        l1 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
      } else {
        l1 = 0L;
      }
      if ((l1 != 0L) && (l1 <= this.b.l().e()))
      {
        QLog.d("MSF.C.NetConnTag", 1, "preDetectTimeoutMsg return before connSucc.");
        return;
      }
      synchronized (this.Q)
      {
        if ((!this.Q.get()) || (System.currentTimeMillis() - this.S >= com.tencent.mobileqq.msf.core.a.a.O() + 120000))
        {
          l1 = System.currentTimeMillis();
          Object localObject;
          if (QLog.isColorLevel()) {
            localObject = paramToServiceMsg.getServiceCmd();
          } else {
            localObject = com.tencent.mobileqq.msf.core.b.a.a(paramToServiceMsg.getServiceCmd());
          }
          StringBuilder localStringBuilder;
          if (l1 - this.S > com.tencent.mobileqq.msf.core.a.a.P())
          {
            A();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("preDetectTimeoutMsg cmd:");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append(", ssoSeq:");
            localStringBuilder.append(paramToServiceMsg.getRequestSsoSeq());
            QLog.d("MSF.C.NetConnTag", 1, localStringBuilder.toString());
            if (this.D.statReporter != null)
            {
              localObject = new HashMap();
              ((HashMap)localObject).put("param_preDetectUin", paramToServiceMsg.getUin());
              ((HashMap)localObject).put("param_preDetectCmd", paramToServiceMsg.getServiceCmd());
              ((HashMap)localObject).put("param_preDetectSsoseq", String.valueOf(paramToServiceMsg.getRequestSsoSeq()));
              this.D.statReporter.a("dim.Msf.PreDetectTimeoutMsg", true, 0L, 0L, (Map)localObject, false, false);
            }
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("notry preDetectTimeoutMsg cmd:");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append(", ssoSeq:");
            localStringBuilder.append(paramToServiceMsg.getRequestSsoSeq());
            QLog.d("MSF.C.NetConnTag", 1, localStringBuilder.toString());
          }
        }
        return;
      }
    }
  }
  
  public void g()
  {
    b(false);
  }
  
  public void h()
  {
    this.aO = true;
    this.aP.set(false);
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "onAppForeground");
    }
  }
  
  public void i()
  {
    this.aO = false;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "onAppBackground");
    }
  }
  
  public void k()
  {
    this.C.nativeClearReceData();
  }
  
  public String l()
  {
    return this.aq;
  }
  
  public int m()
  {
    return this.ap;
  }
  
  public void n()
  {
    try
    {
      if (this.ah)
      {
        Object localObject = this.ag.iterator();
        while (((Iterator)localObject).hasNext())
        {
          HashMap localHashMap = (HashMap)((Iterator)localObject).next();
          try
          {
            this.D.configManager.a(localHashMap, "");
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("report waitReportData succ ");
          ((StringBuilder)localObject).append(this.ag.size());
          QLog.d("MSF.C.NetConnTag", 2, ((StringBuilder)localObject).toString());
        }
        this.ag.clear();
        this.ah = false;
        return;
      }
    }
    catch (Exception localException1)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("report waitReportData error ");
        localStringBuilder.append(localException1);
        QLog.d("MSF.C.NetConnTag", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void o()
  {
    Iterator localIterator = this.d.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      if (localObject1 != null)
      {
        localObject1 = (ToServiceMsg)((Map.Entry)localObject1).getValue();
        if ((localObject1 != null) && (!this.g.contains(localObject1)))
        {
          boolean bool = ((ToServiceMsg)localObject1).isFastResendEnabled();
          int i2 = 1;
          int i1;
          Object localObject2;
          if (bool)
          {
            i1 = i2;
          }
          else
          {
            if (((ToServiceMsg)localObject1).isSupportRetry())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("send reteyMsg :");
              ((StringBuilder)localObject2).append(((ToServiceMsg)localObject1).getStringForLog());
              QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject2).toString());
              this.g.offer(localObject1);
            }
            else
            {
              localObject2 = BaseConstants.CMD_NeedResendCmds;
              int i3 = localObject2.length;
              i1 = 0;
              while (i1 < i3)
              {
                Object localObject3 = localObject2[i1];
                if (((ToServiceMsg)localObject1).getServiceCmd().equals(localObject3))
                {
                  i1 = i2;
                  break label199;
                }
                i1 += 1;
              }
            }
            i1 = 0;
          }
          label199:
          if (i1 != 0)
          {
            localObject2 = MsfSdkUtils.constructResponse((ToServiceMsg)localObject1, 2901, "", null);
            ((FromServiceMsg)localObject2).setBusinessFail(2901);
            if ((localObject1 != null) && (this.D.quicksender != null) && (this.D.quicksender.d((ToServiceMsg)localObject1))) {
              this.D.quicksender.a((ToServiceMsg)localObject1, (FromServiceMsg)localObject2, -1);
            }
            this.D.addRespToQuque((ToServiceMsg)localObject1, (FromServiceMsg)localObject2);
            localIterator.remove();
          }
        }
      }
    }
  }
  
  public void r()
  {
    n localn = this.b;
    if ((localn != null) && (localn.l() != null)) {
      this.b.l().g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ad
 * JD-Core Version:    0.7.0.1
 */