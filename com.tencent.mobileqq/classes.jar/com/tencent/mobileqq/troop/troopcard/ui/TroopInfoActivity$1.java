package com.tencent.mobileqq.troop.troopcard.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class TroopInfoActivity$1
  extends BroadcastReceiver
{
  TroopInfoActivity$1(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if (!"changeGroupTribe".equals(paramIntent.getStringExtra("event"))) {
      return;
    }
    paramContext = paramIntent.getStringExtra("data");
    if (paramContext != null) {}
    try
    {
      paramContext = new JSONObject(paramContext);
      this.a.f.tribeId = paramContext.optInt("bid");
      this.a.f.tribeName = paramContext.optString("bname");
      this.a.o = true;
      paramContext = new ArrayList();
      if (!TextUtils.isEmpty(this.a.f.tribeName)) {
        paramContext.add(this.a.f.tribeName);
      }
      this.a.a(9, paramContext, true, 1, true);
      return;
    }
    catch (JSONException paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.1
 * JD-Core Version:    0.7.0.1
 */