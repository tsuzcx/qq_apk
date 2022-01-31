package dov.com.qq.im.ae.camera.core;

import ajpl;
import ajrs;
import alpo;
import ammv;
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
import axjq;
import axjr;
import axlc;
import axld;
import axlg;
import axlh;
import axlo;
import axmn;
import axqz;
import axrl;
import axrn;
import azcx;
import azda;
import azds;
import bdcs;
import bkkj;
import bkny;
import bknz;
import bkoa;
import bkoc;
import bkod;
import bkoe;
import bkof;
import bkog;
import bkoh;
import bkoi;
import bkol;
import bkou;
import bkov;
import bkox;
import bkoy;
import bkoz;
import bkpa;
import bkqj;
import bksd;
import bkse;
import bksv;
import bkve;
import bkvu;
import bkwm;
import bkwu;
import bkww;
import bkyt;
import blbn;
import blbo;
import blbr;
import blen;
import bler;
import blfg;
import bngq;
import bnlu;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.ai.AIManager;
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
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;
import com.tencent.mobileqq.shortvideo.filter.QQLowLightFilter;
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
import com.tencent.ttpic.openapi.ttpicmodule.PTSegmenter;
import com.tencent.ttpic.openapi.ttpicmodule.SegmentInitializer;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.ttpic.util.SensorUtil2;
import dov.com.qq.im.ae.camera.AEVideoCaptureResult;
import dov.com.qq.im.ae.mode.AECaptureMode;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;

