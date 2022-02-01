package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.OpenProxy;
import com.tencent.open.agent.OpenSdkIMBlockFragment;
import com.tencent.open.data.SharedPrefs;

public class OpenSdkLoginAction
  extends BaseLoginAction
{
  private boolean a(Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBundle != null)
    {
      bool1 = bool2;
      if (paramBundle.getBoolean("authority_start_qq_login", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void a(Activity paramActivity, Bundle paramBundle)
  {
    if (!a(paramBundle)) {
      OpenSdkIMBlockFragment.a(paramActivity, SharedPrefs.a(), true);
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity, int paramInt)
  {
    if (!a(paramQBaseActivity.getIntent().getExtras())) {}
    for (;;)
    {
      return;
      String str = null;
      switch (paramInt)
      {
      }
      while (str != null)
      {
        ReportController.a(paramQBaseActivity.getAppRuntime(), "dc00898", "", "", str, str, 0, 0, "", "", "", "");
        return;
        str = "0x800BA1E";
        continue;
        str = "0x800BA20";
        continue;
        str = "0x800BA1F";
        continue;
        str = "0x800BA21";
      }
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity, String paramString, boolean paramBoolean)
  {
    OpenProxy.a().b(paramString);
  }
  
  public void a(String paramString)
  {
    OpenProxy.a().b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.OpenSdkLoginAction
 * JD-Core Version:    0.7.0.1
 */