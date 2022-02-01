package com.tencent.mobileqq.pluspanel.appinfo;

import ahvi;
import android.content.Intent;
import android.text.TextUtils;
import bdla;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.URLEncoder;
import nty;
import nua;

public class AnonymousChatSettingAppInfo
  extends PlusPanelAppInfo
{
  public int defaultDrawableID()
  {
    return 2130843732;
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
    return BaseApplicationImpl.getContext().getString(2131695794);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface;
    Object localObject;
    int i;
    if (nty.a().a(paramSessionInfo.curFriendUin))
    {
      localQQAppInterface = paramBaseChatPie.app;
      paramahvi = localQQAppInterface.getCurrentAccountUin();
      localObject = ((TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramSessionInfo.curFriendUin);
      if ((localObject == null) || (TextUtils.isEmpty(paramahvi))) {
        break label270;
      }
      if ((((TroopInfo)localObject).Administrator == null) || (!((TroopInfo)localObject).Administrator.contains(paramahvi))) {
        break label235;
      }
      i = 3;
    }
    for (;;)
    {
      paramahvi = nty.a().a(paramSessionInfo.curFriendUin);
      localObject = new Intent(paramBaseChatPie.getActivity(), QQBrowserActivity.class);
      StringBuilder localStringBuilder = new StringBuilder().append("https://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&gcode=").append(paramSessionInfo.curFriendUin).append("&avatar=").append(nty.a(paramahvi.jdField_a_of_type_Int)).append("&nick=");
      if (TextUtils.isEmpty(paramahvi.jdField_a_of_type_JavaLangString)) {}
      for (paramahvi = "";; paramahvi = URLEncoder.encode(paramahvi.jdField_a_of_type_JavaLangString))
      {
        ((Intent)localObject).putExtra("url", paramahvi + "&role=" + String.valueOf(i) + "&self=1");
        paramBaseChatPie.getActivity().startActivity((Intent)localObject);
        bdla.b(localQQAppInterface, "P_CliOper", "Grp_anon", "", "aio_plus", "clk_change", 0, 0, paramSessionInfo.curFriendUin, String.valueOf(i), "", "");
        return;
        label235:
        if (paramahvi.equals(((TroopInfo)localObject).troopowneruin))
        {
          i = 2;
          break;
        }
        i = 1;
        break;
      }
      label270:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.AnonymousChatSettingAppInfo
 * JD-Core Version:    0.7.0.1
 */