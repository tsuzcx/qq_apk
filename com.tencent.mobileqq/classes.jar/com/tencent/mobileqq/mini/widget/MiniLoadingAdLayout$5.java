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
      QLog.i("MiniLoadingAdLayout", 1, "report reportParams=" + this.val$reportParams.toString() + " result=" + str);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MiniLoadingAdLayout", 1, "report error. url=" + "https://rpt.gdt.qq.com/mqq_log" + " reportParams=" + this.val$reportParams.toString(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.5
 * JD-Core Version:    0.7.0.1
 */