package com.tencent.mobileqq.richmedia.capture.view;

import ahub;
import ahyd;
import ajyc;
import amfw;
import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLES20;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import aune;
import avrr;
import avtc;
import avtm;
import avuw;
import avuy;
import avuz;
import avva;
import avvb;
import avvc;
import avvd;
import axgm;
import axho;
import bbdj;
import bflj;
import biht;
import bjae;
import bjan;
import bkup;
import bkyy;
import bkzt;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
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
import com.tencent.mobileqq.shortvideo.ptvfilter.GroupVideoFilterList;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.MovieMaterial;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQTemplateParser;
import com.tencent.mobileqq.shortvideo.util.CameraInterFace;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.initializer.FaceDetectInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;
import xfr;

@TargetApi(17)
public class EffectsCameraCaptureView
  extends CameraCaptureView
  implements CameraInterFace
{
  private static QQFilterRenderManager jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  private int A;
  private int B;
  private int C;
  private int D;
  private avuy jdField_a_of_type_Avuy;
  private avuz jdField_a_of_type_Avuz;
  private avva jdField_a_of_type_Avva;
  private avvb jdField_a_of_type_Avvb;
  private avvc jdField_a_of_type_Avvc;
  private avvd jdField_a_of_type_Avvd = new avvd();
  protected bkzt a;
  private QQDanceEventHandler jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler;
  protected QQFilterRenderManager a;
  private GroupVideoFilterList jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGroupVideoFilterList;
  private String jdField_a_of_type_JavaLangString;
  private String jdField_b_of_type_JavaLangString;
  private long d;
  private long e = ((Long)xfr.a().a("SmartCutPicSpacing", Long.valueOf(500L))).longValue();
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
  private boolean x;
  private boolean y;
  private int jdField_z_of_type_Int;
  private volatile boolean jdField_z_of_type_Boolean;
  
  static
  {
    bflj.a();
    biht.a();
    VideoPrefsUtil.init(BaseApplicationImpl.getContext(), ShortVideoUtils.a());
    BadcaseReportUtils.registerReport(new avtm());
  }
  
  public EffectsCameraCaptureView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Bkzt = new bkzt();
  }
  
  public EffectsCameraCaptureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Bkzt = new bkzt();
  }
  
  private MovieMaterial a()
  {
    bkyy localbkyy = (bkyy)bjae.a(3);
    if (localbkyy != null) {
      return localbkyy.a();
    }
    return null;
  }
  
  private String a(int paramInt)
  {
    if (paramInt == PTFaceAttr.PTExpression.MOUTH_OPEN.value) {
      return ajyc.a(2131703980);
    }
    if (paramInt == PTFaceAttr.PTExpression.EYEBROWS_RAISE.value) {
      return ajyc.a(2131703982);
    }
    if (paramInt == PTFaceAttr.PTExpression.BLINK.value) {
      return ajyc.a(2131703976);
    }
    if (paramInt == PTFaceAttr.PTExpression.HEAD_SHAKE.value) {
      return ajyc.a(2131703981);
    }
    if (paramInt == PTFaceAttr.PTExpression.KISS.value) {
      return ajyc.a(2131703979);
    }
    if (paramInt == PTFaceAttr.PTExpression.HEAD_NOD.value) {
      return ajyc.a(2131703985);
    }
    return null;
  }
  
  private void a(MovieMaterial paramMovieMaterial)
  {
    bkyy localbkyy = (bkyy)bjae.a(3);
    if (localbkyy != null) {
      localbkyy.a(paramMovieMaterial);
    }
  }
  
  private void a(VideoMaterial paramVideoMaterial)
  {
    if (this.jdField_a_of_type_Avva != null) {
      this.jdField_a_of_type_Avva.a(paramVideoMaterial);
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
  
  private boolean a(VideoMaterial paramVideoMaterial)
  {
    boolean bool = true;
    if (paramVideoMaterial != null) {
      bool = paramVideoMaterial.needFaceInfo();
    }
    return bool;
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
  
  public static QQFilterRenderManager b()
  {
    if ((jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager == null) && (QLog.isColorLevel())) {
      QLog.d("EffectsCameraCaptureView", 2, "getCurrentRenderManager null");
    }
    return jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  }
  
  private boolean b(avuw paramavuw)
  {
    this.jdField_z_of_type_Boolean = false;
    if ((paramavuw != null) && (paramavuw.jdField_a_of_type_Int == 20))
    {
      com.tencent.mobileqq.shortvideo.bighead.BigHeadFilter.sGBigHeadModelPath = paramavuw.e + paramavuw.h + File.separator;
      this.jdField_z_of_type_Boolean = true;
    }
    if ((this.jdField_a_of_type_Avva != null) && (this.jdField_a_of_type_Avva.a(this.jdField_z_of_type_Boolean)) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setFilterEffect(null);
    }
    return this.jdField_z_of_type_Boolean;
  }
  
  public void A()
  {
    this.jdField_a_of_type_Avva.b();
  }
  
  public void B()
  {
    if ((this.j) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && (this.jdField_a_of_type_JavaLangString != null)) {
      setFaceEffect(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void C()
  {
    super.queueEvent(new EffectsCameraCaptureView.8(this));
  }
  
  public void D()
  {
    super.queueEvent(new EffectsCameraCaptureView.9(this));
  }
  
  public void E()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().resetShookHeadCount();
      this.D = 0;
    }
  }
  
  public QQFilterRenderManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if ((this.j) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceChange(this.jdField_n_of_type_Int, this.jdField_o_of_type_Int, getWidth(), getHeight());
    }
  }
  
  public void a(boolean paramBoolean, avuw paramavuw)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler.enterSilhouette();
    }
    super.queueEvent(new EffectsCameraCaptureView.10(this, paramBoolean, paramavuw));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt)
  {
    boolean bool2 = false;
    this.l = paramBoolean1;
    this.m = paramBoolean2;
    this.jdField_o_of_type_Boolean = paramBoolean3;
    this.p = paramBoolean4;
    this.jdField_z_of_type_Int = 0;
    this.A = paramInt;
    if (this.jdField_a_of_type_Avva != null)
    {
      avva localavva = this.jdField_a_of_type_Avva;
      boolean bool1 = bool2;
      if (!axgm.a().b())
      {
        bool1 = bool2;
        if (paramBoolean1) {
          bool1 = true;
        }
      }
      localavva.a(bool1, paramBoolean2, paramBoolean3, paramBoolean4);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (ahyd.a().a()) {
      ahyd.a().a(paramArrayOfByte, paramInt1, paramInt2);
    }
    short[] arrayOfShort = a(paramArrayOfByte);
    double d1 = 0.0D;
    int i = 0;
    while (i < arrayOfShort.length)
    {
      d1 += arrayOfShort[i] * arrayOfShort[i];
      i += 1;
    }
    d1 = Math.log10(d1 / arrayOfShort.length);
    if (this.jdField_a_of_type_Avuy != null) {
      this.jdField_a_of_type_Avuy.a(d1 * 10.0D);
    }
    this.jdField_a_of_type_Avrr.a(paramArrayOfByte, paramInt1, paramInt2);
    this.jdField_a_of_type_Bkzt.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  protected boolean a()
  {
    boolean bool2 = true;
    if (this.x) {
      return false;
    }
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      bool1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.hasActiveFilter();
      if ((this.jdField_a_of_type_Int != 1) || (!axho.g())) {
        break label65;
      }
      i = 1;
      label42:
      if ((!amfw.a()) || (bool1) || (i != 0)) {
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
  
  public boolean a(avuw paramavuw)
  {
    avuw localavuw = paramavuw;
    if (paramavuw == null) {
      localavuw = avuw.a(this.jdField_a_of_type_Avva);
    }
    boolean bool2 = this.jdField_a_of_type_Avva instanceof QIMEffectCameraCaptureUnit;
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && (localavuw != null) && (localavuw.jdField_a_of_type_Boolean) && (axgm.a(3, localavuw.jdField_a_of_type_Int, bool2)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler == null) {
        break label226;
      }
      paramavuw = localavuw.e + localavuw.jdField_b_of_type_JavaLangString + File.separator;
    }
    label165:
    label226:
    for (boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler.changeDanceStatus(true, paramavuw);; bool1 = false)
    {
      if (bool1)
      {
        if (!axgm.a(1, localavuw.jdField_a_of_type_Int, bool2)) {
          break label165;
        }
        BadcaseReportUtils.sDanceFilterID = localavuw.jdField_a_of_type_JavaLangString;
        BadcaseReportUtils.sDanceFilterName = localavuw.jdField_b_of_type_JavaLangString;
        avtm.a(this.y);
        a(false, localavuw);
        axgm.a().a(true);
      }
      while (!axgm.a(2, localavuw.jdField_a_of_type_Int, bool2)) {
        return true;
      }
      a(true, localavuw);
      axgm.a().a(true);
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler.changeDanceStatus(false, null);
      }
      D();
      axgm.a().a(false);
      return false;
    }
  }
  
  protected int b(int paramInt)
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
          break label375;
        }
        bool = true;
        localQQFilterRenderManager.setParam("key_front_camera", String.valueOf(bool));
        localQQFilterRenderManager.setParam("key_draw_screen", String.valueOf(true));
        localQQFilterRenderManager.setParam("key_enable_beauty", String.valueOf(this.q));
        localQQFilterRenderManager.setParam("key_enable_filter", String.valueOf(this.s));
        localQQFilterRenderManager.setParam("key_enable_ptv", String.valueOf(this.r));
        localQQFilterRenderManager.setParam("key_width", String.valueOf(this.jdField_n_of_type_Int));
        localQQFilterRenderManager.setParam("key_height", String.valueOf(this.jdField_o_of_type_Int));
        localQQFilterRenderManager.setBackCameraDetectEnable(bkup.a().c());
        localQQFilterRenderManager.setCaptureMode(this.c);
        paramInt = localQQFilterRenderManager.drawFrame(paramInt);
        if (this.A != this.jdField_a_of_type_Avvd.jdField_a_of_type_Int)
        {
          this.m = false;
          this.l = false;
          this.jdField_o_of_type_Boolean = false;
          this.p = false;
          this.jdField_z_of_type_Int = 0;
        }
        if (this.jdField_a_of_type_Avvd.jdField_a_of_type_Int != 0) {
          break label449;
        }
        if ((!localQQFilterRenderManager.mNeedDoFaceDetect) || (localQQFilterRenderManager.mDetectedFace) || (!this.m)) {
          break label393;
        }
        if (this.jdField_z_of_type_Int < 4) {
          break label380;
        }
        a(localQQFilterRenderManager.mNeedDoFaceDetect, localQQFilterRenderManager.mDetectedFace, false, false, 0);
      }
    }
    for (;;)
    {
      i = paramInt;
      if (this.jdField_a_of_type_Avuz != null)
      {
        long l1 = System.currentTimeMillis();
        i = paramInt;
        if (l1 - this.d >= this.e)
        {
          aune.a("Q.videostory", "Q.videostory.capture", "capturebitmap", "start");
          this.jdField_a_of_type_Avuz.a(GlUtil.captureFrame(paramInt, this.jdField_n_of_type_Int, this.jdField_o_of_type_Int, 0));
          this.d = l1;
          i = paramInt;
        }
      }
      this.jdField_a_of_type_Avva.a(System.currentTimeMillis());
      return i;
      label375:
      bool = false;
      break;
      label380:
      this.jdField_z_of_type_Int += 1;
      continue;
      label393:
      if ((this.l != localQQFilterRenderManager.mNeedDoFaceDetect) || (this.m != localQQFilterRenderManager.mDetectedFace) || (this.jdField_n_of_type_Boolean))
      {
        this.jdField_n_of_type_Boolean = false;
        a(localQQFilterRenderManager.mNeedDoFaceDetect, localQQFilterRenderManager.mDetectedFace, false, false, 0);
        continue;
        label449:
        if (this.jdField_a_of_type_Avvd.jdField_a_of_type_Int == 1)
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
        else if ((this.jdField_a_of_type_Avvd.jdField_a_of_type_Int == 2) && (localQQFilterRenderManager.mNeedDoFaceDetect) && (localQQFilterRenderManager.mNeedDoGestureDetect) && ((localQQFilterRenderManager.mDetectedFace != this.m) || (localQQFilterRenderManager.mDetectedGesture != this.p) || (this.jdField_n_of_type_Boolean)))
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
  
  public String b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGroupVideoFilterList != null) {
      return this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGroupVideoFilterList.getTriggerTips();
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null) {
      ahyd.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
    }
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
  
  public void d()
  {
    ahyd.a().a(null);
  }
  
  public void d(int paramInt)
  {
    queueEvent(new EffectsCameraCaptureView.4(this, paramInt));
  }
  
  protected boolean d()
  {
    return (this.j) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && ((this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.isFilterWork(90)) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().isSegmentRequired()) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().isVoiceToTextMaterial()));
  }
  
  public int e()
  {
    return this.D;
  }
  
  protected boolean e()
  {
    if (bkup.a().a()) {}
    do
    {
      do
      {
        return true;
      } while ((this.j) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().isVoiceToTextMaterial()));
      if (this.x) {
        return false;
      }
      if ((!this.j) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager == null)) {
        break;
      }
    } while (bkup.a().a(this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getAllActiveFilters()) >= bkup.a().a());
    return false;
    return false;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && (g()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().isRunningMovieFilter()) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().playMovie(null, null, false, null, 0.0F, 0.0F, 0.0F, 0.0F);
      }
      if (this.jdField_a_of_type_Avva != null) {
        this.jdField_a_of_type_Avva.a(null, null);
      }
    }
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_Avva.c(paramBoolean);
  }
  
  public void g()
  {
    super.g();
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
      if (this.jdField_a_of_type_Avvc != null) {
        this.jdField_a_of_type_Avvc.m();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
      this.j = false;
    }
  }
  
  public void g(boolean paramBoolean)
  {
    this.jdField_a_of_type_Avva.b(paramBoolean);
  }
  
  public boolean g()
  {
    return a() != null;
  }
  
  public int getCameraID()
  {
    return a();
  }
  
  public void h()
  {
    MovieMaterial localMovieMaterial = a();
    if (QLog.isColorLevel()) {
      QLog.d("EffectsCameraCaptureView", 2, "playMovieFilter, movieMaterial = " + localMovieMaterial);
    }
    if ((localMovieMaterial == null) || (!this.jdField_b_of_type_Boolean)) {
      f();
    }
    while (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager == null) {
      return;
    }
    if (localMovieMaterial.isTouchable) {
      if (!TextUtils.isEmpty(localMovieMaterial.atmosphereName)) {
        if (!bbdj.b(localMovieMaterial.atmosphereVideoPath)) {
          break label368;
        }
      }
    }
    label368:
    for (Object localObject = new File(localMovieMaterial.atmosphereVideoPath);; localObject = null)
    {
      if (bbdj.b(localMovieMaterial.atmosphereAudioPath)) {}
      for (File localFile = new File(localMovieMaterial.atmosphereAudioPath);; localFile = null)
      {
        FilterBusinessOperation localFilterBusinessOperation;
        String str;
        if (localObject != null)
        {
          this.jdField_a_of_type_Avva.a(null, null);
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
          this.jdField_a_of_type_Avva.a(localMovieMaterial.hintsContent, localMovieMaterial.hintImagePath);
          return;
          localObject = localFile.getAbsolutePath();
          break;
          this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().playMovie(null, null, false, null, 0.0F, 0.0F, 0.0F, 0.0F);
          continue;
          this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().playMovie(null, null, false, null, 0.0F, 0.0F, 0.0F, 0.0F);
        }
        if (bbdj.a(localMovieMaterial.doodleVideoPath)) {}
        for (localObject = new File(localMovieMaterial.doodleVideoPath);; localObject = null)
        {
          if (bbdj.a(localMovieMaterial.doodleAudioPath)) {}
          for (localFile = new File(localMovieMaterial.doodleAudioPath); localObject != null; localFile = null)
          {
            this.jdField_a_of_type_Avva.a(null, null);
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
  
  public boolean h()
  {
    return this.v;
  }
  
  public void i()
  {
    if (g())
    {
      h();
      ahub.a("", "0X80083BA", bjan.jdField_b_of_type_JavaLangString);
    }
    E();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().startRecord();
      a(this.l, this.m, this.jdField_o_of_type_Boolean, this.p, this.A);
    }
    super.i();
  }
  
  public boolean i()
  {
    return !TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean j()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.hasActiveFilter());
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_Avva != null) && (g())) {
      this.jdField_a_of_type_Avva.a(null, null);
    }
  }
  
  public boolean k()
  {
    return this.jdField_z_of_type_Boolean;
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.j) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null))
    {
      VideoPrefsUtil.setMaterialMute(true);
      queueEvent(new EffectsCameraCaptureView.7(this));
    }
  }
  
  public void onResume()
  {
    super.onResume();
    VideoPrefsUtil.setMaterialMute(this.u);
    if ((this.j) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)) {
      queueEvent(new EffectsCameraCaptureView.6(this));
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
      y();
    }
  }
  
  public void setAudioVolumeListener(avuy paramavuy)
  {
    this.jdField_a_of_type_Avuy = paramavuy;
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
  
  public void setCaptureRequest(avuz paramavuz)
  {
    this.jdField_a_of_type_Avuz = paramavuz;
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
  
  public void setEnableBadCaseReport(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }
  
  public void setFaceEffect(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if ((b()) || (!FeatureManager.Features.FACE_DETECT.isFunctionReady())) {
      QLog.d("EffectsCameraCaptureView", 1, new Object[] { "setFaceEffect fail ", Boolean.valueOf(b()) });
    }
    while ((!this.j) || (!this.r)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGroupVideoFilterList = null;
    ThreadManager.getUIHandler().post(new EffectsCameraCaptureView.3(this, paramString));
  }
  
  public void setFaceEffectEnable(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  public void setFaceEffectListener(avva paramavva)
  {
    this.jdField_a_of_type_Avva = paramavva;
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
          A();
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
  
  public void setFilterInitedListener(avvb paramavvb)
  {
    this.jdField_a_of_type_Avvb = paramavvb;
  }
  
  public void setFiltersChainListener(avvc paramavvc)
  {
    this.jdField_a_of_type_Avvc = paramavvc;
  }
  
  public void setHasStoryWaterMark(boolean paramBoolean)
  {
    this.jdField_w_of_type_Boolean = paramBoolean;
  }
  
  public void setIntercepPreviewCheck(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
  
  public void setMovieEffect(String paramString)
  {
    if ((this.j) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null))
    {
      if (!bbdj.b(paramString))
      {
        f();
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
    h();
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
    queueEvent(new EffectsCameraCaptureView.5(this, paramInt));
  }
  
  protected void u()
  {
    super.u();
    ThreadManager.excute(new EffectsCameraCaptureView.1(this), 64, null, false);
  }
  
  public void v()
  {
    super.v();
    this.jdField_a_of_type_Bkzt.a();
  }
  
  protected void w()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      this.D = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().getShookHeadCount();
      if (QLog.isColorLevel()) {
        QLog.i("EffectsCameraCaptureView", 2, "onMediaCodecStopRecord shookHeadCount:" + this.D);
      }
    }
  }
  
  public void y()
  {
    if (!this.j)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EffectsCameraCaptureView", 2, "QQFilterRenderManager initQQFilterManger");
      }
      this.t = avtc.a(true);
      Object localObject = new QQFilterRenderManager();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = ((QQFilterRenderManager)localObject);
      jdField_b_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = (QQFilterRenderManager)localObject;
      localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getChainBuilder();
      ((QQFilterRenderManager.ChainBuilder)localObject).setUseSort(true);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(40, null);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(90, null);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(70, null);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(184, null);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(25, null);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(80, null);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(10, null);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(100, null);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(186, null);
      if (this.jdField_a_of_type_Avvc != null) {
        this.jdField_a_of_type_Avvc.a((QQFilterRenderManager.ChainBuilder)localObject);
      }
      ((QQFilterRenderManager.ChainBuilder)localObject).commit();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.cameraInterFace = this;
      LogUtils.setEnable(false);
      if (this.t) {
        AEModule.updateDeviceAttr(true);
      }
      VideoMemoryManager.getInstance().setForceLoadFromSdCard(true);
    }
    queueEvent(new EffectsCameraCaptureView.2(this));
  }
  
  public void z()
  {
    this.jdField_n_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView
 * JD-Core Version:    0.7.0.1
 */