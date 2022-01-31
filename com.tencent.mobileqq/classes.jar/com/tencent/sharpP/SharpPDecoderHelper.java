package com.tencent.sharpP;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;

public class SharpPDecoderHelper
{
  SharpPPathDecoder a;
  
  public SharpPDecoderHelper(String paramString)
  {
    this.a = new SharpPPathDecoder(paramString);
  }
  
  public int a()
  {
    try
    {
      int i = this.a.a();
      return i;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "parseHeader catch a UnsatisfiedLinkError:" + Log.getStackTraceString(localUnsatisfiedLinkError) });
    }
    return -1;
  }
  
  public Bitmap a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, SharpPDecoderWrapper.WriteableInteger paramWriteableInteger, Bitmap paramBitmap)
  {
    try
    {
      Bitmap localBitmap1 = this.a.a(paramInt1, paramInt2, paramInt3, paramInt4, paramWriteableInteger, paramBitmap);
      paramBitmap = localBitmap1;
      localBitmap1 = paramBitmap;
      if (paramBitmap == null)
      {
        this.a.a();
        localBitmap1 = this.a.a(paramInt1, paramInt2, paramInt3, paramInt4, paramWriteableInteger, paramBitmap);
      }
      this.a.a();
      return localBitmap1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP2GifFrame catch an OutOfMemoryError:" + Log.getStackTraceString(localOutOfMemoryError) });
      i = paramInt3 / 2;
    }
    finally
    {
      try
      {
        paramInt3 = paramInt4 / 2;
        Bitmap localBitmap2 = paramBitmap;
        if (paramBitmap == null)
        {
          this.a.a();
          localBitmap2 = this.a.a(paramInt1, paramInt2, i, paramInt3, paramWriteableInteger, paramBitmap);
        }
        this.a.a();
        return localBitmap2;
      }
      finally
      {
        int i;
        paramInt3 = i;
      }
      localObject1 = finally;
    }
    if (paramBitmap == null)
    {
      this.a.a();
      this.a.a(paramInt1, paramInt2, paramInt3, paramInt4, paramWriteableInteger, paramBitmap);
    }
    this.a.a();
    throw localObject1;
  }
  
  public Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    Object localObject3 = null;
    i = paramInt1;
    try
    {
      Bitmap localBitmap = this.a.a(paramInt1, paramInt2, paramConfig);
      localObject3 = localBitmap;
      if (localBitmap == null) {
        ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP error,retry once" });
      }
      try
      {
        this.a.a();
        localObject3 = this.a.a(paramInt1, paramInt2, paramConfig);
        this.a.a();
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
        this.a.a();
        this.a.a(i, paramInt2, paramConfig);
        this.a.a();
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
        this.a.a();
        localObject1 = this.a.a(paramInt1, j, paramConfig);
        this.a.a();
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
      this.a.a();
      return null;
    }
    finally
    {
      if (0 == 0) {
        ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP error,retry once" });
      }
    }
  }
  
  public SharpPDecoderWrapper.SharpPFeatureWrapper a()
  {
    return this.a.a();
  }
  
  public String a()
  {
    return this.a.a();
  }
  
  public void a(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public int b()
  {
    try
    {
      int i = this.a.b();
      return i;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "createDecoder catch a UnsatisfiedLinkError:" + Log.getStackTraceString(localUnsatisfiedLinkError) });
    }
    return -1;
  }
  
  public Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    Object localObject3 = null;
    i = paramInt1;
    try
    {
      Bitmap localBitmap = this.a.b(paramInt1, paramInt2, paramConfig);
      localObject3 = localBitmap;
      if (localBitmap == null) {
        ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP2PNG error,retry once" });
      }
      try
      {
        this.a.a();
        localObject3 = this.a.b(paramInt1, paramInt2, paramConfig);
        this.a.a();
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
        this.a.a();
        this.a.b(i, paramInt2, paramConfig);
        this.a.a();
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
        this.a.a();
        localObject1 = this.a.b(paramInt1, j, paramConfig);
        this.a.a();
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
      this.a.a();
      return null;
    }
    finally
    {
      if (0 == 0) {
        ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP2PNG error,retry once" });
      }
    }
  }
  
  public int c()
  {
    return this.a.c();
  }
  
  public Bitmap c(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    Object localObject3 = null;
    i = paramInt1;
    try
    {
      Bitmap localBitmap = this.a.c(paramInt1, paramInt2, paramConfig);
      localObject3 = localBitmap;
      if (localBitmap == null) {
        ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP2JPG error,retry once" });
      }
      try
      {
        this.a.a();
        localObject3 = this.a.c(paramInt1, paramInt2, paramConfig);
        this.a.a();
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
        this.a.a();
        this.a.c(i, paramInt2, paramConfig);
        this.a.a();
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
        this.a.a();
        localObject1 = this.a.c(paramInt1, j, paramConfig);
        this.a.a();
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
      this.a.a();
      return null;
    }
    finally
    {
      if (0 == 0) {
        ImageManagerEnv.getLogger().e("SharpPDecoderHelper", new Object[] { "decodeSharpP2JPG error,retry once" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sharpP.SharpPDecoderHelper
 * JD-Core Version:    0.7.0.1
 */