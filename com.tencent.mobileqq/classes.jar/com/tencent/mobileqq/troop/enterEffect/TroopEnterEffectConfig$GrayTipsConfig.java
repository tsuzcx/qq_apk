package com.tencent.mobileqq.troop.entereffect;

import QQService.EVIPSPEC;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class TroopEnterEffectConfig$GrayTipsConfig
{
  private static final String d;
  public int a;
  public String a;
  public ArrayList<TroopEnterEffectConfig.GrayTipsConfig.Link> a;
  public boolean a;
  public int b;
  public String b;
  public ArrayList<Integer> b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  public int e;
  public int f;
  public int g;
  
  static
  {
    jdField_d_of_type_JavaLangString = HardCodeUtil.a(2131715086);
  }
  
  public TroopEnterEffectConfig$GrayTipsConfig()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static int a(AppRuntime paramAppRuntime)
  {
    String str = paramAppRuntime.getCurrentUin();
    paramAppRuntime = (IFriendDataService)paramAppRuntime.getRuntimeService(IFriendDataService.class, "all");
    int j = 1;
    paramAppRuntime = paramAppRuntime.getFriend(str, true);
    int i = j;
    if (paramAppRuntime != null)
    {
      boolean bool = paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
      if (paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP))
      {
        if (paramAppRuntime.getServiceType(EVIPSPEC.E_SP_SUPERVIP) == 1) {
          return 22;
        }
        return 5;
      }
      i = j;
      if (bool)
      {
        if (paramAppRuntime.getServiceType(EVIPSPEC.E_SP_QQVIP) == 1) {
          return 21;
        }
        i = 4;
      }
    }
    return i;
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
      if (i < this.jdField_a_of_type_JavaLangString.length() - 1)
      {
        String str1 = this.jdField_a_of_type_JavaLangString;
        j = i + 1;
        if (str1.charAt(j) == '(')
        {
          i += 2;
          int m = this.jdField_a_of_type_JavaLangString.indexOf(')', i);
          if (m > 0)
          {
            str1 = this.jdField_a_of_type_JavaLangString.substring(i, m);
            Object localObject = new StringBuilder();
            ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString.substring(0, i - 1));
            String str2 = this.jdField_a_of_type_JavaLangString;
            ((StringBuilder)localObject).append(str2.substring(m + 1, str2.length()));
            this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
            localObject = new TroopEnterEffectConfig.GrayTipsConfig.Link();
            ((TroopEnterEffectConfig.GrayTipsConfig.Link)localObject).jdField_a_of_type_Int = k;
            ((TroopEnterEffectConfig.GrayTipsConfig.Link)localObject).jdField_b_of_type_Int = j;
            ((TroopEnterEffectConfig.GrayTipsConfig.Link)localObject).jdField_a_of_type_JavaLangString = str1;
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
          }
        }
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      QLog.e("GrayTipsConfig.GrayTips", 1, "mergeFromJson error grayTipsObj == null");
      return;
    }
    this.jdField_a_of_type_Int = paramJSONObject.optInt("id");
    int j = paramJSONObject.optInt("isValid");
    int i = 0;
    boolean bool;
    if (j == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    this.jdField_b_of_type_Int = paramJSONObject.optInt("priority");
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("wording");
    a();
    if (paramJSONObject.optInt("noLongerPrompt") == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_b_of_type_Boolean = bool;
    Object localObject;
    if (this.jdField_b_of_type_Boolean)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    }
    this.jdField_c_of_type_Int = paramJSONObject.optInt("linkType");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("serviceCode");
    this.jdField_d_of_type_Int = paramJSONObject.optInt("hardType");
    this.e = paramJSONObject.optInt("openMonth");
    this.f = paramJSONObject.optInt("hardMonth");
    this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("aidAndroid");
    try
    {
      localObject = paramJSONObject.optJSONArray("vipType");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {
        while (i < ((JSONArray)localObject).length())
        {
          this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(((JSONArray)localObject).getInt(i)));
          i += 1;
        }
      }
      StringBuilder localStringBuilder;
      return;
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mergeFromJson error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("GrayTipsConfig.GrayTips", 1, localStringBuilder.toString());
      this.g = paramJSONObject.optInt("settingStatus");
    }
  }
  
  public boolean a(int paramInt, AppRuntime paramAppRuntime)
  {
    int i = a(paramAppRuntime);
    boolean bool3 = this.jdField_a_of_type_Boolean;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      int j = this.g;
      if (paramInt != j)
      {
        bool1 = bool2;
        if (j != 0) {}
      }
      else if (!this.jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(i)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectConfig.GrayTipsConfig
 * JD-Core Version:    0.7.0.1
 */