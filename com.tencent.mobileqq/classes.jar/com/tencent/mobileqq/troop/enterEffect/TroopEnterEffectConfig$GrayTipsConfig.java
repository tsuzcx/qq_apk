package com.tencent.mobileqq.troop.enterEffect;

import QQService.EVIPSPEC;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
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
    jdField_d_of_type_JavaLangString = HardCodeUtil.a(2131715163);
  }
  
  public TroopEnterEffectConfig$GrayTipsConfig()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    String str = paramQQAppInterface.getCurrentUin();
    paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(str);
    if (paramQQAppInterface != null)
    {
      boolean bool = paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
      if (paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP))
      {
        if (paramQQAppInterface.getServiceType(EVIPSPEC.E_SP_SUPERVIP) == 1) {
          return 22;
        }
        return 5;
      }
      if (bool)
      {
        if (paramQQAppInterface.getServiceType(EVIPSPEC.E_SP_QQVIP) == 1) {
          return 21;
        }
        return 4;
      }
    }
    return 1;
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
        break label236;
      }
    }
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        this.jdField_b_of_type_Boolean = bool;
        if (this.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_JavaLangString += jdField_d_of_type_JavaLangString;
        }
        this.jdField_c_of_type_Int = paramJSONObject.optInt("linkType");
        this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("serviceCode");
        this.jdField_d_of_type_Int = paramJSONObject.optInt("hardType");
        this.e = paramJSONObject.optInt("openMonth");
        this.f = paramJSONObject.optInt("hardMonth");
        this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("aidAndroid");
        try
        {
          JSONArray localJSONArray = paramJSONObject.optJSONArray("vipType");
          if ((localJSONArray == null) || (localJSONArray.length() <= 0)) {
            break label272;
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
          label236:
          QLog.e("TroopEnterEffect.GrayTips", 1, "mergeFromJson error: " + localException.getMessage());
          this.g = paramJSONObject.optInt("settingStatus");
        }
      }
    }
    label272:
  }
  
  public boolean a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    int i = a(paramQQAppInterface);
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Boolean) {
      if (paramInt != this.g)
      {
        bool1 = bool2;
        if (this.g != 0) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectConfig.GrayTipsConfig
 * JD-Core Version:    0.7.0.1
 */