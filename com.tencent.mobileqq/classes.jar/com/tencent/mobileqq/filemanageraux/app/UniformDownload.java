package com.tencent.mobileqq.filemanageraux.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadUtil;
import com.tencent.qphone.base.util.QLog;

public class UniformDownload
{
  public static boolean a = true;
  Activity b;
  
  private UniformDownload(Activity paramActivity)
  {
    this.b = paramActivity;
  }
  
  public static boolean a(Activity paramActivity, String paramString, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL]. >>>gotoDownload. url:");
    localStringBuilder.append(paramString);
    QLog.i("UniformDownloadMgr<FileAssistant>", 1, localStringBuilder.toString());
    if ((paramActivity != null) && (paramString != null) && (paramBundle != null))
    {
      new UniformDownload(paramActivity).a(paramString, paramBundle);
      return true;
    }
    QLog.e("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL]. gotoDownload. param error:");
    return false;
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    long l1 = paramBundle.getLong("_filesize");
    long l2 = paramBundle.getLong("_buttontype", 0L);
    ((IUniformDownloadUtil)QRoute.api(IUniformDownloadUtil.class)).getFileInfoOfUrlAsync(paramString, new UniformDownload.1(this, paramBundle, paramString, l1, l2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.app.UniformDownload
 * JD-Core Version:    0.7.0.1
 */