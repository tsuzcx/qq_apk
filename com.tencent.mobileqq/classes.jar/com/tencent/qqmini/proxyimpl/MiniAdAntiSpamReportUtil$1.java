package com.tencent.qqmini.proxyimpl;

import android.os.Bundle;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;

final class MiniAdAntiSpamReportUtil$1
  implements Runnable
{
  MiniAdAntiSpamReportUtil$1(Bundle paramBundle) {}
  
  public void run()
  {
    this.a.putInt("PostBodyType", 1);
    try
    {
      String str = HttpUtil.openUrl(BaseApplicationImpl.getContext(), "https://rpt.gdt.qq.com/mqq_log", "POST", this.a, null);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("report reportParams=");
      localStringBuilder.append(this.a.toString());
      localStringBuilder.append(" result=");
      localStringBuilder.append(str);
      QLog.i("MiniAdAntiSpamReportUtil", 1, localStringBuilder.toString());
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report error. url=");
      localStringBuilder.append("https://rpt.gdt.qq.com/mqq_log");
      localStringBuilder.append(" reportParams=");
      localStringBuilder.append(this.a.toString());
      QLog.e("MiniAdAntiSpamReportUtil", 1, localStringBuilder.toString(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAdAntiSpamReportUtil.1
 * JD-Core Version:    0.7.0.1
 */