package cooperation.qqcircle.picload;

import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;

public class RFWPicLoadConfig
{
  private static final String TAG = "RFWPicLoadConfig";
  
  public static boolean useOkHttpDownLoadPic()
  {
    int i = QCircleConfigHelper.a("qqcircle", "qqcircle_use_okhppt_download_pic", Integer.valueOf(1)).intValue();
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("useOkHttp downloadpic:");
        localStringBuilder.append(i);
        QLog.e("RFWPicLoadConfig", 1, localStringBuilder.toString());
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return i == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.picload.RFWPicLoadConfig
 * JD-Core Version:    0.7.0.1
 */