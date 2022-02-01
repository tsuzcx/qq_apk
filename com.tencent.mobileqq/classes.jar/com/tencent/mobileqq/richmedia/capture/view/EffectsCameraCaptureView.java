package com.tencent.mobileqq.richmedia.capture.view;

import alpt;
import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLES20;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import aqmy;
import azjq;
import bbge;
import bbhm;
import bbhs;
import bbiv;
import bbiw;
import bbix;
import bbiy;
import bbiz;
import bczv;
import bdaw;
import bmwb;
import bnrh;
import bogd;
import bogm;
import bpnj;
import bpqs;
import bprj;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQDanceEventHandler;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager.ChainBuilder;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.MovieMaterial;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQTemplateParser;
import com.tencent.mobileqq.shortvideo.util.CameraInterFace;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SvEffectSdkInitor;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@TargetApi(17)
public class EffectsCameraCaptureView
  extends CameraCaptureView
  implements CameraInterFace
{
  private static QQFilterRenderManager b;
  private int A;
  private int B;
  private int C;
  private bbiv jdField_a_of_type_Bbiv;
  private bbiw jdField_a_of_type_Bbiw;
  private bbix jdField_a_of_type_Bbix;
  private bbiy jdField_a_of_type_Bbiy;
  private bbiz jdField_a_of_type_Bbiz = new bbiz();
  protected bprj a;
  private QQDanceEventHandler jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler;
  protected QQFilterRenderManager a;
  private String jdField_a_of_type_JavaLangString;
  private long d;
  private long e = ((Long)VSConfigManager.getInstance().getValue("SmartCutPicSpacing", Long.valueOf(500L))).longValue();
  protected boolean j;
  public boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q = true;
  private boolean r = true;
  private boolean s = true;
  private boolean t;
  private boolean u;
  private boolean v;
  private boolean w;
  private volatile boolean x;
  private int z;
  
  static
  {
    SvEffectSdkInitor.init();
    bmwb.a();
    VideoPrefsUtil.init(BaseApplicationImpl.getContext(), ShortVideoUtils.getPtvTemplateSDKPref());
    BadcaseReportUtils.registerReport(new bbhs());
  }
  
  public EffectsCameraCaptureView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Bprj = new bprj();
  }
  
  public EffectsCameraCaptureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Bprj = new bprj();
  }
  
  public static QQFilterRenderManager a()
  {
    if ((jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager == null) && (QLog.isColorLevel())) {
      QLog.d("EffectsCameraCaptureView", 2, "getCurrentRenderManager null");
    }
    return jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  }
  
  private MovieMaterial a()
  {
    bpqs localbpqs = (bpqs)bogd.a(3);
    if (localbpqs != null) {
      return localbpqs.a();
    }
    return null;
  }
  
  private void a(MovieMaterial paramMovieMaterial)
  {
    bpqs localbpqs = (bpqs)bogd.a(3);
    if (localbpqs != null) {
      localbpqs.a(paramMovieMaterial);
    }
  }
  
  public static boolean a(FilterDesc paramFilterDesc)
  {
    if (paramFilterDesc != null)
    {
      int i = QQAVImageFilterConstants.getFilterType(paramFilterDesc.id);
      if ((i == 2) || (i == 1)) {}
      while ("MANHUA".equals(paramFilterDesc.name)) {
        return true;
      }
    }
    return false;
  }
  
  public static short[] a(byte[] paramArrayOfByte)
  {
    int i1 = paramArrayOfByte.length >> 1;
    short[] arrayOfShort = new short[i1];
    int i = 0;
    while (i < i1)
    {
      arrayOfShort[i] = ((short)(paramArrayOfByte[(i * 2)] & 0xFF | paramArrayOfByte[(i * 2 + 1)] << 8));
      i += 1;
    }
    return arrayOfShort;
  }
  
  protected int a(int paramInt)
  {
    int i = paramInt;
    QQFilterRenderManager localQQFilterRenderManager;
    boolean bool;
    if (this.j)
    {
      i = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
      {
        localQQFilterRenderManager = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
        GLES20.glViewport(0, 0, this.jdField_n_of_type_Int, this.jdField_o_of_type_Int);
        localQQFilterRenderManager.setParam("key_orientation_degree", String.valueOf(this.jdField_w_of_type_Int));
        if (a() != 1) {
          break label367;
        }
        bool = true;
        localQQFilterRenderManager.setParam("key_front_camera", String.valueOf(bool));
        localQQFilterRenderManager.setParam("key_draw_screen", String.valueOf(true));
        localQQFilterRenderManager.setParam("key_enable_beauty", String.valueOf(this.q));
        localQQFilterRenderManager.setParam("key_enable_filter", String.valueOf(this.s));
        localQQFilterRenderManager.setParam("key_enable_ptv", String.valueOf(this.r));
        localQQFilterRenderManager.setParam("key_width", String.valueOf(this.jdField_n_of_type_Int));
        localQQFilterRenderManager.setParam("key_height", String.valueOf(this.jdField_o_of_type_Int));
        localQQFilterRenderManager.setBackCameraDetectEnable(bpnj.a().c());
        localQQFilterRenderManager.setCaptureMode(this.c);
        paramInt = localQQFilterRenderManager.drawFrame(paramInt);
        if (this.A != this.jdField_a_of_type_Bbiz.jdField_a_of_type_Int)
        {
          this.m = false;
          this.l = false;
          this.jdField_o_of_type_Boolean = false;
          this.p = false;
          this.z = 0;
        }
        if (this.jdField_a_of_type_Bbiz.jdField_a_of_type_Int != 0) {
          break label441;
        }
        if ((!localQQFilterRenderManager.mNeedDoFaceDetect) || (localQQFilterRenderManager.mDetectedFace) || (!this.m)) {
          break label385;
        }
        if (this.z < 4) {
          break label372;
        }
        a(localQQFilterRenderManager.mNeedDoFaceDetect, localQQFilterRenderManager.mDetectedFace, false, false, 0);
      }
    }
    for (;;)
    {
      i = paramInt;
      if (this.jdField_a_of_type_Bbiw != null)
      {
        long l1 = System.currentTimeMillis();
        i = paramInt;
        if (l1 - this.d >= this.e)
        {
          azjq.a("Q.videostory", "Q.videostory.capture", "capturebitmap", "start");
          this.jdField_a_of_type_Bbiw.a(GlUtil.captureFrame(paramInt, this.jdField_n_of_type_Int, this.jdField_o_of_type_Int, 0));
          this.d = l1;
          i = paramInt;
        }
      }
      this.jdField_a_of_type_Bbix.a(System.currentTimeMillis());
      return i;
      label367:
      bool = false;
      break;
      label372:
      this.z += 1;
      continue;
      label385:
      if ((this.l != localQQFilterRenderManager.mNeedDoFaceDetect) || (this.m != localQQFilterRenderManager.mDetectedFace) || (this.jdField_n_of_type_Boolean))
      {
        this.jdField_n_of_type_Boolean = false;
        a(localQQFilterRenderManager.mNeedDoFaceDetect, localQQFilterRenderManager.mDetectedFace, false, false, 0);
        continue;
        label441:
        if (this.jdField_a_of_type_Bbiz.jdField_a_of_type_Int == 1)
        {
          if ((localQQFilterRenderManager.mNeedDoGestureDetect) && (!localQQFilterRenderManager.mDetectedGesture) && (this.p))
          {
            a(false, false, localQQFilterRenderManager.mNeedDoGestureDetect, localQQFilterRenderManager.mDetectedGesture, 1);
          }
          else if ((this.jdField_o_of_type_Boolean != localQQFilterRenderManager.mNeedDoGestureDetect) || (this.p != localQQFilterRenderManager.mDetectedGesture) || (this.jdField_n_of_type_Boolean))
          {
            this.jdField_n_of_type_Boolean = false;
            a(false, false, localQQFilterRenderManager.mNeedDoGestureDetect, localQQFilterRenderManager.mDetectedGesture, 1);
          }
        }
        else if ((this.jdField_a_of_type_Bbiz.jdField_a_of_type_Int == 2) && (localQQFilterRenderManager.mNeedDoFaceDetect) && (localQQFilterRenderManager.mNeedDoGestureDetect) && ((localQQFilterRenderManager.mDetectedFace != this.m) || (localQQFilterRenderManager.mDetectedGesture != this.p) || (this.jdField_n_of_type_Boolean)))
        {
          this.jdField_n_of_type_Boolean = false;
          a(localQQFilterRenderManager.mNeedDoFaceDetect, localQQFilterRenderManager.mDetectedFace, localQQFilterRenderManager.mNeedDoGestureDetect, localQQFilterRenderManager.mDetectedGesture, 2);
          if (QLog.isColorLevel()) {
            QLog.d("EffectsCameraCaptureView", 2, "onDrawFrameAfterCamera mDetectedFace:" + localQQFilterRenderManager.mDetectedFace + "mFilterProcess.mDetectedGesture:" + localQQFilterRenderManager.mDetectedGesture);
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt)
  {
    boolean bool2 = false;
    this.l = paramBoolean1;
    this.m = paramBoolean2;
    this.jdField_o_of_type_Boolean = paramBoolean3;
    this.p = paramBoolean4;
    this.z = 0;
    this.A = paramInt;
    if (this.jdField_a_of_type_Bbix != null)
    {
      bbix localbbix = this.jdField_a_of_type_Bbix;
      boolean bool1 = bool2;
      if (!bczv.a().a())
      {
        bool1 = bool2;
        if (paramBoolean1) {
          bool1 = true;
        }
      }
      localbbix.a(bool1, paramBoolean2, paramBoolean3, paramBoolean4);
    }
  }
  
  protected boolean a()
  {
    boolean bool2 = true;
    if (this.jdField_w_of_type_Boolean) {
      return false;
    }
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      bool1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.hasActiveFilter();
      if ((this.jdField_a_of_type_Int != 1) || (!bdaw.g())) {
        break label65;
      }
      i = 1;
      label42:
      if ((!aqmy.a()) || (bool1) || (i != 0)) {
        break label70;
      }
    }
    label65:
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      bool1 = false;
      break;
      i = 0;
      break label42;
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if ((this.j) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceChange(this.jdField_n_of_type_Int, this.jdField_o_of_type_Int, getWidth(), getHeight());
    }
  }
  
  protected boolean b()
  {
    return (this.j) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && ((this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.isFilterWork(90)) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().isSegmentRequired()) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().isVoiceToTextMaterial()));
  }
  
  public void c(int paramInt)
  {
    queueEvent(new EffectsCameraCaptureView.3(this, paramInt));
  }
  
  protected boolean c()
  {
    if (bpnj.a().a()) {}
    do
    {
      do
      {
        return true;
      } while ((this.j) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().isVoiceToTextMaterial()));
      if (this.jdField_w_of_type_Boolean) {
        return false;
      }
      if ((!this.j) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager == null)) {
        break;
      }
    } while (bpnj.a().a(this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getAllActiveFilters()) >= bpnj.a().a());
    return false;
    return false;
  }
  
  public int d()
  {
    int i1 = 0;
    int i = i1;
    if (this.j)
    {
      i = i1;
      if (this.q)
      {
        i = i1;
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) {
          i = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().getPtuBeautyLevel();
        }
      }
    }
    return i;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bbix.c(paramBoolean);
  }
  
  public boolean d()
  {
    return a() != null;
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bbix.b(paramBoolean);
  }
  
  public boolean e()
  {
    return this.x;
  }
  
  public int getCameraID()
  {
    return a();
  }
  
  public void j()
  {
    if (d())
    {
      r();
      alpt.a("", "0X80083BA", bogm.b);
    }
    v();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().startRecord();
      a(this.l, this.m, this.jdField_o_of_type_Boolean, this.p, this.A);
    }
    super.j();
  }
  
  protected void m()
  {
    super.m();
    ThreadManager.excute(new EffectsCameraCaptureView.1(this), 64, null, false);
  }
  
  public void n()
  {
    super.n();
    if (QLog.isColorLevel()) {
      QLog.d("EffectsCameraCaptureView", 2, "onSurfaceDestroy " + Thread.currentThread().getName() + " mFilterProcessInited=" + this.j);
    }
    if (jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager == this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager) {
      jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
    }
    if (this.j)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
      }
      if (this.jdField_a_of_type_Bbiy != null) {
        this.jdField_a_of_type_Bbiy.a();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
      this.j = false;
    }
  }
  
  protected void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      this.C = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().getShookHeadCount();
      if (QLog.isColorLevel()) {
        QLog.i("EffectsCameraCaptureView", 2, "onMediaCodecStopRecord shookHeadCount:" + this.C);
      }
    }
  }
  
  public void onAudioFrames(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    short[] arrayOfShort = a(paramArrayOfByte);
    double d1 = 0.0D;
    int i = 0;
    while (i < arrayOfShort.length)
    {
      d1 += arrayOfShort[i] * arrayOfShort[i];
      i += 1;
    }
    d1 = Math.log10(d1 / arrayOfShort.length);
    if (this.jdField_a_of_type_Bbiv != null) {
      this.jdField_a_of_type_Bbiv.a(d1 * 10.0D);
    }
    this.jdField_a_of_type_Bbge.a(paramArrayOfByte, paramInt1, paramInt2);
    this.jdField_a_of_type_Bprj.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void onAudioInit() {}
  
  public void onAudioUnInit() {}
  
  public void onPause()
  {
    super.onPause();
    if ((this.j) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null))
    {
      VideoPrefsUtil.setMaterialMute(true);
      queueEvent(new EffectsCameraCaptureView.6(this));
    }
  }
  
  public void onResume()
  {
    super.onResume();
    VideoPrefsUtil.setMaterialMute(this.u);
    if ((this.j) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)) {
      queueEvent(new EffectsCameraCaptureView.5(this));
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    super.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
    if (QLog.isColorLevel()) {
      QLog.d("EffectsCameraCaptureView", 2, "onSurfaceChanged " + Thread.currentThread().getName() + " mFilterProcessInited=" + this.j);
    }
    if (this.j)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceChange(this.jdField_n_of_type_Int, this.jdField_o_of_type_Int, getWidth(), getHeight());
      }
      if (this.jdField_a_of_type_JavaLangString != null) {
        setFaceEffect(this.jdField_a_of_type_JavaLangString);
      }
      if (this.B != 0) {
        setBeauty(this.B);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
      {
        paramGL10 = new CopyOnWriteArrayList();
        paramGL10.addAll(this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().getCurrentAVFilterIdList());
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setFilterEffectList(paramGL10);
      }
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    super.onSurfaceCreated(paramGL10, paramEGLConfig);
    if (QLog.isColorLevel()) {
      QLog.d("EffectsCameraCaptureView", 2, "onSurfaceCreated " + Thread.currentThread().getName() + " mFilterProcessInited=" + this.j);
    }
    if (this.j) {
      t();
    }
  }
  
  public void q()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && (d()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().isRunningMovieFilter()) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().playMovie(null, null, false, null, 0.0F, 0.0F, 0.0F, 0.0F);
      }
      if (this.jdField_a_of_type_Bbix != null) {
        this.jdField_a_of_type_Bbix.a(null, null);
      }
    }
  }
  
  public void r()
  {
    MovieMaterial localMovieMaterial = a();
    if (QLog.isColorLevel()) {
      QLog.d("EffectsCameraCaptureView", 2, "playMovieFilter, movieMaterial = " + localMovieMaterial);
    }
    if ((localMovieMaterial == null) || (!this.jdField_b_of_type_Boolean)) {
      q();
    }
    while (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager == null) {
      return;
    }
    if (localMovieMaterial.isTouchable) {
      if (!TextUtils.isEmpty(localMovieMaterial.atmosphereName)) {
        if (!FileUtils.fileExistsAndNotEmpty(localMovieMaterial.atmosphereVideoPath)) {
          break label367;
        }
      }
    }
    label367:
    for (Object localObject = new File(localMovieMaterial.atmosphereVideoPath);; localObject = null)
    {
      if (FileUtils.fileExistsAndNotEmpty(localMovieMaterial.atmosphereAudioPath)) {}
      for (File localFile = new File(localMovieMaterial.atmosphereAudioPath);; localFile = null)
      {
        FilterBusinessOperation localFilterBusinessOperation;
        String str;
        if (localObject != null)
        {
          this.jdField_a_of_type_Bbix.a(null, null);
          localFilterBusinessOperation = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation();
          str = ((File)localObject).getAbsolutePath();
          if (localFile == null)
          {
            localObject = "";
            localFilterBusinessOperation.playMovie(str, (String)localObject, localMovieMaterial.loopAtmosphere, null, 0.0F, 0.0F, 0.0F, 0.0F);
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_Bbix.a(localMovieMaterial.hintsContent, localMovieMaterial.hintImagePath);
          return;
          localObject = localFile.getAbsolutePath();
          break;
          this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().playMovie(null, null, false, null, 0.0F, 0.0F, 0.0F, 0.0F);
          continue;
          this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().playMovie(null, null, false, null, 0.0F, 0.0F, 0.0F, 0.0F);
        }
        if (FileUtils.fileExists(localMovieMaterial.doodleVideoPath)) {}
        for (localObject = new File(localMovieMaterial.doodleVideoPath);; localObject = null)
        {
          if (FileUtils.fileExists(localMovieMaterial.doodleAudioPath)) {}
          for (localFile = new File(localMovieMaterial.doodleAudioPath); localObject != null; localFile = null)
          {
            this.jdField_a_of_type_Bbix.a(null, null);
            localFilterBusinessOperation = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation();
            str = ((File)localObject).getAbsolutePath();
            if (localFile == null) {}
            for (localObject = "";; localObject = localFile.getAbsolutePath())
            {
              localFilterBusinessOperation.playMovie(str, (String)localObject, localMovieMaterial.loopDoodle, null, 0.0F, 0.0F, 0.0F, 0.0F);
              return;
            }
          }
          break;
        }
      }
    }
  }
  
  public void s()
  {
    if ((this.jdField_a_of_type_Bbix != null) && (d())) {
      this.jdField_a_of_type_Bbix.a(null, null);
    }
  }
  
  public void setBeauty(int paramInt)
  {
    if ((this.j) && (this.q) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().updatePtuBeautyFilter(paramInt);
    }
    this.B = paramInt;
  }
  
  public void setBeauty(int[] paramArrayOfInt)
  {
    if ((this.j) && (this.q)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().updatePtuBeautyFilter(paramArrayOfInt[0]);
    }
    this.B = paramArrayOfInt[0];
  }
  
  public void setBeautyEnable(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public void setCaptureRequest(bbiw parambbiw)
  {
    this.jdField_a_of_type_Bbiw = parambbiw;
  }
  
  public void setDanceFilterEventHandler(QQDanceEventHandler paramQQDanceEventHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler = paramQQDanceEventHandler;
  }
  
  public void setEffectMute(boolean paramBoolean)
  {
    this.u = paramBoolean;
    if ((this.j) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setEffectMute(this.u);
    }
  }
  
  public void setFaceEffect(String paramString) {}
  
  public void setFaceEffectEnable(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  public void setFaceEffectListener(bbix parambbix)
  {
    this.jdField_a_of_type_Bbix = parambbix;
  }
  
  public void setFilter(FilterCategoryItem paramFilterCategoryItem)
  {
    if ((this.j) && (this.s) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null))
    {
      FilterCategoryItem localFilterCategoryItem = null;
      if (paramFilterCategoryItem != null)
      {
        paramFilterCategoryItem = paramFilterCategoryItem.a();
        localFilterCategoryItem = paramFilterCategoryItem;
        if (a(paramFilterCategoryItem))
        {
          u();
          localFilterCategoryItem = paramFilterCategoryItem;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setFilterEffect(localFilterCategoryItem);
    }
  }
  
  public void setFilterEnable(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public void setFiltersChainListener(bbiy parambbiy)
  {
    this.jdField_a_of_type_Bbiy = parambbiy;
  }
  
  public void setHasStoryWaterMark(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public void setIntercepPreviewCheck(boolean paramBoolean)
  {
    this.jdField_w_of_type_Boolean = paramBoolean;
  }
  
  public void setMovieEffect(String paramString)
  {
    if ((this.j) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null))
    {
      if (!FileUtils.fileExistsAndNotEmpty(paramString))
      {
        q();
        a(null);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setMovieMaterial(null);
      }
    }
    else {
      return;
    }
    MovieMaterial localMovieMaterial = QQTemplateParser.parseMovieMaterial(paramString, "params");
    if (localMovieMaterial == null)
    {
      QLog.e("PtvFilterUtils", 2, "setMovieFilter parseMovieMaterial params.json failed");
      return;
    }
    if (!TextUtils.isEmpty(localMovieMaterial.atmosphereName))
    {
      localMovieMaterial.atmosphereVideoPath = (paramString + File.separator + localMovieMaterial.atmosphereName + ".mp4");
      localMovieMaterial.atmosphereAudioPath = (paramString + File.separator + localMovieMaterial.atmosphereName + ".mp3");
    }
    if (!TextUtils.isEmpty(localMovieMaterial.doodleName))
    {
      localMovieMaterial.doodleVideoPath = (paramString + File.separator + localMovieMaterial.doodleName + ".mp4");
      localMovieMaterial.doodleAudioPath = (paramString + File.separator + localMovieMaterial.doodleName + ".mp3");
    }
    if (!TextUtils.isEmpty(localMovieMaterial.hintsImageName)) {
      localMovieMaterial.hintImagePath = (paramString + File.separator + localMovieMaterial.hintsImageName + ".png");
    }
    a(localMovieMaterial);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setMovieMaterial(localMovieMaterial);
    r();
  }
  
  public void setSharpFaceEnable(boolean paramBoolean)
  {
    this.k = paramBoolean;
    if (this.k) {
      com.tencent.mobileqq.shortvideo.ptvfilter.QQSharpFaceFilter.sSharpFaceLevel = AdvancedProviderView.c();
    }
  }
  
  public void setUpCosmeticsAlpha(int paramInt)
  {
    queueEvent(new EffectsCameraCaptureView.4(this, paramInt));
  }
  
  public void t()
  {
    if (!this.j)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EffectsCameraCaptureView", 2, "QQFilterRenderManager initQQFilterManger");
      }
      this.t = bbhm.a(true);
      bnrh.d("EffectsCameraCaptureView", "initQQFilterManger: soLoaded = " + this.t);
      Object localObject = new QQFilterRenderManager();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = ((QQFilterRenderManager)localObject);
      jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = (QQFilterRenderManager)localObject;
      localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getChainBuilder();
      ((QQFilterRenderManager.ChainBuilder)localObject).setUseSort(false);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(10, null);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(25, null);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(186, null);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(40, null);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(70, null);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(80, null);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(90, null);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(100, null);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(184, null);
      if (this.jdField_a_of_type_Bbiy != null) {
        this.jdField_a_of_type_Bbiy.a((QQFilterRenderManager.ChainBuilder)localObject);
      }
      if (this.t) {
        ((QQFilterRenderManager.ChainBuilder)localObject).commit();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.cameraInterFace = this;
      LogUtils.setEnable(false);
      if (this.t) {
        AEModule.updateDeviceAttr(true);
      }
      VideoMemoryManager.getInstance().setForceLoadFromSdCard(true);
    }
    queueEvent(new EffectsCameraCaptureView.2(this));
  }
  
  public void u()
  {
    this.jdField_a_of_type_Bbix.a();
  }
  
  public void v()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().resetShookHeadCount();
      this.C = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView
 * JD-Core Version:    0.7.0.1
 */