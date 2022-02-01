package com.tencent.mobileqq.location.callback;

import android.app.Activity;
import android.app.Dialog;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.LocationShareServiceHolder;
import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.qqfloatingwindow.listener.IWindowClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class FloatMapCallback$1
  implements IWindowClickListener
{
  boolean a = false;
  Dialog b;
  
  FloatMapCallback$1(FloatMapCallback paramFloatMapCallback, QQAppInterface paramQQAppInterface, LocationRoom.RoomKey paramRoomKey) {}
  
  public boolean a()
  {
    Object localObject = LocationShareServiceHolder.b(this.c);
    if ((!this.c.isBackgroundPause) && (!this.c.isBackgroundStop))
    {
      if (!this.a)
      {
        this.b = ((IFloatMapService)localObject).createFloatExitConfirmDialog(this.d.a(), this.d.b());
        this.a = true;
        localObject = this.b;
        if (localObject != null) {
          ((Dialog)localObject).setOnDismissListener(new FloatMapCallback.1.1(this));
        }
      }
    }
    else {
      ((IFloatMapService)localObject).showFloatTypeDialog(this.d);
    }
    ReportController.b(null, "CliOper", "", "", "0X800A978", "0X800A978", 0, 0, "", "0", "0", "");
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatMapCallback", 2, new Object[] { "onEnterClick: invoked. ", " centerX: ", Integer.valueOf(paramInt1), " centerY: ", Integer.valueOf(paramInt2) });
    }
    Object localObject = QBaseActivity.sTopActivity;
    if (localObject != null) {
      LocationShareServiceHolder.a(this.c).launchShareUi((Activity)localObject, this.d.a(), this.d.b(), 4);
    }
    FloatMapCallback.d();
    localObject = this.b;
    if (localObject != null) {}
    try
    {
      ((Dialog)localObject).dismiss();
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.callback.FloatMapCallback.1
 * JD-Core Version:    0.7.0.1
 */