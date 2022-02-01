package com.tencent.qqmini.proxyimpl;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.PageActionBridge;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.ICapsuleButton;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.shell.ICommonManager;
import eipc.EIPCClient;
import eipc.EIPCResult;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniSDKClientQIPCModule
  extends QIPCModule
{
  private MiniSDKClientQIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static MiniSDKClientQIPCModule a()
  {
    return MiniSDKClientQIPCModule.MiniSDKClientClass.a();
  }
  
  public static void a()
  {
    MiniSDKClientQIPCModule localMiniSDKClientQIPCModule = a();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("register ");
      localStringBuilder.append(localMiniSDKClientQIPCModule);
      QMLog.i("MiniSDKClientQIPCModule", localStringBuilder.toString());
      QIPCClientHelper.getInstance().register(localMiniSDKClientQIPCModule);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MiniSDKClientQIPCModule", 1, "register ipc module error.", localException);
    }
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("param_proc_badge_count");
      if (QMLog.isDebugEnabled())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("count is ");
        paramBundle.append(i);
        QMLog.d("MiniSDKClientQIPCModule", paramBundle.toString());
      }
      paramBundle = AppLoaderFactory.g().getCommonManager().getCurrentRuntime();
      if ((paramBundle != null) && (paramBundle.getPage() != null))
      {
        paramBundle = paramBundle.getPage().getCapsuleButton();
        if (paramBundle == null)
        {
          QMLog.w("MiniSDKClientQIPCModule", "capsule button is null");
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(BaseApplicationImpl.getApplication().getQQProcessName());
        localStringBuilder.append(" msg count = ");
        localStringBuilder.append(i);
        QMLog.i("MiniSDKClientQIPCModule", localStringBuilder.toString());
        paramBundle.setUnReadCount(i, true);
        return;
      }
      QMLog.w("MiniSDKClientQIPCModule", "runtime or page is null");
    }
  }
  
  private void a(BaseRuntime paramBaseRuntime, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new MiniSDKClientQIPCModule.5(this, paramBaseRuntime, paramString));
  }
  
  private void a(BaseRuntime paramBaseRuntime, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    ThreadManager.getSubThreadHandler().post(new MiniSDKClientQIPCModule.4(this, paramBaseRuntime, paramString1, paramString2, paramInt, paramString3));
  }
  
  private void a(BaseRuntime paramBaseRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, RequestEvent paramRequestEvent)
  {
    a(paramString4, new MiniSDKClientQIPCModule.1(this, paramBaseRuntime, paramString1, paramString2, paramString3, paramInt, paramRequestEvent));
  }
  
  private void a(IJsService paramIJsService, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, int paramInt4)
  {
    MiniAppCmdUtil.getInstance().createUpdatableMsg(paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, new MiniSDKClientQIPCModule.6(this, paramString1, paramIJsService, paramInt4));
  }
  
  private void a(String paramString, CmdCallback paramCmdCallback)
  {
    if (TextUtils.isEmpty(paramString))
    {
      b(paramString, paramCmdCallback);
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if ((localJSONObject.has("metaData")) && (localJSONObject.optJSONObject("metaData").has("detail")) && (localJSONObject.optJSONObject("metaData").optJSONObject("detail").has("preview")))
      {
        String str = localJSONObject.optJSONObject("metaData").optJSONObject("detail").optString("preview");
        if (!URLUtil.isNetworkUrl(str))
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("preview", str);
          QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_upload_image", localBundle, new MiniSDKClientQIPCModule.2(this, localJSONObject, paramCmdCallback));
          return;
        }
        b(paramString, paramCmdCallback);
        return;
      }
      b(paramString, paramCmdCallback);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniSDKClientQIPCModule", 1, "getReplaceJsonString error,", localThrowable);
      b(paramString, paramCmdCallback);
    }
  }
  
  private void a(JSONObject paramJSONObject1, BaseRuntime paramBaseRuntime, int paramInt, String paramString, boolean paramBoolean, JSONObject paramJSONObject2)
  {
    try
    {
      paramJSONObject1.put("errMsg", paramString);
      paramJSONObject1.put("success", paramBoolean);
    }
    catch (JSONException paramString)
    {
      QLog.e("MiniSDKClientQIPCModule", 1, "callOnShareMessageToFriend error,", paramString);
    }
    if (paramBaseRuntime.getJsService() != null)
    {
      paramString = paramBaseRuntime.getJsService();
      paramJSONObject1 = paramJSONObject1.toString();
      if (paramBaseRuntime.isMiniGame()) {
        paramInt = -1;
      } else {
        paramInt = ActionBridge.PageActionBridge.getPageId(paramBaseRuntime);
      }
      paramString.evaluateSubscribeJS("onShareMessageToFriend", paramJSONObject1, paramInt);
      return;
    }
    QLog.e("MiniSDKClientQIPCModule", 1, "runtime.getJsService == null");
  }
  
  private void a(boolean paramBoolean)
  {
    BaseRuntime localBaseRuntime = AppLoaderFactory.g().getCommonManager().getCurrentRuntime();
    if (localBaseRuntime == null)
    {
      QLog.e("MiniSDKClientQIPCModule", 1, "runtime == null");
      return;
    }
    ShareState localShareState = localBaseRuntime.getShareState();
    if (localShareState == null)
    {
      QLog.e("MiniSDKClientQIPCModule", 1, "shareState == null");
      return;
    }
    Object localObject2 = null;
    StringBuilder localStringBuilder;
    try
    {
      IJsService localIJsService;
      if (localShareState.requestEvent != null) {
        localIJsService = localShareState.requestEvent.jsService;
      } else {
        localIJsService = localBaseRuntime.getJsService();
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniSDKClientQIPCModule", 1, "runtime.getJsService exception", localThrowable);
      localStringBuilder = null;
    }
    if (localStringBuilder == null)
    {
      QLog.e("MiniSDKClientQIPCModule", 1, "jsService == null");
      return;
    }
    if ("raffleShare".equals(localShareState.shareEvent))
    {
      if (paramBoolean)
      {
        localObject1 = new JSONObject();
        try
        {
          ((JSONObject)localObject1).put("state", "share");
        }
        catch (JSONException localJSONException1)
        {
          QLog.e("MiniSDKClientQIPCModule", 1, "onShareCallback exception", localJSONException1);
        }
        localStringBuilder.evaluateSubscribeJS("onMinigameRaffleStateChange", ((JSONObject)localObject1).toString(), 0);
      }
      return;
    }
    Object localObject1 = "";
    if (paramBoolean)
    {
      if ("requestFriendPayment".equals(localShareState.shareEvent))
      {
        localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("resultCode", 0);
        }
        catch (JSONException localJSONException2)
        {
          QLog.e("MiniSDKClientQIPCModule", 1, "API_PAY_BY_FRIEND put resultCode error", localJSONException2);
        }
      }
      localJSONObject = ApiUtil.wrapCallbackOk(localShareState.shareEvent, localJSONObject);
      if (localJSONObject != null) {
        localObject1 = localJSONObject.toString();
      }
      localStringBuilder.evaluateCallbackJs(localShareState.shareCallbackId, (String)localObject1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("callback: ");
      localStringBuilder.append((String)localObject1);
      QLog.i("MiniSDKClientQIPCModule", 1, localStringBuilder.toString());
      a(localBaseRuntime, "share_success");
      return;
    }
    JSONObject localJSONObject = ApiUtil.wrapCallbackFail(localShareState.shareEvent, null);
    if (localJSONObject != null) {
      localObject1 = localJSONObject.toString();
    }
    localStringBuilder.evaluateCallbackJs(localShareState.shareCallbackId, (String)localObject1);
    a(localBaseRuntime, "share_fail");
  }
  
  public static void b()
  {
    QMLog.i("MiniSDKClientQIPCModule", "unregister");
    QIPCClientHelper.getInstance().getClient().unRegisterModule(a());
  }
  
  private void b(Bundle paramBundle)
  {
    Object localObject2 = AppLoaderFactory.g().getCommonManager().getCurrentRuntime();
    if (localObject2 == null)
    {
      QLog.e("MiniSDKClientQIPCModule", 1, "runtime == null");
      return;
    }
    Object localObject4 = ((BaseRuntime)localObject2).getShareState();
    if (localObject4 == null)
    {
      QLog.e("MiniSDKClientQIPCModule", 1, "onShareUpdatableMsgCallback shareState == null");
      return;
    }
    Object localObject1 = null;
    try
    {
      if (((ShareState)localObject4).requestEvent != null)
      {
        localObject2 = ((ShareState)localObject4).requestEvent.jsService;
        localObject1 = localObject2;
      }
      else
      {
        localObject2 = ((BaseRuntime)localObject2).getJsService();
        localObject1 = localObject2;
      }
    }
    catch (Throwable localThrowable1)
    {
      QLog.e("MiniSDKClientQIPCModule", 1, "runtime.getJsService exception", localThrowable1);
    }
    if (localObject1 == null)
    {
      QLog.e("MiniSDKClientQIPCModule", 1, "jsService == null");
      return;
    }
    boolean bool = paramBundle.getBoolean("miniAppShareIsComplete", false);
    Object localObject3 = paramBundle.getString("miniAppShareEvent");
    localObject4 = paramBundle.getString("miniAppShareAppid");
    String str = paramBundle.getString("miniAppShareTemplateId");
    int j = paramBundle.getInt("miniAppShareCallbackId");
    int k = paramBundle.getInt("miniAppShareUpdatableMsgFrom");
    int m = paramBundle.getInt("miniAppShareSubScene", -1);
    if (bool)
    {
      int i = paramBundle.getInt("uintype");
      if ((i != 1) && (i == 0)) {
        i = 1;
      } else {
        i = 0;
      }
      paramBundle = paramBundle.getString("uin");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder("doCreateUpdatableMsgCallback");
        localStringBuilder.append(", appid:");
        localStringBuilder.append((String)localObject4);
        localStringBuilder.append(", templateId:");
        localStringBuilder.append(str);
        localStringBuilder.append(", from:");
        localStringBuilder.append(k);
        localStringBuilder.append(", scene:");
        localStringBuilder.append(i);
        localStringBuilder.append(", uin:");
        localStringBuilder.append(paramBundle);
        localStringBuilder.append(", subScene:");
        localStringBuilder.append(m);
        QLog.i("MiniSDKClientQIPCModule", 1, localStringBuilder.toString());
      }
      a(localObject1, (String)localObject3, (String)localObject4, str, k, i, m, paramBundle, j);
      return;
    }
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("retCode", 1);
      localObject3 = ApiUtil.wrapCallbackFail((String)localObject3, paramBundle, "用户取消");
      paramBundle = (Bundle)localObject3;
    }
    catch (Throwable localThrowable2)
    {
      localThrowable2.printStackTrace();
    }
    localObject1.evaluateCallbackJs(j, paramBundle.toString());
  }
  
  private void b(BaseRuntime paramBaseRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, RequestEvent paramRequestEvent)
  {
    MiniAppCmdUtil.getInstance().sendArkMsg(null, paramString3, paramString2, paramString4, paramRequestEvent.event, new MiniSDKClientQIPCModule.3(this, paramRequestEvent, paramBaseRuntime, paramString1, paramInt));
  }
  
  private void b(String paramString, CmdCallback paramCmdCallback)
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("shareJson", paramString);
      paramCmdCallback.onCmdResult(true, localBundle);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void b(boolean paramBoolean)
  {
    BaseRuntime localBaseRuntime = AppLoaderFactory.g().getCommonManager().getCurrentRuntime();
    if (localBaseRuntime == null)
    {
      QLog.e("MiniSDKClientQIPCModule", 1, "runtime == null");
      return;
    }
    Object localObject2 = localBaseRuntime.getShareState();
    if (localObject2 == null)
    {
      QLog.e("MiniSDKClientQIPCModule", 1, "shareState == null");
      return;
    }
    Object localObject1 = ((ShareState)localObject2).shareEvent;
    Object localObject3 = ((ShareState)localObject2).shareOpenid;
    String str1 = ((ShareState)localObject2).shareAppid;
    String str2 = ((ShareState)localObject2).shareJson;
    int i = ((ShareState)localObject2).shareCallbackId;
    localObject2 = ((ShareState)localObject2).requestEvent;
    if (paramBoolean)
    {
      a(localBaseRuntime, (String)localObject1, (String)localObject3, str1, str2, i, (RequestEvent)localObject2);
      return;
    }
    ((RequestEvent)localObject2).fail();
    localObject3 = new JSONObject();
    a((JSONObject)localObject3, localBaseRuntime, i, "cancel", false, ApiUtil.wrapCallbackFail((String)localObject1, (JSONObject)localObject3));
    a(localBaseRuntime, "shareMessageToFriend_fail");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("share_");
    ((StringBuilder)localObject1).append(((RequestEvent)localObject2).event);
    a(localBaseRuntime, ((StringBuilder)localObject1).toString(), "fail", 3, "cancel");
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCall main server action=");
      localStringBuilder.append(paramString);
      QLog.d("MiniSDKClientQIPCModule", 2, localStringBuilder.toString());
    }
    if ("action_sync_unreadcount".equals(paramString)) {
      a(paramBundle);
    } else if ("actionMiniShareSucCallback".equals(paramString)) {
      a(true);
    } else if ("actionMiniShareFailCallback".equals(paramString)) {
      a(false);
    } else if ("actionMiniDirectShareSucCallback".equals(paramString)) {
      b(true);
    } else if ("actionMiniDirectShareFailCallback".equals(paramString)) {
      b(false);
    } else if ((!"actionMiniReportEvent".equals(paramString)) && ("actionMiniCreateUpdatableMsgCallback".equals(paramString))) {
      b(paramBundle);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule
 * JD-Core Version:    0.7.0.1
 */