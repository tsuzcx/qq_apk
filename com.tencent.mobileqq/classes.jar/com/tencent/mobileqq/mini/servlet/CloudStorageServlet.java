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
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.WupUtil;
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
    String str;
    if (paramIntent != null) {
      str = paramIntent.getStringExtra("app_id");
    } else {
      str = "";
    }
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
  
  private void putData(Bundle paramBundle, PROTOCAL.StQWebRsp paramStQWebRsp)
  {
    Object localObject1;
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
      return;
    }
    if (("get_friend_cloud_storage".equals(this.type)) || ("get_group_cloud_storage".equals(this.type)))
    {
      localObject1 = null;
      if ("get_friend_cloud_storage".equals(this.type))
      {
        localObject1 = new CloudStorage.StGetFriendCloudStorageRsp();
        ((CloudStorage.StGetFriendCloudStorageRsp)localObject1).mergeFrom(paramStQWebRsp.busiBuff.get().toByteArray());
        localObject1 = ((CloudStorage.StGetFriendCloudStorageRsp)localObject1).data.get();
      }
      else if ("get_group_cloud_storage".equals(this.type))
      {
        localObject1 = new CloudStorage.StGetGroupCloudStorageRsp();
        ((CloudStorage.StGetGroupCloudStorageRsp)localObject1).mergeFrom(paramStQWebRsp.busiBuff.get().toByteArray());
        localObject1 = ((CloudStorage.StGetGroupCloudStorageRsp)localObject1).data.get();
      }
      if (localObject1 != null)
      {
        if (((List)localObject1).isEmpty()) {
          return;
        }
        try
        {
          paramStQWebRsp = new JSONObject();
          localObject2 = new JSONArray();
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject3 = (CloudStorage.StUserGameData)((Iterator)localObject1).next();
            localJSONObject1 = new JSONObject();
            localJSONObject1.put("avatarUrl", ((CloudStorage.StUserGameData)localObject3).avatarUrl.get());
            localJSONObject1.put("nickname", ((CloudStorage.StUserGameData)localObject3).nickname.get());
            localJSONObject1.put("openid", ((CloudStorage.StUserGameData)localObject3).openid.get());
            if ((((CloudStorage.StUserGameData)localObject3).KVDataList != null) && (((CloudStorage.StUserGameData)localObject3).KVDataList.size() > 0))
            {
              Object localObject4 = ((CloudStorage.StUserGameData)localObject3).KVDataList.get();
              localObject3 = new JSONArray();
              localObject4 = ((List)localObject4).iterator();
              while (((Iterator)localObject4).hasNext())
              {
                CloudStorage.StKVData localStKVData = (CloudStorage.StKVData)((Iterator)localObject4).next();
                JSONObject localJSONObject2 = new JSONObject();
                localJSONObject2.put("key", localStKVData.key.get());
                localJSONObject2.put("value", localStKVData.value.get());
                ((JSONArray)localObject3).put(localJSONObject2);
              }
              localJSONObject1.put("KVDataList", localObject3);
            }
            ((JSONArray)localObject2).put(localJSONObject1);
          }
          paramStQWebRsp.put("data", localObject2);
          paramBundle.putString("key_reslut_data", paramStQWebRsp.toString());
          return;
        }
        catch (Throwable paramBundle)
        {
          paramBundle.printStackTrace();
          QLog.d("[minigame] CloudStorageServlet", 1, "GET_FRIEND_CLOUD_STORAGE fail", paramBundle);
        }
      }
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramIntent != null) {}
    for (;;)
    {
      try
      {
        localObject1 = paramIntent.getStringExtra("request_type");
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onReceive type:");
        ((StringBuilder)localObject3).append(this.type);
        ((StringBuilder)localObject3).append(", intent.type:");
        ((StringBuilder)localObject3).append((String)localObject1);
        QLog.i("[minigame] CloudStorageServlet", 1, ((StringBuilder)localObject3).toString());
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(this.type))) {
          this.type = ((String)localObject1);
        }
        boolean bool = "set_cloud_storage".equals(this.type);
        if ((!bool) && (!"remove_cloud_storage".equals(this.type)))
        {
          bool = "get_cloud_storage".equals(this.type);
          if ((bool) || ("get_friend_cloud_storage".equals(this.type)) || ("get_group_cloud_storage".equals(this.type)))
          {
            if ("get_friend_cloud_storage".equals(this.type))
            {
              i = 1019;
            }
            else
            {
              if (!"get_group_cloud_storage".equals(this.type)) {
                break label394;
              }
              i = 1018;
            }
            localObject1 = new Bundle();
            localObject3 = new PROTOCAL.StQWebRsp();
            ((PROTOCAL.StQWebRsp)localObject3).mergeFrom(WupUtil.b(paramFromServiceMsg.getWupBuffer()));
            putData((Bundle)localObject1, (PROTOCAL.StQWebRsp)localObject3);
            ((Bundle)localObject1).putInt("key_index", (int)((PROTOCAL.StQWebRsp)localObject3).Seq.get());
            notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, MiniAppObserver.class);
          }
        }
        else
        {
          if (!"set_cloud_storage".equals(this.type)) {
            break label401;
          }
          i = 1015;
          localObject1 = new Bundle();
          localObject3 = new PROTOCAL.StQWebRsp();
          ((PROTOCAL.StQWebRsp)localObject3).mergeFrom(WupUtil.b(paramFromServiceMsg.getWupBuffer()));
          ((Bundle)localObject1).putInt("key_index", (int)((PROTOCAL.StQWebRsp)localObject3).Seq.get());
          notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, MiniAppObserver.class);
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        continue;
      }
      QLog.e("[minigame] CloudStorageServlet", 1, "onReceive error", (Throwable)localObject1);
      doReport(paramIntent, paramFromServiceMsg);
      return;
      Object localObject2 = null;
      continue;
      label394:
      int i = 1016;
      continue;
      label401:
      i = 1017;
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
    paramPacket.putSendData(WupUtil.a((byte[])localObject));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.CloudStorageServlet
 * JD-Core Version:    0.7.0.1
 */