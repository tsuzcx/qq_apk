package com.tencent.mobileqq.kandian.glue.viola.view;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.glue.viola.adapter.ViolaReportDelegate;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.open.business.base.Constants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaEnvironment;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

class ViolaBaseView$19
  implements HttpCgiAsyncTask.Callback
{
  ViolaBaseView$19(ViolaBaseView paramViolaBaseView, boolean paramBoolean) {}
  
  public void a(Exception paramException)
  {
    String str1;
    String str2;
    if ((paramException instanceof ConnectTimeoutException))
    {
      str1 = Constants.e;
      str2 = ViolaEnvironment.CHANGE_ERROR_CONNECT_TIMEOUT;
    }
    else if ((paramException instanceof SocketTimeoutException))
    {
      str1 = Constants.f;
      str2 = ViolaEnvironment.CHANGE_ERROR_CONNECT_TIMEOUT;
    }
    else if ((paramException instanceof MalformedURLException))
    {
      str2 = ViolaEnvironment.CHANGE_ERROR_URL;
      str1 = "访问url有误!";
    }
    else if ((paramException instanceof HttpBaseUtil.HttpStatusException))
    {
      str2 = ViolaEnvironment.CHANGE_ERROR_HTTP_CODE;
      str1 = "Http返回码异常!";
    }
    else if ((paramException instanceof HttpBaseUtil.NetworkUnavailableException))
    {
      str1 = Constants.g;
      str2 = ViolaEnvironment.CHANGE_ERROR_CONNECT_UNAVALIABLE;
    }
    else if ((paramException instanceof JSONException))
    {
      str1 = Constants.b;
      str2 = ViolaEnvironment.CHANGE_ERROR_DATA;
    }
    else if ((paramException instanceof IOException))
    {
      str1 = Constants.a;
      str2 = ViolaEnvironment.CHANGE_ERROR_IO;
    }
    else
    {
      str1 = Constants.d;
      str2 = ViolaEnvironment.CHANGE_ERROR_UNKNOW;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("viola request cgi has error:");
      localStringBuilder.append(str1);
      localStringBuilder.append(",e:");
      localStringBuilder.append(paramException.getMessage());
      QLog.d("ViolaBaseView", 2, localStringBuilder.toString());
    }
    if (this.a) {
      ViolaBaseView.a(this.b).addReportData(ViolaEnvironment.KEY_CHANGE, str2);
    }
    ViolaBaseView.e(this.b, this.a);
    ViolaBaseView.d(this.b, this.a);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("change cgi result:");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.d("ViolaBaseView", 2, localStringBuilder.toString());
    }
    try
    {
      if ((paramJSONObject.getInt("retCode") == 0) && (paramJSONObject.getString("retMsg").equals("success")) && (!TextUtils.isEmpty(paramJSONObject.getJSONObject("retObj").getString("fileUrl"))))
      {
        ViolaBaseView.c(this.b, paramJSONObject.getJSONObject("retObj").getString("fileUrl"));
        if (this.a) {
          ViolaBaseView.a(this.b).addReportData(ViolaEnvironment.KEY_CHANGE, ViolaEnvironment.CHANGE_END);
        }
        ViolaBaseView.c(this.b, this.a);
        ViolaBaseView.d(this.b, this.a);
        return;
      }
      if (this.a) {
        ViolaBaseView.a(this.b).addReportData(ViolaEnvironment.KEY_CHANGE, ViolaEnvironment.CHANGE_ERROR_DATA);
      }
      ViolaBaseView.e(this.b, this.a);
      ViolaBaseView.d(this.b, this.a);
      return;
    }
    catch (Exception paramJSONObject)
    {
      if (this.a) {
        ViolaBaseView.a(this.b).addReportData(ViolaEnvironment.KEY_CHANGE, ViolaEnvironment.CHANGE_ERROR_UNKNOW);
      }
      ViolaBaseView.e(this.b, this.a);
      ViolaBaseView.d(this.b, this.a);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("change cgi exception:");
        localStringBuilder.append(paramJSONObject.getMessage());
        QLog.e("ViolaBaseView", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.19
 * JD-Core Version:    0.7.0.1
 */