package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.ResultReceiver;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationMiniApp;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationMiniApp;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationMiniApp;
import com.tencent.mobileqq.activity.recent.RecentOptPopBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandLaunchUI;
import com.tencent.mobileqq.mini.appbrand.ui.MiniAppWebviewFragment;
import com.tencent.mobileqq.mini.mainpage.MainPageFragment;
import com.tencent.mobileqq.mini.manager.MiniAppDetainManager;
import com.tencent.mobileqq.mini.out.activity.MapActivity;
import com.tencent.mobileqq.mini.report.InnerAppReportDc4239;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.utils.TroopApplicationListUtil;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.minigame.utils.PathUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.GetShareStateActionBridge;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.PageActionBridge;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.IAppUpdateListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.IChoosePhotoListner;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.IDrawableLoadedCallBack;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.SenderListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.launcher.ui.MoreItem;
import com.tencent.qqmini.sdk.launcher.ui.MoreItemList.Builder;
import com.tencent.qqmini.sdk.launcher.ui.OnAppCloseAction;
import com.tencent.qqmini.sdk.launcher.ui.OnMoreItemSelectedListener;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.smtt.sdk.QbSdk;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import java.io.Closeable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;

@ProxyService(proxy=MiniAppProxy.class)
@RequiresApi(api=3)
public class MiniAppProxyImpl
  extends MiniAppProxy
{
  private static boolean d;
  private boolean a = false;
  private IMiniAppContext b;
  private ArrayList<Integer> c = new MiniAppProxyImpl.1(this);
  private Handler e = new Handler(Looper.getMainLooper(), new MiniAppProxyImpl.2(this));
  private BroadcastReceiver f = null;
  private MiniAppInfo g = null;
  private MiniAppConfig h = null;
  private String i = null;
  private String j = null;
  private String k = null;
  private DownloadListener l = new MiniAppProxyImpl.15(this);
  
  private void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.i = paramString4;
    this.j = paramString1;
    this.k = paramString2;
    Bundle localBundle = new Bundle();
    localBundle.putString(DownloadConstants.b, paramString1);
    localBundle.putString(DownloadConstants.j, paramString4);
    localBundle.putString(DownloadConstants.f, paramString2);
    localBundle.putInt(DownloadConstants.k, 2);
    localBundle.putString(DownloadConstants.i, "MiniApp");
    localBundle.putString(DownloadConstants.l, paramString3);
    localBundle.putInt(DownloadConstants.J, 1);
    DownloadApi.a(this.l);
    DownloadApi.a(paramActivity, localBundle, "biz_src_miniapp", null, 0);
    QQToast.makeText(paramActivity, "开始下载", 1).show();
    InnerAppReportDc4239.innerAppReport(this.h, null, "launchapp", "downloadapp", "qqdownload");
  }
  
  private void a(Context paramContext, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (paramContext == null) {
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("packageName", paramString2);
      localBundle.putString("appId", paramString1);
      localBundle.putString("big_brother_source_key", "biz_src_miniapp");
      if ((paramContext instanceof BasePluginActivity))
      {
        AppClient.b(((BasePluginActivity)paramContext).getOutActivity(), localBundle);
        InnerAppReportDc4239.innerAppReport(this.h, null, "launchapp", "downloadapp", "yybdownload");
        return;
      }
      if ((paramContext instanceof Activity))
      {
        AppClient.b((Activity)paramContext, localBundle);
        InnerAppReportDc4239.innerAppReport(this.h, null, "launchapp", "downloadapp", "yybdownload");
        return;
      }
      QLog.e("MiniAppProxyImpl", 2, "onOpenThridApp mContext 必现是一个Activity");
    }
  }
  
  private void a(IColorNoteController paramIColorNoteController)
  {
    if (paramIColorNoteController != null)
    {
      if (!paramIColorNoteController.isColorNoteExist())
      {
        if (paramIColorNoteController.canAddColorNote())
        {
          paramIColorNoteController.insertColorNote();
          return;
        }
        paramIColorNoteController.onCannotAdd();
        return;
      }
      if (paramIColorNoteController.isColorNoteExist()) {
        paramIColorNoteController.deleteColorNote();
      }
    }
  }
  
  public static void a(IMiniAppContext paramIMiniAppContext)
  {
    paramIMiniAppContext.performAction(new MiniAppProxyImpl.3());
    a(paramIMiniAppContext.getAttachedActivity());
    Process.killProcess(Process.myPid());
  }
  
  private void a(IMiniAppContext paramIMiniAppContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    MiniAppConfig localMiniAppConfig = MiniSdkUtil.b(paramIMiniAppContext.getMiniAppInfo());
    MiniProgramLpReportDC04239.reportUserClick(localMiniAppConfig, MiniProgramLpReportDC04239.getAppType(localMiniAppConfig), ActionBridge.PageActionBridge.getPageUrl(paramIMiniAppContext), "user_click", "more_button", paramString);
  }
  
  private void a(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sendSetUserAppTopRequest, miniAppInfo = ");
        ((StringBuilder)localObject).append(paramMiniAppInfo);
        QLog.e("MiniAppProxyImpl", 1, ((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("appid", paramMiniAppInfo.appId);
    ((Bundle)localObject).putInt("topType", paramMiniAppInfo.topType);
    ((Bundle)localObject).putInt("verType", paramMiniAppInfo.verType);
    QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "sync_mini_app_data", (Bundle)localObject, new MiniAppProxyImpl.6(this, paramMiniAppInfo));
  }
  
  private static boolean a(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return false;
    }
    try
    {
      Object localObject = (ActivityManager)paramActivity.getSystemService("activity");
      if (localObject == null) {
        return false;
      }
      localObject = ((ActivityManager)localObject).getAppTasks();
      if (localObject == null) {
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.AppTask localAppTask = (ActivityManager.AppTask)((Iterator)localObject).next();
        if ((localAppTask != null) && (localAppTask.getTaskInfo() != null) && (localAppTask.getTaskInfo().baseIntent != null) && (localAppTask.getTaskInfo().baseIntent.getComponent() != null))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("will finish and remove task: id=");
          localStringBuilder.append(localAppTask.getTaskInfo().id);
          QLog.e("miniapp", 1, localStringBuilder.toString());
          if ((localAppTask.getTaskInfo().baseIntent.getComponent().getClassName().equals(paramActivity.getClass().getName())) || (localAppTask.getTaskInfo().baseIntent.getComponent().getClassName().equals(paramActivity.getClass().getName()))) {
            localAppTask.finishAndRemoveTask();
          }
        }
      }
      return true;
    }
    catch (Throwable paramActivity)
    {
      label198:
      break label198;
    }
    QLog.e("miniapp", 1, "finishAndRemoveAllTasks exception.");
    return false;
  }
  
  private int b(IColorNoteController paramIColorNoteController)
  {
    if (paramIColorNoteController.shouldDisplayColorNote())
    {
      if (paramIColorNoteController.isColorNoteExist()) {
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  private void b(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null)
    {
      QLog.e("MiniAppProxyImpl", 1, "setMiniAppTop, miniAppInfo = null.");
      return;
    }
    MiniAppCmdUtil.getInstance().setUserAppTop(paramMiniAppInfo.appId, paramMiniAppInfo.topType, paramMiniAppInfo.verType, null, new MiniAppProxyImpl.7(this, paramMiniAppInfo));
  }
  
  private void c(IMiniAppContext paramIMiniAppContext)
  {
    if ((paramIMiniAppContext != null) && (paramIMiniAppContext.getAttachedActivity() != null))
    {
      QLog.d("MiniAppProxyImpl", 1, "setMiniAppToTroopApplicationList");
      Object localObject = AppLoaderFactory.g().getMiniAppEnv().getActivityResultManager();
      ((IActivityResultManager)localObject).addActivityResultListener(new MiniAppProxyImpl.4(this, (IActivityResultManager)localObject, paramIMiniAppContext));
      localObject = new Intent(paramIMiniAppContext.getAttachedActivity(), TroopActivity.class);
      ((Intent)localObject).putExtra("onlyOneSegement", true);
      ((Intent)localObject).putExtra("_key_mode", 0);
      ((Intent)localObject).putExtra("key_tab_mode", 0);
      ((Intent)localObject).putExtra("is_select_troop", true);
      ((Intent)localObject).putExtra("key_from", 3);
      paramIMiniAppContext.getAttachedActivity().startActivityForResult((Intent)localObject, 1002);
      return;
    }
    QLog.e("MiniAppProxyImpl", 1, "setMiniAppToTroopApplicationList, miniAppContext is null.");
  }
  
  private boolean c(MiniAppInfo paramMiniAppInfo)
  {
    boolean bool2 = AppNetConnInfo.isMobileConn();
    boolean bool1 = false;
    if (!bool2)
    {
      paramMiniAppInfo = new StringBuilder();
      paramMiniAppInfo.append("shouldShowKingCardTip network type is wifi + ");
      paramMiniAppInfo.append(AppNetConnInfo.isWifiConn());
      QLog.i("MiniAppProxyImpl", 1, paramMiniAppInfo.toString());
      return false;
    }
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.appMode != null) && (paramMiniAppInfo.appMode.isWangKa)) {
      m = 1;
    } else {
      m = 0;
    }
    if (m == 0)
    {
      QLog.i("MiniAppProxyImpl", 1, "shouldShowKingCardTip， not wangka app");
      return false;
    }
    int m = CUKingCardUtils.a();
    paramMiniAppInfo = new StringBuilder();
    paramMiniAppInfo.append("shouldShowKingCardTip， king card status = ");
    paramMiniAppInfo.append(m);
    QLog.i("MiniAppProxyImpl", 1, paramMiniAppInfo.toString());
    if (m == 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  private void d(IMiniAppContext paramIMiniAppContext)
  {
    QLog.d("MiniAppProxyImpl", 1, "addToCurrentTroop");
    try
    {
      paramIMiniAppContext = paramIMiniAppContext.getMiniAppInfo();
      TroopApplicationListUtil.addMiniAppToTroopApplicationList(String.valueOf(paramIMiniAppContext.launchParam.entryModel.uin), paramIMiniAppContext.appId, null);
      return;
    }
    catch (Exception paramIMiniAppContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addToCurrentTroop exception: ");
      localStringBuilder.append(Log.getStackTraceString(paramIMiniAppContext));
      QLog.e("MiniAppProxyImpl", 1, localStringBuilder.toString());
    }
  }
  
  private boolean d(MiniAppInfo paramMiniAppInfo)
  {
    if (f(paramMiniAppInfo)) {
      return paramMiniAppInfo.launchParam.entryModel.isAdmin;
    }
    return false;
  }
  
  private void e(IMiniAppContext paramIMiniAppContext)
  {
    MiniAppInfo localMiniAppInfo = paramIMiniAppContext.getMiniAppInfo();
    Activity localActivity = paramIMiniAppContext.getAttachedActivity();
    if ((localMiniAppInfo != null) && (localActivity != null))
    {
      paramIMiniAppContext = "";
      try
      {
        String str = URLEncoder.encode("https://support.qq.com/data/1368/2018/0927/5e6c84b68d1f3ad390e7beeb6c2f83b0.jpeg", "UTF-8");
        paramIMiniAppContext = str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startComplainAndCallback, url = ");
        localStringBuilder.append("");
        QLog.e("MiniAppProxyImpl", 1, localStringBuilder.toString());
        localUnsupportedEncodingException.printStackTrace();
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://tucao.qq.com/qq_miniprogram/tucao?appid=");
      ((StringBuilder)localObject).append(localMiniAppInfo.appId);
      ((StringBuilder)localObject).append("&openid=");
      ((StringBuilder)localObject).append(MainPageFragment.getUin());
      ((StringBuilder)localObject).append("&avatar=");
      ((StringBuilder)localObject).append(paramIMiniAppContext);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131899587));
      localObject = ((StringBuilder)localObject).toString();
      paramIMiniAppContext = new Intent(localActivity, QQBrowserActivity.class);
      paramIMiniAppContext.putExtra("url", (String)localObject);
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("hide_more_button", true);
      paramIMiniAppContext.putExtras((Bundle)localObject);
      localActivity.startActivity(paramIMiniAppContext);
      paramIMiniAppContext = MiniSdkUtil.b(localMiniAppInfo);
      MiniProgramLpReportDC04239.reportUserClick(paramIMiniAppContext, MiniProgramLpReportDC04239.getAppType(paramIMiniAppContext), null, "user_click", "more_button", "report");
      QLog.d("MiniAppProxyImpl", 2, "feedback, prepare to upload log ");
      paramIMiniAppContext = new Bundle();
      paramIMiniAppContext.putString("appid", localMiniAppInfo.appId);
      QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "upload_user_log", paramIMiniAppContext, new MiniAppProxyImpl.5(this));
    }
  }
  
  private boolean e(MiniAppInfo paramMiniAppInfo)
  {
    return f(paramMiniAppInfo) ^ true;
  }
  
  private boolean f(MiniAppInfo paramMiniAppInfo)
  {
    return (paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null) && (paramMiniAppInfo.launchParam.entryModel != null);
  }
  
  public void a()
  {
    Object localObject1 = this.b;
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((IMiniAppContext)localObject1).getAttachedActivity();
    boolean bool3 = localObject1 instanceof GameActivity1;
    if (this.a) {
      return;
    }
    Object localObject2 = this.b.getMiniAppInfo();
    ShareState localShareState = (ShareState)this.b.performAction(ActionBridge.GetShareStateActionBridge.obtain());
    boolean bool4 = ((MiniAppInfo)localObject2).isLimitedAccessApp();
    boolean bool1 = ((MiniAppInfo)localObject2).isEngineTypeMiniGame();
    boolean bool2 = false;
    if (bool1)
    {
      if ((localShareState.showRestart) && (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_capsule_show_restart_btn", 1) == 1)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
    else {
      bool1 = localShareState.showRestart;
    }
    if (bool3)
    {
      localObject3 = ((GameActivity1)localObject1).getColorNoteController();
      if ((!bool4) && (localObject3 != null))
      {
        m = b((IColorNoteController)localObject3);
        break label218;
      }
    }
    else
    {
      localObject3 = (PageGestureProxy)AppLoaderFactory.g().getProxyManager().get(PageGestureProxy.class);
      if ((localObject3 instanceof PageGestureProxyImpl))
      {
        localObject3 = ((PageGestureProxyImpl)localObject3).a();
        if ((!bool4) && (localObject3 != null))
        {
          m = b((IColorNoteController)localObject3);
          break label218;
        }
      }
    }
    int m = 0;
    label218:
    Object localObject3 = new Intent();
    ((Intent)localObject3).putExtra("miniAppID", ((MiniAppInfo)localObject2).appId);
    ((Intent)localObject3).putExtra("miniAppName", ((MiniAppInfo)localObject2).name);
    ((Intent)localObject3).putExtra("isOpenMonitorPanel", d);
    ((Intent)localObject3).putExtra("debugEnable", DebugUtil.getDebugEnabled((MiniAppInfo)localObject2));
    ((Intent)localObject3).putExtra("showDebug", localShareState.showDebug);
    ((Intent)localObject3).putExtra("showMonitor", localShareState.showMonitor);
    ((Intent)localObject3).putExtra("menuStyle", AppLoaderFactory.g().getMiniAppEnv().getMenuStyle());
    ((Intent)localObject3).putExtra("showShareQQ", localShareState.withShareQQ);
    ((Intent)localObject3).putExtra("showShareQzone", localShareState.withShareQzone);
    ((Intent)localObject3).putExtra("showShareWeChatFriends", localShareState.withShareWeChatFriend);
    ((Intent)localObject3).putExtra("showShareWeChatMoment", localShareState.withShareWeChatMoment);
    ((Intent)localObject3).putExtra("topType", ((MiniAppInfo)localObject2).topType);
    ((Intent)localObject3).putExtra("showDetail", true);
    ((Intent)localObject3).putExtra("showSetting", true);
    ((Intent)localObject3).putExtra("showComplaint", true);
    if (Build.VERSION.SDK_INT >= 21) {
      bool2 = true;
    }
    ((Intent)localObject3).putExtra("addShortcut", bool2);
    ((Intent)localObject3).putExtra("showBackHome", -1);
    ((Intent)localObject3).putExtra("isLandscape", localShareState.isOrientationLandscape);
    ((Intent)localObject3).putExtra("isSpecialMiniApp", ((MiniAppInfo)localObject2).isSpecialMiniApp());
    ((Intent)localObject3).putExtra("disableAddToMyApp", ((MiniAppInfo)localObject2).appMode.disableAddToMyApp);
    ((Intent)localObject3).putExtra("disableAddToMyFavor", ((MiniAppInfo)localObject2).appMode.disableAddToMyFavor);
    ((Intent)localObject3).putExtra("showKingcardTip", c((MiniAppInfo)localObject2));
    ((Intent)localObject3).putExtra("key_mini_msgtab_type", 1);
    ((Intent)localObject3).putExtra("key_mini_msgtab_need_action_sheet", true);
    ((Intent)localObject3).putExtra("key_mini_app_config", MiniSdkUtil.b((MiniAppInfo)localObject2));
    ((Intent)localObject3).putExtra("key_color_note", m);
    ((Intent)localObject3).putExtra("key_mini_app_is_game", bool3);
    ((Intent)localObject3).putExtra("key_mini_app_version_type", ((MiniAppInfo)localObject2).verType);
    ((Intent)localObject3).putExtra("showFavorite", true);
    ((Intent)localObject3).putExtra("is_limited_access_app", bool4);
    ((Intent)localObject3).putExtra("showRestartMiniApp", bool1);
    ((Intent)localObject3).putExtra("setToTroop", e((MiniAppInfo)localObject2));
    ((Intent)localObject3).putExtra("addToCurrentTroop", d((MiniAppInfo)localObject2));
    if (QFileAssistantUtils.b()) {
      ((Intent)localObject3).putExtra("showShareDataline", true);
    }
    localObject2 = AppLoaderFactory.g().getMiniAppEnv().getActivityResultManager();
    ((IActivityResultManager)localObject2).addActivityResultListener(new MiniAppProxyImpl.10(this, (IActivityResultManager)localObject2));
    MiniChatActivity.a((Activity)localObject1, (Intent)localObject3, 9527);
    QLog.d("MiniAppProxyImpl", 1, "set isMiniMsgTabShow true");
    this.a = true;
    a(this.b, "open");
  }
  
  public void a(Context paramContext, String paramString)
  {
    if ((paramString != null) && (!TextUtils.isEmpty(paramString)) && (paramString.length() >= 5))
    {
      TroopUtils.a(paramContext, TroopInfoUIUtil.a(paramString, 5), 2);
      return;
    }
    QLog.e("MiniAppProxyImpl", 1, "uin is null");
  }
  
  public boolean addShortcut(Context paramContext, MiniAppInfo paramMiniAppInfo, AsyncResult paramAsyncResult)
  {
    ShortcutUtils.a((Activity)paramContext, paramMiniAppInfo, new MiniAppProxyImpl.12(this, paramAsyncResult));
    return true;
  }
  
  public void b(Context paramContext, String paramString)
  {
    if ((paramString != null) && (!TextUtils.isEmpty(paramString)) && (paramString.length() >= 5))
    {
      paramContext = new ActivityURIRequest(paramContext, "/pubaccount/detail");
      paramContext.extra().putString("uin", paramString);
      QRoute.startUri(paramContext, null);
      return;
    }
    QLog.e("MiniAppProxyImpl", 1, "uin is null");
  }
  
  public void b(IMiniAppContext paramIMiniAppContext)
  {
    this.e.sendEmptyMessageDelayed(1000, 500L);
    MiniAppInfo localMiniAppInfo = paramIMiniAppContext.getMiniAppInfo();
    int m;
    if (localMiniAppInfo != null)
    {
      m = localMiniAppInfo.verType;
      paramIMiniAppContext = localMiniAppInfo.appId;
    }
    else
    {
      m = 3;
      paramIMiniAppContext = null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", paramIMiniAppContext);
    localBundle.putInt("verType", m);
    QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "query_mini_app_data", localBundle, new MiniAppProxyImpl.9(this, localMiniAppInfo));
  }
  
  public boolean chooseLocation(Context paramContext, AsyncResult paramAsyncResult)
  {
    IActivityResultManager localIActivityResultManager = AppLoaderFactory.g().getMiniAppEnv().getActivityResultManager();
    localIActivityResultManager.addActivityResultListener(new MiniAppProxyImpl.14(this, paramAsyncResult, localIActivityResultManager));
    paramAsyncResult = new Intent(paramContext, MapActivity.class);
    paramAsyncResult.putExtra("key_type", 2);
    ((BaseActivity)paramContext).startActivityForResult(paramAsyncResult, 3);
    return true;
  }
  
  public boolean downloadApp(Context paramContext, MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.g = paramMiniAppInfo;
    this.h = MiniSdkUtil.b(this.g);
    if (!TextUtils.isEmpty(paramString4))
    {
      QLog.d("MiniAppProxyImpl", 1, "手Q下载");
      a((Activity)paramContext, paramString1, paramString2, paramString3, paramString4);
      return true;
    }
    QLog.d("MiniAppProxyImpl", 1, "应用宝微下载");
    a(paramContext, paramString1, paramString2);
    return true;
  }
  
  public boolean enterQRCode(Context paramContext, boolean paramBoolean, AsyncResult paramAsyncResult)
  {
    paramContext = (BaseActivity)paramContext;
    if (!RecentOptPopBar.a(paramContext))
    {
      paramAsyncResult.onReceiveResult(false, null);
      return true;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("leftViewText", paramContext.getString(2131887625));
    localIntent.putExtra("selfSet_leftViewText", paramContext.getString(2131887625));
    localIntent.putExtra("start_time", System.currentTimeMillis());
    localIntent.putExtra("from", "mini_app");
    if (paramBoolean) {
      localIntent.putExtra("hide_album", true);
    }
    localIntent.setFlags(67108864);
    BroadcastReceiver localBroadcastReceiver = this.f;
    if (localBroadcastReceiver != null)
    {
      try
      {
        paramContext.unregisterReceiver(localBroadcastReceiver);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unregisterReceiver error.");
        localStringBuilder.append(localException);
        QLog.e("MiniAppProxyImpl", 1, localStringBuilder.toString());
      }
      this.f = null;
    }
    this.f = new MiniAppProxyImpl.11(this, paramAsyncResult);
    paramAsyncResult = new IntentFilter("com.tencent.mobileqq.mini.out.plugins.scanResultAction");
    paramContext.registerReceiver(this.f, paramAsyncResult, "com.tencent.msg.permission.pushnotify", null);
    RouteUtils.a(paramContext, localIntent, "/qrscan/scanner");
    return true;
  }
  
  public String getA2()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null) {
      return "";
    }
    TicketManager localTicketManager = (TicketManager)localAppRuntime.getManager(2);
    if (localTicketManager != null) {
      return localTicketManager.getA2(localAppRuntime.getAccount());
    }
    return "";
  }
  
  public String getAccount()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getAccount();
  }
  
  public String getAmsAppId()
  {
    return null;
  }
  
  public String getAppId()
  {
    return null;
  }
  
  public String getAppName()
  {
    return "qq";
  }
  
  public void getAppUpdate(Activity paramActivity, MiniAppProxy.IAppUpdateListener paramIAppUpdateListener)
  {
    IActivityResultManager localIActivityResultManager = AppLoaderFactory.g().getMiniAppEnv().getActivityResultManager();
    localIActivityResultManager.addActivityResultListener(new MiniAppProxyImpl.16(this, localIActivityResultManager, paramIAppUpdateListener));
    paramIAppUpdateListener = new Intent(BaseApplication.getContext(), UpgradeActivity.class);
    paramIAppUpdateListener.putExtra("activity_type", 4096);
    paramActivity.startActivityForResult(paramIAppUpdateListener, 1003);
  }
  
  public String getAppVersion()
  {
    return "8.8.17.5770";
  }
  
  public Drawable getDrawable(Context paramContext, String paramString, int paramInt1, int paramInt2, Drawable paramDrawable)
  {
    paramContext = URLDrawable.URLDrawableOptions.obtain();
    paramContext.mPlayGifImage = true;
    paramContext.mKeyAddWHSuffix = false;
    paramContext.mRequestWidth = paramInt1;
    paramContext.mRequestHeight = paramInt2;
    paramContext.mFailedDrawable = paramDrawable;
    paramContext.mLoadingDrawable = paramDrawable;
    if (PathUtil.isNetworkUrl(paramString)) {
      return URLDrawable.getDrawable(paramString, paramContext);
    }
    return URLDrawable.getFileDrawable(paramString, paramContext);
  }
  
  public String getImei()
  {
    return MobileInfoUtil.getImei();
  }
  
  public String getLocation(Context paramContext)
  {
    paramContext = new StringBuilder();
    SosoLbsInfo localSosoLbsInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("miniapp");
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null))
    {
      paramContext.append(String.valueOf(localSosoLbsInfo.mLocation.mLat02));
      paramContext.append('*');
      paramContext.append(String.valueOf(localSosoLbsInfo.mLocation.mLon02));
    }
    return paramContext.toString();
  }
  
  public boolean getLocation(Context paramContext, String paramString, boolean paramBoolean, AsyncResult paramAsyncResult)
  {
    boolean bool;
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("wgs84"))) {
      bool = false;
    } else {
      bool = true;
    }
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new MiniAppProxyImpl.13(this, 0, true, true, 5000L, false, false, "miniApp", bool, paramBoolean, paramAsyncResult));
    return true;
  }
  
  public byte[] getLoginSig()
  {
    return new byte[0];
  }
  
  public int getLoginType()
  {
    return 0;
  }
  
  public OnMoreItemSelectedListener getMoreItemSelectedListener()
  {
    return null;
  }
  
  public ArrayList<MoreItem> getMoreItems(MoreItemList.Builder paramBuilder)
  {
    return null;
  }
  
  public String getNickName()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Constants.PropertiesKey.nickName.toString());
    localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    return localBaseApplicationImpl.getProperty(localStringBuilder.toString());
  }
  
  public String getPayAccessToken()
  {
    return null;
  }
  
  public int getPayMode()
  {
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_pay_by_h5", 0) == 0) {
      return 2;
    }
    return 1;
  }
  
  public String getPayOpenId()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getAccount();
  }
  
  public String getPayOpenKey()
  {
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localObject2 == null) {
      return "";
    }
    TicketManager localTicketManager = (TicketManager)((AppRuntime)localObject2).getManager(2);
    Object localObject1 = str;
    if (localTicketManager != null)
    {
      localObject2 = localTicketManager.getSkey(((AppRuntime)localObject2).getAccount(), 16L, null);
      localObject1 = str;
      if (localObject2 != null)
      {
        localObject1 = str;
        if (((Ticket)localObject2)._sig != null)
        {
          str = new String(((Ticket)localObject2)._sig);
          localObject1 = str;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("get skey sucess.: ");
            ((StringBuilder)localObject1).append(str);
            QLog.i("MiniAppProxyImpl", 2, ((StringBuilder)localObject1).toString());
            localObject1 = str;
          }
        }
      }
    }
    return localObject1;
  }
  
  public String getPlatformId()
  {
    return "10000";
  }
  
  public String getPlatformQUA()
  {
    return QUA.getQUA3();
  }
  
  public String getSoPath()
  {
    return null;
  }
  
  public int getTbsVersion()
  {
    return QbSdk.getTbsVersion(BaseApplicationImpl.getApplication());
  }
  
  public boolean isDebugVersion()
  {
    return false;
  }
  
  public void muteAudioFocus(Context paramContext, boolean paramBoolean)
  {
    QQAudioUtils.a(paramContext, paramBoolean);
  }
  
  public void notifyMiniAppInfo(int paramInt, MiniAppInfo paramMiniAppInfo) {}
  
  public OnAppCloseAction onAppClose(MiniAppInfo paramMiniAppInfo, Closeable paramCloseable)
  {
    return null;
  }
  
  public void onAppStateChange(MiniAppInfo paramMiniAppInfo, int paramInt) {}
  
  public boolean onCapsuleButtonCloseClick(IMiniAppContext paramIMiniAppContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramIMiniAppContext == null) {
      return false;
    }
    Activity localActivity = paramIMiniAppContext.getAttachedActivity();
    MiniAppInfo localMiniAppInfo = paramIMiniAppContext.getMiniAppInfo();
    if (localActivity != null)
    {
      if (localMiniAppInfo == null) {
        return false;
      }
      String str = getAppName();
      if ((!"qq".equalsIgnoreCase(str)) && (!"qi".equalsIgnoreCase(str)) && (!"ssq".equalsIgnoreCase(str))) {
        return false;
      }
      return MiniAppDetainManager.INSTANCE.handleOnCloseBtnClick(localActivity, paramIMiniAppContext, localMiniAppInfo, paramOnClickListener);
    }
    return false;
  }
  
  public boolean onCapsuleButtonMoreClick(IMiniAppContext paramIMiniAppContext)
  {
    QLog.d("MiniAppProxyImpl", 1, "onCapsuleButtonMoreClick");
    if (paramIMiniAppContext == null)
    {
      QLog.w("MiniAppProxyImpl", 1, "miniRuntime is null, no need to response more button");
      return false;
    }
    this.b = paramIMiniAppContext;
    Object localObject = paramIMiniAppContext.getAttachedActivity();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      localObject = paramIMiniAppContext.getMiniAppInfo();
      if (localObject == null)
      {
        QLog.w("MiniAppProxyImpl", 1, "MiniAppInfo is null, no need to response more button");
        return false;
      }
      ShareState localShareState = (ShareState)paramIMiniAppContext.performAction(ActionBridge.GetShareStateActionBridge.obtain());
      if (((MiniAppInfo)localObject).verType != 3)
      {
        localShareState.showDebug = true;
        localShareState.showMonitor = true;
      }
      if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_share_to_wx_switcher", 1) != 1)
      {
        localShareState.withShareWeChatFriend = false;
        localShareState.withShareWeChatMoment = false;
      }
      b(paramIMiniAppContext);
      return true;
    }
    QLog.w("MiniAppProxyImpl", 1, "Activity is not exiting, no need to response more button");
    return false;
  }
  
  public boolean openChoosePhotoActivity(Context paramContext, int paramInt, MiniAppProxy.IChoosePhotoListner paramIChoosePhotoListner)
  {
    paramIChoosePhotoListner = new ActivityURIRequest(paramContext, "/base/album/photolist");
    paramIChoosePhotoListner.extra().putInt("enter_from", 4);
    paramIChoosePhotoListner.extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationMiniApp.a);
    paramIChoosePhotoListner.extra().putString("KEY_ALBUM_LIST_CLASS_NAME", AlbumListCustomizationMiniApp.j);
    paramIChoosePhotoListner.extra().putString("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationMiniApp.a);
    paramIChoosePhotoListner.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
    paramIChoosePhotoListner.extra().putBoolean("PhotoConst.IS_SINGLE_MODE", false);
    paramIChoosePhotoListner.extra().putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 6);
    paramIChoosePhotoListner.extra().putString("PhotoConst.DEST_BROADCAST_ACTION_NAME", "micro_api_choose_image");
    paramIChoosePhotoListner.extra().putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    QRoute.startUri(paramIChoosePhotoListner);
    AlbumUtil.anim((Activity)paramContext, false, true);
    return true;
  }
  
  public boolean openImagePreview(Context paramContext, int paramInt, List<String> paramList)
  {
    Intent localIntent = new Intent(paramContext, TroopAvatarWallPreviewActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", paramInt);
    localBundle.putStringArrayList("seqNum", (ArrayList)paramList);
    localBundle.putBoolean("needBottomBar", false);
    localBundle.putBoolean("is_show_action", true);
    localBundle.putBoolean("is_not_show_index", true);
    localBundle.putBoolean("is_need_to_aio", false);
    localBundle.putBoolean("is_from_plugin", true);
    localIntent.putExtras(localBundle);
    localIntent.addFlags(603979776);
    paramContext.startActivity(localIntent);
    return true;
  }
  
  public boolean openLocation(Context paramContext, double paramDouble1, double paramDouble2, int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, MapActivity.class);
    localIntent.putExtra("key_type", 1);
    localIntent.putExtra("latitude", paramDouble1);
    localIntent.putExtra("longitude", paramDouble2);
    localIntent.putExtra("scale", paramInt);
    localIntent.putExtra("name", paramString1);
    localIntent.putExtra("address", paramString2);
    paramContext.startActivity(localIntent);
    return true;
  }
  
  public boolean openNativePage(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (paramContext != null) {
      if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2)) && (paramString2.length() >= 5))
      {
        if (paramString3.equals("group")) {
          a(paramContext, paramString2);
        } else if (paramString3.equals("public_account")) {
          b(paramContext, paramString2);
        }
      }
      else {
        return false;
      }
    }
    return true;
  }
  
  public boolean openSchema(Context paramContext, String paramString, int paramInt, ResultReceiver paramResultReceiver)
  {
    if ((MiniAppLauncher.isMiniAppScheme(paramString)) && (paramInt != -1))
    {
      MiniAppLauncher.startMiniApp(paramContext, paramString, paramInt, null);
      return true;
    }
    if (paramContext != null)
    {
      Intent localIntent = new Intent(paramContext, AppBrandLaunchUI.class);
      localIntent.setFlags(402653184);
      localIntent.putExtra("from", "SchemeJsPlugin");
      localIntent.putExtra("scheme", paramString);
      localIntent.putExtra("result_receiver", paramResultReceiver);
      paramContext.startActivity(localIntent);
    }
    return true;
  }
  
  public void sendData(byte[] paramArrayOfByte, MiniAppProxy.SenderListener paramSenderListener) {}
  
  public void sendRequestByMsf(byte[] paramArrayOfByte, String paramString, MiniAppProxy.SenderListener paramSenderListener)
  {
    MiniAppCmdUtil.getInstance().sendRequestByMsf(paramArrayOfByte, paramString, paramSenderListener);
  }
  
  public void setDrawableCallback(Drawable paramDrawable, MiniAppProxy.IDrawableLoadedCallBack paramIDrawableLoadedCallBack)
  {
    if ((paramDrawable != null) && ((paramDrawable instanceof URLDrawable))) {
      ((URLDrawable)paramDrawable).setURLDrawableListener(new MiniAppProxyImpl.8(this, paramIDrawableLoadedCallBack));
    }
  }
  
  public boolean startBrowserActivity(Context paramContext, Intent paramIntent)
  {
    paramIntent.setComponent(new ComponentName(paramContext, QQBrowserActivity.class));
    paramIntent.putExtra("fragmentClass", MiniAppWebviewFragment.class);
    paramContext.startActivity(paramIntent);
    return true;
  }
  
  public boolean verifyFile(int paramInt, String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl
 * JD-Core Version:    0.7.0.1
 */