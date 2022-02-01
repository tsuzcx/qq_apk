package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.tav.decoder.logger.Logger;

class MediaCodecWrapper
{
  private static final int MAX_RETRY_COUNT = 10;
  private static final long WAIT_TRANSIENT_MS = 20L;
  private final String TAG;
  private MediaCodec mediaCodec;
  private final VideoDecoder videoDecoder;
  
  MediaCodecWrapper(VideoDecoder paramVideoDecoder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MediaCodecWrapper@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.TAG = localStringBuilder.toString();
    this.videoDecoder = paramVideoDecoder;
  }
  
  private boolean isLollipop()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  private void resetMediaCodec(MediaFormat paramMediaFormat)
  {
    if (isLollipop())
    {
      this.mediaCodec.reset();
      return;
    }
    try
    {
      this.mediaCodec.stop();
      label22:
      MediaCodecManager.releaseCodec(this.mediaCodec);
      this.mediaCodec = MediaCodecManager.createDecoderByType(paramMediaFormat.getString("mime"));
      return;
    }
    catch (Exception localException)
    {
      break label22;
    }
  }
  
  private void tryLogMediaCodecError(MediaCodec.CodecException paramCodecException)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CodecException - isTransient = ");
      localStringBuilder.append(paramCodecException.isTransient());
      localStringBuilder.append(" , isRecoverable = ");
      localStringBuilder.append(paramCodecException.isRecoverable());
      localStringBuilder.append(" , errorCode = ");
      localStringBuilder.append(paramCodecException.getErrorCode());
      Logger.e(str, localStringBuilder.toString());
    }
  }
  
  boolean decoderConfigure(MediaFormat paramMediaFormat, Surface paramSurface)
  {
    try
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("decoderConfigure() called with: inputFormat = [");
      localStringBuilder.append(paramMediaFormat);
      localStringBuilder.append("], outputSurface = [");
      localStringBuilder.append(paramSurface);
      localStringBuilder.append("]");
      Logger.i(str, localStringBuilder.toString());
      this.mediaCodec = MediaCodecManager.createDecoderByType(paramMediaFormat.getString("mime"));
      if (Build.VERSION.SDK_INT < 21)
      {
        this.mediaCodec.configure(paramMediaFormat, paramSurface, null, 0);
        paramMediaFormat = this.TAG;
        paramSurface = new StringBuilder();
        paramSurface.append("decoderConfigure() called with: outputFormat = [");
        paramSurface.append(this.mediaCodec.getOutputFormat());
        paramSurface.append("]");
        Logger.i(paramMediaFormat, paramSurface.toString());
        return true;
      }
      int i = 0;
      for (;;)
      {
        int j = i + 1;
        try
        {
          str = this.TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("createdDecoder---time---");
          localStringBuilder.append(j);
          Logger.d(str, localStringBuilder.toString());
          if (j > 10) {
            return false;
          }
          this.mediaCodec.configure(paramMediaFormat, paramSurface, null, 0);
          str = this.TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("decoderConfigure() called with: outputFormat = [");
          localStringBuilder.append(this.mediaCodec.getOutputFormat());
          localStringBuilder.append("]");
          Logger.i(str, localStringBuilder.toString());
          return true;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          if ((localException instanceof MediaCodec.CodecException))
          {
            i = j;
            if (((MediaCodec.CodecException)localException).isTransient()) {
              continue;
            }
            if (((MediaCodec.CodecException)localException).isRecoverable())
            {
              i = j;
              continue;
            }
          }
          MediaCodecManager.releaseCodec(this.mediaCodec);
          throw localException;
        }
      }
      throw paramMediaFormat;
    }
    finally {}
    for (;;) {}
  }
  
  /* Error */
  int dequeueInputBuffer()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/tav/decoder/MediaCodecWrapper:mediaCodec	Landroid/media/MediaCodec;
    //   6: ldc2_w 166
    //   9: invokevirtual 170	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: astore_2
    //   18: goto +68 -> 86
    //   21: astore_2
    //   22: goto +4 -> 26
    //   25: astore_2
    //   26: aload_0
    //   27: getfield 47	com/tencent/tav/decoder/MediaCodecWrapper:TAG	Ljava/lang/String;
    //   30: ldc 171
    //   32: aload_2
    //   33: invokestatic 174	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   36: aload_0
    //   37: invokespecial 73	com/tencent/tav/decoder/MediaCodecWrapper:isLollipop	()Z
    //   40: ifeq +44 -> 84
    //   43: aload_2
    //   44: instanceof 105
    //   47: ifeq +37 -> 84
    //   50: aload_0
    //   51: aload_2
    //   52: checkcast 105	android/media/MediaCodec$CodecException
    //   55: invokespecial 176	com/tencent/tav/decoder/MediaCodecWrapper:tryLogMediaCodecError	(Landroid/media/MediaCodec$CodecException;)V
    //   58: aload_2
    //   59: checkcast 105	android/media/MediaCodec$CodecException
    //   62: invokevirtual 108	android/media/MediaCodec$CodecException:isTransient	()Z
    //   65: ifeq +19 -> 84
    //   68: aload_0
    //   69: ldc2_w 10
    //   72: invokevirtual 180	com/tencent/tav/decoder/MediaCodecWrapper:waitTime	(J)V
    //   75: aload_0
    //   76: invokevirtual 182	com/tencent/tav/decoder/MediaCodecWrapper:dequeueInputBuffer	()I
    //   79: istore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: iload_1
    //   83: ireturn
    //   84: aload_2
    //   85: athrow
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_2
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	MediaCodecWrapper
    //   12	71	1	i	int
    //   17	1	2	localObject	Object
    //   21	1	2	localError	java.lang.Error
    //   25	64	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	13	17	finally
    //   26	80	17	finally
    //   84	86	17	finally
    //   2	13	21	java/lang/Error
    //   2	13	25	java/lang/Exception
  }
  
  /* Error */
  int dequeueOutputBuffer(android.media.MediaCodec.BufferInfo paramBufferInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/tav/decoder/MediaCodecWrapper:mediaCodec	Landroid/media/MediaCodec;
    //   6: aload_1
    //   7: ldc2_w 166
    //   10: invokevirtual 187	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   13: istore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: astore_1
    //   19: goto +65 -> 84
    //   22: astore_3
    //   23: aload_0
    //   24: getfield 47	com/tencent/tav/decoder/MediaCodecWrapper:TAG	Ljava/lang/String;
    //   27: ldc 188
    //   29: aload_3
    //   30: invokestatic 174	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   33: aload_0
    //   34: invokespecial 73	com/tencent/tav/decoder/MediaCodecWrapper:isLollipop	()Z
    //   37: ifeq +45 -> 82
    //   40: aload_3
    //   41: instanceof 105
    //   44: ifeq +38 -> 82
    //   47: aload_0
    //   48: aload_3
    //   49: checkcast 105	android/media/MediaCodec$CodecException
    //   52: invokespecial 176	com/tencent/tav/decoder/MediaCodecWrapper:tryLogMediaCodecError	(Landroid/media/MediaCodec$CodecException;)V
    //   55: aload_3
    //   56: checkcast 105	android/media/MediaCodec$CodecException
    //   59: invokevirtual 108	android/media/MediaCodec$CodecException:isTransient	()Z
    //   62: ifeq +20 -> 82
    //   65: aload_0
    //   66: ldc2_w 10
    //   69: invokevirtual 180	com/tencent/tav/decoder/MediaCodecWrapper:waitTime	(J)V
    //   72: aload_0
    //   73: aload_1
    //   74: invokevirtual 190	com/tencent/tav/decoder/MediaCodecWrapper:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;)I
    //   77: istore_2
    //   78: aload_0
    //   79: monitorexit
    //   80: iload_2
    //   81: ireturn
    //   82: aload_3
    //   83: athrow
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	MediaCodecWrapper
    //   0	88	1	paramBufferInfo	android.media.MediaCodec.BufferInfo
    //   13	68	2	i	int
    //   22	61	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	14	18	finally
    //   23	78	18	finally
    //   82	84	18	finally
    //   2	14	22	java/lang/Exception
  }
  
  void flushDecoder()
  {
    this.mediaCodec.flush();
  }
  
  /* Error */
  java.nio.ByteBuffer getInputBuffer(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/tav/decoder/MediaCodecWrapper:mediaCodec	Landroid/media/MediaCodec;
    //   6: iload_1
    //   7: invokestatic 201	com/tencent/tav/decoder/DecoderUtils:getInputBuffer	(Landroid/media/MediaCodec;I)Ljava/nio/ByteBuffer;
    //   10: astore_2
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_2
    //   14: areturn
    //   15: astore_2
    //   16: goto +69 -> 85
    //   19: astore_2
    //   20: goto +4 -> 24
    //   23: astore_2
    //   24: aload_0
    //   25: getfield 47	com/tencent/tav/decoder/MediaCodecWrapper:TAG	Ljava/lang/String;
    //   28: ldc 202
    //   30: aload_2
    //   31: invokestatic 174	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   34: aload_0
    //   35: invokespecial 73	com/tencent/tav/decoder/MediaCodecWrapper:isLollipop	()Z
    //   38: ifeq +45 -> 83
    //   41: aload_2
    //   42: instanceof 105
    //   45: ifeq +38 -> 83
    //   48: aload_0
    //   49: aload_2
    //   50: checkcast 105	android/media/MediaCodec$CodecException
    //   53: invokespecial 176	com/tencent/tav/decoder/MediaCodecWrapper:tryLogMediaCodecError	(Landroid/media/MediaCodec$CodecException;)V
    //   56: aload_2
    //   57: checkcast 105	android/media/MediaCodec$CodecException
    //   60: invokevirtual 108	android/media/MediaCodec$CodecException:isTransient	()Z
    //   63: ifeq +20 -> 83
    //   66: aload_0
    //   67: ldc2_w 10
    //   70: invokevirtual 180	com/tencent/tav/decoder/MediaCodecWrapper:waitTime	(J)V
    //   73: aload_0
    //   74: iload_1
    //   75: invokevirtual 204	com/tencent/tav/decoder/MediaCodecWrapper:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   78: astore_2
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_2
    //   82: areturn
    //   83: aload_2
    //   84: athrow
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_2
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	MediaCodecWrapper
    //   0	89	1	paramInt	int
    //   10	4	2	localByteBuffer1	java.nio.ByteBuffer
    //   15	1	2	localObject	Object
    //   19	1	2	localError	java.lang.Error
    //   23	34	2	localException	Exception
    //   78	10	2	localByteBuffer2	java.nio.ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   2	11	15	finally
    //   24	79	15	finally
    //   83	85	15	finally
    //   2	11	19	java/lang/Error
    //   2	11	23	java/lang/Exception
  }
  
  public MediaCodec getMediaCodec()
  {
    return this.mediaCodec;
  }
  
  /* Error */
  java.nio.ByteBuffer getOnputBuffer(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/tav/decoder/MediaCodecWrapper:mediaCodec	Landroid/media/MediaCodec;
    //   6: iload_1
    //   7: invokestatic 210	com/tencent/tav/decoder/DecoderUtils:getOutputBuffer	(Landroid/media/MediaCodec;I)Ljava/nio/ByteBuffer;
    //   10: astore_2
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_2
    //   14: areturn
    //   15: astore_2
    //   16: goto +69 -> 85
    //   19: astore_2
    //   20: goto +4 -> 24
    //   23: astore_2
    //   24: aload_0
    //   25: getfield 47	com/tencent/tav/decoder/MediaCodecWrapper:TAG	Ljava/lang/String;
    //   28: ldc 211
    //   30: aload_2
    //   31: invokestatic 174	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   34: aload_0
    //   35: invokespecial 73	com/tencent/tav/decoder/MediaCodecWrapper:isLollipop	()Z
    //   38: ifeq +45 -> 83
    //   41: aload_2
    //   42: instanceof 105
    //   45: ifeq +38 -> 83
    //   48: aload_0
    //   49: aload_2
    //   50: checkcast 105	android/media/MediaCodec$CodecException
    //   53: invokespecial 176	com/tencent/tav/decoder/MediaCodecWrapper:tryLogMediaCodecError	(Landroid/media/MediaCodec$CodecException;)V
    //   56: aload_2
    //   57: checkcast 105	android/media/MediaCodec$CodecException
    //   60: invokevirtual 108	android/media/MediaCodec$CodecException:isTransient	()Z
    //   63: ifeq +20 -> 83
    //   66: aload_0
    //   67: ldc2_w 10
    //   70: invokevirtual 180	com/tencent/tav/decoder/MediaCodecWrapper:waitTime	(J)V
    //   73: aload_0
    //   74: iload_1
    //   75: invokevirtual 213	com/tencent/tav/decoder/MediaCodecWrapper:getOnputBuffer	(I)Ljava/nio/ByteBuffer;
    //   78: astore_2
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_2
    //   82: areturn
    //   83: aload_2
    //   84: athrow
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_2
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	MediaCodecWrapper
    //   0	89	1	paramInt	int
    //   10	4	2	localByteBuffer1	java.nio.ByteBuffer
    //   15	1	2	localObject	Object
    //   19	1	2	localError	java.lang.Error
    //   23	34	2	localException	Exception
    //   78	10	2	localByteBuffer2	java.nio.ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   2	11	15	finally
    //   24	79	15	finally
    //   83	85	15	finally
    //   2	11	19	java/lang/Error
    //   2	11	23	java/lang/Exception
  }
  
  /* Error */
  void queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/tav/decoder/MediaCodecWrapper:mediaCodec	Landroid/media/MediaCodec;
    //   6: iload_1
    //   7: iload_2
    //   8: iload_3
    //   9: lload 4
    //   11: iload 6
    //   13: invokevirtual 217	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: astore 7
    //   21: goto +77 -> 98
    //   24: astore 7
    //   26: goto +5 -> 31
    //   29: astore 7
    //   31: aload_0
    //   32: getfield 47	com/tencent/tav/decoder/MediaCodecWrapper:TAG	Ljava/lang/String;
    //   35: ldc 218
    //   37: aload 7
    //   39: invokestatic 174	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   42: aload_0
    //   43: invokespecial 73	com/tencent/tav/decoder/MediaCodecWrapper:isLollipop	()Z
    //   46: ifeq +49 -> 95
    //   49: aload 7
    //   51: instanceof 105
    //   54: ifeq +41 -> 95
    //   57: aload_0
    //   58: aload 7
    //   60: checkcast 105	android/media/MediaCodec$CodecException
    //   63: invokespecial 176	com/tencent/tav/decoder/MediaCodecWrapper:tryLogMediaCodecError	(Landroid/media/MediaCodec$CodecException;)V
    //   66: aload 7
    //   68: checkcast 105	android/media/MediaCodec$CodecException
    //   71: invokevirtual 108	android/media/MediaCodec$CodecException:isTransient	()Z
    //   74: ifeq +21 -> 95
    //   77: aload_0
    //   78: ldc2_w 10
    //   81: invokevirtual 180	com/tencent/tav/decoder/MediaCodecWrapper:waitTime	(J)V
    //   84: aload_0
    //   85: iload_1
    //   86: iload_2
    //   87: iload_3
    //   88: lload 4
    //   90: iload 6
    //   92: invokevirtual 219	com/tencent/tav/decoder/MediaCodecWrapper:queueInputBuffer	(IIIJI)V
    //   95: aload 7
    //   97: athrow
    //   98: aload_0
    //   99: monitorexit
    //   100: aload 7
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	MediaCodecWrapper
    //   0	103	1	paramInt1	int
    //   0	103	2	paramInt2	int
    //   0	103	3	paramInt3	int
    //   0	103	4	paramLong	long
    //   0	103	6	paramInt4	int
    //   19	1	7	localObject	Object
    //   24	1	7	localError	java.lang.Error
    //   29	72	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	16	19	finally
    //   31	95	19	finally
    //   95	98	19	finally
    //   2	16	24	java/lang/Error
    //   2	16	29	java/lang/Exception
  }
  
  void release()
  {
    if (this.mediaCodec == null) {
      return;
    }
    ThreadPool.execute(new MediaCodecWrapper.1(this));
  }
  
  /* Error */
  void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/tav/decoder/MediaCodecWrapper:mediaCodec	Landroid/media/MediaCodec;
    //   6: iload_1
    //   7: iload_2
    //   8: invokevirtual 235	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   11: iload_2
    //   12: ifeq +11 -> 23
    //   15: aload_0
    //   16: getfield 49	com/tencent/tav/decoder/MediaCodecWrapper:videoDecoder	Lcom/tencent/tav/decoder/VideoDecoder;
    //   19: iconst_1
    //   20: putfield 241	com/tencent/tav/decoder/VideoDecoder:lastFrameValid	Z
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: astore_3
    //   27: goto +65 -> 92
    //   30: astore_3
    //   31: goto +4 -> 35
    //   34: astore_3
    //   35: aload_0
    //   36: getfield 47	com/tencent/tav/decoder/MediaCodecWrapper:TAG	Ljava/lang/String;
    //   39: ldc 242
    //   41: aload_3
    //   42: invokestatic 174	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   45: aload_0
    //   46: invokespecial 73	com/tencent/tav/decoder/MediaCodecWrapper:isLollipop	()Z
    //   49: ifeq +41 -> 90
    //   52: aload_3
    //   53: instanceof 105
    //   56: ifeq +34 -> 90
    //   59: aload_0
    //   60: aload_3
    //   61: checkcast 105	android/media/MediaCodec$CodecException
    //   64: invokespecial 176	com/tencent/tav/decoder/MediaCodecWrapper:tryLogMediaCodecError	(Landroid/media/MediaCodec$CodecException;)V
    //   67: aload_3
    //   68: checkcast 105	android/media/MediaCodec$CodecException
    //   71: invokevirtual 108	android/media/MediaCodec$CodecException:isTransient	()Z
    //   74: ifeq +16 -> 90
    //   77: aload_0
    //   78: ldc2_w 10
    //   81: invokevirtual 180	com/tencent/tav/decoder/MediaCodecWrapper:waitTime	(J)V
    //   84: aload_0
    //   85: iload_1
    //   86: iload_2
    //   87: invokevirtual 243	com/tencent/tav/decoder/MediaCodecWrapper:releaseOutputBuffer	(IZ)V
    //   90: aload_3
    //   91: athrow
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_3
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	MediaCodecWrapper
    //   0	96	1	paramInt	int
    //   0	96	2	paramBoolean	boolean
    //   26	1	3	localObject	Object
    //   30	1	3	localError	java.lang.Error
    //   34	61	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	11	26	finally
    //   15	23	26	finally
    //   35	90	26	finally
    //   90	92	26	finally
    //   2	11	30	java/lang/Error
    //   15	23	30	java/lang/Error
    //   2	11	34	java/lang/Exception
    //   15	23	34	java/lang/Exception
  }
  
  void reset(Surface paramSurface, MediaFormat paramMediaFormat)
  {
    try
    {
      boolean bool = this.videoDecoder.isReleased;
      if (bool) {
        return;
      }
      Logger.d(this.TAG, "reset");
      try
      {
        resetMediaCodec(paramMediaFormat);
        decoderConfigure(paramMediaFormat, paramSurface);
        startDecoder(paramSurface, paramMediaFormat);
      }
      catch (Exception paramSurface)
      {
        paramSurface.printStackTrace();
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  void startDecoder(Surface paramSurface, MediaFormat paramMediaFormat)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/tav/decoder/MediaCodecWrapper:mediaCodec	Landroid/media/MediaCodec;
    //   6: invokevirtual 258	android/media/MediaCodec:start	()V
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: astore_1
    //   13: goto +92 -> 105
    //   16: astore_3
    //   17: aload_0
    //   18: getfield 47	com/tencent/tav/decoder/MediaCodecWrapper:TAG	Ljava/lang/String;
    //   21: ldc_w 260
    //   24: aload_3
    //   25: invokestatic 174	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   28: aload_0
    //   29: invokespecial 73	com/tencent/tav/decoder/MediaCodecWrapper:isLollipop	()Z
    //   32: ifeq +63 -> 95
    //   35: aload_3
    //   36: instanceof 105
    //   39: ifeq +56 -> 95
    //   42: aload_0
    //   43: aload_3
    //   44: checkcast 105	android/media/MediaCodec$CodecException
    //   47: invokespecial 176	com/tencent/tav/decoder/MediaCodecWrapper:tryLogMediaCodecError	(Landroid/media/MediaCodec$CodecException;)V
    //   50: aload_3
    //   51: checkcast 105	android/media/MediaCodec$CodecException
    //   54: invokevirtual 108	android/media/MediaCodec$CodecException:isTransient	()Z
    //   57: ifeq +19 -> 76
    //   60: aload_0
    //   61: ldc2_w 10
    //   64: invokevirtual 180	com/tencent/tav/decoder/MediaCodecWrapper:waitTime	(J)V
    //   67: aload_0
    //   68: aload_1
    //   69: aload_2
    //   70: invokevirtual 255	com/tencent/tav/decoder/MediaCodecWrapper:startDecoder	(Landroid/view/Surface;Landroid/media/MediaFormat;)V
    //   73: aload_0
    //   74: monitorexit
    //   75: return
    //   76: aload_3
    //   77: checkcast 105	android/media/MediaCodec$CodecException
    //   80: invokevirtual 116	android/media/MediaCodec$CodecException:isRecoverable	()Z
    //   83: ifeq +12 -> 95
    //   86: aload_0
    //   87: aload_1
    //   88: aload_2
    //   89: invokevirtual 262	com/tencent/tav/decoder/MediaCodecWrapper:reset	(Landroid/view/Surface;Landroid/media/MediaFormat;)V
    //   92: aload_0
    //   93: monitorexit
    //   94: return
    //   95: aload_0
    //   96: getfield 49	com/tencent/tav/decoder/MediaCodecWrapper:videoDecoder	Lcom/tencent/tav/decoder/VideoDecoder;
    //   99: iconst_0
    //   100: invokevirtual 265	com/tencent/tav/decoder/VideoDecoder:release	(Z)V
    //   103: aload_3
    //   104: athrow
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	MediaCodecWrapper
    //   0	109	1	paramSurface	Surface
    //   0	109	2	paramMediaFormat	MediaFormat
    //   16	88	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	9	12	finally
    //   17	73	12	finally
    //   76	92	12	finally
    //   95	105	12	finally
    //   2	9	16	java/lang/Exception
  }
  
  /* Error */
  void waitTime(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	com/tencent/tav/decoder/MediaCodecWrapper:videoDecoder	Lcom/tencent/tav/decoder/VideoDecoder;
    //   6: lload_1
    //   7: invokevirtual 270	java/lang/Object:wait	(J)V
    //   10: goto +12 -> 22
    //   13: astore_3
    //   14: goto +11 -> 25
    //   17: astore_3
    //   18: aload_3
    //   19: invokevirtual 271	java/lang/InterruptedException:printStackTrace	()V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_3
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	29	0	this	MediaCodecWrapper
    //   0	29	1	paramLong	long
    //   13	1	3	localObject	Object
    //   17	11	3	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	10	13	finally
    //   18	22	13	finally
    //   2	10	17	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.MediaCodecWrapper
 * JD-Core Version:    0.7.0.1
 */