package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.filter.Param.Float2fParam;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureBitmapParam;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoFilterUtil.DRAW_MODE;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import java.util.List;
import java.util.Map;

public class FaceOffByImageFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceOffFragmentShader.dat");
  private static final String TAG = FaceOffByImageFilter.class.getSimpleName();
  private static final String VERTEX_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceOffVertexShader.dat");
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
    super(VERTEX_SHADER, FRAGMENT_SHADER, null);
    this.item = paramFaceItem;
    initParams();
    setDrawPartial(true);
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    List localList2 = FaceOffUtil.genPoints(this.item.facePoints);
    List localList1 = FaceOffUtil.getGrayCoords(this.item.featureType);
    localList2 = FaceOffUtil.getFullCoords(localList2);
    localList1 = FaceOffUtil.getFullCoords(localList1);
    setTexCords(FaceOffUtil.initMaterialFaceTexCoords(localList2, this.faceImageWidth, this.faceImageHeight, this.texVertices));
    setGrayCords(FaceOffUtil.initMaterialFaceTexCoords(localList1, this.grayImageWidth, this.grayImageHeight, this.grayVertices));
    setDrawMode(VideoFilterUtil.DRAW_MODE.TRIANGLES);
    setCoordNum(690);
  }
  
  public void initParams()
  {
    Bitmap localBitmap1 = FaceOffUtil.getFaceBitmap(this.item.faceExchangeImage);
    Bitmap localBitmap2 = FaceOffUtil.getGrayBitmap(this.item.featureType);
    if ((!VideoBitmapUtil.isLegal(localBitmap1)) || (!VideoBitmapUtil.isLegal(localBitmap2))) {
      return;
    }
    this.faceImageWidth = localBitmap1.getWidth();
    this.faceImageHeight = localBitmap1.getHeight();
    this.grayImageWidth = localBitmap2.getWidth();
    this.grayImageHeight = localBitmap2.getHeight();
    addParam(new Param.TextureBitmapParam("inputImageTexture2", localBitmap1, 33986, true));
    addParam(new Param.TextureBitmapParam("inputImageTexture3", localBitmap2, 33987, true));
    addParam(new Param.IntParam("enableFaceOff", 1));
    addParam(new Param.FloatParam("alpha", this.item.blendAlpha));
    addParam(new Param.Float2fParam("canvasSize", 0.0F, 0.0F));
    addParam(new Param.FloatParam("positionRotate", 0.0F));
    addParam(new Param.IntParam("enableAlphaFromGray", this.item.grayScale));
  }
  
  public void updatePreview(List<PointF> paramList, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, float paramFloat, long paramLong)
  {
    if (!VideoPreviewFaceOutlineDetector.getInstance().detectExpression(VideoMaterialUtil.TRIGGER_TYPE.FACE_DETECT.value))
    {
      setPositions(VideoFilterUtil.EMPTY_POSITIONS);
      setCoordNum(4);
      return;
    }
    paramList = FaceOffUtil.getFullCoords(VideoMaterialUtil.copyList(paramList));
    VideoMaterialUtil.flipYPoints(paramList, (int)(this.height * this.mScreenScale));
    setPositions(FaceOffUtil.initFacePositions(paramList, (int)(this.width * this.mScreenScale), (int)(this.height * this.mScreenScale), this.faceVertices));
    setCoordNum(690);
    addParam(new Param.FloatParam("positionRotate", -paramFloat));
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new Param.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceOffByImageFilter
 * JD-Core Version:    0.7.0.1
 */