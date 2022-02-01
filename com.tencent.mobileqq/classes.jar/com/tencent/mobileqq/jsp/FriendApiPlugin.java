package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.friends.FriendConstants;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.frdsysmsg.FrdSysMsg.FriendSysMsg;
import tencent.im.s2c.frdsysmsg.FrdSysMsg.SchoolInfo;

public class FriendApiPlugin
  extends WebViewPlugin
{
  public FriendApiPlugin()
  {
    this.mPluginNameSpace = "friendApi";
  }
  
  private int a()
  {
    Activity localActivity = this.mRuntime.a();
    if ((localActivity != null) && (FriendConstants.a(localActivity.getIntent().getStringExtra("url")))) {
      return 127;
    }
    return 999;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = "friendApi".equals(paramString2);
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    int i;
    if ("openProfile".equals(paramString3))
    {
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        if (QLog.isColorLevel())
        {
          paramJsBridgeListener = new StringBuilder();
          paramJsBridgeListener.append("open profile ");
          paramJsBridgeListener.append(paramVarArgs[0]);
          QLog.w("FriendApiPlugin", 2, paramJsBridgeListener.toString());
        }
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = new AllInOne(paramJsBridgeListener.optString("uin"), paramJsBridgeListener.optInt("from"));
          paramJsBridgeListener.profileEntryType = a();
          ProfileUtils.openProfileCard(this.mRuntime.a(), paramJsBridgeListener);
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          if (!QLog.isColorLevel()) {
            break label1042;
          }
        }
        paramString1 = new StringBuilder();
        paramString1.append("open profile error:");
        paramString1.append(paramJsBridgeListener.toString());
        QLog.w("FriendApiPlugin", 2, paramString1.toString());
        return true;
      }
    }
    else
    {
      bool2 = "addFriend".equals(paramString3);
      paramJsBridgeListener = null;
      paramString1 = null;
      if (bool2)
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0))
        {
          if (QLog.isColorLevel())
          {
            paramJsBridgeListener = new StringBuilder();
            paramJsBridgeListener.append("add friend ");
            paramJsBridgeListener.append(paramVarArgs[0]);
            QLog.w("FriendApiPlugin", 2, paramJsBridgeListener.toString());
          }
          try
          {
            paramString3 = new JSONObject(paramVarArgs[0]);
            paramString2 = paramString3.optString("uin");
            i = paramString3.optInt("sourceId", 0);
            int j = paramString3.optInt("subSourceId", 0);
            paramJsBridgeListener = paramString1;
            if (paramString3.has("schoolInfo"))
            {
              paramString3 = paramString3.optJSONObject("schoolInfo");
              paramJsBridgeListener = paramString1;
              if (paramString3 != null)
              {
                paramJsBridgeListener = paramString3.optString("schoolId");
                paramString3 = paramString3.optString("schoolName");
                paramString1 = new FrdSysMsg.SchoolInfo();
                paramString1.str_school_id.set(paramJsBridgeListener);
                paramString1.str_school_name.set(paramString3);
                paramJsBridgeListener = new FrdSysMsg.FriendSysMsg();
                paramJsBridgeListener.msg_school_info.set(paramString1);
                paramJsBridgeListener = paramJsBridgeListener.toByteArray();
              }
            }
            paramString3 = this.mRuntime.a();
            paramVarArgs = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(paramString3, 1, paramString2, "", i, j, null, null, null, null, null);
            if (paramJsBridgeListener != null)
            {
              paramString2 = paramVarArgs.getBundleExtra("flc_extra_param");
              paramString1 = paramString2;
              if (paramString2 == null)
              {
                paramString1 = new Bundle();
                paramVarArgs.putExtra("flc_extra_param", paramString1);
              }
              paramString1.putByteArray("friend_src_desc", paramJsBridgeListener);
            }
            ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(paramString3, paramVarArgs);
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            if (!QLog.isColorLevel()) {
              break label1042;
            }
          }
          paramString1 = new StringBuilder();
          paramString1.append("add friend error:");
          paramString1.append(paramJsBridgeListener.toString());
          QLog.w("FriendApiPlugin", 2, paramString1.toString());
          return true;
        }
      }
      else if ("isFriend".equals(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
            paramString1 = paramJsBridgeListener.optString("frd_uin");
            paramString2 = new Bundle();
            paramString2.putString("KEY_UIN", paramString1);
            paramString1 = QIPCClientHelper.getInstance().getClient().callServer("FriendQIPCModule", "ACTION_IS_FRIEND", paramString2);
            if (!paramString1.isSuccess()) {
              break label1044;
            }
            bool1 = paramString1.data.getBoolean("KEY_IS_FRIEND", false);
            paramString1 = new JSONObject();
            paramString1.put("result", bool1);
            callJs(paramJsBridgeListener.optString("callback"), new String[] { paramString1.toString() });
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
            return true;
          }
        }
      }
      else if ("getPhoneNumber".equals(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.optString("frd_uin");
            paramString3 = new Bundle();
            paramString3.putString("KEY_UIN", paramString1);
            paramString1 = QIPCClientHelper.getInstance().getClient().callServer("FriendQIPCModule", "ACTION_GET_PHONE_NUMBER", paramString3);
            if (paramString1.isSuccess()) {
              paramJsBridgeListener = paramString1.data.getString("PHONE_NUMBER", null);
            }
            paramString3 = new JSONObject();
            if (TextUtils.isEmpty(paramJsBridgeListener)) {
              break label1050;
            }
            paramString1 = paramJsBridgeListener;
            if ("0".equals(paramJsBridgeListener)) {
              break label1050;
            }
            label785:
            paramString3.put("PhoneNumber", paramString1);
            callJs(paramString2.optString("callback"), new String[] { paramString3.toString() });
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
            return true;
          }
        }
      }
      else if ((!"deleteOneWayFriends".equals(paramString3)) || (paramVarArgs == null) || (paramVarArgs.length <= 0)) {}
    }
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramVarArgs[0]).optJSONArray("uins");
        paramJsBridgeListener = new ArrayList();
        if ((paramString1 != null) && (paramString1.length() > 0))
        {
          i = 0;
          if (i < paramString1.length())
          {
            paramString2 = paramString1.optString(i);
            if (TextUtils.isEmpty(paramString2)) {
              break label1056;
            }
            paramJsBridgeListener.add(paramString2);
            break label1056;
          }
        }
        paramString1 = new StringBuilder();
        paramString1.append("delete single way friends: ");
        paramString1.append(paramJsBridgeListener);
        QLog.d("FriendApiPlugin", 1, paramString1.toString());
        if (!paramJsBridgeListener.isEmpty())
        {
          paramString1 = new Bundle();
          paramString1.putStringArrayList("KEY_BE_DELETE_SINGLE_WAY_FRIENDS", paramJsBridgeListener);
          paramJsBridgeListener = QIPCClientHelper.getInstance().getClient().callServer("FriendQIPCModule", "ACTION_DELETE_SINGLE_WAY_FRIENDS", paramString1);
          if (paramJsBridgeListener != null) {
            bool1 = paramJsBridgeListener.isSuccess();
          }
          paramJsBridgeListener = new StringBuilder();
          paramJsBridgeListener.append("notify delete single way friend, isSuccess: ");
          paramJsBridgeListener.append(bool1);
          QLog.d("FriendApiPlugin", 1, paramJsBridgeListener.toString());
          return true;
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
      }
      label1042:
      return true;
      label1044:
      bool1 = false;
      break;
      label1050:
      paramString1 = "";
      break label785;
      label1056:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.FriendApiPlugin
 * JD-Core Version:    0.7.0.1
 */