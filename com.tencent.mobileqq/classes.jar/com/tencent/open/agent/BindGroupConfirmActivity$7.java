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
              if (this.a.t == null)
              {
                this.a.t = new ShareAioResultDialog(this.a);
                this.a.t.a(this.a.p.getString(2131887562));
                this.a.t.a(this.a.p.getString(2131887561, new Object[] { this.a.q }), this.a);
                this.a.t.a(this.a);
              }
              if (!this.a.t.isShowing()) {
                this.a.t.show();
              }
              ReportController.b(this.a.app, "CliOper", "", "", "0x80084B1", "0x80084B1", 0, 0, "", "", "", "");
            }
            else
            {
              paramJSONObject = this.a.getActivity().getResources().getString(2131917510);
            }
            switch (paramInt)
            {
            case 221020: 
              paramJSONObject = this.a.getActivity().getResources().getString(2131917508);
              break;
            case 221019: 
              paramJSONObject = this.a.getActivity().getResources().getString(2131917512);
              break;
            case 221001: 
              paramJSONObject = this.a.getActivity().getResources().getString(2131917513);
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
        BindGroupConfirmActivity.a(paramBundle, paramBundle.getActivity().getResources().getString(2131917510));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupConfirmActivity.7
 * JD-Core Version:    0.7.0.1
 */