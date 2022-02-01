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
  private static final String a = "com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.closebtn.CustomCloseBtnModule";
  private ImageView b;
  
  private void b()
  {
    ViewStub localViewStub = (ViewStub)getRootView().findViewById(2131430819);
    ((RelativeLayout.LayoutParams)localViewStub.getLayoutParams()).setMargins(DeviceManager.a(this.context, 5.0F), UIUtil.getStatusBarHeight(this.context) + DeviceManager.a(this.context, 9.0F), 0, 0);
    localViewStub.inflate();
    this.b = ((ImageView)getRootView().findViewById(2131430001));
    this.b.setOnClickListener(new CustomCloseBtnModule.1(this));
  }
  
  private void c()
  {
    getEvent().observe(ContentLoadedEvent.class, new CustomCloseBtnModule.2(this));
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    b();
    c();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.b.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.closebtn.CustomCloseBtnModule
 * JD-Core Version:    0.7.0.1
 */