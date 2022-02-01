package com.tencent.mobileqq.config.business;

import android.support.v4.util.ArraySet;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class BroadcastConfProcessor$BroadcastConfBean
{
  public ArraySet<String> a = new ArraySet();
  
  public static BroadcastConfBean a(String paramString)
  {
    localBroadcastConfBean = new BroadcastConfBean();
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("white_list");
      int i = 0;
      while (i < paramString.length())
      {
        localBroadcastConfBean.a.add(paramString.optString(i, ""));
        i += 1;
      }
      return localBroadcastConfBean;
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BroadcastConfProcessor", 2, paramString, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.BroadcastConfProcessor.BroadcastConfBean
 * JD-Core Version:    0.7.0.1
 */