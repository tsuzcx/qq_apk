package com.tencent.mobileqq.kandian.repo.ugc.srtutils;

import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

final class UGRuleManager$1
  implements Runnable
{
  UGRuleManager$1(String paramString) {}
  
  public void run()
  {
    try
    {
      HttpUtil.openUrl(BaseActivity.sTopActivity, this.a, "GET", null, null);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UG report error");
      localStringBuilder.append(localException.getMessage());
      QLog.e("UGRuleManager", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.ugc.srtutils.UGRuleManager.1
 * JD-Core Version:    0.7.0.1
 */