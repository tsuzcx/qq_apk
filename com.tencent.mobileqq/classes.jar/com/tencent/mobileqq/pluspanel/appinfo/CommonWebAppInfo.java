package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import java.net.URI;
import java.net.URISyntaxException;

public class CommonWebAppInfo
  extends PlusPanelAppInfo
{
  CommonWebAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  private void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if (TextUtils.isEmpty(this.url)) {}
    do
    {
      return;
      paramSessionInfo = this.url.replace("$UIN$", paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).replace("$GCODE$", paramSessionInfo.jdField_a_of_type_JavaLangString).replace("$APPID$", String.valueOf(getAppID()));
      int j = 0;
      int i = j;
      try
      {
        if (TextUtils.equals(new URI(paramSessionInfo).getScheme(), "mqqapi"))
        {
          localObject = JumpParser.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatPie.a(), paramSessionInfo);
          i = j;
          if (localObject != null)
          {
            ((JumpAction)localObject).a();
            i = 1;
          }
        }
      }
      catch (URISyntaxException localURISyntaxException)
      {
        for (;;)
        {
          Object localObject;
          i = j;
        }
      }
    } while (i != 0);
    localObject = new Intent(paramBaseChatPie.a(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramSessionInfo);
    ((Intent)localObject).putExtra("selfSet_leftViewText", HardCodeUtil.a(2131715571));
    paramBaseChatPie.a().startActivity((Intent)localObject);
  }
  
  private void a(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramPlusPanelViewModel.a("chat_tool_tencentdoc", localQQAppInterface.getCurrentAccountUin());
    paramPlusPanelViewModel.b(paramBaseChatPie);
    TeamWorkUtils.a(localQQAppInterface, paramBaseChatPie.a(), paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      paramPlusPanelViewModel = (TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (paramPlusPanelViewModel == null) {
        break label168;
      }
    }
    label168:
    for (paramPlusPanelViewModel = paramPlusPanelViewModel.b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);; paramPlusPanelViewModel = null)
    {
      if (paramPlusPanelViewModel != null) {}
      for (paramPlusPanelViewModel = "" + paramPlusPanelViewModel.dwGroupClassExt;; paramPlusPanelViewModel = "")
      {
        ReportController.b(localQQAppInterface, "dc00898", "", paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8009E25", "0X8009E25", 0, 0, "", "", "" + paramPlusPanelViewModel, "");
        return;
      }
    }
  }
  
  private boolean a(BaseChatPie paramBaseChatPie, int paramInt)
  {
    if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(this.url))
    {
      QLog.i("CommonWebAppInfo", 1, "troopFormLog openMiniApp:url :" + this.url);
      if (TextUtils.isEmpty(this.url)) {
        return false;
      }
      String str = this.url.replace("$UIN$", paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).replace("$GCODE$", paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).replace("$APPID$", String.valueOf(paramInt));
      return ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramBaseChatPie.a(), str, 2016, paramBaseChatPie.a(), null);
    }
    return false;
  }
  
  public int defaultDrawableID()
  {
    return 0;
  }
  
  public int getAppID()
  {
    return this.appid;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return super.getRedDotID();
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return this.name;
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if (getAppID() == 101458937) {
      a(paramPlusPanelViewModel, paramBaseChatPie);
    }
    while (a(paramBaseChatPie, getAppID())) {
      return;
    }
    a(paramBaseChatPie, paramSessionInfo);
    paramPlusPanelViewModel.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getAppID(), paramSessionInfo.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.CommonWebAppInfo
 * JD-Core Version:    0.7.0.1
 */