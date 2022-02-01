package com.tencent.mobileqq.selectmember;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class BlessSelectMemberActivity$10
  extends BroadcastReceiver
{
  BlessSelectMemberActivity$10(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction())) && (this.a.mType == 9003) && (this.a.mEntrance == 32))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "ACTION_START_VIDEO_CHAT from BLESS_WEB");
      }
      paramContext = new Intent("tencent.video.q2v.startUploadPTV");
      paramContext.putExtra("broadcastType", 1);
      this.a.app.getApp().sendBroadcast(paramContext);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.BlessSelectMemberActivity.10
 * JD-Core Version:    0.7.0.1
 */