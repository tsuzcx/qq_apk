package com.tencent.tav.decoder;

import java.util.HashMap;

public class IDecoder$Params
{
  public HashMap<String, Object> extraInfo;
  public String filePath;
  public int sourceType;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Params{sourceType=");
    localStringBuilder.append(this.sourceType);
    localStringBuilder.append(", filePath='");
    localStringBuilder.append(this.filePath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", extraInfo=");
    localStringBuilder.append(this.extraInfo);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.IDecoder.Params
 * JD-Core Version:    0.7.0.1
 */