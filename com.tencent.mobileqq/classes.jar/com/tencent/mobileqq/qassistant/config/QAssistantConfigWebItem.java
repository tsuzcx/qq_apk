package com.tencent.mobileqq.qassistant.config;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qassistant.api.IQAssistantTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.StringUtil;

public class QAssistantConfigWebItem
  extends QAssistantConfigItem
{
  protected String a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (StringUtil.a(this.f)) {
      return "";
    }
    return ((IQAssistantTempApi)QRoute.api(IQAssistantTempApi.class)).configWebItemJumpUrl(this.f);
  }
  
  protected void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    paramBaseQQAppInterface = a(paramBaseQQAppInterface);
    if (StringUtil.a(paramBaseQQAppInterface)) {
      return;
    }
    this.b = paramBaseQQAppInterface;
  }
  
  protected void a(JumpAction paramJumpAction, BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if (this.f.equalsIgnoreCase("qqgame")) {
      paramJumpAction.e("platformId=qq_m");
    }
  }
  
  protected boolean b(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    return StringUtil.a(this.b) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.config.QAssistantConfigWebItem
 * JD-Core Version:    0.7.0.1
 */