package com.tencent.mobileqq.troop.homework.entry.ui;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.widget.QQToast;
import org.json.JSONObject;

class PublishHomeWorkFragment$21
  implements HttpWebCgiAsyncTask.Callback
{
  PublishHomeWorkFragment$21(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    this.a.A();
    if (paramJSONObject != null) {}
    try
    {
      if (paramJSONObject.has("retcode"))
      {
        paramInt = paramJSONObject.optInt("retcode");
        if (paramInt == 0)
        {
          this.a.u();
          return;
        }
        boolean bool = paramJSONObject.has("wording");
        paramBundle = "";
        if (bool) {
          paramBundle = paramJSONObject.optString("wording", "");
        }
        if (!TextUtils.isEmpty(paramBundle))
        {
          QQToast.makeText(this.a.getActivity(), paramBundle, 0).show();
          return;
        }
        if (paramInt == 111000)
        {
          QQToast.makeText(this.a.getActivity(), 2131895224, 0).show();
          return;
        }
        QQToast.makeText(this.a.getActivity(), 2131895274, 0).show();
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment.21
 * JD-Core Version:    0.7.0.1
 */