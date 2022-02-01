package com.tencent.mobileqq.nearby.profilecard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.qphone.base.util.QLog;

public class RealNearbyProfileCardUtils
{
  public static void a(Context paramContext, AllInOne paramAllInOne, Bundle paramBundle, int paramInt)
  {
    if (paramContext != null) {
      try
      {
        Intent localIntent = new Intent(paramContext, NearbyPeopleProfileActivity.class);
        localIntent.putExtra("AllInOne", paramAllInOne);
        localIntent.putExtras(paramBundle);
        localIntent.putExtra("frome_where", paramInt);
        localIntent.addFlags(536870912);
        if (!(paramContext instanceof Activity)) {
          localIntent.addFlags(268435456);
        }
        paramContext.startActivity(localIntent);
        return;
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
        }
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt == 22) {
      return true;
    }
    return (paramInt >= 7) && (paramInt <= 12) && (paramInt != 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.RealNearbyProfileCardUtils
 * JD-Core Version:    0.7.0.1
 */