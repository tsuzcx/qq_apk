package com.tencent.mobileqq.qqexpand.manager.config;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class limitChatOnPlusConfBean
{
  private int a = 0;
  private int b = 0;
  
  public static limitChatOnPlusConfBean a(QConfItem paramQConfItem)
  {
    limitChatOnPlusConfBean locallimitChatOnPlusConfBean = new limitChatOnPlusConfBean();
    if (paramQConfItem != null)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parse taskid->");
        localStringBuilder.append(paramQConfItem.a);
        localStringBuilder.append(" content->");
        localStringBuilder.append(paramQConfItem.b);
        QLog.d("limitChatOnPlusConfBean", 2, localStringBuilder.toString());
      }
      try
      {
        paramQConfItem = paramQConfItem.b;
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
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("parse error->");
          localStringBuilder.append(paramQConfItem.toString());
          QLog.d("limitChatOnPlusConfBean", 2, localStringBuilder.toString());
        }
      }
    }
    return locallimitChatOnPlusConfBean;
  }
  
  void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public boolean a()
  {
    return this.a == 1;
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
    return String.format("mBusinessSwitch:%d mShowInRecent:%d", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.config.limitChatOnPlusConfBean
 * JD-Core Version:    0.7.0.1
 */