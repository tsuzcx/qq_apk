package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.URLEncoder;

public class AnonymousChatSettingAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130844777;
  }
  
  public int getAppID()
  {
    if (isTroop()) {
      return 1200000005;
    }
    return 0;
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131893819);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if (AnonymousChatHelper.a().a(paramSessionInfo.b))
    {
      QQAppInterface localQQAppInterface = paramBaseChatPie.d;
      int j = 0;
      paramPlusPanelViewModel = localQQAppInterface.getCurrentAccountUin();
      Object localObject = ((TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).g(paramSessionInfo.b);
      int i = j;
      if (localObject != null)
      {
        i = j;
        if (!TextUtils.isEmpty(paramPlusPanelViewModel)) {
          if ((((TroopInfo)localObject).Administrator != null) && (((TroopInfo)localObject).Administrator.contains(paramPlusPanelViewModel))) {
            i = 3;
          } else if (paramPlusPanelViewModel.equals(((TroopInfo)localObject).troopowneruin)) {
            i = 2;
          } else {
            i = 1;
          }
        }
      }
      paramPlusPanelViewModel = AnonymousChatHelper.a().b(paramSessionInfo.b);
      localObject = new Intent(paramBaseChatPie.aX(), QQBrowserActivity.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&gcode=");
      localStringBuilder.append(paramSessionInfo.b);
      localStringBuilder.append("&avatar=");
      localStringBuilder.append(AnonymousChatHelper.a(paramPlusPanelViewModel.c));
      localStringBuilder.append("&nick=");
      if (TextUtils.isEmpty(paramPlusPanelViewModel.d)) {
        paramPlusPanelViewModel = "";
      } else {
        paramPlusPanelViewModel = URLEncoder.encode(paramPlusPanelViewModel.d);
      }
      localStringBuilder.append(paramPlusPanelViewModel);
      localStringBuilder.append("&role=");
      localStringBuilder.append(String.valueOf(i));
      localStringBuilder.append("&self=1");
      ((Intent)localObject).putExtra("url", localStringBuilder.toString());
      paramBaseChatPie.aX().startActivity((Intent)localObject);
      ReportController.b(localQQAppInterface, "P_CliOper", "Grp_anon", "", "aio_plus", "clk_change", 0, 0, paramSessionInfo.b, String.valueOf(i), "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.AnonymousChatSettingAppInfo
 * JD-Core Version:    0.7.0.1
 */