package dov.com.qq.im.ae.camera.core;

import alxc;
import alyi;
import amap;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import anzj;
import bbet;
import bbeu;
import bbgf;
import bbgg;
import bbgr;
import bbhq;
import bbmc;
import bbmo;
import bbmq;
import bday;
import bdbt;
import bhmi;
import boem;
import boim;
import boin;
import boio;
import boiq;
import boir;
import bois;
import boit;
import boiu;
import boiv;
import boiw;
import bojk;
import bojl;
import bojn;
import bojo;
import bojp;
import bojq;
import bolf;
import bomz;
import bonq;
import boqa;
import boqu;
import bork;
import borv;
import borx;
import botw;
import bowo;
import bowp;
import bows;
import bozr;
import bozv;
import bpam;
import brdw;
import brig;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.api.standard.filter.AEFilterManager.StickerInnerEffectFilterListener;
import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilter;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilterInfo;
import com.tencent.mobileqq.shortvideo.resource.AVFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.ttpicmodule.module_human_segment.HumanSegmentInitializer;
import com.tencent.ttpic.openapi.ttpicmodule.module_human_segment.PTHumanSegmenter;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.ttpic.util.SensorUtil2;
import dov.com.qq.im.ae.camera.AEVideoCaptureResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;

@TargetApi(17)
public class AECameraGLSurfaceView
  extends GLSurfaceView
  implements amap, GLSurfaceView.Renderer, bbet, bbmo, bojn
{
  private static volatile boolean o;
  private int jdField_a_of_type_Int = 320;
  private long jdField_a_of_type_Long;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF(0.0F, 0.0F);
  private bbeu jdField_a_of_type_Bbeu;
  private bbmc jdField_a_of_type_Bbmc;
  private bbmq jdField_a_of_type_Bbmq;
  private boim jdField_a_of_type_Boim;
  private boir jdField_a_of_type_Boir;
  private bois jdField_a_of_type_Bois;
  private boit jdField_a_of_type_Boit;
  private boiv jdField_a_of_type_Boiv;
  private boiw jdField_a_of_type_Boiw;
  private bojo jdField_a_of_type_Bojo;
  private bojq jdField_a_of_type_Bojq;
  private bolf jdField_a_of_type_Bolf;
  public bonq a;
  private boqa jdField_a_of_type_Boqa;
  private borv jdField_a_of_type_Borv;
  private borx jdField_a_of_type_Borx;
  private bows jdField_a_of_type_Bows = new bowo();
  private brig jdField_a_of_type_Brig = new brig();
  private AEFilterManager.StickerInnerEffectFilterListener jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager$StickerInnerEffectFilterListener;
  private AudioCapture jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture;
  private VideoMaterial jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
  private volatile SensorUtil2 jdField_a_of_type_ComTencentTtpicUtilSensorUtil2;
  private AEVideoCaptureResult jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int jdField_b_of_type_Int = 480;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 90;
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int;
  private volatile boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean = true;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean;
  private final int jdField_m_of_type_Int;
  private volatile boolean jdField_m_of_type_Boolean;
  private boolean n = true;
  private boolean p;
  private boolean q;
  private boolean r;
  
  public AECameraGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    n();
    this.jdField_m_of_type_Int = System.identityHashCode(this);
  }
  
  public AECameraGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bowp.a().a("glSurfaceViewConstruct-begin");
    n();
    this.jdField_m_of_type_Int = System.identityHashCode(this);
    bowp.a().a("glSurfaceViewConstruct-end");
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (float)Math.sqrt((paramFloat1 - paramFloat3) * (paramFloat1 - paramFloat3) + (paramFloat2 - paramFloat4) * (paramFloat2 - paramFloat4));
  }
  
  private void a(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    long l1 = SystemClock.elapsedRealtimeNanos();
    if ((d()) && (f()))
    {
      b(3553, paramInt, paramArrayOfFloat1, paramArrayOfFloat2, l1);
      return;
    }
    a(3553, paramInt, paramArrayOfFloat1, paramArrayOfFloat2, l1);
  }
  
  private void a(bbhq parambbhq)
  {
    if (this.jdField_a_of_type_Boit != null) {
      this.jdField_a_of_type_Boit.a(parambbhq);
    }
    ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.8(this));
  }
  
  private void a(bojl parambojl)
  {
    if (this.jdField_a_of_type_Boir != null) {
      this.jdField_a_of_type_Boir.a(parambojl);
    }
  }
  
  private void a(VideoMaterial paramVideoMaterial)
  {
    if (this.jdField_a_of_type_Boir != null) {
      this.jdField_a_of_type_Boir.a(paramVideoMaterial);
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Boir != null) {
      this.jdField_a_of_type_Boir.a(paramBoolean1, paramBoolean2);
    }
  }
  
  private short[] a(byte[] paramArrayOfByte)
  {
    int i2 = paramArrayOfByte.length >> 1;
    short[] arrayOfShort = new short[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfShort[i1] = ((short)(paramArrayOfByte[(i1 * 2)] & 0xFF | paramArrayOfByte[(i1 * 2 + 1)] << 8));
      i1 += 1;
    }
    return arrayOfShort;
  }
  
  private void b(int paramInt1, int paramInt2) {}
  
  private void b(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (this.jdField_a_of_type_Bojo == null) {}
    Object localObject;
    do
    {
      return;
      localObject = (bojl)this.jdField_a_of_type_Bojo;
      if (this.jdField_a_of_type_Long == 0L)
      {
        QLog.d("AECameraGLSurfaceView", 4, "frameToMediaCodec, gifRecordStartTimestamp == 0");
        this.jdField_a_of_type_Long = paramLong;
        botw.jdField_a_of_type_JavaUtilList = new ArrayList();
        botw.b = new ArrayList();
      }
      paramInt2 = ((bojl)localObject).a(paramInt2);
    } while ((paramLong - this.jdField_a_of_type_Long) / 1000000L <= 83L * this.jdField_b_of_type_Long);
    QLog.d("AECameraGLSurfaceView", 4, new Object[] { "frameToMediaCodec, encode frame, gifRecordFrameIndex = ", Long.valueOf(this.jdField_b_of_type_Long) });
    this.jdField_b_of_type_Long += 1L;
    if (((bojl)localObject).a() != null)
    {
      localObject = (PTFaceAttr)((bojl)localObject).a().getFaceAttr();
      botw.jdField_a_of_type_JavaUtilList.add(((PTFaceAttr)localObject).getAllFacePoints());
      botw.b.add(((PTFaceAttr)localObject).getAllFaceAngles());
      botw.jdField_a_of_type_Double = ((PTFaceAttr)localObject).getFaceDetectScale();
    }
    a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, (paramLong / 1.5D));
  }
  
  private void b(alxc paramalxc)
  {
    if (this.jdField_a_of_type_Boiw.c()) {
      this.jdField_a_of_type_Boiw.a((Activity)getContext(), true);
    }
    Object localObject = this.jdField_a_of_type_Boim.jdField_a_of_type_JavaLangString + "/" + System.currentTimeMillis() + ".jpg";
    bhmi.c((String)localObject);
    localObject = new File((String)localObject);
    boolean bool = this.jdField_a_of_type_Boiw.b();
    int i1 = bbgg.c(this.jdField_e_of_type_Int);
    this.jdField_a_of_type_Boiw.a((File)localObject, i1, bool, this, paramalxc);
  }
  
  private void c(int paramInt)
  {
    if ((f()) && (this.jdField_a_of_type_Long > 0L))
    {
      Object localObject = (bojl)this.jdField_a_of_type_Bojo;
      if (this.jdField_a_of_type_Borv == null)
      {
        QLog.d("AECameraGLSurfaceView", 4, "recording gif, aeExpressionRecognizer == null, create it");
        this.jdField_a_of_type_Borv = new borv();
        this.jdField_a_of_type_Borv.a();
      }
      long l1 = (SystemClock.elapsedRealtimeNanos() - this.jdField_a_of_type_Long) / 1000000L;
      int i1 = this.jdField_a_of_type_Borv.a();
      QLog.d("AECameraGLSurfaceView", 4, "recording gif, aeExpressionRecognizer.getFrameCount() == " + i1);
      if ((i1 < 3) && ((float)l1 > (i1 + 0.5F) * 1000.0F) && (((bojl)localObject).c()))
      {
        localObject = (PTFaceAttr)((bojl)localObject).a().getFaceAttr();
        this.jdField_a_of_type_Borv.a(paramInt, (List)((PTFaceAttr)localObject).getAllFacePoints().get(0), (int)(this.jdField_j_of_type_Int * ((PTFaceAttr)localObject).getFaceDetectScale()), (int)(this.jdField_k_of_type_Int * ((PTFaceAttr)localObject).getFaceDetectScale()));
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    int i1 = (int)(this.jdField_b_of_type_Int * 1.0F / this.jdField_a_of_type_Int * this.jdField_a_of_type_Boim.c());
    if (brdw.a().e()) {
      i1 = this.jdField_a_of_type_Boim.b();
    }
    if (this.jdField_b_of_type_Boolean)
    {
      arrayOfInt = bbgg.a(i1, paramInt1, paramInt2);
      arrayOfInt = bbgg.a(arrayOfInt[0], arrayOfInt[1], this.jdField_a_of_type_Boim.d(), this.jdField_a_of_type_Boim.e(), 1.0F);
      this.jdField_h_of_type_Int = arrayOfInt[0];
      this.jdField_i_of_type_Int = arrayOfInt[1];
      return;
    }
    int[] arrayOfInt = bbgg.a(paramInt1, paramInt2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Boim.a());
    this.jdField_h_of_type_Int = arrayOfInt[0];
    this.jdField_i_of_type_Int = arrayOfInt[1];
    arrayOfInt = bbgg.a(i1, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int);
    this.jdField_h_of_type_Int = arrayOfInt[0];
    this.jdField_i_of_type_Int = arrayOfInt[1];
  }
  
  private boolean d()
  {
    return (bork.a()) && (this.jdField_a_of_type_Bojo != null) && ((this.jdField_a_of_type_Bojo instanceof bojl));
  }
  
  public static void e()
  {
    try
    {
      bpam.b("AECameraGLSurfaceView", "[initSdk] + BEGIN, isSdkInited = " + o);
      long l1 = System.currentTimeMillis();
      if (!o)
      {
        bpam.b("AECameraGLSurfaceView", "[initSdk] do init");
        o = true;
        bowp.a().a("glSurfaceViewStaticInit-begin");
        if (boem.a()) {
          VideoPrefsUtil.init(BaseApplicationImpl.getContext(), ShortVideoUtils.a());
        }
        bowp.a().a("glSurfaceViewStaticInit-end");
      }
      bpam.b("AECameraGLSurfaceView", "[initSdk] + END, time cost = " + (System.currentTimeMillis() - l1));
      return;
    }
    finally {}
  }
  
  private void e(String paramString)
  {
    ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.11(this, paramString));
  }
  
  private boolean e()
  {
    if (!d()) {
      return true;
    }
    if (!((bojl)this.jdField_a_of_type_Bojo).e()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean f()
  {
    return (this.jdField_k_of_type_Boolean) && (this.jdField_m_of_type_Boolean) && (this.jdField_a_of_type_Bbmc != null);
  }
  
  private void n()
  {
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 0, 0);
    setEGLContextFactory(new boin(this));
    setPreserveEGLContextOnPause(false);
    setRenderer(this);
    setRenderMode(0);
    o();
  }
  
  private void o()
  {
    bpam.b("AECameraGLSurfaceView", "preAction");
    if (!o) {
      e();
    }
    try
    {
      this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2 = new SensorUtil2();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void p()
  {
    this.jdField_l_of_type_Boolean = false;
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_Bojo != null) {
      return;
    }
    bpam.b("AECameraGLSurfaceView", "createFilterProcess---BEGIN");
    boem.a();
    if (FeatureManager.loadBasicFeatures())
    {
      this.jdField_a_of_type_Bojo = new bojl(this.jdField_m_of_type_Int);
      bpam.b("AECameraGLSurfaceView", "createFilterProcess---create AEFilterProcessTex");
      return;
    }
    this.jdField_a_of_type_Bojo = new bojp();
    bpam.d("AECameraGLSurfaceView", "createFilterProcess---create NonAEFilterProcess");
  }
  
  private void r()
  {
    bowp.a().a("AECameraGLSurfaceView", "initFilterProcess---begin");
    if (this.jdField_a_of_type_Bojo == null) {
      q();
    }
    if ((this.jdField_a_of_type_Bojo instanceof bojl))
    {
      bojk.a((bojl)this.jdField_a_of_type_Bojo);
      if (this.jdField_a_of_type_Bois != null) {
        this.jdField_a_of_type_Bois.b();
      }
      ((bojl)this.jdField_a_of_type_Bojo).b(false);
      ((bojl)this.jdField_a_of_type_Bojo).a(this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager$StickerInnerEffectFilterListener);
      ((bojl)this.jdField_a_of_type_Bojo).a().setParam("SET_AEPROFILER_OBJ", this.jdField_a_of_type_Bows);
    }
    SurfaceTexture localSurfaceTexture = this.jdField_a_of_type_Bojo.a();
    localSurfaceTexture.setOnFrameAvailableListener(new boiq(this));
    if (this.jdField_a_of_type_Boiv != null) {
      this.jdField_a_of_type_Boiv.a(localSurfaceTexture);
    }
    bowp.a().a("AECameraGLSurfaceView", "initFilterProcess---end");
  }
  
  private void s()
  {
    if ((this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null) && (VideoMaterialUtil.isAudio2textMaterial(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial))) {
      this.jdField_a_of_type_Brig.a(getContext(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_Bojo != null)
    {
      this.jdField_a_of_type_Bojo.h();
      this.jdField_a_of_type_Bojo = null;
      if (this.jdField_a_of_type_Boiv != null) {
        this.jdField_a_of_type_Boiv.a();
      }
    }
    bojk.a(null);
  }
  
  private void u()
  {
    v();
    this.jdField_a_of_type_Bows.c();
  }
  
  private void v()
  {
    this.jdField_a_of_type_Boqa = new boio(this, getContext());
    if (this.jdField_a_of_type_Boqa.a()) {
      this.jdField_a_of_type_Boqa.a();
    }
  }
  
  private void w()
  {
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_a_of_type_Long = 0L;
      this.jdField_b_of_type_Long = 0L;
      QLog.d("AECameraGLSurfaceView", 4, "onMediaCodecStopRecord");
      if (this.jdField_a_of_type_Borv != null)
      {
        QLog.d("AECameraGLSurfaceView", 4, "onMediaCodecStopRecord and aeExpressionRecognizer != null, release it");
        this.jdField_a_of_type_Borv.a(this.jdField_a_of_type_Borx);
        this.jdField_a_of_type_Borv.b();
        this.jdField_a_of_type_Borv.c();
      }
    }
  }
  
  private void x()
  {
    if (!d()) {
      return;
    }
    bojl localbojl = (bojl)this.jdField_a_of_type_Bojo;
    if ((localbojl.b()) && (!localbojl.c()) && (!this.jdField_i_of_type_Boolean))
    {
      this.jdField_g_of_type_Int += 1;
      if (this.jdField_g_of_type_Int >= 4)
      {
        a(localbojl.b(), localbojl.c());
        this.jdField_g_of_type_Int = 0;
      }
    }
    if ((!this.jdField_i_of_type_Boolean) && (localbojl.c())) {
      a(localbojl.b(), localbojl.c());
    }
    if (!localbojl.b()) {
      a(localbojl.b(), localbojl.c());
    }
    if ((this.jdField_i_of_type_Boolean) && (localbojl.c())) {
      a(localbojl.b(), localbojl.c());
    }
    this.jdField_i_of_type_Boolean = localbojl.c();
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoFrameCount = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)
    {
      if (!this.jdField_a_of_type_Bbeu.a()) {
        break label56;
      }
      this.jdField_a_of_type_Bbeu.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boit != null) {
        this.jdField_a_of_type_Boit.m();
      }
      return;
      label56:
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Boiw.a(paramFloat1, paramFloat2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_Bbeu.a()))
    {
      bpam.d("AECameraGLSurfaceView", "onAudioError---errorCode=" + paramInt);
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.audioDataFilePath = "";
      if (this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath != null) {
        a(this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i3 = 720;
    bpam.b("AECameraGLSurfaceView", "onCameraPreviewSizeChanged---cameraWidth=" + paramInt1 + ", cameraHeight=" + paramInt2 + ", mSurfaceWidth=" + this.jdField_a_of_type_Int + ", mSurfaceHeight=" + this.jdField_b_of_type_Int);
    double d1 = this.jdField_a_of_type_Int / this.jdField_b_of_type_Int;
    this.jdField_h_of_type_Int = paramInt1;
    this.jdField_i_of_type_Int = ((int)(this.jdField_h_of_type_Int / d1));
    int i1;
    int i2;
    if (this.jdField_k_of_type_Boolean)
    {
      int[] arrayOfInt = bbgg.a(paramInt1, paramInt2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1.0F);
      arrayOfInt = bbgg.a(640, arrayOfInt[0], arrayOfInt[1]);
      i1 = arrayOfInt[0];
      i2 = arrayOfInt[1];
      this.jdField_j_of_type_Int = i1;
      this.jdField_k_of_type_Int = i2;
      this.jdField_h_of_type_Int = this.jdField_j_of_type_Int;
      this.jdField_i_of_type_Int = this.jdField_k_of_type_Int;
      if (this.jdField_a_of_type_Bojo != null)
      {
        if (i1 <= 720) {
          break label288;
        }
        float f1 = 720.0F / i1;
        i2 = (int)(i2 * f1);
        i1 = i3;
      }
    }
    label288:
    for (;;)
    {
      this.jdField_a_of_type_Bojo.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt1, paramInt2, i1, i2);
      this.jdField_a_of_type_Boiw.a(i1, i2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Bojo.a(this.jdField_h_of_type_Int, this.jdField_i_of_type_Int);
      b(paramInt1, paramInt2);
      return;
      c(paramInt1, paramInt2);
      i2 = paramInt2;
      i1 = paramInt1;
      break;
    }
  }
  
  void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if ((this.jdField_m_of_type_Boolean) && (this.jdField_a_of_type_Bbmc != null))
    {
      switch (this.jdField_l_of_type_Int)
      {
      default: 
        throw new RuntimeException("unknown status " + this.jdField_l_of_type_Int);
      case 0: 
        this.jdField_a_of_type_Bbmc.a(EGL14.eglGetCurrentContext());
        this.jdField_a_of_type_Bbmq.a();
        this.jdField_a_of_type_Bbmq.a(this.jdField_a_of_type_Bbmc, this);
        this.jdField_l_of_type_Int = 1;
      }
      this.jdField_a_of_type_Bbmq.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
      return;
    }
    switch (this.jdField_l_of_type_Int)
    {
    case 0: 
    default: 
      throw new RuntimeException("unknown status " + this.jdField_l_of_type_Int);
    }
    this.jdField_a_of_type_Bbmq.b();
    w();
    this.jdField_l_of_type_Int = 0;
  }
  
  public void a(alxc paramalxc)
  {
    if (e())
    {
      QLog.d("AECameraGLSurfaceView", 4, "capturePhotoByCameraProxy");
      bomz.a.jdField_b_of_type_Boolean = false;
      b(paramalxc);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bows.e();
      if (this.jdField_a_of_type_Boit != null) {
        this.jdField_a_of_type_Boit.l();
      }
      return;
      QLog.d("AECameraGLSurfaceView", 4, "capturePhotoByAEKit");
      bomz.a.jdField_b_of_type_Boolean = true;
      k();
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    ThreadManager.excute(new AECameraGLSurfaceView.7(this, paramBitmap), 64, null, false);
  }
  
  public void a(boiw paramboiw, boim paramboim)
  {
    if ((this.jdField_a_of_type_Boim != null) || (this.jdField_a_of_type_Boiw != null)) {
      throw new RuntimeException("init is already called");
    }
    if (paramboiw == null) {
      throw new IllegalArgumentException("param cameraManager is null");
    }
    if (paramboim == null) {
      throw new IllegalArgumentException("param captureParam is null");
    }
    this.jdField_a_of_type_Boim = paramboim;
    this.jdField_a_of_type_Boiw = paramboiw;
    if (QLog.isColorLevel()) {
      QLog.d("AECameraGLSurfaceView", 2, "setCaptureParam : " + paramboim);
    }
    this.jdField_a_of_type_Bbmq = new bbmq();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture = new AudioCapture(this.jdField_a_of_type_Boim.jdField_a_of_type_JavaLangString, 1, bdbt.q, bdbt.o, bdbt.p, this, this.jdField_a_of_type_Boiw.a());
    this.jdField_a_of_type_Bbeu = new bbeu(this.jdField_a_of_type_Boim.jdField_a_of_type_JavaLangString, bdbt.q, this);
    this.jdField_a_of_type_Boiw.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
    if (this.jdField_c_of_type_Boolean)
    {
      paramboiw = this.jdField_a_of_type_Boim.jdField_a_of_type_JavaLangString + File.separator + System.currentTimeMillis() + ".aac";
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a(true, paramboiw);
    }
    this.jdField_a_of_type_Bows.g();
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void a(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    int i1 = 1;
    if (this.jdField_a_of_type_Boit != null) {
      this.jdField_a_of_type_Boit.a(paramAEVideoCaptureResult);
    }
    ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.5(this));
    bbgr.c();
    if (bday.a().jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      bbgf.i(i1);
      return;
      i1 = 2;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AECameraGLSurfaceView", 2, "onEncodeFinish filePath = " + paramString);
    }
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath = paramString;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)
    {
      if (this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.audioDataFilePath != null)
      {
        a(this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
        return;
      }
      if (this.jdField_a_of_type_Bbeu.a())
      {
        this.jdField_a_of_type_Bbeu.b();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e();
      return;
    }
    paramString = this.jdField_a_of_type_Boim.jdField_a_of_type_JavaLangString + "/noaudio";
    bhmi.c(paramString);
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.audioDataFilePath = paramString;
    a(this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!PTHumanSegmenter.HUMAN_SEGMENT.isFunctionReady()) && (paramBoolean)) {
      QQToast.a(BaseApplicationImpl.getContext(), anzj.a(2131689779), 0).a();
    }
    while (!d()) {
      return;
    }
    ((bojl)this.jdField_a_of_type_Bojo).b(paramBoolean);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (alyi.a().a()) {
      alyi.a().a(paramArrayOfByte, paramInt1, paramInt2);
    }
    short[] arrayOfShort = a(paramArrayOfByte);
    double d1 = 0.0D;
    int i1 = 0;
    while (i1 < arrayOfShort.length)
    {
      d1 += arrayOfShort[i1] * arrayOfShort[i1];
      i1 += 1;
    }
    Math.log10(d1 / arrayOfShort.length);
    this.jdField_a_of_type_Bbeu.a(paramArrayOfByte, paramInt1, paramInt2);
    this.jdField_a_of_type_Brig.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boiw.b();
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.errorCode = paramInt;
    if (this.jdField_a_of_type_Boit != null) {
      this.jdField_a_of_type_Boit.a(104);
    }
  }
  
  public void a_(String paramString)
  {
    a(new bbhq(1, 0, paramString, null, this.jdField_d_of_type_Int));
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Boiw.a();
  }
  
  public void b()
  {
    AEVideoCaptureResult localAEVideoCaptureResult = this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult;
    localAEVideoCaptureResult.videoFrameCount += 1;
  }
  
  public void b(int paramInt) {}
  
  public void b(String paramString)
  {
    if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_Bbeu.a()))
    {
      bpam.d("AECameraGLSurfaceView", "onAudioCaptured---filePath=" + paramString);
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.audioDataFilePath = paramString;
      if (this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath != null) {
        a(this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_m_of_type_Boolean;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)
    {
      alyi.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
      queueEvent(new AECameraGLSurfaceView.6(this));
    }
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_Bbeu.a())
    {
      bpam.d("AECameraGLSurfaceView", "onAudioChangeCaptured---filePath=" + paramString);
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.audioDataFilePath = paramString;
      if (this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath != null) {
        a(this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
      }
    }
  }
  
  public boolean c()
  {
    return ((this.jdField_a_of_type_Bojo instanceof bojl)) && (((bojl)this.jdField_a_of_type_Bojo).a() != null) && (((bojl)this.jdField_a_of_type_Bojo).a().getmPTSticker() != null) && (((bojl)this.jdField_a_of_type_Bojo).a().getmPTSticker().needTouchTriggerEvent());
  }
  
  public void d()
  {
    alyi.a().a(null);
  }
  
  public void d(String paramString)
  {
    if ((this.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_Bbeu.a()))
    {
      bpam.d("AECameraGLSurfaceView", "onEncodeAudioCaptured---filePath=" + paramString);
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.audioDataFilePath = paramString;
      if (this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath != null) {
        a(this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
      }
    }
  }
  
  public void f()
  {
    bpam.d("AECameraGLSurfaceView", "[onDestroy]");
    if (QLog.isDevelopLevel()) {
      bpam.a("AECameraGLSurfaceView", "### onDestroy, hashCode=" + this.jdField_m_of_type_Int + " ###");
    }
    if (this.jdField_a_of_type_Brig != null) {
      this.jdField_a_of_type_Brig.a();
    }
    if (this.jdField_a_of_type_Bojo != null) {
      this.jdField_a_of_type_Bojo.a(true);
    }
    this.jdField_a_of_type_Bows.h();
    if (this.jdField_a_of_type_Bbmq != null) {
      this.jdField_a_of_type_Bbmq.c();
    }
    queueEvent(new AECameraGLSurfaceView.3(this));
    bpam.d("AECameraGLSurfaceView", "[onDestroy] end");
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Bojo != null) && (((bojl)this.jdField_a_of_type_Bojo).a()))
    {
      ((bojl)this.jdField_a_of_type_Bojo).b();
      ((bojl)this.jdField_a_of_type_Bojo).c();
    }
  }
  
  public void h()
  {
    if (!d()) {}
    while (this.jdField_a_of_type_Bojo == null) {
      return;
    }
    queueEvent(new AECameraGLSurfaceView.14(this));
  }
  
  public void i()
  {
    this.jdField_a_of_type_Bows.b();
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Bojo != null) {
      this.jdField_a_of_type_Bojo.a(false);
    }
    if (this.jdField_a_of_type_Boiv != null) {
      this.jdField_a_of_type_Boiv.c();
    }
    this.jdField_a_of_type_Bows.a(this.jdField_a_of_type_Boiw.b());
    if (this.jdField_k_of_type_Boolean) {
      return;
    }
    bozr.a().F();
    bpam.b("AECameraGLSurfaceView", "【Change Camera】:isFrontCamera:" + this.jdField_a_of_type_Boiw.b());
  }
  
  public void k()
  {
    int i1 = 0;
    if (this.jdField_a_of_type_Boiw.c())
    {
      this.jdField_a_of_type_Boiw.a((Activity)getContext(), true);
      i1 = 1500;
    }
    ThreadManager.getUIHandler().postDelayed(new AECameraGLSurfaceView.15(this), i1);
  }
  
  public void l()
  {
    bpam.b("AECameraGLSurfaceView", "startCaptureVideo---recordingEnabled=" + this.jdField_m_of_type_Boolean);
    this.jdField_a_of_type_Bows.f();
    if ((this.jdField_a_of_type_Boiw.c()) && (!this.jdField_k_of_type_Boolean)) {
      this.jdField_a_of_type_Boiw.a((Activity)getContext(), true);
    }
    String str = this.jdField_a_of_type_Boim.jdField_a_of_type_JavaLangString + File.separator + System.currentTimeMillis() + ".mp4";
    if ((this.n) && (!this.jdField_k_of_type_Boolean)) {}
    for (int i1 = bbgg.b(this.jdField_d_of_type_Int);; i1 = 0)
    {
      this.jdField_a_of_type_Bbmc = new bbmc(str, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, this.jdField_a_of_type_Boim.a(), this.jdField_a_of_type_Boim.f(), false, i1);
      this.jdField_a_of_type_Bbmc.jdField_j_of_type_Int = this.jdField_a_of_type_Boim.h();
      this.jdField_a_of_type_Bbmc.jdField_k_of_type_Int = this.jdField_a_of_type_Boim.i();
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult = new AEVideoCaptureResult();
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.startTimeMs = System.currentTimeMillis();
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.orientation = this.jdField_d_of_type_Int;
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.type = 0;
      if (this.jdField_a_of_type_Boiw.a() == 2) {
        this.jdField_a_of_type_Boiw.d();
      }
      this.jdField_m_of_type_Boolean = true;
      bbgg.a(false, false);
      return;
    }
  }
  
  public void m()
  {
    bpam.b("AECameraGLSurfaceView", "stopCaptureVideo---recordingEnabled=" + this.jdField_m_of_type_Boolean + ", recordingStatus=" + this.jdField_l_of_type_Int + ", isPaused=" + this.jdField_h_of_type_Boolean);
    if (this.jdField_m_of_type_Boolean)
    {
      this.jdField_m_of_type_Boolean = false;
      if (this.jdField_l_of_type_Int != 0) {
        break label99;
      }
      if (this.jdField_a_of_type_Boit != null) {
        this.jdField_a_of_type_Boit.a(102);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boiw.b();
      return;
      label99:
      if (this.jdField_h_of_type_Boolean) {
        a(0, null, null);
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    bpam.b("AECameraGLSurfaceView", "[onAttachedFromWindow]" + toString());
    super.onAttachedToWindow();
    bpam.b("AECameraGLSurfaceView", "[onAttachedFromWindow] end");
  }
  
  protected void onDetachedFromWindow()
  {
    bpam.d("AECameraGLSurfaceView", "[onDetachedFromWindow]" + toString());
    super.onDetachedFromWindow();
    bpam.d("AECameraGLSurfaceView", "[onDetachedFromWindow] end");
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    boolean bool = this.jdField_e_of_type_Boolean;
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_f_of_type_Int += 1;
      if (bool)
      {
        paramGL10 = "onDrawFrameReal-begin";
        bowp.a().a(paramGL10);
      }
    }
    else
    {
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = false;
        u();
      }
      if (this.jdField_a_of_type_Bojo != null) {
        break label88;
      }
    }
    label88:
    do
    {
      return;
      paramGL10 = "onDrawFrameFake-begin" + this.jdField_f_of_type_Int;
      break;
      if (this.jdField_f_of_type_Boolean) {
        bowp.a().a("FilterProcessInitFilters-begin");
      }
      this.jdField_a_of_type_Bojo.g();
      if (this.jdField_f_of_type_Boolean) {
        bowp.a().a("FilterProcessInitFilters-end");
      }
      paramGL10 = this.jdField_a_of_type_Bojo.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_k_of_type_Boolean);
      if (d())
      {
        bojl localbojl = (bojl)this.jdField_a_of_type_Bojo;
        x();
        g();
        if (this.jdField_a_of_type_Bolf != null) {
          this.jdField_a_of_type_Bolf.a(this.jdField_a_of_type_Boiw.a(), localbojl.a());
        }
        c(paramGL10[1]);
      }
      if ((this.q) && (!this.jdField_k_of_type_Boolean)) {
        this.jdField_a_of_type_Bojo.c(paramGL10[1]);
      }
      a(paramGL10[1], null, null);
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        queueEvent(new AECameraGLSurfaceView.9(this));
      }
      this.jdField_a_of_type_Bows.d();
      if (!this.p)
      {
        this.p = true;
        bozv.a().f();
        bozr.a().X();
        if (bomz.a()) {
          bomz.a(this.jdField_a_of_type_Bonq, 5000L);
        }
        if (this.jdField_a_of_type_Boiv != null) {
          this.jdField_a_of_type_Boiv.b();
        }
      }
      if (this.jdField_f_of_type_Boolean)
      {
        if (!bool) {
          break label398;
        }
        paramGL10 = "onDrawFrameReal-end";
        bowp.a().a(paramGL10);
        if (bool) {
          this.jdField_f_of_type_Boolean = false;
        }
      }
    } while ((!bool) || (this.r));
    this.r = true;
    bowp.a().c();
    paramGL10 = bozr.a();
    if (this.jdField_a_of_type_Boiw.d()) {}
    for (int i1 = 2;; i1 = 1)
    {
      paramGL10.f(i1);
      return;
      label398:
      paramGL10 = "onDrawFrameFake-end" + this.jdField_f_of_type_Int;
      break;
    }
  }
  
  public void onPause()
  {
    bpam.d("AECameraGLSurfaceView", "[onPause] hashCode=" + this.jdField_m_of_type_Int + " ###");
    queueEvent(new AECameraGLSurfaceView.2(this));
    this.jdField_h_of_type_Boolean = true;
    if (this.jdField_a_of_type_Boqa != null) {
      this.jdField_a_of_type_Boqa.b();
    }
    if (this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2 != null) {
      this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2.stop();
    }
    super.onPause();
    bpam.d("AECameraGLSurfaceView", "[onPause] end");
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_h_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2 != null) {
      this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2.start();
    }
    if (QLog.isDevelopLevel()) {
      bpam.a("AECameraGLSurfaceView", "### onResume, hashCode=" + this.jdField_m_of_type_Int + " ###");
    }
    this.jdField_m_of_type_Boolean = false;
    if ((this.jdField_a_of_type_Boqa != null) && (this.jdField_a_of_type_Boqa.a())) {
      this.jdField_a_of_type_Boqa.a();
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    bpam.b("AECameraGLSurfaceView", "[onSurfaceChanged] + BEGIN, width = " + paramInt1 + ", height = " + paramInt2);
    bowp.a().a("onSurfaceChanged-begin");
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_Bojo != null) {
      this.jdField_a_of_type_Bojo.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 0, 0, paramInt1, paramInt2);
    }
    if (this.jdField_c_of_type_Int != 0) {
      setBeautyLevel(this.jdField_c_of_type_Int);
    }
    bowp.a().a("onSurfaceChanged-end");
    bpam.b("AECameraGLSurfaceView", "[onSurfaceChanged] + END, width = " + paramInt1 + ", height = " + paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    bpam.b("AECameraGLSurfaceView", "[onSurfaceCreated] + BEGIN");
    bowp.a().a("onSurfaceCreated-begin");
    r();
    bowp.a().a("onSurfaceCreated-end");
    bpam.b("AECameraGLSurfaceView", "[onSurfaceCreated] + END");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent == null) {
      return false;
    }
    if ((!d()) || (this.jdField_a_of_type_Bojq == null)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    bojl localbojl = (bojl)this.jdField_a_of_type_Bojo;
    if ((paramMotionEvent != null) && (localbojl.d()) && (!this.jdField_a_of_type_Bojq.c()))
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int i1 = DeviceUtils.getScreenWidth(AEModule.getContext());
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        return true;
        this.jdField_a_of_type_AndroidGraphicsPointF.x = f1;
        this.jdField_a_of_type_AndroidGraphicsPointF.y = f2;
        queueEvent(new AECameraGLSurfaceView.18(this, localbojl, f1, f2, i1));
        continue;
        if (a(this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, f1, f2) > i1 * 0.05F)
        {
          queueEvent(new AECameraGLSurfaceView.19(this, localbojl, f1, f2, i1));
          continue;
          queueEvent(new AECameraGLSurfaceView.20(this, localbojl, f1, f2, i1));
        }
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAECaptureController(bojq parambojq)
  {
    this.jdField_a_of_type_Bojq = parambojq;
  }
  
  public void setAEKitInitListener(bois parambois)
  {
    this.jdField_a_of_type_Bois = parambois;
  }
  
  public void setBeautyLevel(int paramInt)
  {
    if (!d())
    {
      bpam.b("AECameraGLSurfaceView", "[setBeautyLevel] level = " + paramInt + ", isAEKitAvailable is false");
      return;
    }
    this.jdField_c_of_type_Int = paramInt;
    queueEvent(new AECameraGLSurfaceView.16(this, paramInt));
  }
  
  public void setCaptureListener(boit paramboit)
  {
    this.jdField_a_of_type_Boit = paramboit;
  }
  
  public void setCaptureRequest(boiu paramboiu)
  {
    if (this.jdField_a_of_type_Bojo != null) {
      this.jdField_a_of_type_Bojo.a(paramboiu);
    }
  }
  
  public void setDynamicResolutionMode(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Boiw.c(paramBoolean);
  }
  
  public void setEventCallback(boiv paramboiv)
  {
    this.jdField_a_of_type_Boiv = paramboiv;
  }
  
  public void setFaceEffectListener(boir paramboir)
  {
    this.jdField_a_of_type_Boir = paramboir;
  }
  
  public void setFilter(FilterCategoryItem paramFilterCategoryItem)
  {
    if (!d()) {}
    bojl localbojl;
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            return;
            localbojl = (bojl)this.jdField_a_of_type_Bojo;
          } while (paramFilterCategoryItem != null);
          localObject = paramFilterCategoryItem.a();
        } while (localObject == null);
        paramFilterCategoryItem = SdkContext.getInstance().getResources().getAvFilterResource().getFilterResPath();
        if (!TextUtils.isEmpty(((FilterDesc)localObject).resRootPath)) {
          paramFilterCategoryItem = ((FilterDesc)localObject).resRootPath;
        }
        paramFilterCategoryItem = ((FilterDesc)localObject).getResFold(paramFilterCategoryItem);
        localObject = QQPtColorFilter.getColorFilterInfo(paramFilterCategoryItem);
      } while (localObject == null);
      paramFilterCategoryItem = paramFilterCategoryItem + ((QQPtColorFilterInfo)localObject).getColorPng();
    } while (!new File(paramFilterCategoryItem).exists());
    localbojl.a(paramFilterCategoryItem);
  }
  
  public void setIsGIFMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bows.b(paramBoolean);
    this.jdField_k_of_type_Boolean = paramBoolean;
  }
  
  public void setIsVoiceNeedEncode(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setMaterial(String paramString)
  {
    ThreadManager.excute(new AECameraGLSurfaceView.13(this, new AECameraGLSurfaceView.12(this, paramString)), 64, null, true);
  }
  
  public void setMaterialMetaData(boqu paramboqu)
  {
    if ((paramboqu == null) || (paramboqu.equals(boqu.jdField_a_of_type_Boqu)))
    {
      setMaterial(null);
      return;
    }
    Object localObject = getContext();
    if (((localObject instanceof Activity)) && (!b()))
    {
      localObject = ((Activity)localObject).getIntent();
      ((Intent)localObject).putExtra("widgetinfo", "camera^" + paramboqu.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("material_id", paramboqu.jdField_a_of_type_JavaLangString);
      bpam.b("AECameraGLSurfaceView", "selectSpecificMaterial---塞拍同款名 takeSameName=" + paramboqu.i);
      ((Intent)localObject).putExtra("key_camera_material_name", paramboqu.i);
      ((Intent)localObject).putExtra("ae_editor_is_show_take_same", paramboqu.jdField_f_of_type_Int);
    }
    setMaterial(paramboqu.a());
  }
  
  public void setPreExtractFrame(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public void setRecommendTextCallback(borx paramborx)
  {
    this.jdField_a_of_type_Borx = paramborx;
  }
  
  public void setSceneListener(bolf parambolf)
  {
    this.jdField_a_of_type_Bolf = parambolf;
  }
  
  public void setSharpFaceLevel(int paramInt)
  {
    if (!d()) {
      return;
    }
    queueEvent(new AECameraGLSurfaceView.17(this, paramInt));
  }
  
  public void setStickerInnerLutFilterListener(AEFilterManager.StickerInnerEffectFilterListener paramStickerInnerEffectFilterListener)
  {
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager$StickerInnerEffectFilterListener = paramStickerInnerEffectFilterListener;
    if ((this.jdField_a_of_type_Bojo != null) && ((this.jdField_a_of_type_Bojo instanceof bojl))) {
      ((bojl)this.jdField_a_of_type_Bojo).a(paramStickerInnerEffectFilterListener);
    }
  }
  
  public void setTapEvent(int paramInt, float paramFloat1, float paramFloat2)
  {
    queueEvent(new AECameraGLSurfaceView.TapRunnable(this, paramInt, paramFloat1 / this.jdField_a_of_type_Int, paramFloat2 / this.jdField_b_of_type_Int));
  }
  
  public void setZoom(int paramInt)
  {
    this.jdField_a_of_type_Boiw.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */