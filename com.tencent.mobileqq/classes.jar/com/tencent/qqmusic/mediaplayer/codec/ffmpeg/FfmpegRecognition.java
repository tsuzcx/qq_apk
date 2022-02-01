package com.tencent.qqmusic.mediaplayer.codec.ffmpeg;

import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.io.IOException;

public class FfmpegRecognition
  implements IAudioRecognition
{
  private static final String SO_AUDIO_COMMON = "audio_common";
  private static final String SO_BASE_NAME = "FFmpeg";
  private static final String SO_NAME = "ffmpeg_decoder";
  private static final String SO_NEON_BASE_NAME = "FFmpeg_v7a";
  private static final String SO_NEON_NAME = "ffmpeg_decoder_v7a";
  private static final String TAG = "FfmpegRecognition";
  
  public static boolean isM4a(IDataSource paramIDataSource)
  {
    byte[] arrayOfByte = new byte[4];
    try
    {
      paramIDataSource.readAt(4L, arrayOfByte, 0, arrayOfByte.length);
      label18:
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (arrayOfByte[0] == 102)
      {
        bool1 = bool2;
        if (arrayOfByte[1] == 116)
        {
          bool1 = bool2;
          if (arrayOfByte[2] == 121)
          {
            bool1 = bool2;
            if (arrayOfByte[3] == 112) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    catch (IOException paramIDataSource)
    {
      break label18;
    }
  }
  
  /* Error */
  public AudioFormat.AudioType getAudioType(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +23 -> 24
    //   4: aload_2
    //   5: arraylength
    //   6: ifne +6 -> 12
    //   9: goto +15 -> 24
    //   12: new 48	java/lang/String
    //   15: dup
    //   16: aload_2
    //   17: invokespecial 51	java/lang/String:<init>	([B)V
    //   20: astore_1
    //   21: goto +110 -> 131
    //   24: new 53	java/io/FileInputStream
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 56	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   32: astore_3
    //   33: aload_3
    //   34: astore_1
    //   35: bipush 64
    //   37: newarray byte
    //   39: astore 4
    //   41: aload_3
    //   42: astore_1
    //   43: aload_3
    //   44: aload 4
    //   46: invokevirtual 62	java/io/InputStream:read	([B)I
    //   49: pop
    //   50: aload_3
    //   51: astore_1
    //   52: new 48	java/lang/String
    //   55: dup
    //   56: aload 4
    //   58: invokespecial 51	java/lang/String:<init>	([B)V
    //   61: astore 4
    //   63: aload_3
    //   64: invokevirtual 65	java/io/InputStream:close	()V
    //   67: goto +10 -> 77
    //   70: astore_1
    //   71: ldc 25
    //   73: aload_1
    //   74: invokestatic 71	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   77: aload 4
    //   79: astore_1
    //   80: goto +51 -> 131
    //   83: astore_2
    //   84: goto +114 -> 198
    //   87: astore 4
    //   89: goto +13 -> 102
    //   92: astore_2
    //   93: aconst_null
    //   94: astore_1
    //   95: goto +103 -> 198
    //   98: astore 4
    //   100: aconst_null
    //   101: astore_3
    //   102: aload_3
    //   103: astore_1
    //   104: ldc 25
    //   106: aload 4
    //   108: invokestatic 71	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   111: aload_3
    //   112: ifnull +17 -> 129
    //   115: aload_3
    //   116: invokevirtual 65	java/io/InputStream:close	()V
    //   119: goto +10 -> 129
    //   122: astore_1
    //   123: ldc 25
    //   125: aload_1
    //   126: invokestatic 71	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   129: aconst_null
    //   130: astore_1
    //   131: aload_1
    //   132: ifnull +16 -> 148
    //   135: aload_1
    //   136: ldc 73
    //   138: invokevirtual 77	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   141: ifeq +7 -> 148
    //   144: getstatic 83	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:M4A	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   147: areturn
    //   148: aload_2
    //   149: ifnull +45 -> 194
    //   152: aload_2
    //   153: arraylength
    //   154: iconst_2
    //   155: if_icmple +39 -> 194
    //   158: aload_2
    //   159: iconst_0
    //   160: baload
    //   161: iconst_m1
    //   162: if_icmpne +32 -> 194
    //   165: aload_2
    //   166: iconst_1
    //   167: baload
    //   168: sipush 240
    //   171: iand
    //   172: sipush 240
    //   175: if_icmpne +19 -> 194
    //   178: aload_2
    //   179: iconst_1
    //   180: baload
    //   181: bipush 15
    //   183: iand
    //   184: bipush 6
    //   186: iand
    //   187: ifne +7 -> 194
    //   190: getstatic 83	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:M4A	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   193: areturn
    //   194: getstatic 86	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:UNSUPPORT	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   197: areturn
    //   198: aload_1
    //   199: ifnull +17 -> 216
    //   202: aload_1
    //   203: invokevirtual 65	java/io/InputStream:close	()V
    //   206: goto +10 -> 216
    //   209: astore_1
    //   210: ldc 25
    //   212: aload_1
    //   213: invokestatic 71	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   216: aload_2
    //   217: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	FfmpegRecognition
    //   0	218	1	paramString	String
    //   0	218	2	paramArrayOfByte	byte[]
    //   32	84	3	localFileInputStream	java.io.FileInputStream
    //   39	39	4	localObject	Object
    //   87	1	4	localException1	java.lang.Exception
    //   98	9	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   63	67	70	java/lang/Exception
    //   35	41	83	finally
    //   43	50	83	finally
    //   52	63	83	finally
    //   104	111	83	finally
    //   35	41	87	java/lang/Exception
    //   43	50	87	java/lang/Exception
    //   52	63	87	java/lang/Exception
    //   24	33	92	finally
    //   24	33	98	java/lang/Exception
    //   115	119	122	java/lang/Exception
    //   202	206	209	java/lang/Exception
  }
  
  public AudioFormat.AudioType guessAudioType(String paramString)
  {
    return getAudioType(paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.ffmpeg.FfmpegRecognition
 * JD-Core Version:    0.7.0.1
 */