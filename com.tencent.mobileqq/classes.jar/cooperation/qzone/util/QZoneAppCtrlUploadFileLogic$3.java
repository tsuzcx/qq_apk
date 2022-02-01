package cooperation.qzone.util;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FilenameFilter;

final class QZoneAppCtrlUploadFileLogic$3
  implements FilenameFilter
{
  QZoneAppCtrlUploadFileLogic$3(long paramLong1, long paramLong2) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    if ((!paramString.startsWith("QAVSDK")) && (!paramString.startsWith("qavsdk"))) {}
    long l;
    do
    {
      File localFile;
      do
      {
        do
        {
          return false;
        } while (paramString.split("_").length == 2);
        localFile = new File(paramFile + File.separator + paramString);
      } while ((localFile == null) || (!localFile.exists()));
      l = localFile.lastModified();
      if (QLog.isDevelopLevel())
      {
        QLog.d("QZoneAppCtrlUploadFileLogic", 4, "file dir: " + paramFile.getName());
        QLog.d("QZoneAppCtrlUploadFileLogic", 4, "file name: " + paramString + " mStartTime: " + this.val$mStartTime + " mEndTime: " + this.val$mEndTime + " lastModifiedTime: " + l);
      }
    } while ((l < this.val$mStartTime) || (l > this.val$mEndTime));
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneAppCtrlUploadFileLogic", 4, "find file name: " + paramString);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.util.QZoneAppCtrlUploadFileLogic.3
 * JD-Core Version:    0.7.0.1
 */