package com.tencent.mobileqq.kandian.biz.accesslayer.data;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianUserDataAladdinConfig;
import org.json.JSONException;
import org.json.JSONObject;

final class RIJDataFetchManager$2
  implements DialogInterface.OnClickListener
{
  RIJDataFetchManager$2(int paramInt, Runnable paramRunnable) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = 1;
    RIJSPUtils.a("readinjoy_user_data_switch", Integer.valueOf(1));
    paramDialogInterface.dismiss();
    paramDialogInterface = new JSONObject();
    try
    {
      if (this.a == 1) {
        paramInt = 0;
      }
      paramDialogInterface.put("click_src", paramInt);
      paramDialogInterface.put("user_data_alert_interval", RIJKanDianUserDataAladdinConfig.a.c());
      paramDialogInterface.put("click_opt", 2);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataFetchManager.2
 * JD-Core Version:    0.7.0.1
 */