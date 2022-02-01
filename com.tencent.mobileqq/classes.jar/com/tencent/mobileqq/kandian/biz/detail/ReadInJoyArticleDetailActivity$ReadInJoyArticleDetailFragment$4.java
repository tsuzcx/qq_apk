package com.tencent.mobileqq.kandian.biz.detail;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.kandian.repo.webarticle.RIJPageGenerator;
import com.tencent.mobileqq.kandian.repo.webarticle.RIJWebArticleReportUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.webview.swift.WebViewKernel;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

class ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment$4
  implements Runnable
{
  ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment$4(ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment paramReadInJoyArticleDetailFragment, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_model", Build.MODEL);
        localHashMap.put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
        localHashMap.put("param_qqVer", "8.8.17.5770");
        localHashMap.put("param_totalMem", String.valueOf(DeviceInfoUtil.a()));
        localHashMap.put("param_availableMem", String.valueOf(this.a));
        localHashMap.put("param_cpuNum", String.valueOf(DeviceInfoUtil.h()));
        localHashMap.put("param_cpuFreq", String.valueOf(DeviceInfoUtil.k()));
        localHashMap.put("param_clickToCreate", String.valueOf(this.this$0.d - this.b));
        localHashMap.put("param_clickToLoadUrl", String.valueOf(this.this$0.e - this.b));
        localHashMap.put("param_clickToPageStart", String.valueOf(this.this$0.f - this.b));
        localHashMap.put("param_clickToFirstWord", String.valueOf(this.this$0.h - this.b));
        localHashMap.put("param_clickToPageFinish", String.valueOf(this.this$0.g - this.b));
        localHashMap.put("param_isSupportNative", this.this$0.i);
        localHashMap.put("param_toolProcessLevel", String.valueOf(this.c));
        localHashMap.put("param_inPreloadWhiteList", String.valueOf(this.d));
        localHashMap.put("param_uin", this.this$0.getAppRuntime().getCurrentAccountUin());
        if (RIJPageGenerator.INSTANCE.isHitCache(ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.c(this.this$0)))
        {
          String str1 = "1";
          localHashMap.put("param_hit_web_data_preload", str1);
          if (QLog.isColorLevel())
          {
            str1 = ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.a;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("doOpenReportAsync:");
            localStringBuilder.append(localHashMap.toString());
            QLog.d(str1, 2, localStringBuilder.toString());
          }
          StatisticCollector.getInstance(this.this$0.getActivity()).collectPerformance(this.this$0.getAppRuntime().getCurrentAccountUin(), "actReadInJoyArticleOpen", true, 0L, 0L, localHashMap, "");
          RIJWebArticleReportUtil.a.a(localHashMap, ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.d(this.this$0).i());
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
      String str2 = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.4
 * JD-Core Version:    0.7.0.1
 */