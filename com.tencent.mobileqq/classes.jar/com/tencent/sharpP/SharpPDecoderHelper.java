package com.tencent.sharpP;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;

public class SharpPDecoderHelper
{
  public static final String TAG = "SharpPDecoderHelper";
  SharpPPathDecoder mDecoder;
  
  public SharpPDecoderHelper(String paramString)
  {
    this.mDecoder = new SharpPPathDecoder(paramString);
  }
  
  public void closeDecoder()
  {
    this.mDecoder.closeDecoder();
  }
  
  public void closeDecoder(long paramLong)
  {
    this.mDecoder.closeDecoder(paramLong);
  }
  
  public long createDecoder()
  {
    try
    {
      long l = this.mDecoder.createDecoder();
      return l;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "createDecoder catch a UnsatisfiedLinkError:" + Log.getStackTraceString(localUnsatisfiedLinkError) });
    }
    return -1L;
  }
  
  public Bitmap decodeSharpP(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    Object localObject3 = null;
    i = paramInt1;
    try
    {
      Bitmap localBitmap = this.mDecoder.decodeSharpP(paramInt1, paramInt2, paramConfig);
      localObject3 = localBitmap;
      if (localBitmap == null) {
        ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP error,retry once" });
      }
      try
      {
        this.mDecoder.closeDecoder();
        localObject3 = this.mDecoder.decodeSharpP(paramInt1, paramInt2, paramConfig);
        this.mDecoder.closeDecoder();
        return localObject3;
      }
      catch (OutOfMemoryError paramConfig)
      {
        for (;;)
        {
          ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP error,retry once failed," + Log.getStackTraceString(paramConfig) });
          localObject3 = localBitmap;
        }
      }
      try
      {
        int j;
        Object localObject1;
        this.mDecoder.closeDecoder();
        this.mDecoder.decodeSharpP(i, paramInt2, paramConfig);
        this.mDecoder.closeDecoder();
        throw localObject2;
      }
      catch (OutOfMemoryError paramConfig)
      {
        for (;;)
        {
          ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP error,retry once failed," + Log.getStackTraceString(paramConfig) });
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      i = paramInt1;
      ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP catch a OutOfMemoryError." });
      i = paramInt1;
      paramInt1 /= 2;
      i = paramInt1;
      j = paramInt2 / 2;
      localObject1 = localObject3;
      if (0 == 0) {
        ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP error,retry once" });
      }
      try
      {
        this.mDecoder.closeDecoder();
        localObject1 = this.mDecoder.decodeSharpP(paramInt1, j, paramConfig);
        this.mDecoder.closeDecoder();
        return localObject1;
      }
      catch (OutOfMemoryError paramConfig)
      {
        for (;;)
        {
          ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP error,retry once failed," + Log.getStackTraceString(paramConfig) });
          localObject1 = localObject3;
        }
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      i = paramInt1;
      ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP catch a UnsatisfiedLinkError:" + Log.getStackTraceString(localUnsatisfiedLinkError) });
      if (0 == 0) {}
      this.mDecoder.closeDecoder();
      return null;
    }
    finally
    {
      if (0 == 0) {
        ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP error,retry once" });
      }
    }
  }
  
  public Bitmap decodeSharpP2GifFrame(long paramLong, int paramInt1, int paramInt2, int paramInt3, SharpPDecoderWrapper.WriteableInteger paramWriteableInteger, Bitmap paramBitmap)
  {
    try
    {
      Bitmap localBitmap1 = this.mDecoder.decodeSharpP2GifFrame(paramLong, paramInt1, paramInt2, paramInt3, paramWriteableInteger, paramBitmap);
      paramBitmap = localBitmap1;
      localBitmap1 = paramBitmap;
      if (paramBitmap == null)
      {
        this.mDecoder.closeDecoder();
        localBitmap1 = this.mDecoder.decodeSharpP2GifFrame(paramLong, paramInt1, paramInt2, paramInt3, paramWriteableInteger, paramBitmap);
      }
      this.mDecoder.closeDecoder();
      return localBitmap1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError = localOutOfMemoryError;
      ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP2GifFrame catch an OutOfMemoryError:" + Log.getStackTraceString(localOutOfMemoryError) });
      i = paramInt2 / 2;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      try
      {
        paramInt2 = paramInt3 / 2;
        Bitmap localBitmap2 = paramBitmap;
        if (paramBitmap == null)
        {
          this.mDecoder.closeDecoder();
          localBitmap2 = this.mDecoder.decodeSharpP2GifFrame(paramLong, paramInt1, i, paramInt2, paramWriteableInteger, paramBitmap);
        }
        this.mDecoder.closeDecoder();
        return localBitmap2;
      }
      finally
      {
        int i;
        Bitmap localBitmap3;
        paramInt2 = i;
      }
      localUnsatisfiedLinkError = localUnsatisfiedLinkError;
      ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP2GifFrame catch a UnsatisfiedLinkError:" + Log.getStackTraceString(localUnsatisfiedLinkError) });
      localBitmap3 = paramBitmap;
      if (paramBitmap == null)
      {
        this.mDecoder.closeDecoder();
        localBitmap3 = this.mDecoder.decodeSharpP2GifFrame(paramLong, paramInt1, paramInt2, paramInt3, paramWriteableInteger, paramBitmap);
      }
      this.mDecoder.closeDecoder();
      return localBitmap3;
    }
    finally {}
    if (paramBitmap == null)
    {
      this.mDecoder.closeDecoder();
      this.mDecoder.decodeSharpP2GifFrame(paramLong, paramInt1, paramInt2, paramInt3, paramWriteableInteger, paramBitmap);
    }
    this.mDecoder.closeDecoder();
    throw localObject1;
  }
  
  public Bitmap decodeSharpP2JPG(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    Object localObject3 = null;
    i = paramInt1;
    try
    {
      Bitmap localBitmap = this.mDecoder.decodeSharpP2JPG(paramInt1, paramInt2, paramConfig);
      localObject3 = localBitmap;
      if (localBitmap == null) {
        ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP2JPG error,retry once" });
      }
      try
      {
        this.mDecoder.closeDecoder();
        localObject3 = this.mDecoder.decodeSharpP2JPG(paramInt1, paramInt2, paramConfig);
        this.mDecoder.closeDecoder();
        return localObject3;
      }
      catch (OutOfMemoryError paramConfig)
      {
        for (;;)
        {
          ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP2PNG error,retry once failed," + Log.getStackTraceString(paramConfig) });
          localObject3 = localBitmap;
        }
      }
      try
      {
        int j;
        Object localObject1;
        this.mDecoder.closeDecoder();
        this.mDecoder.decodeSharpP2JPG(i, paramInt2, paramConfig);
        this.mDecoder.closeDecoder();
        throw localObject2;
      }
      catch (OutOfMemoryError paramConfig)
      {
        for (;;)
        {
          ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP2PNG error,retry once failed," + Log.getStackTraceString(paramConfig) });
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      i = paramInt1;
      ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP2JPG catch a OutOfMemoryError:" + Log.getStackTraceString(localOutOfMemoryError) });
      i = paramInt1;
      paramInt1 /= 2;
      i = paramInt1;
      j = paramInt2 / 2;
      localObject1 = localObject3;
      if (0 == 0) {
        ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP2JPG error,retry once" });
      }
      try
      {
        this.mDecoder.closeDecoder();
        localObject1 = this.mDecoder.decodeSharpP2JPG(paramInt1, j, paramConfig);
        this.mDecoder.closeDecoder();
        return localObject1;
      }
      catch (OutOfMemoryError paramConfig)
      {
        for (;;)
        {
          ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP2PNG error,retry once failed," + Log.getStackTraceString(paramConfig) });
          localObject1 = localObject3;
        }
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      i = paramInt1;
      ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP2JPG catch a UnsatisfiedLinkError:" + Log.getStackTraceString(localUnsatisfiedLinkError) });
      if (0 == 0) {}
      this.mDecoder.closeDecoder();
      return null;
    }
    finally
    {
      if (0 == 0) {
        ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP2JPG error,retry once" });
      }
    }
  }
  
  public Bitmap decodeSharpP2PNG(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    Object localObject3 = null;
    i = paramInt1;
    try
    {
      Bitmap localBitmap = this.mDecoder.decodeSharpP2PNG(paramInt1, paramInt2, paramConfig);
      localObject3 = localBitmap;
      if (localBitmap == null) {
        ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP2PNG error,retry once" });
      }
      try
      {
        this.mDecoder.closeDecoder();
        localObject3 = this.mDecoder.decodeSharpP2PNG(paramInt1, paramInt2, paramConfig);
        this.mDecoder.closeDecoder();
        return localObject3;
      }
      catch (OutOfMemoryError paramConfig)
      {
        for (;;)
        {
          ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP2PNG error,retry once failed," + Log.getStackTraceString(paramConfig) });
          localObject3 = localBitmap;
        }
      }
      try
      {
        int j;
        Object localObject1;
        this.mDecoder.closeDecoder();
        this.mDecoder.decodeSharpP2PNG(i, paramInt2, paramConfig);
        this.mDecoder.closeDecoder();
        throw localObject2;
      }
      catch (OutOfMemoryError paramConfig)
      {
        for (;;)
        {
          ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP2PNG error,retry once failed," + Log.getStackTraceString(paramConfig) });
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      i = paramInt1;
      ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP2PNG catch a OutOfMemoryError:" + Log.getStackTraceString(localOutOfMemoryError) });
      i = paramInt1;
      paramInt1 /= 2;
      i = paramInt1;
      j = paramInt2 / 2;
      localObject1 = localObject3;
      if (0 == 0) {
        ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP2PNG error,retry once" });
      }
      try
      {
        this.mDecoder.closeDecoder();
        localObject1 = this.mDecoder.decodeSharpP2PNG(paramInt1, j, paramConfig);
        this.mDecoder.closeDecoder();
        return localObject1;
      }
      catch (OutOfMemoryError paramConfig)
      {
        for (;;)
        {
          ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP2PNG error,retry once failed," + Log.getStackTraceString(paramConfig) });
          localObject1 = localObject3;
        }
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      i = paramInt1;
      ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP2PNG catch a UnsatisfiedLinkError:" + Log.getStackTraceString(localUnsatisfiedLinkError) });
      if (0 == 0) {}
      this.mDecoder.closeDecoder();
      return null;
    }
    finally
    {
      if (0 == 0) {
        ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP2PNG error,retry once" });
      }
    }
  }
  
  public int getAllocationByteCount()
  {
    return this.mDecoder.getAllocationByteCount();
  }
  
  public SharpPDecoderWrapper.SharpPFeatureWrapper getFeatureInfo()
  {
    return this.mDecoder.getFeatureInfo();
  }
  
  public String getMimeType()
  {
    return this.mDecoder.getMimeType();
  }
  
  public int parseHeader()
  {
    try
    {
      int i = this.mDecoder.parseHeader();
      return i;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "parseHeader catch a UnsatisfiedLinkError:" + Log.getStackTraceString(localUnsatisfiedLinkError) });
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.sharpP.SharpPDecoderHelper
 * JD-Core Version:    0.7.0.1
 */