package com.tencent.mobileqq.richmediabrowser.config;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ListConfigParseUtils
{
  public static List<MachineInfo> a(String paramString)
  {
    localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("LiuHaiArray"))
        {
          paramString = paramString.getJSONArray("LiuHaiArray");
          int i = 0;
          while (i < paramString.length())
          {
            MachineInfo localMachineInfo = new MachineInfo();
            JSONObject localJSONObject = paramString.getJSONObject(i);
            if (localJSONObject.has("manufacturer")) {
              localMachineInfo.a = localJSONObject.optString("manufacturer", "");
            }
            if (localJSONObject.has("brand")) {
              localMachineInfo.b = localJSONObject.optString("brand", "");
            }
            if (localJSONObject.has("model")) {
              localMachineInfo.c = localJSONObject.optString("model", "");
            }
            localArrayList.add(localMachineInfo);
            i += 1;
          }
        }
        return localArrayList;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("ListConfigParseUtils", 2, "parseWhiteListConfig exception = " + paramString.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.config.ListConfigParseUtils
 * JD-Core Version:    0.7.0.1
 */