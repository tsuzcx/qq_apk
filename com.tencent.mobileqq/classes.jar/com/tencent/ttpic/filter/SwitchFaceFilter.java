package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.filter.Param.Float2fParam;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureBitmapParam;
import com.tencent.filter.Param.TextureParam;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.SwitchFaceUtil;
import com.tencent.ttpic.util.SwitchFaceUtil.FEATURE_TYPE;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoFilterUtil.DRAW_MODE;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SwitchFaceFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceOffFragmentShader.dat");
  private static final String VERTEX_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceOffVertexShader.dat");
  private float[] faceVertices = new float[276];
  private int grayImageHeight;
  private int grayImageWidth;
  private float[] grayVertices = new float[276];
  private List<List<PointF>> mFaceLists;
  private int mFaceTex;
  private float[] texVertices = new float[276];
  
  public SwitchFaceFilter()
  {
    this(VERTEX_SHADER, FRAGMENT_SHADER, null);
    initParams();
    this.mFaceLists = new ArrayList();
    this.mFaceTex = -1;
  }
  
  public SwitchFaceFilter(String paramString1, String paramString2, StickerItem paramStickerItem)
  {
    super(paramString1, paramString2, paramStickerItem);
  }
  
  float distanceFrom(PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF2.x - paramPointF1.x;
    float f2 = paramPointF2.y - paramPointF1.y;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  List<PointF> faceSwapFacePoint(List<PointF> paramList)
  {
    if (paramList.size() != 97) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 19)
    {
      localArrayList.add(paramList.get(i));
      i += 1;
    }
    localArrayList.add(paramList.get(90));
    localArrayList.add(paramList.get(91));
    localArrayList.add(paramList.get(92));
    localArrayList.add(paramList.get(93));
    localArrayList.add(paramList.get(94));
    localArrayList.add(paramList.get(95));
    localArrayList.add(paramList.get(96));
    PointF localPointF1 = midBetween((PointF)paramList.get(56), (PointF)paramList.get(62));
    float f1 = (float)Math.atan((((PointF)paramList.get(9)).x - localPointF1.x) / (-((PointF)paramList.get(9)).y + localPointF1.y));
    PointF localPointF2 = new PointF();
    float f2 = distanceFrom((PointF)paramList.get(9), localPointF1);
    localPointF2.x = (((PointF)paramList.get(9)).x + 2.0F * f2 / 8.0F * (float)Math.sin(f1));
    localPointF2.y = (((PointF)paramList.get(9)).y - 2.0F * f2 / 8.0F * (float)Math.cos(f1));
    localArrayList.add(localPointF2);
    localPointF2 = new PointF();
    i = 1;
    while (i < 6)
    {
      localPointF2.x = (((PointF)paramList.get(9)).x + (i + 2) * f2 / 8.0F * (float)Math.sin(f1));
      localPointF2.y = (((PointF)paramList.get(9)).y - (i + 2) * f2 / 8.0F * (float)Math.cos(f1));
      localArrayList.add(localPointF2);
      i += 1;
    }
    localArrayList.add(localPointF1);
    localArrayList.add(paramList.get(83));
    localArrayList.add(paramList.get(84));
    localArrayList.add(midBetween((PointF)paramList.get(89), (PointF)paramList.get(84)));
    localArrayList.add(paramList.get(89));
    return localArrayList;
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    setGrayCords(SwitchFaceUtil.initMaterialFaceTexCoords(faceSwapFacePoint(SwitchFaceUtil.getFullCoords(SwitchFaceUtil.getGrayCoords(SwitchFaceUtil.FEATURE_TYPE.ALL_GRAY))), this.grayImageWidth, this.grayImageHeight, this.grayVertices));
    setDrawMode(VideoFilterUtil.DRAW_MODE.TRIANGLES);
    setCoordNum(138);
  }
  
  public void initParams()
  {
    Bitmap localBitmap = SwitchFaceUtil.getGrayBitmap(SwitchFaceUtil.FEATURE_TYPE.ALL_GRAY);
    if (!VideoBitmapUtil.isLegal(localBitmap)) {
      return;
    }
    this.grayImageWidth = localBitmap.getWidth();
    this.grayImageHeight = localBitmap.getHeight();
    addParam(new Param.TextureParam("inputImageTexture2", this.mFaceTex, 33986));
    addParam(new Param.TextureBitmapParam("inputImageTexture3", localBitmap, 33987, true));
    addParam(new Param.IntParam("enableFaceOff", 1));
    addParam(new Param.FloatParam("alpha", 1.0F));
    addParam(new Param.Float2fParam("canvasSize", 0.0F, 0.0F));
    addParam(new Param.FloatParam("positionRotate", 0.0F));
    addParam(new Param.IntParam("enableAlphaFromGray", 1));
  }
  
  PointF midBetween(PointF paramPointF1, PointF paramPointF2)
  {
    return new PointF((paramPointF1.x + paramPointF2.x) / 2.0F, (paramPointF1.y + paramPointF2.y) / 2.0F);
  }
  
  public void renderProcess()
  {
    if ((!VideoPreviewFaceOutlineDetector.getInstance().detectExpression(VideoMaterialUtil.TRIGGER_TYPE.FACE_DETECT.value)) || (this.mFaceLists.size() < 2))
    {
      setPositions(VideoFilterUtil.EMPTY_POSITIONS);
      setCoordNum(4);
      OnDrawFrameGLSL();
      renderTexture(this.mFaceTex, this.width, this.height);
    }
    for (;;)
    {
      return;
      int i;
      List localList2;
      List localList1;
      if ((this.mFaceLists.size() & 0x1) == 0)
      {
        i = 0;
        while (i < this.mFaceLists.size() / 2)
        {
          localList2 = SwitchFaceUtil.getFullCoords(VideoMaterialUtil.copyList((List)this.mFaceLists.get(i * 2)));
          localList1 = SwitchFaceUtil.getFullCoords(VideoMaterialUtil.copyList((List)this.mFaceLists.get(i * 2 + 1)));
          localList2 = faceSwapFacePoint(localList2);
          localList1 = faceSwapFacePoint(localList1);
          VideoMaterialUtil.flipYPoints(localList2, (int)(this.height * this.mScreenScale));
          VideoMaterialUtil.flipYPoints(localList1, (int)(this.height * this.mScreenScale));
          setTexCords(SwitchFaceUtil.initMaterialFaceTexCoords(localList2, (int)(this.width * this.mScreenScale), (int)(this.height * this.mScreenScale), this.texVertices));
          setPositions(SwitchFaceUtil.initFacePositions(localList1, (int)(this.width * this.mScreenScale), (int)(this.height * this.mScreenScale), this.faceVertices));
          setCoordNum(138);
          OnDrawFrameGLSL();
          renderTexture(this.mFaceTex, this.width, this.height);
          setPositions(SwitchFaceUtil.initFacePositions(localList2, (int)(this.width * this.mScreenScale), (int)(this.height * this.mScreenScale), this.faceVertices));
          setTexCords(SwitchFaceUtil.initMaterialFaceTexCoords(localList1, (int)(this.width * this.mScreenScale), (int)(this.height * this.mScreenScale), this.texVertices));
          setCoordNum(138);
          OnDrawFrameGLSL();
          renderTexture(this.mFaceTex, this.width, this.height);
          i += 1;
        }
      }
      else
      {
        i = 0;
        while (i < this.mFaceLists.size())
        {
          localList2 = SwitchFaceUtil.getFullCoords(VideoMaterialUtil.copyList((List)this.mFaceLists.get(i % this.mFaceLists.size())));
          localList1 = SwitchFaceUtil.getFullCoords(VideoMaterialUtil.copyList((List)this.mFaceLists.get((i + 1) % this.mFaceLists.size())));
          localList2 = faceSwapFacePoint(localList2);
          localList1 = faceSwapFacePoint(localList1);
          VideoMaterialUtil.flipYPoints(localList2, (int)(this.height * this.mScreenScale));
          VideoMaterialUtil.flipYPoints(localList1, (int)(this.height * this.mScreenScale));
          setTexCords(SwitchFaceUtil.initMaterialFaceTexCoords(localList2, (int)(this.width * this.mScreenScale), (int)(this.height * this.mScreenScale), this.texVertices));
          setPositions(SwitchFaceUtil.initFacePositions(localList1, (int)(this.width * this.mScreenScale), (int)(this.height * this.mScreenScale), this.faceVertices));
          setCoordNum(138);
          OnDrawFrameGLSL();
          renderTexture(this.mFaceTex, this.width, this.height);
          i += 1;
        }
      }
    }
  }
  
  public void setFaceParams(List<List<PointF>> paramList, int paramInt)
  {
    this.mFaceLists = paramList;
    this.mFaceTex = paramInt;
    addParam(new Param.TextureParam("inputImageTexture2", this.mFaceTex, 33986));
  }
  
  public void updatePreview(List<PointF> paramList, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, float paramFloat, long paramLong) {}
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new Param.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.SwitchFaceFilter
 * JD-Core Version:    0.7.0.1
 */