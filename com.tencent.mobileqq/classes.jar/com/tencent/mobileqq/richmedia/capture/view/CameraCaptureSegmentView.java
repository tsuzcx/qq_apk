package com.tencent.mobileqq.richmedia.capture.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaFormat;
import android.os.Message;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import auuv;
import auzi;
import auzl;
import avbk;
import bhym;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;

@TargetApi(18)
public class CameraCaptureSegmentView
  extends CameraCaptureView
  implements auzl
{
  private avbk jdField_a_of_type_Avbk;
  private bhym jdField_a_of_type_Bhym;
  private boolean j = true;
  private boolean k;
  private boolean l;
  private int z = 300;
  
  public CameraCaptureSegmentView(@NonNull Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  public CameraCaptureSegmentView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    f();
  }
  
  private boolean g()
  {
    if (!this.k) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureSegmentView", 2, "restartCaptureVideo");
    }
    this.jdField_a_of_type_Auuv.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Auuv.a();
    this.jdField_a_of_type_Avbk = new avbk(this, this.jdField_a_of_type_Auuv.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a(this.jdField_a_of_type_Auuv.b, this.jdField_a_of_type_Avbk.c());
    super.i();
    this.k = false;
    return true;
  }
  
  protected int a(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_Bhym != null)
    {
      i = paramInt;
      if (this.jdField_a_of_type_Bhym.a())
      {
        this.jdField_a_of_type_Bhym.a(paramInt, null);
        i = this.jdField_a_of_type_Bhym.a();
      }
    }
    return i;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureSegmentView", 2, "onAudioError:" + paramInt);
    }
    if (paramInt == -6)
    {
      if (this.jdField_a_of_type_Avbk != null) {
        this.jdField_a_of_type_Avbk.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a());
      }
      this.k = true;
    }
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    if ((this.jdField_a_of_type_Avbk != null) && (this.jdField_a_of_type_Avbk.a != null)) {
      this.jdField_a_of_type_Avbk.a.obtainMessage(1, paramMediaFormat).sendToTarget();
    }
  }
  
  public void a(auzi paramauzi)
  {
    if ((this.jdField_a_of_type_Avbk != null) && (this.jdField_a_of_type_Avbk.a != null)) {
      this.jdField_a_of_type_Avbk.a.obtainMessage(2, paramauzi).sendToTarget();
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureSegmentView", 2, "onEncodeFinish filePath = " + paramString);
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e();
    }
    if (this.jdField_a_of_type_Avbk != null) {
      this.jdField_a_of_type_Avbk.a(paramString, a());
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.jdField_a_of_type_Bhym != null) {
      this.jdField_a_of_type_Bhym.a();
    }
    this.jdField_a_of_type_Bhym = new bhym();
    this.jdField_a_of_type_Bhym.a(getContext(), this.n, this.o);
  }
  
  public void b(String paramString)
  {
    super.b(paramString);
    if (this.jdField_a_of_type_Avbk != null) {
      this.jdField_a_of_type_Avbk.b(paramString, a());
    }
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_Avbk != null) {
      this.jdField_a_of_type_Avbk.a(a(), paramString);
    }
    this.k = true;
  }
  
  protected void e()
  {
    this.i = false;
    super.e();
  }
  
  protected void f()
  {
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    setZOrderOnTop(true);
    getHolder().setFormat(-3);
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Bhym != null) {
      this.jdField_a_of_type_Bhym = null;
    }
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureSegmentView", 2, "cancelCaptureVideo,mIsStarted:" + this.l);
    }
    if (this.jdField_a_of_type_Avbk != null)
    {
      avbk localavbk = this.jdField_a_of_type_Avbk;
      this.jdField_a_of_type_Avbk = null;
      localavbk.a();
    }
    if (this.l)
    {
      this.l = false;
      super.j();
    }
  }
  
  public void i()
  {
    if (this.l)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CameraCaptureSegmentView", 2, "startCaptureVideo fail,mIsStarted:" + this.l);
      }
      return;
    }
    boolean bool2 = true;
    if (this.j)
    {
      this.j = false;
      super.i();
      bool1 = bool2;
      if (QLog.isColorLevel()) {
        QLog.i("CameraCaptureSegmentView", 2, "startCaptureVideo");
      }
    }
    for (boolean bool1 = bool2;; bool1 = g())
    {
      this.jdField_a_of_type_Auzf.a = null;
      if ((this.jdField_a_of_type_Avbk != null) && (this.jdField_a_of_type_Avbk.a())) {
        this.jdField_a_of_type_Auzf.a = this;
      }
      this.l = bool1;
      return;
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureSegmentView", 2, "stopCaptureVideo, mIsStarted:" + this.l);
    }
    if (this.l)
    {
      super.j();
      if (this.jdField_a_of_type_Avbk != null) {
        this.jdField_a_of_type_Avbk.a(this.z, this.jdField_a_of_type_Long, this.b);
      }
      this.l = false;
    }
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_Avbk != null) && (this.jdField_a_of_type_Avbk.a != null)) {
      this.jdField_a_of_type_Avbk.a.obtainMessage(3).sendToTarget();
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    super.onSurfaceCreated(paramGL10, paramEGLConfig);
  }
  
  public void setCaptureParam(auuv paramauuv)
  {
    paramauuv.a();
    super.setCaptureParam(paramauuv);
    int i = VideoEnvironment.a("AVCodec", getContext());
    if ((i != 0) && (QLog.isColorLevel())) {
      QLog.d("CameraCaptureSegmentView", 2, "loadAVCodecSo failed:" + i);
    }
    this.jdField_a_of_type_Avbk = new avbk(this, paramauuv.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a(true, this.jdField_a_of_type_Avbk.c());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a(true);
  }
  
  public void setFinishAnimatorDelay(int paramInt)
  {
    this.z = paramInt;
  }
  
  public void setSurfaceAlpha(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    if (this.jdField_a_of_type_Bhym != null) {
      this.jdField_a_of_type_Bhym.a(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureSegmentView
 * JD-Core Version:    0.7.0.1
 */