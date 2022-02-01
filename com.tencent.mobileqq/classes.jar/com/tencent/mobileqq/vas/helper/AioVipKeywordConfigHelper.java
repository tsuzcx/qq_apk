package com.tencent.mobileqq.vas.helper;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONObject;

public class AioVipKeywordConfigHelper
{
  private static AioVipKeywordConfigHelper jdField_a_of_type_ComTencentMobileqqVasHelperAioVipKeywordConfigHelper;
  static String jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131700366);
  static String b;
  static String c = HardCodeUtil.a(2131700365);
  static String d = HardCodeUtil.a(2131700363);
  public int a;
  public boolean a;
  public String[] a;
  public String[] b;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  
  static
  {
    jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131700364);
  }
  
  public AioVipKeywordConfigHelper()
  {
    this.jdField_a_of_type_Int = 1;
    String str1 = jdField_a_of_type_JavaLangString;
    this.e = str1;
    String str2 = jdField_b_of_type_JavaLangString;
    this.f = str2;
    String str3 = c;
    this.g = str3;
    String str4 = d;
    this.h = str4;
    this.i = str1;
    this.j = str3;
    this.k = str2;
    this.l = str4;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static AioVipKeywordConfigHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqVasHelperAioVipKeywordConfigHelper == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqVasHelperAioVipKeywordConfigHelper == null) {
          jdField_a_of_type_ComTencentMobileqqVasHelperAioVipKeywordConfigHelper = new AioVipKeywordConfigHelper();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqVasHelperAioVipKeywordConfigHelper;
  }
  
  private void a(String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("grayTail")) {
      paramJSONObject = paramJSONObject.getString("grayTail");
    } else {
      paramJSONObject = null;
    }
    int i1 = 0;
    this.jdField_a_of_type_Boolean = false;
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      paramJSONObject = paramJSONObject.split(";");
      while (i1 < paramJSONObject.length)
      {
        CharSequence localCharSequence = paramJSONObject[i1];
        if ((!TextUtils.isEmpty(localCharSequence)) && (paramString.endsWith(localCharSequence.trim())))
        {
          this.jdField_a_of_type_Boolean = true;
          return;
        }
        i1 += 1;
      }
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("groupKeywords")) {
      paramJSONObject = paramJSONObject.optString("groupKeywords");
    } else {
      paramJSONObject = null;
    }
    Object localObject;
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      localObject = new ArrayList();
      String[] arrayOfString = paramJSONObject.split(";");
      int i1 = 0;
      while (i1 < arrayOfString.length)
      {
        String str = arrayOfString[i1];
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(str.trim()))) {
          ((ArrayList)localObject).add(str.trim().toLowerCase());
        }
        i1 += 1;
      }
      this.jdField_b_of_type_ArrayOfJavaLangString = ((String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]));
    }
    else
    {
      this.jdField_b_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("keyword = ");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.d("AioVipKeywordConfigHelper", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("keyword")) {
      paramJSONObject = paramJSONObject.getString("keyword");
    } else {
      paramJSONObject = null;
    }
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      ArrayList localArrayList = new ArrayList();
      paramJSONObject = paramJSONObject.split(";");
      int i1 = 0;
      while (i1 < paramJSONObject.length)
      {
        CharSequence localCharSequence = paramJSONObject[i1];
        if ((!TextUtils.isEmpty(localCharSequence)) && (!TextUtils.isEmpty(localCharSequence.trim()))) {
          localArrayList.add(localCharSequence.trim().toLowerCase());
        }
        i1 += 1;
      }
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localArrayList.toArray(new String[localArrayList.size()]));
    }
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AioVipKeywordConfigHelper", 2, "updateKeywordJson");
    }
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      a(paramString1, paramString2);
      paramString2 = new StringBuilder();
      paramString2.append(paramContext.getFilesDir());
      paramString2.append(File.separator);
      paramString2.append("vipKerwordJson");
      FileUtils.writeFile(paramString2.toString(), paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString1);
        if (!localJSONObject.has("switch")) {
          break label343;
        }
        i1 = localJSONObject.getInt("switch");
        this.jdField_a_of_type_Int = i1;
        if (localJSONObject.has("openWording")) {
          paramString1 = localJSONObject.getString("openWording");
        } else {
          paramString1 = jdField_a_of_type_JavaLangString;
        }
        this.e = paramString1;
        if (localJSONObject.has("openHighlightWording")) {
          paramString1 = localJSONObject.getString("openHighlightWording");
        } else {
          paramString1 = c;
        }
        this.g = paramString1;
        if (localJSONObject.has("giftWording")) {
          paramString1 = localJSONObject.getString("giftWording");
        } else {
          paramString1 = jdField_b_of_type_JavaLangString;
        }
        this.f = paramString1;
        if (localJSONObject.has("giftHighlightWording")) {
          paramString1 = localJSONObject.getString("giftHighlightWording");
        } else {
          paramString1 = d;
        }
        this.h = paramString1;
        this.i = localJSONObject.optString("groupOpenWording", jdField_a_of_type_JavaLangString);
        this.j = localJSONObject.optString("groupOpenHighlightWording", c);
        this.k = localJSONObject.optString("groupGiftWording", jdField_b_of_type_JavaLangString);
        this.l = localJSONObject.optString("groupGiftHighlightWording", d);
        boolean bool = localJSONObject.has("giftUrl");
        Object localObject = null;
        if (!bool) {
          break label348;
        }
        paramString1 = localJSONObject.getString("giftUrl");
        this.m = paramString1;
        paramString1 = localObject;
        if (localJSONObject.has("openUrl")) {
          paramString1 = localJSONObject.getString("openUrl");
        }
        this.n = paramString1;
        a(paramString2, localJSONObject);
        b(localJSONObject);
        a(localJSONObject);
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        paramString2 = new StringBuilder();
        paramString2.append("parseKeyword : json error ");
        paramString2.append(paramString1);
        QLog.d("AioVipKeywordConfigHelper", 1, paramString2.toString());
      }
      return;
      label343:
      int i1 = 0;
      continue;
      label348:
      paramString1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.helper.AioVipKeywordConfigHelper
 * JD-Core Version:    0.7.0.1
 */