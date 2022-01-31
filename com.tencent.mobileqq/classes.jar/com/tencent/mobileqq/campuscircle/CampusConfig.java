package com.tencent.mobileqq.campuscircle;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.json.JSONObject;

public class CampusConfig
{
  public int a;
  public long a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  
  public CampusConfig()
  {
    this.jdField_a_of_type_JavaLangString = "http://ti.qq.com/campusschool/index.html?_wv=3";
    this.jdField_b_of_type_JavaLangString = "https://ti.qq.com/campus/register.html?adtag=edit&_qStyle=1";
    this.jdField_c_of_type_JavaLangString = "http://ti.qq.com/campus/userFeeds.html?_wv=67118055&_wwv=4&adtag=info_card";
    this.jdField_a_of_type_Int = 6;
    this.jdField_a_of_type_Long = (this.jdField_a_of_type_Int * 30 * 86400L);
    this.jdField_b_of_type_Int = 10;
    this.jdField_c_of_type_Int = 1;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        if (!localJSONObject.has("searchSchoolUrl")) {
          continue;
        }
        this.jdField_a_of_type_JavaLangString = localJSONObject.getString("searchSchoolUrl");
        if (!localJSONObject.has("maxUniversityYear")) {
          continue;
        }
        this.jdField_b_of_type_Int = localJSONObject.getInt("maxUniversityYear");
      }
      catch (Exception localException)
      {
        JSONObject localJSONObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(CampusConfig.class.getSimpleName(), 2, "parse", localException);
        localException.printStackTrace();
        continue;
        this.jdField_b_of_type_Int = 10;
        continue;
        this.jdField_a_of_type_Int = 6;
        continue;
        this.jdField_b_of_type_JavaLangString = "https://ti.qq.com/campus/register.html?adtag=edit&_qStyle=1";
        continue;
        this.jdField_c_of_type_JavaLangString = "http://ti.qq.com/campus/userFeeds.html?_wv=67118055&_wwv=4&adtag=info_card";
        continue;
        this.jdField_c_of_type_Int = 1;
        continue;
      }
      if (!localJSONObject.has("minModifySchoolInterval")) {
        continue;
      }
      this.jdField_a_of_type_Int = localJSONObject.getInt("minModifySchoolInterval");
      if (!localJSONObject.has("certificationUrl")) {
        continue;
      }
      this.jdField_b_of_type_JavaLangString = localJSONObject.getString("certificationUrl");
      if (!localJSONObject.has("campusFeedUrl")) {
        continue;
      }
      this.jdField_c_of_type_JavaLangString = localJSONObject.getString("campusFeedUrl");
      if (!localJSONObject.has("forceSelectTopic")) {
        continue;
      }
      this.jdField_c_of_type_Int = localJSONObject.getInt("forceSelectTopic");
      this.jdField_a_of_type_Long = (this.jdField_a_of_type_Int * 30 * 86400L);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i(CampusConfig.class.getSimpleName(), 4, String.format(Locale.getDefault(), "parse config: %s", new Object[] { paramString }));
      return;
      this.jdField_a_of_type_JavaLangString = "http://ti.qq.com/campusschool/index.html?_wv=3";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusConfig
 * JD-Core Version:    0.7.0.1
 */