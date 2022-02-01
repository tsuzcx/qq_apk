package com.tencent.mobileqq.intervideo.lite_now_biz.now_live.services;

import android.content.Context;
import android.os.Bundle;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.hostproxy.SdkInfoInterface;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface.IRoomList;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface.QueryRoomListTrigger;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.VideoType;
import com.tencent.ilivesdk.service.RoomSwitchServiceAdapter;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.mobileqq.intervideo.lite_now_biz.config.NowBizConfigConst;
import com.tencent.mobileqq.intervideo.lite_now_biz.now_live.NowWebCookieManager;
import com.tencent.mobileqq.litelivesdk.framework.room.RoomManager;
import com.tencent.mobileqq.litelivesdk.utils.CookieHelper;
import com.tencent.mobileqq.litelivesdk.utils.DeviceUtils;
import com.tencent.mobileqq.litelivesdk.utils.https.HttpsFactory;
import com.tencent.mobileqq.litelivesdk.utils.https.HttpsInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NowRoomSwitchService
  implements RoomSwitchInterface
{
  private Context a;
  private String b;
  private RoomSwitchServiceAdapter c;
  private LogInterface d;
  
  private long a(SwitchRoomInfo paramSwitchRoomInfo1, SwitchRoomInfo paramSwitchRoomInfo2, SwitchRoomInfo paramSwitchRoomInfo3, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        if (paramInt != 2) {
          paramSwitchRoomInfo1 = paramSwitchRoomInfo2;
        } else {
          paramSwitchRoomInfo1 = paramSwitchRoomInfo3;
        }
      }
    }
    else {
      paramSwitchRoomInfo1 = null;
    }
    if (paramSwitchRoomInfo1 != null) {
      return paramSwitchRoomInfo1.roomId;
    }
    return 0L;
  }
  
  private SwitchRoomInfo a(List<SwitchRoomInfo> paramList, int paramInt)
  {
    if ((paramList != null) && (paramInt >= 0) && (paramInt < paramList.size())) {
      return (SwitchRoomInfo)paramList.get(paramInt);
    }
    return null;
  }
  
  private List<SwitchRoomInfo> a(List<SwitchRoomInfo> paramList1, List<SwitchRoomInfo> paramList2)
  {
    Object localObject = paramList2.iterator();
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        break label83;
      }
      SwitchRoomInfo localSwitchRoomInfo1 = (SwitchRoomInfo)((Iterator)localObject).next();
      Iterator localIterator = paramList1.iterator();
      if (localIterator.hasNext())
      {
        SwitchRoomInfo localSwitchRoomInfo2 = (SwitchRoomInfo)localIterator.next();
        if (localSwitchRoomInfo1.roomId != localSwitchRoomInfo2.roomId) {
          break;
        }
        paramList1.remove(localSwitchRoomInfo2);
      }
    }
    label83:
    localObject = new ArrayList();
    ((List)localObject).addAll(paramList1);
    ((List)localObject).addAll(paramList2);
    return localObject;
  }
  
  private List<SwitchRoomInfo> a(JSONObject paramJSONObject)
  {
    localArrayList = new ArrayList();
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("result").getJSONArray("room_list");
      int i = 0;
      Object localObject1;
      Object localObject2;
      while (i < paramJSONObject.length())
      {
        localObject1 = (JSONObject)paramJSONObject.get(i);
        long l = ((JSONObject)localObject1).getLong("room_id");
        localObject1 = ((JSONObject)localObject1).getString("url");
        localObject2 = new SwitchRoomInfo();
        ((SwitchRoomInfo)localObject2).roomId = l;
        ((SwitchRoomInfo)localObject2).logoUrl = ((String)localObject1);
        ((SwitchRoomInfo)localObject2).videoType = VideoType.LIVE;
        ((SwitchRoomInfo)localObject2).extData = new Bundle();
        ((SwitchRoomInfo)localObject2).extData.putInt("content_type", 1);
        localArrayList.add(localObject2);
        a((SwitchRoomInfo)localObject2);
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException paramJSONObject)
    {
      localObject1 = this.c.getLogger();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(paramJSONObject);
      ((LogInterface)localObject1).e("NowRoomSwitchService", ((StringBuilder)localObject2).toString(), new Object[0]);
    }
  }
  
  private Map<String, String> a(List<SwitchRoomInfo> paramList, int paramInt1, int paramInt2)
  {
    Object localObject = a(paramList, 0);
    SwitchRoomInfo localSwitchRoomInfo1 = a(paramList, paramInt2);
    SwitchRoomInfo localSwitchRoomInfo2 = a(paramList, paramList.size() - 1);
    String str1 = "";
    if ((localSwitchRoomInfo1 != null) && (localSwitchRoomInfo1.extData != null)) {
      paramList = localSwitchRoomInfo1.extData.getString("mqqschema");
    } else {
      paramList = "";
    }
    paramList = (String)RoomManager.a(paramList).get("fromid");
    int j = NowBizConfigConst.a(paramList);
    String str2 = NowBizConfigConst.b(paramList);
    int i;
    if (paramInt1 == 1) {
      i = 0;
    } else {
      i = 10;
    }
    String str3 = String.format(Locale.ENGLISH, "%d_%s_%d_%s", new Object[] { Integer.valueOf(j), str2, Integer.valueOf(paramInt2), Integer.valueOf(i) });
    long l = a((SwitchRoomInfo)localObject, localSwitchRoomInfo1, localSwitchRoomInfo2, paramInt1);
    localObject = new HashMap();
    if (j == 5)
    {
      ((Map)localObject).put("story_topic", str3);
      ((Map)localObject).put("topic_name", str2);
    }
    ((Map)localObject).put("from_id", paramList);
    ((Map)localObject).put("ext", str2);
    ((Map)localObject).put("source", String.valueOf(j));
    if (paramInt1 == 0) {
      paramList = String.valueOf(2);
    } else {
      paramList = String.valueOf(paramInt1);
    }
    ((Map)localObject).put("direction", paramList);
    if (localSwitchRoomInfo1 == null) {
      paramList = str1;
    } else {
      paramList = String.valueOf(localSwitchRoomInfo1.roomId);
    }
    ((Map)localObject).put("room_id", paramList);
    ((Map)localObject).put("next_room_id", String.valueOf(l));
    ((Map)localObject).put("sex", "2");
    ((Map)localObject).put("machine_code", DeviceUtils.a(this.a));
    ((Map)localObject).put("biz_version", "100");
    return localObject;
  }
  
  private void a(SwitchRoomInfo paramSwitchRoomInfo)
  {
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("room_id", String.valueOf(paramSwitchRoomInfo.roomId));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localJSONObject2 = null;
    }
    HashMap localHashMap = new HashMap();
    HttpsInterface localHttpsInterface = HttpsFactory.a();
    String str;
    if (a()) {
      str = "https://test.ilive.qq.com/cgi-bin/core/room_video/get_video_streaming";
    } else {
      str = "https://ilive.qq.com/cgi-bin/core/room_video/get_video_streaming";
    }
    localHttpsInterface.a(str, localHashMap, localJSONObject2, new NowRoomSwitchService.2(this, paramSwitchRoomInfo), CookieHelper.a());
  }
  
  private boolean a()
  {
    return ((HostProxyInterface)BizEngineMgr.getInstance().getLiveEngine().getService(HostProxyInterface.class)).getSdkInfoInterface().isTestEnv();
  }
  
  private Map<String, String> b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("referer", "https://now.qq.com/");
    localHashMap.put("user-agent", "TencentConnect");
    localHashMap.put("cookie", NowWebCookieManager.a());
    return localHashMap;
  }
  
  public void a(RoomSwitchServiceAdapter paramRoomSwitchServiceAdapter)
  {
    this.c = paramRoomSwitchServiceAdapter;
    this.d = paramRoomSwitchServiceAdapter.getLogger();
  }
  
  public void clearEventOutput() {}
  
  public boolean closeRoomSwitch()
  {
    return false;
  }
  
  public RoomSwitchInterface.QueryRoomListTrigger getQueryRoomListTrigger()
  {
    return null;
  }
  
  public void onCreate(Context paramContext)
  {
    this.a = paramContext;
    StringBuilder localStringBuilder = new StringBuilder();
    if (a()) {
      paramContext = "https://fastest.now.qq.com/";
    } else {
      paramContext = "https://now.qq.com/";
    }
    localStringBuilder.append(paramContext);
    localStringBuilder.append("cgi-bin/now/web/room/room_switch");
    this.b = localStringBuilder.toString();
  }
  
  public void onDestroy() {}
  
  public void queryRoomList(List<SwitchRoomInfo> paramList, int paramInt1, int paramInt2, RoomSwitchInterface.IRoomList paramIRoomList)
  {
    this.d.i("NowLiteRoomSwitchService", "queryRoomList direction[%d],  index[%d] ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1) {
      return;
    }
    if (((paramInt1 == 2) || (paramInt1 == 0)) && (paramList.size() - paramInt2 > 3)) {
      return;
    }
    Map localMap = a(paramList, paramInt1, paramInt2);
    this.c.getHttpInterface().post(this.b, b(), localMap, new NowRoomSwitchService.1(this, paramList, paramIRoomList));
  }
  
  public void setQueryRoomListTrigger(RoomSwitchInterface.QueryRoomListTrigger paramQueryRoomListTrigger) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_live.services.NowRoomSwitchService
 * JD-Core Version:    0.7.0.1
 */