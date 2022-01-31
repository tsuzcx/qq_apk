package dov.com.qq.im.AECamera.View;

import ahll;
import ahns;
import ajjy;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import aush;
import ausi;
import auts;
import autt;
import autw;
import autx;
import auue;
import auuy;
import auzf;
import auzr;
import auzt;
import awij;
import awim;
import awje;
import bace;
import bbmy;
import bedt;
import bgxh;
import bgxk;
import bgxl;
import bgxr;
import bgya;
import bgye;
import bgyf;
import bgyk;
import bgym;
import bgyn;
import bgyo;
import bgyp;
import bgyq;
import bgyr;
import bgys;
import bgyv;
import bgyx;
import bgyy;
import bgyz;
import bgzf;
import bgzg;
import bhci;
import bhcm;
import bhcq;
import bhcs;
import bhsc;
import bhse;
import bhtg;
import bjef;
import bjji;
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
import dov.com.qq.im.AECamera.record.AEVideoCaptureResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;
import wsh;
import wsu;
import wuf;
import wur;

@TargetApi(17)
public class AECameraGLSurfaceView
  extends GLSurfaceView
  implements ahns, GLSurfaceView.Renderer, aush, auzr, bgyv, bgyz
{
  private static final String jdField_a_of_type_JavaLangString = AECameraGLSurfaceView.class.getSimpleName();
  private int jdField_a_of_type_Int = 320;
  private final long jdField_a_of_type_Long = 83L;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF(0.0F, 0.0F);
  private GLSurfaceView.EGLContextFactory jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory = new bgyk(this);
  private ausi jdField_a_of_type_Ausi;
  private autw jdField_a_of_type_Autw;
  private auzf jdField_a_of_type_Auzf;
  private auzt jdField_a_of_type_Auzt;
  private bgxh jdField_a_of_type_Bgxh;
  private bgxk jdField_a_of_type_Bgxk;
  private bgyf jdField_a_of_type_Bgyf = new bgye();
  private bgyn jdField_a_of_type_Bgyn;
  private bgyo jdField_a_of_type_Bgyo;
  private bgyp jdField_a_of_type_Bgyp;
  private bgyq jdField_a_of_type_Bgyq;
  private bgzf jdField_a_of_type_Bgzf;
  private bhcq jdField_a_of_type_Bhcq;
  private bhsc jdField_a_of_type_Bhsc;
  private bhse jdField_a_of_type_Bhse;
  private bjji jdField_a_of_type_Bjji = new bjji();
  private AEFilterManager.StickerInnerEffectFilterListener jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager$StickerInnerEffectFilterListener;
  private AudioCapture jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture;
  private VideoMaterial jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
  SensorUtil2 jdField_a_of_type_ComTencentTtpicUtilSensorUtil2 = new SensorUtil2();
  private AEVideoCaptureResult jdField_a_of_type_DovComQqImAECameraRecordAEVideoCaptureResult;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  public wsh a;
  public wsu a;
  private wuf jdField_a_of_type_Wuf;
  private wur jdField_a_of_type_Wur;
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
  private volatile boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean = true;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private boolean l;
  private boolean m;
  private volatile boolean n;
  private boolean o = true;
  private boolean p;
  
  static
  {
    long l1 = SystemClock.uptimeMillis();
    bedt.a();
    bgxr.a();
    VideoPrefsUtil.init(BaseApplicationImpl.getContext(), ShortVideoUtils.a());
    if (QLog.isDevelopLevel()) {
      QLog.d("CameraLaunchPerf", 4, "AECameraGLSurfaceView static init cost=" + (SystemClock.uptimeMillis() - l1));
    }
  }
  
  public AECameraGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    r();
  }
  
  public AECameraGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    r();
  }
  
  private void A()
  {
    if (bgys.a().b()) {
      bgys.a().a((Activity)getContext(), true);
    }
    Object localObject = this.jdField_a_of_type_Bgxk.jdField_a_of_type_JavaLangString + "/" + System.currentTimeMillis() + ".jpg";
    bace.c((String)localObject);
    localObject = new File((String)localObject);
    boolean bool = bgys.a().a();
    int i1 = autt.c(this.jdField_e_of_type_Int);
    bgys.a().a((File)localObject, i1, bool, this);
  }
  
  private void B()
  {
    if (this.l)
    {
      this.jdField_b_of_type_Long = 0L;
      this.jdField_c_of_type_Long = 0L;
      QLog.d(jdField_a_of_type_JavaLangString, 4, "onMediaCodecStopRecord");
      if (this.jdField_a_of_type_Bhsc != null)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "onMediaCodecStopRecord and aeExpressionRecognizer != null, release it");
        this.jdField_a_of_type_Bhsc.a(this.jdField_a_of_type_Bhse);
        this.jdField_a_of_type_Bhsc.b();
        this.jdField_a_of_type_Bhsc.c();
      }
    }
  }
  
  private void C()
  {
    if (!c()) {
      return;
    }
    bgyy localbgyy = (bgyy)this.jdField_a_of_type_Bgzf;
    if ((localbgyy.a()) && (!localbgyy.b()) && (!this.jdField_j_of_type_Boolean))
    {
      this.jdField_f_of_type_Int += 1;
      if (this.jdField_f_of_type_Int >= 4)
      {
        a(localbgyy.a(), localbgyy.b());
        this.jdField_f_of_type_Int = 0;
      }
    }
    if ((!this.jdField_j_of_type_Boolean) && (localbgyy.b())) {
      a(localbgyy.a(), localbgyy.b());
    }
    if (!localbgyy.a()) {
      a(localbgyy.a(), localbgyy.b());
    }
    if ((this.jdField_j_of_type_Boolean) && (localbgyy.b())) {
      a(localbgyy.a(), localbgyy.b());
    }
    this.jdField_j_of_type_Boolean = localbgyy.b();
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (float)Math.sqrt((paramFloat1 - paramFloat3) * (paramFloat1 - paramFloat3) + (paramFloat2 - paramFloat4) * (paramFloat2 - paramFloat4));
  }
  
  private void a(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    long l1 = SystemClock.elapsedRealtimeNanos();
    if ((c()) && (e()))
    {
      b(3553, paramInt, paramArrayOfFloat1, paramArrayOfFloat2, l1);
      return;
    }
    a(3553, paramInt, paramArrayOfFloat1, paramArrayOfFloat2, l1);
  }
  
  private void a(auuy paramauuy)
  {
    if (this.jdField_a_of_type_Bgyq != null) {
      this.jdField_a_of_type_Bgyq.a(paramauuy);
    }
    ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.7(this));
  }
  
  private void a(bgxk parambgxk)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("CameraLaunchPerf", 4, "AECameraGLSurfaceView init time=" + System.currentTimeMillis());
    }
    bgys.a().a(this);
    bgys.a().a(parambgxk);
    this.jdField_a_of_type_Auzt = new auzt();
    this.jdField_a_of_type_Autw = new autw();
    bgys.a().a(this.jdField_a_of_type_Autw);
    s();
    this.jdField_a_of_type_Bgyf.g();
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a(VideoMaterial paramVideoMaterial)
  {
    if (this.jdField_a_of_type_Bgyn != null) {
      this.jdField_a_of_type_Bgyn.a(paramVideoMaterial);
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Bgyn != null) {
      this.jdField_a_of_type_Bgyn.a(paramBoolean1, paramBoolean2);
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
    int i1 = (int)(this.jdField_b_of_type_Int * 1.0F / this.jdField_a_of_type_Int * this.jdField_a_of_type_Bgxk.c());
    if (bjef.a().e()) {
      i1 = this.jdField_a_of_type_Bgxk.b();
    }
    if (this.jdField_c_of_type_Boolean)
    {
      arrayOfInt = autt.a(i1, paramInt1, paramInt2);
      arrayOfInt = autt.a(arrayOfInt[0], arrayOfInt[1], this.jdField_a_of_type_Bgxk.d(), this.jdField_a_of_type_Bgxk.e(), 1.0F);
      this.jdField_g_of_type_Int = arrayOfInt[0];
      this.jdField_h_of_type_Int = arrayOfInt[1];
      return;
    }
    int[] arrayOfInt = autt.a(paramInt1, paramInt2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Bgxk.a());
    this.jdField_g_of_type_Int = arrayOfInt[0];
    this.jdField_h_of_type_Int = arrayOfInt[1];
    arrayOfInt = autt.a(i1, this.jdField_g_of_type_Int, this.jdField_h_of_type_Int);
    this.jdField_g_of_type_Int = arrayOfInt[0];
    this.jdField_h_of_type_Int = arrayOfInt[1];
  }
  
  private void b(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (this.jdField_a_of_type_Bgzf == null) {}
    Object localObject;
    do
    {
      return;
      localObject = (bgyy)this.jdField_a_of_type_Bgzf;
      QLog.d(jdField_a_of_type_JavaLangString, 4, "frameToMediaCodec, isRecordingGIF() && isAEKitInited()");
      if (this.jdField_b_of_type_Long == 0L)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "frameToMediaCodec, gifRecordStartTimestamp == 0");
        this.jdField_b_of_type_Long = paramLong;
        bhtg.jdField_a_of_type_JavaUtilList = new ArrayList();
        bhtg.b = new ArrayList();
      }
      paramInt2 = ((bgyy)localObject).a(paramInt2);
    } while ((paramLong - this.jdField_b_of_type_Long) / 1000000L <= 83L * this.jdField_c_of_type_Long);
    QLog.d(jdField_a_of_type_JavaLangString, 4, new Object[] { "frameToMediaCodec, encode frame, gifRecordFrameIndex = ", Long.valueOf(this.jdField_c_of_type_Long) });
    this.jdField_c_of_type_Long += 1L;
    if (((bgyy)localObject).a() != null)
    {
      localObject = (PTFaceAttr)((bgyy)localObject).a().getFaceAttr();
      bhtg.jdField_a_of_type_JavaUtilList.add(((PTFaceAttr)localObject).getAllFacePoints());
      bhtg.b.add(((PTFaceAttr)localObject).getAllFaceAngles());
      bhtg.jdField_a_of_type_Double = ((PTFaceAttr)localObject).getFaceDetectScale();
    }
    a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, (paramLong / 1.5D));
  }
  
  private boolean c()
  {
    return (FeatureManager.isBasicFeaturesFunctionReady()) && (this.jdField_a_of_type_Bgzf != null) && ((this.jdField_a_of_type_Bgzf instanceof bgyy));
  }
  
  private void d(int paramInt)
  {
    if ((e()) && (this.jdField_b_of_type_Long > 0L))
    {
      Object localObject = (bgyy)this.jdField_a_of_type_Bgzf;
      if (this.jdField_a_of_type_Bhsc == null)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "recording gif, aeExpressionRecognizer == null, create it");
        this.jdField_a_of_type_Bhsc = new bhsc();
        this.jdField_a_of_type_Bhsc.a();
      }
      long l1 = (SystemClock.elapsedRealtimeNanos() - this.jdField_b_of_type_Long) / 1000000L;
      int i1 = this.jdField_a_of_type_Bhsc.a();
      QLog.d(jdField_a_of_type_JavaLangString, 4, "recording gif, aeExpressionRecognizer.getFrameCount() == " + i1);
      if ((i1 < 3) && ((float)l1 > (i1 + 0.5F) * 1000.0F) && (((bgyy)localObject).b()))
      {
        localObject = (PTFaceAttr)((bgyy)localObject).a().getFaceAttr();
        this.jdField_a_of_type_Bhsc.a(paramInt, (List)((PTFaceAttr)localObject).getAllFacePoints().get(0), (int)(this.jdField_i_of_type_Int * ((PTFaceAttr)localObject).getFaceDetectScale()), (int)(this.jdField_j_of_type_Int * ((PTFaceAttr)localObject).getFaceDetectScale()));
      }
    }
  }
  
  private void d(String paramString)
  {
    ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.10(this, paramString));
  }
  
  private boolean d()
  {
    if (!c()) {
      return true;
    }
    if (!((bgyy)this.jdField_a_of_type_Bgzf).d()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean e()
  {
    return (this.l) && (this.n) && (this.jdField_a_of_type_Auzf != null);
  }
  
  private void r()
  {
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 0, 0);
    setEGLContextFactory(this.jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory);
    setPreserveEGLContextOnPause(false);
    setRenderer(this);
    setRenderMode(0);
  }
  
  private void s()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture = new AudioCapture(this.jdField_a_of_type_Bgxk.jdField_a_of_type_JavaLangString, 1, awje.q, awje.o, awje.p, this, bgys.a().a());
    this.jdField_a_of_type_Ausi = new ausi(this.jdField_a_of_type_Bgxk.jdField_a_of_type_JavaLangString, awje.q, this);
    bgys.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
  }
  
  private void t()
  {
    Activity localActivity = (Activity)getContext();
    if ((Build.VERSION.SDK_INT >= 23) && (localActivity.checkSelfPermission("android.permission.CAMERA") != 0)) {
      q();
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_Bgzf != null) {
      return;
    }
    if (FeatureManager.loadBasicFeatures())
    {
      bhcs.a(jdField_a_of_type_JavaLangString, 1, "onSurfaceCreated: loadBasicFeatures success");
      this.jdField_a_of_type_Bgzf = new bgyy();
      ((bgyy)this.jdField_a_of_type_Bgzf).b(false);
      ((bgyy)this.jdField_a_of_type_Bgzf).a(this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager$StickerInnerEffectFilterListener);
      this.jdField_a_of_type_Bgzf.c();
      if (this.jdField_a_of_type_Bgyo != null) {
        this.jdField_a_of_type_Bgyo.c();
      }
      if ((this.jdField_a_of_type_Bgzf != null) && ((this.jdField_a_of_type_Bgzf instanceof bgyy))) {
        ((bgyy)this.jdField_a_of_type_Bgzf).a().setParam("SET_AEPROFILER_OBJ", this.jdField_a_of_type_Bgyf);
      }
    }
    for (;;)
    {
      String str = FeatureManager.getResourceDir();
      if (!AIManager.installDetector(PTSegmenter.class, str, str)) {
        bhcs.b(jdField_a_of_type_JavaLangString, 1, "PTSegmenter install error.");
      }
      bgys.a().a(this.jdField_a_of_type_Bgzf.a());
      return;
      bhcs.b(jdField_a_of_type_JavaLangString, 1, "onSurfaceCreated: loadBasicFeatures failed");
      this.jdField_a_of_type_Bgzf = new bgzg();
      this.jdField_a_of_type_Bgzf.c();
    }
  }
  
  private void v()
  {
    if ((this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null) && (VideoMaterialUtil.isAudio2textMaterial(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial))) {
      this.jdField_a_of_type_Bjji.a(getContext(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
    }
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_Bgzf != null)
    {
      this.jdField_a_of_type_Bgzf.d();
      this.jdField_a_of_type_Bgzf = null;
    }
  }
  
  private void x()
  {
    this.m = false;
  }
  
  private void y()
  {
    z();
    this.jdField_a_of_type_Bgyf.c();
  }
  
  private void z()
  {
    this.jdField_a_of_type_Bhcq = new bgym(this, getContext());
    if (this.jdField_a_of_type_Bhcq.a()) {
      this.jdField_a_of_type_Bhcq.a();
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_DovComQqImAECameraRecordAEVideoCaptureResult.videoFrameCount = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)
    {
      if (!this.jdField_a_of_type_Ausi.a()) {
        break label56;
      }
      this.jdField_a_of_type_Ausi.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bgyq != null) {
        this.jdField_a_of_type_Bgyq.j();
      }
      return;
      label56:
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    bgys.a().a(paramFloat1, paramFloat2);
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    int i3 = 720;
    double d1 = this.jdField_a_of_type_Int / this.jdField_b_of_type_Int;
    this.jdField_g_of_type_Int = paramInt1;
    this.jdField_h_of_type_Int = ((int)(this.jdField_g_of_type_Int / d1));
    Object localObject1;
    int i1;
    int i2;
    if (this.l)
    {
      localObject1 = autt.a(paramInt1, paramInt2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1.0F);
      localObject1 = autt.a(640, localObject1[0], localObject1[1]);
      i1 = localObject1[0];
      i2 = localObject1[1];
      this.jdField_i_of_type_Int = i1;
      this.jdField_j_of_type_Int = i2;
      this.jdField_g_of_type_Int = this.jdField_i_of_type_Int;
      this.jdField_h_of_type_Int = this.jdField_j_of_type_Int;
      if (this.jdField_a_of_type_Bgzf != null)
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
      this.jdField_a_of_type_Bgzf.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt1, paramInt2, i1, i2);
      bgys.a().a(i1, i2);
      this.jdField_a_of_type_Bgzf.a(this.jdField_g_of_type_Int, this.jdField_h_of_type_Int);
      bgxl.a.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      bgxl.a.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      bgxl.a.jdField_c_of_type_Int = Math.min(paramInt1, paramInt2);
      bgxl.a.jdField_d_of_type_Int = Math.max(paramInt1, paramInt2);
      if (bgys.a().c()) {}
      for (localObject1 = Camera2Control.a().c();; localObject1 = awij.a().b())
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new awim();
        }
        bgxl.a.jdField_e_of_type_Int = Math.min(((awim)localObject2).jdField_a_of_type_Int, ((awim)localObject2).jdField_b_of_type_Int);
        bgxl.a.jdField_f_of_type_Int = Math.max(((awim)localObject2).jdField_a_of_type_Int, ((awim)localObject2).jdField_b_of_type_Int);
        if (this.jdField_a_of_type_Bgzf != null)
        {
          localObject1 = this.jdField_a_of_type_Bgzf.a();
          bgxl.a.jdField_g_of_type_Int = localObject1[0];
          bgxl.a.jdField_h_of_type_Int = localObject1[1];
          bgxl.a.jdField_i_of_type_Int = localObject1[2];
          bgxl.a.jdField_j_of_type_Int = localObject1[3];
        }
        bgxl.a.m = this.jdField_g_of_type_Int;
        bgxl.a.n = this.jdField_h_of_type_Int;
        if ((bgxl.a()) && (this.jdField_a_of_type_Wsu != null)) {
          this.jdField_a_of_type_Wsu.b();
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
    if ((this.n) && (this.jdField_a_of_type_Auzf != null))
    {
      switch (this.jdField_k_of_type_Int)
      {
      default: 
        throw new RuntimeException("unknown status " + this.jdField_k_of_type_Int);
      case 0: 
        this.jdField_a_of_type_Auzf.a(EGL14.eglGetCurrentContext());
        this.jdField_a_of_type_Auzt.a();
        this.jdField_a_of_type_Auzt.a(this.jdField_a_of_type_Auzf, this);
        this.jdField_k_of_type_Int = 1;
      }
      this.jdField_a_of_type_Auzt.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
      return;
    }
    switch (this.jdField_k_of_type_Int)
    {
    case 0: 
    default: 
      throw new RuntimeException("unknown status " + this.jdField_k_of_type_Int);
    }
    this.jdField_a_of_type_Auzt.b();
    B();
    this.jdField_k_of_type_Int = 0;
  }
  
  public void a(Bitmap paramBitmap)
  {
    ThreadManager.excute(new AECameraGLSurfaceView.6(this, paramBitmap), 64, null, false);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2.getRotation(this.jdField_a_of_type_ArrayOfFloat);
    this.jdField_a_of_type_Boolean = true;
    queueEvent(new AECameraGLSurfaceView.3(this));
    requestRender();
  }
  
  protected void a(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    int i1 = 1;
    if (this.jdField_a_of_type_Bgyq != null) {
      this.jdField_a_of_type_Bgyq.a(paramAEVideoCaptureResult);
    }
    ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.4(this));
    auue.c();
    if (awij.a().jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      auts.i(i1);
      return;
      i1 = 2;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onEncodeFinish filePath = " + paramString);
    }
    this.jdField_a_of_type_DovComQqImAECameraRecordAEVideoCaptureResult.videoMp4FilePath = paramString;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)
    {
      if (this.jdField_a_of_type_DovComQqImAECameraRecordAEVideoCaptureResult.audioDataFilePath != null)
      {
        a(this.jdField_a_of_type_DovComQqImAECameraRecordAEVideoCaptureResult);
        return;
      }
      if (this.jdField_a_of_type_Ausi.a())
      {
        this.jdField_a_of_type_Ausi.b();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e();
      return;
    }
    paramString = this.jdField_a_of_type_Bgxk.jdField_a_of_type_JavaLangString + "/noaudio";
    bace.c(paramString);
    this.jdField_a_of_type_DovComQqImAECameraRecordAEVideoCaptureResult.audioDataFilePath = paramString;
    a(this.jdField_a_of_type_DovComQqImAECameraRecordAEVideoCaptureResult);
  }
  
  public void a(boolean paramBoolean)
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
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_Bgyp != null)
    {
      this.jdField_a_of_type_Bgyp.a(paramBoolean, paramString);
      bhcs.a(jdField_a_of_type_JavaLangString, 1, "【onCameraStarted】success:" + paramBoolean);
      bhcs.a(jdField_a_of_type_JavaLangString, 1, "【onCameraStarted】errMsg:" + paramString);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (ahll.a().a()) {
      ahll.a().a(paramArrayOfByte, paramInt1, paramInt2);
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
    this.jdField_a_of_type_Ausi.a(paramArrayOfByte, paramInt1, paramInt2);
    this.jdField_a_of_type_Bjji.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public boolean a()
  {
    return bgys.a().a();
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    this.jdField_a_of_type_DovComQqImAECameraRecordAEVideoCaptureResult.errorCode = paramInt;
    if (this.jdField_a_of_type_Bgyq != null) {
      this.jdField_a_of_type_Bgyq.a(104);
    }
  }
  
  public void a_(String paramString)
  {
    a(new auuy(1, 0, paramString, null, this.jdField_d_of_type_Int));
  }
  
  public int b()
  {
    return bgys.a().a();
  }
  
  public void b()
  {
    AEVideoCaptureResult localAEVideoCaptureResult = this.jdField_a_of_type_DovComQqImAECameraRecordAEVideoCaptureResult;
    localAEVideoCaptureResult.videoFrameCount += 1;
  }
  
  public void b(int paramInt) {}
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_DovComQqImAECameraRecordAEVideoCaptureResult.audioDataFilePath = paramString;
    if (this.jdField_a_of_type_DovComQqImAECameraRecordAEVideoCaptureResult.videoMp4FilePath != null) {
      a(this.jdField_a_of_type_DovComQqImAECameraRecordAEVideoCaptureResult);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((!PTSegmenter.SEGMENT.isFunctionReady()) && (paramBoolean)) {
      bbmy.a(BaseApplicationImpl.getContext(), ajjy.a(2131624281), 0).a();
    }
    while (!c()) {
      return;
    }
    ((bgyy)this.jdField_a_of_type_Bgzf).b(paramBoolean);
  }
  
  public boolean b()
  {
    return this.n;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)
    {
      ahll.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
      queueEvent(new AECameraGLSurfaceView.5(this));
    }
  }
  
  public void c(int paramInt)
  {
    bgys.a().a();
  }
  
  public void c(String paramString) {}
  
  public void d()
  {
    ahll.a().a(null);
  }
  
  public void e()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "### in surfaceView destroy.");
    }
    if (this.jdField_a_of_type_Bjji != null) {
      this.jdField_a_of_type_Bjji.a();
    }
    bgyx.a(null);
    bgyy.a(true);
    bgys.a().c();
    this.jdField_a_of_type_Bgyf.h();
    if (this.jdField_a_of_type_Auzt != null) {
      this.jdField_a_of_type_Auzt.c();
    }
  }
  
  public void f()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    bgys.a().e();
  }
  
  public void g() {}
  
  public void h()
  {
    this.jdField_a_of_type_Bgyf.b();
    this.jdField_f_of_type_Boolean = true;
  }
  
  public void i()
  {
    bgyy.a(false);
    bgys.a().d();
    this.jdField_a_of_type_Bgyf.a(bgys.a().a());
    if (this.l) {}
    for (;;)
    {
      if (this.jdField_a_of_type_Bgyp != null) {
        this.jdField_a_of_type_Bgyp.g();
      }
      return;
      bhci.a().m();
      bhcs.a(jdField_a_of_type_JavaLangString, 1, "【Change Camera】:isFrontCamera:" + bgys.a().a());
    }
  }
  
  public void j()
  {
    if (d())
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "capturePhotoByCameraProxy");
      bgxl.a.jdField_b_of_type_Boolean = false;
      A();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bgyf.e();
      if (this.jdField_a_of_type_Bgyq != null) {
        this.jdField_a_of_type_Bgyq.i();
      }
      return;
      QLog.d(jdField_a_of_type_JavaLangString, 4, "capturePhotoByAEKit");
      bgxl.a.jdField_b_of_type_Boolean = true;
      k();
    }
  }
  
  public void k()
  {
    int i1 = 0;
    if (bgys.a().b())
    {
      bgys.a().a((Activity)getContext(), true);
      i1 = 1500;
    }
    ThreadManager.getUIHandler().postDelayed(new AECameraGLSurfaceView.13(this), i1);
  }
  
  public void l()
  {
    this.jdField_a_of_type_Bgyf.f();
    if (bgys.a().b()) {
      bgys.a().a((Activity)getContext(), true);
    }
    String str = this.jdField_a_of_type_Bgxk.jdField_a_of_type_JavaLangString + "/" + System.currentTimeMillis() + ".mp4";
    if (this.o) {}
    for (int i1 = autt.b(this.jdField_d_of_type_Int);; i1 = 0)
    {
      this.jdField_a_of_type_Auzf = new auzf(str, this.jdField_g_of_type_Int, this.jdField_h_of_type_Int, this.jdField_a_of_type_Bgxk.a(), this.jdField_a_of_type_Bgxk.f(), false, i1);
      this.jdField_a_of_type_Auzf.jdField_j_of_type_Int = this.jdField_a_of_type_Bgxk.h();
      this.jdField_a_of_type_Auzf.jdField_k_of_type_Int = this.jdField_a_of_type_Bgxk.i();
      this.jdField_a_of_type_DovComQqImAECameraRecordAEVideoCaptureResult = new AEVideoCaptureResult();
      this.jdField_a_of_type_DovComQqImAECameraRecordAEVideoCaptureResult.startTimeMs = System.currentTimeMillis();
      this.jdField_a_of_type_DovComQqImAECameraRecordAEVideoCaptureResult.orientation = this.jdField_d_of_type_Int;
      this.jdField_a_of_type_DovComQqImAECameraRecordAEVideoCaptureResult.type = 0;
      if (bgys.a().a() == 2) {
        bgys.a().l();
      }
      this.n = true;
      autt.a(false, false);
      return;
    }
  }
  
  public void m()
  {
    if (this.n)
    {
      this.n = false;
      if (this.jdField_k_of_type_Int != 0) {
        break label50;
      }
      if (this.jdField_a_of_type_Bgyq != null) {
        this.jdField_a_of_type_Bgyq.a(102);
      }
    }
    for (;;)
    {
      bgys.a().k();
      bgys.a().g();
      return;
      label50:
      if (this.jdField_i_of_type_Boolean) {
        a(0, null, null);
      }
    }
  }
  
  public void n()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    bgys.a().b();
  }
  
  public void o()
  {
    bgys.a().f();
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    long l1 = 0L;
    if (this.jdField_g_of_type_Boolean)
    {
      long l2 = System.currentTimeMillis();
      l1 = l2;
      if (QLog.isDevelopLevel())
      {
        QLog.d("CameraLaunchPerf", 4, "drawFirstFrame begin time=" + l2);
        l1 = l2;
      }
    }
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_f_of_type_Boolean = false;
      y();
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glClear(16384);
      GLES20.glFinish();
    }
    if (c())
    {
      if (this.jdField_a_of_type_Bgzf == null) {
        return;
      }
      paramGL10 = this.jdField_a_of_type_Bgzf.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      bgyy localbgyy = (bgyy)this.jdField_a_of_type_Bgzf;
      C();
      if (this.jdField_a_of_type_Wuf != null) {
        this.jdField_a_of_type_Wuf.a(bgys.a().a(), localbgyy.a());
      }
      d(paramGL10[1]);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bgzf != null) {
        this.jdField_a_of_type_Bgzf.c(paramGL10[0]);
      }
      a(paramGL10[1], null, null);
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        queueEvent(new AECameraGLSurfaceView.8(this));
      }
      this.jdField_a_of_type_Bgyf.d();
      if (!this.jdField_g_of_type_Boolean) {
        break;
      }
      bhcm.a().f();
      bhci.a().A();
      bhcs.a(jdField_a_of_type_JavaLangString, 1, "【First Launch】：" + System.currentTimeMillis());
      if (QLog.isDevelopLevel()) {
        QLog.d("CameraLaunchPerf", 4, "drawFirstFrame end cost=" + (System.currentTimeMillis() - l1));
      }
      this.jdField_g_of_type_Boolean = false;
      if (!bgxl.a()) {
        break;
      }
      bgxl.a(this.jdField_a_of_type_Wsu, 5000L);
      return;
      if (this.jdField_a_of_type_Bgzf == null) {
        break;
      }
      paramGL10 = this.jdField_a_of_type_Bgzf.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    }
  }
  
  public void onPause()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "in surfaceView pause.");
    }
    queueEvent(new AECameraGLSurfaceView.2(this));
    if (this.jdField_a_of_type_Wsh == wsh.b) {}
    for (this.jdField_h_of_type_Boolean = true;; this.jdField_h_of_type_Boolean = false)
    {
      this.jdField_i_of_type_Boolean = false;
      bgys.a().b();
      bgys.a().j();
      if (this.jdField_a_of_type_Bhcq != null) {
        this.jdField_a_of_type_Bhcq.b();
      }
      this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2.start();
      super.onPause();
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2.start();
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "### AECameraGLSurfaceView onResume ###");
    }
    this.jdField_i_of_type_Boolean = false;
    this.n = false;
    t();
    bgys.a().i();
    if ((this.jdField_a_of_type_Bhcq != null) && (this.jdField_a_of_type_Bhcq.a())) {
      this.jdField_a_of_type_Bhcq.a();
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("CameraLaunchPerf", 4, "AECameraGLSurfaceView onSurfaceChanged time=" + System.currentTimeMillis());
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    bgys.a().b(paramInt1, paramInt2);
    if ((!this.jdField_h_of_type_Boolean) && (!this.jdField_i_of_type_Boolean)) {
      q();
    }
    if (this.jdField_a_of_type_Bgzf != null) {
      this.jdField_a_of_type_Bgzf.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 0, 0, paramInt1, paramInt2);
    }
    if (this.jdField_c_of_type_Int != 0) {
      setBeautyLevel(this.jdField_c_of_type_Int);
    }
    if (this.jdField_a_of_type_Wur != null) {
      this.jdField_a_of_type_Wur.a(paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    bhcs.a(jdField_a_of_type_JavaLangString, 1, "【SurfaceTexture Created】onSurfaceCreated");
    u();
    if (this.jdField_a_of_type_Wuf != null) {
      this.jdField_a_of_type_Wuf.a();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent == null) {
      return false;
    }
    if ((!c()) || (this.jdField_a_of_type_Bgxh == null)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    bgyy localbgyy = (bgyy)this.jdField_a_of_type_Bgzf;
    if ((paramMotionEvent != null) && (localbgyy.c()) && (!this.jdField_a_of_type_Bgxh.c()))
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
        this.p = true;
        queueEvent(new AECameraGLSurfaceView.16(this, localbgyy, f1, f2, i1));
        continue;
        if (a(this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, f1, f2) > i1 * 0.05F)
        {
          queueEvent(new AECameraGLSurfaceView.17(this, localbgyy, f1, f2, i1));
          continue;
          queueEvent(new AECameraGLSurfaceView.18(this, localbgyy, f1, f2, i1));
          this.p = true;
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
    bgys.a().a();
  }
  
  public void q()
  {
    int i1;
    if ((Build.VERSION.SDK_INT >= 23) && (this.jdField_a_of_type_Bgyp != null))
    {
      Activity localActivity = (Activity)getContext();
      i1 = localActivity.checkSelfPermission("android.permission.CAMERA");
      int i2 = localActivity.checkSelfPermission("android.permission.RECORD_AUDIO");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "startCameraWithPermission, camera: ", Integer.valueOf(i1), " audio: ", Integer.valueOf(i2) });
      }
      if ((i1 != 0) || (i2 != 0)) {
        if (!this.jdField_d_of_type_Boolean)
        {
          this.jdField_d_of_type_Boolean = true;
          this.jdField_a_of_type_Bgyp.h();
        }
      }
    }
    for (;;)
    {
      return;
      for (i1 = 0; (i1 != 0) || (this.jdField_e_of_type_Boolean); i1 = 1)
      {
        bgys.a().a(this);
        bgys.a().a();
        bgys.a().e();
        return;
      }
    }
  }
  
  public void setAECaptureController(bgxh parambgxh)
  {
    this.jdField_a_of_type_Bgxh = parambgxh;
  }
  
  public void setAEKitInitListener(bgyo parambgyo)
  {
    this.jdField_a_of_type_Bgyo = parambgyo;
  }
  
  public void setBeautyLevel(int paramInt)
  {
    if (!c()) {
      return;
    }
    this.jdField_c_of_type_Int = paramInt;
    queueEvent(new AECameraGLSurfaceView.14(this, paramInt));
  }
  
  public void setBlockCameraFlag(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
  
  public void setCameraListener(bgyp parambgyp)
  {
    this.jdField_a_of_type_Bgyp = parambgyp;
  }
  
  public void setCameraPermissionFinish(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setCameraPermissionResult(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "setCameraPermissionResult, ", Boolean.valueOf(paramBoolean) });
    }
    this.jdField_e_of_type_Boolean = true;
    if (!this.jdField_h_of_type_Boolean)
    {
      bgys.a().a();
      bgys.a().e();
    }
  }
  
  public void setCaptureListener(bgyq parambgyq)
  {
    this.jdField_a_of_type_Bgyq = parambgyq;
  }
  
  public void setCaptureParam(bgxk parambgxk)
  {
    if (this.jdField_a_of_type_Bgxk != null) {
      throw new RuntimeException("setCaptureParam is already called");
    }
    this.jdField_a_of_type_Bgxk = parambgxk;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setCaptureParam : " + parambgxk);
    }
    a(parambgxk);
  }
  
  public void setCaptureRequest(bgyr parambgyr)
  {
    this.jdField_a_of_type_Bgzf.a(parambgyr);
  }
  
  public void setDarkModeEnable(boolean paramBoolean)
  {
    bgys.a().a(paramBoolean);
  }
  
  public void setDarkModeListener(autx paramautx)
  {
    bgys.a().a(paramautx);
  }
  
  public void setDynamicResolutionMode(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    bgys.a().b(paramBoolean);
  }
  
  public void setFaceEffectListener(bgyn parambgyn)
  {
    this.jdField_a_of_type_Bgyn = parambgyn;
  }
  
  public void setFilter(FilterCategoryItem paramFilterCategoryItem)
  {
    if (!c()) {}
    bgyy localbgyy;
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
            localbgyy = (bgyy)this.jdField_a_of_type_Bgzf;
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
    localbgyy.a(paramFilterCategoryItem);
  }
  
  public void setIsGIFMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bgyf.b(paramBoolean);
    this.l = paramBoolean;
  }
  
  public void setMaterial(String paramString)
  {
    ThreadManager.excute(new AECameraGLSurfaceView.12(this, new AECameraGLSurfaceView.11(this, paramString)), 64, null, true);
  }
  
  public void setMaterialMetaData(bgya parambgya)
  {
    if ((parambgya == null) || (parambgya.equals(bgya.a)))
    {
      setMaterial(null);
      return;
    }
    setMaterial(parambgya.a());
  }
  
  public void setOnFrameDraw(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public void setOnSurfaceChangedListener(wur paramwur)
  {
    this.jdField_a_of_type_Wur = paramwur;
  }
  
  public void setRecommendTextCallback(bhse parambhse)
  {
    this.jdField_a_of_type_Bhse = parambhse;
  }
  
  public void setSceneListener(wuf paramwuf)
  {
    this.jdField_a_of_type_Wuf = paramwuf;
  }
  
  public void setSharpFaceLevel(int paramInt)
  {
    if (!c()) {
      return;
    }
    queueEvent(new AECameraGLSurfaceView.15(this, paramInt));
  }
  
  public void setStickerInnerLutFilterListener(AEFilterManager.StickerInnerEffectFilterListener paramStickerInnerEffectFilterListener)
  {
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager$StickerInnerEffectFilterListener = paramStickerInnerEffectFilterListener;
    if ((this.jdField_a_of_type_Bgzf != null) && ((this.jdField_a_of_type_Bgzf instanceof bgyy))) {
      ((bgyy)this.jdField_a_of_type_Bgzf).a(paramStickerInnerEffectFilterListener);
    }
  }
  
  public void setZoom(int paramInt)
  {
    bgys.a().a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.View.AECameraGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */