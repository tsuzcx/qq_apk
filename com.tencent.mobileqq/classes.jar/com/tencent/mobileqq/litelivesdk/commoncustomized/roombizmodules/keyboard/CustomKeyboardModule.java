package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.keyboard;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.falco.utils.UIUtil;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.base.event.ModuleEventInterface;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.litepages.room.webmodule.event.SendChatInputEvent;
import com.tencent.ilive.litepages.room.webmodule.event.ShowKeyboardRoomEvent;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule;
import com.tencent.ilive.pages.room.events.RoomCloseEvent;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.mobileqq.litelivesdk.utils.KeyboardUtil;
import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import com.tencent.mobileqq.litelivesdk.utils.log.LogInterface;
import com.tencent.mobileqq.litelivesdk.utils.ui.ViewTreeHelper;
import com.tencent.mobileqq.litelivesdk.utils.ui.ViewUtils;
import com.tencent.mobileqq.litelivesdk.utils.ui.ViewUtils.InputMethodShowHelper;

public class CustomKeyboardModule
  extends RoomBizModule
{
  private static final String a = "com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.keyboard.CustomKeyboardModule";
  private LinearLayout b;
  private View c;
  private EditText d;
  private Button e;
  private ViewUtils.InputMethodShowHelper f;
  private ViewTreeHelper g;
  private boolean h = false;
  private boolean i = true;
  
  private void c()
  {
    ((ViewStub)getRootView().findViewById(2131429575)).inflate();
    this.b = ((LinearLayout)getRootView().findViewById(2131444921));
    this.c = getRootView().findViewById(2131449813);
    this.d = ((EditText)getRootView().findViewById(2131432614));
    this.e = ((Button)getRootView().findViewById(2131430012));
  }
  
  private void d()
  {
    getEvent().observe(ShowKeyboardRoomEvent.class, new CustomKeyboardModule.1(this));
  }
  
  private void e()
  {
    this.c.setOnClickListener(new CustomKeyboardModule.2(this));
    this.b.setOnClickListener(new CustomKeyboardModule.3(this));
    this.d.addTextChangedListener(new CustomKeyboardModule.4(this));
    this.e.setOnClickListener(new CustomKeyboardModule.5(this));
    ViewUtils localViewUtils = new ViewUtils();
    localViewUtils.getClass();
    this.f = new ViewUtils.InputMethodShowHelper(localViewUtils, (Activity)this.context);
    this.f.a(new CustomKeyboardModule.6(this));
  }
  
  private void f()
  {
    this.d.setFocusable(true);
    this.d.setFocusableInTouchMode(true);
    this.d.requestFocus();
    if (this.b.getVisibility() != 0) {
      this.b.setVisibility(0);
    }
    this.c.setVisibility(0);
    if (UIUtil.isScreenPortrait(this.context)) {
      this.d.setImeOptions(1);
    } else {
      this.d.setImeOptions(268435456);
    }
    KeyboardUtil.a(this.context, this.d);
    IAudienceRoomPager localIAudienceRoomPager = getAudienceRoomPager();
    if (localIAudienceRoomPager != null) {
      localIAudienceRoomPager.setScrollForbidden(true);
    }
  }
  
  private void g()
  {
    this.c.setVisibility(8);
    this.b.setVisibility(8);
    this.d.setText(null);
    KeyboardUtil.b(this.context, this.d);
    Object localObject = new SendChatInputEvent();
    ((SendChatInputEvent)localObject).mType = 2;
    getEvent().post((ModuleEventInterface)localObject);
    localObject = getAudienceRoomPager();
    if ((this.i) && (this.isUserVisibleHint) && (UIUtil.isScreenPortrait(this.context)) && (localObject != null)) {
      ((IAudienceRoomPager)localObject).setScrollForbidden(false);
    }
  }
  
  protected void a()
  {
    try
    {
      this.i = this.roomBizContext.getEnterRoomInfo().extData.getString("scroll_enable", "1").equals("1");
      c();
      d();
      e();
      ViewGroup localViewGroup = getRootView();
      this.g = new ViewTreeHelper((Activity)this.context, localViewGroup);
      return;
    }
    catch (Exception localException)
    {
      if (getEvent() != null) {
        getEvent().post(new RoomCloseEvent());
      }
      LogInterface localLogInterface = LogFactory.a();
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CustomKeyboardModule onCreate ex = ");
      localStringBuilder.append(localException);
      localLogInterface.e(str, localStringBuilder.toString());
    }
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    a();
  }
  
  public void onDestroy()
  {
    Object localObject = (Activity)this.context;
    super.onDestroy();
    ViewUtils.InputMethodShowHelper localInputMethodShowHelper = this.f;
    if (localInputMethodShowHelper != null)
    {
      localInputMethodShowHelper.a((Activity)localObject);
      this.f.a(null);
    }
    localObject = this.g;
    if (localObject != null) {
      ((ViewTreeHelper)localObject).b();
    }
    localObject = this.c;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(null);
    }
    localObject = this.b;
    if (localObject != null) {
      ((LinearLayout)localObject).setOnClickListener(null);
    }
    localObject = this.d;
    if (localObject != null) {
      ((EditText)localObject).setOnClickListener(null);
    }
    localObject = this.e;
    if (localObject != null) {
      ((Button)localObject).setOnClickListener(null);
    }
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    ViewTreeHelper localViewTreeHelper = this.g;
    if (localViewTreeHelper != null) {
      localViewTreeHelper.a();
    }
  }
  
  public void onExitRoom(boolean paramBoolean)
  {
    super.onExitRoom(paramBoolean);
    if (paramBoolean)
    {
      localObject = this.g;
      if (localObject != null) {
        ((ViewTreeHelper)localObject).b();
      }
    }
    Object localObject = this.f;
    if (localObject != null) {
      ((ViewUtils.InputMethodShowHelper)localObject).a((Activity)this.context);
    }
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    super.onSwitchRoom(paramSwitchRoomInfo);
    if ((this.context instanceof Activity)) {
      KeyboardUtil.a((Activity)this.context);
    }
  }
  
  public void onSwitchScreen(boolean paramBoolean)
  {
    super.onSwitchScreen(paramBoolean);
    this.h = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.keyboard.CustomKeyboardModule
 * JD-Core Version:    0.7.0.1
 */