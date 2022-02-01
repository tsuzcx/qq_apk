package com.tencent.mobileqq.qrscan.minicode;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.minicode.DecodeProxy;
import com.tencent.mobileqq.minicode.YuvProxy;
import com.tencent.mobileqq.qrscan.AIRect;
import com.tencent.mobileqq.qrscan.IQRScanIPCConst.IMiniResDownloadCallback;
import com.tencent.mobileqq.qrscan.OnMiniCodeDetectCallback;
import com.tencent.mobileqq.qrscan.OnMiniCodeInitCallback;
import com.tencent.mobileqq.qrscan.earlydown.MiniScanDecodeSoLoader;
import com.tencent.mobileqq.qrscan.earlydown.MiniScanDetectModelLoader;
import com.tencent.mobileqq.qrscan.earlydown.MiniScanDetectSoLoader;
import com.tencent.mobileqq.qrscan.ipc.QRScanResHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class MiniCodeController
  implements IQRScanIPCConst.IMiniResDownloadCallback, OnMiniCodeDetectCallback
{
  public static volatile MiniCodeController a;
  private static boolean i;
  private static boolean j;
  private static boolean k;
  private static boolean l;
  private static long q;
  private MiniCodeDetector b;
  private CopyOnWriteArrayList<WeakReference<OnMiniCodeDetectCallback>> c = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList<WeakReference<OnMiniCodeInitCallback>> d = new CopyOnWriteArrayList();
  private Set<Long> e = Collections.synchronizedSet(new HashSet());
  private volatile boolean f;
  private volatile boolean g;
  private volatile boolean h;
  private boolean m = false;
  private int n = -1;
  private boolean o = false;
  private boolean p = false;
  
  private MiniCodeController()
  {
    boolean bool = MiniCodeUtil.g();
    if (bool)
    {
      this.p = false;
      this.o = false;
      QLog.i("MiniRecog.MiniCodeController", 1, String.format("init return [%b %b]", new Object[] { Boolean.valueOf(false), Boolean.valueOf(bool) }));
    }
    if ((!l) || (MiniCodeUtil.d(false) > 0))
    {
      l = true;
      ThreadManager.post(new MiniCodeController.2(this), 5, null, true);
    }
  }
  
  public static int a(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!j) {
      return -1;
    }
    try
    {
      YuvProxy.Yuv2Rgba(paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2);
      return 0;
    }
    catch (Throwable paramArrayOfInt)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniCodeController", 2, "Yuv2Rgba exception", paramArrayOfInt);
      }
    }
    return -1;
  }
  
  public static MiniCodeController a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new MiniCodeController();
        }
      }
      finally {}
    }
    return a;
  }
  
  public static boolean a(String paramString)
  {
    return (paramString != null) && (paramString.length() > 0) && (!paramString.equals("____JAVA_EXCEPTION____")) && (!paramString.equals("____NATIVE_ERROR____")) && (!paramString.equals("____NATIVE_EXCEPTION____")) && (!paramString.startsWith("____NATIVE_ERROR____")) && (!paramString.startsWith("____NATIVE_EXCEPTION____"));
  }
  
  public static boolean b()
  {
    return i;
  }
  
  public static boolean c()
  {
    return j;
  }
  
  private void e()
  {
    if (i)
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        OnMiniCodeInitCallback localOnMiniCodeInitCallback = (OnMiniCodeInitCallback)((WeakReference)localIterator.next()).get();
        if (localOnMiniCodeInitCallback != null) {
          localOnMiniCodeInitCallback.d();
        }
      }
    }
  }
  
  private void f()
  {
    long l1;
    boolean bool1;
    boolean bool2;
    label76:
    label104:
    boolean bool3;
    Object localObject4;
    Object localObject5;
    label145:
    boolean bool4;
    label171:
    label211:
    try
    {
      l1 = SystemClock.uptimeMillis();
      if ((this.o) && (!i))
      {
        bool1 = MiniScanDecodeSoLoader.b();
        if (bool1) {
          try
          {
            if (MiniScanDecodeSoLoader.e("minicode") != 0) {
              break label706;
            }
            bool1 = true;
            i = bool1;
          }
          catch (Throwable localThrowable1)
          {
            QLog.i("MiniRecog.MiniCodeController", 1, "loadSoAndModel decode error", localThrowable1);
          }
        }
      }
      if (this.n < 0) {
        break label712;
      }
      bool2 = true;
      if ((!this.p) || (!bool2)) {
        break label724;
      }
      if (!j) {
        break label718;
      }
      if (this.b != null) {
        break label724;
      }
    }
    finally {}
    if (bool3)
    {
      localObject4 = MiniScanDetectSoLoader.c("QMCF_qr");
      localObject5 = MiniScanDetectModelLoader.d();
      if ((!TextUtils.isEmpty((CharSequence)localObject5)) && (((String)localObject5).equalsIgnoreCase((String)localObject4)))
      {
        bool1 = true;
        bool4 = bool1;
        if (QLog.isColorLevel())
        {
          Object localObject1 = localObject4;
          if (localObject4 != null) {
            break label736;
          }
          localObject1 = "null";
          break label736;
          QLog.i("MiniRecog.MiniCodeController", 2, String.format("loadSoAndModel checkMatch detectSoMd5=%s modelNeedMd5=%s bMatch=%b", new Object[] { localObject1, localObject4, Boolean.valueOf(bool1) }));
          bool4 = bool1;
        }
        if ((this.p) && (bool2) && (!j) && (bool4))
        {
          bool1 = MiniScanDetectSoLoader.b();
          if (bool1) {
            try
            {
              int i1 = MiniScanDetectSoLoader.e("QMCF_qr");
              int i2 = MiniScanDetectSoLoader.e("yuvutil");
              if ((i1 != 0) || (i2 != 0)) {
                break label758;
              }
              bool1 = true;
              label270:
              j = bool1;
            }
            catch (Throwable localThrowable2)
            {
              QLog.i("MiniRecog.MiniCodeController", 1, "loadSoAndModel detect error", localThrowable2);
            }
          }
        }
        if ((this.p) && (bool2) && (j) && (bool4) && (this.b == null))
        {
          bool1 = MiniScanDetectModelLoader.c();
          if (bool1) {
            try
            {
              if (q == 0L) {
                q = SystemClock.uptimeMillis();
              } else {
                q = 0L;
              }
              this.b = new MiniCodeDetector(null, this.n, 0, 0);
              this.b.a(this);
              Object localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(MiniScanDetectModelLoader.a());
              ((StringBuilder)localObject2).append(File.separator);
              ((StringBuilder)localObject2).append(MiniScanDetectModelLoader.a("qr_detection_model.bin"));
              localObject2 = ((StringBuilder)localObject2).toString();
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append(MiniScanDetectModelLoader.a());
              ((StringBuilder)localObject4).append(File.separator);
              ((StringBuilder)localObject4).append(MiniScanDetectModelLoader.a("qr_detection_model.txt"));
              localObject4 = ((StringBuilder)localObject4).toString();
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append(MiniScanDetectModelLoader.a());
              ((StringBuilder)localObject5).append(File.separator);
              ((StringBuilder)localObject5).append(MiniScanDetectModelLoader.a("qr_anchor.bin"));
              localObject5 = ((StringBuilder)localObject5).toString();
              String str = MiniCodeUtil.b();
              File localFile = new File(str);
              if (!localFile.exists()) {
                localFile.mkdirs();
              }
              this.b.a((String)localObject2, (String)localObject4, (String)localObject5, str);
            }
            catch (Throwable localThrowable3)
            {
              QLog.i("MiniRecog.MiniCodeController", 1, "loadSoAndModel detect model error", localThrowable3);
              break label770;
            }
          }
        }
        if (this.b == null) {
          break label770;
        }
        break label764;
      }
    }
    for (;;)
    {
      QLog.i("MiniRecog.MiniCodeController", 1, String.format("loadSoAndModel...... bDecodeInited=%b bDetectInited=%b bSupportDetect=%b mDecodeDpcSwitch=%b mDetectDpcSwitch=%b bModelInited=%b iDetectRuntype=%d bNeedCheckMatch=%b cost=%d(ms)", new Object[] { Boolean.valueOf(i), Boolean.valueOf(j), Boolean.valueOf(bool2), Boolean.valueOf(this.o), Boolean.valueOf(this.p), Boolean.valueOf(bool1), Integer.valueOf(this.n), Boolean.valueOf(bool3), Long.valueOf(SystemClock.uptimeMillis() - l1) }));
      e();
      return;
      label706:
      bool1 = false;
      break;
      label712:
      bool2 = false;
      break label76;
      label718:
      bool3 = true;
      break label104;
      label724:
      bool3 = false;
      break label104;
      bool1 = false;
      break label145;
      label736:
      localObject4 = localObject5;
      if (localObject5 != null) {
        break label171;
      }
      localObject4 = "null";
      break label171;
      bool4 = false;
      break label211;
      label758:
      bool1 = false;
      break label270;
      label764:
      bool1 = true;
      continue;
      label770:
      bool1 = false;
    }
  }
  
  private void g()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("requestDownloadResourceIfNeed");
      boolean bool = i;
      int i1 = 0;
      if ((!bool) && (!this.f)) {
        if (MiniScanDecodeSoLoader.b())
        {
          this.f = true;
          localStringBuilder.append(" decode 0");
        }
        else
        {
          QRScanResHelper.a().a(0);
          localStringBuilder.append(" decode 1");
        }
      }
      if (this.n >= 0) {
        i1 = 1;
      }
      if ((this.p) && (i1 != 0) && (!j) && (!this.g)) {
        if (MiniScanDetectSoLoader.b())
        {
          this.g = true;
          localStringBuilder.append(" detect 0");
        }
        else
        {
          QRScanResHelper.a().a(1);
          localStringBuilder.append(" detect 1");
        }
      }
      if ((this.p) && (i1 != 0) && (this.b == null) && (!this.h)) {
        if (MiniScanDetectModelLoader.c())
        {
          this.h = true;
          localStringBuilder.append(" model 0");
        }
        else
        {
          QRScanResHelper.a().a(2);
          localStringBuilder.append(" model 1");
        }
      }
      QLog.i("MiniRecog.MiniCodeController", 1, localStringBuilder.toString());
      return;
    }
    finally {}
  }
  
  public String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramArrayOfByte, paramInt1, paramInt2, 0, 0, 0, 0, paramInt3, paramInt4);
  }
  
  public String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (!i) {
      return "";
    }
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniCodeController", 2, String.format("decode [w,h,barX,barY,barW,barH]=[%d,%d,%d,%d,%d,%d] mode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt8) }));
    }
    try
    {
      if (!k)
      {
        str = DecodeProxy.getVersion();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("call nativeDecode version = ");
        localStringBuilder.append(str);
        QLog.i("MiniRecog.MiniCodeController", 1, localStringBuilder.toString());
        if (QLog.isColorLevel()) {
          DecodeProxy.setLogSwitch(true);
        }
        k = true;
      }
      if (paramInt7 == 2) {
        return DecodeProxy.nativeDecode(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt8);
      }
      if (paramInt7 == 3) {
        return DecodeProxy.nativeWxDecode(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt8);
      }
      String str = DecodeProxy.nativeDecode(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt8);
      if (!TextUtils.isEmpty(str))
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("WITHOUTAIQQ&");
        paramArrayOfByte.append(str);
        return paramArrayOfByte.toString();
      }
      str = DecodeProxy.nativeWxDecode(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt8);
      paramArrayOfByte = str;
      if (!TextUtils.isEmpty(str))
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("WITHOUTAIWX&");
        paramArrayOfByte.append(str);
        paramArrayOfByte = paramArrayOfByte.toString();
        return paramArrayOfByte;
      }
    }
    catch (Throwable paramArrayOfByte)
    {
      QLog.i("MiniRecog.MiniCodeController", 2, "call nativeDecode error", paramArrayOfByte);
      paramArrayOfByte = "____JAVA_EXCEPTION____";
    }
    return paramArrayOfByte;
  }
  
  public void a(int paramInt)
  {
    this.m = true;
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniCodeController", 2, "onDetectReady");
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      OnMiniCodeDetectCallback localOnMiniCodeDetectCallback = (OnMiniCodeDetectCallback)((WeakReference)localIterator.next()).get();
      if (localOnMiniCodeDetectCallback != null) {
        localOnMiniCodeDetectCallback.a(paramInt);
      }
    }
    long l1;
    if (q > 0L)
    {
      l1 = SystemClock.uptimeMillis() - q;
      q = 0L;
    }
    else
    {
      l1 = 0L;
    }
    ThreadManager.post(new MiniCodeController.1(this, paramInt, l1), 5, null, true);
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    QLog.i("MiniRecog.MiniCodeController", 1, String.format("onMiniResDownloadResult...... resType=%d suc=%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) }));
    if (paramBoolean)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt == 2) {
            this.h = true;
          }
        }
        else {
          this.g = true;
        }
      }
      else {
        this.f = true;
      }
      f();
    }
  }
  
  public void a(long paramLong)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      OnMiniCodeDetectCallback localOnMiniCodeDetectCallback = (OnMiniCodeDetectCallback)((WeakReference)localIterator.next()).get();
      if (localOnMiniCodeDetectCallback != null) {
        localOnMiniCodeDetectCallback.a(paramLong);
      }
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    if (this.e.contains(Long.valueOf(paramLong))) {
      this.e.remove(Long.valueOf(paramLong));
    }
    boolean bool = this.e.isEmpty();
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniCodeController", 2, String.format("onDestroy busiHash=%d desc=%s bDoDestroy=%b", new Object[] { Long.valueOf(paramLong), paramString, Boolean.valueOf(bool) }));
    }
    if (bool) {
      try
      {
        if (this.b != null)
        {
          this.b.a();
          this.b = null;
        }
        QRScanResHelper.a().b(this);
        QRScanResHelper.a().b(this);
        a = null;
        return;
      }
      finally {}
    }
  }
  
  public void a(Context paramContext, long paramLong, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      if (!this.o)
      {
        bool = this.p;
        if (!bool) {
          return;
        }
      }
      boolean bool = this.e.add(Long.valueOf(paramLong));
      if (bool) {
        QLog.i("MiniRecog.MiniCodeController", 1, String.format("init busiHash=%d desc=%s", new Object[] { Long.valueOf(paramLong), paramString }));
      }
      if (!bool) {
        return;
      }
      QRScanResHelper.a().a(this);
      QRScanResHelper.a().a(this);
      f();
      g();
      return;
    }
    finally {}
  }
  
  public void a(OnMiniCodeDetectCallback paramOnMiniCodeDetectCallback)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      OnMiniCodeDetectCallback localOnMiniCodeDetectCallback = (OnMiniCodeDetectCallback)((WeakReference)localIterator.next()).get();
      if ((localOnMiniCodeDetectCallback != null) && (localOnMiniCodeDetectCallback == paramOnMiniCodeDetectCallback)) {
        return;
      }
    }
    this.c.add(new WeakReference(paramOnMiniCodeDetectCallback));
  }
  
  public void a(OnMiniCodeInitCallback paramOnMiniCodeInitCallback)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      OnMiniCodeInitCallback localOnMiniCodeInitCallback = (OnMiniCodeInitCallback)((WeakReference)localIterator.next()).get();
      if ((localOnMiniCodeInitCallback != null) && (localOnMiniCodeInitCallback == paramOnMiniCodeInitCallback)) {
        return;
      }
    }
    this.d.add(new WeakReference(paramOnMiniCodeInitCallback));
  }
  
  public void a(List<AIRect> paramList, long paramLong)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      OnMiniCodeDetectCallback localOnMiniCodeDetectCallback = (OnMiniCodeDetectCallback)((WeakReference)localIterator.next()).get();
      if (localOnMiniCodeDetectCallback != null) {
        localOnMiniCodeDetectCallback.a(paramList, paramLong);
      }
    }
  }
  
  public boolean a(Bitmap paramBitmap, long paramLong)
  {
    MiniCodeDetector localMiniCodeDetector = this.b;
    if ((j) && (this.m))
    {
      if (localMiniCodeDetector == null) {
        return false;
      }
      boolean bool = localMiniCodeDetector.a(paramBitmap, paramLong);
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniCodeController", 2, String.format("detect async exec=%b ts=%d", new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong) }));
      }
      return bool;
    }
    return false;
  }
  
  /* Error */
  public boolean a(Bitmap paramBitmap, java.util.ArrayList<AIRect> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 170	com/tencent/mobileqq/qrscan/minicode/MiniCodeController:b	Lcom/tencent/mobileqq/qrscan/minicode/MiniCodeDetector;
    //   4: astore 12
    //   6: getstatic 132	com/tencent/mobileqq/qrscan/minicode/MiniCodeController:j	Z
    //   9: ifeq +315 -> 324
    //   12: aload 12
    //   14: ifnull +310 -> 324
    //   17: aload_2
    //   18: ifnonnull +6 -> 24
    //   21: goto +303 -> 324
    //   24: new 4	java/lang/Object
    //   27: dup
    //   28: invokespecial 41	java/lang/Object:<init>	()V
    //   31: astore 10
    //   33: aload_0
    //   34: getfield 43	com/tencent/mobileqq/qrscan/minicode/MiniCodeController:m	Z
    //   37: istore 5
    //   39: iload 5
    //   41: ifeq +10 -> 51
    //   44: sipush 3000
    //   47: istore_3
    //   48: goto +7 -> 55
    //   51: sipush 5000
    //   54: istore_3
    //   55: iconst_1
    //   56: newarray boolean
    //   58: astore 11
    //   60: aload 11
    //   62: iconst_0
    //   63: iconst_0
    //   64: bastore
    //   65: invokestatic 445	java/lang/System:currentTimeMillis	()J
    //   68: lstore 6
    //   70: new 447	com/tencent/mobileqq/qrscan/minicode/MiniCodeController$3
    //   73: dup
    //   74: aload_0
    //   75: lload 6
    //   77: aload_2
    //   78: aload 10
    //   80: aload 12
    //   82: aload 11
    //   84: aload_1
    //   85: invokespecial 450	com/tencent/mobileqq/qrscan/minicode/MiniCodeController$3:<init>	(Lcom/tencent/mobileqq/qrscan/minicode/MiniCodeController;JLjava/util/ArrayList;Ljava/lang/Object;Lcom/tencent/mobileqq/qrscan/minicode/MiniCodeDetector;[ZLandroid/graphics/Bitmap;)V
    //   88: astore_2
    //   89: iload 5
    //   91: ifeq +20 -> 111
    //   94: aload 12
    //   96: aload_1
    //   97: lload 6
    //   99: invokevirtual 435	com/tencent/mobileqq/qrscan/minicode/MiniCodeDetector:a	(Landroid/graphics/Bitmap;J)Z
    //   102: ifeq +9 -> 111
    //   105: iconst_1
    //   106: istore 4
    //   108: goto +6 -> 114
    //   111: iconst_0
    //   112: istore 4
    //   114: aload 11
    //   116: iconst_0
    //   117: iload 4
    //   119: bastore
    //   120: iload 5
    //   122: ifeq +24 -> 146
    //   125: iload 5
    //   127: ifeq +13 -> 140
    //   130: aload 11
    //   132: iconst_0
    //   133: baload
    //   134: ifeq +6 -> 140
    //   137: goto +9 -> 146
    //   140: iconst_0
    //   141: istore 4
    //   143: goto +6 -> 149
    //   146: iconst_1
    //   147: istore 4
    //   149: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq +53 -> 205
    //   155: ldc 91
    //   157: iconst_2
    //   158: ldc_w 452
    //   161: iconst_4
    //   162: anewarray 4	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: iload 4
    //   169: invokestatic 99	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   172: aastore
    //   173: dup
    //   174: iconst_1
    //   175: iload 5
    //   177: invokestatic 99	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   180: aastore
    //   181: dup
    //   182: iconst_2
    //   183: aload 11
    //   185: iconst_0
    //   186: baload
    //   187: invokestatic 99	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   190: aastore
    //   191: dup
    //   192: iconst_3
    //   193: lload 6
    //   195: invokestatic 308	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   198: aastore
    //   199: invokestatic 105	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   202: invokestatic 110	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: iload 4
    //   207: ifeq +64 -> 271
    //   210: aload 12
    //   212: aload_2
    //   213: invokevirtual 254	com/tencent/mobileqq/qrscan/minicode/MiniCodeDetector:a	(Lcom/tencent/mobileqq/qrscan/OnMiniCodeDetectCallback;)V
    //   216: aload 10
    //   218: monitorenter
    //   219: iload_3
    //   220: i2l
    //   221: lstore 8
    //   223: aload 10
    //   225: lload 8
    //   227: invokevirtual 455	java/lang/Object:wait	(J)V
    //   230: goto +24 -> 254
    //   233: astore_1
    //   234: goto +32 -> 266
    //   237: astore_1
    //   238: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq +13 -> 254
    //   244: ldc 91
    //   246: iconst_2
    //   247: ldc_w 457
    //   250: aload_1
    //   251: invokestatic 146	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   254: aload 10
    //   256: monitorexit
    //   257: aload 12
    //   259: aload_2
    //   260: invokevirtual 459	com/tencent/mobileqq/qrscan/minicode/MiniCodeDetector:b	(Lcom/tencent/mobileqq/qrscan/OnMiniCodeDetectCallback;)V
    //   263: goto +8 -> 271
    //   266: aload 10
    //   268: monitorexit
    //   269: aload_1
    //   270: athrow
    //   271: iload 4
    //   273: ifeq +46 -> 319
    //   276: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   279: ifeq +40 -> 319
    //   282: new 256	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   289: astore_1
    //   290: aload_1
    //   291: ldc_w 461
    //   294: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload_1
    //   299: invokestatic 445	java/lang/System:currentTimeMillis	()J
    //   302: lload 6
    //   304: lsub
    //   305: invokevirtual 464	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: ldc 91
    //   311: iconst_2
    //   312: aload_1
    //   313: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 110	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aload 11
    //   321: iconst_0
    //   322: baload
    //   323: ireturn
    //   324: iconst_0
    //   325: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	this	MiniCodeController
    //   0	326	1	paramBitmap	Bitmap
    //   0	326	2	paramArrayList	java.util.ArrayList<AIRect>
    //   47	173	3	i1	int
    //   106	166	4	bool1	boolean
    //   37	139	5	bool2	boolean
    //   68	235	6	l1	long
    //   221	5	8	l2	long
    //   31	236	10	localObject	Object
    //   58	262	11	arrayOfBoolean	boolean[]
    //   4	254	12	localMiniCodeDetector	MiniCodeDetector
    // Exception table:
    //   from	to	target	type
    //   223	230	233	finally
    //   238	254	233	finally
    //   254	257	233	finally
    //   266	269	233	finally
    //   223	230	237	java/lang/InterruptedException
  }
  
  public void b(OnMiniCodeDetectCallback paramOnMiniCodeDetectCallback)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      OnMiniCodeDetectCallback localOnMiniCodeDetectCallback = (OnMiniCodeDetectCallback)localWeakReference.get();
      if ((localOnMiniCodeDetectCallback != null) && (localOnMiniCodeDetectCallback == paramOnMiniCodeDetectCallback)) {
        this.c.remove(localWeakReference);
      }
    }
  }
  
  public void b(OnMiniCodeInitCallback paramOnMiniCodeInitCallback)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      OnMiniCodeInitCallback localOnMiniCodeInitCallback = (OnMiniCodeInitCallback)localWeakReference.get();
      if ((localOnMiniCodeInitCallback != null) && (localOnMiniCodeInitCallback == paramOnMiniCodeInitCallback)) {
        this.d.remove(localWeakReference);
      }
    }
  }
  
  public boolean d()
  {
    return this.m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.minicode.MiniCodeController
 * JD-Core Version:    0.7.0.1
 */