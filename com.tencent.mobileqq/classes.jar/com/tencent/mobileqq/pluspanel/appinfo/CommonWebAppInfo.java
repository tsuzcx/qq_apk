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
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
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
    if (TextUtils.isEmpty(this.url)) {
      return;
    }
    paramSessionInfo = this.url.replace("$UIN$", paramBaseChatPie.d.getCurrentAccountUin()).replace("$GCODE$", paramSessionInfo.b).replace("$APPID$", String.valueOf(getAppID()));
    j = 0;
    i = j;
    try
    {
      if (TextUtils.equals(new URI(paramSessionInfo).getScheme(), "mqqapi"))
      {
        localObject = JumpParser.a(paramBaseChatPie.d, paramBaseChatPie.aX(), paramSessionInfo);
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
    if (i == 0)
    {
      localObject = new Intent(paramBaseChatPie.aX(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramSessionInfo);
      ((Intent)localObject).putExtra("selfSet_leftViewText", HardCodeUtil.a(2131901576));
      paramBaseChatPie.aX().startActivity((Intent)localObject);
    }
  }
  
  private void a(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.d;
    paramPlusPanelViewModel.a("chat_tool_tencentdoc", localQQAppInterface.getCurrentAccountUin());
    paramPlusPanelViewModel.b(paramBaseChatPie);
    ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).gotoAIOTencentDocListWebH5(localQQAppInterface, paramBaseChatPie.aX(), paramBaseChatPie.ah.b, paramBaseChatPie.ah.a, paramBaseChatPie.ah.e);
    if (paramBaseChatPie.ah.a == 1)
    {
      Object localObject = (TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      paramPlusPanelViewModel = null;
      if (localObject != null) {
        paramPlusPanelViewModel = ((TroopManager)localObject).f(paramBaseChatPie.ah.b);
      }
      if (paramPlusPanelViewModel != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramPlusPanelViewModel.dwGroupClassExt);
        paramPlusPanelViewModel = ((StringBuilder)localObject).toString();
      }
      else
      {
        paramPlusPanelViewModel = "";
      }
      paramBaseChatPie = paramBaseChatPie.ah.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramPlusPanelViewModel);
      ReportController.b(localQQAppInterface, "dc00898", "", paramBaseChatPie, "0X8009E25", "0X8009E25", 0, 0, "", "", ((StringBuilder)localObject).toString(), "");
    }
  }
  
  private boolean a(BaseChatPie paramBaseChatPie, int paramInt)
  {
    if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(this.url))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("troopFormLog openMiniApp:url :");
      ((StringBuilder)localObject).append(this.url);
      QLog.i("CommonWebAppInfo", 1, ((StringBuilder)localObject).toString());
      if (TextUtils.isEmpty(this.url)) {
        return false;
      }
      localObject = this.url.replace("$UIN$", paramBaseChatPie.d.getCurrentAccountUin()).replace("$GCODE$", paramBaseChatPie.ah.b).replace("$APPID$", String.valueOf(paramInt));
      return ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramBaseChatPie.aX(), (String)localObject, 2016, paramBaseChatPie.aV(), null);
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
    if (getAppID() == 101458937)
    {
      a(paramPlusPanelViewModel, paramBaseChatPie);
      return;
    }
    if (a(paramBaseChatPie, getAppID())) {
      return;
    }
    a(paramBaseChatPie, paramSessionInfo);
    paramPlusPanelViewModel.a(paramBaseChatPie.d, getAppID(), paramSessionInfo.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.CommonWebAppInfo
 * JD-Core Version:    0.7.0.1
 */