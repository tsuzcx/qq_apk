package com.tencent.mobileqq.intervideo.lite_now_biz.module;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.mobileqq.intervideo.lite_now_biz.report.DataReport;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule;

public abstract class NowCustomWebModule
  extends CustomWebModule
{
  protected long a;
  private RoomServiceInterface a;
  private boolean b = false;
  
  public NowCustomWebModule()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  private Bundle a()
  {
    if (this.roomBizContext.getEnterRoomInfo() != null) {
      return this.roomBizContext.getEnterRoomInfo().extData;
    }
    return new Bundle();
  }
  
  private long b()
  {
    EnterRoomInfo localEnterRoomInfo = this.roomBizContext.getEnterRoomInfo();
    if (localEnterRoomInfo != null) {
      return localEnterRoomInfo.roomId;
    }
    return 0L;
  }
  
  private long c()
  {
    LiveInfo localLiveInfo = this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceRoomServiceInterface.getLiveInfo();
    if ((localLiveInfo != null) && (localLiveInfo.anchorInfo != null)) {
      return localLiveInfo.anchorInfo.uid;
    }
    return 0L;
  }
  
  protected long a()
  {
    LoginServiceInterface localLoginServiceInterface = (LoginServiceInterface)getRoomEngine().getService(LoginServiceInterface.class);
    if (localLoginServiceInterface.getLoginInfo() != null) {
      return localLoginServiceInterface.getLoginInfo().uid;
    }
    return 0L;
  }
  
  public abstract String a();
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceRoomServiceInterface = ((RoomServiceInterface)getRoomEngine().getService(RoomServiceInterface.class));
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    DataReport.a(a(), String.valueOf(a()), c(), b(), a());
    if (this.b)
    {
      this.b = false;
      DataReport.b(a(), String.valueOf(a()), c(), b(), a());
    }
  }
  
  public void onExitRoom(boolean paramBoolean)
  {
    super.onExitRoom(paramBoolean);
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
    DataReport.a(a(), String.valueOf(a()), c(), b(), a(), this.jdField_a_of_type_Long);
  }
  
  public void onPageFinished()
  {
    super.onPageFinished();
    Bundle localBundle = a();
    if ((!TextUtils.isEmpty(localBundle.getString("mqqschema"))) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl().startsWith(b())))
    {
      DataReport.b(a(), String.valueOf(a()), c(), b(), a());
      return;
    }
    this.b = localBundle.getBoolean("is_preload");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.module.NowCustomWebModule
 * JD-Core Version:    0.7.0.1
 */