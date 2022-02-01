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
  protected long a = 0L;
  private boolean b = false;
  private RoomServiceInterface n;
  
  private Bundle c()
  {
    if (this.roomBizContext.getEnterRoomInfo() != null) {
      return this.roomBizContext.getEnterRoomInfo().extData;
    }
    return new Bundle();
  }
  
  private long m()
  {
    EnterRoomInfo localEnterRoomInfo = this.roomBizContext.getEnterRoomInfo();
    if (localEnterRoomInfo != null) {
      return localEnterRoomInfo.roomId;
    }
    return 0L;
  }
  
  private long t()
  {
    LiveInfo localLiveInfo = this.n.getLiveInfo();
    if ((localLiveInfo != null) && (localLiveInfo.anchorInfo != null)) {
      return localLiveInfo.anchorInfo.uid;
    }
    return 0L;
  }
  
  public abstract String a();
  
  protected long b()
  {
    LoginServiceInterface localLoginServiceInterface = (LoginServiceInterface)getRoomEngine().getService(LoginServiceInterface.class);
    if (localLoginServiceInterface.getLoginInfo() != null) {
      return localLoginServiceInterface.getLoginInfo().uid;
    }
    return 0L;
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    this.n = ((RoomServiceInterface)getRoomEngine().getService(RoomServiceInterface.class));
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    this.a = System.currentTimeMillis();
    DataReport.a(c(), String.valueOf(b()), t(), m(), a());
    if (this.b)
    {
      this.b = false;
      DataReport.b(c(), String.valueOf(b()), t(), m(), a());
    }
  }
  
  public void onExitRoom(boolean paramBoolean)
  {
    super.onExitRoom(paramBoolean);
    this.a = (System.currentTimeMillis() - this.a);
    DataReport.a(c(), String.valueOf(b()), t(), m(), a(), this.a);
  }
  
  public void onPageFinished()
  {
    super.onPageFinished();
    Bundle localBundle = c();
    if ((!TextUtils.isEmpty(localBundle.getString("mqqschema"))) && (this.f.getUrl().startsWith(d())))
    {
      DataReport.b(c(), String.valueOf(b()), t(), m(), a());
      return;
    }
    this.b = localBundle.getBoolean("is_preload");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.module.NowCustomWebModule
 * JD-Core Version:    0.7.0.1
 */