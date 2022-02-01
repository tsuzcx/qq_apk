package com.tencent.mobileqq.pluspanel.appinfo;

import android.annotation.SuppressLint;
import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

@SuppressLint({"RestrictedApi"})
public class AskAnonymouslyAppInfo
  extends PlusPanelAppInfo
{
  public static final String TAG = "AskAnonymouslyAppInfo";
  private WeakReference<Activity> actRef;
  TroopBusinessObserver mTroopBusinessObserver = new AskAnonymouslyAppInfo.1(this);
  
  AskAnonymouslyAppInfo() {}
  
  public AskAnonymouslyAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130839258;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 0;
    }
    return 101912132;
  }
  
  public int getManageConfigID()
  {
    return 0;
  }
  
  public int getRedDotID()
  {
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131695097);
  }
  
  public void onChatPieLifeCycle(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AskAnonymouslyAppInfo", 2, String.format("onChatPieLifeCycle %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    if ((paramInt == 11) || (paramInt == 14))
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        ((QQAppInterface)localAppRuntime).removeObserver(this.mTroopBusinessObserver);
      }
    }
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.a() == null)) {}
    do
    {
      do
      {
        return;
        this.actRef = new WeakReference(paramBaseChatPie.a());
        paramPlusPanelViewModel = paramBaseChatPie.a;
      } while (paramSessionInfo.jdField_a_of_type_Int != 1);
      paramPlusPanelViewModel.addObserver(this.mTroopBusinessObserver);
      ((TroopHandler)paramPlusPanelViewModel.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).b(Long.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 8, 0);
      ReportController.b(null, "dc00899", "Grp_AIO", "", "ask_tab", "clk_ask", 0, 0, paramSessionInfo.jdField_a_of_type_JavaLangString, "0", "", "");
    } while (!QLog.isColorLevel());
    QLog.d("AskAnonymouslyAppInfo", 2, "onPlusPanelAppClick " + paramSessionInfo.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.AskAnonymouslyAppInfo
 * JD-Core Version:    0.7.0.1
 */