package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE.StAddressInfo;
import NS_MINI_INTERFACE.INTERFACE.StApiUserInfo;
import NS_MINI_INTERFACE.INTERFACE.StBatchGetUserInfoRsp;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.Packet;
import org.json.JSONArray;
import org.json.JSONObject;

public class BatchGetUserInfoServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_OPENIDS = "key_openid";
  public static final String KEY_RESULT_DATA = "key_reslut_data";
  public static final String TAG = "[minigame] BatchGetUserInfoServlet";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    try
    {
      localBundle.putInt("key_index", paramIntent.getIntExtra("key_index", -1));
      if (paramFromServiceMsg != null)
      {
        if (paramFromServiceMsg.isSuccess())
        {
          Object localObject1 = new PROTOCAL.StQWebRsp();
          ((PROTOCAL.StQWebRsp)localObject1).mergeFrom(WupUtil.b(paramFromServiceMsg.getWupBuffer()));
          localBundle.putInt("key_index", (int)((PROTOCAL.StQWebRsp)localObject1).Seq.get());
          if (((PROTOCAL.StQWebRsp)localObject1).retCode.get() == 0L)
          {
            localObject2 = new INTERFACE.StBatchGetUserInfoRsp();
            ((INTERFACE.StBatchGetUserInfoRsp)localObject2).mergeFrom(((PROTOCAL.StQWebRsp)localObject1).busiBuff.get().toByteArray());
            if (((INTERFACE.StBatchGetUserInfoRsp)localObject2).user != null)
            {
              localObject2 = ((INTERFACE.StBatchGetUserInfoRsp)localObject2).user.get();
              localObject1 = new JSONArray();
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                INTERFACE.StApiUserInfo localStApiUserInfo = (INTERFACE.StApiUserInfo)((Iterator)localObject2).next();
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("nickName", localStApiUserInfo.nick.get());
                localJSONObject.put("avatarUrl", localStApiUserInfo.avatar.get());
                localJSONObject.put("gender", localStApiUserInfo.gender.get());
                localJSONObject.put("language", localStApiUserInfo.language.get());
                localJSONObject.put("country", localStApiUserInfo.address.country.get());
                localJSONObject.put("province", localStApiUserInfo.address.province.get());
                localJSONObject.put("city", localStApiUserInfo.address.city.get());
                localJSONObject.put("openId", localStApiUserInfo.openid.get());
                ((JSONArray)localObject1).put(localJSONObject);
              }
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("data", localObject1);
              localBundle.putString("key_reslut_data", ((JSONObject)localObject2).toString());
              notifyObserver(paramIntent, 1028, true, localBundle, MiniAppObserver.class);
            }
            else
            {
              QLog.e("[minigame] BatchGetUserInfoServlet", 2, "inform BatchGetUserInfoServlet result.user == null");
              notifyObserver(paramIntent, 1028, false, localBundle, MiniAppObserver.class);
            }
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("inform BatchGetUserInfoServlet rsp.retCode = ");
            ((StringBuilder)localObject2).append(((PROTOCAL.StQWebRsp)localObject1).retCode.get());
            QLog.e("[minigame] BatchGetUserInfoServlet", 2, ((StringBuilder)localObject2).toString());
            notifyObserver(paramIntent, 1028, false, localBundle, MiniAppObserver.class);
          }
        }
        else
        {
          localBundle.putLong("ret_code", paramFromServiceMsg.getBusinessFailCode());
          localBundle.putString("err_msg", paramFromServiceMsg.getBusinessFailMsg());
          QLog.e("[minigame] BatchGetUserInfoServlet", 2, "inform BatchGetUserInfoServlet isSuccess false");
          notifyObserver(paramIntent, 1028, false, localBundle, MiniAppObserver.class);
        }
      }
      else
      {
        QLog.e("[minigame] BatchGetUserInfoServlet", 2, "inform BatchGetUserInfoServlet resultcode fail.");
        notifyObserver(paramIntent, 1028, false, localBundle, MiniAppObserver.class);
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("BatchGetUserInfoServlet exception:");
      ((StringBuilder)localObject2).append(localThrowable);
      ((StringBuilder)localObject2).append("onReceive error");
      QLog.e("[minigame] BatchGetUserInfoServlet", 1, ((StringBuilder)localObject2).toString());
      notifyObserver(null, 1028, false, localBundle, MiniAppObserver.class);
    }
    doReport(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte2 = new BatchGetUserInfoRequest(paramIntent.getStringExtra("key_appid"), paramIntent.getStringExtra("key_lang"), paramIntent.getStringArrayExtra("key_openid")).encode(paramIntent, paramIntent.getIntExtra("key_index", -1), getTraceId());
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null) {
      arrayOfByte1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.mini_user_info.BatchGetUserInfo");
    paramPacket.putSendData(WupUtil.a(arrayOfByte1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.BatchGetUserInfoServlet
 * JD-Core Version:    0.7.0.1
 */