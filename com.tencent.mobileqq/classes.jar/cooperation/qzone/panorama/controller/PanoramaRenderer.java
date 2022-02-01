package cooperation.qzone.panorama.controller;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLES20;
import com.tencent.mobileqq.apollo.view.opengl.Renderer;
import cooperation.qzone.panorama.callback.OnPanoramaLoadingListener;
import cooperation.qzone.panorama.model.ShapeModel;
import cooperation.qzone.panorama.piece.PanoramaPieceManager;
import cooperation.qzone.panorama.piece.PieceCacheList;
import cooperation.qzone.panorama.util.PanoramaConfig.Builder;
import cooperation.qzone.panorama.util.ShaderUtil;
import cooperation.qzone.panorama.util.TextureUtil;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class PanoramaRenderer
  implements Renderer
{
  private static final String TAG = "PanoramaRenderer";
  private PanoramaConfig.Builder builder;
  private PieceCacheList cachePieceDataList;
  private int modeType;
  private OnPanoramaLoadingListener onPanoramaLoadingListener;
  private int programId;
  private ShapeModel shapeModel;
  private int showType;
  private Drawable textureDrawable;
  private int textureId;
  
  public PanoramaRenderer(PanoramaConfig.Builder paramBuilder, OnPanoramaLoadingListener paramOnPanoramaLoadingListener)
  {
    this.builder = paramBuilder;
    this.showType = paramBuilder.getShowType();
    this.shapeModel = paramBuilder.getShapeModel();
    this.modeType = paramBuilder.getModeType();
    this.onPanoramaLoadingListener = paramOnPanoramaLoadingListener;
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    GLES20.glClear(16384);
    if ((this.builder != null) && (this.builder.isTextureChange()))
    {
      this.textureDrawable = this.builder.getTextureDrawable();
      TextureUtil.deleteTexture(this.textureId);
      if (this.textureDrawable != null) {
        this.textureId = TextureUtil.genTextureId(((BitmapDrawable)this.textureDrawable).getBitmap(), false);
      }
      if (this.onPanoramaLoadingListener != null) {
        this.onPanoramaLoadingListener.onPanoramaLoad();
      }
    }
    if ((this.builder != null) && (this.builder.getPanoramaPieceManager() != null))
    {
      this.builder.getPanoramaPieceManager().doProcess();
      this.cachePieceDataList = this.builder.getPanoramaPieceManager().getCachePieceDataList();
      this.shapeModel.setPieceDataList(this.cachePieceDataList);
    }
    if (this.shapeModel != null)
    {
      this.shapeModel.setTextureId(this.textureId);
      this.shapeModel.touchOperation();
      this.shapeModel.onModelDraw();
    }
  }
  
  public void onRecycled()
  {
    TextureUtil.deleteTexture(this.textureId);
    TextureUtil.deleteTexture(this.cachePieceDataList);
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    GLES20.glEnable(2884);
    float f = paramInt1 / paramInt2;
    if (this.shapeModel != null) {
      this.shapeModel.setScreenRatio(f);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    this.programId = ShaderUtil.getProgramId();
    GLES20.glUseProgram(this.programId);
    if (this.shapeModel != null) {
      this.shapeModel.initModel(this.programId);
    }
    paramGL10 = this.builder.getPanoramaPieceManager();
    if ((paramGL10 != null) && (this.shapeModel != null)) {
      paramGL10.setSectorDegree(this.shapeModel.getSectorDegree());
    }
  }
  
  public void setRotate(float paramFloat1, float paramFloat2)
  {
    if (this.shapeModel != null) {
      this.shapeModel.setRotate(paramFloat1, paramFloat2);
    }
  }
  
  public void setScale(float paramFloat)
  {
    if (this.shapeModel != null) {
      this.shapeModel.setScale(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.panorama.controller.PanoramaRenderer
 * JD-Core Version:    0.7.0.1
 */