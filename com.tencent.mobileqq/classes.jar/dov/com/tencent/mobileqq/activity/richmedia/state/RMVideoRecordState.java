package dov.com.tencent.mobileqq.activity.richmedia.state;

import android.os.Handler;
import aohm;
import aohn;
import aoho;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import dov.com.tencent.mobileqq.shortvideo.common.TCTimer;
import dov.com.tencent.mobileqq.shortvideo.common.TCTimer.TCTimerCallback;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.Lock;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.RecordManager;
import dov.com.tencent.mobileqq.shortvideo.util.AudioDataCache;

public class RMVideoRecordState
  extends RMVideoState
{
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  
  private void d()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] [startRecordVideo]Lock.CAPTURE_LOCK=" + Lock.jdField_a_of_type_Boolean);
    }
    if (!Lock.jdField_a_of_type_Boolean) {}
    synchronized (Lock.jdField_a_of_type_JavaLangObject)
    {
      Lock.jdField_a_of_type_Boolean = true;
      Lock.jdField_a_of_type_JavaLangObject.notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("RMRecordState", 2, "[@] [startRecordVideo]Lock.CAPTURE_LOCK=" + Lock.jdField_a_of_type_Boolean);
      }
      AVCodec.get().startCapture();
      localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext.startCapture();
      if (localRMVideoStateMgr.b(2)) {
        localRMVideoStateMgr.e();
      }
      if ((localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture != null) && (localRMVideoStateMgr.g())) {
        localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture.g();
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
    }
  }
  
  public void a()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMViewSTInterface.o();
    localRMVideoStateMgr.j();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] [RMFileEventNotify]stopWatching");
    }
    this.jdField_a_of_type_Boolean = false;
    d();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] initState end");
    }
  }
  
  public void a(TCTimer.TCTimerCallback paramTCTimerCallback, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    paramTCTimerCallback = RMVideoStateMgr.a();
    if (paramTCTimerCallback.jdField_b_of_type_Boolean) {}
    for (paramTCTimerCallback.jdField_a_of_type_Double = (System.currentTimeMillis() - paramTCTimerCallback.jdField_a_of_type_Long);; paramTCTimerCallback.jdField_a_of_type_Double = paramInt1)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = paramBoolean;
        if ((paramTCTimerCallback.f()) && (!paramTCTimerCallback.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture.e) && (!paramTCTimerCallback.h)) {
          paramTCTimerCallback.jdField_a_of_type_AndroidOsHandler.post(new aohn(this));
        }
        if (QLog.isColorLevel()) {
          QLog.d("RMRecordState", 2, "[@] timeExpire: mIsRecordOver=" + this.jdField_a_of_type_Boolean + " mStateMgr.mTotalTime=" + paramTCTimerCallback.jdField_a_of_type_Double);
        }
        paramTCTimerCallback.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMViewSTInterface.a((int)(paramTCTimerCallback.jdField_a_of_type_Double + RecordManager.a().a().a()), this.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Boolean) {
          paramTCTimerCallback.jdField_a_of_type_AndroidOsHandler.post(new aoho(this));
        }
      }
      return;
    }
  }
  
  public void b()
  {
    c();
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    localRMVideoStateMgr.a(2);
    localRMVideoStateMgr.i();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] [RMFileEventNotify]startWatching");
    }
  }
  
  public void c()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (QLog.isColorLevel()) {
      QLog.d("RMRecordState", 2, "[@] [stopRecordVideo]Lock.CAPTURE_LOCK = " + Lock.jdField_a_of_type_Boolean);
    }
    if (Lock.jdField_a_of_type_Boolean)
    {
      Lock.jdField_a_of_type_Boolean = false;
      long l1 = System.currentTimeMillis();
      this.jdField_a_of_type_Long = (l1 - this.jdField_a_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.d("RMRecordState", 2, "[@] [stopRecordVideo] current=" + l1 + " timestamp=" + this.jdField_a_of_type_Long);
      }
      if (this.jdField_a_of_type_Boolean) {
        localRMVideoStateMgr.jdField_a_of_type_Double = CodecParam.c;
      }
      localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMViewSTInterface.t();
      localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext.stopCapture();
      if (localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
        localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture.h();
      }
      if (localRMVideoStateMgr.b(3))
      {
        if (localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilAudioDataCache != null) {
          localRMVideoStateMgr.jdField_b_of_type_JavaLangString = localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilAudioDataCache.a(localRMVideoStateMgr);
        }
        localRMVideoStateMgr.f();
      }
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new aohm(this, localRMVideoStateMgr));
      AVCodec.get().stopCapture();
      long l2 = localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMViewSTInterface.d();
      if (QLog.isColorLevel()) {
        QLog.d("RMRecordState", 2, "[@] [stopRecordVideo] timeLimit=" + l2 + " timestamp=" + this.jdField_a_of_type_Long);
      }
      l1 = l2;
      if (l2 == -1L) {
        l1 = this.jdField_a_of_type_Long;
      }
      if ((l1 < 500L) && (!this.jdField_a_of_type_Boolean))
      {
        localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMViewSTInterface.g(true);
        localRMVideoStateMgr.a(true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("RMRecordState", 2, "[@] stopRecordVideo end Lock.CAPTURE_LOCK = " + Lock.jdField_a_of_type_Boolean);
      }
    }
  }
  
  public void f()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState
 * JD-Core Version:    0.7.0.1
 */