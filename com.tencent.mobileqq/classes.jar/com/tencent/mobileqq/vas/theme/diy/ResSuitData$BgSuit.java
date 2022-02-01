package com.tencent.mobileqq.vas.theme.diy;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class ResSuitData$BgSuit
  extends ResSuitData
{
  public String h;
  public String i;
  public boolean j;
  
  public ResSuitData$BgSuit(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {}
    try
    {
      localJSONArray = paramJSONObject.getJSONObject("data").getJSONArray("diyThemeBg");
      localJSONObject = null;
      k = 0;
    }
    catch (Exception paramJSONObject)
    {
      Object localObject;
      do
      {
        for (;;)
        {
          JSONArray localJSONArray;
          JSONObject localJSONObject;
          int k;
          int m;
          continue;
          k += 1;
        }
      } while (localObject != null);
    }
    m = localJSONArray.length();
    localObject = localJSONObject;
    if (k < m)
    {
      localJSONObject = localJSONArray.getJSONObject(k);
      localObject = localJSONObject;
      if (localJSONObject.optInt("status", 1) != 1) {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("loadResJson bg status: ");
          ((StringBuilder)localObject).append(localJSONObject.optInt("status"));
          ((StringBuilder)localObject).append(", name:");
          ((StringBuilder)localObject).append(paramJSONObject.getString("name"));
          QLog.d("ThemeDiy.ResSuitData", 2, ((StringBuilder)localObject).toString());
          break label280;
          this.b = paramJSONObject.optString("id");
          this.f = paramJSONObject.optString("app");
          this.g = paramJSONObject.optString("type");
          this.d = paramJSONObject.optString("name");
          this.e = ((JSONObject)localObject).optInt("feeType");
          this.a = ((JSONObject)localObject).optString("thumbnail");
          this.h = ((JSONObject)localObject).optString("previewImg");
          this.i = ((JSONObject)localObject).optString("aioImg");
          this.j = true;
          return;
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("theme BgSuit JSONErr name:");
          paramJSONObject.append(this.d);
          paramJSONObject.append(", id:");
          paramJSONObject.append(this.b);
          QLog.e("ThemeDiy.ResSuitData", 1, paramJSONObject.toString());
          return;
        }
      }
    }
    label280:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.diy.ResSuitData.BgSuit
 * JD-Core Version:    0.7.0.1
 */