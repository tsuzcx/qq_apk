package com.tencent.mobileqq.vaswebviewplugin;

import actn;
import ajyc;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import anql;
import anqp;
import anqu;
import anvl;
import aqbc;
import axqw;
import bbbd;
import bbcv;
import bbev;
import bbgu;
import bcdb;
import bcpq;
import bcpw;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmojiJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "emoji";
  public static String KEY_CALLABCKID = "callbackid";
  public static String KEY_DEMOJI_MAKE_ID;
  public static String KEY_DEMOJI_MAKE_RESULT;
  public static final String KEY_EMOJIMALL_CLOSE_BACK = "back_from_emojimall";
  public static final String KEY_EMOJIMALL_DETAIL_ID = "emojimall_detail_id";
  public static final String KEY_EMOJIMALL_QFACE = "emojimall_qFace";
  public static final String KEY_EMOJIMALL_SID = "emojimall_sid";
  public static final String KEY_EMOJIMALL_SRC_FROM = "emojimall_src";
  protected static final String KEY_MALL_NEW_TIMESTAMP = "emomall_new_time";
  protected static final String KEY_PAGE_OPEN_TIME = "openpagetime";
  public static final String OBJECT_NAME = "_qqJSBridge_";
  public static final int REQUEST_CODE_QFACE = 201;
  public static final int RESULT_QFACE_LOSSY = 102;
  public static final int RESULT_QFACE_PATH_ERROR = 101;
  public static String TAG = "EmojiJsPlugin";
  private Vector<Pair<Integer, String>> mDownloadingFunctions = new Vector();
  protected int mEmomallNewTimeFlag = -1;
  protected String mSelfUin;
  protected int mSrcFromType = 1;
  private EmojiJsPlugin.MakeDynamicEmojiInfo makeInfo;
  bcpq progressDialog;
  
  static
  {
    KEY_DEMOJI_MAKE_RESULT = "makeresultcode";
    KEY_DEMOJI_MAKE_ID = "qFace_material_id";
  }
  
  public EmojiJsPlugin()
  {
    this.mPluginNameSpace = "emoji";
  }
  
  private void buyEmoji(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    paramString5 = this.mRuntime.a();
    if (paramString5 != null)
    {
      showProgressDialog();
      paramString4 = (TicketManager)paramString5.getManager(2);
      paramString5 = paramString5.getAccount();
      if ((paramString4 != null) && (paramString5 != null))
      {
        paramString4 = paramString4.getSkey(paramString5);
        dismissProgressDialog();
        if (TextUtils.isEmpty(paramString4)) {
          break label125;
        }
        if (bbev.d(this.mRuntime.a().getApplicationContext())) {
          break label98;
        }
        onPayResultCallback("net unsupport", 4, 0, -1, -1, -1, paramString1);
      }
    }
    label98:
    label125:
    while (!QLog.isColorLevel())
    {
      return;
      PayBridgeActivity.a(this.mRuntime.a(), paramString1, paramString2, paramString3, paramString4, paramString9, paramString7, paramString8, paramString10, paramString11);
      return;
      onPayResultCallback("skey null", 8, 0, -1, -1, -1, paramString1);
      return;
    }
    QLog.e(TAG, 2, "buyEmoji, AppInterface null.");
  }
  
  private void buyGoods(String paramString1, String paramString2)
  {
    PayBridgeActivity.tenpay(this.mRuntime.a(), paramString2, 7, paramString1);
  }
  
  private void clearDownloadingObservers()
  {
    synchronized (this.mDownloadingFunctions)
    {
      this.mDownloadingFunctions.clear();
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "clearDownloadingObservers clear all:");
      }
      return;
    }
  }
  
  private void closePage(int paramInt)
  {
    if (this.mRuntime.a() != null) {
      this.mRuntime.a().finish();
    }
  }
  
  private void collectEmoji(EmojiJsPlugin.JSONWrapper paramJSONWrapper, String paramString)
  {
    Emoticon localEmoticon = new Emoticon();
    localEmoticon.epId = paramJSONWrapper.getString("pkgId");
    localEmoticon.eId = paramJSONWrapper.getString("itemId");
    paramJSONWrapper = new Bundle();
    paramJSONWrapper.putSerializable("emoticon", localEmoticon);
    paramJSONWrapper = anqp.a("collectEmoji", paramString, this.mOnRemoteResp.key, paramJSONWrapper);
    anvl.a().a(paramJSONWrapper);
  }
  
  private void dismissProgressDialog()
  {
    if ((this.mRuntime != null) && (this.mRuntime.a() != null)) {
      this.mRuntime.a().runOnUiThread(new EmojiJsPlugin.9(this));
    }
  }
  
  private void emojiStickerAddFavorites(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("messageSeq", paramString1);
      paramString1 = anqp.a("emojiStickerAddFavorites", paramString2, this.mOnRemoteResp.key, localBundle);
      anvl.a().a(paramString1);
      showProgressDialog();
    }
  }
  
  private void emojiStickerRecall(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("messageSeq", paramString1);
      localBundle.putString("recallCallbackId", paramString2);
      localBundle.putInt("reCallKey", this.mOnRemoteResp.key);
      paramString1 = anqp.a("emojiStickerRecall", paramString2, this.mOnRemoteResp.key, localBundle);
      anvl.a().a(paramString1);
      showProgressDialog();
    }
  }
  
  private void getCollectEmojiStatus(EmojiJsPlugin.JSONWrapper paramJSONWrapper, String paramString)
  {
    Emoticon localEmoticon = new Emoticon();
    localEmoticon.epId = paramJSONWrapper.getString("pkgId");
    localEmoticon.eId = paramJSONWrapper.getString("itemId");
    paramJSONWrapper = new Bundle();
    paramJSONWrapper.putSerializable("emoticon", localEmoticon);
    paramJSONWrapper = anqp.a("getCollectEmojiStatus", paramString, this.mOnRemoteResp.key, paramJSONWrapper);
    anvl.a().a(paramJSONWrapper);
  }
  
  private void getNetwork(String paramString)
  {
    int i = bbev.a(this.mRuntime.a().getApplicationContext());
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("result", 0);
      localJSONObject1.put("message", "");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("status", i);
      localJSONObject1.put("data", localJSONObject2);
      onAppResponse(paramString, localJSONObject1.toString());
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void getSessionKey(String paramString1, String paramString2)
  {
    Object localObject2 = this.mRuntime.a();
    if (localObject2 != null)
    {
      showProgressDialog();
      localObject1 = (TicketManager)((AppInterface)localObject2).getManager(2);
      localObject2 = ((AppInterface)localObject2).getAccount();
      if ((localObject1 != null) && (localObject2 != null) && (!"sid".equals(paramString1))) {}
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        do
        {
          return;
        } while (!"skey".equals(paramString1));
        Object localObject1 = ((TicketManager)localObject1).getSkey((String)localObject2);
        dismissProgressDialog();
        int i = 0;
        paramString1 = "getsession skey ok";
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          i = -1;
          paramString1 = "getsession skey error";
        }
        localObject2 = new JSONObject();
        try
        {
          ((JSONObject)localObject2).put("result", i);
          ((JSONObject)localObject2).put("message", paramString1);
          ((JSONObject)localObject2).put("data", localObject1);
          onAppResponse(paramString2, ((JSONObject)localObject2).toString());
          return;
        }
        catch (JSONException paramString1) {}
      } while (!QLog.isColorLevel());
      QLog.e(TAG, 2, "getSessionKey, skey, onAppResponse exception: " + paramString1.getMessage());
      return;
    }
    QLog.e(TAG, 2, "getSessionKey, AppInterface null.");
  }
  
  private void makeToast(String paramString)
  {
    bcpw.a(this.mRuntime.a(), paramString, 0).b(this.mRuntime.a().getResources().getDimensionPixelSize(2131298865));
  }
  
  private void onPayResultCallback(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject1.put("result", paramInt1);
      localJSONObject1.put("message", paramString1);
      localJSONObject2.put("realSaveNum", paramInt2);
      localJSONObject2.put("payChannel", paramInt3);
      localJSONObject2.put("payState", paramInt4);
      localJSONObject2.put("provideState", paramInt5);
      localJSONObject1.put("data", localJSONObject2);
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "queryEmojiInfo resp to js:" + localJSONObject1.toString());
      }
      onAppResponse(paramString2, localJSONObject1.toString());
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private void openPage(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        localObject = this.mRuntime.a();
        if (localObject != null)
        {
          showProgressDialog();
          paramString1 = (TicketManager)((AppInterface)localObject).getManager(2);
          localObject = ((AppInterface)localObject).getAccount();
          if ((paramString1 == null) || (localObject == null)) {
            break label100;
          }
          paramString1 = paramString1.getSkey((String)localObject);
          dismissProgressDialog();
          if (TextUtils.isEmpty(paramString1)) {
            break label83;
          }
          openSubPage(paramString2, paramString3);
        }
      }
      label83:
      label100:
      while (!QLog.isColorLevel())
      {
        do
        {
          Object localObject;
          do
          {
            return;
          } while (!QLog.isColorLevel());
          QLog.w(TAG, 2, "Open page failed, skey null");
          return;
        } while (!QLog.isColorLevel());
        QLog.w(TAG, 2, "Open page failed, ticketmanager or uin null");
        return;
      }
      QLog.w(TAG, 2, "Open page failed, pageUrl null");
      return;
    }
    openSubPage(paramString2, paramString3);
  }
  
  private void openService(String paramString1, String paramString2)
  {
    PayBridgeActivity.tenpay(this.mRuntime.a(), paramString2, 4, paramString1);
  }
  
  private void openSubPage(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    String str = getInfoIntent().getExtras().getString("key_emojimall_detail_chat_uin");
    int i = getInfoIntent().getExtras().getInt("key_emojimall_detail_chat_type");
    Intent localIntent = new Intent();
    localIntent.putExtra("emojimall_src", this.mSrcFromType);
    localIntent.putExtra("selfuin", this.mSelfUin);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("pageTitle", paramString2);
    localIntent.putExtra("key_emojimall_detail_chat_uin", str);
    localIntent.putExtra("key_emojimall_detail_chat_type", i);
    localIntent.putExtra("openpagetime", System.currentTimeMillis());
    localIntent.putExtra("emomall_new_time", this.mEmomallNewTimeFlag);
    localIntent.putExtra("reqType", 6);
    VasWebviewUtil.openQQBrowserWithoutAD(this.mRuntime.a(), null, 8L, localIntent, false, -1);
  }
  
  private void openTenpayView(String paramString1, String paramString2)
  {
    PayBridgeActivity.tenpay(this.mRuntime.a(), paramString2, 5, paramString1);
  }
  
  private void queryEmojiInfo(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString2);
    localBundle.putInt("businessType", paramInt1);
    localBundle.putInt("sceneType", paramInt2);
    paramString1 = anqp.a("queryEmojiInfo", paramString1, this.mOnRemoteResp.key, localBundle);
    anvl.a().a(paramString1);
  }
  
  private void queryEmojiInfos(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("sceneType", paramInt);
    paramString = anqp.a("queryEmojiInfos", paramString, this.mOnRemoteResp.key, localBundle);
    anvl.a().a(paramString);
  }
  
  private void queryEmojiStickerInfos(String paramString)
  {
    Bundle localBundle = new Bundle();
    paramString = anqp.a("queryEmojiStickerInfos", paramString, this.mOnRemoteResp.key, localBundle);
    anvl.a().a(paramString);
  }
  
  private void rechargeGameCurrency(String paramString1, String paramString2)
  {
    PayBridgeActivity.tenpay(this.mRuntime.a(), paramString2, 6, paramString1);
  }
  
  private void rechargeQb(String paramString1, String paramString2)
  {
    PayBridgeActivity.tenpay(this.mRuntime.a(), paramString2, 8, paramString1);
  }
  
  private void respMakeDynamicEmoji(int paramInt, String paramString)
  {
    if (this.makeInfo == null) {}
    while (((paramString == null) || (this.makeInfo == null) || (!paramString.equals(Integer.toString(this.makeInfo.emoPackId)))) && (paramInt != 4)) {
      return;
    }
    try
    {
      paramString = new JSONObject();
      paramString.put("result", paramInt);
      onAppResponse(this.makeInfo.callbackid, paramString.toString());
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void sendEmojiToAIO(EmojiJsPlugin.JSONWrapper paramJSONWrapper, String paramString)
  {
    Emoticon localEmoticon = new Emoticon();
    localEmoticon.epId = paramJSONWrapper.getString("pkgId");
    localEmoticon.eId = paramJSONWrapper.getString("itemId");
    localEmoticon.isAPNG = paramJSONWrapper.getBoolean("isAPNG", false);
    localEmoticon.name = paramJSONWrapper.getString("itemName");
    paramJSONWrapper = new Bundle();
    paramJSONWrapper.putSerializable("emoticon", localEmoticon);
    paramJSONWrapper = anqp.a("sendEmojiToAIO", paramString, this.mOnRemoteResp.key, paramJSONWrapper);
    anvl.a().a(paramJSONWrapper);
  }
  
  private void sendEmojiToFriend(int paramInt)
  {
    try
    {
      Object localObject = getInfoIntent().getExtras().getString("key_emojimall_detail_chat_uin");
      int i = getInfoIntent().getExtras().getInt("key_emojimall_detail_chat_type");
      axqw.a(null, "CliOper", "", "", "ep_mall", "Clk_send_detail", 0, 0, "", "", "", paramInt + "");
      if (((this.mSrcFromType == 1) || (this.mSrcFromType == 8)) && (localObject != null))
      {
        localBundle = new Bundle();
        localBundle.putString("uin", (String)localObject);
        localBundle.putInt("uintype", i);
        localBundle.putInt("FORWARD_EMOPGK_ID", paramInt);
        localBundle.putBoolean("isBack2Root", true);
        localObject = actn.a(new Intent(this.mRuntime.a().getApplicationContext(), SplashActivity.class), new int[] { 2 });
        this.mRuntime.a().getSharedPreferences("mobileQQ", 4).edit().putBoolean("FORWARD_EMOPGK_ID", true).commit();
        ((Intent)localObject).putExtras(localBundle);
        this.mRuntime.a().startActivity((Intent)localObject);
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 14);
      localBundle.putInt("FORWARD_EMOPGK_ID", paramInt);
      localObject = new Intent(this.mRuntime.a().getApplicationContext(), ForwardRecentActivity.class);
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtras(localBundle);
      this.mRuntime.a().startActivity((Intent)localObject);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, localException.getMessage());
      }
    }
  }
  
  private void showMsgBox(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString4 = paramString4.split("\t");
    if (paramString4.length >= 1)
    {
      paramString2 = bbcv.a(this.mRuntime.a(), 230).a(paramString3).b(paramString2).a(paramString4[0], new EmojiJsPlugin.1(this, paramString1));
      if (paramString4.length >= 2) {
        paramString2.b(paramString4[1], new EmojiJsPlugin.2(this, paramString1));
      }
      if (paramString4.length >= 3) {
        paramString2.c(paramString4[2], new EmojiJsPlugin.3(this, paramString1));
      }
      paramString2.setCanceledOnTouchOutside(false);
      paramString2.setOnKeyListener(new EmojiJsPlugin.4(this, paramString2, paramString1));
      paramString2.show();
    }
  }
  
  private void showProgressDialog()
  {
    if ((this.mRuntime != null) && (this.mRuntime.a() != null)) {
      this.mRuntime.a().runOnUiThread(new EmojiJsPlugin.8(this));
    }
  }
  
  private void startDownloadEmoji(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    try
    {
      JSONObject localJSONObject;
      if (!bbbd.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "SDCard not available.");
        }
        localJSONObject = new JSONObject();
        localJSONObject.put("result", 6);
        localJSONObject.put("message", "SDCard not available.");
        onAppResponse(paramString, localJSONObject.toString());
        return;
      }
      long l = bbbd.b();
      if (l < 5242880)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "Insufficient SDCard space, required: reserved:" + 5242880 + "|available:" + l);
        }
        localJSONObject = new JSONObject();
        localJSONObject.put("result", 1);
        localJSONObject.put("message", "Insufficient SDCard space.");
        onAppResponse(paramString, localJSONObject.toString());
        return;
      }
    }
    catch (JSONException localJSONException1)
    {
      localJSONException1.printStackTrace();
      Object localObject;
      if (bbev.d(this.mRuntime.a().getApplicationContext())) {
        if ((!paramBoolean) || (bbev.b(this.mRuntime.a().getApplicationContext()) == 1))
        {
          localObject = new Bundle();
          ((Bundle)localObject).putInt("id", paramInt1);
          ((Bundle)localObject).putInt("businessType", paramInt2);
          ((Bundle)localObject).putInt("sceneType", paramInt3);
          localObject = anqp.a("startDownloadEmoji", paramString, this.mOnRemoteResp.key, (Bundle)localObject);
          addDownloadingStateObserver(new Pair(Integer.valueOf(paramInt1), paramString));
          anvl.a().b((Bundle)localObject);
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d(TAG, 2, "js startDownloadEmoji ,callbackid:" + paramString + "emoPackId" + paramInt1);
        return;
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "startDownloadEmoji non wifi net");
        }
        localObject = bbcv.a(this.mRuntime.a(), 230).a(this.mRuntime.a().getString(2131692042)).b(this.mRuntime.a().getString(2131692041)).a(this.mRuntime.a().getString(2131692039), new EmojiJsPlugin.6(this, paramString)).c(this.mRuntime.a().getString(2131692040), new EmojiJsPlugin.5(this, paramInt1, paramInt2, paramInt3, paramString));
        ((bbgu)localObject).setOnKeyListener(new EmojiJsPlugin.7(this, (bbgu)localObject, paramString));
        ((bbgu)localObject).setCanceledOnTouchOutside(false);
        ((bbgu)localObject).show();
        continue;
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("result", 5);
          ((JSONObject)localObject).put("message", "no net");
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "startDownloadEmoji resp to js onDownloadingResultSingle:" + ((JSONObject)localObject).toString());
          }
          onAppResponse(paramString, ((JSONObject)localObject).toString());
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            localJSONException2.printStackTrace();
          }
        }
        anqu.a(this.mRuntime.a());
      }
    }
  }
  
  private void stopDownloadEmoji(String paramString, int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("id", paramInt1);
    localBundle.putInt("sceneType", paramInt2);
    paramString = anqp.a("stopDownloadEmoji", paramString, this.mOnRemoteResp.key, localBundle);
    anvl.a().a(paramString);
  }
  
  protected void OnActivityCreate()
  {
    this.mSrcFromType = getInfoIntent().getExtras().getInt("emojimall_src", 1);
    this.mEmomallNewTimeFlag = getInfoIntent().getExtras().getInt("emomall_new_time", -1);
  }
  
  void addDownloadingStateObserver(Pair<Integer, String> paramPair)
  {
    Vector localVector = this.mDownloadingFunctions;
    if (paramPair != null) {}
    try
    {
      if (!this.mDownloadingFunctions.contains(paramPair))
      {
        this.mDownloadingFunctions.add(paramPair);
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "addDownloadingStateObserver id:" + paramPair.first + "callbackid:" + (String)paramPair.second);
        }
      }
      return;
    }
    finally {}
  }
  
  protected boolean excuteEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (8589934603L == paramLong)
    {
      if (paramMap != null)
      {
        paramString = (String)paramMap.get(KEY_DEMOJI_MAKE_ID);
        respMakeDynamicEmoji(((Integer)paramMap.get(KEY_DEMOJI_MAKE_RESULT)).intValue(), paramString);
      }
      return true;
    }
    return false;
  }
  
  protected long getPluginBusiness()
  {
    return 2147483662L;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"emoji".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    if ((TextUtils.isEmpty(this.mSelfUin)) && (this.mRuntime.a() != null)) {
      this.mSelfUin = this.mRuntime.a().getAccount();
    }
    try
    {
      paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (paramJsBridgeListener == null) {
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "handleJsRequest JSON = " + paramJsBridgeListener.toString());
      }
      paramString1 = paramJsBridgeListener.optString("callback");
      if (TextUtils.isEmpty(paramString1))
      {
        QLog.e(TAG, 1, "callback id is null, so return");
        return true;
      }
      if ("demojiremake".equals(paramString3))
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        paramString1 = (String)paramJsBridgeListener.get(KEY_DEMOJI_MAKE_ID);
        respMakeDynamicEmoji(((Integer)paramJsBridgeListener.get(KEY_DEMOJI_MAKE_RESULT)).intValue(), paramString1);
      }
      else
      {
        invoke(paramString3, paramJsBridgeListener.toString(), paramString1);
      }
    }
    catch (Throwable paramJsBridgeListener)
    {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, paramJsBridgeListener.getMessage());
      }
    }
    return true;
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(this.mSelfUin)) && (this.mRuntime.a() != null)) {
      this.mSelfUin = this.mRuntime.a().getAccount();
    }
    return handleEmojiSchemaRequest(paramString1, paramString2);
  }
  
  public void invoke(String paramString1, String paramString2, String paramString3)
  {
    boolean bool2 = true;
    if (!anvl.a().a()) {
      anvl.a().a().doBindService(this.mRuntime.a().getApplicationContext());
    }
    JSONObject localJSONObject;
    EmojiJsPlugin.JSONWrapper localJSONWrapper;
    int i;
    int j;
    int k;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)))
    {
      try
      {
        localJSONObject = new JSONObject(paramString2);
        localJSONWrapper = new EmojiJsPlugin.JSONWrapper(localJSONObject);
        if (paramString1.equals("openPage"))
        {
          openPage(paramString3, localJSONWrapper.getString("pageUrl"), localJSONWrapper.getString("pageTitle"), localJSONWrapper.getBoolean("pageSession", false));
          return;
        }
        if (paramString1.equals("showMsgBox"))
        {
          showMsgBox(paramString3, localJSONWrapper.getString("prompt"), localJSONWrapper.getString("title"), localJSONWrapper.getString("button"));
          return;
        }
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      if (paramString1.equals("buyEmoji"))
      {
        buyEmoji(paramString3, localJSONWrapper.getString("appId"), localJSONWrapper.getString("userId"), localJSONWrapper.getString("userKey"), localJSONWrapper.getString("sessionId"), localJSONWrapper.getString("sessionType"), localJSONWrapper.getString("pf"), localJSONWrapper.getString("pfKey"), localJSONWrapper.getString("zoneId"), localJSONWrapper.getString("tokenUrl"), localJSONWrapper.getString("drmInfo"));
        return;
      }
      if (paramString1.equals("queryEmojiInfo"))
      {
        queryEmojiInfo(paramString3, localJSONWrapper.getString("id"), localJSONWrapper.getInt("businessType", 1), localJSONWrapper.getInt("sceneType", 0));
        return;
      }
      if (paramString1.equals("queryEmojiInfos"))
      {
        queryEmojiInfos(paramString3, localJSONWrapper.getInt("sceneType", 0));
        return;
      }
      if (paramString1.equals("startDownloadEmoji"))
      {
        i = localJSONWrapper.getInt("id", 0);
        j = localJSONWrapper.getInt("businessType", 1);
        k = localJSONWrapper.getInt("sceneType", 0);
        bool1 = bool2;
        if (localJSONObject.has("withoutFlowTips")) {
          if (localJSONObject.getBoolean("withoutFlowTips")) {
            break label803;
          }
        }
      }
    }
    label803:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      startDownloadEmoji(paramString3, i, j, bool1, k);
      return;
      if (paramString1.equals("sendEmojiToFrd"))
      {
        sendEmojiToFriend(localJSONWrapper.getInt("id", 0));
        return;
      }
      if (paramString1.equals("stopDownloadEmoji"))
      {
        stopDownloadEmoji(paramString3, localJSONWrapper.getInt("id", 0), localJSONWrapper.getInt("sceneType", 0));
        return;
      }
      if (paramString1.equals("closePage"))
      {
        closePage(0);
        return;
      }
      if (paramString1.equals("getSessionKey"))
      {
        getSessionKey(localJSONWrapper.getString("type"), paramString3);
        return;
      }
      if (paramString1.equals("getNetwork"))
      {
        getNetwork(paramString3);
        return;
      }
      if ("makeDynamicEmoji".equals(paramString1))
      {
        localJSONWrapper.getInt("id", 0);
        return;
      }
      if ("openService".equals(paramString1))
      {
        openService(paramString3, paramString2);
        return;
      }
      if ("rechargeGameCurrency".equals(paramString1))
      {
        rechargeGameCurrency(paramString3, paramString2);
        return;
      }
      if ("buyGoods".equals(paramString1))
      {
        buyGoods(paramString3, paramString2);
        return;
      }
      if ("rechargeQb".equals(paramString1))
      {
        rechargeQb(paramString3, paramString2);
        return;
      }
      if ("openTenpayView".equals(paramString1))
      {
        openTenpayView(paramString3, paramString2);
        return;
      }
      if ("getVipType".equals(paramString1))
      {
        getVipType(localJSONObject, paramString3);
        return;
      }
      if ("queryEmojiStickerInfos".equals(paramString1))
      {
        queryEmojiStickerInfos(paramString3);
        return;
      }
      if ("emojiStickerRecall".equals(paramString1))
      {
        emojiStickerRecall(localJSONWrapper.getString("hash"), paramString3);
        return;
      }
      if ("emojiStickerAddFavorites".equals(paramString1))
      {
        emojiStickerAddFavorites(localJSONWrapper.getString("hash"), paramString3);
        return;
      }
      if ("sendEmojiToAIO".equals(paramString1))
      {
        sendEmojiToAIO(localJSONWrapper, paramString3);
        return;
      }
      if ("collectEmoji".equals(paramString1))
      {
        collectEmoji(localJSONWrapper, paramString3);
        return;
      }
      if ("getCollectEmojiStatus".equals(paramString1))
      {
        getCollectEmojiStatus(localJSONWrapper, paramString3);
        return;
      }
      paramString1 = new JSONObject();
      try
      {
        localJSONObject.put("result", -1);
        localJSONObject.put("message", "error handler");
        onAppResponse(paramString3, paramString1.toString());
        return;
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
      }
      return;
    }
  }
  
  public void onAppResponse(String paramString1, String paramString2)
  {
    super.callJs(paramString1 + "(" + paramString2 + ");");
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    clearDownloadingObservers();
  }
  
  public void onDisconnectWithService()
  {
    onDownloadingResultAll(-1, "service disconnect");
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onDisconnectWithService");
    }
  }
  
  void onDownloadingResultAll(int paramInt, String paramString)
  {
    synchronized (this.mDownloadingFunctions)
    {
      Iterator localIterator = this.mDownloadingFunctions.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Pair localPair = (Pair)localIterator.next();
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("result", paramInt);
            localJSONObject.put("message", paramString);
            if (QLog.isColorLevel()) {
              QLog.i(TAG, 2, "onDownloadingResultAll startDownloadEmoji resp to js onDownloadingResultall:" + localJSONObject.toString());
            }
            onAppResponse((String)localPair.second, localJSONObject.toString());
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
    this.mDownloadingFunctions.clear();
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "onDownloadingResultAll clear all:");
    }
  }
  
  void onDownloadingResultSingle(int paramInt1, int paramInt2, String paramString)
  {
    Vector localVector = this.mDownloadingFunctions;
    if (paramInt1 > 0)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      try
      {
        localObject1 = new Vector();
        localObject2 = this.mDownloadingFunctions.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Pair)((Iterator)localObject2).next();
          if (((Integer)((Pair)localObject3).first).intValue() == paramInt1) {
            ((Vector)localObject1).add(localObject3);
          }
        }
        localObject1 = ((Vector)localObject1).iterator();
      }
      finally {}
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label290;
        }
        localObject2 = (Pair)((Iterator)localObject1).next();
        localObject3 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("result", paramInt2);
          ((JSONObject)localObject3).put("message", paramString);
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onDownloadingResultSingle startDownloadEmoji resp to js onDownloadingResultSingle:" + ((JSONObject)localObject3).toString());
          }
          onAppResponse((String)((Pair)localObject2).second, ((JSONObject)localObject3).toString());
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
        this.mDownloadingFunctions.remove(localObject2);
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "onDownloadingResultSingle remove id:" + ((Pair)localObject2).first + "callbackid:" + (String)((Pair)localObject2).second + "mDownloadingFunctions size:" + this.mDownloadingFunctions.size());
        }
      }
    }
    label290:
  }
  
  public void onPushMsg(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("packetid", -1);
      int j = paramBundle.getInt("resultcode", -1);
      onDownloadingResultSingle(i, j, "");
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "onPushMsg + id:" + i + ",resultcode:" + j);
      }
    }
  }
  
  public void onResponse(Bundle paramBundle)
  {
    Object localObject2;
    String str;
    Object localObject3;
    Object localObject1;
    int k;
    int i;
    int j;
    int m;
    long l;
    int n;
    int i1;
    JSONObject localJSONObject1;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key))
    {
      localObject2 = paramBundle.getString("cmd");
      str = paramBundle.getString("callbackid");
      localObject3 = paramBundle.getBundle("request");
      localObject1 = paramBundle.getBundle("response");
      k = paramBundle.getInt("failcode");
      if (localObject2 != null)
      {
        if (!((String)localObject2).equals("queryEmojiInfo")) {
          break label441;
        }
        i = ((Bundle)localObject1).getInt("result");
        paramBundle = ((Bundle)localObject1).getString("messge");
        j = ((Bundle)localObject1).getInt("status");
        m = ((Bundle)localObject1).getInt("pluginStatus");
        l = ((Bundle)localObject1).getLong("pluginSize");
        n = ((Bundle)localObject1).getInt("progress");
        i1 = ((Bundle)localObject1).getInt("dynamicEmojiId");
        localObject2 = ((Bundle)localObject1).getStringArrayList("dynamicEmojiList");
        localObject1 = ((Bundle)localObject1).getStringArrayList("urlParamsList");
        if (k != 1000)
        {
          i = -1;
          paramBundle = "queryEmojiInfo error";
        }
        localObject3 = new JSONObject();
        localJSONObject1 = new JSONObject();
      }
    }
    label441:
    do
    {
      for (;;)
      {
        try
        {
          ((JSONObject)localObject3).put("result", i);
          ((JSONObject)localObject3).put("message", paramBundle);
          localJSONObject1.put("status", j);
          localJSONObject1.put("progress", n);
          localJSONObject1.put("pluginSize", l);
          localJSONObject1.put("pluginStatus", m);
          if (i1 > 0) {
            localJSONObject1.put("dynamicEmojiId", i1);
          }
          if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
          {
            paramBundle = new JSONArray();
            i = 0;
            if (i < ((ArrayList)localObject2).size())
            {
              JSONObject localJSONObject2 = new JSONObject();
              localJSONObject2.put("src", ((ArrayList)localObject2).get(i));
              localJSONObject2.put("urlParam", ((ArrayList)localObject1).get(i));
              paramBundle.put(localJSONObject2);
              i += 1;
              continue;
            }
            localJSONObject1.put("dynamicEmojiList", paramBundle);
          }
          ((JSONObject)localObject3).put("data", localJSONObject1);
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "queryEmojiInfo resp to js:" + ((JSONObject)localObject3).toString());
          }
          onAppResponse(str, ((JSONObject)localObject3).toString());
          return;
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
          return;
        }
        if ("queryEmojiStickerInfos".equals(localObject2))
        {
          if (localObject1 != null)
          {
            localObject2 = ((Bundle)localObject1).getParcelableArrayList("stickerInfos");
            if (localObject2 != null)
            {
              try
              {
                paramBundle = new JSONObject();
                localObject1 = new JSONArray();
                localObject2 = ((ArrayList)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (Bundle)((Iterator)localObject2).next();
                  localJSONObject1 = new JSONObject();
                  localJSONObject1.put("id", ((Bundle)localObject3).getString("id"));
                  localJSONObject1.put("subid", ((Bundle)localObject3).getString("subid"));
                  localJSONObject1.put("name", ((Bundle)localObject3).getString("name"));
                  localJSONObject1.put("time", ((Bundle)localObject3).getLong("time"));
                  localJSONObject1.put("nickName", ((Bundle)localObject3).getString("nickName"));
                  localJSONObject1.put("status", ((Bundle)localObject3).getInt("status"));
                  localJSONObject1.put("type", ((Bundle)localObject3).getInt("type"));
                  localJSONObject1.put("url", ((Bundle)localObject3).getString("url"));
                  localJSONObject1.put("hash", ((Bundle)localObject3).getString("hash"));
                  localJSONObject1.put("isSelf", ((Bundle)localObject3).getInt("isSelf"));
                  localJSONObject1.put("base64", ((Bundle)localObject3).getString("base64"));
                  ((JSONArray)localObject1).put(localJSONObject1);
                }
                localObject2 = new JSONObject();
              }
              catch (JSONException paramBundle)
              {
                paramBundle.printStackTrace();
                return;
              }
              ((JSONObject)localObject2).put("data", localObject1);
              paramBundle.put("data", localObject2);
              paramBundle.put("result", 0);
              paramBundle.put("message", "success");
              onAppResponse(str, paramBundle.toString());
            }
          }
        }
        else if ("emojiStickerRecall".equals(localObject2))
        {
          if (localObject1 != null)
          {
            dismissProgressDialog();
            j = ((Bundle)localObject1).getInt("result");
            localObject2 = ((Bundle)localObject1).getString("QQ");
            k = ((Bundle)localObject1).getInt("chatType");
            paramBundle = "";
            switch (j)
            {
            default: 
              i = 1;
            }
            for (;;)
            {
              makeToast(paramBundle);
              try
              {
                paramBundle = new JSONObject();
                paramBundle.put("result", j);
                onAppResponse(str, paramBundle.toString());
                VasWebviewUtil.reportCommercialDrainage((String)localObject2, "Stick", "Recall", String.valueOf(k), 0, i, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                return;
                paramBundle = ajyc.a(2131704013);
                i = 0;
                continue;
                paramBundle = ajyc.a(2131704010);
                i = 1;
                continue;
                paramBundle = ajyc.a(2131704011);
                i = 1;
              }
              catch (JSONException paramBundle)
              {
                for (;;)
                {
                  paramBundle.printStackTrace();
                }
              }
            }
          }
        }
        else if ("emojiStickerAddFavorites".equals(localObject2))
        {
          if (localObject1 != null)
          {
            dismissProgressDialog();
            i = ((Bundle)localObject1).getInt("result");
            paramBundle = "";
            switch (i)
            {
            }
            for (;;)
            {
              makeToast(paramBundle);
              try
              {
                paramBundle = new JSONObject();
                paramBundle.put("result", i);
                onAppResponse(str, paramBundle.toString());
                return;
              }
              catch (JSONException paramBundle)
              {
                paramBundle.printStackTrace();
                return;
              }
              paramBundle = ajyc.a(2131704014);
              continue;
              paramBundle = ajyc.a(2131704015);
              continue;
              paramBundle = ajyc.a(2131704012);
            }
          }
        }
        else
        {
          if ("queryEmojiInfos".equals(localObject2))
          {
            i = 0;
            paramBundle = "";
            if (k != 1000)
            {
              i = -1;
              paramBundle = "queryEmojiInfos error";
            }
            localObject2 = new JSONObject();
            localObject1 = ((Bundle)localObject1).getParcelableArrayList("pkgStatusList");
            try
            {
              ((JSONObject)localObject2).put("result", i);
              ((JSONObject)localObject2).put("message", paramBundle);
              if (localObject1 != null)
              {
                paramBundle = new JSONObject();
                localObject1 = ((ArrayList)localObject1).iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject3 = (Bundle)((Iterator)localObject1).next();
                  localJSONObject1 = new JSONObject();
                  localJSONObject1.put("status", ((Bundle)localObject3).getInt("status"));
                  localJSONObject1.put("progress", ((Bundle)localObject3).getInt("progress"));
                  localJSONObject1.put("usable", ((Bundle)localObject3).getInt("flag"));
                  i = ((Bundle)localObject3).getInt("dEmojiId");
                  if (i > 0) {
                    localJSONObject1.put("dynamicEmojiId", i);
                  }
                  paramBundle.put(((Bundle)localObject3).getString("id"), localJSONObject1);
                }
                ((JSONObject)localObject2).put("data", paramBundle);
              }
            }
            catch (JSONException paramBundle)
            {
              paramBundle.printStackTrace();
              return;
            }
            onAppResponse(str, ((JSONObject)localObject2).toString());
            return;
          }
          if ("writeQFaceResult".equals(localObject2))
          {
            i = ((Bundle)localObject1).getInt("result", -1);
            paramBundle = ((Bundle)localObject1).getString("messge");
            if (k != 1000)
            {
              i = -1;
              paramBundle = "QFaceResult error";
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.emoji.EmoQFace", 2, "write qface result, result:" + i + " msg:" + paramBundle);
            }
          }
          else
          {
            if (!((String)localObject2).equals("startDownloadEmoji")) {
              break;
            }
            n = ((Bundle)localObject1).getInt("result", -1);
            m = ((Bundle)localObject3).getInt("id");
            j = -2147483648;
            if (k == 1000) {
              if (n == 0)
              {
                i = j;
                if (QLog.isColorLevel())
                {
                  QLog.i(TAG, 2, "startDownloadEmoji resp + addDownloadingStateObserver + id:" + m + "callbackid:" + str);
                  i = j;
                }
                j = i;
                if (QLog.isColorLevel()) {
                  QLog.d(TAG, 2, "startDownloadEmoji resp suc:result:" + n);
                }
              }
            }
            for (j = i;; j = -1)
            {
              if (j == -2147483648) {
                break label1696;
              }
              if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "startDownloadEmoji resp error");
              }
              onDownloadingResultSingle(m, j, "");
              return;
              if (n == 1)
              {
                i = -1;
                break;
              }
              if (n == 3)
              {
                i = 3;
                break;
              }
              i = j;
              if (n != 4) {
                break;
              }
              i = 4;
              break;
              if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "startDownloadEmoji resp error: failcode:" + k);
              }
            }
          }
        }
      }
      if (!((String)localObject2).equals("stopDownloadEmoji")) {
        break label1836;
      }
      i = ((Bundle)localObject1).getInt("result", -1);
      paramBundle = ((Bundle)localObject1).getString("messge");
      if (k != 1000)
      {
        i = 1;
        paramBundle = "startDownloadEmoji error";
      }
      localObject1 = new JSONObject();
      try
      {
        ((JSONObject)localObject1).put("result", i);
        ((JSONObject)localObject1).put("message", paramBundle);
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "stopDownloadEmoji resp to js:" + ((JSONObject)localObject1).toString());
        }
        onAppResponse(str, ((JSONObject)localObject1).toString());
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
      }
    } while (k != 1000);
    label1696:
    return;
    label1836:
    if (((String)localObject2).equals("sendEmojiToAIO"))
    {
      i = -1;
      if (((Bundle)localObject1).getBoolean("result", false)) {
        i = 0;
      }
      try
      {
        paramBundle = new Bundle();
        paramBundle.putInt("forward_type", 9);
        paramBundle.putBoolean("direct_send_emoji", true);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtras(paramBundle);
        aqbc.a(this.mRuntime.a(), (Intent)localObject1, 21);
        paramBundle = new JSONObject();
        try
        {
          paramBundle.put("result", i);
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "sendEmojiToAIO resp to js:" + paramBundle.toString());
          }
          onAppResponse(str, paramBundle.toString());
          return;
        }
        catch (JSONException paramBundle)
        {
          QLog.e(TAG, 2, "", paramBundle);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          QLog.e(TAG, 2, "", paramBundle);
        }
      }
    }
    if (((String)localObject2).equals("getCollectEmojiStatus"))
    {
      if (((Bundle)localObject1).getBoolean("result", false)) {}
      for (i = 1;; i = 0)
      {
        paramBundle = new JSONObject();
        try
        {
          paramBundle.put("result", i);
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getCollectEmojiStatus resp to js:" + paramBundle.toString());
          }
          onAppResponse(str, paramBundle.toString());
          return;
        }
        catch (JSONException paramBundle)
        {
          QLog.e(TAG, 2, "", paramBundle);
          return;
        }
      }
    }
    if (((String)localObject2).equals("collectEmoji"))
    {
      i = ((Bundle)localObject1).getInt("result");
      paramBundle = new JSONObject();
      try
      {
        paramBundle.put("result", i);
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "collectEmoji resp to js:" + paramBundle.toString());
        }
        onAppResponse(str, paramBundle.toString());
        return;
      }
      catch (JSONException paramBundle)
      {
        QLog.e(TAG, 2, "", paramBundle);
        return;
      }
    }
    super.onResponse(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin
 * JD-Core Version:    0.7.0.1
 */