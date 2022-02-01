package com.tencent.mobileqq.kandian.biz.accesslayer.data;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianUserDataAladdinConfig;
import org.json.JSONException;
import org.json.JSONObject;

final class RIJDataFetchManager$1
  implements DialogInterface.OnClickListener
{
  RIJDataFetchManager$1(int paramInt, Runnable paramRunnable) {}
  
  @TargetApi(11)
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = 0;
    RIJSPUtils.a("readinjoy_user_data_switch", Integer.valueOf(0));
    paramDialogInterface.dismiss();
    paramDialogInterface = new JSONObject();
    for (;;)
    {
      try
      {
        if (this.a != 1) {
          break label112;
        }
        paramDialogInterface.put("click_src", paramInt);
        paramDialogInterface.put("user_data_alert_interval", RIJKanDianUserDataAladdinConfig.a.c());
        paramDialogInterface.put("click_opt", 1);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      PublicAccountReportUtils.a(null, "", "0X800A809", "0X800A809", 0, 0, "", "", "", paramDialogInterface.toString(), false);
      paramDialogInterface = this.b;
      if (paramDialogInterface != null) {
        paramDialogInterface.run();
      }
      return;
      label112:
      paramInt = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataFetchManager.1
 * JD-Core Version:    0.7.0.1
 */