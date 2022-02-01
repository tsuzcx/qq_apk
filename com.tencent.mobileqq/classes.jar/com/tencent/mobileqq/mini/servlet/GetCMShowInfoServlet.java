package com.tencent.mobileqq.mini.servlet;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetCMShowInfoServlet
  extends MSFServlet
{
  public static final String CMD_STRING = "apollo_router_light.apollo_arkitsvr_linkcmd_getavatar";
  public static final String EXTRA_APPID = "appid";
  public static final String EXTRA_AVATAR_TYPE = "avatar_type";
  public static final String EXTRA_AVATAR_TYPE_2D = "avatar2D";
  public static final String EXTRA_AVATAR_TYPE_3D = "avatar3D";
  public static final String EXTRA_ENGINE_TYPE = "engine_name";
  public static final String EXTRA_ENGINE_VERSION = "engine_version";
  public static final String EXTRA_OPENID = "openids";
  public static final String EXTRA_RESULT_DATA = "result_data";
  private static final int PACKAGE_HEAD_LENGTH = 4;
  public static final int RET_CODE_SUCCESS = 0;
  public static final String TAG = "GetCMShowInfoServlet";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_index", paramIntent.getIntExtra("key_index", -1));
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      Object localObject = paramFromServiceMsg.getWupBuffer();
      if (localObject != null)
      {
        int i = localObject.length - 4;
        paramFromServiceMsg = new byte[i];
        PkgTools.copyData(paramFromServiceMsg, 0, (byte[])localObject, 4, i);
        try
        {
          localObject = new WebSSOAgent.UniSsoServerRsp();
          ((WebSSOAgent.UniSsoServerRsp)localObject).mergeFrom(paramFromServiceMsg);
          localBundle.putLong("retCode", ((WebSSOAgent.UniSsoServerRsp)localObject).ret.get());
          localBundle.putString("errMsg", ((WebSSOAgent.UniSsoServerRsp)localObject).errmsg.get());
          localBundle.putString("result_data", ((WebSSOAgent.UniSsoServerRsp)localObject).rspdata.get());
          if (((WebSSOAgent.UniSsoServerRsp)localObject).ret.get() == 0L) {}
          for (boolean bool = true;; bool = false)
          {
            notifyObserver(paramIntent, 1088, bool, localBundle, MiniAppObserver.class);
            return;
          }
          notifyObserver(paramIntent, 1087, false, localBundle, MiniAppObserver.class);
        }
        catch (Throwable paramFromServiceMsg)
        {
          QLog.e("GetCMShowInfoServlet", 1, "[onReceive] process response error!", paramFromServiceMsg);
        }
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getStringExtra("openids");
    String str1 = paramIntent.getStringExtra("appid");
    String str2 = paramIntent.getStringExtra("engine_name");
    String str3 = paramIntent.getStringExtra("engine_version");
    String str4 = paramIntent.getStringExtra("avatar_type");
    Object localObject2 = new WebSSOAgent.UniSsoServerReqComm();
    ((WebSSOAgent.UniSsoServerReqComm)localObject2).platform.set(109L);
    ((WebSSOAgent.UniSsoServerReqComm)localObject2).osver.set(Build.VERSION.RELEASE);
    ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("8.5.5");
    paramIntent = new WebSSOAgent.UniSsoServerReq();
    paramIntent.comm.set((MessageMicro)localObject2);
    localObject2 = new JSONObject();
    try
    {
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(localObject1);
      ((JSONObject)localObject2).put("openids", localJSONArray);
      ((JSONObject)localObject2).put("appid", str1);
      ((JSONObject)localObject2).put("engine_name", str2);
      ((JSONObject)localObject2).put("engine_version", str3);
      ((JSONObject)localObject2).put("avatar_type", str4);
      paramIntent.reqdata.set(((JSONObject)localObject2).toString());
      paramIntent = paramIntent.toByteArray();
      localObject1 = new byte[paramIntent.length + 4];
      PkgTools.DWord2Byte((byte[])localObject1, 0, paramIntent.length + 4);
      PkgTools.copyData((byte[])localObject1, 4, paramIntent, paramIntent.length);
      paramPacket.setSSOCommand("apollo_router_light.apollo_arkitsvr_linkcmd_getavatar");
      paramPacket.putSendData((byte[])localObject1);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("GetCMShowInfoServlet", 1, "[onSend] params error!", localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetCMShowInfoServlet
 * JD-Core Version:    0.7.0.1
 */