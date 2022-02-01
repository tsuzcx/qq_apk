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
    f localf;
    int i;
    int j;
    do
    {
      return;
      localf = f.a(true);
      if (f.b)
      {
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
        return;
      }
      m localm = m.a(WebView.h());
      i = localm.c();
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = " + i);
      if (i == 2)
      {
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
        localf.a(String.valueOf(localm.b()));
        localf.b(true);
        return;
      }
      j = localm.b("copy_status");
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = " + j);
      if (j == 1)
      {
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
        localf.a(String.valueOf(localm.c("copy_core_ver")));
        localf.b(true);
        return;
      }
    } while ((x.a().b()) || ((i != 3) && (j != 3)));
    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
    localf.a(String.valueOf(f.c()));
    localf.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView.9
 * JD-Core Version:    0.7.0.1
 */