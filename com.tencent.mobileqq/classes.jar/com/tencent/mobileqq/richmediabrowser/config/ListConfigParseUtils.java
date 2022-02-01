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
        Object localObject;
        if (paramString.has("LiuHaiArray"))
        {
          paramString = paramString.getJSONArray("LiuHaiArray");
          int i = 0;
          while (i < paramString.length())
          {
            localObject = new MachineInfo();
            JSONObject localJSONObject = paramString.getJSONObject(i);
            boolean bool = localJSONObject.has("manufacturer");
            if (bool) {
              ((MachineInfo)localObject).a = localJSONObject.optString("manufacturer", "");
            }
            if (localJSONObject.has("brand")) {
              ((MachineInfo)localObject).b = localJSONObject.optString("brand", "");
            }
            if (localJSONObject.has("model")) {
              ((MachineInfo)localObject).c = localJSONObject.optString("model", "");
            }
            localArrayList.add(localObject);
            i += 1;
          }
        }
        return localArrayList;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("parseWhiteListConfig exception = ");
          ((StringBuilder)localObject).append(paramString.getMessage());
          QLog.d("ListConfigParseUtils", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.config.ListConfigParseUtils
 * JD-Core Version:    0.7.0.1
 */