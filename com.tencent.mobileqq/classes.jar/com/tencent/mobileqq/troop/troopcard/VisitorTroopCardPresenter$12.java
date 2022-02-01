package com.tencent.mobileqq.troop.troopcard;

import android.os.Bundle;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import org.json.JSONObject;

class VisitorTroopCardPresenter$12
  implements HttpWebCgiAsyncTask.Callback
{
  VisitorTroopCardPresenter$12(VisitorTroopCardPresenter paramVisitorTroopCardPresenter) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      VisitorTroopCardPresenter.b(this.a, paramJSONObject);
      return;
    }
    VisitorTroopCardPresenter.a(this.a, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.VisitorTroopCardPresenter.12
 * JD-Core Version:    0.7.0.1
 */