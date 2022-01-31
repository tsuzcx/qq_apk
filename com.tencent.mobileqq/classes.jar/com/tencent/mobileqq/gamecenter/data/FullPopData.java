package com.tencent.mobileqq.gamecenter.data;

import android.graphics.Bitmap;
import java.io.File;
import java.io.Serializable;

public class FullPopData
  implements Serializable
{
  public static final String RES_FULLPOP_BOX = "box.png";
  public static final String RES_FULLPOP_LINE = "line.png";
  public static final String RES_FULLPOP_VIDEO = "video.mp4";
  public long beginTime;
  private Bitmap boxBitmap;
  public long endTime;
  public String id;
  public String jumpUrl = "";
  private Bitmap lineBitmap;
  public String resPath;
  public String resUrl = "";
  private File videoFile;
  
  public FullPopData() {}
  
  public FullPopData(String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3)
  {
    this.resUrl = paramString1;
    this.jumpUrl = paramString2;
    this.beginTime = paramLong1;
    this.endTime = paramLong2;
    this.id = paramString3;
  }
  
  public long getBeginTime()
  {
    return this.beginTime;
  }
  
  public Bitmap getBoxBitmap()
  {
    return this.boxBitmap;
  }
  
  public long getEndTime()
  {
    return this.endTime;
  }
  
  public String getJumpUrl()
  {
    return this.jumpUrl;
  }
  
  public Bitmap getLineBitmap()
  {
    return this.lineBitmap;
  }
  
  public String getResPath()
  {
    return this.resPath;
  }
  
  public String getResUrl()
  {
    return this.resUrl;
  }
  
  public File getVideoFile()
  {
    return this.videoFile;
  }
  
  public void setBeginTime(long paramLong)
  {
    this.beginTime = paramLong;
  }
  
  public void setBoxBitmap(Bitmap paramBitmap)
  {
    this.boxBitmap = paramBitmap;
  }
  
  public void setEndTime(long paramLong)
  {
    this.endTime = paramLong;
  }
  
  public void setJumpUrl(String paramString)
  {
    this.jumpUrl = paramString;
  }
  
  public void setLineBitmap(Bitmap paramBitmap)
  {
    this.lineBitmap = paramBitmap;
  }
  
  public void setResPath(String paramString)
  {
    this.resPath = paramString;
  }
  
  public void setResUrl(String paramString)
  {
    this.resUrl = paramString;
  }
  
  public void setVideoFile(File paramFile)
  {
    this.videoFile = paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.FullPopData
 * JD-Core Version:    0.7.0.1
 */