package com.tencent.mobileqq.relationx.friendclue;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import org.json.JSONObject;

public class FriendClueApiPlugin
  extends WebViewPlugin
{
  private Context jdField_a_of_type_AndroidContentContext;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  
  public FriendClueApiPlugin()
  {
    this.mPluginNameSpace = "recallFriend";
  }
  
  private Context a()
  {
    Activity localActivity2 = this.mRuntime.a();
    Activity localActivity1 = localActivity2;
    if (localActivity2 != null)
    {
      localActivity1 = localActivity2;
      if ((localActivity2 instanceof BasePluginActivity)) {
        localActivity1 = ((BasePluginActivity)localActivity2).getOutActivity();
      }
    }
    return localActivity1;
  }
  
  void a(String paramString)
  {
    paramString = new AllInOne(paramString, 1);
    startActivityForResult(new Intent(this.jdField_a_of_type_AndroidContentContext, MoveToGroupActivity.class).putExtra("friendUin", paramString.uin), (byte)0);
  }
  
  void b(String paramString)
  {
    EIPCClient localEIPCClient = QIPCClientHelper.getInstance().getClient();
    Bundle localBundle = new Bundle();
    localBundle.putString("cur_friend_uin", paramString);
    localEIPCClient.callServer("CommonModule", "jumpToRemarkEdit", localBundle);
  }
  
  void c(String paramString)
  {
    EIPCClient localEIPCClient = QIPCClientHelper.getInstance().getClient();
    Bundle localBundle = new Bundle();
    localBundle.putString("cur_friend_uin", paramString);
    localEIPCClient.callServer("CommonModule", "jumpToCommonGroup", localBundle);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("recallFriend".equals(paramString2)) {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClueApiPlugin", 2, String.format("handleJsRequest method=%s args=%s", new Object[] { paramString3, paramVarArgs[0] }));
        }
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        paramString1 = paramJsBridgeListener.optString("opType");
        boolean bool = "move_to_newgroup".equals(paramString1);
        if (bool)
        {
          a(paramJsBridgeListener.optString("uin"));
          return false;
        }
        if ("remark_edit".equals(paramString1))
        {
          b(paramJsBridgeListener.optString("uin"));
          return false;
        }
        if ("common_group".equals(paramString1))
        {
          c(paramJsBridgeListener.optString("uin"));
          return false;
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        QLog.e("ClueApiPlugin", 1, "handleJsRequest fail.", paramJsBridgeListener);
      }
    }
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidContentContext = a();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.mRuntime.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.friendclue.FriendClueApiPlugin
 * JD-Core Version:    0.7.0.1
 */