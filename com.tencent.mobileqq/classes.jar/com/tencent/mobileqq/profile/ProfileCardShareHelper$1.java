package com.tencent.mobileqq.profile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ProfileCardShareHelper$1
  extends BroadcastReceiver
{
  ProfileCardShareHelper$1(ProfileCardShareHelper paramProfileCardShareHelper) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int k = 0;
    if ((paramIntent != null) && ("com.tencent.qqhead.getheadresp".equals(paramIntent.getAction())))
    {
      if (paramIntent.getIntExtra("faceType", -1) != 1) {
        QLog.d("ProfileCardShareHelper", 1, "getHead onReceive FaceType not match!");
      }
    }
    else {
      return;
    }
    if (TextUtils.isEmpty(ProfileCardShareHelper.a(this.a)))
    {
      QLog.d("ProfileCardShareHelper", 1, "getHead onReceive mUin is empty!");
      return;
    }
    paramContext = paramIntent.getStringArrayListExtra("uinList");
    paramIntent = paramIntent.getStringArrayListExtra("headPathList");
    int j = k;
    int i;
    if (paramContext != null)
    {
      j = k;
      if (paramIntent != null)
      {
        j = k;
        if (paramContext.size() == paramIntent.size()) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      j = k;
      if (i < paramContext.size())
      {
        if (((String)paramContext.get(i)).equals(ProfileCardShareHelper.a(this.a)))
        {
          ProfileCardShareHelper.a(this.a, (String)paramIntent.get(i));
          j = 1;
        }
      }
      else
      {
        if ((j == 0) || (!ProfileCardShareHelper.a(this.a))) {
          break;
        }
        ProfileCardShareHelper.a(this.a, ProfileCardShareHelper.b(this.a));
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardShareHelper.1
 * JD-Core Version:    0.7.0.1
 */