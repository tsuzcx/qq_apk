package com.tencent.qqmusic.mediaplayer.codec.wma;

import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;

public class WmaRecognition
  implements IAudioRecognition
{
  public static String TAG = "WmaRecognition";
  private final int HEARER_LENGTH = 16;
  private final byte[] WMA_HEADER = { 48, 38, -78, 117, -114, 102, -49, 17, -90, -39, 0, -86, 0, 98, -50, 108 };
  
  /* Error */
  public AudioFormat.AudioType getAudioType(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +13 -> 14
    //   4: aload_2
    //   5: arraylength
    //   6: bipush 16
    //   8: if_icmplt +6 -> 14
    //   11: goto +117 -> 128
    //   14: aconst_null
    //   15: astore_2
    //   16: aconst_null
    //   17: astore 5
    //   19: aconst_null
    //   20: astore 6
    //   22: new 45	java/io/FileInputStream
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 48	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   30: astore 4
    //   32: aload 6
    //   34: astore_1
    //   35: bipush 16
    //   37: newarray byte
    //   39: astore_2
    //   40: aload_2
    //   41: astore_1
    //   42: aload 4
    //   44: aload_2
    //   45: invokevirtual 54	java/io/InputStream:read	([B)I
    //   48: pop
    //   49: aload 4
    //   51: invokevirtual 57	java/io/InputStream:close	()V
    //   54: goto +74 -> 128
    //   57: astore_1
    //   58: getstatic 59	com/tencent/qqmusic/mediaplayer/codec/wma/WmaRecognition:TAG	Ljava/lang/String;
    //   61: aload_1
    //   62: invokestatic 65	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   65: goto +63 -> 128
    //   68: astore_1
    //   69: aload 4
    //   71: astore_2
    //   72: goto +111 -> 183
    //   75: astore 5
    //   77: goto +17 -> 94
    //   80: astore_1
    //   81: goto +102 -> 183
    //   84: astore_2
    //   85: aconst_null
    //   86: astore_1
    //   87: aload 5
    //   89: astore 4
    //   91: aload_2
    //   92: astore 5
    //   94: aload 4
    //   96: astore_2
    //   97: getstatic 59	com/tencent/qqmusic/mediaplayer/codec/wma/WmaRecognition:TAG	Ljava/lang/String;
    //   100: aload 5
    //   102: invokestatic 65	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   105: aload 4
    //   107: ifnull +19 -> 126
    //   110: aload 4
    //   112: invokevirtual 57	java/io/InputStream:close	()V
    //   115: goto +11 -> 126
    //   118: astore_2
    //   119: getstatic 59	com/tencent/qqmusic/mediaplayer/codec/wma/WmaRecognition:TAG	Ljava/lang/String;
    //   122: aload_2
    //   123: invokestatic 65	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   126: aload_1
    //   127: astore_2
    //   128: aload_2
    //   129: ifnull +50 -> 179
    //   132: aload_2
    //   133: arraylength
    //   134: bipush 16
    //   136: if_icmplt +43 -> 179
    //   139: iconst_0
    //   140: istore_3
    //   141: iload_3
    //   142: bipush 16
    //   144: if_icmpge +25 -> 169
    //   147: aload_2
    //   148: iload_3
    //   149: baload
    //   150: aload_0
    //   151: getfield 39	com/tencent/qqmusic/mediaplayer/codec/wma/WmaRecognition:WMA_HEADER	[B
    //   154: iload_3
    //   155: baload
    //   156: if_icmpeq +6 -> 162
    //   159: goto +10 -> 169
    //   162: iload_3
    //   163: iconst_1
    //   164: iadd
    //   165: istore_3
    //   166: goto -25 -> 141
    //   169: iload_3
    //   170: bipush 16
    //   172: if_icmpne +7 -> 179
    //   175: getstatic 71	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:WMA	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   178: areturn
    //   179: getstatic 74	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:UNSUPPORT	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   182: areturn
    //   183: aload_2
    //   184: ifnull +18 -> 202
    //   187: aload_2
    //   188: invokevirtual 57	java/io/InputStream:close	()V
    //   191: goto +11 -> 202
    //   194: astore_2
    //   195: getstatic 59	com/tencent/qqmusic/mediaplayer/codec/wma/WmaRecognition:TAG	Ljava/lang/String;
    //   198: aload_2
    //   199: invokestatic 65	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   202: goto +5 -> 207
    //   205: aload_1
    //   206: athrow
    //   207: goto -2 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	WmaRecognition
    //   0	210	1	paramString	String
    //   0	210	2	paramArrayOfByte	byte[]
    //   140	33	3	i	int
    //   30	81	4	localObject1	Object
    //   17	1	5	localObject2	Object
    //   75	13	5	localIOException	java.io.IOException
    //   92	9	5	arrayOfByte	byte[]
    //   20	13	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   49	54	57	java/io/IOException
    //   35	40	68	finally
    //   42	49	68	finally
    //   35	40	75	java/io/IOException
    //   42	49	75	java/io/IOException
    //   22	32	80	finally
    //   97	105	80	finally
    //   22	32	84	java/io/IOException
    //   110	115	118	java/io/IOException
    //   187	191	194	java/io/IOException
  }
  
  public AudioFormat.AudioType guessAudioType(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.toLowerCase().contains(".wma"))) {
      return AudioFormat.AudioType.WMA;
    }
    return AudioFormat.AudioType.UNSUPPORT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.wma.WmaRecognition
 * JD-Core Version:    0.7.0.1
 */