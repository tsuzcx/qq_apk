package com.tencent.mobileqq.config;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class OnF2FConfigListener
  implements CfgProcess.OnGetConfigListener
{
  public void onGetConfig(QQAppInterface paramQQAppInterface, int paramInt, String paramString, CfgProcess.CfgParseResult paramCfgParseResult)
  {
    if ((paramCfgParseResult != null) && ("qqsettingme_f2f_guide_config".equals(paramString)))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("handleConfigForTag qqsettingme_f2f content = ");
        paramString.append(paramCfgParseResult.a);
        QLog.d("OnF2FConfigListener", 2, paramString.toString());
      }
      ThreadManager.post(new OnF2FConfigListener.1(this, paramCfgParseResult, paramQQAppInterface), 5, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.OnF2FConfigListener
 * JD-Core Version:    0.7.0.1
 */