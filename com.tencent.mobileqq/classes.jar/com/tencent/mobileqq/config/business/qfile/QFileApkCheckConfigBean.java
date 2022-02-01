package com.tencent.mobileqq.config.business.qfile;

import android.text.TextUtils;
import com.tencent.mobileqq.config.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QFileApkCheckConfigBean
  implements IQStorageSafable<String>
{
  public boolean a = false;
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("configID:663 onParse apkcheckConfig:");
    localStringBuilder.append(paramString);
    QLog.i("QFileApkCheckConfigBean", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString)) {
      paramString = paramString.toLowerCase();
    } else {
      paramString = "";
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w("QFileApkCheckConfigBean", 1, "apkcheckConfig is empty, configID:663 use default value");
      this.a = false;
      return;
    }
    try
    {
      paramString = new JSONObject(paramString).getJSONObject("apkcheckconfig");
      if (paramString != null)
      {
        if (paramString.has("enable"))
        {
          this.a = paramString.getBoolean("enable");
          return;
        }
        this.a = false;
        return;
      }
      QLog.w("QFileApkCheckConfigBean", 1, "apkcheckConfig is no enable. use default value");
      this.a = false;
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QFileApkCheckConfigBean", 1, paramString, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileApkCheckConfigBean
 * JD-Core Version:    0.7.0.1
 */