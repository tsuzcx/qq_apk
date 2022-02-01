package com.tencent.mobileqq.qqgamepub.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.open.ArkView;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.webviewplugin.PayJsPlugin;
import com.tencent.biz.webviewplugin.SSOWebviewPlugin;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.gamecenter.wadl.biz.jsplugin.WadlWebViewJsPlugin;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopPublicAccountChatPieTempApi;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoManager;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.gamecenter.util.QQGameConstant;
import com.tencent.mobileqq.gamecenter.view.ImgHeaderView;
import com.tencent.mobileqq.gamecenter.view.TextHeaderView;
import com.tencent.mobileqq.jsp.DataApiPlugin;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.view.IHeaderView;
import com.tencent.mobileqq.qqgamepub.web.QQGameWebViewJsPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletCommonHbJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class QQGameTempRelyApiImpl
  implements IQQGameTempRelyApi
{
  private static final String TAG = "QQGamePub_QQGameTempRelyApiImpl";
  
  public static String getPAMsgId(MessageRecord paramMessageRecord)
  {
    Object localObject1 = "";
    try
    {
      String str = paramMessageRecord.extStr;
      Object localObject2 = str;
      if (TextUtils.isEmpty(str)) {
        localObject2 = paramMessageRecord.mExJsonObject.toString();
      }
      paramMessageRecord = (MessageRecord)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return paramMessageRecord;
      }
      localObject2 = new JSONObject((String)localObject2);
      paramMessageRecord = PublicAccountEventReport.a(((JSONObject)localObject2).optString("report_key_bytes_oac_msg_extend", ""));
      if (!TextUtils.isEmpty(paramMessageRecord)) {
        return paramMessageRecord;
      }
      paramMessageRecord = ((JSONObject)localObject2).optString("public_account_msg_id", "");
      try
      {
        if (TextUtils.isEmpty(paramMessageRecord))
        {
          localObject1 = ((JSONObject)localObject2).optString("pa_msgId", "");
          return localObject1;
        }
        return paramMessageRecord;
      }
      catch (Throwable localThrowable1) {}
      localObject1 = new StringBuilder();
    }
    catch (Throwable localThrowable2)
    {
      paramMessageRecord = (MessageRecord)localObject1;
    }
    ((StringBuilder)localObject1).append("getPAMsgId error =");
    ((StringBuilder)localObject1).append(localThrowable2.toString());
    QLog.e("QQGamePub_QQGameTempRelyApiImpl", 1, ((StringBuilder)localObject1).toString());
    return paramMessageRecord;
  }
  
  public void addNightModeMask(Activity paramActivity)
  {
    SubscribeUtils.a(paramActivity);
  }
  
  public void bindQQGameWebViewBuilderJavaScript(ArrayList<WebViewPlugin> paramArrayList)
  {
    paramArrayList.add(new WadlWebViewJsPlugin());
    paramArrayList.add(new QQGameWebViewJsPlugin());
    paramArrayList.add(new QWalletPayJsPlugin());
    paramArrayList.add(new PayJsPlugin());
    paramArrayList.add(new QWalletCommonJsPlugin());
    paramArrayList.add(new QWalletBluetoothJsPlugin());
    paramArrayList.add(new QQApiPlugin());
    paramArrayList.add(new UiApiPlugin());
    paramArrayList.add(new SensorAPIJavaScript());
    paramArrayList.add(new DataApiPlugin());
    paramArrayList.add(new MediaApiPlugin());
    paramArrayList.add(new VasCommonJsPlugin());
    paramArrayList.add(new QWalletCommonHbJsPlugin());
    paramArrayList.add(new QWalletMixJsPlugin());
    paramArrayList.add(new SSOWebviewPlugin());
  }
  
  public IHeaderView createHeader(MessageRecord paramMessageRecord, Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      if ((paramMessageRecord instanceof MessageForArkApp)) {
        return ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).getGameArkView(paramActivity);
      }
      if (!(paramMessageRecord instanceof MessageForStructing)) {}
    }
    for (;;)
    {
      int k;
      try
      {
        paramMessageRecord = (ArrayList)((StructMsgForGeneralShare)((MessageForStructing)paramMessageRecord).structingMsg).getStructMsgItemLists();
        if (paramMessageRecord != null) {
          break label292;
        }
        return null;
      }
      catch (Throwable paramMessageRecord)
      {
        ArrayList localArrayList;
        paramActivity = new StringBuilder();
        paramActivity.append("createHeader failed structMsg error=");
        paramActivity.append(paramMessageRecord.toString());
        QLog.e("QQGamePub_QQGameTempRelyApiImpl", 1, paramActivity.toString());
      }
      if (k < paramMessageRecord.size())
      {
        n = i;
        m = j;
        if (!(paramMessageRecord.get(k) instanceof AbsStructMsgItem)) {
          break label323;
        }
        localArrayList = ((AbsStructMsgItem)paramMessageRecord.get(k)).a;
        m = i;
        n = 0;
        i = j;
        j = m;
        m = n;
        if (m >= localArrayList.size()) {
          break label316;
        }
        if ((localArrayList.get(m) instanceof StructMsgItemTitle))
        {
          n = 1;
        }
        else
        {
          n = j;
          if ((localArrayList.get(m) instanceof StructMsgItemCover))
          {
            i = 1;
            n = j;
          }
        }
        if ((n != 0) && (i != 0)) {
          return new ImgHeaderView(paramActivity);
        }
      }
      else
      {
        if (paramMessageRecord.size() == 2)
        {
          paramMessageRecord = new TextHeaderView(paramActivity);
          return paramMessageRecord;
        }
        return null;
        if ((paramMessageRecord instanceof MessageForPubAccount)) {
          return new ImgHeaderView(paramActivity);
        }
        return ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).getMoreMsgHeaderView(paramActivity);
        QLog.d("QQGamePub_QQGameTempRelyApiImpl", 4, "createHeader fail activity is null");
        return null;
        label292:
        k = 0;
        i = 0;
        j = 0;
        continue;
      }
      m += 1;
      int j = n;
      continue;
      label316:
      int m = i;
      int n = j;
      label323:
      k += 1;
      int i = n;
      j = m;
    }
  }
  
  public IHeaderView createHeader(QQGameMsgInfo paramQQGameMsgInfo, Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      if (paramQQGameMsgInfo == null) {}
      try
      {
        return ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).getMoreMsgHeaderView(paramActivity);
      }
      catch (Throwable paramQQGameMsgInfo)
      {
        paramActivity = new StringBuilder();
        paramActivity.append("decode header(web) faile:");
        paramActivity.append(paramQQGameMsgInfo.getMessage());
        QLog.d("QQGamePub_QQGameTempRelyApiImpl", 4, paramActivity.toString());
        return null;
      }
      if (paramQQGameMsgInfo.msgType == 1) {
        return ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).getGameArkView(paramActivity);
      }
      if (paramQQGameMsgInfo.msgType == 2) {
        return new ImgHeaderView(paramActivity);
      }
      if (paramQQGameMsgInfo.msgType == 3) {
        return new TextHeaderView(paramActivity);
      }
      paramQQGameMsgInfo = ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).getMoreMsgHeaderView(paramActivity);
      return paramQQGameMsgInfo;
    }
    QLog.d("QQGamePub_QQGameTempRelyApiImpl", 4, "createHeader fail activity is null");
    return null;
  }
  
  public void exePublicAccountTianshuReport(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    PublicAccountEventReport.a(paramInt1, paramInt2, paramString1, paramString2);
  }
  
  public void exitVideoFullScreen()
  {
    GameCenterVideoViewController localGameCenterVideoViewController = GameCenterVideoManager.a().a();
    if (localGameCenterVideoViewController != null) {
      localGameCenterVideoViewController.exitFullScreen();
    }
  }
  
  public Context getCurrentContext(WebViewPlugin.PluginRuntime paramPluginRuntime)
  {
    if (paramPluginRuntime == null) {
      return null;
    }
    for (paramPluginRuntime = paramPluginRuntime.a(); (paramPluginRuntime instanceof BasePluginActivity); paramPluginRuntime = ((BasePluginActivity)paramPluginRuntime).getOutActivity()) {}
    return paramPluginRuntime;
  }
  
  public Map<String, String> getGameMsgInfoMap()
  {
    return QQGameConstant.a;
  }
  
  public void handleGcArkDeleteMsg(String paramString)
  {
    try
    {
      QLog.d("QQGamePub_QQGameTempRelyApiImpl", 1, "call gc_ark_msg_delete");
      paramString = new JSONObject(paramString).getString("arkViewId");
      Intent localIntent = new Intent("action_qgame_delete_ad");
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if ((Foreground.getTopActivity() instanceof BaseActivity))
      {
        localIntent.putExtra("isAioDeletMsg", true);
        BaseActivity localBaseActivity = (BaseActivity)Foreground.getTopActivity();
        Object localObject = localBaseActivity.getChatFragment();
        if (localObject == null) {
          return;
        }
        if (((ChatFragment)localObject).a == null) {
          return;
        }
        localObject = ((ChatFragment)localObject).a.a.a();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject).next();
            if (paramString.equals(String.valueOf(localChatMessage.uniseq)))
            {
              ((IEcshopPublicAccountChatPieTempApi)QRoute.api(IEcshopPublicAccountChatPieTempApi.class)).startDelAnimAndDelMsg(localBaseActivity, localChatMessage);
              QQToast.a(MobileQQ.getContext(), 2131699812, 1).a();
            }
          }
        }
      }
      localIntent.setPackage(MobileQQ.sMobileQQ.getPackageName());
      localIntent.putExtra("arkViewId", paramString);
      MobileQQ.sMobileQQ.sendBroadcast(localIntent);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("QQGamePub_QQGameTempRelyApiImpl", 1, paramString, new Object[0]);
      return;
    }
  }
  
  public String init(ArkView paramArkView, MessageRecord paramMessageRecord, ArkViewImplement.LoadCallback paramLoadCallback)
  {
    if (paramArkView != null)
    {
      paramMessageRecord = (MessageForArkApp)paramMessageRecord;
      if (paramMessageRecord != null)
      {
        paramArkView.load(paramMessageRecord.ark_app_message.appName, paramMessageRecord.ark_app_message.appView, paramMessageRecord.ark_app_message.appMinVersion, paramMessageRecord.ark_app_message.metaList, paramMessageRecord.ark_app_message.config, paramLoadCallback);
        return paramMessageRecord.ark_app_message.appName;
      }
    }
    return "";
  }
  
  public void initPublicAccountChatPieIntent(ActivityURIRequest paramActivityURIRequest)
  {
    paramActivityURIRequest.extra().putBoolean("shouldreport", true);
    paramActivityURIRequest.extra().putBoolean("has_unread_msg", false);
    paramActivityURIRequest.extra().putInt("jump_from", 1);
  }
  
  public boolean isInNightMode()
  {
    return SubscribeUtils.a();
  }
  
  public boolean isToolAppRuntime(AppRuntime paramAppRuntime)
  {
    return paramAppRuntime instanceof ToolAppRuntime;
  }
  
  public boolean isVideoFullScreenMode()
  {
    GameCenterVideoViewController localGameCenterVideoViewController = GameCenterVideoManager.a().a();
    return (localGameCenterVideoViewController != null) && (localGameCenterVideoViewController.isFullScreenMode());
  }
  
  public void publicAccountExposureReport(String paramString, long paramLong)
  {
    PublicAccountEventReport.a(paramString, paramLong);
  }
  
  public void stopVideo()
  {
    GameCenterVideoViewController localGameCenterVideoViewController = GameCenterVideoManager.a().a();
    if (localGameCenterVideoViewController != null) {
      localGameCenterVideoViewController.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameTempRelyApiImpl
 * JD-Core Version:    0.7.0.1
 */