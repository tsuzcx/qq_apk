package com.tencent.tavcut.exporter;

import java.util.Collection;

public abstract interface ImageExporter$ImageExportCallback
{
  public abstract void onCancelled();
  
  public abstract void onExportComplete();
  
  public abstract void onFailed(Collection<String> paramCollection);
  
  public abstract void onImageExport(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.exporter.ImageExporter.ImageExportCallback
 * JD-Core Version:    0.7.0.1
 */