package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.filter.Frame;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureBitmapParam;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoFilterUtil.DRAW_MODE;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;
import java.util.Map;

public class HeadCropFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/HeadCropFragmentShader.dat");
  private static final String TAG = HeadCropFilter.class.getSimpleName();
  public static final String VERTEX_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/HeadCropVertexShader.dat");
  private float[] faceVertices = new float[1380];
  private int grayImageHeight;
  private int grayImageWidth;
  private float[] grayVertices = new float[1380];
  private Frame inputFrame;
  
  public HeadCropFilter()
  {
    super(VERTEX_SHADER, FRAGMENT_SHADER, null);
    initParams();
    setDrawPartial(true);
  }
  
  public Frame getInputFrame()
  {
    return this.inputFrame;
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    setGrayCords(FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoords(FaceOffUtil.getGrayCoords(FaceOffUtil.FEATURE_TYPE.FACE_HEAD_CROP), 3.0F), this.grayImageWidth, this.grayImageHeight, this.grayVertices));
    setDrawMode(VideoFilterUtil.DRAW_MODE.TRIANGLES);
    setCoordNum(690);
  }
  
  public void initParams()
  {
    Bitmap localBitmap = FaceOffUtil.getGrayBitmap(FaceOffUtil.FEATURE_TYPE.FACE_HEAD_CROP);
    this.grayImageWidth = localBitmap.getWidth();
    this.grayImageHeight = localBitmap.getHeight();
    addParam(new Param.TextureBitmapParam("inputImageTexture2", localBitmap, 33986, true));
    addParam(new Param.IntParam("enableFaceOff", 1));
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return super.renderTexture(this.inputFrame.getTextureId(), this.inputFrame.width, this.inputFrame.height);
  }
  
  public void setInputFrame(Frame paramFrame)
  {
    this.inputFrame = paramFrame;
  }
  
  public void updatePreview(List<PointF> paramList, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, float paramFloat, long paramLong)
  {
    if ((paramList == null) || (paramList.size() < 90))
    {
      setPositions(VideoFilterUtil.EMPTY_POSITIONS);
      setCoordNum(4);
      return;
    }
    setPositions(FaceOffUtil.initFacePositions(FaceOffUtil.getFullCoords(VideoMaterialUtil.copyList(paramList), 3.0F), (int)(this.width * this.mScreenScale), (int)(this.height * this.mScreenScale), this.faceVertices));
    setCoordNum(690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.HeadCropFilter
 * JD-Core Version:    0.7.0.1
 */