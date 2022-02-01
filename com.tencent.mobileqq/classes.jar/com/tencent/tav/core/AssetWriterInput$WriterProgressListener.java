package com.tencent.tav.core;

import android.support.annotation.NonNull;

abstract interface AssetWriterInput$WriterProgressListener
{
  public abstract void onError(@NonNull ExportErrorStatus paramExportErrorStatus);
  
  public abstract void onProgressChanged(AssetWriterInput paramAssetWriterInput, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.core.AssetWriterInput.WriterProgressListener
 * JD-Core Version:    0.7.0.1
 */