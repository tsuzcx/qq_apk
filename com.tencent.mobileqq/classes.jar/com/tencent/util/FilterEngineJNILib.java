package com.tencent.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.tencent.filter.QImage;
import com.tencent.ttpic.AEBaseConfig;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.encrypt.FileEncryptUtils;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FilterEngineJNILib
{
  private static long mLastDate;
  private static int mSameSecondCount;
  
  public static String generateBundlePath(String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(".");
      ((StringBuilder)localObject).append(paramString2);
      paramString2 = ((StringBuilder)localObject).toString();
    }
    else
    {
      paramString2 = paramString1;
    }
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
    if (!((File)localObject).exists())
    {
      ((File)localObject).mkdirs();
      ((File)localObject).delete();
      try
      {
        paramString2 = BitmapUtils.getInputStreamByName(paramString2);
        if (paramString2 != null)
        {
          paramString1 = new byte[1024];
          ((File)localObject).createNewFile();
          FileOutputStream localFileOutputStream = new FileOutputStream((File)localObject);
          for (;;)
          {
            int i = paramString2.read(paramString1);
            if (i == -1) {
              break;
            }
            localFileOutputStream.write(paramString1, 0, i);
          }
          paramString2.close();
          localFileOutputStream.close();
        }
        else
        {
          paramString2 = new StringBuilder();
          paramString2.append("generateBundlePath notfound");
          paramString2.append(paramString1);
          LogUtils.d("filter", paramString2.toString());
          return null;
        }
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return ((File)localObject).getAbsolutePath();
  }
  
  private static String generateName(long paramLong)
  {
    try
    {
      String str = new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss").format(new Date(paramLong));
      if (paramLong / 1000L == mLastDate / 1000L)
      {
        mSameSecondCount += 1;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("_");
        localStringBuilder.append(mSameSecondCount);
        str = localStringBuilder.toString();
      }
      else
      {
        mLastDate = paramLong;
        mSameSecondCount = 0;
      }
      return str;
    }
    finally {}
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
  
  public static native void nativeCopyImage(Bitmap paramBitmap, long paramLong);
  
  public static byte[] readBundleData(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      InputStream localInputStream = BitmapUtils.getInputStreamByName(paramString);
      if (localInputStream == null)
      {
        localObject1 = localObject2;
        StringBuilder localStringBuilder = new StringBuilder();
        localObject1 = localObject2;
        localStringBuilder.append("decodeBitmap  getStream ");
        localObject1 = localObject2;
        localStringBuilder.append(paramString);
        localObject1 = localObject2;
        localStringBuilder.append(" not exist");
        localObject1 = localObject2;
        LogUtils.e("BitmapUtils", localStringBuilder.toString());
      }
      localObject1 = localObject2;
      paramString = FileEncryptUtils.decryptFile(localInputStream);
      localObject1 = paramString;
      IOUtils.closeQuietly(localInputStream);
      return paramString;
    }
    catch (Exception paramString)
    {
      LogUtils.e("BitmapUtils", "decodeBitmap  getStream", paramString, new Object[0]);
    }
    return localObject1;
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
    //   0: new 20	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc 218
    //   11: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_2
    //   16: aload_1
    //   17: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: ldc 48
    //   23: aload_2
    //   24: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 102	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aconst_null
    //   31: astore_3
    //   32: aconst_null
    //   33: astore 4
    //   35: aconst_null
    //   36: astore 5
    //   38: aload 5
    //   40: astore_2
    //   41: new 33	java/io/File
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 36	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore 6
    //   51: aload 5
    //   53: astore_2
    //   54: aload 6
    //   56: invokevirtual 222	java/io/File:getParentFile	()Ljava/io/File;
    //   59: astore 7
    //   61: aload 5
    //   63: astore_2
    //   64: aload 7
    //   66: invokevirtual 40	java/io/File:exists	()Z
    //   69: ifne +12 -> 81
    //   72: aload 5
    //   74: astore_2
    //   75: aload 7
    //   77: invokevirtual 60	java/io/File:mkdirs	()Z
    //   80: pop
    //   81: aload 5
    //   83: astore_2
    //   84: aload 6
    //   86: invokevirtual 40	java/io/File:exists	()Z
    //   89: ifne +12 -> 101
    //   92: aload 5
    //   94: astore_2
    //   95: aload 6
    //   97: invokevirtual 75	java/io/File:createNewFile	()Z
    //   100: pop
    //   101: aload 5
    //   103: astore_2
    //   104: new 20	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   111: astore 7
    //   113: aload 5
    //   115: astore_2
    //   116: aload 7
    //   118: ldc 224
    //   120: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 5
    //   126: astore_2
    //   127: aload 7
    //   129: aload 6
    //   131: invokevirtual 40	java/io/File:exists	()Z
    //   134: invokevirtual 227	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 5
    //   140: astore_2
    //   141: ldc 48
    //   143: aload 7
    //   145: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 102	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload 5
    //   153: astore_2
    //   154: new 77	java/io/FileOutputStream
    //   157: dup
    //   158: aload_1
    //   159: invokespecial 228	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   162: astore_1
    //   163: aload_0
    //   164: ifnull +43 -> 207
    //   167: aload_0
    //   168: getstatic 234	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   171: bipush 95
    //   173: aload_1
    //   174: invokevirtual 238	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   177: pop
    //   178: aload_1
    //   179: invokevirtual 241	java/io/FileOutputStream:flush	()V
    //   182: goto +25 -> 207
    //   185: astore_0
    //   186: aload_1
    //   187: astore_2
    //   188: goto +60 -> 248
    //   191: astore_2
    //   192: aload_1
    //   193: astore_0
    //   194: aload_2
    //   195: astore_1
    //   196: goto +24 -> 220
    //   199: astore_2
    //   200: aload_1
    //   201: astore_0
    //   202: aload_2
    //   203: astore_1
    //   204: goto +32 -> 236
    //   207: aload_1
    //   208: invokestatic 244	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   211: iconst_1
    //   212: ireturn
    //   213: astore_0
    //   214: goto +34 -> 248
    //   217: astore_1
    //   218: aload_3
    //   219: astore_0
    //   220: aload_0
    //   221: astore_2
    //   222: aload_1
    //   223: invokevirtual 245	java/lang/OutOfMemoryError:printStackTrace	()V
    //   226: aload_0
    //   227: invokestatic 244	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   230: iconst_0
    //   231: ireturn
    //   232: astore_1
    //   233: aload 4
    //   235: astore_0
    //   236: aload_0
    //   237: astore_2
    //   238: aload_1
    //   239: invokevirtual 246	java/lang/Exception:printStackTrace	()V
    //   242: aload_0
    //   243: invokestatic 244	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   246: iconst_0
    //   247: ireturn
    //   248: aload_2
    //   249: invokestatic 244	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   252: aload_0
    //   253: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	paramBitmap	Bitmap
    //   0	254	1	paramString	String
    //   7	181	2	localObject1	Object
    //   191	4	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   199	4	2	localException	Exception
    //   221	28	2	localBitmap	Bitmap
    //   31	188	3	localObject2	Object
    //   33	201	4	localObject3	Object
    //   36	116	5	localObject4	Object
    //   49	81	6	localFile	File
    //   59	85	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   167	182	185	finally
    //   167	182	191	java/lang/OutOfMemoryError
    //   167	182	199	java/lang/Exception
    //   41	51	213	finally
    //   54	61	213	finally
    //   64	72	213	finally
    //   75	81	213	finally
    //   84	92	213	finally
    //   95	101	213	finally
    //   104	113	213	finally
    //   116	124	213	finally
    //   127	138	213	finally
    //   141	151	213	finally
    //   154	163	213	finally
    //   222	226	213	finally
    //   238	242	213	finally
    //   41	51	217	java/lang/OutOfMemoryError
    //   54	61	217	java/lang/OutOfMemoryError
    //   64	72	217	java/lang/OutOfMemoryError
    //   75	81	217	java/lang/OutOfMemoryError
    //   84	92	217	java/lang/OutOfMemoryError
    //   95	101	217	java/lang/OutOfMemoryError
    //   104	113	217	java/lang/OutOfMemoryError
    //   116	124	217	java/lang/OutOfMemoryError
    //   127	138	217	java/lang/OutOfMemoryError
    //   141	151	217	java/lang/OutOfMemoryError
    //   154	163	217	java/lang/OutOfMemoryError
    //   41	51	232	java/lang/Exception
    //   54	61	232	java/lang/Exception
    //   64	72	232	java/lang/Exception
    //   75	81	232	java/lang/Exception
    //   84	92	232	java/lang/Exception
    //   95	101	232	java/lang/Exception
    //   104	113	232	java/lang/Exception
    //   116	124	232	java/lang/Exception
    //   127	138	232	java/lang/Exception
    //   141	151	232	java/lang/Exception
    //   154	163	232	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.FilterEngineJNILib
 * JD-Core Version:    0.7.0.1
 */