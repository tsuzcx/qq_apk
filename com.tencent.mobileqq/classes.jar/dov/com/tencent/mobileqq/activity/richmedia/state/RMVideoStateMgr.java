package dov.com.tencent.mobileqq.activity.richmedia.state;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import anvx;
import bbna;
import bdbl;
import bpia;
import bpkb;
import bpkc;
import bpkd;
import bpke;
import bpkf;
import bpkg;
import bpkh;
import bpki;
import bpkm;
import bpkn;
import bprm;
import bpro;
import bprq;
import bpsh;
import bptb;
import bpty;
import bpua;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.maxvideo.mediadevice.AVCodec.AVCodecCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class RMVideoStateMgr
  implements bpro, bprq, bpsh, bpua, AVCodec.AVCodecCallback
{
  private static RMVideoStateMgr jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 850, 780, 650, 480 };
  public static boolean b;
  public double a;
  public int a;
  public long a;
  public Context a;
  public Handler a;
  private bbna jdField_a_of_type_Bbna;
  public bpkb a;
  public bpkc a;
  final bpkd jdField_a_of_type_Bpkd = new bpkd();
  final bpke jdField_a_of_type_Bpke = new bpke();
  final bpkf jdField_a_of_type_Bpkf = new bpkf();
  final bpkg jdField_a_of_type_Bpkg = new bpkg();
  public bpki a;
  public final bpkm a;
  public bpkn a;
  public bpsh a;
  public bptb a;
  public final RMVideoSwitchCameraPicMgr a;
  public AudioCapture a;
  public PreviewContext a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  public AtomicBoolean a;
  public AtomicInteger a;
  public boolean a;
  private int jdField_b_of_type_Int = 1;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  public String b;
  public AtomicInteger b;
  private int[] jdField_b_of_type_ArrayOfInt = new int[8];
  private int c;
  public boolean c;
  public boolean d;
  public boolean e = true;
  public boolean f;
  private boolean g;
  private volatile boolean h;
  private boolean i;
  private volatile boolean j;
  private boolean k = true;
  
  static
  {
    jdField_b_of_type_Boolean = true;
  }
  
  private RMVideoStateMgr()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_Bpkm = new bpkm();
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr = new RMVideoSwitchCameraPicMgr();
    this.jdField_a_of_type_Int = 480;
    this.jdField_a_of_type_Bpki = new bpki();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Bpkc = new bpkc();
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
        int m = 0;
        if (m < arrayOfFile.length)
        {
          if ((paramString2 != null) && (!"".equals(paramString2)) && (arrayOfFile[m].getAbsolutePath().equals(paramString2))) {}
          for (;;)
          {
            m += 1;
            break;
            if (arrayOfFile[m].isDirectory()) {
              b(arrayOfFile[m].getAbsolutePath(), paramString2, true);
            } else {
              arrayOfFile[m].delete();
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
  
  public int a(bpro parambpro, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int m = -1;
    if (parambpro == this)
    {
      a().a(parambpro, paramBoolean, paramInt1, paramInt2);
      m = 0;
    }
    return m;
  }
  
  public bpkh a()
  {
    int m = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    bpke localbpke = this.jdField_a_of_type_Bpke;
    switch (m)
    {
    default: 
      return localbpke;
    case 2: 
      return this.jdField_a_of_type_Bpkd;
    case 3: 
      return this.jdField_a_of_type_Bpkg;
    }
    return this.jdField_a_of_type_Bpkf;
  }
  
  public void a()
  {
    this.h = true;
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
        a(0, anvx.a(2131712937), false);
        if (1 == bpia.jdField_a_of_type_Int) {
          QzoneVideoBeaconReport.reportVideoEvent(bprm.a + "", "qzone_video_record", "1", null);
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
    if (this.jdField_a_of_type_Bpkn != null) {
      this.jdField_a_of_type_Bpkn.a(paramInt, paramString, paramBoolean);
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
      FileUtils.delete(this.jdField_a_of_type_JavaLangString, false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3;
  }
  
  public boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RMVideoStateMgr", 2, "mediacodec from:" + paramInt + ", isMediaCodecSupport:" + this.i);
    }
    return this.i;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("RMVideoStateMgr", 2, "stopHwRecorder");
    }
    this.h = false;
    if (this.jdField_a_of_type_Bbna != null) {
      this.jdField_a_of_type_Bbna.b();
    }
    this.jdField_c_of_type_Int = 0;
  }
  
  public void b(int paramInt, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new RMVideoStateMgr.1(this, paramString));
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  boolean b()
  {
    long l = bpty.a(bpty.a().b);
    if (l <= bpty.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoStateMgr", 2, "[@] checkDiskSpaceIsOK,freeSpace <= FREESPACE_LIMIT_EXIT freeSpace=" + l + "StorageManager.FREESPACE_LIMIT_EXIT=" + bpty.a + " 手机剩余存储空间不足");
      }
      a(0, anvx.a(2131712936), false);
      return false;
    }
    return true;
  }
  
  public void c()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.j = true;
      this.jdField_b_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public boolean c()
  {
    if (!this.j) {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        boolean bool = this.j;
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
    if ((this.jdField_a_of_type_Bpkb != null) && (this.jdField_a_of_type_Double > 0.0D)) {
      this.jdField_a_of_type_Bpkb.startWatching();
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture != null) && (this.jdField_c_of_type_Boolean);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bpkb != null) {
      this.jdField_a_of_type_Bpkb.stopWatching();
    }
  }
  
  public boolean e()
  {
    return this.k;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoStateMgr", 2, "[@][initAudioRecord]mIsAudioReady=" + this.jdField_c_of_type_Boolean + " mAI=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture);
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
      QLog.d("RMVideoStateMgr", 2, "[@][closeAudioRecord]mIsAudioReady=" + this.jdField_c_of_type_Boolean + " mAI=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture);
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
    } while ((!bdbl.class.isInstance(paramObject)) || (this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext == null));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr
 * JD-Core Version:    0.7.0.1
 */