package com.tencent.mobileqq.newfriend.config;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class NewFriendContactGuideConfBean
{
  private static final String a;
  private static final String b;
  private static final String c;
  private static final String d;
  private static final String e;
  private static final String f;
  private static final String g = HardCodeUtil.a(2131694805);
  private static final String h = HardCodeUtil.a(2131694802);
  private static final String i = HardCodeUtil.a(2131694810);
  private static final String j = HardCodeUtil.a(2131694807);
  private static final String k = HardCodeUtil.a(2131694799);
  private static final String l = HardCodeUtil.a(2131694798);
  private static final String m = HardCodeUtil.a(2131694812);
  private static final String n = HardCodeUtil.a(2131694811);
  public int a;
  public final NewFriendContactGuideConfBean.UIElement a;
  public boolean a;
  public final NewFriendContactGuideConfBean.UIElement b;
  public final NewFriendContactGuideConfBean.UIElement c;
  public final NewFriendContactGuideConfBean.UIElement d;
  public final NewFriendContactGuideConfBean.UIElement e;
  public final NewFriendContactGuideConfBean.UIElement f;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131694804);
    jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131694803);
    jdField_c_of_type_JavaLangString = HardCodeUtil.a(2131694801);
    jdField_d_of_type_JavaLangString = HardCodeUtil.a(2131694809);
    jdField_e_of_type_JavaLangString = HardCodeUtil.a(2131694808);
    jdField_f_of_type_JavaLangString = HardCodeUtil.a(2131694806);
  }
  
  public NewFriendContactGuideConfBean()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_ComTencentMobileqqNewfriendConfigNewFriendContactGuideConfBean$UIElement = new NewFriendContactGuideConfBean.UIElement(jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
    this.jdField_b_of_type_ComTencentMobileqqNewfriendConfigNewFriendContactGuideConfBean$UIElement = new NewFriendContactGuideConfBean.UIElement(jdField_d_of_type_JavaLangString, jdField_e_of_type_JavaLangString, jdField_f_of_type_JavaLangString);
    this.jdField_c_of_type_ComTencentMobileqqNewfriendConfigNewFriendContactGuideConfBean$UIElement = new NewFriendContactGuideConfBean.UIElement(g, "", h);
    this.jdField_d_of_type_ComTencentMobileqqNewfriendConfigNewFriendContactGuideConfBean$UIElement = new NewFriendContactGuideConfBean.UIElement(i, "", j);
    this.jdField_e_of_type_ComTencentMobileqqNewfriendConfigNewFriendContactGuideConfBean$UIElement = new NewFriendContactGuideConfBean.UIElement(k, "", l);
    this.jdField_f_of_type_ComTencentMobileqqNewfriendConfigNewFriendContactGuideConfBean$UIElement = new NewFriendContactGuideConfBean.UIElement(m, "", n);
  }
  
  public static NewFriendContactGuideConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    NewFriendContactGuideConfBean localNewFriendContactGuideConfBean = new NewFriendContactGuideConfBean();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      int i2 = paramArrayOfQConfItem.length;
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject = paramArrayOfQConfItem[i1];
        if (localObject != null)
        {
          localObject = ((QConfItem)localObject).jdField_a_of_type_JavaLangString;
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject);
            localNewFriendContactGuideConfBean.jdField_a_of_type_Boolean = localJSONObject.optBoolean("newFriendContactsBannerEnable", false);
            localNewFriendContactGuideConfBean.jdField_a_of_type_Int = localJSONObject.optInt("totalCount", 0);
            a(localNewFriendContactGuideConfBean.jdField_a_of_type_ComTencentMobileqqNewfriendConfigNewFriendContactGuideConfBean$UIElement, localJSONObject.optJSONObject("unauthorized"), jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
            a(localNewFriendContactGuideConfBean.jdField_b_of_type_ComTencentMobileqqNewfriendConfigNewFriendContactGuideConfBean$UIElement, localJSONObject.optJSONObject("unbound"), jdField_d_of_type_JavaLangString, jdField_e_of_type_JavaLangString, jdField_c_of_type_JavaLangString);
            a(localNewFriendContactGuideConfBean.jdField_c_of_type_ComTencentMobileqqNewfriendConfigNewFriendContactGuideConfBean$UIElement, localJSONObject.optJSONObject("contactsListUnauthorized"), g, "", h);
            a(localNewFriendContactGuideConfBean.jdField_d_of_type_ComTencentMobileqqNewfriendConfigNewFriendContactGuideConfBean$UIElement, localJSONObject.optJSONObject("contactsListUnbinding"), i, "", j);
            a(localNewFriendContactGuideConfBean.jdField_e_of_type_ComTencentMobileqqNewfriendConfigNewFriendContactGuideConfBean$UIElement, localJSONObject.optJSONObject("contactsListInactive"), k, "", l);
            a(localNewFriendContactGuideConfBean.jdField_f_of_type_ComTencentMobileqqNewfriendConfigNewFriendContactGuideConfBean$UIElement, localJSONObject.optJSONObject("contactsListUnmatched"), m, "", n);
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("parse: ");
            localStringBuilder.append((String)localObject);
            QLog.i("NewFriendContactGuideConfBean", 2, localStringBuilder.toString());
          }
        }
        i1 += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfQConfItem = new StringBuilder();
      paramArrayOfQConfItem.append("parse: ");
      paramArrayOfQConfItem.append(localNewFriendContactGuideConfBean);
      QLog.i("NewFriendContactGuideConfBean", 2, paramArrayOfQConfItem.toString());
    }
    return localNewFriendContactGuideConfBean;
  }
  
  private static void a(NewFriendContactGuideConfBean.UIElement paramUIElement, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    if (paramUIElement == null) {
      return;
    }
    if (paramJSONObject != null)
    {
      paramUIElement.jdField_a_of_type_JavaLangString = paramJSONObject.optString("title", paramString1);
      paramUIElement.jdField_b_of_type_JavaLangString = paramJSONObject.optString("subTitle", paramString2);
      paramUIElement.jdField_c_of_type_JavaLangString = paramJSONObject.optString("buttonTitle", paramString3);
      return;
    }
    paramUIElement.jdField_a_of_type_JavaLangString = paramString1;
    paramUIElement.jdField_b_of_type_JavaLangString = paramString2;
    paramUIElement.jdField_c_of_type_JavaLangString = paramString3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NewFriendContactGuideConfBean(");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqNewfriendConfigNewFriendContactGuideConfBean$UIElement);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqNewfriendConfigNewFriendContactGuideConfBean$UIElement);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.jdField_c_of_type_ComTencentMobileqqNewfriendConfigNewFriendContactGuideConfBean$UIElement);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.jdField_d_of_type_ComTencentMobileqqNewfriendConfigNewFriendContactGuideConfBean$UIElement);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.jdField_e_of_type_ComTencentMobileqqNewfriendConfigNewFriendContactGuideConfBean$UIElement);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.jdField_f_of_type_ComTencentMobileqqNewfriendConfigNewFriendContactGuideConfBean$UIElement);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.config.NewFriendContactGuideConfBean
 * JD-Core Version:    0.7.0.1
 */