@TargetApi(17)
public class AECameraGLSurfaceView
  extends GLSurfaceView
  implements ajrs, GLSurfaceView.Renderer, axjq, axrl, bkol, bkox
{
  private static int jdField_n_of_type_Int;
  private static volatile boolean p;
  private int jdField_a_of_type_Int = 320;
  private final long jdField_a_of_type_Long = 83L;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF(0.0F, 0.0F);
  private axjr jdField_a_of_type_Axjr;
  private axlg jdField_a_of_type_Axlg;
  private axqz jdField_a_of_type_Axqz;
  private axrn jdField_a_of_type_Axrn;
  private bkny jdField_a_of_type_Bkny;
  private bkoc jdField_a_of_type_Bkoc;
  private bkod jdField_a_of_type_Bkod;
  private bkoe jdField_a_of_type_Bkoe;
  private bkof jdField_a_of_type_Bkof;
  private bkoh jdField_a_of_type_Bkoh;
  private bkoy jdField_a_of_type_Bkoy;
  private bkpa jdField_a_of_type_Bkpa;
  private bkqj jdField_a_of_type_Bkqj;
  private bksd jdField_a_of_type_Bksd;
  public bksv a;
  private bkve jdField_a_of_type_Bkve;
  private bkwu jdField_a_of_type_Bkwu;
  private bkww jdField_a_of_type_Bkww;
  private blbr jdField_a_of_type_Blbr = new blbn();
  private bnlu jdField_a_of_type_Bnlu = new bnlu();
  private AEFilterManager.StickerInnerEffectFilterListener jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager$StickerInnerEffectFilterListener;
  private AudioCapture jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture;
  private VideoMaterial jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
  private volatile SensorUtil2 jdField_a_of_type_ComTencentTtpicUtilSensorUtil2;
  private AEVideoCaptureResult jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult;
  public AECaptureMode a;
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
  private boolean jdField_d_of_type_Boolean;
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
    blbo.a().a("glSurfaceViewConstruct-begin");
    s();
    this.jdField_m_of_type_Int = System.identityHashCode(this);
    blbo.a().a("glSurfaceViewConstruct-end");
  }
  
  private void A()
  {
    this.jdField_a_of_type_Bkve = new bkoa(this, getContext());
    if (this.jdField_a_of_type_Bkve.a()) {
      this.jdField_a_of_type_Bkve.a();
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
    if (bkoi.a().c()) {
      bkoi.a().a((Activity)getContext(), true);
    }
    Object localObject = this.jdField_a_of_type_Bkny.a + "/" + System.currentTimeMillis() + ".jpg";
    bdcs.c((String)localObject);
    localObject = new File((String)localObject);
    boolean bool = bkoi.a().b();
    int i1 = axld.c(this.jdField_e_of_type_Int);
    bkoi.a().a((File)localObject, i1, bool, this);
  }
  
  private void D()
  {
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_b_of_type_Long = 0L;
      this.jdField_c_of_type_Long = 0L;
      QLog.d("AECameraGLSurfaceView", 4, "onMediaCodecStopRecord");
      if (this.jdField_a_of_type_Bkwu != null)
      {
        QLog.d("AECameraGLSurfaceView", 4, "onMediaCodecStopRecord and aeExpressionRecognizer != null, release it");
        this.jdField_a_of_type_Bkwu.a(this.jdField_a_of_type_Bkww);
        this.jdField_a_of_type_Bkwu.b();
        this.jdField_a_of_type_Bkwu.c();
      }
    }
  }
  
  private void E()
  {
    if (!g()) {
      return;
    }
    bkov localbkov = (bkov)this.jdField_a_of_type_Bkoy;
    if ((localbkov.a()) && (!localbkov.b()) && (!this.jdField_i_of_type_Boolean))
    {
      this.jdField_g_of_type_Int += 1;
      if (this.jdField_g_of_type_Int >= 4)
      {
        a(localbkov.a(), localbkov.b());
        this.jdField_g_of_type_Int = 0;
      }
    }
    if ((!this.jdField_i_of_type_Boolean) && (localbkov.b())) {
      a(localbkov.a(), localbkov.b());
    }
    if (!localbkov.a()) {
      a(localbkov.a(), localbkov.b());
    }
    if ((this.jdField_i_of_type_Boolean) && (localbkov.b())) {
      a(localbkov.a(), localbkov.b());
    }
    this.jdField_i_of_type_Boolean = localbkov.b();
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (float)Math.sqrt((paramFloat1 - paramFloat3) * (paramFloat1 - paramFloat3) + (paramFloat2 - paramFloat4) * (paramFloat2 - paramFloat4));
  }
  
  private void a(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    long l1 = SystemClock.elapsedRealtimeNanos();
    if ((g()) && (i()))
    {
      b(3553, paramInt, paramArrayOfFloat1, paramArrayOfFloat2, l1);
      return;
    }
    a(3553, paramInt, paramArrayOfFloat1, paramArrayOfFloat2, l1);
  }
  
  private void a(axmn paramaxmn)
  {
    if (this.jdField_a_of_type_Bkof != null) {
      this.jdField_a_of_type_Bkof.a(paramaxmn);
    }
    ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.8(this));
  }
  
  private void a(VideoMaterial paramVideoMaterial)
  {
    if (this.jdField_a_of_type_Bkoc != null) {
      this.jdField_a_of_type_Bkoc.a(paramVideoMaterial);
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Bkoc != null) {
      this.jdField_a_of_type_Bkoc.a(paramBoolean1, paramBoolean2);
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
    int i1 = (int)(this.jdField_b_of_type_Int * 1.0F / this.jdField_a_of_type_Int * this.jdField_a_of_type_Bkny.c());
    if (bngq.a().e()) {
      i1 = this.jdField_a_of_type_Bkny.b();
    }
    if (this.jdField_c_of_type_Boolean)
    {
      arrayOfInt = axld.a(i1, paramInt1, paramInt2);
      arrayOfInt = axld.a(arrayOfInt[0], arrayOfInt[1], this.jdField_a_of_type_Bkny.d(), this.jdField_a_of_type_Bkny.e(), 1.0F);
      this.jdField_h_of_type_Int = arrayOfInt[0];
      this.jdField_i_of_type_Int = arrayOfInt[1];
      return;
    }
    int[] arrayOfInt = axld.a(paramInt1, paramInt2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Bkny.a());
    this.jdField_h_of_type_Int = arrayOfInt[0];
    this.jdField_i_of_type_Int = arrayOfInt[1];
    arrayOfInt = axld.a(i1, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int);
    this.jdField_h_of_type_Int = arrayOfInt[0];
    this.jdField_i_of_type_Int = arrayOfInt[1];
  }
  
  private void b(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (this.jdField_a_of_type_Bkoy == null) {}
    Object localObject;
    do
    {
      return;
      localObject = (bkov)this.jdField_a_of_type_Bkoy;
      if (this.jdField_b_of_type_Long == 0L)
      {
        QLog.d("AECameraGLSurfaceView", 4, "frameToMediaCodec, gifRecordStartTimestamp == 0");
        this.jdField_b_of_type_Long = paramLong;
        bkyt.jdField_a_of_type_JavaUtilList = new ArrayList();
        bkyt.b = new ArrayList();
      }
      paramInt2 = ((bkov)localObject).a(paramInt2);
    } while ((paramLong - this.jdField_b_of_type_Long) / 1000000L <= 83L * this.jdField_c_of_type_Long);
    QLog.d("AECameraGLSurfaceView", 4, new Object[] { "frameToMediaCodec, encode frame, gifRecordFrameIndex = ", Long.valueOf(this.jdField_c_of_type_Long) });
    this.jdField_c_of_type_Long += 1L;
    if (((bkov)localObject).a() != null)
    {
      localObject = (PTFaceAttr)((bkov)localObject).a().getFaceAttr();
      bkyt.jdField_a_of_type_JavaUtilList.add(((PTFaceAttr)localObject).getAllFacePoints());
      bkyt.b.add(((PTFaceAttr)localObject).getAllFaceAngles());
      bkyt.jdField_a_of_type_Double = ((PTFaceAttr)localObject).getFaceDetectScale();
    }
    a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, (paramLong / 1.5D));
  }
  
  private void c(int paramInt)
  {
    if ((i()) && (this.jdField_b_of_type_Long > 0L))
    {
      Object localObject = (bkov)this.jdField_a_of_type_Bkoy;
      if (this.jdField_a_of_type_Bkwu == null)
      {
        QLog.d("AECameraGLSurfaceView", 4, "recording gif, aeExpressionRecognizer == null, create it");
        this.jdField_a_of_type_Bkwu = new bkwu();
        this.jdField_a_of_type_Bkwu.a();
      }
      long l1 = (SystemClock.elapsedRealtimeNanos() - this.jdField_b_of_type_Long) / 1000000L;
      int i1 = this.jdField_a_of_type_Bkwu.a();
      QLog.d("AECameraGLSurfaceView", 4, "recording gif, aeExpressionRecognizer.getFrameCount() == " + i1);
      if ((i1 < 3) && ((float)l1 > (i1 + 0.5F) * 1000.0F) && (((bkov)localObject).b()))
      {
        localObject = (PTFaceAttr)((bkov)localObject).a().getFaceAttr();
        this.jdField_a_of_type_Bkwu.a(paramInt, (List)((PTFaceAttr)localObject).getAllFacePoints().get(0), (int)(this.jdField_j_of_type_Int * ((PTFaceAttr)localObject).getFaceDetectScale()), (int)(this.jdField_k_of_type_Int * ((PTFaceAttr)localObject).getFaceDetectScale()));
      }
    }
  }
  
  private void d(String paramString)
  {
    ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.11(this, paramString));
  }
  
  public static void e()
  {
    try
    {
      blfg.b("AECameraGLSurfaceView", "[initSdk] + BEGIN, isSdkInited = " + p);
      long l1 = System.currentTimeMillis();
      if (!p)
      {
        blfg.b("AECameraGLSurfaceView", "[initSdk] do init");
        p = true;
        blbo.a().a("glSurfaceViewStaticInit-begin");
        if (bkkj.a()) {
          VideoPrefsUtil.init(BaseApplicationImpl.getContext(), ShortVideoUtils.a());
        }
        blbo.a().a("glSurfaceViewStaticInit-end");
      }
      blfg.b("AECameraGLSurfaceView", "[initSdk] + END, time cost = " + (System.currentTimeMillis() - l1));
      return;
    }
    finally {}
  }
  
  private boolean e()
  {
    if (this.jdField_k_of_type_Boolean) {
      return true;
    }
    Context localContext = getContext();
    if ((localContext instanceof Activity)) {
      return bkwm.h(((Activity)localContext).getIntent());
    }
    return false;
  }
  
  private boolean f()
  {
    Activity localActivity = (Activity)getContext();
    if (Build.VERSION.SDK_INT < 23) {
      return true;
    }
    int i1 = localActivity.checkSelfPermission("android.permission.CAMERA");
    int i2 = localActivity.checkSelfPermission("android.permission.RECORD_AUDIO");
    boolean bool = ammv.a(localActivity);
    if ((i1 == 0) && (i2 == 0) && (bool)) {}
    for (bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean g()
  {
    return (FeatureManager.isBasicFeaturesFunctionReady()) && (this.jdField_a_of_type_Bkoy != null) && ((this.jdField_a_of_type_Bkoy instanceof bkov));
  }
  
  private boolean h()
  {
    if (!g()) {
      return true;
    }
    if (!((bkov)this.jdField_a_of_type_Bkoy).d()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean i()
  {
    return (this.jdField_k_of_type_Boolean) && (this.jdField_m_of_type_Boolean) && (this.jdField_a_of_type_Axqz != null);
  }
  
  private void s()
  {
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 0, 0);
    setEGLContextFactory(new bknz(this));
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
    if (this.jdField_a_of_type_Bkoy != null) {
      return;
    }
    blfg.b("AECameraGLSurfaceView", "createFilterProcess---BEGIN");
    if (FeatureManager.loadBasicFeatures())
    {
      this.jdField_a_of_type_Bkoy = new bkov(this.jdField_m_of_type_Int);
      blfg.b("AECameraGLSurfaceView", "createFilterProcess---create AEFilterProcessTex");
      return;
    }
    this.jdField_a_of_type_Bkoy = new bkoz();
    blfg.d("AECameraGLSurfaceView", "createFilterProcess---create NonAEFilterProcess");
  }
  
  private void v()
  {
    blbo.a().a("AECameraGLSurfaceView", "initFilterProcess---begin");
    if (this.jdField_a_of_type_Bkoy == null) {
      u();
    }
    if ((this.jdField_a_of_type_Bkoy instanceof bkov))
    {
      if (this.jdField_a_of_type_Bkod != null) {
        this.jdField_a_of_type_Bkod.a();
      }
      ((bkov)this.jdField_a_of_type_Bkoy).b(false);
      ((bkov)this.jdField_a_of_type_Bkoy).a(this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager$StickerInnerEffectFilterListener);
      ((bkov)this.jdField_a_of_type_Bkoy).a().setParam("SET_AEPROFILER_OBJ", this.jdField_a_of_type_Blbr);
    }
    bkoi.a().a(this.jdField_a_of_type_Bkoy.a());
    String str = FeatureManager.getResourceDir();
    if (!AIManager.installDetector(PTSegmenter.class, str, str)) {
      blfg.d("AECameraGLSurfaceView", "PTSegmenter install error.");
    }
    blbo.a().a("AECameraGLSurfaceView", "initFilterProcess---end");
  }
  
  private void w()
  {
    if ((this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null) && (VideoMaterialUtil.isAudio2textMaterial(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial))) {
      this.jdField_a_of_type_Bnlu.a(getContext(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_Bkoy != null)
    {
      this.jdField_a_of_type_Bkoy.e();
      this.jdField_a_of_type_Bkoy = null;
      if (jdField_n_of_type_Int == this.jdField_m_of_type_Int) {
        bkoi.a().f();
      }
    }
  }
  
  private void y()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    blfg.b("AECameraGLSurfaceView", "startPreview---");
    bkoi.a().b();
  }
  
  private void z()
  {
    A();
    this.jdField_a_of_type_Blbr.c();
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
      if (!this.jdField_a_of_type_Axjr.a()) {
        break label56;
      }
      this.jdField_a_of_type_Axjr.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bkof != null) {
        this.jdField_a_of_type_Bkof.n();
      }
      return;
      label56:
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    bkoi.a().a(paramFloat1, paramFloat2);
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
      localObject1 = axld.a(paramInt1, paramInt2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1.0F);
      localObject1 = axld.a(640, localObject1[0], localObject1[1]);
      i1 = localObject1[0];
      i2 = localObject1[1];
      this.jdField_j_of_type_Int = i1;
      this.jdField_k_of_type_Int = i2;
      this.jdField_h_of_type_Int = this.jdField_j_of_type_Int;
      this.jdField_i_of_type_Int = this.jdField_k_of_type_Int;
      if (this.jdField_a_of_type_Bkoy != null)
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
      this.jdField_a_of_type_Bkoy.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt1, paramInt2, i1, i2);
      bkoi.a().a(i1, i2);
      this.jdField_a_of_type_Bkoy.a(this.jdField_h_of_type_Int, this.jdField_i_of_type_Int);
      bkse.a.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      bkse.a.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      bkse.a.jdField_c_of_type_Int = Math.min(paramInt1, paramInt2);
      bkse.a.jdField_d_of_type_Int = Math.max(paramInt1, paramInt2);
      if (bkoi.a().d()) {}
      for (localObject1 = Camera2Control.a().c();; localObject1 = azcx.a().b())
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new azda();
        }
        bkse.a.jdField_e_of_type_Int = Math.min(((azda)localObject2).jdField_a_of_type_Int, ((azda)localObject2).jdField_b_of_type_Int);
        bkse.a.jdField_f_of_type_Int = Math.max(((azda)localObject2).jdField_a_of_type_Int, ((azda)localObject2).jdField_b_of_type_Int);
        if (this.jdField_a_of_type_Bkoy != null)
        {
          localObject1 = this.jdField_a_of_type_Bkoy.a();
          bkse.a.jdField_g_of_type_Int = localObject1[0];
          bkse.a.jdField_h_of_type_Int = localObject1[1];
          bkse.a.jdField_i_of_type_Int = localObject1[2];
          bkse.a.jdField_j_of_type_Int = localObject1[3];
        }
        bkse.a.jdField_m_of_type_Int = this.jdField_h_of_type_Int;
        bkse.a.jdField_n_of_type_Int = this.jdField_i_of_type_Int;
        if ((bkse.a()) && (this.jdField_a_of_type_Bksv != null)) {
          this.jdField_a_of_type_Bksv.x();
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
    if ((this.jdField_m_of_type_Boolean) && (this.jdField_a_of_type_Axqz != null))
    {
      switch (this.jdField_l_of_type_Int)
      {
      default: 
        throw new RuntimeException("unknown status " + this.jdField_l_of_type_Int);
      case 0: 
        this.jdField_a_of_type_Axqz.a(EGL14.eglGetCurrentContext());
        this.jdField_a_of_type_Axrn.a();
        this.jdField_a_of_type_Axrn.a(this.jdField_a_of_type_Axqz, this);
        this.jdField_l_of_type_Int = 1;
      }
      this.jdField_a_of_type_Axrn.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
      return;
    }
    switch (this.jdField_l_of_type_Int)
    {
    case 0: 
    default: 
      throw new RuntimeException("unknown status " + this.jdField_l_of_type_Int);
    }
    this.jdField_a_of_type_Axrn.b();
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
      blbo.a().a("onFrameAvailable");
    }
    if (this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2 != null) {
      this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2.getRotation(this.jdField_a_of_type_ArrayOfFloat);
    }
    queueEvent(new AECameraGLSurfaceView.4(this));
    requestRender();
  }
  
  public void a(bkny parambkny)
  {
    if (this.jdField_a_of_type_Bkny != null) {
      throw new RuntimeException("setCaptureParam is already called");
    }
    this.jdField_a_of_type_Bkny = parambkny;
    if (QLog.isColorLevel()) {
      QLog.d("AECameraGLSurfaceView", 2, "setCaptureParam : " + parambkny);
    }
    bkoi.a().a(this);
    bkoi.a().a(parambkny);
    this.jdField_a_of_type_Axrn = new axrn();
    this.jdField_a_of_type_Axlg = new axlg();
    bkoi.a().a(this.jdField_a_of_type_Axlg);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture = new AudioCapture(this.jdField_a_of_type_Bkny.a, 1, azds.q, azds.o, azds.p, this, bkoi.a().a());
    this.jdField_a_of_type_Axjr = new axjr(this.jdField_a_of_type_Bkny.a, azds.q, this);
    bkoi.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
    if (this.jdField_d_of_type_Boolean)
    {
      parambkny = this.jdField_a_of_type_Bkny.a + File.separator + System.currentTimeMillis() + ".aac";
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a(true, parambkny);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a(true);
    }
    this.jdField_a_of_type_Blbr.g();
    this.jdField_b_of_type_Boolean = true;
  }
  
  protected void a(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    int i1 = 1;
    if (this.jdField_a_of_type_Bkof != null) {
      this.jdField_a_of_type_Bkof.a(paramAEVideoCaptureResult);
    }
    ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.5(this));
    axlo.c();
    if (azcx.a().jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      axlc.i(i1);
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
      if (this.jdField_a_of_type_Axjr.a())
      {
        this.jdField_a_of_type_Axjr.b();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e();
      return;
    }
    paramString = this.jdField_a_of_type_Bkny.a + "/noaudio";
    bdcs.c(paramString);
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.audioDataFilePath = paramString;
    a(this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!PTSegmenter.SEGMENT.isFunctionReady()) && (paramBoolean)) {
      QQToast.a(BaseApplicationImpl.getContext(), alpo.a(2131689868), 0).a();
    }
    while (!g()) {
      return;
    }
    ((bkov)this.jdField_a_of_type_Bkoy).b(paramBoolean);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      blbo.a().a("onCameraStart");
    }
    blfg.b("AECameraGLSurfaceView", "onCameraStarted--success=" + paramBoolean + ", errMsg=" + paramString);
    if (this.jdField_a_of_type_Bkoe != null) {
      this.jdField_a_of_type_Bkoe.a(paramBoolean, paramString);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (ajpl.a().a()) {
      ajpl.a().a(paramArrayOfByte, paramInt1, paramInt2);
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
    this.jdField_a_of_type_Axjr.a(paramArrayOfByte, paramInt1, paramInt2);
    this.jdField_a_of_type_Bnlu.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public boolean a()
  {
    return bkoi.a().b();
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.errorCode = paramInt;
    if (this.jdField_a_of_type_Bkof != null) {
      this.jdField_a_of_type_Bkof.a(104);
    }
  }
  
  public void a_(String paramString)
  {
    a(new axmn(1, 0, paramString, null, this.jdField_d_of_type_Int));
  }
  
  public int b()
  {
    return bkoi.a().a();
  }
  
  public void b()
  {
    AEVideoCaptureResult localAEVideoCaptureResult = this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult;
    localAEVideoCaptureResult.videoFrameCount += 1;
  }
  
  public void b(int paramInt) {}
  
  public void b(String paramString)
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      blfg.a("AECameraGLSurfaceView", "onAudioCaptured---filePath=" + paramString);
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.audioDataFilePath = paramString;
      if (this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath != null) {
        a(this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
      }
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
      ajpl.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
      queueEvent(new AECameraGLSurfaceView.6(this));
    }
  }
  
  public void c(String paramString)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      blfg.a("AECameraGLSurfaceView", "onAudioCaptured---filePath=" + paramString);
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.audioDataFilePath = paramString;
      if (this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath != null) {
        a(this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
      }
    }
  }
  
  public boolean c()
  {
    return ((this.jdField_a_of_type_Bkoy instanceof bkov)) && (((bkov)this.jdField_a_of_type_Bkoy).a() != null) && (((bkov)this.jdField_a_of_type_Bkoy).a().getmPTSticker() != null) && (((bkov)this.jdField_a_of_type_Bkoy).a().getmPTSticker().needTouchTriggerEvent());
  }
  
  public void d()
  {
    ajpl.a().a(null);
  }
  
  public void f()
  {
    if (QLog.isDevelopLevel()) {
      blfg.a("AECameraGLSurfaceView", "### onDestroy, hashCode=" + this.jdField_m_of_type_Int + " ###");
    }
    if (this.jdField_a_of_type_Bnlu != null) {
      this.jdField_a_of_type_Bnlu.a();
    }
    bkou.a(null);
    if (this.jdField_a_of_type_Bkoy != null) {
      this.jdField_a_of_type_Bkoy.a(true);
    }
    if (jdField_n_of_type_Int == this.jdField_m_of_type_Int) {
      bkoi.a().b(e());
    }
    this.jdField_a_of_type_Blbr.h();
    if (this.jdField_a_of_type_Axrn != null) {
      this.jdField_a_of_type_Axrn.c();
    }
  }
  
  public void g() {}
  
  public void h()
  {
    if (!g()) {}
    while (this.jdField_a_of_type_Bkoy == null) {
      return;
    }
    queueEvent(new AECameraGLSurfaceView.14(this));
  }
  
  public void i()
  {
    this.jdField_a_of_type_Blbr.b();
    B();
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Bkoy != null) {
      this.jdField_a_of_type_Bkoy.a(false);
    }
    bkoi.a().c(e());
    this.jdField_a_of_type_Blbr.a(bkoi.a().b());
    if (this.jdField_k_of_type_Boolean) {}
    for (;;)
    {
      if (this.jdField_a_of_type_Bkoe != null) {
        this.jdField_a_of_type_Bkoe.c();
      }
      return;
      blen.a().s();
      blfg.b("AECameraGLSurfaceView", "【Change Camera】:isFrontCamera:" + bkoi.a().b());
    }
  }
  
  public void k()
  {
    if (h())
    {
      QLog.d("AECameraGLSurfaceView", 4, "capturePhotoByCameraProxy");
      bkse.a.jdField_b_of_type_Boolean = false;
      C();
    }
    for (;;)
    {
      this.jdField_a_of_type_Blbr.e();
      if (this.jdField_a_of_type_Bkof != null) {
        this.jdField_a_of_type_Bkof.m();
      }
      return;
      QLog.d("AECameraGLSurfaceView", 4, "capturePhotoByAEKit");
      bkse.a.jdField_b_of_type_Boolean = true;
      l();
    }
  }
  
  public void l()
  {
    int i1 = 0;
    if (bkoi.a().c())
    {
      bkoi.a().a((Activity)getContext(), true);
      i1 = 1500;
    }
    ThreadManager.getUIHandler().postDelayed(new AECameraGLSurfaceView.15(this), i1);
  }
  
  public void m()
  {
    blfg.b("AECameraGLSurfaceView", "startCaptureVideo---recordingEnabled=" + this.jdField_m_of_type_Boolean);
    this.jdField_a_of_type_Blbr.f();
    if ((bkoi.a().c()) && (!this.jdField_k_of_type_Boolean)) {
      bkoi.a().a((Activity)getContext(), true);
    }
    String str = this.jdField_a_of_type_Bkny.a + File.separator + System.currentTimeMillis() + ".mp4";
    if ((this.jdField_n_of_type_Boolean) && (!this.jdField_k_of_type_Boolean)) {}
    for (int i1 = axld.b(this.jdField_d_of_type_Int);; i1 = 0)
    {
      this.jdField_a_of_type_Axqz = new axqz(str, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, this.jdField_a_of_type_Bkny.a(), this.jdField_a_of_type_Bkny.f(), false, i1);
      this.jdField_a_of_type_Axqz.jdField_j_of_type_Int = this.jdField_a_of_type_Bkny.h();
      this.jdField_a_of_type_Axqz.jdField_k_of_type_Int = this.jdField_a_of_type_Bkny.i();
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult = new AEVideoCaptureResult();
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.startTimeMs = System.currentTimeMillis();
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.orientation = this.jdField_d_of_type_Int;
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.type = 0;
      if (bkoi.a().a() == 2) {
        bkoi.a().g();
      }
      this.jdField_m_of_type_Boolean = true;
      axld.a(false, false);
      return;
    }
  }
  
  public void n()
  {
    blfg.b("AECameraGLSurfaceView", "stopCaptureVideo---recordingEnabled=" + this.jdField_m_of_type_Boolean);
    if (this.jdField_m_of_type_Boolean)
    {
      this.jdField_m_of_type_Boolean = false;
      if (this.jdField_l_of_type_Int != 0) {
        break label72;
      }
      if (this.jdField_a_of_type_Bkof != null) {
        this.jdField_a_of_type_Bkof.a(102);
      }
    }
    for (;;)
    {
      bkoi.a().d();
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
    blfg.b("AECameraGLSurfaceView", "openCamera");
    bkoi.a().a();
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
        blbo.a().a(paramGL10);
      }
    }
    else
    {
      if (this.jdField_e_of_type_Boolean)
      {
        this.jdField_e_of_type_Boolean = false;
        z();
      }
      if (this.jdField_a_of_type_Bkoy != null) {
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
        blbo.a().a("FilterProcessInitFilters-begin");
      }
      this.jdField_a_of_type_Bkoy.d();
      if (this.jdField_f_of_type_Boolean) {
        blbo.a().a("FilterProcessInitFilters-end");
      }
      paramGL10 = this.jdField_a_of_type_Bkoy.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_k_of_type_Boolean);
      if (g())
      {
        bkov localbkov = (bkov)this.jdField_a_of_type_Bkoy;
        E();
        if (this.jdField_a_of_type_Bkqj != null) {
          this.jdField_a_of_type_Bkqj.a(bkoi.a().a(), localbkov.a());
        }
        c(paramGL10[1]);
      }
      this.jdField_a_of_type_Bkoy.c(paramGL10[0]);
      a(paramGL10[1], null, null);
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        queueEvent(new AECameraGLSurfaceView.9(this));
      }
      this.jdField_a_of_type_Blbr.d();
      if (!this.q)
      {
        this.q = true;
        bler.a().f();
        blen.a().I();
        if (bkse.a()) {
          bkse.a(this.jdField_a_of_type_Bksv, 5000L);
        }
        if (this.jdField_a_of_type_Bkoh != null) {
          this.jdField_a_of_type_Bkoh.a();
        }
      }
    } while (!this.jdField_f_of_type_Boolean);
    if (bool) {}
    for (paramGL10 = "onDrawFrameReal-end";; paramGL10 = "onDrawFrameFake-end" + this.jdField_f_of_type_Int)
    {
      blbo.a().a(paramGL10);
      if (!bool) {
        break;
      }
      this.jdField_f_of_type_Boolean = false;
      return;
    }
  }
  
  public void onPause()
  {
    blfg.b("AECameraGLSurfaceView", "[onPause] hashCode=" + this.jdField_m_of_type_Int + " ###");
    blfg.a("AECameraGLSurfaceView", "[onPause] TOP_SURFACE_HASH_CODE=" + jdField_n_of_type_Int + " ###");
    queueEvent(new AECameraGLSurfaceView.3(this));
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.PLAY) {}
    for (this.jdField_g_of_type_Boolean = true;; this.jdField_g_of_type_Boolean = false)
    {
      this.jdField_h_of_type_Boolean = true;
      if (jdField_n_of_type_Int == this.jdField_m_of_type_Int)
      {
        blfg.a("AECameraGLSurfaceView", "### onPause, execute stop camera TOP_SURFACE_HASH_CODE=mIdentityHashCode=" + jdField_n_of_type_Int + " ###");
        bkoi.a().c();
        bkoi.a().a(e());
      }
      if (this.jdField_a_of_type_Bkve != null) {
        this.jdField_a_of_type_Bkve.b();
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
    if (f()) {
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
        blfg.a("AECameraGLSurfaceView", "### onResume, hashCode=" + this.jdField_m_of_type_Int + " ###");
      }
      this.jdField_m_of_type_Boolean = false;
      bkoi.a().e();
      if ((this.jdField_a_of_type_Bkve != null) && (this.jdField_a_of_type_Bkve.a())) {
        this.jdField_a_of_type_Bkve.a();
      }
      return;
      if (this.jdField_g_of_type_Boolean) {
        blfg.b("AECameraGLSurfaceView", "no need request permission.");
      } else {
        this.jdField_a_of_type_Bkoe.b();
      }
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    blfg.b("AECameraGLSurfaceView", "[onSurfaceChanged] + BEGIN, width = " + paramInt1 + ", height = " + paramInt2);
    blbo.a().a("onSurfaceChanged-begin");
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    bkoi.a().b(paramInt1, paramInt2);
    r();
    if (this.jdField_a_of_type_Bkoy != null) {
      this.jdField_a_of_type_Bkoy.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 0, 0, paramInt1, paramInt2);
    }
    if (this.jdField_c_of_type_Int != 0) {
      setBeautyLevel(this.jdField_c_of_type_Int);
    }
    if (this.jdField_a_of_type_Bksd != null) {
      this.jdField_a_of_type_Bksd.a(paramInt1, paramInt2);
    }
    blbo.a().a("onSurfaceChanged-end");
    blfg.b("AECameraGLSurfaceView", "[onSurfaceChanged] + END, width = " + paramInt1 + ", height = " + paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    blfg.b("AECameraGLSurfaceView", "[onSurfaceCreated] + BEGIN");
    blbo.a().a("onSurfaceCreated-begin");
    jdField_n_of_type_Int = this.jdField_m_of_type_Int;
    v();
    blbo.a().a("onSurfaceCreated-end");
    blfg.b("AECameraGLSurfaceView", "[onSurfaceCreated] + END");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent == null) {
      return false;
    }
    if ((!g()) || (this.jdField_a_of_type_Bkpa == null)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    bkov localbkov = (bkov)this.jdField_a_of_type_Bkoy;
    if ((paramMotionEvent != null) && (localbkov.c()) && (!this.jdField_a_of_type_Bkpa.c()))
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
        queueEvent(new AECameraGLSurfaceView.19(this, localbkov, f1, f2, i1));
        continue;
        if (a(this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, f1, f2) > i1 * 0.05F)
        {
          queueEvent(new AECameraGLSurfaceView.20(this, localbkov, f1, f2, i1));
          continue;
          queueEvent(new AECameraGLSurfaceView.21(this, localbkov, f1, f2, i1));
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
    blfg.b("AECameraGLSurfaceView", "stopCamera");
    bkoi.a().a(e());
  }
  
  public void q()
  {
    blfg.b("AECameraGLSurfaceView", "cameraStopPreview");
    bkoi.a().c();
  }
  
  public void r()
  {
    blfg.b("AECameraGLSurfaceView", "[tryStartCameraPreview] + BEGIN");
    if (this.jdField_g_of_type_Boolean)
    {
      blfg.a("AECameraGLSurfaceView", "[tryStartCameraPreview] blockCameraFlag = " + this.jdField_g_of_type_Boolean);
      return;
    }
    if (this.jdField_h_of_type_Boolean)
    {
      blfg.a("AECameraGLSurfaceView", "[tryStartCameraPreview] isPaused = " + this.jdField_h_of_type_Boolean);
      return;
    }
    if (!f())
    {
      if (this.jdField_a_of_type_Bkoe != null) {
        this.jdField_a_of_type_Bkoe.b();
      }
      blfg.d("AECameraGLSurfaceView", "[tryStartCameraPreview] permission denied");
      return;
    }
    bkoi.a().a(this);
    o();
    y();
    blfg.b("AECameraGLSurfaceView", "[tryStartCameraPreview] + END");
  }
  
  public void setAECaptureController(bkpa parambkpa)
  {
    this.jdField_a_of_type_Bkpa = parambkpa;
  }
  
  public void setAEKitInitListener(bkod parambkod)
  {
    this.jdField_a_of_type_Bkod = parambkod;
  }
  
  public void setBeautyLevel(int paramInt)
  {
    if (!g())
    {
      blfg.b("AECameraGLSurfaceView", "[setBeautyLevel] level = " + paramInt + ", isAEKitAvailable is false");
      return;
    }
    this.jdField_c_of_type_Int = paramInt;
    queueEvent(new AECameraGLSurfaceView.16(this, paramInt));
  }
  
  public void setBlockCameraFlag(boolean paramBoolean)
  {
    blfg.b("AECameraGLSurfaceView", "setBlockCameraFlag---block=" + paramBoolean);
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void setCameraListener(bkoe parambkoe)
  {
    this.jdField_a_of_type_Bkoe = parambkoe;
  }
  
  public void setCameraPermissionResult(boolean paramBoolean)
  {
    blfg.b("AECameraGLSurfaceView", "setCameraPermissionResult---permissionRet=" + paramBoolean);
    if (paramBoolean) {
      r();
    }
  }
  
  public void setCaptureListener(bkof parambkof)
  {
    this.jdField_a_of_type_Bkof = parambkof;
  }
  
  public void setCaptureRequest(bkog parambkog)
  {
    if (this.jdField_a_of_type_Bkoy != null) {
      this.jdField_a_of_type_Bkoy.a(parambkog);
    }
  }
  
  public void setDarkModeEnable(boolean paramBoolean)
  {
    bkoi.a().d(paramBoolean);
  }
  
  public void setDarkModeListener(axlh paramaxlh)
  {
    bkoi.a().a(paramaxlh);
  }
  
  public void setDynamicResolutionMode(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    bkoi.a().e(paramBoolean);
  }
  
  public void setFaceEffectListener(bkoc parambkoc)
  {
    this.jdField_a_of_type_Bkoc = parambkoc;
  }
  
  public void setFilter(FilterCategoryItem paramFilterCategoryItem)
  {
    if (!g()) {}
    bkov localbkov;
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
            localbkov = (bkov)this.jdField_a_of_type_Bkoy;
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
    localbkov.a(paramFilterCategoryItem);
  }
  
  public void setIsGIFMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Blbr.b(paramBoolean);
    this.jdField_k_of_type_Boolean = paramBoolean;
  }
  
  public void setIsVoiceNeedEncode(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setLaunchStateCallback(bkoh parambkoh)
  {
    this.jdField_a_of_type_Bkoh = parambkoh;
  }
  
  public void setMaterial(String paramString)
  {
    ThreadManager.excute(new AECameraGLSurfaceView.13(this, new AECameraGLSurfaceView.12(this, paramString)), 64, null, true);
  }
  
  public void setMaterialMetaData(bkvu parambkvu)
  {
    if ((parambkvu == null) || (parambkvu.equals(bkvu.a)))
    {
      setMaterial(null);
      return;
    }
    setMaterial(parambkvu.a());
  }
  
  public void setOnFrameDraw(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public void setOnSurfaceChangedListener(bksd parambksd)
  {
    this.jdField_a_of_type_Bksd = parambksd;
  }
  
  public void setRecommendTextCallback(bkww parambkww)
  {
    this.jdField_a_of_type_Bkww = parambkww;
  }
  
  public void setSceneListener(bkqj parambkqj)
  {
    this.jdField_a_of_type_Bkqj = parambkqj;
  }
  
  public void setSharpFaceLevel(int paramInt)
  {
    if (!g()) {
      return;
    }
    queueEvent(new AECameraGLSurfaceView.17(this, paramInt));
  }
  
  public void setStickerInnerLutFilterListener(AEFilterManager.StickerInnerEffectFilterListener paramStickerInnerEffectFilterListener)
  {
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager$StickerInnerEffectFilterListener = paramStickerInnerEffectFilterListener;
    if ((this.jdField_a_of_type_Bkoy != null) && ((this.jdField_a_of_type_Bkoy instanceof bkov))) {
      ((bkov)this.jdField_a_of_type_Bkoy).a(paramStickerInnerEffectFilterListener);
    }
  }
  
  public void setTapEvent(int paramInt, float paramFloat1, float paramFloat2)
  {
    queueEvent(new AECameraGLSurfaceView.TapRunnable(this, paramInt, paramFloat1 / this.jdField_a_of_type_Int, paramFloat2 / this.jdField_b_of_type_Int));
  }
  
  public void setZoom(int paramInt)
  {
    bkoi.a().a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */