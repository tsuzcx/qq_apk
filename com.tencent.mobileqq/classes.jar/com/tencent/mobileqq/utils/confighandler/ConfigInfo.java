package com.tencent.mobileqq.utils.confighandler;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public abstract class ConfigInfo
{
  public int _parseRet = -1;
  public String mUin;
  public long serverVer;
  public int task_id;
  
  protected abstract boolean parse(JSONObject paramJSONObject);
  
  public final void setUin(String paramString)
  {
    this.mUin = paramString;
  }
  
  public final boolean tryParse(String paramString1, String paramString2)
  {
    for (int i = 1;; i = 0) {
      try
      {
        if (TextUtils.isEmpty(paramString2))
        {
          QLog.d(paramString1, 1, "parseJson, jsonContent为空");
          return true;
        }
        paramString2 = new JSONObject(paramString2);
        this.task_id = paramString2.optInt("task_id");
        boolean bool = parse(paramString2);
        if (bool)
        {
          this._parseRet = i;
          return bool;
        }
      }
      catch (Exception paramString2)
      {
        QLog.d(paramString1, 1, "parseJson, Exception", paramString2);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.ConfigInfo
 * JD-Core Version:    0.7.0.1
 */