package com.tencent.mobileqq.kandian.biz.privatechat.api.impl;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJPrivateChatReportImpl$reportData$1
  implements Runnable
{
  RIJPrivateChatReportImpl$reportData$1(String paramString1, String paramString2) {}
  
  public final void run()
  {
    Object localObject = RIJQQAppInterfaceUtil.d();
    String str = this.a;
    PublicAccountReportUtils.a(null, (String)localObject, str, str, 0, 0, "", "", "", this.b, false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[reportData] actionName = ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(", r5 = ");
    ((StringBuilder)localObject).append(this.b);
    QLog.i("RIJPrivateChatReportImp", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.privatechat.api.impl.RIJPrivateChatReportImpl.reportData.1
 * JD-Core Version:    0.7.0.1
 */