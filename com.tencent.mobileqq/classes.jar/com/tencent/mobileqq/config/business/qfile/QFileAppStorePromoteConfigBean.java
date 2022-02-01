package com.tencent.mobileqq.config.business.qfile;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.api.util.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QFileAppStorePromoteConfigBean
  implements IQFileAppStorePromoteConfigBean, IQStorageSafable<String>
{
  public boolean a = false;
  public String b = "";
  public String c = "";
  public String d = "{}";
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("QFileAppStorePromoteConfigBean<QFile>", 1, "onParse: but configContent is null!");
    }
    this.d = paramString;
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("actionSwitch")) {
        this.a = paramString.getBoolean("actionSwitch");
      }
      if (paramString.has("actionHint")) {
        this.b = paramString.getString("actionHint");
      }
      if (paramString.has("actionYYBDownloadUrl"))
      {
        this.c = paramString.getString("actionYYBDownloadUrl");
        return;
      }
    }
    catch (JSONException paramString)
    {
      QLog.e("QFileAppStorePromoteConfigBean<QFile>", 1, QLog.getStackTraceString(paramString));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileAppStorePromoteConfigBean
 * JD-Core Version:    0.7.0.1
 */