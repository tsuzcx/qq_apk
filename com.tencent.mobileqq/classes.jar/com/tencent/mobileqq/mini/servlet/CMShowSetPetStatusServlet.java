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
import org.json.JSONException;
import org.json.JSONObject;

public class CMShowSetPetStatusServlet
  extends MSFServlet
{
  public static final String CMD_STRING = "apollo_router_weight.pet_core_linkcmd_set_status";
  public static final String EXTRA_PET_ID = "petId";
  public static final String EXTRA_PET_STATUS = "petStatus";
  private static final int PACKAGE_HEAD_LENGTH = 4;
  public static final int RET_CODE_SUCCESS = 0;
  
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
          if (((WebSSOAgent.UniSsoServerRsp)localObject).ret.get() == 0L) {}
          for (boolean bool = true;; bool = false)
          {
            notifyObserver(paramIntent, 1087, bool, localBundle, MiniAppObserver.class);
            return;
          }
          notifyObserver(paramIntent, 1087, false, localBundle, MiniAppObserver.class);
        }
        catch (Throwable paramFromServiceMsg)
        {
          QLog.e("MSFServlet", 1, "[onReceive] process response error!", paramFromServiceMsg);
        }
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("petId", -1);
    int j = paramIntent.getIntExtra("petStatus", -1);
    Object localObject = new WebSSOAgent.UniSsoServerReqComm();
    ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
    ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
    ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.5.5");
    paramIntent = new WebSSOAgent.UniSsoServerReq();
    paramIntent.comm.set((MessageMicro)localObject);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("id", i);
      ((JSONObject)localObject).put("status", j);
      paramIntent.reqdata.set(((JSONObject)localObject).toString());
      paramIntent = paramIntent.toByteArray();
      localObject = new byte[paramIntent.length + 4];
      PkgTools.DWord2Byte((byte[])localObject, 0, paramIntent.length + 4);
      PkgTools.copyData((byte[])localObject, 4, paramIntent, paramIntent.length);
      paramPacket.setSSOCommand("apollo_router_weight.pet_core_linkcmd_set_status");
      paramPacket.putSendData((byte[])localObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("MSFServlet", 1, "[onSend] params error!", localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.CMShowSetPetStatusServlet
 * JD-Core Version:    0.7.0.1
 */