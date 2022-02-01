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
  final int a = 0;
  final int b = 1;
  final int c = 2;
  private RoomSwitchServiceAdapter d;
  private Context e;
  private String f = "https://kd.ilive.qq.com/";
  private String g = "https://fastest.kd.ilive.qq.com/";
  private String h = "cgi-bin/info_flow/rcmd/rcmd_list";
  private String i;
  private RoomSwitchInterface.QueryRoomListTrigger j;
  
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
    this.d.getLogger().i("RoomSwitchCgiService", String.format("roomList size = %d , switchRoomInfos size = %d", new Object[] { Integer.valueOf(paramList1.size()), Integer.valueOf(paramList2.size()) }), new Object[0]);
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    Object localObject;
    int n;
    for (int m = 0; k < paramList1.size(); m = n)
    {
      localObject = ((SwitchRoomInfo)paramList1.get(k)).extData;
      if (((Bundle)localObject).getBoolean("read"))
      {
        localArrayList.add(paramList1.get(k));
      }
      else
      {
        n = m;
        if (!((Bundle)localObject).getBoolean("is_preload")) {
          break label166;
        }
        n = m;
        if (paramInt == 0) {
          break label166;
        }
        localArrayList.add(paramList1.get(k));
      }
      n = k;
      label166:
      k += 1;
    }
    this.d.getLogger().i("RoomSwitchCgiService", String.format("isReadIndex = %d", new Object[] { Integer.valueOf(m) }), new Object[0]);
    k = 0;
    while (k < paramList2.size())
    {
      localObject = (SwitchRoomInfo)paramList2.get(k);
      n = 0;
      while ((n <= m) && (n < paramList1.size()))
      {
        if (b((SwitchRoomInfo)paramList1.get(n), (SwitchRoomInfo)localObject))
        {
          bool = true;
          break label302;
        }
        n += 1;
      }
      boolean bool = false;
      label302:
      LogInterface localLogInterface = this.d.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isDuplicate = ");
      localStringBuilder.append(bool);
      localLogInterface.i("RoomSwitchCgiService", localStringBuilder.toString(), new Object[0]);
      if (!bool) {
        localArrayList.add(localObject);
      }
      k += 1;
    }
    if (paramInt == 0)
    {
      paramList1 = null;
      paramInt = m + 1;
      if (paramInt < localArrayList.size()) {
        paramList1 = (SwitchRoomInfo)localArrayList.get(paramInt);
      }
      if (paramList1 != null) {
        paramList1.extData.putBoolean("force_update", true);
      }
    }
    paramList1 = this.d.getLogger();
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
      int k;
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("content_list");
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("content_list size = ");
        ((StringBuilder)localObject1).append(paramJSONObject.length());
        AegisHelper.b(((StringBuilder)localObject1).toString(), "RoomSwitchCgiService");
        localObject1 = new ArrayList();
        k = 0;
        if (k < paramJSONObject.length())
        {
          Object localObject2 = (JSONObject)paramJSONObject.get(k);
          int m = ((JSONObject)localObject2).getInt("content_type");
          String str2 = ((JSONObject)localObject2).getJSONObject("ext").getString("ab_token");
          String str1 = ((JSONObject)localObject2).getString("cover_url");
          SwitchRoomInfo localSwitchRoomInfo = new SwitchRoomInfo();
          Bundle localBundle = new Bundle();
          localSwitchRoomInfo.extData = localBundle;
          localSwitchRoomInfo.logoUrl = str1;
          localBundle.putInt("content_type", m);
          localBundle.putString("ab_token", str2);
          if (RoomUtil.b(m))
          {
            localSwitchRoomInfo.roomId = ((JSONObject)localObject2).getLong("room_id");
            localObject2 = ((JSONObject)localObject2).getJSONArray("rtmp_url");
            localSwitchRoomInfo.videoType = VideoType.LIVE;
            if (((JSONArray)localObject2).length() != 0)
            {
              localSwitchRoomInfo.videoUrl = ((String)((JSONArray)localObject2).get(0));
              ((List)localObject1).add(localSwitchRoomInfo);
            }
          }
          else
          {
            str1 = ((JSONObject)localObject2).getString("vid");
            localSwitchRoomInfo.videoType = VideoType.VIDEO;
            localSwitchRoomInfo.videoId = str1;
            localBundle.putString("vid", str1);
            localSwitchRoomInfo.videoUrl = ((JSONObject)localObject2).getString("adr_play_url");
            ((List)localObject1).add(localSwitchRoomInfo);
          }
        }
        else
        {
          paramJSONObject = null;
          if (((List)localObject1).size() == 0) {
            throw new NullPointerException();
          }
          paramList = a(paramList, (List)localObject1, paramInt);
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
      k += 1;
    }
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
  
  private boolean b(SwitchRoomInfo paramSwitchRoomInfo1, SwitchRoomInfo paramSwitchRoomInfo2)
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
    this.d = paramRoomSwitchServiceAdapter;
  }
  
  public void clearEventOutput() {}
  
  public boolean closeRoomSwitch()
  {
    return false;
  }
  
  public RoomSwitchInterface.QueryRoomListTrigger getQueryRoomListTrigger()
  {
    return this.j;
  }
  
  public void onCreate(Context paramContext)
  {
    this.e = paramContext;
    StringBuilder localStringBuilder = new StringBuilder();
    if (((HostProxyInterface)BizEngineMgr.getInstance().getLiveEngine().getService(HostProxyInterface.class)).getSdkInfoInterface().isTestEnv()) {
      paramContext = this.g;
    } else {
      paramContext = this.f;
    }
    localStringBuilder.append(paramContext);
    localStringBuilder.append(this.h);
    this.i = localStringBuilder.toString();
  }
  
  public void onDestroy() {}
  
  public void queryRoomList(List<SwitchRoomInfo> paramList, int paramInt1, int paramInt2, RoomSwitchInterface.IRoomList paramIRoomList)
  {
    Object localObject4 = "";
    Object localObject1 = this.d.getLogger();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("index = ");
    ((StringBuilder)localObject2).append(paramInt2);
    ((LogInterface)localObject1).i("RoomSwitchCgiService", ((StringBuilder)localObject2).toString(), new Object[0]);
    localObject1 = new JSONObject();
    SwitchRoomInfo localSwitchRoomInfo1 = a(paramList, paramInt2 - 1);
    SwitchRoomInfo localSwitchRoomInfo2 = a(paramList, paramInt2);
    a(paramList, paramInt2 + 1);
    int m = 5;
    int k;
    Object localObject5;
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2) {}
        while (localSwitchRoomInfo2 == null)
        {
          k = m;
          break;
        }
        k = localSwitchRoomInfo2.extData.getInt("count");
        localObject2 = this.d.getLogger();
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("current roomid = ");
        ((StringBuilder)localObject5).append(localSwitchRoomInfo2.roomId);
        ((LogInterface)localObject2).i("RoomSwitchCgiService", ((StringBuilder)localObject5).toString(), new Object[0]);
        localObject2 = this.d.getLogger();
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("current vid = ");
        ((StringBuilder)localObject5).append(localSwitchRoomInfo2.videoId);
        ((LogInterface)localObject2).i("RoomSwitchCgiService", ((StringBuilder)localObject5).toString(), new Object[0]);
      }
      else
      {
        k = 0;
      }
    }
    else
    {
      k = m;
      if (localSwitchRoomInfo2 != null)
      {
        k = m;
        if (paramList.size() > 1)
        {
          localSwitchRoomInfo2.extData.putInt("watch_sec", 30);
          k = m;
        }
      }
    }
    AegisHelper.b(String.format("direction = %d, index = %d, count = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(k) }), "RoomSwitchCgiService");
    LoginResult localLoginResult = LoginManager.c.c();
    LoginRequest localLoginRequest = LoginManager.c.d();
    for (;;)
    {
      try
      {
        localObject2 = b(NetworkUtil.a(this.e));
        localObject5 = localObject1;
        try
        {
          ((JSONObject)localObject5).put("apn", localObject2);
          ((JSONObject)localObject5).put("location", "");
          ((JSONObject)localObject5).put("from_id", BusinessManager.a.b().i);
          if (DeviceUtils.a() == null) {
            break label850;
          }
          localObject2 = DeviceUtils.a();
          ((JSONObject)localObject5).put("client_build", localObject2);
          if (localLoginResult == null) {
            paramInt2 = 0;
          } else {
            paramInt2 = localLoginResult.i;
          }
          ((JSONObject)localObject5).put("token_type", a(paramInt2));
          if (localLoginResult == null) {
            localObject2 = "";
          } else {
            localObject2 = localLoginResult.b;
          }
          ((JSONObject)localObject5).put("token", localObject2);
          if (localLoginResult == null) {
            paramInt2 = 0;
          } else {
            paramInt2 = localLoginResult.i;
          }
          ((JSONObject)localObject5).put("app_id_type", c(paramInt2));
          if (localLoginResult == null) {
            localObject2 = "";
          } else {
            localObject2 = localLoginResult.a;
          }
          ((JSONObject)localObject5).put("app_uid", localObject2);
          ((JSONObject)localObject5).put("app_version", String.valueOf(DeviceUtils.b()));
          if (localLoginRequest == null) {
            localObject2 = localObject4;
          } else {
            localObject2 = Integer.valueOf(Integer.parseInt(localLoginRequest.appid));
          }
          ((JSONObject)localObject5).put("open_appId", localObject2);
          ((JSONObject)localObject5).put("original_qq", Long.valueOf(BusinessManager.a.b().j));
          if (paramInt1 == 0) {
            ((JSONObject)localObject5).put("old_content_list", a(null, localSwitchRoomInfo2));
          } else {
            ((JSONObject)localObject5).put("old_content_list", a(localSwitchRoomInfo1, localSwitchRoomInfo2));
          }
          localObject2 = this.d.getLogger();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("count = ");
          ((StringBuilder)localObject4).append(k);
          ((LogInterface)localObject2).i("RoomSwitchCgiService", ((StringBuilder)localObject4).toString(), new Object[0]);
          ((JSONObject)localObject5).put("count", k);
          ((JSONObject)localObject5).put("device_id", DeviceUtils.a(this.e));
        }
        catch (JSONException localJSONException1) {}
        localJSONException2.printStackTrace();
      }
      catch (JSONException localJSONException2) {}
      Object localObject3 = new HashMap();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("https://kd.ilive.qq.com/");
      ((StringBuilder)localObject4).append(BusinessManager.a.b().f);
      ((Map)localObject3).put("Referer", ((StringBuilder)localObject4).toString());
      HttpsFactory.a().a(this.i, (Map)localObject3, (JSONObject)localObject1, new KandianRoomSwitchService.1(this, paramList, paramInt1, paramIRoomList), CookieHelper.a());
      return;
      label850:
      localObject3 = "";
    }
  }
  
  public void setQueryRoomListTrigger(RoomSwitchInterface.QueryRoomListTrigger paramQueryRoomListTrigger)
  {
    this.j = paramQueryRoomListTrigger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.customized.services.rommswitch.KandianRoomSwitchService
 * JD-Core Version:    0.7.0.1
 */