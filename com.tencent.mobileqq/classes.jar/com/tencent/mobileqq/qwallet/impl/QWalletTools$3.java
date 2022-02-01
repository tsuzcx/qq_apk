package com.tencent.mobileqq.qwallet.impl;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.CommonUtil;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class QWalletTools$3
  implements Runnable
{
  QWalletTools$3(String paramString1, int paramInt1, String paramString2, AppRuntime paramAppRuntime, String paramString3, String paramString4, int paramInt2, String paramString5, long paramLong) {}
  
  public void run()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("Tenpay_mqq");
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.a);
    localStringBuilder1.append("||");
    localStringBuilder1.append(this.b);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.c);
    localStringBuilder1.append("|0|1|0|android.");
    try
    {
      localStringBuilder1.append(this.d.getApplication().getPackageManager().getPackageInfo(this.d.getApplication().getPackageName(), 0).versionName);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    localStringBuilder1.append("|");
    localStringBuilder1.append(CommonUtil.b());
    localStringBuilder1.append("|");
    if ((!TextUtils.isEmpty(this.e)) || (!TextUtils.isEmpty(this.f)))
    {
      localStringBuilder1.append(this.e);
      localStringBuilder1.append(".");
      localStringBuilder1.append(this.f);
    }
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.g);
    localStringBuilder1.append(".");
    if (!TextUtils.isEmpty(this.h)) {
      localStringBuilder1.append(this.h.replace("|", ","));
    }
    localStringBuilder1.append("|");
    long l = this.i;
    if (0L != l)
    {
      String str = this.c;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("op_type=");
      localStringBuilder2.append(this.b);
      VACDReportUtil.a(l, null, str, localStringBuilder2.toString(), 0, "");
    }
    StatisticCollector.getInstance(MobileQQ.getContext()).reportToPCliOper(this.d, localStringBuilder1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.QWalletTools.3
 * JD-Core Version:    0.7.0.1
 */