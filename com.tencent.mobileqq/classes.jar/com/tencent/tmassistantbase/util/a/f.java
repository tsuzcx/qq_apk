package com.tencent.tmassistantbase.util.a;

import android.content.pm.PackageInfo;
import android.os.Build;
import com.tencent.tmassistant.st.SDKReportManager2;

class f
  implements Runnable
{
  f(e parame, PackageInfo paramPackageInfo) {}
  
  public void run()
  {
    SDKReportManager2.getInstance().postReport(2003, Build.MANUFACTURER + "|" + Build.MODEL + "|do_hook_install|pkg=" + this.a.packageName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.a.f
 * JD-Core Version:    0.7.0.1
 */