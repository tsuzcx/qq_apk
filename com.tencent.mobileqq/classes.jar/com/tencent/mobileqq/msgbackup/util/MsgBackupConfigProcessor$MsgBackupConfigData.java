package com.tencent.mobileqq.msgbackup.util;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class MsgBackupConfigProcessor$MsgBackupConfigData
{
  private boolean a;
  
  public static MsgBackupConfigData a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        MsgBackupConfigData localMsgBackupConfigData = new MsgBackupConfigData();
        int i = new JSONObject(paramString).optInt("isChatMigrateEnable", 0);
        bool = true;
        if (i == 1)
        {
          localMsgBackupConfigData.a = bool;
          return localMsgBackupConfigData;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("MsgBackupConfigProcessor", 2, "MsgBackupConfigData parse error", paramString);
        return null;
      }
      boolean bool = false;
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.util.MsgBackupConfigProcessor.MsgBackupConfigData
 * JD-Core Version:    0.7.0.1
 */