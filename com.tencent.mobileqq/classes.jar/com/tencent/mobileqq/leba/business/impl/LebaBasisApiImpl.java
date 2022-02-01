package com.tencent.mobileqq.leba.business.impl;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.business.ILebaBasisApi;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class LebaBasisApiImpl
  implements ILebaBasisApi
{
  private static final String TAG = "LebaBasisApiImpl";
  
  public boolean isLocaleUpdatedByUser()
  {
    return LocaleManager.c();
  }
  
  public void jumpByScheme(Context paramContext, String paramString)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      paramContext = JumpParser.a((QQAppInterface)localAppRuntime, paramContext, paramString);
      if (paramContext != null)
      {
        paramContext.a();
        return;
      }
      QLog.i("LebaBasisApiImpl", 1, "jumpAction jAction == null");
      return;
    }
    QLog.i("LebaBasisApiImpl", 1, "jumpByScheme app !instanceof QQAppInterface");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.impl.LebaBasisApiImpl
 * JD-Core Version:    0.7.0.1
 */