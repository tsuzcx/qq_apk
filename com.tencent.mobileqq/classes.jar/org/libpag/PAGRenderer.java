package org.libpag;

import android.graphics.Matrix;
import org.extra.tools.LibraryLoadUtils;

public class PAGRenderer
{
  private long nativeContext = 0L;
  private PAGFile pagFile = null;
  private PAGSurface pagSurface = null;
  
  static
  {
    LibraryLoadUtils.loadLibrary("libpag");
    nativeInit();
    PAGFont.loadSystemFonts();
  }
  
  public PAGRenderer()
  {
    nativeSetup();
  }
  
  private native void nativeGetMatrix(float[] paramArrayOfFloat);
  
  private static final native void nativeInit();
  
  private final native void nativeRelease();
  
  private native void nativeReplaceImage(int paramInt, long paramLong);
  
  private native void nativeSetFile(long paramLong);
  
  private native void nativeSetMatrix(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6);
  
  private native void nativeSetSurface(long paramLong);
  
  private final native void nativeSetup();
  
  public native boolean cacheEnabled();
  
  public native float cacheScale();
  
  public native void draw();
  
  protected void finalize()
  {
    nativeRelease();
  }
  
  public boolean flush()
  {
    return flush(false);
  }
  
  public native boolean flush(boolean paramBoolean);
  
  public PAGFile getFile()
  {
    return this.pagFile;
  }
  
  public native PAGLayer[] getLayersUnderPoint(float paramFloat1, float paramFloat2);
  
  public native double getProgress();
  
  public native PAGComposition getRootComposition();
  
  public PAGSurface getSurface()
  {
    return this.pagSurface;
  }
  
  public Matrix matrix()
  {
    float[] arrayOfFloat = new float[9];
    nativeGetMatrix(arrayOfFloat);
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(arrayOfFloat);
    return localMatrix;
  }
  
  public native float maxFrameRate();
  
  public void replaceImage(int paramInt, PAGImage paramPAGImage)
  {
    if (paramPAGImage == null)
    {
      nativeReplaceImage(paramInt, 0L);
      return;
    }
    nativeReplaceImage(paramInt, paramPAGImage.nativeContext);
  }
  
  public native void reset();
  
  public native int scaleMode();
  
  public native void setCacheEnabled(boolean paramBoolean);
  
  public native void setCacheScale(float paramFloat);
  
  public void setFile(PAGFile paramPAGFile)
  {
    this.pagFile = paramPAGFile;
    if (paramPAGFile != null)
    {
      nativeSetFile(paramPAGFile.nativeContext);
      return;
    }
    nativeSetFile(0L);
  }
  
  public void setMatrix(Matrix paramMatrix)
  {
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    nativeSetMatrix(arrayOfFloat[0], arrayOfFloat[3], arrayOfFloat[1], arrayOfFloat[4], arrayOfFloat[2], arrayOfFloat[5]);
  }
  
  public native void setMaxFrameRate(float paramFloat);
  
  public native void setProgress(double paramDouble);
  
  public native void setScaleMode(int paramInt);
  
  public void setSurface(PAGSurface paramPAGSurface)
  {
    this.pagSurface = paramPAGSurface;
    if (paramPAGSurface == null)
    {
      nativeSetSurface(0L);
      return;
    }
    nativeSetSurface(paramPAGSurface.nativeSurface);
  }
  
  public native void setTextData(int paramInt, PAGText paramPAGText);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     org.libpag.PAGRenderer
 * JD-Core Version:    0.7.0.1
 */