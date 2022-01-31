package dov.com.tencent.mobileqq.activity.richmedia.state;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import aohb;
import aohd;
import aohe;
import aohp;
import aohq;
import aohr;
import aohs;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.maxvideo.mediadevice.AVCodec.AVCodecCallback;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWVideoRecorder;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.CameraPreviewObservable;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import dov.com.tencent.mobileqq.activity.richmedia.view.SVDropFrameMonitor;
import dov.com.tencent.mobileqq.shortvideo.common.GloableValue;
import dov.com.tencent.mobileqq.shortvideo.common.TCTimer;
import dov.com.tencent.mobileqq.shortvideo.common.TCTimer.TCTimerCallback;
import dov.com.tencent.mobileqq.shortvideo.error.ErrorCenter;
import dov.com.tencent.mobileqq.shortvideo.error.ErrorCenter.ErrorHandleCallback;
import dov.com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture.OnAudioRecordListener;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.RecordManager;
import dov.com.tencent.mobileqq.shortvideo.util.AudioDataCache;
import dov.com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import dov.com.tencent.mobileqq.shortvideo.util.storage.StorageManager;
import dov.com.tencent.mobileqq.shortvideo.util.storage.StorageManager.OnSdCardChangedListener;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class RMVideoStateMgr
  implements AVCodec.AVCodecCallback, TCTimer.TCTimerCallback, ErrorCenter.ErrorHandleCallback, AudioCapture.OnAudioRecordListener, StorageManager.OnSdCardChangedListener
{
  private static RMVideoStateMgr jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
  public static boolean a;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 850, 780, 650, 480 };
  public static boolean c;
  public double a;
  public int a;
  public long a;
  public Context a;
  public Handler a;
  public aohb a;
  final aohd jdField_a_of_type_Aohd = new aohd();
  final aohe jdField_a_of_type_Aohe = new aohe();
  private HWVideoRecorder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder;
  public CameraProxy a;
  public RMVideoClipSpec a;
  final RMVideoPreviewState jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoPreviewState = new RMVideoPreviewState();
  final RMVideoRecordState jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoRecordState = new RMVideoRecordState();
  public RMVideoStateMgr.ForceReleaseLockOnPause a;
  public final RMVideoSwitchCameraPicMgr a;
  public final RMVideoThumbGenMgr a;
  public RMViewSTInterface a;
  public AudioCapture.OnAudioRecordListener a;
  public AudioCapture a;
  public PreviewContext a;
  public AudioDataCache a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  public AtomicBoolean a;
  public AtomicInteger a;
  public int b;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  public String b;
  public AtomicInteger b;
  public boolean b;
  private int[] jdField_b_of_type_ArrayOfInt = new int[8];
  private int c;
  private int d;
  public boolean d;
  private int e;
  public boolean e;
  public boolean f = true;
  public boolean g;
  public boolean h;
  public boolean i;
  private boolean j;
  private boolean k;
  private volatile boolean l;
  private boolean m;
  private boolean n;
  private volatile boolean o;
  private boolean p = true;
  
  static
  {
    jdField_c_of_type_Boolean = true;
  }
  
  private RMVideoStateMgr()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr = new RMVideoThumbGenMgr();
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr = new RMVideoSwitchCameraPicMgr();
    this.jdField_c_of_type_Int = 1;
    this.jdField_b_of_type_Int = 480;
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause = new RMVideoStateMgr.ForceReleaseLockOnPause();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoClipSpec = new RMVideoClipSpec();
  }
  
  private int a(int[] paramArrayOfInt)
  {
    int i2 = GloableValue.h.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (paramArrayOfInt[1] == GloableValue.h[i1])
      {
        paramArrayOfInt[0] = GloableValue.g[i1];
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public static RMVideoStateMgr a()
  {
    try
    {
      if (jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr == null) {
        jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr = new RMVideoStateMgr();
      }
      RMVideoStateMgr localRMVideoStateMgr = jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
      return localRMVideoStateMgr;
    }
    finally {}
  }
  
  private static void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.trim().length() == 0)) {}
    for (;;)
    {
      return;
      paramString1 = new File(paramString1);
      paramString2 = new File(paramString2);
      if ((paramString1.exists()) && (paramString2.exists()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("RMVideoStateMgr", 2, "deleteDirectoryByTime rootDir:" + paramString1 + ", currentDirectory:" + paramString2);
        }
        paramString2 = paramString2.getName();
        paramString1 = paramString1.listFiles();
        if ((paramString1 != null) && (paramString1.length > 0) && (!TextUtils.isEmpty(paramString2)))
        {
          int i1 = 0;
          while (i1 < paramString1.length)
          {
            String str = paramString1[i1].getName();
            if ((!TextUtils.isEmpty(str)) && (str.compareTo(paramString2) < 0)) {
              FileUtils.a(paramString1[i1].getAbsolutePath());
            }
            i1 += 1;
          }
        }
      }
    }
  }
  
  /* Error */
  private boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 188	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 190
    //   8: iconst_2
    //   9: ldc 244
    //   11: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_2
    //   15: invokestatic 252	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   18: invokevirtual 256	java/lang/Long:longValue	()J
    //   21: lstore 6
    //   23: lload 6
    //   25: ldc2_w 257
    //   28: lcmp
    //   29: ifne +51 -> 80
    //   32: invokestatic 188	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq +30 -> 65
    //   38: ldc 190
    //   40: iconst_2
    //   41: new 192	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   48: ldc_w 260
    //   51: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: lload 6
    //   56: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   59: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: iconst_0
    //   66: istore 9
    //   68: iload 9
    //   70: ireturn
    //   71: astore_2
    //   72: ldc2_w 257
    //   75: lstore 6
    //   77: goto -54 -> 23
    //   80: iconst_0
    //   81: istore 8
    //   83: invokestatic 267	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()I
    //   86: istore 5
    //   88: lload 6
    //   90: aload_1
    //   91: iload_3
    //   92: iload 4
    //   94: invokestatic 270	dov/com/tencent/mobileqq/shortvideo/common/GloableValue:a	(JLandroid/content/Context;II)Z
    //   97: istore 9
    //   99: iload 9
    //   101: istore 8
    //   103: invokestatic 188	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +41 -> 147
    //   109: ldc 190
    //   111: iconst_2
    //   112: new 192	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 272
    //   122: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: iload 8
    //   127: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   130: ldc_w 277
    //   133: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: iload 5
    //   138: invokevirtual 280	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   141: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: iload 5
    //   149: ifeq +6 -> 155
    //   152: iconst_0
    //   153: istore 8
    //   155: iconst_0
    //   156: istore 9
    //   158: iload 9
    //   160: ifeq +71 -> 231
    //   163: invokestatic 188	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +41 -> 207
    //   169: ldc 190
    //   171: iconst_2
    //   172: new 192	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   179: ldc_w 282
    //   182: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: iload 9
    //   187: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   190: ldc_w 277
    //   193: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: iload 5
    //   198: invokevirtual 280	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   201: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: invokestatic 284	com/tencent/mobileqq/shortvideo/VideoEnvironment:d	()V
    //   210: ldc_w 286
    //   213: aload_1
    //   214: iconst_1
    //   215: invokestatic 289	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;Landroid/content/Context;Z)I
    //   218: istore 5
    //   220: lload 6
    //   222: aload_1
    //   223: iload_3
    //   224: iload 4
    //   226: invokestatic 270	dov/com/tencent/mobileqq/shortvideo/common/GloableValue:a	(JLandroid/content/Context;II)Z
    //   229: istore 8
    //   231: iload 8
    //   233: ifne +6 -> 239
    //   236: invokestatic 291	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	()V
    //   239: iload 8
    //   241: istore 9
    //   243: invokestatic 188	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq -178 -> 68
    //   249: ldc 190
    //   251: iconst_2
    //   252: new 192	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   259: ldc_w 293
    //   262: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: iload 8
    //   267: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   270: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: iload 8
    //   278: ireturn
    //   279: astore_2
    //   280: aload_2
    //   281: invokevirtual 296	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   284: ldc2_w 257
    //   287: putstatic 298	dov/com/tencent/mobileqq/shortvideo/common/GloableValue:jdField_a_of_type_Long	J
    //   290: iconst_1
    //   291: istore 9
    //   293: goto -135 -> 158
    //   296: astore_1
    //   297: aload_1
    //   298: invokevirtual 296	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   301: iconst_0
    //   302: istore 10
    //   304: iload 10
    //   306: istore 8
    //   308: invokestatic 188	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   311: ifeq -80 -> 231
    //   314: ldc 190
    //   316: iconst_2
    //   317: new 192	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 300
    //   327: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: iload 9
    //   332: invokevirtual 275	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   335: ldc_w 277
    //   338: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: iload 5
    //   343: invokevirtual 280	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   346: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 246	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   352: iload 10
    //   354: istore 8
    //   356: goto -125 -> 231
    //   359: astore_2
    //   360: goto -80 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	this	RMVideoStateMgr
    //   0	363	1	paramContext	Context
    //   0	363	2	paramString	String
    //   0	363	3	paramInt1	int
    //   0	363	4	paramInt2	int
    //   86	256	5	i1	int
    //   21	200	6	l1	long
    //   81	274	8	bool1	boolean
    //   66	265	9	bool2	boolean
    //   302	51	10	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   14	23	71	java/lang/NumberFormatException
    //   88	99	279	java/lang/UnsatisfiedLinkError
    //   220	231	296	java/lang/UnsatisfiedLinkError
    //   103	147	359	java/lang/UnsatisfiedLinkError
  }
  
  public static boolean a(boolean paramBoolean)
  {
    return (HwEnvData.a()) || (paramBoolean);
  }
  
  private int b(int[] paramArrayOfInt)
  {
    int i2 = GloableValue.jdField_a_of_type_ArrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if ((paramArrayOfInt[0] == GloableValue.jdField_a_of_type_ArrayOfInt[i1]) && (paramArrayOfInt[1] == GloableValue.jdField_b_of_type_ArrayOfInt[i1])) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private void b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i2 = GloableValue.jdField_c_of_type_ArrayOfInt.length / 2;
    int i1 = 0;
    if (i1 < i2)
    {
      int i3 = a(GloableValue.jdField_c_of_type_ArrayOfInt[(i1 * 2 + 1)], paramBoolean);
      if ((GloableValue.jdField_c_of_type_ArrayOfInt[(i1 * 2)] != paramInt1) || (i3 != paramInt2)) {}
    }
    for (;;)
    {
      if ((i1 >= 0) && (jdField_a_of_type_ArrayOfInt[i1] != this.jdField_b_of_type_Int)) {
        this.jdField_b_of_type_Int = jdField_a_of_type_ArrayOfInt[i1];
      }
      return;
      i1 += 1;
      break;
      i1 = -1;
    }
  }
  
  public static void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RMVideoStateMgr", 2, "clearVideoDataFile:" + paramString);
    }
    ThreadManager.post(new aohs(paramString), 5, null, true);
  }
  
  private static void b(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 == null) || (paramString1.trim().length() == 0)) {}
    do
    {
      do
      {
        return;
        paramString1 = new File(paramString1);
      } while (!paramString1.exists());
      File[] arrayOfFile = paramString1.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int i1 = 0;
        if (i1 < arrayOfFile.length)
        {
          if ((paramString2 != null) && (!"".equals(paramString2)) && (arrayOfFile[i1].getAbsolutePath().equals(paramString2))) {}
          for (;;)
          {
            i1 += 1;
            break;
            if (arrayOfFile[i1].isDirectory()) {
              b(arrayOfFile[i1].getAbsolutePath(), paramString2, true);
            } else {
              arrayOfFile[i1].delete();
            }
          }
        }
      }
    } while (!paramBoolean);
    paramString1.delete();
  }
  
  private void c(int paramInt)
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(paramInt);
  }
  
  public static void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      return;
      str = new File(paramString).getParentFile().getAbsolutePath();
    } while (TextUtils.isEmpty(str));
    a(str, paramString);
  }
  
  private void d(int paramInt)
  {
    if ((paramInt != -1) && (paramInt < GloableValue.h.length))
    {
      paramInt *= 4;
      CodecParam.j = GloableValue.jdField_c_of_type_ArrayOfInt[paramInt];
      CodecParam.k = GloableValue.jdField_c_of_type_ArrayOfInt[(paramInt + 1)];
      CodecParam.l = GloableValue.jdField_c_of_type_ArrayOfInt[(paramInt + 2)];
      CodecParam.m = GloableValue.jdField_c_of_type_ArrayOfInt[(paramInt + 3)];
      return;
    }
    CodecParam.j = GloableValue.jdField_d_of_type_Int;
    CodecParam.k = GloableValue.jdField_d_of_type_Int * 3 / 4;
    CodecParam.l = CodecParam.j * CodecParam.h / CodecParam.i;
    CodecParam.m = CodecParam.k * CodecParam.h / CodecParam.i;
  }
  
  private void d(boolean paramBoolean)
  {
    if ((CameraCompatibleList.e(CameraCompatibleList.u)) || (paramBoolean)) {
      PtvFilterUtils.b(false);
    }
  }
  
  private void n()
  {
    this.o = false;
  }
  
  private native void setBeautyLevelNative(int paramInt);
  
  private native void setResolutionAlignedByteNative(int paramInt);
  
  private native void setVideoClipSpec(int[] paramArrayOfInt);
  
  public float a()
  {
    if ((this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.f <= 0) || (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_e_of_type_Int <= 0)) {
      return 1.333333F;
    }
    return this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_e_of_type_Int * 1.0F / this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.f;
  }
  
  int a(int paramInt, boolean paramBoolean)
  {
    int i1 = paramInt;
    if (a(paramBoolean))
    {
      int i2 = paramInt % 16;
      i1 = paramInt;
      if (i2 > 0) {
        i1 = paramInt + (16 - i2);
      }
    }
    return i1;
  }
  
  public int a(TCTimer.TCTimerCallback paramTCTimerCallback, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int i1 = -1;
    if (paramTCTimerCallback == this)
    {
      a().a(paramTCTimerCallback, paramBoolean, paramInt1, paramInt2);
      i1 = 0;
    }
    return i1;
  }
  
  public RMVideoState a()
  {
    int i1 = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    aohe localaohe = this.jdField_a_of_type_Aohe;
    switch (i1)
    {
    default: 
      return localaohe;
    case 2: 
      return this.jdField_a_of_type_Aohd;
    case 3: 
      return this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoRecordState;
    }
    return this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoPreviewState;
  }
  
  public void a()
  {
    if (this.i) {
      GloableValue.a();
    }
    StorageManager.a().a(this);
    a().a();
    if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy != null) && (!this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame = true;
    }
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.b = false;
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    c(paramInt);
    a().a();
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    j();
    int i1 = 0;
    while (i1 < paramInt2)
    {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext.removeLatestVideo();
      if (paramBoolean) {
        AVCodec.get().removeLastCapture();
      }
      i1 += 1;
    }
    this.jdField_a_of_type_Double = paramInt1;
    RecordManager.a().a().b(paramInt1);
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndAdd(0) < 3) {
      i();
    }
  }
  
  public void a(int paramInt1, RMVideoClipSpec paramRMVideoClipSpec, int paramInt2)
  {
    switch (paramInt1)
    {
    case 3: 
    default: 
      return;
    case 1: 
    case 2: 
      paramRMVideoClipSpec.jdField_a_of_type_Int = paramInt2;
      paramRMVideoClipSpec.jdField_b_of_type_Int = 0;
      return;
    }
    paramRMVideoClipSpec.jdField_a_of_type_Int = (paramRMVideoClipSpec.jdField_e_of_type_Int - paramRMVideoClipSpec.jdField_d_of_type_Int - paramInt2);
    paramRMVideoClipSpec.jdField_b_of_type_Int = 0;
  }
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      
      label3:
      a().f();
      if (paramInt == 0)
      {
        a(0, "SD卡被移除，短视频将退出", false);
        if (1 == FlowCameraMqqAction.jdField_a_of_type_Int) {
          QzoneVideoBeaconReport.a(GloableValue.jdField_a_of_type_Long + "", "qzone_video_record", "1", null);
        }
      }
      return;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      break label3;
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMViewSTInterface != null) {
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMViewSTInterface.a(paramInt, paramString, paramBoolean);
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, String paramString, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4)
  {
    int i3 = 2;
    boolean bool2 = false;
    boolean bool1 = false;
    PtvFilterUtils.b(true);
    if (paramInt1 == 0)
    {
      PtvFilterUtils.a(0);
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "initVideoParams(): ptvMaxTime=" + paramInt4);
      }
      CodecParam.x = 0;
      CodecParam.E = 0;
      CodecParam.a();
      CodecParam.jdField_c_of_type_Int = paramInt4 * 1000;
      VideoEnvironment.c();
      paramBoolean = CameraCompatibleList.a(CameraCompatibleList.l);
      if (QLog.isColorLevel()) {
        QLog.e("RMVideoStateMgr", 2, "isFoundProductFeature:need640Black=" + paramBoolean);
      }
      if (paramBoolean)
      {
        GloableValue.jdField_c_of_type_Int = 640;
        GloableValue.jdField_d_of_type_Int = 480;
        if (QLog.isColorLevel()) {
          QLog.e("RMVideoStateMgr", 2, "isFoundProductFeature:true[640*480]");
        }
      }
      for (;;)
      {
        this.jdField_c_of_type_Int = 1;
        AudioCapture.jdField_a_of_type_Int = 4000;
        return;
        paramBoolean = CameraCompatibleList.a(CameraCompatibleList.s);
        if (QLog.isColorLevel()) {
          QLog.e("RMVideoStateMgr", 2, "isFoundProductFeature:need1024Black=" + paramBoolean);
        }
        if (paramBoolean)
        {
          GloableValue.jdField_c_of_type_Int = 1024;
          GloableValue.jdField_d_of_type_Int = 768;
          if (QLog.isColorLevel()) {
            QLog.e("RMVideoStateMgr", 2, "isFoundProductFeature:true[1024*768]");
          }
        }
        else
        {
          GloableValue.jdField_c_of_type_Int = 320;
          GloableValue.jdField_d_of_type_Int = 240;
        }
      }
    }
    if (paramInt1 == 1)
    {
      PtvFilterUtils.a(0);
      AudioCapture.jdField_a_of_type_Int = 4000;
      AudioCapture.jdField_b_of_type_Int = 1;
      CodecParam.E = 1;
      CodecParam.a();
    }
    for (;;)
    {
      int i1;
      try
      {
        VideoEnvironment.a(paramAppInterface, paramString, paramBoolean);
        VideoEnvironment.b();
        paramAppInterface = VideoEnvironment.a(paramInt2, false);
        if (a(paramAppInterface))
        {
          i1 = a(paramAppInterface);
          GloableValue.jdField_c_of_type_Int = paramAppInterface[0];
          GloableValue.jdField_d_of_type_Int = paramAppInterface[1];
          paramInt4 = paramAppInterface[2];
          paramInt1 = paramAppInterface[3];
          d(i1);
          paramAppInterface = VideoEnvironment.a(paramInt2);
          if (paramInt3 != 1) {
            continue;
          }
          paramInt2 = paramAppInterface[0];
          if (paramInt2 != 0) {
            break label1493;
          }
          if (paramInt4 > 0)
          {
            VideoEnvironment.c(paramInt4);
            VideoEnvironment.b(paramInt4);
            this.jdField_b_of_type_Int = paramInt4;
          }
          this.g = true;
          this.jdField_c_of_type_Int = 2;
        }
      }
      catch (Throwable paramAppInterface)
      {
        paramAppInterface.printStackTrace();
        continue;
        GloableValue.jdField_c_of_type_Int = GloableValue.g[1];
        GloableValue.jdField_d_of_type_Int = GloableValue.h[1];
        paramInt4 = 450;
        paramInt1 = 750;
        i1 = 1;
        continue;
        if ((paramInt3 == 4) || (paramInt3 == 3))
        {
          paramInt2 = paramAppInterface[1];
          continue;
        }
        paramInt2 = paramAppInterface[2];
        continue;
      }
      if (paramInt1 == 2)
      {
        PtvFilterUtils.a(1);
        CodecParam.x = 0;
        CodecParam.E = 0;
        CodecParam.a();
      }
      for (;;)
      {
        try
        {
          VideoEnvironment.a(paramAppInterface, paramString, false);
          VideoEnvironment.b();
          paramAppInterface = VideoEnvironment.a(paramInt2, true);
          if (a(paramAppInterface))
          {
            i1 = b(paramAppInterface);
            GloableValue.jdField_c_of_type_Int = paramAppInterface[0];
            GloableValue.jdField_d_of_type_Int = paramAppInterface[1];
            paramInt4 = paramAppInterface[2];
            paramInt1 = paramAppInterface[3];
            d(i1);
            paramAppInterface = VideoEnvironment.a(paramInt2);
            if (paramInt3 != 1) {
              continue;
            }
            paramInt2 = paramAppInterface[0];
            if (paramInt2 != 0) {
              break label1487;
            }
            if (paramInt4 > 0)
            {
              VideoEnvironment.c(paramInt4);
              VideoEnvironment.b(paramInt4);
              paramBoolean = bool1;
              if (paramInt2 == 1) {
                paramBoolean = true;
              }
              VideoEnvironment.a(paramInt4, paramBoolean);
              this.jdField_b_of_type_Int = paramInt4;
            }
            this.jdField_c_of_type_Int = 3;
            AudioCapture.jdField_a_of_type_Int = 4000;
            AudioCapture.jdField_b_of_type_Int = 1;
            d(true);
            paramInt2 = VcSystemInfo.e();
            paramInt1 = paramInt2;
            if (paramInt2 > 4) {
              paramInt1 = 4;
            }
            paramInt2 = paramInt1;
            if (paramInt1 <= 0) {
              paramInt2 = 2;
            }
            paramInt1 = paramInt2;
            if (paramInt2 != 1)
            {
              paramInt1 = paramInt2;
              if (paramInt2 % 2 != 0) {
                paramInt1 = 2;
              }
            }
            PtvFilterUtils.b(paramInt1);
          }
        }
        catch (Throwable paramAppInterface)
        {
          paramAppInterface.printStackTrace();
          continue;
          GloableValue.jdField_c_of_type_Int = GloableValue.jdField_a_of_type_ArrayOfInt[0];
          GloableValue.jdField_d_of_type_Int = GloableValue.jdField_b_of_type_ArrayOfInt[0];
          paramInt4 = 450;
          paramInt1 = 750;
          i1 = 0;
          continue;
          if ((paramInt3 == 4) || (paramInt3 == 3))
          {
            paramInt2 = paramAppInterface[1];
            continue;
          }
          paramInt2 = paramAppInterface[2];
          continue;
        }
        if (paramInt1 == 3)
        {
          PtvFilterUtils.a(1);
          CodecParam.x = 0;
          CodecParam.E = 0;
          CodecParam.a();
        }
        for (;;)
        {
          try
          {
            VideoEnvironment.a(paramAppInterface, paramString, false);
            VideoEnvironment.b();
            paramAppInterface = VideoEnvironment.a(paramInt2, true);
            if (a(paramAppInterface))
            {
              i2 = b(paramAppInterface);
              GloableValue.jdField_c_of_type_Int = paramAppInterface[0];
              GloableValue.jdField_d_of_type_Int = paramAppInterface[1];
              i1 = paramAppInterface[2];
              paramInt1 = paramAppInterface[3];
              d(i2);
              paramAppInterface = VideoEnvironment.a(paramInt2);
              if (paramInt3 != 1) {
                continue;
              }
              paramInt2 = paramAppInterface[0];
              if (paramInt2 != 0) {
                break label1481;
              }
              if (i1 > 0)
              {
                VideoEnvironment.d(paramInt4);
                VideoEnvironment.b(i1);
                paramBoolean = bool2;
                if (paramInt2 == 1) {
                  paramBoolean = true;
                }
                VideoEnvironment.a(i1, paramBoolean);
                this.jdField_b_of_type_Int = i1;
              }
              this.jdField_c_of_type_Int = 3;
              AudioCapture.jdField_a_of_type_Int = 4000;
              AudioCapture.jdField_b_of_type_Int = 1;
              d(true);
              paramInt2 = VcSystemInfo.e();
              paramInt1 = paramInt2;
              if (paramInt2 > 4) {
                paramInt1 = 4;
              }
              paramInt2 = paramInt1;
              if (paramInt1 <= 0) {
                paramInt2 = 2;
              }
              if ((paramInt2 == 1) || (paramInt2 % 2 == 0)) {
                break label1475;
              }
              paramInt1 = i3;
              PtvFilterUtils.b(paramInt1);
            }
          }
          catch (Throwable paramAppInterface)
          {
            paramAppInterface.printStackTrace();
            continue;
            GloableValue.jdField_c_of_type_Int = GloableValue.jdField_a_of_type_ArrayOfInt[1];
            GloableValue.jdField_d_of_type_Int = GloableValue.jdField_b_of_type_ArrayOfInt[1];
            i1 = 450;
            paramInt1 = 750;
            int i2 = 1;
            continue;
            if ((paramInt3 == 4) || (paramInt3 == 3))
            {
              paramInt2 = paramAppInterface[1];
              continue;
            }
            paramInt2 = paramAppInterface[2];
            continue;
          }
          if (paramInt1 == 4)
          {
            PtvFilterUtils.a(0);
            if (QLog.isColorLevel()) {
              QLog.d("FlowCameraActivity", 2, "initVideoParams(): ptvMaxTime=" + paramInt4);
            }
            CodecParam.x = 0;
            CodecParam.E = 0;
            CodecParam.a();
            CodecParam.jdField_c_of_type_Int = paramInt4 * 1000;
            VideoEnvironment.c();
            CodecParam.g = 18;
            paramBoolean = CameraCompatibleList.a(CameraCompatibleList.l);
            if (QLog.isColorLevel()) {
              QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:need640Black=" + paramBoolean);
            }
            if (paramBoolean)
            {
              GloableValue.jdField_c_of_type_Int = 640;
              GloableValue.jdField_d_of_type_Int = 480;
              if (QLog.isColorLevel()) {
                QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:true[640*480]");
              }
            }
            for (;;)
            {
              this.jdField_c_of_type_Int = 4;
              AudioCapture.jdField_a_of_type_Int = 4000;
              return;
              paramBoolean = CameraCompatibleList.a(CameraCompatibleList.s);
              if (QLog.isColorLevel()) {
                QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:need1024Black=" + paramBoolean);
              }
              if (paramBoolean)
              {
                GloableValue.jdField_c_of_type_Int = 1024;
                GloableValue.jdField_d_of_type_Int = 768;
                if (QLog.isColorLevel()) {
                  QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:true[1024*768]");
                }
              }
              else
              {
                GloableValue.jdField_c_of_type_Int = 640;
                GloableValue.jdField_d_of_type_Int = 480;
              }
            }
          }
          if (paramInt1 != 5) {
            break;
          }
          PtvFilterUtils.a(0);
          CodecParam.x = 0;
          CodecParam.E = 0;
          CodecParam.a();
          CodecParam.jdField_c_of_type_Int = paramInt4 * 1000;
          VideoEnvironment.c();
          CodecParam.g = 18;
          paramBoolean = CameraCompatibleList.a(CameraCompatibleList.l);
          if (QLog.isColorLevel()) {
            QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:need640Black=" + paramBoolean);
          }
          if (paramBoolean)
          {
            GloableValue.jdField_c_of_type_Int = 640;
            GloableValue.jdField_d_of_type_Int = 480;
            if (QLog.isColorLevel()) {
              QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:true[640*480]");
            }
          }
          for (;;)
          {
            this.jdField_c_of_type_Int = 5;
            AudioCapture.jdField_a_of_type_Int = 4000;
            return;
            paramBoolean = CameraCompatibleList.a(CameraCompatibleList.s);
            if (QLog.isColorLevel()) {
              QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:need1024Black=" + paramBoolean);
            }
            if (paramBoolean)
            {
              GloableValue.jdField_c_of_type_Int = 1024;
              GloableValue.jdField_d_of_type_Int = 768;
              if (QLog.isColorLevel()) {
                QLog.i("RMVideoStateMgr", 2, "isFoundProductFeature:true[1024*768]");
              }
            }
            else
            {
              GloableValue.jdField_c_of_type_Int = 1024;
              GloableValue.jdField_d_of_type_Int = 768;
            }
          }
          label1475:
          paramInt1 = paramInt2;
          continue;
          label1481:
          i1 = paramInt1;
        }
        label1487:
        paramInt4 = paramInt1;
      }
      label1493:
      paramInt4 = paramInt1;
    }
  }
  
  public void a(CameraProxy paramCameraProxy)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy = paramCameraProxy;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy != null) {
      paramCameraProxy.a(this);
    }
  }
  
  public void a(RMVideoClipSpec paramRMVideoClipSpec, boolean paramBoolean)
  {
    for (int i1 = 1;; i1 = 0)
    {
      try
      {
        boolean bool1 = CameraCompatibleList.d(CameraCompatibleList.e);
        boolean bool2 = CameraCompatibleList.b(CameraCompatibleList.f);
        boolean bool3 = CameraCompatibleList.b(CameraCompatibleList.x);
        if (((bool1) || (bool2) || (bool3)) && (FlowCameraConstant.jdField_a_of_type_Int == 1)) {
          paramRMVideoClipSpec.jdField_b_of_type_Int = (-paramRMVideoClipSpec.jdField_b_of_type_Int);
        }
        this.jdField_b_of_type_ArrayOfInt[0] = paramRMVideoClipSpec.jdField_a_of_type_Int;
        this.jdField_b_of_type_ArrayOfInt[1] = paramRMVideoClipSpec.jdField_b_of_type_Int;
        this.jdField_b_of_type_ArrayOfInt[2] = paramRMVideoClipSpec.jdField_c_of_type_Int;
        this.jdField_b_of_type_ArrayOfInt[3] = paramRMVideoClipSpec.jdField_d_of_type_Int;
        this.jdField_b_of_type_ArrayOfInt[4] = paramRMVideoClipSpec.jdField_e_of_type_Int;
        this.jdField_b_of_type_ArrayOfInt[5] = paramRMVideoClipSpec.f;
        int[] arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
        if (FlowCameraConstant.jdField_a_of_type_Int != 1) {
          continue;
        }
        arrayOfInt[6] = i1;
        if (QLog.isColorLevel()) {
          QLog.i("RMVideoStateMgr", 2, "setVideoClipSpecdst_width=" + paramRMVideoClipSpec.jdField_e_of_type_Int + "spec.dst_height=" + paramRMVideoClipSpec.f + "xoffset=" + paramRMVideoClipSpec.jdField_a_of_type_Int + "y_offset=" + paramRMVideoClipSpec.jdField_b_of_type_Int + "clip_width=" + paramRMVideoClipSpec.jdField_c_of_type_Int + "clip_height" + paramRMVideoClipSpec.jdField_d_of_type_Int);
        }
        setVideoClipSpec(this.jdField_b_of_type_ArrayOfInt);
      }
      catch (UnsatisfiedLinkError paramRMVideoClipSpec)
      {
        for (;;)
        {
          paramRMVideoClipSpec.printStackTrace();
        }
      }
      b(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_e_of_type_Int, this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.f, paramBoolean);
      return;
    }
  }
  
  public void a(RMViewSTInterface paramRMViewSTInterface)
  {
    int i1 = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
    if (paramRMViewSTInterface == this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMViewSTInterface)
    {
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMViewSTInterface.w();
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMViewSTInterface = null;
    }
    if (i1 == 0)
    {
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext != null)
      {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext.mActivtiyDestory = true;
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext = null;
      }
      this.jdField_a_of_type_AndroidContentContext = null;
      if (QLog.isColorLevel()) {
        QLog.i("RMVideoStateMgr", 2, "rmStateMgr onDestroy viewST:" + this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMViewSTInterface + "\n videoStateMgr:" + jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr);
      }
      this.jdField_a_of_type_Aohe.f();
      this.jdField_a_of_type_Aohe.g();
      this.jdField_a_of_type_Aohd.f();
      this.jdField_a_of_type_Aohd.g();
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture = null;
      j();
      this.jdField_a_of_type_Aohb = null;
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a = null;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture$OnAudioRecordListener = null;
      g();
      this.jdField_e_of_type_Int = 0;
      this.m = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy = null;
  }
  
  public void a(PreviewContext paramPreviewContext)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.jdField_a_of_type_Int = this.jdField_c_of_type_Int;
    }
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext = paramPreviewContext;
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame = true;
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      a().a(paramObject, paramInt, paramVarArgs);
    }
    do
    {
      return;
    } while ((!CameraProxy.CameraPreviewObservable.class.isInstance(paramObject)) || (this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext == null));
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame = true;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
  
  public void a(String paramString)
  {
    j();
    if (QLog.isColorLevel()) {
      QLog.d("" + paramString, 2, "[@][deleteCacheFile] [RMFileEventNotify]stopWatching");
    }
    if (this.jdField_a_of_type_JavaLangString != null) {
      FileUtils.a(this.jdField_a_of_type_JavaLangString, false);
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3;
  }
  
  public boolean a(int paramInt)
  {
    try
    {
      setResolutionAlignedByteNative(paramInt);
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return false;
  }
  
  public boolean a(Context paramContext, String paramString, RMViewSTInterface paramRMViewSTInterface)
  {
    return a(paramContext, paramString, paramRMViewSTInterface, (RMVideoSwitchCameraPicMgr.ViewBitmapSource)paramContext);
  }
  
  public boolean a(Context paramContext, String paramString, RMViewSTInterface paramRMViewSTInterface, RMVideoSwitchCameraPicMgr.ViewBitmapSource paramViewBitmapSource)
  {
    c(1);
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    GloableValue.jdField_a_of_type_Int = localDisplayMetrics.widthPixels;
    GloableValue.jdField_b_of_type_Int = localDisplayMetrics.heightPixels;
    this.j = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Double = 0.0D;
    this.h = false;
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture = null;
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMViewSTInterface = paramRMViewSTInterface;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.p = true;
    if (QLog.isColorLevel()) {
      QLog.i("RMVideoStateMgr", 2, "rmStateMgr onCreate viewST:" + this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMViewSTInterface + "\n videoStateMgr:" + jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr);
    }
    if (!a(paramContext, paramString, GloableValue.jdField_c_of_type_ArrayOfInt[4], GloableValue.jdField_c_of_type_ArrayOfInt[5]))
    {
      if (QLog.isColorLevel()) {
        QLog.e("RMVideoStateMgr", 2, "initTMMEngine[failed]");
      }
      if (1 == FlowCameraMqqAction.jdField_a_of_type_Int) {
        QzoneVideoBeaconReport.a(paramString, "qzone_video_record", "0", null);
      }
      return false;
    }
    try
    {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilAudioDataCache = new AudioDataCache(GloableValue.a());
      b(1);
      try
      {
        this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a = paramViewBitmapSource;
        RecordManager.a().a().addCodecCallback(this);
        RecordManager.a().a().a(this);
        StorageManager.a();
        if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement() > 0) && (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMViewSTInterface != null))
        {
          this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMViewSTInterface.w();
          RecordManager.a().a().b();
          RecordManager.a().a();
        }
        RecordManager.a().a().a(this);
        RecordManager.a().a().a();
        if ((this.n) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder == null)) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder = new HWVideoRecorder();
        }
        UnifiedMonitor.a().a();
        if (QLog.isColorLevel()) {
          QLog.e("RMVideoStateMgr", 2, "onCreate successful");
        }
        return true;
      }
      catch (ClassCastException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
      return false;
    }
    catch (RuntimeException paramContext) {}
  }
  
  public boolean a(int[] paramArrayOfInt)
  {
    return (paramArrayOfInt != null) && (paramArrayOfInt.length == 4) && (paramArrayOfInt[0] > 0) && (paramArrayOfInt[1] > 0);
  }
  
  public void b()
  {
    GloableValue.b();
    a().f();
    StorageManager.a().a(null);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.jdField_a_of_type_Boolean = true;
  }
  
  public void b(int paramInt)
  {
    try
    {
      setBeautyLevelNative(paramInt);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("RMVideoStateMgr", 2, "setBeautyLevel appear error", localUnsatisfiedLinkError);
    }
  }
  
  public void b(int paramInt1, RMVideoClipSpec paramRMVideoClipSpec, int paramInt2)
  {
    switch (paramInt1)
    {
    case 3: 
    default: 
      return;
    case 1: 
      paramRMVideoClipSpec.jdField_a_of_type_Int = paramInt2;
      paramRMVideoClipSpec.jdField_b_of_type_Int = (paramRMVideoClipSpec.f - paramRMVideoClipSpec.jdField_c_of_type_Int);
      return;
    case 2: 
      paramRMVideoClipSpec.jdField_a_of_type_Int = paramInt2;
      paramRMVideoClipSpec.jdField_b_of_type_Int = 0;
      return;
    case 4: 
      paramRMVideoClipSpec.jdField_a_of_type_Int = (paramRMVideoClipSpec.jdField_e_of_type_Int - paramRMVideoClipSpec.jdField_d_of_type_Int - paramInt2);
      paramRMVideoClipSpec.jdField_b_of_type_Int = (paramRMVideoClipSpec.f - paramRMVideoClipSpec.jdField_c_of_type_Int);
      return;
    case 5: 
      paramRMVideoClipSpec.jdField_a_of_type_Int = (paramRMVideoClipSpec.jdField_e_of_type_Int - paramRMVideoClipSpec.jdField_d_of_type_Int - paramInt2);
      paramRMVideoClipSpec.jdField_b_of_type_Int = 0;
      return;
    }
    paramRMVideoClipSpec.jdField_a_of_type_Int = 0;
    paramRMVideoClipSpec.jdField_b_of_type_Int = (-(paramRMVideoClipSpec.f - paramRMVideoClipSpec.jdField_c_of_type_Int) / 2);
  }
  
  public void b(int paramInt, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new aohp(this, paramString));
  }
  
  public void b(boolean paramBoolean)
  {
    c(1);
    a().a(paramBoolean);
    a().a();
    if ((this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.b) && (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.jdField_a_of_type_Boolean)) {
      a().f();
    }
  }
  
  public boolean b()
  {
    return this.k;
  }
  
  public boolean b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RMVideoStateMgr", 2, "mediacodec from:" + paramInt + ", isMediaCodecSupport:" + this.n);
    }
    return this.n;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Double = 0.0D;
    RecordManager.a().a().c();
    if (RecordManager.a().a().a.getState() == Thread.State.TERMINATED)
    {
      RecordManager.a().a();
      RecordManager.a().a().a(this);
      RecordManager.a().a().a();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    int i1 = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (i1 == 3) {
      a().b();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RMVideoStateMgr", 2, "[exitRecordMode]currentState = " + i1 + " mCurrentSegInvalid=" + this.k);
      }
      return this.k;
      if (i1 == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RMVideoStateMgr", 2, "current = G_STATUS_IDLE ,so do not change state...");
        }
        this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.b = true;
      }
    }
  }
  
  public void d()
  {
    n();
    this.k = false;
    if (QLog.isColorLevel()) {
      QLog.e("RMVideoStateMgr", 2, "[enterRecordMode]currentState = " + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + " mCurrentSegInvalid=" + this.k);
    }
    a().b();
  }
  
  public boolean d()
  {
    long l1 = StorageManager.a(StorageManager.a().b);
    if (l1 <= StorageManager.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoStateMgr", 2, "[@] checkDiskSpaceIsOK,freeSpace <= FREESPACE_LIMIT_EXIT freeSpace=" + l1 + "StorageManager.FREESPACE_LIMIT_EXIT=" + StorageManager.jdField_a_of_type_Long + " 手机剩余存储空间不足");
      }
      a(0, "手机剩余存储空间不足,清理外部存储空间后再试", false);
      return false;
    }
    return true;
  }
  
  public void e()
  {
    this.l = true;
    if (QLog.isColorLevel()) {
      QLog.e("RMVideoStateMgr", 2, "startHwRecorder");
    }
    if (SVDropFrameMonitor.a().jdField_d_of_type_Boolean)
    {
      SVDropFrameMonitor.a().a("list_short_video_with_effect");
      return;
    }
    SVDropFrameMonitor.a().a("list_short_video_no_effect");
  }
  
  public boolean e()
  {
    if (!this.o) {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        boolean bool = this.o;
        if (!bool) {}
        try
        {
          this.jdField_b_of_type_JavaLangObject.wait(1000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    return true;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.e("RMVideoStateMgr", 2, "stopHwRecorder");
    }
    this.l = false;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.c();
    }
    this.jdField_d_of_type_Int = 0;
    if (SVDropFrameMonitor.a().jdField_d_of_type_Boolean)
    {
      SVDropFrameMonitor.a().a("list_short_video_with_effect", false);
      return;
    }
    SVDropFrameMonitor.a().a("list_short_video_no_effect", false);
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture != null) && (this.jdField_d_of_type_Boolean);
  }
  
  public void g()
  {
    if (this.j) {
      return;
    }
    RecordManager.a().a().b();
    RecordManager.a().a().a(null);
    RecordManager.a().a().removeCodecCallback(this);
    RecordManager.a().a().recycle();
    RecordManager.a().a().a();
    RecordManager.a().a();
    try
    {
      GloableValue.c();
      StorageManager.a().a();
      this.j = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
      }
    }
  }
  
  public boolean g()
  {
    return this.p;
  }
  
  public void h()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.o = true;
      this.jdField_b_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_Aohb != null) && (this.jdField_a_of_type_Double > 0.0D)) {
      this.jdField_a_of_type_Aohb.startWatching();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Aohb != null) {
      this.jdField_a_of_type_Aohb.stopWatching();
    }
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][initAudioRecord]mIsAudioReady=" + this.jdField_d_of_type_Boolean + " mAI=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture);
    }
    if (!f())
    {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture = new AudioCapture(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture.a(this);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][initAudioRecord]");
    }
  }
  
  public void l()
  {
    ThreadManager.post(new aohq(this), 10, null, false);
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][closeAudioRecord]mIsAudioReady=" + this.jdField_d_of_type_Boolean + " mAI=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture);
    }
    ThreadManager.post(new aohr(this), 10, null, false);
  }
  
  public void onAVCodecEvent(AVCodec.AVCodecCallback arg1, MessageStruct paramMessageStruct)
  {
    a().a(???, paramMessageStruct);
    if (paramMessageStruct.mId == 33554451)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoStateMgr", 2, "[@] onAVCodecEvent, MSG_RECORD_SUBMIT_FINISH_CALLBACK");
      }
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.notifyAll();
        if (QLog.isColorLevel()) {
          QLog.d("RMVideoStateMgr", 2, "[@] onAVCodecEvent, MSG_RECORD_SUBMIT_FINISH_CALLBACK ,notifyAll");
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr
 * JD-Core Version:    0.7.0.1
 */