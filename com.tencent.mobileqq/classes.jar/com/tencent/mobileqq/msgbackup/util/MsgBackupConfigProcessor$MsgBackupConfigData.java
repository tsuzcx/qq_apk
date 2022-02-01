package com.tencent.mobileqq.msgbackup.util;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class MsgBackupConfigProcessor$MsgBackupConfigData
{
  private boolean a;
  
  public static MsgBackupConfigData a(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      return null;
    }
    try
    {
      MsgBackupConfigData localMsgBackupConfigData = new MsgBackupConfigData();
      if (new JSONObject(paramString).optInt("isChatMigrateEnable", 0) == 1) {}
      for (;;)
      {
        localMsgBackupConfigData.a = bool;
        return localMsgBackupConfigData;
        bool = false;
      }
      return null;
    }
    catch (Exception paramString)
    {
      QLog.e("MsgBackupConfigProcessor", 2, "MsgBackupConfigData parse error", paramString);
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.util.MsgBackupConfigProcessor.MsgBackupConfigData
 * JD-Core Version:    0.7.0.1
 */