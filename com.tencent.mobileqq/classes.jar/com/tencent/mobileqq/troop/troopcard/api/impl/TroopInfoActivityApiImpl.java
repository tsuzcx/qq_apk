package com.tencent.mobileqq.troop.troopcard.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.troop.troopcard.TroopInfoActivity;
import com.tencent.mobileqq.troop.troopcard.api.ITroopInfoActivityApi;
import com.tencent.qphone.base.util.QLog;

public class TroopInfoActivityApiImpl
  implements ITroopInfoActivityApi
{
  private static final String TAG = "TroopInfoActivityApiImpl";
  
  public void openTroopProfile(Context paramContext, Bundle paramBundle)
  {
    if (paramContext != null) {
      try
      {
        Intent localIntent = new Intent(paramContext, TroopInfoActivity.class);
        localIntent.putExtras(paramBundle);
        if (!(paramContext instanceof Activity)) {
          localIntent.addFlags(268435456);
        }
        paramContext.startActivity(localIntent);
        return;
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopInfoActivityApiImpl", 2, paramContext.toString());
        }
      }
    }
  }
  
  public void openTroopProfileForResult(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if (paramActivity != null) {
      try
      {
        Intent localIntent = new Intent(paramActivity, TroopInfoActivity.class);
        localIntent.putExtras(paramBundle);
        paramActivity.startActivityForResult(localIntent, paramInt);
        return;
      }
      catch (Exception paramActivity)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopInfoActivityApiImpl", 2, paramActivity.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.api.impl.TroopInfoActivityApiImpl
 * JD-Core Version:    0.7.0.1
 */