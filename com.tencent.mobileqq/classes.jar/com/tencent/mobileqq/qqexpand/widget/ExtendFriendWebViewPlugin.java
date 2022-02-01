package com.tencent.mobileqq.qqexpand.widget;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqexpand.utils.IExpandQuestionUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import eipc.EIPCClient;
import org.json.JSONException;
import org.json.JSONObject;

public class ExtendFriendWebViewPlugin
  extends WebViewPlugin
{
  public ExtendFriendWebViewPlugin()
  {
    this.mPluginNameSpace = "extendFriend";
  }
  
  private void a(String paramString)
  {
    try
    {
      Object localObject1 = new JSONObject(paramString);
      int i = ((JSONObject)localObject1).optInt("category");
      String str = ((JSONObject)localObject1).optString("name");
      Object localObject2 = ((JSONObject)localObject1).optString("schoolid");
      int j = ((JSONObject)localObject1).optInt("idx");
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("name", str);
      ((Bundle)localObject1).putInt("category", i);
      ((Bundle)localObject1).putString("schoolid", (String)localObject2);
      ((Bundle)localObject1).putInt("idx", j);
      if (QLog.isColorLevel())
      {
        str = this.mTAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onNotifyUpdateSchoolInfo result=");
        ((StringBuilder)localObject2).append(paramString);
        QLog.i(str, 2, ((StringBuilder)localObject2).toString());
      }
      QIPCClientHelper.getInstance().getClient().callServer("ExtendFriendQIPCModule", "notifyUpdateSchoolInfo", (Bundle)localObject1);
      RemoteHandleManager.getInstance().getSender().updateSchoolinfo((Bundle)localObject1, this.mRuntime.b().getCurrentAccountUin());
      return;
    }
    catch (JSONException paramString)
    {
      QLog.i(this.mTAG, 1, "onNotifyUpdateSchoolInfo exception", paramString);
    }
  }
  
  private void b(String paramString)
  {
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramString).optInt("certificateResult");
        paramString = new Bundle();
        if (i == 1)
        {
          bool = true;
          paramString.putBoolean("key_result", bool);
          if (QLog.isColorLevel())
          {
            String str = this.mTAG;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onNotifyCampusFriendCertificateResult result=");
            localStringBuilder.append(i);
            QLog.i(str, 2, localStringBuilder.toString());
          }
          QIPCClientHelper.getInstance().getClient().callServer("ExtendFriendQIPCModule", "notifyCampusFriendCertificateResult", paramString);
          return;
        }
      }
      catch (JSONException paramString)
      {
        QLog.i(this.mTAG, 1, "onNotifyCampusFriendCertificateResult exception", paramString);
        return;
      }
      boolean bool = false;
    }
  }
  
  private void c(String paramString)
  {
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramString).optInt("uploadResult");
        paramString = new Bundle();
        if (i == 1)
        {
          bool = true;
          paramString.putBoolean("key_result", bool);
          if (QLog.isColorLevel())
          {
            String str = this.mTAG;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onNotifyUploadSutudentIDResult result=");
            localStringBuilder.append(i);
            QLog.i(str, 2, localStringBuilder.toString());
          }
          QIPCClientHelper.getInstance().getClient().callServer("ExtendFriendQIPCModule", "notifyUploadSutudentIDResult", paramString);
          return;
        }
      }
      catch (JSONException paramString)
      {
        QLog.i(this.mTAG, 1, "onNotifyUploadSutudentIDResult exception", paramString);
        return;
      }
      boolean bool = false;
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = this.mTAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleJsRequest url is: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" method: ");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(" pkgName: ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" args: ");
      localStringBuilder.append(paramVarArgs);
      QLog.i(paramJsBridgeListener, 2, localStringBuilder.toString());
    }
    if (!"extendFriend".equals(paramString2)) {
      return false;
    }
    if ("answerResult".equals(paramString3))
    {
      paramJsBridgeListener = this.mRuntime.b().getCurrentAccountUin();
      if (!TextUtils.isEmpty(paramJsBridgeListener)) {
        ((IExpandQuestionUtils)QRoute.api(IExpandQuestionUtils.class)).setAnswerQuestionFlag(paramJsBridgeListener, false);
      }
      return true;
    }
    if ("notifyCampusFriendCertificateResult".equals(paramString3))
    {
      if (paramVarArgs.length >= 1)
      {
        b(paramVarArgs[0]);
        RemoteHandleManager.getInstance().getSender().updateSchoolCertificate(paramVarArgs[0], "notifyCampusFriendCertificateResult", this.mRuntime.b().getCurrentAccountUin());
        return true;
      }
      QLog.i(this.mTAG, 1, "NOTIFY_CAMPUS_FRIEND_CERTIFICATE_RESULT arg error");
      return true;
    }
    if ("notifyUploadSutudentIDResult".equals(paramString3))
    {
      if (paramVarArgs.length >= 1)
      {
        c(paramVarArgs[0]);
        RemoteHandleManager.getInstance().getSender().updateSchoolCertificate(paramVarArgs[0], "notifyUploadSutudentIDResult", this.mRuntime.b().getCurrentAccountUin());
        return true;
      }
      QLog.i(this.mTAG, 1, "ACTION_NOTIFY_STUDENTID_UPLOAD_RESULT arg error");
      return true;
    }
    if ("notifyUpdateSchoolInfo".equals(paramString3))
    {
      if (paramVarArgs.length >= 1)
      {
        a(paramVarArgs[0]);
        return true;
      }
      QLog.i(this.mTAG, 1, "ACTION_NOTIFY_STUDENTID_UPLOAD_RESULT arg error");
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.ExtendFriendWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */