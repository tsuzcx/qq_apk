package com.tencent.mobileqq.mini.servlet;

import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetFriendCloudStorageRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetGroupCloudStorageRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetUserCloudStorageRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StKVData;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StUserGameData;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bhjl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.Packet;
import org.json.JSONArray;
import org.json.JSONObject;

public class CloudStorageServlet
  extends MiniAppAbstractServlet
{
  public static final String GET_CLOUD_STORAGE = "get_cloud_storage";
  public static final String GET_FRIEND_CLOUD_STORAGE = "get_friend_cloud_storage";
  public static final String GET_GROUP_CLOUD_STORAGE = "get_group_cloud_storage";
  public static final String KEY_APP_ID = "app_id";
  public static final String KEY_DATA = "key_data";
  public static final String KEY_RESULT_DATA = "key_reslut_data";
  public static final String KEY_SHARETICKET = "key_shareticket";
  public static final String REMOVE_CLOUD_STORAGE = "remove_cloud_storage";
  public static final String REQUEST_TYPE = "request_type";
  public static final String SET_CLOUD_STORAGE = "set_cloud_storage";
  private static final String TAG = "[minigame] CloudStorageServlet";
  private String type;
  
  private ProtoBufRequest getRequest(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent != null) {}
    for (String str = paramIntent.getStringExtra("app_id");; str = "")
    {
      if ("set_cloud_storage".equals(this.type))
      {
        paramPacket.setSSOCommand("LightAppSvc.mini_app_cloudstorage.SetUserCloudStorage");
        return new SetCloudStorageRequest((HashMap)paramIntent.getSerializableExtra("key_data"), str);
      }
      if ("get_cloud_storage".equals(this.type))
      {
        paramPacket.setSSOCommand("LightAppSvc.mini_app_cloudstorage.GetUserCloudStorage");
        return new GetCloudStorageRequest(paramIntent.getStringArrayExtra("key_data"), str);
      }
      if ("remove_cloud_storage".equals(this.type))
      {
        paramPacket.setSSOCommand("LightAppSvc.mini_app_cloudstorage.RemoveUserCloudStorage");
        return new RemoveCloudStorageRequest(paramIntent.getStringArrayExtra("key_data"), str);
      }
      if ("get_group_cloud_storage".equals(this.type))
      {
        paramPacket.setSSOCommand("LightAppSvc.mini_app_cloudstorage.GetGroupCloudStorage");
        return new GetGroupCloudStorageRequest(paramIntent.getStringArrayExtra("key_data"), paramIntent.getStringExtra("key_shareticket"), str);
      }
      if ("get_friend_cloud_storage".equals(this.type))
      {
        paramPacket.setSSOCommand("LightAppSvc.mini_app_cloudstorage.GetFriendCloudStorage");
        return new GetFriendCloudStorageRequest(paramIntent.getStringArrayExtra("key_data"), str);
      }
      return null;
    }
  }
  
  private void putData(Bundle paramBundle, PROTOCAL.StQWebRsp paramStQWebRsp)
  {
    Object localObject2;
    JSONObject localJSONObject1;
    if ("get_cloud_storage".equals(this.type))
    {
      localObject1 = new CloudStorage.StGetUserCloudStorageRsp();
      ((CloudStorage.StGetUserCloudStorageRsp)localObject1).mergeFrom(paramStQWebRsp.busiBuff.get().toByteArray());
      localObject1 = ((CloudStorage.StGetUserCloudStorageRsp)localObject1).KVDataList.get();
      paramStQWebRsp = new JSONArray();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CloudStorage.StKVData)((Iterator)localObject1).next();
        localJSONObject1 = new JSONObject();
        localJSONObject1.put("key", ((CloudStorage.StKVData)localObject2).key.get());
        localJSONObject1.put("value", ((CloudStorage.StKVData)localObject2).value.get());
        paramStQWebRsp.put(localJSONObject1);
      }
      paramBundle.putString("key_reslut_data", paramStQWebRsp.toString());
    }
    while ((!"get_friend_cloud_storage".equals(this.type)) && (!"get_group_cloud_storage".equals(this.type))) {
      return;
    }
    Object localObject1 = null;
    if ("get_friend_cloud_storage".equals(this.type))
    {
      localObject1 = new CloudStorage.StGetFriendCloudStorageRsp();
      ((CloudStorage.StGetFriendCloudStorageRsp)localObject1).mergeFrom(paramStQWebRsp.busiBuff.get().toByteArray());
      localObject1 = ((CloudStorage.StGetFriendCloudStorageRsp)localObject1).data.get();
      label209:
      if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
        break label503;
      }
    }
    for (;;)
    {
      Object localObject3;
      try
      {
        paramStQWebRsp = new JSONObject();
        localObject2 = new JSONArray();
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label526;
        }
        localObject3 = (CloudStorage.StUserGameData)((Iterator)localObject1).next();
        localJSONObject1 = new JSONObject();
        localJSONObject1.put("avatarUrl", ((CloudStorage.StUserGameData)localObject3).avatarUrl.get());
        localJSONObject1.put("nickname", ((CloudStorage.StUserGameData)localObject3).nickname.get());
        localJSONObject1.put("openid", ((CloudStorage.StUserGameData)localObject3).openid.get());
        if ((((CloudStorage.StUserGameData)localObject3).KVDataList == null) || (((CloudStorage.StUserGameData)localObject3).KVDataList.size() <= 0)) {
          break label515;
        }
        Object localObject4 = ((CloudStorage.StUserGameData)localObject3).KVDataList.get();
        localObject3 = new JSONArray();
        localObject4 = ((List)localObject4).iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label505;
        }
        CloudStorage.StKVData localStKVData = (CloudStorage.StKVData)((Iterator)localObject4).next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("key", localStKVData.key.get());
        localJSONObject2.put("value", localStKVData.value.get());
        ((JSONArray)localObject3).put(localJSONObject2);
        continue;
        if (!"get_group_cloud_storage".equals(this.type)) {
          break label209;
        }
      }
      catch (Throwable paramBundle)
      {
        paramBundle.printStackTrace();
        QLog.d("[minigame] CloudStorageServlet", 1, "GET_FRIEND_CLOUD_STORAGE fail", paramBundle);
        return;
      }
      localObject1 = new CloudStorage.StGetGroupCloudStorageRsp();
      ((CloudStorage.StGetGroupCloudStorageRsp)localObject1).mergeFrom(paramStQWebRsp.busiBuff.get().toByteArray());
      localObject1 = ((CloudStorage.StGetGroupCloudStorageRsp)localObject1).data.get();
      break label209;
      label503:
      break;
      label505:
      localJSONObject1.put("KVDataList", localObject3);
      label515:
      ((JSONArray)localObject2).put(localJSONObject1);
    }
    label526:
    paramStQWebRsp.put("data", localObject2);
    paramBundle.putString("key_reslut_data", paramStQWebRsp.toString());
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramIntent != null) {}
    for (;;)
    {
      try
      {
        localObject = paramIntent.getStringExtra("request_type");
        QLog.i("[minigame] CloudStorageServlet", 1, "onReceive type:" + this.type + ", intent.type:" + (String)localObject);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(this.type))) {
          this.type = ((String)localObject);
        }
        if ((!"set_cloud_storage".equals(this.type)) && (!"remove_cloud_storage".equals(this.type))) {
          continue;
        }
        if (!"set_cloud_storage".equals(this.type)) {
          continue;
        }
        i = 1015;
        localObject = new Bundle();
        localStQWebRsp = new PROTOCAL.StQWebRsp();
        localStQWebRsp.mergeFrom(bhjl.b(paramFromServiceMsg.getWupBuffer()));
        ((Bundle)localObject).putInt("key_index", (int)localStQWebRsp.Seq.get());
        notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), (Bundle)localObject, MiniAppObserver.class);
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        PROTOCAL.StQWebRsp localStQWebRsp;
        QLog.e("[minigame] CloudStorageServlet", 1, "onReceive error", localThrowable);
        continue;
        boolean bool = "get_group_cloud_storage".equals(this.type);
        if (!bool) {
          continue;
        }
        int i = 1018;
        continue;
      }
      doReport(paramIntent, paramFromServiceMsg);
      return;
      localObject = null;
      continue;
      i = 1017;
      continue;
      if (("get_cloud_storage".equals(this.type)) || ("get_friend_cloud_storage".equals(this.type)) || ("get_group_cloud_storage".equals(this.type)))
      {
        i = 1016;
        if (!"get_friend_cloud_storage".equals(this.type)) {
          continue;
        }
        i = 1019;
        localObject = new Bundle();
        localStQWebRsp = new PROTOCAL.StQWebRsp();
        localStQWebRsp.mergeFrom(bhjl.b(paramFromServiceMsg.getWupBuffer()));
        putData((Bundle)localObject, localStQWebRsp);
        ((Bundle)localObject).putInt("key_index", (int)localStQWebRsp.Seq.get());
        notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), (Bundle)localObject, MiniAppObserver.class);
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("key_index", -1);
    this.type = paramIntent.getStringExtra("request_type");
    Object localObject = getRequest(paramIntent, paramPacket);
    if (localObject == null) {
      return;
    }
    byte[] arrayOfByte = ((ProtoBufRequest)localObject).encode(paramIntent, i, getTraceId());
    localObject = arrayOfByte;
    if (arrayOfByte == null) {
      localObject = new byte[4];
    }
    paramPacket.putSendData(bhjl.a((byte[])localObject));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.CloudStorageServlet
 * JD-Core Version:    0.7.0.1
 */