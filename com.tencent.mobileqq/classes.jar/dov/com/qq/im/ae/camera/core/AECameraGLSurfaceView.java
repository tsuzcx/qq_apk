package dov.com.qq.im.ae.camera.core;

import allk;
import almq;
import alox;
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
import anni;
import bama;
import bamb;
import banm;
import bann;
import bany;
import baox;
import batj;
import batv;
import batx;
import bcig;
import bcjb;
import bgmg;
import bndd;
import bnhe;
import bnhf;
import bnhg;
import bnhi;
import bnhj;
import bnhk;
import bnhl;
import bnhm;
import bnhn;
import bnho;
import bnic;
import bnid;
import bnif;
import bnig;
import bnih;
import bnii;
import bnjv;
import bnlm;
import bnmd;
import bnop;
import bnpf;
import bnpy;
import bnqj;
import bnql;
import bnsi;
import bnvc;
import bnvd;
import bnvg;
import bnyh;
import bnyl;
import bnzb;
import bqcb;
import bqgu;
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
  implements alox, GLSurfaceView.Renderer, bama, batv, bnif
{
  private static volatile boolean o;
  private int jdField_a_of_type_Int = 320;
  private long jdField_a_of_type_Long;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF(0.0F, 0.0F);
  private bamb jdField_a_of_type_Bamb;
  private batj jdField_a_of_type_Batj;
  private batx jdField_a_of_type_Batx;
  private bnhe jdField_a_of_type_Bnhe;
  private bnhj jdField_a_of_type_Bnhj;
  private bnhk jdField_a_of_type_Bnhk;
  private bnhl jdField_a_of_type_Bnhl;
  private bnhn jdField_a_of_type_Bnhn;
  private bnho jdField_a_of_type_Bnho;
  private bnig jdField_a_of_type_Bnig;
  private bnii jdField_a_of_type_Bnii;
  private bnjv jdField_a_of_type_Bnjv;
  public bnmd a;
  private bnop jdField_a_of_type_Bnop;
  private bnqj jdField_a_of_type_Bnqj;
  private bnql jdField_a_of_type_Bnql;
  private bnvg jdField_a_of_type_Bnvg = new bnvc();
  private bqgu jdField_a_of_type_Bqgu = new bqgu();
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
  
  public AECameraGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    n();
    this.jdField_m_of_type_Int = System.identityHashCode(this);
  }
  
  public AECameraGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bnvd.a().a("glSurfaceViewConstruct-begin");
    n();
    this.jdField_m_of_type_Int = System.identityHashCode(this);
    bnvd.a().a("glSurfaceViewConstruct-end");
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
  
  private void a(baox parambaox)
  {
    if (this.jdField_a_of_type_Bnhl != null) {
      this.jdField_a_of_type_Bnhl.a(parambaox);
    }
    ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.8(this));
  }
  
  private void a(bnid parambnid)
  {
    if (this.jdField_a_of_type_Bnhj != null) {
      this.jdField_a_of_type_Bnhj.a(parambnid);
    }
  }
  
  private void a(VideoMaterial paramVideoMaterial)
  {
    if (this.jdField_a_of_type_Bnhj != null) {
      this.jdField_a_of_type_Bnhj.a(paramVideoMaterial);
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Bnhj != null) {
      this.jdField_a_of_type_Bnhj.a(paramBoolean1, paramBoolean2);
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
    if (this.jdField_a_of_type_Bnig == null) {}
    Object localObject;
    do
    {
      return;
      localObject = (bnid)this.jdField_a_of_type_Bnig;
      if (this.jdField_a_of_type_Long == 0L)
      {
        QLog.d("AECameraGLSurfaceView", 4, "frameToMediaCodec, gifRecordStartTimestamp == 0");
        this.jdField_a_of_type_Long = paramLong;
        bnsi.jdField_a_of_type_JavaUtilList = new ArrayList();
        bnsi.b = new ArrayList();
      }
      paramInt2 = ((bnid)localObject).a(paramInt2);
    } while ((paramLong - this.jdField_a_of_type_Long) / 1000000L <= 83L * this.jdField_b_of_type_Long);
    QLog.d("AECameraGLSurfaceView", 4, new Object[] { "frameToMediaCodec, encode frame, gifRecordFrameIndex = ", Long.valueOf(this.jdField_b_of_type_Long) });
    this.jdField_b_of_type_Long += 1L;
    if (((bnid)localObject).a() != null)
    {
      localObject = (PTFaceAttr)((bnid)localObject).a().getFaceAttr();
      bnsi.jdField_a_of_type_JavaUtilList.add(((PTFaceAttr)localObject).getAllFacePoints());
      bnsi.b.add(((PTFaceAttr)localObject).getAllFaceAngles());
      bnsi.jdField_a_of_type_Double = ((PTFaceAttr)localObject).getFaceDetectScale();
    }
    a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, (paramLong / 1.5D));
  }
  
  private void b(allk paramallk)
  {
    if (this.jdField_a_of_type_Bnho.c()) {
      this.jdField_a_of_type_Bnho.a((Activity)getContext(), true);
    }
    Object localObject = this.jdField_a_of_type_Bnhe.jdField_a_of_type_JavaLangString + "/" + System.currentTimeMillis() + ".jpg";
    bgmg.c((String)localObject);
    localObject = new File((String)localObject);
    boolean bool = this.jdField_a_of_type_Bnho.b();
    int i1 = bann.c(this.jdField_e_of_type_Int);
    this.jdField_a_of_type_Bnho.a((File)localObject, i1, bool, this, paramallk);
  }
  
  private void c(int paramInt)
  {
    if ((f()) && (this.jdField_a_of_type_Long > 0L))
    {
      Object localObject = (bnid)this.jdField_a_of_type_Bnig;
      if (this.jdField_a_of_type_Bnqj == null)
      {
        QLog.d("AECameraGLSurfaceView", 4, "recording gif, aeExpressionRecognizer == null, create it");
        this.jdField_a_of_type_Bnqj = new bnqj();
        this.jdField_a_of_type_Bnqj.a();
      }
      long l1 = (SystemClock.elapsedRealtimeNanos() - this.jdField_a_of_type_Long) / 1000000L;
      int i1 = this.jdField_a_of_type_Bnqj.a();
      QLog.d("AECameraGLSurfaceView", 4, "recording gif, aeExpressionRecognizer.getFrameCount() == " + i1);
      if ((i1 < 3) && ((float)l1 > (i1 + 0.5F) * 1000.0F) && (((bnid)localObject).c()))
      {
        localObject = (PTFaceAttr)((bnid)localObject).a().getFaceAttr();
        this.jdField_a_of_type_Bnqj.a(paramInt, (List)((PTFaceAttr)localObject).getAllFacePoints().get(0), (int)(this.jdField_j_of_type_Int * ((PTFaceAttr)localObject).getFaceDetectScale()), (int)(this.jdField_k_of_type_Int * ((PTFaceAttr)localObject).getFaceDetectScale()));
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    int i1 = (int)(this.jdField_b_of_type_Int * 1.0F / this.jdField_a_of_type_Int * this.jdField_a_of_type_Bnhe.c());
    if (bqcb.a().e()) {
      i1 = this.jdField_a_of_type_Bnhe.b();
    }
    if (this.jdField_b_of_type_Boolean)
    {
      arrayOfInt = bann.a(i1, paramInt1, paramInt2);
      arrayOfInt = bann.a(arrayOfInt[0], arrayOfInt[1], this.jdField_a_of_type_Bnhe.d(), this.jdField_a_of_type_Bnhe.e(), 1.0F);
      this.jdField_h_of_type_Int = arrayOfInt[0];
      this.jdField_i_of_type_Int = arrayOfInt[1];
      return;
    }
    int[] arrayOfInt = bann.a(paramInt1, paramInt2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Bnhe.a());
    this.jdField_h_of_type_Int = arrayOfInt[0];
    this.jdField_i_of_type_Int = arrayOfInt[1];
    arrayOfInt = bann.a(i1, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int);
    this.jdField_h_of_type_Int = arrayOfInt[0];
    this.jdField_i_of_type_Int = arrayOfInt[1];
  }
  
  private boolean d()
  {
    return (bnpy.a()) && (this.jdField_a_of_type_Bnig != null) && ((this.jdField_a_of_type_Bnig instanceof bnid));
  }
  
  public static void e()
  {
    try
    {
      bnzb.b("AECameraGLSurfaceView", "[initSdk] + BEGIN, isSdkInited = " + o);
      long l1 = System.currentTimeMillis();
      if (!o)
      {
        bnzb.b("AECameraGLSurfaceView", "[initSdk] do init");
        o = true;
        bnvd.a().a("glSurfaceViewStaticInit-begin");
        if (bndd.a()) {
          VideoPrefsUtil.init(BaseApplicationImpl.getContext(), ShortVideoUtils.a());
        }
        bnvd.a().a("glSurfaceViewStaticInit-end");
      }
      bnzb.b("AECameraGLSurfaceView", "[initSdk] + END, time cost = " + (System.currentTimeMillis() - l1));
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
    if (!((bnid)this.jdField_a_of_type_Bnig).e()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean f()
  {
    return (this.jdField_k_of_type_Boolean) && (this.jdField_m_of_type_Boolean) && (this.jdField_a_of_type_Batj != null);
  }
  
  private void n()
  {
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 0, 0);
    setEGLContextFactory(new bnhf(this));
    setPreserveEGLContextOnPause(false);
    setRenderer(this);
    setRenderMode(0);
    o();
  }
  
  private void o()
  {
    bnzb.b("AECameraGLSurfaceView", "preAction");
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
    if (this.jdField_a_of_type_Bnig != null) {
      return;
    }
    bnzb.b("AECameraGLSurfaceView", "createFilterProcess---BEGIN");
    bndd.a();
    if (FeatureManager.loadBasicFeatures())
    {
      this.jdField_a_of_type_Bnig = new bnid(this.jdField_m_of_type_Int);
      bnzb.b("AECameraGLSurfaceView", "createFilterProcess---create AEFilterProcessTex");
      return;
    }
    this.jdField_a_of_type_Bnig = new bnih();
    bnzb.d("AECameraGLSurfaceView", "createFilterProcess---create NonAEFilterProcess");
  }
  
  private void r()
  {
    bnvd.a().a("AECameraGLSurfaceView", "initFilterProcess---begin");
    if (this.jdField_a_of_type_Bnig == null) {
      q();
    }
    if ((this.jdField_a_of_type_Bnig instanceof bnid))
    {
      bnic.a((bnid)this.jdField_a_of_type_Bnig);
      if (this.jdField_a_of_type_Bnhk != null) {
        this.jdField_a_of_type_Bnhk.b();
      }
      ((bnid)this.jdField_a_of_type_Bnig).b(false);
      ((bnid)this.jdField_a_of_type_Bnig).a(this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager$StickerInnerEffectFilterListener);
      ((bnid)this.jdField_a_of_type_Bnig).a().setParam("SET_AEPROFILER_OBJ", this.jdField_a_of_type_Bnvg);
    }
    SurfaceTexture localSurfaceTexture = this.jdField_a_of_type_Bnig.a();
    localSurfaceTexture.setOnFrameAvailableListener(new bnhi(this));
    if (this.jdField_a_of_type_Bnhn != null) {
      this.jdField_a_of_type_Bnhn.a(localSurfaceTexture);
    }
    bnvd.a().a("AECameraGLSurfaceView", "initFilterProcess---end");
  }
  
  private void s()
  {
    if ((this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null) && (VideoMaterialUtil.isAudio2textMaterial(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial))) {
      this.jdField_a_of_type_Bqgu.a(getContext(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_Bnig != null)
    {
      this.jdField_a_of_type_Bnig.h();
      this.jdField_a_of_type_Bnig = null;
      if (this.jdField_a_of_type_Bnhn != null) {
        this.jdField_a_of_type_Bnhn.a();
      }
    }
    bnic.a(null);
  }
  
  private void u()
  {
    v();
    this.jdField_a_of_type_Bnvg.c();
  }
  
  private void v()
  {
    this.jdField_a_of_type_Bnop = new bnhg(this, getContext());
    if (this.jdField_a_of_type_Bnop.a()) {
      this.jdField_a_of_type_Bnop.a();
    }
  }
  
  private void w()
  {
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_a_of_type_Long = 0L;
      this.jdField_b_of_type_Long = 0L;
      QLog.d("AECameraGLSurfaceView", 4, "onMediaCodecStopRecord");
      if (this.jdField_a_of_type_Bnqj != null)
      {
        QLog.d("AECameraGLSurfaceView", 4, "onMediaCodecStopRecord and aeExpressionRecognizer != null, release it");
        this.jdField_a_of_type_Bnqj.a(this.jdField_a_of_type_Bnql);
        this.jdField_a_of_type_Bnqj.b();
        this.jdField_a_of_type_Bnqj.c();
      }
    }
  }
  
  private void x()
  {
    if (!d()) {
      return;
    }
    bnid localbnid = (bnid)this.jdField_a_of_type_Bnig;
    if ((localbnid.b()) && (!localbnid.c()) && (!this.jdField_i_of_type_Boolean))
    {
      this.jdField_g_of_type_Int += 1;
      if (this.jdField_g_of_type_Int >= 4)
      {
        a(localbnid.b(), localbnid.c());
        this.jdField_g_of_type_Int = 0;
      }
    }
    if ((!this.jdField_i_of_type_Boolean) && (localbnid.c())) {
      a(localbnid.b(), localbnid.c());
    }
    if (!localbnid.b()) {
      a(localbnid.b(), localbnid.c());
    }
    if ((this.jdField_i_of_type_Boolean) && (localbnid.c())) {
      a(localbnid.b(), localbnid.c());
    }
    this.jdField_i_of_type_Boolean = localbnid.c();
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
      if (!this.jdField_a_of_type_Bamb.a()) {
        break label56;
      }
      this.jdField_a_of_type_Bamb.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bnhl != null) {
        this.jdField_a_of_type_Bnhl.m();
      }
      return;
      label56:
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Bnho.a(paramFloat1, paramFloat2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_Bamb.a()))
    {
      bnzb.d("AECameraGLSurfaceView", "onAudioError---errorCode=" + paramInt);
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.audioDataFilePath = "";
      if (this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath != null) {
        a(this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i3 = 720;
    bnzb.b("AECameraGLSurfaceView", "onCameraPreviewSizeChanged---cameraWidth=" + paramInt1 + ", cameraHeight=" + paramInt2 + ", mSurfaceWidth=" + this.jdField_a_of_type_Int + ", mSurfaceHeight=" + this.jdField_b_of_type_Int);
    double d1 = this.jdField_a_of_type_Int / this.jdField_b_of_type_Int;
    this.jdField_h_of_type_Int = paramInt1;
    this.jdField_i_of_type_Int = ((int)(this.jdField_h_of_type_Int / d1));
    int i1;
    int i2;
    if (this.jdField_k_of_type_Boolean)
    {
      int[] arrayOfInt = bann.a(paramInt1, paramInt2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1.0F);
      arrayOfInt = bann.a(640, arrayOfInt[0], arrayOfInt[1]);
      i1 = arrayOfInt[0];
      i2 = arrayOfInt[1];
      this.jdField_j_of_type_Int = i1;
      this.jdField_k_of_type_Int = i2;
      this.jdField_h_of_type_Int = this.jdField_j_of_type_Int;
      this.jdField_i_of_type_Int = this.jdField_k_of_type_Int;
      if (this.jdField_a_of_type_Bnig != null)
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
      this.jdField_a_of_type_Bnig.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt1, paramInt2, i1, i2);
      this.jdField_a_of_type_Bnho.a(i1, i2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Bnig.a(this.jdField_h_of_type_Int, this.jdField_i_of_type_Int);
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
    if ((this.jdField_m_of_type_Boolean) && (this.jdField_a_of_type_Batj != null))
    {
      switch (this.jdField_l_of_type_Int)
      {
      default: 
        throw new RuntimeException("unknown status " + this.jdField_l_of_type_Int);
      case 0: 
        this.jdField_a_of_type_Batj.a(EGL14.eglGetCurrentContext());
        this.jdField_a_of_type_Batx.a();
        this.jdField_a_of_type_Batx.a(this.jdField_a_of_type_Batj, this);
        this.jdField_l_of_type_Int = 1;
      }
      this.jdField_a_of_type_Batx.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
      return;
    }
    switch (this.jdField_l_of_type_Int)
    {
    case 0: 
    default: 
      throw new RuntimeException("unknown status " + this.jdField_l_of_type_Int);
    }
    this.jdField_a_of_type_Batx.b();
    w();
    this.jdField_l_of_type_Int = 0;
  }
  
  public void a(allk paramallk)
  {
    if (e())
    {
      QLog.d("AECameraGLSurfaceView", 4, "capturePhotoByCameraProxy");
      bnlm.a.jdField_b_of_type_Boolean = false;
      b(paramallk);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bnvg.e();
      if (this.jdField_a_of_type_Bnhl != null) {
        this.jdField_a_of_type_Bnhl.l();
      }
      return;
      QLog.d("AECameraGLSurfaceView", 4, "capturePhotoByAEKit");
      bnlm.a.jdField_b_of_type_Boolean = true;
      k();
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    ThreadManager.excute(new AECameraGLSurfaceView.7(this, paramBitmap), 64, null, false);
  }
  
  public void a(bnho parambnho, bnhe parambnhe)
  {
    if ((this.jdField_a_of_type_Bnhe != null) || (this.jdField_a_of_type_Bnho != null)) {
      throw new RuntimeException("init is already called");
    }
    if (parambnho == null) {
      throw new IllegalArgumentException("param cameraManager is null");
    }
    if (parambnhe == null) {
      throw new IllegalArgumentException("param captureParam is null");
    }
    this.jdField_a_of_type_Bnhe = parambnhe;
    this.jdField_a_of_type_Bnho = parambnho;
    if (QLog.isColorLevel()) {
      QLog.d("AECameraGLSurfaceView", 2, "setCaptureParam : " + parambnhe);
    }
    this.jdField_a_of_type_Batx = new batx();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture = new AudioCapture(this.jdField_a_of_type_Bnhe.jdField_a_of_type_JavaLangString, 1, bcjb.q, bcjb.o, bcjb.p, this, this.jdField_a_of_type_Bnho.a());
    this.jdField_a_of_type_Bamb = new bamb(this.jdField_a_of_type_Bnhe.jdField_a_of_type_JavaLangString, bcjb.q, this);
    this.jdField_a_of_type_Bnho.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
    if (this.jdField_c_of_type_Boolean)
    {
      parambnho = this.jdField_a_of_type_Bnhe.jdField_a_of_type_JavaLangString + File.separator + System.currentTimeMillis() + ".aac";
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a(true, parambnho);
    }
    this.jdField_a_of_type_Bnvg.g();
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void a(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    int i1 = 1;
    if (this.jdField_a_of_type_Bnhl != null) {
      this.jdField_a_of_type_Bnhl.a(paramAEVideoCaptureResult);
    }
    ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.5(this));
    bany.c();
    if (bcig.a().jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      banm.i(i1);
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
      if (this.jdField_a_of_type_Bamb.a())
      {
        this.jdField_a_of_type_Bamb.b();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e();
      return;
    }
    paramString = this.jdField_a_of_type_Bnhe.jdField_a_of_type_JavaLangString + "/noaudio";
    bgmg.c(paramString);
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.audioDataFilePath = paramString;
    a(this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!PTHumanSegmenter.HUMAN_SEGMENT.isFunctionReady()) && (paramBoolean)) {
      QQToast.a(BaseApplicationImpl.getContext(), anni.a(2131689774), 0).a();
    }
    while (!d()) {
      return;
    }
    ((bnid)this.jdField_a_of_type_Bnig).b(paramBoolean);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (almq.a().a()) {
      almq.a().a(paramArrayOfByte, paramInt1, paramInt2);
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
    this.jdField_a_of_type_Bamb.a(paramArrayOfByte, paramInt1, paramInt2);
    this.jdField_a_of_type_Bqgu.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bnho.b();
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.errorCode = paramInt;
    if (this.jdField_a_of_type_Bnhl != null) {
      this.jdField_a_of_type_Bnhl.a(104);
    }
  }
  
  public void a_(String paramString)
  {
    a(new baox(1, 0, paramString, null, this.jdField_d_of_type_Int));
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Bnho.a();
  }
  
  public void b()
  {
    AEVideoCaptureResult localAEVideoCaptureResult = this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult;
    localAEVideoCaptureResult.videoFrameCount += 1;
  }
  
  public void b(int paramInt) {}
  
  public void b(String paramString)
  {
    if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_Bamb.a()))
    {
      bnzb.d("AECameraGLSurfaceView", "onAudioCaptured---filePath=" + paramString);
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
      almq.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
      queueEvent(new AECameraGLSurfaceView.6(this));
    }
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_Bamb.a())
    {
      bnzb.d("AECameraGLSurfaceView", "onAudioChangeCaptured---filePath=" + paramString);
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.audioDataFilePath = paramString;
      if (this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath != null) {
        a(this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
      }
    }
  }
  
  public boolean c()
  {
    return ((this.jdField_a_of_type_Bnig instanceof bnid)) && (((bnid)this.jdField_a_of_type_Bnig).a() != null) && (((bnid)this.jdField_a_of_type_Bnig).a().getmPTSticker() != null) && (((bnid)this.jdField_a_of_type_Bnig).a().getmPTSticker().needTouchTriggerEvent());
  }
  
  public void d()
  {
    almq.a().a(null);
  }
  
  public void d(String paramString)
  {
    if ((this.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_Bamb.a()))
    {
      bnzb.d("AECameraGLSurfaceView", "onEncodeAudioCaptured---filePath=" + paramString);
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.audioDataFilePath = paramString;
      if (this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath != null) {
        a(this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
      }
    }
  }
  
  public void f()
  {
    bnzb.d("AECameraGLSurfaceView", "[onDestroy]");
    if (QLog.isDevelopLevel()) {
      bnzb.a("AECameraGLSurfaceView", "### onDestroy, hashCode=" + this.jdField_m_of_type_Int + " ###");
    }
    if (this.jdField_a_of_type_Bqgu != null) {
      this.jdField_a_of_type_Bqgu.a();
    }
    if (this.jdField_a_of_type_Bnig != null) {
      this.jdField_a_of_type_Bnig.a(true);
    }
    this.jdField_a_of_type_Bnvg.h();
    if (this.jdField_a_of_type_Batx != null) {
      this.jdField_a_of_type_Batx.c();
    }
    queueEvent(new AECameraGLSurfaceView.3(this));
    bnzb.d("AECameraGLSurfaceView", "[onDestroy] end");
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Bnig != null) && (((bnid)this.jdField_a_of_type_Bnig).a()))
    {
      ((bnid)this.jdField_a_of_type_Bnig).b();
      ((bnid)this.jdField_a_of_type_Bnig).c();
    }
  }
  
  public void h()
  {
    if (!d()) {}
    while (this.jdField_a_of_type_Bnig == null) {
      return;
    }
    queueEvent(new AECameraGLSurfaceView.14(this));
  }
  
  public void i()
  {
    this.jdField_a_of_type_Bnvg.b();
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Bnig != null) {
      this.jdField_a_of_type_Bnig.a(false);
    }
    if (this.jdField_a_of_type_Bnhn != null) {
      this.jdField_a_of_type_Bnhn.c();
    }
    this.jdField_a_of_type_Bnvg.a(this.jdField_a_of_type_Bnho.b());
    if (this.jdField_k_of_type_Boolean) {
      return;
    }
    bnyh.a().F();
    bnzb.b("AECameraGLSurfaceView", "【Change Camera】:isFrontCamera:" + this.jdField_a_of_type_Bnho.b());
  }
  
  public void k()
  {
    int i1 = 0;
    if (this.jdField_a_of_type_Bnho.c())
    {
      this.jdField_a_of_type_Bnho.a((Activity)getContext(), true);
      i1 = 1500;
    }
    ThreadManager.getUIHandler().postDelayed(new AECameraGLSurfaceView.15(this), i1);
  }
  
  public void l()
  {
    bnzb.b("AECameraGLSurfaceView", "startCaptureVideo---recordingEnabled=" + this.jdField_m_of_type_Boolean);
    this.jdField_a_of_type_Bnvg.f();
    if ((this.jdField_a_of_type_Bnho.c()) && (!this.jdField_k_of_type_Boolean)) {
      this.jdField_a_of_type_Bnho.a((Activity)getContext(), true);
    }
    String str = this.jdField_a_of_type_Bnhe.jdField_a_of_type_JavaLangString + File.separator + System.currentTimeMillis() + ".mp4";
    if ((this.n) && (!this.jdField_k_of_type_Boolean)) {}
    for (int i1 = bann.b(this.jdField_d_of_type_Int);; i1 = 0)
    {
      this.jdField_a_of_type_Batj = new batj(str, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, this.jdField_a_of_type_Bnhe.a(), this.jdField_a_of_type_Bnhe.f(), false, i1);
      this.jdField_a_of_type_Batj.jdField_j_of_type_Int = this.jdField_a_of_type_Bnhe.h();
      this.jdField_a_of_type_Batj.jdField_k_of_type_Int = this.jdField_a_of_type_Bnhe.i();
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult = new AEVideoCaptureResult();
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.startTimeMs = System.currentTimeMillis();
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.orientation = this.jdField_d_of_type_Int;
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.type = 0;
      if (this.jdField_a_of_type_Bnho.a() == 2) {
        this.jdField_a_of_type_Bnho.d();
      }
      this.jdField_m_of_type_Boolean = true;
      bann.a(false, false);
      return;
    }
  }
  
  public void m()
  {
    bnzb.b("AECameraGLSurfaceView", "stopCaptureVideo---recordingEnabled=" + this.jdField_m_of_type_Boolean + ", recordingStatus=" + this.jdField_l_of_type_Int + ", isPaused=" + this.jdField_h_of_type_Boolean);
    if (this.jdField_m_of_type_Boolean)
    {
      this.jdField_m_of_type_Boolean = false;
      if (this.jdField_l_of_type_Int != 0) {
        break label99;
      }
      if (this.jdField_a_of_type_Bnhl != null) {
        this.jdField_a_of_type_Bnhl.a(102);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bnho.b();
      return;
      label99:
      if (this.jdField_h_of_type_Boolean) {
        a(0, null, null);
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    bnzb.d("AECameraGLSurfaceView", "[onDetachedFromWindow]");
    super.onDetachedFromWindow();
    bnzb.d("AECameraGLSurfaceView", "[onDetachedFromWindow] end");
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    boolean bool = this.jdField_e_of_type_Boolean;
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_f_of_type_Int += 1;
      if (!bool) {
        break label61;
      }
    }
    label61:
    for (paramGL10 = "onDrawFrameReal-begin";; paramGL10 = "onDrawFrameFake-begin" + this.jdField_f_of_type_Int)
    {
      bnvd.a().a(paramGL10);
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_Boolean = false;
        u();
      }
      if (this.jdField_a_of_type_Bnig != null) {
        break;
      }
      return;
    }
    if (this.jdField_f_of_type_Boolean) {
      bnvd.a().a("FilterProcessInitFilters-begin");
    }
    this.jdField_a_of_type_Bnig.g();
    if (this.jdField_f_of_type_Boolean) {
      bnvd.a().a("FilterProcessInitFilters-end");
    }
    paramGL10 = this.jdField_a_of_type_Bnig.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_k_of_type_Boolean);
    if (d())
    {
      bnid localbnid = (bnid)this.jdField_a_of_type_Bnig;
      x();
      g();
      if (this.jdField_a_of_type_Bnjv != null) {
        this.jdField_a_of_type_Bnjv.a(this.jdField_a_of_type_Bnho.a(), localbnid.a());
      }
      c(paramGL10[1]);
    }
    if ((this.q) && (!this.jdField_k_of_type_Boolean)) {
      this.jdField_a_of_type_Bnig.c(paramGL10[1]);
    }
    a(paramGL10[1], null, null);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      queueEvent(new AECameraGLSurfaceView.9(this));
    }
    this.jdField_a_of_type_Bnvg.d();
    if (!this.p)
    {
      this.p = true;
      bnyl.a().f();
      bnyh.a().V();
      if (bnlm.a()) {
        bnlm.a(this.jdField_a_of_type_Bnmd, 5000L);
      }
      if (this.jdField_a_of_type_Bnhn != null) {
        this.jdField_a_of_type_Bnhn.b();
      }
    }
    if (this.jdField_f_of_type_Boolean) {
      if (!bool) {
        break label363;
      }
    }
    label363:
    for (paramGL10 = "onDrawFrameReal-end";; paramGL10 = "onDrawFrameFake-end" + this.jdField_f_of_type_Int)
    {
      bnvd.a().a(paramGL10);
      if (bool) {
        this.jdField_f_of_type_Boolean = false;
      }
      if (!bool) {
        break;
      }
      bnvd.a().c();
      return;
    }
  }
  
  public void onPause()
  {
    bnzb.d("AECameraGLSurfaceView", "[onPause] hashCode=" + this.jdField_m_of_type_Int + " ###");
    queueEvent(new AECameraGLSurfaceView.2(this));
    this.jdField_h_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bnop != null) {
      this.jdField_a_of_type_Bnop.b();
    }
    if (this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2 != null) {
      this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2.stop();
    }
    super.onPause();
    bnzb.d("AECameraGLSurfaceView", "[onPause] end");
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_h_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2 != null) {
      this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2.start();
    }
    if (QLog.isDevelopLevel()) {
      bnzb.a("AECameraGLSurfaceView", "### onResume, hashCode=" + this.jdField_m_of_type_Int + " ###");
    }
    this.jdField_m_of_type_Boolean = false;
    if ((this.jdField_a_of_type_Bnop != null) && (this.jdField_a_of_type_Bnop.a())) {
      this.jdField_a_of_type_Bnop.a();
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    bnzb.b("AECameraGLSurfaceView", "[onSurfaceChanged] + BEGIN, width = " + paramInt1 + ", height = " + paramInt2);
    bnvd.a().a("onSurfaceChanged-begin");
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_Bnig != null) {
      this.jdField_a_of_type_Bnig.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 0, 0, paramInt1, paramInt2);
    }
    if (this.jdField_c_of_type_Int != 0) {
      setBeautyLevel(this.jdField_c_of_type_Int);
    }
    bnvd.a().a("onSurfaceChanged-end");
    bnzb.b("AECameraGLSurfaceView", "[onSurfaceChanged] + END, width = " + paramInt1 + ", height = " + paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    bnzb.b("AECameraGLSurfaceView", "[onSurfaceCreated] + BEGIN");
    bnvd.a().a("onSurfaceCreated-begin");
    r();
    bnvd.a().a("onSurfaceCreated-end");
    bnzb.b("AECameraGLSurfaceView", "[onSurfaceCreated] + END");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent == null) {
      return false;
    }
    if ((!d()) || (this.jdField_a_of_type_Bnii == null)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    bnid localbnid = (bnid)this.jdField_a_of_type_Bnig;
    if ((paramMotionEvent != null) && (localbnid.d()) && (!this.jdField_a_of_type_Bnii.c()))
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
        queueEvent(new AECameraGLSurfaceView.18(this, localbnid, f1, f2, i1));
        continue;
        if (a(this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, f1, f2) > i1 * 0.05F)
        {
          queueEvent(new AECameraGLSurfaceView.19(this, localbnid, f1, f2, i1));
          continue;
          queueEvent(new AECameraGLSurfaceView.20(this, localbnid, f1, f2, i1));
        }
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAECaptureController(bnii parambnii)
  {
    this.jdField_a_of_type_Bnii = parambnii;
  }
  
  public void setAEKitInitListener(bnhk parambnhk)
  {
    this.jdField_a_of_type_Bnhk = parambnhk;
  }
  
  public void setBeautyLevel(int paramInt)
  {
    if (!d())
    {
      bnzb.b("AECameraGLSurfaceView", "[setBeautyLevel] level = " + paramInt + ", isAEKitAvailable is false");
      return;
    }
    this.jdField_c_of_type_Int = paramInt;
    queueEvent(new AECameraGLSurfaceView.16(this, paramInt));
  }
  
  public void setCaptureListener(bnhl parambnhl)
  {
    this.jdField_a_of_type_Bnhl = parambnhl;
  }
  
  public void setCaptureRequest(bnhm parambnhm)
  {
    if (this.jdField_a_of_type_Bnig != null) {
      this.jdField_a_of_type_Bnig.a(parambnhm);
    }
  }
  
  public void setDynamicResolutionMode(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Bnho.c(paramBoolean);
  }
  
  public void setEventCallback(bnhn parambnhn)
  {
    this.jdField_a_of_type_Bnhn = parambnhn;
  }
  
  public void setFaceEffectListener(bnhj parambnhj)
  {
    this.jdField_a_of_type_Bnhj = parambnhj;
  }
  
  public void setFilter(FilterCategoryItem paramFilterCategoryItem)
  {
    if (!d()) {}
    bnid localbnid;
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
            localbnid = (bnid)this.jdField_a_of_type_Bnig;
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
    localbnid.a(paramFilterCategoryItem);
  }
  
  public void setIsGIFMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bnvg.b(paramBoolean);
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
  
  public void setMaterialMetaData(bnpf parambnpf)
  {
    if ((parambnpf == null) || (parambnpf.equals(bnpf.jdField_a_of_type_Bnpf)))
    {
      setMaterial(null);
      return;
    }
    Object localObject = getContext();
    if (((localObject instanceof Activity)) && (!b()))
    {
      localObject = ((Activity)localObject).getIntent();
      ((Intent)localObject).putExtra("widgetinfo", "camera^" + parambnpf.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("material_id", parambnpf.jdField_a_of_type_JavaLangString);
      bnzb.b("AECameraGLSurfaceView", "selectSpecificMaterial---塞拍同款名 takeSameName=" + parambnpf.i);
      ((Intent)localObject).putExtra("key_camera_material_name", parambnpf.i);
      ((Intent)localObject).putExtra("ae_editor_is_show_take_same", parambnpf.jdField_f_of_type_Int);
    }
    setMaterial(parambnpf.a());
  }
  
  public void setPreExtractFrame(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public void setRecommendTextCallback(bnql parambnql)
  {
    this.jdField_a_of_type_Bnql = parambnql;
  }
  
  public void setSceneListener(bnjv parambnjv)
  {
    this.jdField_a_of_type_Bnjv = parambnjv;
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
    if ((this.jdField_a_of_type_Bnig != null) && ((this.jdField_a_of_type_Bnig instanceof bnid))) {
      ((bnid)this.jdField_a_of_type_Bnig).a(paramStickerInnerEffectFilterListener);
    }
  }
  
  public void setTapEvent(int paramInt, float paramFloat1, float paramFloat2)
  {
    queueEvent(new AECameraGLSurfaceView.TapRunnable(this, paramInt, paramFloat1 / this.jdField_a_of_type_Int, paramFloat2 / this.jdField_b_of_type_Int));
  }
  
  public void setZoom(int paramInt)
  {
    this.jdField_a_of_type_Bnho.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */