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
    QLog.i("QFileApkCheckConfigBean", 1, "configID:663 onParse apkcheckConfig:" + paramString);
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString.toLowerCase();
    }
    if (TextUtils.isEmpty(str))
    {
      QLog.w("QFileApkCheckConfigBean", 1, "apkcheckConfig is empty, configID:663 use default value");
      this.a = false;
      return;
    }
    try
    {
      paramString = new JSONObject(str).getJSONObject("apkcheckconfig");
      if (paramString == null) {
        break label118;
      }
      if (paramString.has("enable"))
      {
        this.a = paramString.getBoolean("enable");
        return;
      }
    }
    catch (JSONException paramString)
    {
      QLog.e("QFileApkCheckConfigBean", 1, paramString, new Object[0]);
      return;
    }
    this.a = false;
    return;
    label118:
    QLog.w("QFileApkCheckConfigBean", 1, "apkcheckConfig is no enable. use default value");
    this.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileApkCheckConfigBean
 * JD-Core Version:    0.7.0.1
 */