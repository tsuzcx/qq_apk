package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import org.json.JSONObject;

public class QConfPushBean
{
  private boolean a;
  private int b;
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  
  public static QConfPushBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        QConfPushBean localQConfPushBean = new QConfPushBean();
        paramString = new JSONObject(paramString);
        int i = paramString.optInt("enable", 0);
        bool = true;
        if (i == 1)
        {
          localQConfPushBean.a = bool;
          localQConfPushBean.b = paramString.optInt("showCount", 0);
          localQConfPushBean.c = paramString.optString("c2cTipsContent", "");
          localQConfPushBean.d = paramString.optString("c2cHighlightContent", "");
          localQConfPushBean.e = paramString.optString("groupTipsContent", "");
          localQConfPushBean.f = paramString.optString("groupHighlightContent", "");
          return localQConfPushBean;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      boolean bool = false;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public String c()
  {
    if (TextUtils.isEmpty(this.c)) {
      return "想及时收到对方的回复，快去打开消息推送设置吧。";
    }
    return this.c;
  }
  
  public String d()
  {
    if (TextUtils.isEmpty(this.d)) {
      return "打开消息推送";
    }
    return this.d;
  }
  
  public String e()
  {
    if (TextUtils.isEmpty(this.e)) {
      return "想及时收到对方的回复，快去打开消息推送设置吧。";
    }
    return this.e;
  }
  
  public String f()
  {
    if (TextUtils.isEmpty(this.f)) {
      return "打开消息推送";
    }
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QConfPushBean
 * JD-Core Version:    0.7.0.1
 */