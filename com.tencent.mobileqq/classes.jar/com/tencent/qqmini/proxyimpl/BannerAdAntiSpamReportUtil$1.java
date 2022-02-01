package com.tencent.qqmini.proxyimpl;

import android.os.Bundle;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import nlw;

public final class BannerAdAntiSpamReportUtil$1
  implements Runnable
{
  public BannerAdAntiSpamReportUtil$1(Bundle paramBundle) {}
  
  public void run()
  {
    this.a.putInt("PostBodyType", 1);
    try
    {
      String str = nlw.a(BaseApplicationImpl.getContext(), "https://rpt.gdt.qq.com/mqq_log", "POST", this.a, null);
      QLog.i("BannerAdAntiSpamReportUtil", 1, "report reportParams=" + this.a.toString() + " result=" + str);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("BannerAdAntiSpamReportUtil", 1, "report error. url=" + "https://rpt.gdt.qq.com/mqq_log" + " reportParams=" + this.a.toString(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.BannerAdAntiSpamReportUtil.1
 * JD-Core Version:    0.7.0.1
 */