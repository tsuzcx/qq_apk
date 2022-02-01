package com.tencent.mobileqq.troop.troopapps;

import android.os.Bundle;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;
import org.json.JSONObject;

class AddTroopAppCgi$1
  implements HttpWebCgiAsyncTask.Callback
{
  AddTroopAppCgi$1(AddTroopAppCgi paramAddTroopAppCgi) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (AddTroopAppCgi.a(this.a).get() == null) {
      return;
    }
    if ((paramJSONObject != null) && (paramJSONObject.has("ec")))
    {
      paramInt = paramJSONObject.optInt("ec");
      paramJSONObject = paramJSONObject.optString("em");
      if (QLog.isColorLevel()) {
        QLog.d("AddTroopAppCgi", 2, new Object[] { "retCode:", Integer.valueOf(paramInt) });
      }
      if (paramInt == 0)
      {
        ((AddTroopAppCgi.CgiCallBack)AddTroopAppCgi.a(this.a).get()).a(AddTroopAppCgi.a(this.a));
        return;
      }
      ((AddTroopAppCgi.CgiCallBack)AddTroopAppCgi.a(this.a).get()).a(paramInt, paramJSONObject, AddTroopAppCgi.a(this.a));
      return;
    }
    QLog.e("AddTroopAppCgi", 1, "add appid get result err");
    ((AddTroopAppCgi.CgiCallBack)AddTroopAppCgi.a(this.a).get()).a(-1, "", AddTroopAppCgi.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.AddTroopAppCgi.1
 * JD-Core Version:    0.7.0.1
 */