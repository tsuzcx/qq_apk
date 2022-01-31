package com.tencent.mobileqq.nearby.profilecard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import bdal;
import com.tencent.qphone.base.util.QLog;

public class NearbyPeopleProfileActivity$CloseReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramContext != null) && ((paramContext instanceof NearbyPeopleProfileActivity)))
    {
      paramContext = (NearbyPeopleProfileActivity)paramContext;
      paramIntent = paramIntent.getStringExtra("uin");
      if ((!TextUtils.isEmpty(paramIntent)) && (bdal.a(paramIntent, paramContext.d)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.nearby_people_card.", 2, "onReceive,close on uin:" + paramIntent);
        }
        paramContext.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.CloseReceiver
 * JD-Core Version:    0.7.0.1
 */