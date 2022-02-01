package com.tencent.open.agent;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class BindGroupConfirmActivity$7
  implements HttpWebCgiAsyncTask.Callback
{
  BindGroupConfirmActivity$7(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    }
    do
    {
      for (;;)
      {
        return;
        if (paramJSONObject != null) {
          try
          {
            paramJSONObject = (JSONObject)paramJSONObject.get("data");
            if (paramJSONObject != null)
            {
              paramJSONObject = (JSONObject)paramJSONObject.get("key");
              if (paramJSONObject != null)
              {
                paramInt = ((Integer)paramJSONObject.get("retCode")).intValue();
                paramBundle = (String)paramJSONObject.get("retMsg");
                if (paramInt != 0) {
                  break label336;
                }
                if (this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog == null)
                {
                  this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = new ShareAioResultDialog(this.a);
                  this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690723));
                  this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690722, new Object[] { this.a.e }), this.a);
                  this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(this.a);
                }
                if (!this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.isShowing()) {
                  this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
                }
                ReportController.b(this.a.app, "CliOper", "", "", "0x80084B1", "0x80084B1", 0, 0, "", "", "", "");
                if (QLog.isColorLevel())
                {
                  QLog.i("BindGroupConfirmActivity", 2, "bindGroup onResult retCode = " + paramInt + " retMsg = " + paramBundle);
                  return;
                }
              }
            }
          }
          catch (Exception paramJSONObject)
          {
            BindGroupConfirmActivity.a(this.a, this.a.getActivity().getResources().getString(2131720172));
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("BindGroupConfirmActivity", 2, "bindGroup onResult " + paramJSONObject.toString());
    return;
    label336:
    paramJSONObject = this.a.getActivity().getResources().getString(2131720172);
    switch (paramInt)
    {
    }
    for (;;)
    {
      BindGroupConfirmActivity.a(this.a, paramJSONObject);
      break;
      paramJSONObject = this.a.getActivity().getResources().getString(2131720175);
      continue;
      paramJSONObject = this.a.getActivity().getResources().getString(2131720174);
      continue;
      paramJSONObject = this.a.getActivity().getResources().getString(2131720170);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupConfirmActivity.7
 * JD-Core Version:    0.7.0.1
 */