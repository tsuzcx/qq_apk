package com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser;

import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetDetector;
import java.util.Iterator;

public abstract class AudioPlayListItemParser
{
  public static final String TAG = "AudioListItemParser";
  protected CharsetDetector charsetDetector = new CharsetDetector();
  protected String mUri;
  
  protected static String delSeprator(String paramString)
  {
    return paramString.substring(paramString.indexOf("\"") + 1, paramString.lastIndexOf("\""));
  }
  
  /* Error */
  protected String guessCharsetEncoding(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 44
    //   2: astore_3
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 4
    //   9: new 46	java/io/BufferedInputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 49	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore 5
    //   19: aload_3
    //   20: astore_1
    //   21: aload_0
    //   22: getfield 20	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/AudioPlayListItemParser:charsetDetector	Lcom/tencent/qqmusic/mediaplayer/audioplaylist/charsetdetector/CharsetDetector;
    //   25: aload 5
    //   27: invokevirtual 53	com/tencent/qqmusic/mediaplayer/audioplaylist/charsetdetector/CharsetDetector:setText	(Ljava/io/InputStream;)Lcom/tencent/qqmusic/mediaplayer/audioplaylist/charsetdetector/CharsetDetector;
    //   30: pop
    //   31: aload_3
    //   32: astore_1
    //   33: aload_0
    //   34: getfield 20	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/AudioPlayListItemParser:charsetDetector	Lcom/tencent/qqmusic/mediaplayer/audioplaylist/charsetdetector/CharsetDetector;
    //   37: invokevirtual 57	com/tencent/qqmusic/mediaplayer/audioplaylist/charsetdetector/CharsetDetector:detect	()Lcom/tencent/qqmusic/mediaplayer/audioplaylist/charsetdetector/CharsetMatch;
    //   40: astore 4
    //   42: aload_3
    //   43: astore_1
    //   44: aload 4
    //   46: ifnull +82 -> 128
    //   49: aload_3
    //   50: astore_1
    //   51: aload 4
    //   53: invokevirtual 63	com/tencent/qqmusic/mediaplayer/audioplaylist/charsetdetector/CharsetMatch:getConfidence	()I
    //   56: istore_2
    //   57: aload_3
    //   58: astore_1
    //   59: aload 4
    //   61: invokevirtual 67	com/tencent/qqmusic/mediaplayer/audioplaylist/charsetdetector/CharsetMatch:getName	()Ljava/lang/String;
    //   64: astore_3
    //   65: aload_3
    //   66: astore_1
    //   67: new 69	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   74: astore 4
    //   76: aload_3
    //   77: astore_1
    //   78: aload 4
    //   80: ldc 72
    //   82: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_3
    //   87: astore_1
    //   88: aload 4
    //   90: aload_3
    //   91: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_3
    //   96: astore_1
    //   97: aload 4
    //   99: ldc 78
    //   101: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_3
    //   106: astore_1
    //   107: aload 4
    //   109: iload_2
    //   110: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_3
    //   115: astore_1
    //   116: ldc 8
    //   118: aload 4
    //   120: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 90	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload_3
    //   127: astore_1
    //   128: aload_1
    //   129: astore_3
    //   130: aload 5
    //   132: invokevirtual 93	java/io/BufferedInputStream:close	()V
    //   135: aload_1
    //   136: areturn
    //   137: astore_1
    //   138: ldc 8
    //   140: ldc 95
    //   142: aload_1
    //   143: invokestatic 99	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   146: aload_3
    //   147: areturn
    //   148: astore_1
    //   149: goto +51 -> 200
    //   152: astore 6
    //   154: goto +19 -> 173
    //   157: astore_1
    //   158: aload 4
    //   160: astore 5
    //   162: goto +38 -> 200
    //   165: astore 6
    //   167: aload 7
    //   169: astore 5
    //   171: aload_3
    //   172: astore_1
    //   173: aload 5
    //   175: astore 4
    //   177: ldc 8
    //   179: ldc 101
    //   181: aload 6
    //   183: invokestatic 99	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   186: aload 5
    //   188: ifnull +10 -> 198
    //   191: aload_1
    //   192: astore_3
    //   193: aload 5
    //   195: invokevirtual 93	java/io/BufferedInputStream:close	()V
    //   198: aload_1
    //   199: areturn
    //   200: aload 5
    //   202: ifnull +20 -> 222
    //   205: aload 5
    //   207: invokevirtual 93	java/io/BufferedInputStream:close	()V
    //   210: goto +12 -> 222
    //   213: astore_3
    //   214: ldc 8
    //   216: ldc 95
    //   218: aload_3
    //   219: invokestatic 99	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   222: aload_1
    //   223: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	AudioPlayListItemParser
    //   0	224	1	paramInputStream	java.io.InputStream
    //   56	54	2	i	int
    //   2	191	3	localObject1	Object
    //   213	6	3	localIOException1	java.io.IOException
    //   7	169	4	localObject2	Object
    //   17	189	5	localObject3	Object
    //   152	1	6	localIOException2	java.io.IOException
    //   165	17	6	localIOException3	java.io.IOException
    //   4	164	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   130	135	137	java/io/IOException
    //   193	198	137	java/io/IOException
    //   21	31	148	finally
    //   33	42	148	finally
    //   51	57	148	finally
    //   59	65	148	finally
    //   67	76	148	finally
    //   78	86	148	finally
    //   88	95	148	finally
    //   97	105	148	finally
    //   107	114	148	finally
    //   116	126	148	finally
    //   21	31	152	java/io/IOException
    //   33	42	152	java/io/IOException
    //   51	57	152	java/io/IOException
    //   59	65	152	java/io/IOException
    //   67	76	152	java/io/IOException
    //   78	86	152	java/io/IOException
    //   88	95	152	java/io/IOException
    //   97	105	152	java/io/IOException
    //   107	114	152	java/io/IOException
    //   116	126	152	java/io/IOException
    //   9	19	157	finally
    //   177	186	157	finally
    //   9	19	165	java/io/IOException
    //   205	210	213	java/io/IOException
  }
  
  public abstract boolean isParseSuccess();
  
  public abstract Iterator<TrackInfo> iterator();
  
  public abstract void parse();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser.AudioPlayListItemParser
 * JD-Core Version:    0.7.0.1
 */