package com.tencent.mobileqq.intervideo.lite_now_biz.module;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.mobileqq.intervideo.lite_now_biz.report.DataReport;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule;

public abstract class NowCustomWebModule
  extends CustomWebModule
{
  protected long a;
  private boolean a;
  
  public NowCustomWebModule()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private Bundle a()
  {
    return this.roomBizContext.getEnterRoomInfo().extData;
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
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    DataReport.a(a(), String.valueOf(a()), a());
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      DataReport.b(a(), String.valueOf(a()), a());
    }
  }
  
  public void onExitRoom(boolean paramBoolean)
  {
    super.onExitRoom(paramBoolean);
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
    DataReport.a(a(), String.valueOf(a()), a(), this.jdField_a_of_type_Long);
  }
  
  public void onPageFinished()
  {
    super.onPageFinished();
    Bundle localBundle = a();
    if ((!TextUtils.isEmpty(localBundle.getString("mqqschema"))) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl().startsWith(b())))
    {
      DataReport.b(a(), String.valueOf(a()), a());
      return;
    }
    this.jdField_a_of_type_Boolean = localBundle.getBoolean("is_preload");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.module.NowCustomWebModule
 * JD-Core Version:    0.7.0.1
 */