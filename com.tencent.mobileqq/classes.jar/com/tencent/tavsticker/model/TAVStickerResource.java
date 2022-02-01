package com.tencent.tavsticker.model;

import java.nio.ByteBuffer;

public abstract class TAVStickerResource
{
  private ByteBuffer byteBuffer = null;
  private String filePath = "";
  private TAVResourceType resourceType = TAVResourceType.UNKNOWN;
  
  public TAVStickerResource(TAVResourceType paramTAVResourceType, String paramString, ByteBuffer paramByteBuffer)
  {
    this.resourceType = paramTAVResourceType;
    this.filePath = paramString;
    this.byteBuffer = paramByteBuffer;
  }
  
  public ByteBuffer getByteBuffer()
  {
    return this.byteBuffer;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public TAVResourceType getResourceType()
  {
    return this.resourceType;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAVStickerResource {resourceType : ");
    localStringBuilder.append(this.resourceType);
    localStringBuilder.append(", filePath : ");
    localStringBuilder.append(this.filePath);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVStickerResource
 * JD-Core Version:    0.7.0.1
 */