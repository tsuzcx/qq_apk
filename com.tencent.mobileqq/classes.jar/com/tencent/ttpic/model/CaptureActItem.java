package com.tencent.ttpic.model;

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
  private static final String TAG = CaptureActItem.class.getSimpleName();
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
    while (i < this.scores.length)
    {
      this.scores[i] = new CaptureActItem.ScoreTag(null);
      i += 1;
    }
    this.copyFrames = new Frame[paramList.size()];
    i = j;
    while (i < this.copyFrames.length)
    {
      this.copyFrames[i] = new Frame();
      i += 1;
    }
    this.random = new Random(System.currentTimeMillis());
  }
  
  private int getCaptureIndex(long paramLong)
  {
    if ((this.lastCaptureIndex + 1 < this.captureTimes.length) && (paramLong >= this.captureTimes[(this.lastCaptureIndex + 1)]))
    {
      this.lastCaptureIndex += 1;
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
    if ((paramInt < 0) || (paramInt >= this.copyFrames.length)) {
      return -1;
    }
    return this.copyFrames[paramInt].height;
  }
  
  public int getOrigWidth(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.copyFrames.length)) {
      return -1;
    }
    return this.copyFrames[paramInt].width;
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
    int j = 0;
    CaptureActItem.ScoreTag[] arrayOfScoreTag = this.scores;
    int m = arrayOfScoreTag.length;
    int i = 0;
    while (i < m)
    {
      CaptureActItem.ScoreTag localScoreTag = arrayOfScoreTag[i];
      int k = j;
      if (CaptureActItem.ScoreTag.access$300(localScoreTag)) {
        k = j + CaptureActItem.ScoreTag.access$200(localScoreTag);
      }
      i += 1;
      j = k;
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
    GLES20.glGenTextures(this.numTextures.length, this.numTextures, 0);
    int i = 0;
    Object localObject;
    if (i < 10)
    {
      localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.dataPath + File.separator + "expression" + File.separator + this.imageId + File.separator + this.imageId + "_" + i + ".png", 720, 1280);
      if (!BitmapUtils.isLegal((Bitmap)localObject)) {}
      for (;;)
      {
        i += 1;
        break;
        GlUtil.loadTexture(this.numTextures[i], (Bitmap)localObject);
        ((Bitmap)localObject).recycle();
      }
    }
    i = 0;
    while (i < this.expressionList.size())
    {
      localObject = ((ExpressionItem)this.expressionList.get(i)).scoreImageID;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        int[] arrayOfInt = new int[10];
        GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
        int j = 0;
        if (j < 10)
        {
          Bitmap localBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.dataPath + File.separator + "expression" + File.separator + (String)localObject + File.separator + (String)localObject + "_" + j + ".png", 720, 1280);
          if (!BitmapUtils.isLegal(localBitmap)) {}
          for (;;)
          {
            j += 1;
            break;
            GlUtil.loadTexture(arrayOfInt[j], localBitmap);
            localBitmap.recycle();
          }
        }
        CaptureActItem.ScoreTag.access$102(this.scores[i], arrayOfInt);
      }
      i += 1;
    }
  }
  
  public void reset()
  {
    this.lastCaptureIndex = -1;
    int i = 0;
    while (i < this.scores.length)
    {
      CaptureActItem.ScoreTag.access$202(this.scores[i], 0);
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
      BenchUtil.benchStart(TAG + "[update]");
      this.copyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.copyFrames[i]);
      BenchUtil.benchEnd(TAG + "[update]");
      if ((paramList.size() > 0) && (paramInt == 0))
      {
        BenchUtil.benchStart(TAG + "[calculate score]");
        CaptureActItem.ScoreTag.access$202(this.scores[i], (int)ActUtil.getExpressionSimilarity((List)this.starFacePoints.get(i), (List)paramList.get(0), (float[])this.starFaceAngles.get(i), (float[])paramList1.get(0), ((ExpressionItem)this.expressionList.get(i)).expressionWeight));
        BenchUtil.benchEnd(TAG + "[calculate score]");
      }
    }
    else
    {
      return;
    }
    CaptureActItem.ScoreTag.access$202(this.scores[i], this.random.nextInt(5) + 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.model.CaptureActItem
 * JD-Core Version:    0.7.0.1
 */