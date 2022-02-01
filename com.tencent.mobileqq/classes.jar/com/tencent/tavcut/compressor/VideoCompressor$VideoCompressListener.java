package com.tencent.tavcut.compressor;

import com.tencent.tav.core.AssetExportSession;

public abstract interface VideoCompressor$VideoCompressListener
{
  public abstract void onCompressCanceled();
  
  public abstract void onCompressError(AssetExportSession paramAssetExportSession);
  
  public abstract void onCompressFinish(String paramString);
  
  public abstract void onCompressStart();
  
  public abstract void onCompressing(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.compressor.VideoCompressor.VideoCompressListener
 * JD-Core Version:    0.7.0.1
 */