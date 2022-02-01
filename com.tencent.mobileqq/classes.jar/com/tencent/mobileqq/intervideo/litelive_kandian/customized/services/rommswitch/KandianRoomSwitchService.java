package com.tencent.mobileqq.intervideo.litelive_kandian.customized.services.rommswitch;

import android.content.Context;
import android.os.Bundle;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.hostproxy.SdkInfoInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginRequest;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface.IRoomList;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface.QueryRoomListTrigger;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.VideoType;
import com.tencent.ilivesdk.service.RoomSwitchServiceAdapter;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.api.login.LoginResult;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.framework.login.LoginManager;
import com.tencent.mobileqq.litelivesdk.utils.AegisHelper;
import com.tencent.mobileqq.litelivesdk.utils.CookieHelper;
import com.tencent.mobileqq.litelivesdk.utils.DeviceUtils;
import com.tencent.mobileqq.litelivesdk.utils.https.HttpsFactory;
import com.tencent.mobileqq.litelivesdk.utils.https.HttpsInterface;
import com.tencent.mobileqq.litelivesdk.utils.network.NetworkUtil;
import com.tencent.mobileqq.litelivesdk.utils.room.RoomUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class KandianRoomSwitchService
  implements RoomSwitchInterface
{
  final int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private RoomSwitchInterface.QueryRoomListTrigger jdField_a_of_type_ComTencentIlivesdkRoomswitchservice_interfaceRoomSwitchInterface$QueryRoomListTrigger;
  private RoomSwitchServiceAdapter jdField_a_of_type_ComTencentIlivesdkServiceRoomSwitchServiceAdapter;
  private String jdField_a_of_type_JavaLangString = "https://kd.ilive.qq.com/";
  final int jdField_b_of_type_Int = 1;
  private String jdField_b_of_type_JavaLangString = "https://fastest.kd.ilive.qq.com/";
  final int jdField_c_of_type_Int = 2;
  private String jdField_c_of_type_JavaLangString = "cgi-bin/info_flow/rcmd/rcmd_list";
  private String d;
  
  private SwitchRoomInfo a(List<SwitchRoomInfo> paramList, int paramInt)
  {
    if ((paramList != null) && (paramInt >= 0) && (paramInt < paramList.size())) {
      return (SwitchRoomInfo)paramList.get(paramInt);
    }
    return null;
  }
  
  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 8: 
      return "qq_access";
    case 9: 
      return "access";
    }
    return "visitor";
  }
  
  private List<SwitchRoomInfo> a(List<SwitchRoomInfo> paramList1, List<SwitchRoomInfo> paramList2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentIlivesdkServiceRoomSwitchServiceAdapter.getLogger().i("RoomSwitchCgiService", String.format("roomList size = %d , switchRoomInfos size = %d", new Object[] { Integer.valueOf(paramList1.size()), Integer.valueOf(paramList2.size()) }), new Object[0]);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int k = 0;
    Object localObject;
    int j;
    if (i < paramList1.size())
    {
      localObject = ((SwitchRoomInfo)paramList1.get(i)).extData;
      if (((Bundle)localObject).getBoolean("read"))
      {
        localArrayList.add(paramList1.get(i));
        j = i;
      }
      for (;;)
      {
        i += 1;
        k = j;
        break;
        j = k;
        if (((Bundle)localObject).getBoolean("is_preload"))
        {
          j = k;
          if (paramInt != 0)
          {
            localArrayList.add(paramList1.get(i));
            j = i;
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentIlivesdkServiceRoomSwitchServiceAdapter.getLogger().i("RoomSwitchCgiService", String.format("isReadIndex = %d", new Object[] { Integer.valueOf(k) }), new Object[0]);
    i = 0;
    if (i < paramList2.size())
    {
      localObject = (SwitchRoomInfo)paramList2.get(i);
      j = 0;
      label250:
      if ((j > k) || (j >= paramList1.size())) {
        break label461;
      }
      if (!a((SwitchRoomInfo)paramList1.get(j), (SwitchRoomInfo)localObject)) {}
    }
    label461:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentIlivesdkServiceRoomSwitchServiceAdapter.getLogger().i("RoomSwitchCgiService", "isDuplicate = " + bool, new Object[0]);
      if (!bool) {
        localArrayList.add(localObject);
      }
      i += 1;
      break;
      j += 1;
      break label250;
      if (paramInt == 0)
      {
        paramList1 = null;
        if (k + 1 < localArrayList.size()) {
          paramList1 = (SwitchRoomInfo)localArrayList.get(k + 1);
        }
        if (paramList1 != null) {
          paramList1.extData.putBoolean("force_update", true);
        }
      }
      this.jdField_a_of_type_ComTencentIlivesdkServiceRoomSwitchServiceAdapter.getLogger().i("RoomSwitchCgiService", "newList size = " + localArrayList.size(), new Object[0]);
      return localArrayList;
    }
  }
  
  private JSONArray a(SwitchRoomInfo paramSwitchRoomInfo1, SwitchRoomInfo paramSwitchRoomInfo2)
  {
    JSONArray localJSONArray = new JSONArray();
    paramSwitchRoomInfo1 = a(paramSwitchRoomInfo1);
    paramSwitchRoomInfo2 = a(paramSwitchRoomInfo2);
    if (paramSwitchRoomInfo1 != null) {
      localJSONArray.put(paramSwitchRoomInfo1);
    }
    if (paramSwitchRoomInfo2 != null) {
      localJSONArray.put(paramSwitchRoomInfo2);
    }
    return localJSONArray;
  }
  
  private JSONObject a(SwitchRoomInfo paramSwitchRoomInfo)
  {
    if (paramSwitchRoomInfo == null) {
      return null;
    }
    try
    {
      Bundle localBundle = paramSwitchRoomInfo.extData;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("content_type", localBundle.getInt("content_type"));
      localJSONObject.put("room_id", paramSwitchRoomInfo.roomId);
      paramSwitchRoomInfo = new JSONObject();
      paramSwitchRoomInfo.put("ab_token", localBundle.getString("ab_token"));
      paramSwitchRoomInfo.put("watch_sec", localBundle.getInt("watch_sec"));
      localJSONObject.put("ext", paramSwitchRoomInfo);
      localJSONObject.put("vid", localBundle.getString("vid"));
      return localJSONObject;
    }
    catch (JSONException paramSwitchRoomInfo)
    {
      paramSwitchRoomInfo.printStackTrace();
    }
    return null;
  }
  
  private void a(List<SwitchRoomInfo> paramList, JSONObject paramJSONObject, int paramInt, RoomSwitchInterface.IRoomList paramIRoomList)
  {
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = paramJSONObject.getJSONArray("content_list");
        AegisHelper.b("content_list size = " + localJSONArray.length(), "RoomSwitchCgiService");
        paramJSONObject = new ArrayList();
        i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = (JSONObject)localJSONArray.get(i);
          int j = localJSONObject.getInt("content_type");
          String str1 = localJSONObject.getJSONObject("ext").getString("ab_token");
          String str2 = localJSONObject.getString("cover_url");
          localSwitchRoomInfo = new SwitchRoomInfo();
          Object localObject = new Bundle();
          localSwitchRoomInfo.extData = ((Bundle)localObject);
          localSwitchRoomInfo.logoUrl = str2;
          ((Bundle)localObject).putInt("content_type", j);
          ((Bundle)localObject).putString("ab_token", str1);
          if (RoomUtil.b(j))
          {
            localSwitchRoomInfo.roomId = localJSONObject.getLong("room_id");
            localObject = localJSONObject.getJSONArray("rtmp_url");
            localSwitchRoomInfo.videoType = VideoType.LIVE;
            if (((JSONArray)localObject).length() != 0)
            {
              localSwitchRoomInfo.videoUrl = ((String)((JSONArray)localObject).get(0));
              paramJSONObject.add(localSwitchRoomInfo);
            }
          }
          else
          {
            str1 = localJSONObject.getString("vid");
            localSwitchRoomInfo.videoType = VideoType.VIDEO;
            localSwitchRoomInfo.videoId = str1;
            ((Bundle)localObject).putString("vid", str1);
            localSwitchRoomInfo.videoUrl = localJSONObject.getString("adr_play_url");
            paramJSONObject.add(localSwitchRoomInfo);
          }
        }
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
        AegisHelper.a(paramList.getMessage(), "RoomSwitchCgiService");
        return;
      }
      SwitchRoomInfo localSwitchRoomInfo = null;
      if (paramJSONObject.size() == 0) {
        throw new NullPointerException();
      }
      for (;;)
      {
        ThreadManager.getUIHandler().post(new KandianRoomSwitchService.2(this, paramIRoomList, paramList));
        return;
        paramList = a(paramList, paramJSONObject, paramInt);
      }
      i += 1;
    }
  }
  
  private boolean a(SwitchRoomInfo paramSwitchRoomInfo1, SwitchRoomInfo paramSwitchRoomInfo2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramSwitchRoomInfo1 != null)
    {
      bool1 = bool2;
      if (paramSwitchRoomInfo2 != null)
      {
        bool1 = bool2;
        if (paramSwitchRoomInfo1.videoType.equals(paramSwitchRoomInfo2.videoType))
        {
          long l1 = paramSwitchRoomInfo1.roomId;
          long l2 = paramSwitchRoomInfo2.roomId;
          paramSwitchRoomInfo1 = paramSwitchRoomInfo1.videoId;
          paramSwitchRoomInfo2 = paramSwitchRoomInfo2.videoId;
          if ((l1 == 0L) || (l1 != l2))
          {
            bool1 = bool2;
            if (paramSwitchRoomInfo1 != null)
            {
              bool1 = bool2;
              if (!paramSwitchRoomInfo1.equals(paramSwitchRoomInfo2)) {}
            }
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return "no";
    case 1: 
      return "wifi";
    case 2: 
      return "2g";
    case 3: 
      return "3g";
    }
    return "unknow";
  }
  
  private static String c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 8: 
      return "qq_open";
    case 9: 
      return "weixin";
    }
    return "visitor";
  }
  
  public void a(RoomSwitchServiceAdapter paramRoomSwitchServiceAdapter)
  {
    this.jdField_a_of_type_ComTencentIlivesdkServiceRoomSwitchServiceAdapter = paramRoomSwitchServiceAdapter;
  }
  
  public void clearEventOutput() {}
  
  public boolean closeRoomSwitch()
  {
    return false;
  }
  
  public RoomSwitchInterface.QueryRoomListTrigger getQueryRoomListTrigger()
  {
    return this.jdField_a_of_type_ComTencentIlivesdkRoomswitchservice_interfaceRoomSwitchInterface$QueryRoomListTrigger;
  }
  
  public void onCreate(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    StringBuilder localStringBuilder = new StringBuilder();
    if (((HostProxyInterface)BizEngineMgr.getInstance().getLiveEngine().getService(HostProxyInterface.class)).getSdkInfoInterface().isTestEnv()) {}
    for (paramContext = this.jdField_b_of_type_JavaLangString;; paramContext = this.jdField_a_of_type_JavaLangString)
    {
      this.jdField_d_of_type_JavaLangString = (paramContext + this.jdField_c_of_type_JavaLangString);
      return;
    }
  }
  
  public void onDestroy() {}
  
  public void queryRoomList(List<SwitchRoomInfo> paramList, int paramInt1, int paramInt2, RoomSwitchInterface.IRoomList paramIRoomList)
  {
    int k = 5;
    int j = 0;
    this.jdField_a_of_type_ComTencentIlivesdkServiceRoomSwitchServiceAdapter.getLogger().i("RoomSwitchCgiService", "index = " + paramInt2, new Object[0]);
    JSONObject localJSONObject = new JSONObject();
    SwitchRoomInfo localSwitchRoomInfo1 = a(paramList, paramInt2 - 1);
    SwitchRoomInfo localSwitchRoomInfo2 = a(paramList, paramInt2);
    a(paramList, paramInt2 + 1);
    int i;
    LoginResult localLoginResult;
    LoginRequest localLoginRequest;
    switch (paramInt1)
    {
    default: 
      i = k;
      AegisHelper.b(String.format("direction = %d, index = %d, count = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) }), "RoomSwitchCgiService");
      localLoginResult = LoginManager.a.a();
      localLoginRequest = LoginManager.a.a();
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("apn", b(NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext)));
        localJSONObject.put("location", "");
        localJSONObject.put("from_id", BusinessManager.a.a().jdField_d_of_type_JavaLangString);
        if (DeviceUtils.a() == null) {
          continue;
        }
        localObject = DeviceUtils.a();
        localJSONObject.put("client_build", localObject);
        if (localLoginResult != null) {
          continue;
        }
        paramInt2 = 0;
        localJSONObject.put("token_type", a(paramInt2));
        if (localLoginResult != null) {
          continue;
        }
        localObject = "";
        localJSONObject.put("token", localObject);
        if (localLoginResult != null) {
          continue;
        }
        paramInt2 = j;
        localJSONObject.put("app_id_type", c(paramInt2));
        if (localLoginResult != null) {
          continue;
        }
        localObject = "";
        localJSONObject.put("app_uid", localObject);
        localJSONObject.put("app_version", String.valueOf(DeviceUtils.a()));
        if (localLoginRequest != null) {
          continue;
        }
        localObject = "";
        localJSONObject.put("open_appId", localObject);
        localJSONObject.put("original_qq", Long.valueOf(BusinessManager.a.a().e));
        if (paramInt1 != 0) {
          continue;
        }
        localJSONObject.put("old_content_list", a(null, localSwitchRoomInfo2));
        this.jdField_a_of_type_ComTencentIlivesdkServiceRoomSwitchServiceAdapter.getLogger().i("RoomSwitchCgiService", "count = " + i, new Object[0]);
        localJSONObject.put("count", i);
        localJSONObject.put("device_id", DeviceUtils.a(this.jdField_a_of_type_AndroidContentContext));
      }
      catch (JSONException localJSONException)
      {
        Object localObject;
        localJSONException.printStackTrace();
        continue;
      }
      localObject = new HashMap();
      ((Map)localObject).put("Referer", "https://kd.ilive.qq.com/" + BusinessManager.a.a().jdField_d_of_type_Int);
      HttpsFactory.a().a(this.jdField_d_of_type_JavaLangString, (Map)localObject, localJSONObject, new KandianRoomSwitchService.1(this, paramList, paramInt1, paramIRoomList), CookieHelper.a());
      return;
      i = k;
      if (localSwitchRoomInfo2 == null) {
        break;
      }
      i = k;
      if (paramList.size() <= 1) {
        break;
      }
      localSwitchRoomInfo2.extData.putInt("watch_sec", 30);
      i = k;
      break;
      i = 0;
      break;
      i = k;
      if (localSwitchRoomInfo2 == null) {
        break;
      }
      i = localSwitchRoomInfo2.extData.getInt("count");
      this.jdField_a_of_type_ComTencentIlivesdkServiceRoomSwitchServiceAdapter.getLogger().i("RoomSwitchCgiService", "current roomid = " + localSwitchRoomInfo2.roomId, new Object[0]);
      this.jdField_a_of_type_ComTencentIlivesdkServiceRoomSwitchServiceAdapter.getLogger().i("RoomSwitchCgiService", "current vid = " + localSwitchRoomInfo2.videoId, new Object[0]);
      break;
      localObject = "";
      continue;
      paramInt2 = localLoginResult.jdField_a_of_type_Int;
      continue;
      localObject = localLoginResult.jdField_b_of_type_JavaLangString;
      continue;
      paramInt2 = localLoginResult.jdField_a_of_type_Int;
      continue;
      localObject = localLoginResult.jdField_a_of_type_JavaLangString;
      continue;
      localObject = Integer.valueOf(Integer.parseInt(localLoginRequest.appid));
      continue;
      localJSONObject.put("old_content_list", a(localSwitchRoomInfo1, localSwitchRoomInfo2));
    }
  }
  
  public void setQueryRoomListTrigger(RoomSwitchInterface.QueryRoomListTrigger paramQueryRoomListTrigger)
  {
    this.jdField_a_of_type_ComTencentIlivesdkRoomswitchservice_interfaceRoomSwitchInterface$QueryRoomListTrigger = paramQueryRoomListTrigger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.customized.services.rommswitch.KandianRoomSwitchService
 * JD-Core Version:    0.7.0.1
 */