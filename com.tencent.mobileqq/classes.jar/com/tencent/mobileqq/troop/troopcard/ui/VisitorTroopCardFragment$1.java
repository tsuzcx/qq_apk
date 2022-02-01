package com.tencent.mobileqq.troop.troopcard.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

class VisitorTroopCardFragment$1
  extends BroadcastReceiver
{
  VisitorTroopCardFragment$1(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int i;
    if ((this.a.W != null) && (this.a.W.isHomeworkTroop())) {
      i = 1;
    } else {
      i = 0;
    }
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramContext))
    {
      paramContext = paramIntent.getStringExtra("data");
      if (!"onHomeworkTroopIdentityChanged".equals(paramIntent.getStringExtra("event"))) {
        break label431;
      }
      paramIntent = new Intent("com.tencent.mobileqq.action.closewebview");
      paramIntent.putExtra("event", "closeWebView");
      MobileQQ.getContext().sendBroadcast(paramIntent, "com.tencent.msg.permission.pushnotify");
      if (i == 0) {
        return;
      }
      if (TextUtils.isEmpty(paramContext)) {
        return;
      }
    }
    try
    {
      Object localObject = new JSONObject(paramContext);
      paramContext = ((JSONObject)localObject).optString("groupCode");
      if (!TextUtils.equals(this.a.W.troopUin, paramContext)) {
        return;
      }
      paramIntent = ((JSONObject)localObject).optString("content");
      String str1 = ((JSONObject)localObject).optString("source");
      i = ((JSONObject)localObject).optInt("rankId", 333);
      String str2 = ((JSONObject)localObject).optString("nickName");
      ((JSONObject)localObject).optString("uin");
      ((JSONObject)localObject).optString("course");
      ((JSONObject)localObject).optString("name");
      if ("join".equals(str1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("wyx", 2, new Object[] { "mHomeworkTroopIdentityChangedReceiver source=join. cGroupOption=", Short.valueOf(this.a.W.cGroupOption), ", joinType=", Integer.valueOf(VisitorTroopCardFragment.a(this.a)) });
        }
        if (VisitorTroopCardFragment.a(this.a) == 1) {
          this.a.f();
        } else if (VisitorTroopCardFragment.a(this.a) == 2) {
          VisitorTroopCardFragment.a(this.a, paramIntent);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mHomeworkTroopIdentityChangedReceiver troopUin = ");
        ((StringBuilder)localObject).append(paramContext);
        ((StringBuilder)localObject).append(", content = ");
        ((StringBuilder)localObject).append(paramIntent);
        ((StringBuilder)localObject).append(", source = ");
        ((StringBuilder)localObject).append(str1);
        ((StringBuilder)localObject).append(", rankId = ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", nickName = ");
        ((StringBuilder)localObject).append(str2);
        QLog.d("zivonchen", 2, ((StringBuilder)localObject).toString());
        return;
        if ("start_recomend_page".equals(paramContext)) {
          this.a.getActivity().finish();
        }
      }
      label431:
      return;
    }
    catch (JSONException paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardFragment.1
 * JD-Core Version:    0.7.0.1
 */