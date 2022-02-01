package com.tencent.mobileqq.newfriend.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileCardUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class SystemMessageHelper
{
  public static void a(Context paramContext, AllInOne paramAllInOne, Bundle paramBundle)
  {
    if (paramContext != null) {
      try
      {
        paramAllInOne = ProfileUtils.getIntent(paramContext, paramAllInOne);
        if ((paramBundle != null) && (paramBundle.getBoolean("single_top", false))) {
          paramAllInOne.addFlags(67108864);
        } else {
          paramAllInOne.addFlags(536870912);
        }
        if (!(paramContext instanceof Activity)) {
          paramAllInOne.addFlags(268435456);
        }
        if ((paramBundle != null) && (paramBundle.getBoolean("key_need_track_back", false))) {
          paramAllInOne.putExtra("key_need_track_back", true);
        }
        if (paramBundle != null) {
          paramAllInOne.putExtra("profile_extra", paramBundle);
        }
        paramContext.startActivity(paramAllInOne);
        return;
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SystemMessageHelper", 2, paramContext.toString());
        }
      }
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramString = new AllInOne(paramString, 1);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_need_track_back", true);
    a(paramContext, paramString, localBundle);
  }
  
  private static void a(Context paramContext, String paramString, long paramLong, int paramInt1, int paramInt2, Intent paramIntent, KplRoleInfo.WZRYUIinfo paramWZRYUIinfo)
  {
    if ((paramInt1 != -1011) && (paramInt1 != -1006) && (paramInt1 != 1)) {
      if (paramInt1 != 7)
      {
        if (paramInt1 != 187)
        {
          if ((paramInt2 != 3007) && (paramInt2 != 3019) && (paramInt2 != 2007) && (paramInt2 != 4007) && (paramInt2 != 2019))
          {
            paramString = new AllInOne(paramString, 25);
            paramString.profileEntryType = 109;
            paramString.chatAbility = 1;
            if (paramInt1 == 6) {
              paramString.chatAbility = 0;
            }
            Bundle localBundle = new Bundle();
            localBundle.putParcelable("sysInfoExtres", paramIntent);
            if (paramWZRYUIinfo != null) {
              paramString.extras.putSerializable("param_wzry_data", paramWZRYUIinfo);
            }
            a(paramContext, paramString, localBundle);
            return;
          }
          paramString = new AllInOne(paramString, 25);
          paramString.profileEntryType = 109;
          if ((paramInt2 != 3007) && (paramInt2 != 2007) && (paramInt2 != 4007))
          {
            if ((paramInt2 == 3019) || (paramInt2 == 2019)) {
              paramString.profileEntryType = 15;
            }
          }
          else {
            paramString.profileEntryType = 14;
          }
          paramWZRYUIinfo = new Bundle();
          paramWZRYUIinfo.putInt("param_mode", 3);
          paramWZRYUIinfo.putParcelable("sysInfoExtres", paramIntent);
          NearbyProfileCardUtils.a(paramContext, paramString, paramWZRYUIinfo);
        }
      }
      else
      {
        a(paramContext, paramString, paramLong, paramInt2, paramIntent);
        return;
      }
    }
    a(paramContext, paramString, paramLong, paramInt2, paramIntent, paramWZRYUIinfo);
  }
  
  private static void a(Context paramContext, String paramString, long paramLong, int paramInt, Intent paramIntent)
  {
    if ((paramInt != 3007) && (paramInt != 3019) && (paramInt != 2007) && (paramInt != 4007) && (paramInt != 2019))
    {
      paramString = new AllInOne(paramString, 25);
      paramString.profileEntryType = 109;
      paramString.sourceID = paramInt;
      paramString.troopUin = String.valueOf(paramLong);
      paramString.chatAbility = 1;
      localBundle = new Bundle();
      localBundle.putParcelable("sysInfoExtres", paramIntent);
      a(paramContext, paramString, localBundle);
      return;
    }
    paramString = new AllInOne(paramString, 25);
    paramString.profileEntryType = 109;
    if ((paramInt != 3007) && (paramInt != 2007) && (paramInt != 4007))
    {
      if ((paramInt == 3019) || (paramInt == 2019)) {
        paramString.profileEntryType = 15;
      }
    }
    else {
      paramString.profileEntryType = 14;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("param_mode", 3);
    localBundle.putParcelable("sysInfoExtres", paramIntent);
    NearbyProfileCardUtils.a(paramContext, paramString, localBundle);
  }
  
  private static void a(Context paramContext, String paramString, long paramLong, int paramInt, Intent paramIntent, KplRoleInfo.WZRYUIinfo paramWZRYUIinfo)
  {
    if ((paramInt != 3007) && (paramInt != 3019) && (paramInt != 2007) && (paramInt != 2019) && (paramInt != 4007))
    {
      paramString = new AllInOne(paramString, 28);
      paramString.profileEntryType = 109;
      paramString.sourceID = paramInt;
      paramString.troopUin = String.valueOf(paramLong);
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("sysInfoExtres", paramIntent);
      if (paramWZRYUIinfo != null) {
        paramString.extras.putSerializable("param_wzry_data", paramWZRYUIinfo);
      }
      a(paramContext, paramString, localBundle);
      return;
    }
    paramString = new AllInOne(paramString, 28);
    paramString.profileEntryType = 109;
    if ((paramInt != 3007) && (paramInt != 2007) && (paramInt != 4007))
    {
      if ((paramInt == 3019) || (paramInt == 2019)) {
        paramString.profileEntryType = 15;
      }
    }
    else {
      paramString.profileEntryType = 14;
    }
    paramWZRYUIinfo = new Bundle();
    paramWZRYUIinfo.putInt("param_mode", 3);
    paramWZRYUIinfo.putParcelable("sysInfoExtres", paramIntent);
    NearbyProfileCardUtils.a(paramContext, paramString, paramWZRYUIinfo);
  }
  
  public static void a(AppRuntime paramAppRuntime, Context paramContext, String paramString)
  {
    if (((IFriendDataService)paramAppRuntime.getRuntimeService(IFriendDataService.class, "")).isFriend(paramString)) {
      paramAppRuntime = new AllInOne(paramString, 1);
    } else {
      paramAppRuntime = new AllInOne(paramString, 25);
    }
    paramAppRuntime.profileEntryType = 109;
    ProfileUtils.openProfileCard(paramContext, paramAppRuntime);
  }
  
  public static boolean a(AppRuntime paramAppRuntime, Context paramContext, String paramString, long paramLong, int paramInt1, int paramInt2, Intent paramIntent)
  {
    ReportController.b(paramAppRuntime, "CliOper", "", "", "Verify_msg", "Verify_msg_prof", 0, 0, "", "", "", "");
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("openProfileCard | sourceId = ");
      localStringBuilder.append(paramInt2);
      QLog.d("SystemMessageHelper", 2, localStringBuilder.toString());
    }
    paramAppRuntime = (IFriendDataService)paramAppRuntime.getRuntimeService(IFriendDataService.class, "");
    boolean bool = false;
    if (paramAppRuntime != null) {
      bool = paramAppRuntime.isFriend(paramString);
    }
    if (bool)
    {
      paramAppRuntime = new AllInOne(paramString, 1);
      paramAppRuntime.profileEntryType = 109;
      ProfileUtils.openProfileCard(paramContext, paramAppRuntime);
      return true;
    }
    StringBuilder localStringBuilder = null;
    paramAppRuntime = localStringBuilder;
    if (paramIntent != null)
    {
      paramAppRuntime = localStringBuilder;
      if (paramIntent.hasExtra("param_wzry_data")) {
        paramAppRuntime = (KplRoleInfo.WZRYUIinfo)paramIntent.getSerializableExtra("param_wzry_data");
      }
    }
    a(paramContext, paramString, paramLong, paramInt1, paramInt2, paramIntent, paramAppRuntime);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.utils.SystemMessageHelper
 * JD-Core Version:    0.7.0.1
 */