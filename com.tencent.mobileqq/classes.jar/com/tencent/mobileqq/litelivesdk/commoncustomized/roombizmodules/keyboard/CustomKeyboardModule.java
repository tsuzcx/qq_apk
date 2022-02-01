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
  private static final String jdField_a_of_type_JavaLangString = "com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.keyboard.CustomKeyboardModule";
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ViewTreeHelper jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewTreeHelper;
  private ViewUtils.InputMethodShowHelper jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewUtils$InputMethodShowHelper;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = true;
  
  private void a()
  {
    ((ViewStub)getRootView().findViewById(2131363662)).inflate();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)getRootView().findViewById(2131376658));
    this.jdField_a_of_type_AndroidViewView = getRootView().findViewById(2131380837);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)getRootView().findViewById(2131366315));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)getRootView().findViewById(2131364054));
  }
  
  private void b()
  {
    getEvent().observe(ShowKeyboardRoomEvent.class, new CustomKeyboardModule.1(this));
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new CustomKeyboardModule.2(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new CustomKeyboardModule.3(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new CustomKeyboardModule.4(this));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new CustomKeyboardModule.5(this));
    ViewUtils localViewUtils = new ViewUtils();
    localViewUtils.getClass();
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewUtils$InputMethodShowHelper = new ViewUtils.InputMethodShowHelper(localViewUtils, (Activity)this.context);
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewUtils$InputMethodShowHelper.a(new CustomKeyboardModule.6(this));
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (UIUtil.isScreenPortrait(this.context)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(1);
    } else {
      this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(268435456);
    }
    KeyboardUtil.a(this.context, this.jdField_a_of_type_AndroidWidgetEditText);
    IAudienceRoomPager localIAudienceRoomPager = getAudienceRoomPager();
    if (localIAudienceRoomPager != null) {
      localIAudienceRoomPager.setScrollForbidden(true);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(null);
    KeyboardUtil.b(this.context, this.jdField_a_of_type_AndroidWidgetEditText);
    Object localObject = new SendChatInputEvent();
    ((SendChatInputEvent)localObject).mType = 2;
    getEvent().post((ModuleEventInterface)localObject);
    localObject = getAudienceRoomPager();
    if ((this.b) && (this.isUserVisibleHint) && (UIUtil.isScreenPortrait(this.context)) && (localObject != null)) {
      ((IAudienceRoomPager)localObject).setScrollForbidden(false);
    }
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    try
    {
      this.b = this.roomBizContext.getEnterRoomInfo().extData.getString("scroll_enable", "1").equals("1");
      a();
      b();
      c();
      localObject = getRootView();
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewTreeHelper = new ViewTreeHelper((Activity)paramContext, (ViewGroup)localObject);
      return;
    }
    catch (Exception paramContext)
    {
      if (getEvent() != null) {
        getEvent().post(new RoomCloseEvent());
      }
      Object localObject = LogFactory.a();
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CustomKeyboardModule onCreate ex = ");
      localStringBuilder.append(paramContext);
      ((LogInterface)localObject).e(str, localStringBuilder.toString());
    }
  }
  
  public void onDestroy()
  {
    Object localObject = (Activity)this.context;
    super.onDestroy();
    ViewUtils.InputMethodShowHelper localInputMethodShowHelper = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewUtils$InputMethodShowHelper;
    if (localInputMethodShowHelper != null)
    {
      localInputMethodShowHelper.a((Activity)localObject);
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewUtils$InputMethodShowHelper.a(null);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewTreeHelper;
    if (localObject != null) {
      ((ViewTreeHelper)localObject).b();
    }
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(null);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject != null) {
      ((LinearLayout)localObject).setOnClickListener(null);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localObject != null) {
      ((EditText)localObject).setOnClickListener(null);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetButton;
    if (localObject != null) {
      ((Button)localObject).setOnClickListener(null);
    }
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    ViewTreeHelper localViewTreeHelper = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewTreeHelper;
    if (localViewTreeHelper != null) {
      localViewTreeHelper.a();
    }
  }
  
  public void onExitRoom(boolean paramBoolean)
  {
    super.onExitRoom(paramBoolean);
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewTreeHelper;
      if (localObject != null) {
        ((ViewTreeHelper)localObject).b();
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewUtils$InputMethodShowHelper;
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
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.keyboard.CustomKeyboardModule
 * JD-Core Version:    0.7.0.1
 */