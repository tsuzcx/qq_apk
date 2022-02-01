package com.tencent.mobileqq.pluspanel.appinfo;

import ahvi;
import android.content.res.Resources;
import android.os.SystemClock;
import anvx;
import aoep;
import bdla;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class ConfessTalkAppInfo
  extends PlusPanelAppInfo
{
  private long mConfessTalkIconLastClickTime;
  
  public int defaultDrawableID()
  {
    return 2130843775;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 0;
    }
    return 1106865772;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 0;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131698363);
  }
  
  public void init()
  {
    super.init();
    this.mConfessTalkIconLastClickTime = 0L;
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    bdla.b(localQQAppInterface, "dc00898", "", "", "0X800956E", "0X800956E", 0, 0, "", "", "", "");
    if (!NetworkUtil.isNetSupportHw(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2131692125, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299080));
      return;
    }
    if (SystemClock.elapsedRealtime() - this.mConfessTalkIconLastClickTime < 5000L) {
      paramahvi.b(paramBaseChatPie, false);
    }
    for (;;)
    {
      paramahvi.a(true);
      this.mConfessTalkIconLastClickTime = SystemClock.elapsedRealtime();
      return;
      ((TroopChatPie)paramBaseChatPie).a(anvx.a(2131707763));
      ((aoep)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).b(paramSessionInfo.curFriendUin, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.ConfessTalkAppInfo
 * JD-Core Version:    0.7.0.1
 */