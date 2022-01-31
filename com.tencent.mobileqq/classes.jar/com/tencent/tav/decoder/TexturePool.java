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
    Logger.d("TexturePool", "TexturePool: create " + Thread.currentThread().getId());
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
      throw localObject;
    }
  }
  
  private void adapterCacheMemorySize()
  {
    long l = 0L;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.textureInfoList.size())
        {
          TextureInfo localTextureInfo = (TextureInfo)this.textureInfoList.get(i);
          l += localTextureInfo.width * localTextureInfo.height;
          if (l > this.MaxCacheSize)
          {
            Logger.d("TexturePool", "texture: release " + localTextureInfo + " - " + Thread.currentThread());
            localTextureInfo.release();
            this.textureInfoList.remove(i);
            i -= 1;
            i += 1;
          }
        }
        else
        {
          return;
        }
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
  
  /* Error */
  public TextureInfo popTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore 4
    //   5: iload 4
    //   7: aload_0
    //   8: getfield 26	com/tencent/tav/decoder/TexturePool:textureInfoList	Ljava/util/List;
    //   11: invokeinterface 72 1 0
    //   16: if_icmpge +104 -> 120
    //   19: aload_0
    //   20: getfield 26	com/tencent/tav/decoder/TexturePool:textureInfoList	Ljava/util/List;
    //   23: iload 4
    //   25: invokeinterface 76 2 0
    //   30: checkcast 78	com/tencent/tav/coremedia/TextureInfo
    //   33: astore 5
    //   35: aload 5
    //   37: getfield 103	com/tencent/tav/coremedia/TextureInfo:textureType	I
    //   40: iload_1
    //   41: if_icmpne +70 -> 111
    //   44: aload 5
    //   46: getfield 88	com/tencent/tav/coremedia/TextureInfo:width	I
    //   49: iload_2
    //   50: if_icmpne +61 -> 111
    //   53: aload 5
    //   55: getfield 91	com/tencent/tav/coremedia/TextureInfo:height	I
    //   58: iload_3
    //   59: if_icmpne +52 -> 111
    //   62: ldc 10
    //   64: new 34	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   71: ldc 105
    //   73: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload 5
    //   78: getfield 108	com/tencent/tav/coremedia/TextureInfo:textureID	I
    //   81: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 64	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_0
    //   91: getfield 26	com/tencent/tav/decoder/TexturePool:textureInfoList	Ljava/util/List;
    //   94: iload 4
    //   96: invokeinterface 84 2 0
    //   101: checkcast 78	com/tencent/tav/coremedia/TextureInfo
    //   104: astore 5
    //   106: aload_0
    //   107: monitorexit
    //   108: aload 5
    //   110: areturn
    //   111: iload 4
    //   113: iconst_1
    //   114: iadd
    //   115: istore 4
    //   117: goto -112 -> 5
    //   120: iload_1
    //   121: invokestatic 117	com/tencent/tav/decoder/RenderContext:createTexture	(I)I
    //   124: istore_1
    //   125: aload_0
    //   126: invokespecial 119	com/tencent/tav/decoder/TexturePool:adaptCacheSize	()V
    //   129: aload_0
    //   130: invokespecial 121	com/tencent/tav/decoder/TexturePool:adapterCacheMemorySize	()V
    //   133: new 78	com/tencent/tav/coremedia/TextureInfo
    //   136: dup
    //   137: iload_1
    //   138: sipush 3553
    //   141: iload_2
    //   142: iload_3
    //   143: aconst_null
    //   144: iconst_0
    //   145: invokespecial 124	com/tencent/tav/coremedia/TextureInfo:<init>	(IIIILandroid/graphics/Matrix;I)V
    //   148: astore 5
    //   150: goto -44 -> 106
    //   153: astore 5
    //   155: aload_0
    //   156: monitorexit
    //   157: aload 5
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	TexturePool
    //   0	160	1	paramInt1	int
    //   0	160	2	paramInt2	int
    //   0	160	3	paramInt3	int
    //   3	113	4	i	int
    //   33	116	5	localTextureInfo	TextureInfo
    //   153	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	106	153	finally
    //   120	150	153	finally
  }
  
  /* Error */
  public void pushTexture(TextureInfo paramTextureInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: iload_2
    //   5: aload_0
    //   6: getfield 26	com/tencent/tav/decoder/TexturePool:textureInfoList	Ljava/util/List;
    //   9: invokeinterface 72 1 0
    //   14: if_icmpge +80 -> 94
    //   17: aload_0
    //   18: getfield 26	com/tencent/tav/decoder/TexturePool:textureInfoList	Ljava/util/List;
    //   21: iload_2
    //   22: invokeinterface 76 2 0
    //   27: checkcast 78	com/tencent/tav/coremedia/TextureInfo
    //   30: astore_3
    //   31: aload_3
    //   32: getfield 103	com/tencent/tav/coremedia/TextureInfo:textureType	I
    //   35: aload_1
    //   36: getfield 103	com/tencent/tav/coremedia/TextureInfo:textureType	I
    //   39: if_icmpne +48 -> 87
    //   42: aload_3
    //   43: getfield 108	com/tencent/tav/coremedia/TextureInfo:textureID	I
    //   46: aload_1
    //   47: getfield 108	com/tencent/tav/coremedia/TextureInfo:textureID	I
    //   50: if_icmpne +37 -> 87
    //   53: ldc 10
    //   55: new 34	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   62: ldc 128
    //   64: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_3
    //   68: getfield 108	com/tencent/tav/coremedia/TextureInfo:textureID	I
    //   71: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 64	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: aload_1
    //   81: invokevirtual 81	com/tencent/tav/coremedia/TextureInfo:release	()V
    //   84: aload_0
    //   85: monitorexit
    //   86: return
    //   87: iload_2
    //   88: iconst_1
    //   89: iadd
    //   90: istore_2
    //   91: goto -87 -> 4
    //   94: ldc 10
    //   96: new 34	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   103: ldc 130
    //   105: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_1
    //   109: getfield 108	com/tencent/tav/coremedia/TextureInfo:textureID	I
    //   112: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: ldc 98
    //   117: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokestatic 47	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   123: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 64	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload_0
    //   133: getfield 26	com/tencent/tav/decoder/TexturePool:textureInfoList	Ljava/util/List;
    //   136: aload_1
    //   137: invokeinterface 134 2 0
    //   142: pop
    //   143: goto -59 -> 84
    //   146: astore_1
    //   147: aload_0
    //   148: monitorexit
    //   149: aload_1
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	TexturePool
    //   0	151	1	paramTextureInfo	TextureInfo
    //   3	88	2	i	int
    //   30	38	3	localTextureInfo	TextureInfo
    // Exception table:
    //   from	to	target	type
    //   4	84	146	finally
    //   94	143	146	finally
  }
  
  public void release()
  {
    try
    {
      Logger.d("TexturePool", " release all " + Thread.currentThread().getId());
      int i = 0;
      while (i < this.textureInfoList.size())
      {
        ((TextureInfo)this.textureInfoList.get(i)).release();
        i += 1;
      }
      return;
    }
    finally {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.decoder.TexturePool
 * JD-Core Version:    0.7.0.1
 */