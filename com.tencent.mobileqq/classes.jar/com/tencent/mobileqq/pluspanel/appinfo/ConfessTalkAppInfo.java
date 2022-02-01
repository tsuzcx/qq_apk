package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.res.Resources;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class ConfessTalkAppInfo
  extends PlusPanelAppInfo
{
  private long mConfessTalkIconLastClickTime;
  
  public int defaultDrawableID()
  {
    return 2130844821;
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
    return BaseApplicationImpl.getContext().getString(2131896667);
  }
  
  public void init()
  {
    super.init();
    this.mConfessTalkIconLastClickTime = 0L;
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.d;
    ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800956E", "0X800956E", 0, 0, "", "", "", "");
    if (!NetworkUtil.isNetSupportHw(BaseApplicationImpl.getContext()))
    {
      QQToast.makeText(BaseApplicationImpl.getContext(), 2131889169, 0).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299920));
      return;
    }
    if (SystemClock.elapsedRealtime() - this.mConfessTalkIconLastClickTime < 5000L)
    {
      paramPlusPanelViewModel.b(paramBaseChatPie, false);
    }
    else
    {
      ((TroopChatPie)paramBaseChatPie).f(HardCodeUtil.a(2131906089));
      ((ITroopInfoHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER)).a(paramSessionInfo.b, false);
    }
    paramPlusPanelViewModel.a(true);
    this.mConfessTalkIconLastClickTime = SystemClock.elapsedRealtime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.ConfessTalkAppInfo
 * JD-Core Version:    0.7.0.1
 */