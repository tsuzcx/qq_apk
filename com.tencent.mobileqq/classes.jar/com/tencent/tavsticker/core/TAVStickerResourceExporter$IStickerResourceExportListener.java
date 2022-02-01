package com.tencent.tavsticker.core;

import com.tencent.tavsticker.model.TAVStickerResource;

public abstract interface TAVStickerResourceExporter$IStickerResourceExportListener
{
  public abstract void exporting(TAVStickerResource paramTAVStickerResource, float paramFloat);
  
  public abstract void failed(String paramString1, String paramString2);
  
  public abstract void start(TAVStickerResource paramTAVStickerResource);
  
  public abstract void succeed(TAVStickerResource paramTAVStickerResource);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerResourceExporter.IStickerResourceExportListener
 * JD-Core Version:    0.7.0.1
 */