package com.tencent.mobileqq.intervideo.yiqikan;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class TogetherBusinessForWebPlugin
  extends WebViewPlugin
  implements Handler.Callback, View.OnClickListener, WatchFloatingWindowController.FloatingWindowListener, EIPCResultCallback
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TogetherBusinessServlet.RspOpenIdentify jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify;
  private TogetherBusinessServlet.RspOpenStart jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenStart;
  private String jdField_a_of_type_JavaLangString = null;
  private boolean jdField_a_of_type_Boolean = true;
  private String jdField_b_of_type_JavaLangString = null;
  private boolean jdField_b_of_type_Boolean = false;
  private String c = null;
  private String d;
  
  public TogetherBusinessForWebPlugin()
  {
    this.mPluginNameSpace = "together_business";
    WatchFloatingWindowController.a().a(this);
    try
    {
      QIPCClientHelper.getInstance().register(WatchTogetherClientIPCModule.a());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TogetherBusinessForWebPlugin", 1, new Object[] { "register WatchTogetherClientIPCModule ipc module error.", localException.getMessage() });
    }
  }
  
  private Intent a()
  {
    if ((this.mRuntime != null) && (this.mRuntime.a() != null)) {
      return this.mRuntime.a().getIntent();
    }
    return null;
  }
  
  private Bundle a(String paramString1, String paramString2, String paramString3, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("uinType", -1);
    int j = i;
    if (i == -1) {
      j = paramIntent.getIntExtra("curtype", -1);
    }
    i = 1;
    if (j != 0)
    {
      if (j != 1)
      {
        paramIntent = null;
        i = -1;
      }
      else
      {
        paramIntent = paramIntent.getStringExtra("groupUin");
      }
    }
    else
    {
      paramIntent = paramIntent.getStringExtra("friend_uin");
      i = 2;
    }
    if ((!TextUtils.isEmpty(paramIntent)) && (i != -1)) {}
    try
    {
      l = Long.parseLong(paramIntent);
    }
    catch (NumberFormatException paramIntent)
    {
      long l;
      label104:
      break label104;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessForWebPlugin", 2, "uin string to long error");
    }
    l = -1L;
    if (l == -1L) {
      return null;
    }
    a(l, i, paramString1, paramString2, paramString3);
    paramIntent = new Bundle();
    paramIntent.putString("req_data", paramString1);
    paramIntent.putString("req_sign", paramString2);
    paramIntent.putInt("session_type", i);
    paramIntent.putLong("uin", l);
    paramIntent.putString("appid", paramString3);
    return paramIntent;
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("curType or uin is error: uinType=");
      paramString1.append(j);
      paramString1.append(" chatId=");
      paramString1.append(paramIntent);
      QLog.d("TogetherBusinessForWebPlugin", 2, paramString1.toString());
    }
    return null;
  }
  
  private Bundle a(String... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length <= 0) {
        return null;
      }
      try
      {
        Object localObject1 = new JSONObject(paramVarArgs[0]);
        paramVarArgs = ((JSONObject)localObject1).optString("req_data");
        localObject1 = ((JSONObject)localObject1).optString("req_sign");
        boolean bool = TextUtils.isEmpty(paramVarArgs);
        if (((bool) || (TextUtils.isEmpty((CharSequence)localObject1))) && (QLog.isColorLevel()))
        {
          localObject2 = new StringBuilder("call parseParam param error");
          ((StringBuilder)localObject2).append(" data=");
          ((StringBuilder)localObject2).append(paramVarArgs);
          ((StringBuilder)localObject2).append(" sign=");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("TogetherBusinessForWebPlugin", 2, ((StringBuilder)localObject2).toString());
        }
        Object localObject2 = new JSONObject(paramVarArgs).optString("appid");
        Intent localIntent = a();
        if (localIntent == null)
        {
          if (!QLog.isColorLevel()) {
            break label172;
          }
          QLog.d("TogetherBusinessForWebPlugin", 2, "call parseParam intent is null");
          return null;
        }
        paramVarArgs = a(paramVarArgs, (String)localObject1, (String)localObject2, localIntent);
        return paramVarArgs;
      }
      catch (JSONException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
    }
    else
    {
      return null;
    }
    label172:
    return null;
  }
  
  private String a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getCloseTogetherRoomCallBack isShow=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("TogetherBusinessForWebPlugin", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("close_room", paramBoolean);
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TogetherBusinessForWebPlugin", 4, "getCloseTogetherRoomCallBack:", localJSONException);
      }
    }
    return ((JSONObject)localObject).toString();
  }
  
  private String a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getShowButtonCallBack isShow=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" text=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TogetherBusinessForWebPlugin", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("is_show_button", paramBoolean);
      if (!TextUtils.isEmpty(paramString)) {
        ((JSONObject)localObject).put("button_text", paramString);
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return ((JSONObject)localObject).toString();
  }
  
  private JSONObject a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("quitOrCloseMsg type=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("TogetherBusinessForWebPlugin", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new JSONObject();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      ((JSONObject)localObject).put("data", localJSONObject);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localObject;
  }
  
  private void a(int paramInt, String paramString)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    QQToast.a(localBaseApplication, paramInt, paramString, 1).b(localBaseApplication.getResources().getDimensionPixelSize(2131299168));
  }
  
  private void a(long paramLong, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
  }
  
  private void a(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        String str2 = paramString.optString("uin");
        String str3 = paramString.optString("url");
        int i = paramString.optInt("aio_type");
        bool1 = paramString.optBoolean("author");
        double d1 = paramString.optDouble("video_width", 0.0D);
        double d2 = paramString.optDouble("video_height", 0.0D);
        String str1 = paramString.optString("callback", "");
        String str4 = paramString.optString("from", "watchroom");
        WatchTogetherFloatingData localWatchTogetherFloatingData = new WatchTogetherFloatingData();
        localWatchTogetherFloatingData.setSmallUrl(str3);
        localWatchTogetherFloatingData.setCurUin(str2);
        localWatchTogetherFloatingData.setCurType(i);
        localWatchTogetherFloatingData.setIsAdm(bool1);
        localWatchTogetherFloatingData.setFrom(str4);
        if ((this.mRuntime != null) && (this.mRuntime.a() != null))
        {
          paramString = this.mRuntime.a().getCurrentUrl();
        }
        else
        {
          if ((this.mRuntime == null) || (this.mRuntime.a() == null)) {
            break label589;
          }
          paramString = this.mRuntime.a().getUrl();
        }
        localWatchTogetherFloatingData.setBigUrl(paramString);
        if ((d1 > 0.0D) && (d2 > 0.0D))
        {
          localWatchTogetherFloatingData.setVideoWidth(d1);
          localWatchTogetherFloatingData.setVideoHeight(d2);
        }
        boolean bool2 = QLog.isColorLevel();
        if (!bool2) {
          break label596;
        }
        StringBuilder localStringBuilder = new StringBuilder("SHOW_FLOATING_WINDOW ");
        localStringBuilder.append("uin=");
        localStringBuilder.append(str2);
        localStringBuilder.append(" roomUrl=");
        localStringBuilder.append(str3);
        localStringBuilder.append(" sessionType=");
        localStringBuilder.append(i);
        localStringBuilder.append(" author=");
        localStringBuilder.append(bool1);
        localStringBuilder.append(" videoWidth");
        localStringBuilder.append(d1);
        localStringBuilder.append(" videoHeight=");
        localStringBuilder.append(d2);
        localStringBuilder.append(" methodName=");
        localStringBuilder.append(str1);
        localStringBuilder.append(" bigUrl");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" from=");
        localStringBuilder.append(str4);
        QLog.d("TogetherBusinessForWebPlugin", 2, localStringBuilder.toString());
        if ("watchroom".equals(str4))
        {
          if ((this.jdField_b_of_type_Boolean) && (!((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).checkPermission(BaseApplication.getContext())))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TogetherBusinessForWebPlugin", 2, "SHOW_FLOATING_WINDOW no permission");
            }
            callJs(str1, new String[] { a(true) });
            return;
          }
          i = WatchFloatingWindowController.a().a(BaseApplication.getContext(), localWatchTogetherFloatingData);
          if (i != 1) {
            break label599;
          }
          bool1 = true;
          this.jdField_b_of_type_Boolean = bool1;
          if (i != 1) {
            callJs(str1, new String[] { "" });
          }
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder("SHOW_FLOATING_WINDOW resultCode=");
            paramString.append(i);
            QLog.d("TogetherBusinessForWebPlugin", 2, paramString.toString());
          }
        }
        else
        {
          WatchFloatingWindowController.a().a(localWatchTogetherFloatingData);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      return;
      label589:
      paramString = "";
      continue;
      label596:
      continue;
      label599:
      boolean bool1 = false;
    }
  }
  
  private void a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (this.mRuntime != null)
    {
      if (this.mRuntime.a() == null) {
        return;
      }
      QQCustomDialog localQQCustomDialog = new QQCustomDialog(this.mRuntime.a(), 2131756189);
      localQQCustomDialog.setContentView(2131558978);
      if (!TextUtils.isEmpty(paramString1)) {
        localQQCustomDialog.setTitle(paramString1);
      } else {
        localQQCustomDialog.setTitle(null);
      }
      localQQCustomDialog.setMessage(paramString2);
      localQQCustomDialog.setCanceledOnTouchOutside(false);
      localQQCustomDialog.setCancelable(false);
      localQQCustomDialog.setNegativeButton(this.mRuntime.a().getString(2131690707), new TogetherBusinessForWebPlugin.3(this, localQQCustomDialog));
      localQQCustomDialog.setPositiveButton(this.mRuntime.a().getString(2131690709), paramOnClickListener);
      localQQCustomDialog.show();
    }
  }
  
  private void a(String... paramVarArgs)
  {
    try
    {
      this.d = new JSONObject(paramVarArgs[0]).optString("callback", "");
      return;
    }
    catch (Throwable paramVarArgs)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("TogetherBusinessForWebPlugin", 2, paramVarArgs, new Object[0]);
        return;
      }
    }
    catch (JSONException paramVarArgs)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessForWebPlugin", 2, paramVarArgs, new Object[0]);
      }
    }
  }
  
  private boolean a()
  {
    if (!NetworkUtil.isNetSupport(null))
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
      localMessage.obj = "当前网络不可用，请检查网络设置。";
      localMessage.arg1 = 1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button network not well");
      }
      return true;
    }
    return false;
  }
  
  private boolean a(Bundle paramBundle)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.confirmText))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button confirmText is empty");
      }
      return false;
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    localMessage.obj = new TogetherBusinessForWebPlugin.DialogElement(this, null, this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.confirmText, new TogetherBusinessForWebPlugin.2(this, paramBundle));
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    return true;
  }
  
  private boolean a(TogetherBusinessServlet.ResultInfo paramResultInfo)
  {
    if ((paramResultInfo != null) && (paramResultInfo.showErrorMsg))
    {
      if (TextUtils.isEmpty(paramResultInfo.errorMsg))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button errorMsg is empty");
        }
        return false;
      }
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
      localMessage.obj = paramResultInfo.errorMsg;
      localMessage.arg1 = 0;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button resultInfo is empty or no need showErrorMsg");
    }
    return false;
  }
  
  private boolean a(String... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length <= 0) {
        return true;
      }
      try
      {
        boolean bool = new JSONObject(paramVarArgs[0]).optBoolean("draw_button_by_qq", true);
        return bool;
      }
      catch (JSONException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
    }
    return true;
  }
  
  private void b(String paramString)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidViewView;
    if (localObject1 != null)
    {
      ((View)localObject1).setVisibility(0);
      localObject1 = this.jdField_a_of_type_AndroidWidgetButton;
      if (localObject1 != null) {
        ((Button)localObject1).setText(paramString);
      }
      return;
    }
    localObject1 = (WebViewFragment)this.mRuntime.a();
    if (localObject1 != null)
    {
      localObject2 = (ViewGroup)LayoutInflater.from(this.mRuntime.a()).inflate(2131559953, null);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(12);
      if (((WebViewFragment)localObject1).getUIStyleHandler().d != null) {
        ((WebViewFragment)localObject1).getUIStyleHandler().d.addView((View)localObject2, localLayoutParams);
      }
    }
    else
    {
      localObject1 = ((ViewStub)this.mRuntime.a().findViewById(2131372242)).inflate();
      localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).height = -2;
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    this.jdField_a_of_type_AndroidViewView = ((ViewGroup)this.mRuntime.a().findViewById(2131373196));
    localObject1 = this.jdField_a_of_type_AndroidViewView;
    if (localObject1 == null) {
      return;
    }
    ((View)localObject1).setBackgroundColor(((View)localObject1).getResources().getColor(2131167028));
    localObject1 = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).height = AIOUtils.b(75.0F, this.jdField_a_of_type_AndroidViewView.getResources());
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    ((ImageView)this.mRuntime.a().findViewById(2131365759)).setVisibility(8);
    localObject1 = (ViewGroup)this.mRuntime.a().findViewById(2131363728);
    int i = AIOUtils.b(16.0F, ((ViewGroup)localObject1).getResources());
    ((ViewGroup)localObject1).setPadding(i, 0, i, 0);
    Object localObject2 = new Button(this.mRuntime.a());
    ((Button)localObject2).setText(paramString);
    ((Button)localObject2).setGravity(17);
    ((Button)localObject2).setTextColor(this.mRuntime.a().getResources().getColor(2131167089));
    ((Button)localObject2).setBackground(this.mRuntime.a().getDrawable(2130839280));
    ((Button)localObject2).setTextSize(1, 17.0F);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localObject2);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    paramString = new RelativeLayout.LayoutParams(-1, AIOUtils.b(45.0F, this.jdField_a_of_type_AndroidViewView.getResources()));
    paramString.addRule(15);
    ((ViewGroup)localObject1).addView((View)localObject2, paramString);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("closeOrQuitBusiness ");
      localStringBuilder.append("type=");
      localStringBuilder.append(paramInt);
      QLog.d("TogetherBusinessForWebPlugin", 2, localStringBuilder.toString());
    }
    dispatchJsEvent("close_business", a(paramInt), null);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("playOrPauseVideo ");
      localStringBuilder.append("type=");
      localStringBuilder.append(paramInt);
      QLog.d("TogetherBusinessForWebPlugin", 2, localStringBuilder.toString());
    }
    dispatchJsEvent("play_control", a(paramInt), null);
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 8589934595L) && (!TextUtils.isEmpty(paramString)) && (paramString.contains("ti.qq.com/sportslive/mini/room")))
    {
      if (QLog.isColorLevel())
      {
        paramMap = new StringBuilder();
        paramMap.append("handleEvent type =");
        if (paramLong == 8589934595L) {
          paramString = "load_error";
        } else {
          paramString = "http_error";
        }
        paramMap.append(paramString);
        QLog.d("TogetherBusinessForWebPlugin", 2, paramMap.toString());
      }
      WatchFloatingWindowController.a().b(2);
      return true;
    }
    if (paramLong == 8589934623L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessForWebPlugin", 2, "handleEvent type =init_webview_complete");
      }
      WatchFloatingWindowController.a().c();
      return true;
    }
    if ((paramLong == 8589934600L) && (paramMap != null)) {
      if ((paramMap.get("requestCode") != null) && ((paramMap.get("requestCode") instanceof Integer)))
      {
        Integer localInteger = (Integer)paramMap.get("requestCode");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleEvent type =on activityResult requestCode=");
          localStringBuilder.append(localInteger);
          QLog.d("TogetherBusinessForWebPlugin", 2, localStringBuilder.toString());
        }
        if (localInteger.intValue() == 200)
        {
          WatchFloatingWindowController.a().a(null);
          return true;
        }
      }
      else
      {
        return false;
      }
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder("Call TogetherBusinessForWebPlugin handleJsRequest, url=");
      paramJsBridgeListener.append(paramString1);
      paramJsBridgeListener.append(" pkgName=");
      paramJsBridgeListener.append(paramString2);
      paramJsBridgeListener.append(" method=");
      paramJsBridgeListener.append(paramString3);
      QLog.d("TogetherBusinessForWebPlugin", 2, paramJsBridgeListener.toString());
    }
    if ("together_business".equals(paramString2))
    {
      if ("show_together_button".equals(paramString3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherBusinessForWebPlugin", 2, "call show_together_button");
        }
        a(-1L, -1, null, null, null);
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify = null;
        paramJsBridgeListener = a(paramVarArgs);
        a(paramVarArgs);
        if (paramJsBridgeListener != null)
        {
          this.jdField_a_of_type_Boolean = a(paramVarArgs);
          QIPCClientHelper.getInstance().callServer("TogetherBusinessIPCModule", "action_open_identify", paramJsBridgeListener, this);
          return true;
        }
      }
      else
      {
        if ("click_together_button".equals(paramString3))
        {
          if (QLog.isColorLevel())
          {
            paramJsBridgeListener = new StringBuilder();
            paramJsBridgeListener.append("call click_together_button mRspOpenIdentify=");
            paramJsBridgeListener.append(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify);
            QLog.d("TogetherBusinessForWebPlugin", 2, paramJsBridgeListener.toString());
          }
          this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenStart = null;
          a(-1L, -1, null, null, null);
          paramString1 = a(paramVarArgs);
          if (paramString1 != null)
          {
            paramJsBridgeListener = this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify;
            if (paramJsBridgeListener != null)
            {
              paramString1.putInt("business_type", paramJsBridgeListener.businessType);
              if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.businessType == 2)
              {
                if (this.jdField_a_of_type_Int == 2) {
                  paramJsBridgeListener = "c2c_AIO";
                } else {
                  paramJsBridgeListener = "Grp_AIO";
                }
                paramString2 = new StringBuilder();
                paramString2.append(this.jdField_a_of_type_Long);
                paramString2.append("");
                ReportController.b(null, "dc00899", paramJsBridgeListener, "", "video_tab", "clk_share_grp", 0, 0, paramString2.toString(), this.c, "", "");
              }
              if (a()) {
                return true;
              }
              if (a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.resultInfo)) {
                return true;
              }
              if (a(paramString1)) {
                return true;
              }
              QIPCClientHelper.getInstance().callServer("TogetherBusinessIPCModule", "action_open_start", paramString1, this);
              return true;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button bundle or mRspOpenIdentify is null");
          }
          return true;
        }
        if ("dispear_together_button".equals(paramString3))
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
          return true;
        }
        if ("show_floating_window".equals(paramString3))
        {
          a(paramVarArgs[0]);
          return true;
        }
        int i;
        if ("close_floating_window".equals(paramString3)) {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString1.optString("uin");
            i = paramString1.optInt("aio_type");
            paramString1 = new WatchTogetherFloatingData();
            paramString1.setCurUin(paramJsBridgeListener);
            paramString1.setCurType(i);
            if (QLog.isColorLevel())
            {
              paramString1 = new StringBuilder("CLOSE_FLOATING_WINDOW ");
              paramString1.append("uin=");
              paramString1.append(paramJsBridgeListener);
              paramString1.append(" sessionType=");
              paramString1.append(i);
              QLog.d("TogetherBusinessForWebPlugin", 2, paramString1.toString());
            }
            paramJsBridgeListener = new TogetherBusinessForWebPlugin.1(this);
            ThreadManager.getUIHandlerV2().postDelayed(paramJsBridgeListener, 500L);
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
            return true;
          }
        }
        if ("loading_status_notify".equals(paramString3)) {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
            i = paramJsBridgeListener.optInt("status");
            double d1 = paramJsBridgeListener.optDouble("video_width", 0.0D);
            double d2 = paramJsBridgeListener.optDouble("video_height", 0.0D);
            if (QLog.isColorLevel())
            {
              paramJsBridgeListener = new StringBuilder("LOAD_STATUS_NOTIFY ");
              paramJsBridgeListener.append("videoWidth=");
              paramJsBridgeListener.append(d1);
              paramJsBridgeListener.append(" videoHeight=");
              paramJsBridgeListener.append(d2);
              paramJsBridgeListener.append(" status=");
              paramJsBridgeListener.append(i);
              QLog.d("TogetherBusinessForWebPlugin", 2, paramJsBridgeListener.toString());
            }
            WatchFloatingWindowController.a().a(d1, d2);
            WatchFloatingWindowController.a().b(i);
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
      }
      return true;
    }
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      String str = (String)paramMessage.obj;
      a(paramMessage.arg1, str);
      return true;
    }
    if (paramMessage.what == 2)
    {
      paramMessage = (TogetherBusinessForWebPlugin.DialogElement)paramMessage.obj;
      a(paramMessage.jdField_a_of_type_JavaLangString, paramMessage.jdField_b_of_type_JavaLangString, paramMessage.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      return true;
    }
    if (paramMessage.what == 3)
    {
      b((String)paramMessage.obj);
      return true;
    }
    if (paramMessage.what == 4)
    {
      paramMessage = this.jdField_a_of_type_AndroidViewView;
      if (paramMessage != null) {
        paramMessage.setVisibility(8);
      }
      return true;
    }
    return false;
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      if (paramEIPCResult.data == null) {
        return;
      }
      Object localObject = paramEIPCResult.data.getSerializable("QQAIOMediaSvc.open_identify");
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify = ((TogetherBusinessServlet.RspOpenIdentify)localObject);
        boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.buttonText) ^ true;
        if (QLog.isColorLevel())
        {
          paramEIPCResult = new StringBuilder();
          paramEIPCResult.append("callback from CMD_OPEN_IDENTIFY isShowButton=");
          paramEIPCResult.append(bool);
          paramEIPCResult.append(" mDrawButtonByQQ=");
          paramEIPCResult.append(this.jdField_a_of_type_Boolean);
          QLog.d("TogetherBusinessForWebPlugin", 2, paramEIPCResult.toString());
        }
        if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.businessType == 2))
        {
          if (this.jdField_a_of_type_Int == 2) {
            paramEIPCResult = "c2c_AIO";
          } else {
            paramEIPCResult = "Grp_AIO";
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
          ((StringBuilder)localObject).append("");
          ReportController.b(null, "dc00899", paramEIPCResult, "", "video_tab", "exp_share_grp", 0, 0, ((StringBuilder)localObject).toString(), this.c, "", "");
        }
        paramEIPCResult = a(bool, this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.buttonText);
        if (!TextUtils.isEmpty(this.d)) {
          callJs(this.d, new String[] { paramEIPCResult });
        }
        if ((bool) && (this.jdField_a_of_type_Boolean))
        {
          paramEIPCResult = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
          paramEIPCResult.obj = this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.buttonText;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramEIPCResult);
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessForWebPlugin", 2, "callback from CMD_OPEN_START ");
      }
      paramEIPCResult = paramEIPCResult.data.getSerializable("QQAIOMediaSvc.open_start");
      if (paramEIPCResult == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenStart = ((TogetherBusinessServlet.RspOpenStart)paramEIPCResult);
      if (!a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenStart.resultInfo)) {}
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenStart = null;
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessForWebPlugin", 2, "call parseParam intent is null");
      }
    }
    else
    {
      Bundle localBundle = a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, (Intent)localObject);
      if (localBundle != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify;
        if (localObject != null)
        {
          localBundle.putInt("business_type", ((TogetherBusinessServlet.RspOpenIdentify)localObject).businessType);
          if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.businessType == 2)
          {
            if (this.jdField_a_of_type_Int == 2) {
              localObject = "c2c_AIO";
            } else {
              localObject = "Grp_AIO";
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.jdField_a_of_type_Long);
            localStringBuilder.append("");
            ReportController.b(null, "dc00899", (String)localObject, "", "video_tab", "clk_share_grp", 0, 0, localStringBuilder.toString(), this.c, "", "");
          }
          if ((a()) || (a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanTogetherBusinessServlet$RspOpenIdentify.resultInfo)) || (a(localBundle))) {
            break label238;
          }
          QIPCClientHelper.getInstance().callServer("TogetherBusinessIPCModule", "action_open_start", localBundle, this);
          break label238;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button bundle or mRspOpenIdentify is null");
      }
    }
    label238:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    WatchFloatingWindowController.a().b(this);
    QIPCClientHelper.getInstance().getClient().unRegisterModule(WatchTogetherClientIPCModule.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessForWebPlugin
 * JD-Core Version:    0.7.0.1
 */