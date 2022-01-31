package com.tencent.qqmini.proxyimpl;

import Wallet.FocusMpIdReq;
import agkg;
import ahbv;
import ajjy;
import alrv;
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
import android.text.TextUtils;
import azgu;
import baaf;
import bati;
import bcau;
import bdcz;
import bdel;
import bdfr;
import bdgb;
import bdhg;
import bdnw;
import bdrf;
import bdzf;
import bfpj;
import bfpk;
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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.mini.mainpage.MainPageFragment;
import com.tencent.mobileqq.mini.out.activity.MapActivity;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.request.Ticket;

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
  private Handler mHandler = new Handler(Looper.getMainLooper(), new MiniAppProxyImpl.2(this));
  private bdcz miniAppContext;
  private BroadcastReceiver scanResultReceiver;
  
  private void reportClick(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
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
    i = bati.a();
    QLog.i("MiniAppProxyImpl", 1, "shouldShowKingCardTip， king card status = " + i);
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private void startReportPage(bdcz parambdcz)
  {
    MiniAppInfo localMiniAppInfo = parambdcz.a();
    Activity localActivity = parambdcz.a();
    if ((localMiniAppInfo != null) && (localActivity != null)) {
      parambdcz = "";
    }
    try
    {
      localObject = URLEncoder.encode("https://support.qq.com/data/1368/2018/0927/5e6c84b68d1f3ad390e7beeb6c2f83b0.jpeg", "UTF-8");
      parambdcz = (bdcz)localObject;
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
    localObject = "https://tucao.qq.com/qq_miniprogram/tucao?appid=" + localMiniAppInfo.appId + "&openid=" + MainPageFragment.getUin() + "&avatar=" + parambdcz + ajjy.a(2131635557);
    parambdcz = new Intent(localActivity, QQBrowserActivity.class);
    parambdcz.putExtra("url", (String)localObject);
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("hide_more_button", true);
    parambdcz.putExtras((Bundle)localObject);
    localActivity.startActivity(parambdcz);
  }
  
  public boolean addPublicAccount(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    agkg.a(new FocusMpIdReq(paramString1, paramString2), new MiniAppProxyImpl.8(this, paramAsyncResult));
    return true;
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
    bdel.a().a(new MiniAppProxyImpl.11(this, paramAsyncResult));
    paramAsyncResult = new Intent(paramContext, MapActivity.class);
    paramAsyncResult.putExtra("key_type", 2);
    ((BaseActivity)paramContext).startActivityForResult(paramAsyncResult, 3);
    return true;
  }
  
  public void doShowShareView()
  {
    if (this.miniAppContext == null) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = this.miniAppContext.a();
    } while ((!(localActivity instanceof GameActivity1)) || (this.isMiniMsgTabShow));
    Object localObject = ((GameActivity1)localActivity).getColorNoteController();
    boolean bool;
    int i;
    if (localObject != null)
    {
      bool = ((alrv)localObject).a();
      if (bool) {
        if (((alrv)localObject).c())
        {
          i = 2;
          QLog.d("MiniAppProxyImpl", 1, "handleMoreClick, shouldDisplayColorNote : " + bool);
        }
      }
    }
    for (;;)
    {
      localObject = this.miniAppContext.a();
      bdgb localbdgb = (bdgb)this.miniAppContext.a(bdfr.a());
      Intent localIntent = new Intent();
      localIntent.putExtra("miniAppID", ((MiniAppInfo)localObject).appId);
      localIntent.putExtra("miniAppName", ((MiniAppInfo)localObject).name);
      localIntent.putExtra("isOpenMonitorPanel", isMonitorPanelShowing);
      localIntent.putExtra("debugEnable", getEnableDebug(((MiniAppInfo)localObject).appId));
      localIntent.putExtra("showDebug", localbdgb.b);
      localIntent.putExtra("showMonitor", localbdgb.c);
      localIntent.putExtra("menuStyle", MiniAppEnv.g().getMenuStyle());
      localIntent.putExtra("showShareQQ", localbdgb.e);
      localIntent.putExtra("showShareQzone", localbdgb.d);
      localIntent.putExtra("showShareWeChatFriends", localbdgb.f);
      localIntent.putExtra("showShareWeChatMoment", localbdgb.g);
      localIntent.putExtra("topType", ((MiniAppInfo)localObject).topType);
      localIntent.putExtra("showDetail", true);
      localIntent.putExtra("showComplaint", true);
      if (Build.VERSION.SDK_INT >= 21) {}
      for (bool = true;; bool = false)
      {
        localIntent.putExtra("addShortcut", bool);
        localIntent.putExtra("showBackHome", -1);
        localIntent.putExtra("isLandscape", localbdgb.a);
        localIntent.putExtra("isSpecialMiniApp", false);
        localIntent.putExtra("showKingcardTip", shouldShowKingCardTip((MiniAppInfo)localObject));
        localIntent.putExtra("key_mini_msgtab_type", 1);
        localIntent.putExtra("key_mini_msgtab_need_action_sheet", this.miniAppContext.e());
        localIntent.putExtra("key_mini_app_version_type", 1);
        localIntent.putExtra("key_mini_app_config", MiniSdkUtil.convertSDK2QQConfig((MiniAppInfo)localObject));
        localIntent.putExtra("key_mini_app_is_game", true);
        localIntent.putExtra("key_color_note", i);
        bdel.a().a(new MiniAppProxyImpl.6(this));
        MiniChatActivity.a(localActivity, localIntent, 9527);
        bdnw.a("MiniAppProxyImpl", "set isMiniMsgTabShow true");
        this.isMiniMsgTabShow = true;
        return;
        i = 1;
        break;
      }
      i = 0;
      break;
      i = 0;
    }
  }
  
  public boolean enterQRCode(Context paramContext, boolean paramBoolean, AsyncResult paramAsyncResult)
  {
    BaseActivity localBaseActivity = (BaseActivity)paramContext;
    if (!ahbv.a(localBaseActivity))
    {
      paramAsyncResult.onReceiveResult(false, null);
      return true;
    }
    paramContext = new Intent((BaseActivity)paramContext, ScannerActivity.class);
    paramContext.putExtra("leftViewText", localBaseActivity.getString(2131625011));
    paramContext.putExtra("selfSet_leftViewText", localBaseActivity.getString(2131625011));
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
  
  public String getAppName()
  {
    return "qq";
  }
  
  public String getAppVersion()
  {
    return "8.2.6.4370";
  }
  
  public Class getBrowserClass()
  {
    return QQBrowserActivity.class;
  }
  
  public String getDeviceInfo()
  {
    return bfpj.a().c();
  }
  
  public Drawable getDrawable(Context paramContext, String paramString, int paramInt1, int paramInt2, Drawable paramDrawable)
  {
    paramContext = URLDrawable.URLDrawableOptions.obtain();
    paramContext.mPlayGifImage = true;
    paramContext.mRequestWidth = paramInt1;
    paramContext.mRequestHeight = paramInt2;
    paramContext.mFailedDrawable = paramDrawable;
    paramContext.mLoadingDrawable = paramDrawable;
    if (bdrf.a(paramString)) {
      return URLDrawable.getDrawable(paramString, paramContext);
    }
    return URLDrawable.getFileDrawable(paramString, paramContext);
  }
  
  public boolean getEnableDebug(String paramString)
  {
    return bdzf.a().getBoolean(paramString + "_debug", false);
  }
  
  public boolean getLocation(String paramString, boolean paramBoolean, AsyncResult paramAsyncResult)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("wgs84"))) {}
    for (boolean bool = true;; bool = false)
    {
      SosoInterface.a(new MiniAppProxyImpl.10(this, 0, true, true, 5000L, false, false, "miniApp", bool, paramBoolean, paramAsyncResult));
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
    return bfpk.a();
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
  
  public void onCapsuleButtonMoreClick(bdcz parambdcz)
  {
    bdnw.a("MiniAppProxyImpl", "onCapsuleButtonMoreClick");
    Object localObject = parambdcz.a();
    if ((localObject == null) || (((Activity)localObject).isFinishing()))
    {
      bdnw.c("MiniAppProxyImpl", "Activity is not exiting, no need to response more button");
      return;
    }
    localObject = parambdcz.a();
    if (localObject == null)
    {
      bdnw.c("MiniAppProxyImpl", "MiniAppInfo is null, no need to response more button");
      return;
    }
    bdgb localbdgb = (bdgb)parambdcz.a(bdfr.a());
    if (((MiniAppInfo)localObject).verType != 3)
    {
      localbdgb.b = true;
      localbdgb.c = true;
    }
    if (bdhg.a("MiniApp", "mini_app_share_to_wx_switcher", 1) != 1)
    {
      localbdgb.f = false;
      localbdgb.g = false;
    }
    localbdgb.a = parambdcz.f();
    showShareView(parambdcz);
  }
  
  public boolean openAppDetailPage(Context paramContext, String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("packageName", paramString2);
    localBundle.putString("appId", paramString1);
    localBundle.putString("big_brother_source_key", "biz_src_miniapp");
    if ((paramContext instanceof BasePluginActivity)) {
      bcau.b(((BasePluginActivity)paramContext).getOutActivity(), localBundle);
    }
    for (;;)
    {
      return true;
      if ((paramContext instanceof Activity)) {
        bcau.b((Activity)paramContext, localBundle);
      } else {
        QLog.e("MiniAppProxyImpl", 2, "onOpenThridApp mContext 必现是一个Activity");
      }
    }
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
    baaf.a(paramActivity, false, true);
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
  
  public boolean openRobotProfileCard(Context paramContext, String paramString1, String paramString2)
  {
    azgu.a(paramContext, paramString1, paramString2);
    return true;
  }
  
  public void reportApiInvoke(MiniAppInfo paramMiniAppInfo, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new MiniAppProxyImpl.9(this, paramString, paramMiniAppInfo));
  }
  
  public void sendData(byte[] paramArrayOfByte, MiniAppProxy.SenderListener paramSenderListener) {}
  
  public void setEnableDebug(String paramString, boolean paramBoolean)
  {
    bdzf.a().edit().putBoolean(paramString + "_debug", paramBoolean).apply();
  }
  
  public void showShareView(bdcz parambdcz)
  {
    this.miniAppContext = parambdcz;
    this.mHandler.sendEmptyMessageDelayed(1000, 500L);
    MiniAppInfo localMiniAppInfo = parambdcz.a();
    int i = 3;
    parambdcz = null;
    if (localMiniAppInfo != null)
    {
      i = localMiniAppInfo.verType;
      parambdcz = localMiniAppInfo.appId;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", parambdcz);
    localBundle.putInt("verType", i);
    QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "query_mini_app_data", localBundle, new MiniAppProxyImpl.5(this, localMiniAppInfo));
  }
  
  public boolean startAddFriendActivity(Context paramContext, String paramString1, String paramString2)
  {
    AddFriendLogicActivity.a = paramString1;
    paramContext.startActivity(AddFriendLogicActivity.a(paramContext, 3, paramString2, paramString1, 3024, Integer.parseInt(paramString1), null, null, null, "", null));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl
 * JD-Core Version:    0.7.0.1
 */