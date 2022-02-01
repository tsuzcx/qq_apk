package com.tencent.mobileqq.extendfriend.limitchat;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class limitChatOnPlusConfBean
{
  private int a;
  private int b = 0;
  
  public limitChatOnPlusConfBean()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public static limitChatOnPlusConfBean a(QConfItem paramQConfItem)
  {
    limitChatOnPlusConfBean locallimitChatOnPlusConfBean = new limitChatOnPlusConfBean();
    if (paramQConfItem != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("limitChatOnPlusConfBean", 2, "parse taskid->" + paramQConfItem.jdField_a_of_type_Int + " content->" + paramQConfItem.jdField_a_of_type_JavaLangString);
      }
      try
      {
        paramQConfItem = paramQConfItem.jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(paramQConfItem))
        {
          paramQConfItem = new JSONObject(paramQConfItem);
          locallimitChatOnPlusConfBean.a(paramQConfItem.optInt("business_switch", 0));
          locallimitChatOnPlusConfBean.b(paramQConfItem.optInt("showInRecentView", 0));
          return locallimitChatOnPlusConfBean;
        }
        if (QLog.isColorLevel())
        {
          QLog.e("limitChatOnPlusConfBean", 2, "parse content is null ");
          return locallimitChatOnPlusConfBean;
        }
      }
      catch (JSONException paramQConfItem)
      {
        if (QLog.isColorLevel()) {
          QLog.d("limitChatOnPlusConfBean", 2, "parse error->" + paramQConfItem.toString());
        }
      }
    }
    return locallimitChatOnPlusConfBean;
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
  
  public String toString()
  {
    return String.format("mBusinessSwitch:%d mShowInRecent:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.limitChatOnPlusConfBean
 * JD-Core Version:    0.7.0.1
 */