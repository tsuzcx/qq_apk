package com.tencent.mobileqq.qqlive.api.impl.upload.bitmap;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import mqq.os.MqqHandler;

public class StoreFileTask
{
  private static final int COMPRESS_QUALITY = 80;
  private static final String TAG = "StoreFileTask";
  private Bitmap photoBitmap;
  private String targetPath;
  
  public StoreFileTask(Bitmap paramBitmap, String paramString)
  {
    this.photoBitmap = paramBitmap;
    this.targetPath = paramString;
  }
  
  private File createNewFile(String paramString)
  {
    if (paramString == null)
    {
      QLog.i("StoreFileTask", 1, "createNewFile but filepath is null");
      return null;
    }
    Object localObject = new File(paramString);
    try
    {
      if (!((File)localObject).exists())
      {
        int i = paramString.lastIndexOf('/');
        if ((i > 0) && (i < paramString.length() - 1))
        {
          paramString = new File(paramString.substring(0, i));
          if (!paramString.exists()) {
            paramString.mkdirs();
          }
        }
      }
      else
      {
        ((File)localObject).delete();
      }
      ((File)localObject).createNewFile();
      return localObject;
    }
    catch (IOException paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createNewFile IOException ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("StoreFileTask", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  /* Error */
  private String storeImageToFile(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: ifnonnull +13 -> 17
    //   7: ldc 11
    //   9: iconst_1
    //   10: ldc 98
    //   12: invokestatic 46	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aconst_null
    //   16: areturn
    //   17: new 48	java/io/File
    //   20: dup
    //   21: aload_0
    //   22: getfield 23	com/tencent/mobileqq/qqlive/api/impl/upload/bitmap/StoreFileTask:targetPath	Ljava/lang/String;
    //   25: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore_3
    //   29: aload_3
    //   30: astore_2
    //   31: aload_3
    //   32: invokevirtual 55	java/io/File:exists	()Z
    //   35: ifne +12 -> 47
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 23	com/tencent/mobileqq/qqlive/api/impl/upload/bitmap/StoreFileTask:targetPath	Ljava/lang/String;
    //   43: invokespecial 100	com/tencent/mobileqq/qqlive/api/impl/upload/bitmap/StoreFileTask:createNewFile	(Ljava/lang/String;)Ljava/io/File;
    //   46: astore_2
    //   47: aload_2
    //   48: ifnull +56 -> 104
    //   51: aload_2
    //   52: invokevirtual 55	java/io/File:exists	()Z
    //   55: ifne +6 -> 61
    //   58: goto +46 -> 104
    //   61: new 102	java/io/FileOutputStream
    //   64: dup
    //   65: aload_2
    //   66: invokespecial 105	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   69: astore_3
    //   70: aload_3
    //   71: astore_2
    //   72: aload_1
    //   73: getstatic 111	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   76: bipush 80
    //   78: aload_3
    //   79: invokevirtual 117	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   82: pop
    //   83: aload_3
    //   84: astore_2
    //   85: aload_0
    //   86: getfield 23	com/tencent/mobileqq/qqlive/api/impl/upload/bitmap/StoreFileTask:targetPath	Ljava/lang/String;
    //   89: astore_1
    //   90: aload_3
    //   91: invokestatic 123	com/tencent/mobileqq/qqlive/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   94: aload_1
    //   95: areturn
    //   96: astore_2
    //   97: aload_3
    //   98: astore_1
    //   99: aload_2
    //   100: astore_3
    //   101: goto +60 -> 161
    //   104: new 79	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   111: astore_3
    //   112: aload_3
    //   113: ldc 125
    //   115: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_2
    //   120: ifnonnull +65 -> 185
    //   123: ldc 127
    //   125: astore_1
    //   126: goto +3 -> 129
    //   129: aload_3
    //   130: aload_1
    //   131: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: ldc 11
    //   137: iconst_1
    //   138: aload_3
    //   139: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 46	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: aconst_null
    //   146: invokestatic 123	com/tencent/mobileqq/qqlive/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   149: aconst_null
    //   150: areturn
    //   151: astore_1
    //   152: aload 4
    //   154: astore_2
    //   155: goto +24 -> 179
    //   158: astore_3
    //   159: aconst_null
    //   160: astore_1
    //   161: aload_1
    //   162: astore_2
    //   163: ldc 11
    //   165: iconst_1
    //   166: ldc 129
    //   168: aload_3
    //   169: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   172: aload_1
    //   173: invokestatic 123	com/tencent/mobileqq/qqlive/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   176: aconst_null
    //   177: areturn
    //   178: astore_1
    //   179: aload_2
    //   180: invokestatic 123	com/tencent/mobileqq/qqlive/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   183: aload_1
    //   184: athrow
    //   185: ldc 134
    //   187: astore_1
    //   188: goto -59 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	StoreFileTask
    //   0	191	1	paramBitmap	Bitmap
    //   30	55	2	localObject1	Object
    //   96	24	2	localIOException1	IOException
    //   154	26	2	localObject2	Object
    //   28	111	3	localObject3	Object
    //   158	11	3	localIOException2	IOException
    //   1	152	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   72	83	96	java/io/IOException
    //   85	90	96	java/io/IOException
    //   31	47	151	finally
    //   51	58	151	finally
    //   61	70	151	finally
    //   104	119	151	finally
    //   129	145	151	finally
    //   31	47	158	java/io/IOException
    //   51	58	158	java/io/IOException
    //   61	70	158	java/io/IOException
    //   104	119	158	java/io/IOException
    //   129	145	158	java/io/IOException
    //   72	83	178	finally
    //   85	90	178	finally
    //   163	172	178	finally
  }
  
  public void start(StoreFileTask.OnStorePhotoCallback paramOnStorePhotoCallback)
  {
    ThreadManager.getFileThreadHandler().post(new StoreFileTask.1(this, paramOnStorePhotoCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.upload.bitmap.StoreFileTask
 * JD-Core Version:    0.7.0.1
 */