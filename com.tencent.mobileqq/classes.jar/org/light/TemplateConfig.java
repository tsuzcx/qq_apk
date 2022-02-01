package org.light;

public class TemplateConfig
{
  public static final int SourceType_MultiMedia = 2;
  public static final int SourceType_Photo = 1;
  public static final int SourceType_Video = 0;
  public int maxClipAssetCount = 0;
  public int maxImageDuration = 0;
  public int minClipAssetCount = 0;
  public int minImageDuration = 0;
  public int minVideoDuration = 0;
  public long preferredCoverTime = 0L;
  public int type = 0;
  
  public TemplateConfig(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong)
  {
    this.type = paramInt1;
    this.minImageDuration = paramInt2;
    this.maxImageDuration = paramInt3;
    this.minClipAssetCount = paramInt4;
    this.maxClipAssetCount = paramInt5;
    this.minVideoDuration = paramInt6;
    this.preferredCoverTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.TemplateConfig
 * JD-Core Version:    0.7.0.1
 */