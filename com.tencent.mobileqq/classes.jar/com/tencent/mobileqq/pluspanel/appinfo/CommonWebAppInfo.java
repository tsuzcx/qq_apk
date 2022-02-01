package com.tencent.mobileqq.pluspanel.appinfo;

import ahvi;
import android.content.Intent;
import android.text.TextUtils;
import anvx;
import bdla;
import becr;
import bheh;
import bhey;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import java.net.URI;
import java.net.URISyntaxException;

public class CommonWebAppInfo
  extends PlusPanelAppInfo
{
  public CommonWebAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  private void a(ahvi paramahvi, BaseChatPie paramBaseChatPie)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    paramahvi.a("chat_tool_tencentdoc", localQQAppInterface.getCurrentAccountUin());
    paramahvi.b(paramBaseChatPie);
    becr.a(localQQAppInterface, paramBaseChatPie.getActivity(), paramBaseChatPie.sessionInfo.curFriendUin, paramBaseChatPie.sessionInfo.curType, paramBaseChatPie.sessionInfo.curFriendNick);
    if (paramBaseChatPie.sessionInfo.curType == 1)
    {
      paramahvi = (TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (paramahvi == null) {
        break label168;
      }
    }
    label168:
    for (paramahvi = paramahvi.b(paramBaseChatPie.sessionInfo.curFriendUin);; paramahvi = null)
    {
      if (paramahvi != null) {}
      for (paramahvi = "" + paramahvi.dwGroupClassExt;; paramahvi = "")
      {
        bdla.b(localQQAppInterface, "dc00898", "", paramBaseChatPie.sessionInfo.curFriendUin, "0X8009E25", "0X8009E25", 0, 0, "", "", "" + paramahvi, "");
        return;
      }
    }
  }
  
  private void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if (TextUtils.isEmpty(this.url)) {}
    do
    {
      return;
      paramSessionInfo = this.url.replace("$UIN$", paramBaseChatPie.app.getCurrentAccountUin()).replace("$GCODE$", paramSessionInfo.curFriendUin).replace("$APPID$", String.valueOf(getAppID()));
      int j = 0;
      int i = j;
      try
      {
        if (TextUtils.equals(new URI(paramSessionInfo).getScheme(), "mqqapi"))
        {
          localObject = bhey.a(paramBaseChatPie.app, paramBaseChatPie.getActivity(), paramSessionInfo);
          i = j;
          if (localObject != null)
          {
            ((bheh)localObject).a();
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
    localObject = new Intent(paramBaseChatPie.getActivity(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramSessionInfo);
    ((Intent)localObject).putExtra("selfSet_leftViewText", anvx.a(2131715077));
    paramBaseChatPie.getActivity().startActivity((Intent)localObject);
  }
  
  private boolean a(BaseChatPie paramBaseChatPie, int paramInt)
  {
    if (MiniAppLauncher.isMiniAppUrl(this.url))
    {
      QLog.i("CommonWebAppInfo", 1, "troopFormLog openMiniApp:url :" + this.url);
      if (!TextUtils.isEmpty(this.url)) {}
    }
    else
    {
      return false;
    }
    String str = this.url.replace("$UIN$", paramBaseChatPie.app.getCurrentAccountUin()).replace("$GCODE$", paramBaseChatPie.sessionInfo.curFriendUin).replace("$APPID$", String.valueOf(paramInt));
    return MiniAppLauncher.startMiniApp(paramBaseChatPie.getActivity(), str, 2016, paramBaseChatPie.createMiniAppEntryModel(), null);
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
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if (getAppID() == 101458937) {
      a(paramahvi, paramBaseChatPie);
    }
    while (a(paramBaseChatPie, getAppID())) {
      return;
    }
    a(paramBaseChatPie, paramSessionInfo);
    paramahvi.a(paramBaseChatPie.app, getAppID(), paramSessionInfo.curFriendUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.CommonWebAppInfo
 * JD-Core Version:    0.7.0.1
 */