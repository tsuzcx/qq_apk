package com.tencent.mobileqq.richmedia.capture.view;

import ajpy;
import ajua;
import alud;
import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLES20;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import aobe;
import awiw;
import axoa;
import axpm;
import axpw;
import axrg;
import axri;
import axrj;
import axrk;
import axrl;
import axrm;
import axrn;
import azgd;
import azhf;
import bdhb;
import bhrb;
import bkoq;
import bljn;
import blqr;
import blra;
import bnlc;
import bnpl;
import bnqg;
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
import yyw;

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
  private axri jdField_a_of_type_Axri;
  private axrj jdField_a_of_type_Axrj;
  private axrk jdField_a_of_type_Axrk;
  private axrl jdField_a_of_type_Axrl;
  private axrm jdField_a_of_type_Axrm;
  private axrn jdField_a_of_type_Axrn = new axrn();
  protected bnqg a;
  private QQDanceEventHandler jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler;
  protected QQFilterRenderManager a;
  private GroupVideoFilterList jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGroupVideoFilterList;
  private String jdField_a_of_type_JavaLangString;
  private String jdField_b_of_type_JavaLangString;
  private long d;
  private long e = ((Long)yyw.a().a("SmartCutPicSpacing", Long.valueOf(500L))).longValue();
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
    bhrb.a();
    bkoq.a();
    VideoPrefsUtil.init(BaseApplicationImpl.getContext(), ShortVideoUtils.a());
    BadcaseReportUtils.registerReport(new axpw());
  }
  
  public EffectsCameraCaptureView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Bnqg = new bnqg();
  }
  
  public EffectsCameraCaptureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Bnqg = new bnqg();
  }
  
  private MovieMaterial a()
  {
    bnpl localbnpl = (bnpl)blqr.a(3);
    if (localbnpl != null) {
      return localbnpl.a();
    }
    return null;
  }
  
  private String a(int paramInt)
  {
    if (paramInt == PTFaceAttr.PTExpression.MOUTH_OPEN.value) {
      return alud.a(2131704375);
    }
    if (paramInt == PTFaceAttr.PTExpression.EYEBROWS_RAISE.value) {
      return alud.a(2131704377);
    }
    if (paramInt == PTFaceAttr.PTExpression.BLINK.value) {
      return alud.a(2131704371);
    }
    if (paramInt == PTFaceAttr.PTExpression.HEAD_SHAKE.value) {
      return alud.a(2131704376);
    }
    if (paramInt == PTFaceAttr.PTExpression.KISS.value) {
      return alud.a(2131704374);
    }
    if (paramInt == PTFaceAttr.PTExpression.HEAD_NOD.value) {
      return alud.a(2131704380);
    }
    return null;
  }
  
  private void a(MovieMaterial paramMovieMaterial)
  {
    bnpl localbnpl = (bnpl)blqr.a(3);
    if (localbnpl != null) {
      localbnpl.a(paramMovieMaterial);
    }
  }
  
  private void a(VideoMaterial paramVideoMaterial)
  {
    if (this.jdField_a_of_type_Axrk != null) {
      this.jdField_a_of_type_Axrk.a(paramVideoMaterial);
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
  
  private boolean b(axrg paramaxrg)
  {
    this.jdField_z_of_type_Boolean = false;
    if ((paramaxrg != null) && (paramaxrg.jdField_a_of_type_Int == 20))
    {
      com.tencent.mobileqq.shortvideo.bighead.BigHeadFilter.sGBigHeadModelPath = paramaxrg.e + paramaxrg.h + File.separator;
      this.jdField_z_of_type_Boolean = true;
    }
    if ((this.jdField_a_of_type_Axrk != null) && (this.jdField_a_of_type_Axrk.a(this.jdField_z_of_type_Boolean)) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setFilterEffect(null);
    }
    return this.jdField_z_of_type_Boolean;
  }
  
  public void A()
  {
    this.jdField_a_of_type_Axrk.b();
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
  
  public void a(boolean paramBoolean, axrg paramaxrg)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler.enterSilhouette();
    }
    super.queueEvent(new EffectsCameraCaptureView.10(this, paramBoolean, paramaxrg));
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
    if (this.jdField_a_of_type_Axrk != null)
    {
      axrk localaxrk = this.jdField_a_of_type_Axrk;
      boolean bool1 = bool2;
      if (!azgd.a().b())
      {
        bool1 = bool2;
        if (paramBoolean1) {
          bool1 = true;
        }
      }
      localaxrk.a(bool1, paramBoolean2, paramBoolean3, paramBoolean4);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (ajua.a().a()) {
      ajua.a().a(paramArrayOfByte, paramInt1, paramInt2);
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
    if (this.jdField_a_of_type_Axri != null) {
      this.jdField_a_of_type_Axri.a(d1 * 10.0D);
    }
    this.jdField_a_of_type_Axoa.a(paramArrayOfByte, paramInt1, paramInt2);
    this.jdField_a_of_type_Bnqg.a(paramArrayOfByte, paramInt1, paramInt2);
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
      if ((this.jdField_a_of_type_Int != 1) || (!azhf.g())) {
        break label65;
      }
      i = 1;
      label42:
      if ((!aobe.a()) || (bool1) || (i != 0)) {
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
  
  public boolean a(axrg paramaxrg)
  {
    axrg localaxrg = paramaxrg;
    if (paramaxrg == null) {
      localaxrg = axrg.a(this.jdField_a_of_type_Axrk);
    }
    boolean bool2 = this.jdField_a_of_type_Axrk instanceof QIMEffectCameraCaptureUnit;
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && (localaxrg != null) && (localaxrg.jdField_a_of_type_Boolean) && (azgd.a(3, localaxrg.jdField_a_of_type_Int, bool2)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler == null) {
        break label226;
      }
      paramaxrg = localaxrg.e + localaxrg.jdField_b_of_type_JavaLangString + File.separator;
    }
    label165:
    label226:
    for (boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler.changeDanceStatus(true, paramaxrg);; bool1 = false)
    {
      if (bool1)
      {
        if (!azgd.a(1, localaxrg.jdField_a_of_type_Int, bool2)) {
          break label165;
        }
        BadcaseReportUtils.sDanceFilterID = localaxrg.jdField_a_of_type_JavaLangString;
        BadcaseReportUtils.sDanceFilterName = localaxrg.jdField_b_of_type_JavaLangString;
        axpw.a(this.y);
        a(false, localaxrg);
        azgd.a().a(true);
      }
      while (!azgd.a(2, localaxrg.jdField_a_of_type_Int, bool2)) {
        return true;
      }
      a(true, localaxrg);
      azgd.a().a(true);
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQDanceEventHandler.changeDanceStatus(false, null);
      }
      D();
      azgd.a().a(false);
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
        localQQFilterRenderManager.setBackCameraDetectEnable(bnlc.a().c());
        localQQFilterRenderManager.setCaptureMode(this.c);
        paramInt = localQQFilterRenderManager.drawFrame(paramInt);
        if (this.A != this.jdField_a_of_type_Axrn.jdField_a_of_type_Int)
        {
          this.m = false;
          this.l = false;
          this.jdField_o_of_type_Boolean = false;
          this.p = false;
          this.jdField_z_of_type_Int = 0;
        }
        if (this.jdField_a_of_type_Axrn.jdField_a_of_type_Int != 0) {
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
      if (this.jdField_a_of_type_Axrj != null)
      {
        long l1 = System.currentTimeMillis();
        i = paramInt;
        if (l1 - this.d >= this.e)
        {
          awiw.a("Q.videostory", "Q.videostory.capture", "capturebitmap", "start");
          this.jdField_a_of_type_Axrj.a(GlUtil.captureFrame(paramInt, this.jdField_n_of_type_Int, this.jdField_o_of_type_Int, 0));
          this.d = l1;
          i = paramInt;
        }
      }
      this.jdField_a_of_type_Axrk.a(System.currentTimeMillis());
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
        if (this.jdField_a_of_type_Axrn.jdField_a_of_type_Int == 1)
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
        else if ((this.jdField_a_of_type_Axrn.jdField_a_of_type_Int == 2) && (localQQFilterRenderManager.mNeedDoFaceDetect) && (localQQFilterRenderManager.mNeedDoGestureDetect) && ((localQQFilterRenderManager.mDetectedFace != this.m) || (localQQFilterRenderManager.mDetectedGesture != this.p) || (this.jdField_n_of_type_Boolean)))
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
      ajua.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
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
    ajua.a().a(null);
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
    if (bnlc.a().a()) {}
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
    } while (bnlc.a().a(this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getAllActiveFilters()) >= bnlc.a().a());
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
      if (this.jdField_a_of_type_Axrk != null) {
        this.jdField_a_of_type_Axrk.a(null, null);
      }
    }
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_Axrk.c(paramBoolean);
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
      if (this.jdField_a_of_type_Axrm != null) {
        this.jdField_a_of_type_Axrm.m();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
      this.j = false;
    }
  }
  
  public void g(boolean paramBoolean)
  {
    this.jdField_a_of_type_Axrk.b(paramBoolean);
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
        if (!bdhb.b(localMovieMaterial.atmosphereVideoPath)) {
          break label368;
        }
      }
    }
    label368:
    for (Object localObject = new File(localMovieMaterial.atmosphereVideoPath);; localObject = null)
    {
      if (bdhb.b(localMovieMaterial.atmosphereAudioPath)) {}
      for (File localFile = new File(localMovieMaterial.atmosphereAudioPath);; localFile = null)
      {
        FilterBusinessOperation localFilterBusinessOperation;
        String str;
        if (localObject != null)
        {
          this.jdField_a_of_type_Axrk.a(null, null);
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
          this.jdField_a_of_type_Axrk.a(localMovieMaterial.hintsContent, localMovieMaterial.hintImagePath);
          return;
          localObject = localFile.getAbsolutePath();
          break;
          this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().playMovie(null, null, false, null, 0.0F, 0.0F, 0.0F, 0.0F);
          continue;
          this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().playMovie(null, null, false, null, 0.0F, 0.0F, 0.0F, 0.0F);
        }
        if (bdhb.a(localMovieMaterial.doodleVideoPath)) {}
        for (localObject = new File(localMovieMaterial.doodleVideoPath);; localObject = null)
        {
          if (bdhb.a(localMovieMaterial.doodleAudioPath)) {}
          for (localFile = new File(localMovieMaterial.doodleAudioPath); localObject != null; localFile = null)
          {
            this.jdField_a_of_type_Axrk.a(null, null);
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
      ajpy.a("", "0X80083BA", blra.jdField_b_of_type_JavaLangString);
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
    if ((this.jdField_a_of_type_Axrk != null) && (g())) {
      this.jdField_a_of_type_Axrk.a(null, null);
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
  
  public void setAudioVolumeListener(axri paramaxri)
  {
    this.jdField_a_of_type_Axri = paramaxri;
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
  
  public void setCaptureRequest(axrj paramaxrj)
  {
    this.jdField_a_of_type_Axrj = paramaxrj;
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
  
  public void setFaceEffectListener(axrk paramaxrk)
  {
    this.jdField_a_of_type_Axrk = paramaxrk;
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
  
  public void setFilterInitedListener(axrl paramaxrl)
  {
    this.jdField_a_of_type_Axrl = paramaxrl;
  }
  
  public void setFiltersChainListener(axrm paramaxrm)
  {
    this.jdField_a_of_type_Axrm = paramaxrm;
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
      if (!bdhb.b(paramString))
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
    this.jdField_a_of_type_Bnqg.a();
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
      this.t = axpm.a(true);
      bljn.d("EffectsCameraCaptureView", "initQQFilterManger: soLoaded = " + this.t);
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
      if (this.jdField_a_of_type_Axrm != null) {
        this.jdField_a_of_type_Axrm.a((QQFilterRenderManager.ChainBuilder)localObject);
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
  
  public void z()
  {
    this.jdField_n_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView
 * JD-Core Version:    0.7.0.1
 */