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
    int i = TextureLoader.1.$SwitchMap$android$graphics$Bitmap$Config[paramBitmap.getConfig().ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return Texture.Format.RGBA;
      }
      return Texture.Format.RGB;
    }
    return Texture.Format.ALPHA;
  }
  
  private static Texture.InternalFormat internalFormat(TextureLoader.TextureType paramTextureType)
  {
    int i = TextureLoader.1.$SwitchMap$com$tencent$ttpic$filament$TextureLoader$TextureType[paramTextureType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return Texture.InternalFormat.SRGB8_A8;
        }
        return Texture.InternalFormat.RGBA8;
      }
      return Texture.InternalFormat.RGBA8;
    }
    return Texture.InternalFormat.SRGB8_A8;
  }
  
  public static Texture loadTexture(Engine paramEngine, Resources paramResources, int paramInt, TextureLoader.TextureType paramTextureType)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    boolean bool;
    if (paramTextureType == TextureLoader.TextureType.COLOR) {
      bool = true;
    } else {
      bool = false;
    }
    localOptions.inPremultiplied = bool;
    return loadTexture(paramEngine, BitmapFactory.decodeResource(paramResources, paramInt, localOptions), paramTextureType);
  }
  
  public static Texture loadTexture(Engine paramEngine, Bitmap paramBitmap, TextureLoader.TextureType paramTextureType)
  {
    paramTextureType = new Texture.Builder().width(paramBitmap.getWidth()).height(paramBitmap.getHeight()).sampler(Texture.Sampler.SAMPLER_2D).format(internalFormat(paramTextureType)).levels(255).build(paramEngine);
    if (SKIP_BITMAP_COPY)
    {
      TextureHelper.setBitmap(paramEngine, paramTextureType, 0, paramBitmap);
    }
    else
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramBitmap.getByteCount());
      paramBitmap.copyPixelsToBuffer(localByteBuffer);
      localByteBuffer.flip();
      paramTextureType.setImage(paramEngine, 0, new Texture.PixelBufferDescriptor(localByteBuffer, format(paramBitmap), type(paramBitmap)));
    }
    paramTextureType.generateMipmaps(paramEngine);
    return paramTextureType;
  }
  
  public static Texture loadTexture(Engine paramEngine, String paramString, TextureLoader.TextureType paramTextureType)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    boolean bool;
    if (paramTextureType == TextureLoader.TextureType.COLOR) {
      bool = true;
    } else {
      bool = false;
    }
    localOptions.inPremultiplied = bool;
    paramString = BitmapFactory.decodeFile(paramString, localOptions);
    if (paramString == null) {
      return null;
    }
    return loadTexture(paramEngine, paramString, paramTextureType);
  }
  
  private static Texture.Type type(Bitmap paramBitmap)
  {
    if (TextureLoader.1.$SwitchMap$android$graphics$Bitmap$Config[paramBitmap.getConfig().ordinal()] != 3) {
      return Texture.Type.UBYTE;
    }
    return Texture.Type.HALF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filament.TextureLoader
 * JD-Core Version:    0.7.0.1
 */