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
    return 2130839144;
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
    return BaseApplicationImpl.getContext().getString(2131698557);
  }
  
  protected void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if (paramBaseChatPie.a.getAVNotifyCenter().a(paramBaseChatPie.a(), 4, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (!AppNetConnInfo.isNetSupport())
    {
      paramPlusPanelViewModel = BaseApplicationImpl.getContext();
      i = paramPlusPanelViewModel.getResources().getDimensionPixelSize(2131299168);
      QQToast.a(paramPlusPanelViewModel, -1, paramPlusPanelViewModel.getString(2131695997), 0).b(i);
      return;
    }
    if (!WTogetherUtil.a())
    {
      paramPlusPanelViewModel = BaseApplicationImpl.getContext();
      i = paramPlusPanelViewModel.getResources().getDimensionPixelSize(2131299168);
      QQToast.a(paramPlusPanelViewModel, -1, paramPlusPanelViewModel.getString(2131696015), 0).b(i);
      return;
    }
    if ((!paramBaseChatPie.a.isVideoChatting()) && (!paramBaseChatPie.a.getAVNotifyCenter().b()))
    {
      if (paramSessionInfo.jdField_a_of_type_Int == 0)
      {
        paramBaseChatPie.Q();
        paramPlusPanelViewModel.b(paramBaseChatPie);
        ChooseFileAssistant.a().a(paramSessionInfo);
        WTEntranceHelper.a(paramBaseChatPie.a(), 1, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString);
        paramBaseChatPie.a().setCanLock(false);
        ReportController.b(paramBaseChatPie.a, "dc00898", "", "", "0X800B61B", "0X800B61B", 0, 0, "", "", "", "");
        return;
      }
      if (QLog.isColorLevel())
      {
        paramPlusPanelViewModel = new StringBuilder();
        paramPlusPanelViewModel.append("clickToolQavWatchTogether, not support chat, [");
        paramPlusPanelViewModel.append(paramSessionInfo.jdField_a_of_type_Int);
        paramPlusPanelViewModel.append("]");
        QLog.i("QavWTAppInfo", 2, paramPlusPanelViewModel.toString());
      }
      return;
    }
    paramPlusPanelViewModel = BaseApplicationImpl.getContext();
    int i = paramPlusPanelViewModel.getResources().getDimensionPixelSize(2131299168);
    QQToast.a(paramPlusPanelViewModel, 2131695996, 1).b(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.QavWTAppInfo
 * JD-Core Version:    0.7.0.1
 */