package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FeatureType;
import java.util.Arrays;
import java.util.List;

public class FaceOffNoseOcclusionFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nvoid main(void) {\n    gl_FragColor = texture2D(inputImageTexture2, textureCoordinate);\n}\n";
  private static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n";
  private float[] faceVertices = new float[1380];
  private boolean isTexLoaded = false;
  private List<Float> itemFacePoints = Arrays.asList(FaceOffUtil.COSMETIC_MODEL_IMAGE_FACEPOINTS);
  private float[] texVertices = new float[1380];
  private int[] texture = new int[1];
  
  public FaceOffNoseOcclusionFilter()
  {
    super("attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n", "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nvoid main(void) {\n    gl_FragColor = texture2D(inputImageTexture2, textureCoordinate);\n}\n");
    initParams();
    setCoordNum(690);
    int[] arrayOfInt = this.texture;
    GlUtil.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
  }
  
  private void initFaceTexCoords()
  {
    setTexCords(FaceOffUtil.initMaterialFaceNoseLastTexCoords(FaceOffUtil.getFullCoordsForNoseAndOutline(FaceOffUtil.genPoints(this.itemFacePoints)), 800, 1067, this.texVertices));
  }
  
  private void loadNoseTex()
  {
    if (!this.isTexLoaded)
    {
      Bitmap localBitmap = VideoMemoryManager.getInstance().loadImage(FaceOffUtil.FeatureType.NOSE_MASK);
      if (BitmapUtils.isLegal(localBitmap))
      {
        GlUtil.loadTexture(this.texture[0], localBitmap);
        this.isTexLoaded = true;
      }
    }
  }
  
  private void updateParam(List<PointF> paramList, float paramFloat)
  {
    try
    {
      paramList = VideoMaterial.copyList(paramList);
    }
    catch (Exception paramList)
    {
      label8:
      double d1;
      double d2;
      int i;
      break label8;
    }
    paramList = null;
    if (paramList != null)
    {
      paramList = FaceOffUtil.getFullCoordsForNoseAndOutline(paramList);
      d1 = this.width;
      d2 = this.mFaceDetScale;
      Double.isNaN(d1);
      i = (int)(d1 * d2);
      d1 = this.height;
      d2 = this.mFaceDetScale;
      Double.isNaN(d1);
      setPositions(FaceOffUtil.initFaceNoseLastPositions(paramList, i, (int)(d1 * d2), this.faceVertices));
    }
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    loadNoseTex();
    addParam(new UniformParam.TextureParam("inputImageTexture2", this.texture[0], 33986));
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    int[] arrayOfInt = this.texture;
    GlUtil.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    initFaceTexCoords();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    setCoordNum(690);
  }
  
  public void initParams()
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
  }
  
  public void loadFaceTex(String paramString)
  {
    paramString = BitmapUtils.decodeSampledBitmapFromFile(paramString, 1);
    if (BitmapUtils.isLegal(paramString))
    {
      GlUtil.loadTexture(this.texture[0], paramString);
      this.isTexLoaded = true;
    }
  }
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      loadNoseTex();
      super.updatePreview(paramObject);
      updateParam(paramObject.facePoints, 0.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceOffNoseOcclusionFilter
 * JD-Core Version:    0.7.0.1
 */