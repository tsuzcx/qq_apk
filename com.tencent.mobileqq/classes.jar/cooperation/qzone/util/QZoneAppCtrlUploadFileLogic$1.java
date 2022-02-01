package cooperation.qzone.util;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FilenameFilter;

final class QZoneAppCtrlUploadFileLogic$1
  implements FilenameFilter
{
  QZoneAppCtrlUploadFileLogic$1(long paramLong1, long paramLong2) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    if (!paramString.endsWith(".trace")) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramFile);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramString);
    localObject = new File(((StringBuilder)localObject).toString());
    if (!((File)localObject).exists()) {
      return false;
    }
    long l = ((File)localObject).lastModified();
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("file dir: ");
      ((StringBuilder)localObject).append(paramFile.getName());
      QLog.d("QZoneAppCtrlUploadFileLogic", 4, ((StringBuilder)localObject).toString());
      paramFile = new StringBuilder();
      paramFile.append("file name: ");
      paramFile.append(paramString);
      paramFile.append(" mStartTime: ");
      paramFile.append(this.val$mStartTime);
      paramFile.append(" mEndTime: ");
      paramFile.append(this.val$mEndTime);
      paramFile.append(" lastModifiedTime: ");
      paramFile.append(l);
      QLog.d("QZoneAppCtrlUploadFileLogic", 4, paramFile.toString());
    }
    if (l >= this.val$mStartTime)
    {
      if (l > this.val$mEndTime) {
        return false;
      }
      if (QLog.isDevelopLevel())
      {
        paramFile = new StringBuilder();
        paramFile.append("find file name: ");
        paramFile.append(paramString);
        QLog.d("QZoneAppCtrlUploadFileLogic", 4, paramFile.toString());
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.util.QZoneAppCtrlUploadFileLogic.1
 * JD-Core Version:    0.7.0.1
 */