package com.tencent.mobileqq.filemanager.app;

import ackp;
import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.qphone.base.util.QLog;

public class UniformDownload
{
  public static boolean a;
  public Activity a;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  private UniformDownload(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle)
  {
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL]. >>>gotoDownload. url:" + paramString);
    if ((paramActivity == null) || (paramString == null) || (paramBundle == null))
    {
      QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL]. gotoDownload. param error:");
      return;
    }
    new UniformDownload(paramActivity).a(paramString, paramBundle);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    UniformDownloadUtil.a(paramString, new ackp(this, paramBundle, paramString, paramBundle.getLong("_filesize"), paramBundle.getLong("_buttontype", 0L)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.UniformDownload
 * JD-Core Version:    0.7.0.1
 */