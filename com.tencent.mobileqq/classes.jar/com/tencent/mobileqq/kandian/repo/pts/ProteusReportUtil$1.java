package com.tencent.mobileqq.kandian.repo.pts;

import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;

final class ProteusReportUtil$1
  implements Runnable
{
  ProteusReportUtil$1(JSONArray paramJSONArray) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.a.length())
    {
      String str;
      try
      {
        Object localObject = this.a.get(i);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        str = null;
      }
      if ((str instanceof String))
      {
        str = (String)str;
        if (!TextUtils.isEmpty(str)) {
          try
          {
            HttpUtil.openUrl(BaseActivity.sTopActivity, str, "GET", null, null);
          }
          catch (Exception localException)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("UG report error");
            localStringBuilder.append(localException.getMessage());
            QLog.e("ProteusReportUtil", 1, localStringBuilder.toString());
          }
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.pts.ProteusReportUtil.1
 * JD-Core Version:    0.7.0.1
 */