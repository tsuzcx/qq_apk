package dov.com.qq.im.ae.camera.core;

import ahyb;
import aiai;
import ajya;
import akwf;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import avrs;
import avrt;
import avtd;
import avte;
import avth;
import avti;
import avtp;
import avuo;
import avza;
import avzm;
import avzo;
import axhr;
import axhu;
import axim;
import bbdx;
import bcql;
import biik;
import bijq;
import bijr;
import bijs;
import biju;
import bijv;
import bijw;
import bijx;
import bijy;
import bijz;
import bika;
import bikd;
import bikf;
import bikg;
import biki;
import bikj;
import bikk;
import bikl;
import bilu;
import binj;
import bink;
import biob;
import biqp;
import bire;
import birt;
import bisb;
import bisd;
import biua;
import biwo;
import biwt;
import biwu;
import biwx;
import bizt;
import bizx;
import bjah;
import bkvg;
import blak;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.api.standard.filter.AEFilterManager.StickerInnerEffectFilterListener;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;
import com.tencent.mobileqq.shortvideo.filter.QQLowLightFilter;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilter;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilterInfo;
import com.tencent.mobileqq.shortvideo.resource.AVFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.ttpicmodule.PTSegmenter;
import com.tencent.ttpic.openapi.ttpicmodule.SegmentInitializer;
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
  implements aiai, GLSurfaceView.Renderer, avrs, avzm, bikd, biki
{
  private static int jdField_n_of_type_Int;
  private static volatile boolean p;
  private int jdField_a_of_type_Int = 320;
  private final long jdField_a_of_type_Long = 83L;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF(0.0F, 0.0F);
  private avrt jdField_a_of_type_Avrt;
  private avth jdField_a_of_type_Avth;
  private avza jdField_a_of_type_Avza;
  private avzo jdField_a_of_type_Avzo;
  private bijq jdField_a_of_type_Bijq;
  private biju jdField_a_of_type_Biju;
  private bijv jdField_a_of_type_Bijv;
  private bijw jdField_a_of_type_Bijw;
  private bijx jdField_a_of_type_Bijx;
  private bijz jdField_a_of_type_Bijz;
  private bikj jdField_a_of_type_Bikj;
  private bikl jdField_a_of_type_Bikl;
  private bilu jdField_a_of_type_Bilu;
  private binj jdField_a_of_type_Binj;
  public biob a;
  private biqp jdField_a_of_type_Biqp;
  private bisb jdField_a_of_type_Bisb;
  private bisd jdField_a_of_type_Bisd;
  public biwo a;
  private biwx jdField_a_of_type_Biwx = new biwt();
  private blak jdField_a_of_type_Blak = new blak();
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
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 90;
  private volatile boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = true;
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
  private boolean jdField_n_of_type_Boolean = true;
  private boolean o;
  private boolean q;
  
  public AECameraGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    s();
    this.jdField_m_of_type_Int = System.identityHashCode(this);
  }
  
  public AECameraGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    biwu.a().a("glSurfaceViewConstruct-begin");
    s();
    this.jdField_m_of_type_Int = System.identityHashCode(this);
    biwu.a().a("glSurfaceViewConstruct-end");
  }
  
  private void A()
  {
    this.jdField_a_of_type_Biqp = new bijs(this, getContext());
    if (this.jdField_a_of_type_Biqp.a()) {
      this.jdField_a_of_type_Biqp.a();
    }
  }
  
  private void B()
  {
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.o = false;
  }
  
  private void C()
  {
    if (bika.a().c()) {
      bika.a().a((Activity)getContext(), true);
    }
    Object localObject = this.jdField_a_of_type_Bijq.a + "/" + System.currentTimeMillis() + ".jpg";
    bbdx.c((String)localObject);
    localObject = new File((String)localObject);
    boolean bool = bika.a().b();
    int i1 = avte.c(this.jdField_e_of_type_Int);
    bika.a().a((File)localObject, i1, bool, this);
  }
  
  private void D()
  {
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_b_of_type_Long = 0L;
      this.jdField_c_of_type_Long = 0L;
      QLog.d("AECameraGLSurfaceView", 4, "onMediaCodecStopRecord");
      if (this.jdField_a_of_type_Bisb != null)
      {
        QLog.d("AECameraGLSurfaceView", 4, "onMediaCodecStopRecord and aeExpressionRecognizer != null, release it");
        this.jdField_a_of_type_Bisb.a(this.jdField_a_of_type_Bisd);
        this.jdField_a_of_type_Bisb.b();
        this.jdField_a_of_type_Bisb.c();
      }
    }
  }
  
  private void E()
  {
    if (!f()) {
      return;
    }
    bikg localbikg = (bikg)this.jdField_a_of_type_Bikj;
    if ((localbikg.a()) && (!localbikg.b()) && (!this.jdField_i_of_type_Boolean))
    {
      this.jdField_g_of_type_Int += 1;
      if (this.jdField_g_of_type_Int >= 4)
      {
        a(localbikg.a(), localbikg.b());
        this.jdField_g_of_type_Int = 0;
      }
    }
    if ((!this.jdField_i_of_type_Boolean) && (localbikg.b())) {
      a(localbikg.a(), localbikg.b());
    }
    if (!localbikg.a()) {
      a(localbikg.a(), localbikg.b());
    }
    if ((this.jdField_i_of_type_Boolean) && (localbikg.b())) {
      a(localbikg.a(), localbikg.b());
    }
    this.jdField_i_of_type_Boolean = localbikg.b();
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (float)Math.sqrt((paramFloat1 - paramFloat3) * (paramFloat1 - paramFloat3) + (paramFloat2 - paramFloat4) * (paramFloat2 - paramFloat4));
  }
  
  private void a(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    long l1 = SystemClock.elapsedRealtimeNanos();
    if ((f()) && (h()))
    {
      b(3553, paramInt, paramArrayOfFloat1, paramArrayOfFloat2, l1);
      return;
    }
    a(3553, paramInt, paramArrayOfFloat1, paramArrayOfFloat2, l1);
  }
  
  private void a(avuo paramavuo)
  {
    if (this.jdField_a_of_type_Bijx != null) {
      this.jdField_a_of_type_Bijx.a(paramavuo);
    }
    ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.8(this));
  }
  
  private void a(VideoMaterial paramVideoMaterial)
  {
    if (this.jdField_a_of_type_Biju != null) {
      this.jdField_a_of_type_Biju.a(paramVideoMaterial);
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Biju != null) {
      this.jdField_a_of_type_Biju.a(paramBoolean1, paramBoolean2);
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
  
  private void b(int paramInt1, int paramInt2)
  {
    int i1 = (int)(this.jdField_b_of_type_Int * 1.0F / this.jdField_a_of_type_Int * this.jdField_a_of_type_Bijq.c());
    if (bkvg.a().e()) {
      i1 = this.jdField_a_of_type_Bijq.b();
    }
    if (this.jdField_c_of_type_Boolean)
    {
      arrayOfInt = avte.a(i1, paramInt1, paramInt2);
      arrayOfInt = avte.a(arrayOfInt[0], arrayOfInt[1], this.jdField_a_of_type_Bijq.d(), this.jdField_a_of_type_Bijq.e(), 1.0F);
      this.jdField_h_of_type_Int = arrayOfInt[0];
      this.jdField_i_of_type_Int = arrayOfInt[1];
      return;
    }
    int[] arrayOfInt = avte.a(paramInt1, paramInt2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Bijq.a());
    this.jdField_h_of_type_Int = arrayOfInt[0];
    this.jdField_i_of_type_Int = arrayOfInt[1];
    arrayOfInt = avte.a(i1, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int);
    this.jdField_h_of_type_Int = arrayOfInt[0];
    this.jdField_i_of_type_Int = arrayOfInt[1];
  }
  
  private void b(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (this.jdField_a_of_type_Bikj == null) {}
    Object localObject;
    do
    {
      return;
      localObject = (bikg)this.jdField_a_of_type_Bikj;
      if (this.jdField_b_of_type_Long == 0L)
      {
        QLog.d("AECameraGLSurfaceView", 4, "frameToMediaCodec, gifRecordStartTimestamp == 0");
        this.jdField_b_of_type_Long = paramLong;
        biua.jdField_a_of_type_JavaUtilList = new ArrayList();
        biua.b = new ArrayList();
      }
      paramInt2 = ((bikg)localObject).a(paramInt2);
    } while ((paramLong - this.jdField_b_of_type_Long) / 1000000L <= 83L * this.jdField_c_of_type_Long);
    QLog.d("AECameraGLSurfaceView", 4, new Object[] { "frameToMediaCodec, encode frame, gifRecordFrameIndex = ", Long.valueOf(this.jdField_c_of_type_Long) });
    this.jdField_c_of_type_Long += 1L;
    if (((bikg)localObject).a() != null)
    {
      localObject = (PTFaceAttr)((bikg)localObject).a().getFaceAttr();
      biua.jdField_a_of_type_JavaUtilList.add(((PTFaceAttr)localObject).getAllFacePoints());
      biua.b.add(((PTFaceAttr)localObject).getAllFaceAngles());
      biua.jdField_a_of_type_Double = ((PTFaceAttr)localObject).getFaceDetectScale();
    }
    a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, (paramLong / 1.5D));
  }
  
  private void c(int paramInt)
  {
    if ((h()) && (this.jdField_b_of_type_Long > 0L))
    {
      Object localObject = (bikg)this.jdField_a_of_type_Bikj;
      if (this.jdField_a_of_type_Bisb == null)
      {
        QLog.d("AECameraGLSurfaceView", 4, "recording gif, aeExpressionRecognizer == null, create it");
        this.jdField_a_of_type_Bisb = new bisb();
        this.jdField_a_of_type_Bisb.a();
      }
      long l1 = (SystemClock.elapsedRealtimeNanos() - this.jdField_b_of_type_Long) / 1000000L;
      int i1 = this.jdField_a_of_type_Bisb.a();
      QLog.d("AECameraGLSurfaceView", 4, "recording gif, aeExpressionRecognizer.getFrameCount() == " + i1);
      if ((i1 < 3) && ((float)l1 > (i1 + 0.5F) * 1000.0F) && (((bikg)localObject).b()))
      {
        localObject = (PTFaceAttr)((bikg)localObject).a().getFaceAttr();
        this.jdField_a_of_type_Bisb.a(paramInt, (List)((PTFaceAttr)localObject).getAllFacePoints().get(0), (int)(this.jdField_j_of_type_Int * ((PTFaceAttr)localObject).getFaceDetectScale()), (int)(this.jdField_k_of_type_Int * ((PTFaceAttr)localObject).getFaceDetectScale()));
      }
    }
  }
  
  private void d(String paramString)
  {
    ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.11(this, paramString));
  }
  
  private boolean d()
  {
    if (this.jdField_k_of_type_Boolean) {
      return true;
    }
    Context localContext = getContext();
    if ((localContext instanceof Activity)) {
      return birt.h(((Activity)localContext).getIntent());
    }
    return false;
  }
  
  public static void e()
  {
    bjah.b("AECameraGLSurfaceView", "[initSdk] + BEGIN, isSdkInited = " + p);
    long l1 = System.currentTimeMillis();
    if (!p)
    {
      bjah.b("AECameraGLSurfaceView", "[initSdk] do init");
      p = true;
      biwu.a().a("glSurfaceViewStaticInit-begin");
      biik.a();
      FeatureManager.loadBasicFeatures();
      VideoPrefsUtil.init(BaseApplicationImpl.getContext(), ShortVideoUtils.a());
      biwu.a().a("glSurfaceViewStaticInit-end");
    }
    bjah.b("AECameraGLSurfaceView", "[initSdk] + END, time cost = " + (System.currentTimeMillis() - l1));
  }
  
  private boolean e()
  {
    Activity localActivity = (Activity)getContext();
    if (Build.VERSION.SDK_INT < 23) {
      return true;
    }
    int i1 = localActivity.checkSelfPermission("android.permission.CAMERA");
    int i2 = localActivity.checkSelfPermission("android.permission.RECORD_AUDIO");
    boolean bool = akwf.a(localActivity);
    if ((i1 == 0) && (i2 == 0) && (bool)) {}
    for (bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean f()
  {
    return (FeatureManager.isBasicFeaturesFunctionReady()) && (this.jdField_a_of_type_Bikj != null) && ((this.jdField_a_of_type_Bikj instanceof bikg));
  }
  
  private boolean g()
  {
    if (!f()) {
      return true;
    }
    if (!((bikg)this.jdField_a_of_type_Bikj).d()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean h()
  {
    return (this.jdField_k_of_type_Boolean) && (this.jdField_m_of_type_Boolean) && (this.jdField_a_of_type_Avza != null);
  }
  
  private void s()
  {
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 0, 0);
    setEGLContextFactory(new bijr(this));
    setPreserveEGLContextOnPause(false);
    setRenderer(this);
    setRenderMode(0);
    queueEvent(new AECameraGLSurfaceView.2(this));
  }
  
  private void t()
  {
    this.jdField_l_of_type_Boolean = false;
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_Bikj != null) {
      return;
    }
    bjah.b("AECameraGLSurfaceView", "createFilterProcess---BEGIN");
    if (FeatureManager.loadBasicFeatures())
    {
      this.jdField_a_of_type_Bikj = new bikg(this.jdField_m_of_type_Int);
      bjah.b("AECameraGLSurfaceView", "createFilterProcess---create AEFilterProcessTex");
      return;
    }
    this.jdField_a_of_type_Bikj = new bikk();
    bjah.d("AECameraGLSurfaceView", "createFilterProcess---create NonAEFilterProcess");
  }
  
  private void v()
  {
    biwu.a().a("AECameraGLSurfaceView", "initFilterProcess---begin");
    if (this.jdField_a_of_type_Bikj == null) {
      u();
    }
    if ((this.jdField_a_of_type_Bikj instanceof bikg))
    {
      if (this.jdField_a_of_type_Bijv != null) {
        this.jdField_a_of_type_Bijv.a();
      }
      ((bikg)this.jdField_a_of_type_Bikj).b(false);
      ((bikg)this.jdField_a_of_type_Bikj).a(this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager$StickerInnerEffectFilterListener);
      ((bikg)this.jdField_a_of_type_Bikj).a().setParam("SET_AEPROFILER_OBJ", this.jdField_a_of_type_Biwx);
    }
    bika.a().a(this.jdField_a_of_type_Bikj.a());
    String str = FeatureManager.getResourceDir();
    if (!AIManager.installDetector(PTSegmenter.class, str, str)) {
      bjah.d("AECameraGLSurfaceView", "PTSegmenter install error.");
    }
    biwu.a().a("AECameraGLSurfaceView", "initFilterProcess---end");
  }
  
  private void w()
  {
    if ((this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null) && (VideoMaterialUtil.isAudio2textMaterial(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial))) {
      this.jdField_a_of_type_Blak.a(getContext(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_Bikj != null)
    {
      this.jdField_a_of_type_Bikj.e();
      this.jdField_a_of_type_Bikj = null;
      if (jdField_n_of_type_Int == this.jdField_m_of_type_Int) {
        bika.a().f();
      }
    }
  }
  
  private void y()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    bjah.b("AECameraGLSurfaceView", "startPreview---");
    bika.a().b();
  }
  
  private void z()
  {
    A();
    this.jdField_a_of_type_Biwx.c();
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
      if (!this.jdField_a_of_type_Avrt.a()) {
        break label56;
      }
      this.jdField_a_of_type_Avrt.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bijx != null) {
        this.jdField_a_of_type_Bijx.n();
      }
      return;
      label56:
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    bika.a().a(paramFloat1, paramFloat2);
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    int i3 = 720;
    double d1 = this.jdField_a_of_type_Int / this.jdField_b_of_type_Int;
    this.jdField_h_of_type_Int = paramInt1;
    this.jdField_i_of_type_Int = ((int)(this.jdField_h_of_type_Int / d1));
    Object localObject1;
    int i1;
    int i2;
    if (this.jdField_k_of_type_Boolean)
    {
      localObject1 = avte.a(paramInt1, paramInt2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1.0F);
      localObject1 = avte.a(640, localObject1[0], localObject1[1]);
      i1 = localObject1[0];
      i2 = localObject1[1];
      this.jdField_j_of_type_Int = i1;
      this.jdField_k_of_type_Int = i2;
      this.jdField_h_of_type_Int = this.jdField_j_of_type_Int;
      this.jdField_i_of_type_Int = this.jdField_k_of_type_Int;
      if (this.jdField_a_of_type_Bikj != null)
      {
        if (i1 <= 720) {
          break label436;
        }
        float f1 = 720.0F / i1;
        i2 = (int)(i2 * f1);
        i1 = i3;
      }
    }
    label436:
    for (;;)
    {
      this.jdField_a_of_type_Bikj.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt1, paramInt2, i1, i2);
      bika.a().a(i1, i2);
      this.jdField_a_of_type_Bikj.a(this.jdField_h_of_type_Int, this.jdField_i_of_type_Int);
      bink.a.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      bink.a.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      bink.a.jdField_c_of_type_Int = Math.min(paramInt1, paramInt2);
      bink.a.jdField_d_of_type_Int = Math.max(paramInt1, paramInt2);
      if (bika.a().d()) {}
      for (localObject1 = Camera2Control.a().c();; localObject1 = axhr.a().b())
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new axhu();
        }
        bink.a.jdField_e_of_type_Int = Math.min(((axhu)localObject2).jdField_a_of_type_Int, ((axhu)localObject2).jdField_b_of_type_Int);
        bink.a.jdField_f_of_type_Int = Math.max(((axhu)localObject2).jdField_a_of_type_Int, ((axhu)localObject2).jdField_b_of_type_Int);
        if (this.jdField_a_of_type_Bikj != null)
        {
          localObject1 = this.jdField_a_of_type_Bikj.a();
          bink.a.jdField_g_of_type_Int = localObject1[0];
          bink.a.jdField_h_of_type_Int = localObject1[1];
          bink.a.jdField_i_of_type_Int = localObject1[2];
          bink.a.jdField_j_of_type_Int = localObject1[3];
        }
        bink.a.jdField_m_of_type_Int = this.jdField_h_of_type_Int;
        bink.a.jdField_n_of_type_Int = this.jdField_i_of_type_Int;
        if ((bink.a()) && (this.jdField_a_of_type_Biob != null)) {
          this.jdField_a_of_type_Biob.x();
        }
        return;
        b(paramInt1, paramInt2);
        i2 = paramInt2;
        i1 = paramInt1;
        break;
      }
    }
  }
  
  void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if ((this.jdField_m_of_type_Boolean) && (this.jdField_a_of_type_Avza != null))
    {
      switch (this.jdField_l_of_type_Int)
      {
      default: 
        throw new RuntimeException("unknown status " + this.jdField_l_of_type_Int);
      case 0: 
        this.jdField_a_of_type_Avza.a(EGL14.eglGetCurrentContext());
        this.jdField_a_of_type_Avzo.a();
        this.jdField_a_of_type_Avzo.a(this.jdField_a_of_type_Avza, this);
        this.jdField_l_of_type_Int = 1;
      }
      this.jdField_a_of_type_Avzo.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
      return;
    }
    switch (this.jdField_l_of_type_Int)
    {
    case 0: 
    default: 
      throw new RuntimeException("unknown status " + this.jdField_l_of_type_Int);
    }
    this.jdField_a_of_type_Avzo.b();
    D();
    this.jdField_l_of_type_Int = 0;
  }
  
  public void a(Bitmap paramBitmap)
  {
    ThreadManager.excute(new AECameraGLSurfaceView.7(this, paramBitmap), 64, null, false);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_Boolean = true;
    if (!this.o)
    {
      this.o = true;
      biwu.a().a("onFrameAvailable");
    }
    if (this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2 != null) {
      this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2.getRotation(this.jdField_a_of_type_ArrayOfFloat);
    }
    queueEvent(new AECameraGLSurfaceView.4(this));
    requestRender();
  }
  
  public void a(bijq parambijq)
  {
    if (this.jdField_a_of_type_Bijq != null) {
      throw new RuntimeException("setCaptureParam is already called");
    }
    this.jdField_a_of_type_Bijq = parambijq;
    if (QLog.isColorLevel()) {
      QLog.d("AECameraGLSurfaceView", 2, "setCaptureParam : " + parambijq);
    }
    bika.a().a(this);
    bika.a().a(parambijq);
    this.jdField_a_of_type_Avzo = new avzo();
    this.jdField_a_of_type_Avth = new avth();
    bika.a().a(this.jdField_a_of_type_Avth);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture = new AudioCapture(this.jdField_a_of_type_Bijq.a, 1, axim.q, axim.o, axim.p, this, bika.a().a());
    this.jdField_a_of_type_Avrt = new avrt(this.jdField_a_of_type_Bijq.a, axim.q, this);
    bika.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
    this.jdField_a_of_type_Biwx.g();
    this.jdField_b_of_type_Boolean = true;
  }
  
  protected void a(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    int i1 = 1;
    if (this.jdField_a_of_type_Bijx != null) {
      this.jdField_a_of_type_Bijx.a(paramAEVideoCaptureResult);
    }
    ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.5(this));
    avtp.c();
    if (axhr.a().jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      avtd.i(i1);
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
      if (this.jdField_a_of_type_Avrt.a())
      {
        this.jdField_a_of_type_Avrt.b();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e();
      return;
    }
    paramString = this.jdField_a_of_type_Bijq.a + "/noaudio";
    bbdx.c(paramString);
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.audioDataFilePath = paramString;
    a(this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!PTSegmenter.SEGMENT.isFunctionReady()) && (paramBoolean)) {
      bcql.a(BaseApplicationImpl.getContext(), ajya.a(2131689826), 0).a();
    }
    while (!f()) {
      return;
    }
    ((bikg)this.jdField_a_of_type_Bikj).b(paramBoolean);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      biwu.a().a("onCameraStart");
    }
    bjah.b("AECameraGLSurfaceView", "onCameraStarted--success=" + paramBoolean + ", errMsg=" + paramString);
    if (this.jdField_a_of_type_Bijw != null) {
      this.jdField_a_of_type_Bijw.a(paramBoolean, paramString);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (ahyb.a().a()) {
      ahyb.a().a(paramArrayOfByte, paramInt1, paramInt2);
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
    this.jdField_a_of_type_Avrt.a(paramArrayOfByte, paramInt1, paramInt2);
    this.jdField_a_of_type_Blak.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public boolean a()
  {
    return bika.a().b();
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.errorCode = paramInt;
    if (this.jdField_a_of_type_Bijx != null) {
      this.jdField_a_of_type_Bijx.a(104);
    }
  }
  
  public void a_(String paramString)
  {
    a(new avuo(1, 0, paramString, null, this.jdField_d_of_type_Int));
  }
  
  public int b()
  {
    return bika.a().a();
  }
  
  public void b()
  {
    AEVideoCaptureResult localAEVideoCaptureResult = this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult;
    localAEVideoCaptureResult.videoFrameCount += 1;
  }
  
  public void b(int paramInt) {}
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.audioDataFilePath = paramString;
    if (this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath != null) {
      a(this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      QQLowLightFilter.enableNightMode(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
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
      ahyb.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
      queueEvent(new AECameraGLSurfaceView.6(this));
    }
  }
  
  public void c(String paramString) {}
  
  public void d()
  {
    ahyb.a().a(null);
  }
  
  public void f()
  {
    if (QLog.isDevelopLevel()) {
      bjah.a("AECameraGLSurfaceView", "### onDestroy, hashCode=" + this.jdField_m_of_type_Int + " ###");
    }
    if (this.jdField_a_of_type_Blak != null) {
      this.jdField_a_of_type_Blak.a();
    }
    bikf.a(null);
    if (this.jdField_a_of_type_Bikj != null) {
      this.jdField_a_of_type_Bikj.a(true);
    }
    if (jdField_n_of_type_Int == this.jdField_m_of_type_Int) {
      bika.a().b(d());
    }
    this.jdField_a_of_type_Biwx.h();
    if (this.jdField_a_of_type_Avzo != null) {
      this.jdField_a_of_type_Avzo.c();
    }
  }
  
  public void g() {}
  
  public void h()
  {
    if (!f()) {}
    while (this.jdField_a_of_type_Bikj == null) {
      return;
    }
    queueEvent(new AECameraGLSurfaceView.14(this));
  }
  
  public void i()
  {
    this.jdField_a_of_type_Biwx.b();
    B();
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Bikj != null) {
      this.jdField_a_of_type_Bikj.a(false);
    }
    bika.a().c(d());
    this.jdField_a_of_type_Biwx.a(bika.a().b());
    if (this.jdField_k_of_type_Boolean) {}
    for (;;)
    {
      if (this.jdField_a_of_type_Bijw != null) {
        this.jdField_a_of_type_Bijw.c();
      }
      return;
      bizt.a().m();
      bjah.b("AECameraGLSurfaceView", "【Change Camera】:isFrontCamera:" + bika.a().b());
    }
  }
  
  public void k()
  {
    if (g())
    {
      QLog.d("AECameraGLSurfaceView", 4, "capturePhotoByCameraProxy");
      bink.a.jdField_b_of_type_Boolean = false;
      C();
    }
    for (;;)
    {
      this.jdField_a_of_type_Biwx.e();
      if (this.jdField_a_of_type_Bijx != null) {
        this.jdField_a_of_type_Bijx.m();
      }
      return;
      QLog.d("AECameraGLSurfaceView", 4, "capturePhotoByAEKit");
      bink.a.jdField_b_of_type_Boolean = true;
      l();
    }
  }
  
  public void l()
  {
    int i1 = 0;
    if (bika.a().c())
    {
      bika.a().a((Activity)getContext(), true);
      i1 = 1500;
    }
    ThreadManager.getUIHandler().postDelayed(new AECameraGLSurfaceView.15(this), i1);
  }
  
  public void m()
  {
    bjah.b("AECameraGLSurfaceView", "startCaptureVideo---recordingEnabled=" + this.jdField_m_of_type_Boolean);
    this.jdField_a_of_type_Biwx.f();
    if ((bika.a().c()) && (!this.jdField_k_of_type_Boolean)) {
      bika.a().a((Activity)getContext(), true);
    }
    String str = this.jdField_a_of_type_Bijq.a + File.separator + System.currentTimeMillis() + ".mp4";
    if ((this.jdField_n_of_type_Boolean) && (!this.jdField_k_of_type_Boolean)) {}
    for (int i1 = avte.b(this.jdField_d_of_type_Int);; i1 = 0)
    {
      this.jdField_a_of_type_Avza = new avza(str, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, this.jdField_a_of_type_Bijq.a(), this.jdField_a_of_type_Bijq.f(), false, i1);
      this.jdField_a_of_type_Avza.jdField_j_of_type_Int = this.jdField_a_of_type_Bijq.h();
      this.jdField_a_of_type_Avza.jdField_k_of_type_Int = this.jdField_a_of_type_Bijq.i();
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult = new AEVideoCaptureResult();
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.startTimeMs = System.currentTimeMillis();
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.orientation = this.jdField_d_of_type_Int;
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.type = 0;
      if (bika.a().a() == 2) {
        bika.a().g();
      }
      this.jdField_m_of_type_Boolean = true;
      avte.a(false, false);
      return;
    }
  }
  
  public void n()
  {
    bjah.b("AECameraGLSurfaceView", "stopCaptureVideo---recordingEnabled=" + this.jdField_m_of_type_Boolean);
    if (this.jdField_m_of_type_Boolean)
    {
      this.jdField_m_of_type_Boolean = false;
      if (this.jdField_l_of_type_Int != 0) {
        break label72;
      }
      if (this.jdField_a_of_type_Bijx != null) {
        this.jdField_a_of_type_Bijx.a(102);
      }
    }
    for (;;)
    {
      bika.a().d();
      return;
      label72:
      if (this.jdField_h_of_type_Boolean) {
        a(0, null, null);
      }
    }
  }
  
  public void o()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    bjah.b("AECameraGLSurfaceView", "openCamera");
    bika.a().a();
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_f_of_type_Int += 1;
      if (bool)
      {
        paramGL10 = "onDrawFrameReal-begin";
        biwu.a().a(paramGL10);
      }
    }
    else
    {
      if (this.jdField_e_of_type_Boolean)
      {
        this.jdField_e_of_type_Boolean = false;
        z();
      }
      if (this.jdField_a_of_type_Bikj != null) {
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
        biwu.a().a("FilterProcessInitFilters-begin");
      }
      this.jdField_a_of_type_Bikj.d();
      if (this.jdField_f_of_type_Boolean) {
        biwu.a().a("FilterProcessInitFilters-end");
      }
      paramGL10 = this.jdField_a_of_type_Bikj.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      if (f())
      {
        bikg localbikg = (bikg)this.jdField_a_of_type_Bikj;
        E();
        if (this.jdField_a_of_type_Bilu != null) {
          this.jdField_a_of_type_Bilu.a(bika.a().a(), localbikg.a());
        }
        c(paramGL10[1]);
      }
      this.jdField_a_of_type_Bikj.c(paramGL10[0]);
      a(paramGL10[1], null, null);
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        queueEvent(new AECameraGLSurfaceView.9(this));
      }
      this.jdField_a_of_type_Biwx.d();
      if (!this.q)
      {
        this.q = true;
        bizx.a().f();
        bizt.a().C();
        if (bink.a()) {
          bink.a(this.jdField_a_of_type_Biob, 5000L);
        }
        if (this.jdField_a_of_type_Bijz != null) {
          this.jdField_a_of_type_Bijz.a();
        }
      }
    } while (!this.jdField_f_of_type_Boolean);
    if (bool) {}
    for (paramGL10 = "onDrawFrameReal-end";; paramGL10 = "onDrawFrameFake-end" + this.jdField_f_of_type_Int)
    {
      biwu.a().a(paramGL10);
      if (!bool) {
        break;
      }
      this.jdField_f_of_type_Boolean = false;
      return;
    }
  }
  
  public void onPause()
  {
    bjah.b("AECameraGLSurfaceView", "[onPause] hashCode=" + this.jdField_m_of_type_Int + " ###");
    bjah.a("AECameraGLSurfaceView", "[onPause] TOP_SURFACE_HASH_CODE=" + jdField_n_of_type_Int + " ###");
    queueEvent(new AECameraGLSurfaceView.3(this));
    if (this.jdField_a_of_type_Biwo == biwo.b) {}
    for (this.jdField_g_of_type_Boolean = true;; this.jdField_g_of_type_Boolean = false)
    {
      this.jdField_h_of_type_Boolean = true;
      if (jdField_n_of_type_Int == this.jdField_m_of_type_Int)
      {
        bjah.a("AECameraGLSurfaceView", "### onPause, execute stop camera TOP_SURFACE_HASH_CODE=mIdentityHashCode=" + jdField_n_of_type_Int + " ###");
        bika.a().c();
        bika.a().a(d());
      }
      if (this.jdField_a_of_type_Biqp != null) {
        this.jdField_a_of_type_Biqp.b();
      }
      if (this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2 != null) {
        this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2.stop();
      }
      super.onPause();
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_h_of_type_Boolean = false;
    if (e()) {
      if (!this.jdField_g_of_type_Boolean) {
        o();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2 != null) {
        this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2.start();
      }
      if (QLog.isDevelopLevel()) {
        bjah.a("AECameraGLSurfaceView", "### onResume, hashCode=" + this.jdField_m_of_type_Int + " ###");
      }
      this.jdField_m_of_type_Boolean = false;
      bika.a().e();
      if ((this.jdField_a_of_type_Biqp != null) && (this.jdField_a_of_type_Biqp.a())) {
        this.jdField_a_of_type_Biqp.a();
      }
      return;
      if (!this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = true;
        this.jdField_a_of_type_Bijw.b();
      }
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    bjah.b("AECameraGLSurfaceView", "[onSurfaceChanged] + BEGIN, width = " + paramInt1 + ", height = " + paramInt2);
    biwu.a().a("onSurfaceChanged-begin");
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    bika.a().b(paramInt1, paramInt2);
    r();
    if (this.jdField_a_of_type_Bikj != null) {
      this.jdField_a_of_type_Bikj.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 0, 0, paramInt1, paramInt2);
    }
    if (this.jdField_c_of_type_Int != 0) {
      setBeautyLevel(this.jdField_c_of_type_Int);
    }
    if (this.jdField_a_of_type_Binj != null) {
      this.jdField_a_of_type_Binj.a(paramInt1, paramInt2);
    }
    biwu.a().a("onSurfaceChanged-end");
    bjah.b("AECameraGLSurfaceView", "[onSurfaceChanged] + END, width = " + paramInt1 + ", height = " + paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    bjah.b("AECameraGLSurfaceView", "[onSurfaceCreated] + BEGIN");
    biwu.a().a("onSurfaceCreated-begin");
    jdField_n_of_type_Int = this.jdField_m_of_type_Int;
    v();
    biwu.a().a("onSurfaceCreated-end");
    bjah.b("AECameraGLSurfaceView", "[onSurfaceCreated] + END");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent == null) {
      return false;
    }
    if ((!f()) || (this.jdField_a_of_type_Bikl == null)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    bikg localbikg = (bikg)this.jdField_a_of_type_Bikj;
    if ((paramMotionEvent != null) && (localbikg.c()) && (!this.jdField_a_of_type_Bikl.c()))
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
        queueEvent(new AECameraGLSurfaceView.19(this, localbikg, f1, f2, i1));
        continue;
        if (a(this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, f1, f2) > i1 * 0.05F)
        {
          queueEvent(new AECameraGLSurfaceView.20(this, localbikg, f1, f2, i1));
          continue;
          queueEvent(new AECameraGLSurfaceView.21(this, localbikg, f1, f2, i1));
        }
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void p()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    bjah.b("AECameraGLSurfaceView", "stopCamera");
    bika.a().a(d());
  }
  
  public void q()
  {
    bjah.b("AECameraGLSurfaceView", "cameraStopPreview");
    bika.a().c();
  }
  
  public void r()
  {
    bjah.b("AECameraGLSurfaceView", "[tryStartCameraPreview] + BEGIN");
    if (this.jdField_g_of_type_Boolean)
    {
      bjah.a("AECameraGLSurfaceView", "[tryStartCameraPreview] blockCameraFlag = " + this.jdField_g_of_type_Boolean);
      return;
    }
    if (this.jdField_h_of_type_Boolean)
    {
      bjah.a("AECameraGLSurfaceView", "[tryStartCameraPreview] isPaused = " + this.jdField_h_of_type_Boolean);
      return;
    }
    if (!e())
    {
      bjah.d("AECameraGLSurfaceView", "[tryStartCameraPreview] permission denied");
      return;
    }
    bika.a().a(this);
    o();
    y();
    bjah.b("AECameraGLSurfaceView", "[tryStartCameraPreview] + END");
  }
  
  public void setAECaptureController(bikl parambikl)
  {
    this.jdField_a_of_type_Bikl = parambikl;
  }
  
  public void setAEKitInitListener(bijv parambijv)
  {
    this.jdField_a_of_type_Bijv = parambijv;
  }
  
  public void setBeautyLevel(int paramInt)
  {
    if (!f())
    {
      bjah.b("AECameraGLSurfaceView", "[setBeautyLevel] level = " + paramInt + ", isAEKitAvailable is false");
      return;
    }
    this.jdField_c_of_type_Int = paramInt;
    queueEvent(new AECameraGLSurfaceView.16(this, paramInt));
  }
  
  public void setBlockCameraFlag(boolean paramBoolean)
  {
    bjah.b("AECameraGLSurfaceView", "setBlockCameraFlag---block=" + paramBoolean);
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void setCameraListener(bijw parambijw)
  {
    this.jdField_a_of_type_Bijw = parambijw;
  }
  
  public void setCameraPermissionResult(boolean paramBoolean)
  {
    bjah.b("AECameraGLSurfaceView", "setCameraPermissionResult---permissionRet=" + paramBoolean);
    if (paramBoolean) {
      r();
    }
  }
  
  public void setCaptureListener(bijx parambijx)
  {
    this.jdField_a_of_type_Bijx = parambijx;
  }
  
  public void setCaptureRequest(bijy parambijy)
  {
    this.jdField_a_of_type_Bikj.a(parambijy);
  }
  
  public void setDarkModeEnable(boolean paramBoolean)
  {
    bika.a().d(paramBoolean);
  }
  
  public void setDarkModeListener(avti paramavti)
  {
    bika.a().a(paramavti);
  }
  
  public void setDynamicResolutionMode(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    bika.a().e(paramBoolean);
  }
  
  public void setFaceEffectListener(biju parambiju)
  {
    this.jdField_a_of_type_Biju = parambiju;
  }
  
  public void setFilter(FilterCategoryItem paramFilterCategoryItem)
  {
    if (!f()) {}
    bikg localbikg;
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
            localbikg = (bikg)this.jdField_a_of_type_Bikj;
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
    localbikg.a(paramFilterCategoryItem);
  }
  
  public void setIsGIFMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Biwx.b(paramBoolean);
    this.jdField_k_of_type_Boolean = paramBoolean;
  }
  
  public void setLaunchStateCallback(bijz parambijz)
  {
    this.jdField_a_of_type_Bijz = parambijz;
  }
  
  public void setMaterial(String paramString)
  {
    ThreadManager.excute(new AECameraGLSurfaceView.13(this, new AECameraGLSurfaceView.12(this, paramString)), 64, null, true);
  }
  
  public void setMaterialMetaData(bire parambire)
  {
    if ((parambire == null) || (parambire.equals(bire.a)))
    {
      setMaterial(null);
      return;
    }
    setMaterial(parambire.a());
  }
  
  public void setOnFrameDraw(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public void setOnSurfaceChangedListener(binj parambinj)
  {
    this.jdField_a_of_type_Binj = parambinj;
  }
  
  public void setRecommendTextCallback(bisd parambisd)
  {
    this.jdField_a_of_type_Bisd = parambisd;
  }
  
  public void setSceneListener(bilu parambilu)
  {
    this.jdField_a_of_type_Bilu = parambilu;
  }
  
  public void setSharpFaceLevel(int paramInt)
  {
    if (!f()) {
      return;
    }
    queueEvent(new AECameraGLSurfaceView.17(this, paramInt));
  }
  
  public void setStickerInnerLutFilterListener(AEFilterManager.StickerInnerEffectFilterListener paramStickerInnerEffectFilterListener)
  {
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager$StickerInnerEffectFilterListener = paramStickerInnerEffectFilterListener;
    if ((this.jdField_a_of_type_Bikj != null) && ((this.jdField_a_of_type_Bikj instanceof bikg))) {
      ((bikg)this.jdField_a_of_type_Bikj).a(paramStickerInnerEffectFilterListener);
    }
  }
  
  public void setZoom(int paramInt)
  {
    bika.a().a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */