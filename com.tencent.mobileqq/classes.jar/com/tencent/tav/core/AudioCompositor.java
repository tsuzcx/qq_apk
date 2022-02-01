package com.tencent.tav.core;

import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.AudioMixer;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class AudioCompositor
{
  private final String TAG = "AudioCompositor@" + Integer.toHexString(hashCode());
  private AudioMixer audioMixer;
  @NonNull
  private final AudioResample audioResample = new AudioResample();
  private ShortBuffer currentSamples;
  private ShortBuffer lastSamples;
  
  public AudioCompositor(AudioInfo paramAudioInfo)
  {
    this.audioMixer = new AudioMixer(paramAudioInfo.sampleRate, paramAudioInfo.channelCount);
  }
  
  private AudioInfo resample(CMSampleBuffer paramCMSampleBuffer, AudioInfo paramAudioInfo)
  {
    ByteBuffer localByteBuffer2 = paramCMSampleBuffer.getSampleByteBuffer();
    if ((localByteBuffer2 == null) || (localByteBuffer2.limit() <= 0))
    {
      Logger.d(this.audioResample.TAG, "resample: 不进行重采样 byteBuffer = " + localByteBuffer2);
      return paramAudioInfo;
    }
    ByteBuffer localByteBuffer1 = this.audioResample.resample(localByteBuffer2, paramAudioInfo);
    if (localByteBuffer1 != null) {
      paramAudioInfo = this.audioResample.getDestAudioInfo();
    }
    for (;;)
    {
      paramCMSampleBuffer.setSampleByteBuffer(localByteBuffer1);
      return paramAudioInfo;
      localByteBuffer1 = localByteBuffer2;
    }
  }
  
  public void clear()
  {
    try
    {
      this.currentSamples = null;
      this.lastSamples = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public ByteBuffer processFrame(ByteBuffer paramByteBuffer, float paramFloat1, float paramFloat2, AudioInfo paramAudioInfo)
  {
    this.audioMixer.setAudioInfo(paramAudioInfo.sampleRate, paramAudioInfo.channelCount, paramAudioInfo.pcmEncoding);
    return this.audioMixer.processBytes(paramByteBuffer, paramFloat2, paramFloat1, 1.0F);
  }
  
  /* Error */
  public CMSampleBuffer readMergeSample(com.tencent.tav.decoder.AudioDecoderTrack paramAudioDecoderTrack, AudioMixInputParameters paramAudioMixInputParameters, CMSampleBuffer paramCMSampleBuffer)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_3
    //   6: ifnull +14 -> 20
    //   9: aload_3
    //   10: invokevirtual 74	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   13: ifnull +7 -> 20
    //   16: aload_1
    //   17: ifnonnull +21 -> 38
    //   20: aload_0
    //   21: aconst_null
    //   22: putfield 105	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 107	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   30: aload_3
    //   31: astore 9
    //   33: aload_0
    //   34: monitorexit
    //   35: aload 9
    //   37: areturn
    //   38: aload_3
    //   39: invokevirtual 74	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   42: invokevirtual 128	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   45: invokevirtual 131	java/nio/ShortBuffer:limit	()I
    //   48: istore 8
    //   50: aload_0
    //   51: getfield 105	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   54: ifnull +15 -> 69
    //   57: aload_0
    //   58: getfield 105	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   61: invokevirtual 134	java/nio/ShortBuffer:capacity	()I
    //   64: iload 8
    //   66: if_icmpge +278 -> 344
    //   69: iload 8
    //   71: iconst_2
    //   72: imul
    //   73: invokestatic 138	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   76: astore 9
    //   78: aload 9
    //   80: aload_3
    //   81: invokevirtual 74	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   84: invokevirtual 142	java/nio/ByteBuffer:order	()Ljava/nio/ByteOrder;
    //   87: invokevirtual 145	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   90: pop
    //   91: aload_0
    //   92: aload 9
    //   94: invokevirtual 128	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   97: putfield 105	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   100: aload_0
    //   101: getfield 107	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   104: ifnull +91 -> 195
    //   107: aload_0
    //   108: getfield 107	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   111: invokevirtual 148	java/nio/ShortBuffer:remaining	()I
    //   114: ifle +81 -> 195
    //   117: iload 8
    //   119: aload_0
    //   120: getfield 107	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   123: invokevirtual 148	java/nio/ShortBuffer:remaining	()I
    //   126: if_icmpge +234 -> 360
    //   129: aload_0
    //   130: getfield 107	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   133: invokevirtual 151	java/nio/ShortBuffer:position	()I
    //   136: istore 6
    //   138: aload_0
    //   139: getfield 107	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   142: invokevirtual 131	java/nio/ShortBuffer:limit	()I
    //   145: istore 7
    //   147: aload_0
    //   148: getfield 107	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   151: iload 6
    //   153: iload 8
    //   155: iadd
    //   156: invokevirtual 154	java/nio/ShortBuffer:limit	(I)Ljava/nio/Buffer;
    //   159: pop
    //   160: aload_0
    //   161: getfield 105	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   164: aload_0
    //   165: getfield 107	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   168: invokevirtual 158	java/nio/ShortBuffer:put	(Ljava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;
    //   171: pop
    //   172: aload_0
    //   173: getfield 107	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   176: iload 7
    //   178: invokevirtual 154	java/nio/ShortBuffer:limit	(I)Ljava/nio/Buffer;
    //   181: pop
    //   182: aload_0
    //   183: getfield 107	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   186: iload 6
    //   188: iload 8
    //   190: iadd
    //   191: invokevirtual 160	java/nio/ShortBuffer:position	(I)Ljava/nio/Buffer;
    //   194: pop
    //   195: aload_0
    //   196: getfield 105	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   199: invokevirtual 151	java/nio/ShortBuffer:position	()I
    //   202: istore 7
    //   204: iload 7
    //   206: iload 8
    //   208: if_icmpge +386 -> 594
    //   211: aload_1
    //   212: aload_3
    //   213: invokevirtual 164	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   216: invokevirtual 170	com/tencent/tav/decoder/AudioDecoderTrack:readSample	(Lcom/tencent/tav/coremedia/CMTime;)Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   219: astore 10
    //   221: aload_0
    //   222: getfield 44	com/tencent/tav/core/AudioCompositor:TAG	Ljava/lang/String;
    //   225: astore 9
    //   227: new 21	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   234: ldc 172
    //   236: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: astore 11
    //   241: iload 5
    //   243: iconst_1
    //   244: iadd
    //   245: istore 6
    //   247: aload 9
    //   249: aload 11
    //   251: iload 5
    //   253: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   256: ldc 177
    //   258: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload 10
    //   263: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 180	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   272: aload_3
    //   273: astore 9
    //   275: aload 10
    //   277: invokevirtual 184	com/tencent/tav/coremedia/CMSampleBuffer:getState	()Lcom/tencent/tav/coremedia/CMSampleState;
    //   280: invokevirtual 190	com/tencent/tav/coremedia/CMSampleState:getStateCode	()J
    //   283: ldc2_w 191
    //   286: lcmp
    //   287: ifle -254 -> 33
    //   290: aload_1
    //   291: aload 10
    //   293: invokevirtual 164	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   296: invokevirtual 196	com/tencent/tav/decoder/AudioDecoderTrack:asyncReadNextSample	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   299: aload_2
    //   300: ifnull +90 -> 390
    //   303: aload_2
    //   304: aload 10
    //   306: invokevirtual 164	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   309: invokevirtual 202	com/tencent/tav/core/AudioMixInputParameters:getVolumeAtTime	(Lcom/tencent/tav/coremedia/CMTime;)F
    //   312: fstore 4
    //   314: aload 10
    //   316: invokevirtual 74	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   319: ifnull +393 -> 712
    //   322: aload 10
    //   324: invokevirtual 74	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   327: invokevirtual 79	java/nio/ByteBuffer:limit	()I
    //   330: istore 5
    //   332: iload 5
    //   334: ifgt +62 -> 396
    //   337: iload 6
    //   339: istore 5
    //   341: goto -137 -> 204
    //   344: aload_0
    //   345: getfield 105	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   348: invokevirtual 205	java/nio/ShortBuffer:clear	()Ljava/nio/Buffer;
    //   351: pop
    //   352: goto -252 -> 100
    //   355: astore_1
    //   356: aload_0
    //   357: monitorexit
    //   358: aload_1
    //   359: athrow
    //   360: aload_0
    //   361: getfield 105	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   364: aload_0
    //   365: getfield 107	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   368: invokevirtual 158	java/nio/ShortBuffer:put	(Ljava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;
    //   371: pop
    //   372: aload_0
    //   373: getfield 107	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   376: aload_0
    //   377: getfield 107	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   380: invokevirtual 131	java/nio/ShortBuffer:limit	()I
    //   383: invokevirtual 160	java/nio/ShortBuffer:position	(I)Ljava/nio/Buffer;
    //   386: pop
    //   387: goto -192 -> 195
    //   390: fconst_1
    //   391: fstore 4
    //   393: goto -79 -> 314
    //   396: aload_0
    //   397: aload 10
    //   399: aload_1
    //   400: invokevirtual 208	com/tencent/tav/decoder/AudioDecoderTrack:getAudioInfo	()Lcom/tencent/tav/decoder/AudioInfo;
    //   403: invokespecial 210	com/tencent/tav/core/AudioCompositor:resample	(Lcom/tencent/tav/coremedia/CMSampleBuffer;Lcom/tencent/tav/decoder/AudioInfo;)Lcom/tencent/tav/decoder/AudioInfo;
    //   406: astore 9
    //   408: aload_2
    //   409: ifnull +36 -> 445
    //   412: aload_2
    //   413: invokevirtual 214	com/tencent/tav/core/AudioMixInputParameters:getAudioTapProcessor	()Lcom/tencent/tav/core/AudioTapProcessor;
    //   416: ifnull +29 -> 445
    //   419: aload 10
    //   421: aload_2
    //   422: invokevirtual 214	com/tencent/tav/core/AudioMixInputParameters:getAudioTapProcessor	()Lcom/tencent/tav/core/AudioTapProcessor;
    //   425: aload 10
    //   427: invokevirtual 164	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   430: aload 10
    //   432: invokevirtual 74	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   435: aload 9
    //   437: invokeinterface 220 4 0
    //   442: invokevirtual 102	com/tencent/tav/coremedia/CMSampleBuffer:setSampleByteBuffer	(Ljava/nio/ByteBuffer;)V
    //   445: aload_0
    //   446: aload 10
    //   448: invokevirtual 74	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   451: fload 4
    //   453: fconst_1
    //   454: aload 9
    //   456: invokevirtual 222	com/tencent/tav/core/AudioCompositor:processFrame	(Ljava/nio/ByteBuffer;FFLcom/tencent/tav/decoder/AudioInfo;)Ljava/nio/ByteBuffer;
    //   459: invokevirtual 128	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   462: astore 9
    //   464: aload 9
    //   466: invokevirtual 131	java/nio/ShortBuffer:limit	()I
    //   469: iload 8
    //   471: iload 7
    //   473: isub
    //   474: if_icmple +207 -> 681
    //   477: aload 9
    //   479: invokevirtual 131	java/nio/ShortBuffer:limit	()I
    //   482: iload 8
    //   484: iload 7
    //   486: isub
    //   487: isub
    //   488: istore 5
    //   490: aload_0
    //   491: getfield 107	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   494: ifnull +15 -> 509
    //   497: aload_0
    //   498: getfield 107	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   501: invokevirtual 134	java/nio/ShortBuffer:capacity	()I
    //   504: iload 5
    //   506: if_icmpge +132 -> 638
    //   509: iload 5
    //   511: iconst_2
    //   512: imul
    //   513: invokestatic 138	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   516: astore_1
    //   517: aload_1
    //   518: aload_3
    //   519: invokevirtual 74	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   522: invokevirtual 142	java/nio/ByteBuffer:order	()Ljava/nio/ByteOrder;
    //   525: invokevirtual 145	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   528: pop
    //   529: aload_0
    //   530: aload_1
    //   531: invokevirtual 128	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   534: putfield 107	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   537: aload 9
    //   539: iload 8
    //   541: iload 7
    //   543: isub
    //   544: invokevirtual 160	java/nio/ShortBuffer:position	(I)Ljava/nio/Buffer;
    //   547: pop
    //   548: aload_0
    //   549: getfield 107	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   552: aload 9
    //   554: invokevirtual 158	java/nio/ShortBuffer:put	(Ljava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;
    //   557: pop
    //   558: aload_0
    //   559: getfield 107	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   562: invokevirtual 225	java/nio/ShortBuffer:flip	()Ljava/nio/Buffer;
    //   565: pop
    //   566: aload 9
    //   568: iconst_0
    //   569: invokevirtual 160	java/nio/ShortBuffer:position	(I)Ljava/nio/Buffer;
    //   572: pop
    //   573: aload 9
    //   575: iload 8
    //   577: iload 7
    //   579: isub
    //   580: invokevirtual 154	java/nio/ShortBuffer:limit	(I)Ljava/nio/Buffer;
    //   583: pop
    //   584: aload_0
    //   585: getfield 105	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   588: aload 9
    //   590: invokevirtual 158	java/nio/ShortBuffer:put	(Ljava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;
    //   593: pop
    //   594: aload_0
    //   595: getfield 105	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   598: invokevirtual 225	java/nio/ShortBuffer:flip	()Ljava/nio/Buffer;
    //   601: pop
    //   602: aload_0
    //   603: getfield 65	com/tencent/tav/core/AudioCompositor:audioMixer	Lcom/tencent/tav/decoder/AudioMixer;
    //   606: aload_3
    //   607: invokevirtual 74	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   610: invokevirtual 128	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   613: aload_0
    //   614: getfield 105	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   617: invokevirtual 229	com/tencent/tav/decoder/AudioMixer:mergeSamples	(Ljava/nio/ShortBuffer;Ljava/nio/ShortBuffer;)Ljava/nio/ByteBuffer;
    //   620: astore_1
    //   621: new 70	com/tencent/tav/coremedia/CMSampleBuffer
    //   624: dup
    //   625: aload_3
    //   626: invokevirtual 164	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   629: aload_1
    //   630: invokespecial 232	com/tencent/tav/coremedia/CMSampleBuffer:<init>	(Lcom/tencent/tav/coremedia/CMTime;Ljava/nio/ByteBuffer;)V
    //   633: astore 9
    //   635: goto -602 -> 33
    //   638: aload_0
    //   639: getfield 107	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   642: invokevirtual 205	java/nio/ShortBuffer:clear	()Ljava/nio/Buffer;
    //   645: pop
    //   646: goto -109 -> 537
    //   649: astore_1
    //   650: aload_0
    //   651: getfield 44	com/tencent/tav/core/AudioCompositor:TAG	Ljava/lang/String;
    //   654: ldc 234
    //   656: aload_1
    //   657: invokestatic 238	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   660: new 70	com/tencent/tav/coremedia/CMSampleBuffer
    //   663: dup
    //   664: ldc2_w 191
    //   667: ldc 240
    //   669: aload_1
    //   670: invokestatic 244	com/tencent/tav/coremedia/CMSampleState:fromError	(JLjava/lang/String;Ljava/lang/Throwable;)Lcom/tencent/tav/coremedia/CMSampleState;
    //   673: invokespecial 247	com/tencent/tav/coremedia/CMSampleBuffer:<init>	(Lcom/tencent/tav/coremedia/CMSampleState;)V
    //   676: astore 9
    //   678: goto -645 -> 33
    //   681: aload_0
    //   682: getfield 105	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   685: aload 9
    //   687: invokevirtual 158	java/nio/ShortBuffer:put	(Ljava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;
    //   690: pop
    //   691: aload 9
    //   693: invokevirtual 131	java/nio/ShortBuffer:limit	()I
    //   696: istore 5
    //   698: iload 5
    //   700: iload 7
    //   702: iadd
    //   703: istore 7
    //   705: iload 6
    //   707: istore 5
    //   709: goto -505 -> 204
    //   712: iload 6
    //   714: istore 5
    //   716: goto -512 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	719	0	this	AudioCompositor
    //   0	719	1	paramAudioDecoderTrack	com.tencent.tav.decoder.AudioDecoderTrack
    //   0	719	2	paramAudioMixInputParameters	AudioMixInputParameters
    //   0	719	3	paramCMSampleBuffer	CMSampleBuffer
    //   312	140	4	f	float
    //   1	714	5	i	int
    //   136	577	6	j	int
    //   145	559	7	k	int
    //   48	532	8	m	int
    //   31	661	9	localObject	Object
    //   219	228	10	localCMSampleBuffer	CMSampleBuffer
    //   239	11	11	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   9	16	355	finally
    //   20	30	355	finally
    //   38	69	355	finally
    //   69	100	355	finally
    //   100	195	355	finally
    //   195	204	355	finally
    //   211	241	355	finally
    //   247	272	355	finally
    //   275	299	355	finally
    //   303	314	355	finally
    //   314	332	355	finally
    //   344	352	355	finally
    //   360	387	355	finally
    //   396	408	355	finally
    //   412	445	355	finally
    //   445	509	355	finally
    //   509	537	355	finally
    //   537	594	355	finally
    //   594	635	355	finally
    //   638	646	355	finally
    //   650	678	355	finally
    //   681	698	355	finally
    //   211	241	649	java/lang/Throwable
    //   247	272	649	java/lang/Throwable
    //   275	299	649	java/lang/Throwable
    //   303	314	649	java/lang/Throwable
    //   314	332	649	java/lang/Throwable
    //   396	408	649	java/lang/Throwable
    //   412	445	649	java/lang/Throwable
    //   445	509	649	java/lang/Throwable
    //   509	537	649	java/lang/Throwable
    //   537	594	649	java/lang/Throwable
    //   594	635	649	java/lang/Throwable
    //   638	646	649	java/lang/Throwable
    //   681	698	649	java/lang/Throwable
  }
  
  public void release()
  {
    this.audioResample.release();
  }
  
  public void setAudioInfo(AudioInfo paramAudioInfo)
  {
    this.audioMixer = new AudioMixer(paramAudioInfo.sampleRate, paramAudioInfo.channelCount);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.core.AudioCompositor
 * JD-Core Version:    0.7.0.1
 */