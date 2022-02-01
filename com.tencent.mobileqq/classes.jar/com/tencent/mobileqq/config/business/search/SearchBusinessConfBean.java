package com.tencent.mobileqq.config.business.search;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class SearchBusinessConfBean
{
  private int a;
  private int b = 1;
  private int c = 1;
  
  public SearchBusinessConfBean()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static SearchBusinessConfBean a(QConfItem paramQConfItem)
  {
    SearchBusinessConfBean localSearchBusinessConfBean = new SearchBusinessConfBean();
    if (paramQConfItem != null)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parse taskid->");
        localStringBuilder.append(paramQConfItem.jdField_a_of_type_Int);
        localStringBuilder.append(" content->");
        localStringBuilder.append(paramQConfItem.jdField_a_of_type_JavaLangString);
        QLog.d("SearchBusinessConfBean", 2, localStringBuilder.toString());
      }
      try
      {
        paramQConfItem = new JSONObject(paramQConfItem.jdField_a_of_type_JavaLangString);
        localSearchBusinessConfBean.a(paramQConfItem.optInt("business_switch_message", 1));
        localSearchBusinessConfBean.b(paramQConfItem.optInt("business_switch_contact", 1));
        localSearchBusinessConfBean.c(paramQConfItem.optInt("business_switch_dongtai", 1));
        return localSearchBusinessConfBean;
      }
      catch (Exception paramQConfItem)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("parse error->");
          localStringBuilder.append(paramQConfItem.toString());
          QLog.d("SearchBusinessConfBean", 2, localStringBuilder.toString());
        }
      }
    }
    return localSearchBusinessConfBean;
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public boolean b()
  {
    return this.b == 1;
  }
  
  void c(int paramInt)
  {
    this.c = paramInt;
  }
  
  public boolean c()
  {
    return this.c == 1;
  }
  
  public String toString()
  {
    return String.format("mBusinessSwitchTabMessage:%d, mBusinessSwitchTabContact:%d, mBusinessSwitchTabDongtai:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), Integer.valueOf(this.c) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.search.SearchBusinessConfBean
 * JD-Core Version:    0.7.0.1
 */