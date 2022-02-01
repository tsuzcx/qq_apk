package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.keyboard;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.falco.utils.UIUtil;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.litepages.room.webmodule.event.SendChatInputEvent;
import com.tencent.ilive.litepages.room.webmodule.event.ShowKeyboardRoomEvent;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.mobileqq.litelivesdk.utils.KeyboardUtil;
import com.tencent.mobileqq.litelivesdk.utils.ui.ViewTreeHelper;
import com.tencent.mobileqq.litelivesdk.utils.ui.ViewUtils;
import com.tencent.mobileqq.litelivesdk.utils.ui.ViewUtils.InputMethodShowHelper;

public class CustomKeyboardModule
  extends RoomBizModule
{
  private static final String jdField_a_of_type_JavaLangString = CustomKeyboardModule.class.getName();
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ViewTreeHelper jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewTreeHelper;
  private ViewUtils.InputMethodShowHelper jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewUtils$InputMethodShowHelper;
  private boolean jdField_a_of_type_Boolean = false;
  
  private void a()
  {
    ((ViewStub)getRootView().findViewById(2131363732)).inflate();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)getRootView().findViewById(2131377196));
    this.jdField_a_of_type_AndroidViewView = getRootView().findViewById(2131381604);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)getRootView().findViewById(2131366434));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)getRootView().findViewById(2131364133));
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
    }
    for (;;)
    {
      KeyboardUtil.a(this.context, this.jdField_a_of_type_AndroidWidgetEditText);
      return;
      this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(268435456);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(null);
    KeyboardUtil.b(this.context, this.jdField_a_of_type_AndroidWidgetEditText);
    SendChatInputEvent localSendChatInputEvent = new SendChatInputEvent();
    localSendChatInputEvent.mType = 2;
    getEvent().post(localSendChatInputEvent);
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    a();
    b();
    c();
    ViewGroup localViewGroup = getRootView();
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewTreeHelper = new ViewTreeHelper((Activity)paramContext, localViewGroup);
  }
  
  public void onDestroy()
  {
    Activity localActivity = (Activity)this.context;
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewUtils$InputMethodShowHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewUtils$InputMethodShowHelper.a(localActivity);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewTreeHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewTreeHelper.b();
    }
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(null);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(null);
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewUtils$InputMethodShowHelper.a(null);
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewTreeHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewTreeHelper.a();
    }
  }
  
  public void onExitRoom(boolean paramBoolean)
  {
    super.onExitRoom(paramBoolean);
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewTreeHelper != null)) {
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewTreeHelper.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewUtils$InputMethodShowHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkUtilsUiViewUtils$InputMethodShowHelper.a((Activity)this.context);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.keyboard.CustomKeyboardModule
 * JD-Core Version:    0.7.0.1
 */