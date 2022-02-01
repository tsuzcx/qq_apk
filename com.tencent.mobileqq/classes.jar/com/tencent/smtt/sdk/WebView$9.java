package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;

final class WebView$9
  implements Runnable
{
  public void run()
  {
    if (WebView.h() == null) {
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
    }
    d locald;
    int i;
    int j;
    do
    {
      return;
      locald = d.a(true);
      if (d.b)
      {
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
        return;
      }
      k localk = k.a(WebView.h());
      i = localk.c();
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = " + i);
      if (i == 2)
      {
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
        locald.a(String.valueOf(localk.b()));
        locald.b(true);
        return;
      }
      j = localk.b("copy_status");
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = " + j);
      if (j == 1)
      {
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
        locald.a(String.valueOf(localk.c("copy_core_ver")));
        locald.b(true);
        return;
      }
    } while ((v.a().b()) || ((i != 3) && (j != 3)));
    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
    locald.a(String.valueOf(d.c()));
    locald.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView.9
 * JD-Core Version:    0.7.0.1
 */