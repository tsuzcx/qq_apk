package com.tencent.mobileqq.mini.widget;

import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

final class MiniLoadingAdLayout$5
  implements Runnable
{
  MiniLoadingAdLayout$5(Bundle paramBundle) {}
  
  public void run()
  {
    this.val$reportParams.putInt("PostBodyType", 1);
    try
    {
      String str = HttpUtil.openUrl(BaseApplicationImpl.getContext(), "https://rpt.gdt.qq.com/mqq_log", "POST", this.val$reportParams, null);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("report reportParams=");
      localStringBuilder.append(this.val$reportParams.toString());
      localStringBuilder.append(" result=");
      localStringBuilder.append(str);
      QLog.i("MiniLoadingAdLayout", 1, localStringBuilder.toString());
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report error. url=");
      localStringBuilder.append("https://rpt.gdt.qq.com/mqq_log");
      localStringBuilder.append(" reportParams=");
      localStringBuilder.append(this.val$reportParams.toString());
      QLog.e("MiniLoadingAdLayout", 1, localStringBuilder.toString(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.5
 * JD-Core Version:    0.7.0.1
 */