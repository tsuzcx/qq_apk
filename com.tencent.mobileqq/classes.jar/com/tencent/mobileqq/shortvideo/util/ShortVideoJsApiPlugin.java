package com.tencent.mobileqq.shortvideo.util;

import aiir;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.biz.qqstory.takevideo.dancemachine.DanceMachinePKManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureRecognitionUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ShortVideoJsApiPlugin
  extends WebViewPlugin
{
  public BroadcastReceiver a = new aiir(this);
  
  public ShortVideoJsApiPlugin()
  {
    this.mPluginNameSpace = "ptv";
  }
  
  public void a(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoJsApiPlugin", 2, "onActivityResult, requestCode:" + paramInt1 + "，resultCode：" + paramInt2);
    }
    if ((paramInt1 != 11000) || (paramIntent == null)) {}
    String str;
    do
    {
      do
      {
        return;
        str = paramIntent.getStringExtra("arg_callback");
      } while (TextUtils.isEmpty(str));
      if (paramInt2 != -1) {
        break;
      }
      paramIntent = paramIntent.getStringExtra("arg_result_json");
    } while (paramIntent == null);
    try
    {
      paramIntent = new JSONObject(paramIntent);
      paramIntent.put("retCode", 0);
      paramIntent = paramIntent.toString();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoJsApiPlugin", 2, "startNewPTVActivity" + " result:" + ReadInJoyDeliverUGCActivity.a(paramIntent));
      }
      callJs(str, new String[] { paramIntent });
      return;
    }
    catch (Exception paramIntent)
    {
      return;
    }
    try
    {
      paramIntent = new JSONObject();
      paramIntent.put("retCode", -1);
      paramIntent = paramIntent.toString();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoJsApiPlugin", 2, "startNewPTVActivity" + " result:" + paramIntent);
      }
      callJs(str, new String[] { paramIntent });
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if ((paramLong == 8589934600L) && (paramMap != null))
    {
      int i = ((Integer)paramMap.get("requestCode")).intValue();
      if (i == 11000)
      {
        int j = ((Integer)paramMap.get("resultCode")).intValue();
        a((Intent)paramMap.get("data"), i, j);
        return true;
      }
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoJsApiPlugin", 2, "Call ShortVideoJsApiPlugin handleJsRequest, url" + paramString1 + " pkgName:" + paramString2);
    }
    if ("ptv".equals(paramString2))
    {
      if ("GSBase64Encode".equals(paramString3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoJsApiPlugin", 2, "Call Ptv Api GSBaze64Encode, args:" + paramVarArgs);
        }
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {}
      }
      for (;;)
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          paramString1 = paramJsBridgeListener.optString("need_encode_string");
          paramJsBridgeListener = paramJsBridgeListener.optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = NearbyURLSafeUtil.a(paramString1);
            paramString2 = new JSONObject();
            paramString2.put("encoded_string", paramString1);
            callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
          }
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          continue;
        }
        boolean bool1;
        if ("isSupportPTV".equals(paramString3))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoJsApiPlugin", 2, "Call Ptv Api isSupportPTV, args:" + paramVarArgs);
          }
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
              if (TextUtils.isEmpty(paramJsBridgeListener)) {
                continue;
              }
              bool1 = ShortVideoGuideUtil.c(this.mRuntime.a());
              paramString1 = new JSONObject();
              paramString1.put("is_support_ptv", bool1);
              callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
        }
        else if ("startNewPTVActivity".equals(paramString3))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoJsApiPlugin", 2, "Call Ptv Api startPTVActivity, args:" + paramVarArgs);
          }
          if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
            continue;
          }
          try
          {
            localObject2 = new JSONObject(paramVarArgs[0]);
            str3 = ((JSONObject)localObject2).optString("supportvideo");
            str4 = ((JSONObject)localObject2).optString("supportphoto");
            str5 = ((JSONObject)localObject2).optString("cameramode");
            str6 = ((JSONObject)localObject2).optString("beauty");
            str7 = ((JSONObject)localObject2).optString("dealtype");
            str8 = ((JSONObject)localObject2).optString("callback");
            str9 = ((JSONObject)localObject2).optString("supportDD");
            str10 = ((JSONObject)localObject2).optString("unfoldDD");
            str11 = ((JSONObject)localObject2).optString("DDCategoryName");
            str12 = ((JSONObject)localObject2).optString("DDItemID");
            str13 = ((JSONObject)localObject2).optString("supportFilter");
            str14 = ((JSONObject)localObject2).optString("unfoldFilter");
            str15 = ((JSONObject)localObject2).optString("filterCategoryName");
            str16 = ((JSONObject)localObject2).optString("filterItemID");
            str17 = ((JSONObject)localObject2).optString("supportSubtitle");
            str18 = ((JSONObject)localObject2).optString("activityType");
            paramString3 = "";
          }
          catch (JSONException paramJsBridgeListener)
          {
            Object localObject2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            String str13;
            String str14;
            String str15;
            String str16;
            String str17;
            String str18;
            label540:
            String str1;
            paramJsBridgeListener.printStackTrace();
          }
        }
        try
        {
          paramJsBridgeListener = ((JSONObject)localObject2).getString("activityId");
          paramString3 = paramJsBridgeListener;
        }
        catch (JSONException paramJsBridgeListener)
        {
          break label540;
        }
        paramString1 = "";
        Object localObject1 = "";
        str1 = "";
        String str2 = "";
        paramString2 = str1;
        paramJsBridgeListener = (JsBridgeListener)localObject1;
        try
        {
          paramVarArgs = ((JSONObject)localObject2).getString("callerType");
          paramString2 = str1;
          paramJsBridgeListener = (JsBridgeListener)localObject1;
          paramString1 = paramVarArgs;
          localObject1 = ((JSONObject)localObject2).getString("topicId");
          paramString2 = str1;
          paramJsBridgeListener = (JsBridgeListener)localObject1;
          paramString1 = paramVarArgs;
          str1 = ((JSONObject)localObject2).getString("topicName");
          paramString2 = str1;
          paramJsBridgeListener = (JsBridgeListener)localObject1;
          paramString1 = paramVarArgs;
          localObject2 = ((JSONObject)localObject2).getString("adtag");
          paramJsBridgeListener = (JsBridgeListener)localObject2;
          paramString2 = str1;
          paramString1 = (String)localObject1;
          localObject1 = paramJsBridgeListener;
          paramJsBridgeListener = paramString1;
          paramString1 = paramVarArgs;
        }
        catch (JSONException paramVarArgs)
        {
          for (;;)
          {
            localObject1 = str2;
          }
        }
        if (!TextUtils.isEmpty(str8))
        {
          ShortVideoGuideUtil.a(this.mRuntime.a(), this.mRuntime.a(), str3, str4, str5, str6, str9, str10, str11, str12, str13, str14, str15, str16, str17, str7, str18, paramString3, str8, paramString1, paramJsBridgeListener, paramString2, (String)localObject1);
          continue;
          continue;
          if ("isMobileSupportPTV".equals(paramString3))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoJsApiPlugin", 2, "Call Ptv Api isMobileSupportPTV, args:" + paramVarArgs);
            }
            if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
              try
              {
                paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
                if (TextUtils.isEmpty(paramJsBridgeListener)) {
                  continue;
                }
                bool1 = ShortVideoGuideUtil.f(this.mRuntime.a());
                paramString1 = new JSONObject();
                paramString1.put("is_mobile_support_ptv", bool1);
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
              }
              catch (JSONException paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
              }
            }
          }
          else if ("isSupportDynamicDecoration".equals(paramString3))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoJsApiPlugin", 2, "Call Ptv Api isSupportDynamicDecoration, args:" + paramVarArgs);
            }
            if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
              try
              {
                paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
                if (TextUtils.isEmpty(paramJsBridgeListener)) {
                  continue;
                }
                bool1 = ShortVideoGuideUtil.g(this.mRuntime.a());
                paramString1 = new JSONObject();
                paramString1.put("is_support_DynamicDecoration", bool1);
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
              }
              catch (JSONException paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
              }
            }
          }
          else if ("isSupportGestureDecoration".equals(paramString3))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoJsApiPlugin", 2, "Call Ptv Api isSupportGestureDecoration, args:" + paramVarArgs);
            }
            if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
              for (;;)
              {
                try
                {
                  paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
                  if (TextUtils.isEmpty(paramJsBridgeListener)) {
                    break;
                  }
                  bool1 = ShortVideoGuideUtil.c(this.mRuntime.a());
                  boolean bool2 = GestureRecognitionUtils.c();
                  boolean bool3 = VideoEnvironment.e(this.mRuntime.a());
                  boolean bool4 = PtvFilterSoLoad.a(BaseApplicationImpl.getContext());
                  QLog.i("ShortVideoJsApiPlugin", 1, "call isSupportGestureDecoration isSupportPTV:" + bool1 + ",isSupportGesture:" + bool2);
                  paramString1 = new JSONObject();
                  if ((!bool2) || (!bool1) || (!bool3) || (!bool4)) {
                    break label1215;
                  }
                  bool1 = true;
                  paramString1.put("is_support_GestureDecoration", bool1);
                  callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                }
                catch (JSONException paramJsBridgeListener)
                {
                  paramJsBridgeListener.printStackTrace();
                }
                break;
                label1215:
                bool1 = false;
              }
            }
          }
          else if ("getGestureRecognitionResult".equals(paramString3))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoJsApiPlugin", 2, "Call Ptv Api getGestureRecognitionResult, args:" + paramVarArgs);
            }
            if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
              try
              {
                paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
                if (TextUtils.isEmpty(paramJsBridgeListener)) {
                  continue;
                }
                bool1 = CaptureUtil.g();
                QLog.i("ShortVideoJsApiPlugin", 1, "call getGestureRecognitionResult result:" + bool1);
                paramString1 = new JSONObject();
                paramString1.put("is_support_GestureDecoration", bool1);
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
              }
              catch (JSONException paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
              }
            }
          }
          else if ("isSupportDanceGame".equals(paramString3))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoJsApiPlugin", 2, "Call Ptv Api isSupportDanceGame, args:" + paramVarArgs);
            }
            if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
              try
              {
                paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
                if (TextUtils.isEmpty(paramJsBridgeListener)) {
                  continue;
                }
                bool1 = ShortVideoGuideUtil.h(this.mRuntime.a());
                paramString1 = new JSONObject();
                paramString1.put("is_support_dance_game", bool1);
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
              }
              catch (JSONException paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
              }
            }
          }
          else if ("isSupportFaceDanceGame".equals(paramString3))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoJsApiPlugin", 2, "Call Ptv Api isSupportFaceDanceGame, args:" + paramVarArgs);
            }
            if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
              try
              {
                paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
                if (TextUtils.isEmpty(paramJsBridgeListener)) {
                  continue;
                }
                bool1 = ShortVideoGuideUtil.i(this.mRuntime.a());
                paramString1 = new JSONObject();
                paramString1.put("is_support_facedance_game", bool1);
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
              }
              catch (JSONException paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
              }
            }
          }
          else if ("onClickShareBattle".equals(paramString3))
          {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
              paramString1 = paramJsBridgeListener.optString("shareWebUrl");
              int i = paramJsBridgeListener.optInt("rank", 0);
              DanceMachinePKManager.a().a(paramString1, Integer.valueOf(i).toString());
            }
            catch (JSONException paramJsBridgeListener) {}
            if (QLog.isColorLevel())
            {
              QLog.d("ShortVideoJsApiPlugin", 2, "onClickShareBattle error");
              paramJsBridgeListener.printStackTrace();
            }
          }
          else if ("onClickShareVideo".equals(paramString3))
          {
            DanceMachinePKManager.a().b();
          }
        }
      }
    }
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.shortVideoJsApiPulgin");
    this.mRuntime.a().registerReceiver(this.a, localIntentFilter);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mRuntime.a().unregisterReceiver(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.ShortVideoJsApiPlugin
 * JD-Core Version:    0.7.0.1
 */