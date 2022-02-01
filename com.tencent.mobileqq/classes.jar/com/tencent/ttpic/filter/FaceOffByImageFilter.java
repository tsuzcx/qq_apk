package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.List;
import java.util.Set;

public class FaceOffByImageFilter
  extends VideoFilterBase
{
  private static final String TAG = FaceOffByImageFilter.class.getSimpleName();
  private int faceImageHeight;
  private int faceImageWidth;
  private float[] faceVertices = new float[1380];
  private int grayImageHeight;
  private int grayImageWidth;
  private float[] grayVertices = new float[1380];
  private FaceItem item;
  private float[] texVertices = new float[1380];
  
  public FaceOffByImageFilter(FaceItem paramFaceItem)
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.FACEOFF));
    this.item = paramFaceItem;
    initParams();
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    List localList2 = FaceOffUtil.genPoints(this.item.facePoints);
    List localList1 = FaceOffUtil.getGrayCoords(this.item.featureType);
    localList2 = FaceOffUtil.getFullCoords(localList2, 2.0F);
    localList1 = FaceOffUtil.getFullCoords(localList1, 2.0F);
    setTexCords(FaceOffUtil.initMaterialFaceTexCoords(localList2, this.faceImageWidth, this.faceImageHeight, this.texVertices));
    addAttribParam("inputGrayTextureCoordinate", FaceOffUtil.initMaterialFaceTexCoords(localList1, this.grayImageWidth, this.grayImageHeight, this.grayVertices));
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    setCoordNum(690);
  }
  
  public void initParams()
  {
    Bitmap localBitmap1 = FaceOffUtil.getFaceBitmap(this.item.faceExchangeImage);
    Bitmap localBitmap2 = FaceOffUtil.getGrayBitmap(this.item.featureType);
    if ((!BitmapUtils.isLegal(localBitmap1)) || (!BitmapUtils.isLegal(localBitmap2))) {
      return;
    }
    this.faceImageWidth = localBitmap1.getWidth();
    this.faceImageHeight = localBitmap1.getHeight();
    this.grayImageWidth = localBitmap2.getWidth();
    this.grayImageHeight = localBitmap2.getHeight();
    addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", localBitmap1, 33986, true));
    addParam(new UniformParam.TextureBitmapParam("inputImageTexture3", localBitmap2, 33987, true));
    addParam(new UniformParam.IntParam("enableFaceOff", 1));
    addParam(new UniformParam.FloatParam("alpha", this.item.blendAlpha));
    addParam(new UniformParam.Float2fParam("canvasSize", 0.0F, 0.0F));
    addParam(new UniformParam.FloatParam("positionRotate", 0.0F));
    addParam(new UniformParam.FloatParam("enableAlphaFromGray", this.item.grayScale));
    if (this.item.grayScale > 0)
    {
      addParam(new UniformParam.FloatParam("enableAlphaFromGrayNew", 1.0F));
      return;
    }
    addParam(new UniformParam.FloatParam("enableAlphaFromGrayNew", 0.0F));
  }
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      if (!paramObject.triggeredExpression.contains(Integer.valueOf(PTFaceAttr.PTExpression.FACE_DETECT.value)))
      {
        setPositions(GlUtil.EMPTY_POSITIONS);
        setCoordNum(4);
      }
    }
    else
    {
      return;
    }
    List localList = FaceOffUtil.getFullCoords(VideoMaterialUtil.copyList(paramObject.facePoints), 2.0F);
    VideoMaterialUtil.flipYPoints(localList, (int)(this.height * this.mFaceDetScale));
    setPositions(FaceOffUtil.initFacePositions(localList, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices));
    setCoordNum(690);
    addParam(new UniformParam.FloatParam("positionRotate", -paramObject.phoneAngle));
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceOffByImageFilter
 * JD-Core Version:    0.7.0.1
 */