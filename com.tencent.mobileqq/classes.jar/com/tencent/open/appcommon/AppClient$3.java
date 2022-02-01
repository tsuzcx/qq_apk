package com.tencent.open.appcommon;

import android.app.Activity;
import android.os.Bundle;
import bhwo;
import bibw;
import bicl;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public final class AppClient$3
  implements Runnable
{
  public AppClient$3(String paramString1, String paramString2, String paramString3, Activity paramActivity, boolean paramBoolean) {}
  
  public void run()
  {
    if (bicl.a().b())
    {
      Bundle localBundle = new Bundle();
      String str = bibw.b;
      if (this.jdField_a_of_type_JavaLangString == null) {}
      for (localObject = "";; localObject = this.jdField_a_of_type_JavaLangString)
      {
        localBundle.putString(str, (String)localObject);
        localBundle.putString(bibw.c, "");
        localBundle.putString(bibw.d, "");
        localBundle.putString(bibw.f, this.b);
        localBundle.putInt(bibw.e, 0);
        localBundle.putString(bibw.i, "ANDROIDQQ.SHARESOURCE");
        localBundle.putString("big_brother_source_key", this.c);
        ThreadManager.getSubThreadHandler().post(new AppClient.3.1(this, localBundle));
        return;
      }
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("uin", "");
    ((Bundle)localObject).putString("sid", "");
    ((Bundle)localObject).putString("via", "ANDROIDQQ.SHARESOURCE");
    ((Bundle)localObject).putBoolean("autoDownload", false);
    ((Bundle)localObject).putString("packageName", this.b);
    ((Bundle)localObject).putString("subpagetype", "SHARESOURCE");
    bhwo.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, 2462, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.AppClient.3
 * JD-Core Version:    0.7.0.1
 */