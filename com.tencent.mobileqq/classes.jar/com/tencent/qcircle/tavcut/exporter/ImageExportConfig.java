package com.tencent.qcircle.tavcut.exporter;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.tav.coremedia.CGSize;
import java.util.ArrayList;
import java.util.List;

public class ImageExportConfig
  extends ExportConfig
{
  private Bitmap.CompressFormat format = Bitmap.CompressFormat.JPEG;
  private int maxExportSize = -1;
  private List<String> outputPaths = new ArrayList();
  private int quality = 100;
  private CGSize screenSize = null;
  
  public Bitmap.CompressFormat getFormat()
  {
    return this.format;
  }
  
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
  
  public CGSize getScreenSize()
  {
    return this.screenSize;
  }
  
  public void setFormat(Bitmap.CompressFormat paramCompressFormat)
  {
    this.format = paramCompressFormat;
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
  
  public void setScreenSize(CGSize paramCGSize)
  {
    this.screenSize = paramCGSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.exporter.ImageExportConfig
 * JD-Core Version:    0.7.0.1
 */