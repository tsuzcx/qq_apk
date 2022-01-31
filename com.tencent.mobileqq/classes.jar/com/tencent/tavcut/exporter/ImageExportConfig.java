package com.tencent.tavcut.exporter;

import java.util.ArrayList;
import java.util.List;

public class ImageExportConfig
  extends ExportConfig
{
  private int maxExportSize = -1;
  private List<String> outputPaths = new ArrayList();
  private int quality = 100;
  
  public int getMaxExportSize()
  {
    return this.maxExportSize;
  }
  
  public List<String> getOutputPaths()
  {
    return this.outputPaths;
  }
  
  public int getQuality()
  {
    return this.quality;
  }
  
  public void setMaxExportSize(int paramInt)
  {
    this.maxExportSize = paramInt;
  }
  
  public void setOutputPath(List<String> paramList)
  {
    this.outputPaths = paramList;
  }
  
  public void setQuality(int paramInt)
  {
    this.quality = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.exporter.ImageExportConfig
 * JD-Core Version:    0.7.0.1
 */