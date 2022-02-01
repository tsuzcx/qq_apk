package com.tencent.open.agent;

import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class BindGroupConfirmActivity$1
  implements HttpCgiAsyncTask.Callback
{
  BindGroupConfirmActivity$1(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void a(Exception paramException)
  {
    if ((this.a.s != null) && (this.a.s.isShowing())) {
      this.a.s.dismiss();
    }
    this.a.b(paramException);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((this.a.s != null) && (this.a.s.isShowing())) {
      this.a.s.dismiss();
    }
    try
    {
      if (paramJSONObject.getInt("ret") == 0)
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
      }
      else
      {
        int i = paramJSONObject.getInt("ret");
        if ((i != 10071) && (paramJSONObject.getInt("ret") != 10000))
        {
          if (QLog.isColorLevel()) {
            QLog.d("BindGroupConfirmActivity", 2, "The JSONObject has error!");
          }
          paramJSONObject = paramJSONObject.getString("msg");
          QQToast.makeText(CommonDataAdapter.a().b(), paramJSONObject, 0).create(this.a.getTitleBarHeight()).show();
          return;
        }
        if (this.a.u == null) {
          this.a.u = DialogUtil.a(this.a, 230, this.a.p.getString(2131887565), this.a.p.getString(2131887566), 2131887812, 2131892267, this.a, null);
        }
        paramJSONObject = paramJSONObject.getString("msg");
        if (!TextUtils.isEmpty(paramJSONObject)) {
          this.a.u.setMessage(paramJSONObject);
        }
        if (!this.a.u.isShowing())
        {
          this.a.u.show();
          return;
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      a(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupConfirmActivity.1
 * JD-Core Version:    0.7.0.1
 */