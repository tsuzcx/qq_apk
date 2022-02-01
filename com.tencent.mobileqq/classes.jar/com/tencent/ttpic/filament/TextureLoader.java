package com.tencent.ttpic.filament;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.google.android.filament.Engine;
import com.google.android.filament.Texture;
import com.google.android.filament.Texture.Builder;
import com.google.android.filament.Texture.Format;
import com.google.android.filament.Texture.InternalFormat;
import com.google.android.filament.Texture.PixelBufferDescriptor;
import com.google.android.filament.Texture.Sampler;
import com.google.android.filament.Texture.Type;
import com.google.android.filament.android.TextureHelper;
import java.nio.ByteBuffer;

public class TextureLoader
{
  public static boolean SKIP_BITMAP_COPY = true;
  
  private static Texture.Format format(Bitmap paramBitmap)
  {
    switch (TextureLoader.1.$SwitchMap$android$graphics$Bitmap$Config[paramBitmap.getConfig().ordinal()])
    {
    default: 
      return Texture.Format.RGBA;
    case 1: 
      return Texture.Format.ALPHA;
    }
    return Texture.Format.RGB;
  }
  
  private static Texture.InternalFormat internalFormat(TextureLoader.TextureType paramTextureType)
  {
    switch (TextureLoader.1.$SwitchMap$com$tencent$ttpic$filament$TextureLoader$TextureType[paramTextureType.ordinal()])
    {
    default: 
      return Texture.InternalFormat.SRGB8_A8;
    case 1: 
      return Texture.InternalFormat.SRGB8_A8;
    case 2: 
      return Texture.InternalFormat.RGBA8;
    }
    return Texture.InternalFormat.RGBA8;
  }
  
  public static Texture loadTexture(Engine paramEngine, Resources paramResources, int paramInt, TextureLoader.TextureType paramTextureType)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    if (paramTextureType == TextureLoader.TextureType.COLOR) {}
    for (boolean bool = true;; bool = false)
    {
      localOptions.inPremultiplied = bool;
      return loadTexture(paramEngine, BitmapFactory.decodeResource(paramResources, paramInt, localOptions), paramTextureType);
    }
  }
  
  public static Texture loadTexture(Engine paramEngine, Bitmap paramBitmap, TextureLoader.TextureType paramTextureType)
  {
    paramTextureType = new Texture.Builder().width(paramBitmap.getWidth()).height(paramBitmap.getHeight()).sampler(Texture.Sampler.SAMPLER_2D).format(internalFormat(paramTextureType)).levels(255).build(paramEngine);
    if (SKIP_BITMAP_COPY) {
      TextureHelper.setBitmap(paramEngine, paramTextureType, 0, paramBitmap);
    }
    for (;;)
    {
      paramTextureType.generateMipmaps(paramEngine);
      return paramTextureType;
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramBitmap.getByteCount());
      paramBitmap.copyPixelsToBuffer(localByteBuffer);
      localByteBuffer.flip();
      paramTextureType.setImage(paramEngine, 0, new Texture.PixelBufferDescriptor(localByteBuffer, format(paramBitmap), type(paramBitmap)));
    }
  }
  
  public static Texture loadTexture(Engine paramEngine, String paramString, TextureLoader.TextureType paramTextureType)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    if (paramTextureType == TextureLoader.TextureType.COLOR) {}
    for (boolean bool = true;; bool = false)
    {
      localOptions.inPremultiplied = bool;
      paramString = BitmapFactory.decodeFile(paramString, localOptions);
      if (paramString != null) {
        break;
      }
      return null;
    }
    return loadTexture(paramEngine, paramString, paramTextureType);
  }
  
  private static Texture.Type type(Bitmap paramBitmap)
  {
    switch (TextureLoader.1.$SwitchMap$android$graphics$Bitmap$Config[paramBitmap.getConfig().ordinal()])
    {
    default: 
      return Texture.Type.UBYTE;
    }
    return Texture.Type.HALF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filament.TextureLoader
 * JD-Core Version:    0.7.0.1
 */