package com.tencent.mobileqq.qassistant.config;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qassistant.api.IQAssistantTempApi;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qphone.base.util.QLog;

public class QAssistantConfigMainItem
  extends QAssistantConfigItem
{
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    AssistantUtils.a("HelloQQWake", "QAssistantConfigMainItem RealJump");
    ((IQAssistantTempApi)QRoute.api(IQAssistantTempApi.class)).configWebItemCloseDrawer();
    return true;
  }
  
  public boolean a(QBaseActivity paramQBaseActivity, boolean paramBoolean)
  {
    if (paramQBaseActivity == null)
    {
      QAssistantConfigUtils.a(this.g, this.f, 100);
      return false;
    }
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(paramQBaseActivity, "/base/start/splash");
    ((IQAssistantTempApi)QRoute.api(IQAssistantTempApi.class)).extendJumpIntentExtra2(localActivityURIRequest.extra(), this.f);
    localActivityURIRequest.setFlags(67108864);
    QAssistantConfigUtils.a(this, paramBoolean, localActivityURIRequest);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QAssistantConfigItem.Jump item_server = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("|");
    localStringBuilder.append(paramQBaseActivity.getClass().toString());
    QLog.d("QAssistantConfigItem", 1, localStringBuilder.toString());
    QRoute.startUri(localActivityURIRequest, null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.config.QAssistantConfigMainItem
 * JD-Core Version:    0.7.0.1
 */