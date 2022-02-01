package com.tencent.tav.decoder;

import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;
import java.util.List;

public class TexturePool
  implements ITexturePool
{
  private static final String TAG = "TexturePool";
  private int MaxCacheLength = 60;
  private long MaxCacheSize = 207360000L;
  private List<TextureInfo> textureInfoList = new ArrayList();
  
  public TexturePool()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TexturePool: create ");
    localStringBuilder.append(Thread.currentThread().getId());
    Logger.d("TexturePool", localStringBuilder.toString());
  }
  
  private void adaptCacheSize()
  {
    try
    {
      while ((this.textureInfoList.size() > 0) && (this.textureInfoList.size() - this.MaxCacheLength > 0))
      {
        ((TextureInfo)this.textureInfoList.get(0)).release();
        this.textureInfoList.remove(0);
      }
      return;
    }
    finally
    {
      localObject = finally;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void adapterCacheMemorySize()
  {
    long l = 0L;
    int i = 0;
    try
    {
      while (i < this.textureInfoList.size())
      {
        TextureInfo localTextureInfo = (TextureInfo)this.textureInfoList.get(i);
        l += localTextureInfo.width * localTextureInfo.height;
        int j = i;
        if (l > this.MaxCacheSize)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("texture: release ");
          localStringBuilder.append(localTextureInfo);
          localStringBuilder.append(" - ");
          localStringBuilder.append(Thread.currentThread());
          Logger.v("TexturePool", localStringBuilder.toString());
          localTextureInfo.release();
          this.textureInfoList.remove(i);
          j = i - 1;
        }
        i = j + 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public TextureInfo popTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    try
    {
      while (i < this.textureInfoList.size())
      {
        localTextureInfo = (TextureInfo)this.textureInfoList.get(i);
        if ((localTextureInfo.textureType == paramInt1) && (localTextureInfo.width == paramInt2) && (localTextureInfo.height == paramInt3))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("popTexture: hint pool ");
          localStringBuilder.append(localTextureInfo.textureID);
          Logger.v("TexturePool", localStringBuilder.toString());
          localTextureInfo = (TextureInfo)this.textureInfoList.remove(i);
          return localTextureInfo;
        }
        i += 1;
      }
      paramInt1 = RenderContext.createTexture(paramInt1);
      adaptCacheSize();
      adapterCacheMemorySize();
      TextureInfo localTextureInfo = new TextureInfo(paramInt1, 3553, paramInt2, paramInt3, null, 0);
      return localTextureInfo;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void pushTexture(TextureInfo paramTextureInfo)
  {
    int i = 0;
    try
    {
      while (i < this.textureInfoList.size())
      {
        localObject = (TextureInfo)this.textureInfoList.get(i);
        if ((((TextureInfo)localObject).textureType == paramTextureInfo.textureType) && (((TextureInfo)localObject).textureID == paramTextureInfo.textureID))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("pushTexture: hint pool  ");
          localStringBuilder.append(((TextureInfo)localObject).textureID);
          Logger.v("TexturePool", localStringBuilder.toString());
          paramTextureInfo.release();
          return;
        }
        i += 1;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pushTexture: push in ");
      ((StringBuilder)localObject).append(paramTextureInfo.textureID);
      ((StringBuilder)localObject).append(" - ");
      ((StringBuilder)localObject).append(Thread.currentThread());
      Logger.v("TexturePool", ((StringBuilder)localObject).toString());
      this.textureInfoList.add(paramTextureInfo);
      return;
    }
    finally {}
    for (;;)
    {
      throw paramTextureInfo;
    }
  }
  
  public void release()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" release all ");
      localStringBuilder.append(Thread.currentThread().getId());
      Logger.d("TexturePool", localStringBuilder.toString());
      int i = 0;
      while (i < this.textureInfoList.size())
      {
        ((TextureInfo)this.textureInfoList.get(i)).release();
        i += 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void setMaxCacheLength(int paramInt)
  {
    this.MaxCacheLength = paramInt;
    adapterCacheMemorySize();
  }
  
  public void setMaxCacheSize(long paramLong)
  {
    this.MaxCacheSize = paramLong;
    adaptCacheSize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.TexturePool
 * JD-Core Version:    0.7.0.1
 */