package com.tencent.qcircle.tavcut.exporter;

import com.tencent.tav.core.AssetExportSession;

public abstract interface MovieExporter$ExportListener
{
  public abstract void onExportCancel();
  
  public abstract void onExportCompleted(String paramString);
  
  public abstract void onExportError(AssetExportSession paramAssetExportSession);
  
  public abstract void onExportStart();
  
  public abstract void onExporting(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.exporter.MovieExporter.ExportListener
 * JD-Core Version:    0.7.0.1
 */