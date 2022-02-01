package cooperation.qzone.util;

import com.tencent.mobileqq.testassister.ShareAppLogHelper.LogFile;
import java.util.Comparator;

final class QZoneAppCtrlUploadFileLogic$2
  implements Comparator<ShareAppLogHelper.LogFile>
{
  public int compare(ShareAppLogHelper.LogFile paramLogFile1, ShareAppLogHelper.LogFile paramLogFile2)
  {
    return (int)(paramLogFile1.lastModified() - paramLogFile2.lastModified()) / 1000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.util.QZoneAppCtrlUploadFileLogic.2
 * JD-Core Version:    0.7.0.1
 */