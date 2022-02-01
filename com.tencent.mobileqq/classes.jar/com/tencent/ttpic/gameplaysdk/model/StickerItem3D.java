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
      if ((this.triggered) && (!TextUtils.isEmpty(this.extension))) {
        break label136;
      }
      this.curPlayCount = 0;
      this.curFrameImagePath = "";
      this.frameStartTime = paramLong;
      Log.i("gameFilter", " updateActionTriggered item.id = " + this.id);
      Log.i("gameFilter", "gameFilter updateActionTriggered triggered = " + this.triggered + "frameStartTime = " + this.frameStartTime + ", curPlayCount = " + this.curPlayCount);
    }
    label136:
    int i;
    int j;
    do
    {
      return;
      i = (int)((paramLong - this.frameStartTime) / Math.max(this.frameDuration, 1.0D));
      if (i >= this.frames * (this.curPlayCount + 1)) {
        this.curPlayCount += 1;
      }
      j = Math.max(this.frames, 1);
      localObject = this.id.split(":");
    } while (localObject.length != 2);
    Object localObject = localObject[1];
    this.curFrameImagePath = ((String)localObject + File.separator + (String)localObject + "_" + i % j + "." + this.extension);
  }
  
  public void reset()
  {
    this.curPlayCount = 0;
    this.triggered = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.gameplaysdk.model.StickerItem3D
 * JD-Core Version:    0.7.0.1
 */