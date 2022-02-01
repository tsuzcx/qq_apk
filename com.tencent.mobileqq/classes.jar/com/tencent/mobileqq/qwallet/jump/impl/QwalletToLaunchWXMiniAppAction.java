package com.tencent.mobileqq.qwallet.jump.impl;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.jump.IWXMiniProgramHelper;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class QwalletToLaunchWXMiniAppAction
  extends JumpAction
{
  public QwalletToLaunchWXMiniAppAction(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    super(paramBaseQQAppInterface, paramContext);
  }
  
  private boolean c()
  {
    ((IWXMiniProgramHelper)QRoute.api(IWXMiniProgramHelper.class)).launchMiniProgram(this.f);
    return true;
  }
  
  public boolean a()
  {
    try
    {
      if ((this.f.containsKey("user_name")) && (!StringUtil.isEmpty((String)this.f.get("user_name"))))
      {
        boolean bool = c();
        return bool;
      }
      return false;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("QwalletToLaunchWXMiniAppAction", 1, localStringBuilder.toString());
      h_("QwalletToLaunchWXMiniAppAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.jump.impl.QwalletToLaunchWXMiniAppAction
 * JD-Core Version:    0.7.0.1
 */