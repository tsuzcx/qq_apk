package com.tencent.weseevideo.model.resource;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.weseevideo.model.BaseMediaModel;
import com.tencent.weseevideo.model.effect.VideoEffectModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoConfigurationModel
  extends BaseMediaModel
{
  private int contentMode;
  private List<VideoEffectModel> effects;
  private float frameHeight;
  private PointF frameOrigin;
  private float frameWidth;
  private float[] matrix = { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  private int rotate = 0;
  
  protected VideoConfigurationModel clone()
  {
    VideoConfigurationModel localVideoConfigurationModel = new VideoConfigurationModel();
    localVideoConfigurationModel.setContentMode(getContentMode());
    localVideoConfigurationModel.setFrameHeight(getFrameHeight());
    localVideoConfigurationModel.setFrameWidth(getFrameWidth());
    localVideoConfigurationModel.setFrameOrigin(getFrameOrigin());
    localVideoConfigurationModel.setMatrix(getMatrix());
    localVideoConfigurationModel.setRotate(getRotate());
    ArrayList localArrayList = new ArrayList();
    if (getEffects() != null)
    {
      Iterator localIterator = getEffects().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((VideoEffectModel)localIterator.next()).clone());
      }
    }
    localVideoConfigurationModel.setEffects(localArrayList);
    return localVideoConfigurationModel;
  }
  
  @Nullable
  public CGRect createFrameRect()
  {
    if ((this.frameOrigin == null) || (this.frameWidth <= 0.0F) || (this.frameHeight <= 0.0F)) {
      return null;
    }
    return new CGRect(this.frameOrigin, new CGSize(this.frameWidth, this.frameHeight));
  }
  
  public int getContentMode()
  {
    return this.contentMode;
  }
  
  public List<VideoEffectModel> getEffects()
  {
    return this.effects;
  }
  
  public float getFrameHeight()
  {
    return this.frameHeight;
  }
  
  public PointF getFrameOrigin()
  {
    return this.frameOrigin;
  }
  
  public float getFrameWidth()
  {
    return this.frameWidth;
  }
  
  public float[] getMatrix()
  {
    return this.matrix;
  }
  
  public int getRotate()
  {
    return this.rotate;
  }
  
  public void setContentMode(int paramInt)
  {
    this.contentMode = paramInt;
  }
  
  public void setEffects(List<VideoEffectModel> paramList)
  {
    this.effects = paramList;
  }
  
  public void setFrameHeight(float paramFloat)
  {
    this.frameHeight = paramFloat;
  }
  
  public void setFrameOrigin(PointF paramPointF)
  {
    this.frameOrigin = paramPointF;
  }
  
  public void setFrameWidth(float paramFloat)
  {
    this.frameWidth = paramFloat;
  }
  
  public void setMatrix(float[] paramArrayOfFloat)
  {
    this.matrix = paramArrayOfFloat;
  }
  
  public void setRotate(int paramInt)
  {
    this.rotate = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.resource.VideoConfigurationModel
 * JD-Core Version:    0.7.0.1
 */