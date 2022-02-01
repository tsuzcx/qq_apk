package com.tencent.mobileqq.richmedia.mediacodec.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import androidx.annotation.RequiresApi;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.FileUtils;

@RequiresApi(api=16)
public class MediaUtil
{
  private static final char[] a = "0123456789ABCDEF".toCharArray();
  
  public static long a(String paramString)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    long l1 = 0L;
    try
    {
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = localMediaMetadataRetriever.extractMetadata(9);
      try
      {
        long l2 = Long.parseLong(paramString);
        l1 = l2;
      }
      catch (NumberFormatException paramString)
      {
        paramString.printStackTrace();
      }
      localMediaMetadataRetriever.release();
      return l1;
    }
    catch (Error localError)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getVideoDuration path=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" exists=");
      localStringBuilder.append(FileUtils.e(paramString));
      SLog.c("MediaUtil", localStringBuilder.toString(), localError);
      localMediaMetadataRetriever.release();
      return 0L;
    }
    catch (RuntimeException localRuntimeException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getVideoDuration path=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" exists=");
      localStringBuilder.append(FileUtils.e(paramString));
      SLog.c("MediaUtil", localStringBuilder.toString(), localRuntimeException);
      localMediaMetadataRetriever.release();
    }
    return 0L;
  }
  
  public static Bitmap a(String paramString, int paramInt)
  {
    boolean bool = FileUtils.e(paramString);
    StringBuilder localStringBuilder = null;
    if (!bool)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("File note exist when getFrameAtTime(). videoPath = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" millisecond = ");
      localStringBuilder.append(paramInt);
      SLog.e("MediaUtil", localStringBuilder.toString());
      return null;
    }
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramString);
    long l = paramInt * 1000;
    try
    {
      paramString = localMediaMetadataRetriever.getFrameAtTime(l, 0);
    }
    catch (OutOfMemoryError paramString)
    {
      SLog.c("MediaUtil", "getFrameAtTime", paramString);
      paramString = localStringBuilder;
    }
    localMediaMetadataRetriever.release();
    return paramString;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1, 0);
    if (paramString1 != null) {
      BitmapUtils.a(paramString1, Bitmap.CompressFormat.JPEG, 80, paramString2);
    }
  }
  
  /* Error */
  public static int[] a(String paramString)
  {
    // Byte code:
    //   0: new 34	android/media/MediaMetadataRetriever
    //   3: dup
    //   4: invokespecial 35	android/media/MediaMetadataRetriever:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_0
    //   10: invokevirtual 39	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   13: aload_3
    //   14: bipush 18
    //   16: invokevirtual 43	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   19: astore_0
    //   20: aload_3
    //   21: bipush 19
    //   23: invokevirtual 43	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   26: astore 4
    //   28: aload_0
    //   29: invokestatic 124	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   32: ifne +14 -> 46
    //   35: aload_0
    //   36: invokestatic 130	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   39: invokevirtual 134	java/lang/Integer:intValue	()I
    //   42: istore_1
    //   43: goto +5 -> 48
    //   46: iconst_0
    //   47: istore_1
    //   48: aload 4
    //   50: invokestatic 124	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifne +15 -> 68
    //   56: aload 4
    //   58: invokestatic 130	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   61: invokevirtual 134	java/lang/Integer:intValue	()I
    //   64: istore_2
    //   65: goto +5 -> 70
    //   68: iconst_0
    //   69: istore_2
    //   70: aload_3
    //   71: invokevirtual 54	android/media/MediaMetadataRetriever:release	()V
    //   74: goto +29 -> 103
    //   77: astore_0
    //   78: goto +10 -> 88
    //   81: astore_0
    //   82: goto +33 -> 115
    //   85: astore_0
    //   86: iconst_0
    //   87: istore_1
    //   88: ldc 76
    //   90: aload_0
    //   91: invokevirtual 135	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   94: invokestatic 99	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload_3
    //   98: invokevirtual 54	android/media/MediaMetadataRetriever:release	()V
    //   101: iconst_0
    //   102: istore_2
    //   103: iconst_2
    //   104: newarray int
    //   106: dup
    //   107: iconst_0
    //   108: iload_1
    //   109: iastore
    //   110: dup
    //   111: iconst_1
    //   112: iload_2
    //   113: iastore
    //   114: areturn
    //   115: aload_3
    //   116: invokevirtual 54	android/media/MediaMetadataRetriever:release	()V
    //   119: aload_0
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramString	String
    //   42	67	1	i	int
    //   64	49	2	j	int
    //   7	109	3	localMediaMetadataRetriever	MediaMetadataRetriever
    //   26	31	4	str	String
    // Exception table:
    //   from	to	target	type
    //   48	65	77	java/lang/NumberFormatException
    //   28	43	81	finally
    //   48	65	81	finally
    //   88	97	81	finally
    //   28	43	85	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil
 * JD-Core Version:    0.7.0.1
 */