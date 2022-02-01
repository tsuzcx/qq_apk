package org.libpag;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import org.extra.tools.LibraryLoadUtils;

public class PAGImage
{
  long nativeContext = 0L;
  
  static
  {
    LibraryLoadUtils.loadLibrary("libpag");
    nativeInit();
  }
  
  PAGImage(long paramLong)
  {
    this.nativeContext = paramLong;
  }
  
  public static PAGImage FromAssets(AssetManager paramAssetManager, String paramString)
  {
    long l = LoadFromAssets(paramAssetManager, paramString);
    if (l == 0L) {
      return null;
    }
    return new PAGImage(l);
  }
  
  public static PAGImage FromBitmap(Bitmap paramBitmap)
  {
    long l = LoadFromBitmap(paramBitmap);
    if (l == 0L) {
      return null;
    }
    return new PAGImage(l);
  }
  
  public static PAGImage FromBytes(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return null;
      }
      long l = LoadFromBytes(paramArrayOfByte, paramArrayOfByte.length);
      if (l == 0L) {
        return null;
      }
      return new PAGImage(l);
    }
    return null;
  }
  
  public static PAGImage FromPath(String paramString)
  {
    long l = LoadFromPath(paramString);
    if (l == 0L) {
      return null;
    }
    return new PAGImage(l);
  }
  
  public static PAGImage FromTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return FromTexture(paramInt1, paramInt2, paramInt3, paramInt4, false);
  }
  
  public static PAGImage FromTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    long l = LoadFromTexture(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
    if (l == 0L) {
      return null;
    }
    return new PAGImage(l);
  }
  
  private static native long LoadFromAssets(AssetManager paramAssetManager, String paramString);
  
  private static native long LoadFromBitmap(Bitmap paramBitmap);
  
  private static native long LoadFromBytes(byte[] paramArrayOfByte, int paramInt);
  
  private static native long LoadFromPath(String paramString);
  
  private static native long LoadFromTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean);
  
  private native void nativeFinalize();
  
  private native void nativeGetMatrix(float[] paramArrayOfFloat);
  
  private static final native void nativeInit();
  
  private final native void nativeRelease();
  
  private native void nativeSetMatrix(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6);
  
  protected void finalize()
  {
    nativeFinalize();
  }
  
  public native int height();
  
  public Matrix matrix()
  {
    float[] arrayOfFloat = new float[9];
    nativeGetMatrix(arrayOfFloat);
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(arrayOfFloat);
    return localMatrix;
  }
  
  public void release()
  {
    nativeRelease();
  }
  
  public native int scaleMode();
  
  public void setMatrix(Matrix paramMatrix)
  {
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    nativeSetMatrix(arrayOfFloat[0], arrayOfFloat[3], arrayOfFloat[1], arrayOfFloat[4], arrayOfFloat[2], arrayOfFloat[5]);
  }
  
  public native void setScaleMode(int paramInt);
  
  public native int width();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.libpag.PAGImage
 * JD-Core Version:    0.7.0.1
 */