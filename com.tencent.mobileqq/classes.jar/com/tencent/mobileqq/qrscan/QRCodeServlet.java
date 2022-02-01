package com.tencent.mobileqq.qrscan;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QRCodeServlet
  extends MSFServlet
{
  private static String a = "QRCodeServlet";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg != null) {
      QLog.d(a, 2, paramFromServiceMsg.toString());
    }
    Object localObject = null;
    boolean bool;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramFromServiceMsg.getResultCode() == 1000)) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
      if (paramFromServiceMsg == null)
      {
        bool = false;
        paramFromServiceMsg = (FromServiceMsg)localObject;
      }
      else
      {
        localObject = WupUtil.b(paramFromServiceMsg);
        paramFromServiceMsg = new Bundle();
        localObject = new String((byte[])localObject);
        paramFromServiceMsg.putString("result", (String)localObject);
        QLog.d(a, 2, (String)localObject);
      }
    }
    else
    {
      QLog.e(a, 2, " MSF response is null");
      paramFromServiceMsg = (FromServiceMsg)localObject;
    }
    notifyObserver(paramIntent, 0, bool, paramFromServiceMsg, QRCodeBusinessObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    Object localObject1 = new JSONObject();
    try
    {
      paramIntent = paramIntent.getExtras();
      localObject2 = new String[15];
      i = 0;
      localObject2[0] = "skey";
      localObject2[1] = "no_verify_token";
      localObject2[2] = "d";
      localObject2[3] = "appid";
      localObject2[4] = "ul";
      localObject2[5] = "bqq";
      localObject2[6] = "md5";
      localObject2[7] = "fromuin";
      localObject2[8] = "touin";
      localObject2[9] = "imei";
      localObject2[10] = "ip";
      localObject2[11] = "url";
      localObject2[12] = "guid";
      localObject2[13] = "uuid";
      localObject2[14] = "type";
      j = localObject2.length;
    }
    catch (JSONException paramIntent)
    {
      for (;;)
      {
        Object localObject2;
        int i;
        int j;
        Object localObject3;
        Object localObject4;
        continue;
        i += 1;
      }
    }
    if (i < j)
    {
      localObject3 = localObject2[i];
      if (paramIntent.containsKey((String)localObject3))
      {
        localObject4 = paramIntent.get((String)localObject3);
        if ((localObject4 instanceof ArrayList)) {
          ((JSONObject)localObject1).put((String)localObject3, new JSONArray((ArrayList)localObject4));
        } else if (TextUtils.equals("type", (CharSequence)localObject3)) {
          ((JSONObject)localObject1).put((String)localObject3, Integer.valueOf(localObject4.toString()));
        } else {
          ((JSONObject)localObject1).put((String)localObject3, localObject4);
        }
      }
    }
    else
    {
      if (paramIntent.containsKey("extra"))
      {
        localObject2 = paramIntent.getBundle("extra");
        localObject3 = ((Bundle)localObject2).keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          ((JSONObject)localObject1).put((String)localObject4, ((Bundle)localObject2).get((String)localObject4));
        }
      }
      localObject1 = ((JSONObject)localObject1).toString();
      paramPacket.setTimeout(30000L);
      paramPacket.setSSOCommand(paramIntent.getString("cmd"));
      paramPacket.putSendData(WupUtil.a(((String)localObject1).getBytes()));
      if (QLog.isColorLevel())
      {
        paramIntent = a;
        paramPacket = new StringBuilder();
        paramPacket.append("onSend result: ");
        paramPacket.append((String)localObject1);
        QLog.i(paramIntent, 2, paramPacket.toString());
        return;
        QLog.d(a, 2, "json error");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.QRCodeServlet
 * JD-Core Version:    0.7.0.1
 */