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
    if (paramInt != 2)
    {
      if (paramInt != 8)
      {
        if (paramInt != 9) {
          return "";
        }
        return "access";
      }
      return "qq_access";
    }
    return "visitor";
  }
  
  private List<SwitchRoomInfo> a(List<SwitchRoomInfo> paramList1, List<SwitchRoomInfo> paramList2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentIlivesdkServiceRoomSwitchServiceAdapter.getLogger().i("RoomSwitchCgiService", String.format("roomList size = %d , switchRoomInfos size = %d", new Object[] { Integer.valueOf(paramList1.size()), Integer.valueOf(paramList2.size()) }), new Object[0]);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Object localObject;
    int k;
    for (int j = 0; i < paramList1.size(); j = k)
    {
      localObject = ((SwitchRoomInfo)paramList1.get(i)).extData;
      if (((Bundle)localObject).getBoolean("read"))
      {
        localArrayList.add(paramList1.get(i));
      }
      else
      {
        k = j;
        if (!((Bundle)localObject).getBoolean("is_preload")) {
          break label166;
        }
        k = j;
        if (paramInt == 0) {
          break label166;
        }
        localArrayList.add(paramList1.get(i));
      }
      k = i;
      label166:
      i += 1;
    }
    this.jdField_a_of_type_ComTencentIlivesdkServiceRoomSwitchServiceAdapter.getLogger().i("RoomSwitchCgiService", String.format("isReadIndex = %d", new Object[] { Integer.valueOf(j) }), new Object[0]);
    i = 0;
    while (i < paramList2.size())
    {
      localObject = (SwitchRoomInfo)paramList2.get(i);
      k = 0;
      while ((k <= j) && (k < paramList1.size()))
      {
        if (a((SwitchRoomInfo)paramList1.get(k), (SwitchRoomInfo)localObject))
        {
          bool = true;
          break label302;
        }
        k += 1;
      }
      boolean bool = false;
      label302:
      LogInterface localLogInterface = this.jdField_a_of_type_ComTencentIlivesdkServiceRoomSwitchServiceAdapter.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isDuplicate = ");
      localStringBuilder.append(bool);
      localLogInterface.i("RoomSwitchCgiService", localStringBuilder.toString(), new Object[0]);
      if (!bool) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    if (paramInt == 0)
    {
      paramList1 = null;
      paramInt = j + 1;
      if (paramInt < localArrayList.size()) {
        paramList1 = (SwitchRoomInfo)localArrayList.get(paramInt);
      }
      if (paramList1 != null) {
        paramList1.extData.putBoolean("force_update", true);
      }
    }
    paramList1 = this.jdField_a_of_type_ComTencentIlivesdkServiceRoomSwitchServiceAdapter.getLogger();
    paramList2 = new StringBuilder();
    paramList2.append("newList size = ");
    paramList2.append(localArrayList.size());
    paramList1.i("RoomSwitchCgiService", paramList2.toString(), new Object[0]);
    return localArrayList;
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
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("content_list size = ");
        paramJSONObject.append(localJSONArray.length());
        AegisHelper.b(paramJSONObject.toString(), "RoomSwitchCgiService");
        paramJSONObject = new ArrayList();
        i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = (JSONObject)localJSONArray.get(i);
          int j = localJSONObject.getInt("content_type");
          String str2 = localJSONObject.getJSONObject("ext").getString("ab_token");
          String str1 = localJSONObject.getString("cover_url");
          SwitchRoomInfo localSwitchRoomInfo = new SwitchRoomInfo();
          Object localObject = new Bundle();
          localSwitchRoomInfo.extData = ((Bundle)localObject);
          localSwitchRoomInfo.logoUrl = str1;
          ((Bundle)localObject).putInt("content_type", j);
          ((Bundle)localObject).putString("ab_token", str2);
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
        else
        {
          localJSONArray = null;
          if (paramJSONObject.size() == 0) {
            throw new NullPointerException();
          }
          paramList = a(paramList, paramJSONObject, paramInt);
          ThreadManager.getUIHandler().post(new KandianRoomSwitchService.2(this, paramIRoomList, paramList));
          return;
        }
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
        AegisHelper.a(paramList.getMessage(), "RoomSwitchCgiService");
        return;
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
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return "";
            }
            return "unknow";
          }
          return "3g";
        }
        return "2g";
      }
      return "wifi";
    }
    return "no";
  }
  
  private static String c(int paramInt)
  {
    if (paramInt != 2)
    {
      if (paramInt != 8)
      {
        if (paramInt != 9) {
          return "";
        }
        return "weixin";
      }
      return "qq_open";
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
    if (((HostProxyInterface)BizEngineMgr.getInstance().getLiveEngine().getService(HostProxyInterface.class)).getSdkInfoInterface().isTestEnv()) {
      paramContext = this.jdField_b_of_type_JavaLangString;
    } else {
      paramContext = this.jdField_a_of_type_JavaLangString;
    }
    localStringBuilder.append(paramContext);
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    this.jdField_d_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public void onDestroy() {}
  
  public void queryRoomList(List<SwitchRoomInfo> paramList, int paramInt1, int paramInt2, RoomSwitchInterface.IRoomList paramIRoomList)
  {
    Object localObject4 = "";
    Object localObject1 = this.jdField_a_of_type_ComTencentIlivesdkServiceRoomSwitchServiceAdapter.getLogger();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("index = ");
    ((StringBuilder)localObject2).append(paramInt2);
    ((LogInterface)localObject1).i("RoomSwitchCgiService", ((StringBuilder)localObject2).toString(), new Object[0]);
    localObject1 = new JSONObject();
    SwitchRoomInfo localSwitchRoomInfo1 = a(paramList, paramInt2 - 1);
    SwitchRoomInfo localSwitchRoomInfo2 = a(paramList, paramInt2);
    a(paramList, paramInt2 + 1);
    int j = 5;
    int i;
    Object localObject5;
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2) {}
        while (localSwitchRoomInfo2 == null)
        {
          i = j;
          break;
        }
        i = localSwitchRoomInfo2.extData.getInt("count");
        localObject2 = this.jdField_a_of_type_ComTencentIlivesdkServiceRoomSwitchServiceAdapter.getLogger();
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("current roomid = ");
        ((StringBuilder)localObject5).append(localSwitchRoomInfo2.roomId);
        ((LogInterface)localObject2).i("RoomSwitchCgiService", ((StringBuilder)localObject5).toString(), new Object[0]);
        localObject2 = this.jdField_a_of_type_ComTencentIlivesdkServiceRoomSwitchServiceAdapter.getLogger();
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("current vid = ");
        ((StringBuilder)localObject5).append(localSwitchRoomInfo2.videoId);
        ((LogInterface)localObject2).i("RoomSwitchCgiService", ((StringBuilder)localObject5).toString(), new Object[0]);
      }
      else
      {
        i = 0;
      }
    }
    else
    {
      i = j;
      if (localSwitchRoomInfo2 != null)
      {
        i = j;
        if (paramList.size() > 1)
        {
          localSwitchRoomInfo2.extData.putInt("watch_sec", 30);
          i = j;
        }
      }
    }
    AegisHelper.b(String.format("direction = %d, index = %d, count = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) }), "RoomSwitchCgiService");
    LoginResult localLoginResult = LoginManager.a.a();
    LoginRequest localLoginRequest = LoginManager.a.a();
    for (;;)
    {
      try
      {
        localObject2 = b(NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext));
        localObject5 = localObject1;
        try
        {
          ((JSONObject)localObject5).put("apn", localObject2);
          ((JSONObject)localObject5).put("location", "");
          ((JSONObject)localObject5).put("from_id", BusinessManager.a.a().jdField_d_of_type_JavaLangString);
          if (DeviceUtils.a() == null) {
            break label850;
          }
          localObject2 = DeviceUtils.a();
          ((JSONObject)localObject5).put("client_build", localObject2);
          if (localLoginResult == null) {
            paramInt2 = 0;
          } else {
            paramInt2 = localLoginResult.jdField_a_of_type_Int;
          }
          ((JSONObject)localObject5).put("token_type", a(paramInt2));
          if (localLoginResult == null) {
            localObject2 = "";
          } else {
            localObject2 = localLoginResult.jdField_b_of_type_JavaLangString;
          }
          ((JSONObject)localObject5).put("token", localObject2);
          if (localLoginResult == null) {
            paramInt2 = 0;
          } else {
            paramInt2 = localLoginResult.jdField_a_of_type_Int;
          }
          ((JSONObject)localObject5).put("app_id_type", c(paramInt2));
          if (localLoginResult == null) {
            localObject2 = "";
          } else {
            localObject2 = localLoginResult.jdField_a_of_type_JavaLangString;
          }
          ((JSONObject)localObject5).put("app_uid", localObject2);
          ((JSONObject)localObject5).put("app_version", String.valueOf(DeviceUtils.a()));
          if (localLoginRequest == null) {
            localObject2 = localObject4;
          } else {
            localObject2 = Integer.valueOf(Integer.parseInt(localLoginRequest.appid));
          }
          ((JSONObject)localObject5).put("open_appId", localObject2);
          ((JSONObject)localObject5).put("original_qq", Long.valueOf(BusinessManager.a.a().e));
          if (paramInt1 == 0) {
            ((JSONObject)localObject5).put("old_content_list", a(null, localSwitchRoomInfo2));
          } else {
            ((JSONObject)localObject5).put("old_content_list", a(localSwitchRoomInfo1, localSwitchRoomInfo2));
          }
          localObject2 = this.jdField_a_of_type_ComTencentIlivesdkServiceRoomSwitchServiceAdapter.getLogger();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("count = ");
          ((StringBuilder)localObject4).append(i);
          ((LogInterface)localObject2).i("RoomSwitchCgiService", ((StringBuilder)localObject4).toString(), new Object[0]);
          ((JSONObject)localObject5).put("count", i);
          ((JSONObject)localObject5).put("device_id", DeviceUtils.a(this.jdField_a_of_type_AndroidContentContext));
        }
        catch (JSONException localJSONException1) {}
        localJSONException2.printStackTrace();
      }
      catch (JSONException localJSONException2) {}
      Object localObject3 = new HashMap();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("https://kd.ilive.qq.com/");
      ((StringBuilder)localObject4).append(BusinessManager.a.a().jdField_d_of_type_Int);
      ((Map)localObject3).put("Referer", ((StringBuilder)localObject4).toString());
      HttpsFactory.a().a(this.jdField_d_of_type_JavaLangString, (Map)localObject3, (JSONObject)localObject1, new KandianRoomSwitchService.1(this, paramList, paramInt1, paramIRoomList), CookieHelper.a());
      return;
      label850:
      localObject3 = "";
    }
  }
  
  public void setQueryRoomListTrigger(RoomSwitchInterface.QueryRoomListTrigger paramQueryRoomListTrigger)
  {
    this.jdField_a_of_type_ComTencentIlivesdkRoomswitchservice_interfaceRoomSwitchInterface$QueryRoomListTrigger = paramQueryRoomListTrigger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.customized.services.rommswitch.KandianRoomSwitchService
 * JD-Core Version:    0.7.0.1
 */