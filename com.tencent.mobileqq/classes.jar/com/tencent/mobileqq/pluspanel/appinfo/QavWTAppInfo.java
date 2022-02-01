package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.wtogether.util.ChooseFileAssistant;
import com.tencent.av.wtogether.util.WTEntranceHelper;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QavWTAppInfo
  extends PlusPanelAppInfo
{
  public QavWTAppInfo() {}
  
  public QavWTAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130839300;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 223;
    }
    return 0;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 683;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130223;
    }
    return 0;
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131896504);
  }
  
  protected void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if (paramBaseChatPie.d.getAVNotifyCenter().a(paramBaseChatPie.aX(), 4, paramSessionInfo.a, paramSessionInfo.b)) {
      return;
    }
    if (!AppNetConnInfo.isNetSupport())
    {
      paramPlusPanelViewModel = BaseApplicationImpl.getContext();
      i = paramPlusPanelViewModel.getResources().getDimensionPixelSize(2131299920);
      QQToast.makeText(paramPlusPanelViewModel, -1, paramPlusPanelViewModel.getString(2131893759), 0).show(i);
      return;
    }
    if (!WTogetherUtil.a())
    {
      paramPlusPanelViewModel = BaseApplicationImpl.getContext();
      i = paramPlusPanelViewModel.getResources().getDimensionPixelSize(2131299920);
      QQToast.makeText(paramPlusPanelViewModel, -1, paramPlusPanelViewModel.getString(2131893777), 0).show(i);
      return;
    }
    if ((!paramBaseChatPie.d.isVideoChatting()) && (!paramBaseChatPie.d.getAVNotifyCenter().d()))
    {
      if (paramSessionInfo.a == 0)
      {
        paramBaseChatPie.aw();
        paramPlusPanelViewModel.b(paramBaseChatPie);
        ChooseFileAssistant.a().a(paramSessionInfo);
        WTEntranceHelper.a(paramBaseChatPie.aX(), 1, paramSessionInfo.a, paramSessionInfo.b);
        paramBaseChatPie.aX().setCanLock(false);
        ReportController.b(paramBaseChatPie.d, "dc00898", "", "", "0X800B61B", "0X800B61B", 0, 0, "", "", "", "");
        return;
      }
      if (QLog.isColorLevel())
      {
        paramPlusPanelViewModel = new StringBuilder();
        paramPlusPanelViewModel.append("clickToolQavWatchTogether, not support chat, [");
        paramPlusPanelViewModel.append(paramSessionInfo.a);
        paramPlusPanelViewModel.append("]");
        QLog.i("QavWTAppInfo", 2, paramPlusPanelViewModel.toString());
      }
      return;
    }
    paramPlusPanelViewModel = BaseApplicationImpl.getContext();
    int i = paramPlusPanelViewModel.getResources().getDimensionPixelSize(2131299920);
    QQToast.makeText(paramPlusPanelViewModel, 2131893758, 1).show(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.QavWTAppInfo
 * JD-Core Version:    0.7.0.1
 */