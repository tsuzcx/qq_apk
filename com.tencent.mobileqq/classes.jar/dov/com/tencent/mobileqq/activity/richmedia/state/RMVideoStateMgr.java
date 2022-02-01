package dov.com.tencent.mobileqq.activity.richmedia.state;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.maxvideo.mediadevice.AVCodec.AVCodecCallback;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWVideoRecorder;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.CameraPreviewObservable;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import dov.com.tencent.mobileqq.shortvideo.common.GloableValue;
import dov.com.tencent.mobileqq.shortvideo.common.TCTimer.TCTimerCallback;
import dov.com.tencent.mobileqq.shortvideo.error.ErrorCenter.ErrorHandleCallback;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture.OnAudioRecordListener;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import dov.com.tencent.mobileqq.shortvideo.util.AudioDataCache;
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
  private HWVideoRecorder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder;
  public RMFileEventNotify a;
  public RMVideoClipSpec a;
  final RMVideoIdleState jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoIdleState = new RMVideoIdleState();
  final RMVideoInitState jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoInitState = new RMVideoInitState();
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
  public int c;
  private int d;
  public boolean d;
  private int e;
  public boolean e;
  private int f;
  public boolean f;
  public boolean g = false;
  public boolean h = false;
  public boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private volatile boolean l;
  private boolean m = false;
  private boolean n = false;
  private volatile boolean o = false;
  private boolean p = true;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_c_of_type_Boolean = true;
  }
  
  private RMVideoStateMgr()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr = new RMVideoThumbGenMgr();
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr = new RMVideoSwitchCameraPicMgr();
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMFileEventNotify = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilAudioDataCache = null;
    this.jdField_d_of_type_Int = 1;
    this.jdField_b_of_type_Int = 480;
    this.jdField_f_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause = new RMVideoStateMgr.ForceReleaseLockOnPause();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoClipSpec = new RMVideoClipSpec();
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
  
  private void b(int paramInt)
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(paramInt);
  }
  
  public static void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RMVideoStateMgr", 2, "clearVideoDataFile:" + paramString);
    }
    ThreadManager.post(new RMVideoStateMgr.4(paramString), 5, null, true);
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
  
  private native void setBeautyLevelNative(int paramInt);
  
  private native void setResolutionAlignedByteNative(int paramInt);
  
  private native void setVideoClipSpec(int[] paramArrayOfInt);
  
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
    RMVideoInitState localRMVideoInitState = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoInitState;
    switch (i1)
    {
    default: 
      return localRMVideoInitState;
    case 2: 
      return this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoIdleState;
    case 3: 
      return this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoRecordState;
    }
    return this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoPreviewState;
  }
  
  public void a()
  {
    this.l = true;
    if (QLog.isColorLevel()) {
      QLog.e("RMVideoStateMgr", 2, "startHwRecorder");
    }
  }
  
  public void a(int paramInt)
  {
    b(paramInt);
    a().a();
  }
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      
      label3:
      a().e();
      if (paramInt == 0)
      {
        a(0, HardCodeUtil.a(2131713433), false);
        if (1 == FlowCameraMqqAction.jdField_a_of_type_Int) {
          QzoneVideoBeaconReport.reportVideoEvent(GloableValue.jdField_a_of_type_Long + "", "qzone_video_record", "1", null);
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
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
  
  public void a(String paramString)
  {
    e();
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
    if (QLog.isColorLevel()) {
      QLog.i("RMVideoStateMgr", 2, "mediacodec from:" + paramInt + ", isMediaCodecSupport:" + this.n);
    }
    return this.n;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("RMVideoStateMgr", 2, "stopHwRecorder");
    }
    this.l = false;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.c();
    }
    this.jdField_e_of_type_Int = 0;
  }
  
  public void b(int paramInt, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new RMVideoStateMgr.1(this, paramString));
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  boolean b()
  {
    long l1 = StorageManager.a(StorageManager.a().b);
    if (l1 <= StorageManager.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoStateMgr", 2, "[@] checkDiskSpaceIsOK,freeSpace <= FREESPACE_LIMIT_EXIT freeSpace=" + l1 + "StorageManager.FREESPACE_LIMIT_EXIT=" + StorageManager.jdField_a_of_type_Long + " 手机剩余存储空间不足");
      }
      a(0, HardCodeUtil.a(2131713432), false);
      return false;
    }
    return true;
  }
  
  public void c()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.o = true;
      this.jdField_b_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public boolean c()
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
  
  public void d()
  {
    if ((this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMFileEventNotify != null) && (this.jdField_a_of_type_Double > 0.0D)) {
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMFileEventNotify.startWatching();
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture != null) && (this.jdField_d_of_type_Boolean);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMFileEventNotify != null) {
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMFileEventNotify.stopWatching();
    }
  }
  
  public boolean e()
  {
    return this.p;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][initAudioRecord]mIsAudioReady=" + this.jdField_d_of_type_Boolean + " mAI=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture);
    }
    if (!d())
    {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture = new AudioCapture(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture.a(this);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][initAudioRecord]");
    }
  }
  
  public void g()
  {
    ThreadManager.post(new RMVideoStateMgr.2(this), 10, null, false);
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][closeAudioRecord]mIsAudioReady=" + this.jdField_d_of_type_Boolean + " mAI=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture);
    }
    ThreadManager.post(new RMVideoStateMgr.3(this), 10, null, false);
  }
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr
 * JD-Core Version:    0.7.0.1
 */