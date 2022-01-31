package cooperation.qzone.vision;

import android.graphics.Bitmap;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.AlbumLibDownloaderUtil;
import java.io.File;

public class PhotoUtil
{
  public static boolean a;
  
  static
  {
    a();
  }
  
  /* Error */
  public static boolean a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 20	cooperation/qzone/vision/PhotoUtil:b	()Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +118 -> 126
    //   11: getstatic 25	cooperation/qzone/util/AlbumLibDownloaderUtil:a	Ljava/io/File;
    //   14: invokevirtual 31	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   17: astore_1
    //   18: ldc 33
    //   20: iconst_1
    //   21: new 35	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   28: ldc 38
    //   30: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 44
    //   39: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 53	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: new 35	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   55: aload_1
    //   56: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 44
    //   61: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 59	java/lang/System:load	(Ljava/lang/String;)V
    //   70: ldc 33
    //   72: iconst_1
    //   73: new 35	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   80: ldc 61
    //   82: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_1
    //   86: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc 63
    //   91: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 53	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: new 35	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   107: aload_1
    //   108: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 63
    //   113: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 59	java/lang/System:load	(Ljava/lang/String;)V
    //   122: iconst_1
    //   123: putstatic 65	cooperation/qzone/vision/PhotoUtil:a	Z
    //   126: getstatic 65	cooperation/qzone/vision/PhotoUtil:a	Z
    //   129: istore_0
    //   130: ldc 2
    //   132: monitorexit
    //   133: iload_0
    //   134: ireturn
    //   135: astore_1
    //   136: ldc 33
    //   138: iconst_1
    //   139: ldc 67
    //   141: invokestatic 53	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: aload_1
    //   145: invokevirtual 70	java/lang/Throwable:printStackTrace	()V
    //   148: iconst_0
    //   149: putstatic 65	cooperation/qzone/vision/PhotoUtil:a	Z
    //   152: goto -26 -> 126
    //   155: astore_1
    //   156: ldc 2
    //   158: monitorexit
    //   159: aload_1
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	128	0	bool	boolean
    //   17	91	1	str	String
    //   135	10	1	localThrowable	java.lang.Throwable
    //   155	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	126	135	java/lang/Throwable
    //   3	7	155	finally
    //   11	126	155	finally
    //   126	130	155	finally
    //   136	152	155	finally
  }
  
  public static boolean b()
  {
    if (c()) {
      return true;
    }
    AlbumLibDownloaderUtil.a().b();
    return false;
  }
  
  public static boolean c()
  {
    Object localObject = AlbumLibDownloaderUtil.a.getAbsolutePath();
    localObject = new File((String)localObject + "/photoQulatitySo.zip");
    boolean bool = LocalMultiProcConfig.getBool(AlbumLibDownloaderUtil.c, true);
    if (!AlbumLibDownloaderUtil.a().a(AlbumLibDownloaderUtil.c, bool)) {
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
    }
    do
    {
      return false;
      bool = LocalMultiProcConfig.getBool(AlbumLibDownloaderUtil.b, true);
      if (AlbumLibDownloaderUtil.a().a(AlbumLibDownloaderUtil.b, bool)) {
        break;
      }
    } while (!((File)localObject).exists());
    ((File)localObject).delete();
    return false;
    return true;
  }
  
  public static native void getAntiShakeBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3);
  
  public static native float getHashSimilarity(long paramLong1, long paramLong2);
  
  public static native long getImageDHash(Bitmap paramBitmap);
  
  public static native long getImageDHashByPath(String paramString);
  
  public static native float getImageExposure(Bitmap paramBitmap);
  
  public static native long getImageHash(Bitmap paramBitmap);
  
  public static native long getImageHashByPath(String paramString);
  
  public static native float getImageQuality(Bitmap paramBitmap);
  
  public static native float getImageQualityByPath(String paramString);
  
  public static native float getImageSimilarity(Bitmap paramBitmap1, Bitmap paramBitmap2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.vision.PhotoUtil
 * JD-Core Version:    0.7.0.1
 */