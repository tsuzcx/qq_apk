package com.tencent.tavkit.component;

public abstract interface TAVExporter$ExportListener
{
  public abstract void onExportCancel();
  
  public abstract void onExportCompleted(String paramString);
  
  public abstract void onExportError(int paramInt, Throwable paramThrowable);
  
  public abstract void onExportStart();
  
  public abstract void onExporting(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVExporter.ExportListener
 * JD-Core Version:    0.7.0.1
 */