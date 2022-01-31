package com.tencent.mobileqq.troop.data;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopCreateLogic$TroopCreateInfo
{
  public int a;
  public TroopCreateAdvanceData a;
  public String a;
  public ArrayList a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public String e;
  public String f;
  
  public TroopCreateLogic$TroopCreateInfo()
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    b();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateAdvanceData = new TroopCreateAdvanceData();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateAdvanceData.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateAdvanceData.a = new byte[0];
  }
  
  public void a(String paramString)
  {
    boolean bool = true;
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_Int = paramString.optInt("classify", 0);
      this.jdField_b_of_type_Int = paramString.optInt("verifyType", 2);
      this.jdField_a_of_type_JavaLangString = paramString.optString("classificationInfo", "");
      this.jdField_b_of_type_JavaLangString = paramString.optString("name", "");
      this.jdField_d_of_type_JavaLangString = paramString.optString("introduction", "");
      this.e = paramString.optString("location", "");
      this.jdField_c_of_type_Int = paramString.optInt("group_type", -1);
      if (paramString.optInt("isJumpAio") == 1) {}
      for (;;)
      {
        this.jdField_b_of_type_Boolean = bool;
        this.jdField_d_of_type_Int = paramString.optInt("create_source", 0);
        return;
        bool = false;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.e = "";
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateAdvanceData = null;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateInfo
 * JD-Core Version:    0.7.0.1
 */