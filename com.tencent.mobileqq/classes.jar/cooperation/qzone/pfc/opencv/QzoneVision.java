package cooperation.qzone.pfc.opencv;

import android.graphics.Bitmap;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.AlbumLibDownloaderUtil;
import java.io.File;

public class QzoneVision
{
  public static final String LOG_TAG = "NativeLibLoader";
  public static boolean mNativeLibLoaded;
  
  static
  {
    loadNativeLib();
  }
  
  public static native void getAntiShakeBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3);
  
  public static boolean isLibDownloaded()
  {
    if (vertifySOIsOk()) {
      return true;
    }
    AlbumLibDownloaderUtil.getInstance().downloadPicQulatitySo();
    return false;
  }
  
  /* Error */
  public static boolean loadNativeLib()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 39	cooperation/qzone/pfc/opencv/QzoneVision:isLibDownloaded	()Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +118 -> 126
    //   11: getstatic 43	cooperation/qzone/util/AlbumLibDownloaderUtil:mAlbumDir	Ljava/io/File;
    //   14: invokevirtual 49	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   17: astore_1
    //   18: ldc 8
    //   20: iconst_1
    //   21: new 51	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   28: ldc 54
    //   30: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 60
    //   39: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 69	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: new 51	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   55: aload_1
    //   56: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 60
    //   61: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 75	java/lang/System:load	(Ljava/lang/String;)V
    //   70: ldc 8
    //   72: iconst_1
    //   73: new 51	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   80: ldc 77
    //   82: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_1
    //   86: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc 79
    //   91: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 69	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: new 51	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   107: aload_1
    //   108: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 79
    //   113: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 75	java/lang/System:load	(Ljava/lang/String;)V
    //   122: iconst_1
    //   123: putstatic 81	cooperation/qzone/pfc/opencv/QzoneVision:mNativeLibLoaded	Z
    //   126: getstatic 81	cooperation/qzone/pfc/opencv/QzoneVision:mNativeLibLoaded	Z
    //   129: istore_0
    //   130: ldc 2
    //   132: monitorexit
    //   133: iload_0
    //   134: ireturn
    //   135: astore_1
    //   136: ldc 8
    //   138: iconst_1
    //   139: ldc 83
    //   141: aload_1
    //   142: invokestatic 86	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   145: aload_1
    //   146: invokevirtual 89	java/lang/Throwable:printStackTrace	()V
    //   149: iconst_0
    //   150: putstatic 81	cooperation/qzone/pfc/opencv/QzoneVision:mNativeLibLoaded	Z
    //   153: goto -27 -> 126
    //   156: astore_1
    //   157: ldc 2
    //   159: monitorexit
    //   160: aload_1
    //   161: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	128	0	bool	boolean
    //   17	91	1	str	String
    //   135	11	1	localThrowable	java.lang.Throwable
    //   156	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	126	135	java/lang/Throwable
    //   3	7	156	finally
    //   11	126	156	finally
    //   126	130	156	finally
    //   136	153	156	finally
  }
  
  public static boolean vertifySOIsOk()
  {
    Object localObject = AlbumLibDownloaderUtil.mAlbumDir.getAbsolutePath();
    localObject = new File((String)localObject + "/photoQulatitySo.zip");
    boolean bool = LocalMultiProcConfig.getBool(AlbumLibDownloaderUtil.LIB_SHARED_NAME, true);
    if (!AlbumLibDownloaderUtil.getInstance().vertifySoIsOK(AlbumLibDownloaderUtil.LIB_SHARED_NAME, bool)) {
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
    }
    do
    {
      return false;
      bool = LocalMultiProcConfig.getBool(AlbumLibDownloaderUtil.LIB_QZONE_VISION_NAME, true);
      if (AlbumLibDownloaderUtil.getInstance().vertifySoIsOK(AlbumLibDownloaderUtil.LIB_QZONE_VISION_NAME, bool)) {
        break;
      }
    } while (!((File)localObject).exists());
    ((File)localObject).delete();
    return false;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.pfc.opencv.QzoneVision
 * JD-Core Version:    0.7.0.1
 */