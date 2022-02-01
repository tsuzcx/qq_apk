package com.tencent.tavcut.render.exporter;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/exporter/IExporter$ExportListener;", "", "onExportCancel", "", "onExportCompleted", "exportPath", "", "onExportError", "errCode", "", "throwable", "", "onExportStart", "onExporting", "progress", "", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public abstract interface IExporter$ExportListener
{
  public abstract void a();
  
  public abstract void a(float paramFloat);
  
  public abstract void a(int paramInt, @Nullable Throwable paramThrowable);
  
  public abstract void a(@Nullable String paramString);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.exporter.IExporter.ExportListener
 * JD-Core Version:    0.7.0.1
 */