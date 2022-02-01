package com.tencent.mobileqq.jump.api.impl;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.jump.api.IJumpApi;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class JumpApiImpl
  implements IJumpApi
{
  public void doJumpAction(Context paramContext, String paramString)
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (!(localObject instanceof QQAppInterface)) {
      return;
    }
    localObject = (QQAppInterface)localObject;
    if (localObject == null)
    {
      QLog.e("JumpApiImpl", 1, "getApp is null");
      return;
    }
    paramContext = JumpParser.a((BaseQQAppInterface)localObject, paramContext, paramString);
    if (paramContext != null)
    {
      paramContext.a();
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("Push toast content clicked, but jumpAction is null! jumpUrl: ");
    paramContext.append(paramString);
    QLog.e("JumpApiImpl", 2, paramContext.toString());
  }
  
  public String getJumpActionQCircle()
  {
    return "qcircle";
  }
  
  public Class getJumpActivityClass()
  {
    return JumpActivity.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jump.api.impl.JumpApiImpl
 * JD-Core Version:    0.7.0.1
 */