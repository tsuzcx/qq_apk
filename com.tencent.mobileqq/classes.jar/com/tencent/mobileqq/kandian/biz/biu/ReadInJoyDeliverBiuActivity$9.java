package com.tencent.mobileqq.kandian.biz.biu;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

class ReadInJoyDeliverBiuActivity$9
  extends ReadInJoyObserver
{
  ReadInJoyDeliverBiuActivity$9(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity) {}
  
  public void a(int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    super.a(paramInt1, paramLong, paramString1, paramInt2, paramString2, paramString3);
    ReadInJoyDeliverBiuActivity.b(this.a, true);
    ReadInJoyDeliverBiuActivity.b(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDeliverUGCResult retCode=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", feedsId=");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", rowkey=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", status=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", comment=");
    localStringBuilder.append(paramString2);
    QLog.d("ReadInJoyDeliverBiuActivity", 2, localStringBuilder.toString());
    if (paramInt1 == 0)
    {
      paramString1 = this.a;
      QQToast.a(paramString1, 2, paramString1.getString(2131717859), 0).b(this.a.getTitleBarHeight());
      ReadInJoyDeliverBiuActivity.e(this.a, -1);
      ReadInJoyDeliverBiuActivity.c(this.a);
      this.a.getIntent().putExtra("KEY_VIDEO_BIU_SUCCESS", true);
      this.a.finish();
      if (ReadInJoyDeliverBiuActivity.o(this.a) != 14) {
        ReadInJoyLogicEngine.a().b(true);
      }
    }
    else
    {
      QQToast.a(this.a, 1, paramString3, 0).b(this.a.getTitleBarHeight());
    }
    if ((paramInt1 != 0) && (ReadInJoyDeliverBiuActivity.b(this.a))) {
      this.a.finish();
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onBiuResult: retCode = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" errorMsg = ");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = true;
    QLog.i("ReadInJoyDeliverBiuActivity", 1, (String)localObject);
    ReadInJoyDeliverBiuActivity.c(this.a, true);
    ReadInJoyDeliverBiuActivity.d(this.a);
    paramLong = NetConnInfoCenter.getServerTimeMillis() - ReadInJoyDeliverBiuActivity.a(this.a);
    if (paramInt == 0)
    {
      paramString = this.a.getString(2131717859);
      if (ReadInJoyDeliverBiuActivity.g(this.a)) {
        paramString = this.a.getString(2131717853);
      }
      ReadInJoyDeliverBiuActivity.d(this.a, false);
      if (!this.a.getIntent().getBooleanExtra("hideSuccessToast", false)) {
        QQToast.a(this.a, 2, paramString, 0).b(this.a.getTitleBarHeight());
      }
      ReadInJoyDeliverBiuActivity.f(this.a, -1);
      ReadInJoyDeliverBiuActivity.c(this.a);
      this.a.getIntent().putExtra("KEY_VIDEO_BIU_SUCCESS", true);
      this.a.finish();
      if (ReadInJoyDeliverBiuActivity.o(this.a) != 14) {
        ReadInJoyLogicEngine.a().b(true);
      }
    }
    else
    {
      QQToast.a(this.a, 1, paramString, 0).b(this.a.getTitleBarHeight());
    }
    if (paramInt != 0) {
      bool = false;
    }
    paramString = new HashMap();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("");
    paramString.put("param_FailCode", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ReadInJoyDeliverBiuActivity.o(this.a));
    ((StringBuilder)localObject).append("");
    paramString.put("param_FromType", ((StringBuilder)localObject).toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actMultiBiuResult", bool, paramLong, 0L, paramString, "");
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("doStatisticReport-->success:");
      paramString.append(bool);
      paramString.append(", costTime:");
      paramString.append(paramLong);
      paramString.append(", retcode:");
      paramString.append(paramInt);
      QLog.d("ReadInJoyDeliverBiuActivity", 2, paramString.toString());
    }
    if (bool) {
      ReadInJoyDeliverBiuActivity.a(this.a, bool);
    }
    if ((paramInt != 0) && (ReadInJoyDeliverBiuActivity.b(this.a))) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity.9
 * JD-Core Version:    0.7.0.1
 */