package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.OpenProxy;
import com.tencent.open.agent.OpenSdkIMBlockFragment;
import com.tencent.open.agent.util.AuthParamUtil;
import com.tencent.open.data.SharedPrefs;

public class OpenSdkLoginAction
  extends BaseLoginAction
{
  public void a(Activity paramActivity, Bundle paramBundle)
  {
    if (!AuthParamUtil.a(paramBundle)) {
      OpenSdkIMBlockFragment.a(paramActivity, SharedPrefs.c(), true);
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity, int paramInt)
  {
    if (!AuthParamUtil.a(paramQBaseActivity.getIntent().getExtras())) {
      return;
    }
    String str = null;
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 3) {
          if (paramInt != 4) {
            break label63;
          }
        }
      }
    }
    for (;;)
    {
      str = "0x800BA21";
      continue;
      str = "0x800BA1F";
      continue;
      str = "0x800BA20";
      continue;
      str = "0x800BA1E";
    }
    label63:
    if (str != null) {
      ReportController.a(paramQBaseActivity.getAppRuntime(), "dc00898", "", "", str, str, 0, 0, "", "", "", "");
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