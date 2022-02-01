package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class AudioRecognition
{
  private static final int READ_FILE_HEADER_SIZE = 64;
  private static String TAG = "AudioRecognition";
  private static HashMap<String, AudioFormat.AudioType> mGuessFormatResultCache = new HashMap();
  private static HashMap<String, AudioFormat.AudioType> mRecognitionResultCache = new HashMap();
  
  public static int calcBitDept(long paramLong1, long paramLong2, int paramInt, long paramLong3)
  {
    if ((0L != paramLong2) && (paramInt != 0))
    {
      double d = (float)paramLong1 * 1000.0F / (float)(paramInt * paramLong2 * paramLong3);
      int i = (int)Math.round(d);
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("byteNumbers = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(",time = ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(",channels = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",sampleRate = ");
      localStringBuilder.append(paramLong3);
      localStringBuilder.append(",bitDept = ");
      localStringBuilder.append(d);
      Logger.i(str, localStringBuilder.toString());
      return i;
    }
    return 0;
  }
  
  public static int getAudioBitDept(BaseDecoder paramBaseDecoder, AudioInformation paramAudioInformation)
  {
    AudioFormat.AudioType localAudioType1 = paramAudioInformation.getAudioType();
    AudioFormat.AudioType localAudioType2 = AudioFormat.AudioType.FLAC;
    int k = 0;
    if (localAudioType1 == localAudioType2) {
      j = 1;
    } else {
      j = 0;
    }
    int i = k;
    if (j != 0) {
      try
      {
        long l = paramBaseDecoder.getMinBufferSize();
        i = (int)l;
      }
      catch (Throwable localThrowable)
      {
        Logger.e(TAG, localThrowable);
        i = k;
      }
    }
    k = AudioTrack.getMinBufferSize((int)paramAudioInformation.getSampleRate(), paramAudioInformation.getChannels(), 2);
    if (j == 0)
    {
      i = k;
      if (k % 2048 != 0) {
        i = (k / 2048 + 1) * 2048;
      }
    }
    k = paramBaseDecoder.decodeData(i, new byte[i]);
    int j = k;
    if (k <= 0) {
      j = i * 2;
    }
    return calcBitDept(j, paramBaseDecoder.getCurrentTime(), paramAudioInformation.getChannels(), paramAudioInformation.getSampleRate());
  }
  
  public static NativeDecoder getDecoderFormFile(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    NativeDecoder localNativeDecoder = new NativeDecoder();
    if (localNativeDecoder.init(paramString, false) == 0) {
      return localNativeDecoder;
    }
    return null;
  }
  
  public static AudioFormat.AudioType guessFormat(String paramString)
  {
    Object localObject1 = mGuessFormatResultCache;
    if ((localObject1 != null) && (((HashMap)localObject1).containsKey(paramString))) {
      return (AudioFormat.AudioType)mGuessFormatResultCache.get(paramString);
    }
    localObject1 = MediaCodecFactory.getSupportAudioType().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = MediaCodecFactory.createDecoderByType((AudioFormat.AudioType)((Iterator)localObject1).next());
      if (localObject2 != null)
      {
        localObject2 = ((IAudioRecognition)localObject2).guessAudioType(paramString);
        if (AudioFormat.isAudioType((AudioFormat.AudioType)localObject2))
        {
          mGuessFormatResultCache.put(paramString, localObject2);
          return localObject2;
        }
      }
    }
    return AudioFormat.AudioType.UNSUPPORT;
  }
  
  public static AudioFormat.AudioType recognitionAudioFormatByExtensions(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (mRecognitionResultCache.containsKey(paramString))
    {
      localObject1 = (AudioFormat.AudioType)mRecognitionResultCache.get(paramString);
      localObject3 = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Get from cache ");
      localStringBuilder.append(localObject1);
      localStringBuilder.append(",filepath = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",retType = ");
      localStringBuilder.append(localObject1);
      Logger.w((String)localObject3, localStringBuilder.toString());
      return localObject1;
    }
    Object localObject3 = guessFormat(paramString);
    Object localObject1 = localObject3;
    Object localObject2;
    if (!AudioFormat.isAudioType((AudioFormat.AudioType)localObject3))
    {
      localObject1 = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("recognitionAudioFormatByExtensions guessAudioType = null,so recognitionAudioFormatExactly filepath = ");
      localStringBuilder.append(paramString);
      Logger.i((String)localObject1, localStringBuilder.toString());
      try
      {
        localObject1 = recognitionAudioFormatExactly(paramString);
      }
      catch (IOException localIOException)
      {
        Logger.e(TAG, localIOException);
        localObject2 = localObject3;
      }
    }
    localObject3 = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("recognitionAudioFormatByExtensions filepath = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",guessAudioType = ");
    localStringBuilder.append(localObject2);
    Logger.i((String)localObject3, localStringBuilder.toString());
    return localObject2;
  }
  
  /* Error */
  public static AudioFormat.AudioType recognitionAudioFormatExactly(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 5
    //   12: aload_0
    //   13: ifnonnull +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: getstatic 26	com/tencent/qqmusic/mediaplayer/AudioRecognition:mGuessFormatResultCache	Ljava/util/HashMap;
    //   21: aload_0
    //   22: invokevirtual 224	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: pop
    //   26: getstatic 39	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   29: astore 6
    //   31: new 41	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   38: astore 8
    //   40: aload 8
    //   42: ldc 226
    //   44: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 8
    //   50: aload_0
    //   51: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 6
    //   57: aload 8
    //   59: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 75	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: new 228	java/io/File
    //   68: dup
    //   69: aload_0
    //   70: invokespecial 231	java/io/File:<init>	(Ljava/lang/String;)V
    //   73: astore 6
    //   75: aload 6
    //   77: invokevirtual 234	java/io/File:exists	()Z
    //   80: ifeq +792 -> 872
    //   83: aload 6
    //   85: invokevirtual 237	java/io/File:canRead	()Z
    //   88: ifeq +746 -> 834
    //   91: getstatic 39	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   94: astore 8
    //   96: new 41	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   103: astore 10
    //   105: aload 10
    //   107: ldc 239
    //   109: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 10
    //   115: aload 6
    //   117: invokevirtual 242	java/io/File:length	()J
    //   120: invokevirtual 51	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 8
    //   126: aload 10
    //   128: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 75	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: invokestatic 247	java/lang/System:currentTimeMillis	()J
    //   137: lstore_2
    //   138: aload_0
    //   139: invokestatic 208	com/tencent/qqmusic/mediaplayer/AudioRecognition:guessFormat	(Ljava/lang/String;)Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   142: astore 10
    //   144: invokestatic 153	com/tencent/qqmusic/mediaplayer/MediaCodecFactory:getSupportAudioType	()Ljava/util/ArrayList;
    //   147: astore 11
    //   149: aload 10
    //   151: ifnull +58 -> 209
    //   154: aload 11
    //   156: aload 10
    //   158: invokevirtual 250	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   161: ifeq +48 -> 209
    //   164: aload 11
    //   166: aload 10
    //   168: invokevirtual 252	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   171: pop
    //   172: aload 11
    //   174: iconst_0
    //   175: aload 10
    //   177: invokevirtual 256	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   180: getstatic 259	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:MP3	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   183: aload 10
    //   185: invokevirtual 262	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:equals	(Ljava/lang/Object;)Z
    //   188: ifeq +21 -> 209
    //   191: aload 11
    //   193: getstatic 91	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:FLAC	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   196: invokevirtual 252	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   199: pop
    //   200: aload 11
    //   202: iconst_0
    //   203: getstatic 91	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:FLAC	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   206: invokevirtual 256	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   209: aload_0
    //   210: invokestatic 266	com/tencent/qqmusic/mediaplayer/codec/MediaCodecDecoder:getAudioType	(Ljava/lang/String;)Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   213: astore 8
    //   215: aload 8
    //   217: invokestatic 184	com/tencent/qqmusic/mediaplayer/AudioFormat:isAudioType	(Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;)Z
    //   220: ifne +452 -> 672
    //   223: new 268	java/io/FileInputStream
    //   226: dup
    //   227: aload_0
    //   228: invokespecial 269	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   231: astore 6
    //   233: aload 7
    //   235: astore 4
    //   237: sipush 1024
    //   240: newarray byte
    //   242: astore 9
    //   244: aload 7
    //   246: astore 4
    //   248: aload 6
    //   250: aload 9
    //   252: invokevirtual 275	java/io/InputStream:read	([B)I
    //   255: istore_1
    //   256: iload_1
    //   257: bipush 64
    //   259: if_icmplt +28 -> 287
    //   262: aload 7
    //   264: astore 4
    //   266: bipush 64
    //   268: newarray byte
    //   270: astore 5
    //   272: aload 5
    //   274: astore 4
    //   276: aload 9
    //   278: iconst_0
    //   279: aload 5
    //   281: iconst_0
    //   282: bipush 64
    //   284: invokestatic 279	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   287: aload 5
    //   289: astore 4
    //   291: getstatic 39	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   294: astore 7
    //   296: aload 5
    //   298: astore 4
    //   300: new 41	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   307: astore 12
    //   309: aload 5
    //   311: astore 4
    //   313: aload 12
    //   315: ldc_w 281
    //   318: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 5
    //   324: astore 4
    //   326: aload 12
    //   328: new 283	java/lang/String
    //   331: dup
    //   332: aload 9
    //   334: iconst_0
    //   335: iload_1
    //   336: invokespecial 286	java/lang/String:<init>	([BII)V
    //   339: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload 5
    //   345: astore 4
    //   347: aload 12
    //   349: ldc_w 288
    //   352: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload 5
    //   358: astore 4
    //   360: aload 12
    //   362: aload_0
    //   363: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload 5
    //   369: astore 4
    //   371: aload 7
    //   373: aload 12
    //   375: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokestatic 75	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   381: aload 6
    //   383: invokevirtual 291	java/io/InputStream:close	()V
    //   386: goto +81 -> 467
    //   389: astore 4
    //   391: getstatic 39	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   394: aload 4
    //   396: invokestatic 101	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   399: goto +68 -> 467
    //   402: astore_0
    //   403: goto +244 -> 647
    //   406: astore 7
    //   408: aload 4
    //   410: astore 5
    //   412: goto +20 -> 432
    //   415: astore_0
    //   416: aload 4
    //   418: astore 6
    //   420: goto +227 -> 647
    //   423: astore 7
    //   425: aconst_null
    //   426: astore 5
    //   428: aload 9
    //   430: astore 6
    //   432: aload 6
    //   434: astore 4
    //   436: getstatic 39	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   439: aload 7
    //   441: invokestatic 101	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   444: aload 6
    //   446: ifnull +21 -> 467
    //   449: aload 6
    //   451: invokevirtual 291	java/io/InputStream:close	()V
    //   454: goto +13 -> 467
    //   457: astore 4
    //   459: getstatic 39	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   462: aload 4
    //   464: invokestatic 101	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   467: aload 11
    //   469: invokevirtual 159	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   472: astore 6
    //   474: aload 6
    //   476: invokeinterface 165 1 0
    //   481: ifeq +191 -> 672
    //   484: aload 6
    //   486: invokeinterface 169 1 0
    //   491: checkcast 87	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType
    //   494: invokestatic 173	com/tencent/qqmusic/mediaplayer/MediaCodecFactory:createDecoderByType	(Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;)Lcom/tencent/qqmusic/mediaplayer/codec/IAudioRecognition;
    //   497: astore 4
    //   499: aload 4
    //   501: ifnull -27 -> 474
    //   504: aload 4
    //   506: aload_0
    //   507: aload 5
    //   509: invokeinterface 294 3 0
    //   514: astore 4
    //   516: goto +21 -> 537
    //   519: astore 4
    //   521: getstatic 39	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   524: ldc_w 296
    //   527: aload 4
    //   529: invokestatic 299	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   532: getstatic 191	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:UNSUPPORT	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   535: astore 4
    //   537: aload 4
    //   539: invokestatic 184	com/tencent/qqmusic/mediaplayer/AudioFormat:isAudioType	(Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;)Z
    //   542: ifeq -68 -> 474
    //   545: getstatic 39	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   548: astore 5
    //   550: new 41	java/lang/StringBuilder
    //   553: dup
    //   554: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   557: astore 6
    //   559: aload 6
    //   561: ldc_w 301
    //   564: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: aload 6
    //   570: aload 4
    //   572: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   575: pop
    //   576: aload 6
    //   578: ldc_w 303
    //   581: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: pop
    //   585: aload 6
    //   587: aload_0
    //   588: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: pop
    //   592: aload 6
    //   594: ldc_w 305
    //   597: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: pop
    //   601: aload 6
    //   603: invokestatic 247	java/lang/System:currentTimeMillis	()J
    //   606: lload_2
    //   607: lsub
    //   608: invokevirtual 51	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   611: pop
    //   612: aload 6
    //   614: ldc_w 307
    //   617: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: pop
    //   621: aload 6
    //   623: aload 4
    //   625: aload 10
    //   627: invokevirtual 262	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:equals	(Ljava/lang/Object;)Z
    //   630: invokevirtual 310	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   633: pop
    //   634: aload 5
    //   636: aload 6
    //   638: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: invokestatic 206	com/tencent/qqmusic/mediaplayer/util/Logger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   644: goto +32 -> 676
    //   647: aload 6
    //   649: ifnull +21 -> 670
    //   652: aload 6
    //   654: invokevirtual 291	java/io/InputStream:close	()V
    //   657: goto +13 -> 670
    //   660: astore 4
    //   662: getstatic 39	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   665: aload 4
    //   667: invokestatic 101	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   670: aload_0
    //   671: athrow
    //   672: aload 8
    //   674: astore 4
    //   676: aload 4
    //   678: ifnonnull +11 -> 689
    //   681: getstatic 191	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:UNSUPPORT	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   684: astore 4
    //   686: goto +89 -> 775
    //   689: getstatic 39	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   692: astore 5
    //   694: new 41	java/lang/StringBuilder
    //   697: dup
    //   698: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   701: astore 6
    //   703: aload 6
    //   705: ldc_w 312
    //   708: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: pop
    //   712: aload 6
    //   714: aload_0
    //   715: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: aload 6
    //   721: ldc_w 314
    //   724: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: pop
    //   728: aload 6
    //   730: aload 4
    //   732: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   735: pop
    //   736: aload 6
    //   738: ldc_w 316
    //   741: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: pop
    //   745: aload 5
    //   747: aload 6
    //   749: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   752: invokestatic 75	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   755: getstatic 24	com/tencent/qqmusic/mediaplayer/AudioRecognition:mRecognitionResultCache	Ljava/util/HashMap;
    //   758: aload_0
    //   759: aload 4
    //   761: invokevirtual 188	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   764: pop
    //   765: getstatic 26	com/tencent/qqmusic/mediaplayer/AudioRecognition:mGuessFormatResultCache	Ljava/util/HashMap;
    //   768: aload_0
    //   769: aload 4
    //   771: invokevirtual 188	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   774: pop
    //   775: getstatic 39	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   778: astore 5
    //   780: new 41	java/lang/StringBuilder
    //   783: dup
    //   784: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   787: astore 6
    //   789: aload 6
    //   791: ldc_w 318
    //   794: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: pop
    //   798: aload 6
    //   800: aload_0
    //   801: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: pop
    //   805: aload 6
    //   807: ldc 203
    //   809: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: pop
    //   813: aload 6
    //   815: aload 4
    //   817: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   820: pop
    //   821: aload 5
    //   823: aload 6
    //   825: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   828: invokestatic 75	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   831: aload 4
    //   833: areturn
    //   834: new 41	java/lang/StringBuilder
    //   837: dup
    //   838: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   841: astore 4
    //   843: aload 4
    //   845: ldc_w 320
    //   848: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: pop
    //   852: aload 4
    //   854: aload_0
    //   855: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: pop
    //   859: new 194	java/io/IOException
    //   862: dup
    //   863: aload 4
    //   865: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   868: invokespecial 321	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   871: athrow
    //   872: new 41	java/lang/StringBuilder
    //   875: dup
    //   876: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   879: astore 4
    //   881: aload 4
    //   883: ldc_w 323
    //   886: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: pop
    //   890: aload 4
    //   892: aload_0
    //   893: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: pop
    //   897: new 325	java/io/FileNotFoundException
    //   900: dup
    //   901: aload 4
    //   903: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   906: invokespecial 326	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   909: astore_0
    //   910: goto +5 -> 915
    //   913: aload_0
    //   914: athrow
    //   915: goto -2 -> 913
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	918	0	paramString	String
    //   255	81	1	i	int
    //   137	470	2	l	long
    //   4	366	4	localObject1	Object
    //   389	28	4	localException1	java.lang.Exception
    //   434	1	4	localObject2	Object
    //   457	6	4	localException2	java.lang.Exception
    //   497	18	4	localObject3	Object
    //   519	9	4	localSoNotFindException	SoNotFindException
    //   535	89	4	localAudioType	AudioFormat.AudioType
    //   660	6	4	localException3	java.lang.Exception
    //   674	228	4	localObject4	Object
    //   10	812	5	localObject5	Object
    //   29	795	6	localObject6	Object
    //   1	371	7	str	String
    //   406	1	7	localException4	java.lang.Exception
    //   423	17	7	localException5	java.lang.Exception
    //   38	635	8	localObject7	Object
    //   7	422	9	arrayOfByte	byte[]
    //   103	523	10	localObject8	Object
    //   147	321	11	localArrayList	ArrayList
    //   307	67	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   381	386	389	java/lang/Exception
    //   237	244	402	finally
    //   248	256	402	finally
    //   266	272	402	finally
    //   276	287	402	finally
    //   291	296	402	finally
    //   300	309	402	finally
    //   313	322	402	finally
    //   326	343	402	finally
    //   347	356	402	finally
    //   360	367	402	finally
    //   371	381	402	finally
    //   237	244	406	java/lang/Exception
    //   248	256	406	java/lang/Exception
    //   266	272	406	java/lang/Exception
    //   276	287	406	java/lang/Exception
    //   291	296	406	java/lang/Exception
    //   300	309	406	java/lang/Exception
    //   313	322	406	java/lang/Exception
    //   326	343	406	java/lang/Exception
    //   347	356	406	java/lang/Exception
    //   360	367	406	java/lang/Exception
    //   371	381	406	java/lang/Exception
    //   223	233	415	finally
    //   436	444	415	finally
    //   223	233	423	java/lang/Exception
    //   449	454	457	java/lang/Exception
    //   504	516	519	com/tencent/qqmusic/mediaplayer/SoNotFindException
    //   652	657	660	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.AudioRecognition
 * JD-Core Version:    0.7.0.1
 */