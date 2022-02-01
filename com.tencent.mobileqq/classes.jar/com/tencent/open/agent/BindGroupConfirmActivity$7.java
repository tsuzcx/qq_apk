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
    if (paramInt != 0) {
      return;
    }
    if (paramJSONObject != null) {}
    for (;;)
    {
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
            if (paramInt == 0)
            {
              if (this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog == null)
              {
                this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = new ShareAioResultDialog(this.a);
                this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690651));
                this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(this.a.jdField_a_of_type_AndroidContentResResources.getString(2131690650, new Object[] { this.a.e }), this.a);
                this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(this.a);
              }
              if (!this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.isShowing()) {
                this.a.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
              }
              ReportController.b(this.a.app, "CliOper", "", "", "0x80084B1", "0x80084B1", 0, 0, "", "", "", "");
            }
            else
            {
              paramJSONObject = this.a.getActivity().getResources().getString(2131719905);
            }
            switch (paramInt)
            {
            case 221020: 
              paramJSONObject = this.a.getActivity().getResources().getString(2131719903);
              break;
            case 221019: 
              paramJSONObject = this.a.getActivity().getResources().getString(2131719907);
              break;
            case 221001: 
              paramJSONObject = this.a.getActivity().getResources().getString(2131719908);
              BindGroupConfirmActivity.a(this.a, paramJSONObject);
              if (QLog.isColorLevel())
              {
                paramJSONObject = new StringBuilder();
                paramJSONObject.append("bindGroup onResult retCode = ");
                paramJSONObject.append(paramInt);
                paramJSONObject.append(" retMsg = ");
                paramJSONObject.append(paramBundle);
                QLog.i("BindGroupConfirmActivity", 2, paramJSONObject.toString());
                return;
              }
              break;
            }
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        paramBundle = this.a;
        BindGroupConfirmActivity.a(paramBundle, paramBundle.getActivity().getResources().getString(2131719905));
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("bindGroup onResult ");
          paramBundle.append(paramJSONObject.toString());
          QLog.d("BindGroupConfirmActivity", 2, paramBundle.toString());
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupConfirmActivity.7
 * JD-Core Version:    0.7.0.1
 */