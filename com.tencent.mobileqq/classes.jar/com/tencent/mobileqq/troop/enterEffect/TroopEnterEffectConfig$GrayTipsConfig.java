package com.tencent.mobileqq.troop.enterEffect;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class TroopEnterEffectConfig$GrayTipsConfig
{
  public int a;
  public String a;
  public ArrayList a;
  public boolean a;
  public int b;
  public String b;
  public ArrayList b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  public int e;
  public int f;
  public int g;
  
  public TroopEnterEffectConfig$GrayTipsConfig()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private void a()
  {
    while (this.jdField_a_of_type_JavaLangString.indexOf('[') > 0)
    {
      int k = this.jdField_a_of_type_JavaLangString.indexOf('[');
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.replaceFirst("\\[", "");
      int j = this.jdField_a_of_type_JavaLangString.indexOf(']', k);
      int i = j;
      if (j > 0)
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.replaceFirst("]", "");
        i = j - 1;
      }
      if ((i < this.jdField_a_of_type_JavaLangString.length() - 1) && (this.jdField_a_of_type_JavaLangString.charAt(i + 1) == '('))
      {
        j = i + 2;
        int m = this.jdField_a_of_type_JavaLangString.indexOf(')', j);
        if (m > 0)
        {
          String str = this.jdField_a_of_type_JavaLangString.substring(j, m);
          this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString.substring(0, j - 1) + this.jdField_a_of_type_JavaLangString.substring(m + 1, this.jdField_a_of_type_JavaLangString.length()));
          TroopEnterEffectConfig.GrayTipsConfig.Link localLink = new TroopEnterEffectConfig.GrayTipsConfig.Link();
          localLink.jdField_a_of_type_Int = k;
          localLink.jdField_b_of_type_Int = (i + 1);
          localLink.jdField_a_of_type_JavaLangString = str;
          this.jdField_a_of_type_JavaUtilArrayList.add(localLink);
        }
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    int i = 0;
    if (paramJSONObject == null)
    {
      QLog.e("TroopEnterEffect.GrayTips", 1, "mergeFromJson error grayTipsObj == null");
      return;
    }
    this.jdField_a_of_type_Int = paramJSONObject.optInt("id");
    if (paramJSONObject.optInt("isValid") == 1)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_b_of_type_Int = paramJSONObject.optInt("priority");
      this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("wording");
      a();
      if (paramJSONObject.optInt("noLongerPrompt") != 1) {
        break label235;
      }
    }
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        this.jdField_b_of_type_Boolean = bool;
        if (this.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_JavaLangString += "不再提示";
        }
        this.jdField_c_of_type_Int = paramJSONObject.optInt("linkType");
        this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("serviceCode");
        this.d = paramJSONObject.optInt("hardType");
        this.e = paramJSONObject.optInt("openMonth");
        this.f = paramJSONObject.optInt("hardMonth");
        this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("aidAndroid");
        try
        {
          JSONArray localJSONArray = paramJSONObject.optJSONArray("vipType");
          if ((localJSONArray == null) || (localJSONArray.length() <= 0)) {
            break label271;
          }
          while (i < localJSONArray.length())
          {
            this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(localJSONArray.getInt(i)));
            i += 1;
          }
          bool = false;
        }
        catch (Exception localException)
        {
          label235:
          QLog.e("TroopEnterEffect.GrayTips", 1, "mergeFromJson error: " + localException.getMessage());
          this.g = paramJSONObject.optInt("settingStatus");
        }
      }
    }
    label271:
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Boolean) {
      if (paramInt1 != this.g)
      {
        bool1 = bool2;
        if (this.g != 0) {}
      }
      else if (!this.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt2)))
      {
        bool1 = bool2;
        if (!this.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(0))) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectConfig.GrayTipsConfig
 * JD-Core Version:    0.7.0.1
 */