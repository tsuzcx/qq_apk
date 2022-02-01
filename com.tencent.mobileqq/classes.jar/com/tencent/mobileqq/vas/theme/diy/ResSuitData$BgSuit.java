package com.tencent.mobileqq.vas.theme.diy;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class ResSuitData$BgSuit
  extends ResSuitData
{
  public boolean a;
  public String f;
  public String g;
  
  public ResSuitData$BgSuit(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {}
    try
    {
      localJSONArray = paramJSONObject.getJSONObject("data").getJSONArray("diyThemeBg");
      localJSONObject = null;
      i = 0;
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
          int i;
          int j;
          continue;
          i += 1;
        }
      } while (localObject != null);
    }
    j = localJSONArray.length();
    localObject = localJSONObject;
    if (i < j)
    {
      localJSONObject = localJSONArray.getJSONObject(i);
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
          this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("id");
          this.d = paramJSONObject.optString("app");
          this.e = paramJSONObject.optString("type");
          this.c = paramJSONObject.optString("name");
          this.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("feeType");
          this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("thumbnail");
          this.f = ((JSONObject)localObject).optString("previewImg");
          this.g = ((JSONObject)localObject).optString("aioImg");
          this.jdField_a_of_type_Boolean = true;
          return;
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("theme BgSuit JSONErr name:");
          paramJSONObject.append(this.c);
          paramJSONObject.append(", id:");
          paramJSONObject.append(this.jdField_b_of_type_JavaLangString);
          QLog.e("ThemeDiy.ResSuitData", 1, paramJSONObject.toString());
          return;
        }
      }
    }
    label280:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.diy.ResSuitData.BgSuit
 * JD-Core Version:    0.7.0.1
 */