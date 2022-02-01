package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.room;

import android.content.Context;
import android.os.Bundle;
import com.tencent.beacon.event.UserAction;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.http.HttpResponse;
import com.tencent.ilivesdk.roomservice_interface.EnterExitRoomCallback;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceAdapter;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveMediaInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveRoomInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveWatchMediaInfo;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.utils.CookieHelper;
import com.tencent.mobileqq.litelivesdk.utils.https.HttpsFactory;
import com.tencent.mobileqq.litelivesdk.utils.https.HttpsInterface;
import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import com.tencent.mobileqq.litelivesdk.utils.log.LogInterface;
import com.tencent.mobileqq.litelivesdk.utils.room.RoomUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbstractCustomRoomService
  implements RoomServiceInterface
{
  public RoomServiceAdapter a;
  public EnterRoomInfo a;
  public LiveInfo a;
  private ConcurrentHashMap<Long, EnterExitRoomCallback> a;
  protected boolean a;
  
  public AbstractCustomRoomService()
  {
    this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceModelLiveInfo = new LiveInfo();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  protected abstract String a();
  
  protected void a()
  {
    HashMap localHashMap;
    if (BusinessManager.a.b())
    {
      localHashMap = new HashMap();
      localHashMap.put("appid", "1014");
      localHashMap.put("act_type", "start_video_url");
      localHashMap.put("fromid", BusinessManager.a.b());
      localHashMap.put("userid", BusinessManager.a.a());
      if (!BusinessManager.a.c()) {
        break label125;
      }
    }
    label125:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("zt_int4", str);
      localHashMap.put("zt_int5", BusinessManager.a.c());
      UserAction.onUserActionToTunnel("00000MEVUX3CBYO1", "start_video_url#room_page#room", true, -1L, -1L, localHashMap, true, true);
      return;
    }
  }
  
  public void a(long paramLong)
  {
    HashMap localHashMap;
    if (BusinessManager.a.b())
    {
      localHashMap = new HashMap();
      localHashMap.put("appid", "1014");
      localHashMap.put("act_type", "end_video_url");
      localHashMap.put("timelong", String.valueOf(paramLong));
      localHashMap.put("fromid", BusinessManager.a.b());
      localHashMap.put("userid", BusinessManager.a.a());
      if (!BusinessManager.a.c()) {
        break label147;
      }
    }
    label147:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("zt_int4", str);
      localHashMap.put("zt_int5", BusinessManager.a.c());
      UserAction.onUserActionToTunnel("00000MEVUX3CBYO1", "end_video_url#room_page#room", true, -1L, -1L, localHashMap, true, true);
      return;
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    HashMap localHashMap;
    if (BusinessManager.a.b())
    {
      localHashMap = new HashMap();
      localHashMap.put("appid", "1014");
      localHashMap.put("act_type", "fail_video_url");
      localHashMap.put("timelong", String.valueOf(paramLong));
      localHashMap.put("fromid", BusinessManager.a.b());
      localHashMap.put("userid", BusinessManager.a.a());
      localHashMap.put("zt_int3", String.valueOf(paramInt));
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      localHashMap.put("zt_str3", str);
      if (!BusinessManager.a.c()) {
        break label188;
      }
    }
    label188:
    for (paramString = "1";; paramString = "0")
    {
      localHashMap.put("zt_int4", paramString);
      localHashMap.put("zt_int5", BusinessManager.a.c());
      UserAction.onUserActionToTunnel("00000MEVUX3CBYO1", "fail_video_url#room_page#room", true, -1L, -1L, localHashMap, true, true);
      return;
    }
  }
  
  public void anchorEnterRoom(EnterRoomInfo paramEnterRoomInfo, EnterExitRoomCallback paramEnterExitRoomCallback)
  {
    if (paramEnterExitRoomCallback != null) {
      paramEnterExitRoomCallback.onSuccess();
    }
  }
  
  protected abstract String b();
  
  protected abstract String c();
  
  public void clearEventOutput()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  protected abstract String d();
  
  protected abstract String e();
  
  public void exitRoom(EnterExitRoomCallback paramEnterExitRoomCallback)
  {
    if (paramEnterExitRoomCallback != null) {
      paramEnterExitRoomCallback.onSuccess();
    }
  }
  
  protected abstract String f();
  
  protected abstract String g();
  
  public EnterRoomInfo getEnterRoomInfo()
  {
    return this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceModelEnterRoomInfo;
  }
  
  public LiveInfo getLiveInfo()
  {
    return this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceModelLiveInfo;
  }
  
  public void init(RoomServiceAdapter paramRoomServiceAdapter)
  {
    this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceRoomServiceAdapter = paramRoomServiceAdapter;
    this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceModelLiveInfo.anchorInfo = new LiveAnchorInfo();
    this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceModelLiveInfo.mediaInfo = new LiveMediaInfo();
    this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceModelLiveInfo.roomInfo = new LiveRoomInfo();
    this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceModelLiveInfo.tlvInfos = new ArrayList();
    this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceModelLiveInfo.watchMediaInfo = new LiveWatchMediaInfo();
    this.jdField_a_of_type_Boolean = paramRoomServiceAdapter.getAppInfo().isSvrTestEnv();
  }
  
  public void onCreate(Context paramContext) {}
  
  public void onDestroy()
  {
    clearEventOutput();
  }
  
  public void watchEnterRoom(EnterRoomInfo paramEnterRoomInfo, EnterExitRoomCallback paramEnterExitRoomCallback)
  {
    this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceModelEnterRoomInfo = paramEnterRoomInfo;
    Object localObject1 = paramEnterRoomInfo.extData;
    int i = ((Bundle)localObject1).getInt("content_type");
    LogFactory.a().c("AbstractCustomRoomService", "----------watchEnterRoom contentType " + i);
    HashMap localHashMap = new HashMap();
    localHashMap.put("Referer", g());
    long l1 = System.currentTimeMillis();
    a();
    Object localObject2;
    if (RoomUtil.b(i))
    {
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("room_id", String.valueOf(paramEnterRoomInfo.roomId));
        HttpsInterface localHttpsInterface = HttpsFactory.a();
        if (this.jdField_a_of_type_Boolean) {}
        for (localObject1 = b();; localObject1 = a())
        {
          localHttpsInterface.a((String)localObject1, localHashMap, (JSONObject)localObject2, new AbstractCustomRoomService.1(this, paramEnterExitRoomCallback, l1, paramEnterRoomInfo), CookieHelper.a());
          return;
        }
        if (!RoomUtil.c(i)) {
          break label339;
        }
      }
      catch (Exception paramEnterRoomInfo)
      {
        paramEnterRoomInfo.printStackTrace();
        a(System.currentTimeMillis() - l1, -2, paramEnterRoomInfo.getMessage());
        return;
      }
    }
    else
    {
      paramEnterRoomInfo = paramEnterRoomInfo.extData.getString("vid");
      localObject1 = new AbstractCustomRoomService.2(this, l1);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(((HttpCallbacker)localObject1).a()), paramEnterExitRoomCallback);
      localHashMap.put("cookie", CookieHelper.a());
      paramEnterExitRoomCallback = this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceRoomServiceAdapter.getHttpInterface();
      if (this.jdField_a_of_type_Boolean) {}
      for (paramEnterRoomInfo = d() + "?vid=" + paramEnterRoomInfo;; paramEnterRoomInfo = c() + "?vid=" + paramEnterRoomInfo)
      {
        paramEnterExitRoomCallback.get(paramEnterRoomInfo, localHashMap, (HttpResponse)localObject1);
        return;
      }
    }
    label339:
    if (RoomUtil.a(i))
    {
      long l2 = paramEnterRoomInfo.roomId;
      paramEnterRoomInfo = ((Bundle)localObject1).getString("topicTime");
      localObject1 = new AbstractCustomRoomService.3(this, l1);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(((HttpCallbacker)localObject1).a()), paramEnterExitRoomCallback);
      for (;;)
      {
        try
        {
          paramEnterExitRoomCallback = new JSONObject();
          paramEnterExitRoomCallback.put("room_id", String.valueOf(l2));
          paramEnterExitRoomCallback.put("start_ts", paramEnterRoomInfo);
          localObject2 = HttpsFactory.a();
          if (this.jdField_a_of_type_Boolean)
          {
            paramEnterRoomInfo = f();
            ((HttpsInterface)localObject2).a(paramEnterRoomInfo, localHashMap, paramEnterExitRoomCallback, new AbstractCustomRoomService.4(this, (HttpCallbacker)localObject1), CookieHelper.a());
            return;
          }
        }
        catch (JSONException paramEnterRoomInfo)
        {
          paramEnterRoomInfo.printStackTrace();
          a(System.currentTimeMillis() - l1, -2, paramEnterRoomInfo.getMessage());
          return;
        }
        paramEnterRoomInfo = e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.room.AbstractCustomRoomService
 * JD-Core Version:    0.7.0.1
 */