package org.libpag;

import android.graphics.Matrix;
import org.extra.tools.LibraryLoadUtils;

@Deprecated
public class PAGRenderer
{
  private long nativeContext = 0L;
  private PAGFile pagFile = null;
  private PAGSurface pagSurface = null;
  
  static
  {
    LibraryLoadUtils.loadLibrary("libpag");
    nativeInit();
  }
  
  @Deprecated
  public PAGRenderer()
  {
    nativeSetup();
  }
  
  private native void nativeFinalize();
  
  private native void nativeGetMatrix(float[] paramArrayOfFloat);
  
  private static final native void nativeInit();
  
  private final native void nativeRelease();
  
  private native void nativeReplaceImage(int paramInt, long paramLong);
  
  private native void nativeSetFile(long paramLong);
  
  private native void nativeSetMatrix(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6);
  
  private native void nativeSetSurface(long paramLong);
  
  private final native void nativeSetup();
  
  @Deprecated
  public native boolean cacheEnabled();
  
  @Deprecated
  public native float cacheScale();
  
  @Deprecated
  public native void draw();
  
  protected void finalize()
  {
    nativeFinalize();
  }
  
  @Deprecated
  public boolean flush()
  {
    return flush(false);
  }
  
  @Deprecated
  public native boolean flush(boolean paramBoolean);
  
  @Deprecated
  public PAGFile getFile()
  {
    return this.pagFile;
  }
  
  @Deprecated
  public native PAGLayer[] getLayersUnderPoint(float paramFloat1, float paramFloat2);
  
  @Deprecated
  public native double getProgress();
  
  @Deprecated
  public native PAGComposition getRootComposition();
  
  @Deprecated
  public PAGSurface getSurface()
  {
    return this.pagSurface;
  }
  
  @Deprecated
  public Matrix matrix()
  {
    float[] arrayOfFloat = new float[9];
    nativeGetMatrix(arrayOfFloat);
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(arrayOfFloat);
    return localMatrix;
  }
  
  @Deprecated
  public native float maxFrameRate();
  
  public void release()
  {
    nativeRelease();
  }
  
  @Deprecated
  public void replaceImage(int paramInt, PAGImage paramPAGImage)
  {
    if (paramPAGImage == null)
    {
      nativeReplaceImage(paramInt, 0L);
      return;
    }
    nativeReplaceImage(paramInt, paramPAGImage.nativeContext);
  }
  
  @Deprecated
  public native void reset();
  
  @Deprecated
  public native int scaleMode();
  
  @Deprecated
  public native void setCacheEnabled(boolean paramBoolean);
  
  @Deprecated
  public native void setCacheScale(float paramFloat);
  
  @Deprecated
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
  
  @Deprecated
  public void setMatrix(Matrix paramMatrix)
  {
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    nativeSetMatrix(arrayOfFloat[0], arrayOfFloat[3], arrayOfFloat[1], arrayOfFloat[4], arrayOfFloat[2], arrayOfFloat[5]);
  }
  
  @Deprecated
  public native void setMaxFrameRate(float paramFloat);
  
  @Deprecated
  public native void setProgress(double paramDouble);
  
  @Deprecated
  public native void setScaleMode(int paramInt);
  
  @Deprecated
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
  
  @Deprecated
  public native void setTextData(int paramInt, PAGText paramPAGText);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.libpag.PAGRenderer
 * JD-Core Version:    0.7.0.1
 */