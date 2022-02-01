package com.tencent.open.adapter;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class OpenAppClient$GetVkeyRunnable
  implements Runnable
{
  protected Activity a;
  protected int b;
  protected String c;
  protected AppRuntime d;
  
  public OpenAppClient$GetVkeyRunnable(Activity paramActivity, int paramInt, String paramString)
  {
    this.a = paramActivity;
    paramActivity = this.a;
    if ((paramActivity instanceof BaseActivity)) {
      this.d = ((BaseActivity)paramActivity).getAppRuntime();
    }
    this.b = paramInt;
    this.c = paramString;
  }
  
  public OpenAppClient$GetVkeyRunnable(AppRuntime paramAppRuntime, int paramInt, String paramString)
  {
    this.d = paramAppRuntime;
    this.b = paramInt;
    this.c = paramString;
  }
  
  public void run()
  {
    if (!APNUtil.k(CommonDataAdapter.a().b())) {
      return;
    }
    String str = null;
    Object localObject = this.d;
    if (localObject == null) {
      return;
    }
    localObject = ((TicketManager)((AppRuntime)localObject).getManager(2)).getSkey(this.d.getAccount());
    AppRuntime localAppRuntime = this.d;
    if ((localAppRuntime instanceof QQAppInterface)) {
      str = ((QQAppInterface)localAppRuntime).getCurrentAccountUin();
    } else if ((localAppRuntime instanceof BrowserAppInterface)) {
      str = ((BrowserAppInterface)localAppRuntime).getAccount();
    }
    if ((str != null) && (!str.equals(String.valueOf(CommonDataAdapter.a().c())))) {
      CommonDataAdapter.a().a(Long.valueOf(str).longValue());
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      LogUtility.b(OpenAppClient.a, "Get skey success");
      CommonDataAdapter.a().a((String)localObject);
    }
    OpenAppClient.d = false;
    int i = this.b;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      AppClient.b(this.a, this.c, str, (String)localObject);
      return;
    }
    AppClient.a(this.a, this.c, str, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.adapter.OpenAppClient.GetVkeyRunnable
 * JD-Core Version:    0.7.0.1
 */