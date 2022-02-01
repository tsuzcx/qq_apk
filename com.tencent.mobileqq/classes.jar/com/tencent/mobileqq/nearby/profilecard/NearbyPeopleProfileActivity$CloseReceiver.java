package com.tencent.mobileqq.nearby.profilecard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.util.Utils;
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
      if ((!TextUtils.isEmpty(paramIntent)) && (Utils.a(paramIntent, paramContext.mUin)))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onReceive,close on uin:");
          localStringBuilder.append(paramIntent);
          QLog.i("NearbyPeopleProfileActivity", 2, localStringBuilder.toString());
        }
        paramContext.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.CloseReceiver
 * JD-Core Version:    0.7.0.1
 */