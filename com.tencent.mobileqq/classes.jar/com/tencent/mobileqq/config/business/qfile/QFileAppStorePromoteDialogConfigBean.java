package com.tencent.mobileqq.config.business.qfile;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.api.util.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QFileAppStorePromoteDialogConfigBean
  implements IQFileAppStorePromoteDialogConfigBean, IQStorageSafable<String>
{
  public boolean a = false;
  public String b = "{}";
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("QFileAppStorePromoteDialogConfigBean<QFile>", 1, "onParse: but configContent is null!");
    }
    this.b = paramString;
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("dialogSwitch"))
      {
        this.a = paramString.getBoolean("dialogSwitch");
        return;
      }
    }
    catch (JSONException paramString)
    {
      QLog.e("QFileAppStorePromoteDialogConfigBean<QFile>", 1, QLog.getStackTraceString(paramString));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QFileAppStorePromoteDialogConfigBean
 * JD-Core Version:    0.7.0.1
 */