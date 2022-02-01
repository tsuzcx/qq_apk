package com.tencent.tavcut.render.exporter;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/exporter/IExporter;", "", "cancelExport", "", "export", "exportOutput", "Lcom/tencent/tavcut/render/exporter/ExportOutput;", "destPath", "", "isExporting", "", "release", "setErrorInterceptor", "errorInterceptor", "Lcom/tencent/tavcut/render/exporter/IExporter$ExportErrorInterceptor;", "setExportListener", "listener", "Lcom/tencent/tavcut/render/exporter/IExporter$ExportListener;", "ExportErrorInterceptor", "ExportListener", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public abstract interface IExporter
{
  public abstract void a();
  
  public abstract void a(@NotNull ExportOutput paramExportOutput, @NotNull String paramString);
  
  public abstract void a(@Nullable IExporter.ExportListener paramExportListener);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.exporter.IExporter
 * JD-Core Version:    0.7.0.1
 */