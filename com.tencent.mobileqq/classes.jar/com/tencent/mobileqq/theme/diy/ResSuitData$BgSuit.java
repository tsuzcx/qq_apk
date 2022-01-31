package com.tencent.mobileqq.theme.diy;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class ResSuitData$BgSuit
  extends ResSuitData
{
  public String aioImg;
  public boolean isdecoded;
  public String previewImg;
  public ResData resData;
  
  public ResSuitData$BgSuit(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      JSONObject localJSONObject2;
      label243:
      do
      {
        for (;;)
        {
          int i;
          try
          {
            JSONArray localJSONArray = paramJSONObject.getJSONObject("data").getJSONArray("diyThemeBg");
            JSONObject localJSONObject1 = null;
            i = 0;
            localJSONObject2 = localJSONObject1;
            if (i >= localJSONArray.length()) {
              break;
            }
            localJSONObject1 = localJSONArray.getJSONObject(i);
            localJSONObject2 = localJSONObject1;
            if (localJSONObject1.optInt("status", 1) == 1) {
              break;
            }
            if (!QLog.isColorLevel()) {
              break label243;
            }
            QLog.d("ThemeDiy.ResSuitData", 2, "loadResJson bg status: " + localJSONObject1.optInt("status") + ", name:" + paramJSONObject.getString("name"));
          }
          catch (Exception paramJSONObject)
          {
            QLog.e("ThemeDiy.ResSuitData", 1, "theme BgSuit JSONErr name:" + this.name + ", id:" + this.id);
            return;
          }
          this.id = paramJSONObject.optString("id");
          this.appStr = paramJSONObject.optString("app");
          this.typeStr = paramJSONObject.optString("type");
          this.name = paramJSONObject.optString("name");
          this.feeType = localJSONObject2.optInt("feeType");
          this.thumbnail = localJSONObject2.optString("thumbnail");
          this.previewImg = localJSONObject2.optString("previewImg");
          this.aioImg = localJSONObject2.optString("aioImg");
          this.isdecoded = true;
          return;
          i += 1;
        }
      } while (localJSONObject2 != null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ResSuitData.BgSuit
 * JD-Core Version:    0.7.0.1
 */