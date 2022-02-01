package org.light;

import java.util.HashMap;

public class MaterialConfig
{
  public static final int SourceType_MultiMedia = 2;
  public static final int SourceType_Photo = 1;
  public static final int SourceType_Video = 0;
  public HashMap<String, String> aiFilterList;
  public int clipAssetCount = 0;
  public String description = "";
  public String key = "";
  public int minImageHeight = 0;
  public int minImageWidth = 0;
  public int minVideoDuration = 0;
  public int type = 0;
  
  public MaterialConfig(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, HashMap<String, String> paramHashMap, String paramString2)
  {
    this.key = paramString1;
    this.type = paramInt1;
    this.clipAssetCount = paramInt2;
    this.minVideoDuration = paramInt3;
    this.minImageHeight = paramInt4;
    this.minImageWidth = paramInt5;
    this.aiFilterList = paramHashMap;
    this.description = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.light.MaterialConfig
 * JD-Core Version:    0.7.0.1
 */