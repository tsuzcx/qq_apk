package com.tencent.mobileqq.selectmember;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class SelectMemberActivity$VideoMsgReceiver
  extends BroadcastReceiver
{
  SelectMemberActivity$VideoMsgReceiver(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((!TextUtils.isEmpty(paramIntent.getPackage())) && (paramIntent.getPackage().equals(this.a.app.getApp().getPackageName())))
    {
      if (paramContext.equals("tencent.av.v2q.StopVideoChat"))
      {
        int i = paramIntent.getIntExtra("stopReason", 0);
        int j = paramIntent.getIntExtra("stopReason3rd", -1);
        if (((i == 0) || (j == 1)) && ((this.a.mEntrance == 11) || (this.a.mEntrance == 36)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SelectMemberActivity", 2, "ACTION_STOP_VIDEO_CHAT");
          }
          this.a.finish();
        }
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("receive broadcast from wrong package:");
      localStringBuilder.append(paramIntent.getPackage());
      localStringBuilder.append(",action:");
      localStringBuilder.append(paramContext);
      QLog.d("SelectMemberActivity", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectMemberActivity.VideoMsgReceiver
 * JD-Core Version:    0.7.0.1
 */