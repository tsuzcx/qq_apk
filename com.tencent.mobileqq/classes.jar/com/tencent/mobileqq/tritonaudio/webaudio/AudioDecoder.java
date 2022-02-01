package com.tencent.mobileqq.tritonaudio.webaudio;

import android.media.AudioAttributes.Builder;
import android.media.AudioFormat.Builder;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import androidx.annotation.RequiresApi;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import java.io.IOException;

class AudioDecoder
{
  private static final long DEFAULT_TIMEOUT = 2000L;
  private static final String TAG = "AudioDecoder";
  private int decodeId = -1;
  private boolean isFirst = true;
  private MediaCodec mediaCodec;
  private MediaExtractor mediaExtractor;
  private MediaFormat oformat;
  private AudioDecoder.OnDecodeProcessListener onDecodeProcessListener;
  
  /* Error */
  @RequiresApi(api=16)
  private byte[] doDecode()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:mediaCodec	Landroid/media/MediaCodec;
    //   4: invokevirtual 48	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   7: astore 9
    //   9: aload_0
    //   10: getfield 42	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:mediaCodec	Landroid/media/MediaCodec;
    //   13: invokevirtual 51	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   16: astore 7
    //   18: new 53	android/media/MediaCodec$BufferInfo
    //   21: dup
    //   22: invokespecial 54	android/media/MediaCodec$BufferInfo:<init>	()V
    //   25: astore 10
    //   27: new 56	java/io/ByteArrayOutputStream
    //   30: dup
    //   31: invokespecial 57	java/io/ByteArrayOutputStream:<init>	()V
    //   34: astore 8
    //   36: iconst_0
    //   37: istore_1
    //   38: iconst_0
    //   39: istore_2
    //   40: iload_1
    //   41: ifne +295 -> 336
    //   44: iload_2
    //   45: istore_3
    //   46: iload_2
    //   47: ifne +95 -> 142
    //   50: aload_0
    //   51: getfield 42	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:mediaCodec	Landroid/media/MediaCodec;
    //   54: ldc2_w 7
    //   57: invokevirtual 61	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   60: istore 4
    //   62: iload_2
    //   63: istore_3
    //   64: iload 4
    //   66: iflt +76 -> 142
    //   69: aload 9
    //   71: iload 4
    //   73: aaload
    //   74: astore 11
    //   76: aload_0
    //   77: getfield 63	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:mediaExtractor	Landroid/media/MediaExtractor;
    //   80: aload 11
    //   82: iconst_0
    //   83: invokevirtual 69	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   86: istore_3
    //   87: iload_3
    //   88: ifge +21 -> 109
    //   91: aload_0
    //   92: getfield 42	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:mediaCodec	Landroid/media/MediaCodec;
    //   95: iload 4
    //   97: iconst_0
    //   98: iconst_0
    //   99: lconst_0
    //   100: iconst_4
    //   101: invokevirtual 73	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   104: iconst_1
    //   105: istore_3
    //   106: goto +36 -> 142
    //   109: aload_0
    //   110: getfield 63	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:mediaExtractor	Landroid/media/MediaExtractor;
    //   113: invokevirtual 77	android/media/MediaExtractor:getSampleTime	()J
    //   116: lstore 5
    //   118: aload_0
    //   119: getfield 42	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:mediaCodec	Landroid/media/MediaCodec;
    //   122: iload 4
    //   124: iconst_0
    //   125: iload_3
    //   126: lload 5
    //   128: iconst_0
    //   129: invokevirtual 73	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   132: aload_0
    //   133: getfield 63	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:mediaExtractor	Landroid/media/MediaExtractor;
    //   136: invokevirtual 81	android/media/MediaExtractor:advance	()Z
    //   139: pop
    //   140: iload_2
    //   141: istore_3
    //   142: aload_0
    //   143: getfield 42	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:mediaCodec	Landroid/media/MediaCodec;
    //   146: aload 10
    //   148: ldc2_w 7
    //   151: invokevirtual 85	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   154: istore 4
    //   156: iload 4
    //   158: iflt +132 -> 290
    //   161: aload 10
    //   163: getfield 88	android/media/MediaCodec$BufferInfo:flags	I
    //   166: iconst_2
    //   167: iand
    //   168: ifeq +18 -> 186
    //   171: aload_0
    //   172: getfield 42	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:mediaCodec	Landroid/media/MediaCodec;
    //   175: iload 4
    //   177: iconst_0
    //   178: invokevirtual 92	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   181: iload_3
    //   182: istore_2
    //   183: goto -143 -> 40
    //   186: aload 10
    //   188: getfield 95	android/media/MediaCodec$BufferInfo:size	I
    //   191: ifeq +70 -> 261
    //   194: aload 7
    //   196: iload 4
    //   198: aaload
    //   199: astore 11
    //   201: aload 10
    //   203: getfield 95	android/media/MediaCodec$BufferInfo:size	I
    //   206: newarray byte
    //   208: astore 12
    //   210: aload 11
    //   212: aload 12
    //   214: invokevirtual 101	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   217: pop
    //   218: aload_0
    //   219: getfield 103	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:onDecodeProcessListener	Lcom/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder$OnDecodeProcessListener;
    //   222: ifnull +28 -> 250
    //   225: aload_0
    //   226: getfield 103	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:onDecodeProcessListener	Lcom/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder$OnDecodeProcessListener;
    //   229: aload 12
    //   231: aload_0
    //   232: getfield 105	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:oformat	Landroid/media/MediaFormat;
    //   235: aload_0
    //   236: getfield 30	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:isFirst	Z
    //   239: iconst_0
    //   240: invokeinterface 111 5 0
    //   245: aload_0
    //   246: iconst_0
    //   247: putfield 30	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:isFirst	Z
    //   250: aload 12
    //   252: arraylength
    //   253: istore_2
    //   254: aload 8
    //   256: aload 12
    //   258: invokevirtual 115	java/io/ByteArrayOutputStream:write	([B)V
    //   261: aload_0
    //   262: getfield 42	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:mediaCodec	Landroid/media/MediaCodec;
    //   265: iload 4
    //   267: iconst_0
    //   268: invokevirtual 92	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   271: iload_3
    //   272: istore_2
    //   273: aload 10
    //   275: getfield 88	android/media/MediaCodec$BufferInfo:flags	I
    //   278: iconst_4
    //   279: iand
    //   280: ifeq -240 -> 40
    //   283: iconst_1
    //   284: istore_1
    //   285: iload_3
    //   286: istore_2
    //   287: goto -247 -> 40
    //   290: iload 4
    //   292: bipush 253
    //   294: if_icmpne +17 -> 311
    //   297: aload_0
    //   298: getfield 42	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:mediaCodec	Landroid/media/MediaCodec;
    //   301: invokevirtual 51	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   304: astore 7
    //   306: iload_3
    //   307: istore_2
    //   308: goto -268 -> 40
    //   311: iload_3
    //   312: istore_2
    //   313: iload 4
    //   315: bipush 254
    //   317: if_icmpne -277 -> 40
    //   320: aload_0
    //   321: aload_0
    //   322: getfield 42	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:mediaCodec	Landroid/media/MediaCodec;
    //   325: invokevirtual 119	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   328: putfield 105	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:oformat	Landroid/media/MediaFormat;
    //   331: iload_3
    //   332: istore_2
    //   333: goto -293 -> 40
    //   336: aload_0
    //   337: getfield 103	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:onDecodeProcessListener	Lcom/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder$OnDecodeProcessListener;
    //   340: ifnull +19 -> 359
    //   343: aload_0
    //   344: getfield 103	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:onDecodeProcessListener	Lcom/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder$OnDecodeProcessListener;
    //   347: aconst_null
    //   348: aload_0
    //   349: getfield 105	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:oformat	Landroid/media/MediaFormat;
    //   352: iconst_0
    //   353: iconst_1
    //   354: invokeinterface 111 5 0
    //   359: aload 8
    //   361: invokevirtual 122	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   364: astore 7
    //   366: aload 8
    //   368: invokevirtual 125	java/io/ByteArrayOutputStream:close	()V
    //   371: aload_0
    //   372: getfield 42	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:mediaCodec	Landroid/media/MediaCodec;
    //   375: invokevirtual 128	android/media/MediaCodec:stop	()V
    //   378: aload_0
    //   379: getfield 42	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:mediaCodec	Landroid/media/MediaCodec;
    //   382: invokevirtual 131	android/media/MediaCodec:release	()V
    //   385: aload_0
    //   386: getfield 63	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:mediaExtractor	Landroid/media/MediaExtractor;
    //   389: invokevirtual 132	android/media/MediaExtractor:release	()V
    //   392: aload 7
    //   394: areturn
    //   395: astore 8
    //   397: ldc 12
    //   399: ldc 134
    //   401: aload 8
    //   403: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   406: pop
    //   407: aload 7
    //   409: areturn
    //   410: astore 7
    //   412: goto +53 -> 465
    //   415: astore 7
    //   417: aload 7
    //   419: invokevirtual 143	java/lang/Exception:printStackTrace	()V
    //   422: aload 8
    //   424: invokevirtual 125	java/io/ByteArrayOutputStream:close	()V
    //   427: aload_0
    //   428: getfield 42	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:mediaCodec	Landroid/media/MediaCodec;
    //   431: invokevirtual 128	android/media/MediaCodec:stop	()V
    //   434: aload_0
    //   435: getfield 42	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:mediaCodec	Landroid/media/MediaCodec;
    //   438: invokevirtual 131	android/media/MediaCodec:release	()V
    //   441: aload_0
    //   442: getfield 63	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:mediaExtractor	Landroid/media/MediaExtractor;
    //   445: invokevirtual 132	android/media/MediaExtractor:release	()V
    //   448: goto +15 -> 463
    //   451: astore 7
    //   453: ldc 12
    //   455: ldc 134
    //   457: aload 7
    //   459: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   462: pop
    //   463: aconst_null
    //   464: areturn
    //   465: aload 8
    //   467: invokevirtual 125	java/io/ByteArrayOutputStream:close	()V
    //   470: aload_0
    //   471: getfield 42	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:mediaCodec	Landroid/media/MediaCodec;
    //   474: invokevirtual 128	android/media/MediaCodec:stop	()V
    //   477: aload_0
    //   478: getfield 42	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:mediaCodec	Landroid/media/MediaCodec;
    //   481: invokevirtual 131	android/media/MediaCodec:release	()V
    //   484: aload_0
    //   485: getfield 63	com/tencent/mobileqq/tritonaudio/webaudio/AudioDecoder:mediaExtractor	Landroid/media/MediaExtractor;
    //   488: invokevirtual 132	android/media/MediaExtractor:release	()V
    //   491: goto +15 -> 506
    //   494: astore 8
    //   496: ldc 12
    //   498: ldc 134
    //   500: aload 8
    //   502: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   505: pop
    //   506: goto +6 -> 512
    //   509: aload 7
    //   511: athrow
    //   512: goto -3 -> 509
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	515	0	this	AudioDecoder
    //   37	248	1	i	int
    //   39	294	2	j	int
    //   45	287	3	k	int
    //   60	258	4	m	int
    //   116	11	5	l	long
    //   16	392	7	localObject1	Object
    //   410	1	7	localObject2	Object
    //   415	3	7	localException1	Exception
    //   451	59	7	localException2	Exception
    //   34	333	8	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   395	71	8	localException3	Exception
    //   494	7	8	localException4	Exception
    //   7	63	9	arrayOfByteBuffer	java.nio.ByteBuffer[]
    //   25	249	10	localBufferInfo	android.media.MediaCodec.BufferInfo
    //   74	137	11	localByteBuffer	java.nio.ByteBuffer
    //   208	49	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   366	392	395	java/lang/Exception
    //   50	62	410	finally
    //   76	87	410	finally
    //   91	104	410	finally
    //   109	140	410	finally
    //   142	156	410	finally
    //   161	181	410	finally
    //   186	194	410	finally
    //   201	250	410	finally
    //   250	261	410	finally
    //   261	271	410	finally
    //   273	283	410	finally
    //   297	306	410	finally
    //   320	331	410	finally
    //   336	359	410	finally
    //   359	366	410	finally
    //   417	422	410	finally
    //   50	62	415	java/lang/Exception
    //   76	87	415	java/lang/Exception
    //   91	104	415	java/lang/Exception
    //   109	140	415	java/lang/Exception
    //   142	156	415	java/lang/Exception
    //   161	181	415	java/lang/Exception
    //   186	194	415	java/lang/Exception
    //   201	250	415	java/lang/Exception
    //   250	261	415	java/lang/Exception
    //   261	271	415	java/lang/Exception
    //   273	283	415	java/lang/Exception
    //   297	306	415	java/lang/Exception
    //   320	331	415	java/lang/Exception
    //   336	359	415	java/lang/Exception
    //   359	366	415	java/lang/Exception
    //   422	448	451	java/lang/Exception
    //   465	491	494	java/lang/Exception
  }
  
  @RequiresApi(api=16)
  private boolean initMediaCodec()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.mediaExtractor.getTrackCount())
        {
          MediaFormat localMediaFormat = this.mediaExtractor.getTrackFormat(i);
          String str = localMediaFormat.getString("mime");
          if (!str.startsWith("audio")) {
            break label93;
          }
          this.mediaExtractor.selectTrack(i);
          this.mediaCodec = MediaCodec.createDecoderByType(str);
          this.mediaCodec.configure(localMediaFormat, null, null, 0);
        }
        if (this.mediaCodec == null) {
          return false;
        }
        this.mediaCodec.start();
        return true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
      label93:
      i += 1;
    }
  }
  
  @RequiresApi(api=16)
  private boolean initMediaExtractor(String paramString)
  {
    try
    {
      this.mediaExtractor = new MediaExtractor();
      this.mediaExtractor.setDataSource(paramString);
      return true;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  @RequiresApi(api=23)
  private boolean initMediaExtractor(byte[] paramArrayOfByte)
  {
    try
    {
      this.mediaExtractor = new MediaExtractor();
      this.mediaExtractor.setDataSource(new AudioDecoder.MyMediaDataSource(this, paramArrayOfByte));
      return true;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return false;
  }
  
  @RequiresApi(api=21)
  private void testRawData(byte[] paramArrayOfByte)
  {
    int i;
    if (this.oformat.getInteger("channel-count") == 1) {
      i = 4;
    } else {
      i = 12;
    }
    ReportAudioTrack localReportAudioTrack = new ReportAudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(2).build(), new AudioFormat.Builder().setSampleRate(this.oformat.getInteger("sample-rate")).setChannelMask(i).setEncoding(this.oformat.getInteger("pcm-encoding")).build(), paramArrayOfByte.length, 0, 0);
    localReportAudioTrack.write(paramArrayOfByte, 0, paramArrayOfByte.length);
    localReportAudioTrack.play();
  }
  
  @RequiresApi(api=16)
  public byte[] decodeByPath(String paramString, int paramInt)
  {
    this.decodeId = paramInt;
    if ((initMediaExtractor(paramString)) && (initMediaCodec())) {
      return doDecode();
    }
    return null;
  }
  
  @RequiresApi(api=23)
  public byte[] decodeInMemory(byte[] paramArrayOfByte, int paramInt)
  {
    this.decodeId = paramInt;
    if ((initMediaExtractor(paramArrayOfByte)) && (initMediaCodec())) {
      return doDecode();
    }
    return null;
  }
  
  @RequiresApi(api=16)
  public int getBitsPerChannel()
  {
    if (this.oformat == null) {
      return 0;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      int i;
      if (this.oformat.containsKey("pcm-encoding")) {
        i = this.oformat.getInteger("pcm-encoding");
      } else {
        i = 2;
      }
      if (i == 3) {
        return 8;
      }
      return 16;
    }
    return this.oformat.getInteger("bit-width");
  }
  
  @RequiresApi(api=16)
  public int getChannelCount()
  {
    MediaFormat localMediaFormat = this.oformat;
    if (localMediaFormat == null) {
      return 0;
    }
    return localMediaFormat.getInteger("channel-count");
  }
  
  @RequiresApi(api=16)
  public int getSampleRate()
  {
    MediaFormat localMediaFormat = this.oformat;
    if (localMediaFormat == null) {
      return 0;
    }
    return localMediaFormat.getInteger("sample-rate");
  }
  
  public void setOnDecodeProcessListener(AudioDecoder.OnDecodeProcessListener paramOnDecodeProcessListener)
  {
    this.onDecodeProcessListener = paramOnDecodeProcessListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.webaudio.AudioDecoder
 * JD-Core Version:    0.7.0.1
 */