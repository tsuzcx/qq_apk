package com.tencent.mobileqq.location.ui;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.net.LocationShareLocationManager;
import com.tencent.mobileqq.location.net.LocationShareRoomManager;
import com.tencent.mobileqq.location.net.RoomOperateHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class HeadSetViewModule$2
  implements ActionSheet.OnButtonClickListener
{
  HeadSetViewModule$2(HeadSetViewModule paramHeadSetViewModule, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      HeadSetViewModule.b(this.b).finish();
      paramView = HeadSetViewModule.b(this.b).getIntent();
      String str = paramView.getStringExtra("uin");
      paramInt = paramView.getIntExtra("uintype", -1);
      LocationShareRoomManager.a().b.a(3, paramInt, str);
      paramView = new LocationRoom.RoomKey(paramInt, str);
      LocationShareLocationManager.a().a(paramView, false);
      ReportController.b(null, "CliOper", "", "", "0X800A76E", "0X800A76E", 0, 0, "", "0", "0", "");
    }
    this.a.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.HeadSetViewModule.2
 * JD-Core Version:    0.7.0.1
 */