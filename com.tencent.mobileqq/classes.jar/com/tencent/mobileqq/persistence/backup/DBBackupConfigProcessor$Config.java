package com.tencent.mobileqq.persistence.backup;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public final class DBBackupConfigProcessor$Config
{
  private boolean a = false;
  
  private void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Config parse configText -> ");
    localStringBuilder.append(paramString);
    QLog.d("DBBackupConfigProcessor", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        if (new JSONObject(paramString).optInt("backup_master_switch", 0) != 1) {
          break label80;
        }
        bool = true;
        this.a = bool;
        return;
      }
      catch (JSONException paramString)
      {
        QLog.e("DBBackupConfigProcessor", 1, paramString, new Object[0]);
      }
      return;
      label80:
      boolean bool = false;
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.backup.DBBackupConfigProcessor.Config
 * JD-Core Version:    0.7.0.1
 */