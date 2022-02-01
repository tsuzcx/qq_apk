package com.tencent.qqmini.sdk.core.proxy.service;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.R.drawable;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.core.manager.HttpServer;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.IAppUpdateListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.IChoosePhotoListner;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.IDrawableLoadedCallBack;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.SenderListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppState;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.ui.MoreItem;
import com.tencent.qqmini.sdk.launcher.ui.MoreItemList.Builder;
import com.tencent.qqmini.sdk.launcher.ui.OnAppCloseAction;
import com.tencent.qqmini.sdk.launcher.ui.OnMoreItemSelectedListener;
import com.tencent.qqmini.sdk.ui.DefaultMoreItemSelectedListener;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

@ProxyService(proxy=MiniAppProxy.class)
public class MiniAppProxyDefault
  extends MiniAppProxy
{
  private static final String TAG = "MiniAppProxyDefault";
  
  public boolean VerifyFile(int paramInt, String paramString)
  {
    return true;
  }
  
  public boolean addShortcut(Context paramContext, MiniAppInfo paramMiniAppInfo, AsyncResult paramAsyncResult)
  {
    return false;
  }
  
  public boolean chooseLocation(Context paramContext, AsyncResult paramAsyncResult)
  {
    return false;
  }
  
  public boolean downloadApp(Context paramContext, MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return false;
  }
  
  public boolean enterQRCode(Context paramContext, boolean paramBoolean, AsyncResult paramAsyncResult)
  {
    return false;
  }
  
  public String getA2()
  {
    return "";
  }
  
  public String getAccount()
  {
    return "10000";
  }
  
  public String getAmsAppId()
  {
    return "";
  }
  
  public String getAppId()
  {
    return "";
  }
  
  public String getAppName()
  {
    return "sdk";
  }
  
  public void getAppUpdate(Activity paramActivity, MiniAppProxy.IAppUpdateListener paramIAppUpdateListener)
  {
    if (paramIAppUpdateListener != null) {
      paramIAppUpdateListener.onGetAppUpdateResult(false, "更新失败");
    }
  }
  
  public String getAppVersion()
  {
    return "8.0.5";
  }
  
  public Drawable getDrawable(Context paramContext, String paramString, int paramInt1, int paramInt2, Drawable paramDrawable)
  {
    return null;
  }
  
  public String getImei()
  {
    return "123";
  }
  
  public String getLocation(Context paramContext)
  {
    try
    {
      paramContext = (LocationManager)paramContext.getSystemService("location");
      Object localObject = new Criteria();
      ((Criteria)localObject).setCostAllowed(false);
      ((Criteria)localObject).setAccuracy(2);
      localObject = paramContext.getBestProvider((Criteria)localObject, true);
      if (localObject != null)
      {
        paramContext = paramContext.getLastKnownLocation((String)localObject);
        if (paramContext == null) {
          return "";
        }
        double d1 = paramContext.getLatitude();
        double d2 = paramContext.getLongitude();
        paramContext = d1 + "*" + d2;
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      QMLog.e("getLocation", "getLocation>>>", paramContext);
    }
    return "";
  }
  
  public boolean getLocation(Context paramContext, String paramString, boolean paramBoolean, AsyncResult paramAsyncResult)
  {
    return false;
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
    return new DefaultMoreItemSelectedListener();
  }
  
  public ArrayList<MoreItem> getMoreItems(MoreItemList.Builder paramBuilder)
  {
    paramBuilder.addShareQQ("QQ", R.drawable.mini_sdk_channel_qq).addShareQzone("QQ空间", R.drawable.mini_sdk_channel_qzone).addShareWxFriends("微信好友", R.drawable.mini_sdk_channel_wx_friend).addShareWxMoments("微信朋友圈", R.drawable.mini_sdk_channel_wx_moment).addAbout("关于", R.drawable.mini_sdk_about).addComplaint("举报", R.drawable.mini_sdk_browser_report).addDebug("调试", R.drawable.mini_sdk_about).addMonitor("性能", R.drawable.mini_sdk_about);
    return paramBuilder.build();
  }
  
  public String getNickName()
  {
    return null;
  }
  
  public String getPayAccessToken()
  {
    return "ABC";
  }
  
  public int getPayMode()
  {
    int i = 2;
    int j = 1;
    if ((QUAUtil.isAlienApp()) || (QUAUtil.isMicroApp()) || (QUAUtil.isQQApp())) {
      if (WnsConfig.getConfig("qqminiapp", "mini_game_pay_by_h5", 0) != 0) {}
    }
    do
    {
      for (;;)
      {
        return i;
        i = 1;
      }
      i = j;
    } while (WnsConfig.getConfig("qqminiapp", "mini_game_pay_by_h5", 1) == 1);
    return 2;
  }
  
  public String getPayOpenId()
  {
    return "123";
  }
  
  public String getPayOpenKey()
  {
    return "ABC";
  }
  
  public String getPlatformId()
  {
    return "16";
  }
  
  public String getPlatformQUA()
  {
    return "";
  }
  
  public String getSoPath()
  {
    return null;
  }
  
  public int getTbsVersion()
  {
    return 1;
  }
  
  public boolean isDebugVersion()
  {
    return true;
  }
  
  public void muteAudioFocus(Context paramContext, boolean paramBoolean) {}
  
  public void notifyMiniAppInfo(int paramInt, MiniAppInfo paramMiniAppInfo) {}
  
  public OnAppCloseAction onAppClose(MiniAppInfo paramMiniAppInfo, Closeable paramCloseable)
  {
    return null;
  }
  
  public void onAppStateChange(MiniAppInfo paramMiniAppInfo, @AppState int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QMLog.e("MiniAppProxyDefault", paramMiniAppInfo.name + "," + paramMiniAppInfo.appId + ",unknown AppState " + paramInt);
      return;
    }
    QMLog.d("MiniAppProxyDefault", paramMiniAppInfo.name + "," + paramMiniAppInfo.appId + ",onAppStateChange " + paramInt);
  }
  
  public boolean onCapsuleButtonCloseClick(IMiniAppContext paramIMiniAppContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    return false;
  }
  
  public boolean onCapsuleButtonMoreClick(IMiniAppContext paramIMiniAppContext)
  {
    QMLog.d("MiniAppProxyDefault", "onCapsuleButtonMoreClick");
    return true;
  }
  
  public boolean openChoosePhotoActivity(Context paramContext, int paramInt, MiniAppProxy.IChoosePhotoListner paramIChoosePhotoListner)
  {
    return false;
  }
  
  public boolean openImagePreview(Context paramContext, int paramInt, List<String> paramList)
  {
    return false;
  }
  
  public boolean openLocation(Context paramContext, double paramDouble1, double paramDouble2, int paramInt, String paramString1, String paramString2)
  {
    return false;
  }
  
  public boolean openNativePage(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return false;
  }
  
  public boolean openSchema(Context paramContext, String paramString, int paramInt, ResultReceiver paramResultReceiver)
  {
    return false;
  }
  
  public void sendData(byte[] paramArrayOfByte, MiniAppProxy.SenderListener paramSenderListener)
  {
    HttpServer.sendData(paramArrayOfByte, paramSenderListener);
  }
  
  public void sendRequestByMsf(byte[] paramArrayOfByte, String paramString, MiniAppProxy.SenderListener paramSenderListener)
  {
    HttpServer.sendData(paramArrayOfByte, paramSenderListener);
  }
  
  public void setDrawableCallback(Drawable paramDrawable, MiniAppProxy.IDrawableLoadedCallBack paramIDrawableLoadedCallBack) {}
  
  public boolean startBrowserActivity(Context paramContext, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.MiniAppProxyDefault
 * JD-Core Version:    0.7.0.1
 */