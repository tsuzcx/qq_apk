package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;

final class WebView$8
  implements Runnable
{
  public void run()
  {
    if (WebView.g() == null)
    {
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
      return;
    }
    f localf = f.a(true);
    if (f.b)
    {
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
      return;
    }
    m localm = m.a(WebView.g());
    int i = localm.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebView.updateNeeeRebootStatus--installStatus = ");
    localStringBuilder.append(i);
    TbsLog.d("TbsNeedReboot", localStringBuilder.toString());
    if (i == 2)
    {
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
      localf.a(String.valueOf(localm.b()));
      localf.b(true);
      return;
    }
    int j = localm.b("copy_status");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebView.updateNeeeRebootStatus--copyStatus = ");
    localStringBuilder.append(j);
    TbsLog.d("TbsNeedReboot", localStringBuilder.toString());
    if (j == 1)
    {
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
      localf.a(String.valueOf(localm.c("copy_core_ver")));
      localf.b(true);
      return;
    }
    if ((!x.a().b()) && ((i == 3) || (j == 3)))
    {
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
      localf.a(String.valueOf(f.c()));
      localf.b(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView.8
 * JD-Core Version:    0.7.0.1
 */