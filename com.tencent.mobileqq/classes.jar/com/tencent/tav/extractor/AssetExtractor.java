package com.tencent.tav.extractor;

import android.content.res.AssetFileDescriptor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.ResourceLoadUtil;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.DecoderUtils;
import java.io.FileDescriptor;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.Map;

public class AssetExtractor
  implements Cloneable
{
  public static boolean DOWNGRADING = false;
  public static final int SAMPLE_FLAG_ENCRYPTED = 2;
  public static final int SAMPLE_FLAG_SYNC = 1;
  public static final int SEEK_TO_CLOSEST_SYNC = 2;
  public static final int SEEK_TO_NEXT_SYNC = 1;
  public static final int SEEK_TO_PREVIOUS_SYNC = 0;
  @Nullable
  private IAssetExtractorDelegate delegate;
  private long duration = 0L;
  private long mNativeContext = 0L;
  private int preferRotation = -1;
  private boolean released = false;
  private CGSize size = null;
  private String sourcePath = "";
  
  static
  {
    if (ResourceLoadUtil.isLoaded())
    {
      nativeInit();
      return;
    }
    System.out.println("loadlibrary : tav start");
    try
    {
      System.loadLibrary("tav");
      ResourceLoadUtil.setLoaded(true);
      nativeInit();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public AssetExtractor()
  {
    this(DOWNGRADING);
  }
  
  public AssetExtractor(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.delegate = new ApiAssetExtractorDelegate();
    }
  }
  
  private synchronized native boolean advanceNative();
  
  private synchronized native long getSampleTimeNative();
  
  private synchronized native int getSampleTrackIndexNative();
  
  private final synchronized native int getTrackCountNative();
  
  @NonNull
  private synchronized native Map<String, Object> getTrackFormatNative(int paramInt);
  
  private final synchronized native void nativeFinalize();
  
  private static final synchronized native void nativeInit();
  
  private synchronized native int readSampleDataNative(@NonNull ByteBuffer paramByteBuffer, int paramInt);
  
  private final synchronized native void releaseNative();
  
  private native void seekToNative(long paramLong, int paramInt);
  
  private synchronized native void selectTrackNative(int paramInt);
  
  private synchronized native void unselectTrackNative(int paramInt);
  
  /* Error */
  public boolean advance()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 95	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: getfield 95	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   13: invokeinterface 118 1 0
    //   18: istore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_1
    //   22: ireturn
    //   23: aload_0
    //   24: getfield 78	com/tencent/tav/extractor/AssetExtractor:released	Z
    //   27: ifne +11 -> 38
    //   30: aload_0
    //   31: invokespecial 120	com/tencent/tav/extractor/AssetExtractor:advanceNative	()Z
    //   34: istore_1
    //   35: goto -16 -> 19
    //   38: iconst_0
    //   39: istore_1
    //   40: goto -21 -> 19
    //   43: astore_2
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_2
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	AssetExtractor
    //   18	22	1	bool	boolean
    //   43	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	43	finally
    //   23	35	43	finally
  }
  
  public AssetExtractor clone()
  {
    AssetExtractor localAssetExtractor = new AssetExtractor();
    localAssetExtractor.setSize(getSize());
    localAssetExtractor.setPreferRotation(getPreferRotation());
    localAssetExtractor.setDuration(getDuration());
    localAssetExtractor.setDataSource(this.sourcePath);
    return localAssetExtractor;
  }
  
  /* Error */
  public void dispose()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 84	com/tencent/tav/extractor/AssetExtractor:sourcePath	Ljava/lang/String;
    //   6: invokevirtual 156	java/lang/String:isEmpty	()Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifeq +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 78	com/tencent/tav/extractor/AssetExtractor:released	Z
    //   21: ifne -7 -> 14
    //   24: aload_0
    //   25: getfield 95	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   28: ifnonnull -14 -> 14
    //   31: aload_0
    //   32: invokespecial 158	com/tencent/tav/extractor/AssetExtractor:releaseNative	()V
    //   35: goto -21 -> 14
    //   38: astore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_2
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	AssetExtractor
    //   9	2	1	bool	boolean
    //   38	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	38	finally
    //   17	35	38	finally
  }
  
  protected void finalize()
  {
    if (this.delegate != null) {}
    while (this.released) {
      return;
    }
    try
    {
      if (!this.released)
      {
        this.released = true;
        nativeFinalize();
      }
      return;
    }
    finally {}
  }
  
  public long getAudioDuration()
  {
    try
    {
      long l = DecoderUtils.getAudioDuration(this);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getDuration()
  {
    try
    {
      if (this.duration == 0L) {
        this.duration = DecoderUtils.getDuration(this);
      }
      long l = this.duration;
      return l;
    }
    finally {}
  }
  
  public int getPreferRotation()
  {
    try
    {
      if (this.preferRotation == -1) {
        this.preferRotation = ExtractorUtils.getPreferRotation(this);
      }
      int i = this.preferRotation;
      return i;
    }
    finally {}
  }
  
  public native int getSampleFlags();
  
  /* Error */
  public long getSampleTime()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 95	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: getfield 95	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   13: invokeinterface 178 1 0
    //   18: lstore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: lload_1
    //   22: lreturn
    //   23: aload_0
    //   24: getfield 78	com/tencent/tav/extractor/AssetExtractor:released	Z
    //   27: ifne +11 -> 38
    //   30: aload_0
    //   31: invokespecial 180	com/tencent/tav/extractor/AssetExtractor:getSampleTimeNative	()J
    //   34: lstore_1
    //   35: goto -16 -> 19
    //   38: ldc2_w 181
    //   41: lstore_1
    //   42: goto -23 -> 19
    //   45: astore_3
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_3
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	AssetExtractor
    //   18	24	1	l	long
    //   45	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	45	finally
    //   23	35	45	finally
  }
  
  /* Error */
  public int getSampleTrackIndex()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 95	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: getfield 95	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   13: invokeinterface 185 1 0
    //   18: istore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_1
    //   22: ireturn
    //   23: aload_0
    //   24: getfield 78	com/tencent/tav/extractor/AssetExtractor:released	Z
    //   27: ifne +11 -> 38
    //   30: aload_0
    //   31: invokespecial 187	com/tencent/tav/extractor/AssetExtractor:getSampleTrackIndexNative	()I
    //   34: istore_1
    //   35: goto -16 -> 19
    //   38: iconst_m1
    //   39: istore_1
    //   40: goto -21 -> 19
    //   43: astore_2
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_2
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	AssetExtractor
    //   18	22	1	i	int
    //   43	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	43	finally
    //   23	35	43	finally
  }
  
  public CGSize getSize()
  {
    try
    {
      if (this.size == null) {
        this.size = ExtractorUtils.getVideoSize(this);
      }
      CGSize localCGSize = this.size;
      return localCGSize;
    }
    finally {}
  }
  
  public String getSourcePath()
  {
    return this.sourcePath;
  }
  
  /* Error */
  public final int getTrackCount()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 95	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: getfield 95	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   13: invokeinterface 196 1 0
    //   18: istore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_1
    //   22: ireturn
    //   23: aload_0
    //   24: getfield 78	com/tencent/tav/extractor/AssetExtractor:released	Z
    //   27: ifne +11 -> 38
    //   30: aload_0
    //   31: invokespecial 198	com/tencent/tav/extractor/AssetExtractor:getTrackCountNative	()I
    //   34: istore_1
    //   35: goto -16 -> 19
    //   38: iconst_0
    //   39: istore_1
    //   40: goto -21 -> 19
    //   43: astore_2
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_2
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	AssetExtractor
    //   18	22	1	i	int
    //   43	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	43	finally
    //   23	35	43	finally
  }
  
  /* Error */
  @NonNull
  public android.media.MediaFormat getTrackFormat(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 95	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   6: ifnull +18 -> 24
    //   9: aload_0
    //   10: getfield 95	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   13: iload_1
    //   14: invokeinterface 204 2 0
    //   19: astore_2
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_2
    //   23: areturn
    //   24: new 206	android/media/MediaFormat
    //   27: dup
    //   28: invokespecial 207	android/media/MediaFormat:<init>	()V
    //   31: astore_3
    //   32: aload_3
    //   33: astore_2
    //   34: aload_0
    //   35: getfield 78	com/tencent/tav/extractor/AssetExtractor:released	Z
    //   38: ifne -18 -> 20
    //   41: aload_0
    //   42: iload_1
    //   43: invokespecial 209	com/tencent/tav/extractor/AssetExtractor:getTrackFormatNative	(I)Ljava/util/Map;
    //   46: astore_2
    //   47: ldc 206
    //   49: ldc 211
    //   51: invokevirtual 217	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   54: astore 4
    //   56: aload 4
    //   58: iconst_1
    //   59: invokevirtual 222	java/lang/reflect/Field:setAccessible	(Z)V
    //   62: aload 4
    //   64: aload_3
    //   65: aload_2
    //   66: invokevirtual 226	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   69: aload_3
    //   70: astore_2
    //   71: goto -51 -> 20
    //   74: astore_2
    //   75: ldc 228
    //   77: aload_2
    //   78: invokevirtual 231	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   81: invokestatic 237	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   84: pop
    //   85: aload_3
    //   86: astore_2
    //   87: goto -67 -> 20
    //   90: astore_2
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_2
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	AssetExtractor
    //   0	95	1	paramInt	int
    //   19	52	2	localObject1	Object
    //   74	4	2	localException	java.lang.Exception
    //   86	1	2	localObject2	Object
    //   90	4	2	localObject3	Object
    //   31	55	3	localMediaFormat	android.media.MediaFormat
    //   54	9	4	localField	java.lang.reflect.Field
    // Exception table:
    //   from	to	target	type
    //   47	69	74	java/lang/Exception
    //   2	20	90	finally
    //   24	32	90	finally
    //   34	47	90	finally
    //   47	69	90	finally
    //   75	85	90	finally
  }
  
  public boolean isReleased()
  {
    return this.released;
  }
  
  /* Error */
  public int readSampleData(@NonNull ByteBuffer paramByteBuffer, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 95	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   6: ifnull +19 -> 25
    //   9: aload_0
    //   10: getfield 95	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   13: aload_1
    //   14: iload_2
    //   15: invokeinterface 242 3 0
    //   20: istore_2
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_2
    //   24: ireturn
    //   25: aload_0
    //   26: getfield 78	com/tencent/tav/extractor/AssetExtractor:released	Z
    //   29: ifne +13 -> 42
    //   32: aload_0
    //   33: aload_1
    //   34: iload_2
    //   35: invokespecial 244	com/tencent/tav/extractor/AssetExtractor:readSampleDataNative	(Ljava/nio/ByteBuffer;I)I
    //   38: istore_2
    //   39: goto -18 -> 21
    //   42: iconst_m1
    //   43: istore_2
    //   44: goto -23 -> 21
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	AssetExtractor
    //   0	52	1	paramByteBuffer	ByteBuffer
    //   0	52	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   2	21	47	finally
    //   25	39	47	finally
  }
  
  /* Error */
  public final void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 95	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   6: ifnull +20 -> 26
    //   9: aload_0
    //   10: getfield 95	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   13: invokeinterface 248 1 0
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 95	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield 78	com/tencent/tav/extractor/AssetExtractor:released	Z
    //   30: ifne -7 -> 23
    //   33: aload_0
    //   34: invokespecial 158	com/tencent/tav/extractor/AssetExtractor:releaseNative	()V
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 78	com/tencent/tav/extractor/AssetExtractor:released	Z
    //   42: goto -19 -> 23
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	AssetExtractor
    //   45	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	23	45	finally
    //   26	42	45	finally
  }
  
  /* Error */
  public void seekTo(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 95	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: getfield 95	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   13: lload_1
    //   14: iload_3
    //   15: invokeinterface 251 4 0
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 78	com/tencent/tav/extractor/AssetExtractor:released	Z
    //   27: ifne -7 -> 20
    //   30: aload_0
    //   31: lload_1
    //   32: iload_3
    //   33: invokespecial 253	com/tencent/tav/extractor/AssetExtractor:seekToNative	(JI)V
    //   36: goto -16 -> 20
    //   39: astore 4
    //   41: aload_0
    //   42: monitorexit
    //   43: aload 4
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	AssetExtractor
    //   0	46	1	paramLong	long
    //   0	46	3	paramInt	int
    //   39	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	39	finally
    //   23	36	39	finally
  }
  
  /* Error */
  public void selectTrack(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 95	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   6: ifnull +16 -> 22
    //   9: aload_0
    //   10: getfield 95	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   13: iload_1
    //   14: invokeinterface 256 2 0
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 78	com/tencent/tav/extractor/AssetExtractor:released	Z
    //   26: ifne -7 -> 19
    //   29: aload_0
    //   30: iload_1
    //   31: invokespecial 258	com/tencent/tav/extractor/AssetExtractor:selectTrackNative	(I)V
    //   34: goto -15 -> 19
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	AssetExtractor
    //   0	42	1	paramInt	int
    //   37	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	37	finally
    //   22	34	37	finally
  }
  
  public final void setDataSource(@NonNull AssetFileDescriptor paramAssetFileDescriptor)
  {
    for (;;)
    {
      try
      {
        if (this.delegate != null)
        {
          this.delegate.setDataSource(paramAssetFileDescriptor);
          return;
        }
        if (paramAssetFileDescriptor.getDeclaredLength() < 0L) {
          setDataSource(paramAssetFileDescriptor.getFileDescriptor());
        } else {
          setDataSource(paramAssetFileDescriptor.getFileDescriptor(), paramAssetFileDescriptor.getStartOffset(), paramAssetFileDescriptor.getDeclaredLength());
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public final void setDataSource(@NonNull FileDescriptor paramFileDescriptor)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 95	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   6: ifnull +16 -> 22
    //   9: aload_0
    //   10: getfield 95	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   13: aload_1
    //   14: invokeinterface 280 2 0
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: aload_1
    //   24: lconst_0
    //   25: ldc2_w 281
    //   28: invokevirtual 279	com/tencent/tav/extractor/AssetExtractor:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   31: goto -12 -> 19
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	AssetExtractor
    //   0	39	1	paramFileDescriptor	FileDescriptor
    // Exception table:
    //   from	to	target	type
    //   2	19	34	finally
    //   22	31	34	finally
  }
  
  public final native void setDataSource(@NonNull FileDescriptor paramFileDescriptor, long paramLong1, long paramLong2);
  
  /* Error */
  public final void setDataSource(@NonNull String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 95	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   6: ifnull +13 -> 19
    //   9: aload_0
    //   10: getfield 95	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   13: aload_1
    //   14: invokeinterface 283 2 0
    //   19: aload_0
    //   20: aload_1
    //   21: putfield 84	com/tencent/tav/extractor/AssetExtractor:sourcePath	Ljava/lang/String;
    //   24: aload_1
    //   25: invokestatic 289	com/tencent/tav/extractor/wrapper/ExtractorWrapperPool:contains	(Ljava/lang/String;)Z
    //   28: ifeq +14 -> 42
    //   31: aload_0
    //   32: getfield 84	com/tencent/tav/extractor/AssetExtractor:sourcePath	Ljava/lang/String;
    //   35: aload_0
    //   36: invokestatic 293	com/tencent/tav/extractor/wrapper/ExtractorWrapperPool:fillIn	(Ljava/lang/String;Lcom/tencent/tav/extractor/AssetExtractor;)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: aload_1
    //   43: invokestatic 298	com/tencent/tav/extractor/wrapper/ExtractorLoader:cacheExtractor	(Ljava/lang/String;)V
    //   46: goto -7 -> 39
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	AssetExtractor
    //   0	54	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	19	49	finally
    //   19	39	49	finally
    //   42	46	49	finally
  }
  
  public void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public void setPreferRotation(int paramInt)
  {
    this.preferRotation = paramInt;
  }
  
  public void setSize(CGSize paramCGSize)
  {
    this.size = paramCGSize;
  }
  
  /* Error */
  public void unselectTrack(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 95	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   6: ifnull +16 -> 22
    //   9: aload_0
    //   10: getfield 95	com/tencent/tav/extractor/AssetExtractor:delegate	Lcom/tencent/tav/extractor/IAssetExtractorDelegate;
    //   13: iload_1
    //   14: invokeinterface 301 2 0
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 78	com/tencent/tav/extractor/AssetExtractor:released	Z
    //   26: ifne -7 -> 19
    //   29: aload_0
    //   30: iload_1
    //   31: invokespecial 303	com/tencent/tav/extractor/AssetExtractor:unselectTrackNative	(I)V
    //   34: goto -15 -> 19
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	AssetExtractor
    //   0	42	1	paramInt	int
    //   37	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	37	finally
    //   22	34	37	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.extractor.AssetExtractor
 * JD-Core Version:    0.7.0.1
 */