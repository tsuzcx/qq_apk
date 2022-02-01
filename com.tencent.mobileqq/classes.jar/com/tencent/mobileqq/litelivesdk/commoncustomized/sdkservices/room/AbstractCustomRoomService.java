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
  protected RoomServiceAdapter a;
  protected EnterRoomInfo a;
  protected LiveInfo a;
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
    if (BusinessManager.a.b())
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("appid", "1014");
      localHashMap.put("act_type", "start_video_url");
      localHashMap.put("fromid", BusinessManager.a.b());
      localHashMap.put("userid", BusinessManager.a.a());
      String str;
      if (BusinessManager.a.d()) {
        str = "1";
      } else {
        str = "0";
      }
      localHashMap.put("zt_int4", str);
      localHashMap.put("zt_int5", BusinessManager.a.c());
      UserAction.onUserActionToTunnel("00000MEVUX3CBYO1", "start_video_url#room_page#room", true, -1L, -1L, localHashMap, true, true);
    }
  }
  
  protected void a(long paramLong)
  {
    if (BusinessManager.a.b())
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("appid", "1014");
      localHashMap.put("act_type", "end_video_url");
      localHashMap.put("timelong", String.valueOf(paramLong));
      localHashMap.put("fromid", BusinessManager.a.b());
      localHashMap.put("userid", BusinessManager.a.a());
      String str;
      if (BusinessManager.a.d()) {
        str = "1";
      } else {
        str = "0";
      }
      localHashMap.put("zt_int4", str);
      localHashMap.put("zt_int5", BusinessManager.a.c());
      UserAction.onUserActionToTunnel("00000MEVUX3CBYO1", "end_video_url#room_page#room", true, -1L, -1L, localHashMap, true, true);
    }
  }
  
  protected void a(long paramLong, int paramInt, String paramString)
  {
    if (BusinessManager.a.b())
    {
      HashMap localHashMap = new HashMap();
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
      if (BusinessManager.a.d()) {
        paramString = "1";
      } else {
        paramString = "0";
      }
      localHashMap.put("zt_int4", paramString);
      localHashMap.put("zt_int5", BusinessManager.a.c());
      UserAction.onUserActionToTunnel("00000MEVUX3CBYO1", "fail_video_url#room_page#room", true, -1L, -1L, localHashMap, true, true);
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
    Object localObject2 = LogFactory.a();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("----------watchEnterRoom contentType ");
    ((StringBuilder)localObject3).append(i);
    ((LogInterface)localObject2).c("AbstractCustomRoomService", ((StringBuilder)localObject3).toString());
    localObject2 = new HashMap();
    ((Map)localObject2).put("Referer", g());
    long l1 = System.currentTimeMillis();
    a();
    Object localObject4;
    if (RoomUtil.b(i))
    {
      try
      {
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("room_id", String.valueOf(paramEnterRoomInfo.roomId));
        localObject4 = HttpsFactory.a();
        if (this.jdField_a_of_type_Boolean) {
          localObject1 = b();
        } else {
          localObject1 = a();
        }
        paramEnterRoomInfo = new AbstractCustomRoomService.1(this, paramEnterExitRoomCallback, l1, paramEnterRoomInfo);
        paramEnterExitRoomCallback = CookieHelper.a();
        try
        {
          ((HttpsInterface)localObject4).a((String)localObject1, (Map)localObject2, (JSONObject)localObject3, paramEnterRoomInfo, paramEnterExitRoomCallback);
          return;
        }
        catch (Exception paramEnterRoomInfo) {}
        paramEnterRoomInfo.printStackTrace();
      }
      catch (Exception paramEnterRoomInfo) {}
      a(System.currentTimeMillis() - l1, -2, paramEnterRoomInfo.getMessage());
      return;
    }
    if (RoomUtil.c(i))
    {
      localObject1 = paramEnterRoomInfo.extData.getString("vid");
      localObject3 = new AbstractCustomRoomService.2(this, l1);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(((HttpCallbacker)localObject3).a()), paramEnterExitRoomCallback);
      ((Map)localObject2).put("cookie", CookieHelper.a());
      localObject4 = this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceRoomServiceAdapter.getHttpInterface();
      if (this.jdField_a_of_type_Boolean)
      {
        paramEnterRoomInfo = new StringBuilder();
        paramEnterExitRoomCallback = d();
      }
      else
      {
        paramEnterRoomInfo = new StringBuilder();
        paramEnterExitRoomCallback = c();
      }
      paramEnterRoomInfo.append(paramEnterExitRoomCallback);
      paramEnterRoomInfo.append("?vid=");
      paramEnterRoomInfo.append((String)localObject1);
      ((HttpInterface)localObject4).get(paramEnterRoomInfo.toString(), (Map)localObject2, (HttpResponse)localObject3);
      return;
    }
    if (RoomUtil.a(i))
    {
      long l2 = paramEnterRoomInfo.roomId;
      paramEnterRoomInfo = ((Bundle)localObject1).getString("topicTime");
      localObject1 = new AbstractCustomRoomService.3(this, l1);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(((HttpCallbacker)localObject1).a()), paramEnterExitRoomCallback);
      try
      {
        paramEnterExitRoomCallback = new JSONObject();
        paramEnterExitRoomCallback.put("room_id", String.valueOf(l2));
        paramEnterExitRoomCallback.put("start_ts", paramEnterRoomInfo);
        localObject3 = HttpsFactory.a();
        if (this.jdField_a_of_type_Boolean) {
          paramEnterRoomInfo = f();
        } else {
          paramEnterRoomInfo = e();
        }
        ((HttpsInterface)localObject3).a(paramEnterRoomInfo, (Map)localObject2, paramEnterExitRoomCallback, new AbstractCustomRoomService.4(this, (HttpCallbacker)localObject1), CookieHelper.a());
        return;
      }
      catch (JSONException paramEnterRoomInfo)
      {
        paramEnterRoomInfo.printStackTrace();
        a(System.currentTimeMillis() - l1, -2, paramEnterRoomInfo.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.room.AbstractCustomRoomService
 * JD-Core Version:    0.7.0.1
 */