package com.tencent.thumbplayer.core.richmedia;

public class TPNativeRichMediaFeatureData
{
  private String mEnv;
  private TPNativeRichMediaFeatureData.TPNativeRichMediaFeatureContent[] mFeatureContents = new TPNativeRichMediaFeatureData.TPNativeRichMediaFeatureContent[0];
  private String mFeatureType;
  private String mVersion;
  
  public String getEnv()
  {
    return this.mEnv;
  }
  
  public TPNativeRichMediaFeatureData.TPNativeRichMediaFeatureContent[] getFeatureContents()
  {
    return this.mFeatureContents;
  }
  
  public String getFeatureType()
  {
    return this.mFeatureType;
  }
  
  public String getVersion()
  {
    return this.mVersion;
  }
  
  public void setEnv(String paramString)
  {
    this.mEnv = paramString;
  }
  
  public void setFeatureContents(TPNativeRichMediaFeatureData.TPNativeRichMediaFeatureContent[] paramArrayOfTPNativeRichMediaFeatureContent)
  {
    this.mFeatureContents = paramArrayOfTPNativeRichMediaFeatureContent;
  }
  
  public void setFeatureType(String paramString)
  {
    this.mFeatureType = paramString;
  }
  
  public void setVersion(String paramString)
  {
    this.mVersion = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaFeatureData
 * JD-Core Version:    0.7.0.1
 */