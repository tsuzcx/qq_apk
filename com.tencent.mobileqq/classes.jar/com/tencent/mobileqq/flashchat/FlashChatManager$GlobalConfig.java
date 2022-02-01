package com.tencent.mobileqq.flashchat;

import com.tencent.mobileqq.config.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class FlashChatManager$GlobalConfig
  implements IQStorageSafable<String>
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public String h = "1";
  public String i = "";
  
  public FlashChatManager$GlobalConfig()
  {
    this.jdField_a_of_type_JavaLangString = "1";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 2;
    this.jdField_b_of_type_Int = 2;
    this.jdField_c_of_type_Int = 2;
    this.jdField_d_of_type_Int = 3;
    this.jdField_e_of_type_Int = 3;
    this.jdField_f_of_type_Int = 60;
    this.jdField_g_of_type_Int = 60;
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_JavaLangString = paramString.optString("entry", "1");
      this.jdField_b_of_type_JavaLangString = paramString.optString("name", null);
      this.jdField_d_of_type_JavaLangString = paramString.optString("icon", null);
      this.jdField_f_of_type_JavaLangString = paramString.optString("actionI", null);
      this.jdField_g_of_type_JavaLangString = paramString.optString("actionA", null);
      this.jdField_c_of_type_JavaLangString = paramString.optString("url", null);
      this.jdField_a_of_type_Int = paramString.optInt("scC", 2);
      this.jdField_b_of_type_Int = paramString.optInt("hiC", 2);
      this.jdField_c_of_type_Int = paramString.optInt("flC", 2);
      this.jdField_d_of_type_Int = paramString.optInt("piC", 3);
      this.jdField_e_of_type_Int = paramString.optInt("tvC", 3);
      this.h = paramString.optString("recordRule", "1");
      this.jdField_f_of_type_Int = paramString.optInt("pIn", 60);
      this.jdField_g_of_type_Int = paramString.optInt("tvI", 60);
      this.jdField_a_of_type_Boolean = "1".equals(paramString.optString("qimNotifyEnable", "0"));
      this.jdField_b_of_type_Boolean = "1".equals(paramString.optString("qimPopUpEnable", "0"));
      this.i = paramString.optString("qimNotifySource", "");
      this.jdField_e_of_type_JavaLangString = paramString.optString("qimNotifyLogo", "");
      return;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleFlashChatConfig failed");
      localStringBuilder.append(paramString);
      QLog.e("FlashChat", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatManager.GlobalConfig
 * JD-Core Version:    0.7.0.1
 */