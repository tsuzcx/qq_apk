package com.tencent.ttpic.gameplaysdk.model;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.ttpic.openapi.model.StickerItem;
import java.io.File;

public class StickerItem3D
  extends StickerItem
{
  public String curFrameImagePath;
  public int curPlayCount = 0;
  public String extension = "";
  public long frameStartTime;
  public String glbModePath;
  public float[] nodeEulerAngles;
  public NodeParameter nodeParameter;
  public float[] nodePosition;
  public float[] nodeScale;
  public boolean triggered = false;
  
  public void calFrameIndex(long paramLong)
  {
    if ((!TextUtils.isEmpty(this.id)) && (this.id.contains(":")))
    {
      Object localObject;
      if ((this.triggered) && (!TextUtils.isEmpty(this.extension)))
      {
        double d1 = paramLong - this.frameStartTime;
        double d2 = Math.max(this.frameDuration, 1.0D);
        Double.isNaN(d1);
        int i = (int)(d1 / d2);
        int j = this.frames;
        int k = this.curPlayCount;
        if (i >= j * (k + 1)) {
          this.curPlayCount = (k + 1);
        }
        j = Math.max(this.frames, 1);
        localObject = this.id.split(":");
        if (localObject.length == 2)
        {
          localObject = localObject[1];
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(File.separator);
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("_");
          localStringBuilder.append(i % j);
          localStringBuilder.append(".");
          localStringBuilder.append(this.extension);
          this.curFrameImagePath = localStringBuilder.toString();
        }
      }
      else
      {
        this.curPlayCount = 0;
        this.curFrameImagePath = "";
        this.frameStartTime = paramLong;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" updateActionTriggered item.id = ");
        ((StringBuilder)localObject).append(this.id);
        Log.i("gameFilter", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("gameFilter updateActionTriggered triggered = ");
        ((StringBuilder)localObject).append(this.triggered);
        ((StringBuilder)localObject).append("frameStartTime = ");
        ((StringBuilder)localObject).append(this.frameStartTime);
        ((StringBuilder)localObject).append(", curPlayCount = ");
        ((StringBuilder)localObject).append(this.curPlayCount);
        Log.i("gameFilter", ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void reset()
  {
    this.curPlayCount = 0;
    this.triggered = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.gameplaysdk.model.StickerItem3D
 * JD-Core Version:    0.7.0.1
 */