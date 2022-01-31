package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.opengl.GLES20;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import autt;
import auwn;
import auwo;
import awje;
import bedt;
import bgxr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.util.CameraInterFace;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class SimpleEffectsCaptureView
  extends CameraCaptureSegmentView
  implements CameraInterFace
{
  private static QQFilterRenderManager jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  private auwn jdField_a_of_type_Auwn;
  private auwo jdField_a_of_type_Auwo;
  protected QQFilterRenderManager a;
  private short[] jdField_a_of_type_ArrayOfShort;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[50];
  protected boolean j;
  private boolean k;
  private boolean l;
  private boolean m = true;
  private int z;
  
  static
  {
    bedt.a();
    bgxr.a();
    VideoPrefsUtil.init(BaseApplicationImpl.getContext(), ShortVideoUtils.a());
  }
  
  public SimpleEffectsCaptureView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public SimpleEffectsCaptureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static float a(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    float f = 0.0F;
    int i = 0;
    while (i < paramInt2)
    {
      f += paramArrayOfShort[(paramInt1 + i)] * paramArrayOfShort[(paramInt1 + i)];
      i += 1;
    }
    return (float)(Math.log10(f / paramInt2) * 10.0D);
  }
  
  private short[] a(int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfShort == null) || (this.jdField_a_of_type_ArrayOfShort.length < paramInt)) {
      this.jdField_a_of_type_ArrayOfShort = new short[paramInt];
    }
    return this.jdField_a_of_type_ArrayOfShort;
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if ((this.j) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceChange(this.n, this.o, getWidth(), getHeight());
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = a(paramArrayOfByte, paramInt1, paramInt2);
    paramInt2 >>= 1;
    paramInt1 = awje.q;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null) {
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a();
    }
    int i = paramInt2 * 1000 / paramInt1;
    int n = i / 30;
    int i1 = paramInt1 * 30 / 1000;
    paramInt1 = 0;
    while (paramInt1 < n)
    {
      this.jdField_b_of_type_ArrayOfFloat[paramInt1] = a(paramArrayOfByte, paramInt1 * i1, i1);
      paramInt1 += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SimpleEffectsCaptureView", 2, "onAudioFrames length=" + paramInt2 + " shData.length: " + paramArrayOfByte.length + " duration: " + i + " countRefreshMs: " + i1);
    }
    if (this.jdField_a_of_type_Auwn != null) {
      this.jdField_a_of_type_Auwn.a(n, this.jdField_b_of_type_ArrayOfFloat);
    }
  }
  
  public short[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt2 >> 1;
    short[] arrayOfShort = a(i);
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      arrayOfShort[paramInt2] = ((short)(paramArrayOfByte[(paramInt2 * 2 + paramInt1)] & 0xFF | paramArrayOfByte[(paramInt2 * 2 + paramInt1 + 1)] << 8));
      paramInt2 += 1;
    }
    return arrayOfShort;
  }
  
  protected int b(int paramInt)
  {
    int i = paramInt;
    QQFilterRenderManager localQQFilterRenderManager;
    if (this.j)
    {
      i = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
      {
        localQQFilterRenderManager = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
        GLES20.glViewport(0, 0, this.n, this.o);
        localQQFilterRenderManager.setParam("key_orientation_degree", String.valueOf(this.w));
        if (a() != 1) {
          break label175;
        }
      }
    }
    label175:
    for (boolean bool = true;; bool = false)
    {
      localQQFilterRenderManager.setParam("key_front_camera", String.valueOf(bool));
      localQQFilterRenderManager.setParam("key_draw_screen", String.valueOf(true));
      localQQFilterRenderManager.setParam("key_enable_beauty", String.valueOf(this.m));
      localQQFilterRenderManager.setParam("key_enable_filter", String.valueOf(false));
      localQQFilterRenderManager.setParam("key_enable_ptv", String.valueOf(false));
      localQQFilterRenderManager.setParam("key_width", String.valueOf(this.n));
      localQQFilterRenderManager.setParam("key_height", String.valueOf(this.o));
      i = localQQFilterRenderManager.drawFrame(paramInt);
      if (this.jdField_a_of_type_Auwo != null) {
        this.jdField_a_of_type_Auwo.a(System.currentTimeMillis());
      }
      return i;
    }
  }
  
  public int d()
  {
    int n = 0;
    int i = n;
    if (this.j)
    {
      i = n;
      if (this.m)
      {
        i = n;
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) {
          i = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().getPtuBeautyLevel();
        }
      }
    }
    return i;
  }
  
  public void g()
  {
    super.g();
    if (QLog.isColorLevel()) {
      QLog.d("SimpleEffectsCaptureView", 2, "onSurfaceDestroy " + Thread.currentThread().getName() + " mFilterProcessInited=" + this.j);
    }
    if (jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager == this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager) {
      jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
    }
    if (this.j)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
      this.j = false;
    }
  }
  
  public int getCameraID()
  {
    return a();
  }
  
  public void i()
  {
    super.i();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    super.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
    if (QLog.isColorLevel()) {
      QLog.d("SimpleEffectsCaptureView", 2, "onSurfaceChanged " + Thread.currentThread().getName() + " mFilterProcessInited=" + this.j);
    }
    if (this.j)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceChange(this.n, this.o, getWidth(), getHeight());
      }
      if (this.z != 0) {
        setBeauty(this.z);
      }
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    super.onSurfaceCreated(paramGL10, paramEGLConfig);
    if (QLog.isColorLevel()) {
      QLog.d("SimpleEffectsCaptureView", 2, "onSurfaceCreated " + Thread.currentThread().getName() + " mFilterProcessInited=" + this.j);
    }
    if (this.j) {
      y();
    }
  }
  
  public void setAudioVolumeListener(auwn paramauwn)
  {
    this.jdField_a_of_type_Auwn = paramauwn;
  }
  
  public void setBeauty(int paramInt)
  {
    if ((this.j) && (this.m) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().updatePtuBeautyFilter(paramInt);
    }
    this.z = paramInt;
  }
  
  public void setBeauty(int[] paramArrayOfInt)
  {
    if ((this.j) && (this.m)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().updatePtuBeautyFilter(paramArrayOfInt[0]);
    }
    this.z = paramArrayOfInt[0];
  }
  
  public void setBeautyEnable(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void setFaceEffectListener(auwo paramauwo)
  {
    this.jdField_a_of_type_Auwo = paramauwo;
  }
  
  protected void u()
  {
    super.u();
    ThreadManager.postImmediately(new SimpleEffectsCaptureView.1(this), null, false);
  }
  
  public void y()
  {
    if (!this.j)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SimpleEffectsCaptureView", 2, "QQFilterRenderManager initQQFilterManger");
      }
      this.l = autt.b();
      QQFilterRenderManager localQQFilterRenderManager = new QQFilterRenderManager(new int[] { 25 });
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = localQQFilterRenderManager;
      jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = localQQFilterRenderManager;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.cameraInterFace = this;
    }
    queueEvent(new SimpleEffectsCaptureView.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.SimpleEffectsCaptureView
 * JD-Core Version:    0.7.0.1
 */