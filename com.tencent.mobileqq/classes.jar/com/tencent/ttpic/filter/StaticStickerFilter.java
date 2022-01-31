package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.Param.IntParam;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.recorder.ActVideoDecoder;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.VideoFilterUtil;
import java.util.List;

public class StaticStickerFilter
  extends NormalVideoFilter
{
  private boolean initialized = false;
  
  public StaticStickerFilter(StickerItem paramStickerItem, String paramString)
  {
    super(paramStickerItem, paramString);
  }
  
  private void initFabbyPositionAdjust()
  {
    if (this.item.aspectMode == 1)
    {
      setPositions(VideoFilterUtil.ORIGIN_POSITION_COORDS);
      return;
    }
    double d2 = this.width / this.height;
    double d1 = this.item.width / this.item.height;
    if (d2 >= d1)
    {
      d2 = this.width / 720.0D;
      j = (int)(this.width / d1);
      int k = (int)(j * this.item.position[1]);
      i = (int)(this.width * this.item.position[0]);
      j = k - (j - this.height) / 2;
      setPositions(AlgoUtils.calPositions(i, (float)(j + this.item.height * d2), (float)(i + this.item.width * d2), j, this.width, this.height));
      return;
    }
    d2 = this.height / 720.0D * d1;
    int j = (int)(this.height * d1);
    int i = (int)(this.height * this.item.position[1]);
    j = (int)(j * this.item.position[0]) - (j - this.width) / 2;
    setPositions(AlgoUtils.calPositions(j, (float)(i + this.item.height * d2), (float)(j + this.item.width * d2), i, this.width, this.height));
  }
  
  public void clearTextureParam()
  {
    super.clearTextureParam();
    this.initialized = false;
  }
  
  public void initParams()
  {
    super.initParams();
    addParam(new Param.IntParam("texNeedTransform", -1));
  }
  
  public void initPositionAdjusted()
  {
    if ((this.item == null) || (this.item.position == null) || (this.item.position.length < 2))
    {
      setPositions(VideoFilterUtil.EMPTY_POSITIONS);
      return;
    }
    if (this.width / this.height >= 0.75D)
    {
      d = this.width / 720.0D;
      j = (int)(this.width / 0.75D);
      int k = (int)(j * this.item.position[1]);
      i = (int)(this.width * this.item.position[0]);
      j = k - (j - this.height) / 2;
      setPositions(AlgoUtils.calPositions(i, (float)(j + this.item.height * d), (float)(i + this.item.width * d), j, this.width, this.height));
      return;
    }
    double d = this.height / 960.0D;
    int j = (int)(this.height * 0.75D);
    int i = (int)(this.height * this.item.position[1]);
    j = (int)(j * this.item.position[0]) - (j - this.width) / 2;
    setPositions(AlgoUtils.calPositions(j, (float)(i + this.item.height * d), (float)(j + this.item.width * d), i, this.width, this.height));
  }
  
  public void initPositions()
  {
    if ((this.item == null) || (this.item.position == null) || (this.item.position.length < 2))
    {
      setPositions(VideoFilterUtil.EMPTY_POSITIONS);
      return;
    }
    double d = this.width / 720.0D;
    int i = (int)(this.height * (1.0D - this.item.position[1]));
    int j = (int)(this.width * this.item.position[0]);
    setPositions(AlgoUtils.calPositions(j, i, (int)(this.item.width * d) + j, (int)(i - this.item.height * d), this.width, this.height));
    this.initialized = true;
  }
  
  public void resetFabbyProgress()
  {
    this.triggered = false;
    if (this.mVideoDecoder != null) {
      this.mVideoDecoder.reset();
    }
  }
  
  public void updateFabbyProgress(long paramLong)
  {
    if (!this.triggered) {
      this.frameStartTime = paramLong;
    }
    this.triggered = true;
    updateTextureParam((int)((paramLong - this.frameStartTime) / Math.max(this.item.frameDuration, 1.0D)) % Math.max(this.item.frames, 1), paramLong);
    initFabbyPositionAdjust();
  }
  
  protected void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat)
  {
    if (this.initialized) {
      return;
    }
    if (this.item.isFabbyMvItem)
    {
      initFabbyPositionAdjust();
      return;
    }
    initPositionAdjusted();
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    if (this.item.isFabbyMvItem)
    {
      initFabbyPositionAdjust();
      return;
    }
    initPositionAdjusted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.StaticStickerFilter
 * JD-Core Version:    0.7.0.1
 */