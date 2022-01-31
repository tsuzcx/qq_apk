package com.tencent.qqmini.proxyimpl;

import Wallet.FocusMpIdReq;
import agwt;
import ahoi;
import ajya;
import amgn;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import bail;
import bbbx;
import bbdh;
import bbwq;
import bcql;
import bcyb;
import bdfk;
import bdkx;
import bdlb;
import bdld;
import bejc;
import bema;
import besl;
import besz;
import betc;
import bexo;
import beyp;
import bezl;
import bfga;
import bfgc;
import bfhm;
import bgyh;
import bgyi;
import biak;
import biam;
import bian;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandLaunchUI;
import com.tencent.mobileqq.mini.mainpage.MainPageFragment;
import com.tencent.mobileqq.mini.out.activity.MapActivity;
import com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy.IChoosePhotoListner;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy.SenderListener;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.ui.MoreItem;
import cooperation.vip.pb.TianShuAccess.AdItem;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;

@RequiresApi(api=3)
public class MiniAppProxyImpl
  extends MiniAppProxy
{
  public static final String MA_PERMISSION_BROADCAST = "com.tencent.msg.permission.pushnotify";
  public static final String MINI_APP_SCAN_DATA_RESULT = "com.tencent.mobileqq.mini.out.plugins.scanResultData";
  public static final String MINI_APP_SCAN_RESULT = "com.tencent.mobileqq.mini.out.plugins.scanResultAction";
  public static final String MINI_APP_SCAN_RESULT_TYPE = "com.tencent.mobileqq.mini.out.plugins.scanResultType";
  public static final int MSG_ADD_SHORTCUT = 11;
  public static final int MSG_BACK_HOME = 10;
  public static final int MSG_COLOR_NOTE_CLICK = 14;
  public static final int MSG_COMPLAINT = 12;
  public static final int MSG_DEBUG_CLICK = 3;
  public static final int MSG_DETAIL_CLICK = 4;
  public static final int MSG_FORWARD_CLICK = 2;
  public static final int MSG_FORWARD_QZONE_CLICK = 6;
  public static final int MSG_FORWARD_SHARE_CHAT_CLICK = 13;
  public static final int MSG_FORWARD_WECHAT_CLICK = 7;
  public static final int MSG_FORWARD_WECHAT_MOMENT_CLICK = 8;
  public static final int MSG_MONITOR_CLICK = 5;
  public static final int MSG_MORE_CLICK = 1;
  public static final int MSG_QIPC_TIMEOUT = 1000;
  public static final int MSG_SET_TOP = 9;
  private static final String TAG = "MiniAppProxyImpl";
  private static boolean isMonitorPanelShowing;
  private ArrayList<Integer> backHomeSceneList = new MiniAppProxyImpl.1(this);
  private boolean isMiniMsgTabShow;
  private MiniAppInfo mDownLoadMiniAppInfo;
  private bdld mDownloadListener = new MiniAppProxyImpl.12(this);
  private String mDownloadNativeAppId;
  private String mDownloadPackageName;
  private String mDownloadUrl;
  private Handler mHandler = new Handler(Looper.getMainLooper(), new MiniAppProxyImpl.2(this));
  private besz miniRuntime;
  private BroadcastReceiver scanResultReceiver;
  
  private void downloadByDownloadApi(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mDownloadUrl = paramString4;
    this.mDownloadNativeAppId = paramString1;
    this.mDownloadPackageName = paramString2;
    Bundle localBundle = new Bundle();
    localBundle.putString(bdlb.b, paramString1);
    localBundle.putString(bdlb.j, paramString4);
    localBundle.putString(bdlb.f, paramString2);
    localBundle.putInt(bdlb.k, 2);
    localBundle.putString(bdlb.i, "MiniApp");
    localBundle.putString(bdlb.l, paramString3);
    localBundle.putInt(bdlb.H, 1);
    bdkx.a(this.mDownloadListener);
    bdkx.a(paramActivity, localBundle, "biz_src_miniapp", null, 0);
    bcql.a(paramActivity, "开始下载", 1).a();
    beyp.a(this.mDownLoadMiniAppInfo, null, "launchapp", "downloadapp", "qqdownload");
  }
  
  private bian newTianShuReportData(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt)
  {
    int i = (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    bian localbian = new bian();
    localbian.b = (String.valueOf(bcyb.a().a()) + '_' + i);
    localbian.d = paramInt;
    localbian.jdField_e_of_type_Int = 1;
    localbian.g = String.valueOf(paramAdItem.iAdId.get());
    localbian.n = paramString;
    localbian.jdField_a_of_type_Long = i;
    localbian.jdField_a_of_type_Int = 1;
    localbian.jdField_e_of_type_JavaLangString = "tianshu.81";
    localbian.i = "";
    return localbian;
  }
  
  private void openAppDetailPage(Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramContext == null)) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("packageName", paramString2);
    localBundle.putString("appId", paramString1);
    localBundle.putString("big_brother_source_key", "biz_src_miniapp");
    if ((paramContext instanceof BasePluginActivity))
    {
      bdfk.b(((BasePluginActivity)paramContext).getOutActivity(), localBundle);
      beyp.a(this.mDownLoadMiniAppInfo, null, "launchapp", "downloadapp", "yybdownload");
      return;
    }
    if ((paramContext instanceof Activity))
    {
      bdfk.b((Activity)paramContext, localBundle);
      beyp.a(this.mDownLoadMiniAppInfo, null, "launchapp", "downloadapp", "yybdownload");
      return;
    }
    QLog.e("MiniAppProxyImpl", 2, "onOpenThridApp mContext 必现是一个Activity");
  }
  
  private void reportClick(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!this.miniRuntime.a().isEngineTypeMiniGame()) {
      return;
    }
    bezl.a(this.miniRuntime.a(), bezl.a(this.miniRuntime.a()), null, "user_click", "more_button", paramString);
  }
  
  private void sendSetUserAppTopRequest(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MiniAppProxyImpl", 1, "sendSetUserAppTopRequest, miniAppInfo = " + paramMiniAppInfo);
      }
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", paramMiniAppInfo.appId);
    localBundle.putInt("topType", paramMiniAppInfo.topType);
    localBundle.putInt("verType", paramMiniAppInfo.verType);
    QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "sync_mini_app_data", localBundle, new MiniAppProxyImpl.3(this, paramMiniAppInfo));
  }
  
  private void setMiniAppTop(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null)
    {
      QLog.e("MiniAppProxyImpl", 1, "setMiniAppTop, miniAppInfo = null.");
      return;
    }
    MiniAppCmdUtil.getInstance().setUserAppTop(paramMiniAppInfo.appId, paramMiniAppInfo.topType, paramMiniAppInfo.verType, null, new MiniAppProxyImpl.4(this));
  }
  
  private boolean shouldShowKingCardTip(MiniAppInfo paramMiniAppInfo)
  {
    boolean bool = true;
    if (!AppNetConnInfo.isMobileConn())
    {
      QLog.i("MiniAppProxyImpl", 1, "shouldShowKingCardTip network type is wifi + " + AppNetConnInfo.isWifiConn());
      return false;
    }
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.appMode != null) && (paramMiniAppInfo.appMode.h)) {}
    for (int i = 1; i == 0; i = 0)
    {
      QLog.i("MiniAppProxyImpl", 1, "shouldShowKingCardTip， not wangka app");
      return false;
    }
    i = bbwq.a();
    QLog.i("MiniAppProxyImpl", 1, "shouldShowKingCardTip， king card status = " + i);
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private void startReportPage(besz parambesz)
  {
    MiniAppInfo localMiniAppInfo = parambesz.a();
    Activity localActivity = parambesz.a();
    if ((localMiniAppInfo != null) && (localActivity != null)) {
      parambesz = "";
    }
    try
    {
      localObject = URLEncoder.encode("https://support.qq.com/data/1368/2018/0927/5e6c84b68d1f3ad390e7beeb6c2f83b0.jpeg", "UTF-8");
      parambesz = (besz)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject;
        QLog.e("MiniAppProxyImpl", 1, "startComplainAndCallback, url = " + "");
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    localObject = "https://tucao.qq.com/qq_miniprogram/tucao?appid=" + localMiniAppInfo.appId + "&openid=" + MainPageFragment.getUin() + "&avatar=" + parambesz + ajya.a(2131701352);
    parambesz = new Intent(localActivity, QQBrowserActivity.class);
    parambesz.putExtra("url", (String)localObject);
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("hide_more_button", true);
    parambesz.putExtras((Bundle)localObject);
    localActivity.startActivity(parambesz);
    bezl.a(localMiniAppInfo, bezl.a(localMiniAppInfo), null, "user_click", "more_button", "report");
  }
  
  public boolean addPublicAccount(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    agwt.a(new FocusMpIdReq(paramString1, paramString2), new MiniAppProxyImpl.8(this, paramAsyncResult));
    return true;
  }
  
  public boolean addShortcut(Activity paramActivity, MiniAppInfo paramMiniAppInfo, AsyncResult paramAsyncResult)
  {
    return false;
  }
  
  public boolean callServer(String paramString1, String paramString2, Bundle paramBundle)
  {
    try
    {
      QIPCClientHelper.getInstance().callServer(paramString1, paramString2, paramBundle, null);
      return true;
    }
    catch (Exception paramString1)
    {
      QLog.e("MiniAppProxyImpl", 1, paramString1, new Object[0]);
      paramString1.printStackTrace();
    }
    return true;
  }
  
  public boolean chooseLocation(Context paramContext, AsyncResult paramAsyncResult)
  {
    bejc.a().a(new MiniAppProxyImpl.10(this, paramAsyncResult));
    paramAsyncResult = new Intent(paramContext, MapActivity.class);
    paramAsyncResult.putExtra("key_type", 2);
    ((BaseActivity)paramContext).startActivityForResult(paramAsyncResult, 3);
    return true;
  }
  
  public void doShowShareView()
  {
    if (this.miniRuntime == null) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = this.miniRuntime.a();
    } while ((!(localActivity instanceof GameActivity1)) || (this.isMiniMsgTabShow));
    MiniAppInfo localMiniAppInfo = this.miniRuntime.a();
    besl localbesl = this.miniRuntime.a();
    boolean bool1;
    Object localObject;
    boolean bool2;
    int i;
    if ((localMiniAppInfo.appMode != null) && (localMiniAppInfo.appMode.j))
    {
      bool1 = true;
      localObject = ((GameActivity1)localActivity).getColorNoteController();
      if ((bool1) || (localObject == null)) {
        break label557;
      }
      bool2 = ((amgn)localObject).a();
      if (!bool2) {
        break label552;
      }
      if (!((amgn)localObject).c()) {
        break label542;
      }
      i = 2;
      label116:
      QLog.d("MiniAppProxyImpl", 1, "handleMoreClick, shouldDisplayColorNote : " + bool2);
    }
    for (;;)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("miniAppID", localMiniAppInfo.appId);
      ((Intent)localObject).putExtra("miniAppName", localMiniAppInfo.name);
      ((Intent)localObject).putExtra("isOpenMonitorPanel", isMonitorPanelShowing);
      ((Intent)localObject).putExtra("debugEnable", getEnableDebug(localMiniAppInfo.appId));
      ((Intent)localObject).putExtra("showDebug", localbesl.b);
      ((Intent)localObject).putExtra("showMonitor", localbesl.c);
      ((Intent)localObject).putExtra("menuStyle", MiniAppEnv.g().getMenuStyle());
      ((Intent)localObject).putExtra("showShareQQ", localbesl.e);
      ((Intent)localObject).putExtra("showShareQzone", localbesl.d);
      ((Intent)localObject).putExtra("showShareWeChatFriends", localbesl.f);
      ((Intent)localObject).putExtra("showShareWeChatMoment", localbesl.g);
      ((Intent)localObject).putExtra("topType", localMiniAppInfo.topType);
      ((Intent)localObject).putExtra("showDetail", true);
      ((Intent)localObject).putExtra("showSetting", true);
      ((Intent)localObject).putExtra("showComplaint", true);
      if (Build.VERSION.SDK_INT >= 21) {}
      for (bool2 = true;; bool2 = false)
      {
        ((Intent)localObject).putExtra("addShortcut", bool2);
        ((Intent)localObject).putExtra("showBackHome", -1);
        ((Intent)localObject).putExtra("isLandscape", localbesl.a);
        ((Intent)localObject).putExtra("isSpecialMiniApp", false);
        ((Intent)localObject).putExtra("showKingcardTip", shouldShowKingCardTip(localMiniAppInfo));
        ((Intent)localObject).putExtra("key_mini_msgtab_type", 1);
        ((Intent)localObject).putExtra("key_mini_msgtab_need_action_sheet", localMiniAppInfo.isEngineTypeMiniGame());
        ((Intent)localObject).putExtra("key_mini_app_version_type", 1);
        ((Intent)localObject).putExtra("key_mini_app_config", MiniSdkUtil.convertSDK2QQConfig(localMiniAppInfo));
        ((Intent)localObject).putExtra("key_mini_app_is_game", true);
        ((Intent)localObject).putExtra("key_color_note", i);
        ((Intent)localObject).putExtra("is_limited_access_app", bool1);
        bejc.a().a(new MiniAppProxyImpl.6(this));
        MiniChatActivity.a(localActivity, (Intent)localObject, 9527);
        betc.a("MiniAppProxyImpl", "set isMiniMsgTabShow true");
        this.isMiniMsgTabShow = true;
        return;
        bool1 = false;
        break;
        label542:
        i = 1;
        break label116;
      }
      label552:
      i = 0;
      break label116;
      label557:
      i = 0;
    }
  }
  
  public boolean downloadApp(Context paramContext, MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mDownLoadMiniAppInfo = paramMiniAppInfo;
    if (!TextUtils.isEmpty(paramString4))
    {
      QLog.d("MiniAppProxyImpl", 1, "手Q下载");
      downloadByDownloadApi((Activity)paramContext, paramString1, paramString2, paramString3, paramString4);
      return true;
    }
    QLog.d("MiniAppProxyImpl", 1, "应用宝微下载");
    openAppDetailPage(paramContext, paramString1, paramString2);
    return true;
  }
  
  public boolean enterQRCode(Context paramContext, boolean paramBoolean, AsyncResult paramAsyncResult)
  {
    BaseActivity localBaseActivity = (BaseActivity)paramContext;
    if (!ahoi.a(localBaseActivity))
    {
      paramAsyncResult.onReceiveResult(false, null);
      return true;
    }
    paramContext = new Intent((BaseActivity)paramContext, ScannerActivity.class);
    paramContext.putExtra("leftViewText", localBaseActivity.getString(2131690572));
    paramContext.putExtra("selfSet_leftViewText", localBaseActivity.getString(2131690572));
    paramContext.putExtra("start_time", System.currentTimeMillis());
    paramContext.putExtra("from", "mini_app");
    if (paramBoolean) {
      paramContext.putExtra("hide_album", true);
    }
    paramContext.setFlags(67108864);
    if (this.scanResultReceiver != null) {}
    try
    {
      localBaseActivity.unregisterReceiver(this.scanResultReceiver);
      this.scanResultReceiver = null;
      this.scanResultReceiver = new MiniAppProxyImpl.7(this, paramAsyncResult);
      paramAsyncResult = new IntentFilter("com.tencent.mobileqq.mini.out.plugins.scanResultAction");
      localBaseActivity.registerReceiver(this.scanResultReceiver, paramAsyncResult, "com.tencent.msg.permission.pushnotify", null);
      localBaseActivity.startActivity(paramContext);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MiniAppProxyImpl", 1, "unregisterReceiver error." + localException);
      }
    }
  }
  
  public String getAccount()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getAccount();
  }
  
  public String getAppId()
  {
    return null;
  }
  
  public String getAppName()
  {
    return "qq";
  }
  
  public String getAppVersion()
  {
    return "8.3.0.4480";
  }
  
  public String getDeviceInfo()
  {
    return bgyh.a().c();
  }
  
  public Drawable getDrawable(Context paramContext, String paramString, int paramInt1, int paramInt2, Drawable paramDrawable)
  {
    paramContext = URLDrawable.URLDrawableOptions.obtain();
    paramContext.mPlayGifImage = true;
    paramContext.mRequestWidth = paramInt1;
    paramContext.mRequestHeight = paramInt2;
    paramContext.mFailedDrawable = paramDrawable;
    paramContext.mLoadingDrawable = paramDrawable;
    if (bexo.a(paramString)) {
      return URLDrawable.getDrawable(paramString, paramContext);
    }
    return URLDrawable.getFileDrawable(paramString, paramContext);
  }
  
  public boolean getEnableDebug(String paramString)
  {
    return bfhm.a().getBoolean(paramString + "_debug", false);
  }
  
  public boolean getLocation(Context paramContext, String paramString, boolean paramBoolean, AsyncResult paramAsyncResult)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("wgs84"))) {}
    for (boolean bool = true;; bool = false)
    {
      SosoInterface.a(new MiniAppProxyImpl.9(this, 0, true, true, 5000L, false, false, "miniApp", bool, paramBoolean, paramAsyncResult));
      return true;
    }
  }
  
  public byte[] getLoginSig()
  {
    return new byte[0];
  }
  
  public int getLoginType()
  {
    return 0;
  }
  
  public bfgc getMoreItemSelectedListener()
  {
    return null;
  }
  
  public List<MoreItem> getMoreItems(bfga parambfga)
  {
    return null;
  }
  
  public String getNickName()
  {
    return BaseApplicationImpl.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + BaseApplicationImpl.getApplication().getRuntime().getAccount());
  }
  
  public String getPayOpenId()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getAccount();
  }
  
  public String getPayOpenKey()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject1 == null) {
      localObject1 = "";
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject2 = (TicketManager)((AppRuntime)localObject1).getManager(2);
      if (localObject2 == null) {
        break;
      }
      localObject1 = ((TicketManager)localObject2).GetSkey(((AppRuntime)localObject1).getAccount(), 16L, null);
      if ((localObject1 == null) || (((Ticket)localObject1)._sig == null)) {
        break;
      }
      localObject2 = new String(((Ticket)localObject1)._sig);
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.i("MiniAppProxyImpl", 2, "get skey sucess.: " + (String)localObject2);
    return localObject2;
    return "";
  }
  
  public String getPlatformId()
  {
    return "10000";
  }
  
  public String getPlatformQUA()
  {
    return bgyi.a();
  }
  
  public String getPlatformVersionString()
  {
    return bbdh.c();
  }
  
  public String getSoPath()
  {
    return null;
  }
  
  public boolean isDebugVersion()
  {
    return false;
  }
  
  public boolean jump2PublicAccount(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(paramContext, ChatActivity.class));
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 1008);
    localIntent.putExtra("chat_subType", 2);
    localIntent.putExtra("uinname", paramString2);
    localIntent.setFlags(67108864);
    return true;
  }
  
  public void log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      if (paramThrowable == null)
      {
        QLog.i(paramString1, 1, paramString2);
        return;
      }
      break;
    case 2: 
      if (paramThrowable == null)
      {
        QLog.d(paramString1, 1, paramString2);
        return;
      }
      QLog.d(paramString1, 1, paramString2, paramThrowable);
      return;
    case 4: 
      if (paramThrowable == null)
      {
        QLog.w(paramString1, 1, paramString2);
        return;
      }
      QLog.w(paramString1, 1, paramString2, paramThrowable);
      return;
    case 5: 
      if (paramThrowable == null)
      {
        QLog.e(paramString1, 1, paramString2);
        return;
      }
      QLog.e(paramString1, 1, paramString2, paramThrowable);
      return;
    }
    QLog.i(paramString1, 1, paramString2, paramThrowable);
  }
  
  public void notifyMiniAppInfo(MiniAppInfo paramMiniAppInfo) {}
  
  public boolean onCapsuleButtonCloseClick(besz parambesz)
  {
    return true;
  }
  
  public boolean onCapsuleButtonMoreClick(besz parambesz)
  {
    betc.a("MiniAppProxyImpl", "onCapsuleButtonMoreClick");
    if (parambesz == null)
    {
      betc.c("MiniAppProxyImpl", "miniRuntime is null, no need to response more button");
      return false;
    }
    Object localObject = parambesz.a();
    if ((localObject == null) || (((Activity)localObject).isFinishing()))
    {
      betc.c("MiniAppProxyImpl", "Activity is not exiting, no need to response more button");
      return false;
    }
    localObject = parambesz.a();
    if (localObject == null)
    {
      betc.c("MiniAppProxyImpl", "MiniAppInfo is null, no need to response more button");
      return false;
    }
    besl localbesl = parambesz.a();
    if (((MiniAppInfo)localObject).verType != 3)
    {
      localbesl.b = true;
      localbesl.c = true;
    }
    if (bema.a("MiniApp", "mini_app_share_to_wx_switcher", 1) != 1)
    {
      localbesl.f = false;
      localbesl.g = false;
    }
    showShareView(parambesz);
    return true;
  }
  
  public boolean openChoosePhotoActivity(Activity paramActivity, int paramInt, MiniAppProxy.IChoosePhotoListner paramIChoosePhotoListner)
  {
    paramIChoosePhotoListner = new Intent(paramActivity, NewPhotoListActivity.class);
    paramIChoosePhotoListner.putExtra("enter_from", 4);
    paramIChoosePhotoListner.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
    paramIChoosePhotoListner.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    paramIChoosePhotoListner.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 6);
    paramIChoosePhotoListner.putExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME", "micro_api_choose_image");
    paramIChoosePhotoListner.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    paramActivity.startActivity(paramIChoosePhotoListner);
    bbbx.a(paramActivity, false, true);
    return true;
  }
  
  public boolean openImagePreview(Activity paramActivity, int paramInt, List<String> paramList)
  {
    Intent localIntent = new Intent(paramActivity, TroopAvatarWallPreviewActivity.class);
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
    paramActivity.startActivity(localIntent);
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
  
  public boolean openPermissionSettingsActivity(Activity paramActivity, String paramString1, String paramString2)
  {
    PermissionSettingFragment.launchForResult(paramActivity, paramString1, paramString2, 5);
    return true;
  }
  
  public boolean openRobotProfileCard(Context paramContext, String paramString1, String paramString2)
  {
    bail.a(paramContext, paramString1, paramString2);
    return true;
  }
  
  public boolean openSchema(Activity paramActivity, String paramString, ResultReceiver paramResultReceiver)
  {
    if (paramActivity != null)
    {
      Intent localIntent = new Intent(paramActivity, AppBrandLaunchUI.class);
      localIntent.putExtra("from", "SchemeJsPlugin");
      localIntent.putExtra("scheme", paramString);
      localIntent.putExtra("result_receiver", paramResultReceiver);
      paramActivity.startActivity(localIntent);
    }
    return true;
  }
  
  public void sendData(byte[] paramArrayOfByte, MiniAppProxy.SenderListener paramSenderListener) {}
  
  public void setEnableDebug(String paramString, boolean paramBoolean)
  {
    bfhm.a().edit().putBoolean(paramString + "_debug", paramBoolean).apply();
  }
  
  public void showShareView(besz parambesz)
  {
    this.miniRuntime = parambesz;
    this.mHandler.sendEmptyMessageDelayed(1000, 500L);
    MiniAppInfo localMiniAppInfo = parambesz.a();
    int i = 3;
    parambesz = null;
    if (localMiniAppInfo != null)
    {
      i = localMiniAppInfo.verType;
      parambesz = localMiniAppInfo.appId;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", parambesz);
    localBundle.putInt("verType", i);
    QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "query_mini_app_data", localBundle, new MiniAppProxyImpl.5(this, localMiniAppInfo));
  }
  
  public boolean startAddFriendActivity(Context paramContext, String paramString1, String paramString2)
  {
    AddFriendLogicActivity.a = paramString1;
    paramContext.startActivity(AddFriendLogicActivity.a(paramContext, 3, paramString2, paramString1, 3024, Integer.parseInt(paramString1), null, null, null, "", null));
    return true;
  }
  
  public boolean startBrowserActivity(Activity paramActivity, Intent paramIntent)
  {
    paramIntent.setComponent(new ComponentName(paramActivity, QQBrowserActivity.class));
    paramActivity.startActivity(paramIntent);
    return true;
  }
  
  public boolean startBrowserActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    paramIntent.setComponent(new ComponentName(paramActivity, QQBrowserActivity.class));
    paramActivity.startActivityForResult(paramIntent, paramInt);
    return true;
  }
  
  public boolean tianshuReport(TianShuAccess.AdItem paramAdItem, String paramString, int paramInt)
  {
    biam.a().a(newTianShuReportData(paramAdItem, paramString, paramInt));
    return true;
  }
  
  public boolean tianshuRequestAdv(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, AsyncResult paramAsyncResult)
  {
    paramContext = new biak();
    paramContext.jdField_a_of_type_Int = paramInt2;
    paramContext.b = paramInt3;
    biam.a().a(Collections.singletonList(paramContext), new MiniAppProxyImpl.11(this, paramAsyncResult));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl
 * JD-Core Version:    0.7.0.1
 */