package cooperation.qzone.webviewplugin.personalize;

import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.QZoneFilePath;
import java.io.File;
import java.io.IOException;

class QZoneFacadeJsHandleLogic$InnerEnvironment
{
  private static final String TAG = "InnerEnvironment";
  
  public static File getExternalCacheDir()
  {
    try
    {
      String str = QZoneFilePath.ROOT_QZONE_PATH;
      File localFile = new File(str);
      boolean bool = localFile.exists();
      if (!bool)
      {
        try
        {
          new File(str, ".nomedia").createNewFile();
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
        }
        if (!localFile.mkdirs())
        {
          if (QLog.isColorLevel()) {
            QLog.w("InnerEnvironment", 2, "Unable to create external cache directory");
          }
          return null;
        }
      }
      return localFile;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.personalize.QZoneFacadeJsHandleLogic.InnerEnvironment
 * JD-Core Version:    0.7.0.1
 */