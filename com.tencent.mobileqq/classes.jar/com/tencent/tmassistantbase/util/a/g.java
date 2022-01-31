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
    SDKReportManager2.getInstance().postReport(2002, Build.MANUFACTURER + "|" + Build.MODEL + "|do_hook_install|pkg=" + this.a.packageName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.a.g
 * JD-Core Version:    0.7.0.1
 */