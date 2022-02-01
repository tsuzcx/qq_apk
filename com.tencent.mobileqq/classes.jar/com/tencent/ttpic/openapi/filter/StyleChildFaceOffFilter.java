package com.tencent.ttpic.openapi.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import java.util.List;

public class StyleChildFaceOffFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nvarying vec2 textureCoordinate;\nvarying vec2 canvasCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nvoid main(void) {\n    vec4 dstColor = texture2D(inputImageTexture, canvasCoordinate);\n    vec4 maskColor = texture2D(inputImageTexture2, textureCoordinate);\n    vec4 oriColor = texture2D(inputImageTexture3, canvasCoordinate);\n    gl_FragColor = mix(oriColor, dstColor, maskColor.a);\n}\n";
  private static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nvarying vec2 canvasCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n    canvasCoordinate = vec2(position.x * 0.5 + 0.5, position.y * 0.5 + 0.5);\n}\n";
  private float[] faceVertices = new float[1380];
  private boolean isTexLoaded = false;
  private List<Float> itemFacePoints;
  private float[] texVertices = new float[1380];
  private int[] texture = new int[1];
  
  public StyleChildFaceOffFilter(List<Float> paramList)
  {
    super("attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nvarying vec2 canvasCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n    canvasCoordinate = vec2(position.x * 0.5 + 0.5, position.y * 0.5 + 0.5);\n}\n", "precision highp float;\nvarying vec2 textureCoordinate;\nvarying vec2 canvasCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nvoid main(void) {\n    vec4 dstColor = texture2D(inputImageTexture, canvasCoordinate);\n    vec4 maskColor = texture2D(inputImageTexture2, textureCoordinate);\n    vec4 oriColor = texture2D(inputImageTexture3, canvasCoordinate);\n    gl_FragColor = mix(oriColor, dstColor, maskColor.a);\n}\n");
    this.itemFacePoints = paramList;
    initParams();
    setCoordNum(690);
    GlUtil.glGenTextures(this.texture.length, this.texture, 0);
  }
  
  private void initFaceTexCoords()
  {
    setTexCords(FaceOffUtil.initMaterialFaceNoseLastTexCoords(FaceOffUtil.getFullCoordsForNoseAndOutline(FaceOffUtil.genPoints(this.itemFacePoints)), 800, 1067, this.texVertices));
  }
  
  private void loadNoseTex()
  {
    if (!this.isTexLoaded)
    {
      Bitmap localBitmap = VideoMemoryManager.getInstance().loadImage(FaceOffUtil.FEATURE_TYPE.NOSE_MASK);
      if (BitmapUtils.isLegal(localBitmap))
      {
        GlUtil.loadTexture(this.texture[0], localBitmap);
        this.isTexLoaded = true;
      }
    }
  }
  
  private void loadNoseTex1()
  {
    if (!this.isTexLoaded)
    {
      Bitmap localBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), FaceOffUtil.GRAY_FILE_NOSE_MASK, 2147483647, 2147483647);
      if (BitmapUtils.isLegal(localBitmap))
      {
        GlUtil.loadTexture(this.texture[0], localBitmap);
        this.isTexLoaded = true;
      }
    }
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    GlUtil.glDeleteTextures(this.texture.length, this.texture, 0);
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
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
  }
  
  public void loadMask(Bitmap paramBitmap)
  {
    if ((!this.isTexLoaded) && (BitmapUtils.isLegal(paramBitmap)))
    {
      GlUtil.loadTexture(this.texture[0], paramBitmap);
      this.isTexLoaded = true;
      addParam(new UniformParam.TextureParam("inputImageTexture2", this.texture[0], 33986));
    }
  }
  
  public void updateParam(List<PointF> paramList, int paramInt)
  {
    Object localObject = null;
    try
    {
      paramList = VideoMaterialUtil.copyList(paramList);
      if (paramList != null) {
        setPositions(FaceOffUtil.initFaceNoseLastPositions(FaceOffUtil.getFullCoordsForNoseAndOutline(paramList), (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices));
      }
      addParam(new UniformParam.TextureParam("inputImageTexture3", paramInt, 33987));
      return;
    }
    catch (Exception paramList)
    {
      for (;;)
      {
        paramList = localObject;
      }
    }
  }
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      loadNoseTex();
      super.updatePreview(paramObject);
      updateParam(paramObject.facePoints, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.StyleChildFaceOffFilter
 * JD-Core Version:    0.7.0.1
 */