package com.tencent.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Environment;
import com.tencent.filter.QImage;
import com.tencent.view.FilterDefault;
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
    Object localObject = paramString1;
    if (paramString2 != null) {
      localObject = paramString1 + "." + paramString2;
    }
    if (new File((String)localObject).exists()) {
      return localObject;
    }
    paramString2 = FilterDefault.main_Context;
    if (paramString2 == null) {
      return null;
    }
    paramString2 = paramString2.getDir("filter", 0);
    if ((!paramString2.isDirectory()) && (!paramString2.mkdirs())) {
      return null;
    }
    paramString2 = new File(paramString2, (String)localObject);
    FileOutputStream localFileOutputStream;
    if (!paramString2.exists())
    {
      paramString2.mkdirs();
      paramString2.delete();
      try
      {
        localObject = FilterDefault.getInputStreamByName((String)localObject);
        if (localObject == null) {
          break label181;
        }
        paramString1 = new byte[1024];
        paramString2.createNewFile();
        localFileOutputStream = new FileOutputStream(paramString2);
        for (;;)
        {
          int i = ((InputStream)localObject).read(paramString1);
          if (i == -1) {
            break;
          }
          localFileOutputStream.write(paramString1, 0, i);
        }
        return paramString2.getAbsolutePath();
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    for (;;)
    {
      ((InputStream)localObject).close();
      localFileOutputStream.close();
    }
    label181:
    LogUtil.d("filter", "generateBundlePath notfound" + paramString1);
    return null;
  }
  
  /* Error */
  private static String generateName(long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 114	java/text/SimpleDateFormat
    //   6: dup
    //   7: ldc 116
    //   9: invokespecial 117	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   12: new 119	java/util/Date
    //   15: dup
    //   16: lload_0
    //   17: invokespecial 122	java/util/Date:<init>	(J)V
    //   20: invokevirtual 126	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   23: astore_2
    //   24: lload_0
    //   25: ldc2_w 127
    //   28: ldiv
    //   29: getstatic 12	com/tencent/util/FilterEngineJNILib:mLastDate	J
    //   32: ldc2_w 127
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
    //   59: ldc 130
    //   61: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: getstatic 14	com/tencent/util/FilterEngineJNILib:mSameSecondCount	I
    //   67: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
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
    throws IOException
  {
    if (FilterDefault.main_Context == null) {
      return null;
    }
    paramString = FilterDefault.main_Context.getAssets().open(paramString, 3);
    byte[] arrayOfByte = new byte[paramString.available()];
    paramString.read(arrayOfByte);
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
  
  public static byte[] readBundleData(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      InputStream localInputStream = FilterDefault.getInputStreamByName(paramString);
      if (localInputStream == null)
      {
        localObject1 = localObject2;
        LogUtil.e("FilterDefault", "decodeBitmap  getStream " + paramString + " not exist");
      }
      localObject1 = localObject2;
      paramString = FileEncryptUtils.decryptFile(localInputStream);
      localObject1 = paramString;
      IOUtils.closeQuietly(localInputStream);
      return paramString;
    }
    catch (Exception paramString)
    {
      LogUtil.e("FilterDefault", "decodeBitmap  getStream", paramString);
    }
    return localObject1;
  }
  
  public static QImage readBundleImage(String paramString)
  {
    paramString = FilterDefault.decodeBitmap(paramString);
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
    //   9: ldc 238
    //   11: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_1
    //   15: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: invokestatic 110	com/tencent/util/LogUtil:d	(Ljava/lang/Object;Ljava/lang/String;)I
    //   24: pop
    //   25: aconst_null
    //   26: astore 4
    //   28: aconst_null
    //   29: astore 5
    //   31: aconst_null
    //   32: astore_3
    //   33: aload 5
    //   35: astore_2
    //   36: new 37	java/io/File
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 40	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore 6
    //   46: aload 5
    //   48: astore_2
    //   49: aload 6
    //   51: invokevirtual 241	java/io/File:getParentFile	()Ljava/io/File;
    //   54: astore 7
    //   56: aload 5
    //   58: astore_2
    //   59: aload 7
    //   61: invokevirtual 44	java/io/File:exists	()Z
    //   64: ifne +12 -> 76
    //   67: aload 5
    //   69: astore_2
    //   70: aload 7
    //   72: invokevirtual 64	java/io/File:mkdirs	()Z
    //   75: pop
    //   76: aload 5
    //   78: astore_2
    //   79: aload 6
    //   81: invokevirtual 44	java/io/File:exists	()Z
    //   84: ifne +12 -> 96
    //   87: aload 5
    //   89: astore_2
    //   90: aload 6
    //   92: invokevirtual 77	java/io/File:createNewFile	()Z
    //   95: pop
    //   96: aload 5
    //   98: astore_2
    //   99: ldc 52
    //   101: new 24	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   108: ldc 243
    //   110: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload 6
    //   115: invokevirtual 44	java/io/File:exists	()Z
    //   118: invokevirtual 246	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   121: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 110	com/tencent/util/LogUtil:d	(Ljava/lang/Object;Ljava/lang/String;)I
    //   127: pop
    //   128: aload 5
    //   130: astore_2
    //   131: new 79	java/io/FileOutputStream
    //   134: dup
    //   135: aload_1
    //   136: invokespecial 247	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   139: astore_1
    //   140: aload_0
    //   141: ifnull +18 -> 159
    //   144: aload_0
    //   145: getstatic 253	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   148: bipush 95
    //   150: aload_1
    //   151: invokevirtual 257	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   154: pop
    //   155: aload_1
    //   156: invokevirtual 260	java/io/FileOutputStream:flush	()V
    //   159: aload_1
    //   160: invokestatic 263	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   163: iconst_1
    //   164: ireturn
    //   165: astore_1
    //   166: aload_3
    //   167: astore_0
    //   168: aload_0
    //   169: astore_2
    //   170: aload_1
    //   171: invokevirtual 264	java/lang/Exception:printStackTrace	()V
    //   174: aload_0
    //   175: invokestatic 263	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   178: iconst_0
    //   179: ireturn
    //   180: astore_1
    //   181: aload 4
    //   183: astore_0
    //   184: aload_0
    //   185: astore_2
    //   186: aload_1
    //   187: invokevirtual 265	java/lang/OutOfMemoryError:printStackTrace	()V
    //   190: aload_0
    //   191: invokestatic 263	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   194: iconst_0
    //   195: ireturn
    //   196: astore_0
    //   197: aload_2
    //   198: invokestatic 263	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   201: aload_0
    //   202: athrow
    //   203: astore_0
    //   204: aload_1
    //   205: astore_2
    //   206: goto -9 -> 197
    //   209: astore_2
    //   210: aload_1
    //   211: astore_0
    //   212: aload_2
    //   213: astore_1
    //   214: goto -30 -> 184
    //   217: astore_2
    //   218: aload_1
    //   219: astore_0
    //   220: aload_2
    //   221: astore_1
    //   222: goto -54 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	paramBitmap	Bitmap
    //   0	225	1	paramString	String
    //   35	171	2	localObject1	Object
    //   209	4	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   217	4	2	localException	Exception
    //   32	135	3	localObject2	Object
    //   26	156	4	localObject3	Object
    //   29	100	5	localObject4	Object
    //   44	70	6	localFile1	File
    //   54	17	7	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   36	46	165	java/lang/Exception
    //   49	56	165	java/lang/Exception
    //   59	67	165	java/lang/Exception
    //   70	76	165	java/lang/Exception
    //   79	87	165	java/lang/Exception
    //   90	96	165	java/lang/Exception
    //   99	128	165	java/lang/Exception
    //   131	140	165	java/lang/Exception
    //   36	46	180	java/lang/OutOfMemoryError
    //   49	56	180	java/lang/OutOfMemoryError
    //   59	67	180	java/lang/OutOfMemoryError
    //   70	76	180	java/lang/OutOfMemoryError
    //   79	87	180	java/lang/OutOfMemoryError
    //   90	96	180	java/lang/OutOfMemoryError
    //   99	128	180	java/lang/OutOfMemoryError
    //   131	140	180	java/lang/OutOfMemoryError
    //   36	46	196	finally
    //   49	56	196	finally
    //   59	67	196	finally
    //   70	76	196	finally
    //   79	87	196	finally
    //   90	96	196	finally
    //   99	128	196	finally
    //   131	140	196	finally
    //   170	174	196	finally
    //   186	190	196	finally
    //   144	159	203	finally
    //   144	159	209	java/lang/OutOfMemoryError
    //   144	159	217	java/lang/Exception
  }
  
  public static void writeToAlbum(long paramLong, int paramInt1, int paramInt2)
  {
    if (FilterDefault.ENABLE_DEBUG)
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      LogUtil.d("filter", "writeToAlbum: " + paramInt1 + " " + paramInt2);
      nativeCopyImage(localBitmap, paramLong);
      String str = generateName(System.currentTimeMillis());
      paramInt1 = saveBitmap(localBitmap, getSDPath() + "/filter/" + str + ".jpg");
      LogUtil.d("filter", "writeToAlbum ret: " + paramInt1);
      localBitmap.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.util.FilterEngineJNILib
 * JD-Core Version:    0.7.0.1
 */