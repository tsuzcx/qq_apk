package com.tencent.mobileqq.config.business.search;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class SearchHotWordConfBean
{
  private int a;
  private int b = 0;
  private int c = 1;
  
  public SearchHotWordConfBean()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public static SearchHotWordConfBean a(QConfItem paramQConfItem)
  {
    SearchHotWordConfBean localSearchHotWordConfBean = new SearchHotWordConfBean();
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
        QLog.d("SearchHotWordConfBean", 2, localStringBuilder.toString());
      }
      try
      {
        paramQConfItem = new JSONObject(paramQConfItem.jdField_a_of_type_JavaLangString);
        localSearchHotWordConfBean.a(paramQConfItem.optInt("hotword_switch_message", 0));
        localSearchHotWordConfBean.b(paramQConfItem.optInt("hotword_switch_contact", 0));
        localSearchHotWordConfBean.c(paramQConfItem.optInt("hotword_switch_dongtai", 1));
        return localSearchHotWordConfBean;
      }
      catch (Exception paramQConfItem)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("parse error->");
          localStringBuilder.append(paramQConfItem.toString());
          QLog.d("SearchHotWordConfBean", 2, localStringBuilder.toString());
        }
      }
    }
    return localSearchHotWordConfBean;
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
    return String.format("mHotWordSwitchTabMessage:%d, mHotWordSwitchTabContact:%d, mHotWordSwitchTabDongtai:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), Integer.valueOf(this.c) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.search.SearchHotWordConfBean
 * JD-Core Version:    0.7.0.1
 */