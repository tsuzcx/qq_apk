package com.tencent.mobileqq.qqgamepub.config;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QQGameConfBean
{
  public int a;
  public int b;
  public int c;
  public String d = "";
  public String e = "";
  public boolean f = true;
  public boolean g = false;
  public int h = 0;
  public int i = 0;
  public int j;
  public int k = 168;
  
  public static QQGameConfBean a()
  {
    return (QQGameConfBean)QConfigManager.b().b(441);
  }
  
  public static QQGameConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    localQQGameConfBean = new QQGameConfBean();
    int m = 0;
    try
    {
      Object localObject;
      while (m < paramArrayOfQConfItem.length)
      {
        localObject = new JSONObject(paramArrayOfQConfItem[m].b);
        a(localQQGameConfBean, (JSONObject)localObject);
        b(localQQGameConfBean, (JSONObject)localObject);
        m += 1;
      }
      return localQQGameConfBean;
    }
    catch (Throwable paramArrayOfQConfItem)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QQGameConfBean parse error e=");
      ((StringBuilder)localObject).append(paramArrayOfQConfItem.toString());
      QLog.e("QQGameConfBean", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private static void a(QQGameConfBean paramQQGameConfBean, JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder;
    if (paramJSONObject.has("pubaccountSwitch"))
    {
      paramQQGameConfBean.a = paramJSONObject.optInt("pubaccountSwitch");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed swtich=");
        localStringBuilder.append(paramQQGameConfBean.a);
        QLog.d("QQGameConfBean", 2, localStringBuilder.toString());
      }
    }
    if (paramJSONObject.has("fullPopIntervalDay"))
    {
      paramQQGameConfBean.b = paramJSONObject.optInt("fullPopIntervalDay");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed fullPopIntervalDay=");
        localStringBuilder.append(paramQQGameConfBean.b);
        QLog.d("QQGameConfBean", 2, localStringBuilder.toString());
      }
    }
    if (paramJSONObject.has("isFeedByWeb"))
    {
      paramQQGameConfBean.c = paramJSONObject.optInt("isFeedByWeb");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed isFeedByWeb=");
        localStringBuilder.append(paramQQGameConfBean.c);
        QLog.d("QQGameConfBean", 2, localStringBuilder.toString());
      }
    }
    if (paramJSONObject.has("gamePubUrl"))
    {
      paramQQGameConfBean.e = paramJSONObject.optString("gamePubUrl");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed gamePubUlr=");
        localStringBuilder.append(paramQQGameConfBean.d);
        QLog.d("QQGameConfBean", 2, localStringBuilder.toString());
      }
    }
    if (paramJSONObject.has("feedUrl"))
    {
      paramQQGameConfBean.d = paramJSONObject.optString("feedUrl");
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("onParsed feedUrl=");
        paramJSONObject.append(paramQQGameConfBean.d);
        QLog.d("QQGameConfBean", 2, paramJSONObject.toString());
      }
    }
  }
  
  private static void b(QQGameConfBean paramQQGameConfBean, JSONObject paramJSONObject)
  {
    boolean bool1 = paramJSONObject.has("hippySwitch");
    boolean bool2 = true;
    StringBuilder localStringBuilder;
    if (bool1)
    {
      if (paramJSONObject.optInt("hippySwitch", 0) == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramQQGameConfBean.f = bool1;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed hippySwitch=");
        localStringBuilder.append(paramQQGameConfBean.f);
        QLog.d("QQGameConfBean", 2, localStringBuilder.toString());
      }
    }
    if (paramJSONObject.has("hippySoDownload"))
    {
      if (paramJSONObject.optInt("hippySoDownload", 0) == 1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      paramQQGameConfBean.g = bool1;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed hippySoDownload=");
        localStringBuilder.append(paramQQGameConfBean.g);
        QLog.d("QQGameConfBean", 2, localStringBuilder.toString());
      }
    }
    if (paramJSONObject.has("hippyJsPluginType"))
    {
      paramQQGameConfBean.h = paramJSONObject.optInt("hippyJsPluginType", 0);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed hippyJsPluginType=");
        localStringBuilder.append(paramQQGameConfBean.h);
        QLog.d("QQGameConfBean", 2, localStringBuilder.toString());
      }
    }
    if (paramJSONObject.has("gameCenterPreLoadType"))
    {
      paramQQGameConfBean.i = paramJSONObject.optInt("gameCenterPreLoadType", 0);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed gameCenterPreLoadType=");
        localStringBuilder.append(paramQQGameConfBean.i);
        QLog.d("QQGameConfBean", 2, localStringBuilder.toString());
      }
    }
    if (paramJSONObject.has("publicAccountSessionConfig"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("publicAccountSessionConfig");
      if (paramJSONObject != null)
      {
        paramQQGameConfBean.j = paramJSONObject.optInt("style");
        paramQQGameConfBean.k = paramJSONObject.optInt("unUsedTime", 168);
      }
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("onParsed publicAccountSessionConfig, sessionStyle=");
        paramJSONObject.append(paramQQGameConfBean.j);
        paramJSONObject.append(", sessionUnUsedTime=");
        paramJSONObject.append(paramQQGameConfBean.k);
        QLog.d("QQGameConfBean", 2, paramJSONObject.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.config.QQGameConfBean
 * JD-Core Version:    0.7.0.1
 */