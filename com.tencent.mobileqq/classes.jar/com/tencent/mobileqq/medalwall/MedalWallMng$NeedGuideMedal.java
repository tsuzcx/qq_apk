package com.tencent.mobileqq.medalwall;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MedalInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class MedalWallMng$NeedGuideMedal
{
  public int a;
  public MedalInfo a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public String c = null;
  
  public MedalWallMng$NeedGuideMedal()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      try
      {
        JSONArray localJSONArray = new JSONArray(this.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.strResJson);
        JSONObject localJSONObject = null;
        i = localJSONArray.length();
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iLevelCount > 1) && (i > this.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iLevel)) {
          localJSONObject = localJSONArray.getJSONObject(this.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iLevel);
        } else if (i > 1) {
          localJSONObject = localJSONArray.getJSONObject(1);
        }
        if ((localJSONObject != null) && (localJSONObject.has("owned3d"))) {
          this.jdField_a_of_type_JavaLangString = MedalWallMng.a(localJSONObject.getString("owned3d"));
        }
        if ((localJSONObject != null) && (localJSONObject.has("share"))) {
          this.c = MedalWallMng.a(localJSONObject.getString("share"));
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("MedalWallMng", 2, "parse res json fail", localException);
        }
      }
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(MedalWallMng.jdField_b_of_type_JavaLangString);
      localStringBuilder.append(MD5Utils.toMD5(this.jdField_a_of_type_JavaLangString));
      this.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    }
    int i = this.jdField_a_of_type_Int;
    if (i == 2) {
      this.jdField_a_of_type_Boolean = true;
    } else if (i == 1) {
      this.jdField_a_of_type_Boolean = true;
    } else if (FileUtils.fileExistsAndNotEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_Boolean = true;
    }
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.MedalWallMng.NeedGuideMedal
 * JD-Core Version:    0.7.0.1
 */