package com.tencent.mobileqq.vas.hippy;

import android.text.TextUtils;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class VasHippyUtils
{
  public static HippyMap a(int paramInt, String paramString, Object paramObject)
  {
    HippyMap localHippyMap = new HippyMap();
    try
    {
      localHippyMap.pushInt("result", paramInt);
      if (!TextUtils.isEmpty(paramString)) {
        localHippyMap.pushString("message", paramString);
      }
      if (paramObject != null)
      {
        boolean bool = paramObject instanceof JSONObject;
        if (bool)
        {
          localHippyMap.pushJSONObject(new JSONObject().put("data", paramObject));
          return localHippyMap;
        }
        localHippyMap.pushObject("data", paramObject);
        return localHippyMap;
      }
    }
    catch (Exception paramString)
    {
      paramObject = new StringBuilder();
      paramObject.append("newRspObj error");
      paramObject.append(paramString);
      QLog.e("VasHippyUtils", 1, paramObject.toString());
    }
    return localHippyMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.VasHippyUtils
 * JD-Core Version:    0.7.0.1
 */