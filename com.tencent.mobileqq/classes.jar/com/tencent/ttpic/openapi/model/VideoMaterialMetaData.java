package com.tencent.ttpic.openapi.model;

public class VideoMaterialMetaData
{
  public String category;
  public String id;
  public String path;
  public String thumbPath;
  public String url;
  
  public VideoMaterialMetaData(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.id = paramString1;
    this.path = paramString2;
    this.url = paramString3;
    this.thumbPath = paramString4;
  }
  
  public String getCategory()
  {
    return this.category;
  }
  
  public void setCategory(String paramString)
  {
    this.category = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.VideoMaterialMetaData
 * JD-Core Version:    0.7.0.1
 */