package com.tencent.mobileqq.config;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.qphone.base.util.QLog;

public class OnGitFontConfigListener
  implements CfgProcess.OnGetConfigListener
{
  public void onGetConfig(QQAppInterface paramQQAppInterface, int paramInt, String paramString, CfgProcess.CfgParseResult paramCfgParseResult)
  {
    if ((paramCfgParseResult != null) && ("vas_font_switch_config".equals(paramString)))
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("handleConfigForTag font content = ");
        paramQQAppInterface.append(paramCfgParseResult.a);
        QLog.d("FontManagerConstants", 2, paramQQAppInterface.toString());
      }
      FontManagerConstants.updateFontSwitch(paramCfgParseResult.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.OnGitFontConfigListener
 * JD-Core Version:    0.7.0.1
 */