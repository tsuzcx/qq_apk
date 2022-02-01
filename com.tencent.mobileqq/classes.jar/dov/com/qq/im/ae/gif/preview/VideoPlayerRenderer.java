package dov.com.qq.im.ae.gif.preview;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaPlayer;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.util.Log;
import android.view.Surface;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.ttpic.openapi.filter.SpaceFilter;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

class VideoPlayerRenderer
  implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer
{
  private static final String jdField_a_of_type_JavaLangString = VideoPlayerRenderer.class.getSimpleName();
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private final GLSurfaceView jdField_a_of_type_AndroidOpenglGLSurfaceView;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  private BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter = new SurfaceTextureFilter();
  private SpaceFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter = new SpaceFilter();
  private VideoFilterProcess jdField_a_of_type_DovComQqImAeGifPreviewVideoFilterProcess = new VideoFilterProcess();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private float jdField_b_of_type_Float;
  private Frame jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  
  VideoPlayerRenderer(GLSurfaceView paramGLSurfaceView)
  {
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView = paramGLSurfaceView;
  }
  
  private void a(Frame paramFrame)
  {
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glClearColor(0.92F, 0.93F, 0.96F, 1.0F);
    GLES20.glClear(16384);
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter.RenderProcess(paramFrame.getTextureId(), (int)this.jdField_a_of_type_Float, (int)this.jdField_b_of_type_Float, 0, 0.0D, this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame);
    GLES20.glDisable(3042);
  }
  
  private void b()
  {
    Object localObject = new int[1];
    GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
    this.jdField_a_of_type_Int = localObject[0];
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    localObject = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setSurface((Surface)localObject);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
  }
  
  private void c()
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = this.jdField_a_of_type_Int;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentFilterBaseFilter.apply();
    this.jdField_a_of_type_ComTencentFilterBaseFilter.setRotationAndFlip(0, 0, 1);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter.apply();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter.setRotationAndFlip(0, 0, 1);
    this.jdField_a_of_type_DovComQqImAeGifPreviewVideoFilterProcess.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentFilterBaseFilter.clearGLSL();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter.clearGLSL();
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    c();
    this.jdField_a_of_type_DovComQqImAeGifPreviewVideoFilterProcess.b();
  }
  
  public void a(MediaPlayer paramMediaPlayer)
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer = paramMediaPlayer;
  }
  
  public void a(VideoFilterProcess.FrameRenderCallback paramFrameRenderCallback)
  {
    if (this.jdField_a_of_type_DovComQqImAeGifPreviewVideoFilterProcess != null) {
      this.jdField_a_of_type_DovComQqImAeGifPreviewVideoFilterProcess.a(paramFrameRenderCallback);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeGifPreviewVideoFilterProcess != null) {
      this.jdField_a_of_type_DovComQqImAeGifPreviewVideoFilterProcess.a(paramBoolean);
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false))
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
      this.jdField_a_of_type_ComTencentFilterBaseFilter.updateMatrix(this.jdField_a_of_type_ArrayOfFloat);
      this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(this.jdField_a_of_type_Int, (int)(2.0F * this.jdField_a_of_type_Float), (int)this.jdField_b_of_type_Float, -1, 0.0D, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
    }
    if (GLES20.glIsTexture(this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.getTextureId()))
    {
      a(this.jdField_a_of_type_DovComQqImAeGifPreviewVideoFilterProcess.a(this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame, (int)this.jdField_a_of_type_Float, (int)this.jdField_b_of_type_Float));
      return;
    }
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
    GLES20.glClear(16384);
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_AndroidOpenglGLSurfaceView.requestRender();
      return;
    }
    finally
    {
      paramSurfaceTexture = finally;
      throw paramSurfaceTexture;
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    Log.d(jdField_a_of_type_JavaLangString, "onSurfaceChanged width = " + paramInt1 + "  height = " + paramInt2);
    this.jdField_a_of_type_Float = paramInt1;
    this.jdField_b_of_type_Float = paramInt2;
    this.jdField_a_of_type_DovComQqImAeGifPreviewVideoFilterProcess.a(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    b();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.preview.VideoPlayerRenderer
 * JD-Core Version:    0.7.0.1
 */