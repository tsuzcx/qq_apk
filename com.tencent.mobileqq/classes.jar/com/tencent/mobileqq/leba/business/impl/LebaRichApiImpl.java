package com.tencent.mobileqq.leba.business.impl;

import android.view.View;
import com.tencent.mobileqq.leba.business.ILebaRichApi;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import common.config.service.QzoneConfig;
import mqq.app.AppRuntime;

public class LebaRichApiImpl
  implements ILebaRichApi
{
  public void applyThemeBg(AppRuntime paramAppRuntime, View paramView, int paramInt, String paramString)
  {
    ThemeBackground.a(paramAppRuntime, paramView, 4, paramInt, paramString);
  }
  
  public boolean isShowQCircleEnter()
  {
    return QzoneConfig.isShowQCircleEnter(StudyModeManager.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.impl.LebaRichApiImpl
 * JD-Core Version:    0.7.0.1
 */