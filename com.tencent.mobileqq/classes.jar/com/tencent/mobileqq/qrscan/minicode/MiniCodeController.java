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
  private static long jdField_a_of_type_Long;
  public static volatile MiniCodeController a;
  private static boolean d;
  private static boolean e;
  private static boolean f;
  private static boolean g;
  private int jdField_a_of_type_Int = -1;
  private MiniCodeDetector jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniCodeDetector;
  private Set<Long> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  private CopyOnWriteArrayList<WeakReference<OnMiniCodeDetectCallback>> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private volatile boolean jdField_a_of_type_Boolean;
  private CopyOnWriteArrayList<WeakReference<OnMiniCodeInitCallback>> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private volatile boolean jdField_b_of_type_Boolean;
  private volatile boolean c;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  
  private MiniCodeController()
  {
    boolean bool = MiniCodeUtil.a();
    if (bool)
    {
      this.j = false;
      this.i = false;
      QLog.i("MiniRecog.MiniCodeController", 1, String.format("init return [%b %b]", new Object[] { Boolean.valueOf(false), Boolean.valueOf(bool) }));
    }
    if ((!g) || (MiniCodeUtil.a(false) > 0))
    {
      g = true;
      ThreadManager.post(new MiniCodeController.2(this), 5, null, true);
    }
  }
  
  public static int a(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!e) {
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
    if (jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniCodeController == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniCodeController == null) {
          jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniCodeController = new MiniCodeController();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniCodeController;
  }
  
  private void a()
  {
    if (d)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        OnMiniCodeInitCallback localOnMiniCodeInitCallback = (OnMiniCodeInitCallback)((WeakReference)localIterator.next()).get();
        if (localOnMiniCodeInitCallback != null) {
          localOnMiniCodeInitCallback.b();
        }
      }
    }
  }
  
  public static boolean a()
  {
    return d;
  }
  
  public static boolean a(String paramString)
  {
    return (paramString != null) && (paramString.length() > 0) && (!paramString.equals("____JAVA_EXCEPTION____")) && (!paramString.equals("____NATIVE_ERROR____")) && (!paramString.equals("____NATIVE_EXCEPTION____")) && (!paramString.startsWith("____NATIVE_ERROR____")) && (!paramString.startsWith("____NATIVE_EXCEPTION____"));
  }
  
  private void b()
  {
    long l;
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
      l = SystemClock.uptimeMillis();
      if ((this.i) && (!d))
      {
        bool1 = MiniScanDecodeSoLoader.a();
        if (bool1) {
          try
          {
            if (MiniScanDecodeSoLoader.b("minicode") != 0) {
              break label706;
            }
            bool1 = true;
            d = bool1;
          }
          catch (Throwable localThrowable1)
          {
            QLog.i("MiniRecog.MiniCodeController", 1, "loadSoAndModel decode error", localThrowable1);
          }
        }
      }
      if (this.jdField_a_of_type_Int < 0) {
        break label712;
      }
      bool2 = true;
      if ((!this.j) || (!bool2)) {
        break label724;
      }
      if (!e) {
        break label718;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniCodeDetector != null) {
        break label724;
      }
    }
    finally {}
    if (bool3)
    {
      localObject4 = MiniScanDetectSoLoader.c("QMCF_qr");
      localObject5 = MiniScanDetectModelLoader.b();
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
        if ((this.j) && (bool2) && (!e) && (bool4))
        {
          bool1 = MiniScanDetectSoLoader.a();
          if (bool1) {
            try
            {
              int k = MiniScanDetectSoLoader.b("QMCF_qr");
              int m = MiniScanDetectSoLoader.b("yuvutil");
              if ((k != 0) || (m != 0)) {
                break label758;
              }
              bool1 = true;
              label270:
              e = bool1;
            }
            catch (Throwable localThrowable2)
            {
              QLog.i("MiniRecog.MiniCodeController", 1, "loadSoAndModel detect error", localThrowable2);
            }
          }
        }
        if ((this.j) && (bool2) && (e) && (bool4) && (this.jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniCodeDetector == null))
        {
          bool1 = MiniScanDetectModelLoader.a();
          if (bool1) {
            try
            {
              if (jdField_a_of_type_Long == 0L) {
                jdField_a_of_type_Long = SystemClock.uptimeMillis();
              } else {
                jdField_a_of_type_Long = 0L;
              }
              this.jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniCodeDetector = new MiniCodeDetector(null, this.jdField_a_of_type_Int, 0, 0);
              this.jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniCodeDetector.a(this);
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
              this.jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniCodeDetector.a((String)localObject2, (String)localObject4, (String)localObject5, str);
            }
            catch (Throwable localThrowable3)
            {
              QLog.i("MiniRecog.MiniCodeController", 1, "loadSoAndModel detect model error", localThrowable3);
              break label770;
            }
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniCodeDetector == null) {
          break label770;
        }
        break label764;
      }
    }
    for (;;)
    {
      QLog.i("MiniRecog.MiniCodeController", 1, String.format("loadSoAndModel...... bDecodeInited=%b bDetectInited=%b bSupportDetect=%b mDecodeDpcSwitch=%b mDetectDpcSwitch=%b bModelInited=%b iDetectRuntype=%d bNeedCheckMatch=%b cost=%d(ms)", new Object[] { Boolean.valueOf(d), Boolean.valueOf(e), Boolean.valueOf(bool2), Boolean.valueOf(this.i), Boolean.valueOf(this.j), Boolean.valueOf(bool1), Integer.valueOf(this.jdField_a_of_type_Int), Boolean.valueOf(bool3), Long.valueOf(SystemClock.uptimeMillis() - l) }));
      a();
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
  
  public static boolean b()
  {
    return e;
  }
  
  private void c()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("requestDownloadResourceIfNeed");
      boolean bool = d;
      int k = 0;
      if ((!bool) && (!this.jdField_a_of_type_Boolean)) {
        if (MiniScanDecodeSoLoader.a())
        {
          this.jdField_a_of_type_Boolean = true;
          localStringBuilder.append(" decode 0");
        }
        else
        {
          QRScanResHelper.a().a(0);
          localStringBuilder.append(" decode 1");
        }
      }
      if (this.jdField_a_of_type_Int >= 0) {
        k = 1;
      }
      if ((this.j) && (k != 0) && (!e) && (!this.jdField_b_of_type_Boolean)) {
        if (MiniScanDetectSoLoader.a())
        {
          this.jdField_b_of_type_Boolean = true;
          localStringBuilder.append(" detect 0");
        }
        else
        {
          QRScanResHelper.a().a(1);
          localStringBuilder.append(" detect 1");
        }
      }
      if ((this.j) && (k != 0) && (this.jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniCodeDetector == null) && (!this.c)) {
        if (MiniScanDetectModelLoader.a())
        {
          this.c = true;
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
  
  public String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramArrayOfByte, paramInt1, paramInt2, 0, 0, 0, 0, paramInt3);
  }
  
  public String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (!d) {
      return "";
    }
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniCodeController", 2, String.format("decode [w,h,barX,barY,barW,barH]=[%d,%d,%d,%d,%d,%d] mode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7) }));
    }
    try
    {
      if (!f)
      {
        String str = DecodeProxy.getVersion();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("call nativeDecode version = ");
        localStringBuilder.append(str);
        QLog.i("MiniRecog.MiniCodeController", 1, localStringBuilder.toString());
        if (QLog.isColorLevel()) {
          DecodeProxy.setLogSwitch(true);
        }
        f = true;
      }
      paramArrayOfByte = DecodeProxy.nativeDecode(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      QLog.i("MiniRecog.MiniCodeController", 2, "call nativeDecode error", paramArrayOfByte);
    }
    return "____JAVA_EXCEPTION____";
  }
  
  public void a(int paramInt)
  {
    this.h = true;
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniCodeController", 2, "onDetectReady");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      OnMiniCodeDetectCallback localOnMiniCodeDetectCallback = (OnMiniCodeDetectCallback)((WeakReference)localIterator.next()).get();
      if (localOnMiniCodeDetectCallback != null) {
        localOnMiniCodeDetectCallback.a(paramInt);
      }
    }
    long l;
    if (jdField_a_of_type_Long > 0L)
    {
      l = SystemClock.uptimeMillis() - jdField_a_of_type_Long;
      jdField_a_of_type_Long = 0L;
    }
    else
    {
      l = 0L;
    }
    ThreadManager.post(new MiniCodeController.1(this, paramInt, l), 5, null, true);
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
            this.c = true;
          }
        }
        else {
          this.jdField_b_of_type_Boolean = true;
        }
      }
      else {
        this.jdField_a_of_type_Boolean = true;
      }
      b();
    }
  }
  
  public void a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
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
    if (this.jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(paramLong))) {
      this.jdField_a_of_type_JavaUtilSet.remove(Long.valueOf(paramLong));
    }
    boolean bool = this.jdField_a_of_type_JavaUtilSet.isEmpty();
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniCodeController", 2, String.format("onDestroy busiHash=%d desc=%s bDoDestroy=%b", new Object[] { Long.valueOf(paramLong), paramString, Boolean.valueOf(bool) }));
    }
    if (bool) {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniCodeDetector != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniCodeDetector.a();
          this.jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniCodeDetector = null;
        }
        QRScanResHelper.a().b(this);
        QRScanResHelper.a().b(this);
        jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniCodeController = null;
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
      if (!this.i)
      {
        bool = this.j;
        if (!bool) {
          return;
        }
      }
      boolean bool = this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(paramLong));
      if (bool) {
        QLog.i("MiniRecog.MiniCodeController", 1, String.format("init busiHash=%d desc=%s", new Object[] { Long.valueOf(paramLong), paramString }));
      }
      if (!bool) {
        return;
      }
      QRScanResHelper.a().a(this);
      QRScanResHelper.a().a(this);
      b();
      c();
      return;
    }
    finally {}
  }
  
  public void a(OnMiniCodeDetectCallback paramOnMiniCodeDetectCallback)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      OnMiniCodeDetectCallback localOnMiniCodeDetectCallback = (OnMiniCodeDetectCallback)((WeakReference)localIterator.next()).get();
      if ((localOnMiniCodeDetectCallback != null) && (localOnMiniCodeDetectCallback == paramOnMiniCodeDetectCallback)) {
        return;
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(new WeakReference(paramOnMiniCodeDetectCallback));
  }
  
  public void a(OnMiniCodeInitCallback paramOnMiniCodeInitCallback)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      OnMiniCodeInitCallback localOnMiniCodeInitCallback = (OnMiniCodeInitCallback)((WeakReference)localIterator.next()).get();
      if ((localOnMiniCodeInitCallback != null) && (localOnMiniCodeInitCallback == paramOnMiniCodeInitCallback)) {
        return;
      }
    }
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(new WeakReference(paramOnMiniCodeInitCallback));
  }
  
  public void a(List<AIRect> paramList, long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
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
    MiniCodeDetector localMiniCodeDetector = this.jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniCodeDetector;
    if ((e) && (this.h))
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
    //   1: getfield 146	com/tencent/mobileqq/qrscan/minicode/MiniCodeController:jdField_a_of_type_ComTencentMobileqqQrscanMinicodeMiniCodeDetector	Lcom/tencent/mobileqq/qrscan/minicode/MiniCodeDetector;
    //   4: astore 12
    //   6: getstatic 125	com/tencent/mobileqq/qrscan/minicode/MiniCodeController:e	Z
    //   9: ifeq +315 -> 324
    //   12: aload 12
    //   14: ifnull +310 -> 324
    //   17: aload_2
    //   18: ifnonnull +6 -> 24
    //   21: goto +303 -> 324
    //   24: new 4	java/lang/Object
    //   27: dup
    //   28: invokespecial 34	java/lang/Object:<init>	()V
    //   31: astore 10
    //   33: aload_0
    //   34: getfield 36	com/tencent/mobileqq/qrscan/minicode/MiniCodeController:h	Z
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
    //   65: invokestatic 425	java/lang/System:currentTimeMillis	()J
    //   68: lstore 6
    //   70: new 427	com/tencent/mobileqq/qrscan/minicode/MiniCodeController$3
    //   73: dup
    //   74: aload_0
    //   75: lload 6
    //   77: aload_2
    //   78: aload 10
    //   80: aload 12
    //   82: aload 11
    //   84: aload_1
    //   85: invokespecial 430	com/tencent/mobileqq/qrscan/minicode/MiniCodeController$3:<init>	(Lcom/tencent/mobileqq/qrscan/minicode/MiniCodeController;JLjava/util/ArrayList;Ljava/lang/Object;Lcom/tencent/mobileqq/qrscan/minicode/MiniCodeDetector;[ZLandroid/graphics/Bitmap;)V
    //   88: astore_2
    //   89: iload 5
    //   91: ifeq +20 -> 111
    //   94: aload 12
    //   96: aload_1
    //   97: lload 6
    //   99: invokevirtual 415	com/tencent/mobileqq/qrscan/minicode/MiniCodeDetector:a	(Landroid/graphics/Bitmap;J)Z
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
    //   149: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq +53 -> 205
    //   155: ldc 84
    //   157: iconst_2
    //   158: ldc_w 432
    //   161: iconst_4
    //   162: anewarray 4	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: iload 4
    //   169: invokestatic 92	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   172: aastore
    //   173: dup
    //   174: iconst_1
    //   175: iload 5
    //   177: invokestatic 92	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   180: aastore
    //   181: dup
    //   182: iconst_2
    //   183: aload 11
    //   185: iconst_0
    //   186: baload
    //   187: invokestatic 92	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   190: aastore
    //   191: dup
    //   192: iconst_3
    //   193: lload 6
    //   195: invokestatic 298	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   198: aastore
    //   199: invokestatic 98	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   202: invokestatic 103	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: iload 4
    //   207: ifeq +64 -> 271
    //   210: aload 12
    //   212: aload_2
    //   213: invokevirtual 245	com/tencent/mobileqq/qrscan/minicode/MiniCodeDetector:a	(Lcom/tencent/mobileqq/qrscan/OnMiniCodeDetectCallback;)V
    //   216: aload 10
    //   218: monitorenter
    //   219: iload_3
    //   220: i2l
    //   221: lstore 8
    //   223: aload 10
    //   225: lload 8
    //   227: invokevirtual 435	java/lang/Object:wait	(J)V
    //   230: goto +24 -> 254
    //   233: astore_1
    //   234: goto +32 -> 266
    //   237: astore_1
    //   238: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq +13 -> 254
    //   244: ldc 84
    //   246: iconst_2
    //   247: ldc_w 437
    //   250: aload_1
    //   251: invokestatic 139	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   254: aload 10
    //   256: monitorexit
    //   257: aload 12
    //   259: aload_2
    //   260: invokevirtual 439	com/tencent/mobileqq/qrscan/minicode/MiniCodeDetector:b	(Lcom/tencent/mobileqq/qrscan/OnMiniCodeDetectCallback;)V
    //   263: goto +8 -> 271
    //   266: aload 10
    //   268: monitorexit
    //   269: aload_1
    //   270: athrow
    //   271: iload 4
    //   273: ifeq +46 -> 319
    //   276: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   279: ifeq +40 -> 319
    //   282: new 247	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   289: astore_1
    //   290: aload_1
    //   291: ldc_w 441
    //   294: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload_1
    //   299: invokestatic 425	java/lang/System:currentTimeMillis	()J
    //   302: lload 6
    //   304: lsub
    //   305: invokevirtual 444	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: ldc 84
    //   311: iconst_2
    //   312: aload_1
    //   313: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 103	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   47	173	3	k	int
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
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      OnMiniCodeDetectCallback localOnMiniCodeDetectCallback = (OnMiniCodeDetectCallback)localWeakReference.get();
      if ((localOnMiniCodeDetectCallback != null) && (localOnMiniCodeDetectCallback == paramOnMiniCodeDetectCallback)) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localWeakReference);
      }
    }
  }
  
  public void b(OnMiniCodeInitCallback paramOnMiniCodeInitCallback)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      OnMiniCodeInitCallback localOnMiniCodeInitCallback = (OnMiniCodeInitCallback)localWeakReference.get();
      if ((localOnMiniCodeInitCallback != null) && (localOnMiniCodeInitCallback == paramOnMiniCodeInitCallback)) {
        this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localWeakReference);
      }
    }
  }
  
  public boolean c()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.minicode.MiniCodeController
 * JD-Core Version:    0.7.0.1
 */