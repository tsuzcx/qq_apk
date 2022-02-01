package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusOfflineBidSp;
import com.tencent.qphone.base.util.QLog;

public class DailyDynamicHeaderConfigHandler
  extends SimpleConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = super.onReceiveConfig(paramInt1, paramInt2, paramString);
    paramString = Aladdin.getConfig(paramInt1).getString("daily_header_proteus_bid", "0");
    RIJProteusOfflineBidSp.a("daily_header_proteus_bid", paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("update bid=");
    localStringBuilder.append(paramString);
    QLog.i("DailyDynamicHeaderConfig", 2, localStringBuilder.toString());
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyDynamicHeaderConfigHandler
 * JD-Core Version:    0.7.0.1
 */