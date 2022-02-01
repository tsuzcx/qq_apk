package com.tencent.qqmusic.mediaplayer.codec.flac;

import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.io.IOException;

public class FLACRecognition
  implements IAudioRecognition
{
  public static final String TAG = "FLACRecognition";
  
  /* Error */
  private boolean checkFormatBySoftDecoder(String paramString)
  {
    // Byte code:
    //   0: new 21	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder
    //   3: dup
    //   4: invokespecial 22	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder:<init>	()V
    //   7: astore 4
    //   9: iconst_0
    //   10: istore_3
    //   11: aload 4
    //   13: aload_1
    //   14: iconst_0
    //   15: invokevirtual 26	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder:init	(Ljava/lang/String;Z)I
    //   18: ifne +52 -> 70
    //   21: aload 4
    //   23: invokevirtual 30	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder:getAudioInformation	()Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   26: astore_1
    //   27: iload_3
    //   28: istore_2
    //   29: aload_1
    //   30: ifnull +23 -> 53
    //   33: aload_1
    //   34: invokevirtual 36	com/tencent/qqmusic/mediaplayer/AudioInformation:getAudioType	()Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   37: astore_1
    //   38: getstatic 42	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:FLAC	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   41: astore 5
    //   43: iload_3
    //   44: istore_2
    //   45: aload_1
    //   46: aload 5
    //   48: if_acmpne +5 -> 53
    //   51: iconst_1
    //   52: istore_2
    //   53: aload 4
    //   55: invokevirtual 46	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder:release	()I
    //   58: pop
    //   59: iload_2
    //   60: ireturn
    //   61: astore_1
    //   62: ldc 10
    //   64: aload_1
    //   65: invokestatic 52	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   68: iload_2
    //   69: ireturn
    //   70: aload 4
    //   72: invokevirtual 46	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder:release	()I
    //   75: pop
    //   76: iconst_0
    //   77: ireturn
    //   78: astore_1
    //   79: ldc 10
    //   81: aload_1
    //   82: invokestatic 52	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   85: iconst_0
    //   86: ireturn
    //   87: astore_1
    //   88: goto +18 -> 106
    //   91: astore_1
    //   92: ldc 10
    //   94: aload_1
    //   95: invokestatic 52	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   98: aload 4
    //   100: invokevirtual 46	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder:release	()I
    //   103: pop
    //   104: iconst_0
    //   105: ireturn
    //   106: aload 4
    //   108: invokevirtual 46	com/tencent/qqmusic/mediaplayer/codec/NativeDecoder:release	()I
    //   111: pop
    //   112: goto +12 -> 124
    //   115: astore 4
    //   117: ldc 10
    //   119: aload 4
    //   121: invokestatic 52	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   124: aload_1
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	FLACRecognition
    //   0	126	1	paramString	String
    //   28	41	2	bool1	boolean
    //   10	34	3	bool2	boolean
    //   7	100	4	localNativeDecoder	com.tencent.qqmusic.mediaplayer.codec.NativeDecoder
    //   115	5	4	localThrowable	java.lang.Throwable
    //   41	6	5	localAudioType	AudioFormat.AudioType
    // Exception table:
    //   from	to	target	type
    //   53	59	61	java/lang/Throwable
    //   70	76	78	java/lang/Throwable
    //   98	104	78	java/lang/Throwable
    //   11	27	87	finally
    //   33	43	87	finally
    //   92	98	87	finally
    //   11	27	91	java/lang/Throwable
    //   33	43	91	java/lang/Throwable
    //   106	112	115	java/lang/Throwable
  }
  
  public static boolean isFlac(IDataSource paramIDataSource)
  {
    byte[] arrayOfByte = new byte[10];
    try
    {
      paramIDataSource.readAt(0L, arrayOfByte, 0, arrayOfByte.length);
      bool2 = false;
      if ((arrayOfByte[0] == 73) && (arrayOfByte[1] == 68) && (arrayOfByte[2] == 51))
      {
        i = ((arrayOfByte[6] & 0x7F) << 21) + ((arrayOfByte[7] & 0x7F) << 14) + ((arrayOfByte[8] & 0x7F) << 7) + (arrayOfByte[9] & 0x7F);
        if ((arrayOfByte[5] & 0x10) > 0)
        {
          i += 20;
          k = 1;
        }
        else
        {
          i += 10;
          k = 0;
        }
        j = i;
        if (k != 0) {
          break label208;
        }
        arrayOfByte = new byte[1];
        l = i;
      }
    }
    catch (IOException localIOException3)
    {
      try
      {
        int i;
        j = paramIDataSource.readAt(l, arrayOfByte, 0, arrayOfByte.length);
        break label157;
        j = 0;
        label157:
        k = j;
        j = i;
        if (arrayOfByte[0] == 0)
        {
          j = i;
          if (k == 1)
          {
            i += 1;
            l = i;
          }
        }
      }
      catch (IOException localIOException3)
      {
        try
        {
          for (;;)
          {
            int k;
            j = paramIDataSource.readAt(l, arrayOfByte, 0, arrayOfByte.length);
            continue;
            j = k;
          }
          int j = 0;
          label208:
          arrayOfByte = new byte[4];
          l = j;
        }
        catch (IOException localIOException3)
        {
          try
          {
            for (;;)
            {
              boolean bool2;
              long l;
              paramIDataSource.readAt(l, arrayOfByte, 0, arrayOfByte.length);
              label232:
              boolean bool1 = bool2;
              if (arrayOfByte[0] == 102)
              {
                bool1 = bool2;
                if (arrayOfByte[1] == 76)
                {
                  bool1 = bool2;
                  if (arrayOfByte[2] == 97)
                  {
                    bool1 = bool2;
                    if (arrayOfByte[3] == 67) {
                      bool1 = true;
                    }
                  }
                }
              }
              return bool1;
              localIOException1 = localIOException1;
              continue;
              localIOException2 = localIOException2;
            }
            localIOException3 = localIOException3;
          }
          catch (IOException paramIDataSource)
          {
            break label232;
          }
        }
      }
    }
  }
  
  public AudioFormat.AudioType getAudioType(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (new String(paramArrayOfByte).startsWith("flaC"))) {
      return AudioFormat.AudioType.FLAC;
    }
    if (checkFormatBySoftDecoder(paramString)) {
      return AudioFormat.AudioType.FLAC;
    }
    return AudioFormat.AudioType.UNSUPPORT;
  }
  
  public AudioFormat.AudioType guessAudioType(String paramString)
  {
    boolean bool2;
    boolean bool1;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.toLowerCase().contains(".flac")) {
        return AudioFormat.AudioType.FLAC;
      }
      paramString = new FileDataSource(paramString);
      bool2 = false;
      bool1 = bool2;
    }
    try
    {
      paramString.open();
      bool1 = bool2;
      bool2 = isFlac(paramString);
      bool1 = bool2;
      paramString.close();
      bool1 = bool2;
    }
    catch (IOException paramString)
    {
      label55:
      break label55;
    }
    if (bool1) {
      return AudioFormat.AudioType.FLAC;
    }
    return AudioFormat.AudioType.UNSUPPORT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.flac.FLACRecognition
 * JD-Core Version:    0.7.0.1
 */