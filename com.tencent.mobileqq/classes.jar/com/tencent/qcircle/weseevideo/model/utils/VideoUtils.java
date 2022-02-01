package com.tencent.qcircle.weseevideo.model.utils;

import android.media.MediaMetadataRetriever;
import android.os.Environment;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.tav.asset.URLAsset;
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
      Object localObject = localException.getMessage();
      boolean bool = FileUtils.exists(paramString);
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append(",file exists:");
      paramString.append(bool);
      paramString = paramString.toString();
      bool = checkExternalStorageCanRead();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",external storage read:");
      ((StringBuilder)localObject).append(bool);
      Logger.e("VideoUtils", ((StringBuilder)localObject).toString());
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
    //   0: aload_0
    //   1: invokestatic 106	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +84 -> 88
    //   7: aconst_null
    //   8: astore 4
    //   10: aconst_null
    //   11: astore_2
    //   12: new 92	android/media/MediaMetadataRetriever
    //   15: dup
    //   16: invokespecial 107	android/media/MediaMetadataRetriever:<init>	()V
    //   19: astore_3
    //   20: aload_3
    //   21: aload_0
    //   22: invokevirtual 110	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   25: aload_3
    //   26: invokestatic 112	com/tencent/qcircle/weseevideo/model/utils/VideoUtils:extractMetadataRetriever	(Landroid/media/MediaMetadataRetriever;)Ljava/lang/String;
    //   29: invokestatic 118	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   32: invokevirtual 122	java/lang/Integer:intValue	()I
    //   35: istore_1
    //   36: aload_3
    //   37: invokestatic 126	com/tencent/qcircle/weseevideo/model/utils/VideoUtils:releaseRetriever	(Landroid/media/MediaMetadataRetriever;)V
    //   40: iload_1
    //   41: ireturn
    //   42: astore_0
    //   43: aload_3
    //   44: astore_2
    //   45: goto +37 -> 82
    //   48: astore_2
    //   49: aload_3
    //   50: astore_0
    //   51: aload_2
    //   52: astore_3
    //   53: goto +11 -> 64
    //   56: astore_0
    //   57: goto +25 -> 82
    //   60: astore_3
    //   61: aload 4
    //   63: astore_0
    //   64: aload_0
    //   65: astore_2
    //   66: ldc 8
    //   68: aload_3
    //   69: invokevirtual 127	java/lang/Exception:toString	()Ljava/lang/String;
    //   72: invokestatic 88	com/tencent/qcircle/tavcut/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload_0
    //   76: invokestatic 126	com/tencent/qcircle/weseevideo/model/utils/VideoUtils:releaseRetriever	(Landroid/media/MediaMetadataRetriever;)V
    //   79: goto +9 -> 88
    //   82: aload_2
    //   83: invokestatic 126	com/tencent/qcircle/weseevideo/model/utils/VideoUtils:releaseRetriever	(Landroid/media/MediaMetadataRetriever;)V
    //   86: aload_0
    //   87: athrow
    //   88: iconst_0
    //   89: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramString	String
    //   35	6	1	i	int
    //   11	34	2	localObject1	Object
    //   48	4	2	localException1	Exception
    //   65	18	2	str	String
    //   19	34	3	localObject2	Object
    //   60	9	3	localException2	Exception
    //   8	54	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   20	36	42	finally
    //   20	36	48	java/lang/Exception
    //   12	20	56	finally
    //   66	75	56	finally
    //   12	20	60	java/lang/Exception
  }
  
  protected static void releaseRetriever(MediaMetadataRetriever paramMediaMetadataRetriever)
  {
    if (paramMediaMetadataRetriever != null) {
      paramMediaMetadataRetriever.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.utils.VideoUtils
 * JD-Core Version:    0.7.0.1
 */