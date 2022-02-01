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
    if ((paramIntent != null) && ("com.tencent.qqhead.getheadresp".equals(paramIntent.getAction())))
    {
      if (paramIntent.getIntExtra("faceType", -1) != 1)
      {
        QLog.d("ProfileCardShareHelper", 1, "getHead onReceive FaceType not match!");
        return;
      }
      if (TextUtils.isEmpty(ProfileCardShareHelper.a(this.a)))
      {
        QLog.d("ProfileCardShareHelper", 1, "getHead onReceive mUin is empty!");
        return;
      }
      paramContext = paramIntent.getStringArrayListExtra("uinList");
      paramIntent = paramIntent.getStringArrayListExtra("headPathList");
      int k = 0;
      int j = k;
      if (paramContext != null)
      {
        j = k;
        if (paramIntent != null)
        {
          j = k;
          if (paramContext.size() == paramIntent.size())
          {
            int i = 0;
            for (;;)
            {
              j = k;
              if (i >= paramContext.size()) {
                break;
              }
              if (((String)paramContext.get(i)).equals(ProfileCardShareHelper.a(this.a)))
              {
                ProfileCardShareHelper.a(this.a, (String)paramIntent.get(i));
                j = 1;
                break;
              }
              i += 1;
            }
          }
        }
      }
      if ((j != 0) && (ProfileCardShareHelper.a(this.a)))
      {
        paramContext = this.a;
        ProfileCardShareHelper.a(paramContext, ProfileCardShareHelper.b(paramContext));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.ProfileCardShareHelper.1
 * JD-Core Version:    0.7.0.1
 */