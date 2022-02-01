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
  private long a = -1L;
  private int b = -1;
  private String c = null;
  private String d = null;
  private String e = null;
  private Handler f = new Handler(Looper.getMainLooper(), this);
  private boolean g = true;
  private TogetherBusinessServlet.RspOpenIdentify h;
  private TogetherBusinessServlet.RspOpenStart i;
  private View j;
  private Button k;
  private String l;
  private boolean m = false;
  
  public TogetherBusinessForWebPlugin()
  {
    this.mPluginNameSpace = "together_business";
    WatchFloatingWindowController.c().a(this);
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
  
  private Bundle a(String paramString1, String paramString2, String paramString3, Intent paramIntent)
  {
    int n = paramIntent.getIntExtra("uinType", -1);
    int i1 = n;
    if (n == -1) {
      i1 = paramIntent.getIntExtra("curtype", -1);
    }
    n = 1;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        paramIntent = null;
        n = -1;
      }
      else
      {
        paramIntent = paramIntent.getStringExtra("groupUin");
      }
    }
    else
    {
      paramIntent = paramIntent.getStringExtra("friend_uin");
      n = 2;
    }
    if ((!TextUtils.isEmpty(paramIntent)) && (n != -1)) {}
    try
    {
      l1 = Long.parseLong(paramIntent);
    }
    catch (NumberFormatException paramIntent)
    {
      long l1;
      label104:
      break label104;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessForWebPlugin", 2, "uin string to long error");
    }
    l1 = -1L;
    if (l1 == -1L) {
      return null;
    }
    a(l1, n, paramString1, paramString2, paramString3);
    paramIntent = new Bundle();
    paramIntent.putString("req_data", paramString1);
    paramIntent.putString("req_sign", paramString2);
    paramIntent.putInt("session_type", n);
    paramIntent.putLong("uin", l1);
    paramIntent.putString("appid", paramString3);
    return paramIntent;
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("curType or uin is error: uinType=");
      paramString1.append(i1);
      paramString1.append(" chatId=");
      paramString1.append(paramIntent);
      QLog.d("TogetherBusinessForWebPlugin", 2, paramString1.toString());
    }
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
  
  private void a(int paramInt, String paramString)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    QQToast.makeText(localBaseApplication, paramInt, paramString, 1).show(localBaseApplication.getResources().getDimensionPixelSize(2131299920));
  }
  
  private void a(long paramLong, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramLong;
    this.b = paramInt;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
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
        int n = paramString.optInt("aio_type");
        bool1 = paramString.optBoolean("author");
        double d1 = paramString.optDouble("video_width", 0.0D);
        double d2 = paramString.optDouble("video_height", 0.0D);
        String str1 = paramString.optString("callback", "");
        String str4 = paramString.optString("from", "watchroom");
        WatchTogetherFloatingData localWatchTogetherFloatingData = new WatchTogetherFloatingData();
        localWatchTogetherFloatingData.setSmallUrl(str3);
        localWatchTogetherFloatingData.setCurUin(str2);
        localWatchTogetherFloatingData.setCurType(n);
        localWatchTogetherFloatingData.setIsAdm(bool1);
        localWatchTogetherFloatingData.setFrom(str4);
        if ((this.mRuntime != null) && (this.mRuntime.f() != null))
        {
          paramString = this.mRuntime.f().getCurrentUrl();
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
        localStringBuilder.append(n);
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
          if ((this.m) && (!((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).checkPermission(BaseApplication.getContext())))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TogetherBusinessForWebPlugin", 2, "SHOW_FLOATING_WINDOW no permission");
            }
            callJs(str1, new String[] { a(true) });
            return;
          }
          n = WatchFloatingWindowController.c().a(BaseApplication.getContext(), localWatchTogetherFloatingData);
          if (n != 1) {
            break label599;
          }
          bool1 = true;
          this.m = bool1;
          if (n != 1) {
            callJs(str1, new String[] { "" });
          }
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder("SHOW_FLOATING_WINDOW resultCode=");
            paramString.append(n);
            QLog.d("TogetherBusinessForWebPlugin", 2, paramString.toString());
          }
        }
        else
        {
          WatchFloatingWindowController.c().a(localWatchTogetherFloatingData);
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
      if (this.mRuntime.d() == null) {
        return;
      }
      QQCustomDialog localQQCustomDialog = new QQCustomDialog(this.mRuntime.d(), 2131953338);
      localQQCustomDialog.setContentView(2131624611);
      if (!TextUtils.isEmpty(paramString1)) {
        localQQCustomDialog.setTitle(paramString1);
      } else {
        localQQCustomDialog.setTitle(null);
      }
      localQQCustomDialog.setMessage(paramString2);
      localQQCustomDialog.setCanceledOnTouchOutside(false);
      localQQCustomDialog.setCancelable(false);
      localQQCustomDialog.setNegativeButton(this.mRuntime.d().getString(2131887626), new TogetherBusinessForWebPlugin.3(this, localQQCustomDialog));
      localQQCustomDialog.setPositiveButton(this.mRuntime.d().getString(2131887629), paramOnClickListener);
      localQQCustomDialog.show();
    }
  }
  
  private boolean a()
  {
    if (!NetworkUtil.isNetSupport(null))
    {
      Message localMessage = this.f.obtainMessage(1);
      localMessage.obj = "当前网络不可用，请检查网络设置。";
      localMessage.arg1 = 1;
      this.f.sendMessage(localMessage);
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button network not well");
      }
      return true;
    }
    return false;
  }
  
  private boolean a(Bundle paramBundle)
  {
    if (TextUtils.isEmpty(this.h.confirmText))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button confirmText is empty");
      }
      return false;
    }
    Message localMessage = this.f.obtainMessage(2);
    localMessage.obj = new TogetherBusinessForWebPlugin.DialogElement(this, null, this.h.confirmText, new TogetherBusinessForWebPlugin.2(this, paramBundle));
    this.f.sendMessage(localMessage);
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
      Message localMessage = this.f.obtainMessage(1);
      localMessage.obj = paramResultInfo.errorMsg;
      localMessage.arg1 = 0;
      this.f.sendMessage(localMessage);
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
  
  private Intent b()
  {
    if ((this.mRuntime != null) && (this.mRuntime.d() != null)) {
      return this.mRuntime.d().getIntent();
    }
    return null;
  }
  
  private void b(String paramString)
  {
    Object localObject1 = this.j;
    if (localObject1 != null)
    {
      ((View)localObject1).setVisibility(0);
      localObject1 = this.k;
      if (localObject1 != null) {
        ((Button)localObject1).setText(paramString);
      }
      return;
    }
    localObject1 = (WebViewFragment)this.mRuntime.f();
    if (localObject1 != null)
    {
      localObject2 = (ViewGroup)LayoutInflater.from(this.mRuntime.d()).inflate(2131625996, null);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(12);
      if (((WebViewFragment)localObject1).getUIStyleHandler().x != null) {
        ((WebViewFragment)localObject1).getUIStyleHandler().x.addView((View)localObject2, localLayoutParams);
      }
    }
    else
    {
      localObject1 = ((ViewStub)this.mRuntime.d().findViewById(2131439747)).inflate();
      localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).height = -2;
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    this.j = ((ViewGroup)this.mRuntime.d().findViewById(2131440805));
    localObject1 = this.j;
    if (localObject1 == null) {
      return;
    }
    ((View)localObject1).setBackgroundColor(((View)localObject1).getResources().getColor(2131167964));
    localObject1 = this.j.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).height = AIOUtils.b(75.0F, this.j.getResources());
    this.j.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.j.setVisibility(0);
    ((ImageView)this.mRuntime.d().findViewById(2131432003)).setVisibility(8);
    localObject1 = (ViewGroup)this.mRuntime.d().findViewById(2131429651);
    int n = AIOUtils.b(16.0F, ((ViewGroup)localObject1).getResources());
    ((ViewGroup)localObject1).setPadding(n, 0, n, 0);
    Object localObject2 = new Button(this.mRuntime.d());
    ((Button)localObject2).setText(paramString);
    ((Button)localObject2).setGravity(17);
    ((Button)localObject2).setTextColor(this.mRuntime.d().getResources().getColor(2131168041));
    ((Button)localObject2).setBackground(this.mRuntime.d().getDrawable(2130839460));
    ((Button)localObject2).setTextSize(1, 17.0F);
    this.k = ((Button)localObject2);
    this.k.setOnClickListener(this);
    paramString = new RelativeLayout.LayoutParams(-1, AIOUtils.b(45.0F, this.j.getResources()));
    paramString.addRule(15);
    ((ViewGroup)localObject1).addView((View)localObject2, paramString);
  }
  
  private void b(String... paramVarArgs)
  {
    try
    {
      this.l = new JSONObject(paramVarArgs[0]).optString("callback", "");
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
  
  private Bundle c(String... paramVarArgs)
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
        Intent localIntent = b();
        if (localIntent == null)
        {
          if (!QLog.isColorLevel()) {
            break label176;
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
    label176:
    return null;
  }
  
  private JSONObject c(int paramInt)
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
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("closeOrQuitBusiness ");
      localStringBuilder.append("type=");
      localStringBuilder.append(paramInt);
      QLog.d("TogetherBusinessForWebPlugin", 2, localStringBuilder.toString());
    }
    dispatchJsEvent("close_business", c(paramInt), null);
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
    dispatchJsEvent("play_control", c(paramInt), null);
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
      WatchFloatingWindowController.c().b(2);
      return true;
    }
    if (paramLong == 8589934623L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessForWebPlugin", 2, "handleEvent type =init_webview_complete");
      }
      WatchFloatingWindowController.c().d();
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
          WatchFloatingWindowController.c().a(null);
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
        this.g = true;
        this.h = null;
        paramJsBridgeListener = c(paramVarArgs);
        b(paramVarArgs);
        if (paramJsBridgeListener != null)
        {
          this.g = a(paramVarArgs);
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
            paramJsBridgeListener.append(this.h);
            QLog.d("TogetherBusinessForWebPlugin", 2, paramJsBridgeListener.toString());
          }
          this.i = null;
          a(-1L, -1, null, null, null);
          paramString1 = c(paramVarArgs);
          if (paramString1 != null)
          {
            paramJsBridgeListener = this.h;
            if (paramJsBridgeListener != null)
            {
              paramString1.putInt("business_type", paramJsBridgeListener.businessType);
              if (this.h.businessType == 2)
              {
                if (this.b == 2) {
                  paramJsBridgeListener = "c2c_AIO";
                } else {
                  paramJsBridgeListener = "Grp_AIO";
                }
                paramString2 = new StringBuilder();
                paramString2.append(this.a);
                paramString2.append("");
                ReportController.b(null, "dc00899", paramJsBridgeListener, "", "video_tab", "clk_share_grp", 0, 0, paramString2.toString(), this.e, "", "");
              }
              if (a()) {
                return true;
              }
              if (a(this.h.resultInfo)) {
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
          this.f.sendEmptyMessage(4);
          return true;
        }
        if ("show_floating_window".equals(paramString3))
        {
          a(paramVarArgs[0]);
          return true;
        }
        int n;
        if ("close_floating_window".equals(paramString3)) {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString1.optString("uin");
            n = paramString1.optInt("aio_type");
            paramString1 = new WatchTogetherFloatingData();
            paramString1.setCurUin(paramJsBridgeListener);
            paramString1.setCurType(n);
            if (QLog.isColorLevel())
            {
              paramString1 = new StringBuilder("CLOSE_FLOATING_WINDOW ");
              paramString1.append("uin=");
              paramString1.append(paramJsBridgeListener);
              paramString1.append(" sessionType=");
              paramString1.append(n);
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
            n = paramJsBridgeListener.optInt("status");
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
              paramJsBridgeListener.append(n);
              QLog.d("TogetherBusinessForWebPlugin", 2, paramJsBridgeListener.toString());
            }
            WatchFloatingWindowController.c().a(d1, d2);
            WatchFloatingWindowController.c().b(n);
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
      a(paramMessage.a, paramMessage.b, paramMessage.c);
      return true;
    }
    if (paramMessage.what == 3)
    {
      b((String)paramMessage.obj);
      return true;
    }
    if (paramMessage.what == 4)
    {
      paramMessage = this.j;
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
        this.h = ((TogetherBusinessServlet.RspOpenIdentify)localObject);
        boolean bool = TextUtils.isEmpty(this.h.buttonText) ^ true;
        if (QLog.isColorLevel())
        {
          paramEIPCResult = new StringBuilder();
          paramEIPCResult.append("callback from CMD_OPEN_IDENTIFY isShowButton=");
          paramEIPCResult.append(bool);
          paramEIPCResult.append(" mDrawButtonByQQ=");
          paramEIPCResult.append(this.g);
          QLog.d("TogetherBusinessForWebPlugin", 2, paramEIPCResult.toString());
        }
        if ((bool) && (this.h.businessType == 2))
        {
          if (this.b == 2) {
            paramEIPCResult = "c2c_AIO";
          } else {
            paramEIPCResult = "Grp_AIO";
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.a);
          ((StringBuilder)localObject).append("");
          ReportController.b(null, "dc00899", paramEIPCResult, "", "video_tab", "exp_share_grp", 0, 0, ((StringBuilder)localObject).toString(), this.e, "", "");
        }
        paramEIPCResult = a(bool, this.h.buttonText);
        if (!TextUtils.isEmpty(this.l)) {
          callJs(this.l, new String[] { paramEIPCResult });
        }
        if ((bool) && (this.g))
        {
          paramEIPCResult = this.f.obtainMessage(3);
          paramEIPCResult.obj = this.h.buttonText;
          this.f.sendMessage(paramEIPCResult);
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
      this.i = ((TogetherBusinessServlet.RspOpenStart)paramEIPCResult);
      if (!a(this.i.resultInfo)) {}
    }
  }
  
  public void onClick(View paramView)
  {
    this.i = null;
    Object localObject = b();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessForWebPlugin", 2, "call parseParam intent is null");
      }
    }
    else
    {
      Bundle localBundle = a(this.c, this.d, this.e, (Intent)localObject);
      if (localBundle != null)
      {
        localObject = this.h;
        if (localObject != null)
        {
          localBundle.putInt("business_type", ((TogetherBusinessServlet.RspOpenIdentify)localObject).businessType);
          if (this.h.businessType == 2)
          {
            if (this.b == 2) {
              localObject = "c2c_AIO";
            } else {
              localObject = "Grp_AIO";
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.a);
            localStringBuilder.append("");
            ReportController.b(null, "dc00899", (String)localObject, "", "video_tab", "clk_share_grp", 0, 0, localStringBuilder.toString(), this.e, "", "");
          }
          if ((a()) || (a(this.h.resultInfo)) || (a(localBundle))) {
            break label239;
          }
          QIPCClientHelper.getInstance().callServer("TogetherBusinessIPCModule", "action_open_start", localBundle, this);
          break label239;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessForWebPlugin", 2, "call click_together_button bundle or mRspOpenIdentify is null");
      }
    }
    label239:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Handler localHandler = this.f;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    WatchFloatingWindowController.c().b(this);
    QIPCClientHelper.getInstance().getClient().unRegisterModule(WatchTogetherClientIPCModule.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessForWebPlugin
 * JD-Core Version:    0.7.0.1
 */