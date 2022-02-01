package com.tencent.richmedia.videocompress.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.richmedia.videocompress.utils.ConvertLog;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class MediaCodecWrapper
{
  public static int DEC_CODEC = 0;
  public static int ENC_CODEC;
  private static String TAG = "AndroidCodec";
  public static int TIMEOUT_US = 33000;
  protected static Method getInputBuffer21;
  protected static Method getOutputBuffer21;
  protected static Method getOutputFormat21;
  public static boolean invokeAPILevel21 = true;
  protected ByteBuffer[] inputBuffers;
  protected int mCodecType = DEC_CODEC;
  protected MediaCodec mMediaCodec;
  protected MediaFormat mOutputFormat;
  protected ByteBuffer[] outputBuffers;
  
  static
  {
    ENC_CODEC = 1;
  }
  
  public MediaCodecWrapper(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      TAG = paramString + "_AndroidCodec";
    }
    invoke21Apis();
  }
  
  public static MediaCodecInfo getCodecInfo(String paramString)
  {
    try
    {
      int j = MediaCodecList.getCodecCount();
      int i = 0;
      while (i < j)
      {
        MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
        boolean bool = localMediaCodecInfo.getName().equalsIgnoreCase(paramString);
        if (bool) {
          return localMediaCodecInfo;
        }
        i += 1;
      }
      return null;
    }
    catch (Throwable paramString)
    {
      ConvertLog.e(TAG, 1, "getCodecInfo error", paramString);
    }
  }
  
  public static void invoke21Apis()
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      if (getInputBuffer21 == null) {
        getInputBuffer21 = MediaCodec.class.getMethod("getInputBuffer", new Class[] { Integer.TYPE });
      }
      if (getOutputBuffer21 == null) {
        getOutputBuffer21 = MediaCodec.class.getMethod("getOutputBuffer", new Class[] { Integer.TYPE });
      }
      if (getOutputFormat21 == null) {
        getOutputFormat21 = MediaCodec.class.getMethod("getOutputFormat", new Class[] { Integer.TYPE });
      }
      return;
    }
    catch (Exception localException)
    {
      getInputBuffer21 = null;
      getOutputBuffer21 = null;
      getOutputFormat21 = null;
      invokeAPILevel21 = false;
    }
  }
  
  public MediaCodecWrapper.BufferData dequeueOutputBuffer()
  {
    label428:
    label508:
    for (;;)
    {
      Object localObject1;
      int i;
      try
      {
        localObject1 = this.mMediaCodec;
        if (localObject1 == null)
        {
          localObject1 = null;
          return localObject1;
        }
        localObject1 = new MediaCodecWrapper.BufferData();
        i = this.mMediaCodec.dequeueOutputBuffer(((MediaCodecWrapper.BufferData)localObject1).info, TIMEOUT_US);
        switch (i)
        {
        case -3: 
          if (i < 0) {
            break label508;
          }
          if (ConvertLog.isColorLevel()) {
            ConvertLog.d(TAG, 2, new Object[] { "dequeueOutputBuffer ok, index = " + i + ", BufferInfo[flags = " + ((MediaCodecWrapper.BufferData)localObject1).info.flags + ", offset=" + ((MediaCodecWrapper.BufferData)localObject1).info.offset + ", size= " + ((MediaCodecWrapper.BufferData)localObject1).info.size + ", TimeUs=" + ((MediaCodecWrapper.BufferData)localObject1).info.presentationTimeUs + "]" });
          }
          if (Build.VERSION.SDK_INT > 20) {
            break label428;
          }
          ((MediaCodecWrapper.BufferData)localObject1).buffer = this.outputBuffers[i];
          ((MediaCodecWrapper.BufferData)localObject1).index = i;
          ((MediaCodecWrapper.BufferData)localObject1).format = this.mOutputFormat;
          continue;
          if (ConvertLog.isColorLevel()) {
            ConvertLog.e(TAG, 2, new Object[] { "INFO_OUTPUT_BUFFERS_CHANGED" });
          }
          this.outputBuffers = this.mMediaCodec.getOutputBuffers();
          ((MediaCodecWrapper.BufferData)localObject1).index = -3;
        }
      }
      finally {}
      ((MediaCodecWrapper.BufferData)localObject1).index = -2;
      this.mOutputFormat = this.mMediaCodec.getOutputFormat();
      ((MediaCodecWrapper.BufferData)localObject1).format = this.mOutputFormat;
      if (this.mCodecType == DEC_CODEC)
      {
        if (this.mOutputFormat.containsKey("color-format"))
        {
          i = this.mOutputFormat.getInteger("color-format");
          if (ConvertLog.isColorLevel()) {
            ConvertLog.e(TAG, 2, new Object[] { "New color format " + i + "[0x" + Integer.toHexString(i) + "]" });
          }
        }
      }
      else if (ConvertLog.isColorLevel())
      {
        ConvertLog.e(TAG, 2, new Object[] { "EncCodec,INFO_OUTPUT_FORMAT_CHANGED" });
        break label508;
        if (ConvertLog.isColorLevel()) {
          ConvertLog.e(TAG, 2, new Object[] { "dequeueOutputBuffer timed out!" });
        }
        localObject2.index = -1;
        continue;
        localObject2.index = i;
        try
        {
          localObject2.buffer = ((ByteBuffer)getOutputBuffer21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
          localObject2.format = ((MediaFormat)getOutputFormat21.invoke(this.mMediaCodec, new Object[] { Integer.valueOf(i) }));
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          localObject2.success = false;
        }
      }
    }
  }
  
  public MediaCodec getInnerMediaCodec()
  {
    return this.mMediaCodec;
  }
  
  /* Error */
  public MediaCodecWrapper.BufferData getInputBuffer()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 138	com/tencent/richmedia/videocompress/mediacodec/MediaCodecWrapper:mMediaCodec	Landroid/media/MediaCodec;
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 140	com/tencent/richmedia/videocompress/mediacodec/MediaCodecWrapper$BufferData
    //   12: dup
    //   13: invokespecial 141	com/tencent/richmedia/videocompress/mediacodec/MediaCodecWrapper$BufferData:<init>	()V
    //   16: astore_2
    //   17: aload_0
    //   18: getfield 138	com/tencent/richmedia/videocompress/mediacodec/MediaCodecWrapper:mMediaCodec	Landroid/media/MediaCodec;
    //   21: getstatic 33	com/tencent/richmedia/videocompress/mediacodec/MediaCodecWrapper:TIMEOUT_US	I
    //   24: i2l
    //   25: invokevirtual 261	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   28: istore_1
    //   29: iload_1
    //   30: iflt -23 -> 7
    //   33: getstatic 108	android/os/Build$VERSION:SDK_INT	I
    //   36: bipush 20
    //   38: if_icmpgt +29 -> 67
    //   41: aload_0
    //   42: monitorenter
    //   43: aload_2
    //   44: iload_1
    //   45: putfield 198	com/tencent/richmedia/videocompress/mediacodec/MediaCodecWrapper$BufferData:index	I
    //   48: aload_2
    //   49: aload_0
    //   50: getfield 263	com/tencent/richmedia/videocompress/mediacodec/MediaCodecWrapper:inputBuffers	[Ljava/nio/ByteBuffer;
    //   53: iload_1
    //   54: aaload
    //   55: putfield 195	com/tencent/richmedia/videocompress/mediacodec/MediaCodecWrapper$BufferData:buffer	Ljava/nio/ByteBuffer;
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_2
    //   61: areturn
    //   62: astore_2
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_2
    //   66: athrow
    //   67: aload_0
    //   68: monitorenter
    //   69: aload_2
    //   70: iload_1
    //   71: putfield 198	com/tencent/richmedia/videocompress/mediacodec/MediaCodecWrapper$BufferData:index	I
    //   74: aload_2
    //   75: getstatic 110	com/tencent/richmedia/videocompress/mediacodec/MediaCodecWrapper:getInputBuffer21	Ljava/lang/reflect/Method;
    //   78: aload_0
    //   79: getfield 138	com/tencent/richmedia/videocompress/mediacodec/MediaCodecWrapper:mMediaCodec	Landroid/media/MediaCodec;
    //   82: iconst_1
    //   83: anewarray 4	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: iload_1
    //   89: invokestatic 241	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   92: aastore
    //   93: invokevirtual 247	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   96: checkcast 249	java/nio/ByteBuffer
    //   99: putfield 195	com/tencent/richmedia/videocompress/mediacodec/MediaCodecWrapper$BufferData:buffer	Ljava/nio/ByteBuffer;
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_2
    //   105: areturn
    //   106: astore_3
    //   107: aload_3
    //   108: invokevirtual 252	java/lang/Exception:printStackTrace	()V
    //   111: aload_2
    //   112: iconst_0
    //   113: putfield 255	com/tencent/richmedia/videocompress/mediacodec/MediaCodecWrapper$BufferData:success	Z
    //   116: goto -14 -> 102
    //   119: astore_2
    //   120: aload_0
    //   121: monitorexit
    //   122: aload_2
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	MediaCodecWrapper
    //   28	61	1	i	int
    //   16	45	2	localBufferData1	MediaCodecWrapper.BufferData
    //   62	50	2	localBufferData2	MediaCodecWrapper.BufferData
    //   119	4	2	localObject	Object
    //   106	2	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   43	60	62	finally
    //   63	65	62	finally
    //   74	102	106	java/lang/Exception
    //   69	74	119	finally
    //   74	102	119	finally
    //   102	104	119	finally
    //   107	116	119	finally
    //   120	122	119	finally
  }
  
  public void init(MediaFormat paramMediaFormat, int paramInt)
  {
    this.mCodecType = paramInt;
    for (;;)
    {
      try
      {
        String str = paramMediaFormat.getString("mime");
        if (str == null) {
          break;
        }
        if (paramInt == DEC_CODEC)
        {
          this.mMediaCodec = MediaCodec.createDecoderByType(str);
          if (paramInt == ENC_CODEC)
          {
            paramInt = 1;
            this.mMediaCodec.configure(paramMediaFormat, null, null, paramInt);
          }
        }
        else
        {
          this.mMediaCodec = MediaCodec.createEncoderByType(str);
          continue;
        }
        paramInt = 0;
      }
      catch (Exception paramMediaFormat)
      {
        ConvertLog.e(TAG, 1, "init codec error", paramMediaFormat);
        return;
      }
    }
  }
  
  public void init(MediaFormat paramMediaFormat, String paramString, Surface paramSurface)
  {
    int j = 0;
    MediaCodecInfo localMediaCodecInfo = getCodecInfo(paramString);
    int i = j;
    if (localMediaCodecInfo != null)
    {
      i = j;
      if (localMediaCodecInfo.isEncoder())
      {
        this.mCodecType = ENC_CODEC;
        i = 1;
      }
    }
    try
    {
      this.mMediaCodec = MediaCodec.createByCodecName(paramString);
      this.mMediaCodec.configure(paramMediaFormat, paramSurface, null, i);
      return;
    }
    catch (Exception paramMediaFormat)
    {
      ConvertLog.e(TAG, 1, "init codec error", paramMediaFormat);
    }
  }
  
  /* Error */
  public void queueInputBuffer(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 138	com/tencent/richmedia/videocompress/mediacodec/MediaCodecWrapper:mMediaCodec	Landroid/media/MediaCodec;
    //   6: astore 6
    //   8: aload 6
    //   10: ifnonnull +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 138	com/tencent/richmedia/videocompress/mediacodec/MediaCodecWrapper:mMediaCodec	Landroid/media/MediaCodec;
    //   20: iload_1
    //   21: iconst_0
    //   22: iload_2
    //   23: lload_3
    //   24: iload 5
    //   26: invokevirtual 298	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   29: goto -16 -> 13
    //   32: astore 6
    //   34: invokestatic 152	com/tencent/richmedia/videocompress/utils/ConvertLog:isColorLevel	()Z
    //   37: ifeq -24 -> 13
    //   40: getstatic 30	com/tencent/richmedia/videocompress/mediacodec/MediaCodecWrapper:TAG	Ljava/lang/String;
    //   43: iconst_1
    //   44: new 54	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   51: ldc_w 300
    //   54: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: iload_1
    //   58: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: ldc_w 302
    //   64: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: iload_2
    //   68: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   71: ldc_w 304
    //   74: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: lload_3
    //   78: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   81: ldc_w 306
    //   84: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: iload 5
    //   89: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: ldc 185
    //   94: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: aload 6
    //   102: invokestatic 101	com/tencent/richmedia/videocompress/utils/ConvertLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   105: goto -92 -> 13
    //   108: astore 6
    //   110: aload_0
    //   111: monitorexit
    //   112: aload 6
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	MediaCodecWrapper
    //   0	115	1	paramInt1	int
    //   0	115	2	paramInt2	int
    //   0	115	3	paramLong	long
    //   0	115	5	paramInt3	int
    //   6	3	6	localMediaCodec	MediaCodec
    //   32	69	6	localException	Exception
    //   108	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	29	32	java/lang/Exception
    //   2	8	108	finally
    //   16	29	108	finally
    //   34	105	108	finally
  }
  
  public void release()
  {
    try
    {
      this.inputBuffers = null;
      this.outputBuffers = null;
      if (this.mMediaCodec != null)
      {
        this.mMediaCodec.release();
        this.mMediaCodec = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void releaseOutputBuffer(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 138	com/tencent/richmedia/videocompress/mediacodec/MediaCodecWrapper:mMediaCodec	Landroid/media/MediaCodec;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 138	com/tencent/richmedia/videocompress/mediacodec/MediaCodecWrapper:mMediaCodec	Landroid/media/MediaCodec;
    //   18: iload_1
    //   19: iconst_0
    //   20: invokevirtual 314	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   23: goto -12 -> 11
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	MediaCodecWrapper
    //   0	31	1	paramInt	int
    //   6	2	2	localMediaCodec	MediaCodec
    //   26	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	26	finally
    //   14	23	26	finally
  }
  
  public void start()
  {
    try
    {
      if (this.mMediaCodec != null)
      {
        this.mMediaCodec.start();
        if (Build.VERSION.SDK_INT <= 20) {
          try
          {
            this.inputBuffers = this.mMediaCodec.getInputBuffers();
            this.outputBuffers = this.mMediaCodec.getOutputBuffers();
            return;
          }
          finally {}
        }
      }
      return;
    }
    catch (Exception localException)
    {
      ConvertLog.e(TAG, 1, "start codec error", localException);
    }
  }
  
  public void stop()
  {
    if (this.mMediaCodec != null) {
      this.mMediaCodec.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmedia.videocompress.mediacodec.MediaCodecWrapper
 * JD-Core Version:    0.7.0.1
 */