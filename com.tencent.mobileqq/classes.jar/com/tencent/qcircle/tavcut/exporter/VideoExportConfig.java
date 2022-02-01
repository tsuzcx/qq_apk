package com.tencent.qcircle.tavcut.exporter;

public class VideoExportConfig
  extends ExportConfig
{
  private int bitRate = -1;
  private int frameRate = -1;
  private int height = -1;
  private String outputPath = "";
  private int width = -1;
  
  public int getBitRate()
  {
    return this.bitRate;
  }
  
  public int getFrameRate()
  {
    return this.frameRate;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public String getOutputPath()
  {
    return this.outputPath;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void setBitRate(int paramInt)
  {
    this.bitRate = paramInt;
  }
  
  public void setFrameRate(int paramInt)
  {
    this.frameRate = paramInt;
  }
  
  public void setOutputPath(String paramString)
  {
    this.outputPath = paramString;
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.exporter.VideoExportConfig
 * JD-Core Version:    0.7.0.1
 */