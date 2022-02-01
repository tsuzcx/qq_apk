package com.tencent.mobileqq.teamwork.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Window;
import com.qq.wx.voice.recognizer.VoiceRecognizer;
import com.qq.wx.voice.recognizer.VoiceRecognizerListener;
import com.qq.wx.voice.recognizer.VoiceRecognizerResult;
import com.qq.wx.voice.recognizer.VoiceRecordState;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.IVoiceInputHelper;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppActivity;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public final class VoiceInputHelperImpl
  implements VoiceRecognizerListener, IVoiceInputHelper
{
  private static final String TAG = "VoiceInputHelperImpl";
  private boolean initialized = false;
  private String mCallback;
  private final Context mContext;
  private Handler mHandler;
  private final WebViewPlugin mHostPlugin;
  private final AtomicLong mVoiceId;
  
  public VoiceInputHelperImpl(WebViewPlugin paramWebViewPlugin)
  {
    this.mHostPlugin = paramWebViewPlugin;
    if (paramWebViewPlugin != null)
    {
      paramWebViewPlugin = paramWebViewPlugin.mRuntime;
      if (paramWebViewPlugin != null)
      {
        paramWebViewPlugin = paramWebViewPlugin.d();
        if (paramWebViewPlugin != null)
        {
          paramWebViewPlugin = paramWebViewPlugin.getApplicationContext();
          break label46;
        }
      }
    }
    paramWebViewPlugin = null;
    label46:
    this.mContext = paramWebViewPlugin;
    if (paramWebViewPlugin == null) {
      QLog.e("VoiceInputHelperImpl", 1, "context is invalid.");
    }
    this.mVoiceId = new AtomicLong(0L);
  }
  
  private boolean checkSelfPermission()
  {
    AppActivity localAppActivity = getAppActivity();
    return (Build.VERSION.SDK_INT < 23) || (localAppActivity == null) || (localAppActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0);
  }
  
  private Activity getActivity()
  {
    Object localObject = this.mHostPlugin;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((WebViewPlugin)localObject).mRuntime;
    }
    if (localObject == null) {
      return null;
    }
    return ((WebViewPlugin.PluginRuntime)localObject).d();
  }
  
  private AppActivity getAppActivity()
  {
    Activity localActivity = getActivity();
    if ((localActivity instanceof AppActivity)) {
      return (AppActivity)localActivity;
    }
    return null;
  }
  
  private void keepScreenOn(boolean paramBoolean)
  {
    Object localObject = getActivity();
    if (localObject != null)
    {
      if (((Activity)localObject).isFinishing()) {
        return;
      }
      localObject = ((Activity)localObject).getWindow();
      if (localObject != null)
      {
        if (paramBoolean)
        {
          ((Window)localObject).addFlags(128);
          return;
        }
        ((Window)localObject).clearFlags(128);
      }
    }
  }
  
  private void onPermissionResult(boolean paramBoolean, int paramInt)
  {
    String str2 = this.mCallback;
    if (!TextUtils.isEmpty(str2))
    {
      String str1;
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("granted", paramBoolean);
        ((JSONObject)localObject).put("errorCode", paramInt);
        ((JSONObject)localObject).put("cmd", "onPermissionResult");
        localObject = ((JSONObject)localObject).toString();
      }
      catch (JSONException localJSONException)
      {
        QLog.e("VoiceInputHelperImpl", 1, "onPermissionResult error", localJSONException);
        str1 = "";
      }
      if ((this.mHostPlugin != null) && (!TextUtils.isEmpty(str1))) {
        this.mHostPlugin.callJs(str2, new String[] { str1 });
      }
    }
  }
  
  private static void preInitInner(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceInputHelperImpl", 2, "voice input helper preInit invalid app");
      }
      return;
    }
    if (((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).isQQAppInterface(paramAppInterface))
    {
      paramAppInterface = paramAppInterface.getApplication().getApplicationContext();
      ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).soLibraryCheckerExecute(paramAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("VoiceInputHelperImpl", 2, "voice input helper preInit doing");
      }
    }
    else if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("voice input helper preInit app isn't QQAppInterface, app=");
      localStringBuilder.append(paramAppInterface);
      QLog.d("VoiceInputHelperImpl", 2, localStringBuilder.toString());
    }
  }
  
  private void removePermissionUncertainMonitor()
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null) {
      localHandler.removeMessages(1);
    }
  }
  
  private void requestPermission(boolean paramBoolean)
  {
    AppActivity localAppActivity = getAppActivity();
    if (localAppActivity == null) {
      return;
    }
    localAppActivity.requestPermissions(new VoiceInputHelperImpl.2(this, paramBoolean), 1818, new String[] { "android.permission.RECORD_AUDIO" });
    if (this.mHandler == null) {
      this.mHandler = new VoiceInputHelperImpl.3(this, Looper.getMainLooper());
    }
    this.mHandler.sendEmptyMessageDelayed(1, 10000L);
  }
  
  private boolean setupInner()
  {
    if (!((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).soLibraryCheckerSoLibExists(this.mContext))
    {
      QLog.e("VoiceInputHelperImpl", 1, "setup error, so lib not exists");
      return false;
    }
    int i = VoiceRecognizer.shareInstance().init(this.mContext, "wxcd8072f67d2d78d4", ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).soLibraryCheckerGetSoPath(this.mContext));
    if (i < 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setup failed, ret=");
      localStringBuilder.append(i);
      QLog.e("VoiceInputHelperImpl", 1, localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  private boolean startInner()
  {
    int i = VoiceRecognizer.shareInstance().start();
    if (i < 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start failed, ret=");
      localStringBuilder.append(i);
      QLog.e("VoiceInputHelperImpl", 1, localStringBuilder.toString());
      return false;
    }
    keepScreenOn(true);
    return true;
  }
  
  public boolean checkPermission(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("VoiceInputHelperImpl", 1, "checkPermission failed, callback is invalid.");
      return false;
    }
    if (this.mHostPlugin == null) {
      return false;
    }
    this.mCallback = paramString;
    if (checkSelfPermission())
    {
      onPermissionResult(true, 0);
      return true;
    }
    requestPermission(false);
    return false;
  }
  
  public void destroy()
  {
    this.mCallback = null;
    removePermissionUncertainMonitor();
    this.mHandler = null;
    VoiceRecognizer.shareInstance().destroy();
    keepScreenOn(false);
  }
  
  public boolean isInitialized()
  {
    return this.initialized;
  }
  
  public void onGetError(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetError:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("VoiceInputHelperImpl", 2, ((StringBuilder)localObject).toString());
    }
    String str2 = this.mCallback;
    if (!TextUtils.isEmpty(str2))
    {
      String str1;
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("errorCode", paramInt);
        ((JSONObject)localObject).put("cmd", "error");
        localObject = ((JSONObject)localObject).toString();
      }
      catch (JSONException localJSONException)
      {
        QLog.e("VoiceInputHelperImpl", 1, "onGetError error", localJSONException);
        str1 = "";
      }
      if ((this.mHostPlugin != null) && (!TextUtils.isEmpty(str1))) {
        this.mHostPlugin.callJs(str2, new String[] { str1 });
      }
    }
  }
  
  public void onGetResult(VoiceRecognizerResult paramVoiceRecognizerResult)
  {
    if (paramVoiceRecognizerResult == null) {
      return;
    }
    long l;
    if (paramVoiceRecognizerResult.isEnd) {
      l = this.mVoiceId.getAndIncrement();
    } else {
      l = this.mVoiceId.get();
    }
    String str = this.mCallback;
    if (!TextUtils.isEmpty(str))
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("text", paramVoiceRecognizerResult.text);
        localJSONObject.put("voice_id", l);
        localJSONObject.put("startOffset", paramVoiceRecognizerResult.startTime);
        localJSONObject.put("endOffset", paramVoiceRecognizerResult.stopTime);
        localJSONObject.put("cmd", "result");
        paramVoiceRecognizerResult = localJSONObject.toString();
      }
      catch (JSONException paramVoiceRecognizerResult)
      {
        QLog.e("VoiceInputHelperImpl", 1, "onGetResult error", paramVoiceRecognizerResult);
        paramVoiceRecognizerResult = "";
      }
      if ((this.mHostPlugin != null) && (!TextUtils.isEmpty(paramVoiceRecognizerResult))) {
        this.mHostPlugin.callJs(str, new String[] { paramVoiceRecognizerResult });
      }
    }
  }
  
  public void onGetVoicePackage(byte[] paramArrayOfByte, String paramString) {}
  
  public void onGetVoiceRecordState(VoiceRecordState paramVoiceRecordState)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetVoiceRecordState:");
      ((StringBuilder)localObject).append(paramVoiceRecordState);
      QLog.d("VoiceInputHelperImpl", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramVoiceRecordState == VoiceRecordState.Canceling) || (paramVoiceRecordState == VoiceRecordState.Canceled) || (paramVoiceRecordState == VoiceRecordState.Complete))
    {
      localObject = this.mCallback;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        try
        {
          paramVoiceRecordState = new JSONObject();
          paramVoiceRecordState.put("cmd", "canceled");
          paramVoiceRecordState = paramVoiceRecordState.toString();
        }
        catch (JSONException paramVoiceRecordState)
        {
          QLog.e("VoiceInputHelperImpl", 1, "onGetVoiceRecordState error", paramVoiceRecordState);
          paramVoiceRecordState = "";
        }
        if ((this.mHostPlugin != null) && (!TextUtils.isEmpty(paramVoiceRecordState))) {
          this.mHostPlugin.callJs((String)localObject, new String[] { paramVoiceRecordState });
        }
      }
    }
  }
  
  public void onVolumeChanged(int paramInt)
  {
    String str2 = this.mCallback;
    if (!TextUtils.isEmpty(str2))
    {
      String str1;
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("volume", paramInt);
        ((JSONObject)localObject).put("cmd", "volume");
        localObject = ((JSONObject)localObject).toString();
      }
      catch (JSONException localJSONException)
      {
        QLog.e("VoiceInputHelperImpl", 1, "onVolumeChanged error", localJSONException);
        str1 = "";
      }
      if ((this.mHostPlugin != null) && (!TextUtils.isEmpty(str1))) {
        this.mHostPlugin.callJs(str2, new String[] { str1 });
      }
    }
  }
  
  public void preInit(AppInterface paramAppInterface)
  {
    preInitInner(paramAppInterface);
  }
  
  public boolean setup()
  {
    if (this.mContext == null) {
      return false;
    }
    VoiceRecognizer.shareInstance().setListener(this);
    VoiceRecognizer.shareInstance().setContRes(true);
    VoiceRecognizer.shareInstance().setContReco(true);
    VoiceRecognizer.shareInstance().setResultType(1);
    VoiceRecognizer.shareInstance().setSilentTime(1000);
    ThreadManager.excute(new VoiceInputHelperImpl.1(this), 64, null, true);
    this.initialized = true;
    return true;
  }
  
  public boolean start(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("VoiceInputHelperImpl", 1, "start failed, callback is invalid.");
      return false;
    }
    if (this.mHostPlugin == null) {
      return false;
    }
    this.mCallback = paramString;
    if (checkSelfPermission()) {
      return startInner();
    }
    requestPermission(true);
    return false;
  }
  
  public boolean stop()
  {
    int i = VoiceRecognizer.shareInstance().stop();
    if (i < 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stop failed, ret=");
      localStringBuilder.append(i);
      QLog.e("VoiceInputHelperImpl", 1, localStringBuilder.toString());
      return false;
    }
    keepScreenOn(false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.VoiceInputHelperImpl
 * JD-Core Version:    0.7.0.1
 */