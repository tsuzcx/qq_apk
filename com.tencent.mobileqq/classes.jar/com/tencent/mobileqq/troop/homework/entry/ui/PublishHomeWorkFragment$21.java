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
    this.a.p();
    if (paramJSONObject != null) {}
    try
    {
      if (paramJSONObject.has("retcode"))
      {
        paramInt = paramJSONObject.optInt("retcode");
        if (paramInt == 0)
        {
          this.a.k();
          return;
        }
        boolean bool = paramJSONObject.has("wording");
        paramBundle = "";
        if (bool) {
          paramBundle = paramJSONObject.optString("wording", "");
        }
        if (!TextUtils.isEmpty(paramBundle))
        {
          QQToast.a(this.a.getActivity(), paramBundle, 0).a();
          return;
        }
        if (paramInt == 111000)
        {
          QQToast.a(this.a.getActivity(), 2131697451, 0).a();
          return;
        }
        QQToast.a(this.a.getActivity(), 2131697501, 0).a();
      }
      return;
    }
    catch (Exception paramJSONObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment.21
 * JD-Core Version:    0.7.0.1
 */