package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.landscape;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.ilive.audiencepages.room.events.TurnToPortraitEvent;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.interfaces.RoomPageActionInterface;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule;

public class CustomLanscapeModule
  extends RoomBizModule
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView = null;
  private Observer jdField_a_of_type_AndroidxLifecycleObserver = new CustomLanscapeModule.1(this);
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public void a()
  {
    this.roomBizContext.getRoomState().isSwitchRoom = true;
    getAudienceRoomPager().getRoomPageAction().setRequestedOrientation(false);
    this.jdField_a_of_type_AndroidAppActivity.getWindow().setSoftInputMode(16);
  }
  
  public void onActivityPause(LifecycleOwner paramLifecycleOwner)
  {
    a();
    super.onActivityPause(paramLifecycleOwner);
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView();
    getEvent().observe(TurnToPortraitEvent.class, this.jdField_a_of_type_AndroidxLifecycleObserver);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getEvent().removeObserver(TurnToPortraitEvent.class, this.jdField_a_of_type_AndroidxLifecycleObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.landscape.CustomLanscapeModule
 * JD-Core Version:    0.7.0.1
 */