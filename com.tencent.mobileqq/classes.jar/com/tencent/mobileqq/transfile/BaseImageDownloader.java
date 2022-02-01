package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.image.DownloadParams;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.SliceBitmap;
import com.tencent.image.Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public abstract class BaseImageDownloader
  extends AbsDownloader
{
  public static final String TAG = "BaseImageDownloader";
  
  /* Error */
  protected static void copyFromFile(java.io.OutputStream paramOutputStream, File paramFile, com.tencent.image.URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 23	java/io/File:length	()J
    //   4: lstore 6
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 8
    //   12: new 25	java/io/FileInputStream
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 28	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   20: astore_1
    //   21: lconst_0
    //   22: lstore 4
    //   24: sipush 8192
    //   27: newarray byte
    //   29: astore 8
    //   31: aload_1
    //   32: aload 8
    //   34: invokevirtual 32	java/io/FileInputStream:read	([B)I
    //   37: istore_3
    //   38: iload_3
    //   39: iconst_m1
    //   40: if_icmpeq +42 -> 82
    //   43: aload_0
    //   44: aload 8
    //   46: iconst_0
    //   47: iload_3
    //   48: invokevirtual 38	java/io/OutputStream:write	([BII)V
    //   51: aload_0
    //   52: invokevirtual 41	java/io/OutputStream:flush	()V
    //   55: lload 4
    //   57: iload_3
    //   58: i2l
    //   59: ladd
    //   60: lstore 4
    //   62: aload_2
    //   63: lload 4
    //   65: l2f
    //   66: lload 6
    //   68: l2f
    //   69: fdiv
    //   70: ldc 42
    //   72: fmul
    //   73: f2i
    //   74: invokeinterface 48 2 0
    //   79: goto -48 -> 31
    //   82: aload_1
    //   83: invokevirtual 51	java/io/FileInputStream:close	()V
    //   86: return
    //   87: astore_0
    //   88: goto +24 -> 112
    //   91: astore_0
    //   92: aload_1
    //   93: astore 8
    //   95: goto +15 -> 110
    //   98: astore_0
    //   99: aload 8
    //   101: astore_1
    //   102: goto +10 -> 112
    //   105: astore_0
    //   106: aload 9
    //   108: astore 8
    //   110: aload_0
    //   111: athrow
    //   112: aload_1
    //   113: ifnull +7 -> 120
    //   116: aload_1
    //   117: invokevirtual 51	java/io/FileInputStream:close	()V
    //   120: goto +5 -> 125
    //   123: aload_0
    //   124: athrow
    //   125: goto -2 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramOutputStream	java.io.OutputStream
    //   0	128	1	paramFile	File
    //   0	128	2	paramURLDrawableHandler	com.tencent.image.URLDrawableHandler
    //   37	21	3	i	int
    //   22	42	4	l1	long
    //   4	63	6	l2	long
    //   10	99	8	localObject1	Object
    //   7	100	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   24	31	87	finally
    //   31	38	87	finally
    //   43	55	87	finally
    //   62	79	87	finally
    //   24	31	91	java/io/IOException
    //   31	38	91	java/io/IOException
    //   43	55	91	java/io/IOException
    //   62	79	91	java/io/IOException
    //   12	21	98	finally
    //   110	112	98	finally
    //   12	21	105	java/io/IOException
  }
  
  protected Object decodeImage(URL paramURL, File paramFile, DownloadParams paramDownloadParams, BitmapFactory.Options paramOptions)
  {
    String str = paramDownloadParams.urlStr;
    paramOptions.inSampleSize = Utils.calculateInSampleSize(paramOptions, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight);
    int i = paramOptions.outWidth;
    i = paramOptions.outHeight;
    paramOptions.inJustDecodeBounds = false;
    int j = getTryTime(paramURL);
    i = 1;
    Object localObject1 = null;
    paramDownloadParams = null;
    for (;;)
    {
      paramURL = localObject1;
      if (i > j) {
        break;
      }
      paramURL = paramDownloadParams;
      try
      {
        paramDownloadParams = SafeBitmapFactory.decodeFile(paramFile.getAbsolutePath(), paramOptions);
        if (paramDownloadParams == null)
        {
          paramURL = paramDownloadParams;
          bool = QLog.isColorLevel();
          if (bool)
          {
            paramURL = paramDownloadParams;
            localObject2 = new StringBuilder();
            paramURL = paramDownloadParams;
            ((StringBuilder)localObject2).append("DecodeFile Failed,bitmap == null, url:");
            paramURL = paramDownloadParams;
            ((StringBuilder)localObject2).append(str);
            paramURL = paramDownloadParams;
            ((StringBuilder)localObject2).append(" ,retry count: ");
            paramURL = paramDownloadParams;
            ((StringBuilder)localObject2).append(i);
            paramURL = paramDownloadParams;
            ((StringBuilder)localObject2).append(",path:");
            paramURL = paramDownloadParams;
            ((StringBuilder)localObject2).append(paramFile.getAbsolutePath());
            paramURL = paramDownloadParams;
            QLog.d("BaseImageDownloader", 2, ((StringBuilder)localObject2).toString());
          }
          paramURL = paramDownloadParams;
          localObject2 = new StringBuilder();
          paramURL = paramDownloadParams;
          ((StringBuilder)localObject2).append("DecodeFile Failed,bitmap == null, url:");
          paramURL = paramDownloadParams;
          ((StringBuilder)localObject2).append(str);
          paramURL = paramDownloadParams;
          ((StringBuilder)localObject2).append(" ,retry count: ");
          paramURL = paramDownloadParams;
          ((StringBuilder)localObject2).append(i);
          paramURL = paramDownloadParams;
          ((StringBuilder)localObject2).append(",path:");
          paramURL = paramDownloadParams;
          ((StringBuilder)localObject2).append(paramFile.getAbsolutePath());
          paramURL = paramDownloadParams;
          throw new OutOfMemoryError(((StringBuilder)localObject2).toString());
        }
        paramURL = paramDownloadParams;
        boolean bool = SliceBitmap.needSlice(paramDownloadParams);
        if (bool) {
          paramURL = paramDownloadParams;
        }
      }
      catch (OutOfMemoryError paramDownloadParams)
      {
        Object localObject2;
        label308:
        if (paramURL != null) {
          paramURL.recycle();
        }
        paramDownloadParams = paramDownloadParams.getMessage();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("DecodeFile ERROR,oom retryCount=");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(",options.inSampleSize=");
          ((StringBuilder)localObject2).append(paramOptions.inSampleSize);
          ((StringBuilder)localObject2).append(",cacheFile=");
          ((StringBuilder)localObject2).append(paramFile.getAbsolutePath());
          ((StringBuilder)localObject2).append(",url=");
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append(",oom.msg:");
          ((StringBuilder)localObject2).append(paramDownloadParams);
          QLog.d("BaseImageDownloader", 2, ((StringBuilder)localObject2).toString());
        }
        i += 1;
        paramOptions.inSampleSize *= 2;
        paramDownloadParams = paramURL;
      }
      try
      {
        localObject2 = new SliceBitmap(paramDownloadParams);
        paramURL = paramDownloadParams;
        paramDownloadParams.recycle();
        paramURL = (URL)localObject2;
      }
      catch (Exception paramURL)
      {
        break label308;
      }
      paramURL = paramDownloadParams;
      throw new OutOfMemoryError("new SliceBitmap() error");
      paramURL = paramDownloadParams;
      break;
    }
    if (paramURL != null) {
      return paramURL;
    }
    paramURL = new IOException("decode image failed");
    for (;;)
    {
      throw paramURL;
    }
  }
  
  protected int getTryTime(URL paramURL)
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseImageDownloader
 * JD-Core Version:    0.7.0.1
 */