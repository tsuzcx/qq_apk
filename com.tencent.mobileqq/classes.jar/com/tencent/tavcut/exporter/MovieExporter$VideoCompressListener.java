package com.tencent.tavcut.exporter;

import com.tencent.tav.core.AssetExportSession;

public abstract interface MovieExporter$VideoCompressListener
{
  public abstract void onCompressCanceled();
  
  public abstract void onCompressError(AssetExportSession paramAssetExportSession);
  
  public abstract void onCompressFinish(String paramString);
  
  public abstract void onCompressStart();
  
  public abstract void onCompressing(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.exporter.MovieExporter.VideoCompressListener
 * JD-Core Version:    0.7.0.1
 */