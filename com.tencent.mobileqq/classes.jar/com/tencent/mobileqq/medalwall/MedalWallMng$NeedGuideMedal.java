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
  public String c;
  
  public MedalWallMng$NeedGuideMedal()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    for (;;)
    {
      try
      {
        localJSONArray = new JSONArray(this.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.strResJson);
        localJSONObject = null;
        i = localJSONArray.length();
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iLevelCount <= 1) || (i <= this.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iLevel)) {
          continue;
        }
        localJSONObject = localJSONArray.getJSONObject(this.jdField_a_of_type_ComTencentMobileqqDataMedalInfo.iLevel);
        if ((localJSONObject != null) && (localJSONObject.has("owned3d"))) {
          this.jdField_a_of_type_JavaLangString = MedalWallMng.a(localJSONObject.getString("owned3d"));
        }
        if ((localJSONObject != null) && (localJSONObject.has("share"))) {
          this.c = MedalWallMng.a(localJSONObject.getString("share"));
        }
      }
      catch (Exception localException)
      {
        JSONArray localJSONArray;
        JSONObject localJSONObject;
        int i;
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("MedalWallMng", 2, "parse res json fail", localException);
        continue;
        if (this.jdField_a_of_type_Int != 1) {
          continue;
        }
        this.jdField_a_of_type_Boolean = true;
        continue;
        if (!FileUtils.b(this.b)) {
          continue;
        }
        this.jdField_a_of_type_Boolean = true;
        continue;
      }
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(this.b))) {
        this.b = (MedalWallMng.b + MD5Utils.d(this.jdField_a_of_type_JavaLangString));
      }
      if (this.jdField_a_of_type_Int != 2) {
        continue;
      }
      this.jdField_a_of_type_Boolean = true;
      return this.jdField_a_of_type_Boolean;
      if (i > 1) {
        localJSONObject = localJSONArray.getJSONObject(1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.MedalWallMng.NeedGuideMedal
 * JD-Core Version:    0.7.0.1
 */