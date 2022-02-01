package com.tencent.mobileqq.pluspanel.appinfo;

import ahvi;
import aido;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.qphone.base.util.BaseApplication;

public class PublicAccountVoiceAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130839219;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 1200000011;
    }
    return 0;
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131698208);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if ((paramBaseChatPie instanceof aido)) {
      ((aido)paramBaseChatPie).c.performClick();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.PublicAccountVoiceAppInfo
 * JD-Core Version:    0.7.0.1
 */