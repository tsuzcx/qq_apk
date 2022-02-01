package com.tencent.mobileqq.kandian.glue.pts;

import com.tencent.mobileqq.kandian.base.utils.RIJLogUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.qphone.base.util.QLog;

final class WeakNetHelper$1
  implements Runnable
{
  WeakNetHelper$1(String paramString1, String paramString2) {}
  
  public void run()
  {
    String str1 = RIJQQAppInterfaceUtil.d();
    QLog.d("WeakNetHelper", 1, new Object[] { "actionName = ", this.a, "\n", "r2 = ", RIJLogUtil.a.a(str1), " r5 = ", this.b });
    String str2 = this.a;
    PublicAccountReportUtils.a(null, "", str2, str2, 0, 0, str1, "", "", this.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.pts.WeakNetHelper.1
 * JD-Core Version:    0.7.0.1
 */