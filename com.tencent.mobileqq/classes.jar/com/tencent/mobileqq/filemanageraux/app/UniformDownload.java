package com.tencent.mobileqq.filemanageraux.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadUtil;
import com.tencent.qphone.base.util.QLog;

public class UniformDownload
{
  public static boolean a;
  Activity a;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  private UniformDownload(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public static boolean a(Activity paramActivity, String paramString, Bundle paramBundle)
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL]. >>>gotoDownload. url:" + paramString);
    if ((paramActivity == null) || (paramString == null) || (paramBundle == null))
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL]. gotoDownload. param error:");
      return false;
    }
    new UniformDownload(paramActivity).a(paramString, paramBundle);
    return true;
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    long l1 = paramBundle.getLong("_filesize");
    long l2 = paramBundle.getLong("_buttontype", 0L);
    ((IUniformDownloadUtil)QRoute.api(IUniformDownloadUtil.class)).getFileInfoOfUrlAsync(paramString, new UniformDownload.1(this, paramBundle, paramString, l1, l2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.app.UniformDownload
 * JD-Core Version:    0.7.0.1
 */