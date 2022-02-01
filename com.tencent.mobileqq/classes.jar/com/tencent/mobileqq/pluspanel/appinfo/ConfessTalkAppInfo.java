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
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class ConfessTalkAppInfo
  extends PlusPanelAppInfo
{
  private long mConfessTalkIconLastClickTime;
  
  public int defaultDrawableID()
  {
    return 2130843946;
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
    return BaseApplicationImpl.getContext().getString(2131698643);
  }
  
  public void init()
  {
    super.init();
    this.mConfessTalkIconLastClickTime = 0L;
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.a;
    ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800956E", "0X800956E", 0, 0, "", "", "", "");
    if (!NetworkUtil.e(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2131692257, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299166));
      return;
    }
    if (SystemClock.elapsedRealtime() - this.mConfessTalkIconLastClickTime < 5000L) {
      paramPlusPanelViewModel.b(paramBaseChatPie, false);
    }
    for (;;)
    {
      paramPlusPanelViewModel.a(true);
      this.mConfessTalkIconLastClickTime = SystemClock.elapsedRealtime();
      return;
      ((TroopChatPie)paramBaseChatPie).i(HardCodeUtil.a(2131708290));
      ((TroopInfoHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER)).a(paramSessionInfo.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.ConfessTalkAppInfo
 * JD-Core Version:    0.7.0.1
 */