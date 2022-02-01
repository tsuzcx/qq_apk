package com.tencent.mobileqq.profile.diy;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class VipProfileDiyCardConfig
{
  public static SparseArray<String> a;
  public static int b = 50;
  public static String c = HardCodeUtil.a(2131913694);
  private static AtomicBoolean d = new AtomicBoolean(false);
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {}
    try
    {
      QLog.e("VipProfileDiyCardConfig", 1, "parseJson, app null");
      return;
    }
    finally
    {
      for (;;)
      {
        boolean bool;
        JSONObject localJSONObject;
        JSONArray localJSONArray;
        int j;
        String str;
        for (;;)
        {
          throw paramAppRuntime;
        }
        int i = 0;
        continue;
        i += 1;
      }
    }
    bool = d.compareAndSet(false, true);
    if (!bool) {
      return;
    }
    localJSONObject = VasUpdateUtil.a(paramAppRuntime, "card.diyFontConfig.json", true, null);
    if (localJSONObject != null)
    {
      localJSONArray = localJSONObject.optJSONArray("fontList");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        if (a == null)
        {
          a = new SparseArray();
          break label253;
        }
        a.clear();
        break label253;
        if (i < localJSONArray.length())
        {
          paramAppRuntime = localJSONArray.optJSONObject(i);
          j = paramAppRuntime.optInt("id");
          str = paramAppRuntime.optString("imgUrl");
          if (TextUtils.isEmpty(str)) {
            break label258;
          }
          paramAppRuntime = str;
          if (!str.startsWith("http:"))
          {
            paramAppRuntime = str;
            if (!str.startsWith("https:"))
            {
              paramAppRuntime = new StringBuilder();
              paramAppRuntime.append("http:");
              paramAppRuntime.append(str);
              paramAppRuntime = paramAppRuntime.toString();
            }
          }
          a.put(j, paramAppRuntime);
          break label258;
        }
      }
      b = localJSONObject.optInt("maxTextLength", b);
      c = localJSONObject.optString("inputTip", c);
    }
    else
    {
      d.set(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.diy.VipProfileDiyCardConfig
 * JD-Core Version:    0.7.0.1
 */