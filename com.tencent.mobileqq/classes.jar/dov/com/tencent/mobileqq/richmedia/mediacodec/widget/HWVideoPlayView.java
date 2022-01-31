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
import aonv;
import aonw;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUOESBaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.util.CaptureFreqMonitor;
import dov.com.qq.im.capture.util.CaptureFreqMonitorItem;
import dov.com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder;
import dov.com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder.AudioDecodeConfig;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.FilterFactory;
import dov.com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils;
import dov.com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils.MetaData;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@TargetApi(11)
public class HWVideoPlayView
  extends GLSurfaceView
  implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, HWDecodeListener
{
  public int a;
  public long a;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private GLSurfaceView.EGLContextFactory jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory = new aonv(this);
  private GPUOESBaseFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter;
  private final DecodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig = new DecodeConfig();
  private HWDecodeListener jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener;
  protected HWVideoDecoder a;
  protected final AudioDecoder.AudioDecodeConfig a;
  protected AudioDecoder a;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  protected int c;
  protected int d;
  protected int e;
  protected int f = 0;
  private int g;
  
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
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig = new AudioDecoder.AudioDecodeConfig();
    setRenderer(this);
    setRenderMode(0);
  }
  
  public int a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (VideoUtils.a(paramLocalMediaInfo)) {}
    for (this.e = (paramLocalMediaInfo.rotation + 90);; this.e = paramLocalMediaInfo.rotation) {
      return this.e;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
    c();
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    QLog.e("HWVideoPlayView", 4, "onDecodeError errorCode = " + paramInt, paramThrowable);
    ShortVideoExceptionReporter.a(paramThrowable);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.b(paramInt);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.d();
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a(paramLong);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener.a(paramLong1, paramLong2);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.a(paramLong);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.d();
    }
  }
  
  protected void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter.a(this.g, paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public void b()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_JavaLangString)) {
      throw new RuntimeException("startPlay failed. videoFilePath is empty.");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.a();
    this.f = 1;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig, this.g, this, this);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.a();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.b();
  }
  
  public void d()
  {
    this.f = 3;
    QLog.d("HWVideoPlayView", 4, "onDecodeStart");
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener.d();
    }
  }
  
  public void e()
  {
    this.f = 5;
    QLog.d("HWVideoPlayView", 4, "onDecodeFinish");
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener.e();
    }
  }
  
  public void f()
  {
    this.f = 2;
    QLog.d("HWVideoPlayView", 4, "onDecodeCancel");
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener.f();
    }
  }
  
  public void g()
  {
    QLog.d("HWVideoPlayView", 4, "onDecodeRepeat");
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener.g();
    }
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.b();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.c();
    this.f = 4;
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.c();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.d();
    this.f = 3;
  }
  
  public void j()
  {
    setPlayRange(0, 0);
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
      {
        long l1 = 0L;
        if (CaptureFreqMonitor.jdField_b_of_type_Boolean)
        {
          CaptureFreqMonitor.d.b();
          l1 = SystemClock.elapsedRealtime();
        }
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
        paramGL10 = new float[16];
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(paramGL10);
        a(paramGL10, GPUBaseFilter.a(this.c, this.d, this.jdField_a_of_type_Int, this.b));
        if (CaptureFreqMonitor.d.a())
        {
          long l2 = SystemClock.elapsedRealtime();
          CaptureFreqMonitor.d.a(new Integer[] { Integer.valueOf((int)(l2 - l1)) });
          if (CaptureFreqMonitor.d.a(8000)) {
            CaptureFreqMonitor.b();
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
    this.g = GlUtil.a(36197);
    if ((Build.VERSION.SDK_INT == 26) && (!Build.MANUFACTURER.equals("HUAWEI")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HWVideoPlayView", 4, "onSurfaceChanged special 8.0 device. Delay play.");
      }
      postDelayed(new aonw(this), 500L);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.b = paramInt2;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter.a(this.c, this.d);
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        paramGL10 = (HWVideoPlayView.HWVideoPlayViewListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramGL10 != null) {
          paramGL10.a(paramInt1, paramInt2);
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
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter = ((GPUOESBaseFilter)FilterFactory.a(102));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter.a();
  }
  
  public void setDecodeListener(HWDecodeListener paramHWDecodeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener = paramHWDecodeListener;
  }
  
  public void setFilePath(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData = AudioEncoder.a(paramString2, null, 0);
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, "setFilePath: videoFilePath = " + this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_JavaLangString + " ; audioFilePath = " + paramString2);
    }
    this.jdField_a_of_type_Long = VideoCompositeHelper.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.c = this.jdField_a_of_type_Long;
    paramString2 = new MediaMetadataUtils.MetaData();
    int m = MediaMetadataUtils.a(paramString1, paramString2);
    int i = paramString2.a[0];
    int j = paramString2.a[1];
    if ((this.e == 90) || (this.e == 270)) {}
    for (int k = j;; k = i)
    {
      this.c = k;
      if ((this.e == 90) || (this.e == 270)) {
        j = i;
      }
      this.d = j;
      if (QLog.isColorLevel()) {
        QLog.d("HWVideoPlayView", 2, "setFilePath: errcode = " + m + " ; videoWidth = " + this.c + " , videoHeight=" + this.d);
      }
      return;
    }
  }
  
  public void setMuteAudio(boolean paramBoolean)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a(paramBoolean);
  }
  
  public void setPlayRange(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Long = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_b_of_type_Long = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.a(paramInt1, paramInt2);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a(paramInt1, paramInt2);
  }
  
  public void setPlayViewListener(HWVideoPlayView.HWVideoPlayViewListener paramHWVideoPlayViewListener)
  {
    if (paramHWVideoPlayViewListener == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHWVideoPlayViewListener);
  }
  
  public void setRepeat(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setSpeedType(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioDecodeConfig.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.a(paramInt);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder.a(paramInt);
  }
  
  public void setVideoDecodeConfig(DecodeConfig paramDecodeConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.a(paramDecodeConfig);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
    this.jdField_a_of_type_Boolean = true;
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