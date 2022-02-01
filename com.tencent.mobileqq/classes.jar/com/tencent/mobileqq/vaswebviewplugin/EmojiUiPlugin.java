package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.emosm.DataFactory.EmojiPayReqData;
import com.tencent.mobileqq.emosm.DataFactory.EmojiPayRespData;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class EmojiUiPlugin
  extends VasWebviewUiPlugin
  implements DialogInterface.OnDismissListener
{
  public static final String tag = "Q.emoji.web.EmojiUiPlugin";
  boolean bNeedGetKey = false;
  protected boolean closeBtnClick = false;
  EmojiUiPlugin.HomePageUrlInfo configUrl = new EmojiUiPlugin.HomePageUrlInfo(this);
  String errorUrl = "";
  String errordescription = "";
  int failcode = 0;
  EmojiUiPlugin.HomePageLoadInfo homePageUrlInfo = new EmojiUiPlugin.HomePageLoadInfo(this);
  protected int loadmode;
  int mActivityType = 2;
  OnRemoteRespObserver mEmojiKeygetOnRemoteResp = new EmojiUiPlugin.1(this);
  protected int mEmomallNewTimeFlag = -1;
  protected String mSelfUin;
  String mSid = "";
  protected int mSrcFromType = 1;
  long openToFinishOrErrorGap = -1L;
  long openToOncreateGap = -1L;
  long openTogetKeyTimeGap = -1L;
  int processStep = 1;
  QQProgressDialog progressDialog;
  
  private void dismissProgressDialog()
  {
    this.mRuntime.d().runOnUiThread(new EmojiUiPlugin.5(this));
  }
  
  private void onPayResultCallback(Intent paramIntent)
  {
    try
    {
      Object localObject1 = paramIntent.getStringExtra("callbackSn");
      Object localObject2 = paramIntent.getStringExtra("result");
      paramIntent = new JSONObject();
      paramIntent.put("result", 0);
      paramIntent.put("message", "ok");
      paramIntent.put("data", new JSONObject((String)localObject2));
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("responseId", localObject1);
      ((JSONObject)localObject2).put("responseData", paramIntent);
      paramIntent = ((JSONObject)localObject2).toString();
      localObject1 = this.mRuntime.a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("javascript:qqJSBridge.setMessage('");
      ((StringBuilder)localObject2).append(paramIntent);
      ((StringBuilder)localObject2).append("')");
      ((CustomWebView)localObject1).loadUrl(((StringBuilder)localObject2).toString());
      return;
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  private void onPayResultCallback(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2)
  {
    Object localObject = new JSONObject();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("result", paramInt1);
      ((JSONObject)localObject).put("message", paramString1);
      localJSONObject.put("realSaveNum", paramInt2);
      localJSONObject.put("payChannel", paramInt3);
      localJSONObject.put("payState", paramInt4);
      localJSONObject.put("provideState", paramInt5);
      ((JSONObject)localObject).put("data", localJSONObject);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("queryEmojiInfo resp to js:");
        paramString1.append(((JSONObject)localObject).toString());
        QLog.i("Q.emoji.web.EmojiUiPlugin", 2, paramString1.toString());
      }
      paramString1 = new JSONObject();
      paramString1.put("responseId", paramString2);
      paramString1.put("responseData", localObject);
      paramString1 = paramString1.toString();
      paramString2 = this.mRuntime.a();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("javascript:qqJSBridge.setMessage('");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("')");
      paramString2.loadUrl(((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private void showGetKeyErrorDialog()
  {
    QQCustomDialogThreeBtns localQQCustomDialogThreeBtns = DialogUtil.c(this.activity, 230).a(this.activity.getString(2131888882)).b(this.activity.getString(2131888881)).a(this.activity.getString(2131892267), new EmojiUiPlugin.3(this));
    localQQCustomDialogThreeBtns.setOnDismissListener(this);
    localQQCustomDialogThreeBtns.setCanceledOnTouchOutside(false);
    localQQCustomDialogThreeBtns.show();
  }
  
  private void showProgressDialog()
  {
    this.mRuntime.d().runOnUiThread(new EmojiUiPlugin.4(this));
  }
  
  void OnActivityCreate()
  {
    super.OnActivityCreate();
    this.mSelfUin = getInfoIntent().getExtras().getString("selfuin");
    this.mSid = getInfoIntent().getExtras().getString("emojimall_sid");
    getInfoIntent().getExtras().getBoolean("emojimall_qFace", false);
    this.openToOncreateGap = (System.currentTimeMillis() - this.startOpenPageTime);
    this.mSrcFromType = getInfoIntent().getExtras().getInt("emojimall_src", 1);
    this.mEmomallNewTimeFlag = getInfoIntent().getExtras().getInt("emomall_new_time", -1);
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.EmojiUiPlugin", 2, "emojiactivity oncreate");
    }
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.mEmojiKeygetOnRemoteResp);
  }
  
  void OnActivityDestroy()
  {
    super.OnActivityDestroy();
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.mEmojiKeygetOnRemoteResp);
  }
  
  void OnActivityPause()
  {
    super.OnActivityPause();
    if (Build.VERSION.SDK_INT < 16)
    {
      this.mRuntime.a();
      CustomWebView.disablePlatformNotifications();
    }
  }
  
  protected boolean checkOncreateParam(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    if (TextUtils.isEmpty(this.mSelfUin))
    {
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("checkOncreateParam activity type:");
        paramIntent.append(this.mActivityType);
        paramIntent.append(" selfuin null");
        QLog.i("Q.emoji.web.EmojiUiPlugin", 2, paramIntent.toString());
      }
      return false;
    }
    int i = this.mSrcFromType;
    if ((i == 8) || (i == 4))
    {
      if (getInfoIntent() != null) {
        paramIntent = getInfoIntent().getStringExtra("emojimall_detail_id");
      } else {
        paramIntent = "";
      }
      if (TextUtils.isEmpty(paramIntent))
      {
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("checkOncreateParam activity type:");
          paramIntent.append(this.mActivityType);
          paramIntent.append("detailid null");
          QLog.i("Q.emoji.web.EmojiUiPlugin", 2, paramIntent.toString());
        }
        return false;
      }
    }
    return true;
  }
  
  public void closeAllPage()
  {
    Object localObject;
    if (this.closeBtnClick)
    {
      int i = this.mSrcFromType;
      if ((i == 1) || (i == 6) || (i == 9))
      {
        this.closeBtnClick = false;
        localObject = new Intent();
        ((Intent)localObject).addFlags(536870912);
        ((Intent)localObject).putExtra("back_from_emojimall", true);
        ((Intent)localObject).setClass(this.activity, SplashActivity.class);
        localObject = AIOUtils.a((Intent)localObject, null);
        this.activity.startActivity((Intent)localObject);
        if (!QLog.isDevelopLevel()) {
          return;
        }
        QLog.d("Q.emoji.web.EmojiUiPlugin", 4, "emojimallbaseactivity closeAllPage to chatactivity");
        return;
      }
    }
    if (this.mSrcFromType == 2)
    {
      localObject = new ActivityURIRequest(this.activity, "/base/activity/EmosmActivity");
      ((ActivityURIRequest)localObject).setFlags(603979776);
      ((ActivityURIRequest)localObject).extra().putBoolean("back_from_emojimall", true);
      QRoute.startUri((URIRequest)localObject);
    }
  }
  
  public void doBeforeFinish()
  {
    closeAllPage();
  }
  
  protected boolean excuteEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934593L)
    {
      uiSetCallBack();
    }
    else if (paramLong == 8589934594L)
    {
      if (this.activity != null)
      {
        this.openToFinishOrErrorGap = (System.currentTimeMillis() - this.startOpenPageTime);
        this.processStep = 2;
      }
    }
    else if ((paramLong == 8589934595L) && (this.activity != null))
    {
      this.openToFinishOrErrorGap = (System.currentTimeMillis() - this.startOpenPageTime);
      this.processStep = 3;
    }
    return false;
  }
  
  protected void getConfigUrl(int paramInt)
  {
    if (paramInt == 6)
    {
      this.configUrl.index = IndividuationUrlHelper.a(this.activity, "magicPlus", "");
      if (this.configUrl.index == null) {
        this.configUrl.index = IndividuationUrlHelper.a(this.activity, "emoji", "");
      }
      this.configUrl.indexSession = VasWebviewConstants.LOCAL_URL_NEED_KEY_SWITCHER.booleanValue();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getConfigUrl:index:");
      localStringBuilder.append(this.configUrl.index);
      localStringBuilder.append(",detail:");
      localStringBuilder.append(this.configUrl.detail);
      localStringBuilder.append("indexsession:");
      localStringBuilder.append(this.configUrl.indexSession);
      localStringBuilder.append("detailsession:");
      localStringBuilder.append(this.configUrl.detailSession);
      QLog.i("Q.emoji.web.EmojiUiPlugin", 2, localStringBuilder.toString());
    }
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityResult request=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" result=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("Q.emoji.web.EmojiUiPlugin", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramInt1 == 1) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      localObject = DataFactory.EmojiPayRespData.a(paramIntent.getExtras());
      paramIntent = DataFactory.EmojiPayReqData.a(paramIntent.getExtras());
      onPayResultCallback(((DataFactory.EmojiPayRespData)localObject).f, ((DataFactory.EmojiPayRespData)localObject).a, ((DataFactory.EmojiPayRespData)localObject).b, ((DataFactory.EmojiPayRespData)localObject).c, ((DataFactory.EmojiPayRespData)localObject).d, ((DataFactory.EmojiPayRespData)localObject).e, paramIntent.a);
      return true;
    }
    if (paramInt1 == 4)
    {
      onPayResultCallback(paramIntent);
      return true;
    }
    if (paramInt1 == 5)
    {
      onPayResultCallback(paramIntent);
      return true;
    }
    if (paramInt1 == 9)
    {
      onPayResultCallback(paramIntent);
      return true;
    }
    if (paramInt1 == 6)
    {
      onPayResultCallback(paramIntent);
      return true;
    }
    if (paramInt1 == 8)
    {
      onPayResultCallback(paramIntent);
      return true;
    }
    if (paramInt1 == 7)
    {
      onPayResultCallback(paramIntent);
      return true;
    }
    return (paramInt1 == 201) && (paramIntent != null) && (paramIntent.getExtras() != null);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.activity.finish();
  }
  
  public void uiSetCallBack()
  {
    WebViewFragment localWebViewFragment = (WebViewFragment)this.mRuntime.f();
    if (localWebViewFragment != null)
    {
      localWebViewFragment.getUIStyleHandler().a(getInfoIntent(), this.homePageUrlInfo.homePageUrl);
      if ((localWebViewFragment.getSwiftTitleUI().d != null) && (this.mActivityType == 1))
      {
        int i = this.mSrcFromType;
        if ((i == 1) || (i == 6))
        {
          localWebViewFragment.getSwiftTitleUI().d.setText(2131887812);
          localWebViewFragment.getSwiftTitleUI().d.setOnClickListener(new EmojiUiPlugin.2(this));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin
 * JD-Core Version:    0.7.0.1
 */