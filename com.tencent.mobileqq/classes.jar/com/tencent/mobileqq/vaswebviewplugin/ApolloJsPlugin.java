package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.OnApolloViewListener;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.DefaultGameCheckListener;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.store.ApolloFloatActivity;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader;
import com.tencent.mobileqq.apollo.store.ApolloViewController;
import com.tencent.mobileqq.apollo.store.ApolloViewController.PlayActionData;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.mobileqq.apollo.store.IApolloActivityJsCallBack;
import com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor;
import com.tencent.mobileqq.apollo.store.webview.ApolloWebDataHandler;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel.GameMsgInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloJsPlugin
  extends VasWebviewJsPlugin
  implements OnApolloViewListener
{
  public static final String BUSINESS_NAME = "apollo";
  private static final int DEFAULT_HEIGHT = (int)(DeviceInfoUtil.m() * 0.4D / DeviceInfoUtil.a());
  private static final int DEFAULT_WIDTH = (int)((float)(DeviceInfoUtil.l() >> 1) / DeviceInfoUtil.a());
  private static final String FAKE_CALLBACK_ID = "FAKE_CALLBACK_ID";
  public static final int INITFROM_GETLOCALINFO = 3;
  public static final int INITFROM_GETROLE = 2;
  public static final int INITFROM_GETSWITCH = 4;
  public static final String TAG = "ApolloJsPlugin";
  private static final int TYPE_FROM_SHOW_APOLLOVIEW = 10000;
  private static ApolloJsPlugin.ApolloReceiver sApolloReceiver = new ApolloJsPlugin.ApolloReceiver(null);
  public static int sResponseKey;
  private static int sRoleGender;
  private boolean alreadyCallBack;
  private QQCustomDialog gameDialog;
  public int mAISwitch;
  private int mApolloStatus;
  private ApolloViewController mApolloViewContoller;
  private CmGameStartChecker mCmGameStartChecker;
  private CmGameStartChecker.DefaultGameCheckListener mCmGameStartCheckerListener;
  private String mCurrentUin;
  private boolean mDataInited;
  private int[] mDressIds;
  private int mGender;
  public boolean mHasInited;
  protected ApolloUrlInterceptor mInterceptor;
  public boolean mIsAIRole;
  private long mLastGameTime;
  private boolean mNeedCreateInterceptor;
  public Bundle mReqBundle;
  private int mRoleId = -1;
  private String mTab;
  private Vector mValidAvatarIdList = new Vector();
  
  public ApolloJsPlugin()
  {
    this.mPluginNameSpace = "apollo";
    if (QLog.isColorLevel()) {
      QLog.d("ApolloJsPlugin", 2, "apollo_client onApolloJsCreate");
    }
    ApolloEngine.a();
  }
  
  public ApolloJsPlugin(String paramString)
  {
    this.mPluginNameSpace = "apollo";
    if (ApolloWebDataHandler.a())
    {
      this.mNeedCreateInterceptor = false;
      this.mInterceptor = ApolloUrlInterceptor.a(true, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, "apollo_client onApolloJsCreate ApolloWebDataHandler.isInstanceCreated():true");
      }
    }
    for (;;)
    {
      ApolloEngine.a();
      return;
      this.mNeedCreateInterceptor = true;
      ThreadManager.postImmediately(new ApolloJsPlugin.1(this, paramString), null, true);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, "apollo_client onApolloJsCreate ApolloWebDataHandler.isInstanceCreated():false");
      }
    }
  }
  
  private void callBackDownloadGamePercent(int paramInt)
  {
    ThreadManager.getUIHandler().post(new ApolloJsPlugin.8(this, paramInt));
  }
  
  void callbackError(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 1);
      localJSONObject.put("msg", paramString2);
      super.callJs(paramString1 + "(" + localJSONObject.toString() + ");");
      if (QLog.isColorLevel()) {
        QLog.e("ApolloJsPlugin", 2, "callbackId->" + paramString1 + " errorMsg: " + paramString2);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ApolloJsPlugin", 2, localException.getMessage());
        }
      }
    }
  }
  
  void callbackOk(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 0);
      localJSONObject.put("msg", "");
      super.callJs(paramString + "(" + localJSONObject.toString() + ");");
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, "callbackId->" + paramString + " callbackOk" + localJSONObject.toString());
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ApolloJsPlugin", 2, paramString.getMessage());
    }
  }
  
  boolean checkSdcard(Context paramContext)
  {
    if (!"mounted".equals(Environment.getExternalStorageState()))
    {
      QQToast.a(paramContext, "请安装存储卡后再使用", 0).a();
      return false;
    }
    return true;
  }
  
  public ApolloUrlInterceptor getIntercepter()
  {
    return this.mInterceptor;
  }
  
  public int getRemoteKey()
  {
    return this.mOnRemoteResp.key;
  }
  
  protected Object handleEvent(String paramString, long paramLong)
  {
    if (paramLong == 8L) {
      try
      {
        if (this.mInterceptor != null)
        {
          Object localObject = this.mInterceptor.a(paramString);
          if (localObject != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloJsPlugin", 1, "apollo_client handleEvent response-> " + localObject + ",url:" + paramString);
            }
            return localObject;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("ApolloJsPlugin", 1, "handleEvent intercept by apolloClient error -> " + localException.getMessage());
      }
    }
    return super.handleEvent(paramString, paramLong);
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (32L == paramLong)
    {
      if ((this.mNeedCreateInterceptor) && (this.mInterceptor == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloJsPlugin", 1, "apollo_client handleEvent reinited ApolloUrlInterceptor,url:" + paramString);
        }
        this.mInterceptor = ApolloUrlInterceptor.a(true, paramString);
        this.mNeedCreateInterceptor = false;
      }
      if (this.mInterceptor != null)
      {
        this.mInterceptor.a(this.mRuntime.a());
        return this.mInterceptor.b(paramString);
      }
    }
    else if ((8589934597L == paramLong) && (this.mApolloViewContoller != null))
    {
      this.mApolloViewContoller.c();
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"apollo".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    if (!this.mHasInited)
    {
      this.mHasInited = true;
      this.mReqBundle.clear();
      this.mReqBundle.putInt("apollo_initFrom", 3);
      super.sendRemoteReq(DataFactory.a("ipc_apollo_get_apollo_data", "FAKE_CALLBACK_ID", this.mOnRemoteResp.key, this.mReqBundle), false, true);
    }
    paramString2 = null;
    try
    {
      localObject = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (localObject == null) {
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, "handleJsRequest JSON = " + ((JSONObject)localObject).toString());
      }
      paramString1 = ((JSONObject)localObject).optString("callback");
      if (paramString1 != null) {
        break label288;
      }
      try
      {
        throw new Exception("need callbackId");
      }
      catch (Throwable paramJsBridgeListener) {}
    }
    catch (Throwable paramJsBridgeListener)
    {
      for (;;)
      {
        Object localObject;
        int k;
        boolean bool2;
        paramString1 = paramString2;
        continue;
        continue;
        int j = 0;
        continue;
        do
        {
          i = 0;
          break label3111;
          paramJsBridgeListener = null;
          bool2 = bool1;
          continue;
          break label792;
          i += 1;
          break;
          i += 1;
          bool1 = bool2;
          break label2338;
          paramJsBridgeListener = null;
          break label2049;
          bool1 = false;
          break label2067;
          i += 1;
          bool1 = bool2;
          break label3014;
        } while (bool2);
        int i = 1;
        continue;
        k += 1;
        boolean bool1 = bool2;
        continue;
        j += 1;
        continue;
        i = 1;
        continue;
        i = 2;
        continue;
        for (;;)
        {
          j += 1;
          break;
          i = 0;
        }
        i = 2;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        if (bool1)
        {
          i = 1;
        }
        else
        {
          i = 0;
          continue;
          i = 0;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener.printStackTrace();
      QLog.e("ApolloJsPlugin", 2, paramJsBridgeListener.getMessage());
    }
    try
    {
      paramString2 = new JSONObject();
      paramString2.put("result", 1);
      paramString2.put("msg", paramJsBridgeListener.getMessage());
      super.callJs(paramString1 + "(" + paramString2.toString() + ");");
      label2049:
      label2067:
      for (;;)
      {
        return true;
        label288:
        if (QLog.isColorLevel()) {
          QLog.d("ApolloJsPlugin", 2, "json:" + localObject);
        }
        paramVarArgs = this.mRuntime.a();
        if ((paramVarArgs == null) || (this.isDestroy) || (paramVarArgs.isFinishing()))
        {
          callbackError(paramString1, "当前页面已经销毁或非商城页面");
          return true;
        }
        label792:
        label2338:
        label3111:
        if ("isApolloEngineReady".equals(paramString3))
        {
          if (ApolloEngine.a()) {
            callbackOk(paramString1);
          }
          for (;;)
          {
            if (!QLog.isColorLevel()) {
              break label425;
            }
            QLog.d("ApolloJsPlugin", 2, new Object[] { "isApolloEngineReady:", Boolean.valueOf(ApolloEngine.a()) });
            break;
            callbackError(paramString1, "ApolloEngine is not ready");
          }
        }
        else
        {
          label425:
          if ("clearThunderCache".equals(paramString3))
          {
            paramJsBridgeListener = new File(ApolloConstant.jdField_a_of_type_JavaLangString + "/webview/");
            if (paramJsBridgeListener.exists())
            {
              paramJsBridgeListener = paramJsBridgeListener.listFiles();
              if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length > 0))
              {
                j = paramJsBridgeListener.length;
                i = 0;
                if (i < j)
                {
                  paramString2 = paramJsBridgeListener[i];
                  if ((!paramString2.isDirectory()) || (!new File(paramString2, paramString2.getName() + ".txt").exists())) {
                    break label8257;
                  }
                  FileUtils.a(paramString2.getAbsolutePath());
                  if (!QLog.isColorLevel()) {
                    break label8257;
                  }
                  QLog.d("ApolloJsPlugin", 2, "clearThunderCache, htmlFileDir:" + paramString2.getName());
                  break label8257;
                }
              }
            }
            callbackOk(paramString1);
          }
          else if ("stopThunderCache".equals(paramString3))
          {
            ApolloWebDataHandler.a().b();
            callbackOk(paramString1);
          }
          else if ("resumeThunderCache".equals(paramString3))
          {
            ApolloWebDataHandler.a().c();
            callbackOk(paramString1);
          }
          else
          {
            long l;
            String str;
            if ("startApolloGame".equals(paramString3))
            {
              l = System.currentTimeMillis();
              if (l - this.mLastGameTime <= 1000L)
              {
                callbackError(paramString1, "游戏启动中");
                return true;
              }
              this.mLastGameTime = l;
              j = ((JSONObject)localObject).optInt("gameId");
              i = 1;
              if (((JSONObject)localObject).has("gameMode")) {
                i = ((JSONObject)localObject).optInt("gameMode");
              }
              k = ((JSONObject)localObject).optInt("src");
              paramString3 = ((JSONObject)localObject).optString("gameParam");
              paramString2 = ((JSONObject)localObject).optString("friendUin");
              paramJsBridgeListener = ((JSONObject)localObject).optString("friendOpenId");
              bool1 = ((JSONObject)localObject).optBoolean("isEnterAIO");
              if (!TextUtils.isEmpty(paramJsBridgeListener)) {
                break label8254;
              }
              paramJsBridgeListener = paramString2;
              str = ((JSONObject)localObject).optString("uinName");
              if ((paramVarArgs != null) && (!paramVarArgs.isFinishing()))
              {
                if (bool1)
                {
                  localObject = new Bundle();
                  ((Bundle)localObject).putString("uin", paramString2);
                  ((Bundle)localObject).putInt("uintype", 0);
                  ((Bundle)localObject).putString("troop_uin", "");
                  ((Bundle)localObject).putString("uinname", str);
                  ((Bundle)localObject).putBoolean("launchApolloGame", true);
                  ((Bundle)localObject).putInt("gameId", j);
                  ((Bundle)localObject).putInt("gameMode", i);
                  ((Bundle)localObject).putString("openId", paramJsBridgeListener);
                  ((Bundle)localObject).putString("gameParam", paramString3);
                  ((Bundle)localObject).putInt("src", k);
                  ((Bundle)localObject).putInt("enter", 3);
                  paramJsBridgeListener = AIOUtils.a(new Intent(paramVarArgs, SplashActivity.class), new int[] { 2 });
                  paramJsBridgeListener.putExtras((Bundle)localObject);
                  paramVarArgs.startActivity(paramJsBridgeListener);
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "[startApolloGame] openAIO:" + ((Bundle)localObject).toString());
                  }
                  callbackOk(paramString1);
                }
                else
                {
                  paramString2 = new CmGameStartChecker.StartCheckParam(j, true, "luanch", 0L, 4, i, 0, 0, "", k);
                  paramString2.mExtraStr = ((JSONObject)localObject).toString();
                  paramString2.extendJson = paramString3;
                  paramString2.mFriendUin = paramJsBridgeListener;
                  this.mReqBundle.clear();
                  this.mReqBundle.putSerializable("StartCheckParam", paramString2);
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_start_apollo_game", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                }
              }
              else {
                callbackError(paramString1, "启动游戏失败，当前页面已销毁");
              }
            }
            else
            {
              if ("checkGameStatus".equals(paramString3))
              {
                if (!FileUtils.a())
                {
                  callbackError(paramString1, "sdcard未装");
                  return true;
                }
                if (FileUtils.c() < 52428800.0F)
                {
                  callbackError(paramString1, "sdcard 磁盘空间不足");
                  return true;
                }
                i = ((JSONObject)localObject).optInt("gameId");
                this.mReqBundle.clear();
                this.mReqBundle.putInt("gameId", i);
                paramJsBridgeListener = DataFactory.a("IPC_APOLLO_DOWNLOAD_GAME", paramString1, this.mOnRemoteResp.key, this.mReqBundle);
                this.alreadyCallBack = false;
                super.sendRemoteReq(paramJsBridgeListener, false, true);
                return true;
              }
              if ("chooseFriendPlayGame".equals(paramString3))
              {
                i = ((JSONObject)localObject).optInt("gameId");
                paramJsBridgeListener = new ApolloPanel.GameMsgInfo();
                paramJsBridgeListener.e = i;
                ApolloGameBasicEventUtil.a(paramJsBridgeListener, this.mRuntime.a(), 2);
                return true;
              }
              if ("setBackViewVisibility".equals(paramString3))
              {
                i = ((JSONObject)localObject).optInt("visibility");
                if ((paramVarArgs instanceof IApolloActivityJsCallBack))
                {
                  ((IApolloActivityJsCallBack)paramVarArgs).d(i);
                  callbackOk(paramString1);
                }
                else
                {
                  callbackError(paramString1, "ApolloViewController not inited or not ApolloStoreActivity");
                }
              }
              else if ("openApolloShareFloatView".equals(paramString3))
              {
                paramString2 = ((JSONObject)localObject).optString("backgroundImage");
                paramString3 = ((JSONObject)localObject).optString("nickName");
                paramJsBridgeListener = null;
                if ((this.mRuntime.a() instanceof BaseActivity)) {
                  paramJsBridgeListener = ((BaseActivity)this.mRuntime.a()).getAppInterface();
                }
                if (this.mApolloViewContoller != null)
                {
                  this.mApolloViewContoller.a(paramVarArgs, paramJsBridgeListener, paramString2, paramString3);
                  callbackOk(paramString1);
                }
                else if ((paramVarArgs instanceof IApolloActivityJsCallBack))
                {
                  ((IApolloActivityJsCallBack)paramVarArgs).a(paramVarArgs, paramString2, paramString3);
                  callbackOk(paramString1);
                }
                else
                {
                  callbackError(paramString1, "ApolloViewController not inited or not ApolloStoreActivity");
                }
              }
              else if ("openDiyActionFloatView".equals(paramString3))
              {
                paramJsBridgeListener = ((JSONObject)localObject).optString("defaultText");
                if ((paramVarArgs instanceof IApolloActivityJsCallBack)) {
                  ((IApolloActivityJsCallBack)paramVarArgs).a(paramJsBridgeListener);
                } else {
                  callbackError(paramString1, "非商城界面");
                }
              }
              else if ("sayHi".equals(paramString3))
              {
                if ((paramVarArgs instanceof IApolloActivityJsCallBack))
                {
                  paramJsBridgeListener = ((IApolloActivityJsCallBack)paramVarArgs).a();
                  super.callJs(paramString1 + "(" + paramJsBridgeListener + ");");
                }
                else if (this.mApolloViewContoller != null)
                {
                  paramJsBridgeListener = this.mApolloViewContoller.a();
                  super.callJs(paramString1 + "(" + paramJsBridgeListener + ");");
                }
                else
                {
                  callbackError(paramString1, "ApolloViewController not inited or not ApolloStoreActivity");
                }
              }
              else if ("setCapsuleOpened".equals(paramString3))
              {
                paramJsBridgeListener = ((JSONObject)localObject).optString("uin");
                if (TextUtils.isEmpty(paramJsBridgeListener))
                {
                  callbackError(paramString1, "uin is empty");
                }
                else
                {
                  this.mReqBundle.clear();
                  this.mReqBundle.putString("apollo_uin", paramJsBridgeListener);
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_setcapsule", paramString1, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                }
              }
              else if ("openBox".equals(paramString3))
              {
                paramJsBridgeListener = ((JSONObject)localObject).optString("uin");
                if ((paramVarArgs instanceof IApolloActivityJsCallBack))
                {
                  paramJsBridgeListener = ((IApolloActivityJsCallBack)paramVarArgs).a(paramJsBridgeListener);
                  super.callJs(paramString1 + "(" + paramJsBridgeListener + ");");
                }
                else
                {
                  callbackError(paramString1, "非商城界面");
                }
              }
              else if ("setApolloViewVisibility".equals(paramString3))
              {
                i = ((JSONObject)localObject).optInt("visibility", 0);
                if ((paramVarArgs instanceof IApolloActivityJsCallBack))
                {
                  ((IApolloActivityJsCallBack)paramVarArgs).e(i);
                  callbackOk(paramString1);
                  return true;
                }
                if (this.mApolloViewContoller == null)
                {
                  callbackError(paramString1, "ApolloViewController is null");
                  return false;
                }
                this.mApolloViewContoller.b(i);
                callbackOk(paramString1);
              }
              else if ("initApolloView".equals(paramString3))
              {
                if (!ApolloEngine.a())
                {
                  callbackError(paramString1, "engine is not ready");
                  return false;
                }
                if ((this.mApolloViewContoller == null) && ((this.mRuntime.a().getParent() instanceof RelativeLayout)))
                {
                  this.mApolloViewContoller = new ApolloViewController((RelativeLayout)this.mRuntime.a().getParent(), null);
                  this.mApolloViewContoller.a(this);
                }
                if (this.mApolloViewContoller == null)
                {
                  callbackError(paramString1, "ApolloViewController is null");
                  return false;
                }
                i = ((JSONObject)localObject).optInt("disableTouch", 0);
                j = ((JSONObject)localObject).optInt("scrollByWebView", 0);
                if ((this.mRuntime.a() instanceof TouchWebView))
                {
                  paramString2 = (TouchWebView)this.mRuntime.a();
                  if (j <= 0) {
                    break label8279;
                  }
                  paramJsBridgeListener = this.mApolloViewContoller;
                  paramString2.setOnScrollChangedListener(paramJsBridgeListener);
                }
                paramJsBridgeListener = this.mApolloViewContoller;
                if (i <= 0) {
                  break label8284;
                }
                bool1 = true;
                paramJsBridgeListener.b(bool1);
                paramJsBridgeListener = new ApolloWebAvatarParam();
                paramJsBridgeListener.isMain = true;
                paramJsBridgeListener.apolloId = ((JSONObject)localObject).optString("apolloId", "me");
                paramJsBridgeListener.x = ((JSONObject)localObject).optInt("x", DEFAULT_WIDTH);
                paramJsBridgeListener.y = ((JSONObject)localObject).optInt("y", DEFAULT_HEIGHT);
                paramJsBridgeListener.uin = ((JSONObject)localObject).optString("uin");
                if (TextUtils.isEmpty(paramJsBridgeListener.uin)) {
                  paramJsBridgeListener.uin = this.mRuntime.a().getCurrentAccountUin();
                }
                paramJsBridgeListener.nickName = ((JSONObject)localObject).optString("nickName");
                paramJsBridgeListener.type = 0;
                paramJsBridgeListener.tab = "mall";
                paramJsBridgeListener.rate = ((float)((JSONObject)localObject).optDouble("rate", 0.0D));
                paramJsBridgeListener.roleId = ((JSONObject)localObject).optInt("roleId");
                paramString2 = ((JSONObject)localObject).optJSONArray("tapRect");
                if ((paramString2 != null) && (paramString2.length() >= 4))
                {
                  paramJsBridgeListener.tapRectX = paramString2.getInt(0);
                  paramJsBridgeListener.tapRectY = paramString2.getInt(1);
                  paramJsBridgeListener.tapRectWidth = paramString2.getInt(2);
                  paramJsBridgeListener.tapRectHeight = paramString2.getInt(3);
                }
                paramString2 = ((JSONObject)localObject).optJSONArray("dressIds");
                bool1 = false;
                if (paramJsBridgeListener.roleId > 0) {
                  bool1 = ApolloUtil.c(paramJsBridgeListener.roleId);
                }
                bool2 = bool1;
                if (paramString2 != null)
                {
                  bool2 = bool1;
                  if (paramString2.length() > 0)
                  {
                    j = paramString2.length();
                    paramJsBridgeListener.dressIds = new int[j];
                    i = 0;
                    bool2 = bool1;
                    if (i < j)
                    {
                      k = paramString2.getInt(i);
                      paramJsBridgeListener.dressIds[i] = k;
                      bool2 = bool1;
                      if (paramJsBridgeListener.roleId <= 0) {
                        break label8266;
                      }
                      bool2 = bool1;
                      if (!bool1) {
                        break label8266;
                      }
                      bool2 = ApolloUtil.b(k);
                      break label8266;
                    }
                  }
                }
                paramJsBridgeListener.isResExist = bool2;
                this.mValidAvatarIdList.clear();
                this.mValidAvatarIdList.add(paramJsBridgeListener.apolloId);
                if (!bool2)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "initApolloView, should request resource");
                  }
                  paramString2 = new ArrayList(1);
                  paramString2.add(paramJsBridgeListener);
                  this.mReqBundle.clear();
                  this.mReqBundle.putInt("from", 1);
                  this.mReqBundle.putSerializable("apolloList", paramString2);
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_check_avatar_res", paramString1, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                  this.mApolloViewContoller.a(true, paramJsBridgeListener.x, paramJsBridgeListener.y);
                }
                else
                {
                  paramJsBridgeListener = this.mApolloViewContoller.a(1, true, paramJsBridgeListener);
                  super.callJs(paramString1 + "(" + paramJsBridgeListener + ");");
                }
              }
              else if ("initAvatar".equals(paramString3))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloJsPlugin", 2, "initAvatar");
                }
                if (!IApolloActivityJsCallBack.class.isInstance(paramVarArgs))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "initAvatar, not ApolloStoreActivity");
                  }
                  if ((paramVarArgs instanceof BaseActivity))
                  {
                    paramJsBridgeListener = ((BaseActivity)paramVarArgs).getAppInterface();
                    ApolloUtil.a(paramVarArgs, null, "share", this.mRuntime.a().getUrl(), paramJsBridgeListener);
                  }
                  ThreadManager.getSubThreadHandler().postDelayed(new ApolloJsPlugin.2(this, paramVarArgs), 2000L);
                }
                paramString3 = new ApolloWebAvatarParam();
                paramString3.isMain = true;
                paramString3.apolloId = ((JSONObject)localObject).optString("apolloId", "me");
                paramString3.type = ((JSONObject)localObject).optInt("type");
                paramString3.x = ((JSONObject)localObject).optInt("x", DEFAULT_WIDTH);
                paramString3.y = ((JSONObject)localObject).optInt("y", DEFAULT_HEIGHT);
                this.mTab = ((JSONObject)localObject).optString("tab");
                paramString3.tab = this.mTab;
                paramString3.rate = ((float)((JSONObject)localObject).optDouble("rate", 0.0D));
                paramString3.uin = ((JSONObject)localObject).optString("uin");
                paramString3.nickName = ((JSONObject)localObject).optString("nickName");
                paramString3.greeting = ((JSONObject)localObject).optString("greeting");
                str = this.mRuntime.a().getCurrentAccountUin();
                if (TextUtils.isEmpty(paramString3.uin)) {
                  paramString3.uin = str;
                }
                this.mCurrentUin = paramString3.uin;
                paramString3.roleId = ((JSONObject)localObject).optInt("roleId");
                paramJsBridgeListener = ((JSONObject)localObject).optJSONArray("tapRect");
                if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length() >= 4))
                {
                  paramString3.tapRectX = paramJsBridgeListener.getInt(0);
                  paramString3.tapRectY = paramJsBridgeListener.getInt(1);
                  paramString3.tapRectWidth = paramJsBridgeListener.getInt(2);
                  paramString3.tapRectHeight = paramJsBridgeListener.getInt(3);
                }
                bool1 = false;
                if (paramString3.roleId > 0) {
                  bool1 = ApolloUtil.c(paramString3.roleId);
                }
                paramJsBridgeListener = ((JSONObject)localObject).optJSONArray("dressIds");
                l = ((JSONObject)localObject).optLong("avatarTs");
                if ((paramJsBridgeListener == null) || (paramJsBridgeListener.length() <= 0)) {
                  break label8245;
                }
                j = paramJsBridgeListener.length();
                paramString2 = new int[j];
                i = 0;
                label3014:
                if (i < j)
                {
                  paramString2[i] = paramJsBridgeListener.getInt(i);
                  bool2 = bool1;
                  if (paramString3.roleId <= 0) {
                    break label8290;
                  }
                  bool2 = bool1;
                  if (!bool1) {
                    break label8290;
                  }
                  bool2 = ApolloUtil.b(paramString2[i]);
                  break label8290;
                }
                paramString3.dressIds = paramString2;
                bool2 = bool1;
                paramJsBridgeListener = paramString2;
                if (!this.mCurrentUin.equals(str)) {
                  break label8303;
                }
                this.mRoleId = paramString3.roleId;
                this.mDressIds = paramString2;
                bool2 = bool1;
                paramJsBridgeListener = paramString2;
                break label8303;
                this.mValidAvatarIdList.clear();
                this.mValidAvatarIdList.add(paramString3.apolloId);
                if ((paramVarArgs instanceof IApolloActivityJsCallBack))
                {
                  paramString2 = (IApolloActivityJsCallBack)paramVarArgs;
                  if (i != 0)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ApolloJsPlugin", 2, "initAvatar, should request resource");
                    }
                    paramVarArgs = new ArrayList(1);
                    paramVarArgs.add(paramString3);
                    this.mReqBundle.clear();
                    this.mReqBundle.putInt("from", 0);
                    this.mReqBundle.putSerializable("apolloList", paramVarArgs);
                    super.sendRemoteReq(DataFactory.a("ipc_apollo_check_avatar_res", paramString1, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                    paramString2.a(true, paramString3.x, paramString3.y);
                  }
                }
                for (;;)
                {
                  if (i != 0) {
                    break label3413;
                  }
                  this.mReqBundle.clear();
                  this.mReqBundle.putInt("from", 0);
                  this.mReqBundle.putString("uin", ((JSONObject)localObject).optString("uin"));
                  this.mReqBundle.putLong("avatarTs", l);
                  this.mReqBundle.putIntArray("dressId", paramJsBridgeListener);
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_update_avatar_info", paramString1, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                  break;
                  paramString2 = paramString2.a(this.mApolloStatus, paramString3);
                  super.callJs(paramString1 + "(" + paramString2 + ");");
                  continue;
                  QLog.e("ApolloJsPlugin", 1, "initAvatar, not apollo store activity");
                  callbackError(paramString1, "非商城页面");
                }
              }
              else
              {
                label3413:
                int m;
                if ("addAvatar".equals(paramString3))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "addAvatar");
                  }
                  if (!(paramVarArgs instanceof IApolloActivityJsCallBack))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ApolloJsPlugin", 2, "addAvatar, not IApolloActivityJsCallBack, check mApolloViewContoller");
                    }
                    if ((this.mApolloViewContoller == null) && ((this.mRuntime.a().getParent() instanceof RelativeLayout)))
                    {
                      this.mApolloViewContoller = new ApolloViewController((RelativeLayout)this.mRuntime.a().getParent(), null);
                      this.mApolloViewContoller.a(this);
                    }
                    if (this.mApolloViewContoller == null)
                    {
                      QLog.e("ApolloJsPlugin", 1, "addAvatar, mApolloViewContoller null");
                      callbackError(paramString1, "ApolloViewController is null");
                      return false;
                    }
                  }
                  paramJsBridgeListener = ((JSONObject)localObject).getJSONArray("apolloList");
                  if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length() > 0))
                  {
                    i = 0;
                    paramString2 = new ArrayList(paramJsBridgeListener.length());
                    m = paramJsBridgeListener.length();
                    j = 0;
                    if (j >= m) {
                      break label8233;
                    }
                    localObject = paramJsBridgeListener.getJSONObject(j);
                    paramString3 = new ApolloWebAvatarParam();
                    paramString3.isMain = false;
                    paramString3.apolloId = ((JSONObject)localObject).optString("apolloId");
                    paramString3.x = ((JSONObject)localObject).optInt("x", DEFAULT_WIDTH);
                    paramString3.y = ((JSONObject)localObject).optInt("y", DEFAULT_HEIGHT);
                    paramString3.nickName = ((JSONObject)localObject).optString("nickName");
                    paramString3.uin = ((JSONObject)localObject).optString("uin");
                    if ((TextUtils.isEmpty(paramString3.apolloId)) || (TextUtils.isEmpty(paramString3.uin)))
                    {
                      QLog.e("ApolloJsPlugin", 1, "addAvatar, apolloId or uin is null");
                      j = 1;
                      if (j != 0)
                      {
                        QLog.e("ApolloJsPlugin", 1, "addAvatar, param invalid");
                        callbackError(paramString1, "请求参数错误");
                      }
                    }
                    else
                    {
                      paramString3.rate = ((float)((JSONObject)localObject).optDouble("rate", 0.0D));
                      paramString3.roleId = ((JSONObject)localObject).optInt("roleId");
                      localObject = ((JSONObject)localObject).optJSONArray("dressIds");
                      bool1 = false;
                      if (paramString3.roleId > 0) {
                        bool1 = ApolloUtil.c(paramString3.roleId);
                      }
                      bool2 = bool1;
                      if (localObject != null)
                      {
                        bool2 = bool1;
                        if (((JSONArray)localObject).length() > 0)
                        {
                          int n = ((JSONArray)localObject).length();
                          paramString3.dressIds = new int[n];
                          k = 0;
                          bool2 = bool1;
                          if (k < n)
                          {
                            int i1 = ((JSONArray)localObject).getInt(k);
                            paramString3.dressIds[k] = i1;
                            bool2 = bool1;
                            if (paramString3.roleId <= 0) {
                              break label8314;
                            }
                            bool2 = bool1;
                            if (!bool1) {
                              break label8314;
                            }
                            bool2 = ApolloUtil.b(i1);
                            break label8314;
                          }
                        }
                      }
                      paramString3.isResExist = bool2;
                      if (bool2) {
                        break;
                      }
                      i = 1;
                      paramString2.add(paramString3);
                      if (this.mValidAvatarIdList.contains(paramString3.apolloId)) {
                        break label8327;
                      }
                      this.mValidAvatarIdList.add(paramString3.apolloId);
                      break label8327;
                    }
                    if (i != 0)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("ApolloJsPlugin", 2, "addAvatar, should request resource");
                      }
                      this.mReqBundle.clear();
                      this.mReqBundle.putInt("from", 2);
                      this.mReqBundle.putSerializable("apolloList", paramString2);
                      super.sendRemoteReq(DataFactory.a("ipc_apollo_check_avatar_res", paramString1, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                    }
                    else if ((paramVarArgs instanceof IApolloActivityJsCallBack))
                    {
                      paramJsBridgeListener = ((IApolloActivityJsCallBack)paramVarArgs).a(paramString2);
                      super.callJs(paramString1 + "(" + paramJsBridgeListener + ");");
                    }
                    else if (this.mApolloViewContoller != null)
                    {
                      paramJsBridgeListener = this.mApolloViewContoller.a(paramString2);
                      super.callJs(paramString1 + "(" + paramJsBridgeListener + ");");
                    }
                    else
                    {
                      QLog.e("ApolloJsPlugin", 1, "addAvatar, controller null");
                      callbackError(paramString1, "终端初始化错误");
                    }
                  }
                  else
                  {
                    QLog.e("ApolloJsPlugin", 1, "addAvatar, param list null");
                    callbackError(paramString1, "请求列表为空");
                  }
                }
                else if ("destroyAvatar".equals(paramString3))
                {
                  paramJsBridgeListener = ((JSONObject)localObject).optJSONArray("apolloList");
                  if ((paramJsBridgeListener == null) || (paramJsBridgeListener.length() == 0))
                  {
                    callbackError(paramString1, "请求参数错误");
                  }
                  else
                  {
                    paramString2 = new ArrayList();
                    i = 0;
                    j = paramJsBridgeListener.length();
                    while (i < j)
                    {
                      paramString3 = paramJsBridgeListener.getString(i);
                      paramString2.add(paramString3);
                      this.mValidAvatarIdList.remove(paramString3);
                      i += 1;
                    }
                    if ((paramVarArgs instanceof IApolloActivityJsCallBack))
                    {
                      ((IApolloActivityJsCallBack)paramVarArgs).a(paramString2);
                      callbackOk(paramString1);
                    }
                    else if (this.mApolloViewContoller != null)
                    {
                      this.mApolloViewContoller.a(paramString2);
                      callbackOk(paramString1);
                    }
                    else
                    {
                      QLog.e("ApolloJsPlugin", 1, "destroyAvatar, controller null");
                      callbackError(paramString1, "终端初始化错误");
                    }
                  }
                }
                else if ("getRoleId".equals(paramString3))
                {
                  if (!this.mDataInited)
                  {
                    this.mReqBundle.clear();
                    this.mReqBundle.putInt("apollo_initFrom", 2);
                    super.sendRemoteReq(DataFactory.a("ipc_apollo_get_apollo_data", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                    return true;
                  }
                  paramJsBridgeListener = new JSONObject();
                  paramJsBridgeListener.put("result", 0);
                  paramJsBridgeListener.put("msg", "");
                  paramString2 = new JSONObject();
                  j = this.mRoleId;
                  i = j;
                  if (j <= 0)
                  {
                    if (this.mGender == 1) {
                      break label8336;
                    }
                    if (this.mGender != 0) {
                      break label8342;
                    }
                    break label8336;
                  }
                  paramString2.put("roleId", i);
                  paramJsBridgeListener.put("data", paramString2);
                  super.callJs(paramString1 + "(" + paramJsBridgeListener.toString() + ");");
                }
                else if ("getLocalInfo".equals(paramString3))
                {
                  if (!this.mDataInited)
                  {
                    this.mReqBundle.clear();
                    this.mReqBundle.putInt("apollo_initFrom", 3);
                    super.sendRemoteReq(DataFactory.a("ipc_apollo_get_apollo_data", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                    return true;
                  }
                  if ((this.mDressIds == null) || (this.mDressIds.length <= 0))
                  {
                    callbackError(paramString1, "默认角色或获取本人信息失败");
                    if (QLog.isColorLevel()) {
                      QLog.d("ApolloJsPlugin", 2, "dressIds.array->默认角色或获取本人信息失败");
                    }
                  }
                  else
                  {
                    paramJsBridgeListener = new JSONObject();
                    paramJsBridgeListener.put("result", 0);
                    paramJsBridgeListener.put("msg", "");
                    paramString2 = new JSONObject();
                    paramString3 = new JSONArray();
                    paramVarArgs = this.mDressIds;
                    j = paramVarArgs.length;
                    i = 0;
                    while (i < j)
                    {
                      paramString3.put(Integer.valueOf(paramVarArgs[i]));
                      i += 1;
                    }
                    paramString2.put("dressIds", paramString3);
                    paramJsBridgeListener.put("data", paramString2);
                    super.callJs(paramString1 + "(" + paramJsBridgeListener.toString() + ");");
                    if (QLog.isColorLevel()) {
                      QLog.d("ApolloJsPlugin", 2, "array->" + paramString3);
                    }
                  }
                }
                else if ("preview".equals(paramString3))
                {
                  if (!checkSdcard(paramVarArgs))
                  {
                    callbackError(paramString1, "sdcard未装");
                    return true;
                  }
                  if ((paramVarArgs instanceof IApolloActivityJsCallBack))
                  {
                    paramJsBridgeListener = ((JSONObject)localObject).optJSONArray("dressIds");
                    if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length() > 0))
                    {
                      j = paramJsBridgeListener.length();
                      paramString2 = new int[j];
                      i = 0;
                      while (i < j)
                      {
                        paramString2[i] = paramJsBridgeListener.getInt(i);
                        i += 1;
                      }
                      k = paramString2.length;
                      i = 1;
                      j = 0;
                      if (j < k)
                      {
                        m = paramString2[j];
                        if ((i == 0) || (!ApolloUtil.b(m))) {
                          break label8357;
                        }
                        i = 1;
                        break label8348;
                      }
                      if (i != 0)
                      {
                        paramJsBridgeListener = ((IApolloActivityJsCallBack)paramVarArgs).a(paramString2);
                        super.callJs(paramString1 + "(" + paramJsBridgeListener + ");");
                        if (QLog.isColorLevel()) {
                          QLog.e("ApolloJsPlugin", 2, "callbackId->" + paramString1 + " callbackOk" + paramJsBridgeListener);
                        }
                      }
                      else
                      {
                        this.mReqBundle.clear();
                        this.mReqBundle.putIntArray("apollo_dressIds", paramString2);
                        super.sendRemoteReq(DataFactory.a("ipc_apollo_preview", paramString1, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                      }
                    }
                    else
                    {
                      callbackError(paramString1, "dressIds为空");
                    }
                  }
                  else
                  {
                    callbackError(paramString1, "非商城页面");
                  }
                }
                else if (("previewOnFrame".equals(paramString3)) || ("previewAction".equals(paramString3)))
                {
                  if (!checkSdcard(paramVarArgs))
                  {
                    callbackError(paramString1, "sdcard未装");
                    return true;
                  }
                  i = ((JSONObject)localObject).optInt("actionId");
                  j = ((JSONObject)localObject).optInt("type");
                  k = ((JSONObject)localObject).optInt("isSpecial");
                  paramJsBridgeListener = ((JSONObject)localObject).optString("title");
                  paramString2 = ((JSONObject)localObject).optString("subTitle");
                  paramVarArgs = ((JSONObject)localObject).optString("apolloId", "me");
                  this.mReqBundle.clear();
                  this.mReqBundle.putInt("apollo_previewAction", i);
                  this.mReqBundle.putBoolean("apollo_previewOnFrame", "previewOnFrame".equals(paramString3));
                  paramString3 = this.mReqBundle;
                  if (sRoleGender != 2) {
                    break label8363;
                  }
                  i = 1;
                  paramString3.putInt("apollo_partnerRoleId", i);
                  this.mReqBundle.putInt("apollo_type", j);
                  this.mReqBundle.putInt("apollo_isSpecial", k);
                  this.mReqBundle.putString("apollo_json", ((JSONObject)localObject).toString());
                  this.mReqBundle.putString("apollo_id", paramVarArgs);
                  this.mReqBundle.putString("title", paramJsBridgeListener);
                  this.mReqBundle.putString("subTitle", paramString2);
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_preview_action", paramString1, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                }
                else if ("setup".equals(paramString3))
                {
                  paramJsBridgeListener = ((JSONObject)localObject).optJSONArray("dressIds");
                  if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length() > 0))
                  {
                    j = paramJsBridgeListener.length();
                    this.mDressIds = new int[j];
                    i = 0;
                    while (i < j)
                    {
                      this.mDressIds[i] = paramJsBridgeListener.getInt(i);
                      i += 1;
                    }
                  }
                  if ((paramVarArgs instanceof IApolloActivityJsCallBack))
                  {
                    this.mApolloStatus = 1;
                    ((IApolloActivityJsCallBack)paramVarArgs).a(this.mRoleId, this.mDressIds);
                    callbackOk(paramString1);
                    this.mReqBundle.clear();
                    paramJsBridgeListener = ((JSONObject)localObject).optString("userData");
                    this.mReqBundle.putString("apollo_userData", paramJsBridgeListener);
                    super.sendRemoteReq(DataFactory.a("ipc_apollo_setup", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                  }
                  else
                  {
                    callbackError(paramString1, "非商城页面");
                  }
                }
                else if ("changeRole".equals(paramString3))
                {
                  if (!checkSdcard(paramVarArgs))
                  {
                    callbackError(paramString1, "sdcard未装");
                    return true;
                  }
                  j = ((JSONObject)localObject).getInt("roleId");
                  if (j > 0) {
                    this.mRoleId = j;
                  }
                  paramJsBridgeListener = ((JSONObject)localObject).optJSONArray("dressIds");
                  if ((j > 0) && (paramJsBridgeListener != null) && (paramJsBridgeListener.length() > 0))
                  {
                    k = paramJsBridgeListener.length();
                    this.mDressIds = new int[k];
                    i = 0;
                    while (i < k)
                    {
                      this.mDressIds[i] = paramJsBridgeListener.getInt(i);
                      i += 1;
                    }
                    paramJsBridgeListener = ((JSONObject)localObject).optString("userData");
                    paramString2 = new JSONObject(paramJsBridgeListener);
                    sRoleGender = paramString2.optInt("sex");
                    if (paramString2.optJSONObject("role").optInt("aiFlag", 0) != 1) {
                      break label8369;
                    }
                    bool1 = true;
                    this.mIsAIRole = bool1;
                    this.mRoleId = j;
                    this.mReqBundle.clear();
                    this.mReqBundle.putIntArray("apollo_dressIds", this.mDressIds);
                    this.mReqBundle.putInt("apollo_roleId", this.mRoleId);
                    this.mReqBundle.putInt("apollo_fromSelf", 0);
                    this.mReqBundle.putString("apollo_userData", paramJsBridgeListener);
                    super.sendRemoteReq(DataFactory.a("ipc_apollo_changerole", paramString1, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                  }
                  else
                  {
                    callbackError(paramString1, "roleId 或 dressIds 为空");
                  }
                }
                else if ("closeWebview".equals(paramString3))
                {
                  super.sendRemoteReq(DataFactory.a("ipc_kandian_hb_close_guid", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                  paramVarArgs.finish();
                  if (!(paramVarArgs instanceof IApolloActivityJsCallBack)) {
                    paramVarArgs.overridePendingTransition(0, 0);
                  }
                  paramJsBridgeListener = new JSONObject();
                  paramJsBridgeListener.put("result", 0);
                  paramJsBridgeListener.put("msg", "");
                  super.callJs(paramString1 + "(" + paramJsBridgeListener.toString() + ");");
                }
                else if ("getSwitch".equals(paramString3))
                {
                  if (!this.mDataInited)
                  {
                    this.mReqBundle.clear();
                    this.mReqBundle.putInt("apollo_initFrom", 4);
                    super.sendRemoteReq(DataFactory.a("ipc_apollo_get_apollo_data", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                    return true;
                  }
                  paramJsBridgeListener = new JSONObject();
                  paramJsBridgeListener.put("result", 0);
                  paramJsBridgeListener.put("msg", "");
                  paramString2 = new JSONObject();
                  paramString2.put("status", this.mApolloStatus);
                  paramJsBridgeListener.put("data", paramString2);
                  super.callJs(paramString1 + "(" + paramJsBridgeListener.toString() + ");");
                }
                else if ("openFloatTransparentView".equals(paramString3))
                {
                  paramJsBridgeListener = ((JSONObject)localObject).getString("url");
                  i = ((JSONObject)localObject).getInt("closeBtn");
                  j = ((JSONObject)localObject).optInt("fullScreen");
                  paramString2 = new Intent(paramVarArgs, ApolloFloatActivity.class);
                  paramString2.putExtra("extra_key_click_time", System.currentTimeMillis());
                  paramString2.putExtra("extra_key_weburl", paramJsBridgeListener);
                  if (i != 1) {
                    break label8375;
                  }
                  bool1 = true;
                  paramString2.putExtra("extra_key_close_btn", bool1);
                  if (j != 1) {
                    break label8381;
                  }
                  bool1 = true;
                  paramString2.putExtra("extra_key_fullscreen", bool1);
                  paramVarArgs.startActivity(paramString2);
                  paramJsBridgeListener = new JSONObject();
                  paramJsBridgeListener.put("result", 0);
                  paramJsBridgeListener.put("msg", "");
                  super.callJs(paramString1 + "(" + paramJsBridgeListener.toString() + ");");
                }
                else if ("openApolloShow".equals(paramString3))
                {
                  paramJsBridgeListener = ((JSONObject)localObject).optString("nick");
                  paramString2 = ((JSONObject)localObject).optString("uin");
                  paramString3 = new Intent(paramVarArgs, ApolloGuestsStateActivity.class);
                  paramString3.putExtra("extra_guest_nick", paramJsBridgeListener);
                  paramString3.putExtra("extra_guest_uin", paramString2);
                  paramVarArgs.startActivity(paramString3);
                  paramVarArgs.overridePendingTransition(0, 0);
                  callbackOk(paramString1);
                }
                else if ("getFriendsByOpenApollo".equals(paramString3))
                {
                  this.mReqBundle.clear();
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_get_openapollo_friends", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                }
                else if ("sendActionToFrd".equals(paramString3))
                {
                  i = ((JSONObject)localObject).optInt("actionId", -1);
                  j = ((JSONObject)localObject).optInt("pkgId", -1);
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, new Object[] { "apolloJsPlugin call sendActionToFrd, pkgId=", Integer.valueOf(j), ", actionId=", Integer.valueOf(i) });
                  }
                  paramJsBridgeListener = new Bundle();
                  paramJsBridgeListener.putInt("forward_type", 26);
                  paramJsBridgeListener.putInt("apollo_actionid_key", i);
                  paramJsBridgeListener.putInt("apollo_pkgid_key", j);
                  paramString2 = new Intent(this.mRuntime.a().getApplicationContext(), ForwardRecentActivity.class);
                  paramString2.addFlags(268435456);
                  paramString2.addFlags(67108864);
                  paramString2.putExtras(paramJsBridgeListener);
                  this.mRuntime.a().startActivity(paramString2);
                }
                else if ("refreshAction".equals(paramString3))
                {
                  this.mReqBundle.clear();
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_refresh_action", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "apolloJsPlugin call refreshAction");
                  }
                }
                else if ("getLocalFavAction".equals(paramString3))
                {
                  this.mReqBundle.clear();
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_getfav_action", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "apolloJsPlugin call getLocalFavAction");
                  }
                }
                else if ("addCustomAction".equals(paramString3))
                {
                  this.mReqBundle.clear();
                  i = ((JSONObject)localObject).optInt("actionId");
                  j = ((JSONObject)localObject).optInt("textType");
                  paramJsBridgeListener = ((JSONObject)localObject).optString("actionText");
                  k = ((JSONObject)localObject).optInt("audioId");
                  m = ((JSONObject)localObject).optInt("playOriginalAudio");
                  float f = ((JSONObject)localObject).optInt("audioStartTime");
                  this.mReqBundle.putInt("actionId", i);
                  this.mReqBundle.putString("actionText", paramJsBridgeListener);
                  this.mReqBundle.putInt("textType", j);
                  this.mReqBundle.putInt("audioId", k);
                  this.mReqBundle.putInt("playOriginalAudio", m);
                  this.mReqBundle.putFloat("audioStartTime", f);
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_add_fav_action", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "apolloJsPlugin call addCustomAction");
                  }
                }
                else if ("delLocalFavAction".equals(paramString3))
                {
                  this.mReqBundle.clear();
                  this.mReqBundle.putString("delJson", ((JSONObject)localObject).opt("favActionDel").toString());
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_del_fav_list", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "apolloJsPlugin call delLocalFavList");
                  }
                }
                else if ("writeLocalData".equals(paramString3))
                {
                  this.mReqBundle.clear();
                  this.mReqBundle.putString("writeData", ((JSONObject)localObject).toString());
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_write_local", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "apolloJsPlugin call writeLocalData");
                  }
                }
                else if ("redbagCallback".equals(paramString3))
                {
                  this.mReqBundle.clear();
                  i = ((JSONObject)localObject).optInt("bonusSuccess", 0);
                  if (i == 1)
                  {
                    this.mReqBundle.putInt("bonusSuccess", i);
                    super.sendRemoteReq(DataFactory.a("ipc_kandian_hb_lottery", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                  }
                }
                else if ("removeBubble".equals(paramString3))
                {
                  l = ((JSONObject)localObject).optLong("bubbleId");
                  this.mReqBundle.clear();
                  this.mReqBundle.putLong("bubble_id", l);
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_clear_bubble", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                }
                else if ("downloadImageOnFrame".equals(paramString3))
                {
                  i = new Random().nextInt();
                  this.mReqBundle.clear();
                  this.mReqBundle.putInt("apollo_previewAction", i);
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_downloadImageOnFrame", paramString1, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                }
                else if ("addGame".equals(paramString3))
                {
                  this.mReqBundle.clear();
                  this.mReqBundle.putString("gameListJson", ((JSONObject)localObject).toString());
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_add_game", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                }
                else if ("delGame".equals(paramString3))
                {
                  this.mReqBundle.clear();
                  this.mReqBundle.putString("gameListJson", ((JSONObject)localObject).toString());
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_del_game", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                }
                else if ("updateGameList".equals(paramString3))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, new Object[] { "[handleJsRequest] updateGameList, json=", localObject });
                  }
                  this.mReqBundle.clear();
                  this.mReqBundle.putString("gameListJson", ((JSONObject)localObject).toString());
                  super.sendRemoteReq(DataFactory.a("ipc_apollo_update_game_list", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                }
                else if ("isCmFaceAdded".equals(paramString3))
                {
                  this.mReqBundle.clear();
                  paramJsBridgeListener = ((JSONObject)localObject).optJSONArray("faceIdList");
                  if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length() > 0))
                  {
                    this.mReqBundle.putString("faceIdList", paramJsBridgeListener.toString());
                    super.sendRemoteReq(DataFactory.a("ipc_apollo_is_cm_face_added", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                  }
                  else
                  {
                    paramJsBridgeListener = new JSONObject();
                    paramJsBridgeListener.put("result", 1);
                    paramJsBridgeListener.put("msg", "缺少请求参数");
                    super.callJs(paramString1 + "(" + paramJsBridgeListener.toString() + ");");
                  }
                }
                else if ("addCmFace".equals(paramString3))
                {
                  this.mReqBundle.clear();
                  paramJsBridgeListener = ((JSONObject)localObject).optJSONArray("faceIdList");
                  if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length() > 0))
                  {
                    this.mReqBundle.putString("faceIdList", paramJsBridgeListener.toString());
                    super.sendRemoteReq(DataFactory.a("ipc_apollo_add_cm_face", paramString1, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                  }
                  else
                  {
                    paramJsBridgeListener = new JSONObject();
                    paramJsBridgeListener.put("result", 1);
                    paramJsBridgeListener.put("msg", "缺少请求参数");
                    super.callJs(paramString1 + "(" + paramJsBridgeListener.toString() + ");");
                  }
                }
                else if ("downloadTbs".equals(paramString3))
                {
                  paramJsBridgeListener = this.mRuntime.a();
                  if ((paramJsBridgeListener instanceof BrowserAppInterface)) {
                    ((BrowserAppInterface)paramJsBridgeListener).a(true);
                  }
                }
                else if ("setLeftViewIcon".equals(paramString3))
                {
                  paramString2 = ((JSONObject)localObject).optString("url");
                  if (!TextUtils.isEmpty(paramString2))
                  {
                    paramJsBridgeListener = (SwiftBrowserUIStyleHandler)access$101(this, 2);
                    if ((paramJsBridgeListener != null) && (paramJsBridgeListener.a != null) && (paramJsBridgeListener.a.a != null))
                    {
                      paramString3 = URLDrawable.URLDrawableOptions.obtain();
                      paramString3.mLoadingDrawable = paramVarArgs.getResources().getDrawable(2130846264);
                      paramString2 = URLDrawable.getDrawable(paramString2, paramString3);
                      paramString2.startDownload();
                      paramJsBridgeListener.a.a.setBackgroundDrawable(paramString2);
                    }
                  }
                }
                else if ("getUserInfo".equals(paramString3))
                {
                  paramJsBridgeListener = new JSONObject();
                  paramJsBridgeListener.put("result", 0);
                  paramJsBridgeListener.put("msg", "");
                  paramString2 = new JSONObject();
                  paramString3 = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 4);
                  paramVarArgs = this.mRuntime.a().getCurrentAccountUin();
                  bool1 = paramString3.getBoolean(paramVarArgs + "_" + "sp_key_new_store_whitelist", false);
                  bool2 = paramString3.getBoolean(paramVarArgs + "_" + "sp_key_drawer_game_entry_whitelist", false);
                  if (!QLog.isColorLevel()) {
                    break label8387;
                  }
                  QLog.d("ApolloJsPlugin", 2, new Object[] { "getUserInfo, isNewStoreUser=", Boolean.valueOf(bool1), ", isGameBoxUser=", Boolean.valueOf(bool2) });
                  break label8387;
                  paramString2.put("isInNewShopWhiteList", i);
                  if (!bool2) {
                    break label8404;
                  }
                  i = 1;
                  paramString2.put("isInGameBoxWhiteList", i);
                  paramJsBridgeListener.put("data", paramString2);
                  super.callJs(paramString1 + "(" + paramJsBridgeListener.toString() + ");");
                }
                else if ("showGameCard".equals(paramString3))
                {
                  ApolloManager.a(((JSONObject)localObject).optInt("gameId"), ((JSONObject)localObject).optString("extraInfo"), this.mRuntime.a());
                }
              }
            }
          }
        }
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ApolloJsPlugin", 2, paramJsBridgeListener.getMessage());
        }
      }
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.mReqBundle = new Bundle();
    sResponseKey = this.mOnRemoteResp.key;
    ApolloEngine.a();
    sApolloReceiver.onApolloJsCreated(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mInterceptor != null)
    {
      this.mInterceptor.a();
      this.mInterceptor = null;
    }
    if (this.mApolloViewContoller != null) {
      this.mApolloViewContoller.d();
    }
    if (this.gameDialog != null) {
      this.gameDialog.dismiss();
    }
    sApolloReceiver.onApolloJsDestroy(this);
    this.mCmGameStartChecker = null;
    this.mCmGameStartCheckerListener = null;
  }
  
  public void onNotifyLongTouch(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloJsPlugin", 2, new Object[] { "onNotifyLongTouch:", paramString });
    }
  }
  
  public void onNotifyStatusChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloJsPlugin", 2, new Object[] { "[onNotifyStatusChanged] status=", Integer.valueOf(paramInt), ", apolloId=", paramString });
    }
    if (TextUtils.isEmpty(paramString))
    {
      super.callJs("window.apollo && window.apollo.controller && window.apollo.controller.hitAvatar && window.apollo.controller.hitAvatar();");
      return;
    }
    super.callJs(String.format("window.apollo && window.apollo.controller && window.apollo.controller.hitAvatar && window.apollo.controller.hitAvatar('%s');", new Object[] { paramString }));
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    Object localObject3;
    String str;
    Object localObject2;
    Object localObject1;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key))
    {
      localObject3 = paramBundle.getString("cmd");
      str = paramBundle.getString("callbackid");
      localObject2 = paramBundle.getBundle("response");
      if ((localObject3 != null) && (localObject2 != null))
      {
        localObject1 = this.mRuntime.a();
        if ((localObject1 != null) && (!this.isDestroy) && (!((Activity)localObject1).isFinishing())) {
          break label98;
        }
        callbackError(str, "当前页面已经销毁或非商城页面");
      }
    }
    return;
    break label1732;
    label97:
    label98:
    label366:
    int i;
    int j;
    int k;
    Object localObject4;
    Object localObject5;
    int m;
    int n;
    Object localObject6;
    for (;;)
    {
      try
      {
        if (!"ipc_apollo_preview".equals(localObject3)) {
          break label366;
        }
        paramBundle = ((Bundle)localObject2).getIntArray("apollo_dressIds");
        if ((((Bundle)localObject2).getInt("apollo_result") == 0) && (paramBundle != null))
        {
          callbackError(str, "参数不对，未下载成功");
          return;
        }
      }
      catch (Throwable paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ApolloJsPlugin", 2, paramBundle.getMessage());
        }
        callbackError(str, "调用失败");
        return;
      }
      if (this.mApolloViewContoller != null)
      {
        paramBundle = this.mApolloViewContoller.a(paramBundle);
        super.callJs(str + "(" + paramBundle + ");");
        if (QLog.isColorLevel()) {
          QLog.e("ApolloJsPlugin", 2, "callbackId->" + str + " callbackOk" + paramBundle);
        }
      }
      else if ((localObject1 instanceof IApolloActivityJsCallBack))
      {
        paramBundle = ((IApolloActivityJsCallBack)localObject1).a(paramBundle);
        super.callJs(str + "(" + paramBundle + ");");
        if (QLog.isColorLevel()) {
          QLog.e("ApolloJsPlugin", 2, "callbackId->" + str + " callbackOk" + paramBundle);
        }
      }
      else
      {
        callbackError(str, "非商城页面");
        return;
        if ((!"ipc_apollo_preview_action".equals(localObject3)) && (!"ipc_apollo_preview_audio_action".equals(localObject3))) {
          break label1362;
        }
        i = ((Bundle)localObject2).getInt("apollo_previewAction");
        j = ((Bundle)localObject2).getInt("apollo_apolloVipFlag");
        k = ((Bundle)localObject2).getInt("apollo_apolloVipLevel");
        paramBundle = ((Bundle)localObject2).getString("title");
        localObject4 = ((Bundle)localObject2).getString("subTitle");
        localObject5 = ((Bundle)localObject2).getString("apollo_json");
        boolean bool = ((Bundle)localObject2).getBoolean("apollo_previewOnFrame");
        Object localObject7 = new JSONObject((String)localObject5);
        m = ((JSONObject)localObject7).optInt("type");
        n = ((JSONObject)localObject7).optInt("isSpecial");
        int i1 = ((JSONObject)localObject7).optInt("vipLevel");
        int i2 = ((JSONObject)localObject7).optInt("feeType");
        int i3 = ((JSONObject)localObject7).optInt("isDiyAction");
        int i4 = ((JSONObject)localObject7).optInt("textType");
        int i5 = ((JSONObject)localObject7).optInt("playCount");
        int i6 = ((JSONObject)localObject7).optInt("playOriginalAudio");
        int i7 = ((JSONObject)localObject7).optInt("audioId");
        float f1 = (float)((JSONObject)localObject7).optDouble("audioStartTime");
        float f2 = (float)((JSONObject)localObject7).optDouble("frameTime");
        localObject6 = ((JSONObject)localObject7).optString("text");
        ((JSONObject)localObject7).optString("animationName");
        int i8 = ((Bundle)localObject2).getInt("apollo_result");
        int i9 = ((Bundle)localObject2).getInt("apollo_partnerRoleId");
        localObject7 = ((Bundle)localObject2).getString("apollo_id");
        localObject2 = new ApolloViewController.PlayActionData();
        ((ApolloViewController.PlayActionData)localObject2).jdField_a_of_type_Int = i5;
        ((ApolloViewController.PlayActionData)localObject2).jdField_b_of_type_Int = i;
        ((ApolloViewController.PlayActionData)localObject2).jdField_c_of_type_Int = m;
        ((ApolloViewController.PlayActionData)localObject2).jdField_d_of_type_Int = n;
        ((ApolloViewController.PlayActionData)localObject2).e = i1;
        ((ApolloViewController.PlayActionData)localObject2).f = j;
        ((ApolloViewController.PlayActionData)localObject2).g = k;
        ((ApolloViewController.PlayActionData)localObject2).h = i2;
        ((ApolloViewController.PlayActionData)localObject2).i = i9;
        ((ApolloViewController.PlayActionData)localObject2).j = i3;
        ((ApolloViewController.PlayActionData)localObject2).k = i4;
        ((ApolloViewController.PlayActionData)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject6);
        ((ApolloViewController.PlayActionData)localObject2).l = i6;
        ((ApolloViewController.PlayActionData)localObject2).m = i7;
        ((ApolloViewController.PlayActionData)localObject2).jdField_a_of_type_Float = f1;
        ((ApolloViewController.PlayActionData)localObject2).jdField_b_of_type_Float = f2;
        ((ApolloViewController.PlayActionData)localObject2).jdField_a_of_type_Boolean = bool;
        ((ApolloViewController.PlayActionData)localObject2).jdField_c_of_type_JavaLangString = paramBundle;
        ((ApolloViewController.PlayActionData)localObject2).jdField_d_of_type_JavaLangString = ((String)localObject4);
        ((ApolloViewController.PlayActionData)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject7);
        if ((i8 != 0) || (i <= 0)) {
          break;
        }
        if ("ipc_apollo_preview_audio_action".equals(localObject3))
        {
          paramBundle = ApolloViewController.a("ApolloViewController is null or Activity not instanceof IApolloActivityJsCallBack");
          if (this.mApolloViewContoller != null)
          {
            paramBundle = this.mApolloViewContoller.a((ApolloViewController.PlayActionData)localObject2);
            super.callJs(str + "(" + paramBundle + ");");
          }
          while (QLog.isColorLevel())
          {
            QLog.e("ApolloJsPlugin", 2, "IPC_APOLLO_PREVIEW_AUDIO_ACTION callbackId->" + str + " callbackOk" + paramBundle);
            return;
            if ((localObject1 instanceof IApolloActivityJsCallBack))
            {
              paramBundle = ((IApolloActivityJsCallBack)localObject1).a((ApolloViewController.PlayActionData)localObject2);
              super.callJs(str + "(" + paramBundle + ");");
            }
          }
        }
        else if ("ipc_apollo_preview_action".equals(localObject3))
        {
          localObject3 = new File(ApolloResDownloader.b(i7));
          if ((i7 > 0) && (!((File)localObject3).exists()))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ApolloJsPlugin", 2, "IPC_APOLLO_PREVIEW_ACTION audio file no exsit callbackId->" + str);
            }
            this.mReqBundle.clear();
            this.mReqBundle.putInt("apollo_previewAction", i);
            this.mReqBundle.putInt("apollo_apolloVipFlag", j);
            this.mReqBundle.putInt("apollo_apolloVipLevel", k);
            this.mReqBundle.putBoolean("apollo_previewOnFrame", bool);
            this.mReqBundle.putInt("apollo_partnerRoleId", i9);
            this.mReqBundle.putInt("apollo_audioId", i7);
            this.mReqBundle.putString("apollo_json", ((String)localObject5).toString());
            this.mReqBundle.putString("title", paramBundle);
            this.mReqBundle.putString("subTitle", (String)localObject4);
            super.sendRemoteReq(DataFactory.a("ipc_apollo_preview_audio_action", str, this.mOnRemoteResp.key, this.mReqBundle), true, true);
            return;
          }
          paramBundle = ApolloViewController.a("ApolloViewController is null or Activity not instanceof IApolloActivityJsCallBack");
          if ((localObject1 instanceof IApolloActivityJsCallBack))
          {
            paramBundle = ((IApolloActivityJsCallBack)localObject1).a((ApolloViewController.PlayActionData)localObject2);
            super.callJs(str + "(" + paramBundle + ");");
          }
          while (QLog.isColorLevel())
          {
            QLog.e("ApolloJsPlugin", 2, "IPC_APOLLO_PREVIEW_ACTION callbackId->" + str + " callbackOk" + paramBundle);
            return;
            if (this.mApolloViewContoller != null)
            {
              paramBundle = this.mApolloViewContoller.a((ApolloViewController.PlayActionData)localObject2);
              super.callJs(str + "(" + paramBundle + ");");
            }
            else
            {
              callbackError(str, "终端错误");
            }
          }
        }
      }
    }
    callbackError(str, "参数不对，未下载成功" + (String)localObject3);
    return;
    label1362:
    if ("ipc_apollo_check_avatar_res".equals(localObject3))
    {
      i = ((Bundle)localObject2).getInt("result");
      j = ((Bundle)localObject2).getInt("from");
      paramBundle = ((Bundle)localObject2).getString("msg");
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, new Object[] { "IPC_APOLLO_CHECK_AVATAR_RES, ret=", Integer.valueOf(i), ", msg=", paramBundle, ", from=", Integer.valueOf(j) });
      }
      localObject2 = (ArrayList)((Bundle)localObject2).getSerializable("apolloList");
      if (i == 0)
      {
        if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0)) {
          break label4583;
        }
        callbackError(str, "请求参数错误");
        return;
        label1496:
        localObject2 = (ApolloWebAvatarParam)((ArrayList)localObject2).get(0);
        if (((ApolloWebAvatarParam)localObject2).isResExist) {
          if (this.mValidAvatarIdList.contains(((ApolloWebAvatarParam)localObject2).apolloId))
          {
            paramBundle = "";
            if (j == 1)
            {
              if (this.mApolloViewContoller == null) {
                break label4597;
              }
              paramBundle = this.mApolloViewContoller.a(1, true, (ApolloWebAvatarParam)localObject2);
            }
          }
        }
      }
    }
    for (;;)
    {
      super.callJs(str + "(" + paramBundle + ");");
      return;
      if (j == 0)
      {
        if ((localObject1 instanceof IApolloActivityJsCallBack))
        {
          paramBundle = ((IApolloActivityJsCallBack)localObject1).a(this.mApolloStatus, (ApolloWebAvatarParam)localObject2);
          continue;
          QLog.e("ApolloJsPlugin", 1, new Object[] { "[IPC_APOLLO_CHECK_AVATAR_RES] initAvatar abort, apolloId is detroyed, id=", ((ApolloWebAvatarParam)localObject2).apolloId });
          return;
          paramBundle = null;
          if ((this.mRuntime.a() instanceof BaseActivity)) {
            paramBundle = ((BaseActivity)this.mRuntime.a()).getAppInterface();
          }
          if (paramBundle != null)
          {
            ApolloResDownloader.a(paramBundle, ((ApolloWebAvatarParam)localObject2).uin, new ApolloJsPlugin.3(this, (ApolloWebAvatarParam)localObject2, (Activity)localObject1, j, str), ((ApolloWebAvatarParam)localObject2).roleId, ((ApolloWebAvatarParam)localObject2).dressIds, -1, -1, false);
            return;
          }
          callbackError(str, "获取AppInterface失败");
          return;
          label1732:
          if (j != 2) {
            break label97;
          }
          localObject3 = new AtomicInteger(0);
          if ((this.mRuntime.a() instanceof BaseActivity)) {}
          for (paramBundle = ((BaseActivity)this.mRuntime.a()).getAppInterface();; paramBundle = null)
          {
            localObject4 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (ApolloWebAvatarParam)((Iterator)localObject4).next();
              if (((ApolloWebAvatarParam)localObject5).isResExist)
              {
                localObject6 = new ArrayList();
                ((ArrayList)localObject6).add(localObject5);
                if (this.mValidAvatarIdList.contains(((ApolloWebAvatarParam)localObject5).apolloId))
                {
                  if (!(localObject1 instanceof IApolloActivityJsCallBack)) {
                    break label1893;
                  }
                  ((IApolloActivityJsCallBack)localObject1).a((ArrayList)localObject6);
                }
                for (;;)
                {
                  ((AtomicInteger)localObject3).getAndIncrement();
                  if (((AtomicInteger)localObject3).get() != ((ArrayList)localObject2).size()) {
                    break;
                  }
                  callbackOk(str);
                  break;
                  label1893:
                  if (this.mApolloViewContoller != null) {
                    this.mApolloViewContoller.a((ArrayList)localObject6);
                  }
                }
              }
              if (paramBundle != null)
              {
                ApolloResDownloader.a(paramBundle, ((ApolloWebAvatarParam)localObject5).uin, new ApolloJsPlugin.4(this, (ApolloWebAvatarParam)localObject5, (Activity)localObject1, (AtomicInteger)localObject3, (ArrayList)localObject2, str), ((ApolloWebAvatarParam)localObject5).roleId, ((ApolloWebAvatarParam)localObject5).dressIds, -1, -1, false);
              }
              else
              {
                QLog.e("ApolloJsPlugin", 1, new Object[] { "addAvatar, app null, uin=", ((ApolloWebAvatarParam)localObject5).uin });
                ((AtomicInteger)localObject3).getAndIncrement();
                if (((AtomicInteger)localObject3).get() == ((ArrayList)localObject2).size()) {
                  callbackOk(str);
                }
              }
            }
            break;
            if (j != 2) {
              QQToast.a((Context)localObject1, "下载素材角色装扮素材失败", 1).a();
            }
            callbackError(str, "下载素材角色装扮素材失败");
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ApolloJsPlugin", 2, "下载素材角色装扮素材失败->mRoleId" + this.mRoleId + " mDressIds->" + this.mDressIds);
            return;
            if ("ipc_apollo_changerole".equals(localObject3))
            {
              i = ((Bundle)localObject2).getInt("apollo_result");
              j = ((Bundle)localObject2).getInt("apollo_roleId");
              localObject1 = ((Bundle)localObject2).getIntArray("apollo_dressIds");
              if (localObject1 != null)
              {
                paramBundle = (Bundle)localObject1;
                if (localObject1.length > 0) {}
              }
              else
              {
                paramBundle = ApolloResDownloader.a(j);
              }
              this.mDressIds = paramBundle;
              this.mRoleId = j;
              this.mApolloStatus = 1;
              if ((i == 0) && (paramBundle != null) && (paramBundle.length > 0))
              {
                callbackOk(str);
                return;
              }
              callbackError(str, "参数不对，未下载成功");
              return;
            }
            if ("ipc_apollo_get_apollo_data".equals(localObject3))
            {
              this.mDataInited = true;
              i = ((Bundle)localObject2).getInt("apollo_initFrom");
              this.mRoleId = ((Bundle)localObject2).getInt("apollo_roleId");
              this.mGender = ((Bundle)localObject2).getInt("apollo_gender");
              this.mApolloStatus = ((Bundle)localObject2).getInt("apollo_apolloStatus");
              this.mDressIds = ((Bundle)localObject2).getIntArray("apollo_dressIds");
              this.mAISwitch = ((Bundle)localObject2).getInt("apollo_aiswitch");
              sRoleGender = ((Bundle)localObject2).getInt("apollo_roleGender");
              this.mIsAIRole = ((Bundle)localObject2).getBoolean("apollo_isAIRole");
              paramBundle = ((Bundle)localObject2).getString("apollo_aipush");
              localObject3 = ((Bundle)localObject2).getString("apollo_aipush_content");
              j = ((Bundle)localObject2).getInt("apollo_aipush_actionId");
              k = ((Bundle)localObject2).getInt("apollo_aipush_type");
              m = ((Bundle)localObject2).getInt("apollo_aiconfig");
              n = ((Bundle)localObject2).getInt("apollo_aiwhite");
              if ((localObject1 instanceof IApolloActivityJsCallBack)) {
                ((IApolloActivityJsCallBack)localObject1).a(m, n, this.mAISwitch, paramBundle, (String)localObject3, j, k);
              }
              if ("FAKE_CALLBACK_ID".equals(str))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloJsPlugin", 2, "初始化个人信息，不用callback");
                }
                if (!(localObject1 instanceof IApolloActivityJsCallBack)) {
                  break;
                }
                ((IApolloActivityJsCallBack)localObject1).b(this.mApolloStatus);
                return;
              }
              if (this.mRoleId <= 0)
              {
                if ((this.mGender != 1) && (this.mGender != 0)) {
                  break label2519;
                }
                this.mRoleId = 1;
              }
              for (;;)
              {
                if (3 == i)
                {
                  if ((this.mDressIds == null) || (this.mDressIds.length <= 0))
                  {
                    callbackError(str, "默认角色或获取本人信息失败");
                    if (!QLog.isColorLevel()) {
                      break;
                    }
                    QLog.d("ApolloJsPlugin", 2, "dressIds.array->默认角色或获取本人信息失败");
                    return;
                    label2519:
                    this.mRoleId = 2;
                    continue;
                  }
                  paramBundle = new JSONObject();
                  paramBundle.put("result", 0);
                  paramBundle.put("msg", "");
                  localObject1 = new JSONObject();
                  localObject2 = new JSONArray();
                  localObject3 = this.mDressIds;
                  j = localObject3.length;
                  i = 0;
                  while (i < j)
                  {
                    ((JSONArray)localObject2).put(Integer.valueOf(localObject3[i]));
                    i += 1;
                  }
                  ((JSONObject)localObject1).put("dressIds", localObject2);
                  paramBundle.put("data", localObject1);
                  super.callJs(str + "(" + paramBundle.toString() + ");");
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("ApolloJsPlugin", 2, "dressIds.array->" + localObject2);
                  return;
                }
              }
              if (2 == i)
              {
                if (this.mRoleId <= 0)
                {
                  callbackError(str, "默认角色或获取本人信息失败");
                  return;
                }
                paramBundle = new JSONObject();
                paramBundle.put("result", 0);
                paramBundle.put("msg", "");
                localObject1 = new JSONObject();
                ((JSONObject)localObject1).put("roleId", this.mRoleId);
                paramBundle.put("data", localObject1);
                super.callJs(str + "(" + paramBundle.toString() + ");");
                return;
              }
              if (4 != i) {
                break;
              }
              paramBundle = new JSONObject();
              paramBundle.put("result", 0);
              paramBundle.put("msg", "");
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("status", this.mApolloStatus);
              paramBundle.put("data", localObject1);
              super.callJs(str + "(" + paramBundle.toString() + ");");
              return;
            }
            if ("ipc_apollo_get_openapollo_friends".equals(localObject3))
            {
              i = ((Bundle)localObject2).getInt("apollo_result");
              paramBundle = ((Bundle)localObject2).getString("apollo_data");
              if (i == 0)
              {
                localObject1 = new JSONObject();
                ((JSONObject)localObject1).put("result", 0);
                ((JSONObject)localObject1).put("data", new JSONObject(paramBundle));
                super.callJs(str + "(" + ((JSONObject)localObject1).toString() + ");");
              }
              while (QLog.isColorLevel())
              {
                QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_GET_OPENAPOLLO_FRIENDS onResponse dataStr is:" + paramBundle);
                return;
                callbackError(str, "数据为空或查询数据有误");
              }
              break;
            }
            if ("ipc_apollo_query_mine_redinfo".equals(localObject3))
            {
              i = ((Bundle)localObject2).getInt("isNewFlag");
              if ((i == 1) && ((localObject1 instanceof IApolloActivityJsCallBack))) {
                ((IApolloActivityJsCallBack)localObject1).b();
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_QUERY_MINE_REDINFO onResponse dataInt is:" + i);
              return;
            }
            if ("ipc_apollo_getfav_action".equals(localObject3))
            {
              paramBundle = ((Bundle)localObject2).getString("getFavResult");
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("data", new JSONObject(paramBundle));
              ((JSONObject)localObject1).put("result", 0);
              super.callJs(str + "(" + ((JSONObject)localObject1).toString() + ");");
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_GETFAV_ACTION onResponse data is:" + ((JSONObject)localObject1).toString());
              return;
            }
            if ("ipc_apollo_add_fav_action".equals(localObject3))
            {
              paramBundle = ((Bundle)localObject2).getString("addFavAction");
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("data", new JSONObject(paramBundle));
              ((JSONObject)localObject1).put("result", 0);
              super.callJs(str + "(" + ((JSONObject)localObject1).toString() + ");");
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_ADD_FAV_ACTION onResponse data is:" + ((JSONObject)localObject1).toString());
              return;
            }
            if ("ipc_apollo_del_fav_action".equals(localObject3))
            {
              paramBundle = ((Bundle)localObject2).getString("delFavAction");
              i = new JSONObject(paramBundle).optInt("ret");
              localObject1 = new JSONObject();
              if (i == 0)
              {
                ((JSONObject)localObject1).put("data", new JSONObject(paramBundle));
                ((JSONObject)localObject1).put("result", 0);
                super.callJs(str + "(" + ((JSONObject)localObject1).toString() + ");");
              }
              while (QLog.isColorLevel())
              {
                QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_DEL_FAV_ACTION onResponse data is:" + ((JSONObject)localObject1).toString());
                return;
                if (i == 1) {
                  callbackError(str, "本地没有该动作");
                } else if (i == 2) {
                  callbackError(str, "删除动作失败");
                } else {
                  callbackError(str, "删除动作异常");
                }
              }
              break;
            }
            if ("ipc_apollo_del_fav_list".equals(localObject3))
            {
              paramBundle = new JSONObject(((Bundle)localObject2).getString("delFavListAction"));
              localObject1 = new JSONObject();
              if (paramBundle.optBoolean("delHasError")) {
                ((JSONObject)localObject1).put("result", 1);
              }
              for (;;)
              {
                ((JSONObject)localObject1).put("data", paramBundle.opt("errorList"));
                super.callJs(str + "(" + ((JSONObject)localObject1).toString() + ");");
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_DEL_FAV_List onResponse data is:" + ((JSONObject)localObject1).toString());
                return;
                ((JSONObject)localObject1).put("result", 0);
              }
            }
            if ("ipc_apollo_write_local".equals(localObject3))
            {
              paramBundle = new JSONObject(((Bundle)localObject2).getString("writeRet"));
              super.callJs(str + "(" + paramBundle.toString() + ");");
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_WRITE_LOCAL onResponse data is:" + paramBundle.toString());
              return;
            }
            if ("ipc_apollo_downloadImageOnFrame".equals(localObject3))
            {
              if (!(localObject1 instanceof IApolloActivityJsCallBack)) {
                break;
              }
              ((IApolloActivityJsCallBack)localObject1).b(str);
              return;
            }
            if (("ipc_apollo_add_game".equals(localObject3)) || ("ipc_apollo_del_game".equals(localObject3)))
            {
              paramBundle = String.format("%s({\"result\":%d, \"message\":\"%s\"});", new Object[] { str, Integer.valueOf(((Bundle)localObject2).getInt("result")), ((Bundle)localObject2).getString("message") });
              super.callJs(paramBundle);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("ApolloJsPlugin", 2, new Object[] { "cmd=", localObject3, ", callbackStr=", paramBundle });
              return;
            }
            if ("ipc_apollo_start_apollo_game".equals(localObject3))
            {
              if (((Bundle)localObject2).getInt("result") == 0)
              {
                callbackOk(str);
                return;
              }
              callbackError(str, "启动失败");
              return;
            }
            if ("ipc_apollo_choose_friend_play_game".equals(localObject3))
            {
              i = ((Bundle)localObject2).getInt("gameId");
              j = ((Bundle)localObject2).getInt("gameMode");
              if (((Bundle)localObject2).getBoolean("hasGameRunning"))
              {
                this.gameDialog = DialogUtil.b((Context)localObject1, 0, "", "当前正在游戏中，确认加入新的游戏?", 2131433015, 2131433016, new ApolloJsPlugin.5(this, i, j, (Activity)localObject1), new ApolloJsPlugin.6(this));
                if ((localObject1 instanceof BaseActivity)) {
                  VipUtils.a(((BaseActivity)localObject1).getAppInterface(), "cmshow", "Apollo", "game_alert_show", 3, 0, new String[0]);
                }
                this.gameDialog.show();
                return;
              }
              paramBundle = new ApolloPanel.GameMsgInfo();
              paramBundle.e = i;
              ApolloGameBasicEventUtil.a(paramBundle, this.mRuntime.a(), 2);
              return;
            }
            if ("IPC_APOLLO_DOWNLOAD_GAME".equals(localObject3))
            {
              paramBundle = (CmGameStartChecker.StartCheckParam)((Bundle)localObject2).getSerializable("StartCheckParam");
              if (paramBundle == null)
              {
                callbackError(str, "参数有误，下载失败");
                return;
              }
              localObject2 = CmGameUtil.a();
              this.mCmGameStartChecker = new CmGameStartChecker((AppInterface)localObject2);
              this.mCmGameStartCheckerListener = new ApolloJsPlugin.7(this, (AppInterface)localObject2, str, (Activity)localObject1);
              this.mCmGameStartChecker.a(paramBundle, this.mCmGameStartCheckerListener);
              return;
            }
            if ("ipc_apollo_update_game_list".equals(localObject3))
            {
              paramBundle = String.format("%s({\"result\":%d});", new Object[] { str, Integer.valueOf(((Bundle)localObject2).getInt("result")) });
              if (QLog.isColorLevel()) {
                QLog.d("ApolloJsPlugin", 2, new Object[] { "IPC_APOLLO_UPDATE_GAME_LIST, result=", paramBundle });
              }
              super.callJs(paramBundle);
              return;
            }
            if ("ipc_apollo_add_cm_face".equals(localObject3))
            {
              paramBundle = String.format("%s({\"result\":%d,\"msg\":\"%s\"});", new Object[] { str, Integer.valueOf(((Bundle)localObject2).getInt("result")), ((Bundle)localObject2).getString("msg") });
              if (QLog.isColorLevel()) {
                QLog.d("ApolloJsPlugin", 2, new Object[] { "IPC_APOLLO_ADD_CM_FACE, result=", paramBundle });
              }
              super.callJs(paramBundle);
              return;
            }
            if ("ipc_apollo_is_cm_face_added".equals(localObject3))
            {
              i = ((Bundle)localObject2).getInt("result");
              paramBundle = ((Bundle)localObject2).getString("msg");
              paramBundle = String.format("%s({\"result\":%d,\"data\":{\"status\":%s}, \"msg\":\"%s\"});", new Object[] { str, Integer.valueOf(i), ((Bundle)localObject2).getString("status"), paramBundle });
              if (QLog.isColorLevel()) {
                QLog.d("ApolloJsPlugin", 2, new Object[] { "IPC_APOLLO_IS_CM_FACE_ADDED, result=", paramBundle });
              }
              super.callJs(paramBundle);
              return;
            }
            if ("ipc_apollo_setcapsule".equals(localObject3))
            {
              if (((Bundle)localObject2).getInt("result") == 0)
              {
                callbackOk(str);
                return;
              }
              callbackError(str, "result != 0");
              return;
            }
            super.onResponse(paramBundle);
            return;
          }
          label4583:
          if (j == 1) {
            break label1496;
          }
          if (j != 0) {
            break;
          }
          break label1496;
          label4597:
          paramBundle = "{\"result\":1, \"msg\": \"终端初始化错误\" }";
          continue;
        }
        paramBundle = "{\"result\":1, \"msg\": \"非商城页面\" }";
      }
    }
  }
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloJsPlugin", 2, "Avatar view is Ready.");
    }
  }
  
  public void sendRemoteReq(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.sendRemoteReq(paramBundle, paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin
 * JD-Core Version:    0.7.0.1
 */