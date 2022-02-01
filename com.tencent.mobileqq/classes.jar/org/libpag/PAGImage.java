package org.libpag;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.extra.tools.LibraryLoadUtils;

public class PAGImage
{
  private static final int AlphaType_Opaque = 1;
  private static final int AlphaType_Premul = 2;
  private static final int AlphaType_Unpremul = 3;
  private static final int ColorType_ARGB_4444 = 3;
  private static final int ColorType_Alpha_8 = 1;
  private static final int ColorType_BGRA_8888 = 5;
  private static final int ColorType_Gray_8 = 7;
  private static final int ColorType_Index_8 = 6;
  private static final int ColorType_RGBA_8888 = 4;
  private static final int ColorType_RGBA_F16 = 8;
  private static final int ColorType_RGB_565 = 2;
  long nativeContext = 0L;
  private byte[] pixels = null;
  
  static
  {
    LibraryLoadUtils.loadLibrary("libpag");
    nativeInit();
    PAGFont.loadSystemFonts();
  }
  
  PAGImage(long paramLong)
  {
    this.nativeContext = paramLong;
  }
  
  public static PAGImage FromAssets(AssetManager paramAssetManager, String paramString)
  {
    if ((paramAssetManager == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = paramAssetManager.open(paramString);
        paramAssetManager = BitmapFactory.decodeStream(paramString);
        if (paramString != null) {}
        try
        {
          paramString.close();
          if (paramAssetManager == null) {
            continue;
          }
          return FromBitmap(paramAssetManager);
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
          }
        }
        return null;
      }
      catch (IOException paramAssetManager) {}
    }
  }
  
  public static PAGImage FromBitmap(Bitmap paramBitmap)
  {
    int k = 1;
    if ((Build.VERSION.SDK_INT >= 26) && (paramBitmap.getConfig() == Bitmap.Config.HARDWARE)) {
      return null;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramBitmap.getHeight() * paramBitmap.getRowBytes());
    paramBitmap.copyPixelsToBuffer(localByteBuffer);
    Bitmap.Config localConfig2 = paramBitmap.getConfig();
    Bitmap.Config localConfig1 = localConfig2;
    if (localConfig2 == null) {
      localConfig1 = Bitmap.Config.ARGB_8888;
    }
    int i;
    int j;
    if (paramBitmap.isPremultiplied())
    {
      i = 2;
      switch (PAGImage.1.$SwitchMap$android$graphics$Bitmap$Config[localConfig1.ordinal()])
      {
      default: 
        k = 4;
        j = i;
        i = k;
      }
    }
    long l;
    for (;;)
    {
      l = LoadFromPixels(localByteBuffer.array(), paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getRowBytes(), i, j);
      if (l != 0L) {
        break label189;
      }
      return null;
      i = 3;
      break;
      j = i;
      i = k;
      continue;
      j = 1;
      i = 2;
      continue;
      k = 3;
      j = i;
      i = k;
      continue;
      k = 8;
      j = i;
      i = k;
    }
    label189:
    paramBitmap = new PAGImage(l);
    paramBitmap.pixels = localByteBuffer.array();
    return paramBitmap;
  }
  
  public static PAGImage FromBytes(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    do
    {
      return null;
      paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
    } while (paramArrayOfByte == null);
    return FromBitmap(paramArrayOfByte);
  }
  
  public static PAGImage FromPath(String paramString)
  {
    paramString = BitmapFactory.decodeFile(paramString);
    if (paramString == null) {
      return null;
    }
    return FromBitmap(paramString);
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
  
  private static native long LoadFromBytes(byte[] paramArrayOfByte, int paramInt);
  
  private static native long LoadFromPath(String paramString);
  
  private static native long LoadFromPixels(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.libpag.PAGImage
 * JD-Core Version:    0.7.0.1
 */