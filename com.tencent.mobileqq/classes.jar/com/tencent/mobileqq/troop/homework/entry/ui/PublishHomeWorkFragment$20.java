package com.tencent.mobileqq.troop.homework.entry.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.widget.QQToast;
import org.json.JSONObject;

class PublishHomeWorkFragment$20
  implements HttpWebCgiAsyncTask.Callback
{
  PublishHomeWorkFragment$20(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    this.a.A();
    if ((paramJSONObject != null) && (paramJSONObject.has("retcode")))
    {
      paramInt = paramJSONObject.optInt("retcode");
      if (paramInt == 0)
      {
        QQToast.makeText(this.a.getActivity(), 2131895225, 0).show();
        paramJSONObject = BaseAIOUtils.a(new Intent(), new int[] { 2 });
        paramJSONObject.addFlags(268435456);
        paramJSONObject.putExtra("uin", this.a.O);
        paramJSONObject.putExtra("uintype", 1);
        RouteUtils.a(this.a.getActivity(), paramJSONObject, "/base/start/splash");
        this.a.getActivity().overridePendingTransition(2130772007, 2130772436);
        return;
      }
      if (paramInt == 111000)
      {
        QQToast.makeText(this.a.getActivity(), 2131895224, 0).show();
        return;
      }
      QQToast.makeText(this.a.getActivity(), 2131895274, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment.20
 * JD-Core Version:    0.7.0.1
 */