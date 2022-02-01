package com.tencent.weseevideo.model.utils;

import android.media.MediaMetadataRetriever;
import android.os.Environment;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tavcut.util.Logger;
import java.io.File;

public class VideoUtils
{
  private static final String TAG = "VideoUtils";
  
  public static boolean checkExternalStorageCanRead()
  {
    try
    {
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        boolean bool = new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canRead();
        if (bool) {
          return true;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public static URLAsset createAsset(String paramString)
  {
    try
    {
      URLAsset localURLAsset = new URLAsset(paramString);
      return localURLAsset;
    }
    catch (Exception localException)
    {
      String str = localException.getMessage();
      boolean bool = FileUtils.exists(paramString);
      paramString = str + ",file exists:" + bool;
      bool = checkExternalStorageCanRead();
      Logger.e("VideoUtils", paramString + ",external storage read:" + bool);
    }
    return null;
  }
  
  protected static String extractMetadataRetriever(MediaMetadataRetriever paramMediaMetadataRetriever)
  {
    if (paramMediaMetadataRetriever != null) {
      return paramMediaMetadataRetriever.extractMetadata(9);
    }
    return "0";
  }
  
  /* Error */
  public static int getDurationImmediately(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokestatic 106	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +35 -> 41
    //   9: new 92	android/media/MediaMetadataRetriever
    //   12: dup
    //   13: invokespecial 107	android/media/MediaMetadataRetriever:<init>	()V
    //   16: astore_3
    //   17: aload_3
    //   18: astore_2
    //   19: aload_3
    //   20: aload_0
    //   21: invokevirtual 110	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   24: aload_3
    //   25: astore_2
    //   26: aload_3
    //   27: invokestatic 112	com/tencent/weseevideo/model/utils/VideoUtils:extractMetadataRetriever	(Landroid/media/MediaMetadataRetriever;)Ljava/lang/String;
    //   30: invokestatic 118	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   33: invokevirtual 122	java/lang/Integer:intValue	()I
    //   36: istore_1
    //   37: aload_3
    //   38: invokestatic 126	com/tencent/weseevideo/model/utils/VideoUtils:releaseRetriever	(Landroid/media/MediaMetadataRetriever;)V
    //   41: iload_1
    //   42: ireturn
    //   43: astore 4
    //   45: aconst_null
    //   46: astore_0
    //   47: aload_0
    //   48: astore_2
    //   49: ldc 8
    //   51: aload 4
    //   53: invokevirtual 127	java/lang/Exception:toString	()Ljava/lang/String;
    //   56: invokestatic 88	com/tencent/tavcut/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_0
    //   60: invokestatic 126	com/tencent/weseevideo/model/utils/VideoUtils:releaseRetriever	(Landroid/media/MediaMetadataRetriever;)V
    //   63: iconst_0
    //   64: ireturn
    //   65: astore_0
    //   66: aconst_null
    //   67: astore_2
    //   68: aload_2
    //   69: invokestatic 126	com/tencent/weseevideo/model/utils/VideoUtils:releaseRetriever	(Landroid/media/MediaMetadataRetriever;)V
    //   72: aload_0
    //   73: athrow
    //   74: astore_0
    //   75: goto -7 -> 68
    //   78: astore 4
    //   80: aload_3
    //   81: astore_0
    //   82: goto -35 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramString	String
    //   1	41	1	i	int
    //   18	51	2	localObject	Object
    //   16	65	3	localMediaMetadataRetriever	MediaMetadataRetriever
    //   43	9	4	localException1	Exception
    //   78	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   9	17	43	java/lang/Exception
    //   9	17	65	finally
    //   19	24	74	finally
    //   26	37	74	finally
    //   49	59	74	finally
    //   19	24	78	java/lang/Exception
    //   26	37	78	java/lang/Exception
  }
  
  protected static void releaseRetriever(MediaMetadataRetriever paramMediaMetadataRetriever)
  {
    if (paramMediaMetadataRetriever != null) {
      paramMediaMetadataRetriever.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.utils.VideoUtils
 * JD-Core Version:    0.7.0.1
 */