package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.closebtn;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.falco.utils.UIUtil;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.litepages.room.webmodule.event.ContentLoadedEvent;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule;
import com.tencent.mobileqq.litelivesdk.utils.ui.DeviceManager;

public class CustomCloseBtnModule
  extends RoomBizModule
{
  private static final String jdField_a_of_type_JavaLangString = "com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.closebtn.CustomCloseBtnModule";
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  
  private void a()
  {
    ViewStub localViewStub = (ViewStub)getRootView().findViewById(2131364713);
    ((RelativeLayout.LayoutParams)localViewStub.getLayoutParams()).setMargins(DeviceManager.a(this.context, 5.0F), UIUtil.getStatusBarHeight(this.context) + DeviceManager.a(this.context, 9.0F), 0, 0);
    localViewStub.inflate();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)getRootView().findViewById(2131364043));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new CustomCloseBtnModule.1(this));
  }
  
  private void b()
  {
    getEvent().observe(ContentLoadedEvent.class, new CustomCloseBtnModule.2(this));
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    a();
    b();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.closebtn.CustomCloseBtnModule
 * JD-Core Version:    0.7.0.1
 */