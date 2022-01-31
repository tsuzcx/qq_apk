package com.tencent.weseevideo.model.resource;

import com.tencent.weseevideo.model.BaseMediaModel;

public class VideoResourceModel
  extends BaseMediaModel
{
  private int height;
  private String path;
  private int rotate;
  private long scaleDuration;
  private long selectTimeDuration;
  private long selectTimeDurationUs;
  private long selectTimeStart;
  private long selectTimeStartUs;
  private long sourceTimeDuration;
  private long sourceTimeDurationUs;
  private long sourceTimeStart;
  private long sourceTimeStartUs;
  private int type = 1;
  private int width;
  
  public VideoResourceModel clone()
  {
    VideoResourceModel localVideoResourceModel = new VideoResourceModel();
    localVideoResourceModel.setPath(this.path);
    localVideoResourceModel.setScaleDuration(this.scaleDuration);
    localVideoResourceModel.setSourceTimeStart(this.sourceTimeStart);
    localVideoResourceModel.setSourceTimeDuration(this.sourceTimeDuration);
    localVideoResourceModel.setScaleDuration(this.scaleDuration);
    localVideoResourceModel.setType(this.type);
    localVideoResourceModel.setSelectTimeStart(this.selectTimeStart);
    localVideoResourceModel.setSelectTimeDuration(this.selectTimeDuration);
    localVideoResourceModel.setSourceTimeDurationUs(this.sourceTimeDurationUs);
    localVideoResourceModel.setSelectTimeDurationUs(this.selectTimeDurationUs);
    localVideoResourceModel.setWidth(this.width);
    localVideoResourceModel.setHeight(this.height);
    localVideoResourceModel.setRotate(this.rotate);
    return localVideoResourceModel;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (VideoResourceModel)paramObject;
    } while ((this.scaleDuration == paramObject.scaleDuration) && (this.sourceTimeStart == paramObject.sourceTimeStart) && (this.sourceTimeDuration == paramObject.sourceTimeDuration) && (this.type == paramObject.type) && (this.sourceTimeStartUs == paramObject.sourceTimeStartUs) && (this.sourceTimeDurationUs == paramObject.sourceTimeDurationUs) && (this.selectTimeStart == paramObject.selectTimeStart) && (this.selectTimeDuration == paramObject.selectTimeDuration) && (this.selectTimeStartUs == paramObject.selectTimeStartUs) && (this.selectTimeDurationUs == paramObject.selectTimeDurationUs) && (this.width == paramObject.width) && (this.height == paramObject.height) && (this.rotate == paramObject.rotate) && (this.path.equals(paramObject.path)));
    return false;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public int getRotate()
  {
    return this.rotate;
  }
  
  public long getScaleDuration()
  {
    if (this.scaleDuration == 0L) {
      return this.selectTimeDuration;
    }
    return this.scaleDuration;
  }
  
  public long getSelectTimeDuration()
  {
    return this.selectTimeDuration;
  }
  
  public long getSelectTimeDurationUs()
  {
    return this.selectTimeDurationUs;
  }
  
  public long getSelectTimeStart()
  {
    return this.selectTimeStart;
  }
  
  public long getSelectTimeStartUs()
  {
    return this.selectTimeStartUs;
  }
  
  public long getSourceTimeDuration()
  {
    return this.sourceTimeDuration;
  }
  
  public long getSourceTimeDurationUs()
  {
    return this.sourceTimeDurationUs;
  }
  
  public long getSourceTimeStart()
  {
    return this.sourceTimeStart;
  }
  
  public long getSourceTimeStartUs()
  {
    return this.sourceTimeStartUs;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  public void setRotate(int paramInt)
  {
    this.rotate = paramInt;
  }
  
  public void setScaleDuration(long paramLong)
  {
    this.scaleDuration = paramLong;
  }
  
  public void setSelectTimeDuration(long paramLong)
  {
    this.selectTimeDuration = paramLong;
    this.selectTimeDurationUs = (1000L * paramLong);
  }
  
  public void setSelectTimeDurationUs(long paramLong)
  {
    this.selectTimeDuration = (paramLong / 1000L);
    this.selectTimeDurationUs = paramLong;
  }
  
  public void setSelectTimeStart(long paramLong)
  {
    this.selectTimeStart = paramLong;
    this.selectTimeStartUs = (1000L * paramLong);
  }
  
  public void setSelectTimeStartUs(long paramLong)
  {
    this.selectTimeStart = (paramLong / 1000L);
    this.selectTimeStartUs = paramLong;
  }
  
  public void setSourceTimeDuration(long paramLong)
  {
    this.sourceTimeDuration = paramLong;
    this.sourceTimeDurationUs = (1000L * paramLong);
    if (this.selectTimeDuration == 0L) {
      setSelectTimeDuration(paramLong);
    }
  }
  
  public void setSourceTimeDurationUs(long paramLong)
  {
    this.sourceTimeDuration = (paramLong / 1000L);
    this.sourceTimeDurationUs = paramLong;
  }
  
  public void setSourceTimeStart(long paramLong)
  {
    this.sourceTimeStart = paramLong;
    this.sourceTimeStartUs = (1000L * paramLong);
  }
  
  public void setSourceTimeStartUs(long paramLong)
  {
    this.sourceTimeStart = (paramLong / 1000L);
    this.sourceTimeStartUs = paramLong;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
  
  public String toString()
  {
    return "VideoResourceModel{path='" + this.path + '\'' + ", scaleDuration=" + this.scaleDuration + ", sourceTimeStart=" + this.sourceTimeStart + ", sourceTimeDuration=" + this.sourceTimeDuration + ", type=" + this.type + ", sourceTimeStartUs=" + this.sourceTimeStartUs + ", sourceTimeDurationUs=" + this.sourceTimeDurationUs + ", selectTimeStart=" + this.selectTimeStart + ", selectTimeDuration=" + this.selectTimeDuration + ", selectTimeStartUs=" + this.selectTimeStartUs + ", selectTimeDurationUs=" + this.selectTimeDurationUs + ", width=" + this.width + ", height=" + this.height + ", rotate=" + this.rotate + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.model.resource.VideoResourceModel
 * JD-Core Version:    0.7.0.1
 */