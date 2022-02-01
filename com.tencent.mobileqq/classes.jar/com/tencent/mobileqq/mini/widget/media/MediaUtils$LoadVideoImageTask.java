package com.tencent.mobileqq.mini.widget.media;

import android.os.AsyncTask;
import java.io.File;

public class MediaUtils$LoadVideoImageTask
  extends AsyncTask<String, Integer, File>
{
  private MediaUtils.OnLoadVideoImageListener listener;
  
  public MediaUtils$LoadVideoImageTask(MediaUtils.OnLoadVideoImageListener paramOnLoadVideoImageListener)
  {
    this.listener = paramOnLoadVideoImageListener;
  }
  
  /* Error */
  protected File doInBackground(String... paramVarArgs)
  {
    // Byte code:
    //   0: new 21	android/media/MediaMetadataRetriever
    //   3: dup
    //   4: invokespecial 22	android/media/MediaMetadataRetriever:<init>	()V
    //   7: astore_2
    //   8: aload_1
    //   9: iconst_0
    //   10: aaload
    //   11: astore_1
    //   12: aload_1
    //   13: ldc 24
    //   15: invokevirtual 30	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   18: ifne +12 -> 30
    //   21: aload_1
    //   22: ldc 32
    //   24: invokevirtual 30	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   27: ifeq +88 -> 115
    //   30: aload_2
    //   31: aload_1
    //   32: new 34	java/util/HashMap
    //   35: dup
    //   36: invokespecial 35	java/util/HashMap:<init>	()V
    //   39: invokevirtual 39	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;Ljava/util/Map;)V
    //   42: aload_2
    //   43: invokevirtual 43	android/media/MediaMetadataRetriever:getFrameAtTime	()Landroid/graphics/Bitmap;
    //   46: astore 4
    //   48: new 45	java/io/File
    //   51: dup
    //   52: invokestatic 51	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   55: ldc 53
    //   57: invokevirtual 57	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getTmpPath	(Ljava/lang/String;)Ljava/lang/String;
    //   60: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   63: astore_3
    //   64: aload_3
    //   65: invokevirtual 64	java/io/File:exists	()Z
    //   68: ifeq +8 -> 76
    //   71: aload_3
    //   72: invokevirtual 67	java/io/File:delete	()Z
    //   75: pop
    //   76: new 69	java/io/FileOutputStream
    //   79: dup
    //   80: aload_3
    //   81: invokespecial 72	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   84: astore 5
    //   86: aload 4
    //   88: getstatic 78	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   91: bipush 90
    //   93: aload 5
    //   95: invokevirtual 84	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   98: pop
    //   99: aload 5
    //   101: invokevirtual 87	java/io/FileOutputStream:flush	()V
    //   104: aload 5
    //   106: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   109: aload_2
    //   110: invokevirtual 93	android/media/MediaMetadataRetriever:release	()V
    //   113: aload_3
    //   114: areturn
    //   115: aload_2
    //   116: aload_1
    //   117: invokevirtual 95	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   120: goto -78 -> 42
    //   123: astore_1
    //   124: ldc 97
    //   126: iconst_1
    //   127: new 99	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   134: ldc 102
    //   136: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_1
    //   140: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: aconst_null
    //   150: areturn
    //   151: astore 4
    //   153: ldc 97
    //   155: new 99	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   162: ldc 121
    //   164: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_1
    //   168: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: aload 4
    //   176: invokestatic 127	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   179: pop
    //   180: goto -71 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	LoadVideoImageTask
    //   0	183	1	paramVarArgs	String[]
    //   7	109	2	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   63	51	3	localFile	File
    //   46	41	4	localBitmap	android.graphics.Bitmap
    //   151	24	4	localException	java.lang.Exception
    //   84	21	5	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   0	8	123	java/lang/Exception
    //   12	30	123	java/lang/Exception
    //   30	42	123	java/lang/Exception
    //   42	76	123	java/lang/Exception
    //   109	113	123	java/lang/Exception
    //   115	120	123	java/lang/Exception
    //   153	180	123	java/lang/Exception
    //   76	109	151	java/lang/Exception
  }
  
  protected void onPostExecute(File paramFile)
  {
    super.onPostExecute(paramFile);
    if (this.listener != null) {
      this.listener.onLoadImage(paramFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MediaUtils.LoadVideoImageTask
 * JD-Core Version:    0.7.0.1
 */