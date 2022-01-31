package com.tencent.mobileqq.richmedia.capture.view;

import ahlx;
import ahly;
import ahlz;
import ahma;
import ahmb;
import ahmd;
import ahme;
import ahmf;
import ahmg;
import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLES20;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.richmedia.subtitles.AudioTranslator;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richmedia.capture.util.ReportBadCase;
import com.tencent.mobileqq.shortvideo.dancegame.DanceGameVideoManager;
import com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils;
import com.tencent.mobileqq.shortvideo.filter.QQDanceEventHandler;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.CustomSize;
import com.tencent.mobileqq.shortvideo.ptvfilter.GroupVideoFilterList;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.MovieMaterial;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQVideoMaterial;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.TemplateParser;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SvEffectSdkInitor;
import com.tencent.ttpic.QQLogUtils;
import com.tencent.ttpic.VideoModule;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import com.tencent.ttpic.util.VideoPrefsUtil;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;
import java.io.File;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;

@TargetApi(17)
public class EffectsCameraCaptureView
  extends CameraCaptureView
{
  private static QQFilterRenderManager jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  private float jdField_a_of_type_Float = -1.0F;
  private EffectsCameraCaptureView.EffectListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener;
  private EffectsCameraCaptureView.MaterialStatusRecord jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$MaterialStatusRecord = new EffectsCameraCaptureView.MaterialStatusRecord();
  private QQDanceEventHandler jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler;
  public QQFilterRenderManager a;
  private GroupVideoFilterList jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGroupVideoFilterList;
  private String jdField_a_of_type_JavaLangString;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  public boolean h;
  public boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private int jdField_o_of_type_Int;
  private boolean jdField_o_of_type_Boolean = true;
  private int jdField_p_of_type_Int;
  private boolean jdField_p_of_type_Boolean = true;
  private int jdField_q_of_type_Int;
  private boolean jdField_q_of_type_Boolean = true;
  private int jdField_r_of_type_Int;
  private boolean jdField_r_of_type_Boolean;
  private int jdField_s_of_type_Int;
  private boolean jdField_s_of_type_Boolean;
  private boolean t;
  private boolean u;
  
  static
  {
    SvEffectSdkInitor.a();
    VideoModule.init(BaseApplicationImpl.getContext());
    VideoPrefsUtil.init(BaseApplicationImpl.getContext());
    QQLogUtils.setEnable(QLog.isColorLevel());
    BadcaseReportUtils.a(new ReportBadCase());
  }
  
  public EffectsCameraCaptureView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public EffectsCameraCaptureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
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
    QIMPtvTemplateManager localQIMPtvTemplateManager = (QIMPtvTemplateManager)QIMManager.a(3);
    if (localQIMPtvTemplateManager != null) {
      return localQIMPtvTemplateManager.a();
    }
    return null;
  }
  
  private String a(int paramInt)
  {
    if (paramInt == VideoMaterialUtil.TRIGGER_TYPE.MOUTH_OPEN.value) {
      return "张开你的嘴";
    }
    if (paramInt == VideoMaterialUtil.TRIGGER_TYPE.EYEBROWS_RAISE.value) {
      return "挑动你的眉毛";
    }
    if (paramInt == VideoMaterialUtil.TRIGGER_TYPE.BLINK.value) {
      return "眨眨你的眼睛";
    }
    if (paramInt == VideoMaterialUtil.TRIGGER_TYPE.HEAD_SHAKE.value) {
      return "摇一摇你的头";
    }
    if (paramInt == VideoMaterialUtil.TRIGGER_TYPE.KISS.value) {
      return "嘟起你的嘴";
    }
    if (paramInt == VideoMaterialUtil.TRIGGER_TYPE.HEAD_NOD.value) {
      return "点一点你的头";
    }
    return null;
  }
  
  private void a(MovieMaterial paramMovieMaterial)
  {
    QIMPtvTemplateManager localQIMPtvTemplateManager = (QIMPtvTemplateManager)QIMManager.a(3);
    if (localQIMPtvTemplateManager != null) {
      localQIMPtvTemplateManager.a(paramMovieMaterial);
    }
  }
  
  private void a(QQVideoMaterial paramQQVideoMaterial)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener.a(paramQQVideoMaterial);
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt)
  {
    this.j = paramBoolean1;
    this.k = paramBoolean2;
    this.m = paramBoolean3;
    this.jdField_n_of_type_Boolean = paramBoolean4;
    this.jdField_o_of_type_Int = 0;
    this.jdField_p_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
    }
  }
  
  private boolean a(VideoMaterial paramVideoMaterial)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramVideoMaterial != null)
    {
      bool1 = bool2;
      if (paramVideoMaterial.getShaderType() == 2000) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public int a(int paramInt)
  {
    int i1 = paramInt;
    QQFilterRenderManager localQQFilterRenderManager;
    boolean bool;
    if (this.h)
    {
      i1 = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
      {
        localQQFilterRenderManager = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
        GLES20.glViewport(0, 0, this.f, this.g);
        localQQFilterRenderManager.b("key_orientation_degree", String.valueOf(this.jdField_n_of_type_Int));
        if (a() != 1) {
          break label280;
        }
        bool = true;
        localQQFilterRenderManager.b("key_front_camera", String.valueOf(bool));
        localQQFilterRenderManager.b("key_draw_screen", String.valueOf(true));
        localQQFilterRenderManager.b("key_enable_beauty", String.valueOf(this.jdField_o_of_type_Boolean));
        localQQFilterRenderManager.b("key_enable_filter", String.valueOf(this.jdField_q_of_type_Boolean));
        localQQFilterRenderManager.b("key_enable_ptv", String.valueOf(this.jdField_p_of_type_Boolean));
        localQQFilterRenderManager.b("key_width", String.valueOf(this.f));
        localQQFilterRenderManager.b("key_height", String.valueOf(this.g));
        paramInt = localQQFilterRenderManager.a(paramInt);
        if (this.jdField_p_of_type_Int != this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$MaterialStatusRecord.jdField_a_of_type_Int)
        {
          this.k = false;
          this.j = false;
          this.m = false;
          this.jdField_n_of_type_Boolean = false;
          this.jdField_o_of_type_Int = 0;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$MaterialStatusRecord.jdField_a_of_type_Int != 0) {
          break label360;
        }
        if ((!localQQFilterRenderManager.b) || (localQQFilterRenderManager.jdField_a_of_type_Boolean) || (!this.k)) {
          break label300;
        }
        if (this.jdField_o_of_type_Int < 4) {
          break label285;
        }
        a(localQQFilterRenderManager.b, localQQFilterRenderManager.jdField_a_of_type_Boolean, false, false, 0);
        i1 = paramInt;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener.a(System.currentTimeMillis());
      return i1;
      label280:
      bool = false;
      break;
      label285:
      this.jdField_o_of_type_Int += 1;
      i1 = paramInt;
      continue;
      label300:
      if ((this.j == localQQFilterRenderManager.b) && (this.k == localQQFilterRenderManager.jdField_a_of_type_Boolean))
      {
        i1 = paramInt;
        if (!this.l) {}
      }
      else
      {
        this.l = false;
        a(localQQFilterRenderManager.b, localQQFilterRenderManager.jdField_a_of_type_Boolean, false, false, 0);
        i1 = paramInt;
        continue;
        label360:
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$MaterialStatusRecord.jdField_a_of_type_Int == 1)
        {
          if ((localQQFilterRenderManager.jdField_c_of_type_Boolean) && (!localQQFilterRenderManager.jdField_d_of_type_Boolean) && (this.jdField_n_of_type_Boolean))
          {
            a(false, false, localQQFilterRenderManager.jdField_c_of_type_Boolean, localQQFilterRenderManager.jdField_d_of_type_Boolean, 1);
            i1 = paramInt;
          }
          else if ((this.m == localQQFilterRenderManager.jdField_c_of_type_Boolean) && (this.jdField_n_of_type_Boolean == localQQFilterRenderManager.jdField_d_of_type_Boolean))
          {
            i1 = paramInt;
            if (!this.l) {}
          }
          else
          {
            this.l = false;
            a(false, false, localQQFilterRenderManager.jdField_c_of_type_Boolean, localQQFilterRenderManager.jdField_d_of_type_Boolean, 1);
            i1 = paramInt;
          }
        }
        else
        {
          i1 = paramInt;
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$MaterialStatusRecord.jdField_a_of_type_Int == 2)
          {
            i1 = paramInt;
            if (localQQFilterRenderManager.b)
            {
              i1 = paramInt;
              if (localQQFilterRenderManager.jdField_c_of_type_Boolean) {
                if ((localQQFilterRenderManager.jdField_a_of_type_Boolean == this.k) && (localQQFilterRenderManager.jdField_d_of_type_Boolean == this.jdField_n_of_type_Boolean))
                {
                  i1 = paramInt;
                  if (!this.l) {}
                }
                else
                {
                  this.l = false;
                  a(localQQFilterRenderManager.b, localQQFilterRenderManager.jdField_a_of_type_Boolean, localQQFilterRenderManager.jdField_c_of_type_Boolean, localQQFilterRenderManager.jdField_d_of_type_Boolean, 2);
                  i1 = paramInt;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("EffectsCameraCaptureView", 2, "onDrawFrameAfterCamera mDetectedFace:" + localQQFilterRenderManager.jdField_a_of_type_Boolean + "mFilterProcess.mDetectedGesture:" + localQQFilterRenderManager.jdField_d_of_type_Boolean);
                    i1 = paramInt;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.h) && (this.i))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.c(paramInt);
      }
    }
    else {
      return;
    }
    QQFilterRenderManager localQQFilterRenderManager = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
    if (paramInt >= 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localQQFilterRenderManager.a(paramBoolean);
      return;
    }
  }
  
  protected void a(CameraControl.CustomSize paramCustomSize)
  {
    super.a(paramCustomSize);
    queueEvent(new ahly(this));
  }
  
  public void a(boolean paramBoolean, CommonPatternInfo paramCommonPatternInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler.j();
    }
    super.queueEvent(new ahlx(this, paramBoolean, paramCommonPatternInfo));
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (AudioTranslator.a().a()) {
      AudioTranslator.a().a(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  protected boolean a()
  {
    boolean bool3 = false;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) {}
    for (boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.c();; bool1 = false)
    {
      boolean bool2 = bool3;
      if (CameraUtils.a())
      {
        bool2 = bool3;
        if (!bool1) {
          bool2 = true;
        }
      }
      return bool2;
    }
  }
  
  public boolean a(CommonPatternInfo paramCommonPatternInfo)
  {
    CommonPatternInfo localCommonPatternInfo = paramCommonPatternInfo;
    if (paramCommonPatternInfo == null) {
      localCommonPatternInfo = CommonPatternInfo.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener);
    }
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener instanceof QIMEffectCameraCaptureUnit;
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && (localCommonPatternInfo != null) && (localCommonPatternInfo.jdField_a_of_type_Boolean) && (DanceGameVideoManager.a(3, localCommonPatternInfo.jdField_a_of_type_Int, bool2)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler == null) {
        break label226;
      }
      paramCommonPatternInfo = localCommonPatternInfo.e + localCommonPatternInfo.jdField_b_of_type_JavaLangString + File.separator;
    }
    label165:
    label226:
    for (boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler.a(true, paramCommonPatternInfo);; bool1 = false)
    {
      if (bool1)
      {
        if (!DanceGameVideoManager.a(1, localCommonPatternInfo.jdField_a_of_type_Int, bool2)) {
          break label165;
        }
        BadcaseReportUtils.jdField_b_of_type_JavaLangString = localCommonPatternInfo.jdField_a_of_type_JavaLangString;
        BadcaseReportUtils.jdField_a_of_type_JavaLangString = localCommonPatternInfo.jdField_b_of_type_JavaLangString;
        ReportBadCase.a(this.u);
        a(false, localCommonPatternInfo);
        DanceGameVideoManager.a().a(true);
      }
      while (!DanceGameVideoManager.a(2, localCommonPatternInfo.jdField_a_of_type_Int, bool2)) {
        return true;
      }
      a(true, localCommonPatternInfo);
      DanceGameVideoManager.a().a(true);
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler.a(false, null);
      }
      y();
      DanceGameVideoManager.a().a(false);
      return false;
    }
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGroupVideoFilterList != null) {
      return this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGroupVideoFilterList.a();
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public int c()
  {
    int i2 = 0;
    int i1 = i2;
    if (this.h)
    {
      i1 = i2;
      if (this.jdField_o_of_type_Boolean)
      {
        i1 = i2;
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) {
          i1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.c();
        }
      }
    }
    return i1;
  }
  
  public boolean c()
  {
    return a() != null;
  }
  
  public int d()
  {
    return this.jdField_s_of_type_Int;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener.d(paramBoolean);
  }
  
  public boolean d()
  {
    return this.t;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null) {
      AudioTranslator.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener.c(paramBoolean);
  }
  
  public void f()
  {
    AudioTranslator.a().a(null);
  }
  
  public void k()
  {
    if (c())
    {
      s();
      FlowCameraMqqAction.a("", "0X80083BA", QIMPtvTemplateAdapter.jdField_b_of_type_JavaLangString);
    }
    z();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.p();
      a(this.j, this.k, this.m, this.jdField_n_of_type_Boolean, this.jdField_p_of_type_Int);
    }
    super.k();
  }
  
  protected void n()
  {
    super.n();
    ThreadManager.postImmediately(new ahlz(this), null, false);
  }
  
  public void o()
  {
    super.o();
    if (QLog.isColorLevel()) {
      QLog.d("EffectsCameraCaptureView", 2, "onSurfaceDestroy " + Thread.currentThread().getName() + " mFilterProcessInited=" + this.h);
    }
    if (jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager == this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager) {
      jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
    }
    if (this.h)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.o();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
      this.h = false;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.h) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null))
    {
      VideoPrefsUtil.setMaterialMute(true);
      queueEvent(new ahme(this));
    }
  }
  
  public void onResume()
  {
    super.onResume();
    VideoPrefsUtil.setMaterialMute(this.jdField_s_of_type_Boolean);
    if ((this.h) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)) {
      queueEvent(new ahmd(this));
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    super.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
    if (QLog.isColorLevel()) {
      QLog.d("EffectsCameraCaptureView", 2, "onSurfaceChanged " + Thread.currentThread().getName() + " mFilterProcessInited=" + this.h);
    }
    if (this.h)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.c(this.f, this.g, getWidth(), getHeight());
      }
      if (this.jdField_a_of_type_JavaLangString != null) {
        setFaceEffect(this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    super.onSurfaceCreated(paramGL10, paramEGLConfig);
    if (QLog.isColorLevel()) {
      QLog.d("EffectsCameraCaptureView", 2, "onSurfaceCreated " + Thread.currentThread().getName() + " mFilterProcessInited=" + this.h);
    }
    if (this.h) {
      u();
    }
    VideoModule.initExtensionValues();
  }
  
  protected void p()
  {
    super.p();
    s();
  }
  
  protected void q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      this.jdField_s_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.d();
      if (QLog.isColorLevel()) {
        QLog.i("EffectsCameraCaptureView", 2, "onMediaCodecStopRecord shookHeadCount:" + this.jdField_s_of_type_Int);
      }
    }
  }
  
  public void r()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && (c()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.b()) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(null, null, false, null, 0.0F, 0.0F, 0.0F, 0.0F);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener.a(null, null);
      }
    }
  }
  
  public void s()
  {
    MovieMaterial localMovieMaterial = a();
    if (QLog.isColorLevel()) {
      QLog.d("EffectsCameraCaptureView", 2, "playMovieFilter, movieMaterial = " + localMovieMaterial);
    }
    if ((localMovieMaterial == null) || (!this.jdField_a_of_type_Boolean)) {
      r();
    }
    while (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager == null) {
      return;
    }
    if (localMovieMaterial.jdField_a_of_type_Boolean) {
      if (!TextUtils.isEmpty(localMovieMaterial.jdField_b_of_type_JavaLangString)) {
        if (!FileUtils.b(localMovieMaterial.g)) {
          break label355;
        }
      }
    }
    label355:
    for (Object localObject = new File(localMovieMaterial.g);; localObject = null)
    {
      if (FileUtils.b(localMovieMaterial.h)) {}
      for (File localFile = new File(localMovieMaterial.h);; localFile = null)
      {
        QQFilterRenderManager localQQFilterRenderManager;
        String str;
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener.a(null, null);
          localQQFilterRenderManager = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
          str = ((File)localObject).getAbsolutePath();
          if (localFile == null)
          {
            localObject = "";
            localQQFilterRenderManager.a(str, (String)localObject, localMovieMaterial.jdField_c_of_type_Boolean, null, 0.0F, 0.0F, 0.0F, 0.0F);
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener.a(localMovieMaterial.jdField_d_of_type_JavaLangString, localMovieMaterial.i);
          return;
          localObject = localFile.getAbsolutePath();
          break;
          this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(null, null, false, null, 0.0F, 0.0F, 0.0F, 0.0F);
          continue;
          this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(null, null, false, null, 0.0F, 0.0F, 0.0F, 0.0F);
        }
        if (FileUtils.a(localMovieMaterial.e)) {}
        for (localObject = new File(localMovieMaterial.e);; localObject = null)
        {
          if (FileUtils.a(localMovieMaterial.f)) {}
          for (localFile = new File(localMovieMaterial.f); localObject != null; localFile = null)
          {
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener.a(null, null);
            localQQFilterRenderManager = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
            str = ((File)localObject).getAbsolutePath();
            if (localFile == null) {}
            for (localObject = "";; localObject = localFile.getAbsolutePath())
            {
              localQQFilterRenderManager.a(str, (String)localObject, localMovieMaterial.jdField_d_of_type_Boolean, null, 0.0F, 0.0F, 0.0F, 0.0F);
              return;
            }
          }
          break;
        }
      }
    }
  }
  
  public void setBeauty(int paramInt)
  {
    if ((this.h) && (this.jdField_o_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.b(paramInt);
    }
    this.jdField_q_of_type_Int = paramInt;
  }
  
  public void setBeauty(int[] paramArrayOfInt)
  {
    if ((this.h) && (this.jdField_o_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.b(paramArrayOfInt[0]);
    }
    this.jdField_q_of_type_Int = paramArrayOfInt[0];
  }
  
  public void setBeautyEnable(boolean paramBoolean)
  {
    this.jdField_o_of_type_Boolean = paramBoolean;
  }
  
  public void setDanceFilterEventHandler(QQDanceEventHandler paramQQDanceEventHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler = paramQQDanceEventHandler;
  }
  
  public void setEffectMute(boolean paramBoolean)
  {
    this.jdField_s_of_type_Boolean = paramBoolean;
    if ((this.h) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.c(this.jdField_s_of_type_Boolean);
    }
  }
  
  public void setEnableBadCaseReport(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public void setFaceEffect(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (b()) {}
    while ((!this.h) || (!this.jdField_p_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGroupVideoFilterList = null;
    ThreadManager.getUIHandler().post(new ahmb(this, paramString));
  }
  
  public void setFaceEffectEnable(boolean paramBoolean)
  {
    this.jdField_p_of_type_Boolean = paramBoolean;
  }
  
  public void setFaceEffectListener(EffectsCameraCaptureView.EffectListener paramEffectListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener = paramEffectListener;
  }
  
  public void setFilter(FilterCategoryItem paramFilterCategoryItem)
  {
    QQFilterRenderManager localQQFilterRenderManager;
    if ((this.h) && (this.jdField_q_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null))
    {
      localQQFilterRenderManager = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
      if (paramFilterCategoryItem == null) {
        break label41;
      }
    }
    label41:
    for (paramFilterCategoryItem = paramFilterCategoryItem.a();; paramFilterCategoryItem = null)
    {
      localQQFilterRenderManager.a(paramFilterCategoryItem);
      return;
    }
  }
  
  public void setFilterEnable(boolean paramBoolean)
  {
    this.jdField_q_of_type_Boolean = paramBoolean;
  }
  
  public void setMovieEffect(String paramString)
  {
    if ((this.h) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null))
    {
      if (!FileUtils.b(paramString))
      {
        r();
        a(null);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(null);
        return;
      }
      MovieMaterial localMovieMaterial = TemplateParser.a(paramString, "params");
      if (localMovieMaterial == null)
      {
        QLog.e("PtvFilterUtils", 2, "setMovieFilter parseMovieMaterial params.json failed");
        return;
      }
      if (!TextUtils.isEmpty(localMovieMaterial.jdField_b_of_type_JavaLangString))
      {
        localMovieMaterial.g = (paramString + File.separator + localMovieMaterial.jdField_b_of_type_JavaLangString + ".mp4");
        localMovieMaterial.h = (paramString + File.separator + localMovieMaterial.jdField_b_of_type_JavaLangString + ".mp3");
      }
      if (!TextUtils.isEmpty(localMovieMaterial.jdField_a_of_type_JavaLangString))
      {
        localMovieMaterial.e = (paramString + File.separator + localMovieMaterial.jdField_a_of_type_JavaLangString + ".mp4");
        localMovieMaterial.f = (paramString + File.separator + localMovieMaterial.jdField_a_of_type_JavaLangString + ".mp3");
      }
      if (!TextUtils.isEmpty(localMovieMaterial.jdField_c_of_type_JavaLangString)) {
        localMovieMaterial.i = (paramString + File.separator + localMovieMaterial.jdField_c_of_type_JavaLangString + ".png");
      }
      a(localMovieMaterial);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(localMovieMaterial);
      s();
    }
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void setSharpFaceEnable(boolean paramBoolean)
  {
    this.i = paramBoolean;
    if (this.i) {
      com.tencent.mobileqq.shortvideo.ptvfilter.QQSharpFaceFilter.jdField_a_of_type_Int = AdvancedProviderView.c();
    }
  }
  
  public void t()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener != null) && (c())) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener.a(null, null);
    }
  }
  
  public void u()
  {
    if (!this.h)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EffectsCameraCaptureView", 2, "QQFilterRenderManager initQQFilterManger");
      }
      this.jdField_r_of_type_Boolean = CaptureUtil.b();
      QQFilterRenderManager localQQFilterRenderManager = new QQFilterRenderManager(new int[] { 40, 90, 70, 25, 80, 10, 100, 130, 140 });
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = localQQFilterRenderManager;
      jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = localQQFilterRenderManager;
    }
    queueEvent(new ahma(this));
  }
  
  public void v()
  {
    this.l = true;
  }
  
  public void w()
  {
    if ((this.h) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && (this.jdField_a_of_type_JavaLangString != null)) {
      setFaceEffect(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void x()
  {
    super.queueEvent(new ahmf(this));
  }
  
  public void y()
  {
    super.queueEvent(new ahmg(this));
  }
  
  public void z()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.l();
      this.jdField_s_of_type_Int = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView
 * JD-Core Version:    0.7.0.1
 */