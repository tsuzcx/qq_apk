package com.tencent.ttpic.openapi.filter;

import java.util.List;

public class FabbyParts
{
  private String audioFile;
  private List<FabbyMvPart> parts;
  
  public FabbyParts(List<FabbyMvPart> paramList, String paramString)
  {
    this.parts = paramList;
    this.audioFile = paramString;
  }
  
  public String getAudioFile()
  {
    return this.audioFile;
  }
  
  public List<FabbyMvPart> getParts()
  {
    return this.parts;
  }
  
  public void setAudioFile(String paramString)
  {
    this.audioFile = paramString;
  }
  
  public void setParts(List<FabbyMvPart> paramList)
  {
    this.parts = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.FabbyParts
 * JD-Core Version:    0.7.0.1
 */