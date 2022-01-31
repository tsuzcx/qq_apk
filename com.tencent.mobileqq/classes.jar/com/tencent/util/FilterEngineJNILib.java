package com.tencent.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Environment;
import com.tencent.filter.QImage;
import com.tencent.ttpic.AEBaseConfig;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FilterEngineJNILib
{
  private static long mLastDate = 0L;
  private static int mSameSecondCount = 0;
  
  public static String generateBundlePath(String paramString1, String paramString2)
  {
    if (paramString2 != null) {}
    for (paramString2 = paramString1 + "." + paramString2;; paramString2 = paramString1)
    {
      if (new File(paramString2).exists()) {
        return paramString2;
      }
      Object localObject = AEBaseConfig.getContext();
      if (localObject == null) {
        return null;
      }
      localObject = ((Context)localObject).getDir("filter", 0);
      if ((!((File)localObject).isDirectory()) && (!((File)localObject).mkdirs())) {
        return null;
      }
      localObject = new File((File)localObject, paramString2);
      FileOutputStream localFileOutputStream;
      if (!((File)localObject).exists())
      {
        ((File)localObject).mkdirs();
        ((File)localObject).delete();
        try
        {
          paramString2 = BitmapUtils.getInputStreamByName(paramString2);
          if (paramString2 == null) {
            break label179;
          }
          paramString1 = new byte[1024];
          ((File)localObject).createNewFile();
          localFileOutputStream = new FileOutputStream((File)localObject);
          for (;;)
          {
            int i = paramString2.read(paramString1);
            if (i == -1) {
              break;
            }
            localFileOutputStream.write(paramString1, 0, i);
          }
          return ((File)localObject).getAbsolutePath();
        }
        catch (IOException paramString1)
        {
          paramString1.printStackTrace();
        }
      }
      for (;;)
      {
        paramString2.close();
        localFileOutputStream.close();
      }
      label179:
      LogUtils.d("filter", "generateBundlePath notfound" + paramString1);
      return null;
    }
  }
  
  /* Error */
  private static String generateName(long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 116	java/text/SimpleDateFormat
    //   6: dup
    //   7: ldc 118
    //   9: invokespecial 119	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   12: new 121	java/util/Date
    //   15: dup
    //   16: lload_0
    //   17: invokespecial 124	java/util/Date:<init>	(J)V
    //   20: invokevirtual 128	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   23: astore_2
    //   24: lload_0
    //   25: ldc2_w 129
    //   28: ldiv
    //   29: getstatic 12	com/tencent/util/FilterEngineJNILib:mLastDate	J
    //   32: ldc2_w 129
    //   35: ldiv
    //   36: lcmp
    //   37: ifne +42 -> 79
    //   40: getstatic 14	com/tencent/util/FilterEngineJNILib:mSameSecondCount	I
    //   43: iconst_1
    //   44: iadd
    //   45: putstatic 14	com/tencent/util/FilterEngineJNILib:mSameSecondCount	I
    //   48: new 24	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   55: aload_2
    //   56: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 132
    //   61: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: getstatic 14	com/tencent/util/FilterEngineJNILib:mSameSecondCount	I
    //   67: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: astore_2
    //   74: ldc 2
    //   76: monitorexit
    //   77: aload_2
    //   78: areturn
    //   79: lload_0
    //   80: putstatic 12	com/tencent/util/FilterEngineJNILib:mLastDate	J
    //   83: iconst_0
    //   84: putstatic 14	com/tencent/util/FilterEngineJNILib:mSameSecondCount	I
    //   87: goto -13 -> 74
    //   90: astore_2
    //   91: ldc 2
    //   93: monitorexit
    //   94: aload_2
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramLong	long
    //   23	55	2	str	String
    //   90	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	74	90	finally
    //   79	87	90	finally
  }
  
  public static byte[] getAssetContents(String paramString)
  {
    if (AEBaseConfig.getContext() == null) {
      return null;
    }
    paramString = AEBaseConfig.getContext().getAssets().open(paramString, 3);
    byte[] arrayOfByte = new byte[paramString.available()];
    paramString.read(arrayOfByte);
    paramString.close();
    return arrayOfByte;
  }
  
  private static String getSDPath()
  {
    File localFile = null;
    if (Environment.getExternalStorageState().equals("mounted")) {
      localFile = Environment.getExternalStorageDirectory();
    }
    return localFile.toString();
  }
  
  public static native void nativeCopyImage(Bitmap paramBitmap, long paramLong);
  
  /* Error */
  public static byte[] readBundleData(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 76	com/tencent/ttpic/baseutils/bitmap/BitmapUtils:getInputStreamByName	(Ljava/lang/String;)Ljava/io/InputStream;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +32 -> 38
    //   9: ldc 177
    //   11: new 24	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   18: ldc 179
    //   20: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 181
    //   29: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 184	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_1
    //   39: invokestatic 190	com/tencent/ttpic/baseutils/encrypt/FileEncryptUtils:decryptFile	(Ljava/io/InputStream;)[B
    //   42: astore_0
    //   43: aload_1
    //   44: invokestatic 196	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   47: aload_0
    //   48: areturn
    //   49: astore_1
    //   50: aconst_null
    //   51: astore_0
    //   52: ldc 177
    //   54: ldc 198
    //   56: aload_1
    //   57: iconst_0
    //   58: anewarray 4	java/lang/Object
    //   61: invokestatic 201	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   64: aload_0
    //   65: areturn
    //   66: astore_1
    //   67: goto -15 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramString	String
    //   4	40	1	localInputStream	InputStream
    //   49	8	1	localException1	java.lang.Exception
    //   66	1	1	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	5	49	java/lang/Exception
    //   9	38	49	java/lang/Exception
    //   38	43	49	java/lang/Exception
    //   43	47	66	java/lang/Exception
  }
  
  public static QImage readBundleImage(String paramString)
  {
    paramString = BitmapUtils.decodeBitmap(paramString);
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      QImage localQImage = QImage.Bitmap2QImage(paramString);
      BitmapUtils.recycle(paramString);
      return localQImage;
    }
    return null;
  }
  
  public static void recycleImage(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
    System.gc();
  }
  
  /* Error */
  private static int saveBitmap(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: ldc 52
    //   2: new 24	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   9: ldc 237
    //   11: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_1
    //   15: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: invokestatic 112	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: aconst_null
    //   25: astore 4
    //   27: aconst_null
    //   28: astore 5
    //   30: aconst_null
    //   31: astore_3
    //   32: aload 5
    //   34: astore_2
    //   35: new 37	java/io/File
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 40	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore 6
    //   45: aload 5
    //   47: astore_2
    //   48: aload 6
    //   50: invokevirtual 240	java/io/File:getParentFile	()Ljava/io/File;
    //   53: astore 7
    //   55: aload 5
    //   57: astore_2
    //   58: aload 7
    //   60: invokevirtual 44	java/io/File:exists	()Z
    //   63: ifne +12 -> 75
    //   66: aload 5
    //   68: astore_2
    //   69: aload 7
    //   71: invokevirtual 64	java/io/File:mkdirs	()Z
    //   74: pop
    //   75: aload 5
    //   77: astore_2
    //   78: aload 6
    //   80: invokevirtual 44	java/io/File:exists	()Z
    //   83: ifne +12 -> 95
    //   86: aload 5
    //   88: astore_2
    //   89: aload 6
    //   91: invokevirtual 79	java/io/File:createNewFile	()Z
    //   94: pop
    //   95: aload 5
    //   97: astore_2
    //   98: ldc 52
    //   100: new 24	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   107: ldc 242
    //   109: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload 6
    //   114: invokevirtual 44	java/io/File:exists	()Z
    //   117: invokevirtual 245	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   120: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 112	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload 5
    //   128: astore_2
    //   129: new 81	java/io/FileOutputStream
    //   132: dup
    //   133: aload_1
    //   134: invokespecial 246	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   137: astore_1
    //   138: aload_0
    //   139: ifnull +18 -> 157
    //   142: aload_0
    //   143: getstatic 252	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   146: bipush 95
    //   148: aload_1
    //   149: invokevirtual 256	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   152: pop
    //   153: aload_1
    //   154: invokevirtual 259	java/io/FileOutputStream:flush	()V
    //   157: aload_1
    //   158: invokestatic 262	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   161: iconst_1
    //   162: ireturn
    //   163: astore_1
    //   164: aload_3
    //   165: astore_0
    //   166: aload_0
    //   167: astore_2
    //   168: aload_1
    //   169: invokevirtual 263	java/lang/Exception:printStackTrace	()V
    //   172: aload_0
    //   173: invokestatic 262	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   176: iconst_0
    //   177: ireturn
    //   178: astore_1
    //   179: aload 4
    //   181: astore_0
    //   182: aload_0
    //   183: astore_2
    //   184: aload_1
    //   185: invokevirtual 264	java/lang/OutOfMemoryError:printStackTrace	()V
    //   188: aload_0
    //   189: invokestatic 262	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   192: iconst_0
    //   193: ireturn
    //   194: astore_0
    //   195: aload_2
    //   196: invokestatic 262	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   199: aload_0
    //   200: athrow
    //   201: astore_0
    //   202: aload_1
    //   203: astore_2
    //   204: goto -9 -> 195
    //   207: astore_2
    //   208: aload_1
    //   209: astore_0
    //   210: aload_2
    //   211: astore_1
    //   212: goto -30 -> 182
    //   215: astore_2
    //   216: aload_1
    //   217: astore_0
    //   218: aload_2
    //   219: astore_1
    //   220: goto -54 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	paramBitmap	Bitmap
    //   0	223	1	paramString	String
    //   34	170	2	localObject1	Object
    //   207	4	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   215	4	2	localException	java.lang.Exception
    //   31	134	3	localObject2	Object
    //   25	155	4	localObject3	Object
    //   28	99	5	localObject4	Object
    //   43	70	6	localFile1	File
    //   53	17	7	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   35	45	163	java/lang/Exception
    //   48	55	163	java/lang/Exception
    //   58	66	163	java/lang/Exception
    //   69	75	163	java/lang/Exception
    //   78	86	163	java/lang/Exception
    //   89	95	163	java/lang/Exception
    //   98	126	163	java/lang/Exception
    //   129	138	163	java/lang/Exception
    //   35	45	178	java/lang/OutOfMemoryError
    //   48	55	178	java/lang/OutOfMemoryError
    //   58	66	178	java/lang/OutOfMemoryError
    //   69	75	178	java/lang/OutOfMemoryError
    //   78	86	178	java/lang/OutOfMemoryError
    //   89	95	178	java/lang/OutOfMemoryError
    //   98	126	178	java/lang/OutOfMemoryError
    //   129	138	178	java/lang/OutOfMemoryError
    //   35	45	194	finally
    //   48	55	194	finally
    //   58	66	194	finally
    //   69	75	194	finally
    //   78	86	194	finally
    //   89	95	194	finally
    //   98	126	194	finally
    //   129	138	194	finally
    //   168	172	194	finally
    //   184	188	194	finally
    //   142	157	201	finally
    //   142	157	207	java/lang/OutOfMemoryError
    //   142	157	215	java/lang/Exception
  }
  
  public static void writeToAlbum(long paramLong, int paramInt1, int paramInt2)
  {
    if (BitmapUtils.ENABLE_DEBUG)
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      LogUtils.d("filter", "writeToAlbum: " + paramInt1 + " " + paramInt2);
      nativeCopyImage(localBitmap, paramLong);
      String str = generateName(System.currentTimeMillis());
      paramInt1 = saveBitmap(localBitmap, getSDPath() + "/filter/" + str + ".jpg");
      LogUtils.d("filter", "writeToAlbum ret: " + paramInt1);
      localBitmap.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.util.FilterEngineJNILib
 * JD-Core Version:    0.7.0.1
 */