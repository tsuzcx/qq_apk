package com.tencent.mobileqq.jump.api.impl;

import android.content.Context;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.jump.api.IJumpApi;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.util.JumpUtil;
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
    paramContext = JumpParser.a((QQAppInterface)localObject, paramContext, paramString);
    if (paramContext != null)
    {
      paramContext.a();
      return;
    }
    QLog.e("JumpApiImpl", 2, "Push toast content clicked, but jumpAction is null! jumpUrl: " + paramString);
  }
  
  public String getJumpActionQCircle()
  {
    return "qcircle";
  }
  
  public Class getJumpActivityClass()
  {
    return JumpActivity.class;
  }
  
  public String getQCircleSchemeFromJumpUtil(String paramString1, String paramString2)
  {
    return JumpUtil.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jump.api.impl.JumpApiImpl
 * JD-Core Version:    0.7.0.1
 */