package dov.com.tencent.mobileqq.richmedia.mediacodec.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import awag;
import bjil;
import bjim;
import bkxb;
import bkxj;
import bkyg;
import bkyh;
import blbs;
import blbt;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;
import dov.com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import swf;
import vel;
import vzx;

@TargetApi(11)
public class HWVideoPlayView
  extends GLSurfaceView
  implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, HWDecodeListener
{
  protected int a;
  public long a;
  protected SurfaceTexture a;
  private GLSurfaceView.EGLContextFactory jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory = new bkyg(this);
  protected final bkxb a;
  private final DecodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig = new DecodeConfig();
  private HWDecodeListener jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener;
  protected HWVideoDecoder a;
  private GPUOESBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter;
  protected AudioDecoder a;
  private WeakReference<bkyh> jdField_a_of_type_JavaLangRefWeakReference;
  public boolean a;
  protected int b;
  protected long b;
  protected boolean b;
  public int c;
  public long c;
  private boolean c;
  public int d;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  public int e;
  private boolean e;
  public int f;
  protected int g;
  protected int h = 0;
  public int i;
  public int j;
  private int k;
  
  public HWVideoPlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HWVideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setEGLContextFactory(this.jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory);
    setEGLContextClientVersion(2);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder = new HWVideoDecoder();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder = new AudioDecoder();
    this.jdField_a_of_type_Bkxb = new bkxb();
    setRenderer(this);
    setRenderMode(0);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.speedType;
  }
  
  public int a(int paramInt)
  {
    this.g = paramInt;
    return this.g;
  }
  
  public int a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (vzx.a(paramLocalMediaInfo)) {}
    for (this.g = (paramLocalMediaInfo.rotation + 90);; this.g = paramLocalMediaInfo.rotation)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HWVideoPlayView", 2, "adjustRotation: mVideoRotation=" + this.g);
      }
      return this.g;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.inputFilePath;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
    }
    this.jdField_c_of_type_Boolean = true;
    c();
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      bkyh localbkyh = (bkyh)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localbkyh != null) {
        localbkyh.j();
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.seekTo(paramInt);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.decodeFrame();
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.nextTo(paramLong);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.decodeFrame();
    }
  }
  
  protected void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.drawTexture(this.k, paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public void b()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.inputFilePath)) {
      throw new RuntimeException("startPlay failed. videoFilePath is empty.");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.stopDecode();
    this.h = 1;
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, new Object[] { "startPlay, mCurrentStat:", Integer.valueOf(this.h) });
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.startDecode(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig, this.k, this, this);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bkxb.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a(this.jdField_a_of_type_Bkxb);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.stopDecode();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.b();
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_d_of_type_Long > 0L))
    {
      this.jdField_c_of_type_Long = (System.currentTimeMillis() - this.jdField_d_of_type_Long);
      this.j = (this.i - 15);
      this.jdField_d_of_type_Long = 0L;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.pauseDecode();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.c();
    this.h = 4;
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, new Object[] { "pausePlay, mCurrentStat:", Integer.valueOf(this.h) });
    }
    if (this.jdField_d_of_type_Long != 0L)
    {
      this.jdField_c_of_type_Long += System.currentTimeMillis() - this.jdField_d_of_type_Long;
      this.j = (this.i - 15);
      this.jdField_d_of_type_Long = 0L;
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.resumeDecode();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.d();
    this.h = 3;
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, new Object[] { "resumePlay, mCurrentStat:", Integer.valueOf(this.h) });
    }
    if (this.jdField_d_of_type_Long == 0L) {
      this.jdField_d_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public void f()
  {
    setPlayRange(0, 0);
  }
  
  protected void g()
  {
    if (bjil.jdField_c_of_type_Boolean)
    {
      long l1 = System.currentTimeMillis();
      bjil.f.a(2, l1);
      if (bjil.f.a())
      {
        l1 -= bjil.f.jdField_a_of_type_ArrayOfLong[0];
        long l2 = bjil.f.jdField_a_of_type_ArrayOfLong[1] - bjil.f.jdField_a_of_type_ArrayOfLong[0];
        long l3 = bjil.f.jdField_a_of_type_ArrayOfLong[2] - bjil.f.jdField_a_of_type_ArrayOfLong[1];
        if ((vel.a(l1, 0L, 10000L)) && (vel.a(l2, 0L, 10000L)) && (vel.a(l3, 0L, 10000L))) {
          vel.a("OpenEditCost", true, l1, new String[] { String.valueOf(bjil.f.jdField_a_of_type_Int), String.valueOf(l2), String.valueOf(l3) });
        }
        bjil.f.c();
      }
    }
  }
  
  public void onDecodeCancel()
  {
    if (Thread.currentThread().getId() == this.jdField_b_of_type_Long) {
      this.h = 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, new Object[] { "onDecodeCancel, mCurrentStat:", Integer.valueOf(this.h) });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener.onDecodeCancel();
    }
  }
  
  public void onDecodeError(int paramInt, Throwable paramThrowable)
  {
    QLog.e("HWVideoPlayView", 4, "onDecodeError errorCode = " + paramInt, paramThrowable);
    awag.a(paramThrowable);
  }
  
  public void onDecodeFinish()
  {
    if (Thread.currentThread().getId() == this.jdField_b_of_type_Long) {
      this.h = 5;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, new Object[] { "onDecodeFinish, mCurrentStat:", Integer.valueOf(this.h) });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener.onDecodeFinish();
    }
  }
  
  public void onDecodeFrame(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener.onDecodeFrame(paramLong1, paramLong2);
    }
  }
  
  public void onDecodeRepeat()
  {
    QLog.d("HWVideoPlayView", 4, "onDecodeRepeat");
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener.onDecodeRepeat();
    }
  }
  
  public void onDecodeSeekTo(long paramLong)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a(paramLong);
  }
  
  public void onDecodeStart()
  {
    this.h = 3;
    this.jdField_b_of_type_Long = Thread.currentThread().getId();
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, new Object[] { "onDecodeStart, mCurrentStat:", Integer.valueOf(this.h) });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener.onDecodeStart();
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
      {
        if (!this.jdField_d_of_type_Boolean)
        {
          this.jdField_d_of_type_Boolean = true;
          g();
        }
        long l1 = System.currentTimeMillis();
        if ((!this.jdField_e_of_type_Boolean) && (this.i > 15))
        {
          this.jdField_e_of_type_Boolean = true;
          this.jdField_d_of_type_Long = l1;
        }
        l1 = 0L;
        if (bjil.jdField_b_of_type_Boolean)
        {
          bjil.d.b();
          l1 = SystemClock.elapsedRealtime();
        }
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
        paramGL10 = new float[16];
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(paramGL10);
        a(paramGL10, GPUBaseFilter.caculateCenterCropMvpMatrix(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
        this.i += 1;
        if (bjil.d.a())
        {
          long l2 = SystemClock.elapsedRealtime();
          bjil.d.a(new Integer[] { Integer.valueOf((int)(l2 - l1)) });
          if (bjil.d.a(8000)) {
            bjil.b();
          }
        }
      }
      return;
    }
    catch (Throwable paramGL10)
    {
      QLog.e("HWVideoPlayView", 2, "onDrawFrame error.", paramGL10);
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
    requestRender();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 4, "onSurfaceChanged : " + paramInt1 + ";" + paramInt2);
    }
    this.k = GlUtil.createTexture(36197);
    if ((Build.VERSION.SDK_INT == 26) && (!Build.MANUFACTURER.equals("HUAWEI")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HWVideoPlayView", 4, "onSurfaceChanged special 8.0 device. Delay play.");
      }
      postDelayed(new HWVideoPlayView.2(this), 500L);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.onOutputSizeChanged(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        paramGL10 = (bkyh)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramGL10 != null) {
          paramGL10.d();
        }
      }
      return;
      b();
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 4, "onSurfaceCreated");
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter = ((GPUOESBaseFilter)bkxj.a(102));
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.init();
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void setBgmFilePath(String paramString)
  {
    this.jdField_a_of_type_Bkxb.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bkxb.jdField_b_of_type_Axkf = AudioEncoder.a(paramString, null, 0);
  }
  
  public void setDecodeListener(HWDecodeListener paramHWDecodeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener = paramHWDecodeListener;
  }
  
  public void setFilePath(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.inputFilePath = paramString1;
    this.jdField_a_of_type_Bkxb.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Bkxb.jdField_a_of_type_Axkf = AudioEncoder.a(paramString2, null, 0);
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, "setFilePath: videoFilePath = " + this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.inputFilePath + " ; audioFilePath = " + paramString2);
    }
    int i2;
    int m;
    int n;
    if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_c_of_type_Int == 0) || (this.jdField_d_of_type_Int == 0))
    {
      this.jdField_a_of_type_Long = swf.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.inputFilePath);
      this.jdField_a_of_type_Bkxb.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
      paramString2 = new blbt();
      i2 = blbs.a(paramString1, paramString2);
      m = paramString2.a[0];
      n = paramString2.a[1];
      if ((this.g != 90) && (this.g != 270)) {
        break label323;
      }
    }
    label323:
    for (int i1 = n;; i1 = m)
    {
      this.jdField_c_of_type_Int = i1;
      if ((this.g == 90) || (this.g == 270)) {
        n = m;
      }
      this.jdField_d_of_type_Int = n;
      this.jdField_e_of_type_Int = this.jdField_c_of_type_Int;
      this.f = this.jdField_d_of_type_Int;
      QLog.d("HWVideoPlayView", 1, "setFilePath: errcode = " + i2 + " ; videoWidth = " + this.jdField_c_of_type_Int + " , videoHeight=" + this.jdField_d_of_type_Int + " , mVideoRotation=" + this.g + " , rotation=" + paramString2.a[2] + " videoDuration=" + this.jdField_a_of_type_Long);
      return;
    }
  }
  
  public void setMediaInfo(LocalMediaInfo paramLocalMediaInfo)
  {
    this.jdField_a_of_type_Long = paramLocalMediaInfo.mDuration;
    this.jdField_a_of_type_Bkxb.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
    int m = paramLocalMediaInfo.mediaWidth;
    int n = paramLocalMediaInfo.mediaHeight;
    if ((this.g == 90) || (this.g == 270)) {}
    for (int i1 = n;; i1 = m)
    {
      this.jdField_c_of_type_Int = i1;
      if ((this.g == 90) || (this.g == 270)) {
        n = m;
      }
      this.jdField_d_of_type_Int = n;
      this.jdField_e_of_type_Int = this.jdField_c_of_type_Int;
      this.f = this.jdField_d_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("HWVideoPlayView", 2, "videoWidth = " + this.jdField_c_of_type_Int + " , videoHeight=" + this.jdField_d_of_type_Int + " , mVideoRotation=" + this.g + " videoDuration=" + this.jdField_a_of_type_Long);
      }
      return;
    }
  }
  
  public void setMuteAudio(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bkxb.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a(paramBoolean);
  }
  
  public void setPlayRange(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.startTimeMillSecond = paramInt1;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.endTimeMillSecond = paramInt2;
    }
    if (this.jdField_a_of_type_Bkxb != null)
    {
      this.jdField_a_of_type_Bkxb.jdField_a_of_type_Long = paramInt1;
      this.jdField_a_of_type_Bkxb.jdField_b_of_type_Long = paramInt2;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.setPlayRange(paramInt1, paramInt2);
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a(paramInt1, paramInt2);
    }
  }
  
  public void setPlayViewListener(bkyh parambkyh)
  {
    if (parambkyh == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambkyh);
  }
  
  public void setProlong(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.prolongToTime = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.setProlongToTime(paramLong);
  }
  
  public void setRepeat(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.repeat = paramBoolean;
    this.jdField_a_of_type_Bkxb.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setSpeedType(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.speedType = paramInt;
    this.jdField_a_of_type_Bkxb.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.setSpeedType(paramInt);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a(paramInt);
  }
  
  public void setVideoDecodeConfig(DecodeConfig paramDecodeConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.copyFrom(paramDecodeConfig);
  }
  
  public void setVolume(float paramFloat)
  {
    this.jdField_a_of_type_Bkxb.jdField_a_of_type_Axkf.a = paramFloat;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 4, "surfaceDestroyed");
    }
    super.surfaceDestroyed(paramSurfaceHolder);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.widget.HWVideoPlayView
 * JD-Core Version:    0.7.0.1
 */