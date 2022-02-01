package cooperation.qzone.pfc.opencv;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
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
  
  public static boolean loadNativeLib()
  {
    try
    {
      boolean bool = isLibDownloaded();
      if (bool) {
        try
        {
          String str = AlbumLibDownloaderUtil.mAlbumDir.getAbsolutePath();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("loadLibrary libc++_shared.so, sopath=");
          localStringBuilder.append(str);
          localStringBuilder.append("/libc++_shared.so");
          QLog.i("NativeLibLoader", 1, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("/libc++_shared.so");
          System.load(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("loadLibrary libqzone_vision.so, sopath=");
          localStringBuilder.append(str);
          localStringBuilder.append("/libqzone_vision.so");
          QLog.i("NativeLibLoader", 1, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("/libqzone_vision.so");
          System.load(localStringBuilder.toString());
          mNativeLibLoaded = true;
        }
        catch (Throwable localThrowable)
        {
          QLog.i("NativeLibLoader", 1, "loadLibrary libqzone_vision.so or libc++_shared.so failed", localThrowable);
          localThrowable.printStackTrace();
          mNativeLibLoaded = false;
        }
      }
      bool = mNativeLibLoaded;
      return bool;
    }
    finally {}
  }
  
  public static boolean vertifySOIsOk()
  {
    Object localObject = AlbumLibDownloaderUtil.mAlbumDir.getAbsolutePath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("/photoQulatitySo.zip");
    localObject = new File(localStringBuilder.toString());
    boolean bool = LocalMultiProcConfig.getBool(AlbumLibDownloaderUtil.LIB_SHARED_NAME, true);
    if (!AlbumLibDownloaderUtil.getInstance().vertifySoIsOK(AlbumLibDownloaderUtil.LIB_SHARED_NAME, bool))
    {
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      return false;
    }
    bool = LocalMultiProcConfig.getBool(AlbumLibDownloaderUtil.LIB_QZONE_VISION_NAME, true);
    if (!AlbumLibDownloaderUtil.getInstance().vertifySoIsOK(AlbumLibDownloaderUtil.LIB_QZONE_VISION_NAME, bool))
    {
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.pfc.opencv.QzoneVision
 * JD-Core Version:    0.7.0.1
 */