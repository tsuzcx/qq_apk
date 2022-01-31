package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.filter.Param.Float2fParam;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureBitmapParam;
import com.tencent.ttpic.QQLogUtils;
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
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FaceOffFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceOffFragmentShader.dat");
  private static final String TAG = FaceOffFilter.class.getSimpleName();
  public static final String VERTEX_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceOffVertexShader.dat");
  private byte[] data = null;
  private int faceImageHeight;
  private int faceImageWidth;
  private float[] faceVertices = new float[1380];
  private int grayImageHeight;
  private int grayImageWidth;
  private float[] grayVertices = new float[1380];
  private boolean isValid;
  private FaceItem item;
  public float level1 = 0.0F;
  public float level2 = 0.0F;
  public int levelCount = 0;
  float percent1 = 0.05F;
  float percent2 = 0.15F;
  public double sumg = 0.0D;
  public double sumr = 0.0D;
  private float[] texVertices = new float[1380];
  
  public FaceOffFilter(String paramString1, String paramString2, FaceItem paramFaceItem, String paramString3)
  {
    super(paramString1, paramString2, null);
    this.item = paramFaceItem;
    this.dataPath = paramString3;
    initParams();
    setDrawPartial(true);
  }
  
  private float getAverageGreen(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    if (this.data == null) {
      return 0.0F;
    }
    int j = (int)(((PointF)paramList.get(66)).x - ((PointF)paramList.get(65)).x);
    int n = (int)(((PointF)paramList.get(69)).y - ((PointF)paramList.get(78)).y);
    int m = (int)((PointF)paramList.get(65)).x;
    int i = (int)((PointF)paramList.get(78)).y;
    if ((m >= paramInt1) || (i >= paramInt2)) {
      return 0.0F;
    }
    int k = m;
    if (m < 0) {
      k = 0;
    }
    m = i;
    if (i < 0) {
      m = 0;
    }
    i = j;
    if (k + j > paramInt1) {
      i = paramInt1 - k;
    }
    j = n;
    if (m + n > paramInt2) {
      j = paramInt2 - m;
    }
    paramList = new byte[i * j * 4];
    paramInt2 = 0;
    while (paramInt2 < j)
    {
      n = 0;
      while (n < i)
      {
        int i1 = (paramInt2 * i + n) * 4;
        int i2 = ((paramInt2 + m) * paramInt1 + n + k) * 4;
        paramList[i1] = this.data[i2];
        paramList[(i1 + 1)] = this.data[(i2 + 1)];
        paramList[(i1 + 2)] = this.data[(i2 + 2)];
        paramList[(i1 + 3)] = this.data[(i2 + 3)];
        n += 1;
      }
      paramInt2 += 1;
    }
    int[] arrayOfInt = new int[256];
    this.sumg = 0.0D;
    this.sumr = 0.0D;
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      paramInt2 = 0;
      while (paramInt2 < i)
      {
        k = paramList[((paramInt1 * i + paramInt2) * 4)] & 0xFF;
        this.sumr += k;
        m = paramList[((paramInt1 * i + paramInt2) * 4 + 1)];
        this.sumg += (m & 0xFF);
        arrayOfInt[k] += 1;
        paramInt2 += 1;
      }
      paramInt1 += 1;
    }
    this.sumg /= i * j;
    this.sumr /= i * j;
    this.levelCount = 0;
    paramInt1 = 255;
    if (paramInt1 >= 0)
    {
      this.levelCount += arrayOfInt[paramInt1];
      if (this.levelCount >= j * i * this.percent1) {
        this.level1 = paramInt1;
      }
    }
    else
    {
      this.levelCount = 0;
      paramInt1 = 255;
    }
    for (;;)
    {
      if (paramInt1 >= 0)
      {
        this.levelCount += arrayOfInt[paramInt1];
        if (this.levelCount >= j * i * this.percent2) {
          this.level2 = paramInt1;
        }
      }
      else
      {
        return (float)this.sumr;
        paramInt1 -= 1;
        break;
      }
      paramInt1 -= 1;
    }
  }
  
  public FaceItem getFaceOffItem()
  {
    return this.item;
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
    Bitmap localBitmap1 = FaceOffUtil.getFaceBitmap(this.dataPath, this.item);
    Bitmap localBitmap2 = FaceOffUtil.getGrayBitmap(this.item.featureType);
    if ((!VideoBitmapUtil.isLegal(localBitmap1)) || (!VideoBitmapUtil.isLegal(localBitmap2)))
    {
      QQLogUtils.i("FaceOffFilter", "faceBitmap:" + localBitmap1 + ", grayBitmap:" + localBitmap2);
      this.isValid = false;
      return;
    }
    this.isValid = true;
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
    addParam(new Param.IntParam("blendMode", this.item.blendMode));
    addParam(new Param.FloatParam("level1", 0.0F));
    addParam(new Param.FloatParam("level2", 0.0F));
  }
  
  public void setCosAlpha(float paramFloat)
  {
    addParam(new Param.FloatParam("alpha", paramFloat));
  }
  
  public void setImageData(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    this.data = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public void updatePreview(List<PointF> paramList, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, float paramFloat, long paramLong)
  {
    if ((!VideoPreviewFaceOutlineDetector.getInstance().detectExpression(VideoMaterialUtil.TRIGGER_TYPE.FACE_DETECT.value)) || (!this.isValid))
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
    addParam(new Param.FloatParam("level1", this.level1 / 255.0F));
    addParam(new Param.FloatParam("level2", this.level2 / 255.0F));
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new Param.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceOffFilter
 * JD-Core Version:    0.7.0.1
 */