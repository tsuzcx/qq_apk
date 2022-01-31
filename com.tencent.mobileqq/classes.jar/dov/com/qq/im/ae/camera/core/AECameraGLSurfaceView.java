package dov.com.qq.im.ae.camera.core;

import ajua;
import ajwh;
import alud;
import amrk;
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
import axnz;
import axoa;
import axpl;
import axpm;
import axpp;
import axpq;
import axpx;
import axqw;
import axvi;
import axvu;
import axvw;
import azhg;
import azhj;
import azib;
import bdhb;
import bkoq;
import bksf;
import bksg;
import bksh;
import bksj;
import bksk;
import bksl;
import bksm;
import bksn;
import bkso;
import bksp;
import bkss;
import bktb;
import bktc;
import bkte;
import bktf;
import bktg;
import bkth;
import bkuq;
import bkwk;
import bkwl;
import bkxc;
import bkzl;
import blab;
import blat;
import blbb;
import blbd;
import blda;
import blfu;
import blfv;
import blfy;
import bliu;
import bliy;
import bljn;
import bnlc;
import bnqg;
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
  implements ajwh, GLSurfaceView.Renderer, axnz, axvu, bkss, bkte
{
  private static int jdField_n_of_type_Int;
  private static volatile boolean p;
  private int jdField_a_of_type_Int = 320;
  private final long jdField_a_of_type_Long = 83L;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF(0.0F, 0.0F);
  private axoa jdField_a_of_type_Axoa;
  private axpp jdField_a_of_type_Axpp;
  private axvi jdField_a_of_type_Axvi;
  private axvw jdField_a_of_type_Axvw;
  private bksf jdField_a_of_type_Bksf;
  private bksj jdField_a_of_type_Bksj;
  private bksk jdField_a_of_type_Bksk;
  private bksl jdField_a_of_type_Bksl;
  private bksm jdField_a_of_type_Bksm;
  private bkso jdField_a_of_type_Bkso;
  private bktf jdField_a_of_type_Bktf;
  private bkth jdField_a_of_type_Bkth;
  private bkuq jdField_a_of_type_Bkuq;
  private bkwk jdField_a_of_type_Bkwk;
  public bkxc a;
  private bkzl jdField_a_of_type_Bkzl;
  private blbb jdField_a_of_type_Blbb;
  private blbd jdField_a_of_type_Blbd;
  private blfy jdField_a_of_type_Blfy = new blfu();
  private bnqg jdField_a_of_type_Bnqg = new bnqg();
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
  private boolean r;
  
  public AECameraGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    s();
    this.jdField_m_of_type_Int = System.identityHashCode(this);
  }
  
  public AECameraGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    blfv.a().a("glSurfaceViewConstruct-begin");
    s();
    this.jdField_m_of_type_Int = System.identityHashCode(this);
    blfv.a().a("glSurfaceViewConstruct-end");
  }
  
  private void A()
  {
    this.jdField_a_of_type_Bkzl = new bksh(this, getContext());
    if (this.jdField_a_of_type_Bkzl.a()) {
      this.jdField_a_of_type_Bkzl.a();
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
    if (bksp.a().c()) {
      bksp.a().a((Activity)getContext(), true);
    }
    Object localObject = this.jdField_a_of_type_Bksf.a + "/" + System.currentTimeMillis() + ".jpg";
    bdhb.c((String)localObject);
    localObject = new File((String)localObject);
    boolean bool = bksp.a().b();
    int i1 = axpm.c(this.jdField_e_of_type_Int);
    bksp.a().a((File)localObject, i1, bool, this);
  }
  
  private void D()
  {
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_b_of_type_Long = 0L;
      this.jdField_c_of_type_Long = 0L;
      QLog.d("AECameraGLSurfaceView", 4, "onMediaCodecStopRecord");
      if (this.jdField_a_of_type_Blbb != null)
      {
        QLog.d("AECameraGLSurfaceView", 4, "onMediaCodecStopRecord and aeExpressionRecognizer != null, release it");
        this.jdField_a_of_type_Blbb.a(this.jdField_a_of_type_Blbd);
        this.jdField_a_of_type_Blbb.b();
        this.jdField_a_of_type_Blbb.c();
      }
    }
  }
  
  private void E()
  {
    if (!g()) {
      return;
    }
    bktc localbktc = (bktc)this.jdField_a_of_type_Bktf;
    if ((localbktc.a()) && (!localbktc.b()) && (!this.jdField_i_of_type_Boolean))
    {
      this.jdField_g_of_type_Int += 1;
      if (this.jdField_g_of_type_Int >= 4)
      {
        a(localbktc.a(), localbktc.b());
        this.jdField_g_of_type_Int = 0;
      }
    }
    if ((!this.jdField_i_of_type_Boolean) && (localbktc.b())) {
      a(localbktc.a(), localbktc.b());
    }
    if (!localbktc.a()) {
      a(localbktc.a(), localbktc.b());
    }
    if ((this.jdField_i_of_type_Boolean) && (localbktc.b())) {
      a(localbktc.a(), localbktc.b());
    }
    this.jdField_i_of_type_Boolean = localbktc.b();
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
  
  private void a(axqw paramaxqw)
  {
    if (this.jdField_a_of_type_Bksm != null) {
      this.jdField_a_of_type_Bksm.a(paramaxqw);
    }
    ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.8(this));
  }
  
  private void a(VideoMaterial paramVideoMaterial)
  {
    if (this.jdField_a_of_type_Bksj != null) {
      this.jdField_a_of_type_Bksj.a(paramVideoMaterial);
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Bksj != null) {
      this.jdField_a_of_type_Bksj.a(paramBoolean1, paramBoolean2);
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
    int i1 = (int)(this.jdField_b_of_type_Int * 1.0F / this.jdField_a_of_type_Int * this.jdField_a_of_type_Bksf.c());
    if (bnlc.a().e()) {
      i1 = this.jdField_a_of_type_Bksf.b();
    }
    if (this.jdField_c_of_type_Boolean)
    {
      arrayOfInt = axpm.a(i1, paramInt1, paramInt2);
      arrayOfInt = axpm.a(arrayOfInt[0], arrayOfInt[1], this.jdField_a_of_type_Bksf.d(), this.jdField_a_of_type_Bksf.e(), 1.0F);
      this.jdField_h_of_type_Int = arrayOfInt[0];
      this.jdField_i_of_type_Int = arrayOfInt[1];
      return;
    }
    int[] arrayOfInt = axpm.a(paramInt1, paramInt2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Bksf.a());
    this.jdField_h_of_type_Int = arrayOfInt[0];
    this.jdField_i_of_type_Int = arrayOfInt[1];
    arrayOfInt = axpm.a(i1, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int);
    this.jdField_h_of_type_Int = arrayOfInt[0];
    this.jdField_i_of_type_Int = arrayOfInt[1];
  }
  
  private void b(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (this.jdField_a_of_type_Bktf == null) {}
    Object localObject;
    do
    {
      return;
      localObject = (bktc)this.jdField_a_of_type_Bktf;
      if (this.jdField_b_of_type_Long == 0L)
      {
        QLog.d("AECameraGLSurfaceView", 4, "frameToMediaCodec, gifRecordStartTimestamp == 0");
        this.jdField_b_of_type_Long = paramLong;
        blda.jdField_a_of_type_JavaUtilList = new ArrayList();
        blda.b = new ArrayList();
      }
      paramInt2 = ((bktc)localObject).a(paramInt2);
    } while ((paramLong - this.jdField_b_of_type_Long) / 1000000L <= 83L * this.jdField_c_of_type_Long);
    QLog.d("AECameraGLSurfaceView", 4, new Object[] { "frameToMediaCodec, encode frame, gifRecordFrameIndex = ", Long.valueOf(this.jdField_c_of_type_Long) });
    this.jdField_c_of_type_Long += 1L;
    if (((bktc)localObject).a() != null)
    {
      localObject = (PTFaceAttr)((bktc)localObject).a().getFaceAttr();
      blda.jdField_a_of_type_JavaUtilList.add(((PTFaceAttr)localObject).getAllFacePoints());
      blda.b.add(((PTFaceAttr)localObject).getAllFaceAngles());
      blda.jdField_a_of_type_Double = ((PTFaceAttr)localObject).getFaceDetectScale();
    }
    a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, (paramLong / 1.5D));
  }
  
  private void c(int paramInt)
  {
    if ((i()) && (this.jdField_b_of_type_Long > 0L))
    {
      Object localObject = (bktc)this.jdField_a_of_type_Bktf;
      if (this.jdField_a_of_type_Blbb == null)
      {
        QLog.d("AECameraGLSurfaceView", 4, "recording gif, aeExpressionRecognizer == null, create it");
        this.jdField_a_of_type_Blbb = new blbb();
        this.jdField_a_of_type_Blbb.a();
      }
      long l1 = (SystemClock.elapsedRealtimeNanos() - this.jdField_b_of_type_Long) / 1000000L;
      int i1 = this.jdField_a_of_type_Blbb.a();
      QLog.d("AECameraGLSurfaceView", 4, "recording gif, aeExpressionRecognizer.getFrameCount() == " + i1);
      if ((i1 < 3) && ((float)l1 > (i1 + 0.5F) * 1000.0F) && (((bktc)localObject).b()))
      {
        localObject = (PTFaceAttr)((bktc)localObject).a().getFaceAttr();
        this.jdField_a_of_type_Blbb.a(paramInt, (List)((PTFaceAttr)localObject).getAllFacePoints().get(0), (int)(this.jdField_j_of_type_Int * ((PTFaceAttr)localObject).getFaceDetectScale()), (int)(this.jdField_k_of_type_Int * ((PTFaceAttr)localObject).getFaceDetectScale()));
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
      bljn.b("AECameraGLSurfaceView", "[initSdk] + BEGIN, isSdkInited = " + p);
      long l1 = System.currentTimeMillis();
      if (!p)
      {
        bljn.b("AECameraGLSurfaceView", "[initSdk] do init");
        p = true;
        blfv.a().a("glSurfaceViewStaticInit-begin");
        if (bkoq.a()) {
          VideoPrefsUtil.init(BaseApplicationImpl.getContext(), ShortVideoUtils.a());
        }
        blfv.a().a("glSurfaceViewStaticInit-end");
      }
      bljn.b("AECameraGLSurfaceView", "[initSdk] + END, time cost = " + (System.currentTimeMillis() - l1));
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
      return blat.h(((Activity)localContext).getIntent());
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
    boolean bool = amrk.a(localActivity);
    if ((i1 == 0) && (i2 == 0) && (bool)) {}
    for (bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean g()
  {
    return (FeatureManager.isBasicFeaturesFunctionReady()) && (this.jdField_a_of_type_Bktf != null) && ((this.jdField_a_of_type_Bktf instanceof bktc));
  }
  
  private boolean h()
  {
    if (!g()) {
      return true;
    }
    if (!((bktc)this.jdField_a_of_type_Bktf).d()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean i()
  {
    return (this.jdField_k_of_type_Boolean) && (this.jdField_m_of_type_Boolean) && (this.jdField_a_of_type_Axvi != null);
  }
  
  private void s()
  {
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 0, 0);
    setEGLContextFactory(new bksg(this));
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
    if (this.jdField_a_of_type_Bktf != null) {
      return;
    }
    bljn.b("AECameraGLSurfaceView", "createFilterProcess---BEGIN");
    if (FeatureManager.loadBasicFeatures())
    {
      this.jdField_a_of_type_Bktf = new bktc(this.jdField_m_of_type_Int);
      bljn.b("AECameraGLSurfaceView", "createFilterProcess---create AEFilterProcessTex");
      return;
    }
    this.jdField_a_of_type_Bktf = new bktg();
    bljn.d("AECameraGLSurfaceView", "createFilterProcess---create NonAEFilterProcess");
  }
  
  private void v()
  {
    blfv.a().a("AECameraGLSurfaceView", "initFilterProcess---begin");
    if (this.jdField_a_of_type_Bktf == null) {
      u();
    }
    if ((this.jdField_a_of_type_Bktf instanceof bktc))
    {
      if (this.jdField_a_of_type_Bksk != null) {
        this.jdField_a_of_type_Bksk.a();
      }
      ((bktc)this.jdField_a_of_type_Bktf).b(false);
      ((bktc)this.jdField_a_of_type_Bktf).a(this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager$StickerInnerEffectFilterListener);
      ((bktc)this.jdField_a_of_type_Bktf).a().setParam("SET_AEPROFILER_OBJ", this.jdField_a_of_type_Blfy);
    }
    bksp.a().a(this.jdField_a_of_type_Bktf.a());
    String str = FeatureManager.getResourceDir();
    if (!AIManager.installDetector(PTSegmenter.class, str, str)) {
      bljn.d("AECameraGLSurfaceView", "PTSegmenter install error.");
    }
    blfv.a().a("AECameraGLSurfaceView", "initFilterProcess---end");
  }
  
  private void w()
  {
    if ((this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null) && (VideoMaterialUtil.isAudio2textMaterial(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial))) {
      this.jdField_a_of_type_Bnqg.a(getContext(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_Bktf != null)
    {
      this.jdField_a_of_type_Bktf.e();
      this.jdField_a_of_type_Bktf = null;
      if (jdField_n_of_type_Int == this.jdField_m_of_type_Int) {
        bksp.a().f();
      }
    }
  }
  
  private void y()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    bljn.b("AECameraGLSurfaceView", "startPreview---");
    bksp.a().b();
  }
  
  private void z()
  {
    A();
    this.jdField_a_of_type_Blfy.c();
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
      if (!this.jdField_a_of_type_Axoa.a()) {
        break label56;
      }
      this.jdField_a_of_type_Axoa.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bksm != null) {
        this.jdField_a_of_type_Bksm.n();
      }
      return;
      label56:
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    bksp.a().a(paramFloat1, paramFloat2);
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
      localObject1 = axpm.a(paramInt1, paramInt2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1.0F);
      localObject1 = axpm.a(640, localObject1[0], localObject1[1]);
      i1 = localObject1[0];
      i2 = localObject1[1];
      this.jdField_j_of_type_Int = i1;
      this.jdField_k_of_type_Int = i2;
      this.jdField_h_of_type_Int = this.jdField_j_of_type_Int;
      this.jdField_i_of_type_Int = this.jdField_k_of_type_Int;
      if (this.jdField_a_of_type_Bktf != null)
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
      this.jdField_a_of_type_Bktf.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt1, paramInt2, i1, i2);
      bksp.a().a(i1, i2);
      this.jdField_a_of_type_Bktf.a(this.jdField_h_of_type_Int, this.jdField_i_of_type_Int);
      bkwl.a.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      bkwl.a.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      bkwl.a.jdField_c_of_type_Int = Math.min(paramInt1, paramInt2);
      bkwl.a.jdField_d_of_type_Int = Math.max(paramInt1, paramInt2);
      if (bksp.a().d()) {}
      for (localObject1 = Camera2Control.a().c();; localObject1 = azhg.a().b())
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new azhj();
        }
        bkwl.a.jdField_e_of_type_Int = Math.min(((azhj)localObject2).jdField_a_of_type_Int, ((azhj)localObject2).jdField_b_of_type_Int);
        bkwl.a.jdField_f_of_type_Int = Math.max(((azhj)localObject2).jdField_a_of_type_Int, ((azhj)localObject2).jdField_b_of_type_Int);
        if (this.jdField_a_of_type_Bktf != null)
        {
          localObject1 = this.jdField_a_of_type_Bktf.a();
          bkwl.a.jdField_g_of_type_Int = localObject1[0];
          bkwl.a.jdField_h_of_type_Int = localObject1[1];
          bkwl.a.jdField_i_of_type_Int = localObject1[2];
          bkwl.a.jdField_j_of_type_Int = localObject1[3];
        }
        bkwl.a.jdField_m_of_type_Int = this.jdField_h_of_type_Int;
        bkwl.a.jdField_n_of_type_Int = this.jdField_i_of_type_Int;
        if ((bkwl.a()) && (this.jdField_a_of_type_Bkxc != null)) {
          this.jdField_a_of_type_Bkxc.x();
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
    if ((this.jdField_m_of_type_Boolean) && (this.jdField_a_of_type_Axvi != null))
    {
      switch (this.jdField_l_of_type_Int)
      {
      default: 
        throw new RuntimeException("unknown status " + this.jdField_l_of_type_Int);
      case 0: 
        this.jdField_a_of_type_Axvi.a(EGL14.eglGetCurrentContext());
        this.jdField_a_of_type_Axvw.a();
        this.jdField_a_of_type_Axvw.a(this.jdField_a_of_type_Axvi, this);
        this.jdField_l_of_type_Int = 1;
      }
      this.jdField_a_of_type_Axvw.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
      return;
    }
    switch (this.jdField_l_of_type_Int)
    {
    case 0: 
    default: 
      throw new RuntimeException("unknown status " + this.jdField_l_of_type_Int);
    }
    this.jdField_a_of_type_Axvw.b();
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
      blfv.a().a("onFrameAvailable");
    }
    if (this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2 != null) {
      this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2.getRotation(this.jdField_a_of_type_ArrayOfFloat);
    }
    queueEvent(new AECameraGLSurfaceView.4(this));
    requestRender();
  }
  
  public void a(bksf parambksf)
  {
    if (this.jdField_a_of_type_Bksf != null) {
      throw new RuntimeException("setCaptureParam is already called");
    }
    this.jdField_a_of_type_Bksf = parambksf;
    if (QLog.isColorLevel()) {
      QLog.d("AECameraGLSurfaceView", 2, "setCaptureParam : " + parambksf);
    }
    bksp.a().a(this);
    bksp.a().a(parambksf);
    this.jdField_a_of_type_Axvw = new axvw();
    this.jdField_a_of_type_Axpp = new axpp();
    bksp.a().a(this.jdField_a_of_type_Axpp);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture = new AudioCapture(this.jdField_a_of_type_Bksf.a, 1, azib.q, azib.o, azib.p, this, bksp.a().a());
    this.jdField_a_of_type_Axoa = new axoa(this.jdField_a_of_type_Bksf.a, azib.q, this);
    bksp.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
    if (this.jdField_d_of_type_Boolean)
    {
      parambksf = this.jdField_a_of_type_Bksf.a + File.separator + System.currentTimeMillis() + ".aac";
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a(true, parambksf);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a(true);
    }
    this.jdField_a_of_type_Blfy.g();
    this.jdField_b_of_type_Boolean = true;
  }
  
  protected void a(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    int i1 = 1;
    if (this.jdField_a_of_type_Bksm != null) {
      this.jdField_a_of_type_Bksm.a(paramAEVideoCaptureResult);
    }
    ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.5(this));
    axpx.c();
    if (azhg.a().jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      axpl.i(i1);
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
      if (this.jdField_a_of_type_Axoa.a())
      {
        this.jdField_a_of_type_Axoa.b();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e();
      return;
    }
    paramString = this.jdField_a_of_type_Bksf.a + "/noaudio";
    bdhb.c(paramString);
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.audioDataFilePath = paramString;
    a(this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!PTSegmenter.SEGMENT.isFunctionReady()) && (paramBoolean)) {
      QQToast.a(BaseApplicationImpl.getContext(), alud.a(2131689868), 0).a();
    }
    while (!g()) {
      return;
    }
    ((bktc)this.jdField_a_of_type_Bktf).b(paramBoolean);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      blfv.a().a("onCameraStart");
    }
    bljn.b("AECameraGLSurfaceView", "onCameraStarted--success=" + paramBoolean + ", errMsg=" + paramString);
    if (this.jdField_a_of_type_Bksl != null) {
      this.jdField_a_of_type_Bksl.a(paramBoolean, paramString);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (ajua.a().a()) {
      ajua.a().a(paramArrayOfByte, paramInt1, paramInt2);
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
    this.jdField_a_of_type_Axoa.a(paramArrayOfByte, paramInt1, paramInt2);
    this.jdField_a_of_type_Bnqg.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public boolean a()
  {
    return bksp.a().b();
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.errorCode = paramInt;
    if (this.jdField_a_of_type_Bksm != null) {
      this.jdField_a_of_type_Bksm.a(104);
    }
  }
  
  public void a_(String paramString)
  {
    a(new axqw(1, 0, paramString, null, this.jdField_d_of_type_Int));
  }
  
  public int b()
  {
    return bksp.a().a();
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
      bljn.a("AECameraGLSurfaceView", "onAudioCaptured---filePath=" + paramString);
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
      ajua.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
      queueEvent(new AECameraGLSurfaceView.6(this));
    }
  }
  
  public void c(String paramString)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      bljn.a("AECameraGLSurfaceView", "onAudioCaptured---filePath=" + paramString);
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.audioDataFilePath = paramString;
      if (this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath != null) {
        a(this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
      }
    }
  }
  
  public boolean c()
  {
    return ((this.jdField_a_of_type_Bktf instanceof bktc)) && (((bktc)this.jdField_a_of_type_Bktf).a() != null) && (((bktc)this.jdField_a_of_type_Bktf).a().getmPTSticker() != null) && (((bktc)this.jdField_a_of_type_Bktf).a().getmPTSticker().needTouchTriggerEvent());
  }
  
  public void d()
  {
    ajua.a().a(null);
  }
  
  public void f()
  {
    if (QLog.isDevelopLevel()) {
      bljn.a("AECameraGLSurfaceView", "### onDestroy, hashCode=" + this.jdField_m_of_type_Int + " ###");
    }
    if (this.jdField_a_of_type_Bnqg != null) {
      this.jdField_a_of_type_Bnqg.a();
    }
    bktb.a(null);
    if (this.jdField_a_of_type_Bktf != null) {
      this.jdField_a_of_type_Bktf.a(true);
    }
    if (jdField_n_of_type_Int == this.jdField_m_of_type_Int) {
      bksp.a().b(e());
    }
    this.jdField_a_of_type_Blfy.h();
    if (this.jdField_a_of_type_Axvw != null) {
      this.jdField_a_of_type_Axvw.c();
    }
  }
  
  public void g() {}
  
  public void h()
  {
    if (!g()) {}
    while (this.jdField_a_of_type_Bktf == null) {
      return;
    }
    queueEvent(new AECameraGLSurfaceView.14(this));
  }
  
  public void i()
  {
    this.jdField_a_of_type_Blfy.b();
    B();
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Bktf != null) {
      this.jdField_a_of_type_Bktf.a(false);
    }
    bksp.a().c(e());
    this.jdField_a_of_type_Blfy.a(bksp.a().b());
    if (this.jdField_k_of_type_Boolean) {}
    for (;;)
    {
      if (this.jdField_a_of_type_Bksl != null) {
        this.jdField_a_of_type_Bksl.c();
      }
      return;
      bliu.a().s();
      bljn.b("AECameraGLSurfaceView", "【Change Camera】:isFrontCamera:" + bksp.a().b());
    }
  }
  
  public void k()
  {
    if (h())
    {
      QLog.d("AECameraGLSurfaceView", 4, "capturePhotoByCameraProxy");
      bkwl.a.jdField_b_of_type_Boolean = false;
      C();
    }
    for (;;)
    {
      this.jdField_a_of_type_Blfy.e();
      if (this.jdField_a_of_type_Bksm != null) {
        this.jdField_a_of_type_Bksm.m();
      }
      return;
      QLog.d("AECameraGLSurfaceView", 4, "capturePhotoByAEKit");
      bkwl.a.jdField_b_of_type_Boolean = true;
      l();
    }
  }
  
  public void l()
  {
    int i1 = 0;
    if (bksp.a().c())
    {
      bksp.a().a((Activity)getContext(), true);
      i1 = 1500;
    }
    ThreadManager.getUIHandler().postDelayed(new AECameraGLSurfaceView.15(this), i1);
  }
  
  public void m()
  {
    bljn.b("AECameraGLSurfaceView", "startCaptureVideo---recordingEnabled=" + this.jdField_m_of_type_Boolean);
    this.jdField_a_of_type_Blfy.f();
    if ((bksp.a().c()) && (!this.jdField_k_of_type_Boolean)) {
      bksp.a().a((Activity)getContext(), true);
    }
    String str = this.jdField_a_of_type_Bksf.a + File.separator + System.currentTimeMillis() + ".mp4";
    if ((this.jdField_n_of_type_Boolean) && (!this.jdField_k_of_type_Boolean)) {}
    for (int i1 = axpm.b(this.jdField_d_of_type_Int);; i1 = 0)
    {
      this.jdField_a_of_type_Axvi = new axvi(str, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, this.jdField_a_of_type_Bksf.a(), this.jdField_a_of_type_Bksf.f(), false, i1);
      this.jdField_a_of_type_Axvi.jdField_j_of_type_Int = this.jdField_a_of_type_Bksf.h();
      this.jdField_a_of_type_Axvi.jdField_k_of_type_Int = this.jdField_a_of_type_Bksf.i();
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult = new AEVideoCaptureResult();
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.startTimeMs = System.currentTimeMillis();
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.orientation = this.jdField_d_of_type_Int;
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.type = 0;
      if (bksp.a().a() == 2) {
        bksp.a().g();
      }
      this.jdField_m_of_type_Boolean = true;
      axpm.a(false, false);
      return;
    }
  }
  
  public void n()
  {
    bljn.b("AECameraGLSurfaceView", "stopCaptureVideo---recordingEnabled=" + this.jdField_m_of_type_Boolean);
    if (this.jdField_m_of_type_Boolean)
    {
      this.jdField_m_of_type_Boolean = false;
      if (this.jdField_l_of_type_Int != 0) {
        break label72;
      }
      if (this.jdField_a_of_type_Bksm != null) {
        this.jdField_a_of_type_Bksm.a(102);
      }
    }
    for (;;)
    {
      bksp.a().d();
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
    bljn.b("AECameraGLSurfaceView", "openCamera");
    bksp.a().a();
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
        blfv.a().a(paramGL10);
      }
    }
    else
    {
      if (this.jdField_e_of_type_Boolean)
      {
        this.jdField_e_of_type_Boolean = false;
        z();
      }
      if (this.jdField_a_of_type_Bktf != null) {
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
        blfv.a().a("FilterProcessInitFilters-begin");
      }
      this.jdField_a_of_type_Bktf.d();
      if (this.jdField_f_of_type_Boolean) {
        blfv.a().a("FilterProcessInitFilters-end");
      }
      paramGL10 = this.jdField_a_of_type_Bktf.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_k_of_type_Boolean);
      if (g())
      {
        bktc localbktc = (bktc)this.jdField_a_of_type_Bktf;
        E();
        if (this.jdField_a_of_type_Bkuq != null) {
          this.jdField_a_of_type_Bkuq.a(bksp.a().a(), localbktc.a());
        }
        c(paramGL10[1]);
      }
      if ((this.r) && (!this.jdField_k_of_type_Boolean)) {
        this.jdField_a_of_type_Bktf.c(paramGL10[1]);
      }
      a(paramGL10[1], null, null);
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        queueEvent(new AECameraGLSurfaceView.9(this));
      }
      this.jdField_a_of_type_Blfy.d();
      if (!this.q)
      {
        this.q = true;
        bliy.a().f();
        bliu.a().I();
        if (bkwl.a()) {
          bkwl.a(this.jdField_a_of_type_Bkxc, 5000L);
        }
        if (this.jdField_a_of_type_Bkso != null) {
          this.jdField_a_of_type_Bkso.a();
        }
      }
    } while (!this.jdField_f_of_type_Boolean);
    if (bool) {}
    for (paramGL10 = "onDrawFrameReal-end";; paramGL10 = "onDrawFrameFake-end" + this.jdField_f_of_type_Int)
    {
      blfv.a().a(paramGL10);
      if (!bool) {
        break;
      }
      this.jdField_f_of_type_Boolean = false;
      return;
    }
  }
  
  public void onPause()
  {
    bljn.b("AECameraGLSurfaceView", "[onPause] hashCode=" + this.jdField_m_of_type_Int + " ###");
    bljn.a("AECameraGLSurfaceView", "[onPause] TOP_SURFACE_HASH_CODE=" + jdField_n_of_type_Int + " ###");
    queueEvent(new AECameraGLSurfaceView.3(this));
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.PLAY) {}
    for (this.jdField_g_of_type_Boolean = true;; this.jdField_g_of_type_Boolean = false)
    {
      this.jdField_h_of_type_Boolean = true;
      if (jdField_n_of_type_Int == this.jdField_m_of_type_Int)
      {
        bljn.a("AECameraGLSurfaceView", "### onPause, execute stop camera TOP_SURFACE_HASH_CODE=mIdentityHashCode=" + jdField_n_of_type_Int + " ###");
        bksp.a().c();
        bksp.a().a(e());
      }
      if (this.jdField_a_of_type_Bkzl != null) {
        this.jdField_a_of_type_Bkzl.b();
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
        bljn.a("AECameraGLSurfaceView", "### onResume, hashCode=" + this.jdField_m_of_type_Int + " ###");
      }
      this.jdField_m_of_type_Boolean = false;
      bksp.a().e();
      if ((this.jdField_a_of_type_Bkzl != null) && (this.jdField_a_of_type_Bkzl.a())) {
        this.jdField_a_of_type_Bkzl.a();
      }
      return;
      if (this.jdField_g_of_type_Boolean) {
        bljn.b("AECameraGLSurfaceView", "no need request permission.");
      } else {
        this.jdField_a_of_type_Bksl.b();
      }
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    bljn.b("AECameraGLSurfaceView", "[onSurfaceChanged] + BEGIN, width = " + paramInt1 + ", height = " + paramInt2);
    blfv.a().a("onSurfaceChanged-begin");
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    bksp.a().b(paramInt1, paramInt2);
    r();
    if (this.jdField_a_of_type_Bktf != null) {
      this.jdField_a_of_type_Bktf.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 0, 0, paramInt1, paramInt2);
    }
    if (this.jdField_c_of_type_Int != 0) {
      setBeautyLevel(this.jdField_c_of_type_Int);
    }
    if (this.jdField_a_of_type_Bkwk != null) {
      this.jdField_a_of_type_Bkwk.a(paramInt1, paramInt2);
    }
    blfv.a().a("onSurfaceChanged-end");
    bljn.b("AECameraGLSurfaceView", "[onSurfaceChanged] + END, width = " + paramInt1 + ", height = " + paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    bljn.b("AECameraGLSurfaceView", "[onSurfaceCreated] + BEGIN");
    blfv.a().a("onSurfaceCreated-begin");
    jdField_n_of_type_Int = this.jdField_m_of_type_Int;
    v();
    blfv.a().a("onSurfaceCreated-end");
    bljn.b("AECameraGLSurfaceView", "[onSurfaceCreated] + END");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent == null) {
      return false;
    }
    if ((!g()) || (this.jdField_a_of_type_Bkth == null)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    bktc localbktc = (bktc)this.jdField_a_of_type_Bktf;
    if ((paramMotionEvent != null) && (localbktc.c()) && (!this.jdField_a_of_type_Bkth.c()))
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
        queueEvent(new AECameraGLSurfaceView.19(this, localbktc, f1, f2, i1));
        continue;
        if (a(this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, f1, f2) > i1 * 0.05F)
        {
          queueEvent(new AECameraGLSurfaceView.20(this, localbktc, f1, f2, i1));
          continue;
          queueEvent(new AECameraGLSurfaceView.21(this, localbktc, f1, f2, i1));
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
    bljn.b("AECameraGLSurfaceView", "stopCamera");
    bksp.a().a(e());
  }
  
  public void q()
  {
    bljn.b("AECameraGLSurfaceView", "cameraStopPreview");
    bksp.a().c();
  }
  
  public void r()
  {
    bljn.b("AECameraGLSurfaceView", "[tryStartCameraPreview] + BEGIN");
    if (this.jdField_g_of_type_Boolean)
    {
      bljn.a("AECameraGLSurfaceView", "[tryStartCameraPreview] blockCameraFlag = " + this.jdField_g_of_type_Boolean);
      return;
    }
    if (this.jdField_h_of_type_Boolean)
    {
      bljn.a("AECameraGLSurfaceView", "[tryStartCameraPreview] isPaused = " + this.jdField_h_of_type_Boolean);
      return;
    }
    if (!f())
    {
      if (this.jdField_a_of_type_Bksl != null) {
        this.jdField_a_of_type_Bksl.b();
      }
      bljn.d("AECameraGLSurfaceView", "[tryStartCameraPreview] permission denied");
      return;
    }
    bksp.a().a(this);
    o();
    y();
    bljn.b("AECameraGLSurfaceView", "[tryStartCameraPreview] + END");
  }
  
  public void setAECaptureController(bkth parambkth)
  {
    this.jdField_a_of_type_Bkth = parambkth;
  }
  
  public void setAEKitInitListener(bksk parambksk)
  {
    this.jdField_a_of_type_Bksk = parambksk;
  }
  
  public void setBeautyLevel(int paramInt)
  {
    if (!g())
    {
      bljn.b("AECameraGLSurfaceView", "[setBeautyLevel] level = " + paramInt + ", isAEKitAvailable is false");
      return;
    }
    this.jdField_c_of_type_Int = paramInt;
    queueEvent(new AECameraGLSurfaceView.16(this, paramInt));
  }
  
  public void setBlockCameraFlag(boolean paramBoolean)
  {
    bljn.b("AECameraGLSurfaceView", "setBlockCameraFlag---block=" + paramBoolean);
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void setCameraListener(bksl parambksl)
  {
    this.jdField_a_of_type_Bksl = parambksl;
  }
  
  public void setCameraPermissionResult(boolean paramBoolean)
  {
    bljn.b("AECameraGLSurfaceView", "setCameraPermissionResult---permissionRet=" + paramBoolean);
    if (paramBoolean) {
      r();
    }
  }
  
  public void setCaptureListener(bksm parambksm)
  {
    this.jdField_a_of_type_Bksm = parambksm;
  }
  
  public void setCaptureRequest(bksn parambksn)
  {
    if (this.jdField_a_of_type_Bktf != null) {
      this.jdField_a_of_type_Bktf.a(parambksn);
    }
  }
  
  public void setDarkModeEnable(boolean paramBoolean)
  {
    bksp.a().d(paramBoolean);
  }
  
  public void setDarkModeListener(axpq paramaxpq)
  {
    bksp.a().a(paramaxpq);
  }
  
  public void setDynamicResolutionMode(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    bksp.a().e(paramBoolean);
  }
  
  public void setFaceEffectListener(bksj parambksj)
  {
    this.jdField_a_of_type_Bksj = parambksj;
  }
  
  public void setFilter(FilterCategoryItem paramFilterCategoryItem)
  {
    if (!g()) {}
    bktc localbktc;
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
            localbktc = (bktc)this.jdField_a_of_type_Bktf;
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
    localbktc.a(paramFilterCategoryItem);
  }
  
  public void setIsGIFMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Blfy.b(paramBoolean);
    this.jdField_k_of_type_Boolean = paramBoolean;
  }
  
  public void setIsVoiceNeedEncode(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setLaunchStateCallback(bkso parambkso)
  {
    this.jdField_a_of_type_Bkso = parambkso;
  }
  
  public void setMaterial(String paramString)
  {
    ThreadManager.excute(new AECameraGLSurfaceView.13(this, new AECameraGLSurfaceView.12(this, paramString)), 64, null, true);
  }
  
  public void setMaterialMetaData(blab paramblab)
  {
    if ((paramblab == null) || (paramblab.equals(blab.a)))
    {
      setMaterial(null);
      return;
    }
    setMaterial(paramblab.a());
  }
  
  public void setOnFrameDraw(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public void setOnSurfaceChangedListener(bkwk parambkwk)
  {
    this.jdField_a_of_type_Bkwk = parambkwk;
  }
  
  public void setPreExtractFrame(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  public void setRecommendTextCallback(blbd paramblbd)
  {
    this.jdField_a_of_type_Blbd = paramblbd;
  }
  
  public void setSceneListener(bkuq parambkuq)
  {
    this.jdField_a_of_type_Bkuq = parambkuq;
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
    if ((this.jdField_a_of_type_Bktf != null) && ((this.jdField_a_of_type_Bktf instanceof bktc))) {
      ((bktc)this.jdField_a_of_type_Bktf).a(paramStickerInnerEffectFilterListener);
    }
  }
  
  public void setTapEvent(int paramInt, float paramFloat1, float paramFloat2)
  {
    queueEvent(new AECameraGLSurfaceView.TapRunnable(this, paramInt, paramFloat1 / this.jdField_a_of_type_Int, paramFloat2 / this.jdField_b_of_type_Int));
  }
  
  public void setZoom(int paramInt)
  {
    bksp.a().a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */