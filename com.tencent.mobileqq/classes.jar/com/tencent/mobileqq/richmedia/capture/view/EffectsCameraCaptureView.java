package com.tencent.mobileqq.richmedia.capture.view;

import ahqr;
import ahqs;
import ahqt;
import ahqv;
import ahqw;
import ahqx;
import ahqy;
import ahqz;
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
import dov.com.tencent.mobileqq.richmedia.capture.util.DovSVParamManager;
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
  private int A;
  private float jdField_a_of_type_Float = -1.0F;
  private EffectsCameraCaptureView.EffectListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener;
  private EffectsCameraCaptureView.MaterialStatusRecord jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$MaterialStatusRecord = new EffectsCameraCaptureView.MaterialStatusRecord();
  private QQDanceEventHandler jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler;
  public QQFilterRenderManager a;
  private GroupVideoFilterList jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGroupVideoFilterList;
  private String jdField_a_of_type_JavaLangString;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  public boolean i;
  public boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p = true;
  private boolean q = true;
  private boolean r = true;
  private boolean s;
  private boolean t;
  private boolean u;
  private boolean v;
  private int w;
  private int x;
  private int y;
  private int z;
  
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
    this.k = paramBoolean1;
    this.l = paramBoolean2;
    this.jdField_n_of_type_Boolean = paramBoolean3;
    this.jdField_o_of_type_Boolean = paramBoolean4;
    this.w = 0;
    this.x = paramInt;
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
    if (this.i)
    {
      i1 = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
      {
        localQQFilterRenderManager = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
        GLES20.glViewport(0, 0, this.jdField_n_of_type_Int, this.jdField_o_of_type_Int);
        localQQFilterRenderManager.b("key_orientation_degree", String.valueOf(this.jdField_v_of_type_Int));
        if (a() != 1) {
          break label281;
        }
        bool = true;
        localQQFilterRenderManager.b("key_front_camera", String.valueOf(bool));
        localQQFilterRenderManager.b("key_draw_screen", String.valueOf(true));
        localQQFilterRenderManager.b("key_enable_beauty", String.valueOf(this.p));
        localQQFilterRenderManager.b("key_enable_filter", String.valueOf(this.r));
        localQQFilterRenderManager.b("key_enable_ptv", String.valueOf(this.q));
        localQQFilterRenderManager.b("key_width", String.valueOf(this.jdField_n_of_type_Int));
        localQQFilterRenderManager.b("key_height", String.valueOf(this.jdField_o_of_type_Int));
        paramInt = localQQFilterRenderManager.a(paramInt);
        if (this.x != this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$MaterialStatusRecord.jdField_a_of_type_Int)
        {
          this.l = false;
          this.k = false;
          this.jdField_n_of_type_Boolean = false;
          this.jdField_o_of_type_Boolean = false;
          this.w = 0;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$MaterialStatusRecord.jdField_a_of_type_Int != 0) {
          break label361;
        }
        if ((!localQQFilterRenderManager.b) || (localQQFilterRenderManager.jdField_a_of_type_Boolean) || (!this.l)) {
          break label301;
        }
        if (this.w < 4) {
          break label286;
        }
        a(localQQFilterRenderManager.b, localQQFilterRenderManager.jdField_a_of_type_Boolean, false, false, 0);
        i1 = paramInt;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener.a(System.currentTimeMillis());
      return i1;
      label281:
      bool = false;
      break;
      label286:
      this.w += 1;
      i1 = paramInt;
      continue;
      label301:
      if ((this.k == localQQFilterRenderManager.b) && (this.l == localQQFilterRenderManager.jdField_a_of_type_Boolean))
      {
        i1 = paramInt;
        if (!this.m) {}
      }
      else
      {
        this.m = false;
        a(localQQFilterRenderManager.b, localQQFilterRenderManager.jdField_a_of_type_Boolean, false, false, 0);
        i1 = paramInt;
        continue;
        label361:
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$MaterialStatusRecord.jdField_a_of_type_Int == 1)
        {
          if ((localQQFilterRenderManager.jdField_c_of_type_Boolean) && (!localQQFilterRenderManager.jdField_d_of_type_Boolean) && (this.jdField_o_of_type_Boolean))
          {
            a(false, false, localQQFilterRenderManager.jdField_c_of_type_Boolean, localQQFilterRenderManager.jdField_d_of_type_Boolean, 1);
            i1 = paramInt;
          }
          else if ((this.jdField_n_of_type_Boolean == localQQFilterRenderManager.jdField_c_of_type_Boolean) && (this.jdField_o_of_type_Boolean == localQQFilterRenderManager.jdField_d_of_type_Boolean))
          {
            i1 = paramInt;
            if (!this.m) {}
          }
          else
          {
            this.m = false;
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
                if ((localQQFilterRenderManager.jdField_a_of_type_Boolean == this.l) && (localQQFilterRenderManager.jdField_d_of_type_Boolean == this.jdField_o_of_type_Boolean))
                {
                  i1 = paramInt;
                  if (!this.m) {}
                }
                else
                {
                  this.m = false;
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
    if ((this.i) && (this.j))
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
  
  public void a(boolean paramBoolean, CommonPatternInfo paramCommonPatternInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler.j();
    }
    super.queueEvent(new ahqz(this, paramBoolean, paramCommonPatternInfo));
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
        ReportBadCase.a(this.jdField_v_of_type_Boolean);
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
      x();
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
    if (this.i)
    {
      i1 = i2;
      if (this.p)
      {
        i1 = i2;
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) {
          i1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.c();
        }
      }
    }
    return i1;
  }
  
  protected boolean c()
  {
    return (this.i) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(90));
  }
  
  public int d()
  {
    return this.A;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null) {
      AudioTranslator.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
    }
  }
  
  protected void d(boolean paramBoolean)
  {
    super.d(paramBoolean);
    if ((this.i) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.c(this.jdField_n_of_type_Int, this.jdField_o_of_type_Int, getWidth(), getHeight());
    }
  }
  
  protected boolean d()
  {
    if (DovSVParamManager.a().a()) {}
    do
    {
      return true;
      if ((!this.i) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager == null)) {
        break;
      }
    } while (DovSVParamManager.a().a(this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.b()) >= DovSVParamManager.a().a());
    return false;
    return false;
  }
  
  public void e()
  {
    AudioTranslator.a().a(null);
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener.d(paramBoolean);
  }
  
  public boolean e()
  {
    return a() != null;
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener.c(paramBoolean);
  }
  
  public boolean f()
  {
    return this.u;
  }
  
  public void j()
  {
    if (e())
    {
      r();
      FlowCameraMqqAction.a("", "0X80083BA", QIMPtvTemplateAdapter.jdField_b_of_type_JavaLangString);
    }
    y();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.r();
      a(this.k, this.l, this.jdField_n_of_type_Boolean, this.jdField_o_of_type_Boolean, this.x);
    }
    super.j();
  }
  
  protected void m()
  {
    super.m();
    ThreadManager.postImmediately(new ahqr(this), null, false);
  }
  
  public void n()
  {
    super.n();
    if (QLog.isColorLevel()) {
      QLog.d("EffectsCameraCaptureView", 2, "onSurfaceDestroy " + Thread.currentThread().getName() + " mFilterProcessInited=" + this.i);
    }
    if (jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager == this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager) {
      jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
    }
    if (this.i)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.q();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
      this.i = false;
    }
  }
  
  protected void o()
  {
    super.o();
    r();
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.i) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null))
    {
      VideoPrefsUtil.setMaterialMute(true);
      queueEvent(new ahqw(this));
    }
  }
  
  public void onResume()
  {
    super.onResume();
    VideoPrefsUtil.setMaterialMute(this.t);
    if ((this.i) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)) {
      queueEvent(new ahqv(this));
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    super.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
    if (QLog.isColorLevel()) {
      QLog.d("EffectsCameraCaptureView", 2, "onSurfaceChanged " + Thread.currentThread().getName() + " mFilterProcessInited=" + this.i);
    }
    if (this.i)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.c(this.jdField_n_of_type_Int, this.jdField_o_of_type_Int, getWidth(), getHeight());
      }
      if (this.jdField_a_of_type_JavaLangString != null) {
        setFaceEffect(this.jdField_a_of_type_JavaLangString);
      }
      if (this.y != 0) {
        setBeauty(this.y);
      }
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    super.onSurfaceCreated(paramGL10, paramEGLConfig);
    if (QLog.isColorLevel()) {
      QLog.d("EffectsCameraCaptureView", 2, "onSurfaceCreated " + Thread.currentThread().getName() + " mFilterProcessInited=" + this.i);
    }
    if (this.i) {
      t();
    }
    VideoModule.initExtensionValues();
  }
  
  protected void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      this.A = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.d();
      if (QLog.isColorLevel()) {
        QLog.i("EffectsCameraCaptureView", 2, "onMediaCodecStopRecord shookHeadCount:" + this.A);
      }
    }
  }
  
  public void q()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && (e()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.b()) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(null, null, false, null, 0.0F, 0.0F, 0.0F, 0.0F);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener.a(null, null);
      }
    }
  }
  
  public void r()
  {
    MovieMaterial localMovieMaterial = a();
    if (QLog.isColorLevel()) {
      QLog.d("EffectsCameraCaptureView", 2, "playMovieFilter, movieMaterial = " + localMovieMaterial);
    }
    if ((localMovieMaterial == null) || (!this.jdField_a_of_type_Boolean)) {
      q();
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
  
  public void s()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener != null) && (e())) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener.a(null, null);
    }
  }
  
  public void setBeauty(int paramInt)
  {
    if ((this.i) && (this.p) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.b(paramInt);
    }
    this.y = paramInt;
  }
  
  public void setBeauty(int[] paramArrayOfInt)
  {
    if ((this.i) && (this.p)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.b(paramArrayOfInt[0]);
    }
    this.y = paramArrayOfInt[0];
  }
  
  public void setBeautyEnable(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void setDanceFilterEventHandler(QQDanceEventHandler paramQQDanceEventHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler = paramQQDanceEventHandler;
  }
  
  public void setEffectMute(boolean paramBoolean)
  {
    this.t = paramBoolean;
    if ((this.i) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.c(this.t);
    }
  }
  
  public void setEnableBadCaseReport(boolean paramBoolean)
  {
    this.jdField_v_of_type_Boolean = paramBoolean;
  }
  
  public void setFaceEffect(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (b()) {}
    while ((!this.i) || (!this.q)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGroupVideoFilterList = null;
    ThreadManager.getUIHandler().post(new ahqt(this, paramString));
  }
  
  public void setFaceEffectEnable(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public void setFaceEffectListener(EffectsCameraCaptureView.EffectListener paramEffectListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$EffectListener = paramEffectListener;
  }
  
  public void setFilter(FilterCategoryItem paramFilterCategoryItem)
  {
    QQFilterRenderManager localQQFilterRenderManager;
    if ((this.i) && (this.r) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null))
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
    this.r = paramBoolean;
  }
  
  public void setMovieEffect(String paramString)
  {
    if ((this.i) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null))
    {
      if (!FileUtils.b(paramString))
      {
        q();
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
      r();
    }
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void setSharpFaceEnable(boolean paramBoolean)
  {
    this.j = paramBoolean;
    if (this.j) {
      com.tencent.mobileqq.shortvideo.ptvfilter.QQSharpFaceFilter.jdField_a_of_type_Int = AdvancedProviderView.c();
    }
  }
  
  public void t()
  {
    if (!this.i)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EffectsCameraCaptureView", 2, "QQFilterRenderManager initQQFilterManger");
      }
      this.s = CaptureUtil.b();
      QQFilterRenderManager localQQFilterRenderManager = new QQFilterRenderManager(new int[] { 40, 90, 70, 25, 80, 10, 100, 130, 140 });
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = localQQFilterRenderManager;
      jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = localQQFilterRenderManager;
    }
    queueEvent(new ahqs(this));
  }
  
  public void u()
  {
    this.m = true;
  }
  
  public void v()
  {
    if ((this.i) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && (this.jdField_a_of_type_JavaLangString != null)) {
      setFaceEffect(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void w()
  {
    super.queueEvent(new ahqx(this));
  }
  
  public void x()
  {
    super.queueEvent(new ahqy(this));
  }
  
  public void y()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.l();
      this.A = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView
 * JD-Core Version:    0.7.0.1
 */