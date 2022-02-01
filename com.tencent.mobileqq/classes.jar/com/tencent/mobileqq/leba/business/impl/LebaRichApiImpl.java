package com.tencent.mobileqq.leba.business.impl;

import android.view.View;
import com.tencent.mobileqq.leba.business.ILebaRichApi;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
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
    return QCircleConfigHelper.d(StudyModeManager.h());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.impl.LebaRichApiImpl
 * JD-Core Version:    0.7.0.1
 */