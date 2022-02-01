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
import java.util.List<Lcom.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;>;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NowRoomSwitchService
  implements RoomSwitchInterface
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LogInterface jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface;
  private RoomSwitchServiceAdapter jdField_a_of_type_ComTencentIlivesdkServiceRoomSwitchServiceAdapter;
  private String jdField_a_of_type_JavaLangString;
  
  private long a(SwitchRoomInfo paramSwitchRoomInfo1, SwitchRoomInfo paramSwitchRoomInfo2, SwitchRoomInfo paramSwitchRoomInfo3, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramSwitchRoomInfo1 = paramSwitchRoomInfo2;
    }
    while (paramSwitchRoomInfo1 != null)
    {
      return paramSwitchRoomInfo1.roomId;
      paramSwitchRoomInfo1 = null;
      continue;
      paramSwitchRoomInfo1 = paramSwitchRoomInfo3;
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
      while (i < paramJSONObject.length())
      {
        Object localObject = (JSONObject)paramJSONObject.get(i);
        long l = ((JSONObject)localObject).getLong("room_id");
        localObject = ((JSONObject)localObject).getString("url");
        SwitchRoomInfo localSwitchRoomInfo = new SwitchRoomInfo();
        localSwitchRoomInfo.roomId = l;
        localSwitchRoomInfo.logoUrl = ((String)localObject);
        localSwitchRoomInfo.videoType = VideoType.LIVE;
        localSwitchRoomInfo.extData = new Bundle();
        localSwitchRoomInfo.extData.putInt("content_type", 1);
        localArrayList.add(localSwitchRoomInfo);
        a(localSwitchRoomInfo);
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException paramJSONObject)
    {
      this.jdField_a_of_type_ComTencentIlivesdkServiceRoomSwitchServiceAdapter.getLogger().e("NowRoomSwitchService", "" + paramJSONObject, new Object[0]);
    }
  }
  
  private Map<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("referer", "https://now.qq.com/");
    localHashMap.put("user-agent", "TencentConnect");
    localHashMap.put("cookie", NowWebCookieManager.a());
    return localHashMap;
  }
  
  private Map<String, String> a(List<SwitchRoomInfo> paramList, int paramInt1, int paramInt2)
  {
    SwitchRoomInfo localSwitchRoomInfo2 = a(paramList, 0);
    SwitchRoomInfo localSwitchRoomInfo1 = a(paramList, paramInt2);
    SwitchRoomInfo localSwitchRoomInfo3 = a(paramList, paramList.size() - 1);
    Object localObject = "";
    paramList = (List<SwitchRoomInfo>)localObject;
    if (localSwitchRoomInfo1 != null)
    {
      paramList = (List<SwitchRoomInfo>)localObject;
      if (localSwitchRoomInfo1.extData != null) {
        paramList = localSwitchRoomInfo1.extData.getString("mqqschema");
      }
    }
    paramList = (String)RoomManager.a(paramList).get("fromid");
    int j = NowBizConfigConst.a(paramList);
    String str1 = NowBizConfigConst.a(paramList);
    int i;
    long l;
    if (paramInt1 == 1)
    {
      i = 0;
      String str2 = String.format(Locale.ENGLISH, "%d_%s_%d_%s", new Object[] { Integer.valueOf(j), str1, Integer.valueOf(paramInt2), Integer.valueOf(i) });
      l = a(localSwitchRoomInfo2, localSwitchRoomInfo1, localSwitchRoomInfo3, paramInt1);
      localObject = new HashMap();
      if (j == 5)
      {
        ((Map)localObject).put("story_topic", str2);
        ((Map)localObject).put("topic_name", str1);
      }
      ((Map)localObject).put("from_id", paramList);
      ((Map)localObject).put("ext", str1);
      ((Map)localObject).put("source", String.valueOf(j));
      if (paramInt1 != 0) {
        break label344;
      }
      paramList = String.valueOf(2);
      label241:
      ((Map)localObject).put("direction", paramList);
      if (localSwitchRoomInfo1 != null) {
        break label352;
      }
    }
    label344:
    label352:
    for (paramList = "";; paramList = String.valueOf(localSwitchRoomInfo1.roomId))
    {
      ((Map)localObject).put("room_id", paramList);
      ((Map)localObject).put("next_room_id", String.valueOf(l));
      ((Map)localObject).put("sex", "2");
      ((Map)localObject).put("machine_code", DeviceUtils.a(this.jdField_a_of_type_AndroidContentContext));
      ((Map)localObject).put("biz_version", "100");
      return localObject;
      i = 10;
      break;
      paramList = String.valueOf(paramInt1);
      break label241;
    }
  }
  
  private void a(SwitchRoomInfo paramSwitchRoomInfo)
  {
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("room_id", String.valueOf(paramSwitchRoomInfo.roomId));
      HashMap localHashMap = new HashMap();
      HttpsInterface localHttpsInterface = HttpsFactory.a();
      if (a())
      {
        String str1 = "https://test.ilive.qq.com/cgi-bin/core/room_video/get_video_streaming";
        localHttpsInterface.a(str1, localHashMap, localJSONObject, new NowRoomSwitchService.2(this, paramSwitchRoomInfo), CookieHelper.a());
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        JSONObject localJSONObject = null;
        localException.printStackTrace();
        continue;
        String str2 = "https://ilive.qq.com/cgi-bin/core/room_video/get_video_streaming";
      }
    }
  }
  
  private boolean a()
  {
    return ((HostProxyInterface)BizEngineMgr.getInstance().getLiveEngine().getService(HostProxyInterface.class)).getSdkInfoInterface().isTestEnv();
  }
  
  public void a(RoomSwitchServiceAdapter paramRoomSwitchServiceAdapter)
  {
    this.jdField_a_of_type_ComTencentIlivesdkServiceRoomSwitchServiceAdapter = paramRoomSwitchServiceAdapter;
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface = paramRoomSwitchServiceAdapter.getLogger();
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
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    StringBuilder localStringBuilder = new StringBuilder();
    if (a()) {}
    for (paramContext = "https://fastest.now.qq.com/";; paramContext = "https://now.qq.com/")
    {
      this.jdField_a_of_type_JavaLangString = (paramContext + "cgi-bin/now/web/room/room_switch");
      return;
    }
  }
  
  public void onDestroy() {}
  
  public void queryRoomList(List<SwitchRoomInfo> paramList, int paramInt1, int paramInt2, RoomSwitchInterface.IRoomList paramIRoomList)
  {
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface.i("NowLiteRoomSwitchService", "queryRoomList direction[%d],  index[%d] ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1) {}
    while (((paramInt1 == 2) || (paramInt1 == 0)) && (paramList.size() - paramInt2 > 3)) {
      return;
    }
    Map localMap = a(paramList, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentIlivesdkServiceRoomSwitchServiceAdapter.getHttpInterface().post(this.jdField_a_of_type_JavaLangString, a(), localMap, new NowRoomSwitchService.1(this, paramList, paramIRoomList));
  }
  
  public void setQueryRoomListTrigger(RoomSwitchInterface.QueryRoomListTrigger paramQueryRoomListTrigger) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_live.services.NowRoomSwitchService
 * JD-Core Version:    0.7.0.1
 */