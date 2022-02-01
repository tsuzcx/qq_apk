package com.tencent.ttpic.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.openapi.model.ExpressionItem;
import com.tencent.ttpic.util.ActUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CaptureActItem
  extends FrameSourceItem
{
  private static final String TAG = "CaptureActItem";
  private int[] captureTimes;
  private BaseFilter copyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame[] copyFrames;
  private String dataPath;
  private List<ExpressionItem> expressionList;
  private String imageId;
  private int lastCaptureIndex = -1;
  private int[] numTextures = new int[10];
  private final Random random;
  private CaptureActItem.ScoreTag[] scores;
  private List<float[]> starFaceAngles;
  private List<List<PointF>> starFacePoints;
  
  public CaptureActItem(List<ExpressionItem> paramList, String paramString1, String paramString2, BaseFilter paramBaseFilter)
  {
    super(paramBaseFilter);
    this.expressionList = paramList;
    this.dataPath = paramString1;
    this.imageId = paramString2;
    this.starFacePoints = new ArrayList(paramList.size());
    this.starFaceAngles = new ArrayList(paramList.size());
    this.captureTimes = new int[paramList.size()];
    int j = 0;
    int i = 0;
    while (i < paramList.size())
    {
      paramString1 = (ExpressionItem)paramList.get(i);
      this.starFacePoints.add(paramString1.expressionFeat);
      this.starFaceAngles.add(paramString1.expressionAngle);
      this.captureTimes[i] = paramString1.expressionTime;
      i += 1;
    }
    this.scores = new CaptureActItem.ScoreTag[paramList.size()];
    i = 0;
    for (;;)
    {
      paramString1 = this.scores;
      if (i >= paramString1.length) {
        break;
      }
      paramString1[i] = new CaptureActItem.ScoreTag(null);
      i += 1;
    }
    this.copyFrames = new Frame[paramList.size()];
    i = j;
    for (;;)
    {
      paramList = this.copyFrames;
      if (i >= paramList.length) {
        break;
      }
      paramList[i] = new Frame();
      i += 1;
    }
    this.random = new Random(System.currentTimeMillis());
  }
  
  private int getCaptureIndex(long paramLong)
  {
    int i = this.lastCaptureIndex;
    int[] arrayOfInt = this.captureTimes;
    if ((i + 1 < arrayOfInt.length) && (paramLong >= arrayOfInt[(i + 1)]))
    {
      this.lastCaptureIndex = (i + 1);
      return this.lastCaptureIndex;
    }
    return -1;
  }
  
  public void clear()
  {
    this.copyFilter.clearGLSL();
    Object localObject = this.copyFrames;
    int j = localObject.length;
    int i = 0;
    CaptureActItem.ScoreTag localScoreTag;
    while (i < j)
    {
      localScoreTag = localObject[i];
      if (localScoreTag != null) {
        localScoreTag.clear();
      }
      i += 1;
    }
    localObject = this.scores;
    j = localObject.length;
    i = 0;
    while (i < j)
    {
      localScoreTag = localObject[i];
      if (CaptureActItem.ScoreTag.access$100(localScoreTag) != null)
      {
        GLES20.glDeleteTextures(CaptureActItem.ScoreTag.access$100(localScoreTag).length, CaptureActItem.ScoreTag.access$100(localScoreTag), 0);
        CaptureActItem.ScoreTag.access$102(localScoreTag, null);
      }
      i += 1;
    }
  }
  
  public int getOrigHeight(int paramInt)
  {
    if (paramInt >= 0)
    {
      Frame[] arrayOfFrame = this.copyFrames;
      if (paramInt < arrayOfFrame.length) {
        return arrayOfFrame[paramInt].height;
      }
    }
    return -1;
  }
  
  public int getOrigWidth(int paramInt)
  {
    if (paramInt >= 0)
    {
      Frame[] arrayOfFrame = this.copyFrames;
      if (paramInt < arrayOfFrame.length) {
        return arrayOfFrame[paramInt].width;
      }
    }
    return -1;
  }
  
  public int getScore(CanvasItem paramCanvasItem)
  {
    CaptureActItem.ScoreTag.access$302(this.scores[paramCanvasItem.index], true);
    return CaptureActItem.ScoreTag.access$200(this.scores[paramCanvasItem.index]);
  }
  
  public int[] getScoreTexture(CanvasItem paramCanvasItem)
  {
    if (CaptureActItem.ScoreTag.access$100(this.scores[paramCanvasItem.index]) != null) {
      return CaptureActItem.ScoreTag.access$100(this.scores[paramCanvasItem.index]);
    }
    return this.numTextures;
  }
  
  public int getTexture(CanvasItem paramCanvasItem, long paramLong)
  {
    return this.copyFrames[paramCanvasItem.index].getTextureId();
  }
  
  public int getTotalScore()
  {
    CaptureActItem.ScoreTag[] arrayOfScoreTag = this.scores;
    int m = arrayOfScoreTag.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      CaptureActItem.ScoreTag localScoreTag = arrayOfScoreTag[i];
      k = j;
      if (CaptureActItem.ScoreTag.access$300(localScoreTag)) {
        k = j + CaptureActItem.ScoreTag.access$200(localScoreTag);
      }
      i += 1;
    }
    return j;
  }
  
  public int[] getTotalScoreTexture()
  {
    return this.numTextures;
  }
  
  public void init()
  {
    this.copyFilter.apply();
    Object localObject1 = this.numTextures;
    GLES20.glGenTextures(localObject1.length, (int[])localObject1, 0);
    int i = 0;
    Object localObject2;
    while (i < 10)
    {
      localObject1 = AEModule.getContext();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.dataPath);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("expression");
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(this.imageId);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(this.imageId);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(".png");
      localObject1 = BitmapUtils.decodeSampleBitmap((Context)localObject1, ((StringBuilder)localObject2).toString(), 720, 1280);
      if (BitmapUtils.isLegal((Bitmap)localObject1))
      {
        GlUtil.loadTexture(this.numTextures[i], (Bitmap)localObject1);
        ((Bitmap)localObject1).recycle();
      }
      i += 1;
    }
    i = 0;
    while (i < this.expressionList.size())
    {
      localObject1 = ((ExpressionItem)this.expressionList.get(i)).scoreImageID;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new int[10];
        GLES20.glGenTextures(localObject2.length, (int[])localObject2, 0);
        int j = 0;
        while (j < 10)
        {
          Object localObject3 = AEModule.getContext();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.dataPath);
          localStringBuilder.append(File.separator);
          localStringBuilder.append("expression");
          localStringBuilder.append(File.separator);
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(File.separator);
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("_");
          localStringBuilder.append(j);
          localStringBuilder.append(".png");
          localObject3 = BitmapUtils.decodeSampleBitmap((Context)localObject3, localStringBuilder.toString(), 720, 1280);
          if (BitmapUtils.isLegal((Bitmap)localObject3))
          {
            GlUtil.loadTexture(localObject2[j], (Bitmap)localObject3);
            ((Bitmap)localObject3).recycle();
          }
          j += 1;
        }
        CaptureActItem.ScoreTag.access$102(this.scores[i], (int[])localObject2);
      }
      i += 1;
    }
  }
  
  public void reset()
  {
    this.lastCaptureIndex = -1;
    int i = 0;
    for (;;)
    {
      CaptureActItem.ScoreTag[] arrayOfScoreTag = this.scores;
      if (i >= arrayOfScoreTag.length) {
        break;
      }
      CaptureActItem.ScoreTag.access$202(arrayOfScoreTag[i], 0);
      CaptureActItem.ScoreTag.access$302(this.scores[i], false);
      i += 1;
    }
  }
  
  public void update(Frame paramFrame, long paramLong, List<List<PointF>> paramList, List<float[]> paramList1, int paramInt)
  {
    super.update(paramFrame, paramLong, paramList, paramList1, paramInt);
    int i = getCaptureIndex(paramLong);
    if (i >= 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(TAG);
      localStringBuilder.append("[update]");
      BenchUtil.benchStart(localStringBuilder.toString());
      this.copyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.copyFrames[i]);
      paramFrame = new StringBuilder();
      paramFrame.append(TAG);
      paramFrame.append("[update]");
      BenchUtil.benchEnd(paramFrame.toString());
      if ((paramList.size() > 0) && (paramInt == 0))
      {
        paramFrame = new StringBuilder();
        paramFrame.append(TAG);
        paramFrame.append("[calculate score]");
        BenchUtil.benchStart(paramFrame.toString());
        CaptureActItem.ScoreTag.access$202(this.scores[i], (int)ActUtil.getExpressionSimilarity((List)this.starFacePoints.get(i), (List)paramList.get(0), (float[])this.starFaceAngles.get(i), (float[])paramList1.get(0), ((ExpressionItem)this.expressionList.get(i)).expressionWeight));
        paramFrame = new StringBuilder();
        paramFrame.append(TAG);
        paramFrame.append("[calculate score]");
        BenchUtil.benchEnd(paramFrame.toString());
        return;
      }
      CaptureActItem.ScoreTag.access$202(this.scores[i], this.random.nextInt(5) + 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.model.CaptureActItem
 * JD-Core Version:    0.7.0.1
 */