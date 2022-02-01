package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FeatureType;
import java.util.List;

public class HeadCropFilter
  extends VideoFilterBase
{
  private static final String TAG = "HeadCropFilter";
  private float[] faceVertices = new float[1380];
  private int grayImageHeight;
  private int grayImageWidth;
  private float[] grayVertices = new float[1380];
  private Frame inputFrame;
  
  public HeadCropFilter()
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.HEAD_CROP));
    initParams();
  }
  
  public Frame getInputFrame()
  {
    return this.inputFrame;
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    addAttribParam("inputGrayTextureCoordinate", FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoords(FaceOffUtil.getGrayCoords(FaceOffUtil.FeatureType.FACE_HEAD_CROP), 3.0F), this.grayImageWidth, this.grayImageHeight, this.grayVertices));
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    setCoordNum(690);
  }
  
  public void initParams()
  {
    Bitmap localBitmap = FaceOffUtil.getGrayBitmap(FaceOffUtil.FeatureType.FACE_HEAD_CROP);
    this.grayImageWidth = localBitmap.getWidth();
    this.grayImageHeight = localBitmap.getHeight();
    addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", localBitmap, 33986, true));
    addParam(new UniformParam.IntParam("enableFaceOff", 1));
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return super.renderTexture(this.inputFrame.getTextureId(), this.inputFrame.width, this.inputFrame.height);
  }
  
  public void setInputFrame(Frame paramFrame)
  {
    this.inputFrame = paramFrame;
  }
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      if ((paramObject.facePoints != null) && (paramObject.facePoints.size() >= 90))
      {
        paramObject = FaceOffUtil.getFullCoords(VideoMaterial.copyList(paramObject.facePoints), 3.0F);
        double d1 = this.width;
        double d2 = this.mFaceDetScale;
        Double.isNaN(d1);
        int i = (int)(d1 * d2);
        d1 = this.height;
        d2 = this.mFaceDetScale;
        Double.isNaN(d1);
        setPositions(FaceOffUtil.initFacePositions(paramObject, i, (int)(d1 * d2), this.faceVertices));
        setCoordNum(690);
        return;
      }
      setPositions(GlUtil.EMPTY_POSITIONS);
      setCoordNum(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.HeadCropFilter
 * JD-Core Version:    0.7.0.1
 */