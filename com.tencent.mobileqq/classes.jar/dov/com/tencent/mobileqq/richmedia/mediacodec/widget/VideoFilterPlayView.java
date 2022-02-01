package dov.com.tencent.mobileqq.richmedia.mediacodec.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import bafi;
import blik;
import boab;
import boae;
import boag;
import boah;
import boar;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.pkvideo.PKFilter;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import dov.com.qq.im.ae.download.AEResUtil;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;
import yqs;

public class VideoFilterPlayView
  extends HWVideoPlayView
{
  public static int k;
  private boag jdField_a_of_type_Boag;
  private boah jdField_a_of_type_Boah;
  private boar jdField_a_of_type_Boar;
  private QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  PKFilter jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKFilter;
  private GPUBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  String jdField_a_of_type_JavaLangString;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private final LinkedList<Runnable> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private byte[] jdField_a_of_type_ArrayOfByte;
  private GPUBaseFilter jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  private RenderBuffer jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  String jdField_b_of_type_JavaLangString;
  private GPUBaseFilter jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  String jdField_c_of_type_JavaLangString;
  protected boolean c;
  protected boolean d;
  public boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  public int l;
  
  public VideoFilterPlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoFilterPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_g_of_type_Boolean = true;
    j();
    int i = k + 1;
    k = i;
    this.l = i;
  }
  
  private void a(@NonNull LinkedList<Runnable> paramLinkedList)
  {
    try
    {
      while (!paramLinkedList.isEmpty())
      {
        Runnable localRunnable = (Runnable)paramLinkedList.poll();
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
    }
    finally {}
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = blik.a();
    blik.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager);
  }
  
  protected void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
    }
    if (this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null) {
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
    }
    if (this.jdField_a_of_type_JavaNioByteBuffer != null)
    {
      this.jdField_a_of_type_JavaNioByteBuffer.clear();
      this.jdField_a_of_type_JavaNioByteBuffer = null;
    }
    if (this.jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null)
    {
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.destroy();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = null;
    }
    if (this.jdField_a_of_type_Boah != null) {
      this.jdField_a_of_type_Boah.a();
    }
    if (this.jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null)
    {
      this.jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.destroy();
      this.jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = null;
    }
    if (this.jdField_a_of_type_Boag != null)
    {
      this.jdField_a_of_type_Boag.destroy();
      this.jdField_a_of_type_Boag = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
      this.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = blik.a();
      blik.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {}
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong, int paramInt) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Boah = new boah(paramInt);
  }
  
  public void a(RenderBuffer paramRenderBuffer, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (paramRenderBuffer != null) {
      i = paramRenderBuffer.getTexId();
    }
    if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_JavaNioByteBuffer == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoFilterPlayView", 2, "readTextureToBuffer trackData is null ");
      }
      return;
    }
    this.jdField_a_of_type_JavaNioByteBuffer.rewind();
    if (i != 0) {}
    for (;;)
    {
      try
      {
        paramRenderBuffer = new int[1];
        GLES20.glGenFramebuffers(1, paramRenderBuffer, 0);
        GLES20.glBindFramebuffer(36160, paramRenderBuffer[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
        GLES20.glReadPixels(0, 0, paramInt1, paramInt2, 6408, 5121, this.jdField_a_of_type_JavaNioByteBuffer);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, paramRenderBuffer, 0);
        paramRenderBuffer[0] = 0;
        this.h = false;
        return;
      }
      catch (Exception paramRenderBuffer)
      {
        this.jdField_a_of_type_JavaNioByteBuffer.clear();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("VideoFilterPlayView", 2, "readTextureToBuffer error " + paramRenderBuffer.toString());
      return;
      GLES20.glReadPixels(0, 0, paramInt1, paramInt2, 6408, 5121, this.jdField_a_of_type_JavaNioByteBuffer);
    }
  }
  
  protected void a(@NonNull Runnable paramRunnable)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add(paramRunnable);
      return;
    }
  }
  
  protected void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (this.jdField_f_of_type_Boolean) {
      return;
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean)) {
      if (this.jdField_e_of_type_Boolean)
      {
        paramArrayOfFloat2 = new float[16];
        Matrix.setIdentityM(paramArrayOfFloat2, 0);
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_JavaUtilLinkedList);
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16384);
      Matrix.rotateM(paramArrayOfFloat2, 0, this.jdField_g_of_type_Int, 0.0F, 0.0F, 1.0F);
      Matrix.scaleM(paramArrayOfFloat2, 0, 1.0F, -1.0F, 1.0F);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      super.a(paramArrayOfFloat1, paramArrayOfFloat2);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      paramArrayOfFloat1 = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
      int j = paramArrayOfFloat1.getTexId();
      int i = j;
      if (this.jdField_a_of_type_Boah != null)
      {
        paramArrayOfFloat1.bind();
        i = this.jdField_a_of_type_Boah.a(j);
        paramArrayOfFloat1.unbind();
      }
      j = i;
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.setParam("key_draw_screen", String.valueOf(false));
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.setParam("key_width", String.valueOf(this.jdField_c_of_type_Int));
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.setParam("key_height", String.valueOf(this.jdField_d_of_type_Int));
        int m = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.drawFrame(i);
        j = i;
        if (m != -1) {
          j = m;
        }
      }
      if (paramArrayOfFloat1 == this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer)
      {
        paramArrayOfFloat1 = this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
        label233:
        paramArrayOfFloat1.bind();
        this.jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.drawTexture(j, null, null);
        i = paramArrayOfFloat1.getTexId();
        paramArrayOfFloat1.unbind();
        this.jdField_a_of_type_Boag.a();
        if (!this.jdField_a_of_type_Boag.a()) {
          break label418;
        }
        if (paramArrayOfFloat1 != this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer) {
          break label410;
        }
        paramArrayOfFloat1 = this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
        label287:
        paramArrayOfFloat1.bind();
        this.jdField_a_of_type_Boag.drawTexture(i, null, null);
        i = paramArrayOfFloat1.getTexId();
        paramArrayOfFloat1.unbind();
      }
      label410:
      label418:
      for (;;)
      {
        if (this.h) {
          a(paramArrayOfFloat1, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        paramArrayOfFloat1 = new float[16];
        Matrix.setIdentityM(paramArrayOfFloat1, 0);
        Matrix.scaleM(paramArrayOfFloat1, 0, 1.0F, -1.0F, 1.0F);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.drawTexture(i, null, paramArrayOfFloat1);
        return;
        paramArrayOfFloat2 = GPUBaseFilter.caculateFitCenterMvpMatrix(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        break;
        paramArrayOfFloat1 = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
        break label233;
        paramArrayOfFloat1 = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
        break label287;
      }
    }
  }
  
  public void h() {}
  
  public void i() {}
  
  public void onDecodeFrame(long paramLong1, long paramLong2)
  {
    super.onDecodeFrame(paramLong1, paramLong2);
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().SetTimeStamp(paramLong1, paramLong2);
    }
  }
  
  public void onDecodeRepeat()
  {
    QLog.w("VideoFilterPlayView", 4, "onDecodeRepeat");
    super.onDecodeRepeat();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKFilter != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKFilter.onFilterDecodeRepeat();
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("VideoFilterPlayView", 4, "onSurfaceChanged : " + paramGL10.hashCode());
    }
    if (!this.jdField_g_of_type_Boolean) {}
    for (;;)
    {
      return;
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Int == paramInt1) && (this.jdField_b_of_type_Int == paramInt2)) {
        continue;
      }
      this.jdField_b_of_type_Boolean = true;
      super.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, 33984);
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, 33984);
      if (this.jdField_a_of_type_Boag != null) {
        this.jdField_a_of_type_Boag.onOutputSizeChanged(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      }
      if (this.jdField_a_of_type_Boah != null) {
        this.jdField_a_of_type_Boah.a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.onOutputSizeChanged(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      if (this.jdField_a_of_type_JavaNioByteBuffer == null) {}
      try
      {
        this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_c_of_type_Int * this.jdField_d_of_type_Int * 4];
        this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.wrap(this.jdField_a_of_type_ArrayOfByte);
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceChange(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          this.jdField_f_of_type_Boolean = false;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoFilterPlayView", 2, "onSurfaceChanged");
        return;
      }
      catch (OutOfMemoryError paramGL10)
      {
        for (;;)
        {
          QLog.e("VideoFilterPlayView", 1, "init trackByteBuffer failed ", paramGL10);
          if (this.jdField_a_of_type_JavaNioByteBuffer != null)
          {
            this.jdField_a_of_type_JavaNioByteBuffer.clear();
            this.jdField_a_of_type_JavaNioByteBuffer = null;
          }
        }
      }
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    super.onSurfaceCreated(paramGL10, paramEGLConfig);
    AEResUtil.loadAEBaseSo();
    if (VideoEnvironment.loadAVCodecSo("AVCodec", BaseApplication.getContext()) != 0)
    {
      ThreadManager.getUIHandler().post(new VideoFilterPlayView.2(this));
      this.jdField_g_of_type_Boolean = false;
      QLog.e("VideoFilterPlayView", 1, "onSurfaceCreated : Load so fail");
    }
    do
    {
      return;
      this.jdField_b_of_type_Boolean = false;
      paramGL10 = boab.a(101);
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = paramGL10;
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = paramGL10;
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.init();
      if (this.jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null)
      {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = this.jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.initForce();
      }
      this.jdField_a_of_type_Boag = new boag();
      this.jdField_a_of_type_Boag.init();
      if (this.jdField_a_of_type_Boah != null) {
        this.jdField_a_of_type_Boah.a(this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceCreate(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        this.jdField_f_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.w("VideoFilterPlayView", 2, "mFilterProcess, surfaceCreated success");
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoFilterPlayView", 2, "onSurfaceCreated");
  }
  
  public void setColorFilterType(int paramInt)
  {
    if ((this.jdField_a_of_type_Boag == null) || ((!this.jdField_a_of_type_Boag.a()) && (paramInt == 0))) {
      return;
    }
    this.jdField_a_of_type_Boag.a(paramInt, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  public void setColorFilterType(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    this.jdField_a_of_type_Boag.a(paramInt1, paramInt2, paramFloat, paramInt3, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  public void setFilePath(String paramString1, String paramString2)
  {
    super.setFilePath(paramString1, paramString2);
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (FileUtil.checkFileExist(this.jdField_b_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.hasQQFilter(183)))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.pushChainBasedStackTopChain(183, null);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKFilter = ((PKFilter)this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getQQFilterByType(183));
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKFilter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKFilter.enableDebug(false);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKFilter.config(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Long, false);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKFilter.prepare();
      }
      setProlong(bafi.a(this.jdField_a_of_type_JavaLangString));
    }
  }
  
  public void setFilePath(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.jdField_c_of_type_Boolean = paramBoolean1;
    this.jdField_d_of_type_Boolean = paramBoolean2;
    this.jdField_e_of_type_Boolean = paramBoolean3;
    setFilePath(paramString1, paramString2);
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_e_of_type_Boolean))
    {
      paramString1 = yqs.a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT);
      this.jdField_c_of_type_Int = ((Integer)paramString1.first).intValue();
      this.jdField_d_of_type_Int = ((Integer)paramString1.second).intValue();
    }
  }
  
  public void setMosaicFilterType(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = this.jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
      this.jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = null;
      return;
    }
    if (this.jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter == null)
    {
      this.jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = boab.a(106);
      a(new VideoFilterPlayView.1(this));
    }
    ((boae)this.jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter).a(paramBitmap);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = this.jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  }
  
  public void setSpeedType(int paramInt)
  {
    super.setSpeedType(paramInt);
    a(new VideoFilterPlayView.3(this, paramInt));
  }
  
  public void setStoryGamePaths(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
  }
  
  public void setTrackerCallback(boar paramboar)
  {
    this.jdField_a_of_type_Boar = paramboar;
  }
  
  public void setTransferData(TransferData paramTransferData)
  {
    a(new VideoFilterPlayView.4(this, paramTransferData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView
 * JD-Core Version:    0.7.0.1
 */