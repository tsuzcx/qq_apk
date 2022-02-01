package com.tencent.mobileqq.config;

import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class OnGitFontConfigListener
  implements CfgProcess.OnGetConfigListener
{
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, CfgProcess.CfgParseResult paramCfgParseResult)
  {
    if ((paramCfgParseResult != null) && ("vas_font_switch_config".equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "handleConfigForTag font content = " + paramCfgParseResult.a);
      }
      FontManager.a(paramCfgParseResult.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.OnGitFontConfigListener
 * JD-Core Version:    0.7.0.1
 */