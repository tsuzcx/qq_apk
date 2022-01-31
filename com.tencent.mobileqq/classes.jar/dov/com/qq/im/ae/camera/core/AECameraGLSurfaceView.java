package dov.com.qq.im.ae.camera.core;

import ahyd;
import aiak;
import ajyc;
import akwg;
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
import avrq;
import avrr;
import avtb;
import avtc;
import avtf;
import avtg;
import avtn;
import avum;
import avyy;
import avzk;
import avzm;
import axhp;
import axhs;
import axik;
import bbdj;
import bcpw;
import biht;
import biiz;
import bija;
import bijb;
import bijd;
import bije;
import bijf;
import bijg;
import bijh;
import biji;
import bijj;
import bijm;
import bijo;
import bijp;
import bijr;
import bijs;
import bijt;
import biju;
import bild;
import bims;
import bimt;
import bink;
import bipy;
import biqn;
import birc;
import birk;
import birm;
import bitj;
import bivx;
import biwc;
import biwd;
import biwg;
import bizc;
import bizg;
import bizq;
import bkup;
import bkzt;
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
  implements aiak, GLSurfaceView.Renderer, avrq, avzk, bijm, bijr
{
  private static int jdField_n_of_type_Int;
  private static volatile boolean p;
  private int jdField_a_of_type_Int = 320;
  private final long jdField_a_of_type_Long = 83L;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF(0.0F, 0.0F);
  private avrr jdField_a_of_type_Avrr;
  private avtf jdField_a_of_type_Avtf;
  private avyy jdField_a_of_type_Avyy;
  private avzm jdField_a_of_type_Avzm;
  private biiz jdField_a_of_type_Biiz;
  private bijd jdField_a_of_type_Bijd;
  private bije jdField_a_of_type_Bije;
  private bijf jdField_a_of_type_Bijf;
  private bijg jdField_a_of_type_Bijg;
  private biji jdField_a_of_type_Biji;
  private bijs jdField_a_of_type_Bijs;
  private biju jdField_a_of_type_Biju;
  private bild jdField_a_of_type_Bild;
  private bims jdField_a_of_type_Bims;
  public bink a;
  private bipy jdField_a_of_type_Bipy;
  private birk jdField_a_of_type_Birk;
  private birm jdField_a_of_type_Birm;
  public bivx a;
  private biwg jdField_a_of_type_Biwg = new biwc();
  private bkzt jdField_a_of_type_Bkzt = new bkzt();
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
    biwd.a().a("glSurfaceViewConstruct-begin");
    s();
    this.jdField_m_of_type_Int = System.identityHashCode(this);
    biwd.a().a("glSurfaceViewConstruct-end");
  }
  
  private void A()
  {
    this.jdField_a_of_type_Bipy = new bijb(this, getContext());
    if (this.jdField_a_of_type_Bipy.a()) {
      this.jdField_a_of_type_Bipy.a();
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
    if (bijj.a().c()) {
      bijj.a().a((Activity)getContext(), true);
    }
    Object localObject = this.jdField_a_of_type_Biiz.a + "/" + System.currentTimeMillis() + ".jpg";
    bbdj.c((String)localObject);
    localObject = new File((String)localObject);
    boolean bool = bijj.a().b();
    int i1 = avtc.c(this.jdField_e_of_type_Int);
    bijj.a().a((File)localObject, i1, bool, this);
  }
  
  private void D()
  {
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_b_of_type_Long = 0L;
      this.jdField_c_of_type_Long = 0L;
      QLog.d("AECameraGLSurfaceView", 4, "onMediaCodecStopRecord");
      if (this.jdField_a_of_type_Birk != null)
      {
        QLog.d("AECameraGLSurfaceView", 4, "onMediaCodecStopRecord and aeExpressionRecognizer != null, release it");
        this.jdField_a_of_type_Birk.a(this.jdField_a_of_type_Birm);
        this.jdField_a_of_type_Birk.b();
        this.jdField_a_of_type_Birk.c();
      }
    }
  }
  
  private void E()
  {
    if (!f()) {
      return;
    }
    bijp localbijp = (bijp)this.jdField_a_of_type_Bijs;
    if ((localbijp.a()) && (!localbijp.b()) && (!this.jdField_i_of_type_Boolean))
    {
      this.jdField_g_of_type_Int += 1;
      if (this.jdField_g_of_type_Int >= 4)
      {
        a(localbijp.a(), localbijp.b());
        this.jdField_g_of_type_Int = 0;
      }
    }
    if ((!this.jdField_i_of_type_Boolean) && (localbijp.b())) {
      a(localbijp.a(), localbijp.b());
    }
    if (!localbijp.a()) {
      a(localbijp.a(), localbijp.b());
    }
    if ((this.jdField_i_of_type_Boolean) && (localbijp.b())) {
      a(localbijp.a(), localbijp.b());
    }
    this.jdField_i_of_type_Boolean = localbijp.b();
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
  
  private void a(avum paramavum)
  {
    if (this.jdField_a_of_type_Bijg != null) {
      this.jdField_a_of_type_Bijg.a(paramavum);
    }
    ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.8(this));
  }
  
  private void a(VideoMaterial paramVideoMaterial)
  {
    if (this.jdField_a_of_type_Bijd != null) {
      this.jdField_a_of_type_Bijd.a(paramVideoMaterial);
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Bijd != null) {
      this.jdField_a_of_type_Bijd.a(paramBoolean1, paramBoolean2);
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
    int i1 = (int)(this.jdField_b_of_type_Int * 1.0F / this.jdField_a_of_type_Int * this.jdField_a_of_type_Biiz.c());
    if (bkup.a().e()) {
      i1 = this.jdField_a_of_type_Biiz.b();
    }
    if (this.jdField_c_of_type_Boolean)
    {
      arrayOfInt = avtc.a(i1, paramInt1, paramInt2);
      arrayOfInt = avtc.a(arrayOfInt[0], arrayOfInt[1], this.jdField_a_of_type_Biiz.d(), this.jdField_a_of_type_Biiz.e(), 1.0F);
      this.jdField_h_of_type_Int = arrayOfInt[0];
      this.jdField_i_of_type_Int = arrayOfInt[1];
      return;
    }
    int[] arrayOfInt = avtc.a(paramInt1, paramInt2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Biiz.a());
    this.jdField_h_of_type_Int = arrayOfInt[0];
    this.jdField_i_of_type_Int = arrayOfInt[1];
    arrayOfInt = avtc.a(i1, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int);
    this.jdField_h_of_type_Int = arrayOfInt[0];
    this.jdField_i_of_type_Int = arrayOfInt[1];
  }
  
  private void b(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (this.jdField_a_of_type_Bijs == null) {}
    Object localObject;
    do
    {
      return;
      localObject = (bijp)this.jdField_a_of_type_Bijs;
      if (this.jdField_b_of_type_Long == 0L)
      {
        QLog.d("AECameraGLSurfaceView", 4, "frameToMediaCodec, gifRecordStartTimestamp == 0");
        this.jdField_b_of_type_Long = paramLong;
        bitj.jdField_a_of_type_JavaUtilList = new ArrayList();
        bitj.b = new ArrayList();
      }
      paramInt2 = ((bijp)localObject).a(paramInt2);
    } while ((paramLong - this.jdField_b_of_type_Long) / 1000000L <= 83L * this.jdField_c_of_type_Long);
    QLog.d("AECameraGLSurfaceView", 4, new Object[] { "frameToMediaCodec, encode frame, gifRecordFrameIndex = ", Long.valueOf(this.jdField_c_of_type_Long) });
    this.jdField_c_of_type_Long += 1L;
    if (((bijp)localObject).a() != null)
    {
      localObject = (PTFaceAttr)((bijp)localObject).a().getFaceAttr();
      bitj.jdField_a_of_type_JavaUtilList.add(((PTFaceAttr)localObject).getAllFacePoints());
      bitj.b.add(((PTFaceAttr)localObject).getAllFaceAngles());
      bitj.jdField_a_of_type_Double = ((PTFaceAttr)localObject).getFaceDetectScale();
    }
    a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, (paramLong / 1.5D));
  }
  
  private void c(int paramInt)
  {
    if ((h()) && (this.jdField_b_of_type_Long > 0L))
    {
      Object localObject = (bijp)this.jdField_a_of_type_Bijs;
      if (this.jdField_a_of_type_Birk == null)
      {
        QLog.d("AECameraGLSurfaceView", 4, "recording gif, aeExpressionRecognizer == null, create it");
        this.jdField_a_of_type_Birk = new birk();
        this.jdField_a_of_type_Birk.a();
      }
      long l1 = (SystemClock.elapsedRealtimeNanos() - this.jdField_b_of_type_Long) / 1000000L;
      int i1 = this.jdField_a_of_type_Birk.a();
      QLog.d("AECameraGLSurfaceView", 4, "recording gif, aeExpressionRecognizer.getFrameCount() == " + i1);
      if ((i1 < 3) && ((float)l1 > (i1 + 0.5F) * 1000.0F) && (((bijp)localObject).b()))
      {
        localObject = (PTFaceAttr)((bijp)localObject).a().getFaceAttr();
        this.jdField_a_of_type_Birk.a(paramInt, (List)((PTFaceAttr)localObject).getAllFacePoints().get(0), (int)(this.jdField_j_of_type_Int * ((PTFaceAttr)localObject).getFaceDetectScale()), (int)(this.jdField_k_of_type_Int * ((PTFaceAttr)localObject).getFaceDetectScale()));
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
      return birc.h(((Activity)localContext).getIntent());
    }
    return false;
  }
  
  public static void e()
  {
    bizq.b("AECameraGLSurfaceView", "[initSdk] + BEGIN, isSdkInited = " + p);
    long l1 = System.currentTimeMillis();
    if (!p)
    {
      bizq.b("AECameraGLSurfaceView", "[initSdk] do init");
      p = true;
      biwd.a().a("glSurfaceViewStaticInit-begin");
      biht.a();
      FeatureManager.loadBasicFeatures();
      VideoPrefsUtil.init(BaseApplicationImpl.getContext(), ShortVideoUtils.a());
      biwd.a().a("glSurfaceViewStaticInit-end");
    }
    bizq.b("AECameraGLSurfaceView", "[initSdk] + END, time cost = " + (System.currentTimeMillis() - l1));
  }
  
  private boolean e()
  {
    Activity localActivity = (Activity)getContext();
    if (Build.VERSION.SDK_INT < 23) {
      return true;
    }
    int i1 = localActivity.checkSelfPermission("android.permission.CAMERA");
    int i2 = localActivity.checkSelfPermission("android.permission.RECORD_AUDIO");
    boolean bool = akwg.a(localActivity);
    if ((i1 == 0) && (i2 == 0) && (bool)) {}
    for (bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean f()
  {
    return (FeatureManager.isBasicFeaturesFunctionReady()) && (this.jdField_a_of_type_Bijs != null) && ((this.jdField_a_of_type_Bijs instanceof bijp));
  }
  
  private boolean g()
  {
    if (!f()) {
      return true;
    }
    if (!((bijp)this.jdField_a_of_type_Bijs).d()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean h()
  {
    return (this.jdField_k_of_type_Boolean) && (this.jdField_m_of_type_Boolean) && (this.jdField_a_of_type_Avyy != null);
  }
  
  private void s()
  {
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 0, 0);
    setEGLContextFactory(new bija(this));
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
    if (this.jdField_a_of_type_Bijs != null) {
      return;
    }
    bizq.b("AECameraGLSurfaceView", "createFilterProcess---BEGIN");
    if (FeatureManager.loadBasicFeatures())
    {
      this.jdField_a_of_type_Bijs = new bijp(this.jdField_m_of_type_Int);
      bizq.b("AECameraGLSurfaceView", "createFilterProcess---create AEFilterProcessTex");
      return;
    }
    this.jdField_a_of_type_Bijs = new bijt();
    bizq.d("AECameraGLSurfaceView", "createFilterProcess---create NonAEFilterProcess");
  }
  
  private void v()
  {
    biwd.a().a("AECameraGLSurfaceView", "initFilterProcess---begin");
    if (this.jdField_a_of_type_Bijs == null) {
      u();
    }
    if ((this.jdField_a_of_type_Bijs instanceof bijp))
    {
      if (this.jdField_a_of_type_Bije != null) {
        this.jdField_a_of_type_Bije.a();
      }
      ((bijp)this.jdField_a_of_type_Bijs).b(false);
      ((bijp)this.jdField_a_of_type_Bijs).a(this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager$StickerInnerEffectFilterListener);
      ((bijp)this.jdField_a_of_type_Bijs).a().setParam("SET_AEPROFILER_OBJ", this.jdField_a_of_type_Biwg);
    }
    bijj.a().a(this.jdField_a_of_type_Bijs.a());
    String str = FeatureManager.getResourceDir();
    if (!AIManager.installDetector(PTSegmenter.class, str, str)) {
      bizq.d("AECameraGLSurfaceView", "PTSegmenter install error.");
    }
    biwd.a().a("AECameraGLSurfaceView", "initFilterProcess---end");
  }
  
  private void w()
  {
    if ((this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null) && (VideoMaterialUtil.isAudio2textMaterial(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial))) {
      this.jdField_a_of_type_Bkzt.a(getContext(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_Bijs != null)
    {
      this.jdField_a_of_type_Bijs.e();
      this.jdField_a_of_type_Bijs = null;
      if (jdField_n_of_type_Int == this.jdField_m_of_type_Int) {
        bijj.a().f();
      }
    }
  }
  
  private void y()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    bizq.b("AECameraGLSurfaceView", "startPreview---");
    bijj.a().b();
  }
  
  private void z()
  {
    A();
    this.jdField_a_of_type_Biwg.c();
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
      if (!this.jdField_a_of_type_Avrr.a()) {
        break label56;
      }
      this.jdField_a_of_type_Avrr.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bijg != null) {
        this.jdField_a_of_type_Bijg.n();
      }
      return;
      label56:
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    bijj.a().a(paramFloat1, paramFloat2);
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
      localObject1 = avtc.a(paramInt1, paramInt2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1.0F);
      localObject1 = avtc.a(640, localObject1[0], localObject1[1]);
      i1 = localObject1[0];
      i2 = localObject1[1];
      this.jdField_j_of_type_Int = i1;
      this.jdField_k_of_type_Int = i2;
      this.jdField_h_of_type_Int = this.jdField_j_of_type_Int;
      this.jdField_i_of_type_Int = this.jdField_k_of_type_Int;
      if (this.jdField_a_of_type_Bijs != null)
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
      this.jdField_a_of_type_Bijs.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt1, paramInt2, i1, i2);
      bijj.a().a(i1, i2);
      this.jdField_a_of_type_Bijs.a(this.jdField_h_of_type_Int, this.jdField_i_of_type_Int);
      bimt.a.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      bimt.a.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      bimt.a.jdField_c_of_type_Int = Math.min(paramInt1, paramInt2);
      bimt.a.jdField_d_of_type_Int = Math.max(paramInt1, paramInt2);
      if (bijj.a().d()) {}
      for (localObject1 = Camera2Control.a().c();; localObject1 = axhp.a().b())
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new axhs();
        }
        bimt.a.jdField_e_of_type_Int = Math.min(((axhs)localObject2).jdField_a_of_type_Int, ((axhs)localObject2).jdField_b_of_type_Int);
        bimt.a.jdField_f_of_type_Int = Math.max(((axhs)localObject2).jdField_a_of_type_Int, ((axhs)localObject2).jdField_b_of_type_Int);
        if (this.jdField_a_of_type_Bijs != null)
        {
          localObject1 = this.jdField_a_of_type_Bijs.a();
          bimt.a.jdField_g_of_type_Int = localObject1[0];
          bimt.a.jdField_h_of_type_Int = localObject1[1];
          bimt.a.jdField_i_of_type_Int = localObject1[2];
          bimt.a.jdField_j_of_type_Int = localObject1[3];
        }
        bimt.a.jdField_m_of_type_Int = this.jdField_h_of_type_Int;
        bimt.a.jdField_n_of_type_Int = this.jdField_i_of_type_Int;
        if ((bimt.a()) && (this.jdField_a_of_type_Bink != null)) {
          this.jdField_a_of_type_Bink.x();
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
    if ((this.jdField_m_of_type_Boolean) && (this.jdField_a_of_type_Avyy != null))
    {
      switch (this.jdField_l_of_type_Int)
      {
      default: 
        throw new RuntimeException("unknown status " + this.jdField_l_of_type_Int);
      case 0: 
        this.jdField_a_of_type_Avyy.a(EGL14.eglGetCurrentContext());
        this.jdField_a_of_type_Avzm.a();
        this.jdField_a_of_type_Avzm.a(this.jdField_a_of_type_Avyy, this);
        this.jdField_l_of_type_Int = 1;
      }
      this.jdField_a_of_type_Avzm.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
      return;
    }
    switch (this.jdField_l_of_type_Int)
    {
    case 0: 
    default: 
      throw new RuntimeException("unknown status " + this.jdField_l_of_type_Int);
    }
    this.jdField_a_of_type_Avzm.b();
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
      biwd.a().a("onFrameAvailable");
    }
    if (this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2 != null) {
      this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2.getRotation(this.jdField_a_of_type_ArrayOfFloat);
    }
    queueEvent(new AECameraGLSurfaceView.4(this));
    requestRender();
  }
  
  public void a(biiz parambiiz)
  {
    if (this.jdField_a_of_type_Biiz != null) {
      throw new RuntimeException("setCaptureParam is already called");
    }
    this.jdField_a_of_type_Biiz = parambiiz;
    if (QLog.isColorLevel()) {
      QLog.d("AECameraGLSurfaceView", 2, "setCaptureParam : " + parambiiz);
    }
    bijj.a().a(this);
    bijj.a().a(parambiiz);
    this.jdField_a_of_type_Avzm = new avzm();
    this.jdField_a_of_type_Avtf = new avtf();
    bijj.a().a(this.jdField_a_of_type_Avtf);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture = new AudioCapture(this.jdField_a_of_type_Biiz.a, 1, axik.q, axik.o, axik.p, this, bijj.a().a());
    this.jdField_a_of_type_Avrr = new avrr(this.jdField_a_of_type_Biiz.a, axik.q, this);
    bijj.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
    this.jdField_a_of_type_Biwg.g();
    this.jdField_b_of_type_Boolean = true;
  }
  
  protected void a(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    int i1 = 1;
    if (this.jdField_a_of_type_Bijg != null) {
      this.jdField_a_of_type_Bijg.a(paramAEVideoCaptureResult);
    }
    ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.5(this));
    avtn.c();
    if (axhp.a().jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      avtb.i(i1);
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
      if (this.jdField_a_of_type_Avrr.a())
      {
        this.jdField_a_of_type_Avrr.b();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e();
      return;
    }
    paramString = this.jdField_a_of_type_Biiz.a + "/noaudio";
    bbdj.c(paramString);
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.audioDataFilePath = paramString;
    a(this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!PTSegmenter.SEGMENT.isFunctionReady()) && (paramBoolean)) {
      bcpw.a(BaseApplicationImpl.getContext(), ajyc.a(2131689826), 0).a();
    }
    while (!f()) {
      return;
    }
    ((bijp)this.jdField_a_of_type_Bijs).b(paramBoolean);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      biwd.a().a("onCameraStart");
    }
    bizq.b("AECameraGLSurfaceView", "onCameraStarted--success=" + paramBoolean + ", errMsg=" + paramString);
    if (this.jdField_a_of_type_Bijf != null) {
      this.jdField_a_of_type_Bijf.a(paramBoolean, paramString);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (ahyd.a().a()) {
      ahyd.a().a(paramArrayOfByte, paramInt1, paramInt2);
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
    this.jdField_a_of_type_Avrr.a(paramArrayOfByte, paramInt1, paramInt2);
    this.jdField_a_of_type_Bkzt.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public boolean a()
  {
    return bijj.a().b();
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.errorCode = paramInt;
    if (this.jdField_a_of_type_Bijg != null) {
      this.jdField_a_of_type_Bijg.a(104);
    }
  }
  
  public void a_(String paramString)
  {
    a(new avum(1, 0, paramString, null, this.jdField_d_of_type_Int));
  }
  
  public int b()
  {
    return bijj.a().a();
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
      ahyd.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
      queueEvent(new AECameraGLSurfaceView.6(this));
    }
  }
  
  public void c(String paramString) {}
  
  public void d()
  {
    ahyd.a().a(null);
  }
  
  public void f()
  {
    if (QLog.isDevelopLevel()) {
      bizq.a("AECameraGLSurfaceView", "### onDestroy, hashCode=" + this.jdField_m_of_type_Int + " ###");
    }
    if (this.jdField_a_of_type_Bkzt != null) {
      this.jdField_a_of_type_Bkzt.a();
    }
    bijo.a(null);
    if (this.jdField_a_of_type_Bijs != null) {
      this.jdField_a_of_type_Bijs.a(true);
    }
    if (jdField_n_of_type_Int == this.jdField_m_of_type_Int) {
      bijj.a().b(d());
    }
    this.jdField_a_of_type_Biwg.h();
    if (this.jdField_a_of_type_Avzm != null) {
      this.jdField_a_of_type_Avzm.c();
    }
  }
  
  public void g() {}
  
  public void h()
  {
    if (!f()) {}
    while (this.jdField_a_of_type_Bijs == null) {
      return;
    }
    queueEvent(new AECameraGLSurfaceView.14(this));
  }
  
  public void i()
  {
    this.jdField_a_of_type_Biwg.b();
    B();
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Bijs != null) {
      this.jdField_a_of_type_Bijs.a(false);
    }
    bijj.a().c(d());
    this.jdField_a_of_type_Biwg.a(bijj.a().b());
    if (this.jdField_k_of_type_Boolean) {}
    for (;;)
    {
      if (this.jdField_a_of_type_Bijf != null) {
        this.jdField_a_of_type_Bijf.c();
      }
      return;
      bizc.a().m();
      bizq.b("AECameraGLSurfaceView", "【Change Camera】:isFrontCamera:" + bijj.a().b());
    }
  }
  
  public void k()
  {
    if (g())
    {
      QLog.d("AECameraGLSurfaceView", 4, "capturePhotoByCameraProxy");
      bimt.a.jdField_b_of_type_Boolean = false;
      C();
    }
    for (;;)
    {
      this.jdField_a_of_type_Biwg.e();
      if (this.jdField_a_of_type_Bijg != null) {
        this.jdField_a_of_type_Bijg.m();
      }
      return;
      QLog.d("AECameraGLSurfaceView", 4, "capturePhotoByAEKit");
      bimt.a.jdField_b_of_type_Boolean = true;
      l();
    }
  }
  
  public void l()
  {
    int i1 = 0;
    if (bijj.a().c())
    {
      bijj.a().a((Activity)getContext(), true);
      i1 = 1500;
    }
    ThreadManager.getUIHandler().postDelayed(new AECameraGLSurfaceView.15(this), i1);
  }
  
  public void m()
  {
    bizq.b("AECameraGLSurfaceView", "startCaptureVideo---recordingEnabled=" + this.jdField_m_of_type_Boolean);
    this.jdField_a_of_type_Biwg.f();
    if ((bijj.a().c()) && (!this.jdField_k_of_type_Boolean)) {
      bijj.a().a((Activity)getContext(), true);
    }
    String str = this.jdField_a_of_type_Biiz.a + File.separator + System.currentTimeMillis() + ".mp4";
    if ((this.jdField_n_of_type_Boolean) && (!this.jdField_k_of_type_Boolean)) {}
    for (int i1 = avtc.b(this.jdField_d_of_type_Int);; i1 = 0)
    {
      this.jdField_a_of_type_Avyy = new avyy(str, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, this.jdField_a_of_type_Biiz.a(), this.jdField_a_of_type_Biiz.f(), false, i1);
      this.jdField_a_of_type_Avyy.jdField_j_of_type_Int = this.jdField_a_of_type_Biiz.h();
      this.jdField_a_of_type_Avyy.jdField_k_of_type_Int = this.jdField_a_of_type_Biiz.i();
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult = new AEVideoCaptureResult();
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.startTimeMs = System.currentTimeMillis();
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.orientation = this.jdField_d_of_type_Int;
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.type = 0;
      if (bijj.a().a() == 2) {
        bijj.a().g();
      }
      this.jdField_m_of_type_Boolean = true;
      avtc.a(false, false);
      return;
    }
  }
  
  public void n()
  {
    bizq.b("AECameraGLSurfaceView", "stopCaptureVideo---recordingEnabled=" + this.jdField_m_of_type_Boolean);
    if (this.jdField_m_of_type_Boolean)
    {
      this.jdField_m_of_type_Boolean = false;
      if (this.jdField_l_of_type_Int != 0) {
        break label72;
      }
      if (this.jdField_a_of_type_Bijg != null) {
        this.jdField_a_of_type_Bijg.a(102);
      }
    }
    for (;;)
    {
      bijj.a().d();
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
    bizq.b("AECameraGLSurfaceView", "openCamera");
    bijj.a().a();
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
        biwd.a().a(paramGL10);
      }
    }
    else
    {
      if (this.jdField_e_of_type_Boolean)
      {
        this.jdField_e_of_type_Boolean = false;
        z();
      }
      if (this.jdField_a_of_type_Bijs != null) {
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
        biwd.a().a("FilterProcessInitFilters-begin");
      }
      this.jdField_a_of_type_Bijs.d();
      if (this.jdField_f_of_type_Boolean) {
        biwd.a().a("FilterProcessInitFilters-end");
      }
      paramGL10 = this.jdField_a_of_type_Bijs.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      if (f())
      {
        bijp localbijp = (bijp)this.jdField_a_of_type_Bijs;
        E();
        if (this.jdField_a_of_type_Bild != null) {
          this.jdField_a_of_type_Bild.a(bijj.a().a(), localbijp.a());
        }
        c(paramGL10[1]);
      }
      this.jdField_a_of_type_Bijs.c(paramGL10[0]);
      a(paramGL10[1], null, null);
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        queueEvent(new AECameraGLSurfaceView.9(this));
      }
      this.jdField_a_of_type_Biwg.d();
      if (!this.q)
      {
        this.q = true;
        bizg.a().f();
        bizc.a().C();
        if (bimt.a()) {
          bimt.a(this.jdField_a_of_type_Bink, 5000L);
        }
        if (this.jdField_a_of_type_Biji != null) {
          this.jdField_a_of_type_Biji.a();
        }
      }
    } while (!this.jdField_f_of_type_Boolean);
    if (bool) {}
    for (paramGL10 = "onDrawFrameReal-end";; paramGL10 = "onDrawFrameFake-end" + this.jdField_f_of_type_Int)
    {
      biwd.a().a(paramGL10);
      if (!bool) {
        break;
      }
      this.jdField_f_of_type_Boolean = false;
      return;
    }
  }
  
  public void onPause()
  {
    bizq.b("AECameraGLSurfaceView", "[onPause] hashCode=" + this.jdField_m_of_type_Int + " ###");
    bizq.a("AECameraGLSurfaceView", "[onPause] TOP_SURFACE_HASH_CODE=" + jdField_n_of_type_Int + " ###");
    queueEvent(new AECameraGLSurfaceView.3(this));
    if (this.jdField_a_of_type_Bivx == bivx.b) {}
    for (this.jdField_g_of_type_Boolean = true;; this.jdField_g_of_type_Boolean = false)
    {
      this.jdField_h_of_type_Boolean = true;
      if (jdField_n_of_type_Int == this.jdField_m_of_type_Int)
      {
        bizq.a("AECameraGLSurfaceView", "### onPause, execute stop camera TOP_SURFACE_HASH_CODE=mIdentityHashCode=" + jdField_n_of_type_Int + " ###");
        bijj.a().c();
        bijj.a().a(d());
      }
      if (this.jdField_a_of_type_Bipy != null) {
        this.jdField_a_of_type_Bipy.b();
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
        bizq.a("AECameraGLSurfaceView", "### onResume, hashCode=" + this.jdField_m_of_type_Int + " ###");
      }
      this.jdField_m_of_type_Boolean = false;
      bijj.a().e();
      if ((this.jdField_a_of_type_Bipy != null) && (this.jdField_a_of_type_Bipy.a())) {
        this.jdField_a_of_type_Bipy.a();
      }
      return;
      if (!this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = true;
        this.jdField_a_of_type_Bijf.b();
      }
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    bizq.b("AECameraGLSurfaceView", "[onSurfaceChanged] + BEGIN, width = " + paramInt1 + ", height = " + paramInt2);
    biwd.a().a("onSurfaceChanged-begin");
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    bijj.a().b(paramInt1, paramInt2);
    r();
    if (this.jdField_a_of_type_Bijs != null) {
      this.jdField_a_of_type_Bijs.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 0, 0, paramInt1, paramInt2);
    }
    if (this.jdField_c_of_type_Int != 0) {
      setBeautyLevel(this.jdField_c_of_type_Int);
    }
    if (this.jdField_a_of_type_Bims != null) {
      this.jdField_a_of_type_Bims.a(paramInt1, paramInt2);
    }
    biwd.a().a("onSurfaceChanged-end");
    bizq.b("AECameraGLSurfaceView", "[onSurfaceChanged] + END, width = " + paramInt1 + ", height = " + paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    bizq.b("AECameraGLSurfaceView", "[onSurfaceCreated] + BEGIN");
    biwd.a().a("onSurfaceCreated-begin");
    jdField_n_of_type_Int = this.jdField_m_of_type_Int;
    v();
    biwd.a().a("onSurfaceCreated-end");
    bizq.b("AECameraGLSurfaceView", "[onSurfaceCreated] + END");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent == null) {
      return false;
    }
    if ((!f()) || (this.jdField_a_of_type_Biju == null)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    bijp localbijp = (bijp)this.jdField_a_of_type_Bijs;
    if ((paramMotionEvent != null) && (localbijp.c()) && (!this.jdField_a_of_type_Biju.c()))
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
        queueEvent(new AECameraGLSurfaceView.19(this, localbijp, f1, f2, i1));
        continue;
        if (a(this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, f1, f2) > i1 * 0.05F)
        {
          queueEvent(new AECameraGLSurfaceView.20(this, localbijp, f1, f2, i1));
          continue;
          queueEvent(new AECameraGLSurfaceView.21(this, localbijp, f1, f2, i1));
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
    bizq.b("AECameraGLSurfaceView", "stopCamera");
    bijj.a().a(d());
  }
  
  public void q()
  {
    bizq.b("AECameraGLSurfaceView", "cameraStopPreview");
    bijj.a().c();
  }
  
  public void r()
  {
    bizq.b("AECameraGLSurfaceView", "[tryStartCameraPreview] + BEGIN");
    if (this.jdField_g_of_type_Boolean)
    {
      bizq.a("AECameraGLSurfaceView", "[tryStartCameraPreview] blockCameraFlag = " + this.jdField_g_of_type_Boolean);
      return;
    }
    if (this.jdField_h_of_type_Boolean)
    {
      bizq.a("AECameraGLSurfaceView", "[tryStartCameraPreview] isPaused = " + this.jdField_h_of_type_Boolean);
      return;
    }
    if (!e())
    {
      bizq.d("AECameraGLSurfaceView", "[tryStartCameraPreview] permission denied");
      return;
    }
    bijj.a().a(this);
    o();
    y();
    bizq.b("AECameraGLSurfaceView", "[tryStartCameraPreview] + END");
  }
  
  public void setAECaptureController(biju parambiju)
  {
    this.jdField_a_of_type_Biju = parambiju;
  }
  
  public void setAEKitInitListener(bije parambije)
  {
    this.jdField_a_of_type_Bije = parambije;
  }
  
  public void setBeautyLevel(int paramInt)
  {
    if (!f())
    {
      bizq.b("AECameraGLSurfaceView", "[setBeautyLevel] level = " + paramInt + ", isAEKitAvailable is false");
      return;
    }
    this.jdField_c_of_type_Int = paramInt;
    queueEvent(new AECameraGLSurfaceView.16(this, paramInt));
  }
  
  public void setBlockCameraFlag(boolean paramBoolean)
  {
    bizq.b("AECameraGLSurfaceView", "setBlockCameraFlag---block=" + paramBoolean);
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void setCameraListener(bijf parambijf)
  {
    this.jdField_a_of_type_Bijf = parambijf;
  }
  
  public void setCameraPermissionResult(boolean paramBoolean)
  {
    bizq.b("AECameraGLSurfaceView", "setCameraPermissionResult---permissionRet=" + paramBoolean);
    if (paramBoolean) {
      r();
    }
  }
  
  public void setCaptureListener(bijg parambijg)
  {
    this.jdField_a_of_type_Bijg = parambijg;
  }
  
  public void setCaptureRequest(bijh parambijh)
  {
    this.jdField_a_of_type_Bijs.a(parambijh);
  }
  
  public void setDarkModeEnable(boolean paramBoolean)
  {
    bijj.a().d(paramBoolean);
  }
  
  public void setDarkModeListener(avtg paramavtg)
  {
    bijj.a().a(paramavtg);
  }
  
  public void setDynamicResolutionMode(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    bijj.a().e(paramBoolean);
  }
  
  public void setFaceEffectListener(bijd parambijd)
  {
    this.jdField_a_of_type_Bijd = parambijd;
  }
  
  public void setFilter(FilterCategoryItem paramFilterCategoryItem)
  {
    if (!f()) {}
    bijp localbijp;
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
            localbijp = (bijp)this.jdField_a_of_type_Bijs;
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
    localbijp.a(paramFilterCategoryItem);
  }
  
  public void setIsGIFMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Biwg.b(paramBoolean);
    this.jdField_k_of_type_Boolean = paramBoolean;
  }
  
  public void setLaunchStateCallback(biji parambiji)
  {
    this.jdField_a_of_type_Biji = parambiji;
  }
  
  public void setMaterial(String paramString)
  {
    ThreadManager.excute(new AECameraGLSurfaceView.13(this, new AECameraGLSurfaceView.12(this, paramString)), 64, null, true);
  }
  
  public void setMaterialMetaData(biqn parambiqn)
  {
    if ((parambiqn == null) || (parambiqn.equals(biqn.a)))
    {
      setMaterial(null);
      return;
    }
    setMaterial(parambiqn.a());
  }
  
  public void setOnFrameDraw(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public void setOnSurfaceChangedListener(bims parambims)
  {
    this.jdField_a_of_type_Bims = parambims;
  }
  
  public void setRecommendTextCallback(birm parambirm)
  {
    this.jdField_a_of_type_Birm = parambirm;
  }
  
  public void setSceneListener(bild parambild)
  {
    this.jdField_a_of_type_Bild = parambild;
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
    if ((this.jdField_a_of_type_Bijs != null) && ((this.jdField_a_of_type_Bijs instanceof bijp))) {
      ((bijp)this.jdField_a_of_type_Bijs).a(paramStickerInnerEffectFilterListener);
    }
  }
  
  public void setZoom(int paramInt)
  {
    bijj.a().a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */