package com.tencent.open.appcommon;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.MyAppApi;
import mqq.os.MqqHandler;

final class AppClient$3
  implements Runnable
{
  AppClient$3(String paramString1, String paramString2, String paramString3, Activity paramActivity, boolean paramBoolean) {}
  
  public void run()
  {
    MyAppApi.a();
    if (MyAppApi.b())
    {
      Bundle localBundle = new Bundle();
      String str2 = DownloadConstants.b;
      String str1 = this.jdField_a_of_type_JavaLangString;
      localObject = str1;
      if (str1 == null) {
        localObject = "";
      }
      localBundle.putString(str2, (String)localObject);
      localBundle.putString(DownloadConstants.c, "");
      localBundle.putString(DownloadConstants.d, "");
      localBundle.putString(DownloadConstants.f, this.b);
      localBundle.putInt(DownloadConstants.e, 0);
      localBundle.putString(DownloadConstants.i, "ANDROIDQQ.SHARESOURCE");
      localBundle.putString("big_brother_source_key", this.c);
      ThreadManager.getSubThreadHandler().post(new AppClient.3.1(this, localBundle));
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("uin", "");
    ((Bundle)localObject).putString("sid", "");
    ((Bundle)localObject).putString("via", "ANDROIDQQ.SHARESOURCE");
    ((Bundle)localObject).putBoolean("autoDownload", false);
    ((Bundle)localObject).putString("packageName", this.b);
    ((Bundle)localObject).putString("subpagetype", "SHARESOURCE");
    AppClient.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 2462, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.AppClient.3
 * JD-Core Version:    0.7.0.1
 */