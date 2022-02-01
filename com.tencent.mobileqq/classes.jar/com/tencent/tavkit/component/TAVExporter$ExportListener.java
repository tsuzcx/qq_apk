package com.tencent.tavkit.component;

import com.tencent.tav.core.AssetExportSession;

public abstract interface TAVExporter$ExportListener
{
  public abstract void onExportCancel();
  
  public abstract void onExportCompleted(String paramString);
  
  public abstract void onExportError(AssetExportSession paramAssetExportSession);
  
  public abstract void onExportStart();
  
  public abstract void onExporting(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVExporter.ExportListener
 * JD-Core Version:    0.7.0.1
 */