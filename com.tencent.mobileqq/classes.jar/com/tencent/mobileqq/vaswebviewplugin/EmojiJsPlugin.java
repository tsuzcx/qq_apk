package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class EmojiJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BUSINESS_NAME = "emoji";
  public static String KEY_CALLABCKID = "callbackid";
  public static String KEY_DEMOJI_MAKE_ID = "qFace_material_id";
  public static String KEY_DEMOJI_MAKE_RESULT = "makeresultcode";
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
  QQProgressDialog progressDialog;
  
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
        if (!TextUtils.isEmpty(paramString4))
        {
          if (!NetworkUtil.isNetSupport(this.mRuntime.a().getApplicationContext()))
          {
            onPayResultCallback("net unsupport", 4, 0, -1, -1, -1, paramString1);
            return;
          }
          PayBridgeActivity.startEmojimallPay(this.mRuntime.a(), paramString1, paramString2, paramString3, paramString4, paramString9, paramString7, paramString8, paramString10, paramString11);
          return;
        }
        onPayResultCallback("skey null", 8, 0, -1, -1, -1, paramString1);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e(TAG, 2, "buyEmoji, AppInterface null.");
    }
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
    paramJSONWrapper = DataFactory.a("collectEmoji", paramString, this.mOnRemoteResp.key, paramJSONWrapper);
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramJSONWrapper);
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
      paramString1 = DataFactory.a("emojiStickerAddFavorites", paramString2, this.mOnRemoteResp.key, localBundle);
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramString1);
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
      paramString1 = DataFactory.a("emojiStickerRecall", paramString2, this.mOnRemoteResp.key, localBundle);
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramString1);
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
    paramJSONWrapper = DataFactory.a("getCollectEmojiStatus", paramString, this.mOnRemoteResp.key, paramJSONWrapper);
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramJSONWrapper);
  }
  
  private void getNetwork(String paramString)
  {
    int i = NetworkUtil.getSystemNetwork(this.mRuntime.a().getApplicationContext());
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
      Object localObject1 = (TicketManager)((AppInterface)localObject2).getManager(2);
      localObject2 = ((AppInterface)localObject2).getAccount();
      if ((localObject1 != null) && (localObject2 != null))
      {
        if ("sid".equals(paramString1)) {
          return;
        }
        if ("skey".equals(paramString1))
        {
          localObject1 = ((TicketManager)localObject1).getSkey((String)localObject2);
          dismissProgressDialog();
          int i = 0;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            i = -1;
            paramString1 = "getsession skey error";
          }
          else
          {
            paramString1 = "getsession skey ok";
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
          catch (JSONException paramString1)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
          }
          paramString2 = TAG;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getSessionKey, skey, onAppResponse exception: ");
          ((StringBuilder)localObject1).append(paramString1.getMessage());
          QLog.e(paramString2, 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e(TAG, 2, "getSessionKey, AppInterface null.");
    }
  }
  
  private void makeToast(String paramString)
  {
    QQToast.a(this.mRuntime.a(), paramString, 0).b(this.mRuntime.a().getResources().getDimensionPixelSize(2131299168));
  }
  
  private void onPayResultCallback(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject = new JSONObject();
    try
    {
      localJSONObject.put("result", paramInt1);
      localJSONObject.put("message", paramString1);
      ((JSONObject)localObject).put("realSaveNum", paramInt2);
      ((JSONObject)localObject).put("payChannel", paramInt3);
      ((JSONObject)localObject).put("payState", paramInt4);
      ((JSONObject)localObject).put("provideState", paramInt5);
      localJSONObject.put("data", localObject);
      if (QLog.isColorLevel())
      {
        paramString1 = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("queryEmojiInfo resp to js:");
        ((StringBuilder)localObject).append(localJSONObject.toString());
        QLog.i(paramString1, 2, ((StringBuilder)localObject).toString());
      }
      onAppResponse(paramString2, localJSONObject.toString());
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
        Object localObject = this.mRuntime.a();
        if (localObject != null)
        {
          showProgressDialog();
          paramString1 = (TicketManager)((AppInterface)localObject).getManager(2);
          localObject = ((AppInterface)localObject).getAccount();
          if ((paramString1 != null) && (localObject != null))
          {
            paramString1 = paramString1.getSkey((String)localObject);
            dismissProgressDialog();
            if (!TextUtils.isEmpty(paramString1))
            {
              openSubPage(paramString2, paramString3);
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.w(TAG, 2, "Open page failed, skey null");
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.w(TAG, 2, "Open page failed, ticketmanager or uin null");
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.w(TAG, 2, "Open page failed, pageUrl null");
      }
    }
    else {
      openSubPage(paramString2, paramString3);
    }
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
    VasWebviewUtil.b(this.mRuntime.a(), null, 8L, localIntent, false, -1);
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
    paramString1 = DataFactory.a("queryEmojiInfo", paramString1, this.mOnRemoteResp.key, localBundle);
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramString1);
  }
  
  private void queryEmojiInfos(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("sceneType", paramInt);
    paramString = DataFactory.a("queryEmojiInfos", paramString, this.mOnRemoteResp.key, localBundle);
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramString);
  }
  
  private void queryEmojiStickerInfos(String paramString)
  {
    Bundle localBundle = new Bundle();
    paramString = DataFactory.a("queryEmojiStickerInfos", paramString, this.mOnRemoteResp.key, localBundle);
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramString);
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
    EmojiJsPlugin.MakeDynamicEmojiInfo localMakeDynamicEmojiInfo = this.makeInfo;
    if (localMakeDynamicEmojiInfo == null) {
      return;
    }
    if (((paramString == null) || (localMakeDynamicEmojiInfo == null) || (!paramString.equals(Integer.toString(localMakeDynamicEmojiInfo.emoPackId)))) && (paramInt != 4)) {
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
    paramJSONWrapper = DataFactory.a("sendEmojiToAIO", paramString, this.mOnRemoteResp.key, paramJSONWrapper);
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramJSONWrapper);
  }
  
  private void sendEmojiToFriend(int paramInt)
  {
    try
    {
      Object localObject1 = getInfoIntent().getExtras().getString("key_emojimall_detail_chat_uin");
      int i = getInfoIntent().getExtras().getInt("key_emojimall_detail_chat_type");
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("");
      ReportController.a(null, "CliOper", "", "", "ep_mall", "Clk_send_detail", 0, 0, "", "", "", ((StringBuilder)localObject2).toString());
      int j = this.mSrcFromType;
      if (((j == 1) || (this.mSrcFromType == 8)) && (localObject1 != null))
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("uin", (String)localObject1);
        ((Bundle)localObject2).putInt("uintype", i);
        ((Bundle)localObject2).putInt("FORWARD_EMOPGK_ID", paramInt);
        ((Bundle)localObject2).putBoolean("isBack2Root", true);
        localObject1 = AIOUtils.a(new Intent(this.mRuntime.a().getApplicationContext(), SplashActivity.class), new int[] { 2 });
        this.mRuntime.a().getSharedPreferences("mobileQQ", 4).edit().putBoolean("FORWARD_EMOPGK_ID", true).commit();
        ((Intent)localObject1).putExtras((Bundle)localObject2);
        this.mRuntime.a().startActivity((Intent)localObject1);
        return;
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("forward_type", 14);
      ((Bundle)localObject1).putInt("FORWARD_EMOPGK_ID", paramInt);
      localObject2 = new Intent(this.mRuntime.a().getApplicationContext(), ForwardRecentActivity.class);
      ((Intent)localObject2).addFlags(268435456);
      ((Intent)localObject2).addFlags(67108864);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      this.mRuntime.a().startActivity((Intent)localObject2);
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
      paramString2 = DialogUtil.a(this.mRuntime.a(), 230).a(paramString3).b(paramString2).a(paramString4[0], new EmojiJsPlugin.1(this, paramString1));
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
      Object localObject1;
      if (!Utils.a())
      {
        boolean bool = QLog.isColorLevel();
        if (bool) {
          QLog.d(TAG, 2, "SDCard not available.");
        }
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("result", 6);
        ((JSONObject)localObject1).put("message", "SDCard not available.");
        onAppResponse(paramString, ((JSONObject)localObject1).toString());
        return;
      }
      long l = Utils.b();
      if (l < 5242880)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = TAG;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("Insufficient SDCard space, required: reserved:");
          ((StringBuilder)localObject3).append(5242880);
          ((StringBuilder)localObject3).append("|available:");
          ((StringBuilder)localObject3).append(l);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
        }
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("result", 1);
        ((JSONObject)localObject1).put("message", "Insufficient SDCard space.");
        onAppResponse(paramString, ((JSONObject)localObject1).toString());
        return;
      }
    }
    catch (JSONException localJSONException1)
    {
      Object localObject3;
      localJSONException1.printStackTrace();
      Object localObject2;
      if (NetworkUtil.isNetSupport(this.mRuntime.a().getApplicationContext()))
      {
        if ((paramBoolean) && (NetworkUtil.getNetworkType(this.mRuntime.a().getApplicationContext()) != 1))
        {
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "startDownloadEmoji non wifi net");
          }
          localObject2 = DialogUtil.a(this.mRuntime.a(), 230).a(this.mRuntime.a().getString(2131691921)).b(this.mRuntime.a().getString(2131691920)).a(this.mRuntime.a().getString(2131691918), new EmojiJsPlugin.6(this, paramString)).c(this.mRuntime.a().getString(2131691919), new EmojiJsPlugin.5(this, paramInt1, paramInt2, paramInt3, paramString));
          ((QQCustomDialogThreeBtns)localObject2).setOnKeyListener(new EmojiJsPlugin.7(this, (QQCustomDialogThreeBtns)localObject2, paramString));
          ((QQCustomDialogThreeBtns)localObject2).setCanceledOnTouchOutside(false);
          ((QQCustomDialogThreeBtns)localObject2).show();
        }
        else
        {
          localObject2 = new Bundle();
          ((Bundle)localObject2).putInt("id", paramInt1);
          ((Bundle)localObject2).putInt("businessType", paramInt2);
          ((Bundle)localObject2).putInt("sceneType", paramInt3);
          localObject2 = DataFactory.a("startDownloadEmoji", paramString, this.mOnRemoteResp.key, (Bundle)localObject2);
          addDownloadingStateObserver(new Pair(Integer.valueOf(paramInt1), paramString));
          ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout((Bundle)localObject2);
        }
      }
      else
      {
        localObject2 = new JSONObject();
        try
        {
          ((JSONObject)localObject2).put("result", 5);
          ((JSONObject)localObject2).put("message", "no net");
          if (QLog.isColorLevel())
          {
            localObject3 = TAG;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("startDownloadEmoji resp to js onDownloadingResultSingle:");
            localStringBuilder.append(((JSONObject)localObject2).toString());
            QLog.i((String)localObject3, 2, localStringBuilder.toString());
          }
          onAppResponse(paramString, ((JSONObject)localObject2).toString());
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
        EmosmUtils.a(this.mRuntime.a());
      }
      if (QLog.isColorLevel())
      {
        String str = TAG;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("js startDownloadEmoji ,callbackid:");
        ((StringBuilder)localObject3).append(paramString);
        ((StringBuilder)localObject3).append("emoPackId");
        ((StringBuilder)localObject3).append(paramInt1);
        QLog.d(str, 2, ((StringBuilder)localObject3).toString());
      }
    }
  }
  
  private void stopDownloadEmoji(String paramString, int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("id", paramInt1);
    localBundle.putInt("sceneType", paramInt2);
    paramString = DataFactory.a("stopDownloadEmoji", paramString, this.mOnRemoteResp.key, localBundle);
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramString);
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
        if (QLog.isColorLevel())
        {
          String str = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("addDownloadingStateObserver id:");
          localStringBuilder.append(paramPair.first);
          localStringBuilder.append("callbackid:");
          localStringBuilder.append((String)paramPair.second);
          QLog.i(str, 2, localStringBuilder.toString());
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
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 32L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleJsRequest, url=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", pkgName=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", methodName=");
      localStringBuilder.append(paramString3);
      QLog.d(paramJsBridgeListener, 2, localStringBuilder.toString());
    }
    if ((paramString1 != null) && ("emoji".equals(paramString2)))
    {
      if (paramString3 == null) {
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
        if (QLog.isColorLevel())
        {
          paramString1 = TAG;
          paramString2 = new StringBuilder();
          paramString2.append("handleJsRequest JSON = ");
          paramString2.append(paramJsBridgeListener.toString());
          QLog.d(paramString1, 2, paramString2.toString());
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
          return true;
        }
        invoke(paramString3, paramJsBridgeListener.toString(), paramString1);
        return true;
      }
      catch (Throwable paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, paramJsBridgeListener.getMessage());
        }
        return true;
      }
    }
    return false;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(this.mSelfUin)) && (this.mRuntime.a() != null)) {
      this.mSelfUin = this.mRuntime.a().getAccount();
    }
    return handleEmojiSchemaRequest(paramString1, paramString2);
  }
  
  public void invoke(String paramString1, String paramString2, String paramString3)
  {
    if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).doBindService(this.mRuntime.a().getApplicationContext());
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3))) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString2);
        EmojiJsPlugin.JSONWrapper localJSONWrapper = new EmojiJsPlugin.JSONWrapper(localJSONObject);
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
        if (paramString1.equals("buyEmoji"))
        {
          buyEmoji(paramString3, localJSONWrapper.getString("appId"), localJSONWrapper.getString("userId"), localJSONWrapper.getString("userKey"), localJSONWrapper.getString("sessionId"), localJSONWrapper.getString("sessionType"), localJSONWrapper.getString("pf"), localJSONWrapper.getString("pfKey"), localJSONWrapper.getString("zoneId"), localJSONWrapper.getString("tokenUrl"), localJSONWrapper.getString("drmInfo"));
          return;
        }
        bool = paramString1.equals("queryEmojiInfo");
        if (bool)
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
          int i = localJSONWrapper.getInt("id", 0);
          int j = localJSONWrapper.getInt("businessType", 1);
          int k = localJSONWrapper.getInt("sceneType", 0);
          if (!localJSONObject.has("withoutFlowTips")) {
            break label820;
          }
          if (!localJSONObject.getBoolean("withoutFlowTips"))
          {
            break label820;
            startDownloadEmoji(paramString3, i, j, bool, k);
          }
        }
        else
        {
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
          bool = "emojiStickerRecall".equals(paramString1);
          if (bool)
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
            return;
          }
          return;
        }
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
      }
      boolean bool = false;
      continue;
      label820:
      bool = true;
    }
  }
  
  public void onAppResponse(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("(");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(");");
    super.callJs(localStringBuilder.toString());
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  protected void onDestroy()
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
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("result", paramInt);
          localJSONObject.put("message", paramString);
          if (QLog.isColorLevel())
          {
            String str = TAG;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onDownloadingResultAll startDownloadEmoji resp to js onDownloadingResultall:");
            localStringBuilder.append(localJSONObject.toString());
            QLog.i(str, 2, localStringBuilder.toString());
          }
          onAppResponse((String)localPair.second, localJSONObject.toString());
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
      this.mDownloadingFunctions.clear();
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "onDownloadingResultAll clear all:");
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  void onDownloadingResultSingle(int paramInt1, int paramInt2, String paramString)
  {
    Vector localVector = this.mDownloadingFunctions;
    if (paramInt1 > 0) {}
    try
    {
      Object localObject1 = new Vector();
      Object localObject2 = this.mDownloadingFunctions.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Pair)((Iterator)localObject2).next();
        if (((Integer)((Pair)localObject3).first).intValue() == paramInt1) {
          ((Vector)localObject1).add(localObject3);
        }
      }
      localObject1 = ((Vector)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Pair)((Iterator)localObject1).next();
        localObject3 = new JSONObject();
        Object localObject4;
        try
        {
          ((JSONObject)localObject3).put("result", paramInt2);
          ((JSONObject)localObject3).put("message", paramString);
          if (QLog.isColorLevel())
          {
            localObject4 = TAG;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onDownloadingResultSingle startDownloadEmoji resp to js onDownloadingResultSingle:");
            localStringBuilder.append(((JSONObject)localObject3).toString());
            QLog.i((String)localObject4, 2, localStringBuilder.toString());
          }
          onAppResponse((String)((Pair)localObject2).second, ((JSONObject)localObject3).toString());
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        this.mDownloadingFunctions.remove(localObject2);
        if (QLog.isColorLevel())
        {
          String str = TAG;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("onDownloadingResultSingle remove id:");
          ((StringBuilder)localObject4).append(((Pair)localObject2).first);
          ((StringBuilder)localObject4).append("callbackid:");
          ((StringBuilder)localObject4).append((String)((Pair)localObject2).second);
          ((StringBuilder)localObject4).append("mDownloadingFunctions size:");
          ((StringBuilder)localObject4).append(this.mDownloadingFunctions.size());
          QLog.i(str, 2, ((StringBuilder)localObject4).toString());
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void onPushMsg(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("packetid", -1);
      int j = paramBundle.getInt("resultcode", -1);
      onDownloadingResultSingle(i, j, "");
      if (QLog.isColorLevel())
      {
        paramBundle = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onPushMsg + id:");
        localStringBuilder.append(i);
        localStringBuilder.append(",resultcode:");
        localStringBuilder.append(j);
        QLog.i(paramBundle, 2, localStringBuilder.toString());
      }
    }
  }
  
  public void onResponse(Bundle paramBundle)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin
 * JD-Core Version:    0.7.0.1
 */