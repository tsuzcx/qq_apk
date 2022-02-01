package com.tencent.tmassistantbase.util.a;

import android.content.pm.PackageInfo;
import android.os.Build;
import com.tencent.tmassistant.st.SDKReportManager2;

class g
  implements Runnable
{
  g(e parame, PackageInfo paramPackageInfo) {}
  
  public void run()
  {
    SDKReportManager2 localSDKReportManager2 = SDKReportManager2.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append("|");
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append("|do_hook_install|pkg=");
    localStringBuilder.append(this.a.packageName);
    localSDKReportManager2.postReport(2002, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.a.g
 * JD-Core Version:    0.7.0.1
 */