package com.tencent.mobileqq.vaswebviewplugin;

import alnr;
import alpu;
import alqx;
import alsc;
import alvm;
import alvx;
import alxy;
import amdp;
import amec;
import ameg;
import amej;
import amez;
import amfw;
import amfy;
import amip;
import amja;
import ammz;
import amtj;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqyp;
import aqyt;
import bfur;
import bgtw;
import bgve;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.lightGame.CmGameFragment;
import com.tencent.mobileqq.apollo.store.ApolloFloatActivity;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.Serializable;
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
  implements alqx
{
  public static final String BUSINESS_NAME = "apollo";
  private static final int DEFAULT_HEIGHT = (int)(DeviceInfoUtil.getHeight() * 0.4D / DeviceInfoUtil.getDesity());
  private static final int DEFAULT_WIDTH = (int)((float)(DeviceInfoUtil.getWidth() >> 1) / DeviceInfoUtil.getDesity());
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
  private amec mApolloViewContoller;
  private CmGameStartChecker mCmGameStartChecker;
  private alsc mCmGameStartCheckerListener;
  private String mCurrentUin;
  private boolean mDataInited;
  private int[] mDressIds;
  private int mGender;
  public boolean mHasInited;
  protected amfw mInterceptor;
  public boolean mIsAIRole;
  private long mLastGameTime;
  private boolean mNeedCreateInterceptor;
  public Bundle mReqBundle;
  private int mRoleId = -1;
  private amez mRscLoader;
  private String mTab;
  private Vector<String> mValidAvatarIdList = new Vector();
  
  public ApolloJsPlugin()
  {
    this.mPluginNameSpace = "apollo";
    if (QLog.isColorLevel()) {
      QLog.d("ApolloJsPlugin", 2, "apollo_client onApolloJsCreate");
    }
    ApolloEngine.a();
    alpu.a();
  }
  
  public ApolloJsPlugin(String paramString)
  {
    this.mPluginNameSpace = "apollo";
    if (amfy.a())
    {
      this.mNeedCreateInterceptor = false;
      this.mInterceptor = amfw.a(true, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, "apollo_client onApolloJsCreate ApolloWebDataHandler.isInstanceCreated():true");
      }
    }
    for (;;)
    {
      ApolloEngine.a();
      alpu.a();
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
    ThreadManager.getUIHandler().post(new ApolloJsPlugin.9(this, paramInt));
  }
  
  private String getAbsoluteUrl()
  {
    if (this.mRuntime != null)
    {
      CustomWebView localCustomWebView = this.mRuntime.a();
      if (localCustomWebView != null) {
        return localCustomWebView.getUrl();
      }
    }
    return "";
  }
  
  void callbackError(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 1);
      localJSONObject.put("msg", paramString2);
      super.callJs(paramString1 + "&&" + paramString1 + "(" + localJSONObject.toString() + ");");
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
      super.callJs(paramString + "&&" + paramString + "(" + localJSONObject.toString() + ");");
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
      QQToast.a(paramContext, amtj.a(2131699579), 0).a();
      return false;
    }
    return true;
  }
  
  public amfw getIntercepter()
  {
    return this.mInterceptor;
  }
  
  public int getRemoteKey()
  {
    return this.mOnRemoteResp.key;
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    Object localObject2;
    if (paramLong == 8L) {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloJsPlugin", 1, " handleEvent url:" + paramString);
        }
        Object localObject1;
        if (this.mInterceptor != null)
        {
          localObject3 = this.mInterceptor.a(paramString);
          if (localObject3 != null)
          {
            localObject1 = localObject3;
            if (!QLog.isColorLevel()) {
              break label236;
            }
            QLog.d("ApolloJsPlugin", 1, "apollo_client handleEvent response-> " + localObject3 + ",url:" + paramString);
            return localObject3;
          }
        }
        if (this.mRscLoader == null) {
          this.mRscLoader = new amez(this);
        }
        Object localObject3 = this.mRscLoader.a(paramString);
        if (localObject3 != null)
        {
          localObject1 = localObject3;
          if (!QLog.isColorLevel()) {
            break label236;
          }
          QLog.d("ApolloJsPlugin", 1, "mRscLoader handleEvent response-> " + localObject3 + ",url:" + paramString);
          return localObject3;
        }
      }
      catch (Exception localException)
      {
        QLog.e("ApolloJsPlugin", 1, "handleEvent intercept by apolloClient error -> " + localException.getMessage());
      }
    } else {
      localObject2 = super.handleEvent(paramString, paramLong);
    }
    label236:
    return localObject2;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (32L == paramLong)
    {
      if ((this.mNeedCreateInterceptor) && (this.mInterceptor == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloJsPlugin", 1, "apollo_client handleEvent reinited ApolloUrlInterceptor,url:" + paramString);
        }
        this.mInterceptor = amfw.a(true, paramString);
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
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloJsPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"apollo".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    paramVarArgs = null;
    try
    {
      localObject1 = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (localObject1 == null) {
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, "handleJsRequest JSON = " + ((JSONObject)localObject1).toString());
      }
      paramString2 = ((JSONObject)localObject1).optString("callback");
      if (paramString2 != null) {
        break label245;
      }
      try
      {
        throw new Exception("need callbackId");
      }
      catch (Throwable paramJsBridgeListener)
      {
        paramString1 = paramString2;
      }
    }
    catch (Throwable paramJsBridgeListener)
    {
      for (;;)
      {
        Object localObject1;
        int k;
        paramString1 = paramVarArgs;
        continue;
        continue;
        int j = 0;
        continue;
        paramJsBridgeListener = null;
        boolean bool2 = bool1;
        break label10105;
        continue;
        continue;
        int i = 0;
        continue;
        i += 1;
        continue;
        boolean bool1 = false;
        continue;
        bool1 = false;
        continue;
        i += 1;
        bool1 = bool2;
        continue;
        paramJsBridgeListener = null;
        continue;
        bool1 = false;
        continue;
        i += 1;
        bool1 = bool2;
        continue;
        i = j;
        if (!bool2)
        {
          i = 1;
          continue;
          k += 1;
          bool1 = bool2;
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
      super.callJs(paramString1 + "&&" + paramString1 + "(" + paramString2.toString() + ");");
      label245:
      do
      {
        for (;;)
        {
          return true;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloJsPlugin", 2, "json:" + localObject1);
          }
          paramVarArgs = this.mRuntime.a();
          if ((paramVarArgs == null) || (this.isDestroy) || (paramVarArgs.isFinishing()))
          {
            callbackError(paramString2, amtj.a(2131699586));
            return true;
          }
          if ("startRecord".equals(paramString3))
          {
            j = ((JSONObject)localObject1).optInt("maxDuration", 5);
            if (j <= 100) {
              break label10038;
            }
            j = 100;
            i = 1;
            if (Build.VERSION.SDK_INT >= 23)
            {
              if (paramVarArgs.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
                break label10041;
              }
              i = 1;
            }
            if (i == 0)
            {
              if ((paramVarArgs instanceof BaseActivity)) {
                ((BaseActivity)paramVarArgs).requestPermissions(new ApolloJsPlugin.2(this, paramVarArgs), 2, new String[] { "android.permission.RECORD_AUDIO" });
              }
              callbackError(paramString2, "don't have permission!");
            }
            else
            {
              this.mReqBundle.clear();
              this.mReqBundle.putInt("maxDuration", j);
              super.sendRemoteReq(aqyt.a("ipc_apollo_start_record_msg", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
            }
          }
          else if ("stopRecord".equals(paramString3))
          {
            super.sendRemoteReq(aqyt.a("ipc_apollo_stop_record_msg", paramString2, this.mOnRemoteResp.key, null), false, true);
          }
          else if ("startUploadRecord".equals(paramString3))
          {
            super.sendRemoteReq(aqyt.a("ipc_apollo_upload_record_msg", paramString2, this.mOnRemoteResp.key, null), false, true);
          }
          else if ("startPlayLastRecord".equals(paramString3))
          {
            paramJsBridgeListener = ((JSONObject)localObject1).optString("url", "");
            this.mReqBundle.clear();
            this.mReqBundle.putString("url", paramJsBridgeListener);
            super.sendRemoteReq(aqyt.a("ipc_apollo_play_last_record_msg", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
          }
          else if ("stopPlayLastRecord".equals(paramString3))
          {
            super.sendRemoteReq(aqyt.a("ipc_apollo_stop_last_record_msg", paramString2, this.mOnRemoteResp.key, null), false, true);
          }
          else if ("getPlaymateMsgList".equals(paramString3))
          {
            paramJsBridgeListener = ((JSONObject)localObject1).optJSONArray("uinList");
            if (paramJsBridgeListener != null)
            {
              this.mReqBundle.clear();
              this.mReqBundle.putString("uinList", paramJsBridgeListener.toString());
              super.sendRemoteReq(aqyt.a("ipc_apollo_get_playmate_msg", paramString2, this.mOnRemoteResp.key, this.mReqBundle), true, true);
            }
            else
            {
              callbackError(paramString2, "uinList is null");
            }
          }
          else if ("openCmGameAio".equals(paramString3))
          {
            paramJsBridgeListener = ((JSONObject)localObject1).optString("friendUin");
            paramString1 = ((JSONObject)localObject1).optString("nickName");
            i = ((JSONObject)localObject1).optInt("src");
            if (!TextUtils.isEmpty(paramJsBridgeListener))
            {
              this.mReqBundle.clear();
              this.mReqBundle.putString("friendUin", paramJsBridgeListener);
              if (!TextUtils.isEmpty(paramString1)) {
                this.mReqBundle.putString("nickName", paramString1);
              }
              this.mReqBundle.putInt("src", i);
              super.sendRemoteReq(aqyt.a("ipc_apollo_open_cmgame_aio", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
              callbackOk(paramString2);
            }
            else
            {
              callbackError(paramString2, "friendUin is empty");
            }
          }
          else if ("isApolloEngineReady".equals(paramString3))
          {
            if (ApolloEngine.a()) {
              callbackOk(paramString2);
            }
            for (;;)
            {
              if (!QLog.isColorLevel()) {
                break label934;
              }
              QLog.d("ApolloJsPlugin", 2, new Object[] { "isApolloEngineReady:", Boolean.valueOf(ApolloEngine.a()) });
              break;
              callbackError(paramString2, "ApolloEngine is not ready");
            }
          }
          else if ("clearThunderCache".equals(paramString3))
          {
            paramJsBridgeListener = new File(amip.jdField_a_of_type_JavaLangString + "/webview/");
            if (paramJsBridgeListener.exists())
            {
              paramJsBridgeListener = paramJsBridgeListener.listFiles();
              if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length > 0))
              {
                j = paramJsBridgeListener.length;
                i = 0;
                if (i < j)
                {
                  paramString1 = paramJsBridgeListener[i];
                  if ((!paramString1.isDirectory()) || (!new File(paramString1, paramString1.getName() + ".txt").exists())) {
                    break label10047;
                  }
                  FileUtils.deleteDirectory(paramString1.getAbsolutePath());
                  if (!QLog.isColorLevel()) {
                    break label10047;
                  }
                  QLog.d("ApolloJsPlugin", 2, "clearThunderCache, htmlFileDir:" + paramString1.getName());
                  break label10047;
                }
              }
            }
            callbackOk(paramString2);
          }
          else if ("stopThunderCache".equals(paramString3))
          {
            amfy.a().b();
            callbackOk(paramString2);
          }
          else if ("resumeThunderCache".equals(paramString3))
          {
            amfy.a().c();
            callbackOk(paramString2);
          }
          else
          {
            long l;
            Object localObject3;
            int m;
            Object localObject2;
            if ("startApolloGame".equals(paramString3))
            {
              l = System.currentTimeMillis();
              if (l - this.mLastGameTime <= 1000L)
              {
                callbackError(paramString2, amtj.a(2131699568));
                return true;
              }
              this.mLastGameTime = l;
              j = ((JSONObject)localObject1).optInt("gameId");
              l = ((JSONObject)localObject1).optLong("roomId");
              if (((JSONObject)localObject1).optInt("isCreator", 1) != 1) {
                break label10056;
              }
              bool1 = true;
              i = 1;
              if (((JSONObject)localObject1).has("gameMode")) {
                i = ((JSONObject)localObject1).optInt("gameMode");
              }
              k = ((JSONObject)localObject1).optInt("src");
              paramString3 = ((JSONObject)localObject1).optString("gameParam");
              paramString1 = ((JSONObject)localObject1).optString("friendUin");
              paramJsBridgeListener = ((JSONObject)localObject1).optString("friendOpenId");
              bool2 = ((JSONObject)localObject1).optBoolean("isEnterAIO");
              if (!TextUtils.isEmpty(paramJsBridgeListener)) {
                break label10035;
              }
              paramJsBridgeListener = paramString1;
              localObject3 = ((JSONObject)localObject1).optString("uinName");
              m = ((JSONObject)localObject1).optInt("openTempAIOOnFinish");
              localObject2 = ((JSONObject)localObject1).optString("tempAIOUin");
              String str1 = ((JSONObject)localObject1).optString("tempAIONickName");
              String str2 = ((JSONObject)localObject1).optString("gameName");
              if ((paramVarArgs != null) && (!paramVarArgs.isFinishing()))
              {
                if (bool2)
                {
                  localObject1 = new Bundle();
                  ((Bundle)localObject1).putString("uin", paramString1);
                  ((Bundle)localObject1).putInt("uintype", 0);
                  ((Bundle)localObject1).putString("troop_uin", "");
                  ((Bundle)localObject1).putString("uinname", (String)localObject3);
                  ((Bundle)localObject1).putBoolean("launchApolloGame", true);
                  ((Bundle)localObject1).putInt("gameId", j);
                  ((Bundle)localObject1).putInt("gameMode", i);
                  ((Bundle)localObject1).putString("openId", paramJsBridgeListener);
                  ((Bundle)localObject1).putString("gameParam", paramString3);
                  ((Bundle)localObject1).putString("gameName", str2);
                  ((Bundle)localObject1).putInt("src", k);
                  ((Bundle)localObject1).putInt("enter", 3);
                  paramJsBridgeListener = AIOUtils.setOpenAIOIntent(new Intent(paramVarArgs, SplashActivity.class), new int[] { 2 });
                  paramJsBridgeListener.putExtras((Bundle)localObject1);
                  paramVarArgs.startActivity(paramJsBridgeListener);
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "[startApolloGame] openAIO:" + ((Bundle)localObject1).toString());
                  }
                  callbackOk(paramString2);
                }
                else
                {
                  paramString1 = new CmGameStartChecker.StartCheckParam(j, bool1, "luanch", l, 4, i, 0, 0, "", k, str2);
                  paramString1.mExtraStr = ((JSONObject)localObject1).toString();
                  paramString1.extendJson = paramString3;
                  paramString1.mFriendUin = paramJsBridgeListener;
                  paramString1.mTempAIONickName = str1;
                  paramString1.mTempAIOUin = ((String)localObject2);
                  if (m != 1) {
                    break label10062;
                  }
                  bool1 = true;
                  paramString1.mOpenTempAIOOnFinish = bool1;
                  if (paramString1.src == 318) {
                    paramString1.disableMinGame = true;
                  }
                  if (!TextUtils.isEmpty(paramString3))
                  {
                    paramJsBridgeListener = ApolloUtil.a(paramString3, "rbOpenId");
                    if (!TextUtils.isEmpty(paramJsBridgeListener))
                    {
                      paramString1.mRobotOpenId = paramJsBridgeListener;
                      if (ApolloUtil.a(paramString3, "gameId") > 0) {
                        paramString1.gameId = j;
                      }
                      paramString1.src = 318001;
                      paramString1.disableMinGame = true;
                      alvm.a((String)localObject2);
                    }
                  }
                  this.mReqBundle.clear();
                  this.mReqBundle.putSerializable("StartCheckParam", paramString1);
                  super.sendRemoteReq(aqyt.a("ipc_apollo_start_apollo_game", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                }
              }
              else {
                callbackError(paramString2, amtj.a(2131699562));
              }
            }
            else
            {
              if ("checkGameStatus".equals(paramString3))
              {
                if (!FileUtils.hasSDCardAndWritable())
                {
                  callbackError(paramString2, "sdcard未装");
                  return true;
                }
                if (FileUtils.getAvailableExternalMemorySize() < 52428800.0F)
                {
                  callbackError(paramString2, amtj.a(2131699567));
                  return true;
                }
                i = ((JSONObject)localObject1).optInt("gameId");
                this.mReqBundle.clear();
                this.mReqBundle.putInt("gameId", i);
                paramJsBridgeListener = aqyt.a("IPC_APOLLO_DOWNLOAD_GAME", paramString2, this.mOnRemoteResp.key, this.mReqBundle);
                this.alreadyCallBack = false;
                super.sendRemoteReq(paramJsBridgeListener, false, true);
                return true;
              }
              if ("chooseFriendPlayGame".equals(paramString3))
              {
                i = ((JSONObject)localObject1).optInt("gameId");
                paramJsBridgeListener = new ammz();
                paramJsBridgeListener.jdField_a_of_type_Int = i;
                amja.a(paramJsBridgeListener, this.mRuntime.a(), 2);
                return true;
              }
              if ("dispatchGameEvent".equals(paramString3))
              {
                paramJsBridgeListener = alvx.a();
                if (paramJsBridgeListener != null) {
                  paramJsBridgeListener.c(((JSONObject)localObject1).toString());
                }
                callbackOk(paramString2);
              }
              else if ("setBackViewVisibility".equals(paramString3))
              {
                i = ((JSONObject)localObject1).optInt("visibility");
                if ((paramVarArgs instanceof amej))
                {
                  ((amej)paramVarArgs).c(i);
                  callbackOk(paramString2);
                }
                else
                {
                  callbackError(paramString2, "ApolloViewController not inited or not ApolloStoreActivity");
                }
              }
              else if ("openApolloShareFloatView".equals(paramString3))
              {
                paramString1 = ((JSONObject)localObject1).optString("backgroundImage");
                paramString3 = ((JSONObject)localObject1).optString("nickName");
                paramJsBridgeListener = null;
                if ((this.mRuntime.a() instanceof BaseActivity)) {
                  paramJsBridgeListener = ((BaseActivity)this.mRuntime.a()).getAppInterface();
                }
                if (this.mApolloViewContoller != null)
                {
                  this.mApolloViewContoller.a(paramVarArgs, paramJsBridgeListener, paramString1, paramString3);
                  callbackOk(paramString2);
                }
                else if ((paramVarArgs instanceof amej))
                {
                  ((amej)paramVarArgs).a(paramVarArgs, paramString1, paramString3);
                  callbackOk(paramString2);
                }
                else
                {
                  callbackError(paramString2, "ApolloViewController not inited or not ApolloStoreActivity");
                }
              }
              else if ("openDiyActionFloatView".equals(paramString3))
              {
                paramJsBridgeListener = ((JSONObject)localObject1).optString("defaultText");
                if ((paramVarArgs instanceof amej)) {
                  ((amej)paramVarArgs).a(paramJsBridgeListener);
                } else {
                  callbackError(paramString2, amtj.a(2131699596));
                }
              }
              else if ("sayHi".equals(paramString3))
              {
                if ((paramVarArgs instanceof amej))
                {
                  paramJsBridgeListener = ((amej)paramVarArgs).a();
                  super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener + ");");
                }
                else if (this.mApolloViewContoller != null)
                {
                  paramJsBridgeListener = this.mApolloViewContoller.a();
                  super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener + ");");
                }
                else
                {
                  callbackError(paramString2, "ApolloViewController not inited or not ApolloStoreActivity");
                }
              }
              else if ("setCapsuleOpened".equals(paramString3))
              {
                paramJsBridgeListener = ((JSONObject)localObject1).optString("uin");
                if (TextUtils.isEmpty(paramJsBridgeListener))
                {
                  callbackError(paramString2, "uin is empty");
                }
                else
                {
                  this.mReqBundle.clear();
                  this.mReqBundle.putString("apollo_uin", paramJsBridgeListener);
                  super.sendRemoteReq(aqyt.a("ipc_apollo_setcapsule", paramString2, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                }
              }
              else if ("openBox".equals(paramString3))
              {
                paramJsBridgeListener = ((JSONObject)localObject1).optString("uin");
                if ((paramVarArgs instanceof amej))
                {
                  paramJsBridgeListener = ((amej)paramVarArgs).a(paramJsBridgeListener);
                  super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener + ");");
                }
                else
                {
                  callbackError(paramString2, amtj.a(2131699602));
                }
              }
              else if ("setApolloViewVisibility".equals(paramString3))
              {
                i = ((JSONObject)localObject1).optInt("visibility", 0);
                if ((paramVarArgs instanceof amej))
                {
                  ((amej)paramVarArgs).d(i);
                  callbackOk(paramString2);
                  return true;
                }
                if (this.mApolloViewContoller == null)
                {
                  callbackError(paramString2, "ApolloViewController is null");
                  return false;
                }
                this.mApolloViewContoller.b(i);
                callbackOk(paramString2);
              }
              else if ("initApolloView".equals(paramString3))
              {
                if (!ApolloEngine.a())
                {
                  callbackError(paramString2, "engine is not ready");
                  return false;
                }
                if ((this.mApolloViewContoller == null) && ((this.mRuntime.a().getParent() instanceof RelativeLayout)))
                {
                  this.mApolloViewContoller = new amec((RelativeLayout)this.mRuntime.a().getParent(), null);
                  this.mApolloViewContoller.a(this);
                }
                if (this.mApolloViewContoller == null)
                {
                  callbackError(paramString2, "ApolloViewController is null");
                  return false;
                }
                i = ((JSONObject)localObject1).optInt("disableTouch", 0);
                j = ((JSONObject)localObject1).optInt("scrollByWebView", 0);
                if ((this.mRuntime.a() instanceof TouchWebView))
                {
                  paramString1 = (TouchWebView)this.mRuntime.a();
                  if (j <= 0) {
                    break label10081;
                  }
                  paramJsBridgeListener = this.mApolloViewContoller;
                  paramString1.setOnScrollChangedListener(paramJsBridgeListener);
                }
                paramJsBridgeListener = this.mApolloViewContoller;
                if (i <= 0) {
                  break label10086;
                }
                bool1 = true;
                paramJsBridgeListener.b(bool1);
                paramString3 = new ApolloWebAvatarParam();
                paramString3.isMain = true;
                paramString3.apolloId = ((JSONObject)localObject1).optString("apolloId", "me");
                paramString3.x = ((JSONObject)localObject1).optInt("x", DEFAULT_WIDTH);
                paramString3.y = ((JSONObject)localObject1).optInt("y", DEFAULT_HEIGHT);
                paramString3.uin = ((JSONObject)localObject1).optString("uin");
                if (TextUtils.isEmpty(paramString3.uin)) {
                  paramString3.uin = this.mRuntime.a().getCurrentAccountUin();
                }
                paramString3.nickName = ((JSONObject)localObject1).optString("nickName");
                paramString3.type = 0;
                paramString3.tab = "mall";
                paramString3.rate = ((float)((JSONObject)localObject1).optDouble("rate", 0.0D));
                paramString3.roleId = ((JSONObject)localObject1).optInt("roleId");
                paramJsBridgeListener = ((JSONObject)localObject1).optJSONArray("tapRect");
                if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length() >= 4))
                {
                  paramString3.tapRectX = paramJsBridgeListener.getInt(0);
                  paramString3.tapRectY = paramJsBridgeListener.getInt(1);
                  paramString3.tapRectWidth = paramJsBridgeListener.getInt(2);
                  paramString3.tapRectHeight = paramJsBridgeListener.getInt(3);
                }
                paramJsBridgeListener = ((JSONObject)localObject1).optJSONArray("dressIds");
                bool1 = false;
                if (paramString3.roleId > 0) {
                  bool1 = ApolloUtil.d(paramString3.roleId);
                }
                bool2 = bool1;
                if (paramJsBridgeListener != null)
                {
                  bool2 = bool1;
                  if (paramJsBridgeListener.length() > 0)
                  {
                    j = paramJsBridgeListener.length();
                    paramString3.dressIds = new int[j];
                    i = 0;
                    bool2 = bool1;
                    if (i < j)
                    {
                      k = paramJsBridgeListener.getInt(i);
                      paramString3.dressIds[i] = k;
                      bool2 = bool1;
                      if (paramString3.roleId <= 0) {
                        break label10068;
                      }
                      bool2 = bool1;
                      if (!bool1) {
                        break label10068;
                      }
                      bool2 = ApolloUtil.c(k);
                      break label10068;
                    }
                  }
                }
                paramString3.isResExist = bool2;
                this.mValidAvatarIdList.clear();
                this.mValidAvatarIdList.add(paramString3.apolloId);
                if (!bool2)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "initApolloView, should request resource");
                  }
                  paramVarArgs = new ArrayList(1);
                  paramVarArgs.add(paramString3);
                  this.mReqBundle.clear();
                  paramString1 = ((JSONObject)localObject1).optString("reqUrl");
                  paramJsBridgeListener = paramString1;
                  if (TextUtils.isEmpty(paramString1)) {
                    paramJsBridgeListener = getAbsoluteUrl();
                  }
                  if (!TextUtils.isEmpty(paramJsBridgeListener)) {
                    this.mReqBundle.putString("reqUrl", paramJsBridgeListener);
                  }
                  this.mReqBundle.putInt("from", 1);
                  this.mReqBundle.putSerializable("apolloList", paramVarArgs);
                  super.sendRemoteReq(aqyt.a("ipc_apollo_check_avatar_res", paramString2, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                  this.mApolloViewContoller.a(true, paramString3.x, paramString3.y);
                }
                else
                {
                  paramJsBridgeListener = this.mApolloViewContoller.a(1, true, paramString3);
                  super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener + ");");
                }
              }
              else if ("initAvatar".equals(paramString3))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloJsPlugin", 2, "initAvatar");
                }
                if (!amej.class.isInstance(paramVarArgs))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "initAvatar, not ApolloStoreActivity");
                  }
                  if ((paramVarArgs instanceof BaseActivity))
                  {
                    paramJsBridgeListener = ((BaseActivity)paramVarArgs).getAppInterface();
                    ApolloUtil.a(paramVarArgs, null, "share", this.mRuntime.a().getUrl(), paramJsBridgeListener);
                  }
                  ThreadManager.getSubThreadHandler().postDelayed(new ApolloJsPlugin.3(this, paramVarArgs), 2000L);
                }
                j = 0;
                localObject2 = new ApolloWebAvatarParam();
                ((ApolloWebAvatarParam)localObject2).isMain = true;
                ((ApolloWebAvatarParam)localObject2).apolloId = ((JSONObject)localObject1).optString("apolloId", "me");
                ((ApolloWebAvatarParam)localObject2).type = ((JSONObject)localObject1).optInt("type");
                ((ApolloWebAvatarParam)localObject2).x = ((JSONObject)localObject1).optInt("x", DEFAULT_WIDTH);
                ((ApolloWebAvatarParam)localObject2).y = ((JSONObject)localObject1).optInt("y", DEFAULT_HEIGHT);
                this.mTab = ((JSONObject)localObject1).optString("tab");
                ((ApolloWebAvatarParam)localObject2).tab = this.mTab;
                ((ApolloWebAvatarParam)localObject2).rate = ((float)((JSONObject)localObject1).optDouble("rate", 0.0D));
                ((ApolloWebAvatarParam)localObject2).uin = ((JSONObject)localObject1).optString("uin");
                ((ApolloWebAvatarParam)localObject2).nickName = ((JSONObject)localObject1).optString("nickName");
                ((ApolloWebAvatarParam)localObject2).greeting = ((JSONObject)localObject1).optString("greeting");
                paramString3 = this.mRuntime.a().getCurrentAccountUin();
                if (TextUtils.isEmpty(((ApolloWebAvatarParam)localObject2).uin)) {
                  ((ApolloWebAvatarParam)localObject2).uin = paramString3;
                }
                this.mCurrentUin = ((ApolloWebAvatarParam)localObject2).uin;
                ((ApolloWebAvatarParam)localObject2).roleId = ((JSONObject)localObject1).optInt("roleId");
                paramJsBridgeListener = ((JSONObject)localObject1).optJSONArray("tapRect");
                if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length() >= 4))
                {
                  ((ApolloWebAvatarParam)localObject2).tapRectX = paramJsBridgeListener.getInt(0);
                  ((ApolloWebAvatarParam)localObject2).tapRectY = paramJsBridgeListener.getInt(1);
                  ((ApolloWebAvatarParam)localObject2).tapRectWidth = paramJsBridgeListener.getInt(2);
                  ((ApolloWebAvatarParam)localObject2).tapRectHeight = paramJsBridgeListener.getInt(3);
                }
                bool1 = false;
                if (((ApolloWebAvatarParam)localObject2).roleId > 0) {
                  bool1 = ApolloUtil.d(((ApolloWebAvatarParam)localObject2).roleId);
                }
                paramJsBridgeListener = ((JSONObject)localObject1).optJSONArray("dressIds");
                l = ((JSONObject)localObject1).optLong("avatarTs");
                if ((paramJsBridgeListener == null) || (paramJsBridgeListener.length() <= 0)) {
                  break label10026;
                }
                k = paramJsBridgeListener.length();
                paramString1 = new int[k];
                i = 0;
                if (i < k)
                {
                  paramString1[i] = paramJsBridgeListener.getInt(i);
                  bool2 = bool1;
                  if (((ApolloWebAvatarParam)localObject2).roleId <= 0) {
                    break label10092;
                  }
                  bool2 = bool1;
                  if (!bool1) {
                    break label10092;
                  }
                  bool2 = ApolloUtil.c(paramString1[i]);
                  break label10092;
                }
                ((ApolloWebAvatarParam)localObject2).dressIds = paramString1;
                bool2 = bool1;
                paramJsBridgeListener = paramString1;
                if (!this.mCurrentUin.equals(paramString3)) {
                  break label10105;
                }
                this.mRoleId = ((ApolloWebAvatarParam)localObject2).roleId;
                this.mDressIds = paramString1;
                bool2 = bool1;
                paramJsBridgeListener = paramString1;
                break label10105;
                this.mValidAvatarIdList.clear();
                this.mValidAvatarIdList.add(((ApolloWebAvatarParam)localObject2).apolloId);
                if ((paramVarArgs instanceof amej))
                {
                  paramVarArgs = (amej)paramVarArgs;
                  if (i != 0)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ApolloJsPlugin", 2, "initAvatar, should request resource");
                    }
                    localObject3 = new ArrayList(1);
                    ((ArrayList)localObject3).add(localObject2);
                    this.mReqBundle.clear();
                    paramString3 = ((JSONObject)localObject1).optString("reqUrl");
                    paramString1 = paramString3;
                    if (TextUtils.isEmpty(paramString3)) {
                      paramString1 = getAbsoluteUrl();
                    }
                    if (!TextUtils.isEmpty(paramString1)) {
                      this.mReqBundle.putString("reqUrl", paramString1);
                    }
                    this.mReqBundle.putInt("from", 0);
                    this.mReqBundle.putSerializable("apolloList", (Serializable)localObject3);
                    super.sendRemoteReq(aqyt.a("ipc_apollo_check_avatar_res", paramString2, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                    paramVarArgs.a(true, ((ApolloWebAvatarParam)localObject2).x, ((ApolloWebAvatarParam)localObject2).y);
                  }
                }
                for (;;)
                {
                  if (i != 0) {
                    break label4328;
                  }
                  this.mReqBundle.clear();
                  this.mReqBundle.putInt("from", 0);
                  this.mReqBundle.putString("uin", ((JSONObject)localObject1).optString("uin"));
                  this.mReqBundle.putLong("avatarTs", l);
                  this.mReqBundle.putIntArray("dressId", paramJsBridgeListener);
                  super.sendRemoteReq(aqyt.a("ipc_apollo_update_avatar_info", paramString2, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                  break;
                  paramString1 = paramVarArgs.a(this.mApolloStatus, (ApolloWebAvatarParam)localObject2);
                  super.callJs(paramString2 + "&&" + paramString2 + "(" + paramString1 + ");");
                  continue;
                  QLog.e("ApolloJsPlugin", 1, "initAvatar, not apollo store activity");
                  callbackError(paramString2, amtj.a(2131699585));
                }
              }
              else if ("addAvatar".equals(paramString3))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloJsPlugin", 2, "addAvatar");
                }
                if (!(paramVarArgs instanceof amej))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "addAvatar, not IApolloActivityJsCallBack, check mApolloViewContoller");
                  }
                  if ((this.mApolloViewContoller == null) && ((this.mRuntime.a().getParent() instanceof RelativeLayout)))
                  {
                    this.mApolloViewContoller = new amec((RelativeLayout)this.mRuntime.a().getParent(), null);
                    this.mApolloViewContoller.a(this);
                  }
                  if (this.mApolloViewContoller == null)
                  {
                    QLog.e("ApolloJsPlugin", 1, "addAvatar, mApolloViewContoller null");
                    callbackError(paramString2, "ApolloViewController is null");
                    return false;
                  }
                }
                paramJsBridgeListener = ((JSONObject)localObject1).getJSONArray("apolloList");
                if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length() > 0))
                {
                  i = 0;
                  paramString1 = new ArrayList(paramJsBridgeListener.length());
                  m = paramJsBridgeListener.length();
                  j = 0;
                  if (j >= m) {
                    break label10020;
                  }
                  localObject1 = paramJsBridgeListener.getJSONObject(j);
                  paramString3 = new ApolloWebAvatarParam();
                  paramString3.isMain = false;
                  paramString3.apolloId = ((JSONObject)localObject1).optString("apolloId");
                  paramString3.x = ((JSONObject)localObject1).optInt("x", DEFAULT_WIDTH);
                  paramString3.y = ((JSONObject)localObject1).optInt("y", DEFAULT_HEIGHT);
                  paramString3.nickName = ((JSONObject)localObject1).optString("nickName");
                  paramString3.uin = ((JSONObject)localObject1).optString("uin");
                  if ((TextUtils.isEmpty(paramString3.apolloId)) || (TextUtils.isEmpty(paramString3.uin)))
                  {
                    QLog.e("ApolloJsPlugin", 1, "addAvatar, apolloId or uin is null");
                    j = 1;
                    if (j != 0)
                    {
                      QLog.e("ApolloJsPlugin", 1, "addAvatar, param invalid");
                      callbackError(paramString2, amtj.a(2131699588));
                    }
                  }
                  else
                  {
                    paramString3.rate = ((float)((JSONObject)localObject1).optDouble("rate", 0.0D));
                    paramString3.roleId = ((JSONObject)localObject1).optInt("roleId");
                    localObject1 = ((JSONObject)localObject1).optJSONArray("dressIds");
                    bool1 = false;
                    if (paramString3.roleId > 0) {
                      bool1 = ApolloUtil.d(paramString3.roleId);
                    }
                    bool2 = bool1;
                    if (localObject1 != null)
                    {
                      bool2 = bool1;
                      if (((JSONArray)localObject1).length() > 0)
                      {
                        int n = ((JSONArray)localObject1).length();
                        paramString3.dressIds = new int[n];
                        k = 0;
                        bool2 = bool1;
                        if (k < n)
                        {
                          int i1 = ((JSONArray)localObject1).getInt(k);
                          paramString3.dressIds[k] = i1;
                          bool2 = bool1;
                          if (paramString3.roleId <= 0) {
                            break label10120;
                          }
                          bool2 = bool1;
                          if (!bool1) {
                            break label10120;
                          }
                          bool2 = ApolloUtil.c(i1);
                          break label10120;
                        }
                      }
                    }
                    paramString3.isResExist = bool2;
                    if (bool2) {
                      break label10017;
                    }
                    i = 1;
                    paramString1.add(paramString3);
                    if (this.mValidAvatarIdList.contains(paramString3.apolloId)) {
                      break label10133;
                    }
                    this.mValidAvatarIdList.add(paramString3.apolloId);
                    break label10133;
                  }
                  if (i != 0)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ApolloJsPlugin", 2, "addAvatar, should request resource");
                    }
                    this.mReqBundle.clear();
                    this.mReqBundle.putInt("from", 2);
                    this.mReqBundle.putSerializable("apolloList", paramString1);
                    super.sendRemoteReq(aqyt.a("ipc_apollo_check_avatar_res", paramString2, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                  }
                  else if ((paramVarArgs instanceof amej))
                  {
                    paramJsBridgeListener = ((amej)paramVarArgs).a(paramString1);
                    super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener + ");");
                  }
                  else if (this.mApolloViewContoller != null)
                  {
                    paramJsBridgeListener = this.mApolloViewContoller.a(paramString1);
                    super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener + ");");
                  }
                  else
                  {
                    QLog.e("ApolloJsPlugin", 1, "addAvatar, controller null");
                    callbackError(paramString2, amtj.a(2131699600));
                  }
                }
                else
                {
                  QLog.e("ApolloJsPlugin", 1, "addAvatar, param list null");
                  callbackError(paramString2, amtj.a(2131699608));
                }
              }
              else if ("destroyAvatar".equals(paramString3))
              {
                paramJsBridgeListener = ((JSONObject)localObject1).optJSONArray("apolloList");
                if ((paramJsBridgeListener == null) || (paramJsBridgeListener.length() == 0))
                {
                  callbackError(paramString2, amtj.a(2131699597));
                }
                else
                {
                  paramString1 = new ArrayList();
                  i = 0;
                  j = paramJsBridgeListener.length();
                  while (i < j)
                  {
                    paramString3 = paramJsBridgeListener.getString(i);
                    paramString1.add(paramString3);
                    this.mValidAvatarIdList.remove(paramString3);
                    i += 1;
                  }
                  if ((paramVarArgs instanceof amej))
                  {
                    ((amej)paramVarArgs).a(paramString1);
                    callbackOk(paramString2);
                  }
                  else if (this.mApolloViewContoller != null)
                  {
                    this.mApolloViewContoller.a(paramString1);
                    callbackOk(paramString2);
                  }
                  else
                  {
                    QLog.e("ApolloJsPlugin", 1, "destroyAvatar, controller null");
                    callbackError(paramString2, amtj.a(2131699592));
                  }
                }
              }
              else if ("getRoleId".equals(paramString3))
              {
                if (!this.mDataInited)
                {
                  this.mReqBundle.clear();
                  this.mReqBundle.putInt("apollo_initFrom", 2);
                  super.sendRemoteReq(aqyt.a("ipc_apollo_get_apollo_data", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                  return true;
                }
                paramJsBridgeListener = new JSONObject();
                paramJsBridgeListener.put("result", 0);
                paramJsBridgeListener.put("msg", "");
                paramString1 = new JSONObject();
                j = this.mRoleId;
                i = j;
                if (j <= 0)
                {
                  if (this.mGender == 1) {
                    break label10142;
                  }
                  if (this.mGender != 0) {
                    break label10148;
                  }
                  break label10142;
                }
                paramString1.put("roleId", i);
                paramJsBridgeListener.put("data", paramString1);
                super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener.toString() + ");");
              }
              else if ("getLocalInfo".equals(paramString3))
              {
                if (!this.mDataInited)
                {
                  this.mReqBundle.clear();
                  this.mReqBundle.putInt("apollo_initFrom", 3);
                  super.sendRemoteReq(aqyt.a("ipc_apollo_get_apollo_data", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                  return true;
                }
                if ((this.mDressIds == null) || (this.mDressIds.length <= 0))
                {
                  callbackError(paramString2, amtj.a(2131699578));
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "dressIds.array->默认角色或获取本人信息失败");
                  }
                }
                else
                {
                  paramJsBridgeListener = new JSONObject();
                  paramJsBridgeListener.put("result", 0);
                  paramJsBridgeListener.put("msg", "");
                  paramString1 = new JSONObject();
                  paramString3 = new JSONArray();
                  paramVarArgs = this.mDressIds;
                  j = paramVarArgs.length;
                  i = 0;
                  while (i < j)
                  {
                    paramString3.put(Integer.valueOf(paramVarArgs[i]));
                    i += 1;
                  }
                  paramString1.put("dressIds", paramString3);
                  paramJsBridgeListener.put("data", paramString1);
                  super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener.toString() + ");");
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "array->" + paramString3);
                  }
                }
              }
              else if ("preview".equals(paramString3))
              {
                if (!checkSdcard(paramVarArgs))
                {
                  callbackError(paramString2, "sdcard未装");
                  return true;
                }
                if ((paramVarArgs instanceof amej))
                {
                  paramJsBridgeListener = ((JSONObject)localObject1).optJSONArray("dressIds");
                  if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length() > 0))
                  {
                    j = paramJsBridgeListener.length();
                    paramString1 = new int[j];
                    i = 0;
                    while (i < j)
                    {
                      paramString1[i] = paramJsBridgeListener.getInt(i);
                      i += 1;
                    }
                    k = paramString1.length;
                    i = 1;
                    j = 0;
                    if (j < k)
                    {
                      m = paramString1[j];
                      if ((i == 0) || (!ApolloUtil.c(m))) {
                        break label10163;
                      }
                      i = 1;
                      break label10154;
                    }
                    if (i != 0)
                    {
                      paramJsBridgeListener = ((amej)paramVarArgs).a(paramString1);
                      super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener + ");");
                      if (QLog.isColorLevel()) {
                        QLog.e("ApolloJsPlugin", 2, "callbackId->" + paramString2 + " callbackOk" + paramJsBridgeListener);
                      }
                    }
                    else
                    {
                      this.mReqBundle.clear();
                      this.mReqBundle.putIntArray("apollo_dressIds", paramString1);
                      super.sendRemoteReq(aqyt.a("ipc_apollo_preview", paramString2, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                    }
                  }
                  else
                  {
                    callbackError(paramString2, "dressIds为空");
                  }
                }
                else
                {
                  callbackError(paramString2, amtj.a(2131699593));
                }
              }
              else if (("previewOnFrame".equals(paramString3)) || ("previewAction".equals(paramString3)))
              {
                if (!checkSdcard(paramVarArgs))
                {
                  callbackError(paramString2, "sdcard未装");
                  return true;
                }
                i = ((JSONObject)localObject1).optInt("actionId");
                j = ((JSONObject)localObject1).optInt("type");
                k = ((JSONObject)localObject1).optInt("isSpecial");
                paramJsBridgeListener = ((JSONObject)localObject1).optString("title");
                paramString1 = ((JSONObject)localObject1).optString("subTitle");
                paramVarArgs = ((JSONObject)localObject1).optString("apolloId", "me");
                this.mReqBundle.clear();
                this.mReqBundle.putInt("apollo_previewAction", i);
                this.mReqBundle.putBoolean("apollo_previewOnFrame", "previewOnFrame".equals(paramString3));
                paramString3 = this.mReqBundle;
                if (sRoleGender != 2) {
                  break label10169;
                }
                i = 1;
                paramString3.putInt("apollo_partnerRoleId", i);
                this.mReqBundle.putInt("apollo_type", j);
                this.mReqBundle.putInt("apollo_isSpecial", k);
                this.mReqBundle.putString("apollo_json", ((JSONObject)localObject1).toString());
                this.mReqBundle.putString("apollo_id", paramVarArgs);
                this.mReqBundle.putString("title", paramJsBridgeListener);
                this.mReqBundle.putString("subTitle", paramString1);
                super.sendRemoteReq(aqyt.a("ipc_apollo_preview_action", paramString2, this.mOnRemoteResp.key, this.mReqBundle), true, true);
              }
              else if ("setup".equals(paramString3))
              {
                paramJsBridgeListener = ((JSONObject)localObject1).optJSONArray("dressIds");
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
                if ((paramVarArgs instanceof amej))
                {
                  this.mApolloStatus = 1;
                  ((amej)paramVarArgs).a(this.mRoleId, this.mDressIds);
                  callbackOk(paramString2);
                  this.mReqBundle.clear();
                  paramJsBridgeListener = ((JSONObject)localObject1).optString("userData");
                  this.mReqBundle.putString("apollo_userData", paramJsBridgeListener);
                  super.sendRemoteReq(aqyt.a("ipc_apollo_setup", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                }
                else
                {
                  callbackError(paramString2, amtj.a(2131699574));
                }
              }
              else if ("changeRole".equals(paramString3))
              {
                if (!checkSdcard(paramVarArgs))
                {
                  callbackError(paramString2, "sdcard未装");
                  return true;
                }
                j = ((JSONObject)localObject1).getInt("roleId");
                if (j > 0) {
                  this.mRoleId = j;
                }
                paramJsBridgeListener = ((JSONObject)localObject1).optJSONArray("dressIds");
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
                  paramJsBridgeListener = ((JSONObject)localObject1).optString("userData");
                  paramString1 = new JSONObject(paramJsBridgeListener);
                  sRoleGender = paramString1.optInt("sex");
                  if (paramString1.optJSONObject("role").optInt("aiFlag", 0) != 1) {
                    break label10175;
                  }
                  bool1 = true;
                  this.mIsAIRole = bool1;
                  this.mRoleId = j;
                  this.mReqBundle.clear();
                  this.mReqBundle.putIntArray("apollo_dressIds", this.mDressIds);
                  this.mReqBundle.putInt("apollo_roleId", this.mRoleId);
                  this.mReqBundle.putInt("apollo_fromSelf", 0);
                  this.mReqBundle.putString("apollo_userData", paramJsBridgeListener);
                  super.sendRemoteReq(aqyt.a("ipc_apollo_changerole", paramString2, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                }
                else
                {
                  callbackError(paramString2, amtj.a(2131699581));
                }
              }
              else if ("closeWebview".equals(paramString3))
              {
                super.sendRemoteReq(aqyt.a("ipc_kandian_hb_close_guid", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                paramVarArgs.finish();
                if (!(paramVarArgs instanceof amej)) {
                  paramVarArgs.overridePendingTransition(0, 0);
                }
                paramJsBridgeListener = new JSONObject();
                paramJsBridgeListener.put("result", 0);
                paramJsBridgeListener.put("msg", "");
                super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener.toString() + ");");
              }
              else if ("getSwitch".equals(paramString3))
              {
                if (!this.mDataInited)
                {
                  this.mReqBundle.clear();
                  this.mReqBundle.putInt("apollo_initFrom", 4);
                  super.sendRemoteReq(aqyt.a("ipc_apollo_get_apollo_data", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                  return true;
                }
                paramJsBridgeListener = new JSONObject();
                paramJsBridgeListener.put("result", 0);
                paramJsBridgeListener.put("msg", "");
                paramString1 = new JSONObject();
                paramString1.put("status", this.mApolloStatus);
                paramJsBridgeListener.put("data", paramString1);
                super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener.toString() + ");");
              }
              else if ("openFloatTransparentView".equals(paramString3))
              {
                paramJsBridgeListener = ((JSONObject)localObject1).getString("url");
                i = ((JSONObject)localObject1).getInt("closeBtn");
                j = ((JSONObject)localObject1).optInt("fullScreen");
                paramString1 = new Intent(paramVarArgs, ApolloFloatActivity.class);
                paramString1.putExtra("extra_key_click_time", System.currentTimeMillis());
                paramString1.putExtra("extra_key_weburl", paramJsBridgeListener);
                if (i != 1) {
                  break label10181;
                }
                bool1 = true;
                paramString1.putExtra("extra_key_close_btn", bool1);
                if (j != 1) {
                  break label10187;
                }
                bool1 = true;
                paramString1.putExtra("extra_key_fullscreen", bool1);
                paramString1.putExtra("big_brother_source_key", "biz_src_zf_lmx");
                paramVarArgs.startActivity(paramString1);
                paramJsBridgeListener = new JSONObject();
                paramJsBridgeListener.put("result", 0);
                paramJsBridgeListener.put("msg", "");
                super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener.toString() + ");");
              }
              else if ("openApolloShow".equals(paramString3))
              {
                paramJsBridgeListener = ((JSONObject)localObject1).optString("nick");
                paramString1 = ((JSONObject)localObject1).optString("uin");
                paramString3 = new Intent(paramVarArgs, ApolloGuestsStateActivity.class);
                paramString3.putExtra("extra_guest_nick", paramJsBridgeListener);
                paramString3.putExtra("extra_guest_uin", paramString1);
                paramVarArgs.startActivity(paramString3);
                paramVarArgs.overridePendingTransition(0, 0);
                callbackOk(paramString2);
              }
              else if ("getFriendsByOpenApollo".equals(paramString3))
              {
                this.mReqBundle.clear();
                super.sendRemoteReq(aqyt.a("ipc_apollo_get_openapollo_friends", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
              }
              else if ("sendActionToFrd".equals(paramString3))
              {
                i = ((JSONObject)localObject1).optInt("actionId", -1);
                j = ((JSONObject)localObject1).optInt("pkgId", -1);
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloJsPlugin", 2, new Object[] { "apolloJsPlugin call sendActionToFrd, pkgId=", Integer.valueOf(j), ", actionId=", Integer.valueOf(i) });
                }
                paramJsBridgeListener = new Bundle();
                paramJsBridgeListener.putInt("forward_type", 26);
                paramJsBridgeListener.putInt("apollo_actionid_key", i);
                paramJsBridgeListener.putInt("apollo_pkgid_key", j);
                paramString1 = new Intent(this.mRuntime.a().getApplicationContext(), ForwardRecentActivity.class);
                paramString1.addFlags(268435456);
                paramString1.addFlags(67108864);
                paramString1.putExtras(paramJsBridgeListener);
                this.mRuntime.a().startActivity(paramString1);
              }
              else if ("refreshAction".equals(paramString3))
              {
                this.mReqBundle.clear();
                super.sendRemoteReq(aqyt.a("ipc_apollo_refresh_action", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloJsPlugin", 2, "apolloJsPlugin call refreshAction");
                }
              }
              else if ("getLocalFavAction".equals(paramString3))
              {
                this.mReqBundle.clear();
                super.sendRemoteReq(aqyt.a("ipc_apollo_getfav_action", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloJsPlugin", 2, "apolloJsPlugin call getLocalFavAction");
                }
              }
              else if ("addCustomAction".equals(paramString3))
              {
                this.mReqBundle.clear();
                i = ((JSONObject)localObject1).optInt("actionId");
                j = ((JSONObject)localObject1).optInt("textType");
                paramJsBridgeListener = ((JSONObject)localObject1).optString("actionText");
                k = ((JSONObject)localObject1).optInt("audioId");
                m = ((JSONObject)localObject1).optInt("playOriginalAudio");
                float f = ((JSONObject)localObject1).optInt("audioStartTime");
                this.mReqBundle.putInt("actionId", i);
                this.mReqBundle.putString("actionText", paramJsBridgeListener);
                this.mReqBundle.putInt("textType", j);
                this.mReqBundle.putInt("audioId", k);
                this.mReqBundle.putInt("playOriginalAudio", m);
                this.mReqBundle.putFloat("audioStartTime", f);
                super.sendRemoteReq(aqyt.a("ipc_apollo_add_fav_action", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloJsPlugin", 2, "apolloJsPlugin call addCustomAction");
                }
              }
              else if ("delLocalFavAction".equals(paramString3))
              {
                this.mReqBundle.clear();
                this.mReqBundle.putString("delJson", ((JSONObject)localObject1).opt("favActionDel").toString());
                super.sendRemoteReq(aqyt.a("ipc_apollo_del_fav_list", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloJsPlugin", 2, "apolloJsPlugin call delLocalFavList");
                }
              }
              else if ("writeLocalData".equals(paramString3))
              {
                this.mReqBundle.clear();
                this.mReqBundle.putString("writeData", ((JSONObject)localObject1).toString());
                super.sendRemoteReq(aqyt.a("ipc_apollo_write_local", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloJsPlugin", 2, "apolloJsPlugin call writeLocalData");
                }
              }
              else if ("redbagCallback".equals(paramString3))
              {
                this.mReqBundle.clear();
                i = ((JSONObject)localObject1).optInt("bonusSuccess", 0);
                if (i == 1)
                {
                  this.mReqBundle.putInt("bonusSuccess", i);
                  super.sendRemoteReq(aqyt.a("ipc_kandian_hb_lottery", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                }
              }
              else if ("removeBubble".equals(paramString3))
              {
                l = ((JSONObject)localObject1).optLong("bubbleId");
                this.mReqBundle.clear();
                this.mReqBundle.putLong("bubble_id", l);
                super.sendRemoteReq(aqyt.a("ipc_apollo_clear_bubble", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
              }
              else if ("downloadImageOnFrame".equals(paramString3))
              {
                i = new Random().nextInt();
                this.mReqBundle.clear();
                this.mReqBundle.putInt("apollo_previewAction", i);
                super.sendRemoteReq(aqyt.a("ipc_apollo_downloadImageOnFrame", paramString2, this.mOnRemoteResp.key, this.mReqBundle), true, true);
              }
              else if ("addGame".equals(paramString3))
              {
                this.mReqBundle.clear();
                this.mReqBundle.putString("gameListJson", ((JSONObject)localObject1).toString());
                super.sendRemoteReq(aqyt.a("ipc_apollo_add_game", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
              }
              else if ("delGame".equals(paramString3))
              {
                this.mReqBundle.clear();
                this.mReqBundle.putString("gameListJson", ((JSONObject)localObject1).toString());
                super.sendRemoteReq(aqyt.a("ipc_apollo_del_game", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
              }
              else if ("updateGameList".equals(paramString3))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloJsPlugin", 2, new Object[] { "[handleJsRequest] updateGameList, json=", localObject1 });
                }
                this.mReqBundle.clear();
                this.mReqBundle.putString("gameListJson", ((JSONObject)localObject1).toString());
                super.sendRemoteReq(aqyt.a("ipc_apollo_update_game_list", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
              }
              else if ("isCmFaceAdded".equals(paramString3))
              {
                this.mReqBundle.clear();
                paramJsBridgeListener = ((JSONObject)localObject1).optJSONArray("faceIdList");
                if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length() > 0))
                {
                  this.mReqBundle.putString("faceIdList", paramJsBridgeListener.toString());
                  super.sendRemoteReq(aqyt.a("ipc_apollo_is_cm_face_added", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                }
                else
                {
                  paramJsBridgeListener = new JSONObject();
                  paramJsBridgeListener.put("result", 1);
                  paramJsBridgeListener.put("msg", amtj.a(2131699570));
                  super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener.toString() + ");");
                }
              }
              else if ("addCmFace".equals(paramString3))
              {
                this.mReqBundle.clear();
                paramJsBridgeListener = ((JSONObject)localObject1).optJSONArray("faceIdList");
                if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length() > 0))
                {
                  this.mReqBundle.putString("faceIdList", paramJsBridgeListener.toString());
                  super.sendRemoteReq(aqyt.a("ipc_apollo_add_cm_face", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                }
                else
                {
                  paramJsBridgeListener = new JSONObject();
                  paramJsBridgeListener.put("result", 1);
                  paramJsBridgeListener.put("msg", amtj.a(2131699587));
                  super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener.toString() + ");");
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
                paramString1 = ((JSONObject)localObject1).optString("url");
                if (!TextUtils.isEmpty(paramString1))
                {
                  paramJsBridgeListener = (SwiftBrowserUIStyleHandler)access$101(this, 2);
                  if ((paramJsBridgeListener != null) && (paramJsBridgeListener.mSwiftTitleUI != null) && (paramJsBridgeListener.mSwiftTitleUI.leftView != null))
                  {
                    paramString3 = URLDrawable.URLDrawableOptions.obtain();
                    paramString3.mLoadingDrawable = paramVarArgs.getResources().getDrawable(2130850593);
                    paramString1 = URLDrawable.getDrawable(paramString1, paramString3);
                    paramString1.startDownload();
                    paramJsBridgeListener.mSwiftTitleUI.leftView.setBackgroundDrawable(paramString1);
                  }
                }
              }
              else if ("getUserInfo".equals(paramString3))
              {
                paramJsBridgeListener = new JSONObject();
                paramJsBridgeListener.put("result", 0);
                paramJsBridgeListener.put("msg", "");
                paramString1 = new JSONObject();
                paramString3 = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 4);
                paramVarArgs = this.mRuntime.a().getCurrentAccountUin();
                bool1 = paramString3.getBoolean(paramVarArgs + "_" + "sp_key_new_store_whitelist", false);
                bool2 = paramString3.getBoolean(paramVarArgs + "_" + "sp_key_drawer_game_entry_whitelist", false);
                if (!QLog.isColorLevel()) {
                  break label10193;
                }
                QLog.d("ApolloJsPlugin", 2, new Object[] { "getUserInfo, isNewStoreUser=", Boolean.valueOf(bool1), ", isGameBoxUser=", Boolean.valueOf(bool2) });
                break label10193;
                paramString1.put("isInNewShopWhiteList", i);
                if (!bool2) {
                  break label10210;
                }
                i = 1;
                paramString1.put("isInGameBoxWhiteList", i);
                paramJsBridgeListener.put("data", paramString1);
                super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener.toString() + ");");
              }
              else if ("showGameCard".equals(paramString3))
              {
                alnr.a(((JSONObject)localObject1).optInt("gameId"), ((JSONObject)localObject1).optString("extraInfo"), this.mRuntime.a());
              }
              else if ("createShortcut".equals(paramString3))
              {
                ApolloGameUtil.b(((JSONObject)localObject1).optInt("src"), ((JSONObject)localObject1).optString("name"));
                callbackOk(paramString2);
              }
              else if ("openCmGameMatch".equals(paramString3))
              {
                this.mReqBundle.clear();
                this.mReqBundle.putString("url", ((JSONObject)localObject1).optString("url"));
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloJsPlugin", 2, new Object[] { "openCmGameMatch, url=", paramString1 });
                }
                super.sendRemoteReq(aqyt.a("ipc_open_cm_game_match_page", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
              }
              else if ("isTcpConnected".equals(paramString3))
              {
                this.mReqBundle.clear();
                super.sendRemoteReq(aqyt.a("ipc_cm_game_conn_connected", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
              }
              else if ("checkCmGameWebView".equals(paramString3))
              {
                if ((paramVarArgs instanceof QQBrowserActivity))
                {
                  paramJsBridgeListener = ((QQBrowserActivity)paramVarArgs).a();
                  paramString1 = getAbsoluteUrl();
                  if ((!(paramJsBridgeListener instanceof CmGameFragment)) && (!TextUtils.isEmpty(paramString1)))
                  {
                    QLog.d("ApolloJsPlugin", 1, "[checkCmGameWebView] not CmGameFragment");
                    callbackOk(paramString2);
                    paramVarArgs.finish();
                    alvx.a(paramVarArgs, paramString1);
                  }
                  else
                  {
                    QLog.d("ApolloJsPlugin", 1, "[checkCmGameWebView] is CmGameFragment");
                    callbackOk(paramString2);
                  }
                }
              }
              else if ("sendGameAppArkMessage".equals(paramString3))
              {
                this.mReqBundle.clear();
                paramJsBridgeListener = ((JSONObject)localObject1).optString("friendUin");
                paramString1 = ((JSONObject)localObject1).optJSONObject("arkInfo");
                if ((!TextUtils.isEmpty(paramJsBridgeListener)) && (paramString1 != null))
                {
                  this.mReqBundle.putString("friendUin", paramJsBridgeListener);
                  this.mReqBundle.putString("arkInfo", paramString1.toString());
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "sendGameAppArkMessage");
                  }
                  super.sendRemoteReq(aqyt.a("ipc_open_cm_game_send_game_app_ark_msg", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                }
                else
                {
                  callbackError(paramString2, "param error");
                }
              }
              else
              {
                if (!"saveGameToPlus".equals(paramString3)) {
                  break;
                }
                this.mReqBundle.clear();
                paramJsBridgeListener = ((JSONObject)localObject1).optString("launchUrl");
                paramString1 = ((JSONObject)localObject1).optString("gameName");
                paramString3 = ((JSONObject)localObject1).optString("iconUrl");
                paramVarArgs = ((JSONObject)localObject1).optString("appid");
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloJsPlugin", 2, "saveGameToPlus url=" + paramJsBridgeListener);
                }
                if ((!TextUtils.isEmpty(paramVarArgs)) && (!TextUtils.isEmpty(paramJsBridgeListener)) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)))
                {
                  this.mReqBundle.putString("launchUrl", paramJsBridgeListener);
                  this.mReqBundle.putString("gameName", paramString1);
                  this.mReqBundle.putString("iconUrl", paramString3);
                  this.mReqBundle.putString("appid", paramVarArgs);
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "sendGameAppArkMessage");
                  }
                  super.sendRemoteReq(aqyt.a("ipc_save_game_to_plus", paramString2, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                }
                else
                {
                  callbackError(paramString2, "param error");
                }
              }
            }
          }
        }
      } while (!"isX86".equals(paramString3));
      label934:
      label4328:
      paramJsBridgeListener = new JSONObject();
      if (ApolloGameUtil.a()) {}
      for (i = 1;; i = 0)
      {
        paramJsBridgeListener.put("result", i);
        super.callJs(paramString2 + "&&" + paramString2 + "(" + paramJsBridgeListener.toString() + ");");
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloJsPlugin", 2, new Object[] { "isX86:", Boolean.valueOf(ApolloGameUtil.a()) });
        break;
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
  
  public void onCreate()
  {
    super.onCreate();
    this.mReqBundle = new Bundle();
    sResponseKey = this.mOnRemoteResp.key;
    ApolloEngine.a();
    sApolloReceiver.onApolloJsCreated(this);
  }
  
  public void onDestroy()
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
          break label101;
        }
        callbackError(str, amtj.a(2131699566));
      }
    }
    return;
    label101:
    int j;
    label193:
    label2043:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            try
            {
              if (!"ipc_apollo_start_record_msg".equals(localObject3)) {
                break label193;
              }
              i = ((Bundle)localObject2).getInt("result", -1000);
              if (i == 0)
              {
                callbackOk(str);
                return;
              }
            }
            catch (Throwable paramBundle)
            {
              if (QLog.isColorLevel()) {
                QLog.e("ApolloJsPlugin", 2, paramBundle.getMessage());
              }
              callbackError(str, amtj.a(2131699571));
              return;
            }
            callbackError(str, i + "");
            return;
            if ("ipc_apollo_stop_record_msg".equals(localObject3))
            {
              i = ((Bundle)localObject2).getInt("result", -1000);
              if (i == 0)
              {
                callbackOk(str);
                return;
              }
              callbackError(str, i + "");
              return;
            }
            if ("ipc_apollo_upload_record_msg".equals(localObject3))
            {
              i = ((Bundle)localObject2).getInt("result", -1000);
              if (i == 0)
              {
                callbackOk(str);
                return;
              }
              callbackError(str, i + "");
              return;
            }
            if ("ipc_apollo_play_last_record_msg".equals(localObject3))
            {
              i = ((Bundle)localObject2).getInt("result", -1000);
              if (i == 0)
              {
                callbackOk(str);
                return;
              }
              callbackError(str, i + "");
              return;
            }
            if ("ipc_apollo_stop_last_record_msg".equals(localObject3))
            {
              i = ((Bundle)localObject2).getInt("result", -1000);
              if (i == 0)
              {
                callbackOk(str);
                return;
              }
              callbackError(str, i + "");
              return;
            }
            if ("ipc_apollo_get_playmate_msg".equals(localObject3))
            {
              paramBundle = ((Bundle)localObject2).getString("result");
              super.callJs(str + "&&" + str + "(" + paramBundle + ");");
              return;
            }
            if ("ipc_apollo_preview".equals(localObject3))
            {
              paramBundle = ((Bundle)localObject2).getIntArray("apollo_dressIds");
              if ((((Bundle)localObject2).getInt("apollo_result") == 0) && (paramBundle != null))
              {
                callbackError(str, amtj.a(2131699572));
                return;
              }
              if (this.mApolloViewContoller != null)
              {
                paramBundle = this.mApolloViewContoller.a(paramBundle);
                super.callJs(str + "&&" + str + "(" + paramBundle + ");");
                if (QLog.isColorLevel()) {
                  QLog.e("ApolloJsPlugin", 2, "callbackId->" + str + " callbackOk" + paramBundle);
                }
              }
              else if ((localObject1 instanceof amej))
              {
                paramBundle = ((amej)localObject1).a(paramBundle);
                super.callJs(str + "&&" + str + "(" + paramBundle + ");");
                if (QLog.isColorLevel()) {
                  QLog.e("ApolloJsPlugin", 2, "callbackId->" + str + " callbackOk" + paramBundle);
                }
              }
              else
              {
                callbackError(str, amtj.a(2131699583));
              }
            }
            else
            {
              Object localObject4;
              Object localObject5;
              Object localObject6;
              if (("ipc_apollo_preview_action".equals(localObject3)) || ("ipc_apollo_preview_audio_action".equals(localObject3)))
              {
                i = ((Bundle)localObject2).getInt("apollo_previewAction");
                j = ((Bundle)localObject2).getInt("apollo_apolloVipFlag");
                int k = ((Bundle)localObject2).getInt("apollo_apolloVipLevel");
                paramBundle = ((Bundle)localObject2).getString("title");
                localObject4 = ((Bundle)localObject2).getString("subTitle");
                localObject5 = ((Bundle)localObject2).getString("apollo_json");
                boolean bool1 = ((Bundle)localObject2).getBoolean("apollo_previewOnFrame");
                Object localObject7 = new JSONObject((String)localObject5);
                int m = ((JSONObject)localObject7).optInt("type");
                int n = ((JSONObject)localObject7).optInt("isSpecial");
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
                boolean bool2 = ((Bundle)localObject2).getBoolean("apollo_is_super_yellow");
                localObject2 = new ameg();
                ((ameg)localObject2).jdField_a_of_type_Int = i5;
                ((ameg)localObject2).jdField_b_of_type_Int = i;
                ((ameg)localObject2).jdField_c_of_type_Int = m;
                ((ameg)localObject2).jdField_d_of_type_Int = n;
                ((ameg)localObject2).e = i1;
                ((ameg)localObject2).f = j;
                ((ameg)localObject2).g = k;
                ((ameg)localObject2).h = i2;
                ((ameg)localObject2).i = i9;
                ((ameg)localObject2).j = i3;
                ((ameg)localObject2).k = i4;
                ((ameg)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject6);
                ((ameg)localObject2).l = i6;
                ((ameg)localObject2).m = i7;
                ((ameg)localObject2).jdField_a_of_type_Float = f1;
                ((ameg)localObject2).jdField_b_of_type_Float = f2;
                ((ameg)localObject2).jdField_a_of_type_Boolean = bool1;
                ((ameg)localObject2).jdField_c_of_type_JavaLangString = paramBundle;
                ((ameg)localObject2).jdField_d_of_type_JavaLangString = ((String)localObject4);
                ((ameg)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject7);
                ((ameg)localObject2).jdField_b_of_type_Boolean = bool2;
                if ((i8 == 0) && (i > 0))
                {
                  if ("ipc_apollo_preview_audio_action".equals(localObject3))
                  {
                    paramBundle = amec.a("ApolloViewController is null or Activity not instanceof IApolloActivityJsCallBack");
                    if (this.mApolloViewContoller != null)
                    {
                      paramBundle = this.mApolloViewContoller.a((ameg)localObject2);
                      super.callJs(str + "&&" + str + "(" + paramBundle + ");");
                    }
                    while (QLog.isColorLevel())
                    {
                      QLog.e("ApolloJsPlugin", 2, "IPC_APOLLO_PREVIEW_AUDIO_ACTION callbackId->" + str + " callbackOk" + paramBundle);
                      return;
                      if ((localObject1 instanceof amej))
                      {
                        paramBundle = ((amej)localObject1).a((ameg)localObject2);
                        super.callJs(str + "&&" + str + "(" + paramBundle + ");");
                      }
                    }
                  }
                  else if ("ipc_apollo_preview_action".equals(localObject3))
                  {
                    localObject3 = new File(amdp.b(i7));
                    if ((i7 > 0) && (!((File)localObject3).exists()))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.e("ApolloJsPlugin", 2, "IPC_APOLLO_PREVIEW_ACTION audio file no exsit callbackId->" + str);
                      }
                      this.mReqBundle.clear();
                      this.mReqBundle.putInt("apollo_previewAction", i);
                      this.mReqBundle.putInt("apollo_apolloVipFlag", j);
                      this.mReqBundle.putInt("apollo_apolloVipLevel", k);
                      this.mReqBundle.putBoolean("apollo_previewOnFrame", bool1);
                      this.mReqBundle.putInt("apollo_partnerRoleId", i9);
                      this.mReqBundle.putInt("apollo_audioId", i7);
                      this.mReqBundle.putString("apollo_json", ((String)localObject5).toString());
                      this.mReqBundle.putString("title", paramBundle);
                      this.mReqBundle.putString("subTitle", (String)localObject4);
                      super.sendRemoteReq(aqyt.a("ipc_apollo_preview_audio_action", str, this.mOnRemoteResp.key, this.mReqBundle), true, true);
                      return;
                    }
                    paramBundle = amec.a("ApolloViewController is null or Activity not instanceof IApolloActivityJsCallBack");
                    if ((localObject1 instanceof amej))
                    {
                      paramBundle = ((amej)localObject1).a((ameg)localObject2);
                      super.callJs(str + "&&" + str + "(" + paramBundle + ");");
                    }
                    while (QLog.isColorLevel())
                    {
                      QLog.e("ApolloJsPlugin", 2, "IPC_APOLLO_PREVIEW_ACTION callbackId->" + str + " callbackOk" + paramBundle);
                      return;
                      if (this.mApolloViewContoller != null)
                      {
                        paramBundle = this.mApolloViewContoller.a((ameg)localObject2);
                        super.callJs(str + "&&" + str + "(" + paramBundle + ");");
                      }
                      else
                      {
                        callbackError(str, amtj.a(2131699601));
                      }
                    }
                  }
                }
                else {
                  callbackError(str, amtj.a(2131699598) + (String)localObject3);
                }
              }
              else if ("ipc_apollo_check_avatar_res".equals(localObject3))
              {
                i = ((Bundle)localObject2).getInt("result");
                j = ((Bundle)localObject2).getInt("from");
                paramBundle = ((Bundle)localObject2).getString("msg");
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloJsPlugin", 2, new Object[] { "IPC_APOLLO_CHECK_AVATAR_RES, ret=", Integer.valueOf(i), ", msg=", paramBundle, ", from=", Integer.valueOf(j) });
                }
                localObject3 = (ArrayList)((Bundle)localObject2).getSerializable("apolloList");
                if (i == 0)
                {
                  if ((localObject3 == null) || (((ArrayList)localObject3).size() == 0))
                  {
                    callbackError(str, amtj.a(2131699577));
                    return;
                  }
                  paramBundle = ((Bundle)localObject2).getString("reqUrl");
                  if (TextUtils.isEmpty(paramBundle)) {
                    break label5270;
                  }
                  localObject2 = getAbsoluteUrl();
                  if (paramBundle.equals(localObject2)) {
                    break label5270;
                  }
                  callbackError(str, "WebView已经切换url");
                  QLog.e("ApolloJsPlugin", 1, new Object[] { "reqUrl:", paramBundle, " absoluteUrl:", localObject2 });
                  return;
                  localObject2 = (ApolloWebAvatarParam)((ArrayList)localObject3).get(0);
                  if (((ApolloWebAvatarParam)localObject2).isResExist)
                  {
                    if (this.mValidAvatarIdList.contains(((ApolloWebAvatarParam)localObject2).apolloId))
                    {
                      paramBundle = "";
                      if (j == 1)
                      {
                        if (this.mApolloViewContoller == null) {
                          break label5284;
                        }
                        paramBundle = this.mApolloViewContoller.a(1, true, (ApolloWebAvatarParam)localObject2);
                      }
                      for (;;)
                      {
                        super.callJs(str + "&&" + str + "(" + paramBundle + ");");
                        return;
                        if (j == 0)
                        {
                          if (!(localObject1 instanceof amej)) {
                            break;
                          }
                          paramBundle = ((amej)localObject1).a(this.mApolloStatus, (ApolloWebAvatarParam)localObject2);
                        }
                      }
                    }
                    QLog.e("ApolloJsPlugin", 1, new Object[] { "[IPC_APOLLO_CHECK_AVATAR_RES] initAvatar abort, apolloId is detroyed, id=", ((ApolloWebAvatarParam)localObject2).apolloId });
                    return;
                  }
                  paramBundle = null;
                  if ((this.mRuntime.a() instanceof BaseActivity)) {
                    paramBundle = ((BaseActivity)this.mRuntime.a()).getAppInterface();
                  }
                  if (paramBundle != null)
                  {
                    amdp.a(paramBundle, ((ApolloWebAvatarParam)localObject2).uin, new ApolloJsPlugin.4(this, (ApolloWebAvatarParam)localObject2, (Activity)localObject1, j, str), ((ApolloWebAvatarParam)localObject2).roleId, ((ApolloWebAvatarParam)localObject2).dressIds, -1, -1, false);
                    return;
                  }
                  callbackError(str, "获取AppInterface失败");
                  return;
                  if (j == 2)
                  {
                    localObject2 = new AtomicInteger(0);
                    if (!(this.mRuntime.a() instanceof BaseActivity)) {
                      break label5265;
                    }
                    paramBundle = ((BaseActivity)this.mRuntime.a()).getAppInterface();
                    localObject4 = ((ArrayList)localObject3).iterator();
                    while (((Iterator)localObject4).hasNext())
                    {
                      localObject5 = (ApolloWebAvatarParam)((Iterator)localObject4).next();
                      if (((ApolloWebAvatarParam)localObject5).isResExist)
                      {
                        localObject6 = new ArrayList();
                        ((ArrayList)localObject6).add(localObject5);
                        if (this.mValidAvatarIdList.contains(((ApolloWebAvatarParam)localObject5).apolloId))
                        {
                          if (!(localObject1 instanceof amej)) {
                            break label2450;
                          }
                          ((amej)localObject1).a((ArrayList)localObject6);
                        }
                        for (;;)
                        {
                          ((AtomicInteger)localObject2).getAndIncrement();
                          if (((AtomicInteger)localObject2).get() != ((ArrayList)localObject3).size()) {
                            break;
                          }
                          callbackOk(str);
                          break;
                          if (this.mApolloViewContoller != null) {
                            this.mApolloViewContoller.a((ArrayList)localObject6);
                          }
                        }
                      }
                      if (paramBundle != null)
                      {
                        amdp.a(paramBundle, ((ApolloWebAvatarParam)localObject5).uin, new ApolloJsPlugin.5(this, (ApolloWebAvatarParam)localObject5, (Activity)localObject1, (AtomicInteger)localObject2, (ArrayList)localObject3, str), ((ApolloWebAvatarParam)localObject5).roleId, ((ApolloWebAvatarParam)localObject5).dressIds, -1, -1, false);
                      }
                      else
                      {
                        QLog.e("ApolloJsPlugin", 1, new Object[] { "addAvatar, app null, uin=", ApolloUtil.d(((ApolloWebAvatarParam)localObject5).uin) });
                        ((AtomicInteger)localObject2).getAndIncrement();
                        if (((AtomicInteger)localObject2).get() == ((ArrayList)localObject3).size()) {
                          callbackOk(str);
                        }
                      }
                    }
                  }
                }
                else
                {
                  if (j != 2) {
                    QQToast.a((Context)localObject1, amtj.a(2131699565), 1).a();
                  }
                  callbackError(str, amtj.a(2131699575));
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "下载素材角色装扮素材失败->mRoleId" + this.mRoleId + " mDressIds->" + this.mDressIds);
                  }
                }
              }
              else
              {
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
                    paramBundle = amdp.a(j);
                  }
                  this.mDressIds = paramBundle;
                  this.mRoleId = j;
                  this.mApolloStatus = 1;
                  if ((i == 0) && (paramBundle != null) && (paramBundle.length > 0))
                  {
                    callbackOk(str);
                    return;
                  }
                  callbackError(str, amtj.a(2131699561));
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
                  sRoleGender = ((Bundle)localObject2).getInt("apollo_roleGender");
                  if (this.mRoleId <= 0)
                  {
                    if ((this.mGender != 1) && (this.mGender != 0)) {
                      break label2927;
                    }
                    this.mRoleId = 1;
                  }
                  for (;;)
                  {
                    if (3 == i)
                    {
                      if ((this.mDressIds == null) || (this.mDressIds.length <= 0))
                      {
                        callbackError(str, amtj.a(2131699603));
                        if (!QLog.isColorLevel()) {
                          break;
                        }
                        QLog.d("ApolloJsPlugin", 2, "dressIds.array->默认角色或获取本人信息失败");
                        return;
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
                      super.callJs(str + "&&" + str + "(" + paramBundle.toString() + ");");
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
                      callbackError(str, amtj.a(2131699582));
                      return;
                    }
                    paramBundle = new JSONObject();
                    paramBundle.put("result", 0);
                    paramBundle.put("msg", "");
                    localObject1 = new JSONObject();
                    ((JSONObject)localObject1).put("roleId", this.mRoleId);
                    paramBundle.put("data", localObject1);
                    super.callJs(str + "&&" + str + "(" + paramBundle.toString() + ");");
                    return;
                  }
                  if (4 == i)
                  {
                    paramBundle = new JSONObject();
                    paramBundle.put("result", 0);
                    paramBundle.put("msg", "");
                    localObject1 = new JSONObject();
                    ((JSONObject)localObject1).put("status", this.mApolloStatus);
                    paramBundle.put("data", localObject1);
                    super.callJs(str + "&&" + str + "(" + paramBundle.toString() + ");");
                  }
                }
                else if ("ipc_apollo_get_openapollo_friends".equals(localObject3))
                {
                  i = ((Bundle)localObject2).getInt("apollo_result");
                  paramBundle = ((Bundle)localObject2).getString("apollo_data");
                  if (i == 0)
                  {
                    localObject1 = new JSONObject();
                    ((JSONObject)localObject1).put("result", 0);
                    ((JSONObject)localObject1).put("data", new JSONObject(paramBundle));
                    super.callJs(str + "&&" + str + "(" + ((JSONObject)localObject1).toString() + ");");
                  }
                  while (QLog.isColorLevel())
                  {
                    QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_GET_OPENAPOLLO_FRIENDS onResponse dataStr is:" + paramBundle);
                    return;
                    callbackError(str, amtj.a(2131699590));
                  }
                }
                else if ("ipc_apollo_query_mine_redinfo".equals(localObject3))
                {
                  i = ((Bundle)localObject2).getInt("isNewFlag");
                  if ((i == 1) && ((localObject1 instanceof amej))) {
                    ((amej)localObject1).b();
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_QUERY_MINE_REDINFO onResponse dataInt is:" + i);
                  }
                }
                else if ("ipc_apollo_getfav_action".equals(localObject3))
                {
                  paramBundle = ((Bundle)localObject2).getString("getFavResult");
                  localObject1 = new JSONObject();
                  ((JSONObject)localObject1).put("data", new JSONObject(paramBundle));
                  ((JSONObject)localObject1).put("result", 0);
                  super.callJs(str + "&&" + str + "(" + ((JSONObject)localObject1).toString() + ");");
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_GETFAV_ACTION onResponse data is:" + ((JSONObject)localObject1).toString());
                  }
                }
                else if ("ipc_apollo_add_fav_action".equals(localObject3))
                {
                  paramBundle = ((Bundle)localObject2).getString("addFavAction");
                  localObject1 = new JSONObject();
                  ((JSONObject)localObject1).put("data", new JSONObject(paramBundle));
                  ((JSONObject)localObject1).put("result", 0);
                  super.callJs(str + "&&" + str + "(" + ((JSONObject)localObject1).toString() + ");");
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_ADD_FAV_ACTION onResponse data is:" + ((JSONObject)localObject1).toString());
                  }
                }
                else
                {
                  if (!"ipc_apollo_del_fav_action".equals(localObject3)) {
                    break;
                  }
                  paramBundle = ((Bundle)localObject2).getString("delFavAction");
                  i = new JSONObject(paramBundle).optInt("ret");
                  localObject1 = new JSONObject();
                  if (i == 0)
                  {
                    ((JSONObject)localObject1).put("data", new JSONObject(paramBundle));
                    ((JSONObject)localObject1).put("result", 0);
                    super.callJs(str + "&&" + str + "(" + ((JSONObject)localObject1).toString() + ");");
                  }
                  while (QLog.isColorLevel())
                  {
                    QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_DEL_FAV_ACTION onResponse data is:" + ((JSONObject)localObject1).toString());
                    return;
                    if (i == 1) {
                      callbackError(str, amtj.a(2131699580));
                    } else if (i == 2) {
                      callbackError(str, amtj.a(2131699589));
                    } else {
                      callbackError(str, amtj.a(2131699576));
                    }
                  }
                }
              }
            }
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
              super.callJs(str + "&&" + str + "(" + ((JSONObject)localObject1).toString() + ");");
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_DEL_FAV_List onResponse data is:" + ((JSONObject)localObject1).toString());
              return;
              ((JSONObject)localObject1).put("result", 0);
            }
          }
          if (!"ipc_apollo_write_local".equals(localObject3)) {
            break;
          }
          paramBundle = new JSONObject(((Bundle)localObject2).getString("writeRet"));
          super.callJs(str + "&&" + str + "(" + paramBundle.toString() + ");");
        } while (!QLog.isColorLevel());
        QLog.d("ApolloJsPlugin", 2, "IPC_APOLLO_WRITE_LOCAL onResponse data is:" + paramBundle.toString());
        return;
        if (!"ipc_apollo_downloadImageOnFrame".equals(localObject3)) {
          break;
        }
      } while (!(localObject1 instanceof amej));
      ((amej)localObject1).b(str);
      return;
      if ((!"ipc_apollo_add_game".equals(localObject3)) && (!"ipc_apollo_del_game".equals(localObject3))) {
        break;
      }
      paramBundle = String.format("%s({\"result\":%d, \"message\":\"%s\"});", new Object[] { str, Integer.valueOf(((Bundle)localObject2).getInt("result")), ((Bundle)localObject2).getString("message") });
      super.callJs(paramBundle);
    } while (!QLog.isColorLevel());
    label2105:
    label2927:
    QLog.d("ApolloJsPlugin", 2, new Object[] { "cmd=", localObject3, ", callbackStr=", paramBundle });
    label2332:
    return;
    label2450:
    if ("ipc_apollo_start_apollo_game".equals(localObject3))
    {
      if (((Bundle)localObject2).getInt("result") == 0)
      {
        callbackOk(str);
        return;
      }
      callbackError(str, amtj.a(2131699594));
      return;
    }
    if ("ipc_apollo_choose_friend_play_game".equals(localObject3))
    {
      i = ((Bundle)localObject2).getInt("gameId");
      j = ((Bundle)localObject2).getInt("gameMode");
      if (((Bundle)localObject2).getBoolean("hasGameRunning"))
      {
        this.gameDialog = bfur.a((Context)localObject1, 0, "", amtj.a(2131699564), 2131690620, 2131694201, new ApolloJsPlugin.6(this, i, j, (Activity)localObject1), new ApolloJsPlugin.7(this));
        if ((localObject1 instanceof BaseActivity)) {
          VipUtils.a(((BaseActivity)localObject1).getAppInterface(), "cmshow", "Apollo", "game_alert_show", 3, 0, new String[0]);
        }
        this.gameDialog.show();
        return;
      }
      paramBundle = new ammz();
      paramBundle.jdField_a_of_type_Int = i;
      amja.a(paramBundle, this.mRuntime.a(), 2);
      return;
    }
    if ("IPC_APOLLO_DOWNLOAD_GAME".equals(localObject3))
    {
      paramBundle = (CmGameStartChecker.StartCheckParam)((Bundle)localObject2).getSerializable("StartCheckParam");
      if (paramBundle == null)
      {
        callbackError(str, amtj.a(2131699605));
        return;
      }
      localObject2 = alvx.a();
      this.mCmGameStartChecker = new CmGameStartChecker((AppInterface)localObject2);
      this.mCmGameStartCheckerListener = new ApolloJsPlugin.8(this, (AppInterface)localObject2, false, str, (Activity)localObject1);
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
    if ("ipc_cm_game_conn_connected".equals(localObject3)) {
      if (!((Bundle)localObject2).getBoolean("isConnected")) {
        break label5298;
      }
    }
    label5265:
    label5270:
    label5284:
    label5298:
    for (int i = 1;; i = 0)
    {
      paramBundle = String.format("%s({\"result\":%d,\"data\":{\"isConnected\":%d}});", new Object[] { str, Integer.valueOf(0), Integer.valueOf(i) });
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, new Object[] { "IPC_CM_GAME_CONN_CONNECTED, result=", paramBundle });
      }
      super.callJs(paramBundle);
      return;
      if ("ipc_open_cm_game_match_page".equals(localObject3))
      {
        if (((Bundle)localObject2).getInt("result") == 0)
        {
          callbackOk(str);
          return;
        }
        callbackError(str, "open failed");
        return;
      }
      if ("ipc_open_cm_game_send_game_app_ark_msg".equals(localObject3))
      {
        if (((Bundle)localObject2).getInt("result") == 0)
        {
          callbackOk(str);
          return;
        }
        callbackError(str, "send failed");
        return;
      }
      super.onResponse(paramBundle);
      return;
      paramBundle = null;
      break label2332;
      if (j == 1) {
        break label2043;
      }
      if (j != 0) {
        break;
      }
      break label2043;
      paramBundle = "{\"result\":1, \"msg\": \"终端初始化错误\" }";
      break label2105;
      paramBundle = "{\"result\":1, \"msg\": \"非商城页面\" }";
      break label2105;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin
 * JD-Core Version:    0.7.0.1
 */