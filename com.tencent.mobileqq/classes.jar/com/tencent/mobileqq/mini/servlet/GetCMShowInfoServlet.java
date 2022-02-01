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
        boolean bool = false;
        PkgTools.copyData(paramFromServiceMsg, 0, (byte[])localObject, 4, i);
        try
        {
          localObject = new WebSSOAgent.UniSsoServerRsp();
          ((WebSSOAgent.UniSsoServerRsp)localObject).mergeFrom(paramFromServiceMsg);
          localBundle.putLong("retCode", ((WebSSOAgent.UniSsoServerRsp)localObject).ret.get());
          localBundle.putString("errMsg", ((WebSSOAgent.UniSsoServerRsp)localObject).errmsg.get());
          localBundle.putString("result_data", ((WebSSOAgent.UniSsoServerRsp)localObject).rspdata.get());
          if (((WebSSOAgent.UniSsoServerRsp)localObject).ret.get() == 0L) {
            bool = true;
          }
          notifyObserver(paramIntent, 1088, bool, localBundle, MiniAppObserver.class);
          return;
        }
        catch (Throwable paramFromServiceMsg)
        {
          QLog.e("GetCMShowInfoServlet", 1, "[onReceive] process response error!", paramFromServiceMsg);
        }
      }
    }
    notifyObserver(paramIntent, 1087, false, localBundle, MiniAppObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    String str1 = paramIntent.getStringExtra("openids");
    String str2 = paramIntent.getStringExtra("appid");
    String str3 = paramIntent.getStringExtra("engine_name");
    String str4 = paramIntent.getStringExtra("engine_version");
    String str5 = paramIntent.getStringExtra("avatar_type");
    Object localObject = new WebSSOAgent.UniSsoServerReqComm();
    ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
    ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
    ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.7.0");
    paramIntent = new WebSSOAgent.UniSsoServerReq();
    paramIntent.comm.set((MessageMicro)localObject);
    localObject = new JSONObject();
    try
    {
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(str1);
      ((JSONObject)localObject).put("openids", localJSONArray);
      ((JSONObject)localObject).put("appid", str2);
      ((JSONObject)localObject).put("engine_name", str3);
      ((JSONObject)localObject).put("engine_version", str4);
      ((JSONObject)localObject).put("avatar_type", str5);
    }
    catch (JSONException localJSONException)
    {
      QLog.e("GetCMShowInfoServlet", 1, "[onSend] params error!", localJSONException);
    }
    paramIntent.reqdata.set(((JSONObject)localObject).toString());
    paramIntent = paramIntent.toByteArray();
    byte[] arrayOfByte = new byte[paramIntent.length + 4];
    PkgTools.dWord2Byte(arrayOfByte, 0, paramIntent.length + 4);
    PkgTools.copyData(arrayOfByte, 4, paramIntent, paramIntent.length);
    paramPacket.setSSOCommand("apollo_router_light.apollo_arkitsvr_linkcmd_getavatar");
    paramPacket.putSendData(arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetCMShowInfoServlet
 * JD-Core Version:    0.7.0.1
 */