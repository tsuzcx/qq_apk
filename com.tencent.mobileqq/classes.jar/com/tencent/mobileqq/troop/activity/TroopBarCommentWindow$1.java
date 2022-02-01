package com.tencent.mobileqq.troop.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.widget.QQToast;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class TroopBarCommentWindow$1
  implements BusinessObserver
{
  TroopBarCommentWindow$1(TroopBarCommentWindow paramTroopBarCommentWindow) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.c.setEnabled(true);
    this.a.r.getString(2131894038);
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        Object localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
        paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
        if (paramInt != 0)
        {
          localObject = paramBundle.optString("msg");
          paramBundle = (Bundle)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramBundle = this.a.r.getString(2131894039, new Object[] { Integer.valueOf(paramInt) });
          }
        }
        else
        {
          paramBundle = paramBundle.getJSONObject("result");
          TroopBarUtils.a("two_comment", "suc", this.a.v, this.a.z, "", "");
          this.a.l = true;
          this.a.a(this.a.s, paramBundle.toString(), true);
          this.a.dismiss();
        }
      }
      else
      {
        paramBundle = this.a.r.getString(2131894039, new Object[] { Integer.valueOf(9991) });
      }
    }
    catch (Exception paramBundle)
    {
      break label255;
    }
    paramBundle = this.a.r.getString(2131894039, new Object[] { Integer.valueOf(9992) });
    break label281;
    label255:
    paramBundle = this.a.r.getString(2131894039, new Object[] { Integer.valueOf(9992) });
    label281:
    QQToast.makeText(this.a.r, 1, paramBundle, 0).show(this.a.r.getTitleBarHeight());
    TroopBarUtils.a("two_comment", "fail", this.a.v, "4", "", "");
    this.a.u = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarCommentWindow.1
 * JD-Core Version:    0.7.0.1
 